package next.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import core.view.ModelAndView;
import next.controller.AbstractController;
import next.controller.UserSessionUtils;
import next.dao.UserDao;

public class ListUserController extends AbstractController {
	private UserDao userDao = new UserDao();

	@Override
	public ModelAndView execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		if (!UserSessionUtils.isLogined(req.getSession())) {
			return jspView("redirect:/users/loginForm");
		}

		ModelAndView mav = jspView("/user/list.jsp");
		mav.addObject("users", userDao.findAll());

		return mav;
	}
}
