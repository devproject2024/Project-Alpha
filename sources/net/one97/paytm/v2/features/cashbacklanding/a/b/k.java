package net.one97.paytm.v2.features.cashbacklanding.a.b;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ai;
import androidx.lifecycle.am;
import dagger.a.c;
import dagger.a.g;
import net.one97.paytm.v2.features.cashbacklanding.d.a;

public final class k implements c<a> {

    /* renamed from: a  reason: collision with root package name */
    private final e f20141a;

    /* renamed from: b  reason: collision with root package name */
    private final javax.a.a<AppCompatActivity> f20142b;

    public k(e eVar, javax.a.a<AppCompatActivity> aVar) {
        this.f20141a = eVar;
        this.f20142b = aVar;
    }

    public final /* synthetic */ Object get() {
        AppCompatActivity appCompatActivity = this.f20142b.get();
        kotlin.g.b.k.c(appCompatActivity, "activity");
        ai a2 = am.a((FragmentActivity) appCompatActivity).a(a.class);
        kotlin.g.b.k.a((Object) a2, "ViewModelProviders.of(ac…ferViewModel::class.java)");
        return (a) g.a((a) a2, "Cannot return null from a non-@Nullable @Provides method");
    }
}
