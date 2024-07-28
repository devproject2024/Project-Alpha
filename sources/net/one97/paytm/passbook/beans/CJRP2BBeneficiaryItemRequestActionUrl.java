package net.one97.paytm.passbook.beans;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.passbook.mapping.IJRDataModel;

public class CJRP2BBeneficiaryItemRequestActionUrl extends IJRDataModel {
    @b(a = "request")
    private CJRP2BBeneficiaryItemRequest mBeneficiaryItemRequest;

    public CJRP2BBeneficiaryItemRequest getBeneficiaryItemRequest() {
        return this.mBeneficiaryItemRequest;
    }
}
