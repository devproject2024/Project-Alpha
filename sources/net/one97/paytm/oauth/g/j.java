package net.one97.paytm.oauth.g;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ai;
import androidx.lifecycle.y;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import kotlin.g.b.k;
import net.one97.paytm.oauth.models.ErrorModel;

public final class j extends ai {

    public static final class c extends net.one97.paytm.oauth.e.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f56724a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(y yVar, String str) {
            super(str);
            this.f56724a = yVar;
        }

        public final void a(String str, IJRPaytmDataModel iJRPaytmDataModel) {
            this.f56724a.setValue(net.one97.paytm.oauth.e.a(iJRPaytmDataModel, str));
        }

        public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            this.f56724a.setValue(net.one97.paytm.oauth.e.a(new ErrorModel(i2, iJRPaytmDataModel, networkCustomError), networkCustomError, str));
        }
    }

    public static LiveData<net.one97.paytm.oauth.e<IJRPaytmDataModel>> a(String str, String str2) {
        k.c(str2, "actionType");
        y yVar = new y();
        net.one97.paytm.oauth.b.b.f(new c(yVar, "oauthSendOtpV3"), str, str2);
        return yVar;
    }

    public static final class a extends net.one97.paytm.oauth.e.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f56722a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(y yVar, String str) {
            super(str);
            this.f56722a = yVar;
        }

        public final void a(String str, IJRPaytmDataModel iJRPaytmDataModel) {
            this.f56722a.setValue(net.one97.paytm.oauth.e.a(iJRPaytmDataModel, str));
        }

        public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            this.f56722a.setValue(net.one97.paytm.oauth.e.a(new ErrorModel(i2, iJRPaytmDataModel, networkCustomError), networkCustomError, str));
        }
    }

    public static LiveData<net.one97.paytm.oauth.e<IJRPaytmDataModel>> a(String str) {
        y yVar = new y();
        net.one97.paytm.oauth.b.b.d(new a(yVar, "OauthResendOTPSV1"), str, (String) null);
        return yVar;
    }

    public static final class e extends net.one97.paytm.oauth.e.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f56726a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(y yVar, String str) {
            super(str);
            this.f56726a = yVar;
        }

        public final void a(String str, IJRPaytmDataModel iJRPaytmDataModel) {
            this.f56726a.setValue(net.one97.paytm.oauth.e.a(iJRPaytmDataModel, str));
        }

        public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            this.f56726a.setValue(net.one97.paytm.oauth.e.a(new ErrorModel(i2, iJRPaytmDataModel, networkCustomError), networkCustomError, str));
        }
    }

    public static LiveData<net.one97.paytm.oauth.e<IJRPaytmDataModel>> a(String str, String str2, String str3) {
        k.c(str, "otp");
        y yVar = new y();
        net.one97.paytm.oauth.b.b.e(new e(yVar, "OauthValidateOTPV4SV1"), str, str2, str3);
        return yVar;
    }

    public static final class b extends net.one97.paytm.oauth.e.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f56723a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(y yVar, String str) {
            super(str);
            this.f56723a = yVar;
        }

        public final void a(String str, IJRPaytmDataModel iJRPaytmDataModel) {
            this.f56723a.setValue(net.one97.paytm.oauth.e.a(iJRPaytmDataModel, str));
        }

        public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            this.f56723a.setValue(net.one97.paytm.oauth.e.a(new ErrorModel(i2, iJRPaytmDataModel, networkCustomError), networkCustomError, str));
        }
    }

    public static LiveData<net.one97.paytm.oauth.e<IJRPaytmDataModel>> b(String str, String str2) {
        y yVar = new y();
        net.one97.paytm.oauth.b.b.a((com.paytm.network.listener.b) new b(yVar, "OauthsendOTPUserEmailV4SV1"), str, str2);
        return yVar;
    }

    public static final class d extends net.one97.paytm.oauth.e.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f56725a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(y yVar, String str) {
            super(str);
            this.f56725a = yVar;
        }

        public final void a(String str, IJRPaytmDataModel iJRPaytmDataModel) {
            this.f56725a.setValue(net.one97.paytm.oauth.e.a(iJRPaytmDataModel, str));
        }

        public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            this.f56725a.setValue(net.one97.paytm.oauth.e.a(new ErrorModel(i2, iJRPaytmDataModel, networkCustomError), networkCustomError, str));
        }
    }

    public static LiveData<net.one97.paytm.oauth.e<IJRPaytmDataModel>> c(String str, String str2) {
        k.c(str, "otp");
        y yVar = new y();
        net.one97.paytm.oauth.b.b.e(new d(yVar, "OauthUserValidateOTPSV1"), str2, str);
        return yVar;
    }
}
