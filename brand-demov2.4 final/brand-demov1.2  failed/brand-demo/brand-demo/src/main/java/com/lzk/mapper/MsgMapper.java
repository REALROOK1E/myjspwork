package com.lzk.mapper;

import com.lzk.pojo.Msg;
import com.lzk.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface MsgMapper {

    @Select("select * from msg order by id desc limit 10")
    @ResultMap("msgResultMap")
    List<Msg> selectAll();

    @Insert("insert into msg values (null, #{content},#{userName},now())")
    @ResultMap("msgResultMap")
    void sendmsg(Msg msg);





}
