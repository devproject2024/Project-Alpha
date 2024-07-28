package com.google.android.gms.common.a;

import android.util.Log;
import com.google.android.gms.common.internal.j;
import java.util.Locale;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final String f8347a;

    /* renamed from: b  reason: collision with root package name */
    private final String f8348b;

    /* renamed from: c  reason: collision with root package name */
    private final j f8349c;

    /* renamed from: d  reason: collision with root package name */
    private final int f8350d;

    public a(String str) {
        this(str, "");
    }

    private a(String str, String str2) {
        this.f8348b = str2;
        this.f8347a = str;
        this.f8349c = new j(str);
        int i2 = 2;
        while (7 >= i2 && !Log.isLoggable(this.f8347a, i2)) {
            i2++;
        }
        this.f8350d = i2;
    }

    public final String b(String str, Object... objArr) {
        if (objArr != null && objArr.length > 0) {
            str = String.format(Locale.US, str, objArr);
        }
        return this.f8348b.concat(str);
    }

    public final void a(String str, Object... objArr) {
        if (this.f8350d <= 3) {
            b(str, objArr);
        }
    }
}
