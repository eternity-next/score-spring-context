package com.nhnnext.score;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.nhnnext.score.lecture.Lecture;

public class Score {
	public static void main(String [] args) {
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("classpath:scores.xml");
		
		Lecture standardLecture = context.getBean("standardGradeLecture", Lecture.class);
		System.out.println(standardLecture.grade());
		
		Lecture passFailLecture = context.getBean("passFailGradeLecture", Lecture.class);
		System.out.println(passFailLecture.grade());
		
		context.close();
	}
}
