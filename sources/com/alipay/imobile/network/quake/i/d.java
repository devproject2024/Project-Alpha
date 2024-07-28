package com.alipay.imobile.network.quake.i;

import java.util.regex.Pattern;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f14900a = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");

    public static boolean a(String str) {
        return f14900a.matcher(str).matches();
    }
}
