package com.kits.quanlybenhvien.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;


@Data
@NoArgsConstructor(force = true)
public class DichVu {
    private String tenDichVu;
    private float gia;
}
