package com.paytmmall.artifact.common.a;

import com.paytmmall.artifact.d.t;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f15624a = a.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private static a f15625b;

    private a() {
    }

    public static a a() {
        if (f15625b == null) {
            f15625b = new a();
        }
        return f15625b;
    }

    public static String a(String str, String str2) {
        return t.e().getStringValue(str, str2);
    }

    public static int a(String str, int i2) {
        return t.e().getInt(str, i2);
    }

    public static boolean a(String str, boolean z) {
        return t.e().getBooleanValue(str, z);
    }

    public static boolean b() {
        return t.e().isStagingApp();
    }
}
