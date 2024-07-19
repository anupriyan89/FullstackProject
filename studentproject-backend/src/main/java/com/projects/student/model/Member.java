package com.projects.student.model;

import java.util.Date;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="member")


public class Member {
	public Member() {
		
	}
	public Member(String memberName, String memberEmail, Date memberDOB, String memberPass) {
		super();
		this.memberName = memberName;
		this.memberEmail = memberEmail;
		this.memberDOB = memberDOB;
		this.memberPass = memberPass;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="member_id")
	private long memberId;
	@Column(name="member_name")
	private String memberName;
	@Column(name="member_email")
	private String memberEmail;
	@Column(name="memberDOB")
	private Date memberDOB;
	@Column(name="member_password")
	private String memberPass;
	
	
	public long getMemberId() {
		return memberId;
	}
	public void setMemberId(long memberId) {
		this.memberId = memberId;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	public Date getMemberDOB() {
		return memberDOB;
	}
	public void setMemberDOB(Date memberDOB) {
		this.memberDOB = memberDOB;
	}
	public String getMemberPass() {
		return memberPass;
	}
	public void setMemberPass(String memberPass) {
		this.memberPass = memberPass;
	}
	

}
