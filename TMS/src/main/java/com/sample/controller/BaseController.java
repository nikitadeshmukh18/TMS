package com.sample.controller;

import com.sample.model.BusStop;
import com.sample.model.User;
import com.sample.service.LoginService;
import com.sample.service.UserService;
import com.sample.service.BusStopService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@Transactional
@SessionAttributes("username")
@RequestMapping("/")
public class BaseController {
    private UserService userService;
    private LoginService loginService;
    private BusStopService busStopService;
    public BaseController() {
    }

    @Autowired


    public BaseController(UserService userService, LoginService loginService,BusStopService busStopService) {
        this.userService = userService;
        this.loginService = loginService;
        this.busStopService=busStopService;
    }

    @RequestMapping(value = {"/", "/welcome"})
    public String welcome(ModelMap model) {
        System.out.println("model = " + model);
        model.addAttribute("message", "Maven Web Project + Spring 3 MVC - welcome()");
        return "index";
    }

    @RequestMapping(value = "/login")
    public String login() {
        return ("login");
    }

    @RequestMapping(value = "/addroute")
    public String addroute() {
        return ("addroute");
    }

    @RequestMapping(value = "/login.do", method = RequestMethod.POST)
    public ModelAndView validateLogin(@RequestParam("password") String password,
                                      @RequestParam("username") String username,
                                      ModelMap modelMap) {


        boolean isValid = loginService.isValidUser(username, password);
        if (isValid) {
            return new ModelAndView("redirect:admin?id=0");
        } else {
            return new ModelAndView("redirect:/login");
        }
    }


/*    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String search(ModelMap model) {

        return "search";
    } */

    @RequestMapping(value = "/search")
    public ModelAndView admin(ModelMap map) {

        try
        {
       List<BusStop> busStops = busStopService.getAllStops();
        map.addAttribute("busStops", busStops);
        }
        catch (Exception e)
        {
            System.out.println("Error is " + e.toString());

        }
        return new ModelAndView("search", map);
    }

    @RequestMapping(value = "/logout")
    public ModelAndView logout() {


        return new ModelAndView("redirect:/");
    }


}
