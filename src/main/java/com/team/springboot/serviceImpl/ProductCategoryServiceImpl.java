package com.team.springboot.serviceImpl;

import com.team.springboot.mapper.ProductCategoryMapper;
import com.team.springboot.mapper.ProductMapper;
import com.team.springboot.pojo.ProductCategory;
import com.team.springboot.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
    @Autowired
    ProductCategoryMapper productCategoryMapper;
    @Override
    public String selectCidBycName(String c_Name) {
        return productCategoryMapper.selectCidBycName(c_Name);
    }

    @Override
    public void insertProductCategory(ProductCategory productCategory) {
        productCategoryMapper.insertProductCategory(productCategory);
    }

    @Override
    public List<ProductCategory> selectProductCategorys(int page, int limit) {
        return productCategoryMapper.selectProductCategorys((page-1)*limit,limit);
    }

    @Override
    public List<ProductCategory> selectProductCategorysByaccount(String p_Account, int page, int limit) {
        return productCategoryMapper.selectProductCategorysByaccount(p_Account,(page-1)*limit,limit);
    }

    @Override
    public List<ProductCategory> selectProductAll() {
        return productCategoryMapper.selectProductAll();
    }
}
