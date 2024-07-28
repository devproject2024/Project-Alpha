package com.google.android.gms.internal.firebase_ml;

import com.google.android.gms.internal.firebase_ml.gg;
import com.j256.ormlite.stmt.query.SimpleComparison;
import java.util.Iterator;

public final class ep {

    public static final class b extends gg<b, C0150b> implements hp {
        /* access modifiers changed from: private */
        public static final b zzbwq;
        private static volatile hz<b> zzh;
        private float zzawi;
        private int zzbwm;
        private int zzbwn;
        private boolean zzbwo;
        private boolean zzbwp;
        private int zzj;
        private int zzov;

        public enum a implements gj {
            CLASSIFICATION_UNKNOWN(0),
            CLASSIFICATION_NONE(1),
            CLASSIFICATION_ALL(2);
            
            private static final gm<a> zzac = null;
            private final int value;

            public final int zzd() {
                return this.value;
            }

            public static a zzce(int i2) {
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

            public static gl zzf() {
                return er.f9871a;
            }

            public final String toString() {
                return SimpleComparison.LESS_THAN_OPERATION + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + '>';
            }

            private a(int i2) {
                this.value = i2;
            }

            static {
                zzac = new es();
            }
        }

        public enum c implements gj {
            LANDMARK_UNKNOWN(0),
            LANDMARK_NONE(1),
            LANDMARK_ALL(2),
            LANDMARK_CONTOUR(3);
            
            private static final gm<c> zzac = null;
            private final int value;

            public final int zzd() {
                return this.value;
            }

            public static c zzcf(int i2) {
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

            public static gl zzf() {
                return eu.f9872a;
            }

            public final String toString() {
                return SimpleComparison.LESS_THAN_OPERATION + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + '>';
            }

            private c(int i2) {
                this.value = i2;
            }

            static {
                zzac = new et();
            }
        }

        public enum d implements gj {
            MODE_UNKNOWN(0),
            MODE_ACCURATE(1),
            MODE_FAST(2),
            MODE_SELFIE(3);
            
            private static final gm<d> zzac = null;
            private final int value;

            public final int zzd() {
                return this.value;
            }

            public static d zzcg(int i2) {
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

            public static gl zzf() {
                return ev.f9873a;
            }

            public final String toString() {
                return SimpleComparison.LESS_THAN_OPERATION + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + '>';
            }

            private d(int i2) {
                this.value = i2;
            }

            static {
                zzac = new ew();
            }
        }

        private b() {
        }

        /* renamed from: com.google.android.gms.internal.firebase_ml.ep$b$b  reason: collision with other inner class name */
        public static final class C0150b extends gg.b<b, C0150b> implements hp {
            private C0150b() {
                super(b.zzbwq);
            }

            /* synthetic */ C0150b(byte b2) {
                this();
            }
        }

        /* access modifiers changed from: protected */
        public final Object a(int i2, Object obj) {
            switch (eo.f9870a[i2 - 1]) {
                case 1:
                    return new b();
                case 2:
                    return new C0150b((byte) 0);
                case 3:
                    return a((hn) zzbwq, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဌ\u0001\u0003ဌ\u0002\u0004ဇ\u0003\u0005ဇ\u0004\u0006ခ\u0005", new Object[]{"zzj", "zzov", d.zzf(), "zzbwm", c.zzf(), "zzbwn", a.zzf(), "zzbwo", "zzbwp", "zzawi"});
                case 4:
                    return zzbwq;
                case 5:
                    hz<b> hzVar = zzh;
                    if (hzVar == null) {
                        synchronized (b.class) {
                            hzVar = zzh;
                            if (hzVar == null) {
                                hzVar = new gg.a<>(zzbwq);
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
            zzbwq = bVar;
            gg.a(b.class, bVar);
        }
    }

    public static final class a extends gg<a, C0149a> implements hp {
        private static final go<Integer, ex> zzbwk = new eq();
        /* access modifiers changed from: private */
        public static final a zzbwl;
        private static volatile hz<a> zzh;
        private gn zzbwj = gi.a();

        private a() {
        }

        /* renamed from: com.google.android.gms.internal.firebase_ml.ep$a$a  reason: collision with other inner class name */
        public static final class C0149a extends gg.b<a, C0149a> implements hp {
            private C0149a() {
                super(a.zzbwl);
            }

            public final C0149a a(Iterable<? extends ex> iterable) {
                if (this.f9920b) {
                    d();
                    this.f9920b = false;
                }
                a.a((a) this.f9919a, (Iterable) iterable);
                return this;
            }

            /* synthetic */ C0149a(byte b2) {
                this();
            }
        }

        public static C0149a a() {
            return (C0149a) zzbwl.g();
        }

        /* access modifiers changed from: protected */
        public final Object a(int i2, Object obj) {
            switch (eo.f9870a[i2 - 1]) {
                case 1:
                    return new a();
                case 2:
                    return new C0149a((byte) 0);
                case 3:
                    return a((hn) zzbwl, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001e", new Object[]{"zzbwj", ex.zzf()});
                case 4:
                    return zzbwl;
                case 5:
                    hz<a> hzVar = zzh;
                    if (hzVar == null) {
                        synchronized (a.class) {
                            hzVar = zzh;
                            if (hzVar == null) {
                                hzVar = new gg.a<>(zzbwl);
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
            zzbwl = aVar;
            gg.a(a.class, aVar);
        }

        static /* synthetic */ void a(a aVar, Iterable iterable) {
            if (!aVar.zzbwj.c()) {
                aVar.zzbwj = gg.a(aVar.zzbwj);
            }
            Iterator it2 = iterable.iterator();
            while (it2.hasNext()) {
                aVar.zzbwj.c(((ex) it2.next()).zzd());
            }
        }
    }
}
