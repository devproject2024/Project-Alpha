package net.one97.paytm.passbook.beans;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.passbook.mapping.IJRDataModel;

public class CJRP2BBeneficiaryList extends IJRDataModel {
    @b(a = "response")
    private CJRP2BBeneficiaryListResponse mResponse;

    public CJRP2BBeneficiaryListResponse getResponse() {
        return this.mResponse;
    }
}
