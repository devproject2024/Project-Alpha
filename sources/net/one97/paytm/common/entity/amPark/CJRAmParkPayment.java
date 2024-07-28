package net.one97.paytm.common.entity.amPark;

import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;

public class CJRAmParkPayment implements IJRDataModel {
    private CJRRechargePayment mRechargePayment;

    public CJRRechargePayment getPaymentInfo() {
        return this.mRechargePayment;
    }

    public void setPaymentInfo(CJRRechargePayment cJRRechargePayment) {
        this.mRechargePayment = cJRRechargePayment;
    }
}
