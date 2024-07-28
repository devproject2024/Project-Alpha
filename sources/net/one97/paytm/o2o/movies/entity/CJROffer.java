package net.one97.paytm.o2o.movies.entity;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJROffer extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "icon")
    public String icon;
    @b(a = "pdpIcon")
    private String pdpIcon;
    @b(a = "selectedText")
    private String selectedText;
    @b(a = "text")
    private String text;
    @b(a = "title")
    public String title;
    @b(a = "type")
    private String type;

    public void setIcon(String str) {
        this.icon = str;
    }

    public void setPdpIcon(String str) {
        this.pdpIcon = str;
    }

    public void setSelectedText(String str) {
        this.selectedText = str;
    }

    public void setText(String str) {
        this.text = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setType(String str) {
        this.type = str;
    }

    public String getIcon() {
        return this.icon;
    }

    public String getPdpIcon() {
        return this.pdpIcon;
    }

    public String getSelectedText() {
        return this.selectedText;
    }

    public String getText() {
        return this.text;
    }

    public String getTitle() {
        return this.title;
    }

    public String getType() {
        return this.type;
    }
}
