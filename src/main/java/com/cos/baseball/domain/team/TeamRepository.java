package com.cos.baseball.domain.team;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TeamRepository extends JpaRepository<Team, Integer>{
	
	@Query(value="SELECT * FROM team WHERE teamName = :teamName", nativeQuery = true)
	Team findByTeamName(String teamName);
	
	@Query(value="select teamName from team", nativeQuery = true)
	List<String> teamNames();
}
