package com.kits.quanlybenhvien.web;

import com.kits.quanlybenhvien.entity.Med;
import com.kits.quanlybenhvien.entity.Service;
import com.kits.quanlybenhvien.entity.Treatment;

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
@RequestMapping(path = "/treatment")
public class TreatmentController {
    private RestTemplate rest = new RestTemplate();

    @GetMapping
    public String informationTreatment(Model model){
        List<Treatment> treatments = Arrays.asList(rest.getForObject("http://localhost:8081/treatment",Treatment[].class));
        model.addAttribute("treatments",treatments);
        return "informationTreatment";
    }
    @GetMapping("/add")
    public String addTreatment(Model model){
        model.addAttribute("treatment",new Treatment());
        return "formAddTreatment";
    }
    @PostMapping
    public String addTreatment(@RequestParam(value = "IDExamination",required = false) int IDExamination,
                               @RequestParam(value = "Name_Disease",required = false)String nameDisease,
                               @RequestParam(value = "ID_DoctorExamination",required = false)String ID_DoctorExamination,
                               @RequestParam(value = "ID_DoctorCure",required = false)String ID_DoctorCure,
                               @RequestParam(value = "IDPatient",required = false)String IDPatient,
                               @RequestParam(value = "ID_Nurse",required = false)String ID_Nurse,
                               @RequestParam(value = "medList",required = false)List<Med> medList,
                               @RequestParam(value = "serviceList",required = false)List<Service> serviceList,
                               @RequestParam(value = "atTime",required = false)Date atTime,
                               @RequestParam(value = "status",required = false)boolean status){
        Treatment treatment = new Treatment();
        treatment.setIDExamination(IDExamination);
        treatment.setNameDisease(nameDisease);
        treatment.setID_DoctorExamination(ID_DoctorExamination);
        treatment.setID_DoctorCure(ID_DoctorCure);
        treatment.setIDPatient(IDPatient);
        treatment.setID_Nurse(ID_Nurse);
        treatment.setMedList(medList);
        treatment.setServiceList(serviceList);
        treatment.setAtTime(atTime);
        treatment.setStatus(status);

        log.info("New"+treatment);
        rest.postForObject("http://localhost:8081/treatment",treatment,Treatment.class);
        return "redirect:/treatment";
    }

    @GetMapping("/edit/{id}/{id2}/{id3}/{id4}/{id5}/{id6}/{id7}/{id8}/{id9}/{id10}")
    public String editTreatment(@PathVariable(value = "id",required = false) int id,
                                @PathVariable(value = "id2",required = false) String id2,
                                @PathVariable(value = "id3",required = false) String id3,
                                @PathVariable(value = "id4",required = false) String id4,
                                @PathVariable(value = "id5",required = false) String id5,
                                @PathVariable(value = "id6",required = false) String id6,
                                @PathVariable(value = "id7",required = false) List<Med> id7,
                                @PathVariable(value = "id8",required = false) List<Service> id8,
                                @PathVariable(value = "id9",required = false) Date id9,
                                @PathVariable(value = "id10",required = false) boolean id10,
                                Model model){
        Treatment treatment = rest.getForObject("http://localhost:8081/treatment/{id}/{id2}/{id3}/{id4}/{id5}/{id6}/{id7}/{id8}/{id9}/{id10}",Treatment.class,id,id2,id3,id4,id5,id6,id7,id8,id9,id10);
        model.addAttribute("treatment",treatment);
        return "formAddTreatment";
    }
    @GetMapping("/search")
    public String search(@RequestParam(value = "id",required = false) String id,Model model){
        Treatment treatment = rest.getForObject("http://localhost:8081/treatment/{id}", Treatment.class,id);
        model.addAttribute("treatment",treatment);
        return "informationTreatment";
    }
}
