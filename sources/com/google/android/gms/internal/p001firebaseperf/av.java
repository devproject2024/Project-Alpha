package com.google.android.gms.internal.p001firebaseperf;

import com.google.android.gms.internal.p001firebaseperf.dq;

/* renamed from: com.google.android.gms.internal.firebase-perf.av  reason: invalid package */
public final class av extends dq<av, a> implements ez {
    private static volatile fi<av> zzin;
    /* access modifiers changed from: private */
    public static final av zzjl = new av();
    private int zzii;
    private long zziq;
    private long zzjj;
    private long zzjk;

    private av() {
    }

    /* renamed from: com.google.android.gms.internal.firebase-perf.av$a */
    public static final class a extends dq.a<av, a> implements ez {
        private a() {
            super(av.zzjl);
        }

        public final a a(long j) {
            h();
            av.a((av) this.f9565a, j);
            return this;
        }

        public final a b(long j) {
            h();
            av.b((av) this.f9565a, j);
            return this;
        }

        public final a c(long j) {
            h();
            av.c((av) this.f9565a, j);
            return this;
        }

        /* synthetic */ a(byte b2) {
            this();
        }
    }

    public static a a() {
        return (a) zzjl.l();
    }

    /* access modifiers changed from: protected */
    public final Object a(int i2) {
        switch (au.f9502a[i2 - 1]) {
            case 1:
                return new av();
            case 2:
                return new a((byte) 0);
            case 3:
                return a((ex) zzjl, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0002\u0000\u0002\u0002\u0001\u0003\u0002\u0002", new Object[]{"zzii", "zziq", "zzjj", "zzjk"});
            case 4:
                return zzjl;
            case 5:
                fi<av> fiVar = zzin;
                if (fiVar == null) {
                    synchronized (av.class) {
                        fiVar = zzin;
                        if (fiVar == null) {
                            fiVar = new dq.c<>(zzjl);
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
        dq.a(av.class, zzjl);
    }

    static /* synthetic */ void a(av avVar, long j) {
        avVar.zzii |= 1;
        avVar.zziq = j;
    }

    static /* synthetic */ void b(av avVar, long j) {
        avVar.zzii |= 2;
        avVar.zzjj = j;
    }

    static /* synthetic */ void c(av avVar, long j) {
        avVar.zzii |= 4;
        avVar.zzjk = j;
    }
}
