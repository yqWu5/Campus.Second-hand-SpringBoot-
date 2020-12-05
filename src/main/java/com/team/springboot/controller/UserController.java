package com.team.springboot.controller;

import com.team.springboot.mapper.userMapper;
import com.team.springboot.pojo.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class UserController {

    @Autowired
    userMapper usermapper;

    @RequestMapping("/test")
    public String showOne(Model m,@RequestParam("username") String username) {
        User user = usermapper.selectOne(username);
        m.addAttribute("user", user);
        return "admin/userInfo";
    }

    @RequestMapping("/login")
    public String login() {
        return "admin/login";
    }

    @PostMapping("/user/login")
    public String loginin(@RequestParam("username") String username,
                          @RequestParam("password") String password,
                          ModelAndView m) {
        String msg = "用户名或密码错误";
        if (username.length()!=0&&password.equals("123456"))
            return "redirect:/test";
        else {
            m.addObject("msg",msg);

            return "redirect:/login";
        }
    }

    @RequestMapping("/update")
    public String updateOne(User u) {
        usermapper.updateOne(u);
        return "admin/userInfo";
    }
}
