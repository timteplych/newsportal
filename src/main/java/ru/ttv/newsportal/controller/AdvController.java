package ru.ttv.newsportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.ttv.newsportal.model.Adv;
import ru.ttv.newsportal.service.AdvService;

import java.util.List;
import java.util.Optional;

/**
 * @author Timofey Teplykh
 */
@Controller
public class AdvController {

    @Autowired
    AdvService advService;

//    @GetMapping(value = "/adv/{name}")
//    public ModelAndView helloGet(@PathVariable("name") String name){
//        return new ModelAndView("hello","name",name);
//    }

    @PostMapping(value = "/adv/save")
    public String saveAdvPost(@ModelAttribute("adv") final Adv adv, final BindingResult result){
        if(!result.hasErrors()) advService.update(adv);
        return "redirect:/adv/all";
    }

    @GetMapping(value = "/adv/all")
    public String advAllGet(final Model model){
        List<Adv> advList = advService.getAll();
        model.addAttribute("advList",advList);
        return "adv-list";
    }

    @GetMapping(value = "/adv/add")
    public String advAdd(){
        final Adv adv = new Adv();
        adv.setTitle("New Adv");
        advService.save(adv);
        return "redirect:/adv/all";
    }

    @GetMapping(value = "/adv/edit/{id}")
    public String advEdit(final Model model, @PathVariable("id") final String id){
        final Optional<Adv> adv = advService.get(Long.parseLong(id));
        adv.ifPresent(a -> model.addAttribute("adv",a));
        return "adv-edit";
    }

    @GetMapping(value = "/adv/delete/{id}")
    public String advDelete(final Model model, @PathVariable("id") final String id){
        advService.delete(advService.get(Long.parseLong(id)).get());
        return "redirect:/adv/all";
    }
}
