package net.one97.paytm.recharge.di.helper;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.business.merchant_payments.common.utility.AppConstants;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.common.entity.shopping.CJRCartProduct;
import net.one97.paytm.common.entity.shopping.CJRDetailProduct;
import net.one97.paytm.common.entity.shopping.CJRGridProduct;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.common.entity.shopping.CJROrderSummary;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.recharge.coupons.activity.DealDetail;
import net.one97.paytm.recharge.di.c;
import net.one97.paytm.recharge.di.f;
import net.one97.paytm.recharge.ordersummary.activity.CJRBaseOrderSummaryActivity;
import net.one97.paytm.y;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f62652a = new b();

    /* renamed from: b  reason: collision with root package name */
    private static c f62653b = f.f62644a.d();

    private b() {
    }

    public static void a(CJRItem cJRItem, Map<String, Object> map, String str, FragmentActivity fragmentActivity) {
        k.c(map, Item.CTA_URL_TYPE_MAP);
        k.c(str, "gtM_EVENT_RECHARGE_UTILITY_SCREEN_LOADED");
        f62653b.sendCustomEventWithMapForUtility(cJRItem, map, str, fragmentActivity);
    }

    public static void a(CJRCartProduct cJRCartProduct, Context context, String str, String str2) {
        k.c(context, "mBaseActivity");
        k.c(str2, "gtM_KEY_SCREEN_CART_SCREEN");
        f62653b.sendGTMAddToCartTagRechargeAndBillPayment(cJRCartProduct, context, str, str2);
    }

    public static void a(Context context, String str, String str2, String str3, String str4) {
        k.c(context, "ajrBrowsePlanActivity");
        k.c(str, "eventCategory");
        k.c(str2, "gtmEventRechargesBrowsePlanTabClicked");
        k.c(str3, "mScreenName");
        k.c(str4, "toString");
        f62653b.sendDthCustomEvent(context, str, str2, str3, str4);
    }

    public static void a(String str, Context context, String str2, String str3) {
        k.c(str, "subVertical");
        k.c(context, "context");
        k.c(str2, "serviceType");
        k.c(str3, "eventMessageText");
        f62653b.sendRechargeUtilitiesMessageDisplayedEvent(true, true, str, context, str2, str3);
    }

    public static void a(Context context, String str, String str2, String str3, String str4, String str5) {
        k.c(context, "context");
        k.c(str, "feeCategory");
        k.c(str2, "exploreCollegesClicked");
        k.c(str4, "feeScreenName");
        k.c(str5, "feeVerticalName");
        f62653b.sendNewCustomGTMEvents(context, str, str2, str3, (String) null, (String) null, str4, str5);
    }

    public static void a(String str, Map<String, ? extends Object> map, Context context) {
        k.c(str, AppConstants.NOTIFICATION_DETAILS.EVENT);
        k.c(map, "gaMap");
        k.c(context, "context");
        f62653b.sendCustomEventWithMap(str, map, context);
    }

    public static void a(String str, HashMap<String, Object> hashMap, Context context) {
        k.c(str, AppConstants.NOTIFICATION_DETAILS.EVENT);
        k.c(hashMap, "gaMap");
        k.c(context, "context");
        f62653b.sendCustomEventWithMap(str, hashMap, context);
    }

    public static void a(Context context, String str, String str2, String str3) {
        k.c(context, "activity");
        k.c(str, "gtmRechargeCategory");
        k.c(str2, "gtmEventAddNewAutomaticClicked");
        k.c(str3, "s");
        f62653b.sendEvent(context, str, str2, str3);
    }

    public static void a(CJRGridProduct cJRGridProduct, Context context, String str, String str2) {
        k.c(cJRGridProduct, "mPopUpCoupon");
        k.c(context, "ajrCouponsActivityV8");
        k.c(str, SDKConstants.EVENT_KEY_SCREEN_NAME);
        k.c(str2, "category");
        f62653b.sendGTMRemoveCartTagForCouponsPage(cJRGridProduct, 1, context, str, (Void) null, str2);
    }

    public static void b(CJRGridProduct cJRGridProduct, Context context, String str, String str2) {
        k.c(cJRGridProduct, "mPopUpCoupon");
        k.c(context, "ajrCouponsActivityV8");
        k.c(str, SDKConstants.EVENT_KEY_SCREEN_NAME);
        k.c(str2, "category");
        f62653b.sendGTMAddToCartTagForCouponsPage(cJRGridProduct, 1, context, str, (Void) null, str2);
    }

    public static void a(ArrayList<CJRCartProduct> arrayList, Context context, String str) {
        k.c(str, "category");
        f62653b.sendCheckOutGTMEvent(arrayList, context, 1, str, false);
    }

    public static void a(Context context, String str) {
        k.c(str, "gtM_EVENT_ACTION_BROWSE_PLAN");
        f62653b.sendOpenScreenEvent(context, str);
    }

    public static void a(CJRItem cJRItem, Map<String, Object> map, String str, Context context) {
        k.c(map, Item.CTA_URL_TYPE_MAP);
        k.c(str, "gtM_EVENT_RECHARGE_UTILITY_SCREEN_LOADED");
        f62653b.sendCustomEventWithMapForUtility(cJRItem, map, str, context);
    }

    public static void a(String str, Map<String, Object> map, String str2, Context context) {
        k.c(map, Item.CTA_URL_TYPE_MAP);
        k.c(str2, "gtM_EVENT_RECHARGE_UTILITY_SCREEN_LOADED");
        f62653b.sendCustomEventWithMapForUtility(str, map, str2, context);
    }

    public static void a(FragmentActivity fragmentActivity, String str) {
        k.c(str, "label");
        f62653b.sendGTMRechargeFunnelEvent(fragmentActivity, str);
    }

    public static void a(Context context, CJRGridProduct cJRGridProduct, int i2, String str, String str2) {
        k.c(context, "ajrCouponsActivityV8");
        k.c(cJRGridProduct, "gridProduct");
        k.c(str, "categoryName");
        k.c(str2, SDKConstants.EVENT_KEY_SCREEN_NAME);
        f62653b.sendProductClickInGridForCouponsPage(context, cJRGridProduct, i2, str, str2);
    }

    public static void a(Context context, List<? extends CJRGridProduct> list, String str, String str2, String str3, int i2, String str4, String str5) {
        k.c(context, "context");
        k.c(str, "s");
        k.c(str3, SDKConstants.EVENT_KEY_SCREEN_NAME);
        String str6 = str4;
        k.c(str6, "s1");
        String str7 = str5;
        k.c(str7, "s2");
        f62653b.sendGTMGridEvent(context, list, str, str2, str3, i2, str6, str7, (Void) null);
    }

    public static void b(String str, Context context, String str2, String str3) {
        k.c(str, "verticalLabel");
        k.c(context, "activity");
        k.c(str2, "categoryIdMap");
        f62653b.sendOrderDetails(str, true, context, str2, str3);
    }

    public static void a(Context context, String str, String str2) {
        k.c(str, "gtM_EVENT_CREDIT_CARD_NUMBER_FILED_RE_CLICKED");
        k.c(str2, "s");
        f62653b.sendCreditCardEvent(context, str, str2);
    }

    public static void a(HashMap<String, Object> hashMap, Context context) {
        k.c(hashMap, Item.CTA_URL_TYPE_MAP);
        k.c(context, "context");
        f62653b.sendCustomRechargeEvent(hashMap, context);
    }

    public static void a(Context context, String str, String str2, String str3, String str4, String str5, String str6) {
        k.c(str, "category");
        k.c(str2, "action");
        k.c(str3, "label");
        k.c(str4, "value");
        k.c(str5, SDKConstants.EVENT_KEY_SCREEN_NAME);
        k.c(str6, "verticalId");
        f62653b.sendCustomGTMEvents(context, str, str2, str3, str4, str5, str6);
    }

    public static void a(CJRHomePageItem cJRHomePageItem, Context context, int i2, String str, String str2) {
        k.c(context, "context");
        k.c(str, "pageType");
        k.c(str2, SDKConstants.EVENT_KEY_SCREEN_NAME);
        f62653b.sendPromotionClick(cJRHomePageItem, context, i2, str, str2);
    }

    public static void a(CJROrderSummary cJROrderSummary, y yVar, CJRBaseOrderSummaryActivity cJRBaseOrderSummaryActivity) {
        k.c(yVar, "mPaytmAssistGAEventsData");
        k.c(cJRBaseOrderSummaryActivity, "cjrBaseOrderSummaryActivity");
        f62653b.sendPaytmAssistGAEvents(cJROrderSummary, yVar, cJRBaseOrderSummaryActivity);
    }

    public static void b(Context context, String str, String str2, String str3) {
        k.c(str, "actioN_CREDIT_CARD_ENTER_SIX_DIGIT");
        k.c(str2, "label");
        f62653b.sendCreditCardCustomEvent(context, str, str2, str3);
    }

    public static void a(String str, String str2, String str3, String str4, String str5, ArrayList<String> arrayList, String str6, String str7, String str8) {
        f62653b.sendAppsFlyerPurchaseEvent(str, str2, str3, str4, str5, arrayList, str6, str7, str8);
    }

    public static void a(CJRDetailProduct cJRDetailProduct, DealDetail dealDetail) {
        k.c(cJRDetailProduct, "productDetail");
        k.c(dealDetail, "dealDetail");
        f62653b.sendGTMProductViewTag(cJRDetailProduct, dealDetail, (CJRItem) null);
    }

    public static void c(Context context, String str, String str2, String str3) {
        f62653b.sendImpsCustomEvent(context, str, str2, str3);
    }

    public static void a(CJRHomePageItem cJRHomePageItem, int i2, String str, String str2, Context context, String str3, String str4) {
        k.c(cJRHomePageItem, "product");
        k.c(str, "layoutType");
        k.c(str2, "mchildSiteId");
        k.c(context, "context");
        k.c(str3, "gaKey");
        k.c(str4, "widgetType");
        f62653b.sendImpressionEventForWidgets(cJRHomePageItem, i2, str, str2, context, str3, str4);
    }
}
