package com.example.studyplatform.service;

import com.example.studyplatform.model.Group;
import com.example.studyplatform.model.Task;
import com.example.studyplatform.model.User;
import com.example.studyplatform.repository.ActivityLogRepository;
import com.example.studyplatform.repository.GroupRepository;
import com.example.studyplatform.repository.TaskRepository;
import com.example.studyplatform.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TaskServiceTest {

    @Mock
    private TaskRepository taskRepository;

    @Mock
    private GroupRepository groupRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private ActivityLogRepository activityLogRepository;

    @Mock
    private SimpMessagingTemplate messagingTemplate;

    @InjectMocks
    private TaskService taskService;

    @Test
    public void createTask_ShouldReturnSavedTask() {
        // Arrange
        String username = "testuser";
        Long groupId = 1L;
        String title = "New Task";
        String description = "Description";
        String deadline = "2025-12-31T23:59:00";

        User user = new User();
        user.setUsername(username);

        Group group = new Group();
        group.setId(groupId);

        when(userRepository.findByUsername(username)).thenReturn(user);
        when(groupRepository.findById(groupId)).thenReturn(Optional.of(group));
        when(taskRepository.save(any(Task.class))).thenAnswer(invocation -> {
            Task t = invocation.getArgument(0);
            t.setId(100L); // Simulate DB ID generation
            return t;
        });

        // Act
        Task createdTask = taskService.createTask(groupId, title, description, deadline, username);

        // Assert
        assertNotNull(createdTask);
        assertEquals(title, createdTask.getTitle());
        assertEquals("OPEN", createdTask.getStatus());
        assertEquals(LocalDateTime.parse(deadline), createdTask.getDeadline());
        assertEquals(user, createdTask.getCreatedBy());
        assertEquals(group, createdTask.getGroup());

        // Verify interactions
        verify(taskRepository).save(any(Task.class));
        verify(activityLogRepository).save(any());
        verify(messagingTemplate).convertAndSend(eq("/topic/groups/" + groupId), any(Object.class));
    }
}
