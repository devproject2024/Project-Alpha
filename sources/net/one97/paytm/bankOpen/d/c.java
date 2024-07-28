package net.one97.paytm.bankOpen.d;

import android.content.Context;
import com.paytm.b.a.a;
import com.paytm.network.a;
import com.paytm.utility.f;
import kotlin.g.b.k;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final a f16425a = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final a.c f16426b = a.c.PAYMENTSBANK;

    public static final com.paytm.b.a.a a(Context context) {
        return a.a(context);
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
            return a.C0708a.a(context, c.f16426b);
        }
    }

    public static final com.paytm.b.a.a a(Context context, f.a aVar) {
        k.c(context, "context");
        k.c(aVar, "prefName");
        a.C0708a aVar2 = com.paytm.b.a.a.f42641a;
        return a.C0708a.a(context, f16426b, aVar);
    }
}
