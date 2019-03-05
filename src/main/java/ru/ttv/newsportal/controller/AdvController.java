package ru.ttv.newsportal.controller;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.ttv.newsportal.controller.ajax.AdvsAjax;
import ru.ttv.newsportal.model.Adv;
import ru.ttv.newsportal.model.AdvCategory;
import ru.ttv.newsportal.model.Company;
import ru.ttv.newsportal.service.AdvCategoryService;
import ru.ttv.newsportal.service.AdvService;

import javax.validation.Valid;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

/**
 * @author Timofey Teplykh
 */
@Controller
public class AdvController {

    @Autowired
    private MessageSource messageSource;

    @Autowired
    AdvService advService;

    @Autowired
    AdvCategoryService advCategoryService;

    @GetMapping(value = "/advs_ajax", produces = "application/json")
    @ResponseBody
    /**
     * Все параметры передаются в адресе асинхронного запроса!
     * @param pageCounter – текущая страница(блок из number статей)
     * @param number – количество статей в одном блоке
     * @param order – порядок сортировки(ASC-прямая, DESC-обратная)
     * @param orderBy – поле по которому происходит сортировка
     * @return – объект класса ArticlesAjax, который содержит список статей,
     * данный объект преобразовывается в JSON-формат
     */
    public AdvsAjax advsAjax(@RequestParam("pageCounter") Integer pageCounter,
                             @RequestParam("number") Integer number,
                             @RequestParam("order") String order,
                             @RequestParam("orderBy") String orderBy){
        Sort sort = null;
        if(order.equalsIgnoreCase("DESC")){
            sort = new Sort(Sort.Direction.DESC, orderBy);
        }else {
            sort = new Sort(Sort.Direction.ASC, orderBy);
        }

        PageRequest pageable = new PageRequest(pageCounter, number, sort);
        Page<Adv> advPage = advService.getAll(pageable);
        AdvsAjax responsive = new AdvsAjax();
        responsive.setAdvList(Lists.newArrayList(advPage.iterator()));
        return responsive;
    }

    @GetMapping(value = "/adv/{id}")
    public String advView(final Model model, @PathVariable("id") final String id){
        final Optional<Adv> adv = advService.get(Long.parseLong(id));
        model.addAttribute("adv", adv.get());
        return "adv/advview";
    }

    @PostMapping(value = "/adv/save")
    public String saveAdvPost(@ModelAttribute("adv") @Valid  final Adv adv, final BindingResult result, @RequestParam("categoryId") Long categoryId, Locale locale, RedirectAttributes redirectAttributes){
        AdvCategory advCategory = advCategoryService.get(categoryId);
        if(result.hasErrors() || advCategory==null){
            return "redirect:/adv/add";
        }
        adv.setCategory(advCategory);
        advService.update(adv);
        redirectAttributes.addFlashAttribute("message",messageSource.getMessage("article_create_fail", new Object[]{},locale));
        return "redirect:/";
    }

    @GetMapping(value = "/adv/add")
    public String advAddForm(Model model){
        final Adv adv = new Adv();
        adv.setCompany(new Company());
        List<AdvCategory> advCategories = advCategoryService.getAll();
        model.addAttribute("adv",adv).addAttribute("categories",advCategories);
        return "adv/advadd";
    }

//    @GetMapping(value = "/adv/edit/{id}")
//    public String advEdit(final Model model, @PathVariable("id") final String id){
//        final Optional<Adv> adv = advService.get(Long.parseLong(id));
//        adv.ifPresent(a -> model.addAttribute("adv",a));
//        return "adv-edit";
//    }

    @GetMapping(value = "/adv/delete/{id}")
    public String advDelete(final Model model, @PathVariable("id") final String id){
        advService.delete(advService.get(Long.parseLong(id)).get());
        return "redirect:/adv/all";
    }
}
