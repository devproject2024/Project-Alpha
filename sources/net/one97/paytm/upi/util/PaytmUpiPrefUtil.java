package net.one97.paytm.upi.util;

import android.content.Context;
import com.paytm.b.a.a;
import com.paytm.network.a;
import com.paytm.utility.f;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class PaytmUpiPrefUtil {
    public static final Companion Companion = new Companion((g) null);
    /* access modifiers changed from: private */
    public static final a.c VERTICAL_ID = a.c.UPI;

    public static final com.paytm.b.a.a getPref(Context context) {
        return Companion.getPref(context);
    }

    public static final com.paytm.b.a.a getPref(Context context, f.a aVar) {
        return Companion.getPref(context, aVar);
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final com.paytm.b.a.a getPref(Context context) {
            k.c(context, "context");
            a.C0708a aVar = com.paytm.b.a.a.f42641a;
            return a.C0708a.a(context, PaytmUpiPrefUtil.VERTICAL_ID);
        }

        public final com.paytm.b.a.a getPref(Context context, f.a aVar) {
            k.c(context, "context");
            k.c(aVar, "prefName");
            a.C0708a aVar2 = com.paytm.b.a.a.f42641a;
            return a.C0708a.a(context, PaytmUpiPrefUtil.VERTICAL_ID, aVar);
        }
    }
}
