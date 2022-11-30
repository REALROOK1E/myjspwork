package com.lzk.service;

import com.lzk.mapper.UserMapper;
import com.lzk.pojo.User;
import com.lzk.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.io.UnsupportedEncodingException;


public class UserService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    /**
     * 登录方法
     * @param username
     * @param password
     * @return
     */

    public User login(String username,String password){

        SqlSession sqlSession = factory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = mapper.select(username, password);


        sqlSession.close();

        return  user;
    }




    public boolean register(User user) throws UnsupportedEncodingException {
        SqlSession sqlSession = factory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User u = mapper.selectByUsername(user.getUsername());

        if(u == null){
            // 用户名不存在，注册
            mapper.add(user);
            sqlSession.commit();

        }
        sqlSession.close();

        return u == null;

    }
}
