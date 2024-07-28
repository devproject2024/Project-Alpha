package net.one97.paytm.paymentsBank.slfd;

import android.content.Context;
import kotlin.g.b.k;
import net.one97.paytm.paymentsBank.slfd.a.a.a.a;
import net.one97.paytm.paymentsBank.slfd.a.a.b;
import net.one97.paytm.paymentsBank.slfd.a.a.b.a;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final c f18958a = new c();

    private c() {
    }

    public static b a(Context context) {
        k.c(context, "context");
        b.a aVar = b.f18944a;
        a.C0326a aVar2 = a.f18941a;
        k.c(context, "context");
        a a2 = a.f18942c;
        if (a2 == null) {
            a2 = new a(context);
            a.f18942c = a2;
        }
        net.one97.paytm.paymentsBank.slfd.a.a.a aVar3 = a2;
        a.C0327a aVar4 = net.one97.paytm.paymentsBank.slfd.a.a.b.a.f18948b;
        k.c(context, "context");
        net.one97.paytm.paymentsBank.slfd.a.a.b.a a3 = net.one97.paytm.paymentsBank.slfd.a.a.b.a.f18949c;
        if (a3 == null) {
            a3 = new net.one97.paytm.paymentsBank.slfd.a.a.b.a(context);
            net.one97.paytm.paymentsBank.slfd.a.a.b.a.f18949c = a3;
        }
        net.one97.paytm.paymentsBank.slfd.a.a.a aVar5 = a3;
        k.c(aVar3, "slfdLocalDataSource");
        k.c(aVar5, "slfdRemoteDataSource");
        b a4 = b.f18945d;
        if (a4 != null) {
            return a4;
        }
        b bVar = new b(aVar3, aVar5);
        b.f18945d = bVar;
        return bVar;
    }
}
