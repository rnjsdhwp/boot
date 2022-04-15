package com.ojt.oje.DAO;

import com.ojt.oje.VO.boardVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardDAO {
    List<boardVO> selectBoard();
}
