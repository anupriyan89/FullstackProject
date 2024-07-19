package com.projects.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projects.student.model.Member;



public interface MemberRepo extends JpaRepository<Member, Long>{
	
	

}
