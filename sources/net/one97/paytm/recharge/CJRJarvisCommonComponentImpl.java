package net.one97.paytm.recharge;

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
import com.appsflyer.internal.referrer.Payload;
import com.business.merchant_payments.common.utility.AppConstants;
import com.paytm.network.model.NetworkCustomError;
import com.paytmmall.clpartifact.listeners.IGAHandlerListener;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.widgets.blueprints.SFWidget;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.common.entity.CJRPGTokenList;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.recharge.CJRFrequentOrderList;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;
import net.one97.paytm.common.entity.shopping.CJRCartProduct;
import net.one97.paytm.common.entity.shopping.CJRDetailProduct;
import net.one97.paytm.common.entity.shopping.CJRGridProduct;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.common.entity.shopping.CJRHomePageV2;
import net.one97.paytm.common.entity.shopping.CJROrderSummary;
import net.one97.paytm.common.entity.shopping.CJROrderedCart;
import net.one97.paytm.common.entity.shopping.CJRParcelTrackingInfo;
import net.one97.paytm.m;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.Utils.FetchPayOptionsListener;
import net.one97.paytm.nativesdk.app.VerifyPromoCallbackListener;
import net.one97.paytm.nativesdk.orflow.interfaces.OnPromoActivityDestroyListener;
import net.one97.paytm.recharge.common.utils.w;
import net.one97.paytm.recharge.coupons.activity.DealDetail;
import net.one97.paytm.recharge.di.a;
import net.one97.paytm.recharge.di.b;
import net.one97.paytm.recharge.di.c;
import net.one97.paytm.recharge.di.d;
import net.one97.paytm.recharge.di.e;
import net.one97.paytm.recharge.di.f;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;
import net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2;
import net.one97.paytm.recharge.ordersummary.activity.CJRBaseOrderSummaryActivity;
import net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel;
import net.one97.paytm.utils.t;
import net.one97.paytm.y;

public final class CJRJarvisCommonComponentImpl implements a, b, c, d, e {
    private final /* synthetic */ i $$delegate_0 = new i();
    private final /* synthetic */ f $$delegate_1 = new f();
    private final /* synthetic */ j $$delegate_2;
    private final /* synthetic */ h $$delegate_3;

    public final void checkDeepLinking(Context context, String str) {
        k.c(context, "context");
        k.c(str, "deeplink");
        this.$$delegate_2.checkDeepLinking(context, str);
    }

    public final boolean checkErrorCode(Context context, Exception exc) {
        k.c(exc, "inError1");
        return this.$$delegate_2.checkErrorCode(context, exc);
    }

    public final void clearRiskData() {
        this.$$delegate_2.clearRiskData();
    }

    public final void dropBreadCrumb(String str, String str2) {
        k.c(str, "simpleName");
        k.c(str2, "activity_created");
        this.$$delegate_2.dropBreadCrumb(str, str2);
    }

    public final void fetchWalletToken(Context context, net.one97.paytm.recharge.common.e.b bVar) {
        k.c(context, "context");
        k.c(bVar, "listener");
        this.$$delegate_2.fetchWalletToken(context, bVar);
    }

    public final Map<a.C1212a, Class<? extends Activity>> getActivityMap() {
        return this.$$delegate_1.getActivityMap();
    }

    public final Context getApplicationContext() {
        return this.$$delegate_2.getApplicationContext();
    }

    public final String getBankAuthPasscodeRSA() {
        return this.$$delegate_2.getBankAuthPasscodeRSA();
    }

    public final boolean getBoolean(String str, boolean z) {
        k.c(str, "key");
        return this.$$delegate_0.getBoolean(str, z);
    }

    public final boolean getBooleanFromContainer4(String str, boolean z) {
        k.c(str, "key");
        return this.$$delegate_0.getBooleanFromContainer4(str, z);
    }

    public final String getCartID(Context context) {
        k.c(context, "context");
        return this.$$delegate_2.getCartID(context);
    }

    public final HashMap<String, String> getCategoryIdUrl() {
        return this.$$delegate_2.getCategoryIdUrl();
    }

    public final HashMap<String, String> getCategoryIdUrlType() {
        return this.$$delegate_2.getCategoryIdUrlType();
    }

    public final void getCstOrderIssueIntent(Context context, Bundle bundle) {
        k.c(context, "context");
        k.c(bundle, "bundle");
        this.$$delegate_2.getCstOrderIssueIntent(context, bundle);
    }

    public final CJRHomePageItem getDeepLinkDataItem(Context context, String str) {
        k.c(context, "context");
        k.c(str, "url");
        return this.$$delegate_2.getDeepLinkDataItem(context, str);
    }

    public final Fragment getFJRGoldSubscriptionListFragment() {
        return this.$$delegate_2.getFJRGoldSubscriptionListFragment();
    }

    public final CJRFrequentOrderList getFrequentOrderList() {
        return this.$$delegate_2.getFrequentOrderList();
    }

    public final Map<String, String> getHeader(Context context) {
        k.c(context, "context");
        return this.$$delegate_2.getHeader(context);
    }

    public final RecyclerView.a<RecyclerView.v> getHomeFragmentWidgetAdapter(net.one97.paytm.recharge.ordersummary.f.a aVar, FragmentActivity fragmentActivity, CJRHomePageV2 cJRHomePageV2, String str, RecyclerView recyclerView, CJRItem cJRItem, View view, net.one97.paytm.recharge.ordersummary.f.d dVar, IGAHandlerListener iGAHandlerListener) {
        k.c(aVar, "clickListener");
        k.c(fragmentActivity, "activity");
        k.c(cJRHomePageV2, Payload.RESPONSE);
        k.c(str, "gaKey");
        RecyclerView recyclerView2 = recyclerView;
        k.c(recyclerView2, "fixedInfiniteGridHeader");
        View view2 = view;
        k.c(view2, "infiniteTabBorder");
        net.one97.paytm.recharge.ordersummary.f.d dVar2 = dVar;
        k.c(dVar2, "dataPopulatedListener");
        IGAHandlerListener iGAHandlerListener2 = iGAHandlerListener;
        k.c(iGAHandlerListener2, "gaHandlerListener");
        return this.$$delegate_2.getHomeFragmentWidgetAdapter(aVar, fragmentActivity, cJRHomePageV2, str, recyclerView2, cJRItem, view2, dVar2, iGAHandlerListener2);
    }

    public final int getInteger(String str, int i2) {
        k.c(str, "key");
        return this.$$delegate_0.getInteger(str, i2);
    }

    public final Integer getInteger(String str) {
        k.c(str, "key");
        return this.$$delegate_0.getInteger(str);
    }

    public final Intent getIntent(String str, Context context, CJRHomePageItem cJRHomePageItem) {
        k.c(str, "url");
        k.c(context, "context");
        k.c(cJRHomePageItem, "item");
        return this.$$delegate_2.getIntent(str, context, cJRHomePageItem);
    }

    public final String getPgToken(CJRPGTokenList cJRPGTokenList) {
        return this.$$delegate_2.getPgToken(cJRPGTokenList);
    }

    public final boolean getPicassoIsInMemory() {
        return this.$$delegate_2.getPicassoIsInMemory();
    }

    public final View getPostTxnCashBackView(FragmentActivity fragmentActivity, Integer num, String str, int i2, String str2, String str3, SFWidget sFWidget) {
        k.c(fragmentActivity, "context");
        k.c(str, "verticalId");
        k.c(str3, "transactionType");
        return this.$$delegate_2.getPostTxnCashBackView(fragmentActivity, num, str, i2, str2, str3, sFWidget);
    }

    public final CJRHomePageV2 getRechargeHomePageTabs() {
        return this.$$delegate_2.getRechargeHomePageTabs();
    }

    public final String getResourceId(Context context) {
        k.c(context, "context");
        return this.$$delegate_2.getResourceId(context);
    }

    public final String getRistJsonData() {
        return this.$$delegate_2.getRistJsonData();
    }

    public final String getSSOToken(Context context) {
        k.c(context, "context");
        return this.$$delegate_2.getSSOToken(context);
    }

    public final String getStoreFrontAdApiBody(Context context) {
        k.c(context, "context");
        return this.$$delegate_2.getStoreFrontAdApiBody(context);
    }

    public final String getString(String str) {
        k.c(str, "key");
        return this.$$delegate_0.getString(str);
    }

    public final String getString(String str, String str2) {
        k.c(str, "key");
        k.c(str2, "value");
        return this.$$delegate_0.getString(str, str2);
    }

    public final String getStringFromContainer2(String str) {
        k.c(str, "key");
        return this.$$delegate_0.getStringFromContainer2(str);
    }

    public final String getStringFromContainer4(String str) {
        k.c(str, "key");
        return this.$$delegate_0.getStringFromContainer4(str);
    }

    public final void getUpdatedCstOrderIssueIntent(Activity activity, Bundle bundle, m mVar) {
        k.c(bundle, "bundle");
        this.$$delegate_2.getUpdatedCstOrderIssueIntent(activity, bundle, mVar);
    }

    public final String getWalletSSOToken(Context context) {
        k.c(context, "context");
        return this.$$delegate_2.getWalletSSOToken(context);
    }

    public final long getWalletTokenExpireTime(Context context) {
        k.c(context, "context");
        return this.$$delegate_2.getWalletTokenExpireTime(context);
    }

    public final ContextWrapper getWrapedContextWithRestring(Context context) {
        k.c(context, "context");
        return this.$$delegate_2.getWrapedContextWithRestring(context);
    }

    public final void handleError(Activity activity, Exception exc, String str, Bundle bundle, boolean z) {
        this.$$delegate_2.handleError(activity, exc, str, bundle, z);
    }

    public final boolean isGTMContainerInitialized() {
        return this.$$delegate_0.isGTMContainerInitialized();
    }

    public final void launchDeelink(Context context, String str, CJRHomePageItem cJRHomePageItem) {
        k.c(context, "context");
        k.c(str, "url");
        k.c(cJRHomePageItem, "searchItem");
        this.$$delegate_2.launchDeelink(context, str, cJRHomePageItem);
    }

    public final void loadPage(Context context, String str, IJRDataModel iJRDataModel, String str2, int i2, ArrayList<? extends CJRItem> arrayList, boolean z, String str3) {
        k.c(context, "context");
        k.c(iJRDataModel, "dataModel");
        this.$$delegate_2.loadPage(context, str, iJRDataModel, str2, i2, arrayList, z, str3);
    }

    public final void openDetailPage(String str) {
        k.c(str, "url");
        this.$$delegate_2.openDetailPage(str);
    }

    public final void openHoHoPaymentSuccessActivity(Activity activity, String str) {
        k.c(activity, "activity");
        this.$$delegate_2.openHoHoPaymentSuccessActivity(activity, str);
    }

    public final void openIFSCCodeActivity(Context context, int i2) {
        k.c(context, "context");
        this.$$delegate_2.openIFSCCodeActivity(context, i2);
    }

    public final void openPromoSelectionScreen(Context context, String str, double d2, String str2, String str3, VerifyPromoCallbackListener verifyPromoCallbackListener, OnPromoActivityDestroyListener onPromoActivityDestroyListener) {
        k.c(context, "context");
        k.c(str2, "promoSearchApiResponse");
        String str4 = str3;
        k.c(str4, "reqUrl");
        VerifyPromoCallbackListener verifyPromoCallbackListener2 = verifyPromoCallbackListener;
        k.c(verifyPromoCallbackListener2, "listener");
        OnPromoActivityDestroyListener onPromoActivityDestroyListener2 = onPromoActivityDestroyListener;
        k.c(onPromoActivityDestroyListener2, "destroyListener");
        this.$$delegate_2.openPromoSelectionScreen(context, str, d2, str2, str4, verifyPromoCallbackListener2, onPromoActivityDestroyListener2);
    }

    public final String postRequestBodyForV2(Context context, String str, String str2) {
        k.c(str, "prevPage");
        k.c(str2, "currentPage");
        return this.$$delegate_2.postRequestBodyForV2(context, str, str2);
    }

    public final boolean reportError(Context context, NetworkCustomError networkCustomError, String str) {
        k.c(networkCustomError, "error");
        k.c(str, "mailId");
        return this.$$delegate_2.reportError(context, networkCustomError, str);
    }

    public final void sendAppsFlyerPurchaseEvent(String str, String str2, String str3, String str4, String str5, ArrayList<String> arrayList, String str6, String str7, String str8) {
        this.$$delegate_3.sendAppsFlyerPurchaseEvent(str, str2, str3, str4, str5, arrayList, str6, str7, str8);
    }

    public final void sendCheckOutGTMEvent(ArrayList<CJRCartProduct> arrayList, Context context, int i2, String str, boolean z) {
        k.c(str, "category");
        this.$$delegate_3.sendCheckOutGTMEvent(arrayList, context, i2, str, z);
    }

    public final void sendCreditCardCustomEvent(Context context, String str, String str2, String str3) {
        k.c(str, "actioN_CREDIT_CARD_ENTER_SIX_DIGIT");
        k.c(str2, "label");
        this.$$delegate_3.sendCreditCardCustomEvent(context, str, str2, str3);
    }

    public final void sendCreditCardEvent(Context context, String str, String str2) {
        k.c(str, "gtM_EVENT_CREDIT_CARD_NUMBER_FILED_RE_CLICKED");
        k.c(str2, "s");
        this.$$delegate_3.sendCreditCardEvent(context, str, str2);
    }

    public final void sendCustomEventWithMap(String str, HashMap<String, Object> hashMap, Context context) {
        k.c(str, AppConstants.NOTIFICATION_DETAILS.EVENT);
        k.c(hashMap, "gaMap");
        k.c(context, "context");
        this.$$delegate_3.sendCustomEventWithMap(str, hashMap, context);
    }

    public final void sendCustomEventWithMap(String str, Map<String, ? extends Object> map, Context context) {
        k.c(str, AppConstants.NOTIFICATION_DETAILS.EVENT);
        k.c(map, "gaMap");
        k.c(context, "context");
        this.$$delegate_3.sendCustomEventWithMap(str, map, context);
    }

    public final void sendCustomEventWithMapForUtility(String str, Map<String, Object> map, String str2, Context context) {
        k.c(map, Item.CTA_URL_TYPE_MAP);
        k.c(str2, "gtM_EVENT_RECHARGE_UTILITY_SCREEN_LOADED");
        this.$$delegate_3.sendCustomEventWithMapForUtility(str, map, str2, context);
    }

    public final void sendCustomEventWithMapForUtility(CJRItem cJRItem, Map<String, Object> map, String str, Context context) {
        k.c(map, Item.CTA_URL_TYPE_MAP);
        k.c(str, "gtM_EVENT_RECHARGE_UTILITY_SCREEN_LOADED");
        this.$$delegate_3.sendCustomEventWithMapForUtility(cJRItem, map, str, context);
    }

    public final void sendCustomEventWithMapForUtility(CJRItem cJRItem, Map<String, Object> map, String str, FragmentActivity fragmentActivity) {
        k.c(map, Item.CTA_URL_TYPE_MAP);
        k.c(str, "gtM_EVENT_RECHARGE_UTILITY_SCREEN_LOADED");
        this.$$delegate_3.sendCustomEventWithMapForUtility(cJRItem, map, str, fragmentActivity);
    }

    public final void sendCustomGTMEvents(Context context, String str, String str2, String str3, String str4, String str5, String str6) {
        k.c(str, "category");
        k.c(str2, "action");
        k.c(str3, "label");
        k.c(str4, "value");
        k.c(str5, SDKConstants.EVENT_KEY_SCREEN_NAME);
        String str7 = str6;
        k.c(str7, "verticalId");
        this.$$delegate_3.sendCustomGTMEvents(context, str, str2, str3, str4, str5, str7);
    }

    public final void sendCustomRechargeEvent(HashMap<String, Object> hashMap, Context context) {
        k.c(hashMap, Item.CTA_URL_TYPE_MAP);
        k.c(context, "context");
        this.$$delegate_3.sendCustomRechargeEvent(hashMap, context);
    }

    public final void sendDthCustomEvent(Context context, String str, String str2, String str3, String str4) {
        k.c(context, "ajrBrowsePlanActivity");
        k.c(str, "eventCategory");
        k.c(str2, "gtmEventRechargesBrowsePlanTabClicked");
        k.c(str3, "mScreenName");
        k.c(str4, "toString");
        this.$$delegate_3.sendDthCustomEvent(context, str, str2, str3, str4);
    }

    public final void sendEvent(Context context, String str, String str2, String str3) {
        k.c(context, "activity");
        k.c(str, "gtmRechargeCategory");
        k.c(str2, "gtmEventAddNewAutomaticClicked");
        k.c(str3, "s");
        this.$$delegate_3.sendEvent(context, str, str2, str3);
    }

    public final void sendEventToPaytmAnalytics(CJRRechargeErrorModel cJRRechargeErrorModel, Context context) {
        k.c(cJRRechargeErrorModel, "t");
        k.c(context, "context");
        this.$$delegate_2.sendEventToPaytmAnalytics(cJRRechargeErrorModel, context);
    }

    public final void sendGTMAddToCartTagForCouponsPage(CJRGridProduct cJRGridProduct, int i2, Context context, String str, Void voidR, String str2) {
        k.c(cJRGridProduct, "mPopUpCoupon");
        k.c(context, "ajrCouponsActivityV8");
        k.c(str, SDKConstants.EVENT_KEY_SCREEN_NAME);
        k.c(str2, "category");
        this.$$delegate_3.sendGTMAddToCartTagForCouponsPage(cJRGridProduct, i2, context, str, voidR, str2);
    }

    public final void sendGTMAddToCartTagRechargeAndBillPayment(CJRCartProduct cJRCartProduct, Context context, String str, String str2) {
        k.c(context, "mBaseActivity");
        k.c(str2, "gtM_KEY_SCREEN_CART_SCREEN");
        this.$$delegate_3.sendGTMAddToCartTagRechargeAndBillPayment(cJRCartProduct, context, str, str2);
    }

    public final void sendGTMGridEvent(Context context, List<? extends CJRGridProduct> list, String str, String str2, String str3, int i2, String str4, String str5, Void voidR) {
        k.c(context, "context");
        k.c(str, "s");
        String str6 = str3;
        k.c(str6, SDKConstants.EVENT_KEY_SCREEN_NAME);
        String str7 = str4;
        k.c(str7, "s1");
        String str8 = str5;
        k.c(str8, "s2");
        this.$$delegate_3.sendGTMGridEvent(context, list, str, str2, str6, i2, str7, str8, voidR);
    }

    public final void sendGTMProductViewTag(CJRDetailProduct cJRDetailProduct, DealDetail dealDetail, CJRItem cJRItem) {
        k.c(cJRDetailProduct, "productDetail");
        k.c(dealDetail, "dealDetail");
        this.$$delegate_3.sendGTMProductViewTag(cJRDetailProduct, dealDetail, cJRItem);
    }

    public final void sendGTMRechargeFunnelEvent(FragmentActivity fragmentActivity, String str) {
        k.c(str, "label");
        this.$$delegate_3.sendGTMRechargeFunnelEvent(fragmentActivity, str);
    }

    public final void sendGTMRemoveCartTagForCouponsPage(CJRGridProduct cJRGridProduct, int i2, Context context, String str, Void voidR, String str2) {
        k.c(cJRGridProduct, "mPopUpCoupon");
        k.c(context, "ajrCouponsActivityV8");
        k.c(str, SDKConstants.EVENT_KEY_SCREEN_NAME);
        k.c(str2, "category");
        this.$$delegate_3.sendGTMRemoveCartTagForCouponsPage(cJRGridProduct, i2, context, str, voidR, str2);
    }

    public final void sendImpressionEventForWidgets(CJRHomePageItem cJRHomePageItem, int i2, String str, String str2, Context context, String str3, String str4) {
        k.c(cJRHomePageItem, "product");
        k.c(str, "layoutType");
        k.c(str2, "mchildSiteId");
        k.c(context, "context");
        k.c(str3, "gaKey");
        String str5 = str4;
        k.c(str5, "widgetType");
        this.$$delegate_3.sendImpressionEventForWidgets(cJRHomePageItem, i2, str, str2, context, str3, str5);
    }

    public final void sendImpsCustomEvent(Context context, String str, String str2, String str3) {
        this.$$delegate_3.sendImpsCustomEvent(context, str, str2, str3);
    }

    public final void sendNewCustomGTMEvents(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        k.c(context, "context");
        k.c(str, "feeCategory");
        k.c(str2, "exploreCollegesClicked");
        String str8 = str6;
        k.c(str8, "feeScreenName");
        String str9 = str7;
        k.c(str9, "feeVerticalName");
        this.$$delegate_3.sendNewCustomGTMEvents(context, str, str2, str3, str4, str5, str8, str9);
    }

    public final void sendOpenScreenEvent(Context context, String str) {
        k.c(str, "gtM_EVENT_ACTION_BROWSE_PLAN");
        this.$$delegate_3.sendOpenScreenEvent(context, str);
    }

    public final void sendOrderDetails(String str, boolean z, Context context, String str2, String str3) {
        k.c(str, "verticalLabel");
        k.c(context, "activity");
        k.c(str2, "categoryIdMap");
        this.$$delegate_3.sendOrderDetails(str, z, context, str2, str3);
    }

    public final void sendPaytmAssistGAEvents(CJROrderSummary cJROrderSummary, y yVar, CJRBaseOrderSummaryActivity cJRBaseOrderSummaryActivity) {
        k.c(yVar, "mPaytmAssistGAEventsData");
        k.c(cJRBaseOrderSummaryActivity, "cjrBaseOrderSummaryActivity");
        this.$$delegate_3.sendPaytmAssistGAEvents(cJROrderSummary, yVar, cJRBaseOrderSummaryActivity);
    }

    public final void sendProductClickInGridForCouponsPage(Context context, CJRGridProduct cJRGridProduct, int i2, String str, String str2) {
        k.c(context, "ajrCouponsActivityV8");
        k.c(cJRGridProduct, "gridProduct");
        k.c(str, "categoryName");
        k.c(str2, SDKConstants.EVENT_KEY_SCREEN_NAME);
        this.$$delegate_3.sendProductClickInGridForCouponsPage(context, cJRGridProduct, i2, str, str2);
    }

    public final void sendPromotionClick(CJRHomePageItem cJRHomePageItem, Context context, int i2, String str, String str2) {
        k.c(context, "cjrBaseOrderSummaryActivity");
        k.c(str, "s");
        k.c(str2, "s1");
        this.$$delegate_3.sendPromotionClick(cJRHomePageItem, context, i2, str, str2);
    }

    public final void sendRechargeUtilitiesMessageDisplayedEvent(boolean z, boolean z2, String str, Context context, String str2, String str3) {
        k.c(str, "subVertical");
        k.c(context, "context");
        k.c(str2, "serviceType");
        k.c(str3, "eventMessageText");
        this.$$delegate_3.sendRechargeUtilitiesMessageDisplayedEvent(z, z2, str, context, str2, str3);
    }

    public final void setFrequentOrderList(CJRFrequentOrderList cJRFrequentOrderList) {
        k.c(cJRFrequentOrderList, "frequentOrderList");
        this.$$delegate_2.setFrequentOrderList(cJRFrequentOrderList);
    }

    public final void setRechargeHomePageTabs(CJRHomePageV2 cJRHomePageV2) {
        k.c(cJRHomePageV2, "rechargeHomePageTabs");
        this.$$delegate_2.setRechargeHomePageTabs(cJRHomePageV2);
    }

    public final void setRiskExtendedInfo(Context context, String str, String str2, boolean z, String str3) {
        k.c(context, "context");
        this.$$delegate_2.setRiskExtendedInfo(context, str, str2, z, str3);
    }

    public final void setupBottomTabs(Context context, LinearLayout linearLayout, View.OnClickListener onClickListener) {
        k.c(context, "context");
        k.c(linearLayout, "bottomTabsLinearLayout");
        k.c(onClickListener, "listener");
        this.$$delegate_2.setupBottomTabs(context, linearLayout, onClickListener);
    }

    public final void showSessionTimeoutAlert(Activity activity, Fragment fragment, String str, Bundle bundle, NetworkCustomError networkCustomError, boolean z, boolean z2) {
        k.c(fragment, "fragment");
        this.$$delegate_2.showSessionTimeoutAlert(activity, fragment, str, bundle, networkCustomError, z, z2);
    }

    public final void showSessionTimeoutAlert(Activity activity, Fragment fragment, String str, Bundle bundle, NetworkCustomError networkCustomError, boolean z, boolean z2, int i2) {
        k.c(fragment, "fragment");
        this.$$delegate_2.showSessionTimeoutAlert(activity, fragment, str, bundle, networkCustomError, z, z2, i2);
    }

    public final void showSessionTimeoutAlert(Activity activity, String str, Bundle bundle, NetworkCustomError networkCustomError) {
        this.$$delegate_2.showSessionTimeoutAlert(activity, str, bundle, networkCustomError);
    }

    public final void showSessionTimeoutAlert(Activity activity, String str, Bundle bundle, NetworkCustomError networkCustomError, boolean z) {
        this.$$delegate_2.showSessionTimeoutAlert(activity, str, bundle, networkCustomError, z);
    }

    public final void showSessionTimeoutAlert(Activity activity, String str, Bundle bundle, NetworkCustomError networkCustomError, boolean z, boolean z2) {
        this.$$delegate_2.showSessionTimeoutAlert(activity, str, bundle, networkCustomError, z, z2);
    }

    public final void showSessionTimeoutAlert(Activity activity, String str, Bundle bundle, NetworkCustomError networkCustomError, boolean z, boolean z2, int i2) {
        this.$$delegate_2.showSessionTimeoutAlert(activity, str, bundle, networkCustomError, z, z2, i2);
    }

    public final void signOut(Activity activity, boolean z, NetworkCustomError networkCustomError) {
        k.c(activity, "mSelectCardActivity");
        this.$$delegate_2.signOut(activity, z, networkCustomError);
    }

    public final void startBCLLSuccessBookingActivity(Activity activity, Intent intent, boolean z) {
        k.c(activity, "activity");
        k.c(intent, "resultIntent");
        this.$$delegate_2.startBCLLSuccessBookingActivity(activity, intent, z);
    }

    public final void startHelpAndSupport(Context context) {
        k.c(context, "mContext");
        this.$$delegate_2.startHelpAndSupport(context);
    }

    public final void updateRecentHistory() {
        this.$$delegate_2.updateRecentHistory();
    }

    public final void updateStoreFrontResponseData(Activity activity, RecyclerView.a<RecyclerView.v> aVar, net.one97.paytm.recharge.ordersummary.f.d dVar, CJRHomePageV2 cJRHomePageV2) {
        k.c(activity, "context");
        k.c(aVar, "adapter");
        k.c(dVar, "dataPopulatedListener");
        k.c(cJRHomePageV2, "newResponse");
        this.$$delegate_2.updateStoreFrontResponseData(activity, aVar, dVar, cJRHomePageV2);
    }

    public CJRJarvisCommonComponentImpl(Context context) {
        k.c(context, "context");
        this.$$delegate_2 = new j(context);
        this.$$delegate_3 = new h();
    }

    public final void GTMContainersInitialzed() {
        if (f.f62644a.a().isGTMContainerInitialized()) {
            CJRRechargeUtilities.INSTANCE.getGtmContainerInitializationObservable().onNext(Boolean.TRUE);
        }
    }

    public final void fetchPaymentOptions(Context context, CJRRechargePayment cJRRechargePayment, w wVar) {
        k.c(context, "context");
        k.c(wVar, "cjrRechargeProceedHelper");
        k.c(context, "context");
        k.c(wVar, "cjrRechargeProceedHelper");
        t.a(context, cJRRechargePayment, (FetchPayOptionsListener) wVar);
    }

    public final void sendCustomEventScreenWithMap(String str, String str2, String str3, String str4, Context context) {
        k.c(str, "gtmEventRechargeMobileNumberEntered");
        k.c(str2, SDKConstants.EVENT_KEY_SCREEN_NAME);
        k.c(str3, "gtmKeyMobileNum");
        k.c(str4, "txtMobileNumber");
        k.c(context, "activity");
        k.c(str, "gtmEventRechargeMobileNumberEntered");
        k.c(str2, SDKConstants.EVENT_KEY_SCREEN_NAME);
        k.c(str3, "gtmKeyMobileNum");
        k.c(str4, "txtMobileNumber");
        k.c(context, "activity");
        net.one97.paytm.j.a.a(str, str2, str3, str4, context);
    }

    public final void sendCustomEvents(String str, String str2, Activity activity) {
        k.c(str, "gtmEventCouponProceed");
        k.c(str2, "gtmKeyScreenCoupon");
        k.c(activity, "ajrCoupons");
        k.c(str, "gtmEventCouponProceed");
        k.c(str2, "gtmKeyScreenCoupon");
        k.c(activity, "ajrCoupons");
        net.one97.paytm.j.a.a(str, str2);
    }

    public final void sendCustomEventsWithScreenName(String str, String str2, Context context) {
        k.c(str, AppConstants.NOTIFICATION_DETAILS.EVENT);
        k.c(str2, "gtM_EVENT_CREDIT_CARD_NUMBER_FILED_RE_CLICKED");
        k.c(context, "context");
        k.c(str, AppConstants.NOTIFICATION_DETAILS.EVENT);
        k.c(str2, "gtM_EVENT_CREDIT_CARD_NUMBER_FILED_RE_CLICKED");
        k.c(context, "context");
        net.one97.paytm.j.a.a(str, str2, context);
    }

    public final void sendDealsImpression(String str, HashMap<String, Object> hashMap, Activity activity) {
        k.c(str, "gtmEventDealsImpression");
        k.c(hashMap, Item.CTA_URL_TYPE_MAP);
        k.c(activity, "mActivity");
        k.c(str, "gtmEventDealsImpression");
        k.c(hashMap, Item.CTA_URL_TYPE_MAP);
        k.c(activity, "mActivity");
        net.one97.paytm.j.a.c(str, hashMap, activity);
    }

    public final void sendDevotionItemClickEvent(CJRUtilityVariantV2 cJRUtilityVariantV2, FragmentActivity fragmentActivity, int i2, String str) {
        k.c(cJRUtilityVariantV2, "utilityVariantV2");
        k.c(fragmentActivity, "activity");
        k.c(str, "gtmDevotionScreenName");
        k.c(cJRUtilityVariantV2, "utilityVariantV2");
        k.c(fragmentActivity, "activity");
        k.c(str, "gtmDevotionScreenName");
        net.one97.paytm.j.a.a(cJRUtilityVariantV2, (Context) fragmentActivity, i2);
    }

    public final void sendDevotionItemImpression(CJRUtilityVariantV2 cJRUtilityVariantV2, Context context, int i2) {
        k.c(cJRUtilityVariantV2, "cjrUtilityVariantV2");
        k.c(context, "mContext");
        k.c(cJRUtilityVariantV2, "cjrUtilityVariantV2");
        k.c(context, "mContext");
        net.one97.paytm.j.a.b(cJRUtilityVariantV2, context, i2);
    }

    public final void sendDigitalCartEvent(String str, String str2, String str3, String str4, Activity activity) {
        k.c(str, "gtmEventApplyClickedWallet");
        k.c(str2, "gtmKeyPromoCode");
        k.c(str3, "toString");
        k.c(str4, "gtmKeyScreenWallet");
        k.c(activity, "ajrCoupons");
        k.c(str, "gtmEventApplyClickedWallet");
        k.c(str2, "gtmKeyPromoCode");
        k.c(str3, "toString");
        k.c(str4, "gtmKeyScreenWallet");
        k.c(activity, "ajrCoupons");
        net.one97.paytm.j.a.b(str, str2, str3, str4, (Context) activity);
    }

    public final void sendGTMDevotionEvent(Activity activity, String str, String str2, String str3) {
        k.c(activity, "ajrDevotionDetailTabActivity");
        k.c(str, "s");
        k.c(str2, "s1");
        k.c(str3, "institutionName");
        k.c(activity, "ajrDevotionDetailTabActivity");
        k.c(str, "s");
        k.c(str2, "s1");
        k.c(str3, "institutionName");
        net.one97.paytm.j.a.d((Context) activity, str, str2, str3);
    }

    public final void sendGTMOrderSummaryTag(Context context, CJROrderSummary cJROrderSummary, CJRParcelTrackingInfo cJRParcelTrackingInfo, String str, boolean z, String str2, String str3, long j) {
        k.c(str3, "categoryIdMap");
        k.c(str3, "categoryIdMap");
        net.one97.paytm.j.a.a(context, cJROrderSummary, cJRParcelTrackingInfo, str, z, str2, str3, j);
    }

    public final void sendGTMThankYouScreen(Context context, boolean z, CJROrderSummary cJROrderSummary, String str, String str2) {
        k.c(str2, "categoryIdMap");
        k.c(str2, "categoryIdMap");
        net.one97.paytm.j.a.a(context, z, cJROrderSummary, str, str2);
    }

    public final void sendOpenScreenWithDeviceInfo(String str, String str2, Context context) {
        k.c(str, "coupons");
        k.c(context, "activity");
        k.c(str, "coupons");
        k.c(context, "context");
        net.one97.paytm.j.a.b(str, str2, context);
    }

    public final void sendOrderSummaryForVerticals(String str, String str2, boolean z, String str3, String str4, Context context, ArrayList<CJROrderedCart> arrayList, String str5) {
        k.c(str2, "category");
        k.c(str3, "amount");
        k.c(str4, Payload.REFERRER);
        k.c(str5, "categoryIdMap");
        k.c(str2, "category");
        k.c(str3, "amount");
        k.c(str4, Payload.REFERRER);
        k.c(str5, "categoryIdMap");
        net.one97.paytm.j.a.a(str, str2, z, str3, str4, context, arrayList, str5);
    }

    public final void sendOrderSummaryPGEvent(Context context, CJROrderSummary cJROrderSummary) {
        k.c(cJROrderSummary, "mOrderSummary");
        k.c(cJROrderSummary, "mOrderSummary");
        net.one97.paytm.j.a.a(context, cJROrderSummary);
    }

    public final void sendProductClickInHome(Context context, CJRHomePageItem cJRHomePageItem, int i2, String str, String str2, HashMap<String, Object> hashMap) {
        k.c(context, "cjrBaseOrderSummaryActivity");
        k.c(hashMap, "hashMap");
        k.c(context, "cjrBaseOrderSummaryActivity");
        k.c(hashMap, "hashMap");
        net.one97.paytm.j.a.a(context, cJRHomePageItem, i2, str, str2, hashMap);
    }
}
