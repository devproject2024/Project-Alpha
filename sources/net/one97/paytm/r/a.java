package net.one97.paytm.r;

import android.app.Application;
import androidx.lifecycle.y;
import kotlin.g.b.k;

public final class a extends androidx.lifecycle.a {

    /* renamed from: a  reason: collision with root package name */
    public y<Boolean> f60169a = new y<>();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(Application application) {
        super(application);
        k.c(application, "application");
    }

    public final void a(boolean z) {
        y<Boolean> yVar = this.f60169a;
        if (yVar != null) {
            yVar.setValue(Boolean.valueOf(z));
        }
    }
}
