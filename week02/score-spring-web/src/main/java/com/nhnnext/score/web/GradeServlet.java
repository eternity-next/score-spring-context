package com.nhnnext.score.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.nhnnext.score.lecture.Lecture;

public class GradeServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		
		Lecture lecture = context.getBean("standardGradeLecture", Lecture.class);
		
		resp.setContentType("text/html;charset=UTF-8");
		resp.getWriter().println("<h1>" + lecture.grade());
	}
	
}
