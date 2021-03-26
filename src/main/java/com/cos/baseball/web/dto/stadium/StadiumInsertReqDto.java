package com.cos.baseball.web.dto.stadium;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StadiumInsertReqDto {

	private String stadiumName;
	private String teamName;
}
