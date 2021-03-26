package com.cos.baseball.web.dto.player;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerInsertReqDto {

	private String name;
	private String position;
	private String teamName;
	
}
