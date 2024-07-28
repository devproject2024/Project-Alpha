package net.one97.paytm.passbook.transactionHistory.a;

import android.app.Application;
import android.content.Context;
import androidx.lifecycle.y;
import androidx.lifecycle.z;
import kotlin.g.b.k;
import net.one97.paytm.passbook.beans.PassbookTransactionHistoryResponse;
import net.one97.paytm.passbook.landing.repositories.l;
import net.one97.paytm.passbook.mapping.a.f;

public final class b extends androidx.lifecycle.a {

    /* renamed from: a  reason: collision with root package name */
    public y<f<PassbookTransactionHistoryResponse>> f59166a = new y<>();

    /* renamed from: b  reason: collision with root package name */
    private Context f59167b;

    static final class a<T> implements z<f<? extends PassbookTransactionHistoryResponse>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f59168a;

        a(b bVar) {
            this.f59168a = bVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            this.f59168a.f59166a.postValue((f) obj);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(Application application) {
        super(application);
        k.c(application, "application");
        this.f59167b = application.getApplicationContext();
    }

    public final void a(String str, String str2) {
        l lVar = l.f57811b;
        Context context = this.f59167b;
        lVar.a(str, str2, context != null ? net.one97.paytm.passbook.utility.f.c(context) : null).observeForever(new a(this));
    }
}
