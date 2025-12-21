package com.example.SpringWeb;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(){
        System.out.println("calling home controller");
        return "index";
    }

    // servlet way of getting data
    @RequestMapping("addUsesessionServletWay")
    public String add(HttpServletRequest req, HttpSession session){

        int num1 = Integer.parseInt(req.getParameter("num1"));
        int num2 = Integer.parseInt(req.getParameter("num2"));
        int result = num1 + num2;
        System.out.println(result);

        session.setAttribute("result", result);

        return "result";
    }

    // spring framework ways
    @RequestMapping("addUseSession")
    public String add(@RequestParam("num1") int num, int num2, HttpSession session){

        int result = num + num2;
        System.out.println(result);

        session.setAttribute("result", result);

        return "result";
    }

    @RequestMapping("addUseModel")
    public String add(@RequestParam("num1") int num, int num2, Model model){

        int result = num + num2;
        System.out.println(result);

        model.addAttribute("result", result);

        return "result";
    }

    @RequestMapping("add")
    public ModelAndView add(@RequestParam("num1") int num, int num2, ModelAndView mv){

        int result = num + num2;
        System.out.println(result);

        mv.addObject("result", result);
        mv.setViewName("result");

        return mv;
    }

    @ModelAttribute("course")
    public String courseName(){
        return "Java";
    }

    @RequestMapping("addAlien")
	public String addAlien(@ModelAttribute("alienData") Alien alien) {
		return "result";
	}

    // don't even need @ModelAttribute
    // if the name of variable is same as name that we are using in result page
    /*
    @RequestMapping("addAlien")
	public String addAlien(Alien alien) {
		return "result";
	}
	*/

}
