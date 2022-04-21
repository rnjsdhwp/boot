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
        List<boardVO> lst = dao.selectBoards(start_board, end_board);
        return lst;
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
        String formatNow = dateformat();

        boardVO.setWdate(formatNow);
        boardVO.setHits(0);

        dao.insertBoard(boardVO);
    }

    @Override
    public void insertReply(replyVO replyVO) {
        String formatNow = dateformat();

        replyVO.setRdate(formatNow);

        dao.insertReply(replyVO);
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
}
