package com.team.springboot.service;


import com.team.springboot.pojo.User;

public interface UserService {
    User selectOne(int id);
    void updateOne(User u);
}
