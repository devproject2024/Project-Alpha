package net.one97.paytm.passbook.transactionHistory.a;

import android.app.Application;
import android.content.Context;
import androidx.lifecycle.y;
import androidx.lifecycle.z;
import kotlin.g.b.k;
import net.one97.paytm.passbook.beans.SADetailsResponse;
import net.one97.paytm.passbook.landing.repositories.j;
import net.one97.paytm.passbook.mapping.a.f;

public final class a extends androidx.lifecycle.a {

    /* renamed from: a  reason: collision with root package name */
    public y<f<SADetailsResponse>> f59163a = new y<>();

    /* renamed from: b  reason: collision with root package name */
    private Context f59164b;

    /* renamed from: net.one97.paytm.passbook.transactionHistory.a.a$a  reason: collision with other inner class name */
    static final class C1141a<T> implements z<f<? extends SADetailsResponse>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f59165a;

        C1141a(a aVar) {
            this.f59165a = aVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            this.f59165a.f59163a.postValue((f) obj);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(Application application) {
        super(application);
        k.c(application, "application");
        this.f59164b = application.getApplicationContext();
    }

    public final void a(String str, String str2, String str3, String str4) {
        j jVar = j.f57798b;
        Context context = this.f59164b;
        jVar.a(str, str2, str3, str4, context != null ? net.one97.paytm.passbook.utility.f.c(context) : null).observeForever(new C1141a(this));
    }
}
