package net.one97.paytm.vipcashback.c;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.a.m;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.vipcashback.CashbackDeeplinkItem;

public interface b {
    boolean checkDeepLinking(Context context, String str);

    void generateBrandedLink(Context context, String str, HashMap<String, String> hashMap, m<? super String, ? super Integer, ? extends Object> mVar, int i2);

    HashMap<String, String> getAppCommonHeaders();

    Context getApplicationContext();

    String getApplicationId();

    ContextWrapper getBaseContext(Context context);

    boolean getBooleanFromGTM(String str, boolean z);

    String getBuildType();

    CashbackDeeplinkItem getCashbackDeeplinkItem(IJRDataModel iJRDataModel);

    int getIntFromGTM(String str);

    String getLandingActivityClassName();

    String getSSOToken();

    String getStringFromGTM(String str);

    String getUserId(Context context);

    String get_EXTRA_INTENT_IS_FROM_MESSAGE_TO_HOME_key();

    void handleError(Activity activity, Exception exc, String str, Bundle bundle, boolean z);

    void openLandingActivity(Activity activity);

    void sendNewCustomGTMEventsWithMultipleLabel(Context context, String str, String str2, ArrayList<String> arrayList, String str3, String str4, String str5);

    void sendOpenScreenWithDeviceInfo(String str, String str2, Context context);

    void showSessionTimeOutAlert(Activity activity, String str, Bundle bundle, Exception exc, boolean z, boolean z2);
}
