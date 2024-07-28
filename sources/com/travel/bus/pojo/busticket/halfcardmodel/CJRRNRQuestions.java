package com.travel.bus.pojo.busticket.halfcardmodel;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;

public class CJRRNRQuestions extends IJRPaytmDataModel {
    @b(a = "category")
    private String category;
    @b(a = "category_id")
    private String categoryId;
    @b(a = "mandatory")
    private Integer mandatory;
    @b(a = "options")
    private List<CJRRNROptions> options = null;

    public String getCategoryId() {
        return this.categoryId;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String str) {
        this.category = str;
    }

    public Integer getMandatory() {
        return this.mandatory;
    }

    public List<CJRRNROptions> getOptions() {
        return this.options;
    }
}
