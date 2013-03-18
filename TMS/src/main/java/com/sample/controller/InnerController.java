package com.sample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/welcome")
public class InnerController {

    @RequestMapping(value = "/{name}" , method = RequestMethod.GET)
    public String welcome(@PathVariable String name , ModelMap model){
        model.addAttribute("message" , "Hi " + name + "Your on Inner Controller");

        return "index";
    }

    @RequestMapping(value = "" , method = RequestMethod.GET)
    public String empty(){
        return "index";
    }
}
