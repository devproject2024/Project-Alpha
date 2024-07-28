package net.one97.paytm.paymentsBank.slfd.b;

import android.text.InputFilter;
import android.text.Spanned;
import com.paytm.utility.b;
import java.util.regex.Pattern;

public final class a implements InputFilter {

    /* renamed from: a  reason: collision with root package name */
    private Pattern f18953a;

    /* renamed from: b  reason: collision with root package name */
    private final int f18954b;

    /* renamed from: c  reason: collision with root package name */
    private final int f18955c;

    public a(int i2, int i3) {
        this.f18954b = i2;
        this.f18955c = i3;
        StringBuilder sb = new StringBuilder("(([₹]{1})?([\\s]{1})?([1-9]{1})([0-9,]{0,");
        sb.append(this.f18954b - 1);
        sb.append("})?)(?:\\.[0-9]{0,");
        sb.append(this.f18955c);
        sb.append("})?");
        this.f18953a = Pattern.compile(sb.toString());
    }

    public a(int i2, int i3, String str) {
        this.f18954b = i2;
        this.f18955c = i3;
        this.f18953a = Pattern.compile(str);
    }

    public final CharSequence filter(CharSequence charSequence, int i2, int i3, Spanned spanned, int i4, int i5) {
        StringBuilder sb = new StringBuilder(spanned);
        sb.replace(i4, i5, charSequence.subSequence(i2, i3).toString());
        try {
            if (!this.f18953a.matcher(sb.toString()).matches()) {
                return "";
            }
            return null;
        } catch (Exception e2) {
            if (!b.v) {
                return null;
            }
            e2.printStackTrace();
            return null;
        }
    }
}
