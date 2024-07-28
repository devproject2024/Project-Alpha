package net.one97.paytm.landingpage.leftNavigation;

import android.app.Application;
import androidx.lifecycle.a;
import androidx.lifecycle.y;
import kotlin.g.b.k;

public final class g extends a {

    /* renamed from: a  reason: collision with root package name */
    public y<Boolean> f52854a = new y<>();

    /* renamed from: b  reason: collision with root package name */
    public y<Boolean> f52855b = new y<>();

    /* renamed from: c  reason: collision with root package name */
    public y<Boolean> f52856c = new y<>();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g(Application application) {
        super(application);
        k.c(application, "application");
    }

    public final void a(boolean z) {
        this.f52854a.setValue(Boolean.valueOf(z));
    }
}
