package com.kits.quanlybenhvien.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.util.Date;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class DieuTri {
    @EmbeddedId
    private DieuTriKey id;

    private Date thoiGian;
    private boolean trangThai;
}
