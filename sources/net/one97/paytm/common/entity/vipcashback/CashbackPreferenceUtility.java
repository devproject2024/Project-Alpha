package net.one97.paytm.common.entity.vipcashback;

import android.content.Context;
import com.paytm.b.a.a;
import com.paytm.network.a;
import com.paytm.utility.f;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class CashbackPreferenceUtility {
    public static final Companion Companion = new Companion((g) null);
    /* access modifiers changed from: private */
    public static final a.c VERTICAL_ID = a.c.CASHBACK;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final com.paytm.b.a.a getPref(Context context) {
            k.c(context, "context");
            a.C0708a aVar = com.paytm.b.a.a.f42641a;
            return a.C0708a.a(context, CashbackPreferenceUtility.VERTICAL_ID);
        }

        public final com.paytm.b.a.a getPref(Context context, f.a aVar) {
            k.c(context, "context");
            k.c(aVar, "prefName");
            a.C0708a aVar2 = com.paytm.b.a.a.f42641a;
            return a.C0708a.a(context, CashbackPreferenceUtility.VERTICAL_ID, aVar);
        }
    }
}
