package com.travel.flight.pojo.flightticket.FareRules;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRMiniRuleTC implements IJRDataModel {
    @b(a = "text")
    private ArrayList<CJRMiniRuleTcTextObject> text;
    @b(a = "title")
    private String title;

    public String getTitle() {
        return this.title;
    }

    public ArrayList<CJRMiniRuleTcTextObject> getText() {
        return this.text;
    }
}
