package com.lzk.web;

import com.lzk.pojo.Brand;
import com.lzk.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateServlet")
public class UpdateServlet extends HttpServlet {
    private BrandService service = new BrandService();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        request.setCharacterEncoding("utf-8");


        String id = request.getParameter("id");
        String brandName = request.getParameter("brandName");
        String goodsName = request.getParameter("goodsName");
        String Price = request.getParameter("Price");
        String adv = request.getParameter("adv");
        String status = request.getParameter("status");


        Brand brand = new Brand();
        brand.setId(Integer.parseInt(id));
        brand.setBrandName(brandName);
        brand.setGoodsName(goodsName);
        brand.setPrice(Integer.parseInt(Price));
        brand.setAdv(adv);
        brand.setStatus(Integer.parseInt(status));


        //2. 调用service 完成修改
        service.update(brand);


        //转发到查询主Servlet
        request.getRequestDispatcher("/selectAllServlet").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}