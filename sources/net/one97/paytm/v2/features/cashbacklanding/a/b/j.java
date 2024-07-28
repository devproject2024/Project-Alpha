package net.one97.paytm.v2.features.cashbacklanding.a.b;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ai;
import androidx.lifecycle.am;
import dagger.a.c;
import dagger.a.g;
import kotlin.g.b.k;
import net.one97.paytm.v2.features.b.c.a;

public final class j implements c<a> {

    /* renamed from: a  reason: collision with root package name */
    private final e f20139a;

    /* renamed from: b  reason: collision with root package name */
    private final javax.a.a<AppCompatActivity> f20140b;

    public j(e eVar, javax.a.a<AppCompatActivity> aVar) {
        this.f20139a = eVar;
        this.f20140b = aVar;
    }

    public final /* synthetic */ Object get() {
        AppCompatActivity appCompatActivity = this.f20140b.get();
        k.c(appCompatActivity, "activity");
        ai a2 = am.a((FragmentActivity) appCompatActivity).a(a.class);
        k.a((Object) a2, "ViewModelProviders.of(ac…ardViewModel::class.java)");
        return (a) g.a((a) a2, "Cannot return null from a non-@Nullable @Provides method");
    }
}
