package net.one97.paytm.phoenix.core;

import android.app.Activity;
import kotlin.g.b.k;
import net.one97.paytm.phoenix.api.b;
import net.one97.paytm.phoenix.api.e;
import net.one97.paytm.phoenix.api.f;
import net.one97.paytm.phoenix.e.a;
import net.one97.paytm.phoenix.manager.d;
import net.one97.paytm.phoenix.ui.PhoenixActivity;

public final class c implements a {

    /* renamed from: a  reason: collision with root package name */
    public static final c f59399a = new c();

    /* renamed from: b  reason: collision with root package name */
    private static e f59400b;

    /* renamed from: c  reason: collision with root package name */
    private static f f59401c;

    private c() {
    }

    public final e a() {
        e eVar;
        e eVar2 = f59400b;
        if (eVar2 != null) {
            return eVar2;
        }
        synchronized (this) {
            eVar = f59400b;
            if (eVar == null) {
                net.one97.paytm.phoenix.manager.c cVar = new net.one97.paytm.phoenix.manager.c();
                f59400b = cVar;
                eVar = cVar;
            }
        }
        return eVar;
    }

    public final f b() {
        f fVar;
        f fVar2 = f59401c;
        if (fVar2 != null) {
            return fVar2;
        }
        synchronized (this) {
            fVar = f59401c;
            if (fVar == null) {
                d dVar = new d();
                f59401c = dVar;
                fVar = dVar;
            }
        }
        return fVar;
    }

    public final b a(Activity activity) {
        k.c(activity, "activity");
        if (activity instanceof PhoenixActivity) {
            return ((PhoenixActivity) activity).d();
        }
        return null;
    }
}
