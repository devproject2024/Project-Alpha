package net.one97.paytm.recharge.creditcard.widget;

import android.content.Context;
import android.graphics.Rect;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.DigitsKeyListener;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.AutoCompleteTextView;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import com.business.merchant_payments.common.utility.AppUtility;
import com.paytm.utility.q;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.regex.Pattern;
import net.one97.paytm.recharge.di.helper.c;

public class CustomAmountTextInputEditTextV8 extends AppCompatAutoCompleteTextView {

    /* renamed from: a  reason: collision with root package name */
    private String f62626a = "";

    /* renamed from: b  reason: collision with root package name */
    private a f62627b;

    /* renamed from: c  reason: collision with root package name */
    private int f62628c = 6;

    /* renamed from: d  reason: collision with root package name */
    private int f62629d = 2;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public boolean f62630e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public boolean f62631f;

    /* renamed from: g  reason: collision with root package name */
    private b f62632g;

    /* renamed from: h  reason: collision with root package name */
    private String f62633h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public String f62634i = "##,##,##,##,###";
    /* access modifiers changed from: private */
    public String j = "##,##,##,##,###.";
    /* access modifiers changed from: private */
    public TextWatcher k;
    /* access modifiers changed from: private */
    public String l;

    public interface b {
        void a();

        void b();
    }

    public CustomAmountTextInputEditTextV8(Context context) {
        super(context);
    }

    public CustomAmountTextInputEditTextV8(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
        setInputType();
    }

    public void setInputType() {
        setInputType(8194);
    }

    private void a() {
        try {
            c cVar = c.f62654a;
            this.f62628c = Integer.parseInt(c.Z());
            if (this.f62628c == 0) {
                this.f62628c = 6;
            }
        } catch (Exception unused) {
            this.f62628c = 6;
        }
    }

    public CustomAmountTextInputEditTextV8(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
        setInputType(8194);
        setImeOptions(6);
    }

    public class a implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        a f62635a = null;

        /* renamed from: c  reason: collision with root package name */
        private final AutoCompleteTextView f62637c;

        /* renamed from: d  reason: collision with root package name */
        private String f62638d;

        /* renamed from: e  reason: collision with root package name */
        private int f62639e;

        a(AutoCompleteTextView autoCompleteTextView, String str) {
            this.f62637c = autoCompleteTextView;
            this.f62638d = str;
            if (!TextUtils.isEmpty(CustomAmountTextInputEditTextV8.this.getRegex())) {
                this.f62635a = new a(CustomAmountTextInputEditTextV8.this.getMaxDigitsBeforeDecimalPoint(), CustomAmountTextInputEditTextV8.this.getMaxDigitsAfterDecimalPoint(), CustomAmountTextInputEditTextV8.this.getRegex());
            } else {
                this.f62635a = new a(CustomAmountTextInputEditTextV8.this.getMaxDigitsBeforeDecimalPoint(), CustomAmountTextInputEditTextV8.this.getMaxDigitsAfterDecimalPoint());
            }
            CustomAmountTextInputEditTextV8.this.setFilters(new InputFilter[]{this.f62635a});
            CustomAmountTextInputEditTextV8.this.setKeyListener(DigitsKeyListener.getInstance("0123456789,."));
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            String unused = CustomAmountTextInputEditTextV8.this.l = charSequence.toString();
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            this.f62639e = i2 + i3;
            boolean unused = CustomAmountTextInputEditTextV8.this.f62630e = false;
            boolean unused2 = CustomAmountTextInputEditTextV8.this.f62631f = false;
            if (CustomAmountTextInputEditTextV8.this.k != null) {
                CustomAmountTextInputEditTextV8.this.k.onTextChanged(charSequence, i2, i3, i4);
            }
        }

        public final void afterTextChanged(Editable editable) {
            this.f62637c.removeTextChangedListener(this);
            if (CustomAmountTextInputEditTextV8.this.l.contains(AppUtility.CENTER_DOT) && !editable.toString().contains(AppUtility.CENTER_DOT)) {
                String d2 = CustomAmountTextInputEditTextV8.this.l;
                if (d2.contains(AppUtility.CENTER_DOT) && d2.length() - 1 > d2.indexOf(AppUtility.CENTER_DOT)) {
                    int indexOf = CustomAmountTextInputEditTextV8.this.l.indexOf(46);
                    if (indexOf < editable.toString().length()) {
                        editable.insert(indexOf, AppUtility.CENTER_DOT);
                    }
                    int length = editable.toString().length();
                    int i2 = this.f62639e;
                    if (length > i2 - 1) {
                        this.f62637c.setSelection(i2 - 1);
                    }
                }
            }
            String b2 = b(editable.toString());
            editable.replace(0, editable.length(), b2);
            if (!CustomAmountTextInputEditTextV8.this.l.contains(AppUtility.CENTER_DOT)) {
                this.f62637c.setSelection(CustomAmountTextInputEditTextV8.a(CustomAmountTextInputEditTextV8.b(CustomAmountTextInputEditTextV8.this.l.substring(this.f62639e)), b2, -1));
            } else if (this.f62639e < CustomAmountTextInputEditTextV8.this.l.split("\\.")[0].length()) {
                this.f62637c.setSelection(CustomAmountTextInputEditTextV8.a(CustomAmountTextInputEditTextV8.b(CustomAmountTextInputEditTextV8.this.l.substring(this.f62639e)), b2, CustomAmountTextInputEditTextV8.c(b2)));
            } else if (this.f62639e == CustomAmountTextInputEditTextV8.this.l.split("\\.")[0].length() && CustomAmountTextInputEditTextV8.d(editable.toString()) > CustomAmountTextInputEditTextV8.d(CustomAmountTextInputEditTextV8.this.l)) {
                this.f62637c.setSelection(this.f62639e + 2);
            }
            this.f62637c.addTextChangedListener(this);
        }

        private String a(String str) {
            int length = (str.length() - 1) - str.indexOf(AppUtility.CENTER_DOT);
            String str2 = "";
            if (length != 0 || (CustomAmountTextInputEditTextV8.this.isFocused() && !CustomAmountTextInputEditTextV8.this.f62630e && !CustomAmountTextInputEditTextV8.this.f62631f)) {
                int i2 = 0;
                while (i2 < length && i2 < 2) {
                    str2 = str2 + "0";
                    i2++;
                }
                return str2;
            }
            return str2 + "00";
        }

        /* access modifiers changed from: private */
        public String b(String str) {
            String format;
            String replaceAll = str.replaceAll("[₹, ]", "").trim().replaceAll("^\\s+", "");
            try {
                if (TextUtils.isEmpty(replaceAll)) {
                    return "";
                }
                if (replaceAll.contains(AppUtility.CENTER_DOT)) {
                    if (replaceAll.equals(AppUtility.CENTER_DOT)) {
                        format = this.f62638d + AppUtility.CENTER_DOT;
                    } else {
                        format = new DecimalFormat(this.f62638d + CustomAmountTextInputEditTextV8.this.j + a(replaceAll), DecimalFormatSymbols.getInstance(Locale.ENGLISH)).format(new BigDecimal(replaceAll));
                    }
                    return format;
                }
                return new DecimalFormat(this.f62638d + CustomAmountTextInputEditTextV8.this.f62634i, DecimalFormatSymbols.getInstance(Locale.ENGLISH)).format(new BigDecimal(replaceAll));
            } catch (NumberFormatException e2) {
                q.d(e2.getMessage());
                return "";
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onFocusChanged(boolean z, int i2, Rect rect) {
        super.onFocusChanged(z, i2, rect);
        if (this.f62627b == null) {
            this.f62627b = new a(this, this.f62626a);
        }
        if (z) {
            addTextChangedListener(this.f62627b);
            if (getText().toString().isEmpty()) {
                setText(this.f62626a);
                return;
            }
            return;
        }
        removeTextChangedListener(this.f62627b);
        if (getText().toString().equals(this.f62626a)) {
            setText("");
        }
        setText(this.f62627b.b(getText().toString()));
    }

    public int getMaxDigitsBeforeDecimalPoint() {
        return this.f62628c;
    }

    public void setMaxDigitsBeforeDecimalPoint(int i2) {
        this.f62628c = i2;
        int i3 = this.f62628c;
        if (i3 <= 3) {
            this.f62628c = i3;
        } else if (i3 <= 5) {
            this.f62628c = i3 + 1;
        } else if (i3 <= 7) {
            this.f62628c = i3 + 2;
        } else if (i3 <= 9) {
            this.f62628c = i3 + 3;
        } else if (i3 <= 11) {
            this.f62628c = i3 + 4;
        }
    }

    public int getMaxDigitsAfterDecimalPoint() {
        return this.f62629d;
    }

    public void setMaxDigitsAfterDecimalPoint(int i2) {
        this.f62629d = i2;
    }

    public String getRegex() {
        return this.f62633h;
    }

    public void setRegex(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                this.f62633h = str;
            } else {
                int maxDigitsBeforeDecimalPoint = getMaxDigitsBeforeDecimalPoint();
                StringBuilder sb = new StringBuilder("(([₹]{1})?([\\s]{1})?([1-9]{1})([0-9,]{0,");
                sb.append(maxDigitsBeforeDecimalPoint - 1);
                sb.append("})?)");
                this.f62633h = sb.toString();
            }
            if (this.f62627b != null && this.f62627b.f62635a != null) {
                a aVar = this.f62627b.f62635a;
                String regex = getRegex();
                aVar.f62641b = regex;
                aVar.f62640a = Pattern.compile(regex);
            }
        } catch (Exception unused) {
        }
    }

    public void setDecimalFormat(String str) {
        this.j = str;
    }

    public void setIntegerFormat(String str) {
        this.f62634i = str;
    }

    public boolean onKeyPreIme(int i2, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 1) {
            this.f62630e = true;
            setText(this.f62627b.b(getText().toString()));
            b bVar = this.f62632g;
            if (bVar != null) {
                getText();
                bVar.a();
            }
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public void setOnEditTextImeBackListener(b bVar) {
        this.f62632g = bVar;
    }

    public void onEditorAction(int i2) {
        super.onEditorAction(i2);
        if (i2 == 6) {
            this.f62631f = true;
            setText(this.f62627b.b(getText().toString()));
            b bVar = this.f62632g;
            if (bVar != null) {
                bVar.b();
            }
        }
    }

    public String getPrefix() {
        return this.f62626a;
    }

    public void setPrefix(String str) {
        this.f62626a = str;
    }

    public String getCleanString() {
        return getText().toString().replaceAll("[₹, ]", "").trim().replaceAll("^\\s+", "");
    }

    static /* synthetic */ int b(String str) {
        int i2 = 0;
        for (int i3 = 0; i3 < str.length(); i3++) {
            if (Character.isDigit(str.charAt(i3)) || str.charAt(i3) == ',') {
                i2++;
            }
        }
        return i2;
    }

    static /* synthetic */ int c(String str) {
        String[] split = str.split("\\.");
        if (split.length > 1) {
            return split[1].length();
        }
        return 0;
    }

    static /* synthetic */ int a(int i2, String str, int i3) {
        String sb = new StringBuilder(str).reverse().toString();
        int i4 = i2;
        int i5 = 0;
        for (int i6 = 0; i6 < sb.length() && i4 != 0; i6++) {
            if (Character.isDigit(sb.charAt(i6)) || sb.charAt(i6) == ',') {
                i4--;
            }
            i5++;
        }
        if (i5 != sb.length() && (i3 == -1 ? i2 == 3 || i2 == 6 : i3 == 0 ? i2 == 3 || i2 == 6 : i3 == 1 ? i2 == 4 || i2 == 7 : i3 == 2 && (i2 == 5 || i2 == 8))) {
            i5++;
        }
        int length = sb.length() - i5;
        if (length < 0) {
            return 0;
        }
        return length;
    }

    static /* synthetic */ int d(String str) {
        int i2 = 0;
        for (int i3 = 0; i3 < str.length(); i3++) {
            if (str.charAt(i3) == ',') {
                i2++;
            }
        }
        return i2;
    }
}
