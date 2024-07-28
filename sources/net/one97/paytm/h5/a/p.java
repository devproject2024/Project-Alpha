package net.one97.paytm.h5.a;

import android.app.Activity;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.alipay.mobile.h5container.api.H5Event;
import kotlin.g.b.k;
import net.one97.paytm.h5.a.e;
import net.one97.paytm.h5paytmsdk.b.ad;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;

public final class p extends ad {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public p() {
        super(e.s);
        e.a aVar = e.f16836a;
    }

    public final boolean handleEvent(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        Activity activity;
        super.handleEvent(h5Event, h5BridgeContext);
        if (!(!a(h5Event) || h5Event == null || (activity = h5Event.getActivity()) == null)) {
            String action = h5Event.getAction();
            e.a aVar = e.f16836a;
            if (k.a((Object) action, (Object) e.s)) {
                com.alibaba.a.e param = h5Event.getParam();
                Object obj = param != null ? param.get("isEnable") : null;
                if (obj == null) {
                    e.a aVar2 = e.f16836a;
                    e.a.a(1, "Key not found", h5BridgeContext);
                } else {
                    if (k.a(obj, (Object) Boolean.FALSE)) {
                        activity.getWindow().setFlags(FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE, FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE);
                    } else {
                        activity.getWindow().clearFlags(FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE);
                    }
                    a((Object) "success");
                }
            }
        }
        return true;
    }
}
