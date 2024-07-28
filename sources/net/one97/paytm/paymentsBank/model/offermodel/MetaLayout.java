package net.one97.paytm.paymentsBank.model.offermodel;

import com.google.gson.a.c;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class MetaLayout extends IJRPaytmDataModel implements IJRDataModel {
    @c(a = "bg_color")
    private String bgColor;

    public void setBgColor(String str) {
        this.bgColor = str;
    }

    public String getBgColor() {
        return this.bgColor;
    }

    public String toString() {
        return "MetaLayout{bg_color = '" + this.bgColor + '\'' + "}";
    }
}
