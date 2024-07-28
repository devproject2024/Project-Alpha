package androidx.preference;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class a extends f {

    /* renamed from: a  reason: collision with root package name */
    private EditText f30834a;

    /* renamed from: b  reason: collision with root package name */
    private CharSequence f30835b;

    /* access modifiers changed from: protected */
    public final boolean a() {
        return true;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            this.f30835b = ((EditTextPreference) b()).f30770g;
        } else {
            this.f30835b = bundle.getCharSequence("EditTextPreferenceDialogFragment.text");
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putCharSequence("EditTextPreferenceDialogFragment.text", this.f30835b);
    }

    /* access modifiers changed from: protected */
    public final void a(View view) {
        super.a(view);
        this.f30834a = (EditText) view.findViewById(16908291);
        EditText editText = this.f30834a;
        if (editText != null) {
            editText.requestFocus();
            this.f30834a.setText(this.f30835b);
            EditText editText2 = this.f30834a;
            editText2.setSelection(editText2.getText().length());
            if (((EditTextPreference) b()).f30771h != null) {
                b();
                return;
            }
            return;
        }
        throw new IllegalStateException("Dialog view must contain an EditText with id @android:id/edit");
    }

    public final void a(boolean z) {
        if (z) {
            String obj = this.f30834a.getText().toString();
            EditTextPreference editTextPreference = (EditTextPreference) b();
            if (editTextPreference.l()) {
                editTextPreference.a(obj);
            }
        }
    }
}
