package com.team.springboot.serviceImpl;

import com.team.springboot.mapper.userMapper;
import com.team.springboot.pojo.User;
import com.team.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    userMapper usermapper;

    @Override
    public User selectOne(String id) {
        return usermapper.selectOne(id);
    }

    @Override
    public void updateOne(User u) {
        usermapper.updateOne(u);
    }

    @Override
    public void insertOne(User u) {
        usermapper.insertOne(u);
    }

    @Override
    public void updatePwd(User u) {
        usermapper.updatePwd(u);
    }


}
