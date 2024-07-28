package com.travel.flight.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatEditText;
import com.travel.flight.R;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;

public final class SuffixEditText extends AppCompatEditText {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public String f25647a = "";

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SuffixEditText(Context context) {
        super(context);
        k.c(context, "context");
        a(context, (AttributeSet) null, 0);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SuffixEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        k.c(context, "context");
        a(context, attributeSet, 0);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SuffixEditText(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        k.c(context, "context");
        a(context, attributeSet, i2);
    }

    private final void a(Context context, AttributeSet attributeSet, int i2) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SuffixEditText, i2, 0);
            String string = obtainStyledAttributes.getString(R.styleable.SuffixEditText_suffix);
            if (string == null) {
                string = "";
            }
            this.f25647a = string;
            obtainStyledAttributes.recycle();
        }
        setText(this.f25647a);
        addTextChangedListener(new a(this));
    }

    public static final class a implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SuffixEditText f25648a;

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            k.c(charSequence, "s");
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            k.c(charSequence, "s");
        }

        a(SuffixEditText suffixEditText) {
            this.f25648a = suffixEditText;
        }

        public final void afterTextChanged(Editable editable) {
            k.c(editable, "editable");
            String obj = editable.toString();
            if (editable.length() < this.f25648a.f25647a.length() && p.b(this.f25648a.f25647a, obj, false)) {
                String a2 = this.f25648a.f25647a;
                int length = editable.length();
                if (a2 != null) {
                    String substring = a2.substring(length);
                    k.a((Object) substring, "(this as java.lang.String).substring(startIndex)");
                    editable.insert(editable.length(), substring);
                    return;
                }
                throw new u("null cannot be cast to non-null type java.lang.String");
            } else if (!p.c(obj, this.f25648a.f25647a, false)) {
                editable.insert(obj.length(), this.f25648a.f25647a);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void onSelectionChanged(int i2, int i3) {
        if (this.f25647a == null) {
            this.f25647a = "";
        }
        Editable text = getText();
        if (text == null) {
            k.a();
        }
        int length = text.length() - this.f25647a.length();
        if (i3 > length) {
            if (length < i2) {
                i2 = length;
            }
            setSelection(i2, length);
            return;
        }
        super.onSelectionChanged(i2, i3);
    }
}
