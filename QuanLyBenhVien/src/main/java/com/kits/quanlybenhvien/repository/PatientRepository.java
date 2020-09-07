package com.kits.quanlybenhvien.repository;

import org.springframework.data.repository.CrudRepository;
import com.kits.quanlybenhvien.entity.Patient;

public interface PatientRepository extends CrudRepository<Patient,String> {
}

