package com.lzk.web;

import com.lzk.pojo.User;
import com.lzk.service.Cartservice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteServlet")
public class DeleteServlet extends HttpServlet {
    private Cartservice service = new Cartservice();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


       System.out.println("清空购物车");
        service.delete((User) request.getSession().getAttribute("user"));


        //3. 转发到查询所有Servlet
       // request.getRequestDispatcher("/brand.jsp").forward(request,response);
       request.getRequestDispatcher("/selectAllServlet").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}