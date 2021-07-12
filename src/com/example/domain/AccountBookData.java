package com.example.domain;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountBookData {
	private int num; // 입력번호
	private Timestamp time; // 입력시간
	private String inout;  // 수입 or 지출
	private String categories; // 카테고리
	private int amount; // 금액
	private String memo; // 메모
}
