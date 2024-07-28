package net.one97.paytm.utils;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.paytm.utility.q;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.paytmmall.clpartifact.utils.GAUtil;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.marketplace.a;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public final class c {
    public static CJRHomePageItem a(Context context, String str) {
        String str2;
        q.b("uri  :".concat(String.valueOf(str)));
        if (!str.startsWith("https")) {
            str2 = str;
        } else if (str.contains("paytmmall.com")) {
            String replace = str.replace("https://paytmmall.com/", "paytmmall://");
            str2 = replace.contains("-pdp") ? b(str) : (replace.contains("glpid") || replace.contains("bclpid") || replace.contains("/search") || replace.contains("llpid")) ? c(str) : replace.contains("clpid") ? d(str) : replace.contains("/shop/p/") ? e(str) : replace.contains("/shop/g/") ? f(str) : replace.contains("/shop/h/") ? g(str) : replace.contains("/shop/summary/") ? h(replace) : b(replace, str);
        } else if (str.contains("paytminsurance.co.in")) {
            String replace2 = str.replace("https://paytminsurance.co.in/", "paytmmp://");
            if (replace2.contains("/two-wheeler-insurance")) {
                str2 = "paytmmp://brokinginsurance?insurance_type=13";
            } else if (replace2.contains("/car-insurance")) {
                str2 = "paytmmp://brokinginsurance?insurance_type=9";
            } else if (replace2.contains("/term-life-insurance")) {
                str2 = "paytmmp://brokinginsurance?insurance_type=15";
            } else {
                str2 = replace2.contains("/health-insurance") ? "paytmmp://brokinginsurance?insurance_type=14" : "paytmmp://insurance_buy";
            }
        } else {
            String replace3 = str.replace("https://paytm.com/", "paytmmp://");
            q.b("finalUri  :".concat(String.valueOf(replace3)));
            if ("https://paytm.com/".equals(str)) {
                str2 = replace3;
            } else if (replace3.contains("/h/gift-cards")) {
                str2 = "paytmmp://giftcards";
            } else if (replace3.contains("/h/deals")) {
                str2 = "paytmmp://deals";
            } else if (replace3.contains("/p/")) {
                str2 = i(str);
            } else if (replace3.contains("/h/")) {
                str2 = j(str);
            } else {
                str2 = replace3.contains("/g/") ? k(str) : a(replace3, str);
            }
            if (!TextUtils.isEmpty(str)) {
                a(str, context);
            }
        }
        q.b("finalUri 1: ".concat(String.valueOf(str2)));
        a.a(context, l.c(str));
        return ac.a(context, str2);
    }

    public static String b(Context context, String str) {
        String str2;
        q.b("uri  :".concat(String.valueOf(str)));
        if (str.startsWith("https")) {
            if (str.contains("paytmmall.com")) {
                String replace = str.replace("https://paytmmall.com/", "paytmmall://");
                if (replace.contains("-pdp")) {
                    str = b(str);
                } else if (replace.contains("glpid") || replace.contains("bclpid") || replace.contains("/search") || replace.contains("llpid")) {
                    str = c(str);
                } else if (replace.contains("clpid")) {
                    str = d(str);
                } else if (replace.contains("/shop/p/")) {
                    str = e(str);
                } else if (replace.contains("/shop/g/")) {
                    str = f(str);
                } else if (replace.contains("/shop/h/")) {
                    str = g(str);
                } else if (replace.contains("/shop/summary/")) {
                    str = h(replace);
                } else {
                    str = b(replace, str);
                }
            } else {
                String replace2 = str.replace("https://paytm.com/", "paytmmp://");
                q.b("finalUri  :".concat(String.valueOf(replace2)));
                if ("https://paytm.com/".equals(str)) {
                    str2 = replace2;
                } else if (replace2.contains("/h/gift-cards")) {
                    str2 = "paytmmp://giftcards";
                } else if (replace2.contains("/h/deals")) {
                    str2 = "paytmmp://deals";
                } else if (replace2.contains("/p/")) {
                    str2 = i(str);
                } else if (replace2.contains("/h/")) {
                    str2 = j(str);
                } else {
                    str2 = replace2.contains("/g/") ? k(str) : a(replace2, str);
                }
                if (!TextUtils.isEmpty(str)) {
                    a(str, context);
                }
                str = str2;
            }
        }
        q.b("finalUri 1: ".concat(String.valueOf(str)));
        return str;
    }

    private static String a(String str, String str2) {
        if (!str.startsWith("paytmmp://")) {
            return str;
        }
        String substring = str.substring(10);
        String str3 = null;
        if (substring.contains("?")) {
            int indexOf = substring.indexOf("?");
            String substring2 = substring.substring(indexOf, substring.length());
            substring = substring.substring(0, indexOf);
            str3 = substring2;
        }
        return !TextUtils.isEmpty(substring) ? a(str, substring, str2, str3) : str;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String a(java.lang.String r12, java.lang.String r13, java.lang.String r14, java.lang.String r15) {
        /*
            java.lang.String r0 = "/"
            java.lang.String[] r0 = r13.split(r0)
            r1 = 0
            r2 = r0[r1]
            int r3 = r0.length
            r4 = 0
            r5 = 1
            if (r3 <= r5) goto L_0x0011
            r3 = r0[r5]
            goto L_0x0012
        L_0x0011:
            r3 = r4
        L_0x0012:
            int r6 = r0.length
            r7 = 2
            if (r6 <= r7) goto L_0x0019
            r6 = r0[r7]
            goto L_0x001a
        L_0x0019:
            r6 = r4
        L_0x001a:
            int r8 = r0.length
            r9 = 3
            if (r8 <= r9) goto L_0x0020
            r4 = r0[r9]
        L_0x0020:
            r8 = -1
            int r10 = r2.hashCode()
            java.lang.String r11 = "events"
            switch(r10) {
                case -2028349116: goto L_0x01ee;
                case -2011152049: goto L_0x01e3;
                case -1968982256: goto L_0x01d8;
                case -1961950516: goto L_0x01cd;
                case -1764389124: goto L_0x01c2;
                case -1499089892: goto L_0x01b7;
                case -1370373854: goto L_0x01ac;
                case -1291329255: goto L_0x01a3;
                case -1281671806: goto L_0x0198;
                case -1211468481: goto L_0x018d;
                case -1136202100: goto L_0x0181;
                case -1111774296: goto L_0x0175;
                case -1092399203: goto L_0x0169;
                case -1068259517: goto L_0x015e;
                case -971152375: goto L_0x0152;
                case -966573022: goto L_0x0147;
                case -822288586: goto L_0x013b;
                case -806191449: goto L_0x012f;
                case -771814909: goto L_0x0124;
                case -669291125: goto L_0x0118;
                case -587781963: goto L_0x010d;
                case -455638860: goto L_0x0101;
                case -448954509: goto L_0x00f5;
                case -290756696: goto L_0x00e9;
                case 3046161: goto L_0x00dd;
                case 3235931: goto L_0x00d1;
                case 143805786: goto L_0x00c5;
                case 295629974: goto L_0x00b9;
                case 539402111: goto L_0x00ad;
                case 582247662: goto L_0x00a1;
                case 666179667: goto L_0x0095;
                case 757836652: goto L_0x008a;
                case 813644701: goto L_0x007e;
                case 820276314: goto L_0x0072;
                case 865392794: goto L_0x0067;
                case 1112842872: goto L_0x005b;
                case 1115243790: goto L_0x004f;
                case 1434631203: goto L_0x0043;
                case 1480941877: goto L_0x0037;
                case 2050694846: goto L_0x002c;
                default: goto L_0x002a;
            }
        L_0x002a:
            goto L_0x01f9
        L_0x002c:
            java.lang.String r7 = "credit-score"
            boolean r2 = r2.equals(r7)
            if (r2 == 0) goto L_0x01f9
            r2 = 0
            goto L_0x01fa
        L_0x0037:
            java.lang.String r7 = "cabletv-recharge"
            boolean r2 = r2.equals(r7)
            if (r2 == 0) goto L_0x01f9
            r2 = 21
            goto L_0x01fa
        L_0x0043:
            java.lang.String r7 = "settings"
            boolean r2 = r2.equals(r7)
            if (r2 == 0) goto L_0x01f9
            r2 = 37
            goto L_0x01fa
        L_0x004f:
            java.lang.String r7 = "devotion"
            boolean r2 = r2.equals(r7)
            if (r2 == 0) goto L_0x01f9
            r2 = 24
            goto L_0x01fa
        L_0x005b:
            java.lang.String r7 = "digitalgold"
            boolean r2 = r2.equals(r7)
            if (r2 == 0) goto L_0x01f9
            r2 = 32
            goto L_0x01fa
        L_0x0067:
            java.lang.String r7 = "bus-tickets"
            boolean r2 = r2.equals(r7)
            if (r2 == 0) goto L_0x01f9
            r2 = 3
            goto L_0x01fa
        L_0x0072:
            java.lang.String r7 = "paytmwallet"
            boolean r2 = r2.equals(r7)
            if (r2 == 0) goto L_0x01f9
            r2 = 38
            goto L_0x01fa
        L_0x007e:
            java.lang.String r7 = "loan-emi-payment"
            boolean r2 = r2.equals(r7)
            if (r2 == 0) goto L_0x01f9
            r2 = 35
            goto L_0x01fa
        L_0x008a:
            java.lang.String r7 = "postpaid"
            boolean r2 = r2.equals(r7)
            if (r2 == 0) goto L_0x01f9
            r2 = 1
            goto L_0x01fa
        L_0x0095:
            java.lang.String r7 = "buy-insurance"
            boolean r2 = r2.equals(r7)
            if (r2 == 0) goto L_0x01f9
            r2 = 39
            goto L_0x01fa
        L_0x00a1:
            java.lang.String r7 = "landline-bill-payment"
            boolean r2 = r2.equals(r7)
            if (r2 == 0) goto L_0x01f9
            r2 = 15
            goto L_0x01fa
        L_0x00ad:
            java.lang.String r7 = "cabletv"
            boolean r2 = r2.equals(r7)
            if (r2 == 0) goto L_0x01f9
            r2 = 22
            goto L_0x01fa
        L_0x00b9:
            java.lang.String r7 = "broadband-bill-payment"
            boolean r2 = r2.equals(r7)
            if (r2 == 0) goto L_0x01f9
            r2 = 16
            goto L_0x01fa
        L_0x00c5:
            java.lang.String r7 = "datacard-recharge"
            boolean r2 = r2.equals(r7)
            if (r2 == 0) goto L_0x01f9
            r2 = 11
            goto L_0x01fa
        L_0x00d1:
            java.lang.String r7 = "imax"
            boolean r2 = r2.equals(r7)
            if (r2 == 0) goto L_0x01f9
            r2 = 30
            goto L_0x01fa
        L_0x00dd:
            java.lang.String r7 = "care"
            boolean r2 = r2.equals(r7)
            if (r2 == 0) goto L_0x01f9
            r2 = 36
            goto L_0x01fa
        L_0x00e9:
            java.lang.String r7 = "education"
            boolean r2 = r2.equals(r7)
            if (r2 == 0) goto L_0x01f9
            r2 = 29
            goto L_0x01fa
        L_0x00f5:
            java.lang.String r7 = "datacard-bill-payment"
            boolean r2 = r2.equals(r7)
            if (r2 == 0) goto L_0x01f9
            r2 = 12
            goto L_0x01fa
        L_0x0101:
            java.lang.String r7 = "gas-bill-payment"
            boolean r2 = r2.equals(r7)
            if (r2 == 0) goto L_0x01f9
            r2 = 18
            goto L_0x01fa
        L_0x010d:
            java.lang.String r9 = "amusement-parks"
            boolean r2 = r2.equals(r9)
            if (r2 == 0) goto L_0x01f9
            r2 = 2
            goto L_0x01fa
        L_0x0118:
            java.lang.String r7 = "mobile-bill-payment"
            boolean r2 = r2.equals(r7)
            if (r2 == 0) goto L_0x01f9
            r2 = 10
            goto L_0x01fa
        L_0x0124:
            java.lang.String r7 = "flights"
            boolean r2 = r2.equals(r7)
            if (r2 == 0) goto L_0x01f9
            r2 = 4
            goto L_0x01fa
        L_0x012f:
            java.lang.String r7 = "recharge"
            boolean r2 = r2.equals(r7)
            if (r2 == 0) goto L_0x01f9
            r2 = 9
            goto L_0x01fa
        L_0x013b:
            java.lang.String r7 = "water-bill-payment"
            boolean r2 = r2.equals(r7)
            if (r2 == 0) goto L_0x01f9
            r2 = 19
            goto L_0x01fa
        L_0x0147:
            java.lang.String r7 = "train-tickets"
            boolean r2 = r2.equals(r7)
            if (r2 == 0) goto L_0x01f9
            r2 = 5
            goto L_0x01fa
        L_0x0152:
            java.lang.String r7 = "credit-card-bill-payment"
            boolean r2 = r2.equals(r7)
            if (r2 == 0) goto L_0x01f9
            r2 = 25
            goto L_0x01fa
        L_0x015e:
            java.lang.String r7 = "movies"
            boolean r2 = r2.equals(r7)
            if (r2 == 0) goto L_0x01f9
            r2 = 7
            goto L_0x01fa
        L_0x0169:
            java.lang.String r7 = "insurance-premium-payment"
            boolean r2 = r2.equals(r7)
            if (r2 == 0) goto L_0x01f9
            r2 = 28
            goto L_0x01fa
        L_0x0175:
            java.lang.String r7 = "municipal-payments"
            boolean r2 = r2.equals(r7)
            if (r2 == 0) goto L_0x01f9
            r2 = 26
            goto L_0x01fa
        L_0x0181:
            java.lang.String r7 = "google-play-gift-card-recharge"
            boolean r2 = r2.equals(r7)
            if (r2 == 0) goto L_0x01f9
            r2 = 33
            goto L_0x01fa
        L_0x018d:
            java.lang.String r7 = "hotels"
            boolean r2 = r2.equals(r7)
            if (r2 == 0) goto L_0x01f9
            r2 = 6
            goto L_0x01fa
        L_0x0198:
            java.lang.String r7 = "fastag"
            boolean r2 = r2.equals(r7)
            if (r2 == 0) goto L_0x01f9
            r2 = 31
            goto L_0x01fa
        L_0x01a3:
            boolean r2 = r2.equals(r11)
            if (r2 == 0) goto L_0x01f9
            r2 = 8
            goto L_0x01fa
        L_0x01ac:
            java.lang.String r7 = "financial-services"
            boolean r2 = r2.equals(r7)
            if (r2 == 0) goto L_0x01f9
            r2 = 27
            goto L_0x01fa
        L_0x01b7:
            java.lang.String r7 = "electricity-bill-payment"
            boolean r2 = r2.equals(r7)
            if (r2 == 0) goto L_0x01f9
            r2 = 13
            goto L_0x01fa
        L_0x01c2:
            java.lang.String r7 = "dth-recharge"
            boolean r2 = r2.equals(r7)
            if (r2 == 0) goto L_0x01f9
            r2 = 20
            goto L_0x01fa
        L_0x01cd:
            java.lang.String r7 = "toll-tag-recharge"
            boolean r2 = r2.equals(r7)
            if (r2 == 0) goto L_0x01f9
            r2 = 23
            goto L_0x01fa
        L_0x01d8:
            java.lang.String r7 = "metro-card-recharge"
            boolean r2 = r2.equals(r7)
            if (r2 == 0) goto L_0x01f9
            r2 = 17
            goto L_0x01fa
        L_0x01e3:
            java.lang.String r7 = "apartments-electricity-recharge"
            boolean r2 = r2.equals(r7)
            if (r2 == 0) goto L_0x01f9
            r2 = 14
            goto L_0x01fa
        L_0x01ee:
            java.lang.String r7 = "challan-bill-payment"
            boolean r2 = r2.equals(r7)
            if (r2 == 0) goto L_0x01f9
            r2 = 34
            goto L_0x01fa
        L_0x01f9:
            r2 = -1
        L_0x01fa:
            switch(r2) {
                case 0: goto L_0x0277;
                case 1: goto L_0x0274;
                case 2: goto L_0x0271;
                case 3: goto L_0x026c;
                case 4: goto L_0x0267;
                case 5: goto L_0x0262;
                case 6: goto L_0x025f;
                case 7: goto L_0x025c;
                case 8: goto L_0x0279;
                case 9: goto L_0x0259;
                case 10: goto L_0x0256;
                case 11: goto L_0x0253;
                case 12: goto L_0x0253;
                case 13: goto L_0x0250;
                case 14: goto L_0x024d;
                case 15: goto L_0x024a;
                case 16: goto L_0x024a;
                case 17: goto L_0x0247;
                case 18: goto L_0x0244;
                case 19: goto L_0x0241;
                case 20: goto L_0x023e;
                case 21: goto L_0x023b;
                case 22: goto L_0x023b;
                case 23: goto L_0x0238;
                case 24: goto L_0x0235;
                case 25: goto L_0x0232;
                case 26: goto L_0x022f;
                case 27: goto L_0x022c;
                case 28: goto L_0x022c;
                case 29: goto L_0x0229;
                case 30: goto L_0x0226;
                case 31: goto L_0x0222;
                case 32: goto L_0x021e;
                case 33: goto L_0x021a;
                case 34: goto L_0x0216;
                case 35: goto L_0x0212;
                case 36: goto L_0x020e;
                case 37: goto L_0x020a;
                case 38: goto L_0x0206;
                case 39: goto L_0x0202;
                default: goto L_0x01fd;
            }
        L_0x01fd:
            java.lang.String r12 = a(r14)
            return r12
        L_0x0202:
            java.lang.String r11 = "insurance_buy"
            goto L_0x0279
        L_0x0206:
            java.lang.String r11 = "cash_wallet?featuretype=add_money"
            goto L_0x0279
        L_0x020a:
            java.lang.String r11 = "myprofile"
            goto L_0x0279
        L_0x020e:
            java.lang.String r11 = "contactus"
            goto L_0x0279
        L_0x0212:
            java.lang.String r11 = "loan?url=https://catalog.paytm.com/v2/mobile/getproductlist/37217"
            goto L_0x0279
        L_0x0216:
            java.lang.String r11 = "challan?url=https://catalog.paytm.com/v2/mobile/getproductlist/104154"
            goto L_0x0279
        L_0x021a:
            java.lang.String r11 = "utility?url=https://catalog.paytm.com/v1/mobile/getproductlist/99932"
            goto L_0x0279
        L_0x021e:
            java.lang.String r11 = "digital-gold"
            goto L_0x0279
        L_0x0222:
            java.lang.String r11 = "fastag_toll"
            goto L_0x0279
        L_0x0226:
            java.lang.String r11 = "imaxpage"
            goto L_0x0279
        L_0x0229:
            java.lang.String r11 = "utility?url=https://catalog.paytm.com/v1/mobile/getproductlist/46007"
            goto L_0x0279
        L_0x022c:
            java.lang.String r11 = "utility?url=https://catalog.paytm.com/v1/mobile/getproductlist/64739"
            goto L_0x0279
        L_0x022f:
            java.lang.String r11 = "utility?url=https://catalog.paytm.com/v2/mobile/getproductlist/107730"
            goto L_0x0279
        L_0x0232:
            java.lang.String r11 = "utility?url=https://catalog.paytm.com/v2/mobile/getproductlist/156705"
            goto L_0x0279
        L_0x0235:
            java.lang.String r11 = "utility?url=https://catalog.paytm.com/v2/mobile/getproductlist/127781"
            goto L_0x0279
        L_0x0238:
            java.lang.String r11 = "utility?url=https://catalog.paytm.com/v1/mobile/getproductlist/100253"
            goto L_0x0279
        L_0x023b:
            java.lang.String r11 = "utility?url=https://catalog.paytm.com/v2/mobile/getproductlist/123988"
            goto L_0x0279
        L_0x023e:
            java.lang.String r11 = "dth?url=https://catalog.paytm.com/v1/mobile/DTH/18"
            goto L_0x0279
        L_0x0241:
            java.lang.String r11 = "utility?url=https://catalog.paytm.com/v1/mobile/getproductlist/68869"
            goto L_0x0279
        L_0x0244:
            java.lang.String r11 = "utility?url=https://catalog.paytm.com/v1/mobile/getproductlist/78640"
            goto L_0x0279
        L_0x0247:
            java.lang.String r11 = "utility?url=https://catalog.paytm.com/v1/mobile/getproductlist/77409"
            goto L_0x0279
        L_0x024a:
            java.lang.String r11 = "utility?url=https://catalog.paytm.com/v1/mobile/getproductlist/75505"
            goto L_0x0279
        L_0x024d:
            java.lang.String r11 = "utility?url=https://catalog.paytm.com/v2/mobile/getproductlist/101950"
            goto L_0x0279
        L_0x0250:
            java.lang.String r11 = "utility?url=https://catalog.paytm.com/v1/mobile/getproductlist/26"
            goto L_0x0279
        L_0x0253:
            java.lang.String r11 = "datacard-postpaid?url=https://catalog.paytm.com/v1/mobile/datacard-postpaid/23"
            goto L_0x0279
        L_0x0256:
            java.lang.String r11 = "mobile-postpaid"
            goto L_0x0279
        L_0x0259:
            java.lang.String r11 = "mobile_prepaid"
            goto L_0x0279
        L_0x025c:
            java.lang.String r11 = "movietickets"
            goto L_0x0279
        L_0x025f:
            java.lang.String r11 = "hotel-booking"
            goto L_0x0279
        L_0x0262:
            java.lang.String r12 = b(r12, r13, r14, r15)
            return r12
        L_0x0267:
            java.lang.String r12 = a((java.lang.String) r12, (java.lang.String[]) r0, (java.lang.String) r13)
            return r12
        L_0x026c:
            java.lang.String r12 = b(r12, r0, r13)
            return r12
        L_0x0271:
            java.lang.String r11 = "amusement"
            goto L_0x0279
        L_0x0274:
            java.lang.String r11 = "paytm-postpaid"
            goto L_0x0279
        L_0x0277:
            java.lang.String r11 = "fs-cir"
        L_0x0279:
            boolean r0 = android.text.TextUtils.isEmpty(r11)
            if (r0 != 0) goto L_0x0288
            java.lang.String r0 = "?"
            boolean r0 = r11.contains(r0)
            if (r0 == 0) goto L_0x0288
            r1 = 1
        L_0x0288:
            boolean r0 = android.text.TextUtils.isEmpty(r15)
            java.lang.String r2 = ""
            if (r0 == 0) goto L_0x0291
            r15 = r2
        L_0x0291:
            java.lang.String r12 = r12.replace(r15, r2)
            java.lang.String r12 = r12.replaceFirst(r13, r11)
            java.lang.String r13 = "isAppLink"
            java.lang.String r0 = "1"
            java.lang.String r13 = a((boolean) r1, (java.lang.String) r15, (java.lang.String) r13, (java.lang.String) r0)
            boolean r15 = android.text.TextUtils.isEmpty(r3)
            if (r15 != 0) goto L_0x02ad
            java.lang.String r15 = "app_link_level_1"
            java.lang.String r13 = a((boolean) r1, (java.lang.String) r13, (java.lang.String) r15, (java.lang.String) r3)
        L_0x02ad:
            boolean r15 = android.text.TextUtils.isEmpty(r6)
            if (r15 != 0) goto L_0x02b9
            java.lang.String r15 = "app_link_level_2"
            java.lang.String r13 = a((boolean) r1, (java.lang.String) r13, (java.lang.String) r15, (java.lang.String) r6)
        L_0x02b9:
            boolean r15 = android.text.TextUtils.isEmpty(r4)
            if (r15 != 0) goto L_0x02c5
            java.lang.String r15 = "app_link_level_3"
            java.lang.String r13 = a((boolean) r1, (java.lang.String) r13, (java.lang.String) r15, (java.lang.String) r4)
        L_0x02c5:
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            r15.append(r12)
            r15.append(r13)
            java.lang.String r12 = r15.toString()
            boolean r13 = android.text.TextUtils.isEmpty(r12)
            if (r13 != 0) goto L_0x02db
            return r12
        L_0x02db:
            java.lang.String r12 = a(r14)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.utils.c.a(java.lang.String, java.lang.String, java.lang.String, java.lang.String):java.lang.String");
    }

    private static String a(String str, String[] strArr, String str2) {
        String str3;
        String str4;
        if (strArr == null || strArr.length <= 1) {
            if (strArr == null || strArr.length != 1) {
                return null;
            }
            return "paytmmp://flightticket";
        } else if (strArr.length < 2 || !strArr[1].contains("to") || !strArr[1].contains("flight-tickets")) {
            return "paytmmp://embed?url=" + "https://paytm.com/" + str2 + "?isAppLink=true";
        } else {
            if (strArr[1].contains("-from-")) {
                str3 = strArr[1].substring(strArr[1].indexOf("from-") + 5, strArr[1].indexOf("-to")).trim();
                str4 = strArr[1].substring(strArr[1].indexOf("to-") + 3, strArr[1].length()).trim();
            } else {
                str3 = strArr[1].substring(0, strArr[1].indexOf("-to")).trim();
                str4 = strArr[1].substring(strArr[1].indexOf("-to") + 4, strArr[1].indexOf("-flight")).trim();
            }
            String a2 = a(a(a(a(a(a(a("flightticket" + a("", "url", "https://paytm.com/flight-ticket"), "source_city_name", str3.substring(0, 1).toUpperCase() + str3.substring(1)), "source_city_short_name", ""), "destination_city_name", str4.substring(0, 1).toUpperCase() + str4.substring(1)), "destination_city_short_name", ""), "flight_class", "Economy"), "flight_trip_type", "one_way"), "flight_depart_date", a());
            return str.replaceFirst(strArr[0], a2) + "?isAppLink=true";
        }
    }

    private static String b(String str, String[] strArr, String str2) {
        String str3;
        String str4;
        String str5;
        String str6;
        String[] strArr2 = strArr;
        if (strArr2 != null && strArr2.length > 1) {
            if (strArr2[1].equalsIgnoreCase("search")) {
                if (strArr2.length >= 3) {
                    str4 = strArr2[2];
                } else {
                    str4 = "";
                }
                if (strArr2.length >= 4) {
                    str5 = strArr2[3];
                } else {
                    str5 = "";
                }
                if (strArr2.length >= 5) {
                    str6 = strArr2[4];
                } else {
                    str6 = "";
                }
                str3 = a(a(a(a("busticket" + a("", "source_city_name", str4), "source_city_short_name", str4.toLowerCase()), "destination_city_name", str5), "destination_city_short_name", str5.toLowerCase()), CJRGiftCardUserInputField.FIELD_TYPE_CALENDAR, str6);
            } else if (strArr2[1].contains("-to") && strArr2[1].contains("-booking")) {
                String substring = strArr2[1].substring(0, strArr2[1].indexOf("-to"));
                String substring2 = strArr2[1].substring(strArr2[1].indexOf("-to") + 4, strArr2[1].indexOf("-booking"));
                StringBuilder sb = new StringBuilder("busticket");
                sb.append(a("", "source_city_name", substring.substring(0, 1).toUpperCase() + substring.substring(1)));
                str3 = a(a(a(a(a(sb.toString(), "source_city_short_name", substring.substring(0, 1).toUpperCase() + substring.substring(1)), "destination_city_name", substring2.substring(0, 1).toUpperCase() + substring2.substring(1)), "destination_city_short_name", substring2.substring(0, 1).toUpperCase() + substring2.substring(1)), CJRGiftCardUserInputField.FIELD_TYPE_CALENDAR, a()), "isApplink", "true");
            } else if (!strArr2[0].contains("bus-tickets") || !strArr2[1].contains("feedback")) {
                return "paytmmp://embed?url=" + "https://paytm.com/" + str2 + "?isAppLink=true";
            } else {
                Uri parse = Uri.parse(str);
                str3 = ((("busrating?rating=" + parse.getQueryParameter("rating")) + "&secret=" + parse.getQueryParameter("secret")) + "&channel=" + parse.getQueryParameter("channel")) + "&versionidentifier=" + parse.getQueryParameter("versionidentifier");
            }
            return str.replaceFirst(strArr2[0], str3);
        } else if (strArr2 == null || strArr2.length != 1) {
            return null;
        } else {
            return "paytmmp://busticket";
        }
    }

    private static String a(String str, String str2, String str3) {
        String str4 = "?";
        if (str.contains(str4)) {
            str4 = AppConstants.AND_SIGN;
        }
        return str.concat(str4).concat(str2).concat("=").concat(str3);
    }

    private static String a(String str) {
        return "paytmmp://embed?url=".concat(String.valueOf(str));
    }

    private static String b(String str) {
        return "paytmmall://product?url=".concat(String.valueOf(str.replace("paytmmall.com/", "catalog.paytm.com/")));
    }

    private static String c(String str) {
        String str2;
        if (str.contains("/search")) {
            net.one97.paytm.j.c.a();
            str2 = str.replace("https://paytmmall.com/shop/search", net.one97.paytm.j.c.b()).replace("?q=", "?userQuery=");
        } else {
            str2 = str.replace("paytmmall.com/", c() + "/");
        }
        return "paytmmall://grid?url=".concat(String.valueOf(str2));
    }

    private static String d(String str) {
        return "paytmmall://homepage?url=".concat(String.valueOf(str.replace("paytmmall.com/", b() + "/")));
    }

    private static String e(String str) {
        return "paytmmall://product?url=".concat(String.valueOf(str.replace("paytmmall.com/shop", "catalog.paytm.com/v1")));
    }

    private static String f(String str) {
        return "paytmmall://grid?url=".concat(String.valueOf(str.replace("paytmmall.com/shop", c() + "/v1")));
    }

    private static String g(String str) {
        return "paytmmall://homepage?url=".concat(String.valueOf(str.replace("paytmmall.com/shop", b() + "/v1")));
    }

    private static String h(String str) {
        StringBuilder sb = new StringBuilder("paytmmall://mpordersummary?url=");
        net.one97.paytm.j.c.a();
        sb.append(net.one97.paytm.j.c.e());
        String sb2 = sb.toString();
        return sb2 + str.substring(str.lastIndexOf("/") + 1);
    }

    private static String b(String str, String str2) {
        if (!TextUtils.isEmpty(str2) && str2.equalsIgnoreCase("https://paytmmall.com/")) {
            return "paytmmall://";
        }
        if (str.contains("care/ticket")) {
            return str.replace("care/ticket", "contactus");
        }
        if (str.contains("care")) {
            return str.replace("care", "contactus");
        }
        if (str.contains("settings")) {
            return str.replace("settings", "myprofile");
        }
        if (str.contains("myorders")) {
            return str.replace("myorders", CLPConstants.CONFIG_KEY_MY_ORDERS);
        }
        String concat = "paytmmall://embed?url=".concat(String.valueOf(str2));
        try {
            URL url = new URL(str2);
            String host = url.getHost();
            String path = url.getPath();
            if (!"paytmmall.com".equalsIgnoreCase(host)) {
                return concat;
            }
            if (TextUtils.isEmpty(path) || "/".equalsIgnoreCase(path)) {
                return "paytmmp://mall";
            }
            return concat;
        } catch (Exception e2) {
            q.b(e2.getMessage());
            return concat;
        }
    }

    private static String i(String str) {
        return "paytmmp://product?url=".concat(String.valueOf(str.replace("paytm.com/shop/p", "catalog.paytm.com/v1/p")));
    }

    private static String j(String str) {
        return "paytmmp://homepage?url=".concat(String.valueOf(str.replace("paytm.com/shop/h", b() + "/v2/h")));
    }

    private static String k(String str) {
        return "paytmmp://grid?url=".concat(String.valueOf(str.replace("paytm.com/shop/g", c() + "/v1/g")));
    }

    private static String a() {
        Calendar instance = Calendar.getInstance();
        instance.add(6, 1);
        return new SimpleDateFormat("dd MMM yyyy").format(instance.getTime());
    }

    private static String b() {
        net.one97.paytm.j.c.a();
        String Z = net.one97.paytm.j.c.Z();
        return TextUtils.isEmpty(Z) ? "storefront.paytm.com" : Z;
    }

    private static String c() {
        net.one97.paytm.j.c.a();
        String aa = net.one97.paytm.j.c.aa();
        return TextUtils.isEmpty(aa) ? "middleware.paytmmall.com" : aa;
    }

    private static void a(String str, Context context) {
        try {
            if (!TextUtils.isEmpty(str)) {
                String replace = str.replace("https://paytm.com/", "").replace("/", "-");
                net.one97.paytm.j.a.a();
                HashMap hashMap = new HashMap();
                hashMap.put("event_category", "applink");
                hashMap.put("event_action", "applink_open");
                hashMap.put("event_label", replace);
                hashMap.put("user_id", com.paytm.utility.a.a(context));
                hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, replace);
                hashMap.put("vertical_name", replace);
                net.one97.paytm.j.a.b(GAUtil.CUSTOM_EVENT, (Map<String, Object>) hashMap, context);
            }
        } catch (Exception unused) {
        }
    }

    private static String b(String str, String str2, String str3, String str4) {
        String[] split = str2.split("/");
        if (TextUtils.isEmpty(str4)) {
            str4 = "";
        }
        String replaceFirst = str.replace(str4, "").replaceFirst(str2, "trainticket");
        if (split.length > 1) {
            str4 = str4.concat(c(split[1], "app_link_level_1"));
        }
        if (split.length > 2) {
            str4 = str4.concat(c(split[2], "app_link_level_2"));
        }
        String str5 = replaceFirst + str4;
        if (!TextUtils.isEmpty(str5)) {
            return str5;
        }
        return a(str3);
    }

    private static String c(String str, String str2) {
        if (str.equalsIgnoreCase("pnr-status")) {
            return a("", "landing", "pnr_status");
        }
        if (str.equalsIgnoreCase("train-running-status")) {
            return a("", "landing", "live_train_status");
        }
        return a("", str2, str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
        if (r2.contains(r1) != false) goto L_0x000a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String a(boolean r1, java.lang.String r2, java.lang.String r3, java.lang.String r4) {
        /*
            if (r1 != 0) goto L_0x000a
            java.lang.String r1 = "?"
            boolean r0 = r2.contains(r1)
            if (r0 == 0) goto L_0x000c
        L_0x000a:
            java.lang.String r1 = "&"
        L_0x000c:
            java.lang.String r1 = r2.concat(r1)
            java.lang.String r1 = r1.concat(r3)
            java.lang.String r2 = "="
            java.lang.String r1 = r1.concat(r2)
            java.lang.String r1 = r1.concat(r4)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.utils.c.a(boolean, java.lang.String, java.lang.String, java.lang.String):java.lang.String");
    }
}
