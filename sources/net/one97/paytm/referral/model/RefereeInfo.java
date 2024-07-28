package net.one97.paytm.referral.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public final class RefereeInfo extends IJRPaytmDataModel {
    @b(a = "bonus")
    private Integer bonus;
    @b(a = "display_name")
    private String display_name;
    @b(a = "display_name_initial")
    private String display_name_initial;
    @b(a = "image_bg_color")
    private String image_bg_color;
    @b(a = "image_url")
    private String image_url;
    @b(a = "referee_id")
    private String referee_id;

    public final Integer getBonus() {
        return this.bonus;
    }

    public final void setBonus(Integer num) {
        this.bonus = num;
    }

    public final String getDisplay_name() {
        return this.display_name;
    }

    public final void setDisplay_name(String str) {
        this.display_name = str;
    }

    public final String getImage_url() {
        return this.image_url;
    }

    public final void setImage_url(String str) {
        this.image_url = str;
    }

    public final String getReferee_id() {
        return this.referee_id;
    }

    public final void setReferee_id(String str) {
        this.referee_id = str;
    }

    public final String getImage_bg_color() {
        return this.image_bg_color;
    }

    public final void setImage_bg_color(String str) {
        this.image_bg_color = str;
    }

    public final String getDisplay_name_initial() {
        return this.display_name_initial;
    }

    public final void setDisplay_name_initial(String str) {
        this.display_name_initial = str;
    }

    public RefereeInfo(Integer num, String str, String str2, String str3, String str4, String str5) {
        this.bonus = num;
        this.display_name = str;
        this.image_url = str2;
        this.referee_id = str3;
        this.image_bg_color = str4;
        this.display_name_initial = str5;
    }
}
