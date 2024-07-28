package net.one97.paytm.v2.features.cashbackoffers.a.b;

import androidx.lifecycle.ai;
import androidx.lifecycle.am;
import dagger.a.c;
import dagger.a.g;
import kotlin.g.b.k;
import net.one97.paytm.vipcashback.c.d;

public final class x implements c<d> {

    /* renamed from: a  reason: collision with root package name */
    private final v f20351a;

    public x(v vVar) {
        this.f20351a = vVar;
    }

    public final /* synthetic */ Object get() {
        ai a2 = am.a(this.f20351a.f20349a).a(d.class);
        k.a((Object) a2, "ViewModelProviders.of(ac…ackViewModel::class.java)");
        return (d) g.a((d) a2, "Cannot return null from a non-@Nullable @Provides method");
    }
}
