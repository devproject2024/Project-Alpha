package com.google.android.gms.internal.p001firebaseperf;

import com.google.android.gms.internal.p001firebaseperf.dq;

/* renamed from: com.google.android.gms.internal.firebase-perf.ao  reason: invalid package */
public final class ao extends dq<ao, a> implements ez {
    private static volatile fi<ao> zzin;
    /* access modifiers changed from: private */
    public static final ao zzis = new ao();
    private int zzii;
    private long zziq;
    private int zzir;

    private ao() {
    }

    /* renamed from: com.google.android.gms.internal.firebase-perf.ao$a */
    public static final class a extends dq.a<ao, a> implements ez {
        private a() {
            super(ao.zzis);
        }

        public final a a(long j) {
            h();
            ao.a((ao) this.f9565a, j);
            return this;
        }

        public final a a(int i2) {
            h();
            ao.a((ao) this.f9565a, i2);
            return this;
        }

        /* synthetic */ a(byte b2) {
            this();
        }
    }

    public static a a() {
        return (a) zzis.l();
    }

    /* access modifiers changed from: protected */
    public final Object a(int i2) {
        switch (an.f9498a[i2 - 1]) {
            case 1:
                return new ao();
            case 2:
                return new a((byte) 0);
            case 3:
                return a((ex) zzis, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0002\u0000\u0002\u0004\u0001", new Object[]{"zzii", "zziq", "zzir"});
            case 4:
                return zzis;
            case 5:
                fi<ao> fiVar = zzin;
                if (fiVar == null) {
                    synchronized (ao.class) {
                        fiVar = zzin;
                        if (fiVar == null) {
                            fiVar = new dq.c<>(zzis);
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
        dq.a(ao.class, zzis);
    }

    static /* synthetic */ void a(ao aoVar, long j) {
        aoVar.zzii |= 1;
        aoVar.zziq = j;
    }

    static /* synthetic */ void a(ao aoVar, int i2) {
        aoVar.zzii |= 2;
        aoVar.zzir = i2;
    }
}
