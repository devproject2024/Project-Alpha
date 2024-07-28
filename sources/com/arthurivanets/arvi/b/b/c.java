package com.arthurivanets.arvi.b.b;

import android.text.TextUtils;

public final class c {
    public static void a(Object obj) {
        if (obj == null) {
            throw new NullPointerException("The argument must be non-null!");
        }
    }

    public static void a(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("You must specify a valid raw text.");
        }
    }
}
