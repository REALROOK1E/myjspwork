package com.lzk.mapper;

import com.lzk.pojo.Brand;

import com.lzk.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface BrandMapper {

    @Select("select * from cart where user_id =0")
    @ResultMap("brandResultMap")
    List<Brand> selectAll();

    @Insert("insert into cart values(null,#{brandName},#{goodsName},#{price},#{adv},#{status},DEFAULT,0)")
    void add(Brand brand);

    @Select("select * from cart where id = #{id}")
    @ResultMap("brandResultMap")
    Brand selectById(int id);


    @Update("update cart set status = #{status} where user_id= #{userid} and goods_name= #{goodsName}")
    void update(Brand brand);


    @Insert("insert into cart values(null,#{brandName},#{goodsName},#{price},#{adv},#{status},DEFAULT,#{userid})")
    void cart(Brand brand);


    @Select("select * from cart where status != 0 and user_id= #{id}")
    @ResultMap("brandResultMap")
    List<Brand> selectBystatus(User user);



 Integer sum(User user);

void delete(User user);
int checknull(Brand brand);
int getnum(Brand brand);

@Delete("delete from cart where user_id=#{userid} and goods_name=#{goodsName}")
    void deleteByUser(Brand brand);
}
