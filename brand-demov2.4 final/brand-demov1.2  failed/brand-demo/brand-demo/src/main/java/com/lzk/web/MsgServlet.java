package com.lzk.web;

import com.lzk.pojo.Msg;
import com.lzk.service.MsgService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/MsgServlet")
public class MsgServlet extends HttpServlet {
    private MsgService service = new MsgService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        //1. 调用MsgService完成查询

       List<Msg> msgList = service.selectAll();


        //2. 存入request域中

        request.setAttribute("msgList",msgList);

      //  request.setAttribute("userName",request.getSession().getAttribute("userName"));

        //3. 转发到brand.jsp
        request.getRequestDispatcher("/chatroom.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}