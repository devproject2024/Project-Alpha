package com.travel.train.k;

import androidx.lifecycle.ai;
import androidx.lifecycle.y;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.travel.train.a.a;
import com.travel.train.model.e;
import com.travel.train.model.trainticket.CJRTrainBooking;
import com.travel.train.model.trainticket.CJRTrainVerifyCheckout;
import java.util.HashMap;
import kotlin.g.b.k;
import org.json.JSONObject;

public final class f extends ai implements b {

    /* renamed from: a  reason: collision with root package name */
    public y<CJRTrainBooking> f27659a = new y<>();

    /* renamed from: b  reason: collision with root package name */
    public y<Boolean> f27660b = new y<>();

    /* renamed from: c  reason: collision with root package name */
    public y<e> f27661c = new y<>();

    /* renamed from: d  reason: collision with root package name */
    public y<CJRTrainVerifyCheckout> f27662d = new y<>();

    /* renamed from: e  reason: collision with root package name */
    public a f27663e;

    /* renamed from: f  reason: collision with root package name */
    private y<com.paytm.network.a> f27664f = new y<>();

    public f(a aVar) {
        k.c(aVar, "mRepo");
        this.f27663e = aVar;
    }

    public final void a(HashMap<String, String> hashMap, HashMap<String, String> hashMap2, JSONObject jSONObject) {
        k.c(hashMap, "headers");
        k.c(hashMap2, "urlParams");
        this.f27660b.postValue(Boolean.TRUE);
        b bVar = this;
        this.f27663e.a(bVar, bVar, hashMap, hashMap2, jSONObject);
    }

    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        this.f27660b.postValue(Boolean.FALSE);
        if (iJRPaytmDataModel instanceof CJRTrainBooking) {
            this.f27659a.postValue(iJRPaytmDataModel);
        } else if (iJRPaytmDataModel instanceof CJRTrainVerifyCheckout) {
            this.f27662d.postValue(iJRPaytmDataModel);
        }
    }

    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        this.f27660b.postValue(Boolean.FALSE);
        if ((networkCustomError != null ? networkCustomError.getErrorType() : null) == NetworkCustomError.ErrorType.NetworkError) {
            this.f27664f.postValue(this.f27663e.a());
        }
        e eVar = new e();
        eVar.a(i2);
        eVar.a(iJRPaytmDataModel);
        eVar.a(networkCustomError);
        this.f27661c.postValue(eVar);
    }
}
