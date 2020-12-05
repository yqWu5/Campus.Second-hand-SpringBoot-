package com.team.springboot.controller;

import com.team.springboot.mapper.userMapper;
import com.team.springboot.pojo.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    userMapper usermapper;

    @RequestMapping("/test")
    public String showOne(Model m) {
        User user = usermapper.selectOne("1");
        m.addAttribute("user", user);
        return "admin/userInfo";
    }


    @RequestMapping("/update")
    public String updateOne(User u) {
        usermapper.updateOne(u);
        return "admin/userInfo";
    }
}
