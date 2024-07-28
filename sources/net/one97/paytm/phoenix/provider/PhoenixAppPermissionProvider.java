package net.one97.paytm.phoenix.provider;

import android.app.Activity;

public interface PhoenixAppPermissionProvider {
    boolean doesAppHasPermissionToAccessThisBridge(String str, String str2);

    boolean doesAppHasPermissionToOpenThisDomain(String str, Activity activity);
}
