package net.one97.paytm.v2.features.offerdetail.a.a;

import androidx.lifecycle.ai;
import androidx.lifecycle.am;
import dagger.a.c;
import dagger.a.g;
import kotlin.g.b.k;
import net.one97.paytm.v2.features.offerdetail.c.a;

public final class b implements c<a> {

    /* renamed from: a  reason: collision with root package name */
    private final a f20439a;

    public b(a aVar) {
        this.f20439a = aVar;
    }

    public final /* synthetic */ Object get() {
        ai a2 = am.a(this.f20439a.f20438a).a(a.class);
        k.a((Object) a2, "ViewModelProviders.of(ac…ainViewModel::class.java)");
        return (a) g.a((a) a2, "Cannot return null from a non-@Nullable @Provides method");
    }
}
