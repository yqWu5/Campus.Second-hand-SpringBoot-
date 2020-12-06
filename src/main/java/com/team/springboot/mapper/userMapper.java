package com.team.springboot.mapper;

import com.team.springboot.pojo.User;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface userMapper {


    @Select("select * from user where u_Account = #{u_Account}")
    User selectOne(String u_Account);

    @Update("update user set u_Name = #{u_Name}, u_Email = #{u_Email}, u_Sex = #{u_Sex}, u_Phone = #{u_Phone} where u_Account = #{u_Account}")
    void updateOne(User u);

    @Insert("Insert into user values(#{u_Account}, #{u_Name}, #{u_Password}, #{u_Sex}, #{u_Email}, #{u_Phone})")
    void insertOne(User u);

    @Update("update user set u_Password = #{u_Password} where u_Account = #{u_Account}")
    void updatePwd(User u);
}
