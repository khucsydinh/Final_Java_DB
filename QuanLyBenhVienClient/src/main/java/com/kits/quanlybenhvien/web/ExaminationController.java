package com.kits.quanlybenhvien.web;

import com.kits.quanlybenhvien.entity.Examination;

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
@RequestMapping(path = "/examination")
public class ExaminationController {
    private RestTemplate rest = new RestTemplate();

    @GetMapping
    public String informationExamination(Model model){
        List<Examination> examinations = Arrays.asList(rest.getForObject("http://localhost:8081/examination",Examination[].class));
        model.addAttribute("examinations",examinations);

        return "informationExamination";
    }
    @GetMapping("/add")
    public String addExamination(Model model){
        model.addAttribute("examination",new Examination());
        return "formAddExamination";
    }
    @PostMapping
    public String addExamination(@RequestParam(value = "ID_DoctorExamination",required = false)String ID_DoctorExamination,
                                 @RequestParam(value = "IDPatient",required = false)String IDPatient,
                                 @RequestParam(value = "atTime",required = false) String atTime){
        Examination examination = new Examination();
        examination.setID_DoctorExamination(ID_DoctorExamination);
        examination.setIDPatient(IDPatient);
        examination.setAtTime(atTime);

        log.info("New"+examination);
        rest.postForObject("http://localhost:8081/examination",examination,Examination.class);
        return "redirect:/examination";
    }
    @GetMapping("/delete/{id}/{id2}/{id3}")
    public String deleteExamination(@PathVariable(value = "id",required = false) Integer id,
                                    @PathVariable(value = "id2",required = false) String id2,
                                    @PathVariable(value = "id3",required = false) String id3,
                                    Model model){
        rest.delete("http://localhost:8081/examination/delete/{id}/{id2}/{id3}",id,id2,id3);
        List<Examination> examinations = Arrays.asList(rest.getForObject("http://localhost:8081/examination",Examination[].class));
        model.addAttribute("examinations",examinations);
        return "informationExamination";
    }
    @GetMapping("/edit/{id}/{id2}/{id3}")
    public String editExamination(@PathVariable(value = "id",required = false) Integer id,
                                  @PathVariable(value = "id2",required = false) String id2,
                                  @PathVariable(value = "id3",required = false) String id3,
                                  Model model){
        Examination examination = rest.getForObject("http://localhost:8081/examination/edit/{id}/{id2}/{id3}",Examination.class,id,id2,id3);
        model.addAttribute("examination",examination);

        return "formUpdateExamination";
    }
    @PostMapping("/edit/{id}/{id2}/{id3}")
    public String updateExamination( @PathVariable(value = "id",required = false) Integer id,
                                     @PathVariable(value = "id2",required = false) String id2,
                                     @PathVariable(value = "id3",required = false) String id3,Examination examination){
        examination.setIDExamination(id);
        examination.setID_DoctorExamination(id2);
        examination.setIDPatient(id3);
        rest.postForObject("http://localhost:8081/examination",examination,Examination.class);

        return "redirect:/examination";
    }
    @GetMapping("/search")
    public String search(@RequestParam(value = "id",required = false) int id,Model model){
        Examination examination = rest.getForObject("http://localhost:8081/examination/{id}", Examination.class,id);
        model.addAttribute("examination",examination);
        return "informationExamination";
    }
}
