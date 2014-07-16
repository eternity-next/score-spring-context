package com.nhnnext.score;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nhnnext.score.config.ScoreConfiguration;
import com.nhnnext.score.lecture.Lecture;

public class Score {
	public static void main(String [] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(ScoreConfiguration.class);
		
		Lecture standardLecture = context.getBean("standardGradeLecture", Lecture.class);
		System.out.println(standardLecture.grade());
		
		Lecture passFailLecture = context.getBean("passFailGradeLecture", Lecture.class);
		System.out.println(passFailLecture.grade());
	}
}
