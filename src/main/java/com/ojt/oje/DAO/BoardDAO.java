package com.ojt.oje.DAO;

import com.ojt.oje.VO.boardVO;
import com.ojt.oje.VO.replyVO;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface BoardDAO {
    List<boardVO> selectBoards();
    List<boardVO> selectBoard(int rownum);

    void insertBoard(boardVO boardVO);

    int countReply(int wno);

    List<replyVO> selectReply(int wno);

    void insertReply(replyVO replyVO);
}
