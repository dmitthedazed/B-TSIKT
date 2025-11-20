package com.example.studyplatform.model;

public class NotificationMessage {
    private String type; // "TASK_CREATED", "NEW_FILE", "NEW_MEMBER"
    private String content;
    private Long groupId;

    public NotificationMessage(String type, String content, Long groupId) {
        this.type = type;
        this.content = content;
        this.groupId = groupId;
    }

    public String getType() { return type; }
    public String getContent() { return content; }
    public Long getGroupId() { return groupId; }
}
