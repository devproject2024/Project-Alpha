package com.paytmmall.a.a;

import com.business.merchant_payments.common.utility.AppConstants;
import com.paytmmall.artifact.d.s;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.phoenix.api.H5Event;
import net.one97.paytm.phoenix.api.b;
import net.one97.paytm.phoenix.core.a;
import org.json.JSONObject;

public final class e extends a {
    public e() {
        super("mpFireGAEvents");
    }

    public final boolean a(H5Event h5Event, b bVar) {
        JSONObject params;
        Map<String, Object> a2;
        if (!(h5Event == null || (params = h5Event.getParams()) == null || (a2 = com.paytmmall.artifact.b.a(params, "data")) == null)) {
            String valueOf = String.valueOf(params.opt("action"));
            char c2 = 65535;
            int hashCode = valueOf.hashCode();
            if (hashCode != -385519706) {
                if (hashCode == 368948223 && valueOf.equals("SEND_EVENT_WITH_MAP")) {
                    c2 = 1;
                }
            } else if (valueOf.equals("SEND_MAP_ONLY")) {
                c2 = 0;
            }
            if (c2 == 0) {
                try {
                    com.paytmmall.artifact.common.b.a.a.a((HashMap) a2);
                } catch (Exception e2) {
                    s.a(e2);
                }
            } else if (c2 == 1) {
                try {
                    com.paytmmall.artifact.common.b.a.a.a(String.valueOf(a2.get(AppConstants.NOTIFICATION_DETAILS.EVENT)), (Map) a2);
                } catch (Exception e3) {
                    s.a(e3);
                }
            }
        }
        return super.a(h5Event, bVar);
    }
}
