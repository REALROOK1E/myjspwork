package com.lzk.web;

import com.lzk.pojo.Msg;
import com.lzk.pojo.Msg;
import com.lzk.service.MsgService;
import com.lzk.service.Cartservice;
import com.lzk.service.MsgService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/SendServlet")
public class SendServlet extends HttpServlet {

    private MsgService service = new MsgService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //处理POST请求的乱码问题

        request.setCharacterEncoding("utf-8");
        //1. 接收表单提交的数据，封装为一个Msg对象
         String username = request.getParameter("username");


         String content = request.getParameter("content");
        //封装为一个Msg对象


        if(content != null && content.length() > 0)
        {
        Msg msg = new Msg();
        msg.setUserName(username);
        msg.setContent(content);
        service.sendMsg(msg);
        }




        //3. 转发到查询所有Servlet
        request.getRequestDispatcher("/MsgServlet").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}