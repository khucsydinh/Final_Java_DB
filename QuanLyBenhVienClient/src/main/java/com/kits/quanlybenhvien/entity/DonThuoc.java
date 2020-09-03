package com.kits.quanlybenhvien.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(force = true)
public class DonThuoc {
    private String maDonThuoc;
    private String tenDichVu;
}
