package com.google.zxing.client.a;

import com.google.zxing.r;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.Map;
import java.util.regex.Pattern;

public final class i extends u {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f40054a = Pattern.compile(AppConstants.COMMA);

    public final /* synthetic */ q a(r rVar) {
        return d(rVar);
    }

    private static h d(r rVar) {
        String str;
        String str2;
        String[] strArr;
        String[] strArr2;
        String[] strArr3;
        String str3;
        String b2 = b(rVar);
        String[] strArr4 = null;
        if (b2.startsWith("mailto:") || b2.startsWith("MAILTO:")) {
            String substring = b2.substring(7);
            int indexOf = substring.indexOf(63);
            if (indexOf >= 0) {
                substring = substring.substring(0, indexOf);
            }
            try {
                String d2 = d(substring);
                String[] split = !d2.isEmpty() ? f40054a.split(d2) : null;
                Map<String, String> c2 = c(b2);
                if (c2 != null) {
                    if (split == null && (str3 = c2.get("to")) != null) {
                        split = f40054a.split(str3);
                    }
                    String str4 = c2.get("cc");
                    String[] split2 = str4 != null ? f40054a.split(str4) : null;
                    String str5 = c2.get("bcc");
                    if (str5 != null) {
                        strArr4 = f40054a.split(str5);
                    }
                    str = c2.get("body");
                    strArr3 = split;
                    strArr = strArr4;
                    strArr2 = split2;
                    str2 = c2.get("subject");
                } else {
                    strArr3 = split;
                    strArr2 = null;
                    strArr = null;
                    str2 = null;
                    str = null;
                }
                return new h(strArr3, strArr2, strArr, str2, str);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        } else if (!j.a(b2)) {
            return null;
        } else {
            return new h(b2);
        }
    }
}
