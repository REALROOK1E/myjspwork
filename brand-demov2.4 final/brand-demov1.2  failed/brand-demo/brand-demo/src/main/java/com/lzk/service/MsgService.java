package com.lzk.service;

import com.lzk.mapper.MsgMapper;
import com.lzk.pojo.Msg;
import com.lzk.pojo.User;
import com.lzk.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class MsgService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();


    public List<Msg> selectAll(){

        SqlSession sqlSession = factory.openSession();

        MsgMapper mapper = sqlSession.getMapper(MsgMapper.class);

        List<Msg> msgs = mapper.selectAll();

        sqlSession.close();

        return msgs;
    }




    public void sendMsg(Msg msg){

        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3. 获取MsgMapper
        MsgMapper mapper = sqlSession.getMapper(MsgMapper.class);

        //4. 调用方法
        mapper.sendmsg(msg);

        //提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();

    }



}
