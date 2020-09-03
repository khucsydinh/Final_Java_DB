package com.kits.quanlybenhvien.entity;
import com.sun.istack.internal.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;
import java.util.Date;

@Data
@Entity
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class BacSi {
    @Id
    private String maBS;

    @NotNull
    private String CMT;
    @NotNull
    private String tenBS;
    @NotNull
    private Date DOB;
    @NotNull
    private String diaChi;
    @NotNull
    private int thamNien;
    @NotNull
    private String trinhDo;
    @NotNull
    private String chuyenMon;
    @NotNull
    private String bacNghe;

    @OneToMany(mappedBy = "maBSKham")
    private Collection <Kham> khams;
}
