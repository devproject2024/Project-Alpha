package net.one97.paytm.upi.common;

import android.text.InputFilter;
import android.text.Spanned;
import java.util.regex.Pattern;

public class AmountInputFilter implements InputFilter {
    private Pattern mPattern;
    private final int maxDigitsAfterDecimalPoint;
    private final int maxDigitsBeforeDecimalPointWithComma;

    public AmountInputFilter(int i2, int i3) {
        this.maxDigitsBeforeDecimalPointWithComma = i2;
        this.maxDigitsAfterDecimalPoint = i3;
        StringBuilder sb = new StringBuilder("(([₹]{1})?([\\s]{1})?([1-9]{1})([0-9,]{0,");
        sb.append(this.maxDigitsBeforeDecimalPointWithComma - 1);
        sb.append("})?)(?:\\.[0-9]{0,");
        sb.append(this.maxDigitsAfterDecimalPoint);
        sb.append("})?");
        this.mPattern = Pattern.compile(sb.toString());
    }

    public AmountInputFilter(int i2, int i3, String str) {
        this.maxDigitsBeforeDecimalPointWithComma = i2;
        this.maxDigitsAfterDecimalPoint = i3;
        this.mPattern = Pattern.compile(str);
    }

    public CharSequence filter(CharSequence charSequence, int i2, int i3, Spanned spanned, int i4, int i5) {
        StringBuilder sb = new StringBuilder(spanned);
        sb.replace(i4, i5, charSequence.subSequence(i2, i3).toString());
        try {
            if (!this.mPattern.matcher(sb.toString()).matches()) {
                return "";
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }
}
