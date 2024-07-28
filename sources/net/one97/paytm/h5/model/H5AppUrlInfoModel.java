package net.one97.paytm.h5.model;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class H5AppUrlInfoModel implements IJRDataModel {
    @b(a = "app")
    private String appDeepLink;
    @b(a = "cst")
    private String cst;
    @b(a = "faq")
    private String faq;
    @b(a = "icon")
    private String icon;
    @b(a = "logout")
    private String logout;

    public String getIcon() {
        return this.icon;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public String getAppDeepLink() {
        return this.appDeepLink;
    }

    public void setAppDeepLink(String str) {
        this.appDeepLink = str;
    }

    public String getCst() {
        return this.cst;
    }

    public void setCst(String str) {
        this.cst = str;
    }

    public String getFaq() {
        return this.faq;
    }

    public void setFaq(String str) {
        this.faq = str;
    }

    public String getLogout() {
        return this.logout;
    }

    public void setLogout(String str) {
        this.logout = str;
    }

    public String toString() {
        return "MiniAppUrlInfoModel{icon='" + this.icon + '\'' + ", appDeepLink='" + this.appDeepLink + '\'' + ", cst='" + this.cst + '\'' + ", faq='" + this.faq + '\'' + ", logout='" + this.logout + '\'' + '}';
    }
}
