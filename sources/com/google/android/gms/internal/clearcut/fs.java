package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.bf;

public final class fs {

    public static final class a extends bf<a, C0137a> implements co {
        private static volatile cx<a> zzbg;
        /* access modifiers changed from: private */
        public static final a zzbil = new a();

        /* renamed from: com.google.android.gms.internal.clearcut.fs$a$a  reason: collision with other inner class name */
        public static final class C0137a extends bf.a<a, C0137a> implements co {
            private C0137a() {
                super(a.zzbil);
            }

            /* synthetic */ C0137a(byte b2) {
                this();
            }
        }

        public enum b implements bi {
            NO_RESTRICTION(0),
            SIDEWINDER_DEVICE(1),
            LATCHSKY_DEVICE(2);
            
            private static final bj<b> zzbq = null;
            private final int value;

            static {
                zzbq = new fu();
            }

            private b(int i2) {
                this.value = i2;
            }

            public static b zzbe(int i2) {
                if (i2 == 0) {
                    return NO_RESTRICTION;
                }
                if (i2 == 1) {
                    return SIDEWINDER_DEVICE;
                }
                if (i2 != 2) {
                    return null;
                }
                return LATCHSKY_DEVICE;
            }

            public static bj<b> zzd() {
                return zzbq;
            }

            public final int zzc() {
                return this.value;
            }
        }

        static {
            bf.a(a.class, zzbil);
        }

        private a() {
        }

        /* JADX WARNING: type inference failed for: r2v13, types: [com.google.android.gms.internal.clearcut.bf$b, com.google.android.gms.internal.clearcut.cx<com.google.android.gms.internal.clearcut.fs$a>] */
        /* access modifiers changed from: protected */
        public final Object a(int i2, Object obj) {
            cx<a> cxVar;
            switch (ft.f9371a[i2 - 1]) {
                case 1:
                    return new a();
                case 2:
                    return new C0137a((byte) 0);
                case 3:
                    return a((cm) zzbil, "\u0001\u0000", (Object[]) null);
                case 4:
                    return zzbil;
                case 5:
                    cx<a> cxVar2 = zzbg;
                    cx<a> cxVar3 = cxVar2;
                    if (cxVar2 == null) {
                        synchronized (a.class) {
                            cx<a> cxVar4 = zzbg;
                            cxVar = cxVar4;
                            if (cxVar4 == null) {
                                ? bVar = new bf.b(zzbil);
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
