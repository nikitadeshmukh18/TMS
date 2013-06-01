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
    private BusService busService;

    public RouteController()
    {

    }
    @Autowired
    public RouteController(RouteService routeService,BusStopService busStopService, BusService busService)
    {

        this.routeService=routeService;
        this.busStopService=busStopService;
        this.busService = busService;
    }

    @RequestMapping(value = "/newRoute")
    public ModelAndView newRoute(ModelMap map) {

        int route_no=routeService.getNewRouteID();
        System.out.println(route_no);


        List<BusStop> busStops = busStopService.getRouteStops(route_no);
        map.addAttribute("busStops", busStops);
        map.addAttribute("routeId",route_no);
        map.addAttribute("current","1");
        return new ModelAndView("route",map);
    }

    @RequestMapping(value = "/route")
    public String route() {
        return ("route");
    }



    @RequestMapping(value = "/addRoute")
    public ModelAndView addRoute(){

        return new ModelAndView("redirect:/admin?id=2");
    }



    @RequestMapping(value = "/saveRoute")
    public ModelAndView saveRoute(@RequestParam("routeId") String routeId,@RequestParam("busStops") String stop_id,
                                  @RequestParam("current") String stop_index,@RequestParam("timing") String timeTaken,ModelMap map) {

        try
        {
        System.out.println("RouteId:"+routeId);
        System.out.println("StopId:"+stop_id);
        System.out.println("Current stop index:"+stop_index);
        System.out.println("Timing:"+timeTaken);

        BusRoute busRoute=new BusRoute();
        busRoute.setRouteId(Integer.parseInt(routeId));
        busRoute.setStopIndex(Integer.parseInt(stop_index));


        StringTokenizer st = new StringTokenizer(stop_id, ":");

        int id = Integer.parseInt(st.nextToken());
        System.out.println("ID:"+id);

        busRoute.setStopId(id);
        busRoute.setTimeTaken(timeTaken);
        System.out.println(busRoute.getRouteId());
        routeService.saveRoute(busRoute);

        System.out.print("-------------Till This Fine---------------------");
        List<BusStop> busStops = busStopService.getRouteStops(Integer.parseInt(routeId));

        map.addAttribute("busStops", busStops);
        map.addAttribute("route_no",routeId);
        map.addAttribute("current",Integer.parseInt(stop_index)+1);

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

            return new ModelAndView("route",map);



    }

    @RequestMapping(value = "/deleteRoute")
    public ModelAndView deleteRoute() {


        return new ModelAndView("redirect:/admin?id=11");
    }


    @RequestMapping(value = "/removeRoute")
    public ModelAndView removeRoute(ModelMap map,@RequestParam("routeSelect") int route) {

        if(busService.getRouteBusCount(route)>0)
        {
            JOptionPane.showMessageDialog(null, "Bus Count : " + busService.getRouteBusCount(route));
            List<Bus> busList=busService.getBusesByRoute(route);

            Iterator it=busList.listIterator();
            while (it.hasNext())
            {
                JOptionPane.showMessageDialog(null,it.next());
            }
            map.addAttribute("route",route);
            map.addAttribute("busList",busList);

            return new ModelAndView("removeRoute");
        }

        BusRoute busRoute=new BusRoute();
        busRoute.setRouteId(route);
        routeService.delete(busRoute);
        JOptionPane.showMessageDialog(null,"Route Deleted Successfully");
        return new ModelAndView("redirect:/admin?id=0");
    }


    @RequestMapping(value = "/modifyRoute")
    public ModelAndView modifyRoute() {


        return new ModelAndView("redirect:/admin?id=14");
    }

    @RequestMapping(value = "/updateRoute")
    public ModelAndView updateRoute(ModelMap modelMap,@RequestParam("route") String route)
    {
        int routeId = Integer.parseInt(route);
        List<BusStop> busStopsList = busStopService.getRouteStops(routeId);

        List<Integer> routeIndices = routeService.getStopIndices(routeId);
        List<RouteStops> routeStopsList = new ArrayList<RouteStops>();
        Iterator it = routeIndices.iterator();
        int index =1;
        while (it.hasNext())
        {
            RouteStops st = new RouteStops();
            st.setStopIndex(index++);
            st.setStopName(busStopService.getStopWith((Integer) it.next()));



            routeStopsList.add(st);

            //JOptionPane.showMessageDialog(null,st.getStopName() + st.getStopIndex());
        }




        modelMap.addAttribute("busStops",busStopsList);
        modelMap.addAttribute("routeStops",routeStopsList);
        modelMap.addAttribute("route",route);
        return new ModelAndView("/updateRoute");
    }



    @RequestMapping(value = "/deleteRouteStop")
    public ModelAndView deleteRouteStop(ModelMap modelMap,@RequestParam("route") String route,@RequestParam("stopIndex") String stopIndex)
    {
        int routeId = Integer.parseInt(route);
        int stop_index=Integer.parseInt(stopIndex);
        routeService.deleteRouteStop(routeId,stop_index);
        modelMap.addAttribute("route",routeId);
        return new ModelAndView("redirect:/admin/updateRoute");
    }

    @RequestMapping(value = "/insertRouteStops")
    public ModelAndView insertRouteStops(ModelMap modelMap,@RequestParam("route") String route,@RequestParam("stop_index") String stopIndex,@RequestParam("bus_stop") String bus_stop,@RequestParam("stop_time") String stop_time)
    {

        StringTokenizer st = new StringTokenizer(bus_stop, ":");

        String str=st.nextToken();
        str.trim();
        int stop_id = Integer.parseInt(str);
        System.out.println("ID:"+stop_id);
        int routeId = Integer.parseInt(route);
        int stop_index=Integer.parseInt(stopIndex);

        int maxstopindex=routeService.getRouteStopIndexCount(routeId);
        //JOptionPane.showMessageDialog(null,route+stopIndex+bus_stop);
        if(stop_index<=1)
            stop_index=1;
        if(stop_index>=maxstopindex+1)
        {
            stop_index=maxstopindex+1;
            BusRoute busRoute=new BusRoute();
            busRoute.setRouteId(routeId);
            busRoute.setStopIndex(stop_index);
            busRoute.setStopId(stop_id);
            busRoute.setTimeTaken(stop_time);
            routeService.saveRoute(busRoute);
        }
        else
        {
            routeService.insertStopInRoute(routeId,stop_index,stop_id,stop_time);

        }

       JOptionPane.showMessageDialog(null,"Stop Added in Route..!!");
        modelMap.addAttribute("route",routeId);
        return new ModelAndView("redirect:/admin/updateRoute");

    }





}