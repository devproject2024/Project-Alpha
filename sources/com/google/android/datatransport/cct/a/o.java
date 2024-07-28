package com.google.android.datatransport.cct.a;

import android.util.SparseArray;
import com.alipay.mobile.nebula.util.H5Utils;
import com.google.android.datatransport.cct.a.i;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public abstract class o {

    public static abstract class a {
        public abstract a a(b bVar);

        public abstract a a(c cVar);

        public abstract o a();
    }

    public enum b {
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
        
        private static final SparseArray<b> zzv = null;
        private final int zzw;

        static {
            UNKNOWN_MOBILE_SUBTYPE = new b("UNKNOWN_MOBILE_SUBTYPE", 0, 0);
            GPRS = new b("GPRS", 1, 1);
            EDGE = new b("EDGE", 2, 2);
            UMTS = new b("UMTS", 3, 3);
            CDMA = new b("CDMA", 4, 4);
            EVDO_0 = new b("EVDO_0", 5, 5);
            EVDO_A = new b("EVDO_A", 6, 6);
            RTT = new b("RTT", 7, 7);
            HSDPA = new b("HSDPA", 8, 8);
            HSUPA = new b("HSUPA", 9, 9);
            HSPA = new b("HSPA", 10, 10);
            IDEN = new b("IDEN", 11, 11);
            EVDO_B = new b("EVDO_B", 12, 12);
            LTE = new b("LTE", 13, 13);
            EHRPD = new b("EHRPD", 14, 14);
            HSPAP = new b("HSPAP", 15, 15);
            GSM = new b("GSM", 16, 16);
            TD_SCDMA = new b("TD_SCDMA", 17, 17);
            IWLAN = new b("IWLAN", 18, 18);
            LTE_CA = new b("LTE_CA", 19, 19);
            COMBINED = new b("COMBINED", 20, 100);
            b[] bVarArr = {UNKNOWN_MOBILE_SUBTYPE, GPRS, EDGE, UMTS, CDMA, EVDO_0, EVDO_A, RTT, HSDPA, HSUPA, HSPA, IDEN, EVDO_B, LTE, EHRPD, HSPAP, GSM, TD_SCDMA, IWLAN, LTE_CA, COMBINED};
            SparseArray<b> sparseArray = new SparseArray<>();
            zzv = sparseArray;
            sparseArray.put(0, UNKNOWN_MOBILE_SUBTYPE);
            zzv.put(1, GPRS);
            zzv.put(2, EDGE);
            zzv.put(3, UMTS);
            zzv.put(4, CDMA);
            zzv.put(5, EVDO_0);
            zzv.put(6, EVDO_A);
            zzv.put(7, RTT);
            zzv.put(8, HSDPA);
            zzv.put(9, HSUPA);
            zzv.put(10, HSPA);
            zzv.put(11, IDEN);
            zzv.put(12, EVDO_B);
            zzv.put(13, LTE);
            zzv.put(14, EHRPD);
            zzv.put(15, HSPAP);
            zzv.put(16, GSM);
            zzv.put(17, TD_SCDMA);
            zzv.put(18, IWLAN);
            zzv.put(19, LTE_CA);
        }

        private b(int i2) {
            this.zzw = i2;
        }

        public final int zza() {
            return this.zzw;
        }

        public static b zza(int i2) {
            return zzv.get(i2);
        }
    }

    public enum c {
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
        VPN(17),
        NONE(-1);
        
        private static final SparseArray<c> zzt = null;
        private final int zzu;

        static {
            MOBILE = new c("MOBILE", 0, 0);
            WIFI = new c(H5Utils.NETWORK_TYPE_WIFI, 1, 1);
            MOBILE_MMS = new c("MOBILE_MMS", 2, 2);
            MOBILE_SUPL = new c("MOBILE_SUPL", 3, 3);
            MOBILE_DUN = new c("MOBILE_DUN", 4, 4);
            MOBILE_HIPRI = new c("MOBILE_HIPRI", 5, 5);
            WIMAX = new c("WIMAX", 6, 6);
            BLUETOOTH = new c("BLUETOOTH", 7, 7);
            DUMMY = new c("DUMMY", 8, 8);
            ETHERNET = new c("ETHERNET", 9, 9);
            MOBILE_FOTA = new c("MOBILE_FOTA", 10, 10);
            MOBILE_IMS = new c("MOBILE_IMS", 11, 11);
            MOBILE_CBS = new c("MOBILE_CBS", 12, 12);
            WIFI_P2P = new c("WIFI_P2P", 13, 13);
            MOBILE_IA = new c("MOBILE_IA", 14, 14);
            MOBILE_EMERGENCY = new c("MOBILE_EMERGENCY", 15, 15);
            PROXY = new c("PROXY", 16, 16);
            VPN = new c("VPN", 17, 17);
            NONE = new c(SDKConstants.NATIVE_SDK_NONE, 18, -1);
            c[] cVarArr = {MOBILE, WIFI, MOBILE_MMS, MOBILE_SUPL, MOBILE_DUN, MOBILE_HIPRI, WIMAX, BLUETOOTH, DUMMY, ETHERNET, MOBILE_FOTA, MOBILE_IMS, MOBILE_CBS, WIFI_P2P, MOBILE_IA, MOBILE_EMERGENCY, PROXY, VPN, NONE};
            SparseArray<c> sparseArray = new SparseArray<>();
            zzt = sparseArray;
            sparseArray.put(0, MOBILE);
            zzt.put(1, WIFI);
            zzt.put(2, MOBILE_MMS);
            zzt.put(3, MOBILE_SUPL);
            zzt.put(4, MOBILE_DUN);
            zzt.put(5, MOBILE_HIPRI);
            zzt.put(6, WIMAX);
            zzt.put(7, BLUETOOTH);
            zzt.put(8, DUMMY);
            zzt.put(9, ETHERNET);
            zzt.put(10, MOBILE_FOTA);
            zzt.put(11, MOBILE_IMS);
            zzt.put(12, MOBILE_CBS);
            zzt.put(13, WIFI_P2P);
            zzt.put(14, MOBILE_IA);
            zzt.put(15, MOBILE_EMERGENCY);
            zzt.put(16, PROXY);
            zzt.put(17, VPN);
            zzt.put(-1, NONE);
        }

        private c(int i2) {
            this.zzu = i2;
        }

        public final int zza() {
            return this.zzu;
        }

        public static c zza(int i2) {
            return zzt.get(i2);
        }
    }

    public static a c() {
        return new i.a();
    }

    public abstract c a();

    public abstract b b();
}
