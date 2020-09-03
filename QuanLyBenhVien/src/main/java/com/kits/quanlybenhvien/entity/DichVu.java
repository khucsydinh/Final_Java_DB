package com.kits.quanlybenhvien.entity;

import com.sun.istack.internal.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@RequiredArgsConstructor
@NoArgsConstructor
public class DichVu {
    @Id
    private String tenDichVu;

    @NotNull
    private float gia;
}
