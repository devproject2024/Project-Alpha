package net.one97.paytm.phoenix.provider;

import android.content.Context;

public interface PhoenixBridgeInterceptorProvider {
    void onBridgeCalled(Context context, String str, String str2, String str3, boolean z, String str4);
}
