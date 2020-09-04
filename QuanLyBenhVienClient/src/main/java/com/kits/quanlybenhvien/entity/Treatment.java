package com.kits.quanlybenhvien.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor(force = true)
public class Treatment {

    private Integer ID_Treatment;
    private Integer ID_Examination;
    private String Name_Disease;
    private String ID_DoctorExamination;
    private String ID_DoctorCure;
    private String ID_Patient;
    private String ID_Nurse;

    private Date time;
    private boolean status;

}
