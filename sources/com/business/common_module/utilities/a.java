package com.business.common_module.utilities;

import android.content.Context;
import com.paytm.b.a.a;
import com.paytm.network.a;
import kotlin.g.b.k;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final C0104a f7354a = new C0104a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final a.c f7355b = a.c.ACCEPTPAYMENT;

    public static final com.paytm.b.a.a a(Context context) {
        return C0104a.a(context);
    }

    /* renamed from: com.business.common_module.utilities.a$a  reason: collision with other inner class name */
    public static final class C0104a {
        private C0104a() {
        }

        public /* synthetic */ C0104a(byte b2) {
            this();
        }

        public static com.paytm.b.a.a a(Context context) {
            k.d(context, "context");
            a.C0708a aVar = com.paytm.b.a.a.f42641a;
            return a.C0708a.a(context, a.f7355b);
        }
    }
}
