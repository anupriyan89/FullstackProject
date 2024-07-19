package com.projects.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projects.student.model.MemberCard;

@Repository
public interface MemberCardRepo extends JpaRepository<MemberCard, Long>{

}
