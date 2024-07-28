package com.google.android.exoplayer2.source;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.f.l;
import com.google.android.exoplayer2.source.o;
import com.google.android.exoplayer2.source.p;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public interface p {
    void a(int i2, o.a aVar);

    void a(int i2, o.a aVar, b bVar, c cVar);

    void a(int i2, o.a aVar, b bVar, c cVar, IOException iOException, boolean z);

    void a(int i2, o.a aVar, c cVar);

    void b(int i2, o.a aVar);

    void b(int i2, o.a aVar, b bVar, c cVar);

    void b(int i2, o.a aVar, c cVar);

    void c(int i2, o.a aVar);

    void c(int i2, o.a aVar, b bVar, c cVar);

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final l f33235a;

        /* renamed from: b  reason: collision with root package name */
        public final Uri f33236b;

        /* renamed from: c  reason: collision with root package name */
        public final Map<String, List<String>> f33237c;

        /* renamed from: d  reason: collision with root package name */
        public final long f33238d;

        /* renamed from: e  reason: collision with root package name */
        public final long f33239e;

        /* renamed from: f  reason: collision with root package name */
        public final long f33240f;

        public b(l lVar, Uri uri, Map<String, List<String>> map, long j, long j2, long j3) {
            this.f33235a = lVar;
            this.f33236b = uri;
            this.f33237c = map;
            this.f33238d = j;
            this.f33239e = j2;
            this.f33240f = j3;
        }
    }

    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public final int f33241a;

        /* renamed from: b  reason: collision with root package name */
        public final int f33242b;

        /* renamed from: c  reason: collision with root package name */
        public final Format f33243c;

        /* renamed from: d  reason: collision with root package name */
        public final int f33244d;

        /* renamed from: e  reason: collision with root package name */
        public final Object f33245e;

        /* renamed from: f  reason: collision with root package name */
        public final long f33246f;

        /* renamed from: g  reason: collision with root package name */
        public final long f33247g;

        public c(int i2, int i3, Format format, int i4, Object obj, long j, long j2) {
            this.f33241a = i2;
            this.f33242b = i3;
            this.f33243c = format;
            this.f33244d = i4;
            this.f33245e = obj;
            this.f33246f = j;
            this.f33247g = j2;
        }
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f33229a;

        /* renamed from: b  reason: collision with root package name */
        public final o.a f33230b;

        /* renamed from: c  reason: collision with root package name */
        final CopyOnWriteArrayList<C0549a> f33231c;

        /* renamed from: d  reason: collision with root package name */
        private final long f33232d;

        public a() {
            this(new CopyOnWriteArrayList(), 0, (o.a) null, 0);
        }

        private a(CopyOnWriteArrayList<C0549a> copyOnWriteArrayList, int i2, o.a aVar, long j) {
            this.f33231c = copyOnWriteArrayList;
            this.f33229a = i2;
            this.f33230b = aVar;
            this.f33232d = j;
        }

        public final a a(int i2, o.a aVar, long j) {
            return new a(this.f33231c, i2, aVar, j);
        }

        public final void a() {
            o.a aVar = (o.a) com.google.android.exoplayer2.g.a.a(this.f33230b);
            Iterator<C0549a> it2 = this.f33231c.iterator();
            while (it2.hasNext()) {
                C0549a next = it2.next();
                a(next.f33233a, (Runnable) new Runnable(next.f33234b, aVar) {
                    private final /* synthetic */ p f$1;
                    private final /* synthetic */ o.a f$2;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final void run() {
                        p.a.this.c(this.f$1, this.f$2);
                    }
                });
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void c(p pVar, o.a aVar) {
            pVar.a(this.f33229a, aVar);
        }

        public final void b() {
            o.a aVar = (o.a) com.google.android.exoplayer2.g.a.a(this.f33230b);
            Iterator<C0549a> it2 = this.f33231c.iterator();
            while (it2.hasNext()) {
                C0549a next = it2.next();
                a(next.f33233a, (Runnable) new Runnable(next.f33234b, aVar) {
                    private final /* synthetic */ p f$1;
                    private final /* synthetic */ o.a f$2;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final void run() {
                        p.a.this.b(this.f$1, this.f$2);
                    }
                });
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void b(p pVar, o.a aVar) {
            pVar.b(this.f33229a, aVar);
        }

        public final void a(l lVar, int i2, long j) {
            a(lVar, i2, -1, (Format) null, 0, (Object) null, -9223372036854775807L, -9223372036854775807L, j);
        }

        public final void a(l lVar, int i2, int i3, Format format, int i4, Object obj, long j, long j2, long j3) {
            l lVar2 = lVar;
            a(new b(lVar2, lVar2.f32395a, Collections.emptyMap(), j3, 0, 0), new c(i2, i3, format, i4, obj, a(j), a(j2)));
        }

        public final void a(b bVar, c cVar) {
            Iterator<C0549a> it2 = this.f33231c.iterator();
            while (it2.hasNext()) {
                C0549a next = it2.next();
                a(next.f33233a, (Runnable) new Runnable(next.f33234b, bVar, cVar) {
                    private final /* synthetic */ p f$1;
                    private final /* synthetic */ p.b f$2;
                    private final /* synthetic */ p.c f$3;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                        this.f$3 = r4;
                    }

                    public final void run() {
                        p.a.this.c(this.f$1, this.f$2, this.f$3);
                    }
                });
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void c(p pVar, b bVar, c cVar) {
            pVar.a(this.f33229a, this.f33230b, bVar, cVar);
        }

        public final void a(l lVar, Uri uri, Map<String, List<String>> map, int i2, long j, long j2, long j3) {
            a(lVar, uri, map, i2, -1, (Format) null, 0, (Object) null, -9223372036854775807L, -9223372036854775807L, j, j2, j3);
        }

        public final void a(l lVar, Uri uri, Map<String, List<String>> map, int i2, int i3, Format format, int i4, Object obj, long j, long j2, long j3, long j4, long j5) {
            b(new b(lVar, uri, map, j3, j4, j5), new c(i2, i3, format, i4, obj, a(j), a(j2)));
        }

        public final void b(b bVar, c cVar) {
            Iterator<C0549a> it2 = this.f33231c.iterator();
            while (it2.hasNext()) {
                C0549a next = it2.next();
                a(next.f33233a, (Runnable) new Runnable(next.f33234b, bVar, cVar) {
                    private final /* synthetic */ p f$1;
                    private final /* synthetic */ p.b f$2;
                    private final /* synthetic */ p.c f$3;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                        this.f$3 = r4;
                    }

                    public final void run() {
                        p.a.this.b(this.f$1, this.f$2, this.f$3);
                    }
                });
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void b(p pVar, b bVar, c cVar) {
            pVar.b(this.f33229a, this.f33230b, bVar, cVar);
        }

        public final void b(l lVar, Uri uri, Map<String, List<String>> map, int i2, long j, long j2, long j3) {
            b(lVar, uri, map, i2, -1, (Format) null, 0, (Object) null, -9223372036854775807L, -9223372036854775807L, j, j2, j3);
        }

        public final void b(l lVar, Uri uri, Map<String, List<String>> map, int i2, int i3, Format format, int i4, Object obj, long j, long j2, long j3, long j4, long j5) {
            c(new b(lVar, uri, map, j3, j4, j5), new c(i2, i3, format, i4, obj, a(j), a(j2)));
        }

        public final void c(b bVar, c cVar) {
            Iterator<C0549a> it2 = this.f33231c.iterator();
            while (it2.hasNext()) {
                C0549a next = it2.next();
                a(next.f33233a, (Runnable) new Runnable(next.f33234b, bVar, cVar) {
                    private final /* synthetic */ p f$1;
                    private final /* synthetic */ p.b f$2;
                    private final /* synthetic */ p.c f$3;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                        this.f$3 = r4;
                    }

                    public final void run() {
                        p.a.this.a(this.f$1, this.f$2, this.f$3);
                    }
                });
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void a(p pVar, b bVar, c cVar) {
            pVar.c(this.f33229a, this.f33230b, bVar, cVar);
        }

        public final void a(l lVar, Uri uri, Map<String, List<String>> map, int i2, long j, long j2, long j3, IOException iOException, boolean z) {
            a(lVar, uri, map, i2, -1, (Format) null, 0, (Object) null, -9223372036854775807L, -9223372036854775807L, j, j2, j3, iOException, z);
        }

        public final void a(l lVar, Uri uri, Map<String, List<String>> map, int i2, int i3, Format format, int i4, Object obj, long j, long j2, long j3, long j4, long j5, IOException iOException, boolean z) {
            a(new b(lVar, uri, map, j3, j4, j5), new c(i2, i3, format, i4, obj, a(j), a(j2)), iOException, z);
        }

        public final void a(b bVar, c cVar, IOException iOException, boolean z) {
            Iterator<C0549a> it2 = this.f33231c.iterator();
            while (it2.hasNext()) {
                C0549a next = it2.next();
                a(next.f33233a, (Runnable) new Runnable(next.f33234b, bVar, cVar, iOException, z) {
                    private final /* synthetic */ p f$1;
                    private final /* synthetic */ p.b f$2;
                    private final /* synthetic */ p.c f$3;
                    private final /* synthetic */ IOException f$4;
                    private final /* synthetic */ boolean f$5;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                        this.f$3 = r4;
                        this.f$4 = r5;
                        this.f$5 = r6;
                    }

                    public final void run() {
                        p.a.this.a(this.f$1, this.f$2, this.f$3, this.f$4, this.f$5);
                    }
                });
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void a(p pVar, b bVar, c cVar, IOException iOException, boolean z) {
            pVar.a(this.f33229a, this.f33230b, bVar, cVar, iOException, z);
        }

        public final void c() {
            o.a aVar = (o.a) com.google.android.exoplayer2.g.a.a(this.f33230b);
            Iterator<C0549a> it2 = this.f33231c.iterator();
            while (it2.hasNext()) {
                C0549a next = it2.next();
                a(next.f33233a, (Runnable) new Runnable(next.f33234b, aVar) {
                    private final /* synthetic */ p f$1;
                    private final /* synthetic */ o.a f$2;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final void run() {
                        p.a.this.a(this.f$1, this.f$2);
                    }
                });
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void a(p pVar, o.a aVar) {
            pVar.c(this.f33229a, aVar);
        }

        public final void a(int i2, long j, long j2) {
            long j3 = j;
            a(new c(1, i2, (Format) null, 3, (Object) null, a(j), a(j2)));
        }

        public final void a(c cVar) {
            o.a aVar = (o.a) com.google.android.exoplayer2.g.a.a(this.f33230b);
            Iterator<C0549a> it2 = this.f33231c.iterator();
            while (it2.hasNext()) {
                C0549a next = it2.next();
                a(next.f33233a, (Runnable) new Runnable(next.f33234b, aVar, cVar) {
                    private final /* synthetic */ p f$1;
                    private final /* synthetic */ o.a f$2;
                    private final /* synthetic */ p.c f$3;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                        this.f$3 = r4;
                    }

                    public final void run() {
                        p.a.this.a(this.f$1, this.f$2, this.f$3);
                    }
                });
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void a(p pVar, o.a aVar, c cVar) {
            pVar.a(this.f33229a, aVar, cVar);
        }

        public final void a(int i2, Format format, int i3, Object obj, long j) {
            b(new c(1, i2, format, i3, obj, a(j), -9223372036854775807L));
        }

        public final void b(c cVar) {
            Iterator<C0549a> it2 = this.f33231c.iterator();
            while (it2.hasNext()) {
                C0549a next = it2.next();
                a(next.f33233a, (Runnable) new Runnable(next.f33234b, cVar) {
                    private final /* synthetic */ p f$1;
                    private final /* synthetic */ p.c f$2;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final void run() {
                        p.a.this.a(this.f$1, this.f$2);
                    }
                });
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void a(p pVar, c cVar) {
            pVar.b(this.f33229a, this.f33230b, cVar);
        }

        private long a(long j) {
            long a2 = com.google.android.exoplayer2.c.a(j);
            if (a2 == -9223372036854775807L) {
                return -9223372036854775807L;
            }
            return this.f33232d + a2;
        }

        private static void a(Handler handler, Runnable runnable) {
            if (handler.getLooper() == Looper.myLooper()) {
                runnable.run();
            } else {
                handler.post(runnable);
            }
        }

        /* renamed from: com.google.android.exoplayer2.source.p$a$a  reason: collision with other inner class name */
        static final class C0549a {

            /* renamed from: a  reason: collision with root package name */
            public final Handler f33233a;

            /* renamed from: b  reason: collision with root package name */
            public final p f33234b;

            public C0549a(Handler handler, p pVar) {
                this.f33233a = handler;
                this.f33234b = pVar;
            }
        }
    }
}
