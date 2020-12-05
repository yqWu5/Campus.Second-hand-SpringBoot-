package com.team.springboot.mapper;

import com.team.springboot.pojo.User;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface userMapper {
    @Select("select * from user where id = #{id}")
    User selectOne(int id);


    @Update("update user set name = #{name}, email = #{email}, sex = #{sex}, phone = #{phone} where id = #{id}")
    void updateOne(User u);
}
