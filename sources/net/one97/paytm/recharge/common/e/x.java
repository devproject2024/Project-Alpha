package net.one97.paytm.recharge.common.e;

import net.one97.paytm.common.entity.recharge.CJRRechargePayment;
import net.one97.paytm.nativesdk.Utils.FetchPayOptionsListener;

public interface x extends FetchPayOptionsListener {
    void a(CJRRechargePayment cJRRechargePayment);
}
