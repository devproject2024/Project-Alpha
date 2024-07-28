package com.paytmmall.artifact.order.entity.impsdataentity;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytmmall.artifact.ReturnReplace.entity.CJRBranchDetails;
import java.util.ArrayList;

public class CJRBankResponse extends IJRPaytmDataModel {
    @b(a = "bankBranchList")
    private ArrayList<CJRBranchDetails> mBankBranchList;
    @b(a = "list")
    private ArrayList<String> mList;

    public ArrayList<String> getList() {
        return this.mList;
    }

    public ArrayList<CJRBranchDetails> getBankBranchList() {
        return this.mBankBranchList;
    }
}
