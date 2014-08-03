package com.nhnnext.score.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nhnnext.score.lecture.Lecture;

public class GradeServlet extends HttpServlet {
	private Lecture lecture;

	public void setLecture(Lecture lecture) {
		this.lecture = lecture;
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		resp.getWriter().println("<h1>" + lecture.grade() + "</h1>");
	}
	
}
