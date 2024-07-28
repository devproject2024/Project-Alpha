package net.one97.paytm.managebeneficiary;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import java.util.HashMap;
import net.one97.paytm.managebeneficiary.a.a;
import net.one97.paytm.managebeneficiary.a.b;

public interface g {
    String addBeneficiaryURL(Context context);

    void checkDeepLinking(Context context, String str);

    String deeplinkSchemaName();

    void deleteBeneficiaryFromDb(Context context, String str, String str2);

    String deleteBeneficiaryURL(Context context);

    String editBeneficiaryURL(Context context);

    void getBankAccStatus(Context context, a aVar);

    String getBankIconUrl(Context context, String str);

    String getBeneficiaryAddSuccessMsg(Activity activity);

    String getBeneficiaryDetailUpdatesMsg(Context context);

    String getBeneficiaryLimitUpdateMsg(Context context);

    String getBeneficiaryURLV2(Context context);

    boolean getBoolean(String str, boolean z);

    Intent getIfscConfirmActivity(Context context);

    String getSSOToken(Context context);

    String getValidateBeneficiaryUrl(Context context);

    void handleError(Activity activity, Exception exc, String str, Bundle bundle, boolean z);

    void initIfscHelper(Activity activity, String str, b bVar);

    void sendCustomEventWithMap(String str, HashMap<String, Object> hashMap, Context context);

    void sendOpenScreenWithDeviceInfo(String str, String str2, Activity activity);

    void showAlertForBeneficiary(Activity activity, String str, String str2);

    boolean showDeleteBeneficiaryButton();
}
