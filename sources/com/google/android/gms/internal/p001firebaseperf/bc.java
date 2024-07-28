package com.google.android.gms.internal.p001firebaseperf;

import com.google.android.gms.internal.p001firebaseperf.dq;

/* renamed from: com.google.android.gms.internal.firebase-perf.bc  reason: invalid package */
public final class bc extends dq<bc, a> implements ez {
    private static volatile fi<bc> zzin;
    /* access modifiers changed from: private */
    public static final bc zzke = new bc();
    public int zzii;
    public String zzjz = "";
    public ba zzka;
    private dz<av> zzkb = fn.d();
    private dz<ao> zzkc = fn.d();
    private dz<bg> zzkd = fn.d();

    private bc() {
    }

    /* renamed from: com.google.android.gms.internal.firebase-perf.bc$a */
    public static final class a extends dq.a<bc, a> implements ez {
        private a() {
            super(bc.zzke);
        }

        public final a a(String str) {
            h();
            bc.a((bc) this.f9565a, str);
            return this;
        }

        public final a a(ba baVar) {
            h();
            bc.a((bc) this.f9565a, baVar);
            return this;
        }

        public final a a(av avVar) {
            h();
            bc.a((bc) this.f9565a, avVar);
            return this;
        }

        public final a a(ao aoVar) {
            h();
            bc.a((bc) this.f9565a, aoVar);
            return this;
        }

        /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final boolean a() {
        return (this.zzii & 2) != 0;
    }

    public final int b() {
        return this.zzkb.size();
    }

    public final int c() {
        return this.zzkc.size();
    }

    public static a d() {
        return (a) zzke.l();
    }

    /* access modifiers changed from: protected */
    public final Object a(int i2) {
        switch (bd.f9505a[i2 - 1]) {
            case 1:
                return new bc();
            case 2:
                return new a((byte) 0);
            case 3:
                return a((ex) zzke, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0003\u0000\u0001\b\u0000\u0002\u001b\u0003\t\u0001\u0004\u001b\u0005\u001b", new Object[]{"zzii", "zzjz", "zzkb", av.class, "zzka", "zzkc", ao.class, "zzkd", bg.class});
            case 4:
                return zzke;
            case 5:
                fi<bc> fiVar = zzin;
                if (fiVar == null) {
                    synchronized (bc.class) {
                        fiVar = zzin;
                        if (fiVar == null) {
                            fiVar = new dq.c<>(zzke);
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

    public static bc e() {
        return zzke;
    }

    static {
        dq.a(bc.class, zzke);
    }

    static /* synthetic */ void a(bc bcVar, String str) {
        if (str != null) {
            bcVar.zzii |= 1;
            bcVar.zzjz = str;
            return;
        }
        throw new NullPointerException();
    }

    static /* synthetic */ void a(bc bcVar, ba baVar) {
        if (baVar != null) {
            bcVar.zzka = baVar;
            bcVar.zzii |= 2;
            return;
        }
        throw new NullPointerException();
    }

    static /* synthetic */ void a(bc bcVar, av avVar) {
        if (avVar != null) {
            if (!bcVar.zzkb.a()) {
                bcVar.zzkb = dq.a(bcVar.zzkb);
            }
            bcVar.zzkb.add(avVar);
            return;
        }
        throw new NullPointerException();
    }

    static /* synthetic */ void a(bc bcVar, ao aoVar) {
        if (aoVar != null) {
            if (!bcVar.zzkc.a()) {
                bcVar.zzkc = dq.a(bcVar.zzkc);
            }
            bcVar.zzkc.add(aoVar);
            return;
        }
        throw new NullPointerException();
    }
}
