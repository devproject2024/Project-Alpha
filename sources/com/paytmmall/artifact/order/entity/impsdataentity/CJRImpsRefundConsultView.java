package com.paytmmall.artifact.order.entity.impsdataentity;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.HashMap;
import java.util.List;

public class CJRImpsRefundConsultView extends IJRPaytmDataModel {
    @b(a = "refundConsultViews")
    private List<CJRRefundConsultView> refundConsultViews;
    @b(a = "securityId")
    private String securityId;
    private HashMap<String, Boolean> usedPaymentSource = new HashMap<>();
    @b(a = "walletView")
    private CJRWalletView walletView;

    public CJRWalletView getWalletView() {
        return this.walletView;
    }

    public List<CJRRefundConsultView> getOtherRefundConsultView() {
        return this.refundConsultViews;
    }

    public String getSecurityId() {
        return this.securityId;
    }

    public HashMap<String, Boolean> getUsedPaymentSource() {
        return this.usedPaymentSource;
    }

    public void setUsedPaymentSource(HashMap<String, Boolean> hashMap) {
        this.usedPaymentSource = hashMap;
    }
}
