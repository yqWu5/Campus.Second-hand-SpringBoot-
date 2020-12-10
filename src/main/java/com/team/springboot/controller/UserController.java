package com.team.springboot.controller;


import com.team.springboot.pojo.Address;
import com.team.springboot.pojo.BaseResponse;
import com.team.springboot.pojo.Password;
import com.team.springboot.pojo.User;

import com.team.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
@RequestMapping("/admin")
public class UserController {

    @Autowired
    UserService userService;
    //后台初始化
    @RequestMapping("/userInfo")
    public String showUserInfo(Model m, HttpSession session) {
        String account = (String) session.getAttribute("u_Account");
        User user = userService.selectUserById(account);
        Address address = (Address) userService.selectAddressAll(account);

        System.out.println(account);

        m.addAttribute("user", user);
        m.addAttribute("address",address);
        return "admin/userInfo";
    }

    // 更新用户信息
    @RequestMapping(value = "/userUpdate", method = {RequestMethod.POST})
    @ResponseBody
    public BaseResponse updateUserInfo(@RequestBody User u) {
        BaseResponse<Integer> baseResponse = new BaseResponse<Integer>();

        if(u.getU_Phone().length() < 11 || u.getU_Name() == "" || u.getU_Email().indexOf("@") == -1){
            baseResponse.setCode(500);  // 前端所传内容不符合要求
            baseResponse.setMsg("保存失败");
        }else{
            baseResponse.setCode(200);
            baseResponse.setMsg("保存成功！");
            userService.updateUser(u);
        }

        return baseResponse;
    }

    // 更改密码
    @RequestMapping("/passwordUpdate")
    @ResponseBody
    public BaseResponse updatePassword(@RequestBody Password pojo){
        BaseResponse<Integer> baseResponse = new BaseResponse<Integer>();
        pojo.setU_Account("1001");
        String u_Account = pojo.getU_Account();
        String rightPassword = userService.selectPasswordById(u_Account); //通过账号查询正确的密码

        //修改失败！与原密码一致
        if(pojo.getNewPassword().equals(pojo.getNewPasswordAgain()) && pojo.getNewPassword().equals(pojo.getU_Password()) && pojo.getU_Password().equals(rightPassword)){
            baseResponse.setCode(500);
            baseResponse.setMsg("修改失败！与原密码一致");
            return baseResponse;
        }
        //修改失败！密码为空
        if(pojo.getU_Password().equals("") || pojo.getNewPassword().equals("") || pojo.getNewPasswordAgain().equals("")){
            baseResponse.setCode(500);
            baseResponse.setMsg("密码为空，请重新填写");
            return baseResponse;
        }
        // 修改失败！原密码不正确
        if(!pojo.getU_Password().equals(rightPassword)){
            baseResponse.setCode(500);
            baseResponse.setMsg("修改失败！原密码不正确");
            return baseResponse;
        }
        // 修改失败！两遍新密码不一致
        if(!pojo.getNewPassword().equals(pojo.getNewPasswordAgain())){
            baseResponse.setCode(500);
            baseResponse.setMsg("修改失败！两遍新密码不一致");
            return baseResponse;
        }
        //修改成功
        userService.updatePassword(pojo);
        baseResponse.setCode(200);
        baseResponse.setMsg("修改成功！");
        return baseResponse;


    }

    // 退出登录
    @RequestMapping("/quit")
    public String quit(HttpSession session){
        session.invalidate();
        return "redirect:/login";
    }

}
