package com.nhnnext.score;

import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.nhnnext.score.lecture.Lecture;

public class Score {
	public static void main(String [] args) {
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("classpath:scores.xml");
		
		Lecture lecture = null;
		Scanner scanner = new Scanner(System.in);
		
		try {
			System.out.print("grader? ");
			switch(scanner.next()) {
			case "st":
				lecture = context.getBean("standardGradeLecture", Lecture.class);
				break;
			case "pf":
				lecture = context.getBean("passFailGradeLecture", Lecture.class);			
				break;
			default:
				return;
			}
			System.out.println(lecture.grade());
		} finally {
			scanner.close();
			context.close();
		}
	}
}
