package com.travel.flight.pojo.flightticket.FareRules;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRFareRulesJorneyDetails implements IJRDataModel {
    @b(a = "routes")
    private ArrayList<CJRRoutes> routes;
    @b(a = "title")
    private String title;

    public String getTitle() {
        return this.title;
    }

    public ArrayList<CJRRoutes> getRoutes() {
        return this.routes;
    }
}
