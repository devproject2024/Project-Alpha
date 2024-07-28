package net.one97.paytm.insurance.a;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import com.android.volley.VolleyError;
import com.paytm.network.listener.b;
import com.paytm.network.model.NetworkCustomError;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.common.entity.CJRPGTokenList;
import net.one97.paytm.common.entity.CJRRechargeCart;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.common.entity.shopping.CJROrderSummary;
import net.one97.paytm.m;

public interface a {
    boolean checkErrorCode(Context context, Exception exc);

    void clearRiskExtendedInfo();

    boolean containsError(CJRRechargeCart cJRRechargeCart, Context context);

    Class getAJRAuthActivity();

    Class getAJROrderSummaryActivityClass();

    Class getAJRRechargePaymentActivity();

    Context getApplicationContext();

    ContextWrapper getBaseContext(Context context);

    boolean getBooleanFromGTM(String str, boolean z);

    String getCartCheckoutUrl();

    String getCartVerifyUrl();

    CJRHomePageItem getDeeplinkDataItem(Context context, String str);

    String getEmbedWebViewClassName();

    Class getLandingActivityClass();

    String getLandingActivityClassName();

    String getOrderDetailUrl();

    String getPgToken(CJRPGTokenList cJRPGTokenList);

    String getRiskExtendedInfoJson();

    String getSSOToken(Context context);

    String getStringFromGTM(String str);

    String getStringFromGTM(String str, String str2);

    String getStringFromGTMContainer4(String str);

    String getUserId(Context context);

    Dialog getWalletStyleProgressDialog(Activity activity);

    void getWalletToken(String str, Activity activity, b bVar);

    boolean handleDeepLink(Context context, String str, Bundle bundle);

    void handleError(Activity activity, NetworkCustomError networkCustomError, String str, Bundle bundle, Boolean bool);

    void invokeCstModule(Context context, CJROrderSummary cJROrderSummary, m mVar, Integer num);

    void loadMallPage(Context context, String str, HashMap<String, Serializable> hashMap);

    void openOrderSummary(Activity activity, String str, String str2);

    void openPaymentPage(Activity activity, CJRRechargePayment cJRRechargePayment);

    void sendCustomEventWithMap(String str, Map<String, Object> map, Context context);

    void sendNewCustomGTMEvents(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7);

    void sendOpenScreenEvent(Context context, String str);

    void setRiskExtendedInfo(Context context, String str, String str2, boolean z, String str3);

    void showSessionTimeoutAlert(Activity activity, String str, Bundle bundle, NetworkCustomError networkCustomError);

    void signOut(Activity activity, boolean z, VolleyError volleyError);
}
