package com.kits.quanlybenhvien.web;

import com.kits.quanlybenhvien.entity.Doctor;
import com.kits.quanlybenhvien.entity.Nurse;
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
@RequestMapping("/nurse")
public class NurseController {
    private RestTemplate rest = new RestTemplate();

    @GetMapping
    public String NurseInfo(Model model) {
        List<Nurse> nurses = Arrays.asList(rest.getForObject("http://localhost:8081/nurse", Nurse[].class));
        System.out.println(nurses);
        model.addAttribute("nurses", nurses);
        return "informationNurse";
    }

    @GetMapping("/add")
    public String addNurse(Model model) {
        model.addAttribute("nurse", new Nurse());
        return "formAddNurse";
    }

    @PostMapping
    public String processNurse(@RequestParam(value = "ID_Nurse",required = false) String id ,
                               @RequestParam(value = "identityNumber", required = false) String identity,
                               @RequestParam(value = "nameNurse", required = false) String name,
                               @RequestParam(value = "DOB",required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date dob ,
                               @RequestParam(value = "address",required = false) String address,
                               @RequestParam(value = "exp",required = false) int exp,
                               @RequestParam(value = "diploma",required = false) String diploma ,
                               @RequestParam(value = "phone",required = false) String phone) {
        System.out.println(id);
        Nurse nurse = new Nurse();
        nurse.setID_Nurse(id);
        nurse.setIdentityNumber(identity);
        nurse.setNameNurse(name);
        nurse.setDOB(dob);
        nurse.setAddress(address);
        nurse.setExp(exp);
        nurse.setDiploma(diploma);
        nurse.setPhone(phone);
        log.info("New "+ nurse);
        rest.postForObject("http://localhost:8081/nurse", nurse, Nurse.class);
        return "redirect:/nurse";
    }
    @GetMapping("/delete/{id}")
    public String deleteNurse(@PathVariable("id")String id, Model model) {
        try{
            rest.delete("http://localhost:8081/nurse/delete/{ID_Nurse}",id);
        }catch (Exception e){
            model.addAttribute("warning","Cannot delete! This doctor is currently in examination");
        }

        List<Nurse> nurses = Arrays.asList(rest.getForObject("http://localhost:8081/nurse",Nurse[].class));
        System.out.println(nurses);
        model.addAttribute("nurses",nurses);
        return "informationNurse";
    }
    @GetMapping("/edit/{id}")
    public String editNurse(@PathVariable(value = "id",required = false)String id,Model model){
        Nurse nurse = rest.getForObject("http://localhost:8081/nurse/{id}",Nurse.class,id);
        model.addAttribute("nurse",nurse);
        return "formAddNurse";
    }
    @PostMapping("/search")
    public String search(@RequestParam(value = "id",required = false) String id,Model model){
        Nurse nurse = rest.getForObject("http://localhost:8081/nurse/{id}", Nurse.class,id);
        model.addAttribute("nurse",nurse);
        return "informationNurse";
    }

}
