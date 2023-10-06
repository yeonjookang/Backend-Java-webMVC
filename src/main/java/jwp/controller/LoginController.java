package jwp.controller;

import core.db.MemoryUserRepository;
import core.mvc.Controller;
import jwp.dao.UserDao;
import jwp.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class LoginController implements Controller {

    /**
     * 세션은 클라이언트와 서버 간의 상태 정보를 유지하고 공유하기 위한 기술로,
     * 클라이언트는 이후 요청 시 세션 ID를 포함하여 서버에 전송하게 되며, 이를 통해 서버는 클라이언트와 연결된 상태를 파악할 수 있다.
     * 사용자마다 구분되는 Map<String,Object>의 자료구조를 사용할 수 있다. 세션은 일반적으로 서버 측에 저장된다.
     * Map<세션Id,Map<String,Object>>
     */

    UserDao userDao = new UserDao();

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        if(isLoginSuccess(req.getParameter("userId"),req.getParameter("password"))){
            //세션 정보 저장
            User findUser = userDao.findByUserId(req.getParameter("userId"));
            HttpSession session = req.getSession();
            session.setAttribute("user",findUser);
            return "redirect:/";
        }else{
            return "redirect:/user/loginFailed";
        }
    }

    private boolean isLoginSuccess(String userId, String password) throws SQLException {
        User findUser = userDao.findByUserId(userId);
        if(findUser!=null && findUser.getPassword().equals(password))
            return true;
        else
            return false;
    }
}
