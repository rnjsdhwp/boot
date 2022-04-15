package com.ojt.oje.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;

@RestController
public class MainController {
    @RequestMapping(value = "/")
    public ModelAndView index(){
        ModelAndView mav = new ModelAndView("index");
        return mav;
    }
    @RequestMapping(value = "/home")
    public ModelAndView home(){
        ModelAndView mav = new ModelAndView("index");
        return mav;
    }

    @RequestMapping(value = "/login")
    public ModelAndView login(HttpServletRequest req){
        ModelAndView mav = new ModelAndView("login");
        mav.addObject("name", req.getParameter("name"));

        return mav;
    }

    @RequestMapping(value = "/regist")
    public ModelAndView regist(HttpServletRequest req){
        ModelAndView mav = new ModelAndView("regist");
        return mav;
    }

    @RequestMapping(value = "/board")
    public ModelAndView board(HttpServletRequest req){
        ModelAndView mav = new ModelAndView("board");
        return mav;
    }

    @RequestMapping(value = "/write")
    public ModelAndView write(HttpServletRequest req){
        ModelAndView mav = new ModelAndView("write");
        return mav;
    }

}
