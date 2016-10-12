package next.controller;

import core.mvc.Controller;
import core.view.JsonView;
import core.view.JspView;
import core.view.ModelAndView;

public abstract class AbstractController implements Controller {
	protected ModelAndView jspView(String forwardUrl) {
		return new ModelAndView(new JspView(forwardUrl));
	}
	
	protected ModelAndView jsonView() {
		return new ModelAndView(new JsonView());
	}
}
