package com.team.springboot.mapper;


import com.team.springboot.pojo.Address;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AddressMapper {

    @Select("select * from address where a_Account = #{a_Account}")
    List<Address> selectAddressAll(String a_Account);

    @Delete("delete from address where a_Account = #{a_Account}")
    void deleteAddressAll(String a_Account);

    @Insert("insert into address values(#{0}, #{1})")
    void insertAddressOne(String a_Account, String a_Address);

}
