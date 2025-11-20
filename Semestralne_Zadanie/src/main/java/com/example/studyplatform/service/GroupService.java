package com.example.studyplatform.service;

import com.example.studyplatform.model.ActivityLog;
import com.example.studyplatform.model.Group;
import com.example.studyplatform.model.Membership;
import com.example.studyplatform.model.NotificationMessage;
import com.example.studyplatform.model.User;
import com.example.studyplatform.repository.ActivityLogRepository;
import com.example.studyplatform.repository.GroupRepository;
import com.example.studyplatform.repository.MembershipRepository;
import com.example.studyplatform.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GroupService {

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private MembershipRepository membershipRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Autowired
    private ActivityLogRepository activityLogRepository;

    // Создать новую группу
    @Transactional
    public Group createGroup(String name, String description, String username) {
        User creator = userRepository.findByUsername(username);
        
        Group group = new Group();
        group.setName(name);
        group.setDescription(description);
        group.setCreatedBy(creator);
        
        Group savedGroup = groupRepository.save(group);

        // Создатель автоматически становится админом
        Membership membership = new Membership();
        membership.setGroup(savedGroup);
        membership.setUser(creator);
        membership.setRole("ADMIN");
        membershipRepository.save(membership);

        // Логируем создание
        activityLogRepository.save(new ActivityLog(creator, savedGroup, "GROUP_CREATED", "Created group " + name));

        return savedGroup;
    }

    // Получить все группы
    public List<Group> getAllGroups() {
        return groupRepository.findAll();
    }

    // Получить одну группу
    public Group getGroup(Long id) {
        return groupRepository.findById(id).orElseThrow(() -> new RuntimeException("Group not found"));
    }

    // Добавить участника
    public void addMember(Long groupId, Long userId) {
        Group group = groupRepository.findById(groupId).orElseThrow();
        User user = userRepository.findById(userId).orElseThrow();

        // Проверяем, не добавлен ли уже
        if (membershipRepository.findByUser_IdAndGroup_Id(userId, groupId) != null) {
            throw new RuntimeException("User already in group");
        }

        Membership membership = new Membership();
        membership.setGroup(group);
        membership.setUser(user);
        membership.setRole("MEMBER");
        membershipRepository.save(membership);

        // Логируем добавление
        activityLogRepository.save(new ActivityLog(user, group, "JOINED_GROUP", "User joined group"));

        // Уведомляем группу о новом участнике
        messagingTemplate.convertAndSend("/topic/groups/" + groupId, 
            new NotificationMessage("NEW_MEMBER", "User " + user.getUsername() + " joined the group", groupId));
    }
}
