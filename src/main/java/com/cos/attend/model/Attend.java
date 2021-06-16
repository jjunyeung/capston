package com.cos.attend.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity 
public class Attend {
	
	@Id //Primary key
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id; 
	
	@ColumnDefault("'attend'") //attend, absent, tardy
	private String attendance;
	
	@CreationTimestamp //출결 시간 확인용
	private Timestamp Attendtime;
}
