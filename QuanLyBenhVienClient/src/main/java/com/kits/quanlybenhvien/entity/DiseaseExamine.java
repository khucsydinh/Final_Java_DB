package com.kits.quanlybenhvien.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor(force = true)
public class DiseaseExamine  {
    Integer ID_Examination;
    String ID_DoctorExamination;
    String ID_Patient;
    String nameDisease;
}
