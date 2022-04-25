package com.ojt.oje.VO;

import lombok.Data;

@Data
public class boardVO extends userinfoVO{
    private int rownum;
    private int wno;
    private String title;
    private String wdate;
    private int hits;
    private String contents;
    private int rcount;
}
