package net.one97.paytm.common.entity.vipcashback;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CashBackTnCModal extends IJRPaytmDataModel {
    @b(a = "terms")
    private String terms;
    @b(a = "terms_title")
    private String terms_title;

    public String getTerms() {
        return this.terms;
    }

    public void setTerms(String str) {
        this.terms = str;
    }

    public String getTermsTitle() {
        return this.terms_title;
    }

    public void setTermsTitle(String str) {
        this.terms_title = str;
    }
}
