package com.example.test.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Getter;
import lombok.Setter;


@Getter @Setter
@Entity
public class Review {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="review_num")
	private Long reviewNum;
	
	@ManyToOne
	@JoinColumn(name="member_id")
	private Member member;
	
	private String content;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="review_date")
	private Date reviewDate;
	
	private Long score;  // 별점
	
	@ManyToOne
	@JoinColumn(name="camping_name")
	private Camping camping;
	
	@PrePersist
	public void prePerist() {
		this.score = this.score==null?0:this.score;
	}

}
