package com.cos.baseball.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.baseball.domain.stadium.Stadium;
import com.cos.baseball.domain.stadium.StadiumRepository;
import com.cos.baseball.domain.team.Team;
import com.cos.baseball.domain.team.TeamRepository;
import com.cos.baseball.web.dto.stadium.StadiumInsertReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class StadiumService {

	private final StadiumRepository stadiumRepository;
	private final TeamRepository teamRepository;

	@Transactional
	public int 야구장등록(StadiumInsertReqDto stadiumInsertReqDto) {

		Team teamEntity = teamRepository.findByTeamName(stadiumInsertReqDto.getTeamName());
		Stadium stadiumEntity = stadiumRepository.findByTeamName(stadiumInsertReqDto.getStadiumName());

		if (teamEntity == null) {
			return -1;
		} else if(stadiumEntity == null){
			Stadium stadium = Stadium.builder()
					.stadiumName(stadiumInsertReqDto.getStadiumName())
					.team(teamEntity)
					.build();

			stadiumRepository.save(stadium);
			return 1;
		}else {
			return -2;
		}
	}

	public List<Stadium> 전체찾기() {
		return stadiumRepository.findAll();
	}
	
	@Transactional
	public void 삭제하기(int id) {
		stadiumRepository.deleteById(id);
	}

}
