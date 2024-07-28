package net.one97.paytm.passbook.landing.g;

import android.app.Application;
import android.content.Context;
import androidx.lifecycle.y;
import androidx.lifecycle.z;
import kotlin.g.b.k;
import net.one97.paytm.passbook.beans.PaymentHistoryResponse;
import net.one97.paytm.passbook.mapping.a.f;

public final class c extends androidx.lifecycle.a {

    /* renamed from: a  reason: collision with root package name */
    public y<f<PaymentHistoryResponse>> f57758a = new y<>();

    /* renamed from: b  reason: collision with root package name */
    private Context f57759b;

    static final class a<T> implements z<f<? extends PaymentHistoryResponse>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f57760a;

        a(c cVar) {
            this.f57760a = cVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            this.f57760a.f57758a.setValue((f) obj);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(Application application) {
        super(application);
        k.c(application, "application");
        this.f57759b = application.getApplicationContext();
    }

    public final void a(String str, int i2, String str2, String str3, String str4) {
        net.one97.paytm.passbook.landing.repositories.f.f57778b.a(str, i2, str2, str3, this.f57759b, str4).observeForever(new a(this));
    }
}
