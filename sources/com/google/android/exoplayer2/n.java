package com.google.android.exoplayer2;

import java.util.HashSet;

public final class n {

    /* renamed from: a  reason: collision with root package name */
    private static final HashSet<String> f32755a = new HashSet<>();

    /* renamed from: b  reason: collision with root package name */
    private static String f32756b = "goog.exo.core";

    public static synchronized String a() {
        String str;
        synchronized (n.class) {
            str = f32756b;
        }
        return str;
    }

    public static synchronized void a(String str) {
        synchronized (n.class) {
            if (f32755a.add(str)) {
                f32756b += ", " + str;
            }
        }
    }
}
