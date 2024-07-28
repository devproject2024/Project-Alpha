package com.paytmmall.artifact.ReturnReplace.entity;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytmmall.artifact.order.entity.CJRCustomTextModel;
import java.util.ArrayList;
import java.util.Iterator;

public class CJRReplacementResponse extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "custom_text")
    private CJRCustomTextModel custom_text;
    @b(a = "actions")
    private ArrayList<CJRReplacementAction> mActionList;
    @b(a = "orderItemDetails")
    private CJROrderItemDetails mOrderItemDetails;
    @b(a = "reasonObjs")
    private ArrayList<CJRReplacementReason> mReasonObjs;
    @b(a = "replaceableOptions")
    private ArrayList<CJRReplaceableOptions> mReplaceableOptions;

    public CJRCustomTextModel getCustom_text() {
        return this.custom_text;
    }

    public void setCustom_text(CJRCustomTextModel cJRCustomTextModel) {
        this.custom_text = cJRCustomTextModel;
    }

    public ArrayList<CJRReplacementReason> getL1ReasonList() {
        ArrayList<CJRReplacementReason> arrayList = this.mReasonObjs;
        if (arrayList != null) {
            return arrayList;
        }
        return new ArrayList<>();
    }

    public ArrayList<CJRReplacementAction> getActionList() {
        ArrayList<CJRReplacementAction> arrayList = this.mActionList;
        if (arrayList != null) {
            return arrayList;
        }
        return new ArrayList<>();
    }

    public ArrayList<CJRReplacementReason> getFilteredL1ReasonList() {
        ArrayList<CJRReplacementReason> arrayList = this.mReasonObjs;
        if (arrayList == null) {
            return new ArrayList<>();
        }
        filterReasons(arrayList);
        return this.mReasonObjs;
    }

    private void filterReasons(ArrayList<CJRReplacementReason> arrayList) {
        Iterator<CJRReplacementReason> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            CJRReplacementReason next = it2.next();
            if (next.getIsReplacedOrder() == 0) {
                it2.remove();
            } else if (next.getChildList() != null && next.getChildList().size() > 0) {
                filterReasons(next.getChildList());
            }
        }
    }

    public ArrayList<CJRReplaceableOptions> getReplaceableOptions() {
        return this.mReplaceableOptions;
    }

    public CJROrderItemDetails getOrderItemDetails() {
        return this.mOrderItemDetails;
    }

    public ArrayList<CJRReplacementReason> getReasonObjs() {
        return this.mReasonObjs;
    }
}
