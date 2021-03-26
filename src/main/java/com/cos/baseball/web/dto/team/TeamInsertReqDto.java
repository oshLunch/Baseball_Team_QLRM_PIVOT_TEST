package com.cos.baseball.web.dto.team;

import com.cos.baseball.domain.team.Team;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeamInsertReqDto {
	
	private String teamName;
	
	public Team toEntity() {
		return Team.builder()
				.teamName(teamName)
				.build();
	}
}
