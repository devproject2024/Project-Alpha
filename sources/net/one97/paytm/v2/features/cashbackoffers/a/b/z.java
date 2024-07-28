package net.one97.paytm.v2.features.cashbackoffers.a.b;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ai;
import androidx.lifecycle.am;
import dagger.a.c;
import dagger.a.g;
import kotlin.g.b.k;
import net.one97.paytm.v2.features.cashbacklanding.d.d;
import net.one97.paytm.v2.features.cashbacklanding.d.e;
import net.one97.paytm.v2.features.cashbackoffers.c.a;
import net.one97.paytm.v2.features.cashbackoffers.c.b;
import net.one97.paytm.vipcashback.d.a;

public final class z implements c<a> {

    /* renamed from: a  reason: collision with root package name */
    private final y f20353a;

    /* renamed from: b  reason: collision with root package name */
    private final javax.a.a<Fragment> f20354b;

    public z(y yVar, javax.a.a<Fragment> aVar) {
        this.f20353a = yVar;
        this.f20354b = aVar;
    }

    public final /* synthetic */ Object get() {
        a aVar;
        y yVar = this.f20353a;
        Fragment fragment = this.f20354b.get();
        k.c(fragment, "activity");
        int i2 = yVar.f20352a;
        a.b.C0384a aVar2 = a.b.f20777a;
        if (i2 != a.b.f20778b) {
            a.b.C0384a aVar3 = a.b.f20777a;
            if (i2 != a.b.f20779c) {
                a.b.C0384a aVar4 = a.b.f20777a;
                if (i2 != a.b.f20782f) {
                    a.b.C0384a aVar5 = a.b.f20777a;
                    if (i2 == a.b.f20780d) {
                        ai a2 = am.a(fragment).a(net.one97.paytm.v2.features.cashbacklanding.d.a.class);
                        k.a((Object) a2, "ViewModelProviders.of(ac…ferViewModel::class.java)");
                        aVar = (net.one97.paytm.v2.features.cashbackoffers.c.a) a2;
                    } else {
                        a.b.C0384a aVar6 = a.b.f20777a;
                        if (i2 == a.b.f20781e) {
                            ai a3 = am.a(fragment).a(net.one97.paytm.v2.features.cashbacklanding.d.c.class);
                            k.a((Object) a3, "ViewModelProviders.of(ac…istViewModel::class.java)");
                            aVar = (net.one97.paytm.v2.features.cashbackoffers.c.a) a3;
                        } else {
                            a.b.C0384a aVar7 = a.b.f20777a;
                            if (i2 != a.b.f20783g) {
                                a.b.C0384a aVar8 = a.b.f20777a;
                                if (i2 != a.b.f20785i) {
                                    a.b.C0384a aVar9 = a.b.f20777a;
                                    if (i2 == a.b.f20784h) {
                                        ai a4 = am.a(fragment).a(b.class);
                                        k.a((Object) a4, "ViewModelProviders.of(ac…ersViewModel::class.java)");
                                        aVar = (net.one97.paytm.v2.features.cashbackoffers.c.a) a4;
                                    } else {
                                        ai a5 = am.a(fragment).a(d.class);
                                        k.a((Object) a5, "ViewModelProviders.of(ac…ferViewModel::class.java)");
                                        aVar = (net.one97.paytm.v2.features.cashbackoffers.c.a) a5;
                                    }
                                }
                            }
                            ai a6 = am.a(fragment).a(e.class);
                            k.a((Object) a6, "ViewModelProviders.of(ac…herViewModel::class.java)");
                            aVar = (net.one97.paytm.v2.features.cashbackoffers.c.a) a6;
                        }
                    }
                    return (net.one97.paytm.v2.features.cashbackoffers.c.a) g.a(aVar, "Cannot return null from a non-@Nullable @Provides method");
                }
            }
        }
        ai a7 = am.a(fragment).a(d.class);
        k.a((Object) a7, "ViewModelProviders.of(ac…ferViewModel::class.java)");
        aVar = (net.one97.paytm.v2.features.cashbackoffers.c.a) a7;
        return (net.one97.paytm.v2.features.cashbackoffers.c.a) g.a(aVar, "Cannot return null from a non-@Nullable @Provides method");
    }
}
