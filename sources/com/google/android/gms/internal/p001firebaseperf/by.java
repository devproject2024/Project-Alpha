package com.google.android.gms.internal.p001firebaseperf;

import com.google.android.gms.internal.p001firebaseperf.dq;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-perf.by  reason: invalid package */
public final class by extends dq<by, a> implements ez {
    private static volatile fi<by> zzin;
    /* access modifiers changed from: private */
    public static final by zzmi = new by();
    private int zzii;
    public er<String, String> zziz = er.zzii();
    private long zzkt;
    public dz<bq> zzkx = fn.d();
    public String zzmd = "";
    private boolean zzme;
    public long zzmf;
    public er<String, Long> zzmg = er.zzii();
    public dz<by> zzmh = fn.d();

    /* renamed from: com.google.android.gms.internal.firebase-perf.by$b */
    static final class b {

        /* renamed from: a  reason: collision with root package name */
        static final ep<String, String> f9515a = ep.a(gu.STRING, "", gu.STRING, "");
    }

    /* renamed from: com.google.android.gms.internal.firebase-perf.by$c */
    static final class c {

        /* renamed from: a  reason: collision with root package name */
        static final ep<String, Long> f9516a = ep.a(gu.STRING, "", gu.INT64, 0L);
    }

    private by() {
    }

    /* renamed from: com.google.android.gms.internal.firebase-perf.by$a */
    public static final class a extends dq.a<by, a> implements ez {
        private a() {
            super(by.zzmi);
        }

        public final a a(String str) {
            h();
            by.a((by) this.f9565a, str);
            return this;
        }

        public final a a(long j) {
            h();
            by.a((by) this.f9565a, j);
            return this;
        }

        public final a b(long j) {
            h();
            by.b((by) this.f9565a, j);
            return this;
        }

        public final a a(String str, long j) {
            if (str != null) {
                h();
                by.a((by) this.f9565a).put(str, Long.valueOf(j));
                return this;
            }
            throw new NullPointerException();
        }

        public final a a(Map<String, Long> map) {
            h();
            by.a((by) this.f9565a).putAll(map);
            return this;
        }

        public final a a(by byVar) {
            h();
            by.a((by) this.f9565a, byVar);
            return this;
        }

        public final a a(Iterable<? extends by> iterable) {
            h();
            by.a((by) this.f9565a, (Iterable) iterable);
            return this;
        }

        public final a b(Map<String, String> map) {
            h();
            by.b((by) this.f9565a).putAll(map);
            return this;
        }

        public final a a(bq bqVar) {
            h();
            by.a((by) this.f9565a, bqVar);
            return this;
        }

        public final a b(Iterable<? extends bq> iterable) {
            h();
            by.b((by) this.f9565a, (Iterable) iterable);
            return this;
        }

        public final a a() {
            h();
            ((by) this.f9565a).zzkx = fn.d();
            return this;
        }

        /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final boolean a() {
        return (this.zzii & 4) != 0;
    }

    private final void e() {
        if (!this.zzmh.a()) {
            this.zzmh = dq.a(this.zzmh);
        }
    }

    private final void f() {
        if (!this.zzkx.a()) {
            this.zzkx = dq.a(this.zzkx);
        }
    }

    public static a b() {
        return (a) zzmi.l();
    }

    /* access modifiers changed from: protected */
    public final Object a(int i2) {
        Class<by> cls = by.class;
        switch (ca.f9518a[i2 - 1]) {
            case 1:
                return new by();
            case 2:
                return new a((byte) 0);
            case 3:
                return a((ex) zzmi, "\u0001\b\u0000\u0001\u0001\t\b\u0002\u0002\u0000\u0001\b\u0000\u0002\u0007\u0001\u0004\u0002\u0002\u0005\u0002\u0003\u00062\u0007\u001b\b2\t\u001b", new Object[]{"zzii", "zzmd", "zzme", "zzkt", "zzmf", "zzmg", c.f9516a, "zzmh", cls, "zziz", b.f9515a, "zzkx", bq.class});
            case 4:
                return zzmi;
            case 5:
                fi<by> fiVar = zzin;
                if (fiVar == null) {
                    synchronized (cls) {
                        fiVar = zzin;
                        if (fiVar == null) {
                            fiVar = new dq.c<>(zzmi);
                            zzin = fiVar;
                        }
                    }
                }
                return fiVar;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public static by c() {
        return zzmi;
    }

    static {
        dq.a(by.class, zzmi);
    }

    static /* synthetic */ void a(by byVar, String str) {
        if (str != null) {
            byVar.zzii |= 1;
            byVar.zzmd = str;
            return;
        }
        throw new NullPointerException();
    }

    static /* synthetic */ void a(by byVar, long j) {
        byVar.zzii |= 4;
        byVar.zzkt = j;
    }

    static /* synthetic */ void b(by byVar, long j) {
        byVar.zzii |= 8;
        byVar.zzmf = j;
    }

    static /* synthetic */ Map a(by byVar) {
        if (!byVar.zzmg.isMutable()) {
            byVar.zzmg = byVar.zzmg.zzij();
        }
        return byVar.zzmg;
    }

    static /* synthetic */ void a(by byVar, by byVar2) {
        if (byVar2 != null) {
            byVar.e();
            byVar.zzmh.add(byVar2);
            return;
        }
        throw new NullPointerException();
    }

    static /* synthetic */ void a(by byVar, Iterable iterable) {
        byVar.e();
        ci.a(iterable, byVar.zzmh);
    }

    static /* synthetic */ Map b(by byVar) {
        if (!byVar.zziz.isMutable()) {
            byVar.zziz = byVar.zziz.zzij();
        }
        return byVar.zziz;
    }

    static /* synthetic */ void a(by byVar, bq bqVar) {
        if (bqVar != null) {
            byVar.f();
            byVar.zzkx.add(bqVar);
            return;
        }
        throw new NullPointerException();
    }

    static /* synthetic */ void b(by byVar, Iterable iterable) {
        byVar.f();
        ci.a(iterable, byVar.zzkx);
    }
}
