package net.one97.paytm.ups.sdk;

import net.one97.paytm.ups.provider.UpsJarvisInterface;

public interface UpsSdkInterface {
    UpsJarvisInterface getProvider();

    String getSSOToken();

    boolean isLoggedIn();

    void onLogout();
}
