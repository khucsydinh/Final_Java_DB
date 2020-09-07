package com.kits.quanlybenhvien.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import java.io.Serializable;

//@Embeddable
@Data
@RequiredArgsConstructor
public class DiseaseExamineKey implements Serializable {
    Integer ID_Examination;
    String ID_DoctorExamination;
    String ID_Patient;
    String nameDisease;
}
