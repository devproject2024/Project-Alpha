package net.one97.paytm.common.widgets;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import net.one97.paytm.common.widgets.CustomEditText;

public class EditTextWithLabel extends LinearLayout {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public CustomAutoCompleteTextView f49798a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f49799b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f49800c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public View f49801d;

    /* renamed from: e  reason: collision with root package name */
    private View f49802e;

    /* renamed from: f  reason: collision with root package name */
    private RelativeLayout f49803f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f49804g;

    /* renamed from: h  reason: collision with root package name */
    private String f49805h;

    /* renamed from: i  reason: collision with root package name */
    private int f49806i = 0;

    private void setShowHint(boolean z) {
    }

    public EditTextWithLabel(Context context) {
        super(context);
        a(context);
    }

    public EditTextWithLabel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
        a(context, attributeSet);
    }

    public TextView getRightLabel() {
        return this.f49799b;
    }

    public EditTextWithLabel(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context);
        a(context, attributeSet);
    }

    private void a(int i2) {
        int i3 = this.f49806i;
        if (i3 == 0) {
            this.f49806i = i2;
        } else {
            this.f49806i = i2 | i3;
        }
    }

    public void setLeftTextPadding(int i2) {
        CustomAutoCompleteTextView customAutoCompleteTextView = this.f49798a;
        if (customAutoCompleteTextView != null) {
            customAutoCompleteTextView.setPadding(i2, 0, 0, 0);
        }
    }

    public void setLeftBottomTextPadding(int i2, int i3) {
        CustomAutoCompleteTextView customAutoCompleteTextView = this.f49798a;
        if (customAutoCompleteTextView != null) {
            customAutoCompleteTextView.setPadding(i2, 0, 0, i3);
        }
    }

    public void setEnabled(boolean z) {
        this.f49798a.setEnabled(z);
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x00a7, code lost:
        if (r1 == 0) goto L_0x00ab;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(android.content.Context r14, android.util.AttributeSet r15) {
        /*
            r13 = this;
            int[] r0 = net.one97.paytm.common.widgets.R.styleable.PasscodeEditText
            android.content.res.TypedArray r14 = r14.obtainStyledAttributes(r15, r0)
            int r15 = net.one97.paytm.common.widgets.R.styleable.PasscodeEditText_textSize     // Catch:{ all -> 0x016c }
            r0 = 0
            int r15 = r14.getInteger(r15, r0)     // Catch:{ all -> 0x016c }
            int r1 = net.one97.paytm.common.widgets.R.styleable.PasscodeEditText_labelSize     // Catch:{ all -> 0x016c }
            int r1 = r14.getInteger(r1, r0)     // Catch:{ all -> 0x016c }
            int r2 = net.one97.paytm.common.widgets.R.styleable.PasscodeEditText_maxLength     // Catch:{ all -> 0x016c }
            r3 = 150(0x96, float:2.1E-43)
            int r2 = r14.getInteger(r2, r3)     // Catch:{ all -> 0x016c }
            int r3 = net.one97.paytm.common.widgets.R.styleable.PasscodeEditText_maxLines     // Catch:{ all -> 0x016c }
            r4 = 5
            int r3 = r14.getInteger(r3, r4)     // Catch:{ all -> 0x016c }
            int r5 = net.one97.paytm.common.widgets.R.styleable.PasscodeEditText_inputType     // Catch:{ all -> 0x016c }
            java.lang.String r5 = r14.getString(r5)     // Catch:{ all -> 0x016c }
            r13.f49805h = r5     // Catch:{ all -> 0x016c }
            int r5 = net.one97.paytm.common.widgets.R.styleable.PasscodeEditText_hint     // Catch:{ all -> 0x016c }
            java.lang.String r5 = r14.getString(r5)     // Catch:{ all -> 0x016c }
            int r6 = net.one97.paytm.common.widgets.R.styleable.PasscodeEditText_leftLabel     // Catch:{ all -> 0x016c }
            java.lang.String r6 = r14.getString(r6)     // Catch:{ all -> 0x016c }
            int r7 = net.one97.paytm.common.widgets.R.styleable.PasscodeEditText_rightLabel     // Catch:{ all -> 0x016c }
            java.lang.String r7 = r14.getString(r7)     // Catch:{ all -> 0x016c }
            int r8 = net.one97.paytm.common.widgets.R.styleable.PasscodeEditText_singleLine     // Catch:{ all -> 0x016c }
            boolean r8 = r14.getBoolean(r8, r0)     // Catch:{ all -> 0x016c }
            int r9 = net.one97.paytm.common.widgets.R.styleable.PasscodeEditText_password     // Catch:{ all -> 0x016c }
            boolean r9 = r14.getBoolean(r9, r0)     // Catch:{ all -> 0x016c }
            int r10 = net.one97.paytm.common.widgets.R.styleable.PasscodeEditText_fontName     // Catch:{ all -> 0x016c }
            int r10 = r14.getInteger(r10, r0)     // Catch:{ all -> 0x016c }
            r14.recycle()
            r14 = 1
            r11 = 2
            if (r10 == 0) goto L_0x009f
            if (r10 == r14) goto L_0x0090
            if (r10 == r11) goto L_0x0080
            r12 = 3
            if (r10 == r12) goto L_0x0070
            r12 = 4
            if (r10 == r12) goto L_0x0060
            goto L_0x009f
        L_0x0060:
            net.one97.paytm.common.widgets.CustomAutoCompleteTextView r10 = r13.f49798a
            com.paytm.utility.b.d((android.widget.TextView) r10)
            android.widget.TextView r10 = r13.f49799b
            com.paytm.utility.b.d((android.widget.TextView) r10)
            android.widget.TextView r10 = r13.f49800c
            com.paytm.utility.b.d((android.widget.TextView) r10)
            goto L_0x009f
        L_0x0070:
            net.one97.paytm.common.widgets.CustomAutoCompleteTextView r10 = r13.f49798a
            com.paytm.utility.b.c((android.widget.TextView) r10)
            android.widget.TextView r10 = r13.f49799b
            com.paytm.utility.b.c((android.widget.TextView) r10)
            android.widget.TextView r10 = r13.f49800c
            com.paytm.utility.b.c((android.widget.TextView) r10)
            goto L_0x009f
        L_0x0080:
            net.one97.paytm.common.widgets.CustomAutoCompleteTextView r10 = r13.f49798a
            com.paytm.utility.b.a((android.widget.EditText) r10)
            android.widget.TextView r10 = r13.f49799b
            com.paytm.utility.b.a((android.widget.TextView) r10)
            android.widget.TextView r10 = r13.f49800c
            com.paytm.utility.b.a((android.widget.TextView) r10)
            goto L_0x009f
        L_0x0090:
            net.one97.paytm.common.widgets.CustomAutoCompleteTextView r10 = r13.f49798a
            com.paytm.utility.b.b((android.widget.TextView) r10)
            android.widget.TextView r10 = r13.f49799b
            com.paytm.utility.b.b((android.widget.TextView) r10)
            android.widget.TextView r10 = r13.f49800c
            com.paytm.utility.b.b((android.widget.TextView) r10)
        L_0x009f:
            if (r15 == 0) goto L_0x00aa
            net.one97.paytm.common.widgets.CustomAutoCompleteTextView r10 = r13.f49798a
            float r12 = (float) r15
            r10.setTextSize(r11, r12)
            if (r1 != 0) goto L_0x00aa
            goto L_0x00ab
        L_0x00aa:
            r15 = r1
        L_0x00ab:
            if (r15 == 0) goto L_0x00b8
            android.widget.TextView r1 = r13.f49799b
            float r15 = (float) r15
            r1.setTextSize(r11, r15)
            android.widget.TextView r1 = r13.f49800c
            r1.setTextSize(r11, r15)
        L_0x00b8:
            java.lang.String r15 = r13.f49805h
            if (r15 == 0) goto L_0x00c7
            java.lang.String r1 = "number"
            boolean r15 = r15.equalsIgnoreCase(r1)
            if (r15 == 0) goto L_0x00c7
            r13.f49806i = r11
            goto L_0x00d7
        L_0x00c7:
            java.lang.String r15 = r13.f49805h
            if (r15 == 0) goto L_0x00d7
            java.lang.String r1 = "numberDecimal"
            boolean r15 = r15.equalsIgnoreCase(r1)
            if (r15 == 0) goto L_0x00d7
            r15 = 8194(0x2002, float:1.1482E-41)
            r13.f49806i = r15
        L_0x00d7:
            java.lang.String r15 = r13.f49805h
            if (r15 == 0) goto L_0x0120
            java.lang.String r1 = "textNoSuggestions"
            boolean r15 = r15.contains(r1)
            if (r15 == 0) goto L_0x00e9
            r15 = 524288(0x80000, float:7.34684E-40)
            r13.a((int) r15)
        L_0x00e9:
            java.lang.String r15 = r13.f49805h
            java.lang.String r1 = "textCapWords"
            boolean r15 = r15.contains(r1)
            if (r15 == 0) goto L_0x00f9
            r15 = 8192(0x2000, float:1.14794E-41)
            r13.a((int) r15)
        L_0x00f9:
            java.lang.String r15 = r13.f49805h
            java.lang.String r1 = "textMultiLine"
            boolean r15 = r15.contains(r1)
            if (r15 == 0) goto L_0x0109
            r15 = 131072(0x20000, float:1.83671E-40)
            r13.a((int) r15)
        L_0x0109:
            java.lang.String r15 = r13.f49805h
            java.lang.String r1 = "textEmailAddress"
            boolean r15 = r15.contains(r1)
            if (r15 == 0) goto L_0x0119
            r15 = 32
            r13.a((int) r15)
        L_0x0119:
            net.one97.paytm.common.widgets.CustomAutoCompleteTextView r15 = r13.f49798a
            int r1 = r13.f49806i
            r15.setInputType(r1)
        L_0x0120:
            if (r5 == 0) goto L_0x012c
            net.one97.paytm.common.widgets.CustomAutoCompleteTextView r15 = r13.f49798a
            r15.setHint(r5)
            android.widget.TextView r15 = r13.f49804g
            r15.setText(r5)
        L_0x012c:
            if (r6 == 0) goto L_0x0136
            r13.setLeftLabel(r6)
            android.widget.TextView r15 = r13.f49800c
            r15.setVisibility(r0)
        L_0x0136:
            if (r7 == 0) goto L_0x0140
            r13.setRightLabel(r7)
            android.widget.TextView r15 = r13.f49799b
            r15.setVisibility(r0)
        L_0x0140:
            net.one97.paytm.common.widgets.CustomAutoCompleteTextView r15 = r13.f49798a
            r15.setSingleLine(r8)
            if (r9 == 0) goto L_0x0153
            r15 = 129(0x81, float:1.81E-43)
            r13.a((int) r15)
            net.one97.paytm.common.widgets.CustomAutoCompleteTextView r15 = r13.f49798a
            int r1 = r13.f49806i
            r15.setInputType(r1)
        L_0x0153:
            android.text.InputFilter[] r14 = new android.text.InputFilter[r14]
            android.text.InputFilter$LengthFilter r15 = new android.text.InputFilter$LengthFilter
            r15.<init>(r2)
            r14[r0] = r15
            net.one97.paytm.common.widgets.CustomAutoCompleteTextView r15 = r13.f49798a
            r15.setFilters(r14)
            net.one97.paytm.common.widgets.CustomAutoCompleteTextView r14 = r13.f49798a
            r14.setMaxLines(r3)
            net.one97.paytm.common.widgets.CustomAutoCompleteTextView r14 = r13.f49798a
            r14.setImeOptions(r4)
            return
        L_0x016c:
            r15 = move-exception
            r14.recycle()
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.common.widgets.EditTextWithLabel.a(android.content.Context, android.util.AttributeSet):void");
    }

    public void setNumericKeyBoard() {
        this.f49798a.setInputType(2);
    }

    public void setAlphaNumericKeyBoard() {
        this.f49798a.setInputType(1);
    }

    public void setText(String str) {
        CustomAutoCompleteTextView customAutoCompleteTextView = this.f49798a;
        if (customAutoCompleteTextView != null) {
            customAutoCompleteTextView.setText(str);
        }
    }

    public void setLeftLabel(String str) {
        this.f49800c.setText(str);
    }

    public void setRightLabel(String str) {
        this.f49799b.setText(str);
    }

    public void setRightLabelVisibility(int i2) {
        this.f49799b.setVisibility(i2);
    }

    public void setLeftLabelVisibility(int i2) {
        this.f49800c.setVisibility(i2);
    }

    public void setHint(String str) {
        this.f49798a.setHint(str);
        this.f49804g.setText(str);
    }

    public Editable getText() {
        return this.f49798a.getText();
    }

    public void setFocusable(boolean z) {
        this.f49798a.setFocusable(z);
    }

    public void setFocusableInTouchMode(boolean z) {
        this.f49798a.setFocusableInTouchMode(z);
    }

    public void setRegEx(final String str) {
        this.f49798a.addTextChangedListener(new TextWatcher() {

            /* renamed from: a  reason: collision with root package name */
            String f49807a = "";

            public final void afterTextChanged(Editable editable) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                String charSequence2 = charSequence.toString();
                if (!charSequence2.equals("")) {
                    if (!charSequence2.matches(str)) {
                        EditTextWithLabel.this.f49798a.setText(this.f49807a);
                    } else {
                        this.f49807a = charSequence2;
                    }
                }
            }
        });
    }

    private void a(final Context context) {
        this.f49802e = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.layout_edit_text_with_label, this);
        this.f49803f = (RelativeLayout) this.f49802e.findViewById(R.id.lyt_custom_edit_view);
        this.f49798a = (CustomAutoCompleteTextView) this.f49802e.findViewById(R.id.edit_field);
        this.f49798a.setImeOptions(5);
        this.f49799b = (TextView) this.f49802e.findViewById(R.id.right_label);
        this.f49800c = (TextView) this.f49802e.findViewById(R.id.left_label);
        this.f49798a.setEllipsize(TextUtils.TruncateAt.END);
        this.f49801d = this.f49802e.findViewById(R.id.image_underline);
        this.f49804g = (TextView) this.f49802e.findViewById(R.id.floating_hint);
        this.f49804g.setVisibility(8);
        this.f49803f.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                EditTextWithLabel.this.f49798a.requestFocus();
                ((InputMethodManager) context.getSystemService("input_method")).showSoftInput(EditTextWithLabel.this.f49798a, 1);
            }
        });
        this.f49798a.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                if (z) {
                    EditTextWithLabel.this.f49801d.setBackgroundResource(R.drawable.edit_view_divider_selected);
                } else {
                    EditTextWithLabel.this.f49801d.setBackgroundResource(R.drawable.edit_view_divider);
                }
            }
        });
    }

    public void setSelected(boolean z) {
        if (z) {
            this.f49801d.setBackgroundResource(R.drawable.edit_view_divider_selected);
        } else {
            this.f49801d.setBackgroundResource(R.drawable.edit_view_divider);
        }
    }

    public void setTextSize(int i2) {
        this.f49798a.setTextSize(2, (float) i2);
    }

    public void setTextChangeListener(final CustomEditText.a aVar) {
        this.f49798a.addTextChangedListener(new TextWatcher() {
            public final void afterTextChanged(Editable editable) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }
        });
    }

    public void setMaxLength(int i2) {
        this.f49798a.setFilters(new InputFilter[]{new InputFilter.LengthFilter(i2)});
    }

    public CustomAutoCompleteTextView getAutoCompleteTextView() {
        return this.f49798a;
    }

    public void setImeOption(int i2) {
        this.f49798a.setImeOptions(i2);
    }

    public void setFocusChangedListener(final View.OnFocusChangeListener onFocusChangeListener) {
        this.f49798a.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                if (z) {
                    EditTextWithLabel.this.f49801d.setBackgroundResource(R.drawable.edit_view_divider_selected);
                } else {
                    EditTextWithLabel.this.f49801d.setBackgroundResource(R.drawable.edit_view_divider);
                }
                onFocusChangeListener.onFocusChange(view, z);
            }
        });
    }

    public RelativeLayout getRootLayout() {
        return this.f49803f;
    }

    public void setUnderlineVisibility() {
        this.f49801d.setVisibility(8);
    }
}
