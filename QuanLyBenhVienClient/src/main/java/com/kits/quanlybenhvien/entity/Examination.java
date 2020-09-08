package com.kits.quanlybenhvien.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor(force = true)
public class Examination{
    Integer IDExamination;
    String ID_DoctorExamination;
    String IDPatient;
    private String atTime;
}
