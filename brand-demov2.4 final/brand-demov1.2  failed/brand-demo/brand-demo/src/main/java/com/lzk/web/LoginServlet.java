package com.lzk.web;

import com.lzk.pojo.User;
import com.lzk.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    private UserService service = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 获取用户名和密码
        response.setContentType("text/html;charset=UTF-8");
        String username =request.getParameter("username");
        username = new String(username.getBytes("iso8859-1"),"utf-8");
        String password = request.getParameter("password");
        //获取复选框数据
        String remember = request.getParameter("remember");

        //2. 调用service查询
        User user = service.login(username, password);

        //3. 判断
        if(user != null){


            //判断用户是否勾选记住我
            if("1".equals(remember)){

                //1. 创建Cookie对象
                Cookie c_username = new Cookie("username", URLEncoder.encode(username, "UTF-8") );
                Cookie c_password = new Cookie("password",password);
                System.out.println("Cookie " + c_username );
                // 设置Cookie的存活时间
                c_username.setMaxAge( 60 * 60 * 24 * 7);
                c_password.setMaxAge( 60 * 60 * 24 * 7);
                //2. 发送
                response.addCookie(c_username);
                response.addCookie(c_password);
            }

            //将登陆成功后的user对象，存储到session
            HttpSession session = request.getSession();
            session.setAttribute("user",user);
            session.setAttribute("userid",user.getId());
            session.setAttribute("username",user.getUsername());



            String contextPath = request.getContextPath();
            response.sendRedirect(contextPath+"/selectAllServlet");
         //   response.sendRedirect(contextPath+"/MsgServlet");
        }else {
            // 登录失败,
            // 存储错误信息到request
            request.setAttribute("login_msg","用户名或密码错误");
            // 跳转到login.jsp
            request.getRequestDispatcher("/login.jsp").forward(request,response);

        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}