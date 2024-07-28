package net.one97.paytm.bankOpen.ica.d;

import android.content.Context;
import android.text.TextUtils;
import androidx.lifecycle.ai;
import androidx.lifecycle.y;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.g.b.x;
import net.one97.paytm.bankCommon.b.c;
import net.one97.paytm.bankCommon.g.g;
import net.one97.paytm.bankOpen.f;
import net.one97.paytm.bankOpen.ica.model.ICALeadCreateResponse;
import net.one97.paytm.upi.util.UpiConstants;
import org.json.JSONObject;

public final class c extends ai {

    static final class a<T> implements g.b<IJRPaytmDataModel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ x.e f16600a;

        a(x.e eVar) {
            this.f16600a = eVar;
        }

        public final /* synthetic */ void onResponse(Object obj) {
            c.a aVar = net.one97.paytm.bankCommon.b.c.f16215d;
            ((y) this.f16600a.element).postValue(c.a.a((IJRPaytmDataModel) obj));
        }
    }

    /* renamed from: net.one97.paytm.bankOpen.ica.d.c$c  reason: collision with other inner class name */
    static final class C0243c<T> implements g.b<IJRPaytmDataModel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ x.e f16602a;

        C0243c(x.e eVar) {
            this.f16602a = eVar;
        }

        public final /* synthetic */ void onResponse(Object obj) {
            c.a aVar = net.one97.paytm.bankCommon.b.c.f16215d;
            ((y) this.f16602a.element).postValue(c.a.a((IJRPaytmDataModel) obj));
        }
    }

    public static y<net.one97.paytm.bankCommon.b.c<Object>> a() {
        x.e eVar = new x.e();
        eVar.element = new y();
        net.one97.paytm.bankOpen.ica.a aVar = net.one97.paytm.bankOpen.ica.a.f16435a;
        net.one97.paytm.bankOpen.ica.a.a(new C0243c(eVar), new d(eVar));
        return (y) eVar.element;
    }

    static final class d implements g.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ x.e f16603a;

        d(x.e eVar) {
            this.f16603a = eVar;
        }

        public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            c.a aVar = net.one97.paytm.bankCommon.b.c.f16215d;
            k.a((Object) networkCustomError, "p2");
            ((y) this.f16603a.element).postValue(c.a.a((Throwable) networkCustomError));
        }
    }

    public static y<net.one97.paytm.bankCommon.b.c<Object>> a(String str) {
        String str2 = str;
        k.c(str2, "pan");
        x.e eVar = new x.e();
        eVar.element = new y();
        net.one97.paytm.bankOpen.ica.a aVar = net.one97.paytm.bankOpen.ica.a.f16435a;
        g.b aVar2 = new a(eVar);
        g.a bVar = new b(eVar);
        k.c(str2, "pan");
        k.c(aVar2, "responseListener");
        k.c(bVar, "errorListener");
        k.a((Object) net.one97.paytm.bankCommon.utils.d.b(), "PBGTMHelper.getInstance()");
        String a2 = k.a(net.one97.paytm.bankCommon.utils.d.H(), (Object) "?entityType=INDIVIDUAL&solutionType=limited_ca");
        net.one97.paytm.bankOpen.c a3 = f.a();
        k.a((Object) a3, "PaymentBankAccOpenHelper.getImplListener()");
        Context applicationContext = a3.getApplicationContext();
        if (!TextUtils.isEmpty(com.paytm.utility.d.a(applicationContext))) {
            Map hashMap = new HashMap();
            hashMap.put("applanguage", "en");
            hashMap.put("X-SRC", UpiConstants.B2C_ANDROID);
            hashMap.put("channel", UpiConstants.B2C_ANDROID);
            String a4 = com.paytm.utility.d.a(applicationContext);
            k.a((Object) a4, "CJRNetUtility.getSSOToken(context)");
            hashMap.put("session_token", a4);
            net.one97.paytm.bankOpen.c a5 = f.a();
            k.a((Object) a5, "PaymentBankAccOpenHelper.getImplListener()");
            String A = com.paytm.utility.b.A(a5.getApplicationContext());
            k.a((Object) A, "CJRAppCommonUtility.getD…ner().applicationContext)");
            hashMap.put("deviceIdentifier", A);
            hashMap.put("client", "ANDROID");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("mobile", com.paytm.utility.b.l(applicationContext));
            jSONObject.put("pan", str2);
            jSONObject.put("type", "Others");
            ICALeadCreateResponse iCALeadCreateResponse = new ICALeadCreateResponse((String) null, (String) null, 0, 7, (kotlin.g.b.g) null);
            HashMap hashMap2 = new HashMap();
            String simpleName = aVar.getClass().getSimpleName();
            k.a((Object) simpleName, "javaClass.simpleName");
            hashMap2.put("screen_name", simpleName);
            IJRPaytmDataModel iJRPaytmDataModel = iCALeadCreateResponse;
            Context context = applicationContext;
            net.one97.paytm.bankCommon.g.b bVar2 = new net.one97.paytm.bankCommon.g.b(a2, (g.b<IJRPaytmDataModel>) aVar2, bVar, iJRPaytmDataModel, (Map<String, String>) null, (Map<String, String>) hashMap, jSONObject.toString(), a.C0715a.POST, a.c.PAYMENTSBANK, a.b.USER_FACING, (HashMap<String, String>) hashMap2);
            if (com.paytm.utility.b.c(context)) {
                Context context2 = context;
                k.a((Object) context2, "context");
                context2.getApplicationContext();
                net.one97.paytm.bankCommon.g.c.a();
                net.one97.paytm.bankCommon.g.c.a(bVar2);
            } else {
                bVar.onErrorResponse(-1, iJRPaytmDataModel, new NetworkCustomError());
            }
        }
        return (y) eVar.element;
    }

    static final class b implements g.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ x.e f16601a;

        b(x.e eVar) {
            this.f16601a = eVar;
        }

        public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            c.a aVar = net.one97.paytm.bankCommon.b.c.f16215d;
            k.a((Object) networkCustomError, "p2");
            ((y) this.f16601a.element).postValue(c.a.a((Throwable) networkCustomError));
        }
    }
}
