package com.team.springboot.service;

import com.team.springboot.pojo.ProductCategory;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductCategoryService {
    String selectCidBycName(String c_Name);
    void insertProductCategory(ProductCategory productCategory);
    List<ProductCategory> selectProductCategorys(int page, int limit);
    List<ProductCategory> selectProductCategorysByaccount(String p_Account,int page, int limit);
}
