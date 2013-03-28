package com.sample.controller;

import com.sample.model.BusStop;
import com.sample.model.User;
import com.sample.service.BusService;
import com.sample.service.BusStopService;
import com.sample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Iterator;
import java.util.List;

@Controller
@Transactional
@RequestMapping("/admin")

public class BusController {

    private UserService userService;
    private BusStopService busStopService;
    private BusService busService;
    public BusController() {

    }

    @Autowired
    public BusController(UserService userService , BusStopService busStopService, BusService busService) {
        this.busStopService = busStopService;
        this.userService = userService;
        this.busService = busService;
    }

    @RequestMapping(value = "/admin")
    public String admin(ModelMap map) {

        User user = userService.getUser("username");
        return "admin";
    }

    @RequestMapping(value = "/addBus")
    public ModelAndView addBus(ModelMap modelMap){

        System.out.println("in addbus");

        List<BusStop> busStops = busStopService.getAllStops();
        Iterator iterator = busStops.iterator();
        while (iterator.hasNext()) {
            BusStop busStop = (BusStop) iterator.next();
            System.out.println(busStop.getStopName());
        }
        modelMap.addAttribute("busStops",busStops);
        return new ModelAndView("redirect:/admin?id=1",modelMap);
    }

    @RequestMapping(value = "/saveBus")
    public ModelAndView saveBus(@RequestParam("bus_src") String busSource ,
                                @RequestParam("bus_destination") String busDestination,
            ModelMap modelMap){


       busService.saveBus(busSource,busDestination);



        return new ModelAndView("redirect:/admin?id=0");
    }


}
