package com.nhnnext.score.lecture;

public class PassFailGrader implements Grader {
	public String grade(int [] scores) {
		int [] count = new int[2];
		
		for(int score : scores) {
			if (score >= 70) {
				count[0]++;
			} else {
				count[1]++;
			} 
		}
		
		return "Pass:" + count[0] + " Fail:" + count[1] + " ";
	}
}
