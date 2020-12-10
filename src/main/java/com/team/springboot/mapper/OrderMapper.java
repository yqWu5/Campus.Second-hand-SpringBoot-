package com.team.springboot.mapper;

import com.team.springboot.pojo.Address;
import com.team.springboot.pojo.Order;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface OrderMapper {

    @Select("select o.o_Id, p.p_Title, o.o_Buyer, o.o_Seller, o.o_Baddress, o.o_ItemId, o.o_Status from order2 o, product p where o_ItemId = p.p_Id and o.o_Buyer = #{Buy_Account}")
    List<Order> selectOrderAndProductBuy(String Buy_Account);

    @Select("select o.o_Id, p.p_Title, o.o_Buyer, o.o_Seller, o.o_Baddress, o.o_ItemId, o.o_Status from order2 o, product p where o_ItemId = p.p_Id and o.o_Seller = #{account} ")
    List<Order> selectOrderAndProductSell(String account);

    //给下拉框赋值
    @Select("select * from address where a_Account = #{a_Account}")
    Address selectAddressValue(String a_Account);

    @Update("update order2 set o_Baddress = #{0} where o_Id = #{1}")
    void addressUpdate(String o_Baddress, String o_Id);

    @Delete("delete from order2 where o_Id = #{o_Id}")
    void deleteOrderById(Order o);
}
