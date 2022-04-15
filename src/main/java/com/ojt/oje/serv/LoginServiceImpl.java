package com.ojt.oje.serv;

import com.ojt.oje.DAO.LoginDAO;
import com.ojt.oje.VO.userinfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements ILoginService{
    @Autowired
    private LoginDAO dao;

    @Override
    public boolean loginProc(userinfoVO info) {
        int loginSuccess = dao.loginProc(info);

        if(loginSuccess == 1)   return true;
        else return false;
    }
}
