package com.team.springboot.mapper;

import com.team.springboot.pojo.ShoppingCar;
import com.team.springboot.pojo.ShoppingCarProduct;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ShoppingCarMapper {
    @Insert("insert into shoppingCar(u_Account, p_Id) value (#{0},#{1})")
    void insertOne(String u_Account, int p_Id);

    @Select("select * from shoppingCar where s_Id = #{0}")
    ShoppingCar selectById(String s_Id);

    @Select("select p.p_Id,s.s_Id, p.p_Title, p.p_href, p.p_Price\n" +
            "from shoppingcar s, product p\n" +
            "where s.u_Account = #{0} and s.p_Id = p.p_Id limit #{1}, #{2}")
    List<ShoppingCarProduct> selectShoppingCarProductById(String u_Account,int page, int limit);

    @Select("select count(s_Id) from shoppingcar where u_Account = #{u_Account}")
    int getCountByAccount(String u_Account);

    @Delete("Delete from shoppingCar where s_Id = #{0} ")
    void deleteById(int s_Id);

}