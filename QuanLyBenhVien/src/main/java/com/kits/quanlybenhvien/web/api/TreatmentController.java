package com.kits.quanlybenhvien.web.api;


import com.kits.quanlybenhvien.entity.Med;
import com.kits.quanlybenhvien.entity.Service;
import com.kits.quanlybenhvien.entity.Treatment;
import com.kits.quanlybenhvien.entity.TreatmentKey;

import com.kits.quanlybenhvien.repository.TreatmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/treatment", produces = "application/json")
@CrossOrigin(value = "*")
public class TreatmentController {
    private TreatmentRepository treatmentRepository;
    @Autowired
    public TreatmentController(TreatmentRepository treatmentRepository){
        this.treatmentRepository = treatmentRepository;
    }
    @GetMapping
    public Iterable<Treatment> getAlltreatment(){
        return treatmentRepository.findAll();
    }
    @GetMapping("/{id}")
    public Treatment TreatmentById(@PathVariable(value = "id", required = false) Integer id,
                                   @PathVariable(value = "id", required = false) Integer id2,
                                   @PathVariable(value = "id", required = false) String id3,
                                   @PathVariable(value = "id", required = false) String id4,
                                   @PathVariable(value = "id", required = false) String id5,
                                   @PathVariable(value = "id", required = false) String id6,
                                   @PathVariable(value = "id", required = false) String id7){
        TreatmentKey treatmentKey = new TreatmentKey();
        treatmentKey.setID_Treatment(id);
        treatmentKey.setIDExamination(id2);
        treatmentKey.setNameDisease(id3);
        treatmentKey.setID_DoctorExamination(id4);
        treatmentKey.setID_DoctorCure(id5);
        treatmentKey.setIDPatient(id6);
        treatmentKey.setID_Nurse(id7);

        Optional<Treatment> optionalTreatment = treatmentRepository.findById(treatmentKey);
        if(optionalTreatment.isPresent()){
            return optionalTreatment.get();
        }
        return null;
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Treatment saveTreatment(@RequestBody Treatment treatment){
        return treatmentRepository.save(treatment);
    }
}
