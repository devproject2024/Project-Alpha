package com.google.android.gms.internal.measurement;

import com.alipay.mobile.nebula.util.tar.TarConstants;
import com.google.android.gms.internal.measurement.dv;
import com.j256.ormlite.stmt.query.SimpleComparison;
import java.util.Collections;
import java.util.List;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;
import net.one97.paytm.upi.util.UpiConstants;

public final class aj {

    public static final class c extends dv<c, a> implements fh {
        /* access modifiers changed from: private */
        public static final c zzi;
        private static volatile fo<c> zzj;
        public int zzc;
        public ed<e> zzd = fu.d();
        public String zze = "";
        public long zzf;
        public long zzg;
        public int zzh;

        private c() {
        }

        public static final class a extends dv.b<c, a> implements fh {
            private a() {
                super(c.zzi);
            }

            public final List<e> a() {
                return Collections.unmodifiableList(((c) this.f10593a).zzd);
            }

            public final int b() {
                return ((c) this.f10593a).a();
            }

            public final e a(int i2) {
                return (e) ((c) this.f10593a).zzd.get(i2);
            }

            public final a a(int i2, e eVar) {
                if (this.f10594b) {
                    t();
                    this.f10594b = false;
                }
                c.a((c) this.f10593a, i2, eVar);
                return this;
            }

            public final a a(int i2, e.a aVar) {
                if (this.f10594b) {
                    t();
                    this.f10594b = false;
                }
                c.a((c) this.f10593a, i2, (e) aVar.w());
                return this;
            }

            public final a a(e eVar) {
                if (this.f10594b) {
                    t();
                    this.f10594b = false;
                }
                c.a((c) this.f10593a, eVar);
                return this;
            }

            public final a a(e.a aVar) {
                if (this.f10594b) {
                    t();
                    this.f10594b = false;
                }
                c.a((c) this.f10593a, (e) aVar.w());
                return this;
            }

            public final a a(Iterable<? extends e> iterable) {
                if (this.f10594b) {
                    t();
                    this.f10594b = false;
                }
                c.a((c) this.f10593a, (Iterable) iterable);
                return this;
            }

            public final a c() {
                if (this.f10594b) {
                    t();
                    this.f10594b = false;
                }
                ((c) this.f10593a).zzd = fu.d();
                return this;
            }

            public final a b(int i2) {
                if (this.f10594b) {
                    t();
                    this.f10594b = false;
                }
                c.a((c) this.f10593a, i2);
                return this;
            }

            public final String d() {
                return ((c) this.f10593a).zze;
            }

            public final a a(String str) {
                if (this.f10594b) {
                    t();
                    this.f10594b = false;
                }
                c.a((c) this.f10593a, str);
                return this;
            }

            public final boolean e() {
                return ((c) this.f10593a).b();
            }

            public final long f() {
                return ((c) this.f10593a).zzf;
            }

            public final a a(long j) {
                if (this.f10594b) {
                    t();
                    this.f10594b = false;
                }
                c.a((c) this.f10593a, j);
                return this;
            }

            public final long g() {
                return ((c) this.f10593a).zzg;
            }

            public final a b(long j) {
                if (this.f10594b) {
                    t();
                    this.f10594b = false;
                }
                c.b((c) this.f10593a, j);
                return this;
            }

            /* synthetic */ a(byte b2) {
                this();
            }
        }

        public final int a() {
            return this.zzd.size();
        }

        private final void e() {
            if (!this.zzd.a()) {
                this.zzd = dv.a(this.zzd);
            }
        }

        public final boolean b() {
            return (this.zzc & 2) != 0;
        }

        public static a c() {
            return (a) zzi.k();
        }

        /* access modifiers changed from: protected */
        public final Object a(int i2) {
            switch (ak.f10443a[i2 - 1]) {
                case 1:
                    return new c();
                case 2:
                    return new a((byte) 0);
                case 3:
                    return a((ff) zzi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001\u001b\u0002\b\u0000\u0003\u0002\u0001\u0004\u0002\u0002\u0005\u0004\u0003", new Object[]{"zzc", "zzd", e.class, "zze", "zzf", "zzg", "zzh"});
                case 4:
                    return zzi;
                case 5:
                    fo<c> foVar = zzj;
                    if (foVar == null) {
                        synchronized (c.class) {
                            foVar = zzj;
                            if (foVar == null) {
                                foVar = new dv.a<>(zzi);
                                zzj = foVar;
                            }
                        }
                    }
                    return foVar;
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
            zzi = cVar;
            dv.a(c.class, cVar);
        }

        static /* synthetic */ void a(c cVar, int i2, e eVar) {
            eVar.getClass();
            cVar.e();
            cVar.zzd.set(i2, eVar);
        }

        static /* synthetic */ void a(c cVar, e eVar) {
            eVar.getClass();
            cVar.e();
            cVar.zzd.add(eVar);
        }

        static /* synthetic */ void a(c cVar, Iterable iterable) {
            cVar.e();
            ce.a(iterable, cVar.zzd);
        }

        static /* synthetic */ void a(c cVar, int i2) {
            cVar.e();
            cVar.zzd.remove(i2);
        }

        static /* synthetic */ void a(c cVar, String str) {
            str.getClass();
            cVar.zzc |= 1;
            cVar.zze = str;
        }

        static /* synthetic */ void a(c cVar, long j) {
            cVar.zzc |= 2;
            cVar.zzf = j;
        }

        static /* synthetic */ void b(c cVar, long j) {
            cVar.zzc |= 4;
            cVar.zzg = j;
        }
    }

    public static final class f extends dv<f, a> implements fh {
        /* access modifiers changed from: private */
        public static final f zzd;
        private static volatile fo<f> zze;
        public ed<g> zzc = fu.d();

        private f() {
        }

        public static final class a extends dv.b<f, a> implements fh {
            private a() {
                super(f.zzd);
            }

            public final g a() {
                return (g) ((f) this.f10593a).zzc.get(0);
            }

            public final a a(g.a aVar) {
                if (this.f10594b) {
                    t();
                    this.f10594b = false;
                }
                f.a((f) this.f10593a, (g) aVar.w());
                return this;
            }

            /* synthetic */ a(byte b2) {
                this();
            }
        }

        public static a a() {
            return (a) zzd.k();
        }

        /* access modifiers changed from: protected */
        public final Object a(int i2) {
            switch (ak.f10443a[i2 - 1]) {
                case 1:
                    return new f();
                case 2:
                    return new a((byte) 0);
                case 3:
                    return a((ff) zzd, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzc", g.class});
                case 4:
                    return zzd;
                case 5:
                    fo<f> foVar = zze;
                    if (foVar == null) {
                        synchronized (f.class) {
                            foVar = zze;
                            if (foVar == null) {
                                foVar = new dv.a<>(zzd);
                                zze = foVar;
                            }
                        }
                    }
                    return foVar;
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
            zzd = fVar;
            dv.a(f.class, fVar);
        }

        static /* synthetic */ void a(f fVar, g gVar) {
            gVar.getClass();
            if (!fVar.zzc.a()) {
                fVar.zzc = dv.a(fVar.zzc);
            }
            fVar.zzc.add(gVar);
        }
    }

    public static final class a extends dv<a, C0157a> implements fh {
        /* access modifiers changed from: private */
        public static final a zzh;
        private static volatile fo<a> zzi;
        public int zzc;
        public int zzd;
        private i zze;
        private i zzf;
        public boolean zzg;

        private a() {
        }

        /* renamed from: com.google.android.gms.internal.measurement.aj$a$a  reason: collision with other inner class name */
        public static final class C0157a extends dv.b<a, C0157a> implements fh {
            private C0157a() {
                super(a.zzh);
            }

            public final C0157a a(int i2) {
                if (this.f10594b) {
                    t();
                    this.f10594b = false;
                }
                a.a((a) this.f10593a, i2);
                return this;
            }

            public final C0157a a(i.a aVar) {
                if (this.f10594b) {
                    t();
                    this.f10594b = false;
                }
                a.a((a) this.f10593a, (i) aVar.w());
                return this;
            }

            public final boolean a() {
                return (((a) this.f10593a).zzc & 4) != 0;
            }

            public final i b() {
                return ((a) this.f10593a).b();
            }

            public final C0157a a(i iVar) {
                if (this.f10594b) {
                    t();
                    this.f10594b = false;
                }
                a.b((a) this.f10593a, iVar);
                return this;
            }

            public final C0157a a(boolean z) {
                if (this.f10594b) {
                    t();
                    this.f10594b = false;
                }
                a.a((a) this.f10593a, z);
                return this;
            }

            /* synthetic */ C0157a(byte b2) {
                this();
            }
        }

        public final i a() {
            i iVar = this.zze;
            return iVar == null ? i.e() : iVar;
        }

        public final i b() {
            i iVar = this.zzf;
            return iVar == null ? i.e() : iVar;
        }

        public static C0157a c() {
            return (C0157a) zzh.k();
        }

        /* access modifiers changed from: protected */
        public final Object a(int i2) {
            switch (ak.f10443a[i2 - 1]) {
                case 1:
                    return new a();
                case 2:
                    return new C0157a((byte) 0);
                case 3:
                    return a((ff) zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u0004\u0000\u0002\t\u0001\u0003\t\u0002\u0004\u0007\u0003", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg"});
                case 4:
                    return zzh;
                case 5:
                    fo<a> foVar = zzi;
                    if (foVar == null) {
                        synchronized (a.class) {
                            foVar = zzi;
                            if (foVar == null) {
                                foVar = new dv.a<>(zzh);
                                zzi = foVar;
                            }
                        }
                    }
                    return foVar;
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
            zzh = aVar;
            dv.a(a.class, aVar);
        }

        static /* synthetic */ void a(a aVar, int i2) {
            aVar.zzc |= 1;
            aVar.zzd = i2;
        }

        static /* synthetic */ void a(a aVar, i iVar) {
            iVar.getClass();
            aVar.zze = iVar;
            aVar.zzc |= 2;
        }

        static /* synthetic */ void b(a aVar, i iVar) {
            iVar.getClass();
            aVar.zzf = iVar;
            aVar.zzc |= 4;
        }

        static /* synthetic */ void a(a aVar, boolean z) {
            aVar.zzc |= 8;
            aVar.zzg = z;
        }
    }

    public static final class b extends dv<b, a> implements fh {
        /* access modifiers changed from: private */
        public static final b zzf;
        private static volatile fo<b> zzg;
        private int zzc;
        public int zzd;
        public long zze;

        private b() {
        }

        public static final class a extends dv.b<b, a> implements fh {
            private a() {
                super(b.zzf);
            }

            public final a a(int i2) {
                if (this.f10594b) {
                    t();
                    this.f10594b = false;
                }
                b.a((b) this.f10593a, i2);
                return this;
            }

            public final a a(long j) {
                if (this.f10594b) {
                    t();
                    this.f10594b = false;
                }
                b.a((b) this.f10593a, j);
                return this;
            }

            /* synthetic */ a(byte b2) {
                this();
            }
        }

        public final boolean a() {
            return (this.zzc & 1) != 0;
        }

        public final boolean b() {
            return (this.zzc & 2) != 0;
        }

        public static a c() {
            return (a) zzf.k();
        }

        /* access modifiers changed from: protected */
        public final Object a(int i2) {
            switch (ak.f10443a[i2 - 1]) {
                case 1:
                    return new b();
                case 2:
                    return new a((byte) 0);
                case 3:
                    return a((ff) zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0000\u0002\u0002\u0001", new Object[]{"zzc", "zzd", "zze"});
                case 4:
                    return zzf;
                case 5:
                    fo<b> foVar = zzg;
                    if (foVar == null) {
                        synchronized (b.class) {
                            foVar = zzg;
                            if (foVar == null) {
                                foVar = new dv.a<>(zzf);
                                zzg = foVar;
                            }
                        }
                    }
                    return foVar;
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
            zzf = bVar;
            dv.a(b.class, bVar);
        }

        static /* synthetic */ void a(b bVar, int i2) {
            bVar.zzc |= 1;
            bVar.zzd = i2;
        }

        static /* synthetic */ void a(b bVar, long j) {
            bVar.zzc |= 2;
            bVar.zze = j;
        }
    }

    public static final class d extends dv<d, a> implements fh {
        /* access modifiers changed from: private */
        public static final d zzf;
        private static volatile fo<d> zzg;
        private int zzc;
        private String zzd = "";
        private long zze;

        private d() {
        }

        public static final class a extends dv.b<d, a> implements fh {
            private a() {
                super(d.zzf);
            }

            public final a a(String str) {
                if (this.f10594b) {
                    t();
                    this.f10594b = false;
                }
                d.a((d) this.f10593a, str);
                return this;
            }

            public final a a(long j) {
                if (this.f10594b) {
                    t();
                    this.f10594b = false;
                }
                d.a((d) this.f10593a, j);
                return this;
            }

            /* synthetic */ a(byte b2) {
                this();
            }
        }

        public static a a() {
            return (a) zzf.k();
        }

        /* access modifiers changed from: protected */
        public final Object a(int i2) {
            switch (ak.f10443a[i2 - 1]) {
                case 1:
                    return new d();
                case 2:
                    return new a((byte) 0);
                case 3:
                    return a((ff) zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\b\u0000\u0002\u0002\u0001", new Object[]{"zzc", "zzd", "zze"});
                case 4:
                    return zzf;
                case 5:
                    fo<d> foVar = zzg;
                    if (foVar == null) {
                        synchronized (d.class) {
                            foVar = zzg;
                            if (foVar == null) {
                                foVar = new dv.a<>(zzf);
                                zzg = foVar;
                            }
                        }
                    }
                    return foVar;
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
            zzf = dVar;
            dv.a(d.class, dVar);
        }

        static /* synthetic */ void a(d dVar, String str) {
            str.getClass();
            dVar.zzc |= 1;
            dVar.zzd = str;
        }

        static /* synthetic */ void a(d dVar, long j) {
            dVar.zzc |= 2;
            dVar.zze = j;
        }
    }

    public static final class e extends dv<e, a> implements fh {
        /* access modifiers changed from: private */
        public static final e zzj;
        private static volatile fo<e> zzk;
        private int zzc;
        public String zzd = "";
        public String zze = "";
        public long zzf;
        private float zzg;
        public double zzh;
        private ed<e> zzi = fu.d();

        private e() {
        }

        public static final class a extends dv.b<e, a> implements fh {
            private a() {
                super(e.zzj);
            }

            public final a a(String str) {
                if (this.f10594b) {
                    t();
                    this.f10594b = false;
                }
                e.a((e) this.f10593a, str);
                return this;
            }

            public final a b(String str) {
                if (this.f10594b) {
                    t();
                    this.f10594b = false;
                }
                e.b((e) this.f10593a, str);
                return this;
            }

            public final a a() {
                if (this.f10594b) {
                    t();
                    this.f10594b = false;
                }
                e.a((e) this.f10593a);
                return this;
            }

            public final a a(long j) {
                if (this.f10594b) {
                    t();
                    this.f10594b = false;
                }
                e.a((e) this.f10593a, j);
                return this;
            }

            public final a b() {
                if (this.f10594b) {
                    t();
                    this.f10594b = false;
                }
                e.b((e) this.f10593a);
                return this;
            }

            public final a a(double d2) {
                if (this.f10594b) {
                    t();
                    this.f10594b = false;
                }
                e.a((e) this.f10593a, d2);
                return this;
            }

            public final a c() {
                if (this.f10594b) {
                    t();
                    this.f10594b = false;
                }
                e.c((e) this.f10593a);
                return this;
            }

            /* synthetic */ a(byte b2) {
                this();
            }
        }

        public final boolean a() {
            return (this.zzc & 2) != 0;
        }

        public final boolean b() {
            return (this.zzc & 4) != 0;
        }

        public final boolean c() {
            return (this.zzc & 16) != 0;
        }

        public static a d() {
            return (a) zzj.k();
        }

        /* access modifiers changed from: protected */
        public final Object a(int i2) {
            Class<e> cls = e.class;
            switch (ak.f10443a[i2 - 1]) {
                case 1:
                    return new e();
                case 2:
                    return new a((byte) 0);
                case 3:
                    return a((ff) zzj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001\b\u0000\u0002\b\u0001\u0003\u0002\u0002\u0004\u0001\u0003\u0005\u0000\u0004\u0006\u001b", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", cls});
                case 4:
                    return zzj;
                case 5:
                    fo<e> foVar = zzk;
                    if (foVar == null) {
                        synchronized (cls) {
                            foVar = zzk;
                            if (foVar == null) {
                                foVar = new dv.a<>(zzj);
                                zzk = foVar;
                            }
                        }
                    }
                    return foVar;
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
            zzj = eVar;
            dv.a(e.class, eVar);
        }

        static /* synthetic */ void a(e eVar, String str) {
            str.getClass();
            eVar.zzc |= 1;
            eVar.zzd = str;
        }

        static /* synthetic */ void b(e eVar, String str) {
            str.getClass();
            eVar.zzc |= 2;
            eVar.zze = str;
        }

        static /* synthetic */ void a(e eVar) {
            eVar.zzc &= -3;
            eVar.zze = zzj.zze;
        }

        static /* synthetic */ void a(e eVar, long j) {
            eVar.zzc |= 4;
            eVar.zzf = j;
        }

        static /* synthetic */ void b(e eVar) {
            eVar.zzc &= -5;
            eVar.zzf = 0;
        }

        static /* synthetic */ void a(e eVar, double d2) {
            eVar.zzc |= 16;
            eVar.zzh = d2;
        }

        static /* synthetic */ void c(e eVar) {
            eVar.zzc &= -17;
            eVar.zzh = 0.0d;
        }
    }

    public static final class g extends dv<g, a> implements fh {
        /* access modifiers changed from: private */
        public static final g zzav;
        private static volatile fo<g> zzaw;
        public int zzaa;
        public String zzab = "";
        public String zzac = "";
        public boolean zzad;
        public ed<a> zzae = fu.d();
        public String zzaf = "";
        public int zzag;
        private int zzah;
        private int zzai;
        public String zzaj = "";
        public long zzak;
        public long zzal;
        public String zzam = "";
        private String zzan = "";
        public int zzao;
        public String zzap = "";
        private h zzaq;
        private eb zzar = dy.d();
        public long zzas;
        private long zzat;
        String zzau = "";
        public int zzc;
        public int zzd;
        public int zze;
        public ed<c> zzf = fu.d();
        public ed<k> zzg = fu.d();
        public long zzh;
        public long zzi;
        public long zzj;
        public long zzk;
        public long zzl;
        public String zzm = "";
        public String zzn = "";
        public String zzo = "";
        public String zzp = "";
        public int zzq;
        public String zzr = "";
        public String zzs = "";
        public String zzt = "";
        public long zzu;
        public long zzv;
        public String zzw = "";
        public boolean zzx;
        public String zzy = "";
        public long zzz;

        private g() {
        }

        public static final class a extends dv.b<g, a> implements fh {
            private a() {
                super(g.zzav);
            }

            public final a a() {
                if (this.f10594b) {
                    t();
                    this.f10594b = false;
                }
                g.a((g) this.f10593a);
                return this;
            }

            public final List<c> b() {
                return Collections.unmodifiableList(((g) this.f10593a).zzf);
            }

            public final int c() {
                return ((g) this.f10593a).zzf.size();
            }

            public final c a(int i2) {
                return (c) ((g) this.f10593a).zzf.get(i2);
            }

            public final a a(int i2, c.a aVar) {
                if (this.f10594b) {
                    t();
                    this.f10594b = false;
                }
                g.a((g) this.f10593a, i2, (c) aVar.w());
                return this;
            }

            public final a a(c.a aVar) {
                if (this.f10594b) {
                    t();
                    this.f10594b = false;
                }
                g.a((g) this.f10593a, (c) aVar.w());
                return this;
            }

            public final a a(Iterable<? extends c> iterable) {
                if (this.f10594b) {
                    t();
                    this.f10594b = false;
                }
                g.a((g) this.f10593a, (Iterable) iterable);
                return this;
            }

            public final a d() {
                if (this.f10594b) {
                    t();
                    this.f10594b = false;
                }
                ((g) this.f10593a).zzf = fu.d();
                return this;
            }

            public final a b(int i2) {
                if (this.f10594b) {
                    t();
                    this.f10594b = false;
                }
                g.a((g) this.f10593a, i2);
                return this;
            }

            public final List<k> e() {
                return Collections.unmodifiableList(((g) this.f10593a).zzg);
            }

            public final int f() {
                return ((g) this.f10593a).zzg.size();
            }

            public final k c(int i2) {
                return (k) ((g) this.f10593a).zzg.get(i2);
            }

            public final a a(int i2, k kVar) {
                if (this.f10594b) {
                    t();
                    this.f10594b = false;
                }
                g.a((g) this.f10593a, i2, kVar);
                return this;
            }

            public final a a(k kVar) {
                if (this.f10594b) {
                    t();
                    this.f10594b = false;
                }
                g.a((g) this.f10593a, kVar);
                return this;
            }

            public final a a(k.a aVar) {
                if (this.f10594b) {
                    t();
                    this.f10594b = false;
                }
                g.a((g) this.f10593a, (k) aVar.w());
                return this;
            }

            public final a b(Iterable<? extends k> iterable) {
                if (this.f10594b) {
                    t();
                    this.f10594b = false;
                }
                g.b((g) this.f10593a, (Iterable) iterable);
                return this;
            }

            public final a d(int i2) {
                if (this.f10594b) {
                    t();
                    this.f10594b = false;
                }
                g.b((g) this.f10593a, i2);
                return this;
            }

            public final a a(long j) {
                if (this.f10594b) {
                    t();
                    this.f10594b = false;
                }
                g.a((g) this.f10593a, j);
                return this;
            }

            public final long g() {
                return ((g) this.f10593a).zzi;
            }

            public final a b(long j) {
                if (this.f10594b) {
                    t();
                    this.f10594b = false;
                }
                g.b((g) this.f10593a, j);
                return this;
            }

            public final long h() {
                return ((g) this.f10593a).zzj;
            }

            public final a c(long j) {
                if (this.f10594b) {
                    t();
                    this.f10594b = false;
                }
                g.c((g) this.f10593a, j);
                return this;
            }

            public final a d(long j) {
                if (this.f10594b) {
                    t();
                    this.f10594b = false;
                }
                g.d((g) this.f10593a, j);
                return this;
            }

            public final a i() {
                if (this.f10594b) {
                    t();
                    this.f10594b = false;
                }
                g.c((g) this.f10593a);
                return this;
            }

            public final a e(long j) {
                if (this.f10594b) {
                    t();
                    this.f10594b = false;
                }
                g.e((g) this.f10593a, j);
                return this;
            }

            public final a j() {
                if (this.f10594b) {
                    t();
                    this.f10594b = false;
                }
                g.d((g) this.f10593a);
                return this;
            }

            public final a a(String str) {
                if (this.f10594b) {
                    t();
                    this.f10594b = false;
                }
                g.a((g) this.f10593a, str);
                return this;
            }

            public final a b(String str) {
                if (this.f10594b) {
                    t();
                    this.f10594b = false;
                }
                g.b((g) this.f10593a, str);
                return this;
            }

            public final a c(String str) {
                if (this.f10594b) {
                    t();
                    this.f10594b = false;
                }
                g.c((g) this.f10593a, str);
                return this;
            }

            public final a d(String str) {
                if (this.f10594b) {
                    t();
                    this.f10594b = false;
                }
                g.d((g) this.f10593a, str);
                return this;
            }

            public final a e(int i2) {
                if (this.f10594b) {
                    t();
                    this.f10594b = false;
                }
                g.c((g) this.f10593a, i2);
                return this;
            }

            public final a e(String str) {
                if (this.f10594b) {
                    t();
                    this.f10594b = false;
                }
                g.e((g) this.f10593a, str);
                return this;
            }

            public final String k() {
                return ((g) this.f10593a).zzs;
            }

            public final a f(String str) {
                if (this.f10594b) {
                    t();
                    this.f10594b = false;
                }
                g.f((g) this.f10593a, str);
                return this;
            }

            public final a g(String str) {
                if (this.f10594b) {
                    t();
                    this.f10594b = false;
                }
                g.g((g) this.f10593a, str);
                return this;
            }

            public final a f(long j) {
                if (this.f10594b) {
                    t();
                    this.f10594b = false;
                }
                g.f((g) this.f10593a, j);
                return this;
            }

            public final a o_() {
                if (this.f10594b) {
                    t();
                    this.f10594b = false;
                }
                g.e((g) this.f10593a);
                return this;
            }

            public final a h(String str) {
                if (this.f10594b) {
                    t();
                    this.f10594b = false;
                }
                g.h((g) this.f10593a, str);
                return this;
            }

            public final a a(boolean z) {
                if (this.f10594b) {
                    t();
                    this.f10594b = false;
                }
                g.a((g) this.f10593a, z);
                return this;
            }

            public final a i(String str) {
                if (this.f10594b) {
                    t();
                    this.f10594b = false;
                }
                g.i((g) this.f10593a, str);
                return this;
            }

            public final a g(long j) {
                if (this.f10594b) {
                    t();
                    this.f10594b = false;
                }
                g.g((g) this.f10593a, j);
                return this;
            }

            public final a f(int i2) {
                if (this.f10594b) {
                    t();
                    this.f10594b = false;
                }
                g.d((g) this.f10593a, i2);
                return this;
            }

            public final a j(String str) {
                if (this.f10594b) {
                    t();
                    this.f10594b = false;
                }
                g.j((g) this.f10593a, str);
                return this;
            }

            public final a m() {
                if (this.f10594b) {
                    t();
                    this.f10594b = false;
                }
                g.f((g) this.f10593a);
                return this;
            }

            public final String n() {
                return ((g) this.f10593a).zzac;
            }

            public final a k(String str) {
                if (this.f10594b) {
                    t();
                    this.f10594b = false;
                }
                g.k((g) this.f10593a, str);
                return this;
            }

            public final a b(boolean z) {
                if (this.f10594b) {
                    t();
                    this.f10594b = false;
                }
                g.b((g) this.f10593a, z);
                return this;
            }

            public final a c(Iterable<? extends a> iterable) {
                if (this.f10594b) {
                    t();
                    this.f10594b = false;
                }
                g.c((g) this.f10593a, (Iterable) iterable);
                return this;
            }

            public final a o() {
                if (this.f10594b) {
                    t();
                    this.f10594b = false;
                }
                ((g) this.f10593a).zzae = fu.d();
                return this;
            }

            public final a l(String str) {
                if (this.f10594b) {
                    t();
                    this.f10594b = false;
                }
                g.l((g) this.f10593a, str);
                return this;
            }

            public final a g(int i2) {
                if (this.f10594b) {
                    t();
                    this.f10594b = false;
                }
                g.e((g) this.f10593a, i2);
                return this;
            }

            public final a m(String str) {
                if (this.f10594b) {
                    t();
                    this.f10594b = false;
                }
                g.m((g) this.f10593a, str);
                return this;
            }

            public final a h(long j) {
                if (this.f10594b) {
                    t();
                    this.f10594b = false;
                }
                g.h((g) this.f10593a, j);
                return this;
            }

            public final a i(long j) {
                if (this.f10594b) {
                    t();
                    this.f10594b = false;
                }
                g.i((g) this.f10593a, j);
                return this;
            }

            public final a p() {
                if (this.f10594b) {
                    t();
                    this.f10594b = false;
                }
                g.h((g) this.f10593a);
                return this;
            }

            public final a p_() {
                if (this.f10594b) {
                    t();
                    this.f10594b = false;
                }
                g.i((g) this.f10593a);
                return this;
            }

            public final a h(int i2) {
                if (this.f10594b) {
                    t();
                    this.f10594b = false;
                }
                g.f((g) this.f10593a, i2);
                return this;
            }

            public final a n(String str) {
                if (this.f10594b) {
                    t();
                    this.f10594b = false;
                }
                g.n((g) this.f10593a, str);
                return this;
            }

            public final a a(h.b bVar) {
                if (this.f10594b) {
                    t();
                    this.f10594b = false;
                }
                g.a((g) this.f10593a, (h) bVar.w());
                return this;
            }

            public final a d(Iterable<? extends Integer> iterable) {
                if (this.f10594b) {
                    t();
                    this.f10594b = false;
                }
                g.d((g) this.f10593a, (Iterable) iterable);
                return this;
            }

            public final a j(long j) {
                if (this.f10594b) {
                    t();
                    this.f10594b = false;
                }
                g.j((g) this.f10593a, j);
                return this;
            }

            public final a k(long j) {
                if (this.f10594b) {
                    t();
                    this.f10594b = false;
                }
                g.k((g) this.f10593a, j);
                return this;
            }

            public final String r() {
                return ((g) this.f10593a).zzau;
            }

            public final a o(String str) {
                if (this.f10594b) {
                    t();
                    this.f10594b = false;
                }
                g.o((g) this.f10593a, str);
                return this;
            }

            /* synthetic */ a(byte b2) {
                this();
            }
        }

        private final void e() {
            if (!this.zzf.a()) {
                this.zzf = dv.a(this.zzf);
            }
        }

        private final void f() {
            if (!this.zzg.a()) {
                this.zzg = dv.a(this.zzg);
            }
        }

        public final boolean a() {
            return (this.zzc & 8) != 0;
        }

        public final boolean b() {
            return (this.zzd & 2) != 0;
        }

        public static a c() {
            return (a) zzav.k();
        }

        /* access modifiers changed from: protected */
        public final Object a(int i2) {
            switch (ak.f10443a[i2 - 1]) {
                case 1:
                    return new g();
                case 2:
                    return new a((byte) 0);
                case 3:
                    return a((ff) zzav, "\u0001+\u0000\u0002\u00012+\u0000\u0004\u0000\u0001\u0004\u0000\u0002\u001b\u0003\u001b\u0004\u0002\u0001\u0005\u0002\u0002\u0006\u0002\u0003\u0007\u0002\u0005\b\b\u0006\t\b\u0007\n\b\b\u000b\b\t\f\u0004\n\r\b\u000b\u000e\b\f\u0010\b\r\u0011\u0002\u000e\u0012\u0002\u000f\u0013\b\u0010\u0014\u0007\u0011\u0015\b\u0012\u0016\u0002\u0013\u0017\u0004\u0014\u0018\b\u0015\u0019\b\u0016\u001a\u0002\u0004\u001c\u0007\u0017\u001d\u001b\u001e\b\u0018\u001f\u0004\u0019 \u0004\u001a!\u0004\u001b\"\b\u001c#\u0002\u001d$\u0002\u001e%\b\u001f&\b '\u0004!)\b\",\t#-\u001d.\u0002$/\u0002%2\b&", new Object[]{"zzc", "zzd", "zze", "zzf", c.class, "zzg", k.class, "zzh", "zzi", "zzj", "zzl", "zzm", "zzn", "zzo", "zzp", "zzq", "zzr", "zzs", "zzt", "zzu", "zzv", "zzw", "zzx", "zzy", "zzz", "zzaa", "zzab", "zzac", "zzk", "zzad", "zzae", a.class, "zzaf", "zzag", "zzah", "zzai", "zzaj", "zzak", "zzal", "zzam", "zzan", "zzao", "zzap", "zzaq", "zzar", "zzas", "zzat", "zzau"});
                case 4:
                    return zzav;
                case 5:
                    fo<g> foVar = zzaw;
                    if (foVar == null) {
                        synchronized (g.class) {
                            foVar = zzaw;
                            if (foVar == null) {
                                foVar = new dv.a<>(zzav);
                                zzaw = foVar;
                            }
                        }
                    }
                    return foVar;
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
            zzav = gVar;
            dv.a(g.class, gVar);
        }

        static /* synthetic */ void a(g gVar) {
            gVar.zzc |= 1;
            gVar.zze = 1;
        }

        static /* synthetic */ void a(g gVar, int i2, c cVar) {
            cVar.getClass();
            gVar.e();
            gVar.zzf.set(i2, cVar);
        }

        static /* synthetic */ void a(g gVar, c cVar) {
            cVar.getClass();
            gVar.e();
            gVar.zzf.add(cVar);
        }

        static /* synthetic */ void a(g gVar, Iterable iterable) {
            gVar.e();
            ce.a(iterable, gVar.zzf);
        }

        static /* synthetic */ void a(g gVar, int i2) {
            gVar.e();
            gVar.zzf.remove(i2);
        }

        static /* synthetic */ void a(g gVar, int i2, k kVar) {
            kVar.getClass();
            gVar.f();
            gVar.zzg.set(i2, kVar);
        }

        static /* synthetic */ void a(g gVar, k kVar) {
            kVar.getClass();
            gVar.f();
            gVar.zzg.add(kVar);
        }

        static /* synthetic */ void b(g gVar, Iterable iterable) {
            gVar.f();
            ce.a(iterable, gVar.zzg);
        }

        static /* synthetic */ void b(g gVar, int i2) {
            gVar.f();
            gVar.zzg.remove(i2);
        }

        static /* synthetic */ void a(g gVar, long j) {
            gVar.zzc |= 2;
            gVar.zzh = j;
        }

        static /* synthetic */ void b(g gVar, long j) {
            gVar.zzc |= 4;
            gVar.zzi = j;
        }

        static /* synthetic */ void c(g gVar, long j) {
            gVar.zzc |= 8;
            gVar.zzj = j;
        }

        static /* synthetic */ void d(g gVar, long j) {
            gVar.zzc |= 16;
            gVar.zzk = j;
        }

        static /* synthetic */ void c(g gVar) {
            gVar.zzc &= -17;
            gVar.zzk = 0;
        }

        static /* synthetic */ void e(g gVar, long j) {
            gVar.zzc |= 32;
            gVar.zzl = j;
        }

        static /* synthetic */ void d(g gVar) {
            gVar.zzc &= -33;
            gVar.zzl = 0;
        }

        static /* synthetic */ void a(g gVar, String str) {
            str.getClass();
            gVar.zzc |= 64;
            gVar.zzm = str;
        }

        static /* synthetic */ void b(g gVar, String str) {
            str.getClass();
            gVar.zzc |= 128;
            gVar.zzn = str;
        }

        static /* synthetic */ void c(g gVar, String str) {
            str.getClass();
            gVar.zzc |= UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS;
            gVar.zzo = str;
        }

        static /* synthetic */ void d(g gVar, String str) {
            str.getClass();
            gVar.zzc |= 512;
            gVar.zzp = str;
        }

        static /* synthetic */ void c(g gVar, int i2) {
            gVar.zzc |= TarConstants.EOF_BLOCK;
            gVar.zzq = i2;
        }

        static /* synthetic */ void e(g gVar, String str) {
            str.getClass();
            gVar.zzc |= EmiUtil.EMI_PLAN_REQUEST_CODE;
            gVar.zzr = str;
        }

        static /* synthetic */ void f(g gVar, String str) {
            str.getClass();
            gVar.zzc |= 4096;
            gVar.zzs = str;
        }

        static /* synthetic */ void g(g gVar, String str) {
            str.getClass();
            gVar.zzc |= FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE;
            gVar.zzt = str;
        }

        static /* synthetic */ void f(g gVar, long j) {
            gVar.zzc |= 16384;
            gVar.zzu = j;
        }

        static /* synthetic */ void e(g gVar) {
            gVar.zzc |= 32768;
            gVar.zzv = 19000;
        }

        static /* synthetic */ void h(g gVar, String str) {
            str.getClass();
            gVar.zzc |= 65536;
            gVar.zzw = str;
        }

        static /* synthetic */ void a(g gVar, boolean z) {
            gVar.zzc |= 131072;
            gVar.zzx = z;
        }

        static /* synthetic */ void i(g gVar, String str) {
            str.getClass();
            gVar.zzc |= 262144;
            gVar.zzy = str;
        }

        static /* synthetic */ void g(g gVar, long j) {
            gVar.zzc |= 524288;
            gVar.zzz = j;
        }

        static /* synthetic */ void d(g gVar, int i2) {
            gVar.zzc |= 1048576;
            gVar.zzaa = i2;
        }

        static /* synthetic */ void j(g gVar, String str) {
            str.getClass();
            gVar.zzc |= 2097152;
            gVar.zzab = str;
        }

        static /* synthetic */ void f(g gVar) {
            gVar.zzc &= -2097153;
            gVar.zzab = zzav.zzab;
        }

        static /* synthetic */ void k(g gVar, String str) {
            str.getClass();
            gVar.zzc |= 4194304;
            gVar.zzac = str;
        }

        static /* synthetic */ void b(g gVar, boolean z) {
            gVar.zzc |= 8388608;
            gVar.zzad = z;
        }

        static /* synthetic */ void c(g gVar, Iterable iterable) {
            if (!gVar.zzae.a()) {
                gVar.zzae = dv.a(gVar.zzae);
            }
            ce.a(iterable, gVar.zzae);
        }

        static /* synthetic */ void l(g gVar, String str) {
            str.getClass();
            gVar.zzc |= 16777216;
            gVar.zzaf = str;
        }

        static /* synthetic */ void e(g gVar, int i2) {
            gVar.zzc |= 33554432;
            gVar.zzag = i2;
        }

        static /* synthetic */ void m(g gVar, String str) {
            str.getClass();
            gVar.zzc |= 268435456;
            gVar.zzaj = str;
        }

        static /* synthetic */ void h(g gVar, long j) {
            gVar.zzc |= 536870912;
            gVar.zzak = j;
        }

        static /* synthetic */ void i(g gVar, long j) {
            gVar.zzc |= 1073741824;
            gVar.zzal = j;
        }

        static /* synthetic */ void h(g gVar) {
            String str = null;
            str.getClass();
            gVar.zzc |= Integer.MIN_VALUE;
            gVar.zzam = str;
        }

        static /* synthetic */ void i(g gVar) {
            gVar.zzc &= Integer.MAX_VALUE;
            gVar.zzam = zzav.zzam;
        }

        static /* synthetic */ void f(g gVar, int i2) {
            gVar.zzd |= 2;
            gVar.zzao = i2;
        }

        static /* synthetic */ void n(g gVar, String str) {
            str.getClass();
            gVar.zzd |= 4;
            gVar.zzap = str;
        }

        static /* synthetic */ void a(g gVar, h hVar) {
            hVar.getClass();
            gVar.zzaq = hVar;
            gVar.zzd |= 8;
        }

        static /* synthetic */ void d(g gVar, Iterable iterable) {
            if (!gVar.zzar.a()) {
                eb ebVar = gVar.zzar;
                int size = ebVar.size();
                gVar.zzar = ebVar.b(size == 0 ? 10 : size << 1);
            }
            ce.a(iterable, gVar.zzar);
        }

        static /* synthetic */ void j(g gVar, long j) {
            gVar.zzd |= 16;
            gVar.zzas = j;
        }

        static /* synthetic */ void k(g gVar, long j) {
            gVar.zzd |= 32;
            gVar.zzat = j;
        }

        static /* synthetic */ void o(g gVar, String str) {
            str.getClass();
            gVar.zzd |= 64;
            gVar.zzau = str;
        }
    }

    public static final class h extends dv<h, b> implements fh {
        /* access modifiers changed from: private */
        public static final h zzf;
        private static volatile fo<h> zzg;
        private int zzc;
        private int zzd = 1;
        private ed<d> zze = fu.d();

        public enum a implements ea {
            RADS(1),
            PROVISIONING(2);
            
            private static final dz<a> zzc = null;
            private final int zzd;

            public final int zza() {
                return this.zzd;
            }

            public static a zza(int i2) {
                if (i2 == 1) {
                    return RADS;
                }
                if (i2 != 2) {
                    return null;
                }
                return PROVISIONING;
            }

            public static ec zzb() {
                return al.f10444a;
            }

            public final String toString() {
                return SimpleComparison.LESS_THAN_OPERATION + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzd + " name=" + name() + '>';
            }

            private a(int i2) {
                this.zzd = i2;
            }

            static {
                zzc = new am();
            }
        }

        private h() {
        }

        public static final class b extends dv.b<h, b> implements fh {
            private b() {
                super(h.zzf);
            }

            public final b a(d.a aVar) {
                if (this.f10594b) {
                    t();
                    this.f10594b = false;
                }
                h.a((h) this.f10593a, (d) aVar.w());
                return this;
            }

            /* synthetic */ b(byte b2) {
                this();
            }
        }

        public static b a() {
            return (b) zzf.k();
        }

        /* access modifiers changed from: protected */
        public final Object a(int i2) {
            switch (ak.f10443a[i2 - 1]) {
                case 1:
                    return new h();
                case 2:
                    return new b((byte) 0);
                case 3:
                    return a((ff) zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\f\u0000\u0002\u001b", new Object[]{"zzc", "zzd", a.zzb(), "zze", d.class});
                case 4:
                    return zzf;
                case 5:
                    fo<h> foVar = zzg;
                    if (foVar == null) {
                        synchronized (h.class) {
                            foVar = zzg;
                            if (foVar == null) {
                                foVar = new dv.a<>(zzf);
                                zzg = foVar;
                            }
                        }
                    }
                    return foVar;
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
            zzf = hVar;
            dv.a(h.class, hVar);
        }

        static /* synthetic */ void a(h hVar, d dVar) {
            dVar.getClass();
            if (!hVar.zze.a()) {
                hVar.zze = dv.a(hVar.zze);
            }
            hVar.zze.add(dVar);
        }
    }

    public static final class i extends dv<i, a> implements fh {
        /* access modifiers changed from: private */
        public static final i zzg;
        private static volatile fo<i> zzh;
        public ee zzc = et.d();
        public ee zzd = et.d();
        public ed<b> zze = fu.d();
        public ed<j> zzf = fu.d();

        private i() {
        }

        public static final class a extends dv.b<i, a> implements fh {
            private a() {
                super(i.zzg);
            }

            public final a a(Iterable<? extends Long> iterable) {
                if (this.f10594b) {
                    t();
                    this.f10594b = false;
                }
                i.a((i) this.f10593a, (Iterable) iterable);
                return this;
            }

            public final a a() {
                if (this.f10594b) {
                    t();
                    this.f10594b = false;
                }
                ((i) this.f10593a).zzc = et.d();
                return this;
            }

            public final a b(Iterable<? extends Long> iterable) {
                if (this.f10594b) {
                    t();
                    this.f10594b = false;
                }
                i.b((i) this.f10593a, (Iterable) iterable);
                return this;
            }

            public final a b() {
                if (this.f10594b) {
                    t();
                    this.f10594b = false;
                }
                ((i) this.f10593a).zzd = et.d();
                return this;
            }

            public final a c(Iterable<? extends b> iterable) {
                if (this.f10594b) {
                    t();
                    this.f10594b = false;
                }
                i.c((i) this.f10593a, iterable);
                return this;
            }

            public final a a(int i2) {
                if (this.f10594b) {
                    t();
                    this.f10594b = false;
                }
                i.a((i) this.f10593a, i2);
                return this;
            }

            public final a d(Iterable<? extends j> iterable) {
                if (this.f10594b) {
                    t();
                    this.f10594b = false;
                }
                i.d((i) this.f10593a, iterable);
                return this;
            }

            public final a b(int i2) {
                if (this.f10594b) {
                    t();
                    this.f10594b = false;
                }
                i.b((i) this.f10593a, i2);
                return this;
            }

            /* synthetic */ a(byte b2) {
                this();
            }
        }

        public final int a() {
            return this.zzc.size();
        }

        public final int b() {
            return this.zze.size();
        }

        private final void g() {
            if (!this.zze.a()) {
                this.zze = dv.a(this.zze);
            }
        }

        public final int c() {
            return this.zzf.size();
        }

        private final void r() {
            if (!this.zzf.a()) {
                this.zzf = dv.a(this.zzf);
            }
        }

        public static a d() {
            return (a) zzg.k();
        }

        /* access modifiers changed from: protected */
        public final Object a(int i2) {
            switch (ak.f10443a[i2 - 1]) {
                case 1:
                    return new i();
                case 2:
                    return new a((byte) 0);
                case 3:
                    return a((ff) zzg, "\u0001\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0004\u0000\u0001\u0015\u0002\u0015\u0003\u001b\u0004\u001b", new Object[]{"zzc", "zzd", "zze", b.class, "zzf", j.class});
                case 4:
                    return zzg;
                case 5:
                    fo<i> foVar = zzh;
                    if (foVar == null) {
                        synchronized (i.class) {
                            foVar = zzh;
                            if (foVar == null) {
                                foVar = new dv.a<>(zzg);
                                zzh = foVar;
                            }
                        }
                    }
                    return foVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static i e() {
            return zzg;
        }

        static {
            i iVar = new i();
            zzg = iVar;
            dv.a(i.class, iVar);
        }

        static /* synthetic */ void a(i iVar, Iterable iterable) {
            if (!iVar.zzc.a()) {
                iVar.zzc = dv.a(iVar.zzc);
            }
            ce.a(iterable, iVar.zzc);
        }

        static /* synthetic */ void b(i iVar, Iterable iterable) {
            if (!iVar.zzd.a()) {
                iVar.zzd = dv.a(iVar.zzd);
            }
            ce.a(iterable, iVar.zzd);
        }

        static /* synthetic */ void c(i iVar, Iterable iterable) {
            iVar.g();
            ce.a(iterable, iVar.zze);
        }

        static /* synthetic */ void a(i iVar, int i2) {
            iVar.g();
            iVar.zze.remove(i2);
        }

        static /* synthetic */ void d(i iVar, Iterable iterable) {
            iVar.r();
            ce.a(iterable, iVar.zzf);
        }

        static /* synthetic */ void b(i iVar, int i2) {
            iVar.r();
            iVar.zzf.remove(i2);
        }
    }

    public static final class j extends dv<j, a> implements fh {
        /* access modifiers changed from: private */
        public static final j zzf;
        private static volatile fo<j> zzg;
        private int zzc;
        public int zzd;
        public ee zze = et.d();

        private j() {
        }

        public static final class a extends dv.b<j, a> implements fh {
            private a() {
                super(j.zzf);
            }

            public final a a(int i2) {
                if (this.f10594b) {
                    t();
                    this.f10594b = false;
                }
                j.a((j) this.f10593a, i2);
                return this;
            }

            public final a a(long j) {
                if (this.f10594b) {
                    t();
                    this.f10594b = false;
                }
                j.a((j) this.f10593a, j);
                return this;
            }

            public final a a(Iterable<? extends Long> iterable) {
                if (this.f10594b) {
                    t();
                    this.f10594b = false;
                }
                j.a((j) this.f10593a, (Iterable) iterable);
                return this;
            }

            public final a a() {
                if (this.f10594b) {
                    t();
                    this.f10594b = false;
                }
                ((j) this.f10593a).zze = et.d();
                return this;
            }

            /* synthetic */ a(byte b2) {
                this();
            }
        }

        public final boolean a() {
            return (this.zzc & 1) != 0;
        }

        public final int b() {
            return this.zze.size();
        }

        public final long b(int i2) {
            return this.zze.b(i2);
        }

        private final void e() {
            if (!this.zze.a()) {
                this.zze = dv.a(this.zze);
            }
        }

        public static a c() {
            return (a) zzf.k();
        }

        /* access modifiers changed from: protected */
        public final Object a(int i2) {
            switch (ak.f10443a[i2 - 1]) {
                case 1:
                    return new j();
                case 2:
                    return new a((byte) 0);
                case 3:
                    return a((ff) zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u0004\u0000\u0002\u0014", new Object[]{"zzc", "zzd", "zze"});
                case 4:
                    return zzf;
                case 5:
                    fo<j> foVar = zzg;
                    if (foVar == null) {
                        synchronized (j.class) {
                            foVar = zzg;
                            if (foVar == null) {
                                foVar = new dv.a<>(zzf);
                                zzg = foVar;
                            }
                        }
                    }
                    return foVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            j jVar = new j();
            zzf = jVar;
            dv.a(j.class, jVar);
        }

        static /* synthetic */ void a(j jVar, int i2) {
            jVar.zzc |= 1;
            jVar.zzd = i2;
        }

        static /* synthetic */ void a(j jVar, long j) {
            jVar.e();
            jVar.zze.a(j);
        }

        static /* synthetic */ void a(j jVar, Iterable iterable) {
            jVar.e();
            ce.a(iterable, jVar.zze);
        }
    }

    public static final class k extends dv<k, a> implements fh {
        /* access modifiers changed from: private */
        public static final k zzj;
        private static volatile fo<k> zzk;
        public int zzc;
        public long zzd;
        public String zze = "";
        public String zzf = "";
        public long zzg;
        private float zzh;
        public double zzi;

        private k() {
        }

        public static final class a extends dv.b<k, a> implements fh {
            private a() {
                super(k.zzj);
            }

            public final a a(long j) {
                if (this.f10594b) {
                    t();
                    this.f10594b = false;
                }
                k.a((k) this.f10593a, j);
                return this;
            }

            public final a a(String str) {
                if (this.f10594b) {
                    t();
                    this.f10594b = false;
                }
                k.a((k) this.f10593a, str);
                return this;
            }

            public final a b(String str) {
                if (this.f10594b) {
                    t();
                    this.f10594b = false;
                }
                k.b((k) this.f10593a, str);
                return this;
            }

            public final a a() {
                if (this.f10594b) {
                    t();
                    this.f10594b = false;
                }
                k.a((k) this.f10593a);
                return this;
            }

            public final a b(long j) {
                if (this.f10594b) {
                    t();
                    this.f10594b = false;
                }
                k.b((k) this.f10593a, j);
                return this;
            }

            public final a b() {
                if (this.f10594b) {
                    t();
                    this.f10594b = false;
                }
                k.b((k) this.f10593a);
                return this;
            }

            public final a a(double d2) {
                if (this.f10594b) {
                    t();
                    this.f10594b = false;
                }
                k.a((k) this.f10593a, d2);
                return this;
            }

            public final a c() {
                if (this.f10594b) {
                    t();
                    this.f10594b = false;
                }
                k.c((k) this.f10593a);
                return this;
            }

            /* synthetic */ a(byte b2) {
                this();
            }
        }

        public final boolean a() {
            return (this.zzc & 1) != 0;
        }

        public final boolean b() {
            return (this.zzc & 8) != 0;
        }

        public final boolean c() {
            return (this.zzc & 32) != 0;
        }

        public static a d() {
            return (a) zzj.k();
        }

        /* access modifiers changed from: protected */
        public final Object a(int i2) {
            switch (ak.f10443a[i2 - 1]) {
                case 1:
                    return new k();
                case 2:
                    return new a((byte) 0);
                case 3:
                    return a((ff) zzj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001\u0002\u0000\u0002\b\u0001\u0003\b\u0002\u0004\u0002\u0003\u0005\u0001\u0004\u0006\u0000\u0005", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi"});
                case 4:
                    return zzj;
                case 5:
                    fo<k> foVar = zzk;
                    if (foVar == null) {
                        synchronized (k.class) {
                            foVar = zzk;
                            if (foVar == null) {
                                foVar = new dv.a<>(zzj);
                                zzk = foVar;
                            }
                        }
                    }
                    return foVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            k kVar = new k();
            zzj = kVar;
            dv.a(k.class, kVar);
        }

        static /* synthetic */ void a(k kVar, long j) {
            kVar.zzc |= 1;
            kVar.zzd = j;
        }

        static /* synthetic */ void a(k kVar, String str) {
            str.getClass();
            kVar.zzc |= 2;
            kVar.zze = str;
        }

        static /* synthetic */ void b(k kVar, String str) {
            str.getClass();
            kVar.zzc |= 4;
            kVar.zzf = str;
        }

        static /* synthetic */ void a(k kVar) {
            kVar.zzc &= -5;
            kVar.zzf = zzj.zzf;
        }

        static /* synthetic */ void b(k kVar, long j) {
            kVar.zzc |= 8;
            kVar.zzg = j;
        }

        static /* synthetic */ void b(k kVar) {
            kVar.zzc &= -9;
            kVar.zzg = 0;
        }

        static /* synthetic */ void a(k kVar, double d2) {
            kVar.zzc |= 32;
            kVar.zzi = d2;
        }

        static /* synthetic */ void c(k kVar) {
            kVar.zzc &= -33;
            kVar.zzi = 0.0d;
        }
    }
}
