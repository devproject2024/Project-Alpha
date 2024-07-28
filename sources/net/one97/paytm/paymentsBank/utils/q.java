package net.one97.paytm.paymentsBank.utils;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import io.reactivex.rxjava3.a.p;
import io.reactivex.rxjava3.j.b;

public final class q {
    public static p<String> a(EditText editText) {
        final b a2 = b.a();
        editText.addTextChangedListener(new TextWatcher() {
            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void afterTextChanged(Editable editable) {
                a2.onNext(editable.toString());
            }
        });
        return a2;
    }
}
