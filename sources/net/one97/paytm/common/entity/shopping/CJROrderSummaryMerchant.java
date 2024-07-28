package net.one97.paytm.common.entity.shopping;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJROrderSummaryMerchant implements IJRDataModel {
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
