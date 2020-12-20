package com.team.springboot.controller.exhibition;

import com.team.springboot.pojo.Product;
import com.team.springboot.service.ProductCategoryService;
import com.team.springboot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GoodsDetailController   {
   @Autowired
    ProductCategoryService productCategoryService;
   @Autowired
    ProductService productService;

   @RequestMapping("/goodsDetail")
    public  String goodsDetail(@RequestParam("pid") String pid, Model model){
       Product p  = productService.selectById(Integer.valueOf(pid));
        model.addAttribute("product",p);
        System.out.println(pid);
       return "Exhibition/goods";
   }

   @RequestMapping("/ShoppingCarAdd")
    public String ShoppingCarAdd(){

       return "";
   }


}
