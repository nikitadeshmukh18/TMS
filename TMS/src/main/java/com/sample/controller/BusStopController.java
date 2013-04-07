package com.sample.controller;

import com.sample.model.BusStop;
import com.sample.service.BusStopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.swing.*;

@Controller
@Transactional
@RequestMapping("/admin")
public class BusStopController {

    private BusStopService busStopService;

    public BusStopController() {
    }

    @Autowired
    public BusStopController(BusStopService busStopService) {
        this.busStopService = busStopService;
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
        JOptionPane.showMessageDialog(null, "Stop Successfully Created");
        return  new ModelAndView("redirect:/admin?id=0");
    }
}
