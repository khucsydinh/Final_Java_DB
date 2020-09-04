package com.kits.quanlybenhvien.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import java.io.Serializable;

@Embeddable
public class TreatmentKey implements Serializable {
    @Column(name = "ID_Treatment")
    Integer ID_Treatment;
    @Column(name = "ID_Examination")
    Integer ID_Examination;
    @Column(name = "Name_Disease")
    String Name_Disease;
    @Column(name = "ID_DoctorExamination")
    String ID_DoctorExamination;
    @Column(name = "ID_DoctorCure")
    String ID_DoctorCure;
    @Column(name = "ID_Patient")
    String ID_Patient;
    @Column(name = "ID_Nurse")
    String ID_Nurse;
    @Column(name = "ID_MedList")
    String ID_MedList;
    @Column(name = "ID_ServiceList")
    String ID_ServiceList;
}
