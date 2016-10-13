package next.controller.qna;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import core.mvc.AbstractController;
import core.mvc.ModelAndView;
import next.dao.QuestionDao;
import next.model.Question;

public class AddQuestionController extends AbstractController {
	private static final Logger log = LoggerFactory.getLogger(AddAnswerController.class);

	private QuestionDao questionDao = new QuestionDao();

	@Override
    public ModelAndView execute(HttpServletRequest req, HttpServletResponse response) throws Exception {
		HttpSession session = req.getSession();
		if(session.getAttribute("user") == null) {
			throw new IllegalAccessException("로그인 후 이용바랍니다.");
		}
		
        Question question = new Question(
        		req.getParameter("writer"),
        		req.getParameter("title"),
        		req.getParameter("contents")
                );
        log.debug("question : {}", question);
        
        questionDao.insert(question);

        return jspView("redirect:/");
    }
}
