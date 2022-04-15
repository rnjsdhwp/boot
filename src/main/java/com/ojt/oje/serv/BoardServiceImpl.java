package com.ojt.oje.serv;

import com.ojt.oje.DAO.BoardDAO;
import com.ojt.oje.VO.boardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BoardServiceImpl implements IBoardService{
    @Autowired
    private BoardDAO dao;

    @Override
    public List<boardVO> selectBoard() {
        List<boardVO> lst = dao.selectBoard();
        return lst;
    }
}
