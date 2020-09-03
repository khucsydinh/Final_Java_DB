package com.kits.quanlybenhvien.entity;

import com.sun.istack.internal.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import java.util.Collection;
import java.util.Date;

@Data
@NoArgsConstructor(force = true)
public class BenhNhan {
    private String maBN;
    private String CMT;
    private String tenBN;
    private Date DOB;
    private String diaChi;
    private String SDT;
}
