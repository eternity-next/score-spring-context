package com.nhnnext.score.lecture;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.nhnnext.score.scores.ScoreRepository;

@RunWith(MockitoJUnitRunner.class)
public class LectureTest {
	@Mock
	private ScoreRepository repository;
	
	@Test
	public void starndardGrade() {
		when(repository.getScores()).thenReturn(new int [] {50,20,70,80,90});

		Lecture lecture = new Lecture();
		lecture.setGrader(new StandardGrader()); 
		lecture.setScoreRepository(repository);
		
		String grade = lecture.grade();
		
		assertEquals("A:1 B:1 C:1 D:0 F:2 ", grade);
	}

	@Test
	public void passFailGrade() {
		when(repository.getScores()).thenReturn(new int [] {50,20,70,80,90});
		
		Lecture lecture = new Lecture();
		lecture.setGrader(new PassFailGrader()); 
		lecture.setScoreRepository(repository);
		
		String grade = lecture.grade();
		
		assertEquals("Pass:3 Fail:2 ", grade);
	}
}
