package com.travel.bus.busticket.g;

import net.one97.paytm.common.entity.recharge.CJRRechargePayment;

public final class g {
    public static String a(CJRRechargePayment cJRRechargePayment) {
        if (cJRRechargePayment == null) {
            return null;
        }
        if (cJRRechargePayment.getmPGParams() == null || !cJRRechargePayment.getmPGParams().containsKey("TXN_AMOUNT")) {
            return cJRRechargePayment.getTxnAmount();
        }
        return String.valueOf(cJRRechargePayment.getmPGParams().get("TXN_AMOUNT"));
    }
}
