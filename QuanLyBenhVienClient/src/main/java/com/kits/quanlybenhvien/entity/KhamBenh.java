package com.kits.quanlybenhvien.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(force = true)
public class KhamBenh {
    private String maBK;
    private String maBSKham;
    private String maBN;
    private String tenBenh;
}
