package com.nhnnext.score.web.custom;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nhnnext.score.lecture.Lecture;

public class GradeAction implements Action {
	private Lecture lecture;

	public void setLecture(Lecture lecture) {
		this.lecture = lecture;
	}

	@Override
	public String handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("grade", lecture.grade());
		return "/WEB-INF/jsp/lecture.jsp";
	}

}
