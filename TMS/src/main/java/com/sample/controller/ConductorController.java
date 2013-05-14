package com.sample.controller;

import com.sample.model.Bus;
import com.sample.model.Conductor;
import com.sample.model.Path;
import com.sample.service.ConductorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.swing.*;
import java.util.List;
import java.util.StringTokenizer;

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

    @RequestMapping(value = "/editConductor")
    public ModelAndView editConductor(){
        return new ModelAndView("redirect:/admin?id=10");
    }

    @RequestMapping(value = "/updateConductor")
    public ModelAndView saveUpdate(@RequestParam("c") String condId,ModelMap map){

        int id = Integer.parseInt(condId);
        Conductor conductor = service.getConductor(id);
        map.addAttribute("conductor", conductor);

        return new ModelAndView("updateConductor");
    }

    @RequestMapping(value = "saveUpdateConductor" , method = RequestMethod.POST)
    public void saveUpdate(@RequestParam("cid") String cid,
                           @RequestParam("name") String name){



        Conductor conductor = new Conductor();
        conductor.setId(Integer.parseInt(cid));
        conductor.setName(name);

        try{
            service.update(conductor);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error During Update");

        }
        JOptionPane.showMessageDialog(null, "Conductor Successfully updated");

    }


}
