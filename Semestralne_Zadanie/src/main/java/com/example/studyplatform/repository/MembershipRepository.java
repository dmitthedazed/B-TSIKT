package com.example.studyplatform.repository;

import com.example.studyplatform.model.Membership;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MembershipRepository extends JpaRepository<Membership, Long> {
    List<Membership> findByUser_Id(Long userId);
    List<Membership> findByGroup_Id(Long groupId);
    Membership findByUser_IdAndGroup_Id(Long userId, Long groupId);
}
