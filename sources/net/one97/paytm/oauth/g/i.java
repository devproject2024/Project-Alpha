package net.one97.paytm.oauth.g;

import android.app.Application;
import androidx.lifecycle.y;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import kotlin.g.b.k;
import net.one97.paytm.oauth.e;
import net.one97.paytm.oauth.models.ErrorModel;

public final class i extends androidx.lifecycle.a {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i(Application application) {
        super(application);
        k.c(application, "application");
    }

    public static final class a implements b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f56721a;

        public a(y yVar) {
            this.f56721a = yVar;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            k.c(iJRPaytmDataModel, "model");
            this.f56721a.setValue(e.a(iJRPaytmDataModel));
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            k.c(networkCustomError, "networkError");
            this.f56721a.postValue(e.a(new ErrorModel(i2, iJRPaytmDataModel), (Throwable) networkCustomError));
        }
    }
}
