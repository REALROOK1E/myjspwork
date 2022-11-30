package com.lzk.web;

import com.lzk.pojo.Brand;
import com.lzk.pojo.User;
import com.lzk.service.BrandService;
import com.lzk.service.Cartservice;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;




@WebServlet("/selectAllServlet")
public class SelectAllServlet extends HttpServlet {
    private  BrandService service = new BrandService();
    private Cartservice service2 = new Cartservice();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        //1. 调用BrandService完成查询
       List<Brand> brands = service.selectAll();
       List<Brand> cart = service.selectBystatus((User) request.getSession().getAttribute("user"));
       int cart1 = service2.sum((User) request.getSession().getAttribute("user"));
        //System.out.println(cart1.toString());
        System.out.println(cart.toString());


        //2. 存入request域中
        request.setAttribute("sum",cart1);
        request.setAttribute("brands",brands);
        request.setAttribute("cart",cart);
        request.setAttribute("userid",request.getSession().getAttribute("userid"));


        //3. 转发到brand.jsp
        request.getRequestDispatcher("/brand.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}