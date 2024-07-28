package net.one97.paytm.upgradeKyc.f;

import android.content.Context;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.b;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.upgradeKyc.ScreenTabModel;
import net.one97.paytm.upgradeKyc.helper.a;
import net.one97.paytm.upgradeKyc.helper.d;
import org.json.JSONException;
import org.json.JSONObject;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    g f66000a;

    /* renamed from: b  reason: collision with root package name */
    private Context f66001b;

    /* renamed from: c  reason: collision with root package name */
    private int f66002c;

    public h(Context context, int i2, g gVar) {
        k.c(context, "context");
        k.c(gVar, "listener");
        this.f66000a = gVar;
        Context applicationContext = context.getApplicationContext();
        k.a((Object) applicationContext, "context.applicationContext");
        this.f66001b = applicationContext;
        this.f66002c = i2;
    }

    public final void a() {
        d.a aVar = d.f66026a;
        String str = null;
        if (d.a.a() != null) {
            d.a aVar2 = d.f66026a;
            if (d.a.a() != null) {
                str = d.a("screen_tabs");
            }
        }
        try {
            if (b.c(this.f66001b)) {
                HashMap hashMap = new HashMap();
                hashMap.put("Content-Type", "application/json");
                hashMap.put("session_token", com.paytm.utility.d.a(this.f66001b));
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("noOfNearbyCentres", this.f66002c);
                a.C1317a aVar3 = net.one97.paytm.upgradeKyc.helper.a.f66022a;
                a.C1317a.a().a(this.f66001b).a(a.C0715a.POST).a((Map<String, String>) hashMap).a((IJRPaytmDataModel) new ScreenTabModel()).a(str).c(h.class.getName()).b(jSONObject.toString()).a(a.b.USER_FACING).a((com.paytm.network.listener.b) new a(this)).l().a();
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static final class a implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f66003a;

        a(h hVar) {
            this.f66003a = hVar;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            h.a(this.f66003a, iJRPaytmDataModel);
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            k.c(networkCustomError, "networkCustomError");
            g gVar = this.f66003a.f66000a;
            if (gVar != null) {
                gVar.a(networkCustomError);
            }
        }
    }

    public static final /* synthetic */ void a(h hVar, IJRPaytmDataModel iJRPaytmDataModel) {
        g gVar;
        g gVar2 = hVar.f66000a;
        if (gVar2 != null) {
            gVar2.a();
        }
        if (iJRPaytmDataModel != null && (iJRPaytmDataModel instanceof ScreenTabModel) && (gVar = hVar.f66000a) != null) {
            gVar.a((ScreenTabModel) iJRPaytmDataModel);
        }
    }
}
