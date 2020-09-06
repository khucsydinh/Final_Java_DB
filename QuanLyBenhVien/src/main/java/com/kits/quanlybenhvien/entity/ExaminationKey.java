package com.kits.quanlybenhvien.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

//@Embeddable
public class ExaminationKey implements Serializable {
    Integer IDExamination;
    String ID_DoctorExamination;
    String IDPatient;
}
