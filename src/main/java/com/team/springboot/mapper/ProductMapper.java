package com.team.springboot.mapper;

import com.team.springboot.pojo.Product;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface ProductMapper {
    //查询产品数量
    @Select("select count(*) from product")
    int selectCount();
    @Select("select count(*) from product where p_Account = #{0}")
    int selectCountByaccount(String p_Account);
    //根据ID查找产品的部分信息
    @Select("select p_Id,p_Account,p_Name,p_Title,p_Price from product where p_Id = #{0}")
    Product selectProductById(int p_ID);
    //根据ID查找产品ID描述日期的详情
    @Select("select p_Id,p_Des,p_Date from product where p_Id = #{0}")
    Product selectProductsById(int p_ID);
    //根据ID查找产品全部详情
    @Select("select p_Id,p_Account,p_Name,p_Title,p_Des,p_Price,p_Date from product where p_Id = #{0}")
    Product selectProductallById(int p_ID);
    //根据ID删除
    @Delete("Delete from product where p_Id = #{0}")
    void deleteProductById(int p_ID);
    //更新产品信息
    @Update("update product set p_Name = #{p_Name},p_Title = #{p_Title},p_Des = #{p_Des},p_Price = #{p_Price} ,p_Date = #{p_Date} where p_Id = #{p_Id}")
    void updateProduct(Product product);

}
