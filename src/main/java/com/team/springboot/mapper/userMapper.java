package com.team.springboot.mapper;

import com.team.springboot.pojo.Address;
import com.team.springboot.pojo.Password;
import com.team.springboot.pojo.User;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface userMapper {

    @Select("select * from user where u_Account = #{u_Account}")
    User selectUserById(String u_Account);

    @Update("update user set u_Name = #{u_Name}, u_Email = #{u_Email}, u_Sex = #{u_Sex}, u_Phone = #{u_Phone} where u_Account = #{u_Account}")
    void updateUser(User u);

    @Update("update user set u_Password = #{newPassword} where u_Account = #{u_Account}")
    void updatePassword(Password p);

    @Select("select u_Password from user where u_Account = #{u_Account}")
    String selectPasswordById(String u_Account);

    @Select("select * from address where a_Account = #{a_Account}")
    List<Address> selectAddressAll(String a_Account);

    @Insert("Insert into user values(#{u_Account}, #{u_Name}, #{u_Password}, #{u_Sex}, #{u_Email}, #{u_Phone})")
    void insertOne(User u);

    @Update("update user set u_Password = #{u_Password} where u_Account = #{u_Account}")
    void updatePwd(User u);

}
