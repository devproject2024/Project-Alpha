package net.one97.paytm.recharge.common.widget;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import com.business.merchant_payments.common.utility.AppUtility;
import com.paytm.utility.q;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.HashMap;
import java.util.Locale;
import kotlin.g.b.k;
import kotlin.m.l;
import kotlin.m.p;
import net.one97.paytm.recharge.common.utils.ba;
import net.one97.paytm.recharge.widgets.c.d;

public class CJRAmountInputFieldWidgetV8 extends CJRInputFieldWithActionWidgetV8 implements TextWatcher {

    /* renamed from: a  reason: collision with root package name */
    public static final a f61834a = new a((byte) 0);
    private static int j = 2;

    /* renamed from: f  reason: collision with root package name */
    private String f61835f;

    /* renamed from: g  reason: collision with root package name */
    private String f61836g;

    /* renamed from: h  reason: collision with root package name */
    private DecimalFormat f61837h;

    /* renamed from: i  reason: collision with root package name */
    private TextWatcher f61838i;
    private HashMap k;

    public View a(int i2) {
        if (this.k == null) {
            this.k = new HashMap();
        }
        View view = (View) this.k.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.k.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CJRAmountInputFieldWidgetV8(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        k.c(context, "context");
        this.f61835f = "##,##,##,##,###.";
        this.f61836g = "##,##,##,##,###";
        this.f61837h = new DecimalFormat(this.f61836g, DecimalFormatSymbols.getInstance(Locale.ENGLISH));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CJRAmountInputFieldWidgetV8(Context context) {
        this(context, (AttributeSet) null);
        k.c(context, "context");
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public void setInputFieldTextChangeListener(TextWatcher textWatcher) {
        this.f61838i = textWatcher;
        TextWatcher textWatcher2 = this.f61838i;
        if (textWatcher2 != null) {
            super.setInputFieldTextChangeListener(textWatcher2);
        }
        super.setInputFieldTextChangeListener(this);
    }

    public void afterTextChanged(Editable editable) {
        boolean z = false;
        a(editable == null || editable.length() != 0);
        TextWatcher textWatcher = this;
        super.a(textWatcher);
        TextWatcher textWatcher2 = this.f61838i;
        if (textWatcher2 != null) {
            super.a(textWatcher2);
        }
        CharSequence charSequence = editable;
        if (charSequence == null || p.a(charSequence)) {
            z = true;
        }
        if (!z) {
            try {
                String e2 = e(editable.toString());
                setInputText(e2);
                setInputSelection(e2.length());
            } catch (Exception unused) {
            }
        }
        super.setInputFieldTextChangeListener(textWatcher);
        TextWatcher textWatcher3 = this.f61838i;
        if (textWatcher3 != null) {
            super.setInputFieldTextChangeListener(textWatcher3);
        }
    }

    private static String e(String str) {
        CharSequence replace = new l("[₹, ]").replace((CharSequence) str, "");
        int length = replace.length() - 1;
        int i2 = 0;
        boolean z = false;
        while (i2 <= length) {
            boolean z2 = replace.charAt(!z ? i2 : length) <= ' ';
            if (z) {
                if (!z2) {
                    break;
                }
                length--;
            } else if (!z2) {
                z = true;
            } else {
                i2++;
            }
        }
        String replace2 = new l("^\\s+").replace((CharSequence) replace.subSequence(i2, length + 1).toString(), "");
        try {
            if (p.a(replace2)) {
                return "";
            }
            if (p.a((CharSequence) replace2, (CharSequence) AppUtility.CENTER_DOT, false)) {
                d dVar = d.f64967a;
                return d.a(replace2, false, -1);
            }
            d dVar2 = d.f64967a;
            return d.f(replace2);
        } catch (NumberFormatException e2) {
            q.d(e2.getMessage());
            return "";
        }
    }

    public final String getFormattedString() {
        return e(getInputText());
    }

    public String getInputText() {
        String e2 = ba.e(super.getInputText());
        k.a((Object) e2, "RechargeUtils.getCleanAmountString(text)");
        return e2;
    }
}
