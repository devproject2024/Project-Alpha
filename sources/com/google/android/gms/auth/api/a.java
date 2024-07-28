package com.google.android.gms.auth.api;

import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.f;
import com.google.android.gms.auth.api.signin.internal.i;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.internal.p000authapi.g;
import com.google.android.gms.internal.p000authapi.h;
import java.util.Arrays;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a.g<h> f8070a = new a.g<>();

    /* renamed from: b  reason: collision with root package name */
    public static final a.g<i> f8071b = new a.g<>();
    @Deprecated

    /* renamed from: c  reason: collision with root package name */
    public static final com.google.android.gms.common.api.a<c> f8072c = b.f8118a;

    /* renamed from: d  reason: collision with root package name */
    public static final com.google.android.gms.common.api.a<C0117a> f8073d = new com.google.android.gms.common.api.a<>("Auth.CREDENTIALS_API", f8078i, f8070a);

    /* renamed from: e  reason: collision with root package name */
    public static final com.google.android.gms.common.api.a<GoogleSignInOptions> f8074e = new com.google.android.gms.common.api.a<>("Auth.GOOGLE_SIGN_IN_API", j, f8071b);
    @Deprecated

    /* renamed from: f  reason: collision with root package name */
    public static final com.google.android.gms.auth.api.proxy.a f8075f = b.f8119b;

    /* renamed from: g  reason: collision with root package name */
    public static final com.google.android.gms.auth.api.credentials.a f8076g = new g();

    /* renamed from: h  reason: collision with root package name */
    public static final com.google.android.gms.auth.api.signin.a f8077h = new f();

    /* renamed from: i  reason: collision with root package name */
    private static final a.C0125a<h, C0117a> f8078i = new e();
    private static final a.C0125a<i, GoogleSignInOptions> j = new f();

    @Deprecated
    /* renamed from: com.google.android.gms.auth.api.a$a  reason: collision with other inner class name */
    public static class C0117a implements a.d.e {

        /* renamed from: a  reason: collision with root package name */
        public static final C0117a f8079a = new C0118a().a();

        /* renamed from: b  reason: collision with root package name */
        public final String f8080b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f8081c;

        /* renamed from: d  reason: collision with root package name */
        public final String f8082d;

        public C0117a(C0118a aVar) {
            this.f8080b = aVar.f8083a;
            this.f8081c = aVar.f8084b.booleanValue();
            this.f8082d = aVar.f8085c;
        }

        @Deprecated
        /* renamed from: com.google.android.gms.auth.api.a$a$a  reason: collision with other inner class name */
        public static class C0118a {

            /* renamed from: a  reason: collision with root package name */
            protected String f8083a;

            /* renamed from: b  reason: collision with root package name */
            protected Boolean f8084b = Boolean.FALSE;

            /* renamed from: c  reason: collision with root package name */
            protected String f8085c;

            public C0118a() {
            }

            public C0118a(C0117a aVar) {
                this.f8083a = aVar.f8080b;
                this.f8084b = Boolean.valueOf(aVar.f8081c);
                this.f8085c = aVar.f8082d;
            }

            public C0118a a(String str) {
                this.f8085c = str;
                return this;
            }

            public C0117a a() {
                return new C0117a(this);
            }
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C0117a)) {
                return false;
            }
            C0117a aVar = (C0117a) obj;
            return q.a(this.f8080b, aVar.f8080b) && this.f8081c == aVar.f8081c && q.a(this.f8082d, aVar.f8082d);
        }

        public int hashCode() {
            return Arrays.hashCode(new Object[]{this.f8080b, Boolean.valueOf(this.f8081c), this.f8082d});
        }
    }
}
