package net.one97.paytm.recharge.widgets.a;

import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;

public class d implements b, net.one97.paytm.recharge.widgets.b.d {

    /* renamed from: a  reason: collision with root package name */
    private net.one97.paytm.recharge.widgets.b.d f64964a;

    /* renamed from: b  reason: collision with root package name */
    private b f64965b;

    public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        net.one97.paytm.recharge.widgets.b.d dVar = this.f64964a;
        if (dVar != null) {
            dVar.onApiSuccess(iJRPaytmDataModel);
            return;
        }
        b bVar = this.f64965b;
        if (bVar != null) {
            bVar.onApiSuccess(iJRPaytmDataModel);
        }
    }

    public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        net.one97.paytm.recharge.widgets.b.d dVar = this.f64964a;
        if (dVar != null) {
            dVar.handleErrorCode(i2, iJRPaytmDataModel, networkCustomError);
            return;
        }
        b bVar = this.f64965b;
        if (bVar != null) {
            bVar.handleErrorCode(i2, iJRPaytmDataModel, networkCustomError);
        }
    }
}
