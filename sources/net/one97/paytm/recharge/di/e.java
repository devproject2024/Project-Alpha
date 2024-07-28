package net.one97.paytm.recharge.di;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.network.model.NetworkCustomError;
import com.paytmmall.clpartifact.listeners.IGAHandlerListener;
import com.paytmmall.clpartifact.widgets.blueprints.SFWidget;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.common.entity.CJRPGTokenList;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.recharge.CJRFrequentOrderList;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.common.entity.shopping.CJRHomePageV2;
import net.one97.paytm.m;
import net.one97.paytm.nativesdk.app.VerifyPromoCallbackListener;
import net.one97.paytm.nativesdk.orflow.interfaces.OnPromoActivityDestroyListener;
import net.one97.paytm.recharge.common.e.b;
import net.one97.paytm.recharge.ordersummary.f.a;
import net.one97.paytm.recharge.ordersummary.f.d;
import net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel;

public interface e {
    void checkDeepLinking(Context context, String str);

    boolean checkErrorCode(Context context, Exception exc);

    void clearRiskData();

    void dropBreadCrumb(String str, String str2);

    void fetchWalletToken(Context context, b bVar);

    Context getApplicationContext();

    String getBankAuthPasscodeRSA();

    String getCartID(Context context);

    HashMap<String, String> getCategoryIdUrl();

    HashMap<String, String> getCategoryIdUrlType();

    void getCstOrderIssueIntent(Context context, Bundle bundle);

    CJRHomePageItem getDeepLinkDataItem(Context context, String str);

    Fragment getFJRGoldSubscriptionListFragment();

    CJRFrequentOrderList getFrequentOrderList();

    Map<String, String> getHeader(Context context);

    RecyclerView.a<RecyclerView.v> getHomeFragmentWidgetAdapter(a aVar, FragmentActivity fragmentActivity, CJRHomePageV2 cJRHomePageV2, String str, RecyclerView recyclerView, CJRItem cJRItem, View view, d dVar, IGAHandlerListener iGAHandlerListener);

    Intent getIntent(String str, Context context, CJRHomePageItem cJRHomePageItem);

    String getPgToken(CJRPGTokenList cJRPGTokenList);

    boolean getPicassoIsInMemory();

    View getPostTxnCashBackView(FragmentActivity fragmentActivity, Integer num, String str, int i2, String str2, String str3, SFWidget sFWidget);

    CJRHomePageV2 getRechargeHomePageTabs();

    String getResourceId(Context context);

    String getRistJsonData();

    String getSSOToken(Context context);

    String getStoreFrontAdApiBody(Context context);

    void getUpdatedCstOrderIssueIntent(Activity activity, Bundle bundle, m mVar);

    String getWalletSSOToken(Context context);

    long getWalletTokenExpireTime(Context context);

    ContextWrapper getWrapedContextWithRestring(Context context);

    void handleError(Activity activity, Exception exc, String str, Bundle bundle, boolean z);

    void launchDeelink(Context context, String str, CJRHomePageItem cJRHomePageItem);

    void loadPage(Context context, String str, IJRDataModel iJRDataModel, String str2, int i2, ArrayList<? extends CJRItem> arrayList, boolean z, String str3);

    void openDetailPage(String str);

    void openHoHoPaymentSuccessActivity(Activity activity, String str);

    void openIFSCCodeActivity(Context context, int i2);

    void openPromoSelectionScreen(Context context, String str, double d2, String str2, String str3, VerifyPromoCallbackListener verifyPromoCallbackListener, OnPromoActivityDestroyListener onPromoActivityDestroyListener);

    String postRequestBodyForV2(Context context, String str, String str2);

    boolean reportError(Context context, NetworkCustomError networkCustomError, String str);

    void sendEventToPaytmAnalytics(CJRRechargeErrorModel cJRRechargeErrorModel, Context context);

    void setFrequentOrderList(CJRFrequentOrderList cJRFrequentOrderList);

    void setRechargeHomePageTabs(CJRHomePageV2 cJRHomePageV2);

    void setRiskExtendedInfo(Context context, String str, String str2, boolean z, String str3);

    void setupBottomTabs(Context context, LinearLayout linearLayout, View.OnClickListener onClickListener);

    void showSessionTimeoutAlert(Activity activity, Fragment fragment, String str, Bundle bundle, NetworkCustomError networkCustomError, boolean z, boolean z2);

    void showSessionTimeoutAlert(Activity activity, Fragment fragment, String str, Bundle bundle, NetworkCustomError networkCustomError, boolean z, boolean z2, int i2);

    void showSessionTimeoutAlert(Activity activity, String str, Bundle bundle, NetworkCustomError networkCustomError);

    void showSessionTimeoutAlert(Activity activity, String str, Bundle bundle, NetworkCustomError networkCustomError, boolean z);

    void showSessionTimeoutAlert(Activity activity, String str, Bundle bundle, NetworkCustomError networkCustomError, boolean z, boolean z2);

    void showSessionTimeoutAlert(Activity activity, String str, Bundle bundle, NetworkCustomError networkCustomError, boolean z, boolean z2, int i2);

    void signOut(Activity activity, boolean z, NetworkCustomError networkCustomError);

    void startBCLLSuccessBookingActivity(Activity activity, Intent intent, boolean z);

    void startHelpAndSupport(Context context);

    void updateRecentHistory();

    void updateStoreFrontResponseData(Activity activity, RecyclerView.a<RecyclerView.v> aVar, d dVar, CJRHomePageV2 cJRHomePageV2);
}
