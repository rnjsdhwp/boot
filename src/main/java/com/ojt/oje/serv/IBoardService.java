package com.ojt.oje.serv;

import com.ojt.oje.VO.boardVO;
import java.util.List;

public interface IBoardService {
    List<boardVO> selectBoards();
    List<boardVO> selectBoard(int rownum);
    List<boardVO> selectReply(int wno);
    void insertBoard(boardVO boardVO);
}
