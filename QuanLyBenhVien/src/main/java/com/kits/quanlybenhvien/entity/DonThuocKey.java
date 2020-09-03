package com.kits.quanlybenhvien.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class DonThuocKey {
    @Column(name = "TenThuoc")
    String tenThuoc;
    @Column(name = "MaDonThuoc")
    String maDonThuoc;
}
