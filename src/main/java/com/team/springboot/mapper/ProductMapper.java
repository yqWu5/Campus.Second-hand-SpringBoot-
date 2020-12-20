package com.team.springboot.mapper;

import com.team.springboot.pojo.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProductMapper {
    //查询产品数量
    @Select("select count(*) from product")
    int selectCount();
    @Select("select count(*) from product where p_Account = #{0}")
    int selectCountByaccount(String p_Account);

    @Select("select count(*) from product where p_Name like #{0}")
    int selectCountByp_Name(String p_Name);
    @Select("select count(*) from product where p_Account = #{0} AND p_Name like #{1}")
    int selectCountByp_nameAndaccount(String p_Account,String p_Name);

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
    //查询图片地址
    @Select("select p_href, p_href1 from product where p_Id = #{p_Id}")
    Product imgHref(int p_Id);
    //更新href
    @Update("update product set p_href = #{0} where p_Id = #{1}")
    void setHref(String p_href, int p_Id);
    //更新href1
    @Update("update product set p_href1 = #{0} where p_Id = #{1}")
    void setHref1(String p_href, int p_Id);

    @Select("select * from product where p_Id = #{p_Id}")
    Product selectById(int p_Id);
}
