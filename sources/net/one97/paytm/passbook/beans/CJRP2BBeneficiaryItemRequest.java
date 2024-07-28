package net.one97.paytm.passbook.beans;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.passbook.mapping.IJRDataModel;

public class CJRP2BBeneficiaryItemRequest extends IJRDataModel {
    @b(a = "bankAccountNo")
    private String mBankAccountNo;
    @b(a = "bankName")
    private String mBankName;
    @b(a = "ifscCode")
    private String mIfscCode;
    @b(a = "senderName")
    private String mSenderName;

    public String getSenderName() {
        return this.mSenderName;
    }

    public String getBankName() {
        return this.mBankName;
    }

    public String getIfscCode() {
        return this.mIfscCode;
    }

    public String getBankAccountNo() {
        return this.mBankAccountNo;
    }
}
