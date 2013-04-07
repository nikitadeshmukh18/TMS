package com.sample.controller;

import com.sample.model.*;
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

public class RouteController {

    private RouteService routeService;
    private BusStopService busStopService;
    public RouteController()
    {

    }
    @Autowired
    public RouteController(RouteService routeService,BusStopService busStopService)
    {

        this.routeService=routeService;
        this.busStopService=busStopService;
    }

    @RequestMapping(value = "/newRoute")
    public ModelAndView newRoute(ModelMap map) {

        int route_no=routeService.getNewRouteID();
        System.out.println(route_no);


        List<BusStop> busStops = busStopService.getRouteStops(route_no);
        map.addAttribute("busStops", busStops);
        map.addAttribute("route_no",route_no);
        map.addAttribute("current","1");
        return new ModelAndView("route",map);
    }

    @RequestMapping(value = "/route")
    public String login() {
        return ("route");
    }



    @RequestMapping(value = "/saveRoute")
    public ModelAndView saveRoute(@RequestParam("route_no") String route_no,@RequestParam("busStops") String stop_id,
                                  @RequestParam("current") String stop_index,@RequestParam("timming") String timeTaken,ModelMap map) {

        try
        {
        System.out.println("Route No:"+route_no);
        System.out.println("Bus No:"+stop_id);
        System.out.println("Current:"+stop_index);
        System.out.println("Timming:"+timeTaken);

        BusRoute busRoute=new BusRoute();
        busRoute.setRouteId(Integer.parseInt(route_no));
        busRoute.setStopIndex(Integer.parseInt(stop_index));


        StringTokenizer st = new StringTokenizer(stop_id, ":");

        int id = Integer.parseInt(st.nextToken());
        System.out.println("ID:"+id);

        busRoute.setStopId(id);
        busRoute.setTimeTaken(timeTaken);
        System.out.println(busRoute.getRouteId());
        routeService.saveRoute(busRoute);

        System.out.print("-------------Till This Fine---------------------");
        List<BusStop> busStops = busStopService.getRouteStops(Integer.parseInt(route_no));

        map.addAttribute("busStops", busStops);
        map.addAttribute("route_no",route_no);
        map.addAttribute("current",Integer.parseInt(stop_index)+1);

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

            return new ModelAndView("route",map);



    }


}