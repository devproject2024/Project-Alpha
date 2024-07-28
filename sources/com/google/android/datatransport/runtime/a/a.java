package com.google.android.datatransport.runtime.a;

public final class a {
    public static String a(String str) {
        return "TransportRuntime.".concat(String.valueOf(str));
    }

    public static void a(String str, String str2, Object obj) {
        a(str);
        String.format(str2, new Object[]{obj});
    }

    public static void a(String str, String str2, Object... objArr) {
        a(str);
        String.format(str2, objArr);
    }
}
