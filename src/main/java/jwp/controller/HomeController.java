package jwp.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/")
public class HomeController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("HomeController 실행");
        //정적 페이지(html)이든, 동적 페이지(jsp)이든, webapp 디렉토리에서 읽는다.
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/home.jsp");
        requestDispatcher.forward(req,resp);
    }
}
