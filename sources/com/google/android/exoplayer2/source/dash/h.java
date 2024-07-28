package com.google.android.exoplayer2.source.dash;

import android.os.Handler;
import android.os.Message;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.e;
import com.google.android.exoplayer2.extractor.q;
import com.google.android.exoplayer2.g.ae;
import com.google.android.exoplayer2.g.r;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.emsg.EventMessage;
import com.google.android.exoplayer2.o;
import com.google.android.exoplayer2.source.t;
import com.google.android.exoplayer2.v;
import java.io.IOException;
import java.util.TreeMap;

public final class h implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    final com.google.android.exoplayer2.f.b f33020a;

    /* renamed from: b  reason: collision with root package name */
    final b f33021b;
    /* access modifiers changed from: package-private */

    /* renamed from: c  reason: collision with root package name */
    public final Handler f33022c = ae.a((Handler.Callback) this);

    /* renamed from: d  reason: collision with root package name */
    final TreeMap<Long, Long> f33023d = new TreeMap<>();

    /* renamed from: e  reason: collision with root package name */
    com.google.android.exoplayer2.source.dash.a.b f33024e;

    /* renamed from: f  reason: collision with root package name */
    long f33025f;

    /* renamed from: g  reason: collision with root package name */
    long f33026g = -9223372036854775807L;

    /* renamed from: h  reason: collision with root package name */
    boolean f33027h;

    /* renamed from: i  reason: collision with root package name */
    boolean f33028i;
    /* access modifiers changed from: private */
    public final com.google.android.exoplayer2.metadata.emsg.a j = new com.google.android.exoplayer2.metadata.emsg.a();
    private long k = -9223372036854775807L;

    public interface b {
        void a();

        void a(long j);
    }

    public h(com.google.android.exoplayer2.source.dash.a.b bVar, b bVar2, com.google.android.exoplayer2.f.b bVar3) {
        this.f33024e = bVar;
        this.f33021b = bVar2;
        this.f33020a = bVar3;
    }

    public static boolean a(String str, String str2) {
        if ("urn:mpeg:dash:event:2012".equals(str)) {
            return "1".equals(str2) || "2".equals(str2) || "3".equals(str2);
        }
        return false;
    }

    public final boolean handleMessage(Message message) {
        if (this.f33028i) {
            return true;
        }
        if (message.what != 1) {
            return false;
        }
        a aVar = (a) message.obj;
        long j2 = aVar.f33029a;
        long j3 = aVar.f33030b;
        Long l = this.f33023d.get(Long.valueOf(j3));
        if (l == null) {
            this.f33023d.put(Long.valueOf(j3), Long.valueOf(j2));
        } else if (l.longValue() > j2) {
            this.f33023d.put(Long.valueOf(j3), Long.valueOf(j2));
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        long j2 = this.k;
        if (j2 == -9223372036854775807L || j2 != this.f33026g) {
            this.f33027h = true;
            this.k = this.f33026g;
            this.f33021b.a();
        }
    }

    /* access modifiers changed from: private */
    public static long b(EventMessage eventMessage) {
        try {
            return ae.g(ae.a(eventMessage.f32656e));
        } catch (v unused) {
            return -9223372036854775807L;
        }
    }

    public final class c implements q {

        /* renamed from: a  reason: collision with root package name */
        final t f33031a;

        /* renamed from: c  reason: collision with root package name */
        private final o f33033c = new o();

        /* renamed from: d  reason: collision with root package name */
        private final com.google.android.exoplayer2.metadata.c f33034d = new com.google.android.exoplayer2.metadata.c();

        c(t tVar) {
            this.f33031a = tVar;
        }

        public final void a(Format format) {
            this.f33031a.a(format);
        }

        public final int a(com.google.android.exoplayer2.extractor.h hVar, int i2, boolean z) throws IOException, InterruptedException {
            return this.f33031a.a(hVar, i2, z);
        }

        public final void a(r rVar, int i2) {
            this.f33031a.a(rVar, i2);
        }

        public final void a(long j, int i2, int i3, int i4, q.a aVar) {
            com.google.android.exoplayer2.metadata.c cVar;
            this.f33031a.a(j, i2, i3, i4, aVar);
            while (this.f33031a.f33388a.c()) {
                this.f33034d.a();
                if (this.f33031a.a(this.f33033c, (e) this.f33034d, false, false, 0) == -4) {
                    this.f33034d.g();
                    cVar = this.f33034d;
                } else {
                    cVar = null;
                }
                if (cVar != null) {
                    long j2 = cVar.f31312d;
                    Metadata a2 = h.this.j.a(cVar);
                    if (a2 != null) {
                        EventMessage eventMessage = (EventMessage) a2.f32644a[0];
                        if (h.a(eventMessage.f32652a, eventMessage.f32653b)) {
                            long a3 = h.b(eventMessage);
                            if (a3 != -9223372036854775807L) {
                                h.this.f33022c.sendMessage(h.this.f33022c.obtainMessage(1, new a(j2, a3)));
                            }
                        }
                    }
                }
            }
            t tVar = this.f33031a;
            tVar.a(tVar.f33388a.j());
        }
    }

    static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final long f33029a;

        /* renamed from: b  reason: collision with root package name */
        public final long f33030b;

        public a(long j, long j2) {
            this.f33029a = j;
            this.f33030b = j2;
        }
    }
}
