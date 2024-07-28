package net.one97.paytm.o2o.movies.common.c;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.j;
import com.android.volley.VolleyError;
import com.paytm.network.listener.b;
import com.paytm.network.model.CJRError;
import com.paytm.network.model.NetworkCustomError;
import com.paytmmall.clpartifact.widgets.blueprints.SFWidget;
import java.util.ArrayList;
import java.util.Map;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.common.entity.CJRPGTokenList;
import net.one97.paytm.common.entity.CJRSelectCityModel;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.common.entity.shopping.CJRHomePageLayoutV2;
import net.one97.paytm.common.entity.shopping.CJROrderSummary;
import net.one97.paytm.common.entity.shopping.CJRParcelTrackingInfo;
import net.one97.paytm.m;
import net.one97.paytm.nativesdk.app.PaytmSDKRequestClient;
import net.one97.paytm.nativesdk.app.VerifyPromoCallbackListener;
import net.one97.paytm.nativesdk.common.model.CJPayMethodResponse;
import net.one97.paytm.nativesdk.orflow.interfaces.OnPromoActivityDestroyListener;
import net.one97.paytm.nativesdk.orflow.promo.model.Request;
import net.one97.paytm.o2o.movies.b.g;
import net.one97.paytm.o2o.movies.common.movies.booking.CJRMovieCart;
import net.one97.paytm.y;

public interface a {
    boolean checkErrorCode(Context context, NetworkCustomError networkCustomError);

    void clearRisk();

    boolean containsError(CJRMovieCart cJRMovieCart, Context context);

    void crashlyticsLogs(String str);

    String createRequestBodyForV2(Context context, String str, String str2, CJRSelectCityModel cJRSelectCityModel);

    void dropBreadCrumb(String str, String str2);

    void fetchPaymentOptions(Activity activity, ProgressDialog progressDialog, CJRMovieCart cJRMovieCart, PaytmSDKRequestClient.OtherPayOptionsListener otherPayOptionsListener, boolean z, g gVar);

    void fetchPaymentOptions(Activity activity, CJRRechargePayment cJRRechargePayment, ProgressDialog progressDialog, CJRMovieCart cJRMovieCart);

    Context getAppContext();

    ContextWrapper getBaseContext(Context context);

    String getContainerInstanceId(CJRHomePageLayoutV2 cJRHomePageLayoutV2);

    CJRError getDataDisplayError(Context context, String str);

    CJRError getError(Context context, Exception exc);

    int getIntFromGTM(String str, int i2);

    String getJsonOfRiskExtendedInfo();

    String getPgToken(CJRPGTokenList cJRPGTokenList);

    boolean getPicassoIsInMemory();

    String getSSOToken(Context context);

    String getStringFromGTM(String str, String str2);

    void getWalletTokenMovies(String str, Activity activity, b bVar);

    void handleError(Activity activity, Exception exc, String str, Bundle bundle, boolean z);

    void handlePlayServicesError(Activity activity);

    boolean isBranchShareUrl(String str);

    boolean isDebugType();

    boolean isMainActivityInstance(Activity activity);

    void launchDeeplink(String str, Context context, String str2);

    void loadPage(Activity activity, String str, IJRDataModel iJRDataModel, String str2, int i2, ArrayList<? extends CJRItem> arrayList, boolean z, String str3);

    void makeNPSTrackingApiCall(Context context, int i2, String str, String str2, ArrayList<String> arrayList, b bVar);

    View onTransactionComplete(SFWidget sFWidget, Context context, String str, net.one97.paytm.utils.b.a aVar);

    void openCSTscreen(Activity activity, Bundle bundle, m mVar);

    void openH5(Context context, String str);

    void openPromoPayOptionsBottomSheet(String str, Context context, j jVar, double d2, CJPayMethodResponse cJPayMethodResponse, VerifyPromoCallbackListener verifyPromoCallbackListener, OnPromoActivityDestroyListener onPromoActivityDestroyListener, PaytmSDKRequestClient.VerifyResponseData verifyResponseData);

    void openPromoScreen(String str, Context context, double d2, String str2, VerifyPromoCallbackListener verifyPromoCallbackListener, OnPromoActivityDestroyListener onPromoActivityDestroyListener);

    void openPromoSearchActivityWithoutData(String str, Context context, double d2, Request request, VerifyPromoCallbackListener verifyPromoCallbackListener, OnPromoActivityDestroyListener onPromoActivityDestroyListener);

    String postRequestBodyForV2(Context context, String str, String str2);

    boolean reportError(Context context, Exception exc, String str);

    void sendAppsFlyerPurchaseEvent(String str, String str2, String str3, String str4, String str5, ArrayList<String> arrayList, String str6, String str7, String str8);

    void sendCustomEventWithMap(String str, Map<String, Object> map, Context context);

    void sendCustomEventWithMultipleLabel(Context context, String str, String str2, ArrayList<String> arrayList, String str3, String str4, String str5);

    void sendCustomEvents(String str, Context context);

    void sendDeepLinkOpen(String str, CJRHomePageItem cJRHomePageItem, Context context);

    void sendEnhancedEcommerceEvent(String str, Map<String, Object> map, Context context);

    void sendGTMOrderSummaryTag(Context context, CJROrderSummary cJROrderSummary, CJRParcelTrackingInfo cJRParcelTrackingInfo, String str, boolean z, String str2, String str3, long j);

    void sendGTMThankYouScreen(Context context, boolean z, CJROrderSummary cJROrderSummary, String str, String str2);

    void sendMoviePromotionImpression(CJRHomePageItem cJRHomePageItem, Context context, int i2, String str, String str2);

    void sendMoviePromotionImpressionClick(CJRHomePageItem cJRHomePageItem, Context context, int i2, String str, String str2);

    void sendNewCustomGTMEvents(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7);

    void sendOpenScreenEvent(Context context, String str);

    void sendOpenScreenWithDeviceInfo(String str, String str2, Context context);

    void sendOrderSummaryPGEvent(Context context, CJROrderSummary cJROrderSummary);

    void sendPaytmAssistGAEvents(CJROrderSummary cJROrderSummary, y yVar, Context context);

    void sendPromotionClick(CJRHomePageItem cJRHomePageItem, Context context, int i2, String str, String str2);

    void sendPromotionImpression(CJRHomePageItem cJRHomePageItem, Context context, int i2, String str);

    void sendTransactionBetaOutForWallet(Context context, String str, String str2, String str3, String str4);

    void sendUAEventWithValue(String str, String str2);

    void setRiskExtendedInfo(Context context, String str, String str2, boolean z, String str3);

    void shareBranchLink(Context context, String str);

    void showCustomAlert(Activity activity, String str, String str2);

    void showSessionTimeoutAlert(Activity activity, String str, Bundle bundle, Exception exc);

    void signOut(Activity activity, boolean z, VolleyError volleyError);
}
