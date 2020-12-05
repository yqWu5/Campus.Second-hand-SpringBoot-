package com.team.springboot.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import javax.servlet.http.HttpSession;
@Controller
public class SignInController {
    @RequestMapping("/login")
    public String login() {
        return "admin/login";
    }

    @PostMapping("/user/login")
    public String loginin(@RequestParam("username") String username,
                          @RequestParam("password") String password,
                          HttpSession session) {
        if (username.length() != 0 && password.equals("123456")){
            session.setAttribute("username",username);
            session.setAttribute("password",password);
            return "redirect:/test";
        }
        else {
            session.setAttribute("msg","用户名或密码错误");
            return "redirect:/login";
        }
    }
}
