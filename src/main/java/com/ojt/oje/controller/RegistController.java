package com.ojt.oje.controller;

import com.ojt.oje.serv.IRegistService;
import com.ojt.oje.VO.userinfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@RestController
@RequestMapping(value = "/regist")
public class RegistController {
    @Autowired
    private IRegistService testServ;

    @RequestMapping(value = "/write")
    public ModelAndView test(){
        ModelAndView mav = new ModelAndView("write");

        List<userinfoVO> lst = testServ.selectTest();
        mav.addObject("list", lst);
        return mav;
    }
}
