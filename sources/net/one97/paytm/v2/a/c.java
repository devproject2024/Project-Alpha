package net.one97.paytm.v2.a;

import android.content.Context;
import android.text.TextUtils;
import androidx.lifecycle.y;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.Map;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.vipcashback.CashBackBaseMyOfferModalV4;
import net.one97.paytm.common.entity.vipcashback.ScratchCardModel;
import net.one97.paytm.vipcashback.f.d;
import net.one97.paytm.vipcashback.f.f;
import net.one97.paytm.vipcashback.f.h;
import org.json.JSONObject;

public final class c implements d {

    /* renamed from: a  reason: collision with root package name */
    private final Context f20050a;

    public c(Context context) {
        k.c(context, "appContext");
        this.f20050a = context;
    }

    public final void a(y<h<Object>> yVar, String str) {
        k.c(yVar, "result");
        k.c(str, "refrenceId");
        k.a((Object) f.a(), "GTMHelper.getInstance()");
        String M = f.M();
        if (!TextUtils.isEmpty(M)) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("eventType", "FLIP");
            jSONObject.put("eventId", str);
            d.a aVar = d.f20859a;
            com.paytm.network.b a2 = d.a.c().a(a.C0715a.POST).a(M);
            d.a aVar2 = d.f20859a;
            com.paytm.network.a l = a2.a((Map<String, String>) d.a.b()).a((IJRPaytmDataModel) new CashBackBaseMyOfferModalV4()).c("PostTxnCashback").b(jSONObject.toString()).b((int) AppConstants.START_OTP_FLOW).a((com.paytm.network.listener.b) new a(yVar)).l();
            if (com.paytm.utility.b.c(this.f20050a)) {
                yVar.setValue(h.a());
                l.a();
                return;
            }
            yVar.setValue(h.b(l));
        }
    }

    public static final class a implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f20051a;

        a(y yVar) {
            this.f20051a = yVar;
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            y yVar = this.f20051a;
            if (yVar != null) {
                yVar.setValue(h.a(iJRPaytmDataModel, networkCustomError));
            }
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            y yVar = this.f20051a;
            if (yVar != null) {
                yVar.setValue(h.a(iJRPaytmDataModel));
            }
        }
    }

    public final void b(y<h<Object>> yVar, String str) {
        k.c(yVar, "result");
        k.c(str, "scratchCardId");
        k.a((Object) f.a(), "GTMHelper.getInstance()");
        String q = f.q();
        if (!TextUtils.isEmpty(q)) {
            String str2 = q + str + "/status";
            d.a aVar = d.f20859a;
            com.paytm.network.b a2 = d.a.c().a(a.C0715a.PUT).a(str2);
            d.a aVar2 = d.f20859a;
            com.paytm.network.a l = a2.a((Map<String, String>) d.a.b()).a((IJRPaytmDataModel) new ScratchCardModel()).c("PostTxnCashback").b("{\"scratchCardAction\": \"SCRATCHED\"}").a((com.paytm.network.listener.b) new b(yVar)).l();
            if (com.paytm.utility.b.c(this.f20050a)) {
                l.a();
            } else {
                yVar.setValue(h.b(l));
            }
        }
    }

    public static final class b implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f20052a;

        b(y yVar) {
            this.f20052a = yVar;
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            this.f20052a.setValue(h.a(iJRPaytmDataModel, networkCustomError));
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            this.f20052a.setValue(h.a(iJRPaytmDataModel));
        }
    }
}
