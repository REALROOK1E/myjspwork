package com.lzk.service;

import com.lzk.mapper.BrandMapper;
import com.lzk.pojo.Brand;
import com.lzk.pojo.User;
import com.lzk.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class Cartservice {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();
    public Integer sum(User user) {

        SqlSession sqlSession = factory.openSession();

        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);


        Integer cart= mapper.sum(user);

        sqlSession.close();
        return cart;
    }
    public void delete(User user) {

        SqlSession sqlSession = factory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.delete(user);


        sqlSession.close();


    }
    public int checknull(Brand brand){

        SqlSession sqlSession = factory.openSession();

        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);


        int res=mapper.checknull(brand);

            sqlSession.close();

return res;



    }
    public int getnum(Brand brand){

        SqlSession sqlSession = factory.openSession();

        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);


        int res=mapper.getnum(brand);

        sqlSession.close();

        return res;



    }
}
