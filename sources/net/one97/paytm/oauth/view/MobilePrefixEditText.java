package net.one97.paytm.oauth.view;

import android.content.ClipboardManager;
import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.content.b;
import com.paytm.utility.q;
import net.one97.paytm.oauth.R;
import net.one97.paytm.oauth.utils.OAuthUtils;

public class MobilePrefixEditText extends AppCompatEditText {

    /* renamed from: a  reason: collision with root package name */
    private final int f56826a = 11;

    /* renamed from: b  reason: collision with root package name */
    private final String f56827b = "^(\\+91[\\-\\s]?)?[0]?(91)?[6789]\\d{9}$";
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public String f56828c = "+91 ";
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public a f56829d;

    /* renamed from: e  reason: collision with root package name */
    private int f56830e = (this.f56828c.length() + 11);

    /* renamed from: f  reason: collision with root package name */
    private TextWatcher f56831f = new TextWatcher() {

        /* renamed from: a  reason: collision with root package name */
        int f56832a;

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            this.f56832a = MobilePrefixEditText.this.getText().length();
        }

        public final void afterTextChanged(Editable editable) {
            String obj = editable.toString();
            int length = obj.length();
            boolean z = this.f56832a > length;
            if (MobilePrefixEditText.this.getSelectionStart() == MobilePrefixEditText.this.f56828c.length() - 1 && length > MobilePrefixEditText.this.f56828c.length()) {
                MobilePrefixEditText.this.removeTextChangedListener(this);
                String substring = obj.substring(MobilePrefixEditText.this.getSelectionStart());
                MobilePrefixEditText mobilePrefixEditText = MobilePrefixEditText.this;
                mobilePrefixEditText.setText(String.format("%s%s", new Object[]{mobilePrefixEditText.f56828c, substring}));
                MobilePrefixEditText mobilePrefixEditText2 = MobilePrefixEditText.this;
                mobilePrefixEditText2.setSelection(mobilePrefixEditText2.f56828c.length());
                MobilePrefixEditText.this.addTextChangedListener(this);
            } else if (!obj.startsWith(MobilePrefixEditText.this.f56828c)) {
                MobilePrefixEditText.this.removeTextChangedListener(this);
                if (obj.length() < MobilePrefixEditText.this.f56828c.length()) {
                    MobilePrefixEditText mobilePrefixEditText3 = MobilePrefixEditText.this;
                    mobilePrefixEditText3.setText(mobilePrefixEditText3.f56828c);
                    MobilePrefixEditText mobilePrefixEditText4 = MobilePrefixEditText.this;
                    mobilePrefixEditText4.setSelection(mobilePrefixEditText4.length());
                } else if (MobilePrefixEditText.this.getSelectionStart() == MobilePrefixEditText.this.f56828c.length() - 1) {
                    String substring2 = obj.substring(MobilePrefixEditText.this.getSelectionStart());
                    MobilePrefixEditText mobilePrefixEditText5 = MobilePrefixEditText.this;
                    mobilePrefixEditText5.setText(String.format("%s%s", new Object[]{mobilePrefixEditText5.f56828c, substring2}));
                    MobilePrefixEditText mobilePrefixEditText6 = MobilePrefixEditText.this;
                    mobilePrefixEditText6.setSelection(mobilePrefixEditText6.f56828c.length());
                }
                MobilePrefixEditText.this.addTextChangedListener(this);
            } else if (!z) {
                MobilePrefixEditText.this.removeTextChangedListener(this);
                int selectionStart = MobilePrefixEditText.this.getSelectionStart();
                if (selectionStart < obj.length()) {
                    selectionStart--;
                }
                MobilePrefixEditText.a(MobilePrefixEditText.this, obj, selectionStart);
                MobilePrefixEditText.this.addTextChangedListener(this);
            }
            if (MobilePrefixEditText.this.f56829d != null) {
                MobilePrefixEditText.this.f56829d.a(editable);
            }
        }
    };

    public interface a {
        void a(Editable editable);
    }

    public MobilePrefixEditText(Context context) {
        super(context);
        b();
    }

    public MobilePrefixEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b();
    }

    public MobilePrefixEditText(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        b();
    }

    private void b() {
        if (getTag() != null) {
            this.f56828c = getTag().toString();
            this.f56830e = this.f56828c.length() + 11;
        }
        c();
        setFilters(getMobileNumberFilters());
        addTextChangedListener(this.f56831f);
    }

    public boolean onTextContextMenuItem(int i2) {
        String str;
        if (i2 != 16908322 && i2 != 16908337) {
            return super.onTextContextMenuItem(i2);
        }
        ClipboardManager clipboardManager = (ClipboardManager) getContext().getSystemService("clipboard");
        if (clipboardManager.getPrimaryClip() == null || clipboardManager.getPrimaryClip().getItemCount() <= 0 || clipboardManager.getPrimaryClip().getItemAt(0) == null || TextUtils.isEmpty(clipboardManager.getPrimaryClip().getItemAt(0).getText())) {
            return true;
        }
        String replaceAll = clipboardManager.getPrimaryClip().getItemAt(0).getText().toString().replaceAll("\\s", "");
        if (!replaceAll.matches("^(\\+91[\\-\\s]?)?[0]?(91)?[6789]\\d{9}$")) {
            return true;
        }
        if (replaceAll.length() >= 10) {
            str = replaceAll.substring(replaceAll.length() - 10);
        } else {
            str = replaceAll.replace("+91", "");
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.f56828c + OAuthUtils.e(str));
        spannableStringBuilder.setSpan(new StyleSpan(0), 0, str.length(), 18);
        setText(spannableStringBuilder);
        int i3 = this.f56830e;
        if (spannableStringBuilder.length() < this.f56830e) {
            i3 = spannableStringBuilder.length();
        }
        setSelection(i3);
        return true;
    }

    private void c() {
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(b.c(getContext(), R.color.silver));
        int length = this.f56828c.length();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.f56828c);
        spannableStringBuilder.setSpan(foregroundColorSpan, 0, length, 18);
        setText(spannableStringBuilder);
        setSelection(length);
    }

    public void setTextChangedListener(a aVar) {
        this.f56829d = aVar;
    }

    public final void a() {
        c();
        requestFocus();
    }

    private InputFilter[] getMobileNumberFilters() {
        return new InputFilter[]{new InputFilter() {
            public final CharSequence filter(CharSequence charSequence, int i2, int i3, Spanned spanned, int i4, int i5) {
                return MobilePrefixEditText.this.a(charSequence, i2, i3, spanned, i4, i5);
            }
        }, new InputFilter.LengthFilter(this.f56830e)};
    }

    /* access modifiers changed from: private */
    public /* synthetic */ CharSequence a(CharSequence charSequence, int i2, int i3, Spanned spanned, int i4, int i5) {
        if (i4 >= this.f56828c.length()) {
            return null;
        }
        if (!TextUtils.isEmpty(charSequence) && !TextUtils.isEmpty(spanned)) {
            return "";
        }
        if (TextUtils.isEmpty(charSequence)) {
            return String.valueOf(this.f56828c.charAt(i4));
        }
        return null;
    }

    public int getMaxLength() {
        return this.f56830e;
    }

    static /* synthetic */ void a(MobilePrefixEditText mobilePrefixEditText, String str, int i2) {
        String replace = str.replace("+91 ", "").replace(" ", "");
        if (replace.length() > 5) {
            str = "+91 ".concat(String.valueOf(replace.substring(0, 5) + " " + replace.substring(5)));
        }
        if (i2 < str.length()) {
            i2++;
        }
        mobilePrefixEditText.setText(str);
        try {
            if (i2 < str.length()) {
                mobilePrefixEditText.setSelection(i2);
            } else {
                mobilePrefixEditText.setSelection(str.length());
            }
        } catch (IndexOutOfBoundsException e2) {
            q.b(e2.getMessage());
        }
    }
}
