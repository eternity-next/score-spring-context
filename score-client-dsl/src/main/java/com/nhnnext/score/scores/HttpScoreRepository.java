package com.nhnnext.score.scores;

public class HttpScoreRepository implements ScoreRepository {
	public HttpScoreRepository() {
	}
	
	public int [] getScores() {
		return new int [] {50, 20, 70, 80, 90};
	}
}
