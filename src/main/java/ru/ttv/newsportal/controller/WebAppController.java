package ru.ttv.newsportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.ttv.newsportal.model.AdvCategory;
import ru.ttv.newsportal.service.AdvCategoryService;
import ru.ttv.newsportal.web.UserSettings;

import java.util.List;

/**
 * @author Timofey Teplykh
 */
@Controller
public class WebAppController {

    private AdvCategoryService advCategoryService;

    private UserSettings userSettings;

    @Autowired
    public WebAppController(AdvCategoryService advCategoryService, UserSettings userSettings){
        this.advCategoryService = advCategoryService;
        this.userSettings = userSettings;
    }

    @GetMapping(value = "/")
    public String webAppRoot(Model model){
        List<AdvCategory> advCategories = advCategoryService.getAll();
        model.addAttribute("categories", advCategories);
        model.addAttribute("lang", userSettings.getLanguage());
        return "main/index";
    }

}
