package com.kits.quanlybenhvien.web;

import com.kits.quanlybenhvien.entity.Patient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import com.kits.quanlybenhvien.entity.Patient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/patient")
public class PatientController {

    private RestTemplate rest = new RestTemplate();
    @GetMapping()
    public String InformationPatient(Model model){
        //Sử dụng phương thức getForObject(url, class) để gọi API.
        // Phương thức sẽ tự động gọi API, lấy kết quả, chuyển đổi thành mảng các đối tượng
        List<Patient> patients = Arrays.asList(rest.getForObject("http://localhost:8081/patient",Patient[].class));
        System.out.println(patients);
        model.addAttribute("patients",patients);
        return "informationPatient";
    }
    @GetMapping("/add")
    public String addpatient(Model model){
        model.addAttribute("patient", new Patient());
        return "formAddPatient";
    }

    @PostMapping()
    public String processDesign(@RequestParam(value = "id",required = false) String id , @RequestParam(value = "identity",required = false) String identity, @RequestParam(value = "name",required = false) String name, @RequestParam(value = "dob",required = false) Date dob , @RequestParam(value = "address",required = false) String address, @RequestParam(value = "phone",required = false) String phone) {
        Patient patient = new Patient();
        patient.setID_Patient(id);
        patient.setNamePatient(name);
        patient.setIdentityNumber(identity);
        patient.setAddress(address);
        patient.setDOB(dob);
        patient.setPhone(phone);
        log.info("New "+ patient);
        //Đối tượng Taco được tạo ra sẽ dùng cho postForObject()
        //nhằm thêm vào CSDL để gửi tới POST API
        rest.postForObject("http://localhost:8081/patient", patient, Patient.class);
        return "redirect:/patient";
    }

    @GetMapping("/delete/{id}")
    public String deletePatient(@PathVariable("id")String id, Model model) {
        rest.delete("http://localhost:8081/patient/delete/{id}",id);
        List<Patient> patients = Arrays.asList(rest.getForObject("http://localhost:8081/patient",Patient[].class));
        System.out.println(patients);
        model.addAttribute("patients",patients);
        return "informationPatient";
    }

    @GetMapping("/edit/{id}")
    public String editPatient(@PathVariable("id")String id,Model model){
        Patient patient = rest.getForObject("http://localhost:8081/patient/{id}",Patient.class,id);
        model.addAttribute("patient",patient);
        return "formAddPatient";
    }
    @GetMapping("search")
    public String search(@RequestParam("id") String id,Model model){
        Patient patient = rest.getForObject("http://localhost:8081/patient/{id}",Patient.class,id);
        model.addAttribute("patients",patient);
        return "informationPatient";
    }

}
