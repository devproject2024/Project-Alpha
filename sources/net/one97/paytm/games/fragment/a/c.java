package net.one97.paytm.games.fragment.a;

import android.app.Application;
import androidx.lifecycle.y;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.shopping.CJRHomePageV2;

public final class c extends a {

    /* renamed from: h  reason: collision with root package name */
    public com.paytm.network.a f35646h;

    /* renamed from: i  reason: collision with root package name */
    public final y<CJRHomePageV2> f35647i = new y<>();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(Application application) {
        super(application);
        k.c(application, "application");
    }

    public static final class a implements b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f35648a;

        public a(c cVar) {
            this.f35648a = cVar;
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            this.f35648a.f35647i.setValue(null);
            this.f35648a.f35646h = null;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            if (iJRPaytmDataModel instanceof CJRHomePageV2) {
                this.f35648a.f35647i.setValue(iJRPaytmDataModel);
            } else {
                this.f35648a.f35647i.setValue(null);
            }
            this.f35648a.f35646h = null;
        }
    }

    public final void onCleared() {
        super.onCleared();
        com.paytm.network.a aVar = this.f35646h;
        if (aVar != null) {
            aVar.b();
        }
    }
}
