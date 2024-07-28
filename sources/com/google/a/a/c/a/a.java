package com.google.a.a.c.a;

import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final b f7544a = new c("-_.*", true);

    /* renamed from: b  reason: collision with root package name */
    private static final b f7545b = new c("-_.!~*'()@:$&,;=", false);

    /* renamed from: c  reason: collision with root package name */
    private static final b f7546c = new c("-_.!~*'()@:$&,;=+/?", false);

    /* renamed from: d  reason: collision with root package name */
    private static final b f7547d = new c("-_.!~*'():$&,;=", false);

    /* renamed from: e  reason: collision with root package name */
    private static final b f7548e = new c("-_.!~*'()@:$,;/?:", false);

    public static String a(String str) {
        return f7544a.a(str);
    }

    public static String b(String str) {
        try {
            return URLDecoder.decode(str, AppConstants.UTF_8);
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static String c(String str) {
        return f7545b.a(str);
    }

    public static String d(String str) {
        return f7547d.a(str);
    }

    public static String e(String str) {
        return f7548e.a(str);
    }
}
