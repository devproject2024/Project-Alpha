package net.one97.paytm.h5paytmsdk.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.alibaba.a.e;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.alipay.mobile.h5container.api.H5Event;
import com.alipay.mobile.h5container.api.H5Param;
import kotlin.g.b.k;
import net.one97.paytm.h5paytmsdk.ui.PaytmH5VideoPlayerActivity;
import net.one97.paytm.h5paytmsdk.ui.PaytmH5VideoPlayerPortraitActivity;

public final class ag extends ad {
    public ag() {
        super("paytmPlayVideoFullscreen");
    }

    public final boolean handleEvent(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        super.handleEvent(h5Event, h5BridgeContext);
        if (!b(h5Event) || h5Event == null) {
            return true;
        }
        e param = h5Event.getParam();
        String string = param.getString("videoUrl");
        String string2 = param.getString("title");
        String string3 = param.getString("orientation");
        if (string3 == null) {
            string3 = H5Param.LONG_LANDSCAPE;
        }
        if (TextUtils.isEmpty(string)) {
            a(H5Event.Error.INVALID_PARAM, "Message empty!");
            return true;
        }
        if (k.a((Object) "portrait", (Object) string3)) {
            PaytmH5VideoPlayerPortraitActivity.a aVar = PaytmH5VideoPlayerPortraitActivity.f17124b;
            Activity activity = h5Event.getActivity();
            k.a((Object) activity, "it.activity");
            Context context = activity;
            k.a((Object) string, "videoUrl");
            k.a((Object) string2, "title");
            k.c(context, "context");
            k.c(string, "videoUrl");
            k.c(string2, "title");
            Intent intent = new Intent(context, PaytmH5VideoPlayerPortraitActivity.class);
            intent.putExtra("videoUrl", string);
            intent.putExtra("title", string2);
            context.startActivity(intent);
        } else {
            PaytmH5VideoPlayerActivity.a aVar2 = PaytmH5VideoPlayerActivity.f17113a;
            Activity activity2 = h5Event.getActivity();
            k.a((Object) activity2, "it.activity");
            Context context2 = activity2;
            k.a((Object) string, "videoUrl");
            k.a((Object) string2, "title");
            k.c(context2, "context");
            k.c(string, "videoUrl");
            k.c(string2, "title");
            Intent intent2 = new Intent(context2, PaytmH5VideoPlayerActivity.class);
            intent2.putExtra("videoUrl", string);
            intent2.putExtra("title", string2);
            context2.startActivity(intent2);
        }
        a("success", (Object) Boolean.TRUE);
        a((Object) null);
        return true;
    }
}
