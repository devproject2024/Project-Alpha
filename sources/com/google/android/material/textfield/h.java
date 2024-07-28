package com.google.android.material.textfield;

import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.a.a.a;
import com.google.android.material.R;
import com.google.android.material.textfield.TextInputLayout;

final class h extends e {

    /* renamed from: a  reason: collision with root package name */
    final TextWatcher f36850a = new TextWatcher() {
        public final void afterTextChanged(Editable editable) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            h.this.f36835e.setChecked(!h.a(h.this));
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private final TextInputLayout.b f36851b = new TextInputLayout.b() {
        public final void a(TextInputLayout textInputLayout) {
            EditText editText = textInputLayout.getEditText();
            textInputLayout.setEndIconVisible(true);
            textInputLayout.setEndIconCheckable(true);
            h.this.f36835e.setChecked(true ^ h.a(h.this));
            editText.removeTextChangedListener(h.this.f36850a);
            editText.addTextChangedListener(h.this.f36850a);
        }
    };

    /* renamed from: f  reason: collision with root package name */
    private final TextInputLayout.c f36852f = new TextInputLayout.c() {
        public final void a(TextInputLayout textInputLayout, int i2) {
            EditText editText = textInputLayout.getEditText();
            if (editText != null && i2 == 1) {
                editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
                editText.removeTextChangedListener(h.this.f36850a);
            }
        }
    };

    h(TextInputLayout textInputLayout) {
        super(textInputLayout);
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        this.f36833c.setEndIconDrawable(a.b(this.f36834d, R.drawable.design_password_eye));
        this.f36833c.setEndIconContentDescription(this.f36833c.getResources().getText(R.string.password_toggle_content_description));
        this.f36833c.setEndIconOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                EditText editText = h.this.f36833c.getEditText();
                if (editText != null) {
                    int selectionEnd = editText.getSelectionEnd();
                    if (h.a(h.this)) {
                        editText.setTransformationMethod((TransformationMethod) null);
                    } else {
                        editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    }
                    if (selectionEnd >= 0) {
                        editText.setSelection(selectionEnd);
                    }
                }
            }
        });
        this.f36833c.a(this.f36851b);
        this.f36833c.a(this.f36852f);
        EditText editText = this.f36833c.getEditText();
        if (editText != null && (editText.getInputType() == 16 || editText.getInputType() == 128 || editText.getInputType() == 144 || editText.getInputType() == 224)) {
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }

    static /* synthetic */ boolean a(h hVar) {
        EditText editText = hVar.f36833c.getEditText();
        return editText != null && (editText.getTransformationMethod() instanceof PasswordTransformationMethod);
    }
}
