package net.one97.paytm.wallet.c;

import android.app.Application;
import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import kotlin.g.b.k;
import net.one97.paytm.p2mNewDesign.db.PaymentInstrumentDatabase;

public final class i implements al.b {

    /* renamed from: a  reason: collision with root package name */
    private final PaymentInstrumentDatabase f70044a;

    /* renamed from: b  reason: collision with root package name */
    private final Application f70045b;

    public i(PaymentInstrumentDatabase paymentInstrumentDatabase, Application application) {
        k.c(paymentInstrumentDatabase, "dataSource");
        k.c(application, "application");
        this.f70044a = paymentInstrumentDatabase;
        this.f70045b = application;
    }

    public final <T extends ai> T create(Class<T> cls) {
        k.c(cls, "modelClass");
        if (cls.isAssignableFrom(h.class)) {
            return (ai) new h(this.f70044a, this.f70045b);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
