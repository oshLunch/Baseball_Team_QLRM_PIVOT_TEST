package com.cos.baseball.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.baseball.domain.player.Player;
import com.cos.baseball.service.PlayerService;
import com.cos.baseball.util.Script;
import com.cos.baseball.web.dto.player.PlayerInsertReqDto;
import com.cos.baseball.web.dto.player.PlayerPositionDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class PlayerController {

	private final PlayerService playerService;
	
	
	@PostMapping("/player")
	public @ResponseBody String save(PlayerInsertReqDto playerInsertReqDto) {
		
		int result = playerService.선수등록(playerInsertReqDto);
				
		if(result == 1) {
			return Script.href("선수등록 성공", "/player");
		} else {
			return Script.href("등록되지 않은 팀입니다.", "/playerForm");
		}
				
		
	}
	
	@GetMapping("/playerForm")
	public String insert() {
		return "player/playerForm";
	}
	
	@GetMapping({"","/player"})
	public String findAll(Model model) {
		List<Player> players = playerService.전체찾기();
		model.addAttribute("players", players);
		
		return "player/playerList";
	}
	
	@DeleteMapping("/player/{id}")
	public @ResponseBody String delete(@PathVariable int id) {
		
		playerService.삭제하기(id);
		
		return "ok";
	}
	
	@GetMapping("/position")
	public String position(Model model) {
		
		List<PlayerPositionDto> dtos = playerService.포지션별선수();
		model.addAttribute("dtos", dtos);
		
		return "player/positionList";
	}
}
