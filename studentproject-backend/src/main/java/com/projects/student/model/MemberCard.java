package com.projects.student.model;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;

@Entity
@Table(name="MemberCard")
public class MemberCard {
	
	public MemberCard() {
		
	}
	
	public MemberCard(long cardId, long memberId) {
		super();
		this.cardId = cardId;
		this.memberId = memberId;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="member_card_id")
	private long memberCardId;
	@Column(name="card_id")
	private long cardId;
	@Column(name="member_id")
	private long memberId;
	public long getCardId() {
		return cardId;
	}
	public void setCardId(long cardId) {
		this.cardId = cardId;
	}
	public long getMemberId() {
		return memberId;
	}
	public void setMemberId(long memberId) {
		this.memberId = memberId;
	}
	

	
}
