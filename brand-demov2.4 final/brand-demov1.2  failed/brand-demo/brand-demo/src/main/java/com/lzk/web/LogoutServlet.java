package com.lzk.web;

import com.lzk.pojo.User;
import com.lzk.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet("/logoutServlet")
public class LogoutServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 获取用户名和密码
        response.setContentType("text/html;charset=UTF-8");


            //将登陆成功后的user对象，存储到session
            HttpSession session = request.getSession();
            session.removeAttribute("user");

            request.getRequestDispatcher("/login.jsp").forward(request,response);

        }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}