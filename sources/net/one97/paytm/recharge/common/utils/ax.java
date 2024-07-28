package net.one97.paytm.recharge.common.utils;

import android.content.Context;
import com.paytm.b.a.a;
import com.paytm.network.a;
import com.paytm.utility.f;
import kotlin.g.b.k;

public final class ax {

    /* renamed from: a  reason: collision with root package name */
    public static final a f61521a = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final a.c f61522b = a.c.RECHARGES;

    public static final com.paytm.b.a.a a(Context context) {
        return a.a(context);
    }

    public static final com.paytm.b.a.a a(Context context, f.a aVar) {
        return a.a(context, aVar);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static com.paytm.b.a.a a(Context context) {
            k.c(context, "context");
            a.C0708a aVar = com.paytm.b.a.a.f42641a;
            return a.C0708a.a(context, ax.f61522b);
        }

        public static com.paytm.b.a.a a(Context context, f.a aVar) {
            k.c(context, "context");
            k.c(aVar, "prefName");
            a.C0708a aVar2 = com.paytm.b.a.a.f42641a;
            return a.C0708a.a(context, ax.f61522b, aVar);
        }
    }
}
