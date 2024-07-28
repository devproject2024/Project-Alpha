package com.travel.utils;

import android.text.TextUtils;
import com.business.merchant_payments.common.utility.AppConstants;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public final class p {
    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1573925921:
                if (str.equals("travel-my-pass")) {
                    c2 = 3;
                    break;
                }
                break;
            case -1384638375:
                if (str.equals("travel-pass-details")) {
                    c2 = 2;
                    break;
                }
                break;
            case 682739243:
                if (str.equals("travelpass")) {
                    c2 = 0;
                    break;
                }
                break;
            case 2064966500:
                if (str.equals("travel-pass-about")) {
                    c2 = 1;
                    break;
                }
                break;
        }
        if (c2 == 0 || c2 == 1 || c2 == 2 || c2 == 3) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean b(java.lang.String r4) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x0093
            r0 = -1
            int r3 = r4.hashCode()
            switch(r3) {
                case -1871399148: goto L_0x0084;
                case -1493609548: goto L_0x0078;
                case -1015267906: goto L_0x006d;
                case -686394211: goto L_0x0062;
                case -507287662: goto L_0x0056;
                case -507210051: goto L_0x004b;
                case 167023366: goto L_0x0040;
                case 176324410: goto L_0x0035;
                case 530961629: goto L_0x002a;
                case 903206127: goto L_0x001e;
                case 1176719504: goto L_0x0012;
                default: goto L_0x0010;
            }
        L_0x0010:
            goto L_0x008f
        L_0x0012:
            java.lang.String r3 = "trainticketv2"
            boolean r4 = r4.equals(r3)
            if (r4 == 0) goto L_0x008f
            r4 = 1
            goto L_0x0090
        L_0x001e:
            java.lang.String r3 = "train-pnr"
            boolean r4 = r4.equals(r3)
            if (r4 == 0) goto L_0x008f
            r4 = 8
            goto L_0x0090
        L_0x002a:
            java.lang.String r3 = "train-search-result"
            boolean r4 = r4.equals(r3)
            if (r4 == 0) goto L_0x008f
            r4 = 4
            goto L_0x0090
        L_0x0035:
            java.lang.String r3 = "train-traveller"
            boolean r4 = r4.equals(r3)
            if (r4 == 0) goto L_0x008f
            r4 = 5
            goto L_0x0090
        L_0x0040:
            java.lang.String r3 = "track-train"
            boolean r4 = r4.equals(r3)
            if (r4 == 0) goto L_0x008f
            r4 = 7
            goto L_0x0090
        L_0x004b:
            java.lang.String r3 = "train-review"
            boolean r4 = r4.equals(r3)
            if (r4 == 0) goto L_0x008f
            r4 = 6
            goto L_0x0090
        L_0x0056:
            java.lang.String r3 = "train-resume"
            boolean r4 = r4.equals(r3)
            if (r4 == 0) goto L_0x008f
            r4 = 9
            goto L_0x0090
        L_0x0062:
            java.lang.String r3 = "train_order_summary_v2"
            boolean r4 = r4.equals(r3)
            if (r4 == 0) goto L_0x008f
            r4 = 3
            goto L_0x0090
        L_0x006d:
            java.lang.String r3 = "train_order_summary"
            boolean r4 = r4.equals(r3)
            if (r4 == 0) goto L_0x008f
            r4 = 2
            goto L_0x0090
        L_0x0078:
            java.lang.String r3 = "travel_metro"
            boolean r4 = r4.equals(r3)
            if (r4 == 0) goto L_0x008f
            r4 = 10
            goto L_0x0090
        L_0x0084:
            java.lang.String r3 = "trainticket"
            boolean r4 = r4.equals(r3)
            if (r4 == 0) goto L_0x008f
            r4 = 0
            goto L_0x0090
        L_0x008f:
            r4 = -1
        L_0x0090:
            switch(r4) {
                case 0: goto L_0x0094;
                case 1: goto L_0x0094;
                case 2: goto L_0x0094;
                case 3: goto L_0x0094;
                case 4: goto L_0x0094;
                case 5: goto L_0x0094;
                case 6: goto L_0x0094;
                case 7: goto L_0x0094;
                case 8: goto L_0x0094;
                case 9: goto L_0x0094;
                case 10: goto L_0x0094;
                default: goto L_0x0093;
            }
        L_0x0093:
            r1 = 0
        L_0x0094:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.utils.p.b(java.lang.String):boolean");
    }

    public static boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        char c2 = 65535;
        int hashCode = str.hashCode();
        if (hashCode != -1493609548) {
            if (hashCode == -312570305 && str.equals("travelmetro")) {
                c2 = 1;
            }
        } else if (str.equals("travel_metro")) {
            c2 = 0;
        }
        if (c2 == 0 || c2 == 1) {
            return true;
        }
        return false;
    }

    public static boolean d(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1565513625:
                if (str.equals("bustickets")) {
                    c2 = 2;
                    break;
                }
                break;
            case -1373988810:
                if (str.equals("bus_order_summary")) {
                    c2 = 3;
                    break;
                }
                break;
            case -881784436:
                if (str.equals("busticket")) {
                    c2 = 1;
                    break;
                }
                break;
            case 134087061:
                if (str.equals("bus-search")) {
                    c2 = 0;
                    break;
                }
                break;
        }
        if (c2 == 0 || c2 == 1 || c2 == 2 || c2 == 3) {
            return true;
        }
        return false;
    }

    public static boolean e(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        char c2 = 65535;
        if (str.hashCode() == 2128330677 && str.equals("internationalflights")) {
            c2 = 0;
        }
        if (c2 != 0) {
            return false;
        }
        return true;
    }

    public static boolean f(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        char c2 = 65535;
        int hashCode = str.hashCode();
        if (hashCode != -1298080900) {
            if (hashCode == -720274906 && str.equals("flight_order_summary")) {
                c2 = 1;
            }
        } else if (str.equals("flightticket")) {
            c2 = 0;
        }
        if (c2 == 0 || c2 == 1) {
            return true;
        }
        return false;
    }

    public static boolean g(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        char c2 = 65535;
        switch (str.hashCode()) {
            case -2044543567:
                if (str.equals("hotel-city-search")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1805176726:
                if (str.equals("hotel_order_summary")) {
                    c2 = 5;
                    break;
                }
                break;
            case -689634712:
                if (str.equals("hotel-listings")) {
                    c2 = 1;
                    break;
                }
                break;
            case -416630464:
                if (str.equals("hotel-booking")) {
                    c2 = 4;
                    break;
                }
                break;
            case 616230109:
                if (str.equals("hotel-results")) {
                    c2 = 2;
                    break;
                }
                break;
            case 1076405033:
                if (str.equals("hotel-details")) {
                    c2 = 3;
                    break;
                }
                break;
        }
        if (c2 == 0 || c2 == 1 || c2 == 2 || c2 == 3 || c2 == 4 || c2 == 5) {
            return true;
        }
        return false;
    }

    public static boolean h(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        char c2 = 65535;
        if (str.hashCode() == 785443125 && str.equals("citybus")) {
            c2 = 0;
        }
        if (c2 != 0) {
            return false;
        }
        return true;
    }

    public static boolean i(String str) {
        return a(str) || b(str) || d(str) || e(str) || f(str) || g(str);
    }

    public static String j(String str) {
        if (str == null || str.trim().equalsIgnoreCase("")) {
            return "";
        }
        try {
            DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getInstance(Locale.ENGLISH);
            decimalFormat.applyPattern(AppConstants.PRICE_PATTERN);
            return decimalFormat.format((double) Float.parseFloat(str));
        } catch (Exception unused) {
            return new DecimalFormat(AppConstants.PRICE_PATTERN).format((double) Float.parseFloat(str));
        }
    }
}
