package com.cos.attend.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity // User 클래스가 MySQL에 테이블이 생성
@DynamicInsert
public class User {
	
	@Id //Primary key
	@GeneratedValue(strategy=GenerationType.IDENTITY)//프로젝트에서 연결된 DB의 넘버링 전략을 따라감
	private int id; //시퀀스, auto_increment
	
	@Column(nullable=false, length=30, unique=true)
	private String username; //아이디
	
	@Column(nullable=false, length=100)
	private String password;
	
	@Column(nullable=false, length=50)
	private String email;
	
	//@ColumnDefault("user");
	@Enumerated(EnumType.STRING)
	private RoleType role; //Enum을 쓰는게 좋음, 도메인(범위)을 만들수 있음

	
@CreationTimestamp //시간 자동 입력
private Timestamp createDate;
}
