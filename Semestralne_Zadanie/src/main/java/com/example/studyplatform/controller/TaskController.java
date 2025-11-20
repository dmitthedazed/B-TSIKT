package com.example.studyplatform.controller;

import com.example.studyplatform.model.Task;
import com.example.studyplatform.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class TaskController {

    @Autowired
    private TaskService taskService;

    // Получить задачи группы
    @GetMapping("/groups/{groupId}/tasks")
    public List<Task> getGroupTasks(@PathVariable Long groupId) {
        return taskService.getTasksByGroup(groupId);
    }

    // Создать задачу в группе
    @PostMapping("/groups/{groupId}/tasks")
    public Task createTask(@PathVariable Long groupId, 
                           @RequestBody Map<String, String> payload,
                           @AuthenticationPrincipal UserDetails userDetails) {
        return taskService.createTask(
            groupId,
            payload.get("title"),
            payload.get("description"),
            payload.get("deadline"), // Ожидаем строку в формате "2025-12-31T23:59:00"
            userDetails.getUsername()
        );
    }

    // Обновить статус задачи
    @PutMapping("/tasks/{taskId}/status")
    public Task updateTaskStatus(@PathVariable Long taskId, @RequestBody Map<String, String> payload) {
        return taskService.updateStatus(taskId, payload.get("status"));
    }
}
