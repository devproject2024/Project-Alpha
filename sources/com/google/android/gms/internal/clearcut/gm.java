package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.bf;

public final class gm {

    public static final class a extends bf<a, C0140a> implements co {
        /* access modifiers changed from: private */
        public static final a zzbf = new a();
        private static volatile cx<a> zzbg;
        private int zzbb;
        private int zzbc;
        private int zzbd;
        private int zzbe;

        /* renamed from: com.google.android.gms.internal.clearcut.gm$a$a  reason: collision with other inner class name */
        public static final class C0140a extends bf.a<a, C0140a> implements co {
            private C0140a() {
                super(a.zzbf);
            }

            /* synthetic */ C0140a(byte b2) {
                this();
            }
        }

        public enum b implements bi {
            ARCH_UNKNOWN(0),
            ARCH_NON_NATIVE(1),
            ARCH_ARMV5(2),
            ARCH_ARMV7(4),
            ARCH_ARM64(5),
            ARCH_MIPS(6),
            ARCH_MIPS_64(7),
            ARCH_X86(8),
            ARCH_X86_64(9);
            
            private static final bj<b> zzbq = null;
            private final int value;

            static {
                zzbq = new go();
            }

            private b(int i2) {
                this.value = i2;
            }

            public static b zza(int i2) {
                switch (i2) {
                    case 0:
                        return ARCH_UNKNOWN;
                    case 1:
                        return ARCH_NON_NATIVE;
                    case 2:
                        return ARCH_ARMV5;
                    case 4:
                        return ARCH_ARMV7;
                    case 5:
                        return ARCH_ARM64;
                    case 6:
                        return ARCH_MIPS;
                    case 7:
                        return ARCH_MIPS_64;
                    case 8:
                        return ARCH_X86;
                    case 9:
                        return ARCH_X86_64;
                    default:
                        return null;
                }
            }

            public static bj<b> zzd() {
                return zzbq;
            }

            public final int zzc() {
                return this.value;
            }
        }

        public enum c implements bi {
            BUILD_TYPE_UNKNOWN(0),
            BUILD_TYPE_PROD(1),
            BUILD_TYPE_INTERNAL(2),
            BUILD_TYPE_PRODLMP(3),
            BUILD_TYPE_THINGS(4),
            BUILD_TYPE_PRODMNC(5),
            BUILD_TYPE_WEARABLE(6),
            BUILD_TYPE_AUTO(7),
            BUILD_TYPE_SIDEWINDERMNC(8),
            BUILD_TYPE_ATV(9),
            BUILD_TYPE_PRODPIX(10),
            BUILD_TYPE_PRODPI(11);
            
            private static final bj<c> zzbq = null;
            private final int value;

            static {
                zzbq = new gp();
            }

            private c(int i2) {
                this.value = i2;
            }

            public static c zzc(int i2) {
                switch (i2) {
                    case 0:
                        return BUILD_TYPE_UNKNOWN;
                    case 1:
                        return BUILD_TYPE_PROD;
                    case 2:
                        return BUILD_TYPE_INTERNAL;
                    case 3:
                        return BUILD_TYPE_PRODLMP;
                    case 4:
                        return BUILD_TYPE_THINGS;
                    case 5:
                        return BUILD_TYPE_PRODMNC;
                    case 6:
                        return BUILD_TYPE_WEARABLE;
                    case 7:
                        return BUILD_TYPE_AUTO;
                    case 8:
                        return BUILD_TYPE_SIDEWINDERMNC;
                    case 9:
                        return BUILD_TYPE_ATV;
                    case 10:
                        return BUILD_TYPE_PRODPIX;
                    case 11:
                        return BUILD_TYPE_PRODPI;
                    default:
                        return null;
                }
            }

            public static bj<c> zzd() {
                return zzbq;
            }

            public final int zzc() {
                return this.value;
            }
        }

        public enum d implements bi {
            DENSITY_UNKNOWN(0),
            DENSITY_ALLDPI(1),
            DENSITY_LDPI(2),
            DENSITY_MDPI(3),
            DENSITY_TVDPI(4),
            DENSITY_HDPI(5),
            DENSITY_XHDPI(7),
            DENSITY_DPI400(8),
            DENSITY_XXHDPI(9),
            DENSITY_XXXHDPI(10);
            
            private static final bj<d> zzbq = null;
            private final int value;

            static {
                zzbq = new gq();
            }

            private d(int i2) {
                this.value = i2;
            }

            public static bj<d> zzd() {
                return zzbq;
            }

            public static d zzd(int i2) {
                switch (i2) {
                    case 0:
                        return DENSITY_UNKNOWN;
                    case 1:
                        return DENSITY_ALLDPI;
                    case 2:
                        return DENSITY_LDPI;
                    case 3:
                        return DENSITY_MDPI;
                    case 4:
                        return DENSITY_TVDPI;
                    case 5:
                        return DENSITY_HDPI;
                    case 7:
                        return DENSITY_XHDPI;
                    case 8:
                        return DENSITY_DPI400;
                    case 9:
                        return DENSITY_XXHDPI;
                    case 10:
                        return DENSITY_XXXHDPI;
                    default:
                        return null;
                }
            }

            public final int zzc() {
                return this.value;
            }
        }

        static {
            bf.a(a.class, zzbf);
        }

        private a() {
        }

        /* JADX WARNING: type inference failed for: r3v14, types: [com.google.android.gms.internal.clearcut.cx<com.google.android.gms.internal.clearcut.gm$a>, com.google.android.gms.internal.clearcut.bf$b] */
        /* access modifiers changed from: protected */
        public final Object a(int i2, Object obj) {
            cx<a> cxVar;
            switch (gn.f9405a[i2 - 1]) {
                case 1:
                    return new a();
                case 2:
                    return new C0140a((byte) 0);
                case 3:
                    return a((cm) zzbf, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0004\u0000\u0000\u0000\u0001\f\u0000\u0002\f\u0001\u0003\f\u0002", new Object[]{"zzbb", "zzbc", c.zzd(), "zzbd", b.zzd(), "zzbe", d.zzd()});
                case 4:
                    return zzbf;
                case 5:
                    cx<a> cxVar2 = zzbg;
                    cx<a> cxVar3 = cxVar2;
                    if (cxVar2 == null) {
                        synchronized (a.class) {
                            cx<a> cxVar4 = zzbg;
                            cxVar = cxVar4;
                            if (cxVar4 == null) {
                                ? bVar = new bf.b(zzbf);
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
