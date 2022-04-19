package com.ojt.oje.controller;

import com.ojt.oje.VO.boardVO;
import com.ojt.oje.VO.replyVO;
import com.ojt.oje.serv.IBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Controller
@RequestMapping(value = "/board")
public class BoardController {
    @Autowired
    private IBoardService iBoardServ;

    @RequestMapping(value = "/boardProc")
    public String boardProc(Model model, HttpSession session){
        if(!isLogin(session)){
            return "/redirect";
        }

        List<boardVO> lst = iBoardServ.selectBoards();
        model.addAttribute("lst", lst);

        return "/board";
    }

    @RequestMapping(value = "/write")
    public String write(Model model, HttpSession session){
        if(!isLogin(session)){
            return "/redirect";
        }

        return "/write";
    }

    @RequestMapping(value = "/writeProc")
    public String writeProc(Model model, boardVO boardVO, HttpSession session){
        if(!isLogin(session)){
            return "/redirect";
        }

        iBoardServ.insertBoard(boardVO);

        return "redirect:/board/boardProc";
    }

    @RequestMapping(value = "/read")
    public String read(Model model, boardVO boardVO, HttpSession session){
        if(!isLogin(session)){
            return "/redirect";
        }

        int rownum = boardVO.getRownum();
        int wno = boardVO.getWno();

        List<boardVO> boardlst = iBoardServ.selectBoard(rownum);
        model.addAttribute("boardlst", boardlst);

        List<replyVO> replylst = iBoardServ.selectReply(wno);
        model.addAttribute("replylst", replylst);

        return "read";
    }

    @RequestMapping(value = "/reply")
    public String reply(Model model, boardVO boardVO, HttpSession session){
        if(!isLogin(session)){
            return "/redirect";
        }

        int rownum = boardVO.getRownum();
        List<boardVO> lst = iBoardServ.selectBoard(rownum);
        model.addAttribute("lst", lst);

        return "reply";
    }

    @RequestMapping(value = "/replyProc")
    public String replyPoc(Model model,
                           replyVO replyVO,
                           boardVO boardVO,
                           RedirectAttributes re,
                           HttpSession session){
        if(!isLogin(session)){
            return "/redirect";
        }
        iBoardServ.insertReply(replyVO);

        re.addAttribute("rownum", boardVO.getRownum());
        re.addAttribute("wno", boardVO.getWno());

        return "redirect:/board/read";
    }

    private boolean isLogin(HttpSession session){
        String id = (String) session.getAttribute("id");
        if(id == null || id.isEmpty()){
            return false;
        }
        return true;
    }

}
