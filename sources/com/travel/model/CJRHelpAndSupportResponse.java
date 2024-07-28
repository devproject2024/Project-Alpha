package com.travel.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.cst.CJRHelpAndSupportItem;

public class CJRHelpAndSupportResponse extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "reasonObjs")
    ArrayList<CJRHelpAndSupportItem> mReasonObjs;
    private final Long serialVersionUID = 1L;

    public ArrayList<CJRHelpAndSupportItem> getmReasonObjs() {
        return this.mReasonObjs;
    }

    public void setmReasonObjs(ArrayList<CJRHelpAndSupportItem> arrayList) {
        this.mReasonObjs = arrayList;
    }
}
