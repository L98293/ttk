package com.dgsw.ttk.ttk.domain.post.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@SuperBuilder
@NoArgsConstructor
@Getter
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;

	private String studentId; // 학번

	private String studentName; // 학생 이름

	private String issue; // 신청 사유

	private Status status; // 승인 여부
}
