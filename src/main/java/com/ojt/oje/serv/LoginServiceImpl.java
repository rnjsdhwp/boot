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
    public String loginProc(userinfoVO info) {
        int chkIDNum = dao.chkID(info);

        if(chkIDNum == 1){
            int chkAccNum = dao.chkAccount(info);
            if(chkAccNum == 1){
                return "isLoginSuccess_true";
            }else{
                return "isLoginSuccess_noPW";
            }
        }else{
            return "isLoginSuccess_noID";
        }
    }
}
