package net.one97.paytm.common.widgets;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.alipay.mobile.h5container.api.H5Param;
import com.paytm.utility.b;
import com.paytm.utility.q;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;

public class CustomEditText extends LinearLayout {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public EditText f49767a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public View f49768b;

    /* renamed from: c  reason: collision with root package name */
    private View f49769c;

    /* renamed from: d  reason: collision with root package name */
    private LinearLayout f49770d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f49771e;

    /* renamed from: f  reason: collision with root package name */
    private String f49772f;

    /* renamed from: g  reason: collision with root package name */
    private int f49773g = 0;

    public interface a {
    }

    private void setShowHint(boolean z) {
    }

    public CustomEditText(Context context) {
        super(context);
        a(context);
    }

    public CustomEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
        a(context, attributeSet);
    }

    public CustomEditText(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context);
        a(context, attributeSet);
    }

    public void setEnabled(boolean z) {
        this.f49767a.setEnabled(z);
    }

    private void a(int i2) {
        int i3 = this.f49773g;
        if (i3 == 0) {
            this.f49773g = i2;
        } else {
            this.f49773g = i2 | i3;
        }
    }

    /* JADX INFO: finally extract failed */
    private void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PasscodeEditText);
        try {
            int integer = obtainStyledAttributes.getInteger(R.styleable.PasscodeEditText_textSize, 0);
            int integer2 = obtainStyledAttributes.getInteger(R.styleable.PasscodeEditText_maxLength, H5Param.WEBVIEW_FONT_SIZE_LARGER);
            int integer3 = obtainStyledAttributes.getInteger(R.styleable.PasscodeEditText_maxLines, 5);
            this.f49772f = obtainStyledAttributes.getString(R.styleable.PasscodeEditText_inputType);
            String string = obtainStyledAttributes.getString(R.styleable.PasscodeEditText_hint);
            ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(R.styleable.PasscodeEditText_textColorHint);
            boolean z = obtainStyledAttributes.getBoolean(R.styleable.PasscodeEditText_singleLine, false);
            boolean z2 = obtainStyledAttributes.getBoolean(R.styleable.PasscodeEditText_password, false);
            boolean z3 = obtainStyledAttributes.getBoolean(R.styleable.PasscodeEditText_isLastEditView, false);
            int integer4 = obtainStyledAttributes.getInteger(R.styleable.PasscodeEditText_fontName, 0);
            obtainStyledAttributes.recycle();
            this.f49767a.setTypeface(Typeface.create("sans-serif", 0));
            if (integer4 != 0) {
                if (integer4 == 1) {
                    b.b((TextView) this.f49767a);
                } else if (integer4 == 2) {
                    b.a(this.f49767a);
                } else if (integer4 == 3) {
                    b.c((TextView) this.f49767a);
                } else if (integer4 == 4) {
                    b.d((TextView) this.f49767a);
                }
            }
            if (integer != 0) {
                this.f49767a.setTextSize(2, (float) integer);
            }
            String str = this.f49772f;
            if (str == null || !str.equalsIgnoreCase("number")) {
                String str2 = this.f49772f;
                if (str2 != null && str2.equalsIgnoreCase("numberDecimal")) {
                    this.f49773g = 8194;
                }
            } else {
                this.f49773g = 2;
            }
            String str3 = this.f49772f;
            if (str3 != null) {
                if (str3.contains("textNoSuggestions")) {
                    a(524288);
                }
                if (this.f49772f.contains("textCapWords")) {
                    a((int) FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE);
                }
                if (this.f49772f.contains("textMultiLine")) {
                    a(131072);
                }
                if (this.f49772f.contains("textEmailAddress")) {
                    a(32);
                }
                this.f49767a.setInputType(this.f49773g);
            }
            if (string != null) {
                this.f49767a.setHint(string);
                this.f49771e.setText(string);
            }
            if (colorStateList != null) {
                this.f49767a.setHintTextColor(colorStateList);
            }
            this.f49767a.setSingleLine(z);
            if (z2) {
                a(129);
                this.f49767a.setInputType(this.f49773g);
                this.f49767a.setTypeface(Typeface.SANS_SERIF);
            }
            this.f49767a.setFilters(new InputFilter[]{new InputFilter.LengthFilter(integer2)});
            this.f49767a.setMaxLines(integer3);
            this.f49767a.setTextColor(-16777216);
            if (z3) {
                this.f49767a.setImeOptions(6);
            } else {
                this.f49767a.setImeOptions(5);
            }
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    public void setMaxLength(int i2) {
        this.f49767a.setFilters(new InputFilter[]{new InputFilter.LengthFilter(i2)});
    }

    public void setUtilityMaxLength(int i2) {
        this.f49767a.setFilters(new InputFilter[]{new f(i2, 3)});
    }

    public void setFilters(InputFilter[] inputFilterArr) {
        this.f49767a.setFilters(inputFilterArr);
    }

    public void setTextSize(int i2) {
        this.f49767a.setTextSize(2, (float) i2);
    }

    public void setText(String str) {
        this.f49767a.setText(str);
    }

    public void setHint(String str) {
        this.f49767a.setHint(str);
        this.f49771e.setText(str);
    }

    public void setHintSpanned(SpannableString spannableString) {
        this.f49767a.setHint(spannableString);
        this.f49771e.setText(spannableString);
    }

    public void setLeftTextPadding(int i2) {
        EditText editText = this.f49767a;
        if (editText != null) {
            editText.setPadding(i2, 0, 0, 0);
        }
    }

    public void setLeftBottomTextPadding(int i2, int i3) {
        EditText editText = this.f49767a;
        if (editText != null) {
            editText.setPadding(i2, 0, 0, i3);
        }
    }

    public String getText() {
        return this.f49767a.getText().toString();
    }

    public void setFocusable(boolean z) {
        this.f49767a.setFocusable(z);
    }

    public void setFocusableInTouchMode(boolean z) {
        this.f49767a.setFocusableInTouchMode(z);
    }

    private void a(final Context context) {
        this.f49769c = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.layout_custom_edit_view, this);
        this.f49770d = (LinearLayout) this.f49769c.findViewById(R.id.lyt_custom_edit_view);
        this.f49767a = (EditText) this.f49769c.findViewById(R.id.edit_view);
        this.f49767a.setEllipsize(TextUtils.TruncateAt.END);
        this.f49768b = this.f49769c.findViewById(R.id.image_underline);
        this.f49771e = (TextView) this.f49769c.findViewById(R.id.floating_hint);
        this.f49771e.setVisibility(8);
        this.f49770d.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                CustomEditText.this.f49767a.requestFocus();
                ((InputMethodManager) context.getSystemService("input_method")).showSoftInput(CustomEditText.this.f49767a, 1);
            }
        });
        this.f49767a.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                if (z) {
                    CustomEditText.this.f49768b.setBackgroundResource(R.drawable.edit_view_divider_selected);
                } else {
                    CustomEditText.this.f49768b.setBackgroundResource(R.drawable.edit_view_divider);
                }
            }
        });
    }

    public void setFocusChangedListener(final View.OnFocusChangeListener onFocusChangeListener) {
        this.f49767a.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                if (z) {
                    CustomEditText.this.f49768b.setBackgroundResource(R.drawable.edit_view_divider_selected);
                } else {
                    CustomEditText.this.f49768b.setBackgroundResource(R.drawable.edit_view_divider);
                }
                onFocusChangeListener.onFocusChange(view, z);
            }
        });
    }

    public EditText getEditText() {
        return this.f49767a;
    }

    public void setTextChangeListener(final a aVar) {
        this.f49767a.addTextChangedListener(new TextWatcher() {
            public final void afterTextChanged(Editable editable) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }
        });
    }

    public void setUnderlineVisibility() {
        this.f49768b.setVisibility(8);
    }

    public void setFocusSelected(boolean z) {
        if (z) {
            try {
                this.f49768b.setBackgroundResource(R.drawable.edit_view_divider_selected);
            } catch (Exception e2) {
                q.b(e2.getMessage());
            }
        } else {
            this.f49768b.setBackgroundResource(R.drawable.edit_view_divider);
        }
    }

    public final void a() {
        this.f49767a.getText().clear();
    }

    public void setInputType(String str) {
        if (str.equals(CJRGiftCardUserInputField.FIELD_TYPE_TEXTBOX)) {
            this.f49767a.setInputType(1);
        } else if (str.equals("number")) {
            this.f49767a.setInputType(2);
        } else if (str.equals("text_and_number")) {
            this.f49767a.setInputType(3);
        } else if (str.equals("decimal_number_type")) {
            this.f49767a.setInputType(8194);
        }
    }

    public void setEditableDisable() {
        this.f49767a.setEnabled(false);
    }

    public void setEditableEnable() {
        this.f49767a.setEnabled(true);
    }

    public void setHintColor(int i2) {
        this.f49767a.setHintTextColor(i2);
    }
}
