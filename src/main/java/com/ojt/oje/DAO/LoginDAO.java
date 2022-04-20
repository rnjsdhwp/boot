package com.ojt.oje.DAO;

import com.ojt.oje.VO.userinfoVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginDAO {
    int chkID(userinfoVO info);

    int chkAccount(userinfoVO info);
}
