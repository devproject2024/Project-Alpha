package net.one97.paytm.v2.features.cashbacklanding.a.b;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ai;
import androidx.lifecycle.am;
import dagger.a.c;
import dagger.a.g;
import javax.a.a;
import kotlin.g.b.k;
import net.one97.paytm.v2.features.cashbacklanding.d.d;

public final class i implements c<d> {

    /* renamed from: a  reason: collision with root package name */
    private final e f20137a;

    /* renamed from: b  reason: collision with root package name */
    private final a<AppCompatActivity> f20138b;

    public i(e eVar, a<AppCompatActivity> aVar) {
        this.f20137a = eVar;
        this.f20138b = aVar;
    }

    public final /* synthetic */ Object get() {
        AppCompatActivity appCompatActivity = this.f20138b.get();
        k.c(appCompatActivity, "activity");
        ai a2 = am.a((FragmentActivity) appCompatActivity).a(d.class);
        k.a((Object) a2, "ViewModelProviders.of(ac…ferViewModel::class.java)");
        return (d) g.a((d) a2, "Cannot return null from a non-@Nullable @Provides method");
    }
}
