package net.one97.paytm.utils;

import com.paytm.c.a;
import com.paytm.utility.q;
import kotlin.g.b.k;
import net.one97.paytm.app.CJRJarvisApplication;
import net.one97.paytm.utils.au;

public final class ay implements a {

    /* renamed from: a  reason: collision with root package name */
    public static final ay f69701a = new ay();

    private ay() {
    }

    public final void a(long j, boolean z, boolean z2, String str) {
        k.c(str, "customMessage");
        q.d("SafetyNetLatency in ms -> ".concat(String.valueOf(j)));
        au.e eVar = new au.e();
        eVar.q = j;
        eVar.u = str;
        eVar.p = z ? 200 : -1;
        eVar.g(String.valueOf(z2));
        eVar.o = "safetynet_latency";
        au.a(eVar, au.c.ApiLog.stringValue, CJRJarvisApplication.getAppContext());
    }
}
