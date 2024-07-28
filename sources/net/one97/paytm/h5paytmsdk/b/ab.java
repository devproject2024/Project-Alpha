package net.one97.paytm.h5paytmsdk.b;

import com.alibaba.a.e;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.alipay.mobile.h5container.api.H5Event;
import com.alipay.mobile.h5container.api.H5EventFilter;
import com.alipay.mobile.h5container.api.H5SimplePlugin;
import com.alipay.mobile.nebulacore.plugin.H5LongClickPlugin;

public final class ab extends H5SimplePlugin {
    public final void onPrepare(H5EventFilter h5EventFilter) {
        h5EventFilter.addAction(H5LongClickPlugin.SAVE_IMAGE);
    }

    public final boolean interceptEvent(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        e param = h5Event.getParam();
        if (!param.containsKey("savePath")) {
            param.put("savePath", (Object) "/DCIM/Paytm/");
        }
        return super.interceptEvent(h5Event, h5BridgeContext);
    }
}
