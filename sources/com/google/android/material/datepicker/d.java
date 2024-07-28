package com.google.android.material.datepicker;

import android.os.Build;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

final class d {
    static String a(long j, Locale locale) {
        if (Build.VERSION.SDK_INT >= 24) {
            return o.a(locale).format(new Date(j));
        }
        return o.e(locale).format(new Date(j));
    }

    static String b(long j, Locale locale) {
        if (Build.VERSION.SDK_INT >= 24) {
            return o.b(locale).format(new Date(j));
        }
        return o.f(locale).format(new Date(j));
    }

    static String a(long j) {
        Calendar a2 = o.a();
        Calendar b2 = o.b();
        b2.setTimeInMillis(j);
        return a2.get(1) == b2.get(1) ? b(j, Locale.getDefault()) : a(j, Locale.getDefault());
    }
}
