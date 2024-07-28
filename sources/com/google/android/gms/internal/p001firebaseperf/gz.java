package com.google.android.gms.internal.p001firebaseperf;

import com.google.android.gms.internal.p001firebaseperf.dq;

/* renamed from: com.google.android.gms.internal.firebase-perf.gz  reason: invalid package */
public final class gz {

    /* renamed from: com.google.android.gms.internal.firebase-perf.gz$a */
    public static final class a extends dq<a, b> implements ez {
        private static volatile fi<a> zzin;
        /* access modifiers changed from: private */
        public static final a zzxh = new a();
        private int zzii;
        private int zzxf = -1;
        private int zzxg;

        /* renamed from: com.google.android.gms.internal.firebase-perf.gz$a$a  reason: collision with other inner class name */
        public enum C0142a implements ds {
            UNKNOWN_MOBILE_SUBTYPE(0),
            GPRS(1),
            EDGE(2),
            UMTS(3),
            CDMA(4),
            EVDO_0(5),
            EVDO_A(6),
            RTT(7),
            HSDPA(8),
            HSUPA(9),
            HSPA(10),
            IDEN(11),
            EVDO_B(12),
            LTE(13),
            EHRPD(14),
            HSPAP(15),
            GSM(16),
            TD_SCDMA(17),
            IWLAN(18),
            LTE_CA(19),
            COMBINED(100);
            
            private static final dv<C0142a> zzjf = null;
            private final int value;

            public final int zzdp() {
                return this.value;
            }

            public static du zzdq() {
                return hc.f9688a;
            }

            private C0142a(int i2) {
                this.value = i2;
            }

            static {
                zzjf = new hd();
            }
        }

        /* renamed from: com.google.android.gms.internal.firebase-perf.gz$a$c */
        public enum c implements ds {
            NONE(-1),
            MOBILE(0),
            WIFI(1),
            MOBILE_MMS(2),
            MOBILE_SUPL(3),
            MOBILE_DUN(4),
            MOBILE_HIPRI(5),
            WIMAX(6),
            BLUETOOTH(7),
            DUMMY(8),
            ETHERNET(9),
            MOBILE_FOTA(10),
            MOBILE_IMS(11),
            MOBILE_CBS(12),
            WIFI_P2P(13),
            MOBILE_IA(14),
            MOBILE_EMERGENCY(15),
            PROXY(16),
            VPN(17);
            
            private static final dv<c> zzjf = null;
            private final int value;

            public final int zzdp() {
                return this.value;
            }

            public static du zzdq() {
                return hf.f9689a;
            }

            private c(int i2) {
                this.value = i2;
            }

            static {
                zzjf = new he();
            }
        }

        private a() {
        }

        /* renamed from: com.google.android.gms.internal.firebase-perf.gz$a$b */
        public static final class b extends dq.a<a, b> implements ez {
            private b() {
                super(a.zzxh);
            }

            /* synthetic */ b(byte b2) {
                this();
            }
        }

        /* access modifiers changed from: protected */
        public final Object a(int i2) {
            switch (hb.f9687a[i2 - 1]) {
                case 1:
                    return new a();
                case 2:
                    return new b((byte) 0);
                case 3:
                    return a((ex) zzxh, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0000\u0002\f\u0001", new Object[]{"zzii", "zzxf", c.zzdq(), "zzxg", C0142a.zzdq()});
                case 4:
                    return zzxh;
                case 5:
                    fi<a> fiVar = zzin;
                    if (fiVar == null) {
                        synchronized (a.class) {
                            fiVar = zzin;
                            if (fiVar == null) {
                                fiVar = new dq.c<>(zzxh);
                                zzin = fiVar;
                            }
                        }
                    }
                    return fiVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            dq.a(a.class, zzxh);
        }
    }
}
