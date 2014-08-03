package com.nhnnext.score.web.spring;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.nhnnext.score.lecture.Lecture;

public class GradeController implements Controller {
	private Lecture lecture;

	public void setLecture(Lecture lecture) {
		this.lecture = lecture;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, Object> model = new HashMap<String, Object>(); 
		model.put("grade", lecture.grade());
		
		return new ModelAndView("lecture", model);
	}

}
