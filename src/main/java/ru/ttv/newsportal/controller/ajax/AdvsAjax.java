package ru.ttv.newsportal.controller.ajax;

import ru.ttv.newsportal.model.Adv;

import java.util.List;

/**
 * @author Timofey Teplykh
 */
public class AdvsAjax {

    private List<Adv> advList;

    public List<Adv> getAdvList() {
        return advList;
    }

    public void setAdvList(List<Adv> advList) {
        this.advList = advList;
    }
}
