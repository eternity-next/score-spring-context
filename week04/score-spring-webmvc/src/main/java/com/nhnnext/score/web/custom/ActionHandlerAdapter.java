package com.nhnnext.score.web.custom;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.ModelAndView;

public class ActionHandlerAdapter implements HandlerAdapter {

	@Override
	public boolean supports(Object handler) {
		return handler instanceof Action;
	}

	@Override
	public ModelAndView handle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		String view = ((Action)handler).handle(request, response);
		
		Map<String, Object> model = new HashMap<String, Object>();
		
	    Enumeration<String> enumeration = (Enumeration<String>)request.getAttributeNames();

		while(enumeration.hasMoreElements()) {
			String name = enumeration.nextElement();
			model.put(name, request.getAttribute(name));
		}
		
		return new ModelAndView(view, model);
	}

	@Override
	public long getLastModified(HttpServletRequest request, Object handler) {
		return -1;
	}

}
