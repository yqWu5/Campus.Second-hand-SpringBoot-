package com.team.springboot.controller;

import com.team.springboot.pojo.Address;
import com.team.springboot.pojo.BaseResponse;
import com.team.springboot.pojo.Order;
import com.team.springboot.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class OrderController {
    @Autowired
    OrderService orderService;
    //订单收货地址修改页面转跳
    @RequestMapping("/OrderAddressUpdate")
    public String OrderAddressUpdate(){
        return "admin/OrderAddressUpdate";
    }

    //买入-订单转跳
    @RequestMapping("/BuyOrderInit")
    public String BuyOrderInit(HttpSession session){
        return "admin/BuyOrder";
    }
    //买入-订单表格初始化
    @RequestMapping("/BuyOrderInfo")
    @ResponseBody
    public BaseResponse BuyOrderInfo(HttpSession session){
        BaseResponse<List<Order>> baseResponse = new BaseResponse<>();
        String account = (String)session.getAttribute("u_Account");
        List<Order> list = orderService.selectOrderAndProductBuy(account);

        baseResponse.setCode(0);
        baseResponse.setData(list);

        return baseResponse;
    }

    //出售-订单转跳
    @RequestMapping("/SellOrderInit")
    public String SellOrderInit(){
        return "admin/SellOrder";
    }
    //出售-订单表格初始化
    @RequestMapping("/SellOrderInfo")
    @ResponseBody
    public BaseResponse SellOrderInfo(HttpSession session){
        BaseResponse<List<Order>> baseResponse = new BaseResponse<>();
        String account = (String)session.getAttribute("u_Account");
        List<Order> list = orderService.selectOrderAndProductSell(account);

        baseResponse.setCode(0);
        baseResponse.setData(list);

        return baseResponse;
    }

    //下拉框动态赋值
    @RequestMapping("/selectValue")
    @ResponseBody
    public BaseResponse selectAddressValue(HttpSession session){
        BaseResponse<List<String>> baseResponse = new BaseResponse<>();
        String account = (String)session.getAttribute("u_Account");
        Address a =  orderService.selectAddressValue(account);
        List<String> list = new ArrayList<>();
        list.add(a.getA_Address1());
        list.add(a.getA_Address2());
        list.add(a.getA_Address3());
        list.add(a.getA_Address4());

        baseResponse.setCode(200);
        baseResponse.setData(list);
        return baseResponse;

    }

    //收货地址更改
    @RequestMapping(value = "/orderChange", method = {RequestMethod.POST})
    @ResponseBody
    public BaseResponse orderChange(@RequestBody Order o){
        BaseResponse<Integer> baseResponse = new BaseResponse<>();

        if(o.getO_Baddress().equals("请选择")){
            baseResponse.setCode(500);
            baseResponse.setMsg("收货地址不能为空");
            return baseResponse;
        }

        orderService.addressUpdate(o.getO_Baddress(),o.getO_Id());
        baseResponse.setCode(200);
        baseResponse.setMsg("保存成功");

        return baseResponse;
    }

    @RequestMapping("deleteOrder")
    @ResponseBody BaseResponse deleteOrder(@RequestBody Order o){
        BaseResponse<Integer> baseResponse = new BaseResponse<>();

        System.out.println(o.toString());

        if(o == null){
            baseResponse.setCode(500);
            baseResponse.setMsg("订单不存在，删除失败！");
            return baseResponse;
        }

        orderService.deleteOrderById(o);
        baseResponse.setCode(200);
        baseResponse.setMsg("删除成功!");
        return baseResponse;
    }
}
