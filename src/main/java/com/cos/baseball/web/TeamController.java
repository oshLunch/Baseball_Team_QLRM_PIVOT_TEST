package com.cos.baseball.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.baseball.domain.team.Team;
import com.cos.baseball.service.TeamService;
import com.cos.baseball.util.Script;
import com.cos.baseball.web.dto.team.TeamInsertReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class TeamController {
	
	private final TeamService teamService;

	// 시작 주소 : /team
	@PostMapping("/team")
	public @ResponseBody String save(TeamInsertReqDto teamInsertReqDto) {
		
		int result = teamService.팀등록(teamInsertReqDto);
		
		if(result == 1) {
			return Script.href("팀 등록에 성공하였습니다.", "/team");
		} else {
			return Script.href("존재하는 팀입니다.", "/teamForm");
		}
	}
	
	@GetMapping("/teamForm")
	public String teamForm() {
		return "team/teamForm";
	}
	
	@GetMapping("/team")
	public String findAll(Model model) {
		
		List<Team> teams = teamService.전체찾기();
		model.addAttribute("teams", teams);
		
		return "team/teamList";
	}
	
	@DeleteMapping("/team/{id}")
	public @ResponseBody String delete(@PathVariable int id) {
		
		teamService.삭제하기(id);
		
		return "ok";
	}
}
