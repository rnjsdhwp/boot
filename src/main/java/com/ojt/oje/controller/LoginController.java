package com.ojt.oje.controller;

import com.ojt.oje.VO.userinfoVO;
import com.ojt.oje.serv.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/login")
public class LoginController {
    @Autowired
    private ILoginService iLoginServ;

    @RequestMapping(value = "/")
    public String index(){
        return "/login";
    }

    @RequestMapping(value = "/loginProc")
    public String loginProc(userinfoVO info, Model model){
        String msg = iLoginServ.loginProc(info);
        model.addAttribute("data", msg);

        return "/chkID";
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }

    @RequestMapping(value = "/loginuser")
    public String loginuser(userinfoVO info, HttpServletRequest req){
        HttpSession session = req.getSession();
        session.setAttribute("id", info.getId());

        return "redirect:/home";
    }
}
