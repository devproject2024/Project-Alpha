package net.one97.paytm.common.entity.brandStoreModels;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRSocialAtrributes implements IJRDataModel {
    @b(a = "isEnabled")
    private String misEnabled;
    @b(a = "url")
    private String murl;
    @b(a = "url_type")
    private String murlType;

    public String getMisEnabled() {
        return this.misEnabled;
    }

    public void setMisEnabled(String str) {
        this.misEnabled = str;
    }

    public String getMurl() {
        return this.murl;
    }

    public void setMurl(String str) {
        this.murl = str;
    }

    public String getMurlType() {
        return this.murlType;
    }

    public void setMurlType(String str) {
        this.murlType = str;
    }
}
