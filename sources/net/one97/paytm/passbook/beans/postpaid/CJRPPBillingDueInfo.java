package net.one97.paytm.passbook.beans.postpaid;

import com.google.gson.a.c;
import net.one97.paytm.passbook.mapping.IJRDataModel;

public final class CJRPPBillingDueInfo extends IJRDataModel {
    @c(a = "billDateText")
    private String billDateText;
    @c(a = "billDueText")
    private String billDueText;

    public final String getBillDueText() {
        return this.billDueText;
    }

    public final void setBillDueText(String str) {
        this.billDueText = str;
    }

    public final String getBillDateText() {
        return this.billDateText;
    }

    public final void setBillDateText(String str) {
        this.billDateText = str;
    }
}
