package com.example.studyplatform.controller;

import com.example.studyplatform.model.Group;
import com.example.studyplatform.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/groups")
public class GroupController {

    @Autowired
    private GroupService groupService;

    // Получить все группы
    @GetMapping
    public List<Group> getAllGroups() {
        return groupService.getAllGroups();
    }

    // Создать группу
    @PostMapping
    public Group createGroup(@RequestBody Map<String, String> payload, 
                             @AuthenticationPrincipal UserDetails userDetails) {
        return groupService.createGroup(
            payload.get("name"), 
            payload.get("description"), 
            userDetails.getUsername()
        );
    }

    // Получить конкретную группу
    @GetMapping("/{id}")
    public Group getGroup(@PathVariable Long id) {
        return groupService.getGroup(id);
    }

    // Добавить участника в группу
    @PostMapping("/{id}/members")
    public ResponseEntity<?> addMember(@PathVariable Long id, @RequestBody Map<String, Long> payload) {
        Long userId = payload.get("userId");
        groupService.addMember(id, userId);
        return ResponseEntity.ok("Member added");
    }
}
