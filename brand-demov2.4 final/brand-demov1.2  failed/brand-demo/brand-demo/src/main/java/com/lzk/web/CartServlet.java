package com.lzk.web;

import com.lzk.pojo.Brand;
import com.lzk.service.BrandService;
import com.lzk.service.Cartservice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
    private BrandService service = new BrandService();
    private Cartservice service2 = new Cartservice();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //处理POST请求的乱码问题

        request.setCharacterEncoding("utf-8");


        //1. 接收表单提交的数据，封装为一个Brand对象
        String id = request.getParameter("id");
        String status = request.getParameter("status");
        int userid = Integer.parseInt(request.getParameter("userid"));
        String adv = request.getParameter("adv");
        String goodsName = request.getParameter("goodsName");
        String price = request.getParameter("price");
        String brandName = request.getParameter("brandName");
        //封装为一个Brand对象
//只有目标值为0时候是insert，1时是删除，其他时候是update

        Brand brand = new Brand();
        brand.setId(Integer.parseInt(id));
        brand.setAdv(adv);
        brand.setBrandName(brandName);
        brand.setPrice(Integer.parseInt(price));
        brand.setGoodsName(goodsName);
        brand.setStatus(Integer.parseInt(status));
        brand.setUserid(userid);


        //加号并且
        int check = service2.checknull(brand);
        int num = 0;
        if (check == 1) {
            num = service2.getnum(brand);
        }
        System.out.println(check);
        if (request.getParameter("sign").equals("+")) {
            //2. 调用service 完成修改
            if(check == 0){
            service.cart(brand);
            System.out.println("插入一条新商品");}

            else{
                brand.setStatus(num+1);
                service.update(brand);
                System.out.println("更新商品数量");
            }
        } else if ( num == 1) {
            service.deleteByUser(brand);
            System.out.println("删除一个商品");

        }else{
            brand.setStatus(num-1);
            service.update(brand);
            System.out.println("更新商品数量");


        }


        //3. 转发到查询所有Servlet
        request.getRequestDispatcher("/selectAllServlet").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}