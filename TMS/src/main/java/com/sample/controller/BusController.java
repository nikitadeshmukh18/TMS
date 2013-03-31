package com.sample.controller;

import com.sample.model.Bus;
import com.sample.model.BusStop;
import com.sample.model.Path;
import com.sample.model.User;
import com.sample.service.BusService;
import com.sample.service.BusStopService;
import com.sample.service.RouteService;
import com.sample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Controller
@Transactional
@RequestMapping("/admin")

public class BusController {

    private UserService userService;
    private BusStopService busStopService;
    private BusService busService;
    private RouteService routeService;
    public BusController() {

    }

    @Autowired
    public BusController(UserService userService , BusStopService busStopService, BusService busService, RouteService routeService) {
        this.busStopService = busStopService;
        this.userService = userService;
        this.busService = busService;
        this.routeService = routeService;
    }

    @RequestMapping(value = "/admin")
    public ModelAndView admin(ModelMap map, @ModelAttribute("id") String id) {

        User user = userService.getUser("username");
        map.addAttribute("user",user);

        List<BusStop> busStops =  busStopService.getAllStops();
        map.addAttribute("busStops", busStops);

        List<Path> routes =  routeService.getAllRoutes();
        map.addAttribute("routes",routes);

        return new ModelAndView("admin",map);
    }

    @RequestMapping(value = "/addBus")
    public ModelAndView addBus(){

        System.out.println("in addbus");

        System.out.println("\nLeaving add Bus\n\n\n");
        return new ModelAndView("redirect:/admin?id=1");
    }

    @RequestMapping(value = "/saveBus")
    public ModelAndView saveBus(@RequestParam("bus_src") String busSource ,
                                @RequestParam("bus_destination") String busDestination,
                                @RequestParam("route") String routeId,
            ModelMap modelMap){

       Bus bus = new Bus();
       bus.setBusSource(busSource);
       bus.setBusDestination(busDestination);
       int id = Integer.parseInt(routeId);
       bus.setRouteId(id);
       busService.saveBus(bus);
       return new ModelAndView("redirect:/admin?id=0");
    }


}
