package com.kits.quanlybenhvien.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@NoArgsConstructor(force = true)
public class YTa {

    private String maYTa;
    private String CMT;
    private String tenYTa;
    private Date DOB;
    private String diaChi;
    private int thamNien;
    private String trinhDo;
    private String SDT;
}
