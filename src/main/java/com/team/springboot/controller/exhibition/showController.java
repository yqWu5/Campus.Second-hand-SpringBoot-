package com.team.springboot.controller.exhibition;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.springboot.pojo.ProductCategory;
import com.team.springboot.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class showController {

    @Autowired
    ProductCategoryService productCategoryService;

    @RequestMapping("/showAll")
    public String showAll(Model m,@RequestParam(defaultValue="1",required=true,value="pageNo") Integer pageNo){
        System.out.println(pageNo);
        Integer pageSize = 15;
        PageHelper.startPage(pageNo,pageSize);
        List<ProductCategory> list = productCategoryService.selectProductAll();
        PageInfo<ProductCategory> pageInfo = new PageInfo<ProductCategory>(list,pageSize);
        m.addAttribute("productList",pageInfo);
        return "Exhibition/user";
    }
}
