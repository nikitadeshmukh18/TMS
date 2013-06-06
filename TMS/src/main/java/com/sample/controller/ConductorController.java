package com.sample.controller;

import com.sample.model.*;
import com.sample.service.ConductorService;
import com.sample.service.LoginService;
import com.sample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.swing.*;

import java.awt.*;

import java.text.ParseException;

import java.util.List;
import java.util.StringTokenizer;

@Controller
@Transactional
@RequestMapping("/admin")
public class ConductorController {


    private UserService service;
    private LoginService loginService;

    public ConductorController() {
    }

    @Autowired
    public ConductorController(UserService service, LoginService loginService) {
        this.service = service;
        this.loginService = loginService;
    }

    @RequestMapping("/addConductor")
    public ModelAndView addConductor(){
        return new ModelAndView("redirect:/admin?id=8");
    }

    @RequestMapping("/saveConductor")
    public ModelAndView saveConductor(@RequestParam("CName") String name,
                                      @RequestParam("Cusername") String username,
                                      @RequestParam("Cpassword") String password){

         User user = new User();
         user.setName(name);
         user.setUserType(1);
         user.setContact(null);
         service.save(user);

        Login loginCredentials = new Login();
        Long id = service.getUserId(name).getId();
         System.out.println("-----------id=" + id);
         loginCredentials.setUsername(username);
         loginCredentials.setPassword(password);
         loginCredentials.setId(id);

         loginService.saveCredentials(loginCredentials);

        JOptionPane.showMessageDialog(null, " Conductor Successfully Added");
        return new ModelAndView("redirect:/admin?id=0");
    }

    @RequestMapping("/deleteConductor")
    public ModelAndView deleteConductor() throws ParseException {


        return new ModelAndView("redirect:/admin?id=9");
    }
//
    @RequestMapping("/removeConductor")
    public ModelAndView remConductor(@RequestParam("conductor") String conductor){
        User user = new User();
        user.setId(Long.parseLong(conductor));
        service.remove(user);
        Login userCreds = new Login();
        userCreds.setId(Long.parseLong(conductor));
        loginService.remove(userCreds);
        JOptionPane.showMessageDialog(null,"Conductor Deleted Succesfully");
        return new ModelAndView("redirect:/admin?id=0");
    }
//
    @RequestMapping(value = "/editConductor")
    public ModelAndView editConductor(){
        return new ModelAndView("redirect:/admin?id=10");
    }

    @RequestMapping(value = "/updateConductor")
    public ModelAndView saveUpdate(@RequestParam("c") String condId,ModelMap map){

        long id = Long.parseLong(condId);
        User conductor = service.getUser(id);
        map.addAttribute("conductor", conductor);

        Login Cuser = loginService.getUser(id);
        map.addAttribute("Cuser",Cuser);
        return new ModelAndView("updateConductor");
    }
//
    @RequestMapping(value = "saveUpdateConductor" , method = RequestMethod.POST)
    public void saveUpdate(@RequestParam("cid") String cid,
                           @RequestParam("name") String name,
                           @RequestParam("Cusername") String username,
                           @RequestParam("Cpassword") String password){



        User conductor = new User();
        conductor.setId(Long.parseLong(cid));
        conductor.setUserType(1);
        conductor.setName(name);
        conductor.setContact(null);

        Login credentials = new Login();
        credentials.setId(Long.parseLong(cid));
        credentials.setPassword(password);
        credentials.setUsername(username);

        try{
            service.update(conductor);
            System.out.println("Executed user update---------------");


            loginService.updateUserCredentials(credentials);
            System.out.println("Executed user update---------------");
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error During Update");

        }
        JOptionPane.showMessageDialog(null, "Conductor Successfully updated");

    }


}
