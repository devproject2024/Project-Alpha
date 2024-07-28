package net.one97.paytm.recharge.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ScaleXSpan;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.business.merchant_payments.common.utility.AppUtility;
import java.text.DecimalFormat;
import net.one97.paytm.recharge.R;

public class CJRAmountView extends AppCompatTextView {

    /* renamed from: a  reason: collision with root package name */
    private static DecimalFormat f61839a = new DecimalFormat("##,##,##,##,##,##,##0.00");

    /* renamed from: b  reason: collision with root package name */
    private static DecimalFormat f61840b = new DecimalFormat("##,##,##,##,##,##,##0");

    /* renamed from: c  reason: collision with root package name */
    private boolean f61841c;

    /* renamed from: e  reason: collision with root package name */
    private float f61842e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f61843f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f61844g;

    public CJRAmountView(Context context) {
        super(context);
    }

    public CJRAmountView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.CJRAmountView, 0, 0);
        try {
            this.f61841c = obtainStyledAttributes.getBoolean(R.styleable.CJRAmountView_displayRupee, true);
            this.f61842e = obtainStyledAttributes.getFloat(R.styleable.CJRAmountView_rupeeLetterSpacing, 1.0f);
            if (((double) this.f61842e) < 0.0d) {
                this.f61842e = 0.0f;
            } else if (((double) this.f61842e) > 1.0d) {
                this.f61842e = 1.0f;
            }
            this.f61843f = obtainStyledAttributes.getBoolean(R.styleable.CJRAmountView_enableDecimalFormat, false);
            this.f61844g = obtainStyledAttributes.getBoolean(R.styleable.CJRAmountView_enableBoldFormat, true);
            setText(a(getText().toString(), this.f61841c, this.f61842e, this.f61843f));
        } finally {
            if (obtainStyledAttributes != null) {
                obtainStyledAttributes.recycle();
            }
        }
    }

    public final void a(boolean z) {
        this.f61841c = z;
    }

    public final void a() {
        this.f61843f = false;
    }

    public void setText(String str) {
        setText(a(str, this.f61841c, this.f61842e, this.f61843f));
    }

    private SpannableStringBuilder a(String str, boolean z, float f2, boolean z2) {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            if (b(str)) {
                if (z) {
                    sb.append("₹ ");
                }
                if (z2) {
                    sb.append(f61839a.format(Double.parseDouble(str)));
                } else {
                    sb.append(f61840b.format(Double.parseDouble(str)));
                }
            } else {
                if (z) {
                    sb.append("₹ ");
                }
                sb.append(str);
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(sb.toString());
            if (z) {
                if (f2 == 0.0f) {
                    spannableStringBuilder.replace(1, 2, "");
                } else {
                    spannableStringBuilder.setSpan(new ScaleXSpan(f2), 1, 2, 33);
                }
            }
            int indexOf = spannableStringBuilder.toString().indexOf(AppUtility.CENTER_DOT);
            if (indexOf == -1) {
                indexOf = spannableStringBuilder.length();
            }
            if (this.f61844g) {
                spannableStringBuilder.setSpan(new StyleSpan(1), 0, indexOf, 33);
            }
            return spannableStringBuilder;
        } else if (z2) {
            return new SpannableStringBuilder("₹ 0.00");
        } else {
            return new SpannableStringBuilder("₹ 0");
        }
    }

    private static boolean b(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public static String a(String str) {
        try {
            return f61840b.format(Double.parseDouble(str));
        } catch (Exception unused) {
            return "";
        }
    }
}
