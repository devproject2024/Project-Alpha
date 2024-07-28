package com.paytm.finance.gold.a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import net.one97.paytm.deeplink.DeepLinkData;

public interface b {
    String getBuildType(Context context);

    void loadPage(Activity activity, String str, DeepLinkData deepLinkData, Bundle bundle);
}
