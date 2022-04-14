package com.ojt.oje.serv;

import com.ojt.oje.DAO.RegistMapper;
import com.ojt.oje.VO.userinfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RegistServiceImpl implements IRegistService {
    @Autowired
    private RegistMapper map;

    @Override
    public List<userinfoVO> selectTest() {
        return map.selectTest();
    }
}
