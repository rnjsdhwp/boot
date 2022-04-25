package com.ojt.oje.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {
    @RequestMapping(value = "/")
    public String index(){
        return "/index";
    }
    @RequestMapping(value = "/index")
    public String index1(){
        return "/index";
    }
    @RequestMapping(value = "/home")
    public String home(){
        return "/index";
    }

    @RequestMapping(value = "/login")
    public String login(){
        return "/login";
    }

    @RequestMapping(value = "/regist")
    public String regist(){
        return "/regist";
    }

    @RequestMapping(value = "/board")
    public String board(){
        return "redirect:/board/boardProc";
    }

    @RequestMapping(value = "/write")
    public String write(){
        return "/write";
    }

}
