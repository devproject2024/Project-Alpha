package net.one97.paytm.recharge.common.utils;

import android.text.Editable;
import android.text.TextWatcher;
import io.reactivex.rxjava3.j.b;

public final class bb {

    public static final class a implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f61588a;

        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public a(b bVar) {
            this.f61588a = bVar;
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            this.f61588a.onNext(String.valueOf(charSequence));
        }
    }
}
