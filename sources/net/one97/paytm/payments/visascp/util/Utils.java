package net.one97.paytm.payments.visascp.util;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Base64;
import net.one97.paytm.payments.visascp.storage.SecureSharedPref;

public class Utils {

    /* renamed from: ˊ  reason: contains not printable characters */
    private static int f662 = 1;

    /* renamed from: ˎ  reason: contains not printable characters */
    private static int f663;

    public static String getDeviceId(Context context) {
        int i2 = f663;
        int i3 = ((i2 | 39) << 1) - (i2 ^ 39);
        f662 = i3 % 128;
        if (i3 % 2 != 0) {
        }
        return Settings.Secure.getString(context.getContentResolver(), VisaSCPConstants.DEVICE_ID);
    }

    public static String getCardAlias(Context context, String str, String str2, String str3, String str4) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("-");
        sb.append(str2);
        sb.append("-");
        sb.append(str3);
        sb.append("-");
        sb.append(str4);
        sb.append("-");
        sb.append(getMerchantAppId(context));
        sb.append("-");
        sb.append(getDeviceId(context));
        String encodeToString = Base64.encodeToString(sb.toString().getBytes(), 2);
        int i2 = (f662 + 78) - 1;
        f663 = i2 % 128;
        if (i2 % 2 == 0) {
            return encodeToString;
        }
        Object obj = null;
        super.hashCode();
        return encodeToString;
    }

    public static String getMerchantAppId(Context context) {
        int i2 = ((f662 + 39) - 1) - 1;
        f663 = i2 % 128;
        if (i2 % 2 == 0) {
        }
        return context.getApplicationContext().getPackageName();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x005d, code lost:
        if ((!android.text.TextUtils.isEmpty(r2)) != false) goto L_0x005f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x003d, code lost:
        if ((android.text.TextUtils.isEmpty(r2)) != true) goto L_0x005f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isSafetyNetResponseValid(android.content.Context r8) {
        /*
            int r0 = f663
            r1 = r0 ^ 45
            r2 = r0 & 45
            r1 = r1 | r2
            r3 = 1
            int r1 = r1 << r3
            int r2 = ~r2
            r0 = r0 | 45
            r0 = r0 & r2
            int r0 = -r0
            r2 = r1 & r0
            r0 = r0 | r1
            int r2 = r2 + r0
            int r0 = r2 % 128
            f662 = r0
            int r2 = r2 % 2
            r0 = 0
            if (r2 == 0) goto L_0x001d
            r1 = 0
            goto L_0x001e
        L_0x001d:
            r1 = 1
        L_0x001e:
            if (r1 == r3) goto L_0x0040
            net.one97.paytm.payments.visascp.storage.SecureSharedPref r1 = net.one97.paytm.payments.visascp.storage.SecureSharedPref.getInstance(r8)
            java.lang.String r2 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.SAFETY_DATA_PREF_KEY
            java.lang.String r2 = r1.getData(r8, r2)
            java.lang.String r4 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.SAFETY_DATA_TIME_PREF_KEY
            long r4 = r1.getLongData(r8, r4)
            long r6 = java.lang.System.currentTimeMillis()
            boolean r8 = android.text.TextUtils.isEmpty(r2)
            if (r8 == 0) goto L_0x003c
            r8 = 1
            goto L_0x003d
        L_0x003c:
            r8 = 0
        L_0x003d:
            if (r8 == r3) goto L_0x0094
            goto L_0x005f
        L_0x0040:
            net.one97.paytm.payments.visascp.storage.SecureSharedPref r1 = net.one97.paytm.payments.visascp.storage.SecureSharedPref.getInstance(r8)
            java.lang.String r2 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.SAFETY_DATA_PREF_KEY
            java.lang.String r2 = r1.getData(r8, r2)
            java.lang.String r4 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.SAFETY_DATA_TIME_PREF_KEY
            long r4 = r1.getLongData(r8, r4)
            long r6 = java.lang.System.currentTimeMillis()
            boolean r8 = android.text.TextUtils.isEmpty(r2)
            if (r8 == 0) goto L_0x005c
            r8 = 0
            goto L_0x005d
        L_0x005c:
            r8 = 1
        L_0x005d:
            if (r8 == 0) goto L_0x0094
        L_0x005f:
            long r6 = r6 - r4
            int r8 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.SAFETY_NET_REFRESH_THRESHOLD
            long r1 = (long) r8
            int r8 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r8 <= 0) goto L_0x0069
            r8 = 0
            goto L_0x006a
        L_0x0069:
            r8 = 1
        L_0x006a:
            if (r8 == 0) goto L_0x0094
            int r8 = f662
            r1 = r8 & 37
            r8 = r8 ^ 37
            r8 = r8 | r1
            int r8 = ~r8
            int r1 = r1 - r8
            int r1 = r1 - r3
            int r8 = r1 % 128
            f663 = r8
            int r1 = r1 % 2
            r8 = 71
            if (r1 != 0) goto L_0x0083
            r1 = 75
            goto L_0x0085
        L_0x0083:
            r1 = 71
        L_0x0085:
            if (r1 == r8) goto L_0x0088
            r0 = 1
        L_0x0088:
            int r8 = f663
            int r8 = r8 + 120
            int r8 = r8 - r3
            int r1 = r8 % 128
            f662 = r1
            int r8 = r8 % 2
            return r0
        L_0x0094:
            int r8 = f662
            r1 = r8 ^ 43
            r8 = r8 & 43
            r8 = r8 | r1
            int r8 = r8 << r3
            int r8 = r8 - r1
            int r1 = r8 % 128
            f663 = r1
            int r8 = r8 % 2
            r1 = 73
            if (r8 != 0) goto L_0x00aa
            r8 = 85
            goto L_0x00ac
        L_0x00aa:
            r8 = 73
        L_0x00ac:
            if (r8 == r1) goto L_0x00ae
        L_0x00ae:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.payments.visascp.util.Utils.isSafetyNetResponseValid(android.content.Context):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0074, code lost:
        if ((r2 - r6 > ((long) net.one97.paytm.payments.visascp.util.VisaSCPConstants.ONE_CLICK_INFO_ENROLL_REFRESH_THRESHOLD) ? 'T' : 'Y') != 'T') goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0085, code lost:
        if ((r2 / r6 > ((long) net.one97.paytm.payments.visascp.util.VisaSCPConstants.ONE_CLICK_INFO_ENROLL_REFRESH_THRESHOLD) ? (char) 3 : 19) != 19) goto L_0x0097;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isOneClickInfoEnrollResponseValid(android.content.Context r6, java.lang.String r7) {
        /*
            net.one97.paytm.payments.visascp.storage.SecureSharedPref r0 = net.one97.paytm.payments.visascp.storage.SecureSharedPref.getInstance(r6)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r7)
            java.lang.String r2 = "_"
            r1.append(r2)
            java.lang.String r3 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.ONE_CLICK_INFO_ENROLL_JSON_PREF_KEY
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            java.lang.String r1 = r0.getData(r6, r1)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r7)
            r3.append(r2)
            java.lang.String r7 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.ONE_CLICK_INFO_ENROLL_TIME_PREF_KEY
            r3.append(r7)
            java.lang.String r7 = r3.toString()
            long r6 = r0.getLongData(r6, r7)
            long r2 = java.lang.System.currentTimeMillis()
            boolean r0 = android.text.TextUtils.isEmpty(r1)
            r1 = 51
            if (r0 == 0) goto L_0x0045
            r0 = 51
            goto L_0x0047
        L_0x0045:
            r0 = 63
        L_0x0047:
            r4 = 0
            r5 = 1
            if (r0 == r1) goto L_0x0097
            int r0 = f662
            r1 = r0 | 66
            int r1 = r1 << r5
            r0 = r0 ^ 66
            int r1 = r1 - r0
            r0 = r1 & -1
            r1 = r1 | -1
            int r0 = r0 + r1
            int r1 = r0 % 128
            f663 = r1
            int r0 = r0 % 2
            if (r0 != 0) goto L_0x0062
            r0 = 0
            goto L_0x0063
        L_0x0062:
            r0 = 1
        L_0x0063:
            if (r0 == r5) goto L_0x0077
            long r2 = r2 - r6
            int r6 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.ONE_CLICK_INFO_ENROLL_REFRESH_THRESHOLD
            long r6 = (long) r6
            r0 = 84
            int r1 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r1 <= 0) goto L_0x0072
            r6 = 84
            goto L_0x0074
        L_0x0072:
            r6 = 89
        L_0x0074:
            if (r6 == r0) goto L_0x0097
            goto L_0x0088
        L_0x0077:
            long r2 = r2 / r6
            int r6 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.ONE_CLICK_INFO_ENROLL_REFRESH_THRESHOLD
            long r6 = (long) r6
            r0 = 19
            int r1 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r1 <= 0) goto L_0x0083
            r6 = 3
            goto L_0x0085
        L_0x0083:
            r6 = 19
        L_0x0085:
            if (r6 == r0) goto L_0x0088
            goto L_0x0097
        L_0x0088:
            int r6 = f662
            r7 = r6 | 117(0x75, float:1.64E-43)
            int r7 = r7 << r5
            r6 = r6 ^ 117(0x75, float:1.64E-43)
            int r7 = r7 - r6
            int r6 = r7 % 128
            f663 = r6
            int r7 = r7 % 2
            return r5
        L_0x0097:
            int r6 = f662
            r7 = r6 | 121(0x79, float:1.7E-43)
            int r7 = r7 << r5
            r6 = r6 ^ 121(0x79, float:1.7E-43)
            int r7 = r7 - r6
            int r6 = r7 % 128
            f663 = r6
            int r7 = r7 % 2
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.payments.visascp.util.Utils.isOneClickInfoEnrollResponseValid(android.content.Context, java.lang.String):boolean");
    }

    public static boolean isOneClickInfoPayResponseValid(Context context, String str) {
        SecureSharedPref instance = SecureSharedPref.getInstance(context);
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("_");
        sb.append(VisaSCPConstants.ONE_CLICK_INFO_PAY_JSON_PREF_KEY);
        String data = instance.getData(context, sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append("_");
        sb2.append(VisaSCPConstants.ONE_CLICK_INFO_PAY_TIME_PREF_KEY);
        long longData = instance.getLongData(context, sb2.toString());
        long currentTimeMillis = System.currentTimeMillis();
        boolean z = false;
        if ((TextUtils.isEmpty(data) ? 6 : 'V') == 'V') {
            int i2 = f662;
            int i3 = i2 ^ 39;
            int i4 = ((i2 & 39) | i3) << 1;
            int i5 = -i3;
            int i6 = (i4 ^ i5) + ((i4 & i5) << 1);
            f663 = i6 % 128;
            int i7 = i6 % 2;
            if (currentTimeMillis - longData <= ((long) VisaSCPConstants.ONE_CLICK_INFO_PAY_REFRESH_THRESHOLD)) {
                int i8 = f663;
                int i9 = (i8 ^ 97) + ((i8 & 97) << 1);
                f662 = i9 % 128;
                int i10 = i9 % 2;
                int i11 = f663;
                int i12 = (i11 & 38) + (i11 | 38);
                int i13 = (i12 & -1) + (i12 | -1);
                f662 = i13 % 128;
                if (i13 % 2 != 0) {
                    z = true;
                }
                if (z) {
                    return true;
                }
                Object obj = null;
                super.hashCode();
                return true;
            }
        }
        int i14 = f663;
        int i15 = i14 & 29;
        int i16 = (((i14 ^ 29) | i15) << 1) - ((i14 | 29) & (~i15));
        f662 = i16 % 128;
        int i17 = i16 % 2;
        return false;
    }

    public static boolean isEnrollmentStatusResponseValid(Context context, String str) {
        SecureSharedPref instance = SecureSharedPref.getInstance(context);
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(VisaSCPConstants.ENROLL_STATUS);
        String data = instance.getData(context, sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(VisaSCPConstants.ENROLL_STATUS_API_TIMESTAMP);
        long longData = instance.getLongData(context, sb2.toString());
        long currentTimeMillis = System.currentTimeMillis();
        if ((TextUtils.isEmpty(data) ? 'Q' : 'C') == 'C') {
            int i2 = f662;
            int i3 = ((i2 & 30) + (i2 | 30)) - 1;
            f663 = i3 % 128;
            int i4 = i3 % 2;
            if (currentTimeMillis - longData <= ((long) VisaSCPConstants.ENROLL_STATUS_REFRESH_THRESHOLD)) {
                int i5 = f662;
                int i6 = i5 & 83;
                int i7 = (i5 | 83) & (~i6);
                int i8 = -(-(i6 << 1));
                int i9 = ((i7 | i8) << 1) - (i7 ^ i8);
                f663 = i9 % 128;
                int i10 = i9 % 2;
                int i11 = f663;
                int i12 = i11 ^ 77;
                int i13 = (i11 & 77) << 1;
                int i14 = (i12 & i13) + (i13 | i12);
                f662 = i14 % 128;
                int i15 = i14 % 2;
                return true;
            }
        }
        int i16 = (f663 + 2) - 1;
        f662 = i16 % 128;
        int i17 = i16 % 2;
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0119, code lost:
        r0 = f663;
        r1 = r0 & 67;
        r0 = (r0 ^ 67) | r1;
        r3 = (r1 ^ r0) + ((r0 & r1) << 1);
        f662 = r3 % 128;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x012e, code lost:
        if ((r3 % 2) == 0) goto L_0x0132;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0130, code lost:
        r1 = 6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0132, code lost:
        r1 = '&';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0134, code lost:
        if (r1 == 6) goto L_0x0136;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0136, code lost:
        return com.alipay.mobile.nebula.util.H5Utils.NETWORK_TYPE_3G;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0137, code lost:
        r0 = (f662 + 2) - 1;
        f663 = r0 % 128;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0144, code lost:
        if ((r0 % 2) != 0) goto L_0x0148;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0146, code lost:
        r4 = 'T';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0148, code lost:
        if (r4 == 'T') goto L_0x014a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x014a, code lost:
        return com.alipay.mobile.nebula.util.H5Utils.NETWORK_TYPE_2G;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x014b, code lost:
        r8 = f662;
        r0 = r8 ^ 91;
        r8 = ((((r8 & 91) | r0) << 1) - (~(-r0))) - 1;
        f663 = r8 % 128;
        r8 = r8 % 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x015d, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getNetworkType(android.content.Context r8) {
        /*
            int r0 = f662
            r1 = r0 ^ 11
            r0 = r0 & 11
            r0 = r0 | r1
            r2 = 1
            int r0 = r0 << r2
            int r1 = -r1
            int r1 = ~r1
            int r0 = r0 - r1
            int r0 = r0 - r2
            int r1 = r0 % 128
            f663 = r1
            int r0 = r0 % 2
            r1 = 63
            if (r0 != 0) goto L_0x001a
            r0 = 63
            goto L_0x001c
        L_0x001a:
            r0 = 60
        L_0x001c:
            java.lang.String r3 = "connectivity"
            r4 = 99
            r5 = 0
            r6 = 0
            if (r0 == r1) goto L_0x0036
            java.lang.Object r8 = r8.getSystemService(r3)     // Catch:{ Exception -> 0x015e }
            android.net.ConnectivityManager r8 = (android.net.ConnectivityManager) r8     // Catch:{ Exception -> 0x015e }
            android.net.NetworkInfo r8 = r8.getActiveNetworkInfo()     // Catch:{ Exception -> 0x015e }
            if (r8 != 0) goto L_0x0032
            r0 = 1
            goto L_0x0033
        L_0x0032:
            r0 = 0
        L_0x0033:
            if (r0 == 0) goto L_0x0048
            goto L_0x0053
        L_0x0036:
            java.lang.Object r8 = r8.getSystemService(r3)     // Catch:{ Exception -> 0x015e }
            android.net.ConnectivityManager r8 = (android.net.ConnectivityManager) r8     // Catch:{ Exception -> 0x015e }
            android.net.NetworkInfo r8 = r8.getActiveNetworkInfo()     // Catch:{ Exception -> 0x015e }
            if (r8 != 0) goto L_0x0044
            r0 = 1
            goto L_0x0045
        L_0x0044:
            r0 = 0
        L_0x0045:
            if (r0 == 0) goto L_0x0048
            goto L_0x0053
        L_0x0048:
            boolean r0 = r8.isConnected()     // Catch:{ Exception -> 0x015e }
            if (r0 != 0) goto L_0x0050
            r0 = 1
            goto L_0x0051
        L_0x0050:
            r0 = 0
        L_0x0051:
            if (r0 == 0) goto L_0x006b
        L_0x0053:
            int r8 = f663
            r0 = r8 ^ 99
            r1 = r8 & 99
            r0 = r0 | r1
            int r0 = r0 << r2
            int r1 = ~r1
            r8 = r8 | r4
            r8 = r8 & r1
            int r8 = -r8
            r1 = r0 | r8
            int r1 = r1 << r2
            r8 = r8 ^ r0
            int r1 = r1 - r8
            int r8 = r1 % 128
            f662 = r8
            int r1 = r1 % 2
            return r5
        L_0x006b:
            int r0 = f663
            r1 = r0 & -2
            int r3 = ~r0
            r3 = r3 & r2
            r1 = r1 | r3
            r0 = r0 & r2
            int r0 = r0 << r2
            int r0 = -r0
            int r0 = -r0
            int r0 = ~r0
            int r1 = r1 - r0
            int r1 = r1 - r2
            int r0 = r1 % 128
            f662 = r0
            int r1 = r1 % 2
            int r0 = r8.getType()     // Catch:{ Exception -> 0x015e }
            if (r0 == r2) goto L_0x0087
            r0 = 0
            goto L_0x0088
        L_0x0087:
            r0 = 1
        L_0x0088:
            if (r0 == 0) goto L_0x00ab
            int r8 = f663
            r0 = r8 ^ 45
            r8 = r8 & 45
            int r8 = r8 << r2
            int r0 = r0 + r8
            int r8 = r0 % 128
            f662 = r8
            int r0 = r0 % 2
            java.lang.String r8 = "WIFI"
            int r0 = f663
            int r0 = r0 + 8
            int r0 = r0 - r2
            int r1 = r0 % 128
            f662 = r1
            int r0 = r0 % 2
            if (r0 == 0) goto L_0x00a8
            r6 = 1
        L_0x00a8:
            if (r6 == r2) goto L_0x00aa
        L_0x00aa:
            return r8
        L_0x00ab:
            int r0 = r8.getType()     // Catch:{ Exception -> 0x015e }
            r1 = 84
            if (r0 == 0) goto L_0x00b6
            r0 = 92
            goto L_0x00b8
        L_0x00b6:
            r0 = 84
        L_0x00b8:
            if (r0 == r1) goto L_0x00d6
            int r8 = f662
            r0 = r8 | 105(0x69, float:1.47E-43)
            int r0 = r0 << r2
            r1 = r8 & -106(0xffffffffffffff96, float:NaN)
            int r8 = ~r8
            r8 = r8 & 105(0x69, float:1.47E-43)
            r8 = r8 | r1
            int r8 = -r8
            r1 = r0 | r8
            int r1 = r1 << r2
            r8 = r8 ^ r0
            int r1 = r1 - r8
            int r8 = r1 % 128
            f663 = r8
            int r1 = r1 % 2
            if (r1 != 0) goto L_0x00d4
            goto L_0x00d5
        L_0x00d4:
            r6 = 1
        L_0x00d5:
            return r5
        L_0x00d6:
            int r0 = f663
            r3 = r0 & 47
            r0 = r0 ^ 47
            r0 = r0 | r3
            int r0 = -r0
            int r0 = -r0
            r7 = r3 ^ r0
            r0 = r0 & r3
            int r0 = r0 << r2
            int r7 = r7 + r0
            int r0 = r7 % 128
            f662 = r0
            int r7 = r7 % 2
            if (r7 == 0) goto L_0x00ee
            r0 = 1
            goto L_0x00ef
        L_0x00ee:
            r0 = 0
        L_0x00ef:
            if (r0 == 0) goto L_0x00f9
            int r8 = r8.getSubtype()     // Catch:{ Exception -> 0x015e }
            switch(r8) {
                case 1: goto L_0x0137;
                case 2: goto L_0x0137;
                case 3: goto L_0x0119;
                case 4: goto L_0x0137;
                case 5: goto L_0x0119;
                case 6: goto L_0x0119;
                case 7: goto L_0x0137;
                case 8: goto L_0x0119;
                case 9: goto L_0x0119;
                case 10: goto L_0x0119;
                case 11: goto L_0x0137;
                case 12: goto L_0x0119;
                case 13: goto L_0x0101;
                case 14: goto L_0x0119;
                case 15: goto L_0x0119;
                default: goto L_0x00f8;
            }     // Catch:{ Exception -> 0x015e }
        L_0x00f8:
            goto L_0x014b
        L_0x00f9:
            int r8 = r8.getSubtype()     // Catch:{ Exception -> 0x015e }
            switch(r8) {
                case 1: goto L_0x0137;
                case 2: goto L_0x0137;
                case 3: goto L_0x0119;
                case 4: goto L_0x0137;
                case 5: goto L_0x0119;
                case 6: goto L_0x0119;
                case 7: goto L_0x0137;
                case 8: goto L_0x0119;
                case 9: goto L_0x0119;
                case 10: goto L_0x0119;
                case 11: goto L_0x0137;
                case 12: goto L_0x0119;
                case 13: goto L_0x0101;
                case 14: goto L_0x0119;
                case 15: goto L_0x0119;
                default: goto L_0x0100;
            }
        L_0x0100:
            goto L_0x014b
        L_0x0101:
            java.lang.String r8 = "4G"
            int r0 = f662
            r1 = r0 & 11
            int r3 = ~r1
            r0 = r0 | 11
            r0 = r0 & r3
            int r1 = r1 << r2
            int r0 = r0 + r1
            int r1 = r0 % 128
            f663 = r1
            int r0 = r0 % 2
            if (r0 != 0) goto L_0x0116
            r6 = 1
        L_0x0116:
            if (r6 == r2) goto L_0x0118
        L_0x0118:
            return r8
        L_0x0119:
            java.lang.String r8 = "3G"
            int r0 = f663
            r1 = r0 & 67
            r0 = r0 ^ 67
            r0 = r0 | r1
            r3 = r1 ^ r0
            r0 = r0 & r1
            int r0 = r0 << r2
            int r3 = r3 + r0
            int r0 = r3 % 128
            f662 = r0
            int r3 = r3 % 2
            r0 = 6
            if (r3 == 0) goto L_0x0132
            r1 = 6
            goto L_0x0134
        L_0x0132:
            r1 = 38
        L_0x0134:
            if (r1 == r0) goto L_0x0136
        L_0x0136:
            return r8
        L_0x0137:
            java.lang.String r8 = "2G"
            int r0 = f662
            int r0 = r0 + 2
            int r0 = r0 - r2
            int r2 = r0 % 128
            f663 = r2
            int r0 = r0 % 2
            if (r0 != 0) goto L_0x0148
            r4 = 84
        L_0x0148:
            if (r4 == r1) goto L_0x014a
        L_0x014a:
            return r8
        L_0x014b:
            int r8 = f662
            r0 = r8 ^ 91
            r8 = r8 & 91
            r8 = r8 | r0
            int r8 = r8 << r2
            int r0 = -r0
            int r0 = ~r0
            int r8 = r8 - r0
            int r8 = r8 - r2
            int r0 = r8 % 128
            f663 = r0
            int r8 = r8 % 2
            return r5
        L_0x015e:
            java.lang.String r8 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.LOG_TAG
            java.lang.String r8 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.EXCEPTION_MESSAGE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.payments.visascp.util.Utils.getNetworkType(android.content.Context):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0032, code lost:
        if ((net.one97.paytm.payments.visascp.VisaSDK.isStaging() ? (char) 14 : 24) != 24) goto L_0x0055;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0043, code lost:
        if ((net.one97.paytm.payments.visascp.VisaSDK.isStaging() ? ')' : 7) != ')') goto L_0x0045;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0052, code lost:
        if ((net.one97.paytm.payments.visascp.util.VisaSCPConstants.BUILD_TYPE_STAGING.equalsIgnoreCase("release")) != true) goto L_0x0069;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0055, code lost:
        r0 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.AUTH_CODE_STAGING_URL;
        r1 = f663;
        r4 = r1 & 101;
        r4 = (r4 - (~(-(-((r1 ^ 101) | r4))))) - 1;
        f662 = r4 % 128;
        r4 = r4 % 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0069, code lost:
        r1 = f662;
        r2 = (((r1 ^ 25) | (r1 & 25)) << 1) - (((~r1) & 25) | (r1 & -26));
        f663 = r2 % 128;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x007f, code lost:
        if ((r2 % 2) != 0) goto L_0x0083;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0081, code lost:
        r1 = 7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0083, code lost:
        r1 = '\'';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0085, code lost:
        if (r1 == 7) goto L_0x008e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0087, code lost:
        r1 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        super.hashCode();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x008b, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x008e, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getAuthCodeUrl() {
        /*
            int r0 = f662
            r1 = r0 & -78
            int r2 = ~r0
            r2 = r2 & 77
            r1 = r1 | r2
            r0 = r0 & 77
            r2 = 1
            int r0 = r0 << r2
            int r0 = -r0
            int r0 = -r0
            int r0 = ~r0
            int r1 = r1 - r0
            int r1 = r1 - r2
            int r0 = r1 % 128
            f663 = r0
            int r1 = r1 % 2
            r0 = 78
            if (r1 != 0) goto L_0x001e
            r1 = 78
            goto L_0x0020
        L_0x001e:
            r1 = 60
        L_0x0020:
            r3 = 7
            if (r1 == r0) goto L_0x0035
            java.lang.String r0 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.AUTH_CODE_PROD_URL
            boolean r1 = net.one97.paytm.payments.visascp.VisaSDK.isStaging()
            r4 = 24
            if (r1 == 0) goto L_0x0030
            r1 = 14
            goto L_0x0032
        L_0x0030:
            r1 = 24
        L_0x0032:
            if (r1 == r4) goto L_0x0045
            goto L_0x0055
        L_0x0035:
            java.lang.String r0 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.AUTH_CODE_PROD_URL
            boolean r1 = net.one97.paytm.payments.visascp.VisaSDK.isStaging()
            r4 = 41
            if (r1 == 0) goto L_0x0042
            r1 = 41
            goto L_0x0043
        L_0x0042:
            r1 = 7
        L_0x0043:
            if (r1 == r4) goto L_0x0055
        L_0x0045:
            java.lang.String r1 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.BUILD_TYPE_STAGING
            java.lang.String r4 = "release"
            boolean r1 = r1.equalsIgnoreCase(r4)
            if (r1 != 0) goto L_0x0051
            r1 = 0
            goto L_0x0052
        L_0x0051:
            r1 = 1
        L_0x0052:
            if (r1 == r2) goto L_0x0055
            goto L_0x0069
        L_0x0055:
            java.lang.String r0 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.AUTH_CODE_STAGING_URL
            int r1 = f663
            r4 = r1 & 101(0x65, float:1.42E-43)
            r1 = r1 ^ 101(0x65, float:1.42E-43)
            r1 = r1 | r4
            int r1 = -r1
            int r1 = -r1
            int r1 = ~r1
            int r4 = r4 - r1
            int r4 = r4 - r2
            int r1 = r4 % 128
            f662 = r1
            int r4 = r4 % 2
        L_0x0069:
            int r1 = f662
            r4 = r1 ^ 25
            r5 = r1 & 25
            r4 = r4 | r5
            int r2 = r4 << 1
            r4 = r1 & -26
            int r1 = ~r1
            r1 = r1 & 25
            r1 = r1 | r4
            int r2 = r2 - r1
            int r1 = r2 % 128
            f663 = r1
            int r2 = r2 % 2
            if (r2 != 0) goto L_0x0083
            r1 = 7
            goto L_0x0085
        L_0x0083:
            r1 = 39
        L_0x0085:
            if (r1 == r3) goto L_0x008e
            r1 = 0
            super.hashCode()     // Catch:{ all -> 0x008c }
            return r0
        L_0x008c:
            r0 = move-exception
            throw r0
        L_0x008e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.payments.visascp.util.Utils.getAuthCodeUrl():java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x003a, code lost:
        if (net.one97.paytm.payments.visascp.util.VisaSCPConstants.BUILD_TYPE_STAGING.equalsIgnoreCase("release") != false) goto L_0x003c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getVerifyDeviceUrl(java.lang.String r5) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.VERIFY_DEVICE_PROD_URL
            r0.append(r1)
            r0.append(r5)
            java.lang.String r0 = r0.toString()
            boolean r1 = net.one97.paytm.payments.visascp.VisaSDK.isStaging()
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x001b
            r1 = 0
            goto L_0x001c
        L_0x001b:
            r1 = 1
        L_0x001c:
            if (r1 == r3) goto L_0x001f
            goto L_0x003c
        L_0x001f:
            int r1 = f662
            r4 = r1 | 36
            int r4 = r4 << r3
            r1 = r1 ^ 36
            int r4 = r4 - r1
            r1 = r4 | -1
            int r1 = r1 << r3
            int r4 = ~r4
            int r1 = r1 - r4
            int r4 = r1 % 128
            f663 = r4
            int r1 = r1 % 2
            java.lang.String r1 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.BUILD_TYPE_STAGING
            java.lang.String r4 = "release"
            boolean r1 = r1.equalsIgnoreCase(r4)
            if (r1 == 0) goto L_0x0057
        L_0x003c:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.VERIFY_DEVICE_STAGING_URL
            r0.append(r1)
            r0.append(r5)
            java.lang.String r0 = r0.toString()
            int r5 = f662
            int r5 = r5 + 87
            int r1 = r5 % 128
            f663 = r1
            int r5 = r5 % 2
        L_0x0057:
            int r5 = f662
            r1 = r5 ^ 117(0x75, float:1.64E-43)
            r4 = r5 & 117(0x75, float:1.64E-43)
            r1 = r1 | r4
            int r1 = r1 << r3
            int r4 = ~r4
            r5 = r5 | 117(0x75, float:1.64E-43)
            r5 = r5 & r4
            int r5 = -r5
            r4 = r1 | r5
            int r4 = r4 << r3
            r5 = r5 ^ r1
            int r4 = r4 - r5
            int r5 = r4 % 128
            f663 = r5
            int r4 = r4 % 2
            if (r4 != 0) goto L_0x0072
            r2 = 1
        L_0x0072:
            if (r2 == 0) goto L_0x0075
            return r0
        L_0x0075:
            r5 = 0
            super.hashCode()     // Catch:{ all -> 0x007a }
            return r0
        L_0x007a:
            r5 = move-exception
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.payments.visascp.util.Utils.getVerifyDeviceUrl(java.lang.String):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004a, code lost:
        if ((!net.one97.paytm.payments.visascp.util.VisaSCPConstants.BUILD_TYPE_STAGING.equalsIgnoreCase("release") ? 27 : 'K') != 27) goto L_0x005b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0058, code lost:
        if ((!net.one97.paytm.payments.visascp.util.VisaSCPConstants.BUILD_TYPE_STAGING.equalsIgnoreCase("release")) != false) goto L_0x0074;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getVisaCertificateURL() {
        /*
            int r0 = f662
            r1 = r0 ^ 51
            r0 = r0 & 51
            r0 = r0 | r1
            r2 = 1
            int r0 = r0 << r2
            int r1 = -r1
            r3 = r0 & r1
            r0 = r0 | r1
            int r3 = r3 + r0
            int r0 = r3 % 128
            f663 = r0
            int r3 = r3 % 2
            java.lang.String r0 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.GET_VISA_CERTIFICATE_PROD_URL
            boolean r1 = net.one97.paytm.payments.visascp.VisaSDK.isStaging()
            r3 = 0
            if (r1 == 0) goto L_0x001f
            r1 = 1
            goto L_0x0020
        L_0x001f:
            r1 = 0
        L_0x0020:
            if (r1 == 0) goto L_0x0023
            goto L_0x005b
        L_0x0023:
            int r1 = f663
            int r1 = r1 + 60
            int r1 = r1 - r2
            int r4 = r1 % 128
            f662 = r4
            int r1 = r1 % 2
            r4 = 56
            if (r1 == 0) goto L_0x0035
            r1 = 12
            goto L_0x0037
        L_0x0035:
            r1 = 56
        L_0x0037:
            java.lang.String r5 = "release"
            if (r1 == r4) goto L_0x004d
            java.lang.String r1 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.BUILD_TYPE_STAGING
            boolean r1 = r1.equalsIgnoreCase(r5)
            r4 = 27
            if (r1 != 0) goto L_0x0048
            r1 = 27
            goto L_0x004a
        L_0x0048:
            r1 = 75
        L_0x004a:
            if (r1 == r4) goto L_0x0074
            goto L_0x005b
        L_0x004d:
            java.lang.String r1 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.BUILD_TYPE_STAGING
            boolean r1 = r1.equalsIgnoreCase(r5)
            if (r1 != 0) goto L_0x0057
            r1 = 1
            goto L_0x0058
        L_0x0057:
            r1 = 0
        L_0x0058:
            if (r1 == 0) goto L_0x005b
            goto L_0x0074
        L_0x005b:
            java.lang.String r0 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.GET_VISA_CERTIFICATE_STAGING_URL
            int r1 = f662
            r4 = r1 & 13
            r1 = r1 ^ 13
            r1 = r1 | r4
            int r4 = r4 + r1
            int r1 = r4 % 128
            f663 = r1
            int r4 = r4 % 2
            r1 = 16
            if (r4 != 0) goto L_0x0072
            r4 = 19
            goto L_0x0074
        L_0x0072:
            r4 = 16
        L_0x0074:
            int r1 = f662
            r4 = r1 & 95
            r1 = r1 | 95
            int r4 = r4 + r1
            int r1 = r4 % 128
            f663 = r1
            int r4 = r4 % 2
            if (r4 != 0) goto L_0x0084
            goto L_0x0085
        L_0x0084:
            r2 = 0
        L_0x0085:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.payments.visascp.util.Utils.getVisaCertificateURL():java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0034, code lost:
        if ((!r0 ? 'G' : 30) != 30) goto L_0x011e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0043, code lost:
        if ((!"ACCESS".equalsIgnoreCase(r8)) != true) goto L_0x0045;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00f8, code lost:
        if (r1 != 0) goto L_0x0177;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0105, code lost:
        if (r1 != 0) goto L_0x0107;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0124, code lost:
        if ("CHECKSUM".equalsIgnoreCase(r8) != false) goto L_0x0128;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0126, code lost:
        r8 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0128, code lost:
        r8 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0129, code lost:
        if (r8 == true) goto L_0x0176;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x012b, code lost:
        r8 = f662;
        r10 = r8 ^ 65;
        r8 = ((((r8 & 65) | r10) << 1) - (~(-r10))) - 1;
        f663 = r8 % 128;
        r8 = r8 % 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0143, code lost:
        if (android.text.TextUtils.isEmpty(r9) != false) goto L_0x0148;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0145, code lost:
        r8 = 'X';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0148, code lost:
        r8 = 'b';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x014a, code lost:
        if (r8 == 'X') goto L_0x0176;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x014c, code lost:
        r8 = f662;
        r9 = r8 & 103;
        r9 = r9 + ((r8 ^ 103) | r9);
        f663 = r9 % 128;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x015a, code lost:
        if ((r9 % 2) != 0) goto L_0x015d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x015d, code lost:
        r8 = f663;
        r9 = r8 & 75;
        r9 = (r9 - (~((r8 ^ 75) | r9))) - 1;
        f662 = r9 % 128;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x016c, code lost:
        if ((r9 % 2) == 0) goto L_0x0171;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0176, code lost:
        r6 = r7;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String validateQueryParams(java.lang.String r8, java.lang.String r9, java.lang.String r10) {
        /*
            int r0 = f662
            r1 = r0 ^ 103(0x67, float:1.44E-43)
            r0 = r0 & 103(0x67, float:1.44E-43)
            r2 = 1
            int r0 = r0 << r2
            r3 = r1 & r0
            r0 = r0 | r1
            int r3 = r3 + r0
            int r0 = r3 % 128
            f663 = r0
            int r3 = r3 % 2
            r0 = 51
            r1 = 0
            if (r3 != 0) goto L_0x001a
            r3 = 51
            goto L_0x001b
        L_0x001a:
            r3 = 0
        L_0x001b:
            java.lang.String r4 = "ACCESS"
            r5 = 75
            java.lang.String r6 = "mid cannot be empty or blank"
            r7 = 0
            if (r3 == r0) goto L_0x003a
            boolean r0 = r4.equalsIgnoreCase(r8)
            super.hashCode()     // Catch:{ all -> 0x0038 }
            r3 = 30
            if (r0 != 0) goto L_0x0032
            r0 = 71
            goto L_0x0034
        L_0x0032:
            r0 = 30
        L_0x0034:
            if (r0 == r3) goto L_0x0045
            goto L_0x011e
        L_0x0038:
            r8 = move-exception
            throw r8
        L_0x003a:
            boolean r0 = r4.equalsIgnoreCase(r8)
            if (r0 != 0) goto L_0x0042
            r0 = 1
            goto L_0x0043
        L_0x0042:
            r0 = 0
        L_0x0043:
            if (r0 == r2) goto L_0x011e
        L_0x0045:
            int r8 = f663
            int r8 = r8 + 57
            int r0 = r8 % 128
            f662 = r0
            int r8 = r8 % 2
            boolean r8 = android.text.TextUtils.isEmpty(r9)
            if (r8 != 0) goto L_0x0057
            r8 = 1
            goto L_0x0058
        L_0x0057:
            r8 = 0
        L_0x0058:
            if (r8 == 0) goto L_0x005c
            r6 = r7
            goto L_0x0081
        L_0x005c:
            int r8 = f662
            int r8 = r8 + 57
            int r9 = r8 % 128
            f663 = r9
            int r8 = r8 % 2
            int r8 = f663
            r9 = r8 & 1
            r8 = r8 ^ r2
            r8 = r8 | r9
            int r8 = -r8
            int r8 = -r8
            r0 = r9 & r8
            r8 = r8 | r9
            int r0 = r0 + r8
            int r8 = r0 % 128
            f662 = r8
            int r0 = r0 % 2
            if (r0 == 0) goto L_0x007d
            r8 = 31
            goto L_0x007f
        L_0x007d:
            r8 = 23
        L_0x007f:
            r9 = 31
        L_0x0081:
            boolean r8 = android.text.TextUtils.isEmpty(r10)
            if (r8 != 0) goto L_0x0089
            r8 = 0
            goto L_0x008a
        L_0x0089:
            r8 = 1
        L_0x008a:
            if (r8 == r2) goto L_0x008d
            goto L_0x00c6
        L_0x008d:
            int r8 = f663
            r9 = r8 & 124(0x7c, float:1.74E-43)
            r8 = r8 | 124(0x7c, float:1.74E-43)
            int r9 = r9 + r8
            r8 = r9 | -1
            int r8 = r8 << r2
            int r9 = ~r9
            int r8 = r8 - r9
            int r9 = r8 % 128
            f662 = r9
            int r8 = r8 % 2
            if (r8 == 0) goto L_0x00a4
            r8 = 92
            goto L_0x00a6
        L_0x00a4:
            r8 = 87
        L_0x00a6:
            r9 = 87
            java.lang.String r8 = "referenceId cannot be empty or blank"
            int r9 = f662
            r0 = r9 | 69
            int r0 = r0 << r2
            r9 = r9 ^ 69
            int r9 = -r9
            r3 = r0 ^ r9
            r9 = r9 & r0
            int r9 = r9 << r2
            int r3 = r3 + r9
            int r9 = r3 % 128
            f663 = r9
            int r3 = r3 % 2
            if (r3 != 0) goto L_0x00c1
            r9 = 4
            goto L_0x00c3
        L_0x00c1:
            r9 = 77
        L_0x00c3:
            r0 = 77
            r6 = r8
        L_0x00c6:
            int r8 = r10.length()
            r9 = 10
            if (r8 >= r9) goto L_0x00d0
            r8 = 0
            goto L_0x00d1
        L_0x00d0:
            r8 = 1
        L_0x00d1:
            if (r8 == r2) goto L_0x00d4
            goto L_0x0107
        L_0x00d4:
            int r8 = f662
            r9 = r8 & 9
            r8 = r8 ^ 9
            r8 = r8 | r9
            int r8 = ~r8
            int r9 = r9 - r8
            int r9 = r9 - r2
            int r8 = r9 % 128
            f663 = r8
            int r9 = r9 % 2
            if (r9 != 0) goto L_0x00e9
            r8 = 81
            goto L_0x00eb
        L_0x00e9:
            r8 = 24
        L_0x00eb:
            r9 = 24
            if (r8 == r9) goto L_0x00fc
            int r8 = r10.length()
            r9 = 20
            if (r8 > r9) goto L_0x00f8
            r1 = 1
        L_0x00f8:
            if (r1 == 0) goto L_0x0107
            goto L_0x0177
        L_0x00fc:
            int r8 = r10.length()
            if (r8 > r5) goto L_0x0103
            goto L_0x0105
        L_0x0103:
            r1 = 27
        L_0x0105:
            if (r1 == 0) goto L_0x0177
        L_0x0107:
            int r8 = f662
            r9 = r8 & 9
            r8 = r8 ^ 9
            r8 = r8 | r9
            int r8 = -r8
            int r8 = -r8
            r10 = r9 | r8
            int r10 = r10 << r2
            r8 = r8 ^ r9
            int r10 = r10 - r8
            int r8 = r10 % 128
            f663 = r8
            int r10 = r10 % 2
            java.lang.String r6 = "referenceId length should be between 10 to 20"
            goto L_0x0177
        L_0x011e:
            java.lang.String r10 = "CHECKSUM"
            boolean r8 = r10.equalsIgnoreCase(r8)
            if (r8 != 0) goto L_0x0128
            r8 = 1
            goto L_0x0129
        L_0x0128:
            r8 = 0
        L_0x0129:
            if (r8 == r2) goto L_0x0176
            int r8 = f662
            r10 = r8 ^ 65
            r8 = r8 & 65
            r8 = r8 | r10
            int r8 = r8 << r2
            int r10 = -r10
            int r10 = ~r10
            int r8 = r8 - r10
            int r8 = r8 - r2
            int r10 = r8 % 128
            f663 = r10
            int r8 = r8 % 2
            boolean r8 = android.text.TextUtils.isEmpty(r9)
            r9 = 88
            if (r8 != 0) goto L_0x0148
            r8 = 88
            goto L_0x014a
        L_0x0148:
            r8 = 98
        L_0x014a:
            if (r8 == r9) goto L_0x0176
            int r8 = f662
            r9 = r8 & 103(0x67, float:1.44E-43)
            r8 = r8 ^ 103(0x67, float:1.44E-43)
            r8 = r8 | r9
            int r9 = r9 + r8
            int r8 = r9 % 128
            f663 = r8
            int r9 = r9 % 2
            if (r9 != 0) goto L_0x015d
            r1 = 1
        L_0x015d:
            int r8 = f663
            r9 = r8 & 75
            r8 = r8 ^ r5
            r8 = r8 | r9
            int r8 = ~r8
            int r9 = r9 - r8
            int r9 = r9 - r2
            int r8 = r9 % 128
            f662 = r8
            int r9 = r9 % 2
            if (r9 == 0) goto L_0x0171
            r8 = 47
            goto L_0x0173
        L_0x0171:
            r8 = 29
        L_0x0173:
            r9 = 29
            goto L_0x0177
        L_0x0176:
            r6 = r7
        L_0x0177:
            int r8 = f662
            r9 = r8 ^ 99
            r10 = r8 & 99
            r9 = r9 | r10
            int r9 = r9 << r2
            r10 = r8 & -100
            int r8 = ~r8
            r8 = r8 & 99
            r8 = r8 | r10
            int r8 = -r8
            r10 = r9 | r8
            int r10 = r10 << r2
            r8 = r8 ^ r9
            int r10 = r10 - r8
            int r8 = r10 % 128
            f663 = r8
            int r10 = r10 % 2
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.payments.visascp.util.Utils.validateQueryParams(java.lang.String, java.lang.String, java.lang.String):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0048, code lost:
        if ((!r1) != true) goto L_0x004a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.ArrayList<net.one97.paytm.payments.visascp.network.model.VisaCertificateData> getCertificate(android.content.Context r9) {
        /*
            int r0 = f663
            r1 = r0 & -38
            int r2 = ~r0
            r2 = r2 & 37
            r1 = r1 | r2
            r0 = r0 & 37
            r2 = 1
            int r0 = r0 << r2
            int r1 = r1 + r0
            int r0 = r1 % 128
            f662 = r0
            int r1 = r1 % 2
            r0 = 0
            if (r1 == 0) goto L_0x0018
            r1 = 0
            goto L_0x0019
        L_0x0018:
            r1 = 1
        L_0x0019:
            r3 = 0
            if (r1 == r2) goto L_0x0032
            net.one97.paytm.payments.visascp.storage.SecureSharedPref r1 = net.one97.paytm.payments.visascp.storage.SecureSharedPref.getInstance(r9)     // Catch:{ Exception -> 0x011f }
            java.lang.String r4 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.KEY_SHARED_VISA_CERTIFICATE     // Catch:{ Exception -> 0x011f }
            java.lang.String r9 = r1.getData(r9, r4)     // Catch:{ Exception -> 0x011f }
            boolean r1 = r9.isEmpty()     // Catch:{ Exception -> 0x011f }
            if (r1 != 0) goto L_0x002e
            r1 = 1
            goto L_0x002f
        L_0x002e:
            r1 = 0
        L_0x002f:
            if (r1 == r2) goto L_0x0082
            goto L_0x004a
        L_0x0032:
            net.one97.paytm.payments.visascp.storage.SecureSharedPref r1 = net.one97.paytm.payments.visascp.storage.SecureSharedPref.getInstance(r9)     // Catch:{ Exception -> 0x011f }
            java.lang.String r4 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.KEY_SHARED_VISA_CERTIFICATE     // Catch:{ Exception -> 0x011f }
            java.lang.String r9 = r1.getData(r9, r4)     // Catch:{ Exception -> 0x011f }
            boolean r1 = r9.isEmpty()     // Catch:{ Exception -> 0x011f }
            super.hashCode()     // Catch:{ all -> 0x011d }
            if (r1 != 0) goto L_0x0047
            r1 = 1
            goto L_0x0048
        L_0x0047:
            r1 = 0
        L_0x0048:
            if (r1 == r2) goto L_0x0082
        L_0x004a:
            int r9 = f663
            r0 = r9 ^ 15
            r1 = r9 & 15
            r0 = r0 | r1
            int r0 = r0 << r2
            int r1 = ~r1
            r9 = r9 | 15
            r9 = r9 & r1
            int r9 = -r9
            r1 = r0 | r9
            int r1 = r1 << r2
            r9 = r9 ^ r0
            int r1 = r1 - r9
            int r9 = r1 % 128
            f662 = r9
            int r1 = r1 % 2
            int r9 = f663
            r0 = r9 & -102(0xffffffffffffff9a, float:NaN)
            int r1 = ~r9
            r1 = r1 & 101(0x65, float:1.42E-43)
            r0 = r0 | r1
            r9 = r9 & 101(0x65, float:1.42E-43)
            int r9 = r9 << r2
            int r9 = ~r9
            int r0 = r0 - r9
            int r0 = r0 - r2
            int r9 = r0 % 128
            f662 = r9
            int r0 = r0 % 2
            r9 = 64
            if (r0 == 0) goto L_0x007d
            r0 = 76
            goto L_0x007f
        L_0x007d:
            r0 = 64
        L_0x007f:
            if (r0 == r9) goto L_0x0081
        L_0x0081:
            return r3
        L_0x0082:
            net.one97.paytm.payments.visascp.security.Decrypter r1 = new net.one97.paytm.payments.visascp.security.Decrypter     // Catch:{ Exception -> 0x011f }
            r1.<init>()     // Catch:{ Exception -> 0x011f }
            java.lang.String r4 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.VISA_CERTIFICATE_EN_DE_SECRET_KEY     // Catch:{ Exception -> 0x011f }
            java.lang.String r9 = r1.decryptVisaCertificateResponse(r9, r4)     // Catch:{ Exception -> 0x011f }
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ Exception -> 0x011f }
            r1.<init>()     // Catch:{ Exception -> 0x011f }
            org.json.JSONArray r4 = new org.json.JSONArray     // Catch:{ Exception -> 0x011f }
            r4.<init>(r9)     // Catch:{ Exception -> 0x011f }
            int r9 = f663
            int r9 = r9 + 101
            int r5 = r9 % 128
            f662 = r5
            int r9 = r9 % 2
            r5 = 31
            if (r9 == 0) goto L_0x00a8
            r9 = 31
            goto L_0x00aa
        L_0x00a8:
            r9 = 42
        L_0x00aa:
            r9 = 0
        L_0x00ab:
            int r5 = r4.length()     // Catch:{ Exception -> 0x011f }
            if (r9 >= r5) goto L_0x0110
            net.one97.paytm.payments.visascp.network.model.VisaCertificateData r5 = new net.one97.paytm.payments.visascp.network.model.VisaCertificateData     // Catch:{ Exception -> 0x011f }
            r5.<init>()     // Catch:{ Exception -> 0x011f }
            org.json.JSONObject r6 = r4.getJSONObject(r9)     // Catch:{ Exception -> 0x011f }
            java.lang.String r7 = "certificateKey"
            java.lang.String r7 = r6.optString(r7)     // Catch:{ Exception -> 0x011f }
            r5.setCertificateKey(r7)     // Catch:{ Exception -> 0x011f }
            java.lang.String r7 = "endDate"
            long r7 = r6.optLong(r7)     // Catch:{ Exception -> 0x011f }
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch:{ Exception -> 0x011f }
            r5.setEndDate(r7)     // Catch:{ Exception -> 0x011f }
            java.lang.String r7 = "id"
            long r7 = r6.optLong(r7)     // Catch:{ Exception -> 0x011f }
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch:{ Exception -> 0x011f }
            r5.setId(r7)     // Catch:{ Exception -> 0x011f }
            java.lang.String r7 = "startDate"
            long r6 = r6.optLong(r7)     // Catch:{ Exception -> 0x011f }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ Exception -> 0x011f }
            r5.setStartDate(r6)     // Catch:{ Exception -> 0x011f }
            r1.add(r5)     // Catch:{ Exception -> 0x011f }
            r5 = r9 ^ -24
            r6 = r9 & -24
            r5 = r5 | r6
            int r5 = r5 << r2
            r6 = r9 & 23
            int r9 = ~r9
            r9 = r9 & -24
            r9 = r9 | r6
            int r5 = r5 - r9
            r9 = r5 ^ 25
            r5 = r5 & 25
            int r5 = r5 << r2
            int r9 = r9 + r5
            int r5 = f663
            r6 = r5 ^ 35
            r5 = r5 & 35
            int r5 = r5 << r2
            int r6 = r6 + r5
            int r5 = r6 % 128
            f662 = r5
            int r6 = r6 % 2
            goto L_0x00ab
        L_0x0110:
            int r9 = f662
            int r9 = r9 + 62
            int r9 = r9 - r0
            int r9 = r9 - r2
            int r0 = r9 % 128
            f663 = r0
            int r9 = r9 % 2
            return r1
        L_0x011d:
            r9 = move-exception
            throw r9
        L_0x011f:
            java.lang.String r9 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.LOG_TAG
            java.lang.String r9 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.EXCEPTION_MESSAGE
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.payments.visascp.util.Utils.getCertificate(android.content.Context):java.util.ArrayList");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0042, code lost:
        if ((!r3 ? 'B' : '!') != '!') goto L_0x0071;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0053, code lost:
        if ((!net.one97.paytm.payments.visascp.util.VisaSCPConstants.BUILD_TYPE_STAGING.equalsIgnoreCase("release") ? (char) 14 : 2) != 2) goto L_0x0071;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getStaticVisaCertificateForSSHHandShake() {
        /*
            int r0 = f662
            int r0 = r0 + 30
            r1 = 1
            int r0 = r0 - r1
            int r2 = r0 % 128
            f663 = r2
            r2 = 2
            int r0 = r0 % r2
            java.lang.String r0 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.VISA_CERTIFICATE_FOR_PRODUCTION
            boolean r3 = net.one97.paytm.payments.visascp.VisaSDK.isStaging()
            if (r3 == 0) goto L_0x0016
            r3 = 1
            goto L_0x0017
        L_0x0016:
            r3 = 0
        L_0x0017:
            if (r3 == r1) goto L_0x0056
            int r3 = f663
            int r3 = r3 + 39
            int r3 = r3 - r1
            int r3 = r3 - r1
            int r4 = r3 % 128
            f662 = r4
            int r3 = r3 % r2
            r4 = 7
            if (r3 == 0) goto L_0x0029
            r3 = 7
            goto L_0x002b
        L_0x0029:
            r3 = 46
        L_0x002b:
            java.lang.String r5 = "release"
            if (r3 == r4) goto L_0x0047
            java.lang.String r3 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.BUILD_TYPE_STAGING
            boolean r3 = r3.equalsIgnoreCase(r5)
            r4 = 0
            super.hashCode()     // Catch:{ all -> 0x0045 }
            r4 = 33
            if (r3 != 0) goto L_0x0040
            r3 = 66
            goto L_0x0042
        L_0x0040:
            r3 = 33
        L_0x0042:
            if (r3 == r4) goto L_0x0056
            goto L_0x0071
        L_0x0045:
            r0 = move-exception
            throw r0
        L_0x0047:
            java.lang.String r3 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.BUILD_TYPE_STAGING
            boolean r3 = r3.equalsIgnoreCase(r5)
            if (r3 != 0) goto L_0x0052
            r3 = 14
            goto L_0x0053
        L_0x0052:
            r3 = 2
        L_0x0053:
            if (r3 == r2) goto L_0x0056
            goto L_0x0071
        L_0x0056:
            java.lang.String r0 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.VISA_CERTIFICATE_FOR_STAGING
            int r3 = f663
            r4 = r3 ^ 63
            r5 = r3 & 63
            r4 = r4 | r5
            int r1 = r4 << 1
            r4 = r3 & -64
            int r3 = ~r3
            r3 = r3 & 63
            r3 = r3 | r4
            int r3 = -r3
            r4 = r1 & r3
            r1 = r1 | r3
            int r4 = r4 + r1
            int r1 = r4 % 128
            f662 = r1
            int r4 = r4 % r2
        L_0x0071:
            int r1 = f662
            r3 = r1 & 87
            r1 = r1 | 87
            int r3 = r3 + r1
            int r1 = r3 % 128
            f663 = r1
            int r3 = r3 % r2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.payments.visascp.util.Utils.getStaticVisaCertificateForSSHHandShake():java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0035, code lost:
        if ((r7 == null ? 'X' : 'B') != 'B') goto L_0x003e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0025, code lost:
        if ((r7 == null ? 'N' : 4) != 4) goto L_0x003e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.ArrayList<net.one97.paytm.payments.visascp.network.model.VisaCertificateData> getVisaCertificateFromServer(android.content.Context r7) {
        /*
            int r0 = f662
            r1 = r0 & 65
            r0 = r0 | 65
            int r0 = -r0
            int r0 = -r0
            int r0 = ~r0
            int r1 = r1 - r0
            r0 = 1
            int r1 = r1 - r0
            int r2 = r1 % 128
            f663 = r2
            int r1 = r1 % 2
            r2 = 0
            if (r1 != 0) goto L_0x0017
            r1 = 0
            goto L_0x0018
        L_0x0017:
            r1 = 1
        L_0x0018:
            if (r1 == r0) goto L_0x0028
            java.util.ArrayList r7 = getCertificate(r7)
            r1 = 4
            if (r7 != 0) goto L_0x0024
            r3 = 78
            goto L_0x0025
        L_0x0024:
            r3 = 4
        L_0x0025:
            if (r3 == r1) goto L_0x0038
            goto L_0x003e
        L_0x0028:
            java.util.ArrayList r7 = getCertificate(r7)
            r1 = 66
            if (r7 != 0) goto L_0x0033
            r3 = 88
            goto L_0x0035
        L_0x0033:
            r3 = 66
        L_0x0035:
            if (r3 == r1) goto L_0x0038
            goto L_0x003e
        L_0x0038:
            boolean r1 = r7.isEmpty()
            if (r1 == 0) goto L_0x00e9
        L_0x003e:
            java.lang.String r7 = getStaticVisaCertificateForSSHHandShake()
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            org.json.JSONArray r3 = new org.json.JSONArray     // Catch:{ JSONException -> 0x00d4 }
            r3.<init>(r7)     // Catch:{ JSONException -> 0x00d4 }
            int r7 = f663
            r4 = r7 ^ 41
            r5 = r7 & 41
            r4 = r4 | r5
            int r4 = r4 << r0
            r5 = r7 & -42
            int r7 = ~r7
            r7 = r7 & 41
            r7 = r7 | r5
            int r4 = r4 - r7
            int r7 = r4 % 128
            f662 = r7
            int r4 = r4 % 2
        L_0x0061:
            int r7 = r3.length()     // Catch:{ JSONException -> 0x00d4 }
            if (r2 >= r7) goto L_0x00c1
            net.one97.paytm.payments.visascp.network.model.VisaCertificateData r7 = new net.one97.paytm.payments.visascp.network.model.VisaCertificateData     // Catch:{ JSONException -> 0x00d4 }
            r7.<init>()     // Catch:{ JSONException -> 0x00d4 }
            org.json.JSONObject r4 = r3.getJSONObject(r2)     // Catch:{ JSONException -> 0x00d4 }
            java.lang.String r5 = "certificateKey"
            java.lang.String r5 = r4.optString(r5)     // Catch:{ JSONException -> 0x00d4 }
            r7.setCertificateKey(r5)     // Catch:{ JSONException -> 0x00d4 }
            java.lang.String r5 = "endDate"
            long r5 = r4.optLong(r5)     // Catch:{ JSONException -> 0x00d4 }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ JSONException -> 0x00d4 }
            r7.setEndDate(r5)     // Catch:{ JSONException -> 0x00d4 }
            java.lang.String r5 = "id"
            long r5 = r4.optLong(r5)     // Catch:{ JSONException -> 0x00d4 }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ JSONException -> 0x00d4 }
            r7.setId(r5)     // Catch:{ JSONException -> 0x00d4 }
            java.lang.String r5 = "startDate"
            long r4 = r4.optLong(r5)     // Catch:{ JSONException -> 0x00d4 }
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ JSONException -> 0x00d4 }
            r7.setStartDate(r4)     // Catch:{ JSONException -> 0x00d4 }
            r1.add(r7)     // Catch:{ JSONException -> 0x00d4 }
            r7 = r2 | 2
            int r7 = r7 << r0
            r2 = r2 ^ 2
            int r7 = r7 - r2
            r2 = r7 | -1
            int r2 = r2 << r0
            int r7 = ~r7
            int r2 = r2 - r7
            int r7 = f663
            r4 = r7 & 83
            r7 = r7 | 83
            r5 = r4 | r7
            int r5 = r5 << r0
            r7 = r7 ^ r4
            int r5 = r5 - r7
            int r7 = r5 % 128
            f662 = r7
            int r5 = r5 % 2
            goto L_0x0061
        L_0x00c1:
            int r7 = f663
            r2 = r7 & 99
            r7 = r7 ^ 99
            r7 = r7 | r2
            int r7 = -r7
            int r7 = -r7
            int r7 = ~r7
            int r2 = r2 - r7
            int r2 = r2 - r0
            int r7 = r2 % 128
            f662 = r7
            int r2 = r2 % 2
            goto L_0x00d8
        L_0x00d4:
            java.lang.String r7 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.LOG_TAG
            java.lang.String r7 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.EXCEPTION_MESSAGE
        L_0x00d8:
            int r7 = f662
            r2 = r7 & 7
            r7 = r7 ^ 7
            r7 = r7 | r2
            int r7 = ~r7
            int r2 = r2 - r7
            int r2 = r2 - r0
            int r7 = r2 % 128
            f663 = r7
            int r2 = r2 % 2
            return r1
        L_0x00e9:
            int r1 = f662
            r3 = r1 & 83
            r1 = r1 ^ 83
            r1 = r1 | r3
            r4 = r3 & r1
            r1 = r1 | r3
            int r4 = r4 + r1
            int r1 = r4 % 128
            f663 = r1
            int r4 = r4 % 2
            if (r4 != 0) goto L_0x00fd
            goto L_0x00fe
        L_0x00fd:
            r2 = 1
        L_0x00fe:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.payments.visascp.util.Utils.getVisaCertificateFromServer(android.content.Context):java.util.ArrayList");
    }
}
