package net.one97.travelpass.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class VerticalData extends IJRPaytmDataModel {
    @b(a = "title")
    private String title;
    @b(a = "type")
    private String type;

    public void setType(String str) {
        this.type = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getType() {
        return this.type;
    }

    public String getTitle() {
        return this.title;
    }

    public String getCapitalisedName() {
        return getTitle().toUpperCase();
    }
}
