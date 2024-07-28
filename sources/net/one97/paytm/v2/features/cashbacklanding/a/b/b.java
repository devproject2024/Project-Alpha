package net.one97.paytm.v2.features.cashbacklanding.a.b;

import android.content.Context;
import dagger.a.c;
import javax.a.a;
import kotlin.g.b.k;
import net.one97.paytm.v2.a.f;
import net.one97.paytm.v2.features.cashbackoffers.b.g;
import net.one97.paytm.v2.features.cashbackoffers.b.h;
import net.one97.paytm.vipcashback.d.a;

public final class b implements c<f> {

    /* renamed from: a  reason: collision with root package name */
    private final a f20127a;

    /* renamed from: b  reason: collision with root package name */
    private final a<Context> f20128b;

    public b(a aVar, a<Context> aVar2) {
        this.f20127a = aVar;
        this.f20128b = aVar2;
    }

    public final /* synthetic */ Object get() {
        f fVar;
        a aVar = this.f20127a;
        Context context = this.f20128b.get();
        k.c(context, "context");
        int i2 = aVar.f20126a;
        a.b.C0384a aVar2 = a.b.f20777a;
        if (i2 == a.b.f20778b) {
            fVar = new net.one97.paytm.v2.features.cashbackoffers.b.a(context);
        } else {
            a.b.C0384a aVar3 = a.b.f20777a;
            if (i2 == a.b.f20779c) {
                fVar = new g(context);
            } else {
                a.b.C0384a aVar4 = a.b.f20777a;
                if (i2 == a.b.f20782f) {
                    fVar = new net.one97.paytm.v2.features.cashbackoffers.b.b(context);
                } else {
                    a.b.C0384a aVar5 = a.b.f20777a;
                    if (i2 == a.b.f20785i) {
                        fVar = new net.one97.paytm.v2.features.a.a(context);
                    } else {
                        a.b.C0384a aVar6 = a.b.f20777a;
                        if (i2 == a.b.j) {
                            fVar = new h(context);
                        } else {
                            fVar = new net.one97.paytm.v2.a.a(context);
                        }
                    }
                }
            }
        }
        return (f) dagger.a.g.a(fVar, "Cannot return null from a non-@Nullable @Provides method");
    }
}
