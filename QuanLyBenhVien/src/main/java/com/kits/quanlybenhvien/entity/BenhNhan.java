package com.kits.quanlybenhvien.entity;

import com.sun.istack.internal.NotNull;
import com.sun.javafx.beans.IDProperty;
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
public class BenhNhan {
    @Id
    private String maBN;
    @NotNull
    private String CMT;
    @NotNull
    private String tenBN;
    @NotNull
    private Date DOB;
    @NotNull
    private String diaChi;
    @NotNull
    private String SDT;
}
