package com.projects.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.projects.student.model.Member;
import com.projects.student.repository.MemberRepo;

@Component
public class MemberService {
	@Autowired
	MemberRepo memberRepo;
	
	public boolean checkMember(Long memberId, String memberPass) {
		boolean result= false;
		Optional<Member> member = memberRepo.findById(memberId);
		if(!member.isEmpty() && memberPass.equalsIgnoreCase(member.get().getMemberPass())) {
			result=true;
		}
		
		return result;
		
	}

}
