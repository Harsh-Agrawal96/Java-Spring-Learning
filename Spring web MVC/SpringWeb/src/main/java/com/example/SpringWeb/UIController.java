package com.example.SpringWeb;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class UIController implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse res){

        String path = req.getServletPath();

        switch (path){
            case "/add" : return add(req);
            case "/addAlien" : return addAlien(req);
            default: return home();
        }
    }

    private static ModelAndView home(){
        System.out.println("calling new home controller");
        return new ModelAndView("index");
    }

    private static ModelAndView add(HttpServletRequest req){
        int num1 = Integer.parseInt(req.getParameter("num1"));
        int num2 = Integer.parseInt(req.getParameter("num2"));

        int result = num1 + num2;

        ModelAndView mv = new ModelAndView("result");
        mv.addObject("result", result);

        return mv;
    }

    private static ModelAndView addAlien(HttpServletRequest req){
        int aid = Integer.parseInt(req.getParameter("aid"));
        String aname = req.getParameter("aname");

        Alien alien = new Alien();
        alien.setAid(aid);
        alien.setAname(aname);

        ModelAndView mv = new ModelAndView("result");
        mv.addObject("alienData", alien);

        return mv;
    }

    @ModelAttribute("course")
    public String courseName(){
        return "Java";
    }
}
