package com.team.springboot.service;


import com.team.springboot.pojo.Address;
import com.team.springboot.pojo.Password;
import com.team.springboot.pojo.User;

import java.util.List;

public interface UserService {
    User selectUserById(String id);
    void updateUser(User u);
    String selectPasswordById(String u_Account);
    void updatePassword(Password p);
    List<Address> selectAddressAll(String a_Account);
}
