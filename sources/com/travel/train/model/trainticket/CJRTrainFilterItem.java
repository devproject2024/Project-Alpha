package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTrainFilterItem implements Cloneable, IJRDataModel {
    @b(a = "id")
    private String id;
    @b(a = "label")
    private String label;
    private boolean selectValue;
    @b(a = "values")
    private ArrayList<String> values = new ArrayList<>();

    public String getLabel() {
        return this.label;
    }

    public ArrayList<String> getValues() {
        return this.values;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public boolean isSelectValue() {
        return this.selectValue;
    }

    public void setSelectValue(boolean z) {
        this.selectValue = z;
    }

    public CJRTrainFilterItem clone() throws CloneNotSupportedException {
        return (CJRTrainFilterItem) super.clone();
    }
}
