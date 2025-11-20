package com.example.studyplatform.controller;

import com.example.studyplatform.model.Resource;
import com.example.studyplatform.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    // Загрузить файл в группу
    @PostMapping("/groups/{groupId}/resources")
    public Resource uploadFile(@PathVariable Long groupId,
                               @RequestParam("file") MultipartFile file,
                               @AuthenticationPrincipal UserDetails userDetails) {
        return resourceService.uploadFile(groupId, file, userDetails.getUsername());
    }

    // Список файлов группы
    @GetMapping("/groups/{groupId}/resources")
    public List<Resource> getGroupResources(@PathVariable Long groupId) {
        return resourceService.getResourcesByGroup(groupId);
    }

    // Скачать файл
    @GetMapping("/resources/{id}/download")
    public ResponseEntity<org.springframework.core.io.Resource> downloadFile(@PathVariable Long id) {
        Resource resourceEntity = resourceService.getResource(id);
        try {
            Path filePath = Paths.get(resourceEntity.getPathOrUrl());
            org.springframework.core.io.Resource resource = new UrlResource(filePath.toUri());

            if(resource.exists()) {
                return ResponseEntity.ok()
                        .contentType(MediaType.parseMediaType(resourceEntity.getType()))
                        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resourceEntity.getTitle() + "\"")
                        .body(resource);
            } else {
                throw new RuntimeException("File not found " + resourceEntity.getTitle());
            }
        } catch (MalformedURLException ex) {
            throw new RuntimeException("File not found " + resourceEntity.getTitle(), ex);
        }
    }
}
