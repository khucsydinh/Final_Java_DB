package com.kits.quanlybenhvien.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;

@Embeddable
public class DieuTriKey {
    @Column(name = "MaDieuTri")
    Integer maDieuTri;
    @Column(name = "MaBK")
    Integer maBK;
    @Column(name = "TenBenh")
    String tenBenh;
    @Column(name = "MaBSKham")
    String maBSKham;
    @Column(name = "MaBSDieuTri")
    String maBSDIeuTri;
    @Column(name = "MaBN")
    String MaBN;
    @Column(name = "MaYTa")
    String maYTa;
    @Column(name = "MaDonThuoc")
    String maDonThuoc;
    @Column(name = "MaDonDichVu")
    String maDonDichVu;
}
