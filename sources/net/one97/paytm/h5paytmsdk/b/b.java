package net.one97.paytm.h5paytmsdk.b;

import android.app.Activity;
import android.text.TextUtils;
import android.widget.Toast;
import com.alibaba.a.e;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.alipay.mobile.h5container.api.H5Event;
import kotlin.g.b.k;

public final class b extends ad {
    public b() {
        super("paytmToast");
    }

    public final boolean handleEvent(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        super.handleEvent(h5Event, h5BridgeContext);
        if (b(h5Event)) {
            if (h5Event == null) {
                k.a();
            }
            e param = h5Event.getParam();
            String string = param.getString("message");
            Boolean bool = param.getBoolean("isShort");
            CharSequence charSequence = string;
            if (TextUtils.isEmpty(charSequence)) {
                a(H5Event.Error.INVALID_PARAM, "Message empty!");
            } else {
                Activity activity = h5Event.getActivity();
                if (activity == null) {
                    k.a();
                }
                k.a((Object) bool, "isShort");
                Toast.makeText(activity, charSequence, bool.booleanValue() ^ true ? 1 : 0).show();
                a("success", (Object) Boolean.TRUE);
                a((Object) null);
            }
        }
        return true;
    }
}
