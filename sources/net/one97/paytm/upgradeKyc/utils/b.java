package net.one97.paytm.upgradeKyc.utils;

import android.text.InputFilter;
import android.text.SpannableStringBuilder;
import android.text.Spanned;

public final class b implements InputFilter {
    public final CharSequence filter(CharSequence charSequence, int i2, int i3, Spanned spanned, int i4, int i5) {
        if (charSequence instanceof SpannableStringBuilder) {
            SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) charSequence;
            for (int i6 = i3 - 1; i6 >= i2; i6--) {
                if (!Character.isLetterOrDigit(charSequence.charAt(i6))) {
                    spannableStringBuilder.delete(i6, i6 + 1);
                }
            }
            return charSequence;
        }
        StringBuilder sb = new StringBuilder();
        while (i2 < i3) {
            char charAt = charSequence.charAt(i2);
            if (Character.isLetterOrDigit(charAt) && charAt != 960) {
                sb.append(charAt);
            }
            i2++;
        }
        return sb.toString();
    }
}
