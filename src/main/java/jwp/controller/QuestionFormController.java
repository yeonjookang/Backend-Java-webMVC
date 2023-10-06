package jwp.controller;

import core.mvc.Controller;
import jwp.dao.UserDao;
import jwp.model.User;
import jwp.util.UserSessionUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class QuestionFormController implements Controller {
    UserDao userDao = new UserDao();

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        if(UserSessionUtils.isLogined(req.getSession())){
            return "/qna/form.jsp";
        }
        else{
            return "redirect:/user/loginForm";
        }
    }
}
