package net.one97.paytm.upi.requestmoney.b.a;

import net.one97.paytm.upi.common.upi.UpiDBTransactionModel;
import net.one97.paytm.upi.e;
import net.one97.paytm.upi.requestmoney.b.a.a;

public final class b implements a {

    /* renamed from: a  reason: collision with root package name */
    private static b f69119a;

    /* renamed from: b  reason: collision with root package name */
    private final a f69120b;

    /* renamed from: c  reason: collision with root package name */
    private final a f69121c;

    private b(a aVar, a aVar2) {
        this.f69120b = aVar;
        this.f69121c = aVar2;
    }

    public static b a(a aVar, a aVar2) {
        if (f69119a == null) {
            f69119a = new b(aVar, aVar2);
        }
        return f69119a;
    }

    public final void a(a.C1402a aVar, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        this.f69121c.a(aVar, str, str2, str3, str4, str5, str6, str7, str8, str9, str10);
    }

    public final void a(a.C1402a aVar, String str, String str2) {
        this.f69121c.a(aVar, str, str2);
    }

    public final void a(a.C1402a aVar, String str, String str2, String str3, String str4) {
        this.f69121c.a(aVar, str, str2, str3, str4);
    }

    public final boolean a() {
        return this.f69120b.a();
    }

    public final void a(String str) {
        this.f69121c.a(str);
    }

    public final void a(UpiDBTransactionModel upiDBTransactionModel) {
        this.f69120b.a(upiDBTransactionModel);
    }

    public final void a(e eVar) {
        this.f69120b.a(eVar);
    }

    public final void a(a.C1402a aVar, String str) {
        this.f69121c.a(aVar, str);
    }

    public final void a(a.C1402a aVar, String str, int i2, String str2) {
        this.f69121c.a(aVar, str, i2, str2);
    }

    public final void a(a.C1402a aVar, String str, String str2, boolean z) {
        this.f69121c.a(aVar, str, str2, z);
    }

    public final void a(a.C1402a aVar, a.b bVar, int i2, int i3) {
        this.f69121c.a(aVar, bVar, i2, i3);
    }

    public final void b(a.C1402a aVar, String str, String str2, String str3, String str4) {
        this.f69121c.b(aVar, str, str2, str3, str4);
    }
}
