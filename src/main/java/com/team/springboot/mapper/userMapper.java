package com.team.springboot.mapper;

import com.team.springboot.pojo.*;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface userMapper {

    @Select("select * from user where u_Account = #{u_Account}") //用于查询一个User实体 -wyq
    User selectUserById(String u_Account);

    @Update("update user set u_Name = #{u_Name}, u_Email = #{u_Email}, u_Sex = #{u_Sex}, u_Phone = #{u_Phone} where u_Account = #{u_Account}")
    void updateUser(User u); // 用于更新User实体信息 -wyq

    @Update("update user set u_Password = #{newPassword} where u_Account = #{u_Account}")
    void updatePassword(Password p);// 用户更新User实体的密码 -wyq

    @Select("select u_Password from user where u_Account = #{u_Account}")
    String selectPasswordById(String u_Account);

    @Select("select * from address where a_Account = #{a_Account}") // 通过Account查询所有的收货地址 -wyq
    Address selectAddressAll(String a_Account);

    @Insert("Insert into user(u_Account,u_Name,u_Password,u_Sex,u_Email,u_Phone) values(#{u_Account}, #{u_Name}, #{u_Password}, #{u_Sex}, #{u_Email}, #{u_Phone})")
    void insertOne(User u);

    @Update("update user set u_Password = #{u_Password} where u_Account = #{u_Account}")
    void updatePwd(User u);


    //查询用户数量
    @Select("select count(*) from user")
    int selectCount();
    @Select("select count(*) from user where u_Account = #{0}")
    int selectCountByAccount(String p_Account);
    //分页
    @Select("select * from user limit #{0}, #{1}")
    List<User> selectUserAll(int page, int limit);
    @Delete("Delete from user where u_Account = #{0}")
    void deleteUser(String u_Account);
    //查询某个用户
    @Select("select * from user where u_Account = #{u_Account}")
    List<User>selectUserByIdrtlist(String u_Account);
    @Update("Update user set u_Url = #{0} where u_Account= #{1};")
    void updateHeadp(String url,String u_Account);
}
