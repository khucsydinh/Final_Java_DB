package com.kits.quanlybenhvien.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor(force = true)
public class Examination {
    Integer ID_Examination;
    String ID_DoctorExamination;
    String ID_Patient;
    private Date atTime;
}
