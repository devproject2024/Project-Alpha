package com.paytm.contactsSdk.utils;

import android.content.Context;
import com.paytm.b.a.a;
import com.paytm.network.a;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class ContactPrefUtils {
    public static final Companion Companion = new Companion((g) null);
    /* access modifiers changed from: private */
    public static final a.c VERTICAL_ID = a.c.COMS;

    public static final com.paytm.b.a.a getPref(Context context) {
        return Companion.getPref(context);
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
            return a.C0708a.a(context, ContactPrefUtils.VERTICAL_ID);
        }
    }
}
