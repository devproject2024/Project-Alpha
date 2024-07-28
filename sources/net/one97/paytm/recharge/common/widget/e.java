package net.one97.paytm.recharge.common.widget;

import android.text.InputFilter;
import android.text.Spanned;
import com.business.merchant_payments.common.utility.AppUtility;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.recharge.common.utils.ba;

public final class e implements InputFilter {

    /* renamed from: a  reason: collision with root package name */
    public boolean f62154a;

    /* renamed from: b  reason: collision with root package name */
    private Pattern f62155b;

    public e(int i2) {
        StringBuilder sb = new StringBuilder("[1-9]{1,1}[0-9]{0,");
        sb.append(i2 - 1);
        sb.append("}+((\\.[0-9]{0,2})?)||(\\.)?");
        Pattern compile = Pattern.compile(sb.toString());
        k.a((Object) compile, "Pattern.compile(\"[1-9]{1…ro - 1) + \"})?)||(\\\\.)?\")");
        this.f62155b = compile;
    }

    public final CharSequence filter(CharSequence charSequence, int i2, int i3, Spanned spanned, int i4, int i5) {
        String str;
        Matcher matcher;
        k.c(charSequence, "source");
        k.c(spanned, "dest");
        CharSequence charSequence2 = spanned;
        StringBuilder sb = new StringBuilder(charSequence2);
        sb.append(charSequence);
        if (k.a((Object) sb.toString(), (Object) AppUtility.CENTER_DOT)) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder(charSequence2);
        sb2.replace(i4, i5, charSequence.subSequence(i2, i3).toString());
        if (this.f62154a) {
            str = ba.e(sb2.toString());
            k.a((Object) str, "RechargeUtils.getCleanAm…tring(builder.toString())");
        } else {
            str = "";
        }
        CharSequence charSequence3 = str;
        if (!p.a(charSequence3)) {
            matcher = this.f62155b.matcher(charSequence3);
        } else {
            matcher = this.f62155b.matcher(sb2);
        }
        if (!matcher.matches()) {
            return "";
        }
        return null;
    }
}
