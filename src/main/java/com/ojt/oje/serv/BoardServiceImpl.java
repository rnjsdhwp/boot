package com.ojt.oje.serv;

import com.ojt.oje.DAO.BoardDAO;
import com.ojt.oje.VO.boardVO;
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
    public List<boardVO> selectBoards() {
        List<boardVO> lst = dao.selectBoards();
        return lst;
    }

    @Override
    public List<boardVO> selectBoard(int rownum) {
        return dao.selectBoard(rownum);
    }

    @Override
    public List<boardVO> selectReply(int wno) {
        int rowcnt = dao.countReply(wno);

        if(rowcnt == 0){
            return null;
        }else{
            return dao.selectReply(wno);
        }
    }

    @Override
    public void insertBoard(boardVO boardVO) {
        Date now = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formatNow = format.format(now);

        boardVO.setWdate(formatNow);

        boardVO.setHits(0);

        //System.out.println(boardVO.getWdate());
        dao.insertBoard(boardVO);
    }
}
