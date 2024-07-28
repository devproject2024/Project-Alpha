package net.one97.paytm.recharge.common.e;

import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import io.reactivex.rxjava3.a.aa;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.a.z;
import io.reactivex.rxjava3.b.c;

public final class a<T extends IJRPaytmDataModel> implements aa<T>, w<T>, ai {

    /* renamed from: a  reason: collision with root package name */
    private ae f61083a;

    /* renamed from: b  reason: collision with root package name */
    private z<IJRPaytmDataModel> f61084b;

    /* renamed from: c  reason: collision with root package name */
    private IJRPaytmDataModel f61085c;

    /* renamed from: d  reason: collision with root package name */
    private Object f61086d;

    /* renamed from: e  reason: collision with root package name */
    private int f61087e;

    /* renamed from: f  reason: collision with root package name */
    private String f61088f;

    public final void onComplete() {
    }

    public final /* synthetic */ void onNext(Object obj) {
        IJRPaytmDataModel iJRPaytmDataModel = (IJRPaytmDataModel) obj;
        ae aeVar = this.f61083a;
        if (aeVar != null) {
            aeVar.a_(this.f61088f, iJRPaytmDataModel, this.f61086d);
        }
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        IJRPaytmDataModel iJRPaytmDataModel = (IJRPaytmDataModel) obj;
        ae aeVar = this.f61083a;
        if (aeVar != null) {
            aeVar.a_(this.f61088f, iJRPaytmDataModel, this.f61086d);
        }
    }

    public a(String str, ae aeVar) {
        this.f61088f = str;
        this.f61083a = aeVar;
    }

    public final void a(z<IJRPaytmDataModel> zVar) {
        this.f61084b = zVar;
    }

    public final void a() {
        this.f61083a = null;
        this.f61084b = null;
        this.f61085c = null;
        this.f61086d = null;
        this.f61087e = -1;
        this.f61088f = null;
    }

    public final void onSubscribe(c cVar) {
        ae aeVar = this.f61083a;
        if (aeVar != null) {
            aeVar.a(this.f61088f, cVar);
        }
    }

    public final void onError(Throwable th) {
        NetworkCustomError networkCustomError;
        NetworkCustomError networkCustomError2;
        if (this.f61083a != null) {
            if (th instanceof NetworkCustomError) {
                networkCustomError2 = (NetworkCustomError) th;
            } else if (th != null) {
                networkCustomError = new NetworkCustomError(th);
                this.f61083a.a(this.f61088f, this.f61087e, this.f61085c, networkCustomError, this.f61086d);
            } else {
                networkCustomError2 = new NetworkCustomError();
            }
            networkCustomError = networkCustomError2;
            this.f61083a.a(this.f61088f, this.f61087e, this.f61085c, networkCustomError, this.f61086d);
        }
    }

    public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
        this.f61088f = str;
        this.f61086d = obj;
        z<IJRPaytmDataModel> zVar = this.f61084b;
        if (zVar == null) {
            return;
        }
        if (!zVar.isDisposed()) {
            this.f61084b.onSuccess(iJRPaytmDataModel);
            return;
        }
        ae aeVar = this.f61083a;
        if (aeVar != null) {
            aeVar.a_(str, iJRPaytmDataModel, obj);
        }
    }

    public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
        this.f61088f = str;
        this.f61087e = i2;
        this.f61085c = iJRPaytmDataModel;
        this.f61086d = obj;
        z<IJRPaytmDataModel> zVar = this.f61084b;
        if (zVar == null) {
            return;
        }
        if (!zVar.isDisposed()) {
            this.f61084b.onError(networkCustomError);
            return;
        }
        ae aeVar = this.f61083a;
        if (aeVar != null) {
            aeVar.a(str, i2, this.f61085c, networkCustomError, obj);
        }
    }
}
