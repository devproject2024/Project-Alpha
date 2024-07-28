package com.alipay.mobile.rome.syncsdk.e;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.wireless.security.b.b;
import com.alibaba.wireless.security.b.c;
import com.alibaba.wireless.security.b.d;
import com.alibaba.wireless.security.b.k.a;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.HashMap;
import java.util.StringTokenizer;

public final class l {
    public static String[] a(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, AppConstants.COMMA);
        String[] strArr = new String[stringTokenizer.countTokens()];
        int i2 = 0;
        while (stringTokenizer.hasMoreTokens()) {
            strArr[i2] = stringTokenizer.nextToken();
            i2++;
        }
        return strArr;
    }

    public static boolean a(String[] strArr, String str) {
        for (String equals : strArr) {
            if (TextUtils.equals(str, equals)) {
                return true;
            }
        }
        return false;
    }

    public static String a(Context context, String str, String str2) {
        a aVar;
        try {
            c a2 = c.a(context);
            if (a2 == null || (aVar = (a) a2.a()) == null) {
                return "";
            }
            HashMap hashMap = new HashMap();
            hashMap.put("INPUT", str2);
            d dVar = new d();
            dVar.f14651a = hashMap;
            dVar.f14652b = str;
            dVar.f14653c = 4;
            String a3 = aVar.a();
            h.a("StringUtilsLink", "signature content:" + str2 + "  signature:" + a3);
            return a3;
        } catch (b e2) {
            h.d("StringUtilsLink", "signature content:" + str2 + " Exception[" + e2 + "]" + e2.getMessage() + e2.getErrorCode());
            return "";
        }
    }
}
