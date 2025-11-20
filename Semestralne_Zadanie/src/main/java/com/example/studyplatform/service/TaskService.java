package com.example.studyplatform.service;

import com.example.studyplatform.model.ActivityLog;
import com.example.studyplatform.model.Group;
import com.example.studyplatform.model.NotificationMessage;
import com.example.studyplatform.model.Task;
import com.example.studyplatform.model.User;
import com.example.studyplatform.repository.ActivityLogRepository;
import com.example.studyplatform.repository.GroupRepository;
import com.example.studyplatform.repository.TaskRepository;
import com.example.studyplatform.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Autowired
    private ActivityLogRepository activityLogRepository;

    // Создать задачу
    public Task createTask(Long groupId, String title, String description, String deadlineStr, String username) {
        Group group = groupRepository.findById(groupId)
                .orElseThrow(() -> new RuntimeException("Group not found"));
        User creator = userRepository.findByUsername(username);

        Task task = new Task();
        task.setTitle(title);
        task.setDescription(description);
        task.setStatus("OPEN"); // По умолчанию открыта
        task.setGroup(group);
        task.setCreatedBy(creator);
        
        if (deadlineStr != null && !deadlineStr.isEmpty()) {
            // Для простоты парсим стандартный ISO формат (2025-12-31T23:59:00)
            task.setDeadline(LocalDateTime.parse(deadlineStr));
        }

        Task savedTask = taskRepository.save(task);

        // Логируем
        activityLogRepository.save(new ActivityLog(creator, group, "TASK_CREATED", "Created task: " + title));

        // Уведомляем о новой задаче
        messagingTemplate.convertAndSend("/topic/groups/" + groupId, 
            new NotificationMessage("TASK_CREATED", "New task: " + title, groupId));

        return savedTask;
    }

    // Получить задачи группы
    public List<Task> getTasksByGroup(Long groupId) {
        return taskRepository.findByGroup_Id(groupId);
    }

    // Обновить статус задачи
    public Task updateStatus(Long taskId, String newStatus) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found"));
        
        task.setStatus(newStatus);
        Task savedTask = taskRepository.save(task);

        // Логируем
        activityLogRepository.save(new ActivityLog(task.getCreatedBy(), task.getGroup(), "TASK_STATUS_CHANGE", "Status changed to " + newStatus));

        // Уведомляем об изменении статуса
        messagingTemplate.convertAndSend("/topic/groups/" + task.getGroup().getId(), 
            new NotificationMessage("TASK_UPDATED", "Task '" + task.getTitle() + "' is now " + newStatus, task.getGroup().getId()));

        return savedTask;
    }
}
