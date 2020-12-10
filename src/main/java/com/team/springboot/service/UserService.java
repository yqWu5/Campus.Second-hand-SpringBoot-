package com.team.springboot.service;


import com.team.springboot.pojo.Address;
import com.team.springboot.pojo.Password;
import com.team.springboot.pojo.User;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserService {
    User selectUserById(String u_Account);
    void updateUser(User u);
    String selectPasswordById(String u_Account);
    void updatePassword(Password p);
    Address selectAddressAll(String a_Account);
    void insertOne(User u);
    void updatePwd(User u);
}
