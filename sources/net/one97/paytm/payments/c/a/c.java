package net.one97.paytm.payments.c.a;

import com.business.merchant_payments.common.utility.AppConstants;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.paymentsBank.utils.o;
import net.one97.paytm.phoenix.api.H5Event;
import net.one97.paytm.phoenix.api.b;
import net.one97.paytm.phoenix.core.a;
import org.json.JSONArray;
import org.json.JSONObject;

public final class c extends a {
    public c() {
        super("getGtmValues");
    }

    public final boolean a(H5Event h5Event, b bVar) {
        int length;
        k.c(h5Event, AppConstants.NOTIFICATION_DETAILS.EVENT);
        k.c(bVar, "bridgeContext");
        super.a(h5Event, bVar);
        b(h5Event, bVar);
        JSONObject params = h5Event.getParams();
        JSONArray jSONArray = params != null ? params.getJSONArray("keys") : null;
        JSONObject jSONObject = new JSONObject();
        if (jSONArray != null && (length = jSONArray.length() - 1) >= 0) {
            int i2 = 0;
            while (true) {
                Object obj = jSONArray.get(i2);
                if (obj != null) {
                    String str = (String) obj;
                    jSONObject.put(str, o.a().getStringFromGTM(str));
                    if (i2 == length) {
                        break;
                    }
                    i2++;
                } else {
                    throw new u("null cannot be cast to non-null type kotlin.String");
                }
            }
        }
        a.a(this, h5Event, jSONObject, false, 4);
        return true;
    }
}
