package com.kits.quanlybenhvien.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Data
@Entity
@RequiredArgsConstructor
public class DiseaseExamine {
    @EmbeddedId
    private DiseaseExamineKey id;
}
