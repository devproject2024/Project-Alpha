package net.one97.paytm.fastag.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJROrderSummaryMerchant extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "company_name")
    private String mCompanyName;
    @b(a = "display_name")
    private String mDisplayName;
    @b(a = "email_id")
    private String mEmailId;

    public String getDisplayName() {
        return this.mDisplayName;
    }

    public String getCompanyName() {
        return this.mCompanyName;
    }

    public String getEmailId() {
        return this.mEmailId;
    }
}
