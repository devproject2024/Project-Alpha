package com.google.android.gms.common.internal;

import android.util.Log;

public final class j {

    /* renamed from: a  reason: collision with root package name */
    private static final int f8856a = 15;

    /* renamed from: b  reason: collision with root package name */
    private static final String f8857b = null;

    /* renamed from: c  reason: collision with root package name */
    private final String f8858c;

    /* renamed from: d  reason: collision with root package name */
    private final String f8859d;

    public j(String str, String str2) {
        s.a(str, (Object) "log tag cannot be null");
        s.b(str.length() <= 23, "tag \"%s\" is longer than the %d character maximum", str, 23);
        this.f8858c = str;
        if (str2 == null || str2.length() <= 0) {
            this.f8859d = null;
        } else {
            this.f8859d = str2;
        }
    }

    public j(String str) {
        this(str, (String) null);
    }

    public final boolean a(int i2) {
        return Log.isLoggable(this.f8858c, i2);
    }

    public final void a(String str) {
        if (a(3)) {
            e(str);
        }
    }

    public final void b(String str) {
        if (a(2)) {
            e(str);
        }
    }

    public final void c(String str) {
        if (a(6)) {
            e(str);
        }
    }

    public final void d(String str) {
        if (a(6)) {
            e(str);
        }
    }

    public final String e(String str) {
        String str2 = this.f8859d;
        if (str2 == null) {
            return str;
        }
        return str2.concat(str);
    }
}
