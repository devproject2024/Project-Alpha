package net.one97.paytm.p2b.d;

import kotlin.g.b.k;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    public static final a f12718a = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static h f12719c;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public net.one97.paytm.p2b.b.a f12720b;

    public static final /* synthetic */ net.one97.paytm.p2b.b.a b(h hVar) {
        net.one97.paytm.p2b.b.a aVar = hVar.f12720b;
        if (aVar == null) {
            k.a("iP2bListenerProvider");
        }
        return aVar;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static h a() {
            h a2 = h.f12719c;
            if (a2 != null) {
                return a2;
            }
            throw new RuntimeException("getInstance() called before P2bListenerProvider's init()");
        }
    }

    public static final net.one97.paytm.p2b.b.a b() {
        return b(a.a());
    }
}
