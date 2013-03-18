package com.sample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/")
public class BaseController {

    @RequestMapping(value = "/" , method = RequestMethod.GET)
    public String welcome(ModelMap model){
        model.addAttribute("message", "Maven Web Project + Spring 3 MVC - welcome()");
        return "index";
    }

    @RequestMapping(value = "/login" , method = RequestMethod.GET)
    public String login(ModelMap model){
       // model.addAttribute("message", "Maven Web Project + Spring 3 MVC - welcome()");
        return "login";
    }
   }
