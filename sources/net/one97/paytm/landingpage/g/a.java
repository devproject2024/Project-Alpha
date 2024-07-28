package net.one97.paytm.landingpage.g;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import androidx.lifecycle.y;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.c;
import com.paytmmall.clpartifact.listeners.IGAEnableListener;
import com.paytmmall.clpartifact.modal.SanitizedResponseModel;
import com.paytmmall.clpartifact.network.SFCallbackListener;
import com.paytmmall.clpartifact.utils.SFInterface;
import java.util.HashMap;
import kotlin.g.b.k;

public final class a extends androidx.lifecycle.a {

    /* renamed from: a  reason: collision with root package name */
    public y<SanitizedResponseModel> f52792a = new y<>();

    /* renamed from: b  reason: collision with root package name */
    public y<net.one97.paytm.landingpage.leftNavigation.model.a> f52793b = new y<>();

    /* renamed from: c  reason: collision with root package name */
    public String f52794c = "generic_storefront";

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(Application application) {
        super(application);
        k.c(application, "application");
    }

    public final void a(String str) {
        k.c(str, "url");
        if (!TextUtils.isEmpty(str)) {
            SFInterface sFInterface = SFInterface.INSTANCE;
            sFInterface.getStoreFrontReponse(str + c.a((Context) getApplication(), true), new HashMap(), a.c.HOME, new C0942a(this), this.f52794c, 1004, (IGAEnableListener) null);
        }
    }

    /* renamed from: net.one97.paytm.landingpage.g.a$a  reason: collision with other inner class name */
    public static final class C0942a implements SFCallbackListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f52795a;

        C0942a(a aVar) {
            this.f52795a = aVar;
        }

        public final void onSuccess(SanitizedResponseModel sanitizedResponseModel) {
            this.f52795a.f52792a.setValue(sanitizedResponseModel);
        }

        public final void onFailure(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            this.f52795a.f52793b.setValue(new net.one97.paytm.landingpage.leftNavigation.model.a(i2, networkCustomError, iJRPaytmDataModel));
            SFCallbackListener.CC.$default$onFailure(this, i2, iJRPaytmDataModel, networkCustomError);
        }
    }
}
