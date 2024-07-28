package com.travel.train.travellerProfile.travel;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;

public class CJRTravelViewPage implements IJRDataModel {
    @b(a = "items")
    private ArrayList<CJRHomePageItem> cjrTravelItemPages = new ArrayList<>();
    @b(a = "id")
    private String id;
    @b(a = "image_url")
    private String image_url;
    @b(a = "priority")
    private String priority;
    @b(a = "seourl")
    private String seourl;
    @b(a = "subtitle")
    private String subtitle;
    @b(a = "title")
    private String title;
    @b(a = "type")
    private String type;

    public String getType() {
        return this.type;
    }

    public String getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getSubtitle() {
        return this.subtitle;
    }

    public String getPriority() {
        return this.priority;
    }

    public String getImage_url() {
        return this.image_url;
    }

    public String getSeourl() {
        return this.seourl;
    }

    public ArrayList<CJRHomePageItem> getCjrTravelItemPages() {
        return this.cjrTravelItemPages;
    }
}
