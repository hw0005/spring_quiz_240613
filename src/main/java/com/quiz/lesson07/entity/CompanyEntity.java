package com.quiz.lesson07.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor // 모든 파라미터 있는 생성자
@NoArgsConstructor // 파라미터 없는 생성자
@Builder(toBuilder = true)
@Getter
@Table(name = "company")
@Entity
public class CompanyEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private String business;
	
	private String scale;
	
	private int headcount;
	
	@CreationTimestamp
	@Column(name = "createdAt")
	private LocalDateTime createdAt;
	
	@UpdateTimestamp
	@Column(name = "updatedAt")
	private LocalDateTime updatedAt;
}