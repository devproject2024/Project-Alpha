package net.one97.paytm.widget;

import androidx.fragment.app.FragmentActivity;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytmmall.clpartifact.listeners.IGAHandlerListener;
import com.paytmmall.clpartifact.modal.SanitizedResponseModel;
import com.paytmmall.clpartifact.network.SFCallbackListener;
import com.paytmmall.clpartifact.utils.SFInterface;
import com.paytmmall.clpartifact.widgets.blueprints.IStaticWidget;
import com.paytmmall.clpartifact.widgets.blueprints.IWidgetProvider;
import com.paytmmall.clpartifact.widgets.blueprints.SFWidget;
import java.util.HashMap;
import java.util.LinkedHashMap;
import kotlin.g.b.k;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    public static final g f72427a = new g();

    private g() {
    }

    public static void a(String str, FragmentActivity fragmentActivity, b bVar) {
        k.c(str, "url");
        k.c(fragmentActivity, "activity");
        k.c(bVar, "listener");
        SFInterface.INSTANCE.getStoreFrontReponse(str, new HashMap(), a.c.WALLET, new a(fragmentActivity, bVar));
    }

    static final class a implements SFCallbackListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FragmentActivity f72428a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ b f72429b;

        a(FragmentActivity fragmentActivity, b bVar) {
            this.f72428a = fragmentActivity;
            this.f72429b = bVar;
        }

        public /* synthetic */ void onFailure(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            SFCallbackListener.CC.$default$onFailure(this, i2, iJRPaytmDataModel, networkCustomError);
        }

        public final void onSuccess(SanitizedResponseModel sanitizedResponseModel) {
            if (sanitizedResponseModel != null) {
                g gVar = g.f72427a;
                g.a((LinkedHashMap) sanitizedResponseModel.getSfWidgets(), this.f72428a, this.f72429b);
            }
        }
    }

    public static final /* synthetic */ void a(LinkedHashMap linkedHashMap, FragmentActivity fragmentActivity, b bVar) {
        IWidgetProvider iWidgetProvider = (IWidgetProvider) linkedHashMap.get(104);
        SFWidget sFWidget = null;
        if (iWidgetProvider != null) {
            sFWidget = iWidgetProvider.getWidget(fragmentActivity, (IGAHandlerListener) null);
        }
        if (sFWidget instanceof IStaticWidget) {
            bVar.onReceivedWidget((IStaticWidget) sFWidget);
        }
    }
}
