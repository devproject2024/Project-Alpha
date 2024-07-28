package com.google.android.gms.internal.firebase_ml;

import com.google.android.gms.internal.firebase_ml.gg;
import com.j256.ormlite.stmt.query.SimpleComparison;

public final class t {

    public static final class a extends gg<a, b> implements hp {
        /* access modifiers changed from: private */
        public static final a zzcvj;
        private static volatile hz<a> zzh;
        private int zzcvh;
        private i zzcvi;
        private int zzj;

        /* renamed from: com.google.android.gms.internal.firebase_ml.t$a$a  reason: collision with other inner class name */
        public enum C0151a implements gj {
            UNKNOWN_ENGINE(0),
            TFLITE(1);
            
            private static final gm<C0151a> zzac = null;
            private final int value;

            public final int zzd() {
                return this.value;
            }

            public static C0151a zzek(int i2) {
                if (i2 == 0) {
                    return UNKNOWN_ENGINE;
                }
                if (i2 != 1) {
                    return null;
                }
                return TFLITE;
            }

            public static gl zzf() {
                return v.f10028a;
            }

            public final String toString() {
                return SimpleComparison.LESS_THAN_OPERATION + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + '>';
            }

            private C0151a(int i2) {
                this.value = i2;
            }

            static {
                zzac = new w();
            }
        }

        private a() {
        }

        public static final class b extends gg.b<a, b> implements hp {
            private b() {
                super(a.zzcvj);
            }

            /* synthetic */ b(byte b2) {
                this();
            }
        }

        /* access modifiers changed from: protected */
        public final Object a(int i2, Object obj) {
            switch (u.f10027a[i2 - 1]) {
                case 1:
                    return new a();
                case 2:
                    return new b((byte) 0);
                case 3:
                    return a((hn) zzcvj, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဉ\u0001", new Object[]{"zzj", "zzcvh", C0151a.zzf(), "zzcvi"});
                case 4:
                    return zzcvj;
                case 5:
                    hz<a> hzVar = zzh;
                    if (hzVar == null) {
                        synchronized (a.class) {
                            hzVar = zzh;
                            if (hzVar == null) {
                                hzVar = new gg.a<>(zzcvj);
                                zzh = hzVar;
                            }
                        }
                    }
                    return hzVar;
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
            zzcvj = aVar;
            gg.a(a.class, aVar);
        }
    }

    public static final class b extends gg<b, a> implements hp {
        /* access modifiers changed from: private */
        public static final b zzcvw;
        private static volatile hz<b> zzh;
        private String zzcuk = "";
        private int zzcvn;
        private String zzcvo = "";
        private String zzcvp = "";
        private String zzcvq = "";
        private String zzcvr = "";
        private String zzcvs = "";
        private String zzcvt = "";
        private String zzcvu = "";
        private String zzcvv = "";
        private int zzj;

        private b() {
        }

        public static final class a extends gg.b<b, a> implements hp {
            private a() {
                super(b.zzcvw);
            }

            /* synthetic */ a(byte b2) {
                this();
            }
        }

        /* access modifiers changed from: protected */
        public final Object a(int i2, Object obj) {
            switch (u.f10027a[i2 - 1]) {
                case 1:
                    return new b();
                case 2:
                    return new a((byte) 0);
                case 3:
                    return a((hn) zzcvw, "\u0001\n\u0000\u0001\u0001\n\n\u0000\u0000\u0000\u0001င\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004\u0006ဈ\u0005\u0007ဈ\u0006\bဈ\u0007\tဈ\b\nဈ\t", new Object[]{"zzj", "zzcvn", "zzcvo", "zzcvp", "zzcvq", "zzcvr", "zzcvs", "zzcvt", "zzcvu", "zzcuk", "zzcvv"});
                case 4:
                    return zzcvw;
                case 5:
                    hz<b> hzVar = zzh;
                    if (hzVar == null) {
                        synchronized (b.class) {
                            hzVar = zzh;
                            if (hzVar == null) {
                                hzVar = new gg.a<>(zzcvw);
                                zzh = hzVar;
                            }
                        }
                    }
                    return hzVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            b bVar = new b();
            zzcvw = bVar;
            gg.a(b.class, bVar);
        }
    }

    public static final class c extends gg<c, C0152c> implements hp {
        /* access modifiers changed from: private */
        public static final c zzcwk;
        private static volatile hz<c> zzh;
        private int zzbfp;
        private String zzctp = "";
        private int zzcwd;
        private String zzcwe = "";
        private a zzcwf;
        private d zzcwg;
        private int zzcwh;
        private gq<f> zzcwi = ia.a();
        private int zzcwj;
        private int zzj;

        public enum a implements gj {
            UNKNOWN_ACTION(0),
            INITIALIZATION(1),
            COMPILATION(2),
            EXECUTION(3),
            TEARDOWN(4);
            
            private static final gm<a> zzac = null;
            private final int value;

            public final int zzd() {
                return this.value;
            }

            public static a zzel(int i2) {
                if (i2 == 0) {
                    return UNKNOWN_ACTION;
                }
                if (i2 == 1) {
                    return INITIALIZATION;
                }
                if (i2 == 2) {
                    return COMPILATION;
                }
                if (i2 == 3) {
                    return EXECUTION;
                }
                if (i2 != 4) {
                    return null;
                }
                return TEARDOWN;
            }

            public static gl zzf() {
                return x.f10029a;
            }

            public final String toString() {
                return SimpleComparison.LESS_THAN_OPERATION + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + '>';
            }

            private a(int i2) {
                this.value = i2;
            }

            static {
                zzac = new y();
            }
        }

        public static final class b extends gg<b, a> implements hp {
            /* access modifiers changed from: private */
            public static final b zzcwn;
            private static volatile hz<b> zzh;
            private int zzcwl;
            private int zzcwm;
            private int zzj;

            private b() {
            }

            public static final class a extends gg.b<b, a> implements hp {
                private a() {
                    super(b.zzcwn);
                }

                /* synthetic */ a(byte b2) {
                    this();
                }
            }

            /* access modifiers changed from: protected */
            public final Object a(int i2, Object obj) {
                switch (u.f10027a[i2 - 1]) {
                    case 1:
                        return new b();
                    case 2:
                        return new a((byte) 0);
                    case 3:
                        return a((hn) zzcwn, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001", new Object[]{"zzj", "zzcwl", "zzcwm"});
                    case 4:
                        return zzcwn;
                    case 5:
                        hz<b> hzVar = zzh;
                        if (hzVar == null) {
                            synchronized (b.class) {
                                hzVar = zzh;
                                if (hzVar == null) {
                                    hzVar = new gg.a<>(zzcwn);
                                    zzh = hzVar;
                                }
                            }
                        }
                        return hzVar;
                    case 6:
                        return (byte) 1;
                    case 7:
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            static {
                b bVar = new b();
                zzcwn = bVar;
                gg.a(b.class, bVar);
            }
        }

        public static final class d extends gg<d, a> implements hp {
            /* access modifiers changed from: private */
            public static final d zzcwr;
            private static volatile hz<d> zzh;
            private b zzcwo;
            private b zzcwp;
            private boolean zzcwq;
            private int zzj;

            private d() {
            }

            public static final class a extends gg.b<d, a> implements hp {
                private a() {
                    super(d.zzcwr);
                }

                /* synthetic */ a(byte b2) {
                    this();
                }
            }

            /* access modifiers changed from: protected */
            public final Object a(int i2, Object obj) {
                switch (u.f10027a[i2 - 1]) {
                    case 1:
                        return new d();
                    case 2:
                        return new a((byte) 0);
                    case 3:
                        return a((hn) zzcwr, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဇ\u0002", new Object[]{"zzj", "zzcwo", "zzcwp", "zzcwq"});
                    case 4:
                        return zzcwr;
                    case 5:
                        hz<d> hzVar = zzh;
                        if (hzVar == null) {
                            synchronized (d.class) {
                                hzVar = zzh;
                                if (hzVar == null) {
                                    hzVar = new gg.a<>(zzcwr);
                                    zzh = hzVar;
                                }
                            }
                        }
                        return hzVar;
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
                zzcwr = dVar;
                gg.a(d.class, dVar);
            }
        }

        public enum e implements gj {
            UNKNOWN_STATUS(0),
            COMPLETED_EVENT(1),
            MISSING_END_EVENT(2),
            HANG(3),
            ABANDONED_FROM_HANG(4),
            FORCED_CRASH_FROM_HANG(5);
            
            private static final gm<e> zzac = null;
            private final int value;

            public final int zzd() {
                return this.value;
            }

            public static e zzem(int i2) {
                if (i2 == 0) {
                    return UNKNOWN_STATUS;
                }
                if (i2 == 1) {
                    return COMPLETED_EVENT;
                }
                if (i2 == 2) {
                    return MISSING_END_EVENT;
                }
                if (i2 == 3) {
                    return HANG;
                }
                if (i2 == 4) {
                    return ABANDONED_FROM_HANG;
                }
                if (i2 != 5) {
                    return null;
                }
                return FORCED_CRASH_FROM_HANG;
            }

            public static gl zzf() {
                return z.f10030a;
            }

            public final String toString() {
                return SimpleComparison.LESS_THAN_OPERATION + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + '>';
            }

            private e(int i2) {
                this.value = i2;
            }

            static {
                zzac = new aa();
            }
        }

        private c() {
        }

        /* renamed from: com.google.android.gms.internal.firebase_ml.t$c$c  reason: collision with other inner class name */
        public static final class C0152c extends gg.b<c, C0152c> implements hp {
            private C0152c() {
                super(c.zzcwk);
            }

            /* synthetic */ C0152c(byte b2) {
                this();
            }
        }

        /* access modifiers changed from: protected */
        public final Object a(int i2, Object obj) {
            switch (u.f10027a[i2 - 1]) {
                case 1:
                    return new c();
                case 2:
                    return new C0152c((byte) 0);
                case 3:
                    return a((hn) zzcwk, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0001\u0000\u0001ဌ\u0000\u0002ဌ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဉ\u0004\u0006ဉ\u0005\u0007င\u0006\b\u001b\tင\u0007", new Object[]{"zzj", "zzcwd", a.zzf(), "zzbfp", e.zzf(), "zzctp", "zzcwe", "zzcwf", "zzcwg", "zzcwh", "zzcwi", f.class, "zzcwj"});
                case 4:
                    return zzcwk;
                case 5:
                    hz<c> hzVar = zzh;
                    if (hzVar == null) {
                        synchronized (c.class) {
                            hzVar = zzh;
                            if (hzVar == null) {
                                hzVar = new gg.a<>(zzcwk);
                                zzh = hzVar;
                            }
                        }
                    }
                    return hzVar;
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
            zzcwk = cVar;
            gg.a(c.class, cVar);
        }
    }

    public static final class d extends gg<d, a> implements hp {
        /* access modifiers changed from: private */
        public static final d zzcxd;
        private static volatile hz<d> zzh;
        private int zzctn;
        private int zzj;

        private d() {
        }

        public static final class a extends gg.b<d, a> implements hp {
            private a() {
                super(d.zzcxd);
            }

            /* synthetic */ a(byte b2) {
                this();
            }
        }

        /* access modifiers changed from: protected */
        public final Object a(int i2, Object obj) {
            switch (u.f10027a[i2 - 1]) {
                case 1:
                    return new d();
                case 2:
                    return new a((byte) 0);
                case 3:
                    return a((hn) zzcxd, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001င\u0000", new Object[]{"zzj", "zzctn"});
                case 4:
                    return zzcxd;
                case 5:
                    hz<d> hzVar = zzh;
                    if (hzVar == null) {
                        synchronized (d.class) {
                            hzVar = zzh;
                            if (hzVar == null) {
                                hzVar = new gg.a<>(zzcxd);
                                zzh = hzVar;
                            }
                        }
                    }
                    return hzVar;
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
            zzcxd = dVar;
            gg.a(d.class, dVar);
        }
    }

    public static final class e extends gg<e, a> implements hp {
        /* access modifiers changed from: private */
        public static final e zzcxm;
        private static volatile hz<e> zzh;
        private byte zzch = 2;
        private b zzcxe;
        private h zzcxf;
        private int zzcxg;
        private c zzcxh;
        private j zzcxi;
        private long zzcxj;
        private boolean zzcxk;
        private int zzcxl;
        private int zzj;
        private long zznz;

        private e() {
        }

        public static final class a extends gg.b<e, a> implements hp {
            private a() {
                super(e.zzcxm);
            }

            /* synthetic */ a(byte b2) {
                this();
            }
        }

        /* access modifiers changed from: protected */
        public final Object a(int i2, Object obj) {
            int i3 = 0;
            switch (u.f10027a[i2 - 1]) {
                case 1:
                    return new e();
                case 2:
                    return new a((byte) 0);
                case 3:
                    return a((hn) zzcxm, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0000\u0001\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဌ\u0002\u0004ဉ\u0003\u0005ᐉ\u0004\u0006ဂ\u0005\u0007ဂ\u0006\bဇ\u0007\tင\b", new Object[]{"zzj", "zzcxe", "zzcxf", "zzcxg", ac.zzf(), "zzcxh", "zzcxi", "zznz", "zzcxj", "zzcxk", "zzcxl"});
                case 4:
                    return zzcxm;
                case 5:
                    hz<e> hzVar = zzh;
                    if (hzVar == null) {
                        synchronized (e.class) {
                            hzVar = zzh;
                            if (hzVar == null) {
                                hzVar = new gg.a<>(zzcxm);
                                zzh = hzVar;
                            }
                        }
                    }
                    return hzVar;
                case 6:
                    return Byte.valueOf(this.zzch);
                case 7:
                    if (obj != null) {
                        i3 = 1;
                    }
                    this.zzch = (byte) i3;
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            e eVar = new e();
            zzcxm = eVar;
            gg.a(e.class, eVar);
        }
    }

    public static final class f extends gg<f, a> implements hp {
        /* access modifiers changed from: private */
        public static final f zzcxn;
        private static volatile hz<f> zzh;
        private gn zzaps = gi.a();

        private f() {
        }

        public static final class a extends gg.b<f, a> implements hp {
            private a() {
                super(f.zzcxn);
            }

            /* synthetic */ a(byte b2) {
                this();
            }
        }

        /* access modifiers changed from: protected */
        public final Object a(int i2, Object obj) {
            switch (u.f10027a[i2 - 1]) {
                case 1:
                    return new f();
                case 2:
                    return new a((byte) 0);
                case 3:
                    return a((hn) zzcxn, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u0016", new Object[]{"zzaps"});
                case 4:
                    return zzcxn;
                case 5:
                    hz<f> hzVar = zzh;
                    if (hzVar == null) {
                        synchronized (f.class) {
                            hzVar = zzh;
                            if (hzVar == null) {
                                hzVar = new gg.a<>(zzcxn);
                                zzh = hzVar;
                            }
                        }
                    }
                    return hzVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            f fVar = new f();
            zzcxn = fVar;
            gg.a(f.class, fVar);
        }
    }

    public static final class g extends gg<g, a> implements hp {
        /* access modifiers changed from: private */
        public static final g zzcxo;
        private static volatile hz<g> zzh;
        private String zzctv = "";
        private int zzctz;
        private int zzj;

        private g() {
        }

        public static final class a extends gg.b<g, a> implements hp {
            private a() {
                super(g.zzcxo);
            }

            /* synthetic */ a(byte b2) {
                this();
            }
        }

        /* access modifiers changed from: protected */
        public final Object a(int i2, Object obj) {
            switch (u.f10027a[i2 - 1]) {
                case 1:
                    return new g();
                case 2:
                    return new a((byte) 0);
                case 3:
                    return a((hn) zzcxo, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002င\u0001", new Object[]{"zzj", "zzctv", "zzctz"});
                case 4:
                    return zzcxo;
                case 5:
                    hz<g> hzVar = zzh;
                    if (hzVar == null) {
                        synchronized (g.class) {
                            hzVar = zzh;
                            if (hzVar == null) {
                                hzVar = new gg.a<>(zzcxo);
                                zzh = hzVar;
                            }
                        }
                    }
                    return hzVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            g gVar = new g();
            zzcxo = gVar;
            gg.a(g.class, gVar);
        }
    }

    public static final class h extends gg<h, b> implements hp {
        /* access modifiers changed from: private */
        public static final h zzcxq;
        private static volatile hz<h> zzh;
        private gq<a> zzcxp = ia.a();

        public static final class a extends gg<a, C0153a> implements hp {
            /* access modifiers changed from: private */
            public static final a zzcxs;
            private static volatile hz<a> zzh;
            private int zzapr;
            private String zzbak = "";
            private String zzbal = "";
            private long zzcxr;
            private int zzj;

            private a() {
            }

            /* renamed from: com.google.android.gms.internal.firebase_ml.t$h$a$a  reason: collision with other inner class name */
            public static final class C0153a extends gg.b<a, C0153a> implements hp {
                private C0153a() {
                    super(a.zzcxs);
                }

                /* synthetic */ C0153a(byte b2) {
                    this();
                }
            }

            /* access modifiers changed from: protected */
            public final Object a(int i2, Object obj) {
                switch (u.f10027a[i2 - 1]) {
                    case 1:
                        return new a();
                    case 2:
                        return new C0153a((byte) 0);
                    case 3:
                        return a((hn) zzcxs, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဈ\u0000\u0002င\u0001\u0003ဈ\u0002\u0004ဂ\u0003", new Object[]{"zzj", "zzbak", "zzapr", "zzbal", "zzcxr"});
                    case 4:
                        return zzcxs;
                    case 5:
                        hz<a> hzVar = zzh;
                        if (hzVar == null) {
                            synchronized (a.class) {
                                hzVar = zzh;
                                if (hzVar == null) {
                                    hzVar = new gg.a<>(zzcxs);
                                    zzh = hzVar;
                                }
                            }
                        }
                        return hzVar;
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
                zzcxs = aVar;
                gg.a(a.class, aVar);
            }
        }

        private h() {
        }

        public static final class b extends gg.b<h, b> implements hp {
            private b() {
                super(h.zzcxq);
            }

            /* synthetic */ b(byte b2) {
                this();
            }
        }

        /* access modifiers changed from: protected */
        public final Object a(int i2, Object obj) {
            switch (u.f10027a[i2 - 1]) {
                case 1:
                    return new h();
                case 2:
                    return new b((byte) 0);
                case 3:
                    return a((hn) zzcxq, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzcxp", a.class});
                case 4:
                    return zzcxq;
                case 5:
                    hz<h> hzVar = zzh;
                    if (hzVar == null) {
                        synchronized (h.class) {
                            hzVar = zzh;
                            if (hzVar == null) {
                                hzVar = new gg.a<>(zzcxq);
                                zzh = hzVar;
                            }
                        }
                    }
                    return hzVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            h hVar = new h();
            zzcxq = hVar;
            gg.a(h.class, hVar);
        }
    }

    public static final class i extends gg<i, b> implements hp {
        /* access modifiers changed from: private */
        public static final i zzcxv;
        private static volatile hz<i> zzh;
        private int zzcut;
        private g zzcxt;
        private d zzcxu;
        private int zzj;

        public enum a implements gj {
            DELEGATE_NONE(0),
            NNAPI(1),
            GPU(2),
            HEXAGON(3);
            
            private static final gm<a> zzac = null;
            private final int value;

            public final int zzd() {
                return this.value;
            }

            public static a zzeo(int i2) {
                if (i2 == 0) {
                    return DELEGATE_NONE;
                }
                if (i2 == 1) {
                    return NNAPI;
                }
                if (i2 == 2) {
                    return GPU;
                }
                if (i2 != 3) {
                    return null;
                }
                return HEXAGON;
            }

            public static gl zzf() {
                return ae.f9740a;
            }

            public final String toString() {
                return SimpleComparison.LESS_THAN_OPERATION + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + '>';
            }

            private a(int i2) {
                this.value = i2;
            }

            static {
                zzac = new af();
            }
        }

        private i() {
        }

        public static final class b extends gg.b<i, b> implements hp {
            private b() {
                super(i.zzcxv);
            }

            /* synthetic */ b(byte b2) {
                this();
            }
        }

        /* access modifiers changed from: protected */
        public final Object a(int i2, Object obj) {
            switch (u.f10027a[i2 - 1]) {
                case 1:
                    return new i();
                case 2:
                    return new b((byte) 0);
                case 3:
                    return a((hn) zzcxv, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzj", "zzcut", a.zzf(), "zzcxt", "zzcxu"});
                case 4:
                    return zzcxv;
                case 5:
                    hz<i> hzVar = zzh;
                    if (hzVar == null) {
                        synchronized (i.class) {
                            hzVar = zzh;
                            if (hzVar == null) {
                                hzVar = new gg.a<>(zzcxv);
                                zzh = hzVar;
                            }
                        }
                    }
                    return hzVar;
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
            zzcxv = iVar;
            gg.a(i.class, iVar);
        }
    }

    public static final class j extends gg.c<j, a> implements hp {
        /* access modifiers changed from: private */
        public static final j zzcyb;
        private static volatile hz<j> zzh;
        private byte zzch = 2;

        private j() {
        }

        public static final class a extends gg.d<j, a> implements hp {
            private a() {
                super(j.zzcyb);
            }

            /* synthetic */ a(byte b2) {
                this();
            }
        }

        /* access modifiers changed from: protected */
        public final Object a(int i2, Object obj) {
            int i3 = 1;
            switch (u.f10027a[i2 - 1]) {
                case 1:
                    return new j();
                case 2:
                    return new a((byte) 0);
                case 3:
                    return a((hn) zzcyb, "\u0001\u0000", (Object[]) null);
                case 4:
                    return zzcyb;
                case 5:
                    hz<j> hzVar = zzh;
                    if (hzVar == null) {
                        synchronized (j.class) {
                            hzVar = zzh;
                            if (hzVar == null) {
                                hzVar = new gg.a<>(zzcyb);
                                zzh = hzVar;
                            }
                        }
                    }
                    return hzVar;
                case 6:
                    return Byte.valueOf(this.zzch);
                case 7:
                    if (obj == null) {
                        i3 = 0;
                    }
                    this.zzch = (byte) i3;
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            j jVar = new j();
            zzcyb = jVar;
            gg.a(j.class, jVar);
        }
    }
}
