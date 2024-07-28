package net.one97.paytm.newaddmoney.utils;

import android.content.Context;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytmmall.clpartifact.listeners.IGAEnableListener;
import com.paytmmall.clpartifact.modal.SanitizedResponseModel;
import com.paytmmall.clpartifact.network.SFCallbackListener;
import com.paytmmall.clpartifact.utils.SFInterface;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.addmoney.utils.AddMoneyUtils;
import net.one97.paytm.addmoney.utils.j;
import net.one97.paytm.helper.b;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static final e f55853a = new e();

    private e() {
    }

    public static final boolean a() {
        return net.one97.paytm.helper.a.f50546a.a().a();
    }

    public static final String a(Context context) {
        return AddMoneyUtils.g(j.d(context != null ? context.getApplicationContext() : null));
    }

    public static final class a implements SFCallbackListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f55854a;

        public /* synthetic */ void onFailure(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            SFCallbackListener.CC.$default$onFailure(this, i2, iJRPaytmDataModel, networkCustomError);
        }

        a(b bVar) {
            this.f55854a = bVar;
        }

        public final void onSuccess(SanitizedResponseModel sanitizedResponseModel) {
            if (sanitizedResponseModel != null) {
                this.f55854a.onWidgetLoaded(sanitizedResponseModel);
            }
        }
    }

    public static final void a(Context context, String str, b bVar, String str2) {
        k.c(str, "url");
        k.c(bVar, "homeWidgetListener");
        k.c(str2, SDKConstants.EVENT_KEY_SCREEN_NAME);
        String e2 = com.paytm.utility.b.e(context, str);
        SFInterface sFInterface = SFInterface.INSTANCE;
        k.a((Object) e2, "newUrl");
        sFInterface.getStoreFrontReponse(e2, new HashMap(), a.c.ADDMONEY, new a(bVar), str2, 1004, (IGAEnableListener) null);
    }
}
