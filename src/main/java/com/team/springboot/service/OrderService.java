package com.team.springboot.service;

import com.team.springboot.pojo.Address;
import com.team.springboot.pojo.Order;

import java.util.List;

public interface OrderService {

    List<Order> selectOrderAndProductBuy(String account);
    List<Order> selectOrderAndProductSell(String account);
    Address selectAddressValue(String a_Account);
    void addressUpdate(String o_Baddress, String o_Id);
    void deleteOrderById(Order o);
}
