package net.one97.paytm.feed.a;

import android.content.ComponentName;
import androidx.browser.customtabs.c;
import androidx.browser.customtabs.e;
import java.lang.ref.WeakReference;
import kotlin.g.b.k;

public final class b extends e {

    /* renamed from: b  reason: collision with root package name */
    private final WeakReference<c> f33788b;

    public b(c cVar) {
        k.c(cVar, "connectionCallback");
        this.f33788b = new WeakReference<>(cVar);
    }

    public final void a(ComponentName componentName, c cVar) {
        k.c(componentName, "name");
        k.c(cVar, "client");
        c cVar2 = (c) this.f33788b.get();
        if (cVar2 != null) {
            cVar2.a(cVar);
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        k.c(componentName, "name");
        c cVar = (c) this.f33788b.get();
        if (cVar != null) {
            cVar.b();
        }
    }
}
