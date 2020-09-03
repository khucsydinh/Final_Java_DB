package com.kits.quanlybenhvien.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;

@Embeddable
public class KhamBenhKey {
    @Column(name = "MaBK")
    String MaBK;
    @Column(name = "MaBSKham")
    String maBSKham;
    @Column(name = "MaBN")
    String maBN;
    @Column(name = "tenBenh")
    String tenBenh;
}
