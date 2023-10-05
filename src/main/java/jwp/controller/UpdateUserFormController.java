package jwp.controller;

import core.db.MemoryUserRepository;
import core.mvc.Controller;
import jwp.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateUserFormController implements Controller {


    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String userId = req.getParameter("userId");
        User findUser = MemoryUserRepository.getInstance().findUserById(userId);

        if(findUser!=null){
            req.setAttribute("user",findUser);

            return "/user/updateForm.jsp";
        }
        //url 주소도 함꼐 바꿔주기 위해 redirect
        return "redirect:/";
    }
}
