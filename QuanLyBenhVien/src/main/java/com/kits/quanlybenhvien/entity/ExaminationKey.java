package com.kits.quanlybenhvien.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ExaminationKey implements Serializable {
    @Column(name = "ID_Examination")
    Integer ID_Examination;
    @Column(name = "ID_DoctorExamination")
    String ID_DoctorExamination;
    @Column(name = " ID_Patient")
    String ID_Patient;
}
