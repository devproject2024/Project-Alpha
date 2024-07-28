package com.paytm.ads.a;

import a.a.a.a.a.b.c;
import a.a.a.a.a.b.d;
import a.a.a.a.a.b.f;
import a.a.a.a.a.b.g;
import a.a.a.a.a.b.h;
import android.content.Context;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import kotlin.g.b.k;
import kotlin.m;

public final class b implements a {

    /* renamed from: a  reason: collision with root package name */
    public static final C0681b f40870a = new C0681b((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static b f40871b;

    /* renamed from: c  reason: collision with root package name */
    private final com.paytm.ads.c.a f40872c;

    public enum a {
        NATIVE
    }

    /* renamed from: com.paytm.ads.a.b$b  reason: collision with other inner class name */
    public static final class C0681b {
        private C0681b() {
        }

        public /* synthetic */ C0681b(byte b2) {
            this();
        }
    }

    private b(com.paytm.ads.c.a aVar) {
        this.f40872c = aVar;
        Executors.newCachedThreadPool();
    }

    public /* synthetic */ b(com.paytm.ads.c.a aVar, byte b2) {
        this(aVar);
    }

    public final synchronized com.paytm.ads.d.a a(a aVar, ArrayList<com.paytm.ads.b> arrayList, String str) {
        a.a.a.a.a.b.b bVar;
        k.c(aVar, "adOwner");
        if (arrayList != null) {
            if (arrayList.isEmpty()) {
                throw new Exception();
            }
        }
        if (c.f40875a[aVar.ordinal()] == 1) {
            com.paytm.ads.c.a aVar2 = this.f40872c;
            if (arrayList == null) {
                k.a();
            }
            k.c(arrayList, "verificationResources");
            Context context = aVar2.f40883c;
            a.a.a.a.a.a.a();
            bVar = null;
            a.a.a.a.a.a.a(context != null ? context.getApplicationContext() : null);
            if (aVar2.f40881a == null && aVar2.f40882b < 5) {
                aVar2.a();
                if (aVar2.f40881a == null) {
                }
            } else if (aVar2.f40881a == null) {
            }
            c a2 = c.a(f.NATIVE, f.NONE);
            g a3 = g.a(aVar2.f40884d, aVar2.f40885e);
            String str2 = aVar2.f40881a;
            com.paytm.ads.d.b bVar2 = com.paytm.ads.d.b.f40894a;
            ArrayList<h> a4 = com.paytm.ads.d.b.a(arrayList);
            if (str == null) {
                str = "";
            }
            bVar = a.a.a.a.a.b.b.a(a2, d.a(a3, str2, a4, str));
        } else {
            throw new m();
        }
        return new com.paytm.ads.d.a(bVar);
    }
}
