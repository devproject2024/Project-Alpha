package net.one97.paytm.paymentsBank.si.view;

import android.content.Context;
import android.graphics.Rect;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import com.business.merchant_payments.common.utility.AppUtility;
import com.google.android.material.textfield.TextInputEditText;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class CustomAmountTextInputEditText extends TextInputEditText {

    /* renamed from: a  reason: collision with root package name */
    private String f18911a = "₹ ";

    /* renamed from: b  reason: collision with root package name */
    private a f18912b;

    /* renamed from: c  reason: collision with root package name */
    private int f18913c = 6;

    /* renamed from: d  reason: collision with root package name */
    private int f18914d = 2;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public boolean f18915e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public boolean f18916f;

    /* renamed from: g  reason: collision with root package name */
    private b f18917g;

    /* renamed from: h  reason: collision with root package name */
    private String f18918h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public String f18919i = "##,##,##,##,###";
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
        private final TextInputEditText f18921b;

        /* renamed from: c  reason: collision with root package name */
        private String f18922c;

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        a(TextInputEditText textInputEditText, String str) {
            net.one97.paytm.paymentsBank.slfd.b.a aVar;
            this.f18921b = textInputEditText;
            this.f18922c = str;
            if (!TextUtils.isEmpty(CustomAmountTextInputEditText.this.getRegex())) {
                aVar = new net.one97.paytm.paymentsBank.slfd.b.a(CustomAmountTextInputEditText.this.getMaxDigitsBeforeDecimalPoint(), CustomAmountTextInputEditText.this.getMaxDigitsAfterDecimalPoint(), CustomAmountTextInputEditText.this.getRegex());
            } else {
                aVar = new net.one97.paytm.paymentsBank.slfd.b.a(CustomAmountTextInputEditText.this.getMaxDigitsBeforeDecimalPoint(), CustomAmountTextInputEditText.this.getMaxDigitsAfterDecimalPoint());
            }
            CustomAmountTextInputEditText.this.setFilters(new InputFilter[]{aVar});
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            boolean unused = CustomAmountTextInputEditText.this.f18915e = false;
            boolean unused2 = CustomAmountTextInputEditText.this.f18916f = false;
        }

        public final void afterTextChanged(Editable editable) {
            this.f18921b.removeTextChangedListener(this);
            this.f18921b.setText(b(editable.toString()));
            TextInputEditText textInputEditText = this.f18921b;
            textInputEditText.setSelection(textInputEditText.getText().toString().length());
            this.f18921b.addTextChangedListener(this);
        }

        private String a(String str) {
            int length = (str.length() - 1) - str.indexOf(AppUtility.CENTER_DOT);
            StringBuilder sb = new StringBuilder();
            if (length != 0 || (CustomAmountTextInputEditText.this.isFocused() && !CustomAmountTextInputEditText.this.f18915e && !CustomAmountTextInputEditText.this.f18916f)) {
                int i2 = 0;
                while (i2 < length && i2 < 2) {
                    sb.append("0");
                    i2++;
                }
            } else {
                sb.append("00");
            }
            return sb.toString();
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
                        format = this.f18922c + AppUtility.CENTER_DOT;
                    } else {
                        format = new DecimalFormat(this.f18922c + CustomAmountTextInputEditText.this.j + a(replaceAll), DecimalFormatSymbols.getInstance(Locale.ENGLISH)).format(new BigDecimal(replaceAll));
                    }
                    return format;
                }
                return new DecimalFormat(this.f18922c + CustomAmountTextInputEditText.this.f18919i, DecimalFormatSymbols.getInstance(Locale.ENGLISH)).format(new BigDecimal(replaceAll));
            } catch (NumberFormatException unused) {
                return "";
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onFocusChanged(boolean z, int i2, Rect rect) {
        super.onFocusChanged(z, i2, rect);
        if (this.f18912b == null) {
            this.f18912b = new a(this, this.f18911a);
        }
        if (z) {
            addTextChangedListener(this.f18912b);
            if (getText().toString().isEmpty()) {
                setText(this.f18911a);
                return;
            }
            return;
        }
        removeTextChangedListener(this.f18912b);
        if (getText().toString().equals(this.f18911a)) {
            setText("");
        }
        setText(this.f18912b.b(getText().toString()));
    }

    public final void a() {
        int i2 = this.f18913c;
        if (i2 <= 3) {
            this.f18913c = i2;
        } else if (i2 <= 5) {
            this.f18913c = i2 + 1;
        } else if (i2 <= 7) {
            this.f18913c = i2 + 2;
        } else if (i2 <= 9) {
            this.f18913c = i2 + 3;
        } else if (i2 <= 11) {
            this.f18913c = i2 + 4;
        }
    }

    public int getMaxDigitsBeforeDecimalPoint() {
        return this.f18913c;
    }

    public void setMaxDigitsBeforeDecimalPoint(int i2) {
        this.f18913c = i2;
        a();
    }

    public int getMaxDigitsAfterDecimalPoint() {
        return this.f18914d;
    }

    public void setMaxDigitsAfterDecimalPoint(int i2) {
        this.f18914d = i2;
    }

    public String getRegex() {
        return this.f18918h;
    }

    public void setRegex(String str) {
        this.f18918h = str;
    }

    public void setDecimalFormat(String str) {
        this.j = str;
    }

    public void setIntegerFormat(String str) {
        this.f18919i = str;
    }

    public boolean onKeyPreIme(int i2, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 1) {
            this.f18915e = true;
            setText(this.f18912b.b(getText().toString()));
            if (this.f18917g != null) {
                getText();
            }
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public void setOnEditTextImeBackListener(b bVar) {
        this.f18917g = bVar;
    }

    public void onEditorAction(int i2) {
        super.onEditorAction(i2);
        if (i2 == 6) {
            this.f18916f = true;
            setText(this.f18912b.b(getText().toString()));
        }
    }

    public String getPrefix() {
        return this.f18911a;
    }

    public void setPrefix(String str) {
        this.f18911a = str;
    }

    public String getCleanString() {
        return getText().toString().replaceAll("[₹, ]", "").trim().replaceAll("^\\s+", "");
    }

    public String getNormalText() {
        return getText().toString().replaceAll("[₹, ]", "").trim().replaceAll("^\\s+", "").replaceAll(AppConstants.COMMA, "");
    }
}
