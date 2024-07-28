package net.one97.paytm.bankOpen;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.Map;
import net.one97.paytm.bankCommon.a;
import net.one97.paytm.bankCommon.b;

public class BankCommonProvider implements b {
    private static BankCommonProvider mInstance;

    public Class getEmbeddedWebViewActivityClass() {
        return null;
    }

    private BankCommonProvider() {
    }

    public static void init() {
        if (mInstance == null) {
            mInstance = new BankCommonProvider();
        }
        BankCommonProvider bankCommonProvider = mInstance;
        if (a.f16182a == null) {
            a aVar = new a();
            a.f16182a = aVar;
            aVar.f16183b = bankCommonProvider;
        }
    }

    public void sendCustomGTMEvents(Context context, String str, String str2, String str3, String str4, String str5, String str6) {
        f.b().sendCustomGTMEvents(context, str, str2, str3, str4, str5, str6);
    }

    public void sendOpenScreenWithDeviceInfo(String str, String str2, Context context) {
        f.b().sendOpenScreenWithDeviceInfo(str, str2, context);
    }

    public void sendCustomEventWithMap(String str, Map<String, Object> map, Context context) {
        f.b().sendCustomEventWithMap(str, map, context);
    }

    public void sendNewCustomGTMEvents(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        f.b().sendNewCustomGTMEvents(context, str, str2, str3, str4, str5, str6, str7);
    }

    public void signOutNetworkCustomError(Activity activity, boolean z, NetworkCustomError networkCustomError) {
        f.a().signOutNetworkCustomError(activity, z, networkCustomError);
    }

    public void openMainActivityFromSessionOut(Activity activity, String str, Bundle bundle, boolean z, boolean z2) {
        f.a().openMainActivityFromSessionOut(activity, str, bundle, z, z2);
    }

    public Context getApplicationContext() {
        return f.a().getApplicationContext();
    }

    public Context getBaseContext(Context context) {
        return f.a().getBaseContext(context);
    }

    public String getBuildConfigBuildType() {
        return f.a().getBuildConfigBuildType();
    }

    public String getStringFromGTM(String str) {
        return f.a().getStringFromGTM(str);
    }

    public boolean getBooleanFromGTM(String str, boolean z) {
        return f.a().getBooleanFromGTM(str, z);
    }

    public int getIntFromGTM(String str) {
        return f.a().getIntFromGTM(str);
    }

    public void openYoutubePlayerFragment(Context context, String str) {
        f.a().openYoutubePlayerFragment(context, str);
    }

    public boolean handleErrorResponse(IJRPaytmDataModel iJRPaytmDataModel) {
        return f.b().handleResponse(iJRPaytmDataModel);
    }

    public void cancelBankDebitCardHandler() {
        f.b().cancelBankDebitCardHandler();
    }

    public String getUserToken(Context context) {
        return f.a().getUserToken(context);
    }
}
