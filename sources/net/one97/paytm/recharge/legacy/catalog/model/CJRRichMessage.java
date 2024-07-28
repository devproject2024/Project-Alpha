package net.one97.paytm.recharge.legacy.catalog.model;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRRichMessage implements IJRDataModel {
    @b(a = "image")
    private String image;
    @b(a = "subheading")
    private String sub_heading;
    @b(a = "text")
    private String text;

    public String getText() {
        return this.text;
    }

    public String getImage() {
        return this.image;
    }

    public String getSub_heading() {
        return this.sub_heading;
    }

    public void setText(String str) {
        this.text = str;
    }

    public void setImage(String str) {
        this.image = str;
    }

    public void setSub_heading(String str) {
        this.sub_heading = str;
    }
}
