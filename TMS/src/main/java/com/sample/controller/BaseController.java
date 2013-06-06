package com.sample.controller;


import com.sample.model.Bus;
import com.sample.model.BusStop;
import com.sample.model.SearchResult;
import com.sample.service.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;


@Controller
@Transactional
@SessionAttributes("username")
@RequestMapping("/")
public class BaseController {
    private UserService userService;
    private LoginService loginService;
    private BusStopService busStopService;
    private BusService busService;
    private ConductorService conductorService;

    private RouteService routeService;
    private SearchService searchService;


    public BaseController() {
    }

    @Autowired



    public BaseController(UserService userService, LoginService loginService,BusStopService busStopService,
                          BusService busService, RouteService routeService,ConductorService conductorService,
                          SearchService searchService  ) {
        this.userService = userService;
        this.loginService = loginService;
        this.busStopService=busStopService;
        this.busService = busService;
        this.routeService = routeService;
        this.conductorService=conductorService;
        this.searchService = searchService;


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


    @RequestMapping(value = "/search")

    public ModelAndView search(ModelMap map, @ModelAttribute("search") String search, @ModelAttribute("bus_src") String busSrc,
                               @ModelAttribute("bus_d")String busDestination) {

            try
        {
       List<BusStop> busStops = busStopService.getAllStops();
        map.addAttribute("busStops", busStops);
        }
        catch (Exception e)
        {
            System.out.println("Error is " + e.toString());

        }

        try{
            if (search.equals("1")){
                List<SearchResult> results =  searchService.getSearchResults(busSrc, busDestination);
                map.addAttribute("results", results);
                map.addAttribute("source", busSrc);
                map.addAttribute("destination" , busDestination);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return new ModelAndView("search", map);

    }


    @RequestMapping(value = "/search.do")
    public ModelAndView searchBuses(@RequestParam("bus_src") String busSrc,
                                 @RequestParam("bus_destination") String busDestination, ModelMap map){

        System.out.println("-------------------in search.do-------------------");
        map.addAttribute("bus_src",busSrc);
        map.addAttribute("bus_d",busDestination);
        return  new ModelAndView("redirect:search?search=1",map);

    }


    @RequestMapping(value = "/logout")
    public ModelAndView logout() {


        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/chome")
    public ModelAndView chome(ModelMap map) {

        try
        {
           List <Bus> busList = busService.getAllBuses();

            map.addAttribute("busList", busList);
        }
        catch (Exception e)
        {
            System.out.println("Error is " + e.toString());

        }
        return new ModelAndView("chome", map);
    }

    @RequestMapping(value = "/chome.do", method = RequestMethod.GET)
    public ModelAndView conductorNext(@RequestParam("bus_id") String bus_id,
                                      ModelMap modelMap) {


        try
        {
        System.out.println(bus_id);

        StringTokenizer st = new StringTokenizer(bus_id, ":");
        int id = Integer.parseInt(st.nextToken());
        StringTokenizer st1 = new StringTokenizer(st.nextToken().toString(), "-");
        String bus_src=st1.nextToken().toString();
            System.out.println(bus_src);
        System.out.println(id);
        int route_no=busService.getRouteNoForBus(id);
        System.out.println(route_no);
        int total=2;
             total=routeService.getStopCount(route_no);

            conductorService.delayhandling(id,routeService.getStopId(1,route_no));
            modelMap.addAttribute("bus_no",id);
            modelMap.addAttribute("route_no",route_no);
            modelMap.addAttribute("current","1");
            modelMap.addAttribute("total",total);
            modelMap.addAttribute("current_stop",bus_src);
            return new ModelAndView("redirect:cbusselect" );
        }
        catch(Exception e)
        {
            e.printStackTrace();

        }

        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/cbusselect")
    public String cbusselect() {
        return ("cbusselect");
    }




    @RequestMapping(value = "/cbusselect.do", method = RequestMethod.GET)
    public ModelAndView docbusselect(@RequestParam("bus_no") String bus_no,@RequestParam("route_no") String route_no,
                                     @RequestParam("current") String current,@RequestParam("total") String total,
                                      ModelMap modelMap) {


        try
        {

            System.out.println(bus_no + " " + route_no + " " + current + " " + total);
            int id=Integer.parseInt(bus_no);

            int next;


            next=routeService.getStopForRoute(Integer.parseInt(route_no), Integer.parseInt(current) + 1);
             String bus_src=busStopService.getStopWith(next);



           conductorService.delayhandling(id,routeService.getStopId(Integer.parseInt(current)+1,Integer.parseInt(route_no)));

            modelMap.addAttribute("bus_no",id);
            modelMap.addAttribute("route_no",route_no);
            modelMap.addAttribute("current",Integer.parseInt(current)+1);
            modelMap.addAttribute("total",total);
            modelMap.addAttribute("current_stop",bus_src);
            return new ModelAndView("redirect:cbusselect" );
        }
        catch(Exception e)
        {
            e.printStackTrace();

        }

        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/deleteRunningBus", method = RequestMethod.GET)
    public ModelAndView deleteRunningBus(@RequestParam("bus_no") String bus_no,ModelMap map)
    {
        conductorService.deleteRunningBus(Integer.parseInt(bus_no));
        return new ModelAndView("redirect:/chome");
    }

}
