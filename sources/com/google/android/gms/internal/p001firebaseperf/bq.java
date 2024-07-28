package com.google.android.gms.internal.p001firebaseperf;

import com.google.android.gms.internal.p001firebaseperf.dq;

/* renamed from: com.google.android.gms.internal.firebase-perf.bq  reason: invalid package */
public final class bq extends dq<bq, a> implements ez {
    private static volatile fi<bq> zzin;
    private static final dw<Integer, bx> zzlt = new bs();
    /* access modifiers changed from: private */
    public static final bq zzlu = new bq();
    private int zzii;
    private String zzjz = "";
    private dx zzls = dr.d();

    private bq() {
    }

    /* renamed from: com.google.android.gms.internal.firebase-perf.bq$a */
    public static final class a extends dq.a<bq, a> implements ez {
        private a() {
            super(bq.zzlu);
        }

        public final a a(String str) {
            h();
            bq.a((bq) this.f9565a, str);
            return this;
        }

        public final a a(bx bxVar) {
            h();
            bq.a((bq) this.f9565a, bxVar);
            return this;
        }

        /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final int a() {
        return this.zzls.size();
    }

    public final bx b() {
        return zzlt.a(Integer.valueOf(this.zzls.b(0)));
    }

    public static a c() {
        return (a) zzlu.l();
    }

    /* access modifiers changed from: protected */
    public final Object a(int i2) {
        switch (br.f9513a[i2 - 1]) {
            case 1:
                return new bq();
            case 2:
                return new a((byte) 0);
            case 3:
                return a((ex) zzlu, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\b\u0000\u0002\u001e", new Object[]{"zzii", "zzjz", "zzls", bx.zzdq()});
            case 4:
                return zzlu;
            case 5:
                fi<bq> fiVar = zzin;
                if (fiVar == null) {
                    synchronized (bq.class) {
                        fiVar = zzin;
                        if (fiVar == null) {
                            fiVar = new dq.c<>(zzlu);
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
        dq.a(bq.class, zzlu);
    }

    static /* synthetic */ void a(bq bqVar, String str) {
        if (str != null) {
            bqVar.zzii |= 1;
            bqVar.zzjz = str;
            return;
        }
        throw new NullPointerException();
    }

    static /* synthetic */ void a(bq bqVar, bx bxVar) {
        if (bxVar != null) {
            if (!bqVar.zzls.a()) {
                dx dxVar = bqVar.zzls;
                int size = dxVar.size();
                bqVar.zzls = dxVar.a(size == 0 ? 10 : size << 1);
            }
            bqVar.zzls.c(bxVar.zzdp());
            return;
        }
        throw new NullPointerException();
    }
}
