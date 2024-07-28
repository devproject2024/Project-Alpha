package com.google.firebase.crashlytics.a.c;

import com.alipay.mobile.nebula.util.tar.TarConstants;
import java.util.concurrent.ConcurrentHashMap;

public final class ae {

    /* renamed from: a  reason: collision with root package name */
    String f38161a = null;

    /* renamed from: b  reason: collision with root package name */
    public final ConcurrentHashMap<String, String> f38162b = new ConcurrentHashMap<>();

    public final void a(String str) {
        this.f38161a = b(str);
    }

    public static String b(String str) {
        if (str == null) {
            return str;
        }
        String trim = str.trim();
        return trim.length() > 1024 ? trim.substring(0, TarConstants.EOF_BLOCK) : trim;
    }
}
