package com.ojt.oje.VO;

import lombok.Data;

@Data
public class replyVO extends userinfoVO{
    private int wno;
    private int rno;
    private String rdate;
    private String contents;
}
