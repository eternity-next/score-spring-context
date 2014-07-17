package com.nhnnext.score.lecture;

import com.nhnnext.score.scores.ScoreRepository;

public class Lecture {
	private ScoreRepository scoreRepository;
	private Grader grader;
	
	public Lecture() {
	}
	
	public void setScoreRepository(ScoreRepository scoreRepository) {
		this.scoreRepository = scoreRepository;
	}

	public void setGrader(Grader grader) {
		this.grader = grader;
	}

	public String grade() {
		return grader.grade(scoreRepository.getScores());
	}
}
