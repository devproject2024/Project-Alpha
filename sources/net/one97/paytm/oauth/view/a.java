package net.one97.paytm.oauth.view;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.ViewParent;
import android.widget.EditText;
import com.google.android.material.textfield.TextInputLayout;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.oauth.fragment.AccountUnblockSavedCardFragment;

public final class a implements TextWatcher {

    /* renamed from: a  reason: collision with root package name */
    private final String f56848a = "/";

    /* renamed from: b  reason: collision with root package name */
    private int f56849b;

    /* renamed from: c  reason: collision with root package name */
    private final EditText f56850c;

    /* renamed from: d  reason: collision with root package name */
    private final C1055a f56851d;

    /* renamed from: net.one97.paytm.oauth.view.a$a  reason: collision with other inner class name */
    public interface C1055a {
        void b();
    }

    public a(EditText editText, C1055a aVar) {
        k.c(editText, "mEditText");
        this.f56850c = editText;
        this.f56851d = aVar;
    }

    public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        k.c(charSequence, "s");
        this.f56849b = this.f56850c.getText().length();
    }

    public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        k.c(charSequence, "s");
        ViewParent parent = this.f56850c.getParent();
        ViewParent parent2 = parent != null ? parent.getParent() : null;
        if (!(parent2 instanceof TextInputLayout)) {
            parent2 = null;
        }
        TextInputLayout textInputLayout = (TextInputLayout) parent2;
        if (textInputLayout != null) {
            textInputLayout.setError((CharSequence) null);
        }
        if (textInputLayout != null) {
            textInputLayout.setErrorEnabled(false);
        }
        C1055a aVar = this.f56851d;
        if (aVar instanceof AccountUnblockSavedCardFragment) {
            aVar.b();
        }
    }

    public final void afterTextChanged(Editable editable) {
        k.c(editable, "s");
        int length = this.f56850c.getText().length();
        boolean z = this.f56849b > length;
        if (!z || !p.b(editable.toString(), this.f56848a, false)) {
            int selectionStart = this.f56850c.getSelectionStart();
            if (z) {
                CharSequence charSequence = editable;
                if (!p.a(charSequence, (CharSequence) this.f56848a, false) && length > 2) {
                    this.f56850c.setText(charSequence.subSequence(0, 2).toString() + this.f56848a + charSequence.subSequence(2, charSequence.length()).toString());
                    this.f56850c.setSelection(selectionStart + 1);
                    return;
                }
            }
            if (z || editable.length() != 2 || !(!k.a((Object) String.valueOf(editable.charAt(editable.length() - 1)), (Object) this.f56848a))) {
                if (editable.length() == 3) {
                    CharSequence charSequence2 = editable;
                    if (!p.a(charSequence2, (CharSequence) this.f56848a, false) && !z) {
                        this.f56850c.setText(charSequence2.subSequence(0, 2).toString() + this.f56848a + editable.charAt(editable.length() - 1));
                        this.f56850c.setSelection(selectionStart + 1);
                        return;
                    }
                }
                if (selectionStart == 2 || selectionStart == 3) {
                    CharSequence charSequence3 = editable;
                    if (p.a(charSequence3, (CharSequence) this.f56848a, false)) {
                        this.f56850c.setText(charSequence3.subSequence(0, 2).toString() + this.f56848a + p.a(charSequence3.subSequence(2, charSequence3.length()).toString(), this.f56848a, "", false));
                        EditText editText = this.f56850c;
                        editText.setSelection(editText.getText().toString().length());
                        return;
                    }
                    return;
                }
                return;
            }
            EditText editText2 = this.f56850c;
            editText2.setText(this.f56850c.getText().toString() + this.f56848a);
            this.f56850c.setSelection(selectionStart + 1);
        }
    }
}
