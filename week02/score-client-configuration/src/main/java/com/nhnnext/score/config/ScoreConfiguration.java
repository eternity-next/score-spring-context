package com.nhnnext.score.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

import com.nhnnext.score.lecture.Grader;
import com.nhnnext.score.lecture.Lecture;
import com.nhnnext.score.lecture.PassFailGrader;
import com.nhnnext.score.lecture.StandardGrader;
import com.nhnnext.score.scores.HttpScoreRepository;
import com.nhnnext.score.scores.ScoreRepository;

@Configurable
public class ScoreConfiguration {
	@Bean
	public ScoreRepository httpScoreRepository() {
		return new HttpScoreRepository();
	}
	
	@Bean 
	public Grader standardGrader() {
		return new StandardGrader();
	}
	
	@Bean 
	public Grader passFailGrader() {
		return new PassFailGrader();
	}
	
	@Bean
	public Lecture standardGradeLecture() {
		Lecture lecture = new Lecture();
		lecture.setGrader(standardGrader());
		lecture.setScoreRepository(httpScoreRepository());
		return lecture;
	}
	
	@Bean
	public Lecture passFailGradeLecture() {
		Lecture lecture = new Lecture();
		lecture.setGrader(passFailGrader());
		lecture.setScoreRepository(httpScoreRepository());
		return lecture;
	}
}
