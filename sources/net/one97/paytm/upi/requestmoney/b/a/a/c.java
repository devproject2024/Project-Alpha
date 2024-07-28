package net.one97.paytm.upi.requestmoney.b.a.a;

import android.content.Context;
import net.one97.paytm.upi.common.upi.UpiDBTransactionModel;
import net.one97.paytm.upi.e;
import net.one97.paytm.upi.requestmoney.b.a.a;
import net.one97.paytm.upi.util.PaytmUpiPrefUtil;
import net.one97.paytm.upi.util.UpiConstants;

public final class c implements a {

    /* renamed from: b  reason: collision with root package name */
    private static c f69117b;

    /* renamed from: a  reason: collision with root package name */
    private Context f69118a;

    public final void a(String str) {
    }

    public final void a(a.C1402a aVar, String str) {
    }

    public final void a(a.C1402a aVar, String str, int i2, String str2) {
    }

    public final void a(a.C1402a aVar, String str, String str2) {
    }

    public final void a(a.C1402a aVar, String str, String str2, String str3, String str4) {
    }

    public final void a(a.C1402a aVar, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
    }

    public final void a(a.C1402a aVar, String str, String str2, boolean z) {
    }

    public final void a(a.C1402a aVar, a.b bVar, int i2, int i3) {
    }

    public final void b(a.C1402a aVar, String str, String str2, String str3, String str4) {
    }

    private c(Context context) {
        this.f69118a = context;
    }

    public static synchronized c a(Context context) {
        c cVar;
        synchronized (c.class) {
            if (f69117b == null) {
                f69117b = new c(context);
            }
            cVar = f69117b;
        }
        return cVar;
    }

    public final boolean a() {
        return PaytmUpiPrefUtil.getPref(this.f69118a.getApplicationContext()).b(UpiConstants.PREF_KEY_IS_SAME_DEVICE, false, true);
    }

    public final void a(UpiDBTransactionModel upiDBTransactionModel) {
        new a(this.f69118a, upiDBTransactionModel).execute(new Object[0]);
    }

    public final void a(e eVar) {
        new b(this.f69118a, "request", eVar).execute(new String[0]);
    }
}
