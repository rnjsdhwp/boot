package com.ojt.oje.controller;

import com.ojt.oje.VO.boardVO;
import com.ojt.oje.serv.IBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;

@Controller
@RequestMapping(value = "/board")
public class BoardController {
    @Autowired
    private IBoardService iBoardServ;

    @RequestMapping(value = "/boardProc")
    public String boardProc(Model model, boardVO boardVO){
        List<boardVO> lst = iBoardServ.selectBoards();

        model.addAttribute("id", boardVO.getId());
        model.addAttribute("lst", lst);

        return "/board";
    }

    @RequestMapping(value = "/write")
    public String write(Model model, boardVO boardVO){
        model.addAttribute("id", boardVO.getId());

        return "/write";
    }

    @RequestMapping(value = "/writeProc")
    public String writeProc(Model model, boardVO boardVO, RedirectAttributes re){
        iBoardServ.insertBoard(boardVO);

        re.addAttribute("id", boardVO.getId());

        //return "forward:/board/boardProc";
        return "redirect:/board/boardProc";
    }

    @RequestMapping(value = "/read")
    public String read(Model model, boardVO boardVO){
        int rownum = boardVO.getRownum();
        int wno = boardVO.getWno();

        List<boardVO> boardlst = iBoardServ.selectBoard(rownum);
        model.addAttribute("boardlst", boardlst);

        //SELECT COUNT(*) FROM reply AS r, question_test AS q WHERE q.wno=8 AND r.wno=q.wno
        //값이 있을때 selectReply()
        List<boardVO> replylst = iBoardServ.selectReply(wno);
        model.addAttribute("replylst", replylst);

        return "read";
    }

    @RequestMapping(value = "/reply")
    public String reply(Model model, boardVO boardVO){
        int rownum = boardVO.getRownum();
        List<boardVO> lst = iBoardServ.selectBoard(rownum);
        model.addAttribute("lst", lst);

        return "reply";
    }

    @RequestMapping(value = "/replyPoc")
    public String replyPoc(Model model, boardVO boardVO){


        return "reply";
    }
}
