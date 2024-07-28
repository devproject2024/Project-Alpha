package com.paytmmall.artifact.order.entity.impsdataentity;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.HashMap;
import java.util.List;

public class CJRAccountBodyResponse extends IJRPaytmDataModel {
    @b(a = "refundAccounts")
    private List<CJRRefundAccountDetail> refundAccounts;
    @b(a = "resultInfo")
    private HashMap<String, String> resultInfo = new HashMap<>();

    public HashMap<String, String> getResultInfo() {
        return this.resultInfo;
    }

    public List<CJRRefundAccountDetail> getRefundAccounts() {
        return this.refundAccounts;
    }

    public void setRefundAccounts(List<CJRRefundAccountDetail> list) {
        this.refundAccounts = list;
    }
}
