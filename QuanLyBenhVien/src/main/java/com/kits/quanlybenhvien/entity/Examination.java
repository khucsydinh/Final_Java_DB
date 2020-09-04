package com.kits.quanlybenhvien.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.util.Date;

@Data
@Entity
@RequiredArgsConstructor
public class Examination {
    @EmbeddedId
    private ExaminationKey id;

    private Date atTime;
}
