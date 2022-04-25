package com.ojt.oje.serv;

import com.ojt.oje.VO.userinfoVO;

public interface IRegistService {
    void insertUser(userinfoVO info);
    int chkID(String userid);
}
