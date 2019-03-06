package ru.ttv.newsportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.ttv.newsportal.model.Company;
import ru.ttv.newsportal.service.CompanyService;

import javax.validation.Valid;
import java.util.Locale;

@Controller
public class CompanyController {

    private CompanyService companyService;
    private MessageSource messageSource;

    @Autowired
    public CompanyController(CompanyService companyService, MessageSource messageSource){
        this.companyService = companyService;
        this.messageSource = messageSource;
    }

    @GetMapping(value = "/registration")
    public String registrationForm(Model model){
        Company company = new Company();
        model.addAttribute("company",company);
        return "security/registration";
    }

    @PostMapping(value = "/registration")
    public String registration(Model model, @ModelAttribute("company") @Valid Company company, BindingResult bindingResult,
                               RedirectAttributes redirectAttributes, Locale locale){
        if(bindingResult.hasErrors()){
            model.addAttribute("message", messageSource.getMessage("company_create_fail", new Object[]{},locale));
            return "security/registration";
        }

        if(companyService.getByLogin(company.getLogin()) != null){
            model.addAttribute("message", messageSource.getMessage("author_login_exist", new Object[]{},locale));
            return "security/registration";
        }
        companyService.save(company);
        return "redirect:/";
    }


}
