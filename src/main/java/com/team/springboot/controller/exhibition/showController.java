package com.team.springboot.controller.exhibition;

import com.team.springboot.pojo.ProductCategory;
import com.team.springboot.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class showController {

    @Autowired
    ProductCategoryService productCategoryService;

    @RequestMapping("/showAll")
    public String showAll(Model m){
        List<ProductCategory> list = productCategoryService.selectProductAll();
        m.addAttribute("productList",list);
        return "Exhibition/user";
    }
}
