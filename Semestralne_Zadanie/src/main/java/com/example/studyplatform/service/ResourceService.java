package com.example.studyplatform.service;

import com.example.studyplatform.model.ActivityLog;
import com.example.studyplatform.model.Group;
import com.example.studyplatform.model.NotificationMessage;
import com.example.studyplatform.model.Resource;
import com.example.studyplatform.model.User;
import com.example.studyplatform.repository.ActivityLogRepository;
import com.example.studyplatform.repository.GroupRepository;
import com.example.studyplatform.repository.ResourceRepository;
import com.example.studyplatform.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

@Service
public class ResourceService {

    private final Path fileStorageLocation;

    @Autowired
    private ResourceRepository resourceRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Autowired
    private ActivityLogRepository activityLogRepository;

    public ResourceService() {
        // Папка для хранения файлов прямо в корне проекта
        this.fileStorageLocation = Paths.get("uploads").toAbsolutePath().normalize();
        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex) {
            throw new RuntimeException("Could not create the directory where the uploaded files will be stored.", ex);
        }
    }

    public Resource uploadFile(Long groupId, MultipartFile file, String username) {
        Group group = groupRepository.findById(groupId)
                .orElseThrow(() -> new RuntimeException("Group not found"));
        User uploader = userRepository.findByUsername(username);

        // Генерируем уникальное имя файла, чтобы не затереть существующие
        String originalFileName = file.getOriginalFilename();
        String fileName = UUID.randomUUID().toString() + "_" + originalFileName;

        try {
            // Сохраняем файл на диск
            Path targetLocation = this.fileStorageLocation.resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

            // Сохраняем инфу в базу
            Resource resource = new Resource();
            resource.setTitle(originalFileName);
            resource.setType(file.getContentType());
            resource.setPathOrUrl(targetLocation.toString());
            resource.setGroup(group);
            resource.setUploadedBy(uploader);

            Resource savedResource = resourceRepository.save(resource);

            // Логируем
            activityLogRepository.save(new ActivityLog(uploader, group, "FILE_UPLOADED", "Uploaded file: " + originalFileName));

            // Уведомляем о новом файле
            messagingTemplate.convertAndSend("/topic/groups/" + groupId, 
                new NotificationMessage("NEW_FILE", "New file uploaded: " + originalFileName, groupId));

            return savedResource;
        } catch (IOException ex) {
            throw new RuntimeException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }

    public List<Resource> getResourcesByGroup(Long groupId) {
        return resourceRepository.findByGroup_Id(groupId);
    }
    
    public Resource getResource(Long resourceId) {
        return resourceRepository.findById(resourceId)
                .orElseThrow(() -> new RuntimeException("Resource not found"));
    }
}
