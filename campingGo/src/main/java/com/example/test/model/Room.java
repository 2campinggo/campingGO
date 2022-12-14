package com.example.test.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Room {

	@Id
	private Long roomNum;  // 객실 호실
	
	private int roomCount;  // 최대인원수
	private String roomName;  // 객실이름
	private Long roomPrice;
	private String checkIn;
	private String checkOut;
	private String roomInfo;  // 객실정보
	
	@ManyToOne
	@JoinColumn(name = "camp_title")
	private Camping camping;  // 숙박업체 이름
	
	@OneToOne(mappedBy = "room")
	private Booking booking;
	
	@PrePersist
	public void prePerist() {
		this.roomPrice = this.roomPrice==null?0:this.roomPrice;
	}
}
