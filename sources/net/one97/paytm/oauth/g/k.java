package net.one97.paytm.oauth.g;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ai;
import androidx.lifecycle.y;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import net.one97.paytm.oauth.models.ErrorModel;

public final class k extends ai {

    public static final class e extends net.one97.paytm.oauth.e.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f56731a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(y yVar, String str) {
            super(str);
            this.f56731a = yVar;
        }

        public final void a(String str, IJRPaytmDataModel iJRPaytmDataModel) {
            this.f56731a.setValue(net.one97.paytm.oauth.e.a(iJRPaytmDataModel, str));
        }

        public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            this.f56731a.setValue(net.one97.paytm.oauth.e.a(new ErrorModel(i2, iJRPaytmDataModel, networkCustomError), networkCustomError, str));
        }
    }

    public static LiveData<net.one97.paytm.oauth.e<IJRPaytmDataModel>> a(String str, String str2, String str3) {
        kotlin.g.b.k.c(str2, "mode");
        y yVar = new y();
        net.one97.paytm.oauth.b.b.c(new e(yVar, "sendOtpV4"), str, str2, str3);
        return yVar;
    }

    public static final class d extends net.one97.paytm.oauth.e.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f56730a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(y yVar, String str) {
            super(str);
            this.f56730a = yVar;
        }

        public final void a(String str, IJRPaytmDataModel iJRPaytmDataModel) {
            this.f56730a.setValue(net.one97.paytm.oauth.e.a(iJRPaytmDataModel, str));
        }

        public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            this.f56730a.setValue(net.one97.paytm.oauth.e.a(new ErrorModel(i2, iJRPaytmDataModel, networkCustomError), networkCustomError, str));
        }
    }

    public static LiveData<net.one97.paytm.oauth.e<IJRPaytmDataModel>> a(String str, String str2) {
        kotlin.g.b.k.c(str2, "actionType");
        y yVar = new y();
        net.one97.paytm.oauth.b.b.f(new d(yVar, "oauthSendOtpV3"), str, str2);
        return yVar;
    }

    public static final class j extends net.one97.paytm.oauth.e.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f56736a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(y yVar, String str) {
            super(str);
            this.f56736a = yVar;
        }

        public final void a(String str, IJRPaytmDataModel iJRPaytmDataModel) {
            this.f56736a.setValue(net.one97.paytm.oauth.e.a(iJRPaytmDataModel, str));
        }

        public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            this.f56736a.setValue(net.one97.paytm.oauth.e.a(new ErrorModel(i2, iJRPaytmDataModel, networkCustomError), networkCustomError, str));
        }
    }

    public static LiveData<net.one97.paytm.oauth.e<IJRPaytmDataModel>> b(String str, String str2, String str3) {
        kotlin.g.b.k.c(str, "otp");
        y yVar = new y();
        net.one97.paytm.oauth.b.b.b((com.paytm.network.listener.b) new j(yVar, "validateOtpV4"), str, str2, str3);
        return yVar;
    }

    public static final class f extends net.one97.paytm.oauth.e.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f56732a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(y yVar, String str) {
            super(str);
            this.f56732a = yVar;
        }

        public final void a(String str, IJRPaytmDataModel iJRPaytmDataModel) {
            this.f56732a.setValue(net.one97.paytm.oauth.e.a(iJRPaytmDataModel, str));
        }

        public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            this.f56732a.setValue(net.one97.paytm.oauth.e.a(new ErrorModel(i2, iJRPaytmDataModel, networkCustomError), networkCustomError, str));
        }
    }

    public static LiveData<net.one97.paytm.oauth.e<IJRPaytmDataModel>> b(String str, String str2) {
        kotlin.g.b.k.c(str2, "mobileNo");
        y yVar = new y();
        net.one97.paytm.oauth.b.b.b(new f(yVar, "userPhoneV4"), str, str2);
        return yVar;
    }

    public static final class i extends net.one97.paytm.oauth.e.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f56735a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(y yVar, String str) {
            super(str);
            this.f56735a = yVar;
        }

        public final void a(String str, IJRPaytmDataModel iJRPaytmDataModel) {
            this.f56735a.setValue(net.one97.paytm.oauth.e.a(iJRPaytmDataModel, str));
        }

        public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            this.f56735a.setValue(net.one97.paytm.oauth.e.a(new ErrorModel(i2, iJRPaytmDataModel, networkCustomError), networkCustomError, str));
        }
    }

    public static LiveData<net.one97.paytm.oauth.e<IJRPaytmDataModel>> c(String str, String str2) {
        kotlin.g.b.k.c(str, "otp");
        y yVar = new y();
        net.one97.paytm.oauth.b.b.c(new i(yVar, "userValidateOtpV4"), str2, str);
        return yVar;
    }

    public static final class a extends net.one97.paytm.oauth.e.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f56727a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(y yVar, String str) {
            super(str);
            this.f56727a = yVar;
        }

        public final void a(String str, IJRPaytmDataModel iJRPaytmDataModel) {
            this.f56727a.setValue(net.one97.paytm.oauth.e.a(iJRPaytmDataModel, str));
        }

        public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            this.f56727a.setValue(net.one97.paytm.oauth.e.a(new ErrorModel(i2, iJRPaytmDataModel, networkCustomError), networkCustomError, str));
        }
    }

    public static LiveData<net.one97.paytm.oauth.e<IJRPaytmDataModel>> a(String str) {
        y yVar = new y();
        net.one97.paytm.oauth.b.b.a((com.paytm.network.listener.b) new a(yVar, "oauthResendOtp"), str);
        return yVar;
    }

    public static final class h extends net.one97.paytm.oauth.e.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f56734a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(y yVar, String str) {
            super(str);
            this.f56734a = yVar;
        }

        public final void a(String str, IJRPaytmDataModel iJRPaytmDataModel) {
            this.f56734a.setValue(net.one97.paytm.oauth.e.a(iJRPaytmDataModel, str));
        }

        public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            this.f56734a.setValue(net.one97.paytm.oauth.e.a(new ErrorModel(i2, iJRPaytmDataModel, networkCustomError), networkCustomError, str));
        }
    }

    public static LiveData<net.one97.paytm.oauth.e<IJRPaytmDataModel>> c(String str, String str2, String str3) {
        kotlin.g.b.k.c(str, "otp");
        y yVar = new y();
        net.one97.paytm.oauth.b.b.a((com.paytm.network.listener.b) new h(yVar, "profileValidateOTPV3"), str2, str, "", str3);
        return yVar;
    }

    public static final class g extends net.one97.paytm.oauth.e.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f56733a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(y yVar, String str) {
            super(str);
            this.f56733a = yVar;
        }

        public final void a(String str, IJRPaytmDataModel iJRPaytmDataModel) {
            this.f56733a.setValue(net.one97.paytm.oauth.e.a(iJRPaytmDataModel, str));
        }

        public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            this.f56733a.setValue(net.one97.paytm.oauth.e.a(new ErrorModel(i2, iJRPaytmDataModel, networkCustomError), networkCustomError, str));
        }
    }

    public static LiveData<net.one97.paytm.oauth.e<IJRPaytmDataModel>> d(String str, String str2, String str3) {
        y yVar = new y();
        net.one97.paytm.oauth.b.b.d(new g(yVar, "profileResendOTPV3"), str, str2, str3);
        return yVar;
    }

    public static final class l extends net.one97.paytm.oauth.e.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f56738a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        l(y yVar, String str) {
            super(str);
            this.f56738a = yVar;
        }

        public final void a(String str, IJRPaytmDataModel iJRPaytmDataModel) {
            this.f56738a.setValue(net.one97.paytm.oauth.e.a(iJRPaytmDataModel, str));
        }

        public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            this.f56738a.setValue(net.one97.paytm.oauth.e.a(new ErrorModel(i2, iJRPaytmDataModel, networkCustomError), networkCustomError, str));
        }
    }

    public static LiveData<net.one97.paytm.oauth.e<IJRPaytmDataModel>> d(String str, String str2) {
        kotlin.g.b.k.c(str2, "bizFlow");
        y yVar = new y();
        net.one97.paytm.oauth.b.b.g(new l(yVar, "oauthVerificationInit"), str, str2);
        return yVar;
    }

    /* renamed from: net.one97.paytm.oauth.g.k$k  reason: collision with other inner class name */
    public static final class C1054k extends net.one97.paytm.oauth.e.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f56737a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1054k(y yVar, String str) {
            super(str);
            this.f56737a = yVar;
        }

        public final void a(String str, IJRPaytmDataModel iJRPaytmDataModel) {
            this.f56737a.setValue(net.one97.paytm.oauth.e.a(iJRPaytmDataModel, str));
        }

        public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            this.f56737a.setValue(net.one97.paytm.oauth.e.a(new ErrorModel(i2, iJRPaytmDataModel, networkCustomError), networkCustomError, str));
        }
    }

    public static LiveData<net.one97.paytm.oauth.e<IJRPaytmDataModel>> b(String str) {
        y yVar = new y();
        net.one97.paytm.oauth.b.b.b((com.paytm.network.listener.b) new C1054k(yVar, "oauthVerificationFulfill"), str);
        return yVar;
    }

    public static final class b extends net.one97.paytm.oauth.e.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f56728a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(y yVar, String str) {
            super(str);
            this.f56728a = yVar;
        }

        public final void a(String str, IJRPaytmDataModel iJRPaytmDataModel) {
            this.f56728a.setValue(net.one97.paytm.oauth.e.a(iJRPaytmDataModel, str));
        }

        public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            this.f56728a.setValue(net.one97.paytm.oauth.e.a(new ErrorModel(i2, iJRPaytmDataModel, networkCustomError), networkCustomError, str));
        }
    }

    public static LiveData<net.one97.paytm.oauth.e<IJRPaytmDataModel>> e(String str, String str2) {
        y yVar = new y();
        net.one97.paytm.oauth.b.b.h(new b(yVar, "restDoViewLogin"), str, str2);
        return yVar;
    }

    public static final class c extends net.one97.paytm.oauth.e.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f56729a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(y yVar, String str) {
            super(str);
            this.f56729a = yVar;
        }

        public final void a(String str, IJRPaytmDataModel iJRPaytmDataModel) {
            this.f56729a.setValue(net.one97.paytm.oauth.e.a(iJRPaytmDataModel, str));
        }

        public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            this.f56729a.setValue(net.one97.paytm.oauth.e.a(new ErrorModel(i2, iJRPaytmDataModel, networkCustomError), networkCustomError, str));
        }
    }

    public static LiveData<net.one97.paytm.oauth.e<IJRPaytmDataModel>> c(String str) {
        y yVar = new y();
        net.one97.paytm.oauth.b.b.c((com.paytm.network.listener.b) new c(yVar, "restDoViewLogout"), str);
        return yVar;
    }

    public static final class m extends net.one97.paytm.oauth.e.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f56739a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        m(y yVar, String str) {
            super(str);
            this.f56739a = yVar;
        }

        public final void a(String str, IJRPaytmDataModel iJRPaytmDataModel) {
            this.f56739a.setValue(net.one97.paytm.oauth.e.a(iJRPaytmDataModel, str));
        }

        public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            this.f56739a.setValue(net.one97.paytm.oauth.e.a(new ErrorModel(i2, iJRPaytmDataModel, networkCustomError), networkCustomError, str));
        }
    }

    public static LiveData<net.one97.paytm.oauth.e<IJRPaytmDataModel>> a(String str, String str2, String str3, String str4) {
        kotlin.g.b.k.c(str2, "expiryMonth");
        kotlin.g.b.k.c(str4, "verifyId");
        y yVar = new y();
        net.one97.paytm.oauth.b.b.b(new m(yVar, "oauthVerifyCard"), str, str2, str3, str4);
        return yVar;
    }
}
