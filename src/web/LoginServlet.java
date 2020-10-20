package web;

import pojo.User;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="LoginServlet",urlPatterns="/login")
public class LoginServlet extends HttpServlet {
    private UserService userService=new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User user = userService.login(new User(null, username, password, null));
        if (user==null){
            req.setAttribute("msg","登录名或密码错误");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }else {
            req.setAttribute("username",username);
            req.getRequestDispatcher("main.jsp").forward(req, resp);
        }
    }
}
