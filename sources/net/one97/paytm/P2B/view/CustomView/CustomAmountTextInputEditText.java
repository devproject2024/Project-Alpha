package net.one97.paytm.p2b.view.CustomView;

import android.content.Context;
import android.graphics.Rect;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import androidx.appcompat.widget.AppCompatEditText;
import com.business.merchant_payments.common.utility.AppUtility;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class CustomAmountTextInputEditText extends AppCompatEditText {

    /* renamed from: a  reason: collision with root package name */
    private String f12842a = "";

    /* renamed from: b  reason: collision with root package name */
    private a f12843b;

    /* renamed from: c  reason: collision with root package name */
    private int f12844c = 6;

    /* renamed from: d  reason: collision with root package name */
    private int f12845d = 2;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public boolean f12846e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public boolean f12847f;

    /* renamed from: g  reason: collision with root package name */
    private b f12848g;

    /* renamed from: h  reason: collision with root package name */
    private String f12849h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public String f12850i = "##,##,##,##,###";
    /* access modifiers changed from: private */
    public String j = "##,##,##,##,###.";

    public interface b {
    }

    public CustomAmountTextInputEditText(Context context) {
        super(context);
    }

    public CustomAmountTextInputEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public CustomAmountTextInputEditText(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        setInputType(8194);
        setImeOptions(6);
    }

    class a implements TextWatcher {

        /* renamed from: b  reason: collision with root package name */
        private final AppCompatEditText f12852b;

        /* renamed from: c  reason: collision with root package name */
        private String f12853c;

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        a(AppCompatEditText appCompatEditText, String str) {
            net.one97.paytm.p2b.d.a aVar;
            this.f12852b = appCompatEditText;
            this.f12853c = str;
            if (!TextUtils.isEmpty(CustomAmountTextInputEditText.this.getRegex())) {
                aVar = new net.one97.paytm.p2b.d.a(CustomAmountTextInputEditText.this.getMaxDigitsBeforeDecimalPoint(), CustomAmountTextInputEditText.this.getMaxDigitsAfterDecimalPoint(), CustomAmountTextInputEditText.this.getRegex());
            } else {
                aVar = new net.one97.paytm.p2b.d.a(CustomAmountTextInputEditText.this.getMaxDigitsBeforeDecimalPoint(), CustomAmountTextInputEditText.this.getMaxDigitsAfterDecimalPoint());
            }
            CustomAmountTextInputEditText.this.setFilters(new InputFilter[]{aVar});
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            boolean unused = CustomAmountTextInputEditText.this.f12846e = false;
            boolean unused2 = CustomAmountTextInputEditText.this.f12847f = false;
        }

        public final void afterTextChanged(Editable editable) {
            this.f12852b.removeTextChangedListener(this);
            this.f12852b.setText(b(editable.toString()));
            AppCompatEditText appCompatEditText = this.f12852b;
            appCompatEditText.setSelection(appCompatEditText.getText().toString().length());
            this.f12852b.addTextChangedListener(this);
        }

        private String a(String str) {
            int length = (str.length() - 1) - str.indexOf(AppUtility.CENTER_DOT);
            String str2 = "";
            if (length != 0 || (CustomAmountTextInputEditText.this.isFocused() && !CustomAmountTextInputEditText.this.f12846e && !CustomAmountTextInputEditText.this.f12847f)) {
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
                        format = this.f12853c + AppUtility.CENTER_DOT;
                    } else {
                        format = new DecimalFormat(this.f12853c + CustomAmountTextInputEditText.this.j + a(replaceAll), DecimalFormatSymbols.getInstance(Locale.ENGLISH)).format(new BigDecimal(replaceAll));
                    }
                    return format;
                }
                return new DecimalFormat(this.f12853c + CustomAmountTextInputEditText.this.f12850i, DecimalFormatSymbols.getInstance(Locale.ENGLISH)).format(new BigDecimal(replaceAll));
            } catch (NumberFormatException unused) {
                return "";
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onFocusChanged(boolean z, int i2, Rect rect) {
        super.onFocusChanged(z, i2, rect);
        if (this.f12843b == null) {
            this.f12843b = new a(this, this.f12842a);
        }
        if (z) {
            addTextChangedListener(this.f12843b);
            if (getText().toString().isEmpty()) {
                setText(this.f12842a);
                return;
            }
            return;
        }
        removeTextChangedListener(this.f12843b);
        if (getText().toString().equals(this.f12842a)) {
            setText("");
        }
        setText(this.f12843b.b(getText().toString()));
    }

    private void a() {
        int i2 = this.f12844c;
        if (i2 <= 3) {
            this.f12844c = i2;
        } else if (i2 <= 5) {
            this.f12844c = i2 + 1;
        } else if (i2 <= 7) {
            this.f12844c = i2 + 2;
        } else if (i2 <= 9) {
            this.f12844c = i2 + 3;
        } else if (i2 <= 11) {
            this.f12844c = i2 + 4;
        }
    }

    public int getMaxDigitsBeforeDecimalPoint() {
        return this.f12844c;
    }

    public void setMaxDigitsBeforeDecimalPoint(int i2) {
        this.f12844c = i2;
        a();
    }

    public int getMaxDigitsAfterDecimalPoint() {
        return this.f12845d;
    }

    public void setMaxDigitsAfterDecimalPoint(int i2) {
        this.f12845d = i2;
    }

    public String getRegex() {
        return this.f12849h;
    }

    public void setRegex(String str) {
        this.f12849h = str;
    }

    public void setDecimalFormat(String str) {
        this.j = str;
    }

    public void setIntegerFormat(String str) {
        this.f12850i = str;
    }

    public boolean onKeyPreIme(int i2, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 1) {
            this.f12846e = true;
            setText(this.f12843b.b(getText().toString()));
            if (this.f12848g != null) {
                getText();
            }
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public void setOnEditTextImeBackListener(b bVar) {
        this.f12848g = bVar;
    }

    public void onEditorAction(int i2) {
        super.onEditorAction(i2);
        if (i2 == 6) {
            this.f12847f = true;
            setText(this.f12843b.b(getText().toString()));
        }
    }

    public String getPrefix() {
        return this.f12842a;
    }

    public void setPrefix(String str) {
        this.f12842a = str;
    }

    public String getCleanString() {
        return getText().toString().replaceAll("[₹, ]", "").trim().replaceAll("^\\s+", "");
    }
}
