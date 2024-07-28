package com.travel.bus.pojo.busticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;

public class CJRBusRatingQuestions extends IJRPaytmDataModel {
    @b(a = "category")
    private String category;
    @b(a = "category_id")
    private String categoryId;
    @b(a = "mandatory")
    private Integer mandatory;
    @b(a = "options")
    private List<CJRBusJourneyIssues> options = null;

    public String getCategoryId() {
        return this.categoryId;
    }

    public void setCategoryId(String str) {
        this.categoryId = str;
    }

    public Integer getMandatory() {
        return this.mandatory;
    }

    public void setMandatory(Integer num) {
        this.mandatory = num;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String str) {
        this.category = str;
    }

    public List<CJRBusJourneyIssues> getIssueOptions() {
        return this.options;
    }

    public void setIssueOptions(List<CJRBusJourneyIssues> list) {
        this.options = list;
    }
}
