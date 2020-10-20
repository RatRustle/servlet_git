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

@WebServlet(name="RegistServlet",urlPatterns="/reg")

public class RegistServlet extends HttpServlet {
    private UserService userService=new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String phone = req.getParameter("phone");

        if (userService.existUsername(username)){
            //返回true已存在
            System.out.println("已存在");
            req.getRequestDispatcher("error.jsp").forward(req, resp);
        }else {
            //返回false可以注册
            int regist = userService.regist(new User(null, username, password, phone));
            System.out.println(regist);
            if(regist>=1){
                //注册成功，跳转到登录页面
                req.getRequestDispatcher("login.jsp").forward(req, resp);
            }else {
                //注册失败，跳到失败页面
                req.getRequestDispatcher("error.jsp").forward(req, resp);
            }
        }





    }
}
