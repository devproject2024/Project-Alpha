package com.google.firebase.b;

import android.content.Context;
import com.google.firebase.b.c;
import com.google.firebase.components.b;
import com.google.firebase.components.e;
import com.google.firebase.components.n;

public final class a implements c {

    /* renamed from: a  reason: collision with root package name */
    private d f38067a;

    private a(Context context) {
        this.f38067a = d.a(context);
    }

    public final c.a a(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        boolean a2 = this.f38067a.a(str, currentTimeMillis);
        boolean a3 = this.f38067a.a(currentTimeMillis);
        if (a2 && a3) {
            return c.a.COMBINED;
        }
        if (a3) {
            return c.a.GLOBAL;
        }
        if (a2) {
            return c.a.SDK;
        }
        return c.a.NONE;
    }

    public static b<c> a() {
        return b.a(c.class).a(n.b(Context.class)).a(b.a()).a();
    }

    static /* synthetic */ c a(e eVar) {
        return new a((Context) eVar.a(Context.class));
    }
}
