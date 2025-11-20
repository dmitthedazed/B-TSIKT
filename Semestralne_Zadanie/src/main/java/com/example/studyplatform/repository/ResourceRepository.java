package com.example.studyplatform.repository;

import com.example.studyplatform.model.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ResourceRepository extends JpaRepository<Resource, Long> {
    List<Resource> findByGroup_Id(Long groupId);
}
