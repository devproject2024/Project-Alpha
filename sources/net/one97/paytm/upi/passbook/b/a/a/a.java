package net.one97.paytm.upi.passbook.b.a.a;

import android.content.Context;
import net.one97.paytm.upi.common.upi.UpiTxnHistoryV2RequestBody;
import net.one97.paytm.upi.passbook.b.a.a;

public final class a implements net.one97.paytm.upi.passbook.b.a.a {

    /* renamed from: a  reason: collision with root package name */
    private static a f67618a;

    /* renamed from: b  reason: collision with root package name */
    private Context f67619b;

    public final void a() {
    }

    public final void a(String str) {
    }

    public final void a(a.C1379a aVar, String str, int i2, String str2) {
    }

    public final void a(a.C1379a aVar, String str, String str2) {
    }

    public final void a(a.C1379a aVar, String str, String str2, String str3) {
    }

    public final void a(a.C1379a aVar, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
    }

    public final void a(a.C1379a aVar, String str, UpiTxnHistoryV2RequestBody upiTxnHistoryV2RequestBody) {
    }

    public final void a(a.b bVar, String str, String str2, String str3, String str4, String str5) {
    }

    public final void b(a.C1379a aVar, String str, int i2, String str2) {
    }

    public final void b(a.C1379a aVar, String str, String str2, String str3) {
    }

    private a(Context context) {
        this.f67619b = context;
    }

    public static synchronized a a(Context context) {
        a aVar;
        synchronized (a.class) {
            if (f67618a == null) {
                f67618a = new a(context);
            }
            aVar = f67618a;
        }
        return aVar;
    }
}
