package net.one97.paytm.recharge;

import com.paytm.network.model.NetworkCustomError;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.CJRRechargeCart;
import net.one97.paytm.recharge.common.e.u;
import net.one97.paytm.recharge.common.utils.o;
import net.one97.paytm.recharge.d.a;
import net.one97.paytm.recharge.model.CJRPromoCode;

public final class e implements u {

    /* renamed from: a  reason: collision with root package name */
    private o f62756a;

    /* renamed from: b  reason: collision with root package name */
    private a f62757b;

    public final void a(Integer num, String str, String str2) {
    }

    public final void a(NetworkCustomError networkCustomError) {
        k.c(networkCustomError, "error");
        a aVar = this.f62757b;
        if (aVar != null) {
            aVar.a(networkCustomError);
        }
    }

    public final void a(CJRPromoCode cJRPromoCode, CJRRechargeCart cJRRechargeCart) {
        a aVar;
        boolean z;
        k.c(cJRRechargeCart, "rechargeCart");
        if (cJRPromoCode != null && (aVar = this.f62757b) != null) {
            String code = cJRPromoCode.getCode();
            String terms = cJRPromoCode.getTerms();
            o oVar = this.f62756a;
            if (oVar != null) {
                z = oVar.f61684a;
            } else {
                z = false;
            }
            o oVar2 = this.f62756a;
            aVar.a(code, terms, z, oVar2 != null ? oVar2.d() : null, cJRRechargeCart);
        }
    }

    public final void a(CJRRechargeCart cJRRechargeCart) {
        k.c(cJRRechargeCart, "cjrRechargeCart");
        a aVar = this.f62757b;
        if (aVar != null) {
            aVar.a(cJRRechargeCart);
        }
    }
}
