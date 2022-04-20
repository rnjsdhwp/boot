package com.ojt.oje.controller;

import com.ojt.oje.serv.IRegistService;
import com.ojt.oje.VO.userinfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/regist")
public class RegistController {
    @Autowired
    private IRegistService iRegistServ;

    @RequestMapping(value = "/")
    public String index(){
        return "/regist";
    }

    @RequestMapping(value = "/registuser", method = RequestMethod.POST)
    public String registuser(userinfoVO info, HttpServletRequest req){
        String email = req.getParameter("email");
        String email2 = req.getParameter("email2");
        info.setEmail(email+"@"+email2);

        iRegistServ.insertUser(info);

        return "redirect:/home";
    }

    @RequestMapping(value = "/chkID")
    public String chkID(Model model, HttpServletRequest req){
        String id = req.getParameter("id");
        int num = iRegistServ.chkID(id);

        if(num == 0) {   model.addAttribute("data", "isExistID_false");}
        else{            model.addAttribute("data", "isExistID_true");}

        return "/chkID";
    }


}
