package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.bf;

public final class o {

    public static final class a extends bf<a, C0141a> implements co {
        private static volatile cx<a> zzbg;
        /* access modifiers changed from: private */
        public static final a zzes = new a();
        private int zzbb;
        private int zzel;
        private int zzem;
        private int zzen;
        private int zzeo;
        private int zzep;
        private int zzeq;
        private int zzer;

        /* renamed from: com.google.android.gms.internal.clearcut.o$a$a  reason: collision with other inner class name */
        public static final class C0141a extends bf.a<a, C0141a> implements co {
            private C0141a() {
                super(a.zzes);
            }

            /* synthetic */ C0141a(byte b2) {
                this();
            }
        }

        public enum b implements bi {
            UNKNOWN(0),
            ON(1),
            OFF(2);
            
            private static final bj<b> zzbq = null;
            private final int value;

            static {
                zzbq = new q();
            }

            private b(int i2) {
                this.value = i2;
            }

            public static bj<b> zzd() {
                return zzbq;
            }

            public static b zze(int i2) {
                if (i2 == 0) {
                    return UNKNOWN;
                }
                if (i2 == 1) {
                    return ON;
                }
                if (i2 != 2) {
                    return null;
                }
                return OFF;
            }

            public final int zzc() {
                return this.value;
            }
        }

        static {
            bf.a(a.class, zzes);
        }

        private a() {
        }

        /* JADX WARNING: type inference failed for: r3v14, types: [com.google.android.gms.internal.clearcut.bf$b, com.google.android.gms.internal.clearcut.cx<com.google.android.gms.internal.clearcut.o$a>] */
        /* access modifiers changed from: protected */
        public final Object a(int i2, Object obj) {
            cx<a> cxVar;
            switch (p.f9427a[i2 - 1]) {
                case 1:
                    return new a();
                case 2:
                    return new C0141a((byte) 0);
                case 3:
                    return a((cm) zzes, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\b\u0000\u0000\u0000\u0001\f\u0000\u0002\f\u0001\u0003\f\u0002\u0004\f\u0003\u0005\f\u0004\u0006\f\u0005\u0007\f\u0006", new Object[]{"zzbb", "zzel", b.zzd(), "zzem", b.zzd(), "zzen", b.zzd(), "zzeo", b.zzd(), "zzep", b.zzd(), "zzeq", b.zzd(), "zzer", b.zzd()});
                case 4:
                    return zzes;
                case 5:
                    cx<a> cxVar2 = zzbg;
                    cx<a> cxVar3 = cxVar2;
                    if (cxVar2 == null) {
                        synchronized (a.class) {
                            cx<a> cxVar4 = zzbg;
                            cxVar = cxVar4;
                            if (cxVar4 == null) {
                                ? bVar = new bf.b(zzes);
                                zzbg = bVar;
                                cxVar = bVar;
                            }
                        }
                        cxVar3 = cxVar;
                    }
                    return cxVar3;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }
}
