package com.kits.quanlybenhvien.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class DonThuoc {
    @EmbeddedId
    private DonThuocKey id;
}
