package com.google.android.exoplayer2.f;

import android.content.Context;
import com.google.android.exoplayer2.f.i;

public final class p implements i.a {

    /* renamed from: a  reason: collision with root package name */
    private final Context f32438a;

    /* renamed from: b  reason: collision with root package name */
    private final ad f32439b;

    /* renamed from: c  reason: collision with root package name */
    private final i.a f32440c;

    public p(Context context, String str) {
        this(context, str, (byte) 0);
    }

    private p(Context context, String str, byte b2) {
        this(context, (ad) null, (i.a) new r(str, (ad) null));
    }

    public p(Context context, ad adVar, i.a aVar) {
        this.f32438a = context.getApplicationContext();
        this.f32439b = adVar;
        this.f32440c = aVar;
    }

    public final /* synthetic */ i a() {
        o oVar = new o(this.f32438a, this.f32440c.a());
        ad adVar = this.f32439b;
        if (adVar != null) {
            oVar.a(adVar);
        }
        return oVar;
    }
}
