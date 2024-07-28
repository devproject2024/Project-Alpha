package net.one97.paytm.upi.common;

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
    private static final int MAX_DECIMAL = 2;
    /* access modifiers changed from: private */
    public String decimalFormat = "##,##,##,##,###.";
    private String filterRegex;
    /* access modifiers changed from: private */
    public String integerFormat = "##,##,##,##,###";
    /* access modifiers changed from: private */
    public boolean isBackPressed;
    /* access modifiers changed from: private */
    public boolean isImeActionDone;
    private a mCurrencyTextWatcher;
    private EditTextImeBackListener mOnImeBack;
    private int maxDigitsAfterDecimal = 2;
    private int maxDigitsBeforeDecimal = 6;
    private String prefix = "";

    public interface EditTextImeBackListener {
        void onImeBack(CustomAmountTextInputEditText customAmountTextInputEditText, String str);
    }

    public CustomAmountTextInputEditText(Context context) {
        super(context);
    }

    public CustomAmountTextInputEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        addCommasInLength();
    }

    public CustomAmountTextInputEditText(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        setInputType(8194);
        setImeOptions(6);
    }

    class a implements TextWatcher {

        /* renamed from: b  reason: collision with root package name */
        private final AppCompatEditText f66631b;

        /* renamed from: c  reason: collision with root package name */
        private String f66632c;

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        a(AppCompatEditText appCompatEditText, String str) {
            AmountInputFilter amountInputFilter;
            this.f66631b = appCompatEditText;
            this.f66632c = str;
            if (!TextUtils.isEmpty(CustomAmountTextInputEditText.this.getRegex())) {
                amountInputFilter = new AmountInputFilter(CustomAmountTextInputEditText.this.getMaxDigitsBeforeDecimalPoint(), CustomAmountTextInputEditText.this.getMaxDigitsAfterDecimalPoint(), CustomAmountTextInputEditText.this.getRegex());
            } else {
                amountInputFilter = new AmountInputFilter(CustomAmountTextInputEditText.this.getMaxDigitsBeforeDecimalPoint(), CustomAmountTextInputEditText.this.getMaxDigitsAfterDecimalPoint());
            }
            CustomAmountTextInputEditText.this.setFilters(new InputFilter[]{amountInputFilter});
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            boolean unused = CustomAmountTextInputEditText.this.isBackPressed = false;
            boolean unused2 = CustomAmountTextInputEditText.this.isImeActionDone = false;
        }

        public final void afterTextChanged(Editable editable) {
            this.f66631b.removeTextChangedListener(this);
            this.f66631b.setText(b(editable.toString()));
            AppCompatEditText appCompatEditText = this.f66631b;
            appCompatEditText.setSelection(appCompatEditText.getText().toString().length());
            this.f66631b.addTextChangedListener(this);
        }

        private String a(String str) {
            int length = (str.length() - 1) - str.indexOf(AppUtility.CENTER_DOT);
            String str2 = "";
            if (length != 0 || (CustomAmountTextInputEditText.this.isFocused() && !CustomAmountTextInputEditText.this.isBackPressed && !CustomAmountTextInputEditText.this.isImeActionDone)) {
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
                        format = this.f66632c + AppUtility.CENTER_DOT;
                    } else {
                        format = new DecimalFormat(this.f66632c + CustomAmountTextInputEditText.this.decimalFormat + a(replaceAll), DecimalFormatSymbols.getInstance(Locale.ENGLISH)).format(new BigDecimal(replaceAll));
                    }
                    return format;
                }
                return new DecimalFormat(this.f66632c + CustomAmountTextInputEditText.this.integerFormat, DecimalFormatSymbols.getInstance(Locale.ENGLISH)).format(new BigDecimal(replaceAll));
            } catch (NumberFormatException e2) {
                e2.printStackTrace();
                return "";
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onFocusChanged(boolean z, int i2, Rect rect) {
        super.onFocusChanged(z, i2, rect);
        if (this.mCurrencyTextWatcher == null) {
            this.mCurrencyTextWatcher = new a(this, this.prefix);
        }
        if (z) {
            addTextChangedListener(this.mCurrencyTextWatcher);
            if (getText().toString().isEmpty()) {
                setText(this.prefix);
                return;
            }
            return;
        }
        removeTextChangedListener(this.mCurrencyTextWatcher);
        if (getText().toString().equals(this.prefix)) {
            setText("");
        }
        setText(this.mCurrencyTextWatcher.b(getText().toString()));
    }

    public void addCommasInLength() {
        int i2 = this.maxDigitsBeforeDecimal;
        if (i2 <= 3) {
            this.maxDigitsBeforeDecimal = i2;
        } else if (i2 <= 5) {
            this.maxDigitsBeforeDecimal = i2 + 1;
        } else if (i2 <= 7) {
            this.maxDigitsBeforeDecimal = i2 + 2;
        } else if (i2 <= 9) {
            this.maxDigitsBeforeDecimal = i2 + 3;
        } else if (i2 <= 11) {
            this.maxDigitsBeforeDecimal = i2 + 4;
        }
    }

    public int getMaxDigitsBeforeDecimalPoint() {
        return this.maxDigitsBeforeDecimal;
    }

    public void setMaxDigitsBeforeDecimalPoint(int i2) {
        this.maxDigitsBeforeDecimal = i2;
        addCommasInLength();
    }

    public int getMaxDigitsAfterDecimalPoint() {
        return this.maxDigitsAfterDecimal;
    }

    public void setMaxDigitsAfterDecimalPoint(int i2) {
        this.maxDigitsAfterDecimal = i2;
    }

    public String getRegex() {
        return this.filterRegex;
    }

    public void setRegex(String str) {
        this.filterRegex = str;
    }

    public void setDecimalFormat(String str) {
        this.decimalFormat = str;
    }

    public void setIntegerFormat(String str) {
        this.integerFormat = str;
    }

    public boolean onKeyPreIme(int i2, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 1) {
            this.isBackPressed = true;
            setText(this.mCurrencyTextWatcher.b(getText().toString()));
            EditTextImeBackListener editTextImeBackListener = this.mOnImeBack;
            if (editTextImeBackListener != null) {
                editTextImeBackListener.onImeBack(this, getText().toString());
            }
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public void setOnEditTextImeBackListener(EditTextImeBackListener editTextImeBackListener) {
        this.mOnImeBack = editTextImeBackListener;
    }

    public void onEditorAction(int i2) {
        super.onEditorAction(i2);
        if (i2 == 6) {
            this.isImeActionDone = true;
            setText(this.mCurrencyTextWatcher.b(getText().toString()));
        }
    }

    public String getPrefix() {
        return this.prefix;
    }

    public void setPrefix(String str) {
        this.prefix = str;
    }

    public String getCleanString() {
        return getText().toString().replaceAll("[₹, ]", "").trim().replaceAll("^\\s+", "");
    }
}
