package net.one97.paytm.games.fragment.a;

import android.app.Application;
import androidx.lifecycle.y;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import kotlin.g.b.k;
import kotlin.s;
import net.one97.paytm.games.e.j;
import net.one97.paytm.games.model.pfg.PFGUserTransactionResponse;

public final class d extends a {

    /* renamed from: h  reason: collision with root package name */
    public final y<s<Integer, Integer, PFGUserTransactionResponse>> f35649h = new y<>();
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public com.paytm.network.a f35650i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(Application application) {
        super(application);
        k.c(application, "application");
    }

    public static final class a implements b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f35651a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f35652b;

        a(d dVar, int i2) {
            this.f35651a = dVar;
            this.f35652b = i2;
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            this.f35651a.f35649h.setValue(new s(-1, Integer.valueOf(this.f35652b), null));
            this.f35651a.f35650i = null;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            if (iJRPaytmDataModel instanceof PFGUserTransactionResponse) {
                this.f35651a.f35649h.setValue(new s(Integer.valueOf(((PFGUserTransactionResponse) iJRPaytmDataModel).code), Integer.valueOf(this.f35652b), iJRPaytmDataModel));
            } else {
                this.f35651a.f35649h.setValue(new s(-1, Integer.valueOf(this.f35652b), null));
            }
            this.f35651a.f35650i = null;
        }
    }

    public final void a(int i2, int i3, int i4) {
        com.paytm.network.a aVar = this.f35650i;
        if (aVar != null) {
            aVar.b();
        }
        j jVar = j.f35626a;
        this.f35650i = j.a((b) new a(this, i4), i2, i3, i4);
    }

    public final void onCleared() {
        super.onCleared();
        com.paytm.network.a aVar = this.f35650i;
        if (aVar != null) {
            aVar.b();
        }
    }
}
