package net.one97.paytm.paymentsBank.form15g;

import android.content.Context;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.b;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.bankCommon.g.c;
import net.one97.paytm.bankCommon.g.g;
import net.one97.paytm.bankCommon.utils.d;
import net.one97.paytm.paymentsBank.form15g.model.Form15ghModel;
import net.one97.paytm.upi.util.UpiConstants;

public class a {

    /* renamed from: b  reason: collision with root package name */
    private static a f18393b;

    /* renamed from: a  reason: collision with root package name */
    public Context f18394a;

    private a(Context context) {
        this.f18394a = context;
    }

    public static a a(Context context) {
        if (f18393b == null) {
            synchronized (a.class) {
                f18393b = new a(context);
            }
        }
        return f18393b;
    }

    public final void a(g.b bVar, g.a aVar) {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        hashMap2.put("screen_name", getClass().getSimpleName());
        hashMap.put("user-token", com.paytm.utility.a.q(this.f18394a));
        hashMap.put("Content-Type", "application/json");
        hashMap.put(UpiConstants.CACHE_CONTROL, "no-cache");
        d.a();
        net.one97.paytm.bankCommon.g.a aVar2 = new net.one97.paytm.bankCommon.g.a(d.a("fg_decision_api"), bVar, aVar, (IJRPaytmDataModel) new Form15ghModel(), (Map<String, String>) null, (Map<String, String>) hashMap, a.c.PAYMENTSBANK, a.b.USER_FACING, (HashMap<String, String>) hashMap2);
        if (b.c(this.f18394a)) {
            new c();
            c.a(aVar2);
            return;
        }
        aVar.onErrorResponse(-1, new Form15ghModel(), new NetworkCustomError());
    }
}
