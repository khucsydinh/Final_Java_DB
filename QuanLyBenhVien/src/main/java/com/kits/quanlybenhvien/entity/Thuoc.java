package com.kits.quanlybenhvien.entity;

import com.sun.istack.internal.NotNull;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class Thuoc {
    @Id
    private String tenThuoc;
    @NonNull
    private float gia;
    @NotNull
    private String suDung;

}
