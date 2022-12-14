package com.example.test.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Camping {
	@Id 
	private String campTitle;
	private String campTel;
	private String master; // 대표자 이름
	private String address;
	private Long campId;  // 카테코리 코드
	private String campEmail;
	
	@OneToMany(mappedBy = "camping")
	private List<Review> review;
	
	@OneToMany(mappedBy = "camping")
	private List<Room> room;
	
	@OneToOne(mappedBy = "campTitle")
	private Wishlist wishList;
	
	@PrePersist
	public void prePerist() {
		this.campId = this.campId==null?0:this.campId;
	}

}
