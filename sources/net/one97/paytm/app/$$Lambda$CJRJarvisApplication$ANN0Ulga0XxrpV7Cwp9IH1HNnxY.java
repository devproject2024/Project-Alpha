package net.one97.paytm.app;

import com.paytm.notification.models.callback.ChannelProviderCallback;
import com.paytm.utility.q;

/* renamed from: net.one97.paytm.app.-$$Lambda$CJRJarvisApplication$ANN0Ulga0XxrpV7Cwp9IH1HNnxY  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$CJRJarvisApplication$ANN0Ulga0XxrpV7Cwp9IH1HNnxY implements ChannelProviderCallback {
    public static final /* synthetic */ $$Lambda$CJRJarvisApplication$ANN0Ulga0XxrpV7Cwp9IH1HNnxY INSTANCE = new $$Lambda$CJRJarvisApplication$ANN0Ulga0XxrpV7Cwp9IH1HNnxY();

    private /* synthetic */ $$Lambda$CJRJarvisApplication$ANN0Ulga0XxrpV7Cwp9IH1HNnxY() {
    }

    public final void onChannelCreated(String str) {
        q.a("Channel Id generated:  ".concat(String.valueOf(str)));
    }
}
