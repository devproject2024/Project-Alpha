package net.one97.paytm.common.entity.events;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJREventCPTermAndConditionModel implements IJRDataModel {
    @b(a = "content")
    private ArrayList<String> contents;
    @b(a = "heading")
    private String heading;

    public String getHeading() {
        return this.heading;
    }

    public ArrayList<String> getContents() {
        return this.contents;
    }
}
