package net.one97.paytm.common.widgets;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import net.one97.paytm.common.widgets.CustomEditText;

public class AutoCompleteField extends LinearLayout {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public AutoCompleteTextView f49671a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f49672b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f49673c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public View f49674d;

    /* renamed from: e  reason: collision with root package name */
    private View f49675e;

    /* renamed from: f  reason: collision with root package name */
    private RelativeLayout f49676f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f49677g;

    /* renamed from: h  reason: collision with root package name */
    private String f49678h;

    /* renamed from: i  reason: collision with root package name */
    private int f49679i = 0;

    private void setShowHint(boolean z) {
    }

    public AutoCompleteField(Context context) {
        super(context);
        a(context);
    }

    public AutoCompleteField(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
        a(context, attributeSet);
    }

    public AutoCompleteField(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context);
        a(context, attributeSet);
    }

    private void a(int i2) {
        int i3 = this.f49679i;
        if (i3 == 0) {
            this.f49679i = i2;
        } else {
            this.f49679i = i2 | i3;
        }
    }

    public void setLeftTextPadding(int i2) {
        AutoCompleteTextView autoCompleteTextView = this.f49671a;
        if (autoCompleteTextView != null) {
            autoCompleteTextView.setPadding(i2, 0, 0, 0);
        }
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x00a7, code lost:
        if (r1 == 0) goto L_0x00ab;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(android.content.Context r13, android.util.AttributeSet r14) {
        /*
            r12 = this;
            int[] r0 = net.one97.paytm.common.widgets.R.styleable.PasscodeEditText
            android.content.res.TypedArray r13 = r13.obtainStyledAttributes(r14, r0)
            int r14 = net.one97.paytm.common.widgets.R.styleable.PasscodeEditText_textSize     // Catch:{ all -> 0x0167 }
            r0 = 0
            int r14 = r13.getInteger(r14, r0)     // Catch:{ all -> 0x0167 }
            int r1 = net.one97.paytm.common.widgets.R.styleable.PasscodeEditText_labelSize     // Catch:{ all -> 0x0167 }
            int r1 = r13.getInteger(r1, r0)     // Catch:{ all -> 0x0167 }
            int r2 = net.one97.paytm.common.widgets.R.styleable.PasscodeEditText_maxLength     // Catch:{ all -> 0x0167 }
            r3 = 150(0x96, float:2.1E-43)
            int r2 = r13.getInteger(r2, r3)     // Catch:{ all -> 0x0167 }
            int r3 = net.one97.paytm.common.widgets.R.styleable.PasscodeEditText_maxLines     // Catch:{ all -> 0x0167 }
            r4 = 5
            int r3 = r13.getInteger(r3, r4)     // Catch:{ all -> 0x0167 }
            int r4 = net.one97.paytm.common.widgets.R.styleable.PasscodeEditText_inputType     // Catch:{ all -> 0x0167 }
            java.lang.String r4 = r13.getString(r4)     // Catch:{ all -> 0x0167 }
            r12.f49678h = r4     // Catch:{ all -> 0x0167 }
            int r4 = net.one97.paytm.common.widgets.R.styleable.PasscodeEditText_hint     // Catch:{ all -> 0x0167 }
            java.lang.String r4 = r13.getString(r4)     // Catch:{ all -> 0x0167 }
            int r5 = net.one97.paytm.common.widgets.R.styleable.PasscodeEditText_leftLabel     // Catch:{ all -> 0x0167 }
            java.lang.String r5 = r13.getString(r5)     // Catch:{ all -> 0x0167 }
            int r6 = net.one97.paytm.common.widgets.R.styleable.PasscodeEditText_rightLabel     // Catch:{ all -> 0x0167 }
            java.lang.String r6 = r13.getString(r6)     // Catch:{ all -> 0x0167 }
            int r7 = net.one97.paytm.common.widgets.R.styleable.PasscodeEditText_singleLine     // Catch:{ all -> 0x0167 }
            boolean r7 = r13.getBoolean(r7, r0)     // Catch:{ all -> 0x0167 }
            int r8 = net.one97.paytm.common.widgets.R.styleable.PasscodeEditText_password     // Catch:{ all -> 0x0167 }
            boolean r8 = r13.getBoolean(r8, r0)     // Catch:{ all -> 0x0167 }
            int r9 = net.one97.paytm.common.widgets.R.styleable.PasscodeEditText_fontName     // Catch:{ all -> 0x0167 }
            int r9 = r13.getInteger(r9, r0)     // Catch:{ all -> 0x0167 }
            r13.recycle()
            r13 = 1
            r10 = 2
            if (r9 == 0) goto L_0x009f
            if (r9 == r13) goto L_0x0090
            if (r9 == r10) goto L_0x0080
            r11 = 3
            if (r9 == r11) goto L_0x0070
            r11 = 4
            if (r9 == r11) goto L_0x0060
            goto L_0x009f
        L_0x0060:
            android.widget.AutoCompleteTextView r9 = r12.f49671a
            com.paytm.utility.b.d((android.widget.TextView) r9)
            android.widget.TextView r9 = r12.f49672b
            com.paytm.utility.b.d((android.widget.TextView) r9)
            android.widget.TextView r9 = r12.f49673c
            com.paytm.utility.b.d((android.widget.TextView) r9)
            goto L_0x009f
        L_0x0070:
            android.widget.AutoCompleteTextView r9 = r12.f49671a
            com.paytm.utility.b.c((android.widget.TextView) r9)
            android.widget.TextView r9 = r12.f49672b
            com.paytm.utility.b.c((android.widget.TextView) r9)
            android.widget.TextView r9 = r12.f49673c
            com.paytm.utility.b.c((android.widget.TextView) r9)
            goto L_0x009f
        L_0x0080:
            android.widget.AutoCompleteTextView r9 = r12.f49671a
            com.paytm.utility.b.a((android.widget.EditText) r9)
            android.widget.TextView r9 = r12.f49672b
            com.paytm.utility.b.a((android.widget.TextView) r9)
            android.widget.TextView r9 = r12.f49673c
            com.paytm.utility.b.a((android.widget.TextView) r9)
            goto L_0x009f
        L_0x0090:
            android.widget.AutoCompleteTextView r9 = r12.f49671a
            com.paytm.utility.b.b((android.widget.TextView) r9)
            android.widget.TextView r9 = r12.f49672b
            com.paytm.utility.b.b((android.widget.TextView) r9)
            android.widget.TextView r9 = r12.f49673c
            com.paytm.utility.b.b((android.widget.TextView) r9)
        L_0x009f:
            if (r14 == 0) goto L_0x00aa
            android.widget.AutoCompleteTextView r9 = r12.f49671a
            float r11 = (float) r14
            r9.setTextSize(r10, r11)
            if (r1 != 0) goto L_0x00aa
            goto L_0x00ab
        L_0x00aa:
            r14 = r1
        L_0x00ab:
            if (r14 == 0) goto L_0x00b8
            android.widget.TextView r1 = r12.f49672b
            float r14 = (float) r14
            r1.setTextSize(r10, r14)
            android.widget.TextView r1 = r12.f49673c
            r1.setTextSize(r10, r14)
        L_0x00b8:
            java.lang.String r14 = r12.f49678h
            if (r14 == 0) goto L_0x00c7
            java.lang.String r1 = "number"
            boolean r14 = r14.equalsIgnoreCase(r1)
            if (r14 == 0) goto L_0x00c7
            r12.f49679i = r10
            goto L_0x00d7
        L_0x00c7:
            java.lang.String r14 = r12.f49678h
            if (r14 == 0) goto L_0x00d7
            java.lang.String r1 = "numberDecimal"
            boolean r14 = r14.equalsIgnoreCase(r1)
            if (r14 == 0) goto L_0x00d7
            r14 = 8194(0x2002, float:1.1482E-41)
            r12.f49679i = r14
        L_0x00d7:
            java.lang.String r14 = r12.f49678h
            if (r14 == 0) goto L_0x0120
            java.lang.String r1 = "textNoSuggestions"
            boolean r14 = r14.contains(r1)
            if (r14 == 0) goto L_0x00e9
            r14 = 524288(0x80000, float:7.34684E-40)
            r12.a((int) r14)
        L_0x00e9:
            java.lang.String r14 = r12.f49678h
            java.lang.String r1 = "textCapWords"
            boolean r14 = r14.contains(r1)
            if (r14 == 0) goto L_0x00f9
            r14 = 8192(0x2000, float:1.14794E-41)
            r12.a((int) r14)
        L_0x00f9:
            java.lang.String r14 = r12.f49678h
            java.lang.String r1 = "textMultiLine"
            boolean r14 = r14.contains(r1)
            if (r14 == 0) goto L_0x0109
            r14 = 131072(0x20000, float:1.83671E-40)
            r12.a((int) r14)
        L_0x0109:
            java.lang.String r14 = r12.f49678h
            java.lang.String r1 = "textEmailAddress"
            boolean r14 = r14.contains(r1)
            if (r14 == 0) goto L_0x0119
            r14 = 32
            r12.a((int) r14)
        L_0x0119:
            android.widget.AutoCompleteTextView r14 = r12.f49671a
            int r1 = r12.f49679i
            r14.setInputType(r1)
        L_0x0120:
            if (r4 == 0) goto L_0x012c
            android.widget.AutoCompleteTextView r14 = r12.f49671a
            r14.setHint(r4)
            android.widget.TextView r14 = r12.f49677g
            r14.setText(r4)
        L_0x012c:
            if (r5 == 0) goto L_0x0136
            r12.setLeftLabel(r5)
            android.widget.TextView r14 = r12.f49673c
            r14.setVisibility(r0)
        L_0x0136:
            if (r6 == 0) goto L_0x0140
            r12.setRightLabel(r6)
            android.widget.TextView r14 = r12.f49672b
            r14.setVisibility(r0)
        L_0x0140:
            android.widget.AutoCompleteTextView r14 = r12.f49671a
            r14.setSingleLine(r7)
            if (r8 == 0) goto L_0x0153
            r14 = 129(0x81, float:1.81E-43)
            r12.a((int) r14)
            android.widget.AutoCompleteTextView r14 = r12.f49671a
            int r1 = r12.f49679i
            r14.setInputType(r1)
        L_0x0153:
            android.text.InputFilter[] r13 = new android.text.InputFilter[r13]
            android.text.InputFilter$LengthFilter r14 = new android.text.InputFilter$LengthFilter
            r14.<init>(r2)
            r13[r0] = r14
            android.widget.AutoCompleteTextView r14 = r12.f49671a
            r14.setFilters(r13)
            android.widget.AutoCompleteTextView r13 = r12.f49671a
            r13.setMaxLines(r3)
            return
        L_0x0167:
            r14 = move-exception
            r13.recycle()
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.common.widgets.AutoCompleteField.a(android.content.Context, android.util.AttributeSet):void");
    }

    public void setText(String str) {
        this.f49671a.setText(str);
    }

    public void setLeftLabel(String str) {
        this.f49673c.setText(str);
    }

    public void setRightLabel(String str) {
        this.f49672b.setText(str);
    }

    public void setRightLabelVisibility(int i2) {
        this.f49672b.setVisibility(i2);
    }

    public void setLeftLabelVisibility(int i2) {
        this.f49673c.setVisibility(i2);
    }

    public void setHint(String str) {
        this.f49671a.setHint(str);
        this.f49677g.setText(str);
    }

    public Editable getText() {
        return this.f49671a.getText();
    }

    public void setFocusable(boolean z) {
        this.f49671a.setFocusable(z);
    }

    public void setFocusableInTouchMode(boolean z) {
        this.f49671a.setFocusableInTouchMode(z);
    }

    public void setRegEx(final String str) {
        this.f49671a.addTextChangedListener(new TextWatcher() {

            /* renamed from: a  reason: collision with root package name */
            String f49680a = "";

            public final void afterTextChanged(Editable editable) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                String charSequence2 = charSequence.toString();
                if (!charSequence2.equals("")) {
                    if (!charSequence2.matches(str)) {
                        AutoCompleteField.this.f49671a.setText(this.f49680a);
                    } else {
                        this.f49680a = charSequence2;
                    }
                }
            }
        });
    }

    private void a(final Context context) {
        this.f49675e = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.layout_auto_complete_field, this);
        this.f49676f = (RelativeLayout) this.f49675e.findViewById(R.id.lyt_custom_edit_view);
        this.f49671a = (AutoCompleteTextView) this.f49675e.findViewById(R.id.auto_complete_view);
        this.f49671a.setImeOptions(5);
        this.f49672b = (TextView) this.f49675e.findViewById(R.id.right_label);
        this.f49673c = (TextView) this.f49675e.findViewById(R.id.left_label);
        this.f49671a.setEllipsize(TextUtils.TruncateAt.END);
        this.f49674d = this.f49675e.findViewById(R.id.image_underline);
        this.f49677g = (TextView) this.f49675e.findViewById(R.id.floating_hint);
        this.f49677g.setVisibility(8);
        this.f49676f.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AutoCompleteField.this.f49671a.requestFocus();
                ((InputMethodManager) context.getSystemService("input_method")).showSoftInput(AutoCompleteField.this.f49671a, 1);
            }
        });
        this.f49671a.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                if (z) {
                    AutoCompleteField.this.f49674d.setBackgroundResource(R.drawable.edit_view_divider_selected);
                } else {
                    AutoCompleteField.this.f49674d.setBackgroundResource(R.drawable.edit_view_divider);
                }
            }
        });
    }

    public void setTextSize(int i2) {
        this.f49671a.setTextSize(2, (float) i2);
    }

    public void setTextChangeListener(final CustomEditText.a aVar) {
        this.f49671a.addTextChangedListener(new TextWatcher() {
            public final void afterTextChanged(Editable editable) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }
        });
    }

    public void setAdapter(ArrayAdapter<String> arrayAdapter) {
        this.f49671a.setAdapter(arrayAdapter);
    }

    public void setFocusChangedListener(final View.OnFocusChangeListener onFocusChangeListener) {
        this.f49671a.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                if (z) {
                    AutoCompleteField.this.f49674d.setBackgroundResource(R.drawable.edit_view_divider_selected);
                } else {
                    AutoCompleteField.this.f49674d.setBackgroundResource(R.drawable.edit_view_divider);
                }
                onFocusChangeListener.onFocusChange(view, z);
            }
        });
    }
}
