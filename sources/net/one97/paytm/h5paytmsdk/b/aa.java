package net.one97.paytm.h5paytmsdk.b;

import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.a.e;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.alipay.mobile.h5container.api.H5Event;
import com.alipay.mobile.h5container.api.H5Param;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.h5paytmsdk.PaytmH5Manager;
import net.one97.paytm.h5paytmsdk.b.v;

public final class aa extends ad {
    public aa() {
        super("paytmPushWindow");
    }

    public final boolean handleEvent(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        super.handleEvent(h5Event, h5BridgeContext);
        if (!b(h5Event)) {
            return true;
        }
        if (h5Event == null) {
            k.a();
        }
        e param = h5Event.getParam();
        String string = param.getString("appId");
        String string2 = param.getString("url");
        e jSONObject = param.getJSONObject(H5Param.PARAM);
        if (jSONObject == null) {
            jSONObject = new e();
        }
        Boolean bool = param.getBoolean("isTransparent");
        boolean booleanValue = bool != null ? bool.booleanValue() : false;
        if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2)) {
            a(H5Event.Error.INVALID_PARAM, "appId or url cannot be empty!");
            return true;
        }
        Bundle bundle = new Bundle();
        v.a aVar = v.f17055a;
        v.a.a(bundle, jSONObject);
        bundle.putBoolean("isFromDeeplink", PaytmH5Manager.INSTANCE.isFromDeepLinkStatus$h5paytmsdk_debug());
        k.a((Object) string, "appId");
        k.a((Object) string2, "url");
        PaytmH5Manager.loadPage$default(string, string2, bundle, (String) null, booleanValue, (List) null, (List) null, 104, (Object) null);
        a("success", (Object) Boolean.TRUE);
        a((Object) null);
        return true;
    }
}
