package net.one97.paytm.wallet.newdesign.widget;

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
import com.paytm.utility.q;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import net.one97.paytm.wallet.newdesign.universalp2p.utils.CustomAmountAnimatedEditText;

public class CustomAmountTextInputEditText extends AppCompatEditText {

    /* renamed from: a  reason: collision with root package name */
    private String f71461a = "₹ ";

    /* renamed from: b  reason: collision with root package name */
    private a f71462b;

    /* renamed from: c  reason: collision with root package name */
    private int f71463c = 6;

    /* renamed from: d  reason: collision with root package name */
    private int f71464d = 2;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public boolean f71465e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public boolean f71466f;

    /* renamed from: g  reason: collision with root package name */
    private b f71467g;

    /* renamed from: h  reason: collision with root package name */
    private String f71468h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public String f71469i = "##,##,##,##,###";
    /* access modifiers changed from: private */
    public String j = "##,##,##,##,###.";

    public interface b {
        void a();
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
        private final AppCompatEditText f71471b;

        /* renamed from: c  reason: collision with root package name */
        private String f71472c;

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        a(AppCompatEditText appCompatEditText, String str) {
            CustomAmountAnimatedEditText.a aVar;
            this.f71471b = appCompatEditText;
            this.f71472c = str;
            if (!TextUtils.isEmpty(CustomAmountTextInputEditText.this.getRegex())) {
                aVar = new CustomAmountAnimatedEditText.a(CustomAmountTextInputEditText.this.getMaxDigitsBeforeDecimalPoint(), CustomAmountTextInputEditText.this.getMaxDigitsAfterDecimalPoint());
            } else {
                aVar = new CustomAmountAnimatedEditText.a(CustomAmountTextInputEditText.this.getMaxDigitsBeforeDecimalPoint(), CustomAmountTextInputEditText.this.getMaxDigitsAfterDecimalPoint());
            }
            CustomAmountTextInputEditText.this.setFilters(new InputFilter[]{aVar});
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            boolean unused = CustomAmountTextInputEditText.this.f71465e = false;
            boolean unused2 = CustomAmountTextInputEditText.this.f71466f = false;
        }

        public final void afterTextChanged(Editable editable) {
            this.f71471b.removeTextChangedListener(this);
            this.f71471b.setText(b(editable.toString()));
            AppCompatEditText appCompatEditText = this.f71471b;
            appCompatEditText.setSelection(appCompatEditText.getText().toString().length());
            this.f71471b.addTextChangedListener(this);
        }

        private String a(String str) {
            int length = (str.length() - 1) - str.indexOf(AppUtility.CENTER_DOT);
            String str2 = "";
            if (length != 0 || (CustomAmountTextInputEditText.this.isFocused() && !CustomAmountTextInputEditText.this.f71465e && !CustomAmountTextInputEditText.this.f71466f)) {
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
                        format = this.f71472c + AppUtility.CENTER_DOT;
                    } else {
                        format = new DecimalFormat(this.f71472c + CustomAmountTextInputEditText.this.j + a(replaceAll), DecimalFormatSymbols.getInstance(Locale.ENGLISH)).format(new BigDecimal(replaceAll));
                    }
                    return format;
                }
                return new DecimalFormat(this.f71472c + CustomAmountTextInputEditText.this.f71469i, DecimalFormatSymbols.getInstance(Locale.ENGLISH)).format(new BigDecimal(replaceAll));
            } catch (NumberFormatException e2) {
                q.d(String.valueOf(e2));
                return "";
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onFocusChanged(boolean z, int i2, Rect rect) {
        super.onFocusChanged(z, i2, rect);
        if (this.f71462b == null) {
            this.f71462b = new a(this, this.f71461a);
        }
        if (z) {
            addTextChangedListener(this.f71462b);
            if (getText().toString().isEmpty()) {
                setText(this.f71461a);
                return;
            }
            return;
        }
        removeTextChangedListener(this.f71462b);
        if (getText().toString().equals(this.f71461a)) {
            setText("");
        }
        setText(this.f71462b.b(getText().toString()));
    }

    private void a() {
        int i2 = this.f71463c;
        if (i2 <= 3) {
            this.f71463c = i2;
        } else if (i2 <= 5) {
            this.f71463c = i2 + 1;
        } else if (i2 <= 7) {
            this.f71463c = i2 + 2;
        } else if (i2 <= 9) {
            this.f71463c = i2 + 3;
        } else if (i2 <= 11) {
            this.f71463c = i2 + 4;
        }
    }

    public int getMaxDigitsBeforeDecimalPoint() {
        return this.f71463c;
    }

    public void setMaxDigitsBeforeDecimalPoint(int i2) {
        this.f71463c = i2;
        a();
    }

    public int getMaxDigitsAfterDecimalPoint() {
        return this.f71464d;
    }

    public void setMaxDigitsAfterDecimalPoint(int i2) {
        this.f71464d = i2;
    }

    public String getRegex() {
        return this.f71468h;
    }

    public void setRegex(String str) {
        this.f71468h = str;
    }

    public void setDecimalFormat(String str) {
        this.j = str;
    }

    public void setIntegerFormat(String str) {
        this.f71469i = str;
    }

    public boolean onKeyPreIme(int i2, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 1) {
            this.f71465e = true;
            setText(this.f71462b.b(getText().toString()));
            b bVar = this.f71467g;
            if (bVar != null) {
                getText();
                bVar.a();
            }
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public void setOnEditTextImeBackListener(b bVar) {
        this.f71467g = bVar;
    }

    public void onEditorAction(int i2) {
        super.onEditorAction(i2);
        if (i2 == 6) {
            this.f71466f = true;
            setText(this.f71462b.b(getText().toString()));
        }
    }

    public String getPrefix() {
        return this.f71461a;
    }

    public void setPrefix(String str) {
        this.f71461a = str;
    }

    public String getCleanString() {
        return getText().toString().replaceAll("[₹, ]", "").trim().replaceAll("^\\s+", "");
    }
}
