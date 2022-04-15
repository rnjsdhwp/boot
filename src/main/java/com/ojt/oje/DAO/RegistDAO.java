package com.ojt.oje.DAO;

import com.ojt.oje.VO.userinfoVO;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface RegistDAO {
    void insertUser(userinfoVO info);

    int isExistID(String userid);
}
