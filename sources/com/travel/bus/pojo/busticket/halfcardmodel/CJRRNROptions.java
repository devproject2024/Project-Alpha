package com.travel.bus.pojo.busticket.halfcardmodel;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRRNROptions extends IJRPaytmDataModel {
    @b(a = "icon")
    private String icon;
    @b(a = "icon_selected")
    private String iconSelected;
    @b(a = "id")
    private String id;
    private boolean isSelected;
    @b(a = "name")
    private String name;

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

    public String getIcon() {
        return this.icon;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public String getIconSelected() {
        return this.iconSelected;
    }

    public boolean isSelected() {
        return this.isSelected;
    }

    public void setSelected(boolean z) {
        this.isSelected = z;
    }
}
