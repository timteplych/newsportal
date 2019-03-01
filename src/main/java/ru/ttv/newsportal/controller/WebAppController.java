package ru.ttv.newsportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.ttv.newsportal.model.AdvCategory;
import ru.ttv.newsportal.service.AdvCategoryService;

import java.util.List;

/**
 * @author Timofey Teplykh
 */
@Controller
public class WebAppController {

    private AdvCategoryService advCategoryService;

    @Autowired
    public WebAppController(AdvCategoryService advCategoryService){
        this.advCategoryService = advCategoryService;
    }

    @GetMapping(value = "/")
    public String webAppRoot(Model model){
        List<AdvCategory> advCategories = advCategoryService.getAll();
        model.addAttribute("categories", advCategories);
        return "index";
    }

}
