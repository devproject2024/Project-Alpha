package com.travel.train.j;

import android.text.InputFilter;
import android.text.Spanned;

public final class u implements InputFilter {

    /* renamed from: a  reason: collision with root package name */
    private int f27606a = 1;

    /* renamed from: b  reason: collision with root package name */
    private int f27607b;

    public u(int i2) {
        this.f27607b = i2;
    }

    public final CharSequence filter(CharSequence charSequence, int i2, int i3, Spanned spanned, int i4, int i5) {
        try {
            StringBuilder sb = new StringBuilder();
            boolean z = false;
            sb.append(spanned.subSequence(0, i4).toString());
            sb.append(charSequence);
            sb.append(spanned.subSequence(i5, spanned.length()));
            int parseInt = Integer.parseInt(sb.toString());
            int i6 = this.f27606a;
            int i7 = this.f27607b;
            if (i7 <= i6 ? !(parseInt < i7 || parseInt > i6) : !(parseInt < i6 || parseInt > i7)) {
                z = true;
            }
            if (z) {
                return null;
            }
            return "";
        } catch (NumberFormatException unused) {
            return "";
        }
    }
}
