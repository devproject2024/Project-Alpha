package net.one97.paytm.upi.passbook.b.a;

import net.one97.paytm.upi.common.upi.UpiTxnHistoryV2RequestBody;
import net.one97.paytm.upi.passbook.b.a.a;

public final class b implements a {

    /* renamed from: a  reason: collision with root package name */
    private static b f67620a;

    /* renamed from: b  reason: collision with root package name */
    private final a f67621b;

    /* renamed from: c  reason: collision with root package name */
    private final a f67622c;

    private b(a aVar, a aVar2) {
        this.f67621b = aVar;
        this.f67622c = aVar2;
    }

    public static b a(a aVar, a aVar2) {
        if (f67620a == null) {
            f67620a = new b(aVar, aVar2);
        }
        return f67620a;
    }

    public final void a(a.C1379a aVar, String str, String str2) {
        this.f67622c.a(aVar, str, str2);
    }

    public final void a(a.C1379a aVar, String str, int i2, String str2) {
        this.f67622c.a(aVar, str, i2, str2);
    }

    public final void a(a.C1379a aVar, String str, String str2, String str3) {
        this.f67622c.a(aVar, str, str2, str3);
    }

    public final void a(a.C1379a aVar, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        this.f67622c.a(aVar, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11);
    }

    public final void a(a.b bVar, String str, String str2, String str3, String str4, String str5) {
        this.f67622c.a(bVar, str, str2, str3, str4, str5);
    }

    public final void b(a.C1379a aVar, String str, int i2, String str2) {
        this.f67622c.b(aVar, str, i2, str2);
    }

    public final void a() {
        this.f67622c.a();
    }

    public final void b(a.C1379a aVar, String str, String str2, String str3) {
        a();
        this.f67622c.b(aVar, str, str2, str3);
    }

    public final void a(String str) {
        this.f67622c.a(str);
    }

    public final void a(a.C1379a aVar, String str, UpiTxnHistoryV2RequestBody upiTxnHistoryV2RequestBody) {
        this.f67622c.a(aVar, str, upiTxnHistoryV2RequestBody);
    }
}
