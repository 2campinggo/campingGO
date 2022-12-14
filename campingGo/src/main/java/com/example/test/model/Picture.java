package com.example.test.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Picture {

	@Id
	private Long picNum;  // 사진 식별 번호
	
	private String picName;  // 사진명
	@Transient  // 컬럼에서 제외됨
	private MultipartFile upload;  // 업로드할 파일
}
