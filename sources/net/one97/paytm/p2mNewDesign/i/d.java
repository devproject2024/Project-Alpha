package net.one97.paytm.p2mNewDesign.i;

import android.app.Application;
import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import kotlin.g.b.k;
import net.one97.paytm.p2mNewDesign.db.PaymentInstrumentDatabase;

public final class d implements al.b {

    /* renamed from: a  reason: collision with root package name */
    private final PaymentInstrumentDatabase f51306a;

    /* renamed from: b  reason: collision with root package name */
    private final Application f51307b;

    /* renamed from: c  reason: collision with root package name */
    private final String f51308c;

    /* renamed from: d  reason: collision with root package name */
    private final String f51309d;

    public d(PaymentInstrumentDatabase paymentInstrumentDatabase, Application application, String str, String str2) {
        k.c(paymentInstrumentDatabase, "dataSource");
        k.c(application, "application");
        k.c(str, "mId");
        k.c(str2, "custId");
        this.f51306a = paymentInstrumentDatabase;
        this.f51307b = application;
        this.f51308c = str;
        this.f51309d = str2;
    }

    public final <T extends ai> T create(Class<T> cls) {
        k.c(cls, "modelClass");
        if (cls.isAssignableFrom(c.class)) {
            return (ai) new c(this.f51306a, this.f51307b, this.f51308c, this.f51309d);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
