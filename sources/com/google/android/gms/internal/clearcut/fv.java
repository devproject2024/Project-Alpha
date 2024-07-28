package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.bf;

public final class fv {

    public static final class a extends bf<a, C0138a> implements co {
        private static volatile cx<a> zzbg;
        /* access modifiers changed from: private */
        public static final a zzbir = new a();
        bm<b> zzbiq = da.d();

        /* renamed from: com.google.android.gms.internal.clearcut.fv$a$a  reason: collision with other inner class name */
        public static final class C0138a extends bf.a<a, C0138a> implements co {
            private C0138a() {
                super(a.zzbir);
            }

            /* synthetic */ C0138a(byte b2) {
                this();
            }
        }

        static {
            bf.a(a.class, zzbir);
        }

        public static a a() {
            return zzbir;
        }

        public static a a(byte[] bArr) throws bn {
            return (a) bf.a(zzbir, bArr);
        }

        /* JADX WARNING: type inference failed for: r3v14, types: [com.google.android.gms.internal.clearcut.cx<com.google.android.gms.internal.clearcut.fv$a>, com.google.android.gms.internal.clearcut.bf$b] */
        /* access modifiers changed from: protected */
        public final Object a(int i2, Object obj) {
            cx<a> cxVar;
            switch (fw.f9372a[i2 - 1]) {
                case 1:
                    return new a();
                case 2:
                    return new C0138a((byte) 0);
                case 3:
                    return a((cm) zzbir, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0002\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzbiq", b.class});
                case 4:
                    return zzbir;
                case 5:
                    cx<a> cxVar2 = zzbg;
                    cx<a> cxVar3 = cxVar2;
                    if (cxVar2 == null) {
                        synchronized (a.class) {
                            cx<a> cxVar4 = zzbg;
                            cxVar = cxVar4;
                            if (cxVar4 == null) {
                                ? bVar = new bf.b(zzbir);
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

        public static final class b extends bf<b, C0139a> implements co {
            private static volatile cx<b> zzbg;
            /* access modifiers changed from: private */
            public static final b zzbiv = new b();
            int zzbb;
            String zzbis = "";
            long zzbit;
            long zzbiu;
            int zzya;

            /* renamed from: com.google.android.gms.internal.clearcut.fv$a$b$a  reason: collision with other inner class name */
            public static final class C0139a extends bf.a<b, C0139a> implements co {
                private C0139a() {
                    super(b.zzbiv);
                }

                /* synthetic */ C0139a(byte b2) {
                    this();
                }

                public final C0139a a(long j) {
                    b();
                    b.a((b) this.f9183a, j);
                    return this;
                }

                public final C0139a a(String str) {
                    b();
                    b.a((b) this.f9183a, str);
                    return this;
                }

                public final C0139a b(long j) {
                    b();
                    b.b((b) this.f9183a, j);
                    return this;
                }
            }

            static {
                bf.a(b.class, zzbiv);
            }

            private b() {
            }

            public static C0139a a() {
                return (C0139a) ((bf.a) zzbiv.a(bf.g.f9200e, (Object) null));
            }

            /* JADX WARNING: type inference failed for: r3v14, types: [com.google.android.gms.internal.clearcut.cx<com.google.android.gms.internal.clearcut.fv$a$b>, com.google.android.gms.internal.clearcut.bf$b] */
            /* access modifiers changed from: protected */
            public final Object a(int i2, Object obj) {
                cx<b> cxVar;
                switch (fw.f9372a[i2 - 1]) {
                    case 1:
                        return new b();
                    case 2:
                        return new C0139a((byte) 0);
                    case 3:
                        return a((cm) zzbiv, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0005\u0000\u0000\u0000\u0001\u0004\u0000\u0002\b\u0001\u0003\u0002\u0002\u0004\u0002\u0003", new Object[]{"zzbb", "zzya", "zzbis", "zzbit", "zzbiu"});
                    case 4:
                        return zzbiv;
                    case 5:
                        cx<b> cxVar2 = zzbg;
                        cx<b> cxVar3 = cxVar2;
                        if (cxVar2 == null) {
                            synchronized (b.class) {
                                cx<b> cxVar4 = zzbg;
                                cxVar = cxVar4;
                                if (cxVar4 == null) {
                                    ? bVar = new bf.b(zzbiv);
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

            static /* synthetic */ void a(b bVar, String str) {
                if (str != null) {
                    bVar.zzbb |= 2;
                    bVar.zzbis = str;
                    return;
                }
                throw new NullPointerException();
            }

            static /* synthetic */ void a(b bVar, long j) {
                bVar.zzbb |= 4;
                bVar.zzbit = j;
            }

            static /* synthetic */ void b(b bVar, long j) {
                bVar.zzbb |= 8;
                bVar.zzbiu = j;
            }
        }

        private a() {
        }
    }
}
