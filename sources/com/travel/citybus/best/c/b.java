package com.travel.citybus.best.c;

import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.travel.citybus.best.model.BestEPurse;
import com.travel.citybus.best.model.BestEPurseTokenResponse;
import kotlin.g.b.k;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    final com.travel.citybus.best.b.b f23046a;

    public b(com.travel.citybus.best.b.b bVar) {
        k.c(bVar, "view");
        this.f23046a = bVar;
    }

    public static final class a implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f23047a;

        public a(b bVar) {
            this.f23047a = bVar;
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            this.f23047a.f23046a.onApiError();
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            if (iJRPaytmDataModel instanceof BestEPurseTokenResponse) {
                BestEPurseTokenResponse bestEPurseTokenResponse = (BestEPurseTokenResponse) iJRPaytmDataModel;
                if (bestEPurseTokenResponse.getResponse() != null) {
                    com.travel.citybus.best.b.b bVar = this.f23047a.f23046a;
                    BestEPurse response = bestEPurseTokenResponse.getResponse();
                    k.a((Object) response, "response?.response");
                    bVar.onOrderSummaryReceived(response);
                    return;
                }
            }
            this.f23047a.f23046a.onApiError();
        }
    }
}
