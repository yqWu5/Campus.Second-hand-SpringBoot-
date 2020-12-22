package com.team.springboot.controller.exhibition;

import com.team.springboot.pojo.BaseResponse;
import com.team.springboot.pojo.ShoppingCarProduct;
import com.team.springboot.service.ShoppingCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class ShoppingController {

    @Autowired
    ShoppingCarService shoppingCarService;

    @RequestMapping("/shoppingCarInit")
    public String shoppingCarInit(){
        return "admin/shoppingcar";
    }

    @RequestMapping("/shoppingCarAll")
    @ResponseBody
    public BaseResponse shoppingCarAll(HttpServletRequest req ,int page, int limit){
        BaseResponse<List<ShoppingCarProduct>> baseResponse = new BaseResponse<>();
        String account = (String)req.getSession().getAttribute("u_Account");
        int count = shoppingCarService.getCountByAccount(account);
        List<ShoppingCarProduct> list = shoppingCarService.selectShoppingCarProductById(account,(page - 1) * limit, limit);
        baseResponse.setCount(count);
        baseResponse.setCode(200);
        baseResponse.setData(list);
        return baseResponse;
    }
    @RequestMapping("/shoppingCardelete")
    @ResponseBody
    public  BaseResponse shoppingCardelete(@RequestParam("s_Id") int s_Id){
        BaseResponse<Integer> baseResponse = new BaseResponse<>();
        shoppingCarService.deleteById(s_Id);
        baseResponse.setCode(200);
        baseResponse.setMsg("删除成功");
        return baseResponse;
    }
}
