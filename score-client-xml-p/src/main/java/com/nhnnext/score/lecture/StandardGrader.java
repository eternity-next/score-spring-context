package com.nhnnext.score.lecture;

public class StandardGrader implements Grader {
	private static final String [] GRADES = {"A", "B", "C", "D", "F"};
	
	public String grade(int [] scores) {
		int [] count = new int[GRADES.length];
		
		for(int score : scores) {
			if (score >= 90) {
				count[0]++;
			} else if (score >= 80) {
				count[1]++;
			} else if (score >= 70) {
				count[2]++;
			} else if (score >= 60) {
				count[3]++;
			} else {
				count[4]++;
			}
		}
		
		String result = "";
		for(int loop=0; loop<GRADES.length; loop++) {
			result += GRADES[loop] + ":" + count[loop] + " ";
		}
		
		return result;
	}
}
