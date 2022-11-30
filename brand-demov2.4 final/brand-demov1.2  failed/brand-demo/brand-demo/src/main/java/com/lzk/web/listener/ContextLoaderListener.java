package com.lzk.web.listener;

import com.lzk.pojo.User;
import jdk.javadoc.internal.doclets.toolkit.taglets.UserTaglet;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebListener
public class ContextLoaderListener implements ServletContextListener {
    public  static List<String> userlist= new ArrayList<>();

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        System.out.println("将用户添加到列表");

        sce.getServletContext().setAttribute("userlist",userlist);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //释放资源
    }
}
