package com.team.springboot.controller.exhibition;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class showController {

    @RequestMapping("/showAll")
    public String showAll(){
        return "Exhibition/show";
    }
}
