package com.sample.controller;

import com.sample.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@Transactional
@RequestMapping("/admin")

public class BusController {

    private BusService busService;

    public BusController() {

    }

    @Autowired
    public BusController(BusService busService) {
        this.busService = busService;
    }

    @RequestMapping(value = "/addBus")
    public ModelAndView addBus(ModelMap modelMap){
        int id=1;
        modelMap.addAttribute("id",id);

        return new ModelAndView("redirect:/admin",modelMap);
    }

}
