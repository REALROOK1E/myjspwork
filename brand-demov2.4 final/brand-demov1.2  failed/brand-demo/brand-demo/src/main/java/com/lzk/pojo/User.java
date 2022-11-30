package com.lzk.pojo;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User implements HttpSessionBindingListener {
    public static int usernumber =0;


    @Override
    public void valueBound(HttpSessionBindingEvent event) {

        HttpSession session = event.getSession();
        List<String> userList= (List<String>) session.getServletContext().getAttribute("userlist");
                userList.add(this.username);
        System.out.println(userList);
        System.out.println(this.getUsername()+"已登录");
           usernumber=userList.size();

    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {

        HttpSession session = event.getSession();
        List<String> userList= (List<String>) session.getServletContext().getAttribute("userlist");
        userList.remove(this.username);
        System.out.println(userList);
        System.out.println(this.getUsername()+"已下线");
        usernumber=userList.size();

    }

    private Integer id;
    private String username;
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
