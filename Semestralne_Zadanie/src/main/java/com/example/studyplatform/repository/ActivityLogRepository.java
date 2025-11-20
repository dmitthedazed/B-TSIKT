package com.example.studyplatform.repository;

import com.example.studyplatform.model.ActivityLog;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ActivityLogRepository extends JpaRepository<ActivityLog, Long> {
    List<ActivityLog> findByUser_Id(Long userId);
    List<ActivityLog> findByGroup_IdOrderByTimestampDesc(Long groupId);
}
