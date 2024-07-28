package net.one97.paytm.passbook.utility;

import android.content.Context;
import android.graphics.Typeface;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.RelativeSizeSpan;
import android.widget.TextView;
import com.business.merchant_payments.common.utility.AppUtility;
import com.paytm.utility.CustomTypefaceSpan;
import com.paytm.utility.b;
import java.text.DecimalFormat;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;

public final class f {
    public static final boolean a(Context context) {
        k.c(context, "receiver$0");
        return b.c(context.getApplicationContext());
    }

    public static final boolean b(Context context) {
        k.c(context, "receiver$0");
        return b.r(context.getApplicationContext());
    }

    public static final String c(Context context) {
        k.c(context, "receiver$0");
        return net.one97.paytm.passbook.mapping.b.a(context.getApplicationContext());
    }

    public static final String d(Context context) {
        k.c(context, "receiver$0");
        return b.n(context.getApplicationContext());
    }

    public static final String a(double d2) {
        try {
            DecimalFormat decimalFormat = new DecimalFormat();
            decimalFormat.applyPattern("##,##,##,##,##,###.##");
            return decimalFormat.format(d2);
        } catch (Exception unused) {
            return null;
        }
    }

    public static final String b(double d2) {
        try {
            DecimalFormat decimalFormat = new DecimalFormat();
            decimalFormat.applyPattern("##,##,##,##,##,###.00");
            String format = decimalFormat.format(d2);
            k.a((Object) format, "number");
            if (!p.a((CharSequence) format, (CharSequence) ".00", false)) {
                return format;
            }
            String a2 = p.a(format, ".00", "", false);
            return TextUtils.isEmpty(a2) ? "0" : a2;
        } catch (Exception unused) {
            return null;
        }
    }

    public static final void a(TextView textView, String str) {
        k.c(textView, "receiver$0");
        k.c(str, "strValue");
        Typeface typeface = null;
        try {
            if (textView.getTypeface() == null || textView.getTypeface() != null) {
                Typeface.create("sans-serif-medium", 1);
            }
            if (textView.getTypeface() == null || textView.getTypeface() != null) {
                typeface = Typeface.create("sans-serif", 0);
            }
            Object[] array = p.a((CharSequence) str, new String[]{AppUtility.CENTER_DOT}).toArray(new String[0]);
            if (array != null) {
                String[] strArr = (String[]) array;
                if (strArr == null) {
                    return;
                }
                if (strArr.length > 0) {
                    int length = strArr[0].length();
                    int length2 = str.length();
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
                    if (strArr.length > 1) {
                        spannableStringBuilder.setSpan(new RelativeSizeSpan(1.0f), length, length2, 34);
                        spannableStringBuilder.setSpan(new CustomTypefaceSpan("", typeface), length, length2, 34);
                    }
                    textView.setText(spannableStringBuilder);
                    return;
                }
                return;
            }
            throw new u("null cannot be cast to non-null type kotlin.Array<T>");
        } catch (Exception unused) {
        }
    }

    public static final String c(double d2) {
        try {
            DecimalFormat decimalFormat = new DecimalFormat();
            if (Double.compare(d2 % 1.0d, 0.0d) == 0) {
                decimalFormat.applyPattern("##,##,##,##,##,##0.##");
            } else {
                decimalFormat.applyPattern("##,##,##,##,##,##0.00");
            }
            return decimalFormat.format(d2);
        } catch (Exception unused) {
            return null;
        }
    }
}
