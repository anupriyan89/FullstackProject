package com.projects.student.model;

import java.util.Date;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;

@Entity
@Table(name="card")
public class Card {
	
	public Card(String cardName, String cardType, Date expireDate) {
		super();
		this.cardName = cardName;
		this.cardType = cardType;
		this.expireDate = expireDate;
	}
	public Card() {
		
	}
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="card_id")
	private long cardId;
	@Column(name="card_name")
	private String cardName;
	@Column(name="card_type")
	private String cardType;
	@Column(name="expire_date")
	private Date expireDate;
	
	
	
	public long getCardId() {
		return cardId;
	}
	public void setCardId(long cardId) {
		this.cardId = cardId;
	}
	public String getCardName() {
		return cardName;
	}
	public void setCardName(String cardName) {
		this.cardName = cardName;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public Date getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}
	
	
	

}
