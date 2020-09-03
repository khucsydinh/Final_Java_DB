package com.kits.quanlybenhvien.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor(force = true)
public class Kham {
    private Integer maBK;
    private String maBSKham;
    private String maBN;
    private Date thoigian;
}
