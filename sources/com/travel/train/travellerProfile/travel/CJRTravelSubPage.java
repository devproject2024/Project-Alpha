package com.travel.train.travellerProfile.travel;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTravelSubPage implements IJRDataModel {
    @b(a = "id")
    private String id;
    @b(a = "layout")
    private String layout;
    @b(a = "views")
    public ArrayList<CJRTravelViewPage> mHomePageLayoutList = new ArrayList<>();

    public String getId() {
        return this.id;
    }

    public String getLayout() {
        return this.layout;
    }

    public ArrayList<CJRTravelViewPage> getmHomePageLayoutList() {
        return this.mHomePageLayoutList;
    }
}
