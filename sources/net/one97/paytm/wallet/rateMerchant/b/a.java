package net.one97.paytm.wallet.rateMerchant.b;

import android.content.Context;
import kotlin.g.b.k;
import kotlin.o;
import net.one97.paytm.wallet.rateMerchant.entity.MerchantPPReviewData;

public final class a {

    /* renamed from: c  reason: collision with root package name */
    public static final C1456a f71628c = new C1456a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static a f71629e;

    /* renamed from: a  reason: collision with root package name */
    o<String, String> f71630a;

    /* renamed from: b  reason: collision with root package name */
    MerchantPPReviewData f71631b;

    /* renamed from: d  reason: collision with root package name */
    private final Context f71632d;

    public a(Context context) {
        k.c(context, "appContext");
        this.f71632d = context;
    }

    /* renamed from: net.one97.paytm.wallet.rateMerchant.b.a$a  reason: collision with other inner class name */
    public static final class C1456a {
        private C1456a() {
        }

        public /* synthetic */ C1456a(byte b2) {
            this();
        }

        public static a a(Context context) {
            k.c(context, "appContext");
            if (a.f71629e == null) {
                a.f71629e = new a(context);
            }
            a a2 = a.f71629e;
            if (a2 == null) {
                k.a();
            }
            return a2;
        }
    }
}
