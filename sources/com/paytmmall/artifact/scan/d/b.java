package com.paytmmall.artifact.scan.d;

import android.text.TextUtils;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.one97.paytm.upi.util.UpiConstants;

public final class b {
    public static int a(boolean z) {
        if (z) {
            return 0;
        }
        return UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS;
    }

    public static int a(String str) {
        int i2;
        if (str.length() == 24) {
            i2 = str.equalsIgnoreCase("2810050501011O7KV4V6FDGU") ? 3 : "90".equalsIgnoreCase(str.substring(6, 8)) ? 4 : 2;
        } else if (!TextUtils.isEmpty(d(str))) {
            i2 = 5;
        } else {
            i2 = e(str) ? 6 : 1;
        }
        if (str.length() < 24 || str.length() > 31 || !"91".equalsIgnoreCase(str.substring(6, 8))) {
            return i2;
        }
        return 7;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0027, code lost:
        if (r4.length() < 10) goto L_0x0029;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String d(java.lang.String r4) {
        /*
            java.lang.String r0 = r4.toLowerCase()
            java.lang.String r1 = "c="
            boolean r0 = r0.startsWith(r1)
            r1 = 0
            if (r0 == 0) goto L_0x0061
            java.lang.String r0 = "="
            java.lang.String[] r4 = r4.split(r0)
            int r0 = r4.length
            r2 = 1
            if (r0 <= r2) goto L_0x0029
            r4 = r4[r2]
            java.lang.String r0 = "^\"|\"$"
            java.lang.String r3 = ""
            java.lang.String r4 = r4.replaceAll(r0, r3)
            int r0 = r4.length()
            r3 = 10
            if (r0 >= r3) goto L_0x002a
        L_0x0029:
            r4 = r1
        L_0x002a:
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            if (r0 != 0) goto L_0x0062
            java.lang.String r0 = "+"
            boolean r0 = r4.startsWith(r0)
            if (r0 == 0) goto L_0x0046
            int r0 = r4.length()
            r3 = 13
            if (r0 != r3) goto L_0x0046
            r0 = 3
            java.lang.String r4 = r4.substring(r0)
            goto L_0x0062
        L_0x0046:
            int r0 = r4.length()
            r3 = 12
            if (r0 != r3) goto L_0x0054
            r0 = 2
            java.lang.String r4 = r4.substring(r0)
            goto L_0x0062
        L_0x0054:
            int r0 = r4.length()
            r3 = 11
            if (r0 != r3) goto L_0x0062
            java.lang.String r4 = r4.substring(r2)
            goto L_0x0062
        L_0x0061:
            r4 = r1
        L_0x0062:
            boolean r0 = com.paytm.utility.b.b((java.lang.String) r4)
            if (r0 == 0) goto L_0x0069
            return r4
        L_0x0069:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytmmall.artifact.scan.d.b.d(java.lang.String):java.lang.String");
    }

    private static boolean e(String str) {
        Matcher matcher = Pattern.compile("BEGIN:VCARD", 2).matcher(str);
        return matcher.find() && matcher.start() == 0;
    }

    public static Map<String, String> b(String str) throws UnsupportedEncodingException {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (String str2 : str.split(AppConstants.AND_SIGN)) {
            int indexOf = str2.indexOf("=");
            linkedHashMap.put(URLDecoder.decode(str2.substring(0, indexOf), AppConstants.UTF_8), URLDecoder.decode(str2.substring(indexOf + 1), AppConstants.UTF_8));
        }
        return linkedHashMap;
    }

    public static String c(String str) {
        Pattern compile = Pattern.compile("[A-Za-z]{4}0[A-Z0-9a-z]{6}");
        String[] split = str.split("\\s|\\n");
        int length = split.length;
        for (int i2 = 0; i2 < length; i2++) {
            String str2 = split[i2];
            try {
                if (str2.charAt(4) == 'O' || str2.charAt(4) == 'o') {
                    char[] charArray = str2.toCharArray();
                    charArray[4] = '0';
                    str2 = String.valueOf(charArray);
                }
            } catch (Exception unused) {
            }
            if (compile.matcher(str2).matches()) {
                return str2;
            }
        }
        return null;
    }
}
