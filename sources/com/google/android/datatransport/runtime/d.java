package com.google.android.datatransport.runtime;

import android.content.Context;
import com.google.android.datatransport.runtime.backends.j;
import com.google.android.datatransport.runtime.backends.l;
import com.google.android.datatransport.runtime.d.c;
import com.google.android.datatransport.runtime.s;
import com.google.android.datatransport.runtime.scheduling.a.ab;
import com.google.android.datatransport.runtime.scheduling.a.ah;
import com.google.android.datatransport.runtime.scheduling.a.e;
import com.google.android.datatransport.runtime.scheduling.a.f;
import com.google.android.datatransport.runtime.scheduling.a.i;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.g;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.h;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.n;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.o;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.r;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.s;
import dagger.a.b;
import java.util.concurrent.Executor;

final class d extends s {

    /* renamed from: a  reason: collision with root package name */
    private javax.a.a<Executor> f7772a;

    /* renamed from: b  reason: collision with root package name */
    private javax.a.a<Context> f7773b;

    /* renamed from: c  reason: collision with root package name */
    private javax.a.a f7774c;

    /* renamed from: d  reason: collision with root package name */
    private javax.a.a f7775d;

    /* renamed from: e  reason: collision with root package name */
    private javax.a.a f7776e;

    /* renamed from: f  reason: collision with root package name */
    private javax.a.a<i> f7777f;

    /* renamed from: g  reason: collision with root package name */
    private javax.a.a<g> f7778g;

    /* renamed from: h  reason: collision with root package name */
    private javax.a.a<s> f7779h;

    /* renamed from: i  reason: collision with root package name */
    private javax.a.a<com.google.android.datatransport.runtime.scheduling.a> f7780i;
    private javax.a.a<h> j;
    private javax.a.a<o> k;
    private javax.a.a<q> l;

    /* synthetic */ d(Context context, byte b2) {
        this(context);
    }

    private d(Context context) {
        this.f7772a = b.a(i.a());
        this.f7773b = dagger.a.d.a(context);
        this.f7774c = new j(this.f7773b, com.google.android.datatransport.runtime.d.b.a(), c.a());
        this.f7775d = b.a(new l(this.f7773b, this.f7774c));
        this.f7776e = new ah(this.f7773b, e.a(), f.a());
        this.f7777f = b.a(new ab(com.google.android.datatransport.runtime.d.b.a(), c.a(), com.google.android.datatransport.runtime.scheduling.a.g.a(), this.f7776e));
        this.f7778g = new com.google.android.datatransport.runtime.scheduling.f(com.google.android.datatransport.runtime.d.b.a());
        this.f7779h = new com.google.android.datatransport.runtime.scheduling.g(this.f7773b, this.f7777f, this.f7778g, c.a());
        javax.a.a<Executor> aVar = this.f7772a;
        javax.a.a aVar2 = this.f7775d;
        javax.a.a<s> aVar3 = this.f7779h;
        javax.a.a<i> aVar4 = this.f7777f;
        this.f7780i = new com.google.android.datatransport.runtime.scheduling.d(aVar, aVar2, aVar3, aVar4, aVar4);
        javax.a.a<Context> aVar5 = this.f7773b;
        javax.a.a aVar6 = this.f7775d;
        javax.a.a<i> aVar7 = this.f7777f;
        javax.a.a<s> aVar8 = this.f7779h;
        this.j = new n(aVar5, aVar6, aVar7, aVar8, this.f7772a, aVar7, com.google.android.datatransport.runtime.d.b.a());
        javax.a.a<Executor> aVar9 = this.f7772a;
        javax.a.a<i> aVar10 = this.f7777f;
        this.k = new r(aVar9, aVar10, this.f7779h, aVar10);
        this.l = b.a(new t(com.google.android.datatransport.runtime.d.b.a(), c.a(), this.f7780i, this.j, this.k));
    }

    public static s.a a() {
        return new a((byte) 0);
    }

    /* access modifiers changed from: package-private */
    public final q b() {
        return this.l.get();
    }

    /* access modifiers changed from: package-private */
    public final com.google.android.datatransport.runtime.scheduling.a.c c() {
        return this.f7777f.get();
    }

    static final class a implements s.a {

        /* renamed from: a  reason: collision with root package name */
        private Context f7781a;

        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        public final s a() {
            dagger.a.g.a(this.f7781a, Context.class);
            return new d(this.f7781a, (byte) 0);
        }

        public final /* bridge */ /* synthetic */ s.a a(Context context) {
            this.f7781a = (Context) dagger.a.g.a(context);
            return this;
        }
    }
}
