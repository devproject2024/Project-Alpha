package net.one97.paytm.v2.a;

import androidx.lifecycle.y;
import kotlin.g.b.k;
import net.one97.paytm.vipcashback.f.h;

public final class e implements d {

    /* renamed from: a  reason: collision with root package name */
    private final c f20053a;

    public e(c cVar) {
        k.c(cVar, "remoteDataSource");
        this.f20053a = cVar;
    }

    public final void a(y<h<Object>> yVar, String str) {
        k.c(yVar, "result");
        k.c(str, "refrenceId");
        this.f20053a.a(yVar, str);
    }

    public final void b(y<h<Object>> yVar, String str) {
        k.c(yVar, "liveData");
        k.c(str, "scratchCardId");
        this.f20053a.b(yVar, str);
    }
}
