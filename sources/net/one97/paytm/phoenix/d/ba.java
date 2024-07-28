package net.one97.paytm.phoenix.d;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.business.merchant_payments.common.utility.AppConstants;
import kotlin.g.b.k;
import net.one97.paytm.phoenix.api.H5Event;
import net.one97.paytm.phoenix.api.b;
import net.one97.paytm.phoenix.core.a;
import net.one97.paytm.phoenix.util.g;
import org.json.JSONObject;

public final class ba extends a {
    public ba() {
        super("testsubscribe");
    }

    public final boolean a(H5Event h5Event, b bVar) {
        k.c(h5Event, AppConstants.NOTIFICATION_DETAILS.EVENT);
        k.c(bVar, "bridgeContext");
        super.a(h5Event, bVar);
        Activity activity = h5Event.getActivity();
        if (activity == null) {
            return true;
        }
        String bridgeName = h5Event.getBridgeName();
        if (bridgeName != null && bridgeName.hashCode() == -819421960 && bridgeName.equals("testsubscribe")) {
            JSONObject params = h5Event.getParams();
            if (params == null || !params.has("action")) {
                return true;
            }
            String string = params.getString("action");
            Intent intent = new Intent();
            intent.setAction(string);
            Bundle bundle = new Bundle();
            g gVar = g.f59641a;
            JSONObject params2 = h5Event.getParams();
            if (params2 == null) {
                k.a();
            }
            g.a(params2, bundle);
            intent.putExtras(bundle);
            androidx.localbroadcastmanager.a.a.a((Context) activity).a(intent);
            return true;
        }
        a(h5Event, net.one97.paytm.phoenix.api.a.INVALID_PARAM, "Not valid");
        return true;
    }
}
