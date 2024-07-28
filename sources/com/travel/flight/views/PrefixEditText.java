package com.travel.flight.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatEditText;
import com.travel.flight.R;

public class PrefixEditText extends AppCompatEditText {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public String f25619a = "";

    public PrefixEditText(Context context) {
        super(context);
        a(context, (AttributeSet) null);
    }

    public PrefixEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    public PrefixEditText(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PrefixEditText);
            this.f25619a = obtainStyledAttributes.getString(R.styleable.PrefixEditText_prefix);
            obtainStyledAttributes.recycle();
        }
        if (this.f25619a == null) {
            this.f25619a = "";
        }
        setText(this.f25619a);
        a();
    }

    private void a() {
        addTextChangedListener(new TextWatcher() {
            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                if (editable.length() < PrefixEditText.this.f25619a.length() && PrefixEditText.this.f25619a.startsWith(obj)) {
                    editable.insert(editable.length(), PrefixEditText.this.f25619a.substring(editable.length()));
                } else if (!obj.startsWith(PrefixEditText.this.f25619a)) {
                    editable.insert(0, PrefixEditText.this.f25619a);
                }
            }
        });
        setFilters(new InputFilter[]{new InputFilter() {
            public final CharSequence filter(CharSequence charSequence, int i2, int i3, Spanned spanned, int i4, int i5) {
                return PrefixEditText.this.a(charSequence, i2, i3, spanned, i4, i5);
            }
        }});
    }

    /* access modifiers changed from: private */
    public /* synthetic */ CharSequence a(CharSequence charSequence, int i2, int i3, Spanned spanned, int i4, int i5) {
        if (charSequence.length() != 0 || getSelectionStart() > this.f25619a.length()) {
            return null;
        }
        return spanned.subSequence(i4, i5);
    }

    /* access modifiers changed from: protected */
    public void onSelectionChanged(int i2, int i3) {
        if (this.f25619a == null) {
            this.f25619a = "";
        }
        if (i2 <= this.f25619a.length() - 1) {
            int length = this.f25619a.length();
            int length2 = getText().length();
            if (length2 <= length) {
                length = Math.max(length2 - 1, 0);
            }
            if (length2 >= i3) {
                i3 = Math.max(length2 - 1, 0);
            }
            if (i3 < length) {
                i3 = length;
            }
            setSelection(length, i3);
            return;
        }
        super.onSelectionChanged(i2, i3);
    }
}
