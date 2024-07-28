package com.paytmmall.artifact.ReturnReplace.entity;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRBranchDetails extends IJRPaytmDataModel {
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
