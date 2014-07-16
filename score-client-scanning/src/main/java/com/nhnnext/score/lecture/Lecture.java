package com.nhnnext.score.lecture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nhnnext.score.scores.ScoreRepository;

@Component("standardGradeLecture")
public class Lecture {
	private ScoreRepository scoreRepository;
	private Grader grader;
	
	public Lecture() {
	}
	
	@Autowired
	public void setScoreRepository(ScoreRepository scoreRepository) {
		this.scoreRepository = scoreRepository;
	}

	@Autowired
	public void setGrader(Grader grader) {
		this.grader = grader;
	}

	public String grade() {
		return grader.grade(scoreRepository.getScores());
	}
}
