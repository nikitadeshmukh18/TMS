package com.sample.controller;

import com.sample.model.User;
import com.sample.service.LoginService;
import com.sample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
@Transactional
@SessionAttributes("username")
@RequestMapping("/")
public class BaseController {
    private UserService userService;
    private LoginService loginService;

    public BaseController() {
    }

    @Autowired


    public BaseController(UserService userService, LoginService loginService) {
        this.userService = userService;
        this.loginService = loginService;
    }

    @RequestMapping(value = {"/", "/welcome"})
    public String welcome(ModelMap model) {
        System.out.println("model = " + model);
        model.addAttribute("message", "Maven Web Project + Spring 3 MVC - welcome()");
        return "index";
    }

    @RequestMapping(value = "/admin")
    public String admin(ModelMap map) {

        User user = userService.getUser("username");
        map.addAttribute("user", user);
        return "admin";
    }

    @RequestMapping(value = "/login")
    public String login() {
        return ("login");
    }

    @RequestMapping(value = "/login.do", method = RequestMethod.POST)
    public ModelAndView validateLogin(@RequestParam("password") String password,
                                      @RequestParam("username") String username,
                                      ModelMap modelMap) {


        boolean isValid = loginService.isValidUser(username, password);
        if (isValid) {
            return new ModelAndView("redirect:admin");
        } else {
            return new ModelAndView("redirect:/login");
        }
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String search(ModelMap model) {
        return "search";
    }

    @RequestMapping(value = "/logout")
    public ModelAndView logout() {


        return new ModelAndView("redirect:/");
    }
}
