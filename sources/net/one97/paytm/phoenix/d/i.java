package net.one97.paytm.phoenix.d;

import android.app.Activity;
import com.business.merchant_payments.common.utility.AppConstants;
import kotlin.g.b.k;
import net.one97.paytm.j.c;
import net.one97.paytm.phoenix.api.H5Event;
import net.one97.paytm.phoenix.api.b;
import net.one97.paytm.phoenix.core.a;
import net.one97.paytm.phoenix.util.d;
import org.json.JSONArray;
import org.json.JSONObject;

public final class i extends a {

    /* renamed from: a  reason: collision with root package name */
    private b f19806a;

    public i() {
        super("paytmFetchConfig");
    }

    public final boolean a(H5Event h5Event, b bVar) {
        String bridgeName;
        Object obj;
        k.c(h5Event, AppConstants.NOTIFICATION_DETAILS.EVENT);
        k.c(bVar, "bridgeContext");
        super.a(h5Event, bVar);
        b(h5Event, bVar);
        this.f19806a = bVar;
        Activity activity = h5Event.getActivity();
        if (activity != null && (bridgeName = h5Event.getBridgeName()) != null && bridgeName.hashCode() == 1083221691 && bridgeName.equals("paytmFetchConfig")) {
            JSONArray jSONArray = null;
            JSONObject params = h5Event.getParams();
            if (!(params == null || (obj = params.get("keys")) == null || !(obj instanceof JSONArray))) {
                jSONArray = (JSONArray) obj;
            }
            d.a aVar = d.f19890a;
            if (!d.a.a(h5Event, this.f19806a, activity, "whitelisted_aids_configkeys", 16)) {
                boolean z = jSONArray == null;
                if (jSONArray != null) {
                    int length = jSONArray.length();
                    boolean z2 = z;
                    for (int i2 = 0; i2 < length; i2++) {
                        Object obj2 = jSONArray.get(i2);
                        if (obj2 instanceof String) {
                            if (!(((CharSequence) obj2).length() == 0)) {
                            }
                        }
                        z2 = true;
                    }
                    z = z2;
                }
                if (z) {
                    d.a aVar2 = d.f19890a;
                    d.a.a(h5Event, Integer.valueOf(net.one97.paytm.phoenix.api.a.NOT_FOUND.ordinal()), "Key not found", this.f19806a);
                }
                if (!z) {
                    if (jSONArray == null) {
                        k.a();
                    }
                    JSONObject jSONObject = new JSONObject();
                    int length2 = jSONArray.length();
                    for (int i3 = 0; i3 < length2; i3++) {
                        String string = jSONArray.getString(i3);
                        c.a();
                        jSONObject.put(string, c.a(string));
                    }
                    a.a(this, h5Event, jSONObject, false, 4);
                }
            }
        }
        return true;
    }
}
