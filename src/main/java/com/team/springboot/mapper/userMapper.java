package com.team.springboot.mapper;

import com.team.springboot.pojo.User;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface userMapper {

    @Select("select * from user1 where id = #{id}")
    User selectOne(String id);


    @Update("update user set u_Name = #{name}, u_Email = #{email}, u_Sex = #{sex}, u_Phone = #{phone} where u_Account = #{id}")
    void updateOne(User u);
}
