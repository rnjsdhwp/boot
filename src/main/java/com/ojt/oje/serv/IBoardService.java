package com.ojt.oje.serv;

import com.ojt.oje.VO.boardVO;
import com.ojt.oje.VO.replyVO;
import java.util.List;

public interface IBoardService {
    List<boardVO> selectBoards(int start_board, int end_board);
    List<boardVO> selectBoard(int rownum);
    List<replyVO> selectReply(int wno, int start_reply, int end_reply);
    void insertBoard(boardVO boardVO);
    void insertReply(replyVO replyVO);
    int countBoard();
    int countReply(int wno);
    void hitsBoard(int wno);
}
