package net.one97.paytm.oauth.g;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ai;
import androidx.lifecycle.y;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import net.one97.paytm.oauth.b.b;
import net.one97.paytm.oauth.e;
import net.one97.paytm.oauth.e.a;
import net.one97.paytm.oauth.models.ErrorModel;

public class h extends ai {
    public final LiveData<e<IJRPaytmDataModel>> a(Context context, String str, String str2) {
        final y yVar = new y();
        b.b(context, (com.paytm.network.listener.b) new a("oauthValidateOtpSv1") {
            public final void a(String str, IJRPaytmDataModel iJRPaytmDataModel) {
                yVar.setValue(e.a(iJRPaytmDataModel, str));
            }

            public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                yVar.setValue(e.a(new ErrorModel(i2, iJRPaytmDataModel, networkCustomError), networkCustomError, str));
            }
        }, str, str2);
        return yVar;
    }

    public final LiveData<e<IJRPaytmDataModel>> a(String str, String str2, String str3) {
        final y yVar = new y();
        b.a((com.paytm.network.listener.b) new a("oauthdevicebindingConfirmSv1") {
            public final void a(String str, IJRPaytmDataModel iJRPaytmDataModel) {
                yVar.setValue(e.a(iJRPaytmDataModel, str));
            }

            public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                yVar.setValue(e.a(new ErrorModel(i2, iJRPaytmDataModel, networkCustomError), networkCustomError, str));
            }
        }, str, str2, str3);
        return yVar;
    }

    public final LiveData<e<IJRPaytmDataModel>> a(Context context, String str, boolean z) {
        final y yVar = new y();
        b.a(context, (com.paytm.network.listener.b) new a("oauthSimpleResendOtpSv1") {
            public final void a(String str, IJRPaytmDataModel iJRPaytmDataModel) {
                yVar.setValue(e.a(iJRPaytmDataModel, str));
            }

            public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                yVar.setValue(e.a(new ErrorModel(i2, iJRPaytmDataModel, networkCustomError), networkCustomError, str));
            }
        }, str, z);
        return yVar;
    }

    public final LiveData<e<IJRPaytmDataModel>> a(String str) {
        final y yVar = new y();
        b.d((com.paytm.network.listener.b) new a("oauthdevicebindingstatusSv1") {
            public final void a(String str, IJRPaytmDataModel iJRPaytmDataModel) {
                yVar.setValue(e.a(iJRPaytmDataModel, str));
            }

            public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                yVar.setValue(e.a(new ErrorModel(i2, iJRPaytmDataModel, networkCustomError), networkCustomError, str));
            }
        }, str);
        return yVar;
    }

    public final LiveData<e<IJRPaytmDataModel>> a(String str, boolean z) {
        final y yVar = new y();
        b.d(new a("OauthResendOTPSV1") {
            public final void a(String str, IJRPaytmDataModel iJRPaytmDataModel) {
                yVar.setValue(e.a(iJRPaytmDataModel, str));
            }

            public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                yVar.setValue(e.a(new ErrorModel(i2, iJRPaytmDataModel, networkCustomError), networkCustomError, str));
            }
        }, str, z ? "OBD" : null);
        return yVar;
    }
}
