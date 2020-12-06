package com.team.springboot.service;


import com.team.springboot.pojo.User;

public interface UserService {
    User selectOne(String id);
    void updateOne(User u);
    void insertOne(User u);
    void updatePwd(User u);
}
