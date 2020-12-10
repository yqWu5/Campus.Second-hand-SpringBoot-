package com.team.springboot.serviceImpl;

import com.team.springboot.mapper.OrderMapper;
import com.team.springboot.pojo.Address;
import com.team.springboot.pojo.Order;
import com.team.springboot.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;

    @Override
    public List<Order> selectOrderAndProductBuy(String account) {
        return orderMapper.selectOrderAndProductBuy(account);
    }

    @Override
    public List<Order> selectOrderAndProductSell(String account) {
        return orderMapper.selectOrderAndProductSell(account);
    }

    @Override
    public Address selectAddressValue(String a_Account) {
        return orderMapper.selectAddressValue(a_Account);
    }

    @Override
    public void addressUpdate(String o_Baddress, String o_Id) {
        orderMapper.addressUpdate(o_Baddress, o_Id);
    }

    @Override
    public void deleteOrderById(Order o) {
        orderMapper.deleteOrderById(o);
    }


}
