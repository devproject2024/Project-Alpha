package com.google.android.gms.internal.p001firebaseperf;

import com.google.android.gms.internal.p001firebaseperf.dq;
import com.google.android.gms.internal.p001firebaseperf.gz;

/* renamed from: com.google.android.gms.internal.firebase-perf.bf  reason: invalid package */
public final class bf extends dq<bf, a> implements ez {
    private static volatile fi<bf> zzin;
    /* access modifiers changed from: private */
    public static final bf zzki = new bf();
    private int zzii;
    private String zzik = "";
    private String zzkf = "";
    private String zzkg = "";
    private gz.a zzkh;

    private bf() {
    }

    /* renamed from: com.google.android.gms.internal.firebase-perf.bf$a */
    public static final class a extends dq.a<bf, a> implements ez {
        private a() {
            super(bf.zzki);
        }

        /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* access modifiers changed from: protected */
    public final Object a(int i2) {
        switch (be.f9506a[i2 - 1]) {
            case 1:
                return new bf();
            case 2:
                return new a((byte) 0);
            case 3:
                return a((ex) zzki, "\u0001\u0004\u0000\u0001\u0002\u0005\u0004\u0000\u0000\u0000\u0002\b\u0000\u0003\b\u0001\u0004\b\u0002\u0005\t\u0003", new Object[]{"zzii", "zzik", "zzkf", "zzkg", "zzkh"});
            case 4:
                return zzki;
            case 5:
                fi<bf> fiVar = zzin;
                if (fiVar == null) {
                    synchronized (bf.class) {
                        fiVar = zzin;
                        if (fiVar == null) {
                            fiVar = new dq.c<>(zzki);
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
        dq.a(bf.class, zzki);
    }
}
