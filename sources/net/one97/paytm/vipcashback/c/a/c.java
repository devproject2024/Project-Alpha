package net.one97.paytm.vipcashback.c.a;

import androidx.lifecycle.y;
import kotlin.g.b.k;
import net.one97.paytm.vipcashback.f.h;

public final class c implements b {

    /* renamed from: a  reason: collision with root package name */
    private final b f20715a;

    public c(b bVar) {
        k.c(bVar, "remoteDataSource");
        this.f20715a = bVar;
    }

    public final void a(y<h<Object>> yVar, String str) {
        k.c(str, "scratchCardId");
        this.f20715a.a(yVar, str);
    }

    public final void b(y<h<Object>> yVar, String str) {
        k.c(str, "data");
        this.f20715a.b(yVar, str);
    }

    public final void a(y<h<Object>> yVar, int i2, int i3, String str, String str2, String str3) {
        this.f20715a.a(yVar, i2, i3, str, str2, str3);
    }
}
