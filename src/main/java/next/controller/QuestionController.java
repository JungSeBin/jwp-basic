package next.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import core.mvc.Controller;

public class QuestionController implements Controller{
	
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		return "/qna/form.html";
	}
}
