package com.kits.quanlybenhvien.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.Date;
import java.util.List;

@Entity
@Data
@RequiredArgsConstructor
public class Treatment {
    @EmbeddedId
    private TreatmentKey id;

    @ManyToMany
    List<Med> medList;

    @ManyToMany
    List<Service> serviceList;

    private Date thoiGian;
    private boolean trangThai;
}
