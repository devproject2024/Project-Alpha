package net.one97.paytm.bankOpen;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.paytm.network.model.NetworkCustomError;

public interface c {
    boolean canHandlePostAccOpenCall();

    String getAppChannel();

    String getAppVersion(Context context);

    Context getApplicationContext();

    Context getBaseContext(Context context);

    boolean getBooleanFromGTM(String str, boolean z);

    String getBuildConfigBuildType();

    int getIntFromGTM(String str);

    Class<?> getMainActivityClass();

    String getStringFromGTM(String str);

    Class<?> getTransferToBankActivityClass();

    String getUserId(Context context);

    String getUserToken(Context context);

    void handleError(Activity activity, Exception exc, String str, Bundle bundle, boolean z);

    void handleErrorV2(Context context, NetworkCustomError networkCustomError, int i2);

    boolean isPasscodeSet(Context context);

    void onAccountCreated(Context context, Object obj);

    void openLandingActivity(Activity activity);

    void openMainActivityFromSessionOut(Activity activity, String str, Bundle bundle, boolean z, boolean z2);

    void openYoutubePlayerFragment(Context context, String str);

    boolean showPasscodeScreen(Context context);

    void signOutNetworkCustomError(Activity activity, boolean z, NetworkCustomError networkCustomError);
}
