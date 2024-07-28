package com.alipay.mobile.nebula.util;

import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.a.b;
import com.alibaba.a.e;
import java.util.HashMap;
import java.util.Map;

public class H5TabbarUtils {
    public static final String MATCH_TYPE_PARTHASH = "partHash";
    public static final String MATCH_TYPE_PATH = "path";
    private static final String TAG = "H5TabbarUtils";
    private static Map<String, byte[]> tabDatas = new HashMap();

    public static byte[] getTabDataByAppId(String str) {
        H5Log.d(TAG, "getTabDataByAppId ".concat(String.valueOf(str)));
        Map<String, byte[]> map = tabDatas;
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    public static void setTabData(String str, byte[] bArr) {
        if (tabDatas != null) {
            H5Log.d(TAG, "setTabData ".concat(String.valueOf(str)));
            tabDatas.put(str, bArr);
        }
    }

    public static void clearTabDataByAppId(String str) {
        if (tabDatas != null) {
            H5Log.d(TAG, "clearTabDataByAppId ".concat(String.valueOf(str)));
            tabDatas.remove(str);
        }
    }

    public static void clearTabDatas() {
        if (tabDatas != null) {
            H5Log.d(TAG, "clearTabDatas");
            tabDatas.clear();
        }
    }

    public static int ifUrlMatch(String str, String str2, Bundle bundle) {
        Map<String, byte[]> map = tabDatas;
        byte[] bArr = map != null ? map.get(str) : null;
        int i2 = -1;
        if (bArr != null) {
            String str3 = new String(bArr);
            H5Log.d(TAG, "ifUrlMatch tmpData ".concat(str3));
            e parseObject = H5Utils.parseObject(str3);
            String string = H5Utils.getString(parseObject, "matchType", MATCH_TYPE_PARTHASH);
            String urlWithoutQuery = getUrlWithoutQuery(str2, string);
            H5Log.d(TAG, "ifUrlMatch entryUrlWithoutQuery ".concat(String.valueOf(urlWithoutQuery)));
            b jSONArray = H5Utils.getJSONArray(parseObject, "items", (b) null);
            if (jSONArray != null && !jSONArray.isEmpty()) {
                int size = jSONArray.size();
                int i3 = 0;
                while (i3 < size && i3 < 5) {
                    e jSONObject = jSONArray.getJSONObject(i3);
                    if (jSONObject != null && !jSONObject.isEmpty()) {
                        String string2 = jSONObject.getString("url");
                        String absoluteUrl = getAbsoluteUrl(string2, bundle);
                        String urlWithoutQuery2 = getUrlWithoutQuery(absoluteUrl, string);
                        H5Log.d(TAG, "ifUrlMatch shortUrl " + string2 + ", abUrl " + absoluteUrl + ", abUrlWithoutQuery " + urlWithoutQuery2);
                        if (TextUtils.equals(urlWithoutQuery, urlWithoutQuery2)) {
                            i2 = i3;
                        }
                    }
                    i3++;
                }
            }
        }
        H5Log.d(TAG, "ifUrlMatch final result ".concat(String.valueOf(i2)));
        return i2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x006c, code lost:
        r6 = r5.indexOf("?");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getUrlWithoutQuery(java.lang.String r5, java.lang.String r6) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            r1 = 0
            if (r0 == 0) goto L_0x0008
            return r1
        L_0x0008:
            android.net.Uri r0 = com.alipay.mobile.nebula.util.H5UrlHelper.parseUrl(r5)
            if (r0 == 0) goto L_0x007c
            java.lang.String r2 = "path"
            boolean r2 = r2.equals(r6)
            java.lang.String r3 = "H5TabbarUtils"
            if (r2 == 0) goto L_0x0039
            java.lang.String r1 = "getUrlWithoutQuery MATCH_TYPE_PATH"
            com.alipay.mobile.nebula.util.H5Log.d(r3, r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = r0.getScheme()
            java.lang.String r4 = r0.getEncodedAuthority()
            r1.append(r2)
            java.lang.String r2 = "://"
            r1.append(r2)
            r1.append(r4)
            java.lang.String r1 = r1.toString()
        L_0x0039:
            java.lang.String r2 = "partHash"
            boolean r6 = r2.equals(r6)
            if (r6 == 0) goto L_0x007c
            java.lang.String r6 = "getUrlWithoutQuery MATCH_TYPE_PARTHASH"
            com.alipay.mobile.nebula.util.H5Log.d(r3, r6)
            java.lang.String r6 = r0.getEncodedQuery()
            boolean r1 = android.text.TextUtils.isEmpty(r6)
            java.lang.String r2 = "?"
            if (r1 == 0) goto L_0x0053
            goto L_0x0061
        L_0x0053:
            java.lang.String r6 = java.lang.String.valueOf(r6)
            java.lang.String r6 = r2.concat(r6)
            java.lang.String r1 = ""
            java.lang.String r5 = r5.replace(r6, r1)
        L_0x0061:
            r1 = r5
            java.lang.String r5 = r0.getEncodedFragment()
            boolean r6 = android.text.TextUtils.isEmpty(r5)
            if (r6 != 0) goto L_0x007c
            int r6 = r5.indexOf(r2)
            r0 = -1
            if (r6 == r0) goto L_0x007c
            r0 = 0
            java.lang.String r6 = r5.substring(r0, r6)
            java.lang.String r1 = r1.replace(r5, r6)
        L_0x007c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.nebula.util.H5TabbarUtils.getUrlWithoutQuery(java.lang.String, java.lang.String):java.lang.String");
    }

    public static String getAbsoluteUrl(String str, Bundle bundle) {
        String string = H5Utils.getString(bundle, "url");
        if (!TextUtils.isEmpty(string)) {
            return H5Utils.getAbsoluteUrlV2(string, str, (Bundle) null);
        }
        return null;
    }
}
