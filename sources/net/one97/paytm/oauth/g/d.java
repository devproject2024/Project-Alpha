package net.one97.paytm.oauth.g;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ai;
import androidx.lifecycle.y;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import kotlin.g.b.k;
import net.one97.paytm.oauth.e;
import net.one97.paytm.oauth.models.ErrorModel;

public final class d extends ai {

    public static final class a implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f56691a;

        a(y yVar) {
            this.f56691a = yVar;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            k.c(iJRPaytmDataModel, "model");
            this.f56691a.setValue(e.a(iJRPaytmDataModel));
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            k.c(networkCustomError, "networkError");
            this.f56691a.setValue(e.a(new ErrorModel(i2, iJRPaytmDataModel, networkCustomError), (Throwable) networkCustomError));
        }
    }

    public static LiveData<e<IJRPaytmDataModel>> a(Context context, String str, String str2) {
        k.c(context, "context");
        k.c(str, "mobile");
        k.c(str2, "verificationType");
        y yVar = new y();
        net.one97.paytm.oauth.b.b.a(context, (com.paytm.network.listener.b) new a(yVar), str, str2);
        return yVar;
    }

    public static final class c implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f56693a;

        c(y yVar) {
            this.f56693a = yVar;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            k.c(iJRPaytmDataModel, "model");
            this.f56693a.setValue(e.a(iJRPaytmDataModel));
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            k.c(networkCustomError, "networkError");
            this.f56693a.setValue(e.a(new ErrorModel(i2, iJRPaytmDataModel, networkCustomError), (Throwable) networkCustomError));
        }
    }

    public static LiveData<e<IJRPaytmDataModel>> a(String str, String str2) {
        k.c(str, "otp");
        y yVar = new y();
        net.one97.paytm.oauth.b.b.e(new c(yVar), str, str2, (String) null);
        return yVar;
    }

    public static final class b implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f56692a;

        b(y yVar) {
            this.f56692a = yVar;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            k.c(iJRPaytmDataModel, "model");
            this.f56692a.setValue(e.a(iJRPaytmDataModel));
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            k.c(networkCustomError, "networkError");
            this.f56692a.setValue(e.a(new ErrorModel(i2, iJRPaytmDataModel, networkCustomError), (Throwable) networkCustomError));
        }
    }

    public static LiveData<e<IJRPaytmDataModel>> a(String str, String str2, boolean z) {
        k.c(str2, "password");
        y yVar = new y();
        net.one97.paytm.oauth.b.b.a((com.paytm.network.listener.b) new b(yVar), str, str2, Boolean.valueOf(z));
        return yVar;
    }
}
