package com.paytmmall.a.a;

import com.paytmmall.artifact.d.t;
import net.one97.paytm.phoenix.api.H5Event;
import net.one97.paytm.phoenix.api.b;
import net.one97.paytm.phoenix.core.a;
import org.json.JSONObject;

public final class g extends a {
    public g() {
        super("mpFireKibanaEvents");
    }

    public final boolean a(H5Event h5Event, b bVar) {
        JSONObject params;
        if (!(h5Event == null || (params = h5Event.getParams()) == null)) {
            JSONObject optJSONObject = (params == null || !params.has("extraData") || params.optJSONObject("extraData") == null) ? null : params.optJSONObject("extraData");
            boolean parseBoolean = Boolean.parseBoolean((params == null || !params.has("isAPISuccess")) ? "" : String.valueOf(params.opt("isAPISuccess")));
            if (optJSONObject != null) {
                t.e().sendErrorAnalyticsLogs(optJSONObject.toString(), parseBoolean);
            }
        }
        return super.a(h5Event, bVar);
    }
}
