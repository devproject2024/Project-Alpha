package net.one97.paytm.p2b.d;

import android.text.InputFilter;
import android.text.Spanned;
import java.util.regex.Pattern;

public final class a implements InputFilter {

    /* renamed from: a  reason: collision with root package name */
    private Pattern f12665a;

    /* renamed from: b  reason: collision with root package name */
    private final int f12666b;

    /* renamed from: c  reason: collision with root package name */
    private final int f12667c;

    public a(int i2, int i3) {
        this.f12666b = i2;
        this.f12667c = i3;
        StringBuilder sb = new StringBuilder("(([₹]{1})?([\\s]{1})?([1-9]{1})([0-9,]{0,");
        sb.append(this.f12666b - 1);
        sb.append("})?)(?:\\.[0-9]{0,");
        sb.append(this.f12667c);
        sb.append("})?");
        this.f12665a = Pattern.compile(sb.toString());
    }

    public a(int i2, int i3, String str) {
        this.f12666b = i2;
        this.f12667c = i3;
        this.f12665a = Pattern.compile(str);
    }

    public final CharSequence filter(CharSequence charSequence, int i2, int i3, Spanned spanned, int i4, int i5) {
        StringBuilder sb = new StringBuilder(spanned);
        sb.replace(i4, i5, charSequence.subSequence(i2, i3).toString());
        try {
            if (!this.f12665a.matcher(sb.toString()).matches()) {
                return "";
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }
}
