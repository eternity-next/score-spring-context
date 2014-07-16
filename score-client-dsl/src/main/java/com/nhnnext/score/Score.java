package com.nhnnext.score;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.RuntimeBeanReference;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.StaticApplicationContext;

import com.nhnnext.score.lecture.Lecture;
import com.nhnnext.score.lecture.PassFailGrader;
import com.nhnnext.score.lecture.StandardGrader;
import com.nhnnext.score.scores.HttpScoreRepository;

public class Score {
	private static ApplicationContext initializeApplicationContext() {
		StaticApplicationContext context = new StaticApplicationContext();
		
		context.registerSingleton("httpScoreRepository", HttpScoreRepository.class);
		context.registerSingleton("standardGrader", StandardGrader.class);
		context.registerSingleton("passFailGrader", PassFailGrader.class);
		
		BeanDefinition standardGradeLecture = new RootBeanDefinition(Lecture.class);
		standardGradeLecture.getPropertyValues().addPropertyValue("grader", new RuntimeBeanReference("standardGrader"));
		standardGradeLecture.getPropertyValues().addPropertyValue("scoreRepository", new RuntimeBeanReference("httpScoreRepository"));
		context.registerBeanDefinition("standardGradeLecture", standardGradeLecture);
		
		BeanDefinition passFailGradeLecture = new RootBeanDefinition(Lecture.class);
		passFailGradeLecture.getPropertyValues().addPropertyValue("grader", new RuntimeBeanReference("passFailGrader"));
		passFailGradeLecture.getPropertyValues().addPropertyValue("scoreRepository", new RuntimeBeanReference("httpScoreRepository"));
		context.registerBeanDefinition("passFailGradeLecture", passFailGradeLecture);

		return context;
	}
	
	public static void main(String [] args) {
		ApplicationContext context = initializeApplicationContext();
		
		Lecture standardLecture = context.getBean("standardGradeLecture", Lecture.class);
		System.out.println(standardLecture.grade());
		
		Lecture passFailLecture = context.getBean("passFailGradeLecture", Lecture.class);
		System.out.println(passFailLecture.grade());
	}
}
