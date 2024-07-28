package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTrainFilters implements Cloneable, IJRDataModel {
    @b(a = "filters")
    private ArrayList<CJRTrainFilterItem> filters = new ArrayList<>();
    @b(a = "id")
    private String id;
    @b(a = "title")
    private String title;

    public String getTitle() {
        return this.title;
    }

    public ArrayList<CJRTrainFilterItem> getFilters() {
        return this.filters;
    }

    public String getId() {
        return this.id;
    }
}
