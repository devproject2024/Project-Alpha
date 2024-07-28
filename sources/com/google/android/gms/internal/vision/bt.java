package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.ej;
import com.j256.ormlite.stmt.query.SimpleComparison;

public final class bt {

    public static final class b extends ej<b, a> implements fv {
        private static volatile gc<b> zzbd;
        private static final es<Integer, ch> zzmr = new bu();
        /* access modifiers changed from: private */
        public static final b zzms;
        private eo zzmq = el.d();

        /* JADX WARNING: type inference failed for: r0v0, types: [com.google.android.gms.internal.vision.eo, com.google.android.gms.internal.vision.el] */
        private b() {
        }

        public static final class a extends ej.a<b, a> implements fv {
            private a() {
                super(b.zzms);
            }

            /* synthetic */ a(byte b2) {
                this();
            }
        }

        /* JADX WARNING: type inference failed for: r4v14, types: [com.google.android.gms.internal.vision.ej$b, com.google.android.gms.internal.vision.gc<com.google.android.gms.internal.vision.bt$b>] */
        /* access modifiers changed from: protected */
        public final Object a(int i2) {
            gc<b> gcVar;
            switch (br.f11004a[i2 - 1]) {
                case 1:
                    return new b();
                case 2:
                    return new a((byte) 0);
                case 3:
                    return a((ft) zzms, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001e", new Object[]{"zzmq", ch.zzah()});
                case 4:
                    return zzms;
                case 5:
                    gc<b> gcVar2 = zzbd;
                    gc<b> gcVar3 = gcVar2;
                    if (gcVar2 == null) {
                        synchronized (b.class) {
                            gc<b> gcVar4 = zzbd;
                            gcVar = gcVar4;
                            if (gcVar4 == null) {
                                ? bVar = new ej.b(zzms);
                                zzbd = bVar;
                                gcVar = bVar;
                            }
                        }
                        gcVar3 = gcVar;
                    }
                    return gcVar3;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        /* JADX WARNING: type inference failed for: r0v0, types: [com.google.android.gms.internal.vision.es<java.lang.Integer, com.google.android.gms.internal.vision.ch>, com.google.android.gms.internal.vision.bu] */
        static {
            b bVar = new b();
            zzms = bVar;
            ej.a(b.class, bVar);
        }
    }

    public static final class c extends ej<c, a> implements fv {
        private static volatile gc<c> zzbd;
        /* access modifiers changed from: private */
        public static final c zzmw;
        private int zzbf;
        private int zzmt;
        private int zzmu;
        private String zzmv = "";

        private c() {
        }

        public static final class a extends ej.a<c, a> implements fv {
            private a() {
                super(c.zzmw);
            }

            /* synthetic */ a(byte b2) {
                this();
            }
        }

        /* JADX WARNING: type inference failed for: r4v14, types: [com.google.android.gms.internal.vision.ej$b, com.google.android.gms.internal.vision.gc<com.google.android.gms.internal.vision.bt$c>] */
        /* access modifiers changed from: protected */
        public final Object a(int i2) {
            gc<c> gcVar;
            switch (br.f11004a[i2 - 1]) {
                case 1:
                    return new c();
                case 2:
                    return new a((byte) 0);
                case 3:
                    return a((ft) zzmw, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဌ\u0001\u0003ဈ\u0002", new Object[]{"zzbf", "zzmt", ch.zzah(), "zzmu", cl.zzah(), "zzmv"});
                case 4:
                    return zzmw;
                case 5:
                    gc<c> gcVar2 = zzbd;
                    gc<c> gcVar3 = gcVar2;
                    if (gcVar2 == null) {
                        synchronized (c.class) {
                            gc<c> gcVar4 = zzbd;
                            gcVar = gcVar4;
                            if (gcVar4 == null) {
                                ? bVar = new ej.b(zzmw);
                                zzbd = bVar;
                                gcVar = bVar;
                            }
                        }
                        gcVar3 = gcVar;
                    }
                    return gcVar3;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            c cVar = new c();
            zzmw = cVar;
            ej.a(c.class, cVar);
        }
    }

    public static final class e extends ej<e, b> implements fv {
        private static volatile gc<e> zzbd;
        /* access modifiers changed from: private */
        public static final e zznh;
        private int zzbf;
        private String zzmz = "";
        private boolean zzna;
        private int zznb;
        private long zznc;
        private long zznd;
        private long zzne;
        private String zznf = "";
        private boolean zzng;

        public enum a implements en {
            REASON_UNKNOWN(0),
            REASON_MISSING(1),
            REASON_UPGRADE(2),
            REASON_INVALID(3);
            
            private static final em<a> zzhc = null;
            private final int value;

            public final int zzag() {
                return this.value;
            }

            public static a zzt(int i2) {
                if (i2 == 0) {
                    return REASON_UNKNOWN;
                }
                if (i2 == 1) {
                    return REASON_MISSING;
                }
                if (i2 == 2) {
                    return REASON_UPGRADE;
                }
                if (i2 != 3) {
                    return null;
                }
                return REASON_INVALID;
            }

            public static ep zzah() {
                return bv.f11005a;
            }

            public final String toString() {
                return SimpleComparison.LESS_THAN_OPERATION + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + '>';
            }

            private a(int i2) {
                this.value = i2;
            }

            static {
                zzhc = new bw();
            }
        }

        private e() {
        }

        public static final class b extends ej.a<e, b> implements fv {
            private b() {
                super(e.zznh);
            }

            /* synthetic */ b(byte b2) {
                this();
            }
        }

        /* JADX WARNING: type inference failed for: r4v14, types: [com.google.android.gms.internal.vision.ej$b, com.google.android.gms.internal.vision.gc<com.google.android.gms.internal.vision.bt$e>] */
        /* access modifiers changed from: protected */
        public final Object a(int i2) {
            gc<e> gcVar;
            switch (br.f11004a[i2 - 1]) {
                case 1:
                    return new e();
                case 2:
                    return new b((byte) 0);
                case 3:
                    return a((ft) zznh, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဇ\u0001\u0003ဌ\u0002\u0004ဂ\u0003\u0005ဂ\u0004\u0006ဂ\u0005\u0007ဈ\u0006\bဇ\u0007", new Object[]{"zzbf", "zzmz", "zzna", "zznb", a.zzah(), "zznc", "zznd", "zzne", "zznf", "zzng"});
                case 4:
                    return zznh;
                case 5:
                    gc<e> gcVar2 = zzbd;
                    gc<e> gcVar3 = gcVar2;
                    if (gcVar2 == null) {
                        synchronized (e.class) {
                            gc<e> gcVar4 = zzbd;
                            gcVar = gcVar4;
                            if (gcVar4 == null) {
                                ? bVar = new ej.b(zznh);
                                zzbd = bVar;
                                gcVar = bVar;
                            }
                        }
                        gcVar3 = gcVar;
                    }
                    return gcVar3;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            e eVar = new e();
            zznh = eVar;
            ej.a(e.class, eVar);
        }
    }

    public static final class l extends ej<l, a> implements fv {
        private static volatile gc<l> zzbd;
        /* access modifiers changed from: private */
        public static final l zzpu;
        private int zzbf;
        private long zzns;
        private long zznt;

        private l() {
        }

        public static final class a extends ej.a<l, a> implements fv {
            private a() {
                super(l.zzpu);
            }

            /* synthetic */ a(byte b2) {
                this();
            }
        }

        /* JADX WARNING: type inference failed for: r4v14, types: [com.google.android.gms.internal.vision.ej$b, com.google.android.gms.internal.vision.gc<com.google.android.gms.internal.vision.bt$l>] */
        /* access modifiers changed from: protected */
        public final Object a(int i2) {
            gc<l> gcVar;
            switch (br.f11004a[i2 - 1]) {
                case 1:
                    return new l();
                case 2:
                    return new a((byte) 0);
                case 3:
                    return a((ft) zzpu, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဂ\u0001", new Object[]{"zzbf", "zzns", "zznt"});
                case 4:
                    return zzpu;
                case 5:
                    gc<l> gcVar2 = zzbd;
                    gc<l> gcVar3 = gcVar2;
                    if (gcVar2 == null) {
                        synchronized (l.class) {
                            gc<l> gcVar4 = zzbd;
                            gcVar = gcVar4;
                            if (gcVar4 == null) {
                                ? bVar = new ej.b(zzpu);
                                zzbd = bVar;
                                gcVar = bVar;
                            }
                        }
                        gcVar3 = gcVar;
                    }
                    return gcVar3;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            l lVar = new l();
            zzpu = lVar;
            ej.a(l.class, lVar);
        }
    }

    public static final class a extends ej<a, C0158a> implements fv {
        private static volatile gc<a> zzbd;
        /* access modifiers changed from: private */
        public static final a zzmp;
        private int zzbf;
        private String zzmn = "";
        private String zzmo = "";

        private a() {
        }

        /* renamed from: com.google.android.gms.internal.vision.bt$a$a  reason: collision with other inner class name */
        public static final class C0158a extends ej.a<a, C0158a> implements fv {
            private C0158a() {
                super(a.zzmp);
            }

            public final C0158a a(String str) {
                if (this.f11092b) {
                    b();
                    this.f11092b = false;
                }
                a.a((a) this.f11091a, str);
                return this;
            }

            public final C0158a b(String str) {
                if (this.f11092b) {
                    b();
                    this.f11092b = false;
                }
                a.b((a) this.f11091a, str);
                return this;
            }

            /* synthetic */ C0158a(byte b2) {
                this();
            }
        }

        public static C0158a a() {
            return (C0158a) zzmp.f();
        }

        /* JADX WARNING: type inference failed for: r4v14, types: [com.google.android.gms.internal.vision.ej$b, com.google.android.gms.internal.vision.gc<com.google.android.gms.internal.vision.bt$a>] */
        /* access modifiers changed from: protected */
        public final Object a(int i2) {
            gc<a> gcVar;
            switch (br.f11004a[i2 - 1]) {
                case 1:
                    return new a();
                case 2:
                    return new C0158a((byte) 0);
                case 3:
                    return a((ft) zzmp, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zzbf", "zzmn", "zzmo"});
                case 4:
                    return zzmp;
                case 5:
                    gc<a> gcVar2 = zzbd;
                    gc<a> gcVar3 = gcVar2;
                    if (gcVar2 == null) {
                        synchronized (a.class) {
                            gc<a> gcVar4 = zzbd;
                            gcVar = gcVar4;
                            if (gcVar4 == null) {
                                ? bVar = new ej.b(zzmp);
                                zzbd = bVar;
                                gcVar = bVar;
                            }
                        }
                        gcVar3 = gcVar;
                    }
                    return gcVar3;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            a aVar = new a();
            zzmp = aVar;
            ej.a(a.class, aVar);
        }

        static /* synthetic */ void a(a aVar, String str) {
            str.getClass();
            aVar.zzbf |= 1;
            aVar.zzmn = str;
        }

        static /* synthetic */ void b(a aVar, String str) {
            str.getClass();
            aVar.zzbf |= 2;
            aVar.zzmo = str;
        }
    }

    public static final class d extends ej<d, a> implements fv {
        private static volatile gc<d> zzbd;
        /* access modifiers changed from: private */
        public static final d zzmy;
        private eq<m> zzmx = gh.d();

        private d() {
        }

        public static final class a extends ej.a<d, a> implements fv {
            private a() {
                super(d.zzmy);
            }

            /* synthetic */ a(byte b2) {
                this();
            }
        }

        /* JADX WARNING: type inference failed for: r4v14, types: [com.google.android.gms.internal.vision.gc<com.google.android.gms.internal.vision.bt$d>, com.google.android.gms.internal.vision.ej$b] */
        /* access modifiers changed from: protected */
        public final Object a(int i2) {
            gc<d> gcVar;
            switch (br.f11004a[i2 - 1]) {
                case 1:
                    return new d();
                case 2:
                    return new a((byte) 0);
                case 3:
                    return a((ft) zzmy, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzmx", m.class});
                case 4:
                    return zzmy;
                case 5:
                    gc<d> gcVar2 = zzbd;
                    gc<d> gcVar3 = gcVar2;
                    if (gcVar2 == null) {
                        synchronized (d.class) {
                            gc<d> gcVar4 = zzbd;
                            gcVar = gcVar4;
                            if (gcVar4 == null) {
                                ? bVar = new ej.b(zzmy);
                                zzbd = bVar;
                                gcVar = bVar;
                            }
                        }
                        gcVar3 = gcVar;
                    }
                    return gcVar3;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            d dVar = new d();
            zzmy = dVar;
            ej.a(d.class, dVar);
        }
    }

    public static final class m extends ej<m, a> implements fv {
        private static volatile gc<m> zzbd;
        /* access modifiers changed from: private */
        public static final m zzpx;
        private int zzbf;
        private int zzpv;
        private int zzpw;

        private m() {
        }

        /* JADX WARNING: type inference failed for: r4v14, types: [com.google.android.gms.internal.vision.ej$b, com.google.android.gms.internal.vision.gc<com.google.android.gms.internal.vision.bt$m>] */
        /* access modifiers changed from: protected */
        public final Object a(int i2) {
            gc<m> gcVar;
            switch (br.f11004a[i2 - 1]) {
                case 1:
                    return new m();
                case 2:
                    return new a((byte) 0);
                case 3:
                    return a((ft) zzpx, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001", new Object[]{"zzbf", "zzpv", "zzpw"});
                case 4:
                    return zzpx;
                case 5:
                    gc<m> gcVar2 = zzbd;
                    gc<m> gcVar3 = gcVar2;
                    if (gcVar2 == null) {
                        synchronized (m.class) {
                            gc<m> gcVar4 = zzbd;
                            gcVar = gcVar4;
                            if (gcVar4 == null) {
                                ? bVar = new ej.b(zzpx);
                                zzbd = bVar;
                                gcVar = bVar;
                            }
                        }
                        gcVar3 = gcVar;
                    }
                    return gcVar3;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static final class a extends ej.a<m, a> implements fv {
            private a() {
                super(m.zzpx);
            }

            /* synthetic */ a(byte b2) {
                this();
            }
        }

        static {
            m mVar = new m();
            zzpx = mVar;
            ej.a(m.class, mVar);
        }
    }

    public static final class o extends ej<o, a> implements fv {
        private static volatile gc<o> zzbd;
        /* access modifiers changed from: private */
        public static final o zzqh;
        private int zzbf;
        private e zzqd;
        private k zzqe;
        private i zzqf;
        private int zzqg;

        private o() {
        }

        public static a a() {
            return (a) zzqh.f();
        }

        /* JADX WARNING: type inference failed for: r4v14, types: [com.google.android.gms.internal.vision.ej$b, com.google.android.gms.internal.vision.gc<com.google.android.gms.internal.vision.bt$o>] */
        /* access modifiers changed from: protected */
        public final Object a(int i2) {
            gc<o> gcVar;
            switch (br.f11004a[i2 - 1]) {
                case 1:
                    return new o();
                case 2:
                    return new a((byte) 0);
                case 3:
                    return a((ft) zzqh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004င\u0003", new Object[]{"zzbf", "zzqd", "zzqe", "zzqf", "zzqg"});
                case 4:
                    return zzqh;
                case 5:
                    gc<o> gcVar2 = zzbd;
                    gc<o> gcVar3 = gcVar2;
                    if (gcVar2 == null) {
                        synchronized (o.class) {
                            gc<o> gcVar4 = zzbd;
                            gcVar = gcVar4;
                            if (gcVar4 == null) {
                                ? bVar = new ej.b(zzqh);
                                zzbd = bVar;
                                gcVar = bVar;
                            }
                        }
                        gcVar3 = gcVar;
                    }
                    return gcVar3;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static final class a extends ej.a<o, a> implements fv {
            private a() {
                super(o.zzqh);
            }

            /* synthetic */ a(byte b2) {
                this();
            }
        }

        static {
            o oVar = new o();
            zzqh = oVar;
            ej.a(o.class, oVar);
        }
    }

    public static final class n extends ej<n, a> implements fv {
        private static volatile gc<n> zzbd;
        /* access modifiers changed from: private */
        public static final n zzqc;
        private int zzbf;
        private d zzpy;
        private int zzpz;
        private h zzqa;
        private c zzqb;

        private n() {
        }

        /* JADX WARNING: type inference failed for: r4v14, types: [com.google.android.gms.internal.vision.ej$b, com.google.android.gms.internal.vision.gc<com.google.android.gms.internal.vision.bt$n>] */
        /* access modifiers changed from: protected */
        public final Object a(int i2) {
            gc<n> gcVar;
            switch (br.f11004a[i2 - 1]) {
                case 1:
                    return new n();
                case 2:
                    return new a((byte) 0);
                case 3:
                    return a((ft) zzqc, "\u0001\u0004\u0000\u0001\u0001\u0011\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002င\u0001\u0010ဉ\u0002\u0011ဉ\u0003", new Object[]{"zzbf", "zzpy", "zzpz", "zzqa", "zzqb"});
                case 4:
                    return zzqc;
                case 5:
                    gc<n> gcVar2 = zzbd;
                    gc<n> gcVar3 = gcVar2;
                    if (gcVar2 == null) {
                        synchronized (n.class) {
                            gc<n> gcVar4 = zzbd;
                            gcVar = gcVar4;
                            if (gcVar4 == null) {
                                ? bVar = new ej.b(zzqc);
                                zzbd = bVar;
                                gcVar = bVar;
                            }
                        }
                        gcVar3 = gcVar;
                    }
                    return gcVar3;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static final class a extends ej.a<n, a> implements fv {
            private a() {
                super(n.zzqc);
            }

            /* synthetic */ a(byte b2) {
                this();
            }
        }

        static {
            n nVar = new n();
            zzqc = nVar;
            ej.a(n.class, nVar);
        }
    }

    public static final class j extends ej<j, a> implements fv {
        private static volatile gc<j> zzbd;
        /* access modifiers changed from: private */
        public static final j zzpj;
        private int zzbf;
        private int zzmt;
        private long zzpf;
        private long zzpg;
        private long zzph;
        private long zzpi;

        public enum b implements en {
            FORMAT_UNKNOWN(0),
            FORMAT_LUMINANCE(1),
            FORMAT_RGB8(2),
            FORMAT_MONOCHROME(3);
            
            private static final em<b> zzhc = null;
            private final int value;

            public final int zzag() {
                return this.value;
            }

            public static b zzy(int i2) {
                if (i2 == 0) {
                    return FORMAT_UNKNOWN;
                }
                if (i2 == 1) {
                    return FORMAT_LUMINANCE;
                }
                if (i2 == 2) {
                    return FORMAT_RGB8;
                }
                if (i2 != 3) {
                    return null;
                }
                return FORMAT_MONOCHROME;
            }

            public static ep zzah() {
                return cg.f11010a;
            }

            public final String toString() {
                return SimpleComparison.LESS_THAN_OPERATION + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + '>';
            }

            private b(int i2) {
                this.value = i2;
            }

            static {
                zzhc = new cf();
            }
        }

        private j() {
        }

        /* JADX WARNING: type inference failed for: r4v14, types: [com.google.android.gms.internal.vision.ej$b, com.google.android.gms.internal.vision.gc<com.google.android.gms.internal.vision.bt$j>] */
        /* access modifiers changed from: protected */
        public final Object a(int i2) {
            gc<j> gcVar;
            switch (br.f11004a[i2 - 1]) {
                case 1:
                    return new j();
                case 2:
                    return new a((byte) 0);
                case 3:
                    return a((ft) zzpj, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဂ\u0001\u0003ဂ\u0002\u0004ဂ\u0004\u0005ဂ\u0003", new Object[]{"zzbf", "zzmt", b.zzah(), "zzpf", "zzpg", "zzpi", "zzph"});
                case 4:
                    return zzpj;
                case 5:
                    gc<j> gcVar2 = zzbd;
                    gc<j> gcVar3 = gcVar2;
                    if (gcVar2 == null) {
                        synchronized (j.class) {
                            gc<j> gcVar4 = zzbd;
                            gcVar = gcVar4;
                            if (gcVar4 == null) {
                                ? bVar = new ej.b(zzpj);
                                zzbd = bVar;
                                gcVar = bVar;
                            }
                        }
                        gcVar3 = gcVar;
                    }
                    return gcVar3;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static final class a extends ej.a<j, a> implements fv {
            private a() {
                super(j.zzpj);
            }

            /* synthetic */ a(byte b2) {
                this();
            }
        }

        static {
            j jVar = new j();
            zzpj = jVar;
            ej.a(j.class, jVar);
        }
    }

    public static final class i extends ej<i, a> implements fv {
        private static volatile gc<i> zzbd;
        /* access modifiers changed from: private */
        public static final i zzpe;
        private int zzbf;
        private j zzpb;
        private l zzpc;
        private eq<f> zzpd = gh.d();

        private i() {
        }

        public static final class a extends ej.a<i, a> implements fv {
            private a() {
                super(i.zzpe);
            }

            /* synthetic */ a(byte b2) {
                this();
            }
        }

        /* JADX WARNING: type inference failed for: r4v14, types: [com.google.android.gms.internal.vision.ej$b, com.google.android.gms.internal.vision.gc<com.google.android.gms.internal.vision.bt$i>] */
        /* access modifiers changed from: protected */
        public final Object a(int i2) {
            gc<i> gcVar;
            switch (br.f11004a[i2 - 1]) {
                case 1:
                    return new i();
                case 2:
                    return new a((byte) 0);
                case 3:
                    return a((ft) zzpe, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003\u001b", new Object[]{"zzbf", "zzpb", "zzpc", "zzpd", f.class});
                case 4:
                    return zzpe;
                case 5:
                    gc<i> gcVar2 = zzbd;
                    gc<i> gcVar3 = gcVar2;
                    if (gcVar2 == null) {
                        synchronized (i.class) {
                            gc<i> gcVar4 = zzbd;
                            gcVar = gcVar4;
                            if (gcVar4 == null) {
                                ? bVar = new ej.b(zzpe);
                                zzbd = bVar;
                                gcVar = bVar;
                            }
                        }
                        gcVar3 = gcVar;
                    }
                    return gcVar3;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            i iVar = new i();
            zzpe = iVar;
            ej.a(i.class, iVar);
        }
    }

    public static final class g extends ej<g, b> implements fv {
        private static volatile gc<g> zzbd;
        /* access modifiers changed from: private */
        public static final g zzof;
        private int zzbf;
        private float zzka;
        private boolean zzke;
        private int zzob;
        private int zzoc;
        private int zzod;
        private boolean zzoe;

        public enum a implements en {
            CLASSIFICATION_UNKNOWN(0),
            CLASSIFICATION_NONE(1),
            CLASSIFICATION_ALL(2);
            
            private static final em<a> zzhc = null;
            private final int value;

            public final int zzag() {
                return this.value;
            }

            public static a zzv(int i2) {
                if (i2 == 0) {
                    return CLASSIFICATION_UNKNOWN;
                }
                if (i2 == 1) {
                    return CLASSIFICATION_NONE;
                }
                if (i2 != 2) {
                    return null;
                }
                return CLASSIFICATION_ALL;
            }

            public static ep zzah() {
                return bz.f11007a;
            }

            public final String toString() {
                return SimpleComparison.LESS_THAN_OPERATION + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + '>';
            }

            private a(int i2) {
                this.value = i2;
            }

            static {
                zzhc = new ca();
            }
        }

        public enum c implements en {
            LANDMARK_UNKNOWN(0),
            LANDMARK_NONE(1),
            LANDMARK_ALL(2),
            LANDMARK_CONTOUR(3);
            
            private static final em<c> zzhc = null;
            private final int value;

            public final int zzag() {
                return this.value;
            }

            public static c zzw(int i2) {
                if (i2 == 0) {
                    return LANDMARK_UNKNOWN;
                }
                if (i2 == 1) {
                    return LANDMARK_NONE;
                }
                if (i2 == 2) {
                    return LANDMARK_ALL;
                }
                if (i2 != 3) {
                    return null;
                }
                return LANDMARK_CONTOUR;
            }

            public static ep zzah() {
                return cc.f11008a;
            }

            public final String toString() {
                return SimpleComparison.LESS_THAN_OPERATION + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + '>';
            }

            private c(int i2) {
                this.value = i2;
            }

            static {
                zzhc = new cb();
            }
        }

        public enum d implements en {
            MODE_UNKNOWN(0),
            MODE_ACCURATE(1),
            MODE_FAST(2),
            MODE_SELFIE(3);
            
            private static final em<d> zzhc = null;
            private final int value;

            public final int zzag() {
                return this.value;
            }

            public static d zzx(int i2) {
                if (i2 == 0) {
                    return MODE_UNKNOWN;
                }
                if (i2 == 1) {
                    return MODE_ACCURATE;
                }
                if (i2 == 2) {
                    return MODE_FAST;
                }
                if (i2 != 3) {
                    return null;
                }
                return MODE_SELFIE;
            }

            public static ep zzah() {
                return cd.f11009a;
            }

            public final String toString() {
                return SimpleComparison.LESS_THAN_OPERATION + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + '>';
            }

            private d(int i2) {
                this.value = i2;
            }

            static {
                zzhc = new ce();
            }
        }

        private g() {
        }

        /* JADX WARNING: type inference failed for: r4v14, types: [com.google.android.gms.internal.vision.gc<com.google.android.gms.internal.vision.bt$g>, com.google.android.gms.internal.vision.ej$b] */
        /* access modifiers changed from: protected */
        public final Object a(int i2) {
            gc<g> gcVar;
            switch (br.f11004a[i2 - 1]) {
                case 1:
                    return new g();
                case 2:
                    return new b((byte) 0);
                case 3:
                    return a((ft) zzof, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဌ\u0001\u0003ဌ\u0002\u0004ဇ\u0003\u0005ဇ\u0004\u0006ခ\u0005", new Object[]{"zzbf", "zzob", d.zzah(), "zzoc", c.zzah(), "zzod", a.zzah(), "zzke", "zzoe", "zzka"});
                case 4:
                    return zzof;
                case 5:
                    gc<g> gcVar2 = zzbd;
                    gc<g> gcVar3 = gcVar2;
                    if (gcVar2 == null) {
                        synchronized (g.class) {
                            gc<g> gcVar4 = zzbd;
                            gcVar = gcVar4;
                            if (gcVar4 == null) {
                                ? bVar = new ej.b(zzof);
                                zzbd = bVar;
                                gcVar = bVar;
                            }
                        }
                        gcVar3 = gcVar;
                    }
                    return gcVar3;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static final class b extends ej.a<g, b> implements fv {
            private b() {
                super(g.zzof);
            }

            /* synthetic */ b(byte b2) {
                this();
            }
        }

        static {
            g gVar = new g();
            zzof = gVar;
            ej.a(g.class, gVar);
        }
    }

    public static final class h extends ej<h, a> implements fv {
        private static volatile gc<h> zzbd;
        /* access modifiers changed from: private */
        public static final h zzpa;
        private int zzbf;
        private float zzou;
        private float zzov;
        private float zzow;
        private float zzox;
        private float zzoy;
        private float zzoz;

        private h() {
        }

        /* JADX WARNING: type inference failed for: r4v14, types: [com.google.android.gms.internal.vision.ej$b, com.google.android.gms.internal.vision.gc<com.google.android.gms.internal.vision.bt$h>] */
        /* access modifiers changed from: protected */
        public final Object a(int i2) {
            gc<h> gcVar;
            switch (br.f11004a[i2 - 1]) {
                case 1:
                    return new h();
                case 2:
                    return new a((byte) 0);
                case 3:
                    return a((ft) zzpa, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ခ\u0000\u0002ခ\u0001\u0003ခ\u0002\u0004ခ\u0003\u0005ခ\u0004\u0006ခ\u0005", new Object[]{"zzbf", "zzou", "zzov", "zzow", "zzox", "zzoy", "zzoz"});
                case 4:
                    return zzpa;
                case 5:
                    gc<h> gcVar2 = zzbd;
                    gc<h> gcVar3 = gcVar2;
                    if (gcVar2 == null) {
                        synchronized (h.class) {
                            gc<h> gcVar4 = zzbd;
                            gcVar = gcVar4;
                            if (gcVar4 == null) {
                                ? bVar = new ej.b(zzpa);
                                zzbd = bVar;
                                gcVar = bVar;
                            }
                        }
                        gcVar3 = gcVar;
                    }
                    return gcVar3;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static final class a extends ej.a<h, a> implements fv {
            private a() {
                super(h.zzpa);
            }

            /* synthetic */ a(byte b2) {
                this();
            }
        }

        static {
            h hVar = new h();
            zzpa = hVar;
            ej.a(h.class, hVar);
        }
    }

    public static final class k extends ej<k, a> implements fv {
        private static volatile gc<k> zzbd;
        /* access modifiers changed from: private */
        public static final k zzpt;
        private int zzbf;
        private String zznf = "";
        private String zznn = "";
        private long zzpp;
        private a zzpq;
        private g zzpr;
        private b zzps;

        private k() {
        }

        /* JADX WARNING: type inference failed for: r4v14, types: [com.google.android.gms.internal.vision.ej$b, com.google.android.gms.internal.vision.gc<com.google.android.gms.internal.vision.bt$k>] */
        /* access modifiers changed from: protected */
        public final Object a(int i2) {
            gc<k> gcVar;
            switch (br.f11004a[i2 - 1]) {
                case 1:
                    return new k();
                case 2:
                    return new a((byte) 0);
                case 3:
                    return a((ft) zzpt, "\u0001\u0006\u0000\u0001\u0001\u0011\u0006\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဂ\u0001\u0003ဉ\u0002\u0006ဈ\u0003\u0010ဉ\u0004\u0011ဉ\u0005", new Object[]{"zzbf", "zznn", "zzpp", "zzpq", "zznf", "zzpr", "zzps"});
                case 4:
                    return zzpt;
                case 5:
                    gc<k> gcVar2 = zzbd;
                    gc<k> gcVar3 = gcVar2;
                    if (gcVar2 == null) {
                        synchronized (k.class) {
                            gc<k> gcVar4 = zzbd;
                            gcVar = gcVar4;
                            if (gcVar4 == null) {
                                ? bVar = new ej.b(zzpt);
                                zzbd = bVar;
                                gcVar = bVar;
                            }
                        }
                        gcVar3 = gcVar;
                    }
                    return gcVar3;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static final class a extends ej.a<k, a> implements fv {
            private a() {
                super(k.zzpt);
            }

            /* synthetic */ a(byte b2) {
                this();
            }
        }

        static {
            k kVar = new k();
            zzpt = kVar;
            ej.a(k.class, kVar);
        }
    }

    public static final class f extends ej<f, a> implements fv {
        private static volatile gc<f> zzbd;
        /* access modifiers changed from: private */
        public static final f zznv;
        private int zzbf;
        private String zznn = "";
        private String zzno = "";
        private eq<String> zznp = gh.d();
        private int zznq;
        private String zznr = "";
        private long zzns;
        private long zznt;
        private eq<n> zznu = gh.d();

        public enum b implements en {
            RESULT_UNKNOWN(0),
            RESULT_SUCCESS(1),
            RESULT_FAIL(2),
            RESULT_SKIPPED(3);
            
            private static final em<b> zzhc = null;
            private final int value;

            public final int zzag() {
                return this.value;
            }

            public static b zzu(int i2) {
                if (i2 == 0) {
                    return RESULT_UNKNOWN;
                }
                if (i2 == 1) {
                    return RESULT_SUCCESS;
                }
                if (i2 == 2) {
                    return RESULT_FAIL;
                }
                if (i2 != 3) {
                    return null;
                }
                return RESULT_SKIPPED;
            }

            public static ep zzah() {
                return by.f11006a;
            }

            public final String toString() {
                return SimpleComparison.LESS_THAN_OPERATION + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + '>';
            }

            private b(int i2) {
                this.value = i2;
            }

            static {
                zzhc = new bx();
            }
        }

        private f() {
        }

        /* JADX WARNING: type inference failed for: r4v14, types: [com.google.android.gms.internal.vision.gc<com.google.android.gms.internal.vision.bt$f>, com.google.android.gms.internal.vision.ej$b] */
        /* access modifiers changed from: protected */
        public final Object a(int i2) {
            gc<f> gcVar;
            switch (br.f11004a[i2 - 1]) {
                case 1:
                    return new f();
                case 2:
                    return new a((byte) 0);
                case 3:
                    return a((ft) zznv, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0002\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003\u001a\u0004ဌ\u0002\u0005ဈ\u0003\u0006ဂ\u0004\u0007ဂ\u0005\b\u001b", new Object[]{"zzbf", "zznn", "zzno", "zznp", "zznq", b.zzah(), "zznr", "zzns", "zznt", "zznu", n.class});
                case 4:
                    return zznv;
                case 5:
                    gc<f> gcVar2 = zzbd;
                    gc<f> gcVar3 = gcVar2;
                    if (gcVar2 == null) {
                        synchronized (f.class) {
                            gc<f> gcVar4 = zzbd;
                            gcVar = gcVar4;
                            if (gcVar4 == null) {
                                ? bVar = new ej.b(zznv);
                                zzbd = bVar;
                                gcVar = bVar;
                            }
                        }
                        gcVar3 = gcVar;
                    }
                    return gcVar3;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static final class a extends ej.a<f, a> implements fv {
            private a() {
                super(f.zznv);
            }

            /* synthetic */ a(byte b2) {
                this();
            }
        }

        static {
            f fVar = new f();
            zznv = fVar;
            ej.a(f.class, fVar);
        }
    }
}
