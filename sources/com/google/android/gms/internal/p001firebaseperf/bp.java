package com.google.android.gms.internal.p001firebaseperf;

import com.google.android.gms.internal.p001firebaseperf.ap;
import com.google.android.gms.internal.p001firebaseperf.dq;

/* renamed from: com.google.android.gms.internal.firebase-perf.bp  reason: invalid package */
public final class bp extends dq<bp, a> implements ez {
    private static volatile fi<bp> zzin;
    /* access modifiers changed from: private */
    public static final bp zzlr = new bp();
    public int zzii;
    private ap zzln;
    private by zzlo;
    private bj zzlp;
    public bc zzlq;

    private bp() {
    }

    /* renamed from: com.google.android.gms.internal.firebase-perf.bp$a */
    public static final class a extends dq.a<bp, a> implements ez {
        private a() {
            super(bp.zzlr);
        }

        public final a a(ap.a aVar) {
            h();
            bp.a((bp) this.f9565a, aVar);
            return this;
        }

        public final a a(by byVar) {
            h();
            bp.a((bp) this.f9565a, byVar);
            return this;
        }

        public final a a(bj bjVar) {
            h();
            bp.a((bp) this.f9565a, bjVar);
            return this;
        }

        public final a a(bc bcVar) {
            h();
            bp.a((bp) this.f9565a, bcVar);
            return this;
        }

        /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final ap a() {
        ap apVar = this.zzln;
        return apVar == null ? ap.d() : apVar;
    }

    public final boolean b() {
        return (this.zzii & 2) != 0;
    }

    public final by c() {
        by byVar = this.zzlo;
        return byVar == null ? by.c() : byVar;
    }

    public final boolean d() {
        return (this.zzii & 4) != 0;
    }

    public final bj e() {
        bj bjVar = this.zzlp;
        return bjVar == null ? bj.g() : bjVar;
    }

    public final boolean f() {
        return (this.zzii & 8) != 0;
    }

    public static a g() {
        return (a) zzlr.l();
    }

    /* access modifiers changed from: protected */
    public final Object a(int i2) {
        switch (bo.f9512a[i2 - 1]) {
            case 1:
                return new bp();
            case 2:
                return new a((byte) 0);
            case 3:
                return a((ex) zzlr, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\t\u0000\u0002\t\u0001\u0003\t\u0002\u0004\t\u0003", new Object[]{"zzii", "zzln", "zzlo", "zzlp", "zzlq"});
            case 4:
                return zzlr;
            case 5:
                fi<bp> fiVar = zzin;
                if (fiVar == null) {
                    synchronized (bp.class) {
                        fiVar = zzin;
                        if (fiVar == null) {
                            fiVar = new dq.c<>(zzlr);
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

    static {
        dq.a(bp.class, zzlr);
    }

    static /* synthetic */ void a(bp bpVar, ap.a aVar) {
        bpVar.zzln = (ap) aVar.k();
        bpVar.zzii |= 1;
    }

    static /* synthetic */ void a(bp bpVar, by byVar) {
        if (byVar != null) {
            bpVar.zzlo = byVar;
            bpVar.zzii |= 2;
            return;
        }
        throw new NullPointerException();
    }

    static /* synthetic */ void a(bp bpVar, bj bjVar) {
        if (bjVar != null) {
            bpVar.zzlp = bjVar;
            bpVar.zzii |= 4;
            return;
        }
        throw new NullPointerException();
    }

    static /* synthetic */ void a(bp bpVar, bc bcVar) {
        if (bcVar != null) {
            bpVar.zzlq = bcVar;
            bpVar.zzii |= 8;
            return;
        }
        throw new NullPointerException();
    }
}
