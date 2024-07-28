package com.google.android.gms.internal.p001firebaseperf;

import com.google.android.gms.internal.p001firebaseperf.dq;

/* renamed from: com.google.android.gms.internal.firebase-perf.ak  reason: invalid package */
public final class ak extends dq<ak, a> implements ez {
    /* access modifiers changed from: private */
    public static final ak zzim = new ak();
    private static volatile fi<ak> zzin;
    public int zzii;
    private String zzij = "";
    private String zzik = "";
    private String zzil = "";

    private ak() {
    }

    /* renamed from: com.google.android.gms.internal.firebase-perf.ak$a */
    public static final class a extends dq.a<ak, a> implements ez {
        private a() {
            super(ak.zzim);
        }

        public final a a(String str) {
            h();
            ak.a((ak) this.f9565a, str);
            return this;
        }

        public final a b(String str) {
            h();
            ak.b((ak) this.f9565a, str);
            return this;
        }

        public final a c(String str) {
            h();
            ak.c((ak) this.f9565a, str);
            return this;
        }

        /* synthetic */ a(byte b2) {
            this();
        }
    }

    public static a a() {
        return (a) zzim.l();
    }

    /* access modifiers changed from: protected */
    public final Object a(int i2) {
        switch (am.f9497a[i2 - 1]) {
            case 1:
                return new ak();
            case 2:
                return new a((byte) 0);
            case 3:
                return a((ex) zzim, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001\u0003\b\u0002", new Object[]{"zzii", "zzij", "zzik", "zzil"});
            case 4:
                return zzim;
            case 5:
                fi<ak> fiVar = zzin;
                if (fiVar == null) {
                    synchronized (ak.class) {
                        fiVar = zzin;
                        if (fiVar == null) {
                            fiVar = new dq.c<>(zzim);
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

    public static ak b() {
        return zzim;
    }

    static {
        dq.a(ak.class, zzim);
    }

    static /* synthetic */ void a(ak akVar, String str) {
        if (str != null) {
            akVar.zzii |= 1;
            akVar.zzij = str;
            return;
        }
        throw new NullPointerException();
    }

    static /* synthetic */ void b(ak akVar, String str) {
        if (str != null) {
            akVar.zzii |= 2;
            akVar.zzik = str;
            return;
        }
        throw new NullPointerException();
    }

    static /* synthetic */ void c(ak akVar, String str) {
        if (str != null) {
            akVar.zzii |= 4;
            akVar.zzil = str;
            return;
        }
        throw new NullPointerException();
    }
}
