package com.example.studyplatform.controller;

import com.example.studyplatform.model.ActivityLog;
import com.example.studyplatform.model.Task;
import com.example.studyplatform.repository.ActivityLogRepository;
import com.example.studyplatform.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/stats")
public class StatsController {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private ActivityLogRepository activityLogRepository;

    // Статистика по группе: количество задач по статусам
    @GetMapping("/groups/{groupId}")
    public Map<String, Object> getGroupStats(@PathVariable Long groupId) {
        List<Task> tasks = taskRepository.findByGroup_Id(groupId);
        
        // Считаем задачи
        Map<String, Long> taskCounts = tasks.stream()
                .collect(Collectors.groupingBy(Task::getStatus, Collectors.counting()));

        // Получаем последние действия
        List<ActivityLog> recentActivity = activityLogRepository.findByGroup_IdOrderByTimestampDesc(groupId);

        Map<String, Object> response = new HashMap<>();
        response.put("taskCounts", taskCounts);
        response.put("recentActivity", recentActivity.stream().limit(10).collect(Collectors.toList())); // Только последние 10

        return response;
    }

    // Статистика по пользователю: его действия
    @GetMapping("/users/{userId}")
    public List<ActivityLog> getUserActivity(@PathVariable Long userId) {
        return activityLogRepository.findByUser_Id(userId);
    }
}
