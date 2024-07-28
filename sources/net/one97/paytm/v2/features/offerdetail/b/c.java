package net.one97.paytm.v2.features.offerdetail.b;

import androidx.lifecycle.y;
import kotlin.g.b.k;
import net.one97.paytm.vipcashback.f.h;

public final class c implements b {

    /* renamed from: a  reason: collision with root package name */
    private final a f20449a;

    public c(a aVar) {
        k.c(aVar, "offerDetailRemoteDataSource");
        this.f20449a = aVar;
    }

    public final void b(y<h<Object>> yVar, String str) {
        k.c(yVar, "liveData");
        k.c(str, "url");
        this.f20449a.b(yVar, str);
    }

    public final void a(y<h<Object>> yVar, String str) {
        k.c(yVar, "liveData");
        k.c(str, "gameId");
        this.f20449a.a(yVar, str);
    }

    public final void a(y<h<Object>> yVar, String str, String str2, String str3) {
        k.c(yVar, "liveData");
        k.c(str, "campaignId");
        k.c(str3, "action");
        this.f20449a.a(yVar, str, str2, str3);
    }

    public final void c(y<h<Object>> yVar, String str) {
        k.c(yVar, "liveData");
        k.c(str, "campaignId");
        this.f20449a.c(yVar, str);
    }
}
