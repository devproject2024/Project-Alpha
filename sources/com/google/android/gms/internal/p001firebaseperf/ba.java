package com.google.android.gms.internal.p001firebaseperf;

import com.google.android.gms.internal.p001firebaseperf.dq;

/* renamed from: com.google.android.gms.internal.firebase-perf.ba  reason: invalid package */
public final class ba extends dq<ba, a> implements ez {
    private static volatile fi<ba> zzin;
    /* access modifiers changed from: private */
    public static final ba zzjy = new ba();
    public int zzii;
    private String zzjs = "";
    private int zzjt;
    private int zzju;
    private int zzjv;
    private int zzjw;
    private int zzjx;

    private ba() {
    }

    /* renamed from: com.google.android.gms.internal.firebase-perf.ba$a */
    public static final class a extends dq.a<ba, a> implements ez {
        private a() {
            super(ba.zzjy);
        }

        public final a a(String str) {
            h();
            ba.a((ba) this.f9565a, str);
            return this;
        }

        public final a a(int i2) {
            h();
            ba.a((ba) this.f9565a, i2);
            return this;
        }

        public final a b(int i2) {
            h();
            ba.b((ba) this.f9565a, i2);
            return this;
        }

        public final a c(int i2) {
            h();
            ba.c((ba) this.f9565a, i2);
            return this;
        }

        /* synthetic */ a(byte b2) {
            this();
        }
    }

    public static a a() {
        return (a) zzjy.l();
    }

    /* access modifiers changed from: protected */
    public final Object a(int i2) {
        switch (az.f9504a[i2 - 1]) {
            case 1:
                return new ba();
            case 2:
                return new a((byte) 0);
            case 3:
                return a((ex) zzjy, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001\b\u0000\u0002\u0004\u0001\u0003\u0004\u0003\u0004\u0004\u0004\u0005\u0004\u0005\u0006\u0004\u0002", new Object[]{"zzii", "zzjs", "zzjt", "zzjv", "zzjw", "zzjx", "zzju"});
            case 4:
                return zzjy;
            case 5:
                fi<ba> fiVar = zzin;
                if (fiVar == null) {
                    synchronized (ba.class) {
                        fiVar = zzin;
                        if (fiVar == null) {
                            fiVar = new dq.c<>(zzjy);
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

    public static ba b() {
        return zzjy;
    }

    static {
        dq.a(ba.class, zzjy);
    }

    static /* synthetic */ void a(ba baVar, String str) {
        if (str != null) {
            baVar.zzii |= 1;
            baVar.zzjs = str;
            return;
        }
        throw new NullPointerException();
    }

    static /* synthetic */ void a(ba baVar, int i2) {
        baVar.zzii |= 8;
        baVar.zzjv = i2;
    }

    static /* synthetic */ void b(ba baVar, int i2) {
        baVar.zzii |= 16;
        baVar.zzjw = i2;
    }

    static /* synthetic */ void c(ba baVar, int i2) {
        baVar.zzii |= 32;
        baVar.zzjx = i2;
    }
}
