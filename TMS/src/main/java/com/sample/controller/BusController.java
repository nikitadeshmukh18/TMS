package com.sample.controller;

import com.sample.model.*;
import com.sample.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

        List<Bus> buses = busService.getAllBuses();
        map.addAttribute("buses",buses);

        List<User> conductors = userService.getConductors();
        map.addAttribute("conductors",conductors);

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
                                @RequestParam("timehr") String timehr,
                                @RequestParam("timemin") String timemin,
                                ModelMap modelMap) {


        String time=timehr.concat(":".concat(timemin));

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


    @RequestMapping(value = "/editBus")
    public ModelAndView editBus(){
        return new ModelAndView("redirect:/admin?id=4");
    }

    @RequestMapping(value = "/updateBus")
    public ModelAndView saveUpdate(@RequestParam("bus") String busNo,ModelMap map){

        System.out.println("busNO----------"+busNo);

        int bus_no = Integer.parseInt(busNo);
        Bus bus = busService.getBus(bus_no);
        int routeId = bus.getRouteId();
        Path path = routeService.getRouteFor(routeId);
        map.addAttribute("bus",bus);
        map.addAttribute("path",path);
        List<Path> routes = routeService.getAllRoutes();
        map.addAttribute("routes", routes);


        return new ModelAndView("updateBus");
    }


    @RequestMapping(value = "saveUpdate" , method = RequestMethod.POST)
    public void saveUpdate(@RequestParam("busNo") String busNo,
                           @RequestParam("busSource") String src ,
                           @RequestParam("busDestination") String destination,
                           @RequestParam("startTime") String startTime,@RequestParam("route") String route){



        Bus bus = new Bus();

        bus.setBusNo(Integer.parseInt(busNo));
        bus.setBusSource(src);
        bus.setBusDestination(destination);
        StringTokenizer st = new StringTokenizer(route, ":");

        int id = Integer.parseInt(st.nextToken());
        bus.setRouteId(id);

        bus.setStartTime(startTime);

        try{
            busService.updateBus(bus);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error During Update");

        }
        JOptionPane.showMessageDialog(null, "Bus Successfully updated");

    }
    @RequestMapping(value = "/deleteBus")
    public ModelAndView deleteBus() {

        return new ModelAndView("redirect:/admin?id=5");
    }

    @RequestMapping(value = "/removeBus")
    public ModelAndView removeBus(@RequestParam("bus") String busNo) {

        Bus bus = new Bus();
        bus.setBusNo(Integer.parseInt(busNo));
        busService.delete(bus);
        JOptionPane.showMessageDialog(null, "Bus Successfully Deleted");
        return new ModelAndView("redirect:/admin?id=0");
    }

    @RequestMapping(value = "/displayBuses")
    public ModelAndView displayAll(ModelMap map){
        return new ModelAndView("redirect:/admin?id=17",map);
    }







}
