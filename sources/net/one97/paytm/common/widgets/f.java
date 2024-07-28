package net.one97.paytm.common.widgets;

import android.text.InputFilter;
import android.text.Spanned;
import com.business.merchant_payments.common.utility.AppUtility;
import com.paytm.utility.b;
import com.paytm.utility.q;

public final class f implements InputFilter {

    /* renamed from: a  reason: collision with root package name */
    private final int f49903a;

    /* renamed from: b  reason: collision with root package name */
    private final int f49904b;

    public f(int i2, int i3) {
        this.f49903a = i2;
        this.f49904b = i3;
    }

    public final CharSequence filter(CharSequence charSequence, int i2, int i3, Spanned spanned, int i4, int i5) {
        try {
            StringBuilder sb = new StringBuilder(spanned);
            sb.append(charSequence);
            if (sb.toString().equals(AppUtility.CENTER_DOT)) {
                return "";
            }
            StringBuilder sb2 = new StringBuilder(spanned);
            sb2.replace(i4, i5, charSequence.subSequence(i2, i3).toString());
            String sb3 = sb2.toString();
            StringBuilder sb4 = new StringBuilder("(([1-9]{1})([0-9]{0,");
            sb4.append(this.f49903a - 1);
            sb4.append("})?)?(\\.[0-9]{0,");
            sb4.append(this.f49904b);
            sb4.append("})?");
            if (sb3.matches(sb4.toString())) {
                return null;
            }
            if (charSequence.length() == 0) {
                return spanned.subSequence(i4, i5);
            }
            return "";
        } catch (Exception e2) {
            if (!b.v) {
                return null;
            }
            q.b(e2.getMessage());
            return null;
        }
    }
}
