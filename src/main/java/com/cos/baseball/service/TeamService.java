package com.cos.baseball.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.baseball.domain.team.Team;
import com.cos.baseball.domain.team.TeamRepository;
import com.cos.baseball.web.dto.team.TeamInsertReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class TeamService {
	
	private final TeamRepository teamRepository;
	
	@Transactional
	public int 팀등록(TeamInsertReqDto teamInsertReqDto) {
		Team teamEntity = teamRepository.findByTeamName(teamInsertReqDto.getTeamName());
		
		if(teamEntity == null) {
			teamRepository.save(teamInsertReqDto.toEntity());
			return 1;
		} else {
			return -1;
		}
		
		
	}
	
	public List<Team> 전체찾기() {
		return teamRepository.findAll();
	}
	
	@Transactional
	public void 삭제하기(int id) {
		teamRepository.deleteById(id);
	}
}
