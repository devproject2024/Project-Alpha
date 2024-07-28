package net.one97.paytm.h5paytmsdk.b;

import com.alipay.iap.android.common.b.c;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.alipay.mobile.h5container.api.H5Event;
import kotlin.g.b.k;

public final class p extends ad {
    public p() {
        super("paytmHandleError");
    }

    public final boolean handleEvent(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        super.handleEvent(h5Event, h5BridgeContext);
        if (!a(h5Event)) {
            return true;
        }
        if (h5Event == null) {
            k.a();
        }
        String string = h5Event.getParam().getString("type");
        if (string == null) {
            string = "SR";
        }
        "type ".concat(String.valueOf(string));
        c.e();
        return true;
    }
}
