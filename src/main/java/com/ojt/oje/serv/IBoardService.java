package com.ojt.oje.serv;

import com.ojt.oje.VO.boardVO;
import com.ojt.oje.VO.replyVO;

import java.util.List;

public interface IBoardService {
    List<boardVO> selectBoards();
    List<boardVO> selectBoard(int rownum);
    List<replyVO> selectReply(int wno);
    void insertBoard(boardVO boardVO);

    void insertReply(replyVO replyVO);
}
