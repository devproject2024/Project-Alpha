package com.squareup.timessquare.v3;

import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import java.util.Date;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    final int f45649a;

    /* renamed from: b  reason: collision with root package name */
    final int f45650b;

    /* renamed from: c  reason: collision with root package name */
    final Date f45651c;

    /* renamed from: d  reason: collision with root package name */
    String f45652d;

    /* renamed from: e  reason: collision with root package name */
    SpannableStringBuilder f45653e;

    public e(int i2, int i3, Date date, String str) {
        this.f45649a = i2;
        this.f45650b = i3;
        this.f45651c = date;
        this.f45652d = str;
        String substring = str.substring(0, str.indexOf(" "));
        String substring2 = str.substring(str.indexOf(" "), str.length());
        this.f45653e = new SpannableStringBuilder(substring + substring2);
        this.f45653e.setSpan(new StyleSpan(1), 0, substring.length(), 33);
    }

    public final String toString() {
        return "MonthDescriptor{label='" + this.f45652d + '\'' + ", month=" + this.f45649a + ", year=" + this.f45650b + '}';
    }
}
