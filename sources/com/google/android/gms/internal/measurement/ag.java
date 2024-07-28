package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.ab;
import com.google.android.gms.internal.measurement.dv;
import java.util.Collections;
import java.util.List;

public final class ag {

    public static final class a extends dv<a, C0156a> implements fh {
        /* access modifiers changed from: private */
        public static final a zzh;
        private static volatile fo<a> zzi;
        int zzc;
        String zzd = "";
        boolean zze;
        boolean zzf;
        int zzg;

        private a() {
        }

        /* renamed from: com.google.android.gms.internal.measurement.ag$a$a  reason: collision with other inner class name */
        public static final class C0156a extends dv.b<a, C0156a> implements fh {
            private C0156a() {
                super(a.zzh);
            }

            public final String a() {
                return ((a) this.f10593a).zzd;
            }

            public final C0156a a(String str) {
                if (this.f10594b) {
                    t();
                    this.f10594b = false;
                }
                a.a((a) this.f10593a, str);
                return this;
            }

            public final boolean b() {
                return ((a) this.f10593a).zze;
            }

            public final boolean c() {
                return ((a) this.f10593a).zzf;
            }

            public final boolean d() {
                return (((a) this.f10593a).zzc & 8) != 0;
            }

            public final int e() {
                return ((a) this.f10593a).zzg;
            }

            /* synthetic */ C0156a(byte b2) {
                this();
            }
        }

        /* access modifiers changed from: protected */
        public final Object a(int i2) {
            switch (ai.f10442a[i2 - 1]) {
                case 1:
                    return new a();
                case 2:
                    return new C0156a((byte) 0);
                case 3:
                    return a((ff) zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\b\u0000\u0002\u0007\u0001\u0003\u0007\u0002\u0004\u0004\u0003", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg"});
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

        static /* synthetic */ void a(a aVar, String str) {
            str.getClass();
            aVar.zzc |= 1;
            aVar.zzd = str;
        }
    }

    public static final class b extends dv<b, a> implements fh {
        /* access modifiers changed from: private */
        public static final b zzl;
        private static volatile fo<b> zzm;
        public int zzc;
        public long zzd;
        public String zze = "";
        private int zzf;
        public ed<c> zzg = fu.d();
        ed<a> zzh = fu.d();
        /* access modifiers changed from: package-private */
        public ed<ab.a> zzi = fu.d();
        private String zzj = "";
        public boolean zzk;

        private b() {
        }

        public static final class a extends dv.b<b, a> implements fh {
            private a() {
                super(b.zzl);
            }

            public final int a() {
                return ((b) this.f10593a).zzh.size();
            }

            public final a a(int i2) {
                return (a) ((b) this.f10593a).zzh.get(i2);
            }

            public final a a(int i2, a.C0156a aVar) {
                if (this.f10594b) {
                    t();
                    this.f10594b = false;
                }
                b.a((b) this.f10593a, i2, (a) aVar.w());
                return this;
            }

            public final List<ab.a> b() {
                return Collections.unmodifiableList(((b) this.f10593a).zzi);
            }

            public final a c() {
                if (this.f10594b) {
                    t();
                    this.f10594b = false;
                }
                ((b) this.f10593a).zzi = fu.d();
                return this;
            }

            /* synthetic */ a(byte b2) {
                this();
            }
        }

        public final boolean a() {
            return (this.zzc & 1) != 0;
        }

        public static a b() {
            return (a) zzl.k();
        }

        /* access modifiers changed from: protected */
        public final Object a(int i2) {
            switch (ai.f10442a[i2 - 1]) {
                case 1:
                    return new b();
                case 2:
                    return new a((byte) 0);
                case 3:
                    return a((ff) zzl, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0003\u0000\u0001\u0002\u0000\u0002\b\u0001\u0003\u0004\u0002\u0004\u001b\u0005\u001b\u0006\u001b\u0007\b\u0003\b\u0007\u0004", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", c.class, "zzh", a.class, "zzi", ab.a.class, "zzj", "zzk"});
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

        public static b c() {
            return zzl;
        }

        static {
            b bVar = new b();
            zzl = bVar;
            dv.a(b.class, bVar);
        }

        static /* synthetic */ void a(b bVar, int i2, a aVar) {
            aVar.getClass();
            if (!bVar.zzh.a()) {
                bVar.zzh = dv.a(bVar.zzh);
            }
            bVar.zzh.set(i2, aVar);
        }
    }

    public static final class c extends dv<c, a> implements fh {
        /* access modifiers changed from: private */
        public static final c zzf;
        private static volatile fo<c> zzg;
        private int zzc;
        public String zzd = "";
        public String zze = "";

        private c() {
        }

        public static final class a extends dv.b<c, a> implements fh {
            private a() {
                super(c.zzf);
            }

            /* synthetic */ a(byte b2) {
                this();
            }
        }

        /* access modifiers changed from: protected */
        public final Object a(int i2) {
            switch (ai.f10442a[i2 - 1]) {
                case 1:
                    return new c();
                case 2:
                    return new a((byte) 0);
                case 3:
                    return a((ff) zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001", new Object[]{"zzc", "zzd", "zze"});
                case 4:
                    return zzf;
                case 5:
                    fo<c> foVar = zzg;
                    if (foVar == null) {
                        synchronized (c.class) {
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
            c cVar = new c();
            zzf = cVar;
            dv.a(c.class, cVar);
        }
    }
}
