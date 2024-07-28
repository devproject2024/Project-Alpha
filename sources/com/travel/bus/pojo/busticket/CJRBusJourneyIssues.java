package com.travel.bus.pojo.busticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRBusJourneyIssues extends IJRPaytmDataModel {
    @b(a = "id")
    private String id;
    private boolean isSelected = false;
    @b(a = "name")
    private String name;

    public boolean ismIsClicked() {
        return this.isSelected;
    }

    public void setmIsClicked(boolean z) {
        this.isSelected = z;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }
}
