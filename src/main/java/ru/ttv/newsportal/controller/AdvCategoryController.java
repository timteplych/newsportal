package ru.ttv.newsportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.ttv.newsportal.model.Adv;
import ru.ttv.newsportal.model.AdvCategory;
import ru.ttv.newsportal.service.AdvCategoryService;
import ru.ttv.newsportal.service.AdvService;

import java.util.List;

/**
 * @author Timofey Teplykh
 */
@Controller
public class AdvCategoryController {

    @Autowired
    private AdvCategoryService advCategoryService;

    @Autowired
    private AdvService advService;

    @GetMapping(value = "/categories/{id}")
    public String view(@PathVariable("id") Long id, Model model){
        AdvCategory advCategory = advCategoryService.get(id);
        model.addAttribute("advCategory", advCategory);
        List<AdvCategory> advCategories = advCategoryService.getAll();
        model.addAttribute("advCategories", advCategories);
        List<Adv> advListByCategory = advService.getByCategoryId(id);
        model.addAttribute("advs",advListByCategory);
        return "category/advcategoryview";
    }
}
