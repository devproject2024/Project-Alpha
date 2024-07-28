package net.one97.paytm;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class PDPBadge implements IJRDataModel {
    @b(a = "badge_text_1")
    private String badge_text_1;
    @b(a = "badge_text_2")
    private String badge_text_2;
    @b(a = "description")
    private String description;
    @b(a = "icon_url")
    private String icon_url;
    @b(a = "landing_url")
    private String landing_url;
    @b(a = "name")
    private String name;
    @b(a = "type")
    private String type;

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public String getIcon_url() {
        return this.icon_url;
    }

    public void setIcon_url(String str) {
        this.icon_url = str;
    }

    public String getBadge_text_1() {
        return this.badge_text_1;
    }

    public void setBadge_text_1(String str) {
        this.badge_text_1 = str;
    }

    public String getBadge_text_2() {
        return this.badge_text_2;
    }

    public void setBadge_text_2(String str) {
        this.badge_text_2 = str;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public String getLanding_url() {
        return this.landing_url;
    }

    public void setLanding_url(String str) {
        this.landing_url = str;
    }
}
