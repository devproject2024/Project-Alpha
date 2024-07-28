package net.one97.paytm.recharge.d;

import com.paytm.network.model.NetworkCustomError;
import net.one97.paytm.common.entity.CJRRechargeCart;

public interface a {
    void a(NetworkCustomError networkCustomError);

    void a(String str, String str2, boolean z, String str3, CJRRechargeCart cJRRechargeCart);

    void a(CJRRechargeCart cJRRechargeCart);
}
