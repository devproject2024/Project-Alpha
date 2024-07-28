package com.google.android.gms.internal.p001firebaseperf;

import com.google.android.gms.internal.p001firebaseperf.dq;

/* renamed from: com.google.android.gms.internal.firebase-perf.ce  reason: invalid package */
public final class ce extends dq<ce, a> implements ez {
    private static volatile fi<ce> zzin;
    /* access modifiers changed from: private */
    public static final ce zzmt = new ce();
    private int zzii;
    private String zzik = "";
    private String zzmp = "";
    private int zzmq;
    private int zzmr;
    private int zzms;

    private ce() {
    }

    /* renamed from: com.google.android.gms.internal.firebase-perf.ce$a */
    public static final class a extends dq.a<ce, a> implements ez {
        private a() {
            super(ce.zzmt);
        }

        /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* access modifiers changed from: protected */
    public final Object a(int i2) {
        switch (cg.f9520a[i2 - 1]) {
            case 1:
                return new ce();
            case 2:
                return new a((byte) 0);
            case 3:
                return a((ex) zzmt, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001\u0003\f\u0002\u0004\f\u0003\u0005\f\u0004", new Object[]{"zzii", "zzik", "zzmp", "zzmq", bt.zzdq(), "zzmr", cd.zzdq(), "zzms", aw.zzdq()});
            case 4:
                return zzmt;
            case 5:
                fi<ce> fiVar = zzin;
                if (fiVar == null) {
                    synchronized (ce.class) {
                        fiVar = zzin;
                        if (fiVar == null) {
                            fiVar = new dq.c<>(zzmt);
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
        dq.a(ce.class, zzmt);
    }
}
