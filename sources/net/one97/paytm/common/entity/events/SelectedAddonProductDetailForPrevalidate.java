package net.one97.paytm.common.entity.events;

import net.one97.paytm.common.entity.IJRDataModel;

public class SelectedAddonProductDetailForPrevalidate implements IJRDataModel {
    private String name;
    private String value;

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String str) {
        this.value = str;
    }
}
