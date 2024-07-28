package net.one97.paytm.nativesdk.bank_mandate.dataModel;

import com.google.gson.a.c;
import net.one97.paytm.nativesdk.common.model.BaseDataModel;

public class BankMandateIFSCBranchDetails implements BaseDataModel {
    @c(a = "branchName")
    private String mBranchName;
    @c(a = "displayName")
    private String mDisplayName;
    @c(a = "ifscCode")
    private String mIfscCode;

    public String getIfscCode() {
        return this.mIfscCode;
    }

    public String getDisplayName() {
        return this.mDisplayName;
    }
}
