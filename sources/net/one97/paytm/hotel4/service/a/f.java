package net.one97.paytm.hotel4.service.a;

import android.app.Application;
import androidx.lifecycle.y;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import kotlin.g.b.k;
import net.one97.paytm.hotel4.service.model.ErrorData;
import net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.HotelSearchResponse;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    public Application f28624a;

    /* renamed from: b  reason: collision with root package name */
    public String f28625b = "";

    /* renamed from: c  reason: collision with root package name */
    public y<HotelSearchResponse> f28626c;

    /* renamed from: d  reason: collision with root package name */
    public y<ErrorData> f28627d;

    public f(Application application) {
        this.f28624a = application;
    }

    public final class a implements b {
        public a() {
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            y<HotelSearchResponse> yVar = f.this.f28626c;
            if (yVar == null) {
                k.a("sucessListener");
            }
            if (!(iJRPaytmDataModel instanceof HotelSearchResponse)) {
                iJRPaytmDataModel = null;
            }
            yVar.postValue((HotelSearchResponse) iJRPaytmDataModel);
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            String str = null;
            Integer valueOf = networkCustomError != null ? Integer.valueOf(networkCustomError.getStatusCode()) : null;
            String alertTitle = networkCustomError != null ? networkCustomError.getAlertTitle() : null;
            if (networkCustomError != null) {
                str = networkCustomError.getAlertMessage();
            }
            ErrorData errorData = new ErrorData(valueOf, alertTitle, str);
            y<ErrorData> yVar = f.this.f28627d;
            if (yVar == null) {
                k.a("failureListener");
            }
            yVar.postValue(errorData);
        }
    }
}
