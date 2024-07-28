package net.one97.paytm.addmoney.utils;

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
    private String f48919a = "₹ ";

    /* renamed from: b  reason: collision with root package name */
    private a f48920b;

    /* renamed from: c  reason: collision with root package name */
    private int f48921c = 6;

    /* renamed from: d  reason: collision with root package name */
    private int f48922d = 2;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public boolean f48923e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public boolean f48924f;

    /* renamed from: g  reason: collision with root package name */
    private b f48925g;

    /* renamed from: h  reason: collision with root package name */
    private String f48926h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public String f48927i = "##,##,##,##,###";
    /* access modifiers changed from: private */
    public String j = "##,##,##,##,###.";

    public interface b {
    }

    public void setRangeForAmount(String str, String str2) {
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
        private final TextInputEditText f48929b;

        /* renamed from: c  reason: collision with root package name */
        private String f48930c;

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        a(TextInputEditText textInputEditText, String str) {
            i iVar;
            this.f48929b = textInputEditText;
            this.f48930c = str;
            if (!TextUtils.isEmpty(CustomAmountTextInputEditText.this.getRegex())) {
                iVar = new i(CustomAmountTextInputEditText.this.getMaxDigitsBeforeDecimalPoint(), CustomAmountTextInputEditText.this.getMaxDigitsAfterDecimalPoint(), CustomAmountTextInputEditText.this.getRegex());
            } else {
                iVar = new i(CustomAmountTextInputEditText.this.getMaxDigitsBeforeDecimalPoint(), CustomAmountTextInputEditText.this.getMaxDigitsAfterDecimalPoint());
            }
            CustomAmountTextInputEditText.this.setFilters(new InputFilter[]{iVar});
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            boolean unused = CustomAmountTextInputEditText.this.f48923e = false;
            boolean unused2 = CustomAmountTextInputEditText.this.f48924f = false;
        }

        public final void afterTextChanged(Editable editable) {
            this.f48929b.removeTextChangedListener(this);
            this.f48929b.setText(b(editable.toString()));
            TextInputEditText textInputEditText = this.f48929b;
            textInputEditText.setSelection(textInputEditText.getText().toString().length());
            this.f48929b.addTextChangedListener(this);
        }

        private String a(String str) {
            int length = (str.length() - 1) - str.indexOf(AppUtility.CENTER_DOT);
            String str2 = "";
            if (length != 0 || (CustomAmountTextInputEditText.this.isFocused() && !CustomAmountTextInputEditText.this.f48923e && !CustomAmountTextInputEditText.this.f48924f)) {
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
                        format = this.f48930c + AppUtility.CENTER_DOT;
                    } else {
                        format = new DecimalFormat(this.f48930c + CustomAmountTextInputEditText.this.j + a(replaceAll), DecimalFormatSymbols.getInstance(Locale.ENGLISH)).format(new BigDecimal(replaceAll));
                    }
                    return format;
                }
                return new DecimalFormat(this.f48930c + CustomAmountTextInputEditText.this.f48927i, DecimalFormatSymbols.getInstance(Locale.ENGLISH)).format(new BigDecimal(replaceAll));
            } catch (NumberFormatException e2) {
                e2.printStackTrace();
                return "";
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onFocusChanged(boolean z, int i2, Rect rect) {
        super.onFocusChanged(z, i2, rect);
        if (this.f48920b == null) {
            this.f48920b = new a(this, this.f48919a);
        }
        if (z) {
            addTextChangedListener(this.f48920b);
            if (getText().toString().isEmpty()) {
                setText(this.f48919a);
                return;
            }
            return;
        }
        removeTextChangedListener(this.f48920b);
        if (getText().toString().equals(this.f48919a)) {
            setText("");
        }
        setText(this.f48920b.b(getText().toString()));
    }

    private void a() {
        int i2 = this.f48921c;
        if (i2 <= 3) {
            this.f48921c = i2;
        } else if (i2 <= 5) {
            this.f48921c = i2 + 1;
        } else if (i2 <= 7) {
            this.f48921c = i2 + 2;
        } else if (i2 <= 9) {
            this.f48921c = i2 + 3;
        } else if (i2 <= 11) {
            this.f48921c = i2 + 4;
        }
    }

    public int getMaxDigitsBeforeDecimalPoint() {
        return this.f48921c;
    }

    public void setMaxDigitsBeforeDecimalPoint(int i2) {
        this.f48921c = i2;
        a();
    }

    public int getMaxDigitsAfterDecimalPoint() {
        return this.f48922d;
    }

    public void setMaxDigitsAfterDecimalPoint(int i2) {
        this.f48922d = i2;
    }

    public String getRegex() {
        return this.f48926h;
    }

    public void setRegex(String str) {
        this.f48926h = str;
    }

    public void setDecimalFormat(String str) {
        this.j = str;
    }

    public void setIntegerFormat(String str) {
        this.f48927i = str;
    }

    public boolean onKeyPreIme(int i2, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 1) {
            this.f48923e = true;
            setText(this.f48920b.b(getText().toString()));
            if (this.f48925g != null) {
                getText();
            }
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public void setOnEditTextImeBackListener(b bVar) {
        this.f48925g = bVar;
    }

    public void onEditorAction(int i2) {
        super.onEditorAction(i2);
        if (i2 == 6) {
            this.f48924f = true;
            setText(this.f48920b.b(getText().toString()));
        }
    }

    public String getPrefix() {
        return this.f48919a;
    }

    public void setPrefix(String str) {
        this.f48919a = str;
    }

    public String getCleanString() {
        return getText().toString().replaceAll("[₹, ]", "").trim().replaceAll("^\\s+", "");
    }
}
