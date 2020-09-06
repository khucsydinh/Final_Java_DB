package com.kits.quanlybenhvien.web.api;


import com.kits.quanlybenhvien.entity.Examination;
import com.kits.quanlybenhvien.entity.ExaminationKey;
import com.kits.quanlybenhvien.repository.ExaminationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/examination", produces = "application/json")
@CrossOrigin(value = "*")
public class ExaminationController {
    private ExaminationRepository examinationRepository;
    @Autowired
    public ExaminationController(ExaminationRepository examinationRepository){
        this.examinationRepository = examinationRepository;
    }
    @GetMapping
    public Iterable<Examination> getAllExamination(){
        return examinationRepository.findAll();
    }
    @GetMapping("/{id}")
    public Examination ExaminationById(@PathVariable(value = "id", required = false) ExaminationKey id){
        Optional<Examination> optionalExamination = examinationRepository.findById(id);
        if(optionalExamination.isPresent()){
            return optionalExamination.get();
        }
        return null;
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable(value = "id", required = false) ExaminationKey id){
        try {
            examinationRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){}
    }
    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Examination saveExamination(@RequestBody Examination examination){
        return examinationRepository.save(examination);
    }
}
