package net.one97.paytm.hotel4.service.a;

import android.app.Application;
import androidx.lifecycle.y;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import kotlin.g.b.k;
import net.one97.paytm.hotel4.service.model.ErrorData;
import net.one97.paytm.hotel4.service.model.promocode.PromocodeResponse;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public final String f28609a = "/offers";

    /* renamed from: b  reason: collision with root package name */
    public Application f28610b;

    /* renamed from: c  reason: collision with root package name */
    public y<PromocodeResponse> f28611c;

    /* renamed from: d  reason: collision with root package name */
    public y<ErrorData> f28612d;

    public d(Application application) {
        this.f28610b = application;
    }

    public final class a implements b {
        public a() {
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            y<PromocodeResponse> yVar = d.this.f28611c;
            if (yVar == null) {
                k.a("sucessListener");
            }
            if (!(iJRPaytmDataModel instanceof PromocodeResponse)) {
                iJRPaytmDataModel = null;
            }
            yVar.postValue((PromocodeResponse) iJRPaytmDataModel);
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            String str = null;
            Integer valueOf = networkCustomError != null ? Integer.valueOf(networkCustomError.getStatusCode()) : null;
            String alertTitle = networkCustomError != null ? networkCustomError.getAlertTitle() : null;
            if (networkCustomError != null) {
                str = networkCustomError.getAlertMessage();
            }
            ErrorData errorData = new ErrorData(valueOf, alertTitle, str);
            y<ErrorData> yVar = d.this.f28612d;
            if (yVar == null) {
                k.a("failureListener");
            }
            yVar.postValue(errorData);
        }
    }
}
