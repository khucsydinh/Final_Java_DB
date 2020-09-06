package com.kits.quanlybenhvien.web.api;


import com.kits.quanlybenhvien.entity.DiseaseExamine;
import com.kits.quanlybenhvien.entity.DiseaseExamineKey;
import com.kits.quanlybenhvien.repository.DiseaseExamineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/diseaseExamine", produces = "application/json")
@CrossOrigin(value = "*")
public class DiseaseExamineController {
    private DiseaseExamineRepository diseaseExamineRepository;
    @Autowired
    public DiseaseExamineController(DiseaseExamineRepository diseaseExamineRepository){
        this.diseaseExamineRepository = diseaseExamineRepository;
    }
    @GetMapping
    public Iterable<DiseaseExamine> getAllDiseaseExamine(){
        return diseaseExamineRepository.findAll();
    }
    @GetMapping("/{id}")
    public DiseaseExamine DiseaseExamineById(@PathVariable(value = "id", required = false) DiseaseExamineKey id){
        Optional<DiseaseExamine> optionalDiseaseExamine = diseaseExamineRepository.findById(id);
        if(optionalDiseaseExamine.isPresent()){
            return optionalDiseaseExamine.get();
        }
        return null;
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable(value = "id", required = false) DiseaseExamineKey id){
        try {
            diseaseExamineRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){}
    }
    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public DiseaseExamine saveDiseaseExamine(@RequestBody DiseaseExamine diseaseExamine){
        return diseaseExamineRepository.save(diseaseExamine);
    }
}
