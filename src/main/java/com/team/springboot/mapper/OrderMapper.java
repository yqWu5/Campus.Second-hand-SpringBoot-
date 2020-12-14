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

    @Select("select o.o_Id, p.p_Title, o.o_Buyer, o.o_Seller, o.o_Baddress, o.o_ItemId, o.o_Status from order2 o, product p where o_ItemId = p.p_Id and o.o_Buyer = #{0} limit #{1}, #{2}")
    List<Order> selectOrderAndProductBuy(String Buy_Account, int page, int limit);

    @Select("select o.o_Id, p.p_Title, o.o_Buyer, o.o_Seller, o.o_Baddress, o.o_ItemId, o.o_Status from order2 o, product p where o_ItemId = p.p_Id and o.o_Seller = #{0} limit #{1}, #{2} ")
    List<Order> selectOrderAndProductSell(String account, int page, int limit);

    //给下拉框赋值
    @Select("select * from address where a_Account = #{a_Account}")
    Address selectAddressValue(String a_Account);

    @Update("update order2 set o_Baddress = #{0} where o_Id = #{1}")
    void addressUpdate(String o_Baddress, String o_Id);

    @Delete("delete from order2 where o_Id = #{o_Id}")
    void deleteOrderById(Order o);

    @Select("select count(o_Id) from order2 where o_Buyer = #{o_Buyer}")
    int orderBuyerCount(String o_Buyer);

    @Select("select count(o_Id) from order2 where o_Seller = #{o_Seller}")
    int orderSellerCount(String o_Seller);

    // 更新订单状态
    @Update("update order2 set o_Status = #{o_Status} where o_Id = #{o_Id}")
    void StatusUpdate(Order o);
}
