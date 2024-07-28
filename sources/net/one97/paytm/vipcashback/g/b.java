package net.one97.paytm.vipcashback.g;

import android.app.Application;
import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.y;
import com.appsflyer.internal.referrer.Payload;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.vipcashback.ErrorModel;
import net.one97.paytm.common.entity.vipcashback.MerchantCashBackMyOfferModel;
import net.one97.paytm.common.entity.vipcashback.MerchantGameItem;
import net.one97.paytm.vipcashback.f.d;
import net.one97.paytm.vipcashback.f.h;

public final class b extends androidx.lifecycle.a {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(Application application) {
        super(application);
        k.c(application, "application");
    }

    public final LiveData<h<Object>> a(MerchantGameItem merchantGameItem) {
        k.c(merchantGameItem, "merchantGameItem");
        y yVar = new y();
        d.a aVar = d.f20859a;
        Application application = getApplication();
        k.a((Object) application, "getApplication()");
        String offerId = merchantGameItem.getOfferId();
        k.a((Object) offerId, "merchantGameItem.offerId");
        com.paytm.network.a a2 = d.a.a((Context) application, (com.paytm.network.listener.b) new a(yVar), Integer.parseInt(offerId), "MerchantCashbackFragment");
        if (com.paytm.utility.b.c((Context) getApplication())) {
            if (a2 != null) {
                a2.a();
            }
            yVar.setValue(h.a());
        } else {
            yVar.setValue(h.b(a2));
        }
        return yVar;
    }

    public static final class a implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f21011a;

        a(y yVar) {
            this.f21011a = yVar;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            k.c(iJRPaytmDataModel, Payload.RESPONSE);
            if (iJRPaytmDataModel instanceof MerchantCashBackMyOfferModel) {
                MerchantCashBackMyOfferModel merchantCashBackMyOfferModel = (MerchantCashBackMyOfferModel) iJRPaytmDataModel;
                if (merchantCashBackMyOfferModel.getStatus() == 1 && merchantCashBackMyOfferModel.getData() != null) {
                    this.f21011a.setValue(h.a(iJRPaytmDataModel));
                }
            }
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            k.c(iJRPaytmDataModel, "model");
            k.c(networkCustomError, "networkError");
            this.f21011a.setValue(h.a(new ErrorModel(i2, iJRPaytmDataModel), networkCustomError));
        }
    }
}
