package com.ojt.oje.serv;

import com.ojt.oje.DAO.BoardDAO;
import com.ojt.oje.VO.boardVO;
import com.ojt.oje.VO.replyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class BoardServiceImpl implements IBoardService{
    @Autowired
    private BoardDAO dao;

    @Override
    public List<boardVO> selectBoards(int start_board, int end_board) {
        return dao.selectBoards(start_board, end_board);
    }

    @Override
    public List<boardVO> selectBoard(int wno) {
        return dao.selectBoard(wno);
    }

    @Override
    public List<replyVO> selectReply(int wno, int start_reply, int end_reply) {
        int rowcnt = countReply(wno);

        if(rowcnt == 0){
            return null;
        }else{
            return dao.selectReply(wno, start_reply, end_reply);
        }
    }

    @Override
    public void insertBoard(boardVO boardVO) {
        boardVO.setWdate(dateformat());
        boardVO.setHits(0);

        dao.insertBoard(boardVO);
    }

    @Override
    public void insertReply(replyVO replyVO) {
        replyVO.setRdate(dateformat());

        dao.insertReply(replyVO);
        dao.board_replyCnt(replyVO.getWno());
    }

    private String dateformat(){
        Date now = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(now);
    }

    @Override
    public int countBoard() {
        return dao.countBoard();
    }

    @Override
    public int countReply(int wno) {
        return dao.countReply(wno);
    }

    @Override
    public void hitsBoard(int wno) {
        dao.hitsBoard(wno);
    }
}
