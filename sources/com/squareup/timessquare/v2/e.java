package com.squareup.timessquare.v2;

import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import java.util.Date;

final class e {

    /* renamed from: a  reason: collision with root package name */
    final int f45595a;

    /* renamed from: b  reason: collision with root package name */
    final int f45596b;

    /* renamed from: c  reason: collision with root package name */
    final Date f45597c;

    /* renamed from: d  reason: collision with root package name */
    final SpannableStringBuilder f45598d;

    /* renamed from: e  reason: collision with root package name */
    String f45599e;

    public e(int i2, int i3, Date date, String str) {
        this.f45595a = i2;
        this.f45596b = i3;
        this.f45597c = date;
        this.f45599e = str;
        String substring = str.substring(0, str.indexOf(" "));
        String substring2 = str.substring(str.indexOf(" "), str.length());
        this.f45598d = new SpannableStringBuilder(substring + substring2);
        this.f45598d.setSpan(new StyleSpan(1), 0, substring.length(), 33);
    }

    public final String toString() {
        return "MonthDescriptor{label='" + this.f45599e + '\'' + ", month=" + this.f45595a + ", year=" + this.f45596b + '}';
    }
}
