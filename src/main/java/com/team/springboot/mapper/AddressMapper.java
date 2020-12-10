package com.team.springboot.mapper;


import com.team.springboot.pojo.Address;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AddressMapper {

    @Select("select * from address where a_Account = #{a_Account}")
    List<Address> selectAddressAll(String a_Account);

    @Delete("delete from address where a_Account = #{a_Account}")
    void deleteAddressAll(String a_Account);

    @Insert("insert into address values(#{a_Account}, #{a_Address1}, #{a_Address2}, #{a_Address3}, #{a_Address4})")
    void insertAddressOne(Address a);

    @Update("update address set a_Address1 = #{a_Address1}, a_Address2 = #{a_Address2}, a_Address3 = #{a_Address3}, a_Address4 = #{a_Address4} where a_Account = #{a_Account}")
    void updateAddressByAccount(Address a);

}
