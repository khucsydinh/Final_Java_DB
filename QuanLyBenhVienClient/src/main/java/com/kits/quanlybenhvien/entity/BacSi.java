package com.kits.quanlybenhvien.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Collection;
import java.util.Date;

@Data
@NoArgsConstructor( force = true)
public class BacSi {
    private String maBS;

    private String CMT;
    private String tenBS;
    private Date DOB;
    private String diaChi;
    private int thamNien;
    private String trinhDo;
    private String chuyenMon;
    private String bacNghe;
}
