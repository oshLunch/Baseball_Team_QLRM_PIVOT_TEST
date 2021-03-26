package com.cos.baseball.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.baseball.domain.stadium.Stadium;
import com.cos.baseball.service.StadiumService;
import com.cos.baseball.util.Script;
import com.cos.baseball.web.dto.stadium.StadiumInsertReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class StadiumController {
	
	private final StadiumService stadiumService;
	
	@PostMapping("/stadium")
	public @ResponseBody String save(StadiumInsertReqDto stadiumInsertReqDto) {
		
		int result = stadiumService.야구장등록(stadiumInsertReqDto);
		
		if(result == 1) {
			return Script.href("야구장 등록 성공", "/stadium");
		} else if(result == -1){
			return Script.href("등록되지 않은 팀입니다.", "/stadiumForm");
		} else {
			return Script.href("이미 존재하는 야구장입니다.", "/stadiumForm");
		}
		
		
	}
	
	@GetMapping("/stadiumForm")
	public String stadiumForm() {
		return "stadium/stadiumForm";
	}
	
	@GetMapping("/stadium")
	public String findAll(Model model) {
		
		List<Stadium> stadiums = stadiumService.전체찾기();
		model.addAttribute("stadiums", stadiums);
		
		return "stadium/stadiumList";
	}

	@DeleteMapping("/stadium/{id}")
	public @ResponseBody String delete(@PathVariable int id) {
		
		stadiumService.삭제하기(id);
		
		return "ok";
	}
}
