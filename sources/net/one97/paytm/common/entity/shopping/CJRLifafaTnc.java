package net.one97.paytm.common.entity.shopping;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRLifafaTnc extends IJRPaytmDataModel {
    @b(a = "promocode")
    private String mPromocode;
    @b(a = "site_id")
    private String mSiteId;
    @b(a = "terms")
    private String mTerms;
    @b(a = "terms_title")
    private String mTermsTitle;

    public String getmTerms() {
        return this.mTerms;
    }

    public void setmTerms(String str) {
        this.mTerms = str;
    }

    public String getmPromocode() {
        return this.mPromocode;
    }

    public void setmPromocode(String str) {
        this.mPromocode = str;
    }

    public String getmSiteId() {
        return this.mSiteId;
    }

    public void setmSiteId(String str) {
        this.mSiteId = str;
    }

    public String getmTermsTitle() {
        return this.mTermsTitle;
    }

    public void setmTermsTitle(String str) {
        this.mTermsTitle = str;
    }
}
