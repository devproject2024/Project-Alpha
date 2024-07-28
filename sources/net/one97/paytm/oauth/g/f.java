package net.one97.paytm.oauth.g;

import android.app.Application;
import android.content.Context;
import android.webkit.URLUtil;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.a;
import androidx.lifecycle.y;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import java.security.SignatureException;
import java.util.HashMap;
import net.one97.paytm.oauth.OauthModule;
import net.one97.paytm.oauth.e;
import net.one97.paytm.oauth.fragment.ag;
import net.one97.paytm.oauth.models.ErrorModel;
import net.one97.paytm.oauth.models.SimplifiedLoginInit;
import net.one97.paytm.oauth.utils.l;
import net.one97.paytm.oauth.utils.o;
import net.one97.paytm.oauth.utils.s;
import org.json.JSONException;
import org.json.JSONObject;

public class f extends a {
    public f(Application application) {
        super(application);
    }

    public final LiveData<e<IJRPaytmDataModel>> a(String str, String str2) throws SignatureException {
        final y yVar = new y();
        Application application = getApplication();
        AnonymousClass1 r2 = new b() {
            public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                yVar.setValue(e.a(iJRPaytmDataModel));
            }

            public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                yVar.setValue(e.a(new ErrorModel(i2, iJRPaytmDataModel, networkCustomError), (Throwable) networkCustomError));
            }
        };
        net.one97.paytm.oauth.a.a();
        String a2 = net.one97.paytm.oauth.a.a("oauthValidatePwdSv1");
        o oVar = o.f56791a;
        if (!o.a()) {
            net.one97.paytm.oauth.a.a();
            a2 = net.one97.paytm.oauth.a.a("simple_auth_validate_pwd_url");
        }
        if (URLUtil.isValidUrl(a2)) {
            String e2 = com.paytm.utility.b.e((Context) application, a2);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("password", str);
                jSONObject.put("stateToken", str2);
            } catch (JSONException e3) {
                q.b(e3.getMessage());
            }
            s sVar = s.f56801a;
            HashMap<String, String> a3 = s.a();
            a3.put("autoReadHash", OauthModule.a().c());
            o oVar2 = o.f56791a;
            o.a(e2, l.a(a.C0715a.POST), a3, jSONObject.toString());
            com.paytm.network.b a4 = net.one97.paytm.oauth.b.b.a(ag.class.getName());
            a4.n = a.b.SILENT;
            a4.f42879c = a.C0715a.POST;
            a4.f42880d = e2;
            a4.f42882f = a3;
            a4.f42884h = jSONObject.toString();
            a4.j = r2;
            a4.f42885i = new SimplifiedLoginInit();
            a4.x = 0;
            com.paytm.network.a l = a4.l();
            l.f42860d = true;
            if (!com.paytm.network.b.b.a(application)) {
                r2.handleErrorCode(-1, (IJRPaytmDataModel) null, new NetworkCustomError());
            } else {
                l.a();
            }
        }
        return yVar;
    }
}
