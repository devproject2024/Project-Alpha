package net.one97.paytm.common.entity.wallet;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRBranchDetails implements IJRDataModel {
    @b(a = "branchName")
    private String mBranchName;
    @b(a = "displayName")
    private String mDisplayName;
    @b(a = "ifscCode")
    private String mIfscCode;

    public String getIfscCode() {
        return this.mIfscCode;
    }

    public String getDisplayName() {
        return this.mDisplayName;
    }
}
