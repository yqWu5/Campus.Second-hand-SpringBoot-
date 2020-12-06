package com.team.springboot.serviceImpl;

import com.team.springboot.mapper.userMapper;
import com.team.springboot.pojo.Address;
import com.team.springboot.pojo.Password;
import com.team.springboot.pojo.User;
import com.team.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    userMapper usermapper;

    @Override
    public User selectUserById(String id) {
        return usermapper.selectUserById(id);
    }

    @Override
    public void updateUser(User u) {
        usermapper.updateUser(u);
    }

    @Override
    public String selectPasswordById(String u_Account){
        return usermapper.selectPasswordById(u_Account);
    }

    @Override
    public void updatePassword(Password p){
        usermapper.updatePassword(p);
    }

    @Override
    public List<Address> selectAddressAll(String a_Account) {
        return usermapper.selectAddressAll(a_Account);
    }
}
