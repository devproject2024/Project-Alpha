package com.squareup.timessquare.v4;

import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import java.util.Date;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    final int f45703a;

    /* renamed from: b  reason: collision with root package name */
    final int f45704b;

    /* renamed from: c  reason: collision with root package name */
    final Date f45705c;

    /* renamed from: d  reason: collision with root package name */
    String f45706d;

    /* renamed from: e  reason: collision with root package name */
    SpannableStringBuilder f45707e;

    public e(int i2, int i3, Date date, String str) {
        this.f45703a = i2;
        this.f45704b = i3;
        this.f45705c = date;
        this.f45706d = str;
        String substring = str.substring(0, str.indexOf(" "));
        String substring2 = str.substring(str.indexOf(" "), str.length());
        this.f45707e = new SpannableStringBuilder(substring + substring2);
        this.f45707e.setSpan(new StyleSpan(1), 0, substring.length(), 33);
    }

    public final String toString() {
        return "MonthDescriptor{label='" + this.f45706d + '\'' + ", month=" + this.f45703a + ", year=" + this.f45704b + '}';
    }
}
