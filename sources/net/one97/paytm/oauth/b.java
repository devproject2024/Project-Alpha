package net.one97.paytm.oauth;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.j;
import com.android.volley.VolleyError;
import com.paytm.network.model.NetworkCustomError;
import java.util.ArrayList;
import java.util.Map;
import net.one97.paytm.oauth.models.a;
import net.one97.paytm.oauth.utils.OAuthUtils;

public interface b {
    void checkDeepLinking(Context context, String str);

    void checkSignUpReminder(j jVar);

    void checkSimCardChanged(j jVar, Activity activity);

    Context getApplicationContext();

    boolean getBooleanFromGTM(String str, boolean z);

    int getIntFromGTM(String str, int i2);

    Context getLocalisedContext(Context context);

    String getSSOToken();

    String getStringFromGTM(String str);

    String getUserId();

    String getWalletScopeToken();

    void handleSessionTimeOut(AppCompatActivity appCompatActivity, NetworkCustomError networkCustomError, String str, Bundle bundle, boolean z, boolean z2);

    boolean isPreviewCompleted();

    void launchAJRAuthActivity(Context context, Bundle bundle);

    void logHawEyeEvent(a aVar);

    void markPreviewCompleted();

    void onLogout(Activity activity, boolean z, VolleyError volleyError);

    void openAuthorizedMerchantActivity(Context context);

    void openChooseLaguageScreen(Activity activity, int i2);

    void openHomePage(Context context, boolean z, String str, boolean z2);

    void openProfileActivity(Context context);

    c provideOathModuleConfig();

    void resetSimChangedPromptAttributes(Activity activity);

    void saveEncryptedSSOToken(String str);

    void saveSSOToken(String str);

    void saveWalletScopeToken(String str, String str2, long j);

    void sendCustomEventWithMap(String str, Map<String, Object> map, Context context);

    void sendGAMultipleLabelEvent(Context context, String str, String str2, ArrayList<String> arrayList, String str3, String str4, String str5);

    void sendOpenScreenWithDeviceInfo(String str, String str2, Context context);

    void signOutAndLogin(Activity activity, boolean z, OAuthUtils.b bVar);
}
