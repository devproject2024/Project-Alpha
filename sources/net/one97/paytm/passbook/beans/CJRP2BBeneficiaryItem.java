package net.one97.paytm.passbook.beans;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.passbook.mapping.IJRDataModel;

public class CJRP2BBeneficiaryItem extends IJRDataModel {
    @b(a = "amount")
    private String amount;
    @b(a = "requestActionUrl")
    private CJRP2BBeneficiaryItemRequestActionUrl mBeneficiaryItemRequestActionUrl;

    public String getAmount() {
        return this.amount;
    }

    public CJRP2BBeneficiaryItemRequestActionUrl getBeneficiaryItemRequestActionUrl() {
        return this.mBeneficiaryItemRequestActionUrl;
    }

    public String getSenderName() {
        if (getBeneficiaryItemRequestActionUrl() == null || getBeneficiaryItemRequestActionUrl().getBeneficiaryItemRequest() == null) {
            return null;
        }
        return getBeneficiaryItemRequestActionUrl().getBeneficiaryItemRequest().getSenderName();
    }

    public String getBankName() {
        if (getBeneficiaryItemRequestActionUrl() == null || getBeneficiaryItemRequestActionUrl().getBeneficiaryItemRequest() == null) {
            return null;
        }
        return getBeneficiaryItemRequestActionUrl().getBeneficiaryItemRequest().getBankName();
    }

    public String getIfscCode() {
        if (getBeneficiaryItemRequestActionUrl() == null || getBeneficiaryItemRequestActionUrl().getBeneficiaryItemRequest() == null) {
            return null;
        }
        return getBeneficiaryItemRequestActionUrl().getBeneficiaryItemRequest().getIfscCode();
    }

    public String getBankAccountNo() {
        if (getBeneficiaryItemRequestActionUrl() == null || getBeneficiaryItemRequestActionUrl().getBeneficiaryItemRequest() == null) {
            return null;
        }
        return getBeneficiaryItemRequestActionUrl().getBeneficiaryItemRequest().getBankAccountNo();
    }
}
