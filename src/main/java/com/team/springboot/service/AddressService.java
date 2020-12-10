package com.team.springboot.service;


import com.team.springboot.pojo.Address;

import java.util.List;

public interface AddressService {

    List<Address> selectAddressAll(String a_Account);
    void deleteAddressAll(String a_Account);
    void insertAddressOne(Address a);
    void updateAddressByAccount(Address a);
}
