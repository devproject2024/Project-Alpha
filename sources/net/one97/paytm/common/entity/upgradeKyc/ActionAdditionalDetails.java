package net.one97.paytm.common.entity.upgradeKyc;

import java.io.Serializable;
import java.util.ArrayList;

public class ActionAdditionalDetails implements Serializable {
    private String clickable;
    private ArrayList<String> options;
    private String subTitle;
    private String title;

    public String getSubTitle() {
        return this.subTitle;
    }

    public void setSubTitle(String str) {
        this.subTitle = str;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public boolean getClickable() {
        return "true".equals(this.clickable);
    }

    public void setClickable(String str) {
        this.clickable = str;
    }

    public ArrayList<String> getOptions() {
        return this.options;
    }

    public void setOptions(ArrayList<String> arrayList) {
        this.options = arrayList;
    }
}
