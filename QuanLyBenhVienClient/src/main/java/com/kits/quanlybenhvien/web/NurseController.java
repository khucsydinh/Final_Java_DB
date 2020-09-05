package com.kits.quanlybenhvien.web;

import com.kits.quanlybenhvien.entity.Nurse;
import lombok.extern.slf4j.Slf4j;
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
    public String processDesign(@RequestParam("id") String id,
                                @RequestParam("identity") String identity,
                                @RequestParam("name") String name,
                                @RequestParam("dob") Date dob,
                                @RequestParam("address") String address,
                                @RequestParam("exp") int exp,
                                @RequestParam("diploma") String diploma,
                                @RequestParam("phone") String phone) {
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

}
