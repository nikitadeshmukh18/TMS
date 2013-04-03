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

import javax.swing.*;
import java.lang.reflect.Array;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

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
    public BusController(UserService userService, BusStopService busStopService, BusService busService, RouteService routeService) {
        this.busStopService = busStopService;
        this.userService = userService;
        this.busService = busService;
        this.routeService = routeService;
    }

    @RequestMapping(value = "/admin")
    public ModelAndView admin(ModelMap map, @ModelAttribute("id") String id, @ModelAttribute("route") String route ,@ModelAttribute("time")String time) {

        User user = userService.getUser("username");
        map.addAttribute("user", user);

        List<BusStop> busStops = busStopService.getAllStops();
        map.addAttribute("busStops", busStops);

        List<Path> routes = routeService.getAllRoutes();
        map.addAttribute("routes", routes);

        try{
        StringTokenizer st = new StringTokenizer(route, ":");
        int rid = Integer.parseInt(st.nextToken());

        String rt = st.nextToken();
        st=new StringTokenizer(rt,"-");
        String src= st.nextToken();
        String dest=null;
        while(st.hasMoreTokens())
        {
            dest=st.nextToken();
        }

        Bus bus = new Bus();
        bus.setRouteId(rid);
        bus.setBusSource(src);
        bus.setBusDestination(dest);

        map.addAttribute("bus",bus);
        map.addAttribute("rt",rt);
        map.addAttribute("time",time);
        }
        catch (Exception e){}
        return new ModelAndView("admin", map);
    }

    @RequestMapping(value = "/addBus")
    public ModelAndView addBus() {

        return new ModelAndView("redirect:/admin?id=1");
    }

    @RequestMapping(value = "/saveBus")
    public ModelAndView saveBus(@RequestParam("bus_src") String busSource,
                                @RequestParam("bus_destination") String busDestination,
                                @RequestParam("route") String route,
                                @RequestParam("startTime") String time,
                                ModelMap modelMap) {

        Bus bus = new Bus();
        bus.setBusSource(busSource);
        bus.setBusDestination(busDestination);

        StringTokenizer st = new StringTokenizer(route, ":");

        int id = Integer.parseInt(st.nextToken());
        bus.setRouteId(id);

        bus.setStartTime(time);

        busService.saveBus(bus);
        modelMap.addAttribute("bus",bus);
        modelMap.addAttribute("route",route);
        modelMap.addAttribute(time);

        System.out.println("Bus =" + bus);
        return new ModelAndView("redirect:/admin?id=13",modelMap);
    }

    @RequestMapping(value = "/addRoute")
    public ModelAndView addRoute(){

        return new ModelAndView("redirect:/admin?id=2");
    }

    @RequestMapping(value = "/saveRoute")
    public ModelAndView saveRoute(){


        return  new ModelAndView("redirect:/admin?id=0");
    }

    @RequestMapping(value = "/addStop")
    public ModelAndView addStation(){

        return new ModelAndView("redirect:/admin?id=3");
    }

    @RequestMapping(value = "/saveStop")
    public ModelAndView saveStation(@RequestParam("stop") String stop){
        BusStop busStop = new BusStop();
        busStop.setStopName(stop);
        busStopService.saveStop(busStop);
        JOptionPane.showMessageDialog(null,"Stop Successfully Created");
        return  new ModelAndView("redirect:/admin?id=0");
    }


}
