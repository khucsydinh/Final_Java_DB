package com.kits.quanlybenhvien.web.api;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.hateoas.server.EntityLinks;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.kits.quanlybenhvien.entity.BenhNhan;
import com.kits.quanlybenhvien.repository.BenhNhanRepository;

@RestController
@RequestMapping(path = "/BenhNhans", produces = "application/json")//produces: trả về kết quả dạng Json
@CrossOrigin(origins = "*")//cho phép gọi API từ máy chủ khác localhost
public class BenhNhanController {
    private BenhNhanRepository benhNhanRepo;
    @Autowired
    //EntityLinks entityLinks;
    public BenhNhanController(BenhNhanRepository benhNhanRepo) {
        this.benhNhanRepo = benhNhanRepo;
    }
    @GetMapping
    public Iterable<BenhNhan> getAllBenhNhans() {
        return benhNhanRepo.findAll();
    }

    /*@PathVarialble(“id”) cho biết id sẽ lấy từ đường dẫn
    và sau đó được sử dụng trong phương thức như một tham số
     */
    //tìm kiếm theo id
    @GetMapping("/{id}")
    public BenhNhan BenhNhanById(@PathVariable("id") String id) {
        Optional<BenhNhan> optBenhNhan = benhNhanRepo.findById(id);
        if (optBenhNhan.isPresent()) {
            return optBenhNhan.get();
        }
        return null;
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") String id){
        try {
            benhNhanRepo.deleteById(id);
        }catch(EmptyResultDataAccessException e){
        }
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public BenhNhan postBenhNhan(@RequestBody BenhNhan BenhNhan) {
        return benhNhanRepo.save(BenhNhan);
    }
}
