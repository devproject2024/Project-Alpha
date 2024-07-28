package net.one97.paytm.v2.features.cashbackoffers.a.b;

import dagger.a.c;
import dagger.a.g;
import javax.a.a;
import kotlin.g.b.k;
import net.one97.paytm.v2.features.cashbacklanding.c.b;
import net.one97.paytm.v2.features.cashbacklanding.c.e;
import net.one97.paytm.vipcashback.d.a;

public final class d implements c<b> {

    /* renamed from: a  reason: collision with root package name */
    private final c f20325a;

    /* renamed from: b  reason: collision with root package name */
    private final a<net.one97.paytm.v2.features.cashbacklanding.c.a> f20326b;

    public d(c cVar, a<net.one97.paytm.v2.features.cashbacklanding.c.a> aVar) {
        this.f20325a = cVar;
        this.f20326b = aVar;
    }

    public final /* synthetic */ Object get() {
        b bVar;
        c cVar = this.f20325a;
        net.one97.paytm.v2.features.cashbacklanding.c.a aVar = this.f20326b.get();
        k.c(aVar, "adapterHelper");
        int i2 = cVar.f20324b;
        a.b.C0384a aVar2 = a.b.f20777a;
        if (i2 != a.b.f20778b) {
            int i3 = cVar.f20324b;
            a.b.C0384a aVar3 = a.b.f20777a;
            if (i3 != a.b.f20779c) {
                bVar = new e(aVar);
                return (b) g.a(bVar, "Cannot return null from a non-@Nullable @Provides method");
            }
        }
        bVar = new net.one97.paytm.v2.features.cashbacklanding.c.c();
        return (b) g.a(bVar, "Cannot return null from a non-@Nullable @Provides method");
    }
}
