package com.kits.quanlybenhvien.entity;

import lombok.*;


@Data
@NoArgsConstructor(force = true)
public class Med {
    private String nameMed;
    private float price;
    private String usedFor;

}
