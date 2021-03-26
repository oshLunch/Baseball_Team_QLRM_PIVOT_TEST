package com.cos.baseball.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.qlrm.mapper.JpaResultMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.baseball.domain.player.Player;
import com.cos.baseball.domain.player.PlayerRepository;
import com.cos.baseball.domain.team.Team;
import com.cos.baseball.domain.team.TeamRepository;
import com.cos.baseball.web.dto.player.PlayerInsertReqDto;
import com.cos.baseball.web.dto.player.PlayerPositionDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PlayerService {
	
	private final PlayerRepository playerRepository;
	private final TeamRepository teamRepository;
	private final EntityManager em;
	
	@Transactional
	public int 선수등록(PlayerInsertReqDto playerInsertReqDto) {
		
		Team teamEntity = teamRepository.findByTeamName(playerInsertReqDto.getTeamName());
		
		if(teamEntity==null) {
			return -1;
		} else {
			Player player = Player.builder()
					.name(playerInsertReqDto.getName())
					.position(playerInsertReqDto.getPosition())
					.team(teamEntity)
					.build();
			
			playerRepository.save(player);
			
			return 1;
		}
	}
	
	public List<Player> 전체찾기() {
		return playerRepository.findAll();
	}
	
	@Transactional
	public void 삭제하기(int id) {
		playerRepository.deleteById(id);
	}
	
	@Transactional(readOnly = true)
	public List<PlayerPositionDto> 포지션별선수() {
		StringBuffer sb = new StringBuffer();
		sb.append("select p.position as 'position', ");
		sb.append("GROUP_CONCAT(case when t.teamName = '롯데 자이언츠' THEN p.name ELSE null END) as 'lotte', ");
		sb.append("GROUP_CONCAT(case when t.teamName = '삼성 라이온즈' THEN p.name ELSE null END) as 'samsung',");		
		sb.append("GROUP_CONCAT(case when t.teamName = '기아 타이거즈' THEN p.name ELSE null END) as 'kia' ");
		sb.append("from player p inner join team t on p.teamId = t.id GROUP BY p.position;");
		String pivot = sb.toString();
		
		JpaResultMapper jpaResultMapper = new JpaResultMapper();
		Query query = em.createNativeQuery(pivot);
		
		List<PlayerPositionDto> dto = jpaResultMapper.list(query, PlayerPositionDto.class);
		
		System.out.println("PlayerPositionDto: "+dto);
		
		return dto;
	}
}
