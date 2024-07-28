package com.travel.citybus.brts.citybus;

import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.travel.citybus.best.e.a;
import com.travel.citybus.best.model.BestEPurse;
import com.travel.citybus.best.model.BestEPurseTokenResponse;
import com.travel.citybus.brts.citybus.w;
import com.travel.citybus.brts.model.pojo.CJRRouteApiResponseModel;
import com.travel.citybus.brts.model.pojo.CJRRouteModel;
import kotlin.g.b.k;

public final class g implements b {

    /* renamed from: a  reason: collision with root package name */
    final w.a f23283a;

    public g(w.a aVar) {
        k.c(aVar, "view");
        this.f23283a = aVar;
    }

    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        this.f23283a.a(false);
        if (iJRPaytmDataModel instanceof CJRRouteApiResponseModel) {
            String a2 = a.a(networkCustomError);
            w.a aVar = this.f23283a;
            String alertTitle = networkCustomError != null ? networkCustomError.getAlertTitle() : null;
            if (a2 == null) {
                a2 = networkCustomError != null ? networkCustomError.getAlertMessage() : null;
            }
            aVar.a(alertTitle, a2);
        }
        if (iJRPaytmDataModel instanceof BestEPurseTokenResponse) {
            this.f23283a.f();
        }
    }

    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        if (iJRPaytmDataModel != null) {
            this.f23283a.a(false);
            if (iJRPaytmDataModel instanceof CJRRouteApiResponseModel) {
                w.a aVar = this.f23283a;
                CJRRouteModel routeResponse = ((CJRRouteApiResponseModel) iJRPaytmDataModel).getRouteResponse();
                k.a((Object) routeResponse, "dataModel.routeResponse");
                aVar.a(routeResponse);
            }
            if (iJRPaytmDataModel instanceof BestEPurseTokenResponse) {
                w.a aVar2 = this.f23283a;
                BestEPurse response = ((BestEPurseTokenResponse) iJRPaytmDataModel).getResponse();
                k.a((Object) response, "dataModel?.response");
                aVar2.b(response);
            }
        }
    }
}
