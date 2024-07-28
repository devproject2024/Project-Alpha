package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import com.google.android.material.R;
import com.google.android.material.textfield.TextInputLayout;

final class a extends e {

    /* renamed from: a  reason: collision with root package name */
    final TextWatcher f36796a = new TextWatcher() {
        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void afterTextChanged(Editable editable) {
            if (a.this.f36833c.getSuffixText() == null) {
                a.this.b(a.a(editable));
            }
        }
    };

    /* renamed from: b  reason: collision with root package name */
    final View.OnFocusChangeListener f36797b = new View.OnFocusChangeListener() {
        public final void onFocusChange(View view, boolean z) {
            boolean z2 = true;
            boolean z3 = !TextUtils.isEmpty(((EditText) view).getText());
            a aVar = a.this;
            if (!z3 || !z) {
                z2 = false;
            }
            aVar.b(z2);
        }
    };

    /* renamed from: f  reason: collision with root package name */
    private final TextInputLayout.b f36798f = new TextInputLayout.b() {
        public final void a(TextInputLayout textInputLayout) {
            EditText editText = textInputLayout.getEditText();
            textInputLayout.setEndIconVisible(editText.hasFocus() && a.a(editText.getText()));
            textInputLayout.setEndIconCheckable(false);
            editText.setOnFocusChangeListener(a.this.f36797b);
            editText.removeTextChangedListener(a.this.f36796a);
            editText.addTextChangedListener(a.this.f36796a);
        }
    };

    /* renamed from: g  reason: collision with root package name */
    private final TextInputLayout.c f36799g = new TextInputLayout.c() {
        public final void a(TextInputLayout textInputLayout, int i2) {
            EditText editText = textInputLayout.getEditText();
            if (editText != null && i2 == 2) {
                editText.removeTextChangedListener(a.this.f36796a);
                if (editText.getOnFocusChangeListener() == a.this.f36797b) {
                    editText.setOnFocusChangeListener((View.OnFocusChangeListener) null);
                }
            }
        }
    };

    /* renamed from: h  reason: collision with root package name */
    private AnimatorSet f36800h;

    /* renamed from: i  reason: collision with root package name */
    private ValueAnimator f36801i;

    a(TextInputLayout textInputLayout) {
        super(textInputLayout);
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        this.f36833c.setEndIconDrawable(androidx.appcompat.a.a.a.b(this.f36834d, R.drawable.mtrl_ic_cancel));
        this.f36833c.setEndIconContentDescription(this.f36833c.getResources().getText(R.string.clear_text_end_icon_content_description));
        this.f36833c.setEndIconOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                Editable text = a.this.f36833c.getEditText().getText();
                if (text != null) {
                    text.clear();
                }
            }
        });
        this.f36833c.a(this.f36798f);
        this.f36833c.a(this.f36799g);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.8f, 1.0f});
        ofFloat.setInterpolator(com.google.android.material.a.a.f35803d);
        ofFloat.setDuration(150);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                a.this.f36835e.setScaleX(floatValue);
                a.this.f36835e.setScaleY(floatValue);
            }
        });
        ValueAnimator a2 = a(0.0f, 1.0f);
        this.f36800h = new AnimatorSet();
        this.f36800h.playTogether(new Animator[]{ofFloat, a2});
        this.f36800h.addListener(new AnimatorListenerAdapter() {
            public final void onAnimationStart(Animator animator) {
                a.this.f36833c.setEndIconVisible(true);
            }
        });
        this.f36801i = a(1.0f, 0.0f);
        this.f36801i.addListener(new AnimatorListenerAdapter() {
            public final void onAnimationEnd(Animator animator) {
                a.this.f36833c.setEndIconVisible(false);
            }
        });
    }

    /* access modifiers changed from: package-private */
    public final void a(boolean z) {
        if (this.f36833c.getSuffixText() != null) {
            b(z);
        }
    }

    /* access modifiers changed from: package-private */
    public final void b(boolean z) {
        boolean z2 = this.f36833c.b() == z;
        if (z) {
            this.f36801i.cancel();
            this.f36800h.start();
            if (z2) {
                this.f36800h.end();
                return;
            }
            return;
        }
        this.f36800h.cancel();
        this.f36801i.start();
        if (z2) {
            this.f36801i.end();
        }
    }

    private ValueAnimator a(float... fArr) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
        ofFloat.setInterpolator(com.google.android.material.a.a.f35800a);
        ofFloat.setDuration(100);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                a.this.f36835e.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        return ofFloat;
    }

    static /* synthetic */ boolean a(Editable editable) {
        return editable.length() > 0;
    }
}
