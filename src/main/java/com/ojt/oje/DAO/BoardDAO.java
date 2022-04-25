package com.ojt.oje.DAO;

import com.ojt.oje.VO.boardVO;
import com.ojt.oje.VO.replyVO;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface BoardDAO {
    List<boardVO> selectBoards(int start_board, int end_board);
    List<boardVO> selectBoard(int wno);
    void insertBoard(boardVO boardVO);
    int countReply(int wno);
    List<replyVO> selectReply(int wno, int start_reply, int end_reply);
    void insertReply(replyVO replyVO);
    int countBoard();
    void hitsBoard(int wno);
    void board_replyCnt(int wno);
}
