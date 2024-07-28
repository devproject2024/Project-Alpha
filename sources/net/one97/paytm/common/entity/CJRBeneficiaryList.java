package net.one97.paytm.common.entity;

import com.google.gsonhtcfix.a.b;

public class CJRBeneficiaryList extends CJRDataModelItem {
    private static final long serialVersionUID = 1;
    @b(a = "response")
    private CJRBeneficiaryResponse mResponse;

    public String getName() {
        return null;
    }

    public CJRBeneficiaryResponse getResponse() {
        return this.mResponse;
    }
}
