package net.one97.paytm.wallet.newdesign.addmoney.model;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.CJRDataModelItem;

public class CJRPaytmWalletService extends CJRDataModelItem {
    private static final long serialVersionUID = 1;
    @b(a = "landingPage")
    private String mLandingPage;
    @b(a = "name")
    private String mName;
    @b(a = "url")
    private String mUrl;

    public String getLandingPage() {
        return this.mLandingPage;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public String getName() {
        return this.mName;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public void setUrl(String str) {
        this.mUrl = str;
    }

    public void setLandingPage(String str) {
        this.mLandingPage = str;
    }
}
