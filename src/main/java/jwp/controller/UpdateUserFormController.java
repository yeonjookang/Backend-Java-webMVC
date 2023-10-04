package jwp.controller;

import core.db.MemoryUserRepository;
import jwp.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/updateForm")
public class UpdateUserFormController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("userId");
        User findUser = MemoryUserRepository.getInstance().findUserById(userId);

        if(findUser!=null){
            req.setAttribute("user",findUser);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/user/updateForm.jsp");
            requestDispatcher.forward(req,resp);
            return;
        }
        //url 주소도 함꼐 바꿔주기 위해 redirect
        resp.sendRedirect("/");
    }
}
