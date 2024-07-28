package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.dv;
import com.j256.ormlite.stmt.query.SimpleComparison;

public final class ab {

    public static final class a extends dv<a, C0155a> implements fh {
        /* access modifiers changed from: private */
        public static final a zzi;
        private static volatile fo<a> zzj;
        private int zzc;
        public int zzd;
        public ed<e> zze = fu.d();
        public ed<b> zzf = fu.d();
        private boolean zzg;
        private boolean zzh;

        private a() {
        }

        /* renamed from: com.google.android.gms.internal.measurement.ab$a$a  reason: collision with other inner class name */
        public static final class C0155a extends dv.b<a, C0155a> implements fh {
            private C0155a() {
                super(a.zzi);
            }

            public final int a() {
                return ((a) this.f10593a).zze.size();
            }

            public final e a(int i2) {
                return (e) ((a) this.f10593a).zze.get(i2);
            }

            public final C0155a a(int i2, e.a aVar) {
                if (this.f10594b) {
                    t();
                    this.f10594b = false;
                }
                a.a((a) this.f10593a, i2, (e) aVar.w());
                return this;
            }

            public final int b() {
                return ((a) this.f10593a).zzf.size();
            }

            public final b b(int i2) {
                return (b) ((a) this.f10593a).zzf.get(i2);
            }

            public final C0155a a(int i2, b.a aVar) {
                if (this.f10594b) {
                    t();
                    this.f10594b = false;
                }
                a.a((a) this.f10593a, i2, (b) aVar.w());
                return this;
            }

            /* synthetic */ C0155a(byte b2) {
                this();
            }
        }

        public final boolean a() {
            return (this.zzc & 1) != 0;
        }

        /* access modifiers changed from: protected */
        public final Object a(int i2) {
            switch (ac.f10439a[i2 - 1]) {
                case 1:
                    return new a();
                case 2:
                    return new C0155a((byte) 0);
                case 3:
                    return a((ff) zzi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0002\u0000\u0001\u0004\u0000\u0002\u001b\u0003\u001b\u0004\u0007\u0001\u0005\u0007\u0002", new Object[]{"zzc", "zzd", "zze", e.class, "zzf", b.class, "zzg", "zzh"});
                case 4:
                    return zzi;
                case 5:
                    fo<a> foVar = zzj;
                    if (foVar == null) {
                        synchronized (a.class) {
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
            a aVar = new a();
            zzi = aVar;
            dv.a(a.class, aVar);
        }

        static /* synthetic */ void a(a aVar, int i2, e eVar) {
            eVar.getClass();
            if (!aVar.zze.a()) {
                aVar.zze = dv.a(aVar.zze);
            }
            aVar.zze.set(i2, eVar);
        }

        static /* synthetic */ void a(a aVar, int i2, b bVar) {
            bVar.getClass();
            if (!aVar.zzf.a()) {
                aVar.zzf = dv.a(aVar.zzf);
            }
            aVar.zzf.set(i2, bVar);
        }
    }

    public static final class b extends dv<b, a> implements fh {
        /* access modifiers changed from: private */
        public static final b zzl;
        private static volatile fo<b> zzm;
        public int zzc;
        public int zzd;
        public String zze = "";
        public ed<c> zzf = fu.d();
        private boolean zzg;
        private d zzh;
        public boolean zzi;
        public boolean zzj;
        public boolean zzk;

        private b() {
        }

        public static final class a extends dv.b<b, a> implements fh {
            private a() {
                super(b.zzl);
            }

            public final String a() {
                return ((b) this.f10593a).zze;
            }

            public final a a(String str) {
                if (this.f10594b) {
                    t();
                    this.f10594b = false;
                }
                b.a((b) this.f10593a, str);
                return this;
            }

            public final int b() {
                return ((b) this.f10593a).zzf.size();
            }

            public final c a(int i2) {
                return (c) ((b) this.f10593a).zzf.get(i2);
            }

            public final a a(int i2, c cVar) {
                if (this.f10594b) {
                    t();
                    this.f10594b = false;
                }
                b.a((b) this.f10593a, i2, cVar);
                return this;
            }

            /* synthetic */ a(byte b2) {
                this();
            }
        }

        public final boolean a() {
            return (this.zzc & 1) != 0;
        }

        public final d b() {
            d dVar = this.zzh;
            return dVar == null ? d.d() : dVar;
        }

        public static a c() {
            return (a) zzl.k();
        }

        /* access modifiers changed from: protected */
        public final Object a(int i2) {
            switch (ac.f10439a[i2 - 1]) {
                case 1:
                    return new b();
                case 2:
                    return new a((byte) 0);
                case 3:
                    return a((ff) zzl, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0001\u0000\u0001\u0004\u0000\u0002\b\u0001\u0003\u001b\u0004\u0007\u0002\u0005\t\u0003\u0006\u0007\u0004\u0007\u0007\u0005\b\u0007\u0006", new Object[]{"zzc", "zzd", "zze", "zzf", c.class, "zzg", "zzh", "zzi", "zzj", "zzk"});
                case 4:
                    return zzl;
                case 5:
                    fo<b> foVar = zzm;
                    if (foVar == null) {
                        synchronized (b.class) {
                            foVar = zzm;
                            if (foVar == null) {
                                foVar = new dv.a<>(zzl);
                                zzm = foVar;
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
            zzl = bVar;
            dv.a(b.class, bVar);
        }

        static /* synthetic */ void a(b bVar, String str) {
            str.getClass();
            bVar.zzc |= 2;
            bVar.zze = str;
        }

        static /* synthetic */ void a(b bVar, int i2, c cVar) {
            cVar.getClass();
            if (!bVar.zzf.a()) {
                bVar.zzf = dv.a(bVar.zzf);
            }
            bVar.zzf.set(i2, cVar);
        }
    }

    public static final class d extends dv<d, b> implements fh {
        /* access modifiers changed from: private */
        public static final d zzi;
        private static volatile fo<d> zzj;
        public int zzc;
        private int zzd;
        public boolean zze;
        public String zzf = "";
        public String zzg = "";
        public String zzh = "";

        public enum a implements ea {
            UNKNOWN_COMPARISON_TYPE(0),
            LESS_THAN(1),
            GREATER_THAN(2),
            EQUAL(3),
            BETWEEN(4);
            
            private static final dz<a> zzf = null;
            private final int zzg;

            public final int zza() {
                return this.zzg;
            }

            public static a zza(int i2) {
                if (i2 == 0) {
                    return UNKNOWN_COMPARISON_TYPE;
                }
                if (i2 == 1) {
                    return LESS_THAN;
                }
                if (i2 == 2) {
                    return GREATER_THAN;
                }
                if (i2 == 3) {
                    return EQUAL;
                }
                if (i2 != 4) {
                    return null;
                }
                return BETWEEN;
            }

            public static ec zzb() {
                return ad.f10440a;
            }

            public final String toString() {
                return SimpleComparison.LESS_THAN_OPERATION + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzg + " name=" + name() + '>';
            }

            private a(int i2) {
                this.zzg = i2;
            }

            static {
                zzf = new ae();
            }
        }

        private d() {
        }

        public static final class b extends dv.b<d, b> implements fh {
            private b() {
                super(d.zzi);
            }

            /* synthetic */ b(byte b2) {
                this();
            }
        }

        public final boolean a() {
            return (this.zzc & 1) != 0;
        }

        public final a b() {
            a zza = a.zza(this.zzd);
            return zza == null ? a.UNKNOWN_COMPARISON_TYPE : zza;
        }

        public final boolean c() {
            return (this.zzc & 2) != 0;
        }

        /* access modifiers changed from: protected */
        public final Object a(int i2) {
            switch (ac.f10439a[i2 - 1]) {
                case 1:
                    return new d();
                case 2:
                    return new b((byte) 0);
                case 3:
                    return a((ff) zzi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001\f\u0000\u0002\u0007\u0001\u0003\b\u0002\u0004\b\u0003\u0005\b\u0004", new Object[]{"zzc", "zzd", a.zzb(), "zze", "zzf", "zzg", "zzh"});
                case 4:
                    return zzi;
                case 5:
                    fo<d> foVar = zzj;
                    if (foVar == null) {
                        synchronized (d.class) {
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

        public static d d() {
            return zzi;
        }

        static {
            d dVar = new d();
            zzi = dVar;
            dv.a(d.class, dVar);
        }
    }

    public static final class f extends dv<f, a> implements fh {
        /* access modifiers changed from: private */
        public static final f zzh;
        private static volatile fo<f> zzi;
        public int zzc;
        private int zzd;
        public String zze = "";
        public boolean zzf;
        public ed<String> zzg = fu.d();

        public enum b implements ea {
            UNKNOWN_MATCH_TYPE(0),
            REGEXP(1),
            BEGINS_WITH(2),
            ENDS_WITH(3),
            PARTIAL(4),
            EXACT(5),
            IN_LIST(6);
            
            private static final dz<b> zzh = null;
            private final int zzi;

            public final int zza() {
                return this.zzi;
            }

            public static b zza(int i2) {
                switch (i2) {
                    case 0:
                        return UNKNOWN_MATCH_TYPE;
                    case 1:
                        return REGEXP;
                    case 2:
                        return BEGINS_WITH;
                    case 3:
                        return ENDS_WITH;
                    case 4:
                        return PARTIAL;
                    case 5:
                        return EXACT;
                    case 6:
                        return IN_LIST;
                    default:
                        return null;
                }
            }

            public static ec zzb() {
                return ah.f10441a;
            }

            public final String toString() {
                return SimpleComparison.LESS_THAN_OPERATION + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzi + " name=" + name() + '>';
            }

            private b(int i2) {
                this.zzi = i2;
            }

            static {
                zzh = new af();
            }
        }

        private f() {
        }

        public static final class a extends dv.b<f, a> implements fh {
            private a() {
                super(f.zzh);
            }

            /* synthetic */ a(byte b2) {
                this();
            }
        }

        public final boolean a() {
            return (this.zzc & 1) != 0;
        }

        public final b b() {
            b zza = b.zza(this.zzd);
            return zza == null ? b.UNKNOWN_MATCH_TYPE : zza;
        }

        public final boolean c() {
            return (this.zzc & 2) != 0;
        }

        public final int d() {
            return this.zzg.size();
        }

        /* access modifiers changed from: protected */
        public final Object a(int i2) {
            switch (ac.f10439a[i2 - 1]) {
                case 1:
                    return new f();
                case 2:
                    return new a((byte) 0);
                case 3:
                    return a((ff) zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001\f\u0000\u0002\b\u0001\u0003\u0007\u0002\u0004\u001a", new Object[]{"zzc", "zzd", b.zzb(), "zze", "zzf", "zzg"});
                case 4:
                    return zzh;
                case 5:
                    fo<f> foVar = zzi;
                    if (foVar == null) {
                        synchronized (f.class) {
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

        public static f e() {
            return zzh;
        }

        static {
            f fVar = new f();
            zzh = fVar;
            dv.a(f.class, fVar);
        }
    }

    public static final class c extends dv<c, a> implements fh {
        /* access modifiers changed from: private */
        public static final c zzh;
        private static volatile fo<c> zzi;
        private int zzc;
        private f zzd;
        private d zze;
        public boolean zzf;
        public String zzg = "";

        private c() {
        }

        public static final class a extends dv.b<c, a> implements fh {
            private a() {
                super(c.zzh);
            }

            public final a a(String str) {
                if (this.f10594b) {
                    t();
                    this.f10594b = false;
                }
                c.a((c) this.f10593a, str);
                return this;
            }

            /* synthetic */ a(byte b2) {
                this();
            }
        }

        public final boolean a() {
            return (this.zzc & 1) != 0;
        }

        public final f b() {
            f fVar = this.zzd;
            return fVar == null ? f.e() : fVar;
        }

        public final boolean c() {
            return (this.zzc & 2) != 0;
        }

        public final d d() {
            d dVar = this.zze;
            return dVar == null ? d.d() : dVar;
        }

        public final boolean e() {
            return (this.zzc & 4) != 0;
        }

        /* access modifiers changed from: protected */
        public final Object a(int i2) {
            switch (ac.f10439a[i2 - 1]) {
                case 1:
                    return new c();
                case 2:
                    return new a((byte) 0);
                case 3:
                    return a((ff) zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\t\u0000\u0002\t\u0001\u0003\u0007\u0002\u0004\b\u0003", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg"});
                case 4:
                    return zzh;
                case 5:
                    fo<c> foVar = zzi;
                    if (foVar == null) {
                        synchronized (c.class) {
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

        public static c f() {
            return zzh;
        }

        static {
            c cVar = new c();
            zzh = cVar;
            dv.a(c.class, cVar);
        }

        static /* synthetic */ void a(c cVar, String str) {
            str.getClass();
            cVar.zzc |= 8;
            cVar.zzg = str;
        }
    }

    public static final class e extends dv<e, a> implements fh {
        /* access modifiers changed from: private */
        public static final e zzj;
        private static volatile fo<e> zzk;
        public int zzc;
        public int zzd;
        public String zze = "";
        private c zzf;
        public boolean zzg;
        public boolean zzh;
        public boolean zzi;

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

            /* synthetic */ a(byte b2) {
                this();
            }
        }

        public final boolean a() {
            return (this.zzc & 1) != 0;
        }

        public final c b() {
            c cVar = this.zzf;
            return cVar == null ? c.f() : cVar;
        }

        public static a c() {
            return (a) zzj.k();
        }

        /* access modifiers changed from: protected */
        public final Object a(int i2) {
            switch (ac.f10439a[i2 - 1]) {
                case 1:
                    return new e();
                case 2:
                    return new a((byte) 0);
                case 3:
                    return a((ff) zzj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001\u0004\u0000\u0002\b\u0001\u0003\t\u0002\u0004\u0007\u0003\u0005\u0007\u0004\u0006\u0007\u0005", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi"});
                case 4:
                    return zzj;
                case 5:
                    fo<e> foVar = zzk;
                    if (foVar == null) {
                        synchronized (e.class) {
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
            eVar.zzc |= 2;
            eVar.zze = str;
        }
    }
}
