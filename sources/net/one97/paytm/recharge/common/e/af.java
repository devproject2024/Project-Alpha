package net.one97.paytm.recharge.common.e;

import net.one97.paytm.common.entity.CJRRechargeCart;
import net.one97.paytm.common.entity.shopping.CJRDetailProduct;
import net.one97.paytm.common.entity.wallet.CJRCashWallet;
import net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductListV2;

public interface af {
    void a(int i2);

    void a(CJRRechargeCart cJRRechargeCart, Object obj);

    void a(CJRDetailProduct cJRDetailProduct);

    void a(CJRCashWallet cJRCashWallet);

    void a(CJRUtilityProductListV2 cJRUtilityProductListV2);

    void b(String str);

    void b(CJRCashWallet cJRCashWallet);

    void c(String str);

    void d(String str);

    void g();

    void h();

    void i();

    void j();

    boolean k();

    String l();

    void m();

    boolean n();
}
