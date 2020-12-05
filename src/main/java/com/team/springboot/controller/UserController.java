package com.team.springboot.controller;

import com.google.gson.Gson;
import com.team.springboot.mapper.userMapper;
import com.team.springboot.pojo.BaseResponse;
import com.team.springboot.pojo.User;

import com.team.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/admin")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/userInfo")
    public String showOne(Model m) {

        User user = userService.selectOne(1877000203);


        m.addAttribute("user", user);
        return "admin/userInfo";
    }


    @RequestMapping(value = "/userUpdate", method = {RequestMethod.POST})
    @ResponseBody
    public BaseResponse updateOne(@RequestBody User u) {
        BaseResponse<Integer> baseResponse = new BaseResponse<Integer>();

        if(u.getU_Phone().length() < 11 || u.getU_Name() == null || u.getU_Email().indexOf("@") == -1){
            baseResponse.setCode(500);  // 前端所传内容不符合要求
        }else{
            baseResponse.setCode(200);
            userService.updateOne(u);
        }


        return baseResponse;
    }


}
