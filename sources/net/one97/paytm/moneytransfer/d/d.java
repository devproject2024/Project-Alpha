package net.one97.paytm.moneytransfer.d;

import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.moneytransferv4.d.a.b;
import net.one97.paytm.moneytransferv4.d.a.d;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final a f53996a = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static d f53997c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static net.one97.paytm.moneytransferv4.d.a.a f53998d;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public a f53999b;

    public static final /* synthetic */ a b(d dVar) {
        a aVar = dVar.f53999b;
        if (aVar == null) {
            k.a("iMoneyTransferListener");
        }
        return aVar;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static void a(a aVar) {
            k.c(aVar, "iMoneyTransferListener");
            if (d.f53997c == null) {
                d.f53997c = new d();
                d a2 = d.f53997c;
                if (a2 == null) {
                    k.a();
                }
                a2.f53999b = aVar;
            }
            b();
        }

        private static void b() {
            d.a a2 = net.one97.paytm.moneytransferv4.d.a.d.a();
            d a3 = d.f53997c;
            if (a3 == null) {
                k.a();
            }
            net.one97.paytm.moneytransferv4.d.a.a a4 = a2.a(new b(d.b(a3).a())).a();
            k.a((Object) a4, "DaggerAppComponent.build…\n                .build()");
            d.f53998d = a4;
        }

        public static d a() {
            if (d.f53997c == null) {
                try {
                    Class<?> cls = Class.forName("net.one97.paytm.moneytransfer.MoneyTransferImplProvider");
                    k.a((Object) cls, "Class.forName(MT_IMPL_CLASS_PATH)");
                    if (cls != null) {
                        Object newInstance = cls.newInstance();
                        if (newInstance != null) {
                            a((a) newInstance);
                        } else {
                            throw new u("null cannot be cast to non-null type net.one97.paytm.moneytransfer.helper.IMoneyTransferListener");
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            d a2 = d.f53997c;
            if (a2 == null) {
                k.a();
            }
            return a2;
        }
    }

    public static final a c() {
        return b(a.a());
    }
}
