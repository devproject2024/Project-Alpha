package com.squareup.timessquare;

import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import java.util.Date;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    final int f45543a;

    /* renamed from: b  reason: collision with root package name */
    final int f45544b;

    /* renamed from: c  reason: collision with root package name */
    final Date f45545c;

    /* renamed from: d  reason: collision with root package name */
    String f45546d;

    /* renamed from: e  reason: collision with root package name */
    SpannableStringBuilder f45547e;

    public e(int i2, int i3, Date date, String str) {
        this.f45543a = i2;
        this.f45544b = i3;
        this.f45545c = date;
        this.f45546d = str;
        String substring = str.substring(0, str.indexOf(" "));
        String substring2 = str.substring(str.indexOf(" "), str.length());
        this.f45547e = new SpannableStringBuilder(substring + substring2);
        this.f45547e.setSpan(new StyleSpan(1), 0, substring.length(), 33);
    }

    public final String toString() {
        return "MonthDescriptor{label='" + this.f45546d + '\'' + ", month=" + this.f45543a + ", year=" + this.f45544b + '}';
    }
}
