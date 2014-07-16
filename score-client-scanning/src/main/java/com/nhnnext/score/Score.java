package com.nhnnext.score;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.nhnnext.score.lecture.Lecture;

public class Score {
	private static ApplicationContext initializeAnnotationConfigApplicationContext() {
		return new AnnotationConfigApplicationContext("com.nhnnext.score");
	}

	private static ApplicationContext initializeGenericXmlApplicationContext() {
		return new GenericXmlApplicationContext("classpath:scores.xml");
	}
	
	public static void main(String [] args) {
		ApplicationContext context = initializeAnnotationConfigApplicationContext();
		
		Lecture lecture = context.getBean("standardGradeLecture", Lecture.class);
		System.out.println(lecture.grade());
	}
}
