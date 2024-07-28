package net.one97.paytm.phoenix.provider;

import android.content.Context;

public interface PhoenixDeveloperModeWhitelisDataProvider {
    boolean isAppIdWhitelistedForDeveloperMode(String str);

    void isUserWhitelistedForDeveloperMode(Context context, String str, UserWhitelistedForDeveloperModeCallback userWhitelistedForDeveloperModeCallback);
}
