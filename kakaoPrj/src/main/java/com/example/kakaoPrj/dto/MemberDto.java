package com.example.kakaoPrj.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberDto {

	private String mno;
	private String id;
	private String pw;
	private String name;
}
