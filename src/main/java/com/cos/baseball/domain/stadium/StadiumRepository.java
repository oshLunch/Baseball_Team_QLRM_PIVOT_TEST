package com.cos.baseball.domain.stadium;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StadiumRepository extends JpaRepository<Stadium, Integer>{

	@Query(value="SELECT * FROM stadium WHERE stadiumName = :stadiumName", nativeQuery = true)
	Stadium findByTeamName(String stadiumName);
}
