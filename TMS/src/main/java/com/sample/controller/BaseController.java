package com.sample.controller;

import com.sample.model.User;
import com.sample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import java.util.Map;


@Controller
@SessionAttributes({"username"})
@Transactional
@RequestMapping("/")
public class BaseController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String welcome(ModelMap model){
        System.out.println("model = " + model);
        model.addAttribute("message", "Maven Web Project + Spring 3 MVC - welcome()");
        return "index";
    }

    @RequestMapping(value = "/admin")
    public String admin(@RequestParam("password") String password, ModelMap map ){
//        User user = userService.getUser(username);
//        return new ModelAndView("admin" , (Map<String, ?>) user);
        map.addAttribute("HIiiiii");
        return "admin";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    @RequestMapping(value = "/search" , method = RequestMethod.GET)
    public String search(ModelMap model){
        return "search";
    }
   }
