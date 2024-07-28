package com.paytmmoney.lite.mod.helper;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

public interface IMoneyListener {
    String getAppVersion();

    String getAuthValue();

    String getBuildType();

    String getClientId();

    Object getGtmValue(Context context, String str);

    String getSSOToken(Context context);

    String getUserId(Context context);

    String getUserPancard(Context context);

    boolean isUserSignedIn(Context context);

    void loadPage(Activity activity, String str, String str2, String str3, String str4, Bundle bundle);

    void openHomePage(Activity activity);

    void openPaytmAuth(Activity activity);
}
