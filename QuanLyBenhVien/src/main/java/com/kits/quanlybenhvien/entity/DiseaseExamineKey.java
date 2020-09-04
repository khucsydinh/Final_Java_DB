package com.kits.quanlybenhvien.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import java.io.Serializable;

@Embeddable
public class DiseaseExamineKey implements Serializable {
    @Column(name = "ID_Examination")
    String ID_Examination;
    @Column(name = "ID_DoctorExamination")
    String ID_DoctorExamination;
    @Column(name = "ID_Patient")
    String ID_Patient;
    @Column(name = "Name_Disease")
    String nameDisease;
}
