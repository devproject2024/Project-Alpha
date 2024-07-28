package net.one97.paytm.recharge.common.e;

import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;

public class b implements com.paytm.network.listener.b, ai, net.one97.paytm.recharge.legacy.catalog.a.b {

    /* renamed from: a  reason: collision with root package name */
    private net.one97.paytm.recharge.legacy.catalog.a.b f61089a;

    /* renamed from: b  reason: collision with root package name */
    private ai f61090b;

    /* renamed from: c  reason: collision with root package name */
    private com.paytm.network.listener.b f61091c;

    /* renamed from: d  reason: collision with root package name */
    private String f61092d;

    /* renamed from: e  reason: collision with root package name */
    private Object f61093e;

    public b() {
    }

    public b(ai aiVar, String str) {
        this.f61090b = aiVar;
        this.f61092d = str;
    }

    public b(ai aiVar, String str, Object obj) {
        this.f61090b = aiVar;
        this.f61092d = str;
        this.f61093e = obj;
    }

    public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        a_(this.f61092d, iJRPaytmDataModel, this.f61093e);
    }

    public void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
        ai aiVar = this.f61090b;
        if (aiVar != null) {
            aiVar.a_(str, iJRPaytmDataModel, obj);
            return;
        }
        net.one97.paytm.recharge.legacy.catalog.a.b bVar = this.f61089a;
        if (bVar != null) {
            bVar.onApiSuccess(iJRPaytmDataModel);
            return;
        }
        com.paytm.network.listener.b bVar2 = this.f61091c;
        if (bVar2 != null) {
            bVar2.onApiSuccess(iJRPaytmDataModel);
        }
    }

    public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        a(this.f61092d, i2, iJRPaytmDataModel, networkCustomError, this.f61093e);
    }

    public void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
        ai aiVar = this.f61090b;
        if (aiVar != null) {
            aiVar.a(str, i2, iJRPaytmDataModel, networkCustomError, obj);
            return;
        }
        net.one97.paytm.recharge.legacy.catalog.a.b bVar = this.f61089a;
        if (bVar != null) {
            bVar.handleErrorCode(i2, iJRPaytmDataModel, networkCustomError);
            return;
        }
        com.paytm.network.listener.b bVar2 = this.f61091c;
        if (bVar2 != null) {
            bVar2.handleErrorCode(i2, iJRPaytmDataModel, networkCustomError);
        }
    }
}
