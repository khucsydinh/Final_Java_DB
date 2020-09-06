package com.kits.quanlybenhvien.web;

import com.kits.quanlybenhvien.entity.DiseaseExamine;

import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Slf4j
@Controller
@RequestMapping(path = "/diseaseExamine")
public class DiseaseExamineController {
    private RestTemplate rest = new RestTemplate();

    @GetMapping
    public String informationDiseaseExamine(Model model){
        List<DiseaseExamine> diseaseExamines = Arrays.asList(rest.getForObject("http://localhost:8081/diseaseExamine",DiseaseExamine[].class));
        model.addAttribute("diseaseExamines",diseaseExamines);
        return "informationDiseaseExamine";
    }
    @GetMapping("/add")
    public String addDiseaseExamine(Model model){
        model.addAttribute("diseaseExamine",new DiseaseExamine());
        return "formAddDiseaseExamine";
    }
    @PostMapping
    public String addDiseaseExamine(@RequestParam(value = "IDExamination",required = false) int IDExamination,
                                    @RequestParam(value = "ID_DoctorExamination",required = false)String ID_DoctorExamination,
                                    @RequestParam(value = "IDPatient",required = false)String IDPatient,
                                    @RequestParam(value = "nameDisease",required = false)String nameDisease){
        DiseaseExamine diseaseExamine = new DiseaseExamine();
        diseaseExamine.setID_Examination(IDExamination);
        diseaseExamine.setID_DoctorExamination(ID_DoctorExamination);
        diseaseExamine.setID_Patient(IDPatient);
        diseaseExamine.setNameDisease(nameDisease);

        log.info("New"+diseaseExamine);
        rest.postForObject("http://localhost:8081/diseaseExamine",diseaseExamine,DiseaseExamine.class);
        return "redirect:/diseaseExamine";
    }
    @GetMapping("/delete/{id}")
    public String deleteDiseaseExamine(@PathVariable(value = "id",required = false) String id,Model model){
        rest.delete("http://localhost:8081/diseaseExamine/delete/{id}",id);
        List<DiseaseExamine> diseaseExamines = Arrays.asList(rest.getForObject("http://localhost:8081/diseaseExamine",DiseaseExamine[].class));
        model.addAttribute("diseaseExamines",diseaseExamines);
        return "informationDiseaseExamine";
    }
    @GetMapping("/edit/{id}")
    public String editDiseaseExamine(@PathVariable(value = "id",required = false)String id,Model model){
        DiseaseExamine diseaseExamine = rest.getForObject("http://localhost:8081/diseaseExamine/{id}",DiseaseExamine.class,id);
        model.addAttribute("diseaseExamine",diseaseExamine);
        return "formAddDiseaseExamine";
    }
    @GetMapping("/search")
    public String search(@RequestParam(value = "id",required = false) String id,Model model){
        DiseaseExamine diseaseExamine = rest.getForObject("http://localhost:8081/diseaseExamine/{id}", DiseaseExamine.class,id);
        model.addAttribute("diseaseExamine",diseaseExamine);
        return "informationDiseaseExamine";
    }
}
