package net.one97.paytm.bankOpen;

import android.content.Context;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.Map;

public interface d {
    void cancelBankDebitCardHandler();

    boolean checkDeepLinking(Context context, String str);

    void getNameFromKyc(Context context, net.one97.paytm.bankCommon.f.d dVar);

    Class<?> getNearByMainActivityClass();

    boolean handleResponse(IJRPaytmDataModel iJRPaytmDataModel);

    void sendCustomEventWithMap(String str, Map<String, Object> map, Context context);

    void sendCustomGTMEvents(Context context, String str, String str2, String str3, String str4, String str5, String str6);

    void sendNewCustomGTMEvents(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7);

    void sendOpenScreenWithDeviceInfo(String str, String str2, Context context);
}
