package net.one97.paytm.recharge.creditcard.widget;

import android.text.InputFilter;
import android.text.Spanned;
import com.paytm.utility.q;
import java.util.regex.Pattern;

public final class a implements InputFilter {

    /* renamed from: a  reason: collision with root package name */
    Pattern f62640a;

    /* renamed from: b  reason: collision with root package name */
    String f62641b;

    /* renamed from: c  reason: collision with root package name */
    private final int f62642c;

    /* renamed from: d  reason: collision with root package name */
    private final int f62643d;

    public a(int i2, int i3) {
        this.f62642c = i2;
        this.f62643d = i3;
        StringBuilder sb = new StringBuilder("(([₹]{1})?([\\s]{1})?([1-9]{1})([0-9,]{0,");
        sb.append(this.f62642c - 1);
        sb.append("})?)");
        this.f62640a = Pattern.compile(sb.toString());
    }

    public a(int i2, int i3, String str) {
        this.f62642c = i2;
        this.f62643d = i3;
        this.f62640a = Pattern.compile(str);
    }

    public final CharSequence filter(CharSequence charSequence, int i2, int i3, Spanned spanned, int i4, int i5) {
        StringBuilder sb = new StringBuilder(spanned);
        sb.replace(i4, i5, charSequence.subSequence(i2, i3).toString());
        try {
            if (!this.f62640a.matcher(new StringBuilder(sb.toString().toString().replaceAll("[₹, ]", "").trim().replaceAll("^\\s+", "")).toString()).matches()) {
                return "";
            }
            return null;
        } catch (Exception e2) {
            q.d(e2.getMessage());
            return null;
        }
    }
}
