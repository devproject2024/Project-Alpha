package com.paytmmall.artifact.order.entity.impsdataentity;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.HashMap;

public class CJRPostReturnRefundConsultView extends IJRPaytmDataModel {
    @b(a = "refundConsultView")
    private CJRRefundConsultView refundConsultView;
    @b(a = "securityId")
    private String securityId;
    private HashMap<String, Boolean> usedPaymentSource = new HashMap<>();
    @b(a = "walletView")
    private CJRWalletView walletView;

    public CJRWalletView getWalletView() {
        return this.walletView;
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

    public CJRRefundConsultView getRefundConsultViews() {
        return this.refundConsultView;
    }
}
