package com.lzk.service;

import com.lzk.mapper.BrandMapper;
import com.lzk.pojo.Brand;
import com.lzk.pojo.User;
import com.lzk.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class BrandService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();


    public List<Brand> selectAll(){

        SqlSession sqlSession = factory.openSession();

        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);


        List<Brand> brands = mapper.selectAll();

        sqlSession.close();

        return brands;
    }
    public List<Brand> selectBystatus(User user){

        SqlSession sqlSession = factory.openSession();

        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);


        List<Brand> brands = mapper.selectBystatus(user);

        sqlSession.close();

        return brands;
    }

    public void add(Brand brand){


        SqlSession sqlSession = factory.openSession();

        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);


        mapper.add(brand);


        sqlSession.commit();

        sqlSession.close();

    }



    public void update(Brand brand){

        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3. 获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //4. 调用方法
        mapper.update(brand);

        //提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();

    }
    public void cart(Brand brand){

        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3. 获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //4. 调用方法
        mapper.cart(brand);

        //提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();

    }


    public void deleteByUser(Brand brand) {

        SqlSession sqlSession = factory.openSession();
        //3. 获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //4. 调用方法
        mapper.deleteByUser(brand);
        //提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();

    }
}
