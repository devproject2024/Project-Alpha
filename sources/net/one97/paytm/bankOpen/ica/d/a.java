package net.one97.paytm.bankOpen.ica.d;

import android.content.Context;
import android.webkit.URLUtil;
import androidx.lifecycle.ai;
import androidx.lifecycle.y;
import com.alipay.iap.android.webapp.sdk.plugin.H5RpcPlugin;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.g.b.x;
import net.one97.paytm.bankCommon.b.c;
import net.one97.paytm.bankCommon.g.g;
import net.one97.paytm.bankCommon.mapping.d;
import net.one97.paytm.bankCommon.model.CJRBankDetails;
import net.one97.paytm.bankOpen.f;
import net.one97.paytm.common.entity.upgradeKyc.NearbyRequestCreator;
import net.one97.paytm.upi.util.UpiConstantServiceApi;
import net.one97.paytm.upi.util.UpiConstants;
import org.json.JSONObject;

public final class a extends ai {

    /* renamed from: net.one97.paytm.bankOpen.ica.d.a$a  reason: collision with other inner class name */
    static final class C0241a<T> implements g.b<IJRPaytmDataModel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ x.e f16588a;

        C0241a(x.e eVar) {
            this.f16588a = eVar;
        }

        public final /* synthetic */ void onResponse(Object obj) {
            c.a aVar = c.f16215d;
            ((y) this.f16588a.element).postValue(c.a.a((IJRPaytmDataModel) obj));
        }
    }

    public static y<c<Object>> a(String str) {
        String str2 = str;
        k.c(str2, "ifsc");
        x.e eVar = new x.e();
        eVar.element = new y();
        net.one97.paytm.bankOpen.ica.a aVar = net.one97.paytm.bankOpen.ica.a.f16435a;
        g.b aVar2 = new C0241a(eVar);
        g.a bVar = new b(eVar);
        k.c(str2, "ifscCode");
        k.c(aVar2, "responseListener");
        k.c(bVar, "errorListener");
        net.one97.paytm.bankOpen.c a2 = f.a();
        k.a((Object) a2, "PaymentBankAccOpenHelper.getImplListener()");
        Context applicationContext = a2.getApplicationContext();
        HashMap hashMap = new HashMap();
        String simpleName = aVar.getClass().getSimpleName();
        k.a((Object) simpleName, "javaClass.simpleName");
        hashMap.put("screen_name", simpleName);
        String stringFromGTM = f.a().getStringFromGTM(UpiConstantServiceApi.KEY_GET_BANK);
        if (URLUtil.isValidUrl(stringFromGTM)) {
            String e2 = com.paytm.utility.b.e(applicationContext, stringFromGTM);
            Map hashMap2 = new HashMap();
            String a3 = d.a(applicationContext);
            k.a((Object) a3, "CJRServerUtility.getSSOToken(context)");
            hashMap2.put("ssotoken", a3);
            hashMap2.put("Content-Type", "application/json");
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("ifscCode", str2);
                jSONObject.put("request", jSONObject2);
                jSONObject.put(NearbyRequestCreator.NearbyRequestConstants.ipAddress, "127.0.0.1");
                jSONObject.put(NearbyRequestCreator.NearbyRequestConstants.platformName, "PayTM");
                jSONObject.put(H5RpcPlugin.RpcRequest.RpcParam.OPERATION_TYPE, "P2B_TRANSFER");
                jSONObject.put("channel", UpiConstants.MP_ANDROID);
                String Q = com.paytm.utility.b.Q(applicationContext);
                if (Q != null) {
                    jSONObject.put("version", Q);
                }
            } catch (Exception e3) {
                if (com.paytm.utility.b.v) {
                    e3.printStackTrace();
                }
            }
            Context context = applicationContext;
            net.one97.paytm.bankCommon.g.b bVar2 = new net.one97.paytm.bankCommon.g.b(e2, (g.b<IJRPaytmDataModel>) aVar2, bVar, (IJRPaytmDataModel) new CJRBankDetails(), (Map<String, String>) null, (Map<String, String>) hashMap2, jSONObject.toString(), a.C0715a.POST, a.c.PAYMENTSBANK, a.b.USER_FACING, (HashMap<String, String>) hashMap);
            if (com.paytm.utility.b.c(context)) {
                k.a((Object) context, "context");
                context.getApplicationContext();
                net.one97.paytm.bankCommon.g.c.a();
                net.one97.paytm.bankCommon.g.c.a(bVar2);
            }
        }
        return (y) eVar.element;
    }

    static final class b implements g.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ x.e f16589a;

        b(x.e eVar) {
            this.f16589a = eVar;
        }

        public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            c.a aVar = c.f16215d;
            k.a((Object) networkCustomError, "p2");
            ((y) this.f16589a.element).postValue(c.a.a((Throwable) networkCustomError));
        }
    }
}
