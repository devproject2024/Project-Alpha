package net.one97.paytm.paymentsBank.slfd.view;

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
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class CustomAmountTextInputEditText extends TextInputEditText {

    /* renamed from: a  reason: collision with root package name */
    private String f19402a = "₹ ";

    /* renamed from: b  reason: collision with root package name */
    private a f19403b;

    /* renamed from: c  reason: collision with root package name */
    private int f19404c = 6;

    /* renamed from: d  reason: collision with root package name */
    private int f19405d = 2;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public boolean f19406e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public boolean f19407f;

    /* renamed from: g  reason: collision with root package name */
    private b f19408g;

    /* renamed from: h  reason: collision with root package name */
    private String f19409h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public String f19410i = "##,##,##,##,###";
    /* access modifiers changed from: private */
    public String j = "##,##,##,##,###.";
    private c k;

    public interface b {
    }

    public interface c {
        void a(boolean z);
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

    public void setFocusChangeListener(c cVar) {
        this.k = cVar;
    }

    /* access modifiers changed from: protected */
    public void onFocusChanged(boolean z, int i2, Rect rect) {
        super.onFocusChanged(z, i2, rect);
        c cVar = this.k;
        if (cVar != null) {
            cVar.a(z);
        }
        if (this.f19403b == null) {
            this.f19403b = new a(this, this.f19402a);
        }
        if (z) {
            addTextChangedListener(this.f19403b);
            if (getText().toString().isEmpty()) {
                setText(this.f19402a);
                return;
            }
            return;
        }
        removeTextChangedListener(this.f19403b);
        if (getText().toString().equals(this.f19402a)) {
            setText("");
        }
        setText(this.f19403b.b(getText().toString()));
    }

    public final void a() {
        int i2 = this.f19404c;
        if (i2 <= 3) {
            this.f19404c = i2;
        } else if (i2 <= 5) {
            this.f19404c = i2 + 1;
        } else if (i2 <= 7) {
            this.f19404c = i2 + 2;
        } else if (i2 <= 9) {
            this.f19404c = i2 + 3;
        } else if (i2 <= 11) {
            this.f19404c = i2 + 4;
        }
    }

    public int getMaxDigitsBeforeDecimalPoint() {
        return this.f19404c;
    }

    public void setMaxDigitsBeforeDecimalPoint(int i2) {
        this.f19404c = i2;
        a();
    }

    public int getMaxDigitsAfterDecimalPoint() {
        return this.f19405d;
    }

    public void setMaxDigitsAfterDecimalPoint(int i2) {
        this.f19405d = i2;
    }

    public String getRegex() {
        return this.f19409h;
    }

    public void setRegex(String str) {
        this.f19409h = str;
    }

    public void setDecimalFormat(String str) {
        this.j = str;
    }

    public void setIntegerFormat(String str) {
        this.f19410i = str;
    }

    public boolean onKeyPreIme(int i2, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 1) {
            this.f19406e = true;
            setText(this.f19403b.b(getText().toString()));
            if (this.f19408g != null) {
                getText();
            }
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public void setOnEditTextImeBackListener(b bVar) {
        this.f19408g = bVar;
    }

    public void onEditorAction(int i2) {
        super.onEditorAction(i2);
        if (i2 == 6) {
            this.f19407f = true;
            setText(this.f19403b.b(getText().toString()));
        }
    }

    public String getPrefix() {
        return this.f19402a;
    }

    public void setPrefix(String str) {
        this.f19402a = str;
    }

    public String getCleanString() {
        return getText().toString().replaceAll("[₹, ]", "").trim().replaceAll("^\\s+", "");
    }

    class a implements TextWatcher {

        /* renamed from: b  reason: collision with root package name */
        private final TextInputEditText f19412b;

        /* renamed from: c  reason: collision with root package name */
        private String f19413c;

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        a(TextInputEditText textInputEditText, String str) {
            net.one97.paytm.paymentsBank.slfd.b.a aVar;
            this.f19412b = textInputEditText;
            this.f19413c = str;
            if (!TextUtils.isEmpty(CustomAmountTextInputEditText.this.getRegex())) {
                aVar = new net.one97.paytm.paymentsBank.slfd.b.a(CustomAmountTextInputEditText.this.getMaxDigitsBeforeDecimalPoint(), CustomAmountTextInputEditText.this.getMaxDigitsAfterDecimalPoint(), CustomAmountTextInputEditText.this.getRegex());
            } else {
                aVar = new net.one97.paytm.paymentsBank.slfd.b.a(CustomAmountTextInputEditText.this.getMaxDigitsBeforeDecimalPoint(), CustomAmountTextInputEditText.this.getMaxDigitsAfterDecimalPoint());
            }
            CustomAmountTextInputEditText.this.setFilters(new InputFilter[]{aVar});
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            boolean unused = CustomAmountTextInputEditText.this.f19406e = false;
            boolean unused2 = CustomAmountTextInputEditText.this.f19407f = false;
        }

        public final void afterTextChanged(Editable editable) {
            this.f19412b.removeTextChangedListener(this);
            this.f19412b.setText(b(editable.toString()));
            TextInputEditText textInputEditText = this.f19412b;
            textInputEditText.setSelection(textInputEditText.getText().toString().length());
            this.f19412b.addTextChangedListener(this);
        }

        private String a(String str) {
            int length = (str.length() - 1) - str.indexOf(AppUtility.CENTER_DOT);
            StringBuilder sb = new StringBuilder();
            if (length != 0 || (CustomAmountTextInputEditText.this.isFocused() && !CustomAmountTextInputEditText.this.f19406e && !CustomAmountTextInputEditText.this.f19407f)) {
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
                        format = this.f19413c + AppUtility.CENTER_DOT;
                    } else {
                        format = new DecimalFormat(this.f19413c + CustomAmountTextInputEditText.this.j + a(replaceAll), DecimalFormatSymbols.getInstance(Locale.ENGLISH)).format(new BigDecimal(replaceAll));
                    }
                    return format;
                }
                return new DecimalFormat(this.f19413c + CustomAmountTextInputEditText.this.f19410i, DecimalFormatSymbols.getInstance(Locale.ENGLISH)).format(new BigDecimal(replaceAll));
            } catch (NumberFormatException e2) {
                e2.printStackTrace();
                return "";
            }
        }
    }
}
