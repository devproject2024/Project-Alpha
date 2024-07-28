package net.one97.paytm.oauth.g;

import android.app.Application;
import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.y;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import kotlin.g.b.k;
import net.one97.paytm.oauth.models.ErrorModel;
import net.one97.paytm.oauth.utils.o;

public final class g extends androidx.lifecycle.a {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g(Application application) {
        super(application);
        k.c(application, "application");
    }

    public final LiveData<net.one97.paytm.oauth.e<IJRPaytmDataModel>> a(String str) {
        k.c(str, "authCode");
        y yVar = new y();
        o oVar = o.f56791a;
        if (o.a()) {
            net.one97.paytm.oauth.b.b.a(str, (com.paytm.network.listener.b) new d(yVar, "oauthTokenV3"));
        } else {
            net.one97.paytm.oauth.b.b.a(str, (Context) getApplication(), (com.paytm.network.listener.b) new e(yVar));
        }
        return yVar;
    }

    public static final class d extends net.one97.paytm.oauth.e.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f56709a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(y yVar, String str) {
            super(str);
            this.f56709a = yVar;
        }

        public final void a(String str, IJRPaytmDataModel iJRPaytmDataModel) {
            this.f56709a.setValue(net.one97.paytm.oauth.e.a(iJRPaytmDataModel, str));
        }

        public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            this.f56709a.postValue(net.one97.paytm.oauth.e.a(new ErrorModel(i2, iJRPaytmDataModel, networkCustomError), networkCustomError, str));
        }
    }

    public static final class e implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f56710a;

        e(y yVar) {
            this.f56710a = yVar;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            k.c(iJRPaytmDataModel, "model");
            this.f56710a.setValue(net.one97.paytm.oauth.e.a(iJRPaytmDataModel));
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            k.c(networkCustomError, "networkError");
            this.f56710a.postValue(net.one97.paytm.oauth.e.a(new ErrorModel(i2, iJRPaytmDataModel, networkCustomError), (Throwable) networkCustomError));
        }
    }

    public static final class a extends net.one97.paytm.oauth.e.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f56706a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(y yVar, String str) {
            super(str);
            this.f56706a = yVar;
        }

        public final void a(String str, IJRPaytmDataModel iJRPaytmDataModel) {
            this.f56706a.setValue(net.one97.paytm.oauth.e.a(iJRPaytmDataModel, str));
        }

        public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            this.f56706a.setValue(net.one97.paytm.oauth.e.a(new ErrorModel(i2, iJRPaytmDataModel, networkCustomError), networkCustomError, str));
        }
    }

    public static LiveData<net.one97.paytm.oauth.e<IJRPaytmDataModel>> a(String str, String str2, String str3, String str4) {
        y yVar = new y();
        net.one97.paytm.oauth.b.b.c(new a(yVar, "oauthdevicebindinginitSv1"), str, str2, str3, str4);
        return yVar;
    }

    public static final class b extends net.one97.paytm.oauth.e.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f56707a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(y yVar, String str) {
            super(str);
            this.f56707a = yVar;
        }

        public final void a(String str, IJRPaytmDataModel iJRPaytmDataModel) {
            this.f56707a.setValue(net.one97.paytm.oauth.e.a(iJRPaytmDataModel, str));
        }

        public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            this.f56707a.setValue(net.one97.paytm.oauth.e.a(new ErrorModel(i2, iJRPaytmDataModel, networkCustomError), networkCustomError, str));
        }
    }

    public static LiveData<net.one97.paytm.oauth.e<IJRPaytmDataModel>> a(String str, String str2) {
        y yVar = new y();
        net.one97.paytm.oauth.b.b.j(new b(yVar, "oauthauthorizeinitSv1"), str, str2);
        return yVar;
    }

    public static final class c extends net.one97.paytm.oauth.e.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f56708a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(y yVar, String str) {
            super(str);
            this.f56708a = yVar;
        }

        public final void a(String str, IJRPaytmDataModel iJRPaytmDataModel) {
            this.f56708a.setValue(net.one97.paytm.oauth.e.a(iJRPaytmDataModel, str));
        }

        public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            this.f56708a.setValue(net.one97.paytm.oauth.e.a(new ErrorModel(i2, iJRPaytmDataModel, networkCustomError), networkCustomError, str));
        }
    }

    public static LiveData<net.one97.paytm.oauth.e<IJRPaytmDataModel>> b(String str, String str2) {
        y yVar = new y();
        net.one97.paytm.oauth.b.b.k(new c(yVar, "oauthV2authorizeSv1"), str, str2);
        return yVar;
    }
}
