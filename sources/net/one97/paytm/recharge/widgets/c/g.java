package net.one97.paytm.recharge.widgets.c;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import kotlin.g.b.k;

public final class g implements TextWatcher {

    /* renamed from: a  reason: collision with root package name */
    private View f64974a;

    /* renamed from: b  reason: collision with root package name */
    private final a f64975b;

    public interface a {
        void a(View view, Editable editable);

        void a(View view, CharSequence charSequence, int i2, int i3, int i4);
    }

    public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    public g(View view, a aVar) {
        k.c(aVar, "textWatcher");
        this.f64974a = view;
        this.f64975b = aVar;
    }

    public final void afterTextChanged(Editable editable) {
        this.f64975b.a(this.f64974a, editable);
    }

    public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        this.f64975b.a(this.f64974a, charSequence, i2, i3, i4);
    }
}
