package net.one97.paytm.common.entity.postpaid;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public final class CJRPPBillingDueInfo extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "billDateText")
    private String billDateText;
    @b(a = "billDueText")
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
