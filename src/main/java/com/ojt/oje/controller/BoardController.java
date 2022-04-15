package com.ojt.oje.controller;

import com.ojt.oje.VO.boardVO;
import com.ojt.oje.serv.IBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
@RequestMapping(value = "/board")
public class BoardController {
    @Autowired
    private IBoardService iBoardServ;

    @RequestMapping(value = "/boardProc")
    public String boardProc(Model model){
        List<boardVO> lst = iBoardServ.selectBoard();
        model.addAttribute("lst", lst);
        return "/board";
    }
}
