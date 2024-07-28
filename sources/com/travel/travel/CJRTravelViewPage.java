package com.travel.travel;

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

    public void setType(String str) {
        this.type = str;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getSubtitle() {
        return this.subtitle;
    }

    public void setSubtitle(String str) {
        this.subtitle = str;
    }

    public String getPriority() {
        return this.priority;
    }

    public void setPriority(String str) {
        this.priority = str;
    }

    public String getImage_url() {
        return this.image_url;
    }

    public void setImage_url(String str) {
        this.image_url = str;
    }

    public String getSeourl() {
        return this.seourl;
    }

    public void setSeourl(String str) {
        this.seourl = str;
    }

    public ArrayList<CJRHomePageItem> getCjrTravelItemPages() {
        return this.cjrTravelItemPages;
    }

    public void setCjrTravelItemPages(ArrayList<CJRHomePageItem> arrayList) {
        this.cjrTravelItemPages = arrayList;
    }
}
