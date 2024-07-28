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
import net.one97.paytm.bankCommon.utils.d;
import net.one97.paytm.bankOpen.f;
import net.one97.paytm.bankOpen.ica.model.ICAStatusResponse;
import net.one97.paytm.bankOpen.ica.model.ICATrackLeadResponse;
import net.one97.paytm.upi.util.UpiConstants;

public final class e extends ai {

    static final class a<T> implements g.b<IJRPaytmDataModel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ x.e f16606a;

        a(x.e eVar) {
            this.f16606a = eVar;
        }

        public final /* synthetic */ void onResponse(Object obj) {
            c.a aVar = c.f16215d;
            ((y) this.f16606a.element).postValue(c.a.a((IJRPaytmDataModel) obj));
        }
    }

    public static y<c<Object>> a() {
        x.e eVar = new x.e();
        eVar.element = new y();
        net.one97.paytm.bankOpen.ica.a aVar = net.one97.paytm.bankOpen.ica.a.f16435a;
        g.b aVar2 = new a(eVar);
        g.a bVar = new b(eVar);
        k.c(aVar2, "responseListener");
        k.c(bVar, "errorListener");
        k.a((Object) d.b(), "PBGTMHelper.getInstance()");
        String a2 = k.a(d.G(), (Object) "?entityType=INDIVIDUAL&solutionType=limited_ca");
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
            ICAStatusResponse iCAStatusResponse = new ICAStatusResponse(false, false, 0, false, (String) null, (String) null, (String) null, (String) null, (String) null, 511, (kotlin.g.b.g) null);
            HashMap hashMap2 = new HashMap();
            String simpleName = aVar.getClass().getSimpleName();
            k.a((Object) simpleName, "javaClass.simpleName");
            hashMap2.put("screen_name", simpleName);
            net.one97.paytm.bankCommon.g.a aVar3 = new net.one97.paytm.bankCommon.g.a(a2, aVar2, bVar, new ICATrackLeadResponse(false, false, 0, (String) null, (String) null, (String) null, false, (String) null, false, false, false, 2047, (kotlin.g.b.g) null), hashMap, a.c.PAYMENTSBANK, a.b.USER_FACING, hashMap2);
            if (com.paytm.utility.b.c(applicationContext)) {
                k.a((Object) applicationContext, "context");
                applicationContext.getApplicationContext();
                net.one97.paytm.bankCommon.g.c.a();
                net.one97.paytm.bankCommon.g.c.a(aVar3);
            } else {
                bVar.onErrorResponse(-1, iCAStatusResponse, new NetworkCustomError());
            }
        }
        return (y) eVar.element;
    }

    static final class b implements g.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ x.e f16607a;

        b(x.e eVar) {
            this.f16607a = eVar;
        }

        public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            c.a aVar = c.f16215d;
            k.a((Object) networkCustomError, "p2");
            ((y) this.f16607a.element).postValue(c.a.a((Throwable) networkCustomError));
        }
    }
}
