package net.one97.paytm.paymentsBank.si.f;

import net.one97.paytm.paymentsBank.si.f.a;

public final class b implements a {

    /* renamed from: a  reason: collision with root package name */
    private static b f18899a;

    /* renamed from: b  reason: collision with root package name */
    private final a f18900b;

    private b(a aVar) {
        this.f18900b = aVar;
    }

    public static b a(a aVar) {
        if (f18899a == null) {
            f18899a = new b(aVar);
        }
        return f18899a;
    }

    public final void a(a.C0325a aVar, a.b bVar, int i2, int i3) {
        this.f18900b.a(aVar, bVar, i2, i3);
    }

    public final void a(a.C0325a aVar, String str, String str2, boolean z) {
        this.f18900b.a(aVar, str, str2, z);
    }
}
