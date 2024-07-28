package com.google.android.gms.internal.p001firebaseperf;

import com.google.android.gms.internal.p001firebaseperf.dq;

/* renamed from: com.google.android.gms.internal.firebase-perf.bg  reason: invalid package */
public final class bg extends dq<bg, a> implements ez {
    private static volatile fi<bg> zzin;
    /* access modifiers changed from: private */
    public static final bg zzkl = new bg();
    private int zzii;
    private long zziq;
    private int zzkj;
    private int zzkk;

    private bg() {
    }

    /* renamed from: com.google.android.gms.internal.firebase-perf.bg$a */
    public static final class a extends dq.a<bg, a> implements ez {
        private a() {
            super(bg.zzkl);
        }

        /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* access modifiers changed from: protected */
    public final Object a(int i2) {
        switch (bh.f9507a[i2 - 1]) {
            case 1:
                return new bg();
            case 2:
                return new a((byte) 0);
            case 3:
                return a((ex) zzkl, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0002\u0000\u0002\u0004\u0001\u0003\u0004\u0002", new Object[]{"zzii", "zziq", "zzkj", "zzkk"});
            case 4:
                return zzkl;
            case 5:
                fi<bg> fiVar = zzin;
                if (fiVar == null) {
                    synchronized (bg.class) {
                        fiVar = zzin;
                        if (fiVar == null) {
                            fiVar = new dq.c<>(zzkl);
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
        dq.a(bg.class, zzkl);
    }
}
