package net.one97.paytm.passbook.paytmBalance.b;

import com.appsflyer.internal.referrer.Payload;
import kotlin.g.b.k;
import net.one97.paytm.passbook.beans.CJRLedger;
import net.one97.paytm.passbook.landing.e.a;
import net.one97.paytm.passbook.mapping.a.f;

public final class b extends a {

    /* renamed from: a  reason: collision with root package name */
    public f<? extends CJRLedger> f58203a;

    public b(f<? extends CJRLedger> fVar) {
        k.c(fVar, Payload.RESPONSE);
        this.f58203a = fVar;
    }
}
