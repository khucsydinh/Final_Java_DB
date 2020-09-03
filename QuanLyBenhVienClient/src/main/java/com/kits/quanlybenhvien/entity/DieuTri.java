package com.kits.quanlybenhvien.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor(force = true)
public class DieuTri {
    private Integer maDieuTri;
    private Integer maBk;
    private String tenBenh;
    private String maBSKham;
    private String maBSDieuTri;
    private String maBN;
    private String maYTa;
    private String maDonThuoc;
    private String maDicVu;
    private Date thoiGian;
    private boolean trangThai;
}
