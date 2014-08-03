package com.nhnnext.score.web.custom;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
	String handle(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
