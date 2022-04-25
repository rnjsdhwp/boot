package com.ojt.oje.controller;

import com.ojt.oje.VO.boardVO;
import com.ojt.oje.VO.replyVO;
import com.ojt.oje.serv.IBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value = "/board")
public class BoardController {
    @Autowired
    private IBoardService iBoardServ;
    final int BOARD_LIST_CNT = 6;
    final int REPLY_LIST_CNT = 4;
    final int BLOCK_CNT = 3;

    @RequestMapping(value = "/")
    public String index(){
        return "redirect:/board/boardProc";
    }

    @RequestMapping(value = "/boardProc")
    public String boardProc(Model model, HttpSession session, HttpServletRequest req){
        if(!isLogin(session)){
            return "/redirect";
        }

        paging(model, req, -1, BOARD_LIST_CNT);

        return "/board";
    }

    @RequestMapping(value = "/write")
    public String write(HttpSession session){
        if(!isLogin(session)){
            return "/redirect";
        }

        return "/write";
    }

    @RequestMapping(value = "/writeProc")
    public String writeProc(boardVO boardVO,
                            HttpSession session){
        if(!isLogin(session)){
            return "/redirect";
        }

        iBoardServ.insertBoard(boardVO);

        return "redirect:/board/boardProc";
    }

    @RequestMapping(value = "/read")
    public String read(Model model, boardVO boardVO,
                       HttpSession session, HttpServletRequest req){
        if(!isLogin(session)){
            return "/redirect";
        }

        int wno = boardVO.getWno();
        paging(model, req, wno, REPLY_LIST_CNT);

        List<boardVO> boardlst = iBoardServ.selectBoard(wno);
        model.addAttribute("boardlst", boardlst);

        iBoardServ.hitsBoard(boardVO.getWno());

        return "read";
    }

    @RequestMapping(value = "/reply")
    public String reply(Model model, boardVO boardVO, HttpSession session, HttpServletRequest req){
        if(!isLogin(session)){
            return "/redirect";
        }

        int cPage = Integer.parseInt(req.getParameter("cPage"));
        int cBlock = Integer.parseInt(req.getParameter("cBlock"));
        model.addAttribute("cPage", cPage);
        model.addAttribute("cBlock", cBlock);

        int wno = boardVO.getWno();
        List<boardVO> lst = iBoardServ.selectBoard(wno);
        model.addAttribute("boardlst", lst);

        return "reply";
    }

    @RequestMapping(value = "/replyProc")
    public String replyPoc(replyVO replyVO,
                           RedirectAttributes re,
                           HttpSession session,
                           HttpServletRequest req){
        if(!isLogin(session)){
            return "/redirect";
        }

        String id = (String) session.getAttribute("id");
        replyVO.setId(id);
        iBoardServ.insertReply(replyVO);

        int cPage = Integer.parseInt(req.getParameter("cPage"));
        int cBlock = Integer.parseInt(req.getParameter("cBlock"));
        re.addAttribute("cPage", cPage);
        re.addAttribute("cBlock", cBlock);
        re.addAttribute("wno", replyVO.getWno());

        return "redirect:/board/read";
    }

    private boolean isLogin(HttpSession session){
        String id = (String) session.getAttribute("id");
        if(id == null || id.isEmpty()){
            return false;
        }
        return true;
    }

    private Model paging(Model model, HttpServletRequest req, int wno, int list_cnt){
        int totalCnt = -1;
        int totalPageCnt = -1;
        int totalPageBlock = -1;

        int cPage = -1;
        int cBlock = -1;
        int cPage_reply = -1;
        int cBlock_reply = -1;

        //totalCnt
        if(wno == -1){
            totalCnt = iBoardServ.countBoard();
        }else{
            totalCnt = iBoardServ.countReply(wno);
        }

        //totalPageCnt
        if((totalCnt%list_cnt) == 0){
            totalPageCnt = totalCnt/list_cnt;
        }else{
            totalPageCnt = totalCnt/list_cnt + 1;
        }

        //totalPageBlock
        if((totalPageCnt%BLOCK_CNT) == 0) {
            totalPageBlock = totalPageCnt/BLOCK_CNT;
        }else{
            totalPageBlock = totalPageCnt/BLOCK_CNT + 1;
        }

        //cPage
        if(req.getParameter("cPage") == null || req.getParameter("cPage").isEmpty()){
            cPage=1;
        }else{
            cPage = Integer.parseInt(req.getParameter("cPage"));
        }

        //cBlock
        if(req.getParameter("cBlock") == null || req.getParameter("cBlock").isEmpty()){
            cBlock=1;
        }else{
            cBlock = Integer.parseInt(req.getParameter("cBlock"));
        }

        //cPage_reply
        if(req.getParameter("cPage_reply") == null || req.getParameter("cPage_reply").isEmpty()){
            cPage_reply=1;
        }else{
            cPage_reply = Integer.parseInt(req.getParameter("cPage_reply"));
        }

        //cBlock_reply
        if(req.getParameter("cBlock_reply") == null || req.getParameter("cBlock_reply").isEmpty()){
            cBlock_reply=1;
        }else{
            cBlock_reply = Integer.parseInt(req.getParameter("cBlock_reply"));
        }

        if(wno == -1){
            checking(model, wno, list_cnt, cPage, cBlock, totalPageBlock, totalPageCnt);
        }else{
            checking(model, wno, list_cnt, cPage_reply, cBlock_reply, totalPageBlock, totalPageCnt);
        }

        model.addAttribute("cPage", cPage);
        model.addAttribute("cBlock", cBlock);
        model.addAttribute("cPage_reply", cPage_reply);
        model.addAttribute("cBlock_reply", cBlock_reply);
        model.addAttribute("totalPageBlock", totalPageBlock);

        return model;
    }

    private Model checking(Model model, int wno, int list_cnt, int cPage, int cBlock, int totalPageBlock, int totalPageCnt) {
        List lst = null;
        int start = list_cnt*(cPage-1);
        int end = list_cnt;
        int start_block = cBlock*BLOCK_CNT-2;
        int end_block = -1;

        if(cBlock==totalPageBlock) {
            end_block = totalPageCnt;
        }else{
            end_block = cBlock * BLOCK_CNT;
        }
        model.addAttribute("start_block", start_block);
        model.addAttribute("end_block", end_block);

        if(wno == -1){
            lst = iBoardServ.selectBoards(start, end);
            model.addAttribute("boardlst", lst);
        }else{
            lst = iBoardServ.selectReply(wno, start, end);
            model.addAttribute("replylst", lst);
        }

        return model;
    }
}
