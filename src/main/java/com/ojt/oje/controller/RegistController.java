package com.ojt.oje.controller;

import com.ojt.oje.serv.IRegistService;
import com.ojt.oje.VO.userinfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
@RequestMapping(value = "/regist")
public class RegistController {
    @Autowired
    private IRegistService iRegistServ;
    //private int chkIdNum = 0;

    @RequestMapping(value = "/")
    public String index(){
        return "/regist";
    }

    @RequestMapping(value = "/registuser")
    public String registuser(userinfoVO info) throws IOException {
        /*System.out.println(chkIdNum);
        if(chkIdNum==0){
            String msg = "아이디 중복확인을 해주세요.";
            alert(response, msg);
        }*/

        System.out.println(info.getId());
        //iRegistServ.insertUser(info);
        return "redirect:/home";
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

    @RequestMapping(value = "/chkID")
    public String chkID(Model model, HttpServletRequest req){
        //chkIdNum = 1;
        //HttpServletRequest req ===> userinfoVO info 로 변경해서 진행하기
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String pw = req.getParameter("pw");
        String pwchk = req.getParameter("pwchk");
        String email = req.getParameter("email");

        int num = iRegistServ.chkID(id);
        //System.out.println(id);
        if(num == 0)    model.addAttribute("isExistID", "false");
        else            model.addAttribute("isExistID", "true");

        model.addAttribute("id", id);
        model.addAttribute("name", name);
        model.addAttribute("pw", pw);
        model.addAttribute("pwchk", pwchk);
        model.addAttribute("email", email);

        return "/regist";
    }
}
