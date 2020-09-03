package com.kits.quanlybenhvien.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;

@Embeddable
public class DonDichVuKey {
    @Column(name = "MaDonDV")
    String maDonDV;
    @Column(name = "TenDichVu")
    String tenDichVu;
}
