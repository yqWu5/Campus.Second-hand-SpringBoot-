package com.team.springboot.controller;


import com.team.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import javax.servlet.http.HttpSession;
@Controller
public class SignInController {
    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public String login() {
        return "admin/login";
    }

    @PostMapping("/user/login")
    public String loginin(@RequestParam("u_Account") String account,
                          @RequestParam("u_Password") String password,
                          HttpSession session) {
        if(userService.selectUserById(account)==null){
            session.setAttribute("msg","用户名或密码错误");
            return "redirect:/login";
        }
        if(userService.selectUserById(account).getU_Password().equals(password)){
            session.setAttribute("u_Account",account);
            return "redirect:/admin/userInfo";
        }
        else {
            session.setAttribute("msg","用户名或密码错误");
            return "redirect:/login";
        }
    }
}
