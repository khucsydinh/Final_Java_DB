package com.kits.quanlybenhvien.web.api;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.hateoas.server.EntityLinks;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.kits.quanlybenhvien.entity.Thuoc;
import com.kits.quanlybenhvien.repository.ThuocRepository;

@RestController
@RequestMapping(path = "/Thuocs", produces = "application/json")//produces: trả về kết quả dạng Json
@CrossOrigin(origins = "*")//cho phép gọi API từ máy chủ khác localhost
public class ThuocController {
    private ThuocRepository thuocRepo;
    @Autowired
    //EntityLinks entityLinks;
    public ThuocController(ThuocRepository thuocRepo) {
        this.thuocRepo = thuocRepo;
    }
    @GetMapping
    public Iterable<Thuoc> getAllThuocs() {
        return thuocRepo.findAll();
    }

    /*@PathVarialble(“id”) cho biết id sẽ lấy từ đường dẫn
    và sau đó được sử dụng trong phương thức như một tham số
     */
    //tìm kiếm theo id
    @GetMapping("/{id}")
    public Thuoc ThuocById(@PathVariable("id") String id) {
        Optional<Thuoc> optThuoc = thuocRepo.findById(id);
        if (optThuoc.isPresent()) {
            return optThuoc.get();
        }
        return null;
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") String id){
        try {
            thuocRepo.deleteById(id);
        }catch(EmptyResultDataAccessException e){
        }
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Thuoc postThuoc(@RequestBody Thuoc Thuoc) {
        return thuocRepo.save(Thuoc);
    }
}
