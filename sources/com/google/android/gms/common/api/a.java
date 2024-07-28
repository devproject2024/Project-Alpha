package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.content.Intent;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.a.d;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.api.internal.m;
import com.google.android.gms.common.internal.c;
import com.google.android.gms.common.internal.l;
import com.google.android.gms.common.internal.s;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public final class a<O extends d> {

    /* renamed from: a  reason: collision with root package name */
    public final C0125a<?, O> f8363a;

    /* renamed from: b  reason: collision with root package name */
    public final String f8364b;

    /* renamed from: c  reason: collision with root package name */
    private final i<?, O> f8365c = null;

    /* renamed from: d  reason: collision with root package name */
    private final g<?> f8366d;

    /* renamed from: e  reason: collision with root package name */
    private final j<?> f8367e;

    /* renamed from: com.google.android.gms.common.api.a$a  reason: collision with other inner class name */
    public static abstract class C0125a<T extends f, O> extends e<T, O> {
        @Deprecated
        public T buildClient(Context context, Looper looper, com.google.android.gms.common.internal.d dVar, O o, e.b bVar, e.c cVar) {
            return buildClient(context, looper, dVar, o, (com.google.android.gms.common.api.internal.e) bVar, (m) cVar);
        }

        public T buildClient(Context context, Looper looper, com.google.android.gms.common.internal.d dVar, O o, com.google.android.gms.common.api.internal.e eVar, m mVar) {
            throw new UnsupportedOperationException("buildClient must be implemented");
        }
    }

    public interface b {
    }

    public static class c<C extends b> {
    }

    public interface d {

        /* renamed from: com.google.android.gms.common.api.a$d$a  reason: collision with other inner class name */
        public interface C0126a extends c, C0127d {
            Account a();
        }

        public interface b extends c {
            GoogleSignInAccount a();
        }

        public interface c extends d {
        }

        /* renamed from: com.google.android.gms.common.api.a$d$d  reason: collision with other inner class name */
        public interface C0127d extends d {
        }

        public interface e extends c, C0127d {
        }
    }

    public interface f extends b {
        void a(c.C0130c cVar);

        void a(c.e eVar);

        void a(l lVar, Set<Scope> set);

        void a(String str, PrintWriter printWriter);

        boolean c();

        Intent d();

        int e();

        void f();

        boolean g();

        boolean h();

        boolean i();

        String j();

        Feature[] k();

        Set<Scope> l();
    }

    public static final class g<C extends f> extends c<C> {
    }

    public interface h<T extends IInterface> extends b {
        String a();

        String b();

        T c();
    }

    public static abstract class i<T extends h<? extends IInterface>, O> extends e<T, O> {
    }

    public static final class j<C extends h<? extends IInterface>> extends c<C> {
    }

    public <C extends f> a(String str, C0125a<C, O> aVar, g<C> gVar) {
        s.a(aVar, (Object) "Cannot construct an Api with a null ClientBuilder");
        s.a(gVar, (Object) "Cannot construct an Api with a null ClientKey");
        this.f8364b = str;
        this.f8363a = aVar;
        this.f8366d = gVar;
        this.f8367e = null;
    }

    public static abstract class e<T extends b, O> {
        public static final int API_PRIORITY_GAMES = 1;
        public static final int API_PRIORITY_OTHER = Integer.MAX_VALUE;
        public static final int API_PRIORITY_PLUS = 2;

        public int getPriority() {
            return Integer.MAX_VALUE;
        }

        public List<Scope> getImpliedScopes(O o) {
            return Collections.emptyList();
        }
    }

    public final C0125a<?, O> a() {
        s.a(this.f8363a != null, (Object) "This API was constructed with a SimpleClientBuilder. Use getSimpleClientBuilder");
        return this.f8363a;
    }

    public final c<?> b() {
        g<?> gVar = this.f8366d;
        if (gVar != null) {
            return gVar;
        }
        throw new IllegalStateException("This API was constructed with null client keys. This should not be possible.");
    }
}
