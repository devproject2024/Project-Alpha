package net.one97.paytm.phoenix.provider;

import android.content.Context;

public interface PhoenixDeepLinkHandlerProvider {
    boolean handleDeeplink(Context context, String str);
}
