package net.one97.paytm.fastag.c;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.paytm.network.model.NetworkCustomError;
import java.util.Map;
import net.one97.paytm.common.entity.CJRRechargeCart;
import net.one97.paytm.fastag.ui.activity.FasTagKYCActivity;
import net.one97.paytm.m;

public interface b {
    void checkDeepLinking(Context context, String str);

    boolean checkErrorCodeFromCommonUtility(Activity activity, NetworkCustomError networkCustomError);

    String deeplinkSchemaName();

    Class<?> getAJRCSTOrderIssues();

    Class<?> getAJRCancelItemAcitivityClass();

    Class<?> getAJRCoupons();

    Class<?> getAJREmbedWebView();

    Class<?> getAJRInstallationDetails();

    Class<?> getAJRSellarRating();

    Class<?> getAJRWebViewActivity();

    String getAddressUrl();

    Context getApplicationContext();

    Class<?> getAuthActivityClass();

    Class<?> getAuthActivityClassFromMap();

    CJRRechargeCart getCartResponse(net.one97.paytm.fastag.model.CJRRechargeCart cJRRechargeCart);

    String getCartVerify();

    Class<?> getDetailedItemTrackingClass();

    String getFormattedOrderDate(String str, String str2);

    Map<String, String> getHeader(Context context);

    String getKYCProfileSaveURL();

    String getLeadAPIOnAppLaunchUrl();

    Context getMallApplicationContext();

    Class<?> getOrderDetailsActivity();

    Class<?> getPassbookActivityClass();

    Class<?> getReturnReplaceActivity();

    String getSSOToken(Context context);

    String getSellerRatingUrl();

    String getString(String str);

    String getStringFromGTM(String str);

    String getUploadDocuemntUrl();

    String getUtilityProdDetailsURL();

    void handlePlayServicesError();

    boolean isMinKycDone(FasTagKYCActivity fasTagKYCActivity);

    void sendCustomEventScreenWithMap(String str, String str2, String str3, String str4, FragmentActivity fragmentActivity);

    void sendCustomEventWithMap(String str, Map<String, Object> map, Activity activity);

    void sendCustomEventsWithScreenName(String str, String str2, FragmentActivity fragmentActivity);

    void sendCustomGTMEventForOrderCancel(Activity activity, Map<String, Object> map);

    void signOut(Activity activity, boolean z);

    void startCSTOrderIssuesActivity(Context context, Bundle bundle, m mVar);
}
