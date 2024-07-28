package net.one97.paytm.recharge.common.e;

import com.paytm.network.model.NetworkCustomError;
import net.one97.paytm.common.entity.CJRRechargeCart;
import net.one97.paytm.recharge.model.CJRPromoCode;

public interface u {
    void a(NetworkCustomError networkCustomError);

    void a(Integer num, String str, String str2);

    void a(CJRRechargeCart cJRRechargeCart);

    void a(CJRPromoCode cJRPromoCode, CJRRechargeCart cJRRechargeCart);
}
