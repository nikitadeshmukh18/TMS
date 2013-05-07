package com.sample.controller;

import com.sample.model.Conductor;
import com.sample.service.ConductorService;
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
public class ConductorController {


    private ConductorService service;

    public ConductorController() {
    }

    @Autowired
    public ConductorController(ConductorService service) {
        this.service = service;
    }

    @RequestMapping("/addConductor")
    public ModelAndView addConductor(){
        return new ModelAndView("redirect:/admin?id=8");
    }

    @RequestMapping("/saveConductor")
    public ModelAndView saveConductor(@RequestParam("CName") String name){

        Conductor conductor = new Conductor();
        conductor.setName(name);
        System.out.println("--------------save conduc  " + name);
        service.saveConductor(conductor);


        JOptionPane.showMessageDialog(null," Conductor Successfully Added");
        return new ModelAndView("redirect:/admin?id=0");
    }

    @RequestMapping("/deleteConductor")
    public ModelAndView deleteConductor(){
        return new ModelAndView("redirect:/admin?id=9");
    }

    @RequestMapping("/removeConductor")
    public ModelAndView remConductor(@RequestParam("conductor") String conductor){
        Conductor c = new Conductor();
        c.setId(Integer.parseInt(conductor));
        service.remove(c);
        JOptionPane.showMessageDialog(null,"Conductor Deleted Succesfully");
        return new ModelAndView("redirect:/admin?id=0");
    }



}
