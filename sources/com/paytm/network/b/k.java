package com.paytm.network.b;

import android.text.TextUtils;
import com.paytm.utility.q;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.net.URLEncoder;
import org.json.JSONArray;

public class k {

    /* renamed from: a  reason: collision with root package name */
    public static String[] f42900a = new String[0];

    /* renamed from: b  reason: collision with root package name */
    public static String[] f42901b = {"trust.paytm.in", "https://catalog.paytm.com/v1/mobile/product/"};

    /* renamed from: c  reason: collision with root package name */
    public static JSONArray f42902c;

    /* renamed from: d  reason: collision with root package name */
    public static JSONArray f42903d;

    /* renamed from: e  reason: collision with root package name */
    private static String f42904e = k.class.getSimpleName();

    private static String c(String str) {
        if (str == null || str.contains("&site_id=")) {
            return str;
        }
        try {
            String str2 = i.f42891b;
            String str3 = i.f42892c;
            if (str2 != null) {
                if (str.contains("?")) {
                    str = str + "&child_site_id=" + URLEncoder.encode(str2, AppConstants.UTF_8);
                } else {
                    str = str + "&child_site_id=".replace(AppConstants.AND_SIGN, "?") + URLEncoder.encode(str2, AppConstants.UTF_8);
                }
            }
            if (str3 == null) {
                return str;
            }
            return str + "&site_id=" + URLEncoder.encode(str3, AppConstants.UTF_8);
        } catch (Exception e2) {
            q.b(e2.getMessage());
            return str;
        }
    }

    public static String a(String str, String... strArr) {
        String str2;
        int indexOf = str.indexOf("?");
        boolean z = true;
        boolean z2 = indexOf != -1;
        if (z2) {
            str2 = str.substring(0, indexOf);
            str = str.substring(indexOf + 1);
        } else {
            str2 = null;
        }
        String str3 = str;
        for (int i2 = 0; i2 < 6; i2++) {
            String str4 = strArr[i2] + "=[^&]*?";
            str3 = str3.replaceAll("(&" + str4 + "(?=(&|$))|^" + str4 + "(&|$))", "");
        }
        if (!z2) {
            return str3;
        }
        if (str3 != null && !str3.equals("")) {
            z = false;
        }
        if (!z) {
            str2 = str2 + "?" + str3;
        }
        return str2;
    }

    public static boolean b(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("https://securegw.paytm.in");
    }

    public static String a(String str) {
        if (str == null) {
            return null;
        }
        String[] strArr = f42901b;
        int i2 = 0;
        if (strArr.length > 0) {
            for (String contains : strArr) {
                if (str.contains(contains)) {
                    return str;
                }
            }
        }
        String[] strArr2 = f42900a;
        if (strArr2.length > 0) {
            int length = strArr2.length;
            while (i2 < length) {
                if (!str.contains(strArr2[i2])) {
                    i2++;
                }
            }
            return str;
        }
        return c(str);
    }
}
