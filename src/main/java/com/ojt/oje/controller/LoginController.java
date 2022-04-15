package com.ojt.oje.controller;

import com.ojt.oje.VO.userinfoVO;
import com.ojt.oje.serv.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
@RequestMapping(value = "/login")
public class LoginController {
    @Autowired
    private ILoginService iLoginServ;

    @RequestMapping(value = "/")
    public String index(){
        return "/login";
    }

    @RequestMapping(value = "/login")
    public String home(){
        return "/login";
    }

    @RequestMapping(value = "/loginProc")
    public String loginProc(Model model, userinfoVO info, HttpServletResponse response) throws IOException {
        System.out.println(info.getId());

        boolean isSuccess = iLoginServ.loginProc(info);
        if(isSuccess){
            alert(response, "로그인성공");
            model.addAttribute("id", info.getId());
            return "/index";
        }else {
            alert(response, "로그인실패");
            return "/login";
        }
    }

    private static void alert(HttpServletResponse response, String msg) throws IOException {
        init(response);
        PrintWriter out = response.getWriter();
        out.println("<script>alert('" + msg + "');</script> ");
        out.flush();
    }

    private static void init(HttpServletResponse response) {
        response.setContentType("text/html; charset=euc-kr");
        response.setCharacterEncoding("euc-kr");
    }

}
