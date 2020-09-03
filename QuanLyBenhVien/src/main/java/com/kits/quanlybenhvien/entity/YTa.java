package com.kits.quanlybenhvien.entity;

import com.sun.istack.internal.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class YTa {
    @Id
    private String maYTa;
    @NotNull
    private String CMT;
    @NotNull
    private String tenYTa;
    @NotNull
    private Date DOB;
    @NotNull
    private String diaChi;
    @NotNull
    private int thamNien;
    @NotNull
    private String trinhDo;
    @NotNull
    private String SDT;
}
