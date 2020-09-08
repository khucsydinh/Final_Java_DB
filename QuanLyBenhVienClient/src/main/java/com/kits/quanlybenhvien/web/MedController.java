package com.kits.quanlybenhvien.web;


import com.kits.quanlybenhvien.entity.Med;
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
@RequestMapping("/med")
public class MedController {
    private RestTemplate rest = new RestTemplate();
    @GetMapping()
    public String InformationBacSi(Model model){
        List<Med> meds = Arrays.asList(rest.getForObject("http://localhost:8081/med",Med[].class));
        System.out.println(meds);
        model.addAttribute("meds",meds);
        return "informationMed";
    }
    @GetMapping("/add")
    public String addMed(Model model){
        model.addAttribute("med", new Med());
        return "formAddMed";
    }

    @PostMapping()
    public String processDesign(@RequestParam("nameMed") String nameMed , @RequestParam("price") float price, @RequestParam("usedFor") String usedFor) {
        Med med = new Med();
        med.setNameMed(nameMed);
        med.setPrice(price);
        med.setUsedFor(usedFor);

        log.info("New "+ med);
        rest.postForObject("http://localhost:8081/med", med, Med.class);
        return "redirect:/med";
    }

   /* @GetMapping("/delete/{id}")
    public String deleteIngredient(@PathVariable("id")String id, Model model) {
        rest.delete("http://localhost:8443/ingredients/delete/{id}",id);
        List<Ingredient> ingredients = Arrays.asList(rest.getForObject("http://localhost:8443/ingredients",Ingredient[].class));
        System.out.println(ingredients);
        model.addAttribute("ingredients",ingredients);
        return "informationIngredient";
    }

    @GetMapping("/edit/{id}")
    public String editIngredient(@PathVariable("id")String id,Model model){
        Ingredient ingredient = rest.getForObject("http://localhost:8443/ingredients/{id}",Ingredient.class,id);
        model.addAttribute("ingredient",ingredient);
        return "formAddIngredient";
    }
    @GetMapping("search")
    public String search(@RequestParam("id") String id,Model model){
        Ingredient ingredient = rest.getForObject("http://localhost:8443/ingredients/{id}",Ingredient.class,id);
        model.addAttribute("ingredients",ingredient);
        return "informationIngredient";
    }
*/
}