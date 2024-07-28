package net.one97.paytm.wallet.j;

import android.app.Application;
import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import kotlin.g.b.k;
import net.one97.paytm.p2mNewDesign.db.PaymentInstrumentDatabase;

public final class b implements al.b {

    /* renamed from: a  reason: collision with root package name */
    private final PaymentInstrumentDatabase f70423a;

    /* renamed from: b  reason: collision with root package name */
    private final Application f70424b;

    public b(PaymentInstrumentDatabase paymentInstrumentDatabase, Application application) {
        k.c(paymentInstrumentDatabase, "dataSource");
        k.c(application, "application");
        this.f70423a = paymentInstrumentDatabase;
        this.f70424b = application;
    }

    public final <T extends ai> T create(Class<T> cls) {
        k.c(cls, "modelClass");
        if (cls.isAssignableFrom(a.class)) {
            return (ai) new a(this.f70423a, this.f70424b);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
