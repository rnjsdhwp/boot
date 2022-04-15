package com.ojt.oje.serv;

import com.ojt.oje.DAO.RegistDAO;
import com.ojt.oje.VO.userinfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistServiceImpl implements IRegistService {
    @Autowired
    private RegistDAO dao;

    @Override
    public void insertUser(userinfoVO info) {
        dao.insertUser(info);
    }

    @Override
    public int chkID(String userid) {
        return isExistID(userid);
        //System.out.println(isExistID(userid));
    }

    private int isExistID(String userid) {
        return dao.isExistID(userid);
    }
}
