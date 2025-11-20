package com.example.studyplatform.repository;

import com.example.studyplatform.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface GroupRepository extends JpaRepository<Group, Long> {
    List<Group> findByCreatedBy_Id(Long userId);
}
