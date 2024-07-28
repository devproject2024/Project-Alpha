package net.one97.paytm.oauth.g;

import android.content.Context;
import android.webkit.URLUtil;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ai;
import androidx.lifecycle.y;
import com.alipay.mobile.h5container.api.H5Param;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.b;
import com.paytm.utility.q;
import java.util.HashMap;
import net.one97.paytm.oauth.OauthModule;
import net.one97.paytm.oauth.e.a;
import net.one97.paytm.oauth.fragment.aq;
import net.one97.paytm.oauth.models.DeviceBindingConfigResModel;
import net.one97.paytm.oauth.models.ErrorModel;
import net.one97.paytm.oauth.models.SimplifiedLoginInit;
import net.one97.paytm.oauth.utils.l;
import net.one97.paytm.oauth.utils.n;
import net.one97.paytm.oauth.utils.o;
import net.one97.paytm.oauth.utils.s;
import org.json.JSONException;
import org.json.JSONObject;

public class e extends ai {
    public final LiveData<net.one97.paytm.oauth.e<IJRPaytmDataModel>> a(Context context, String str, String str2) {
        final y yVar = new y();
        AnonymousClass1 r1 = new a("oauthLoginInitSv1") {
            public final void a(String str, IJRPaytmDataModel iJRPaytmDataModel) {
                yVar.setValue(net.one97.paytm.oauth.e.a(iJRPaytmDataModel, str));
            }

            public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                yVar.setValue(net.one97.paytm.oauth.e.a(new ErrorModel(i2, iJRPaytmDataModel, networkCustomError), networkCustomError, str));
            }
        };
        net.one97.paytm.oauth.a.a();
        String a2 = net.one97.paytm.oauth.a.a("oauthLoginInitSv1");
        o oVar = o.f56791a;
        if (!o.a()) {
            net.one97.paytm.oauth.a.a();
            a2 = net.one97.paytm.oauth.a.a("simple_auth_init");
        }
        if (URLUtil.isValidUrl(a2)) {
            String e2 = b.e(context, a2);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("loginId", str);
                o oVar2 = o.f56791a;
                if (!o.a()) {
                    jSONObject.put("flow", str2);
                }
            } catch (JSONException e3) {
                q.b(e3.getMessage());
            }
            s sVar = s.f56801a;
            HashMap<String, String> a3 = s.a();
            a3.put("autoReadHash", OauthModule.a().c());
            try {
                o oVar3 = o.f56791a;
                o.a(a3);
                o oVar4 = o.f56791a;
                o.a(e2, l.a(a.C0715a.POST), a3, jSONObject.toString());
                com.paytm.network.b a4 = net.one97.paytm.oauth.b.b.a(aq.class.getName());
                a4.n = a.b.SILENT;
                a4.f42879c = a.C0715a.POST;
                a4.f42880d = e2;
                a4.f42882f = a3;
                a4.f42884h = jSONObject.toString();
                a4.j = r1;
                a4.f42885i = new SimplifiedLoginInit();
                a4.x = 0;
                com.paytm.network.a l = a4.l();
                l.f42860d = true;
                if (!com.paytm.network.b.b.a(context)) {
                    r1.handleErrorCode(-1, (IJRPaytmDataModel) null, new NetworkCustomError());
                } else {
                    l.a();
                }
            } catch (NullPointerException e4) {
                q.b(e4.getMessage());
                NetworkCustomError networkCustomError = new NetworkCustomError();
                networkCustomError.setStatusCode(n.f56790i.intValue());
                r1.handleErrorCode(n.f56790i.intValue(), (IJRPaytmDataModel) null, networkCustomError);
            }
        }
        return yVar;
    }

    public final LiveData<net.one97.paytm.oauth.e<IJRPaytmDataModel>> a(String str, String str2, String str3) {
        final y yVar = new y();
        AnonymousClass2 r1 = new net.one97.paytm.oauth.e.a("oauthdevicebindingconfigSv1") {
            public final void a(String str, IJRPaytmDataModel iJRPaytmDataModel) {
                yVar.setValue(net.one97.paytm.oauth.e.a(iJRPaytmDataModel, str));
            }

            public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                yVar.setValue(net.one97.paytm.oauth.e.a(new ErrorModel(i2, iJRPaytmDataModel, networkCustomError), networkCustomError, str));
            }
        };
        Context applicationContext = OauthModule.b().getApplicationContext();
        net.one97.paytm.oauth.a.a();
        String a2 = net.one97.paytm.oauth.a.a("oauthdevicebindingconfigSv1");
        if (URLUtil.isValidUrl(a2)) {
            String str4 = b.e(applicationContext, a2) + "&flow=" + str3;
            s sVar = s.f56801a;
            HashMap<String, String> a3 = s.a();
            a3.put("x-phone-number", str);
            a3.put("x-iccid", str2);
            com.paytm.network.b a4 = net.one97.paytm.oauth.b.b.a(aq.class.getName());
            a4.n = a.b.SILENT;
            a4.f42879c = a.C0715a.GET;
            a4.f42880d = str4;
            a4.f42882f = a3;
            a4.j = r1;
            a4.f42885i = new DeviceBindingConfigResModel();
            a4.x = 0;
            com.paytm.network.a l = a4.l();
            l.f42860d = true;
            if (!com.paytm.network.b.b.a(applicationContext)) {
                r1.handleErrorCode(-1, (IJRPaytmDataModel) null, new NetworkCustomError());
            } else {
                l.a();
            }
        }
        return yVar;
    }

    public final LiveData<net.one97.paytm.oauth.e<IJRPaytmDataModel>> a(String str, String str2, String str3, String str4) {
        if (str2 == null) {
            str2 = "login";
        }
        final y yVar = new y();
        net.one97.paytm.oauth.b.b.c(new net.one97.paytm.oauth.e.a("oauthdevicebindinginitSv1") {
            public final void a(String str, IJRPaytmDataModel iJRPaytmDataModel) {
                yVar.setValue(net.one97.paytm.oauth.e.a(iJRPaytmDataModel, str));
            }

            public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                yVar.setValue(net.one97.paytm.oauth.e.a(new ErrorModel(i2, iJRPaytmDataModel, networkCustomError), networkCustomError, str));
            }
        }, str, str2, str3, str4);
        return yVar;
    }

    public final LiveData<net.one97.paytm.oauth.e<IJRPaytmDataModel>> a(String str) {
        final y yVar = new y();
        net.one97.paytm.oauth.b.b.d((com.paytm.network.listener.b) new net.one97.paytm.oauth.e.a("oauthdevicebindingstatusSv1") {
            public final void a(String str, IJRPaytmDataModel iJRPaytmDataModel) {
                yVar.setValue(net.one97.paytm.oauth.e.a(iJRPaytmDataModel, str));
            }

            public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                yVar.setValue(net.one97.paytm.oauth.e.a(new ErrorModel(i2, iJRPaytmDataModel, networkCustomError), networkCustomError, str));
            }
        }, str);
        return yVar;
    }

    public final LiveData<net.one97.paytm.oauth.e<IJRPaytmDataModel>> b(String str) {
        final y yVar = new y();
        AnonymousClass5 r1 = new net.one97.paytm.oauth.e.a("oauthdevicebindinginterveneSv1") {
            public final void a(String str, IJRPaytmDataModel iJRPaytmDataModel) {
                yVar.setValue(net.one97.paytm.oauth.e.a(iJRPaytmDataModel, str));
            }

            public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                yVar.setValue(net.one97.paytm.oauth.e.a(new ErrorModel(i2, iJRPaytmDataModel, networkCustomError), networkCustomError, str));
            }
        };
        Context applicationContext = OauthModule.b().getApplicationContext();
        net.one97.paytm.oauth.a.a();
        String a2 = net.one97.paytm.oauth.a.a("oauthdevicebindinginterveneSv1");
        if (URLUtil.isValidUrl(a2)) {
            String e2 = b.e(applicationContext, a2);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(H5Param.SESSION_ID, str);
            } catch (JSONException e3) {
                q.b(e3.getMessage());
            }
            s sVar = s.f56801a;
            HashMap<String, String> a3 = s.a();
            o oVar = o.f56791a;
            o.a(e2, l.a(a.C0715a.POST), a3, jSONObject.toString());
            com.paytm.network.b a4 = net.one97.paytm.oauth.b.b.a(aq.class.getName());
            a4.n = a.b.SILENT;
            a4.f42879c = a.C0715a.POST;
            a4.f42880d = e2;
            a4.f42882f = a3;
            a4.f42884h = jSONObject.toString();
            a4.j = r1;
            a4.f42885i = new SimplifiedLoginInit();
            a4.x = 0;
            com.paytm.network.a l = a4.l();
            l.f42860d = true;
            if (!com.paytm.network.b.b.a(applicationContext)) {
                r1.handleErrorCode(-1, (IJRPaytmDataModel) null, new NetworkCustomError());
            } else {
                l.a();
            }
        }
        return yVar;
    }
}
