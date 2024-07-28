package com.google.android.gms.auth.api.signin;

import android.content.Context;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.l;
import com.google.android.gms.common.c;
import com.google.android.gms.common.h;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.dynamite.DynamiteModule;

public final class b extends d<GoogleSignInOptions> {

    /* renamed from: a  reason: collision with root package name */
    private static final a f8232a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private static int f8233b = C0119b.f8234a;

    static class a implements r.a<c, GoogleSignInAccount> {
        private a() {
        }

        public final /* synthetic */ Object a(l lVar) {
            return ((c) lVar).f8239a;
        }

        /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* 'enum' modifier removed */
    /* renamed from: com.google.android.gms.auth.api.signin.b$b  reason: collision with other inner class name */
    public static final class C0119b {

        /* renamed from: a  reason: collision with root package name */
        public static final int f8234a = 1;

        /* renamed from: b  reason: collision with root package name */
        public static final int f8235b = 2;

        /* renamed from: c  reason: collision with root package name */
        public static final int f8236c = 3;

        /* renamed from: d  reason: collision with root package name */
        public static final int f8237d = 4;

        /* renamed from: e  reason: collision with root package name */
        private static final /* synthetic */ int[] f8238e = {f8234a, f8235b, f8236c, f8237d};
    }

    public b(Context context, GoogleSignInOptions googleSignInOptions) {
        super(context, com.google.android.gms.auth.api.a.f8074e, googleSignInOptions, (com.google.android.gms.common.api.internal.r) new com.google.android.gms.common.api.internal.a());
    }

    public final synchronized int a() {
        if (f8233b == C0119b.f8234a) {
            Context applicationContext = getApplicationContext();
            c a2 = c.a();
            int a3 = a2.a(applicationContext, (int) h.f8688b);
            if (a3 == 0) {
                f8233b = C0119b.f8237d;
            } else if (a2.a(applicationContext, a3, (String) null) != null || DynamiteModule.a(applicationContext, "com.google.android.gms.auth.api.fallback") == 0) {
                f8233b = C0119b.f8235b;
            } else {
                f8233b = C0119b.f8236c;
            }
        }
        return f8233b;
    }
}
