package net.one97.paytm.moneytransferv4.home.presentation.viewmodel;

import android.app.Application;
import androidx.lifecycle.y;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.k;
import net.one97.paytm.moneytransfer.b.a.a;
import net.one97.paytm.moneytransfer.b.a.b;
import net.one97.paytm.moneytransfer.model.c;
import net.one97.paytm.upi.common.UpiCustomVolleyError;

public final class f extends androidx.lifecycle.a {

    /* renamed from: a  reason: collision with root package name */
    public b f55645a;

    /* renamed from: b  reason: collision with root package name */
    public y<c<String>> f55646b = new y<>();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(Application application) {
        super(application);
        k.c(application, "application");
        b a2 = net.one97.paytm.moneytransfer.b.a(application);
        k.a((Object) a2, "Injection.provideMoneyTr…erRepository(application)");
        this.f55645a = a2;
    }

    public static final class a implements a.C0960a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f55647a;

        public a(f fVar) {
            this.f55647a = fVar;
        }

        public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
            y a2 = this.f55647a.f55646b;
            c.a aVar = c.f54031e;
            a2.postValue(c.a.a(""));
        }

        public final void a(UpiCustomVolleyError upiCustomVolleyError) {
            y a2 = this.f55647a.f55646b;
            c.a aVar = c.f54031e;
            a2.setValue(c.a.a(upiCustomVolleyError));
        }
    }
}
