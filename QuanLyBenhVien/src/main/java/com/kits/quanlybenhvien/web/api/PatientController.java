package com.kits.quanlybenhvien.web.api;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.hateoas.server.EntityLinks;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.kits.quanlybenhvien.entity.Patient;
import com.kits.quanlybenhvien.repository.PatientRepository;

@RestController
@RequestMapping(path = "/patient", produces = "application/json")//produces: trả về kết quả dạng Json
@CrossOrigin(origins = "*")//cho phép gọi API từ máy chủ khác localhost
public class PatientController {
    private PatientRepository patientRepo;
    @Autowired
    //EntityLinks entityLinks;
    public PatientController(PatientRepository patientRepo) {
        this.patientRepo = patientRepo;
    }
    @GetMapping
    public Iterable<Patient> getAllpatients() {
        return patientRepo.findAll();
    }

    /*@PathVarialble(“id”) cho biết id sẽ lấy từ đường dẫn
    và sau đó được sử dụng trong phương thức như một tham số
     */
    //tìm kiếm theo id
    @GetMapping("/{id}")
    public Patient PatientById(@PathVariable("id") String id) {
        Optional<Patient> optPatient = patientRepo.findById(id);
        if (optPatient.isPresent()) {
            return optPatient.get();
        }
        return null;

    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") String id){
        try {
            patientRepo.deleteById(id);
        }catch(EmptyResultDataAccessException e){
        }
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Patient postPatient(@RequestBody Patient patient) {
        return patientRepo.save(patient);
    }
}
