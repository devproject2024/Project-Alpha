package net.one97.paytm.oauth.g;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ai;
import androidx.lifecycle.y;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.wallet.CJRQRScanResultModel;
import net.one97.paytm.oauth.models.ErrorModel;

public final class a extends ai {

    /* renamed from: net.one97.paytm.oauth.g.a$a  reason: collision with other inner class name */
    public static final class C1053a implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f56679a;

        C1053a(y yVar) {
            this.f56679a = yVar;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            k.c(iJRPaytmDataModel, "model");
            this.f56679a.setValue(net.one97.paytm.oauth.e.a(iJRPaytmDataModel));
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            k.c(networkCustomError, "networkError");
            this.f56679a.setValue(net.one97.paytm.oauth.e.a(new ErrorModel(i2, iJRPaytmDataModel, networkCustomError), (Throwable) networkCustomError));
        }
    }

    public static LiveData<net.one97.paytm.oauth.e<IJRPaytmDataModel>> a(String str, String str2, String str3, String str4) {
        k.c(str, CJRQRScanResultModel.KEY_COMMENT_SMALL);
        k.c(str2, "verificationData");
        k.c(str3, "verificationType");
        k.c(str4, "status");
        y yVar = new y();
        net.one97.paytm.oauth.b.b.d(new C1053a(yVar), str, str2, str3, str4);
        return yVar;
    }

    public static final class d extends net.one97.paytm.oauth.e.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f56682a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(y yVar, String str) {
            super(str);
            this.f56682a = yVar;
        }

        public final void a(String str, IJRPaytmDataModel iJRPaytmDataModel) {
            this.f56682a.setValue(net.one97.paytm.oauth.e.a(iJRPaytmDataModel, str));
        }

        public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            this.f56682a.setValue(net.one97.paytm.oauth.e.a(new ErrorModel(i2, iJRPaytmDataModel, networkCustomError), networkCustomError, str));
        }
    }

    public static LiveData<net.one97.paytm.oauth.e<IJRPaytmDataModel>> a(String str, String str2) {
        k.c(str, "anchor");
        k.c(str2, "bizFlow");
        y yVar = new y();
        net.one97.paytm.oauth.b.b.m(new d(yVar, "oauthUserVerificationInit"), str, str2);
        return yVar;
    }

    public static final class c extends net.one97.paytm.oauth.e.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f56681a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(y yVar, String str) {
            super(str);
            this.f56681a = yVar;
        }

        public final void a(String str, IJRPaytmDataModel iJRPaytmDataModel) {
            this.f56681a.setValue(net.one97.paytm.oauth.e.a(iJRPaytmDataModel, str));
        }

        public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            this.f56681a.setValue(net.one97.paytm.oauth.e.a(new ErrorModel(i2, iJRPaytmDataModel, networkCustomError), networkCustomError, str));
        }
    }

    public static LiveData<net.one97.paytm.oauth.e<IJRPaytmDataModel>> b(String str, String str2) {
        k.c(str, "verifyId");
        k.c(str2, "verificationMethod");
        y yVar = new y();
        net.one97.paytm.oauth.b.b.l(new c(yVar, "oauthDoView"), str, str2);
        return yVar;
    }

    public static final class b extends net.one97.paytm.oauth.e.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f56680a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(y yVar, String str) {
            super(str);
            this.f56680a = yVar;
        }

        public final void a(String str, IJRPaytmDataModel iJRPaytmDataModel) {
            this.f56680a.setValue(net.one97.paytm.oauth.e.a(iJRPaytmDataModel, str));
        }

        public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            this.f56680a.setValue(net.one97.paytm.oauth.e.a(new ErrorModel(i2, iJRPaytmDataModel, networkCustomError), networkCustomError, str));
        }
    }

    public static LiveData<net.one97.paytm.oauth.e<IJRPaytmDataModel>> a(String str, String str2, String str3) {
        k.c(str, "verifyId");
        k.c(str2, "validateData");
        k.c(str3, "method");
        y yVar = new y();
        net.one97.paytm.oauth.b.b.f(new b(yVar, "oauthDoVerify"), str, str2, str3);
        return yVar;
    }

    public static final class e extends net.one97.paytm.oauth.e.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f56683a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(y yVar, String str) {
            super(str);
            this.f56683a = yVar;
        }

        public final void a(String str, IJRPaytmDataModel iJRPaytmDataModel) {
            this.f56683a.setValue(net.one97.paytm.oauth.e.a(iJRPaytmDataModel, str));
        }

        public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            this.f56683a.setValue(net.one97.paytm.oauth.e.a(new ErrorModel(i2, iJRPaytmDataModel, networkCustomError), networkCustomError, str));
        }
    }

    public static LiveData<net.one97.paytm.oauth.e<IJRPaytmDataModel>> a(String str) {
        y yVar = new y();
        net.one97.paytm.oauth.b.b.b((com.paytm.network.listener.b) new e(yVar, "oauthVerificationFulfill"), str);
        return yVar;
    }

    public static final class f extends net.one97.paytm.oauth.e.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f56684a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(y yVar, String str) {
            super(str);
            this.f56684a = yVar;
        }

        public final void a(String str, IJRPaytmDataModel iJRPaytmDataModel) {
            this.f56684a.setValue(net.one97.paytm.oauth.e.a(iJRPaytmDataModel, str));
        }

        public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            this.f56684a.setValue(net.one97.paytm.oauth.e.a(new ErrorModel(i2, iJRPaytmDataModel, networkCustomError), networkCustomError, str));
        }
    }

    public static LiveData<net.one97.paytm.oauth.e<IJRPaytmDataModel>> b(String str, String str2, String str3, String str4) {
        k.c(str2, "expiryMonth");
        k.c(str4, "verifyId");
        y yVar = new y();
        net.one97.paytm.oauth.b.b.b(new f(yVar, "oauthVerifyCard"), str, str2, str3, str4);
        return yVar;
    }
}
