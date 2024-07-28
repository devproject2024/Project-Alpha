package net.one97.paytm.recharge;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.business.merchant_payments.common.utility.AppConstants;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.k;
import net.one97.paytm.app.CJRJarvisApplication;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.common.entity.shopping.CJRCartProduct;
import net.one97.paytm.common.entity.shopping.CJRDetailProduct;
import net.one97.paytm.common.entity.shopping.CJRGridProduct;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.common.entity.shopping.CJROrderSummary;
import net.one97.paytm.j.a;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.recharge.coupons.activity.DealDetail;
import net.one97.paytm.recharge.di.c;
import net.one97.paytm.recharge.ordersummary.activity.CJRBaseOrderSummaryActivity;
import net.one97.paytm.utils.v;
import net.one97.paytm.y;

public final class h implements c {
    public final void sendCustomEventWithMap(String str, Map<String, ? extends Object> map, Context context) {
        k.c(str, AppConstants.NOTIFICATION_DETAILS.EVENT);
        k.c(map, "gaMap");
        k.c(context, "context");
        a.b(str, (Map<String, Object>) map, context);
    }

    public final void sendCustomEventWithMap(String str, HashMap<String, Object> hashMap, Context context) {
        k.c(str, AppConstants.NOTIFICATION_DETAILS.EVENT);
        k.c(hashMap, "gaMap");
        k.c(context, "context");
        a.b(str, (Map<String, Object>) hashMap, context);
    }

    public final void sendEvent(Context context, String str, String str2, String str3) {
        k.c(context, "activity");
        k.c(str, "gtmRechargeCategory");
        k.c(str2, "gtmEventAddNewAutomaticClicked");
        k.c(str3, "s");
        a.c(context, str, str2, str3);
    }

    public final void sendGTMRemoveCartTagForCouponsPage(CJRGridProduct cJRGridProduct, int i2, Context context, String str, Void voidR, String str2) {
        k.c(cJRGridProduct, "mPopUpCoupon");
        k.c(context, "ajrCouponsActivityV8");
        k.c(str, SDKConstants.EVENT_KEY_SCREEN_NAME);
        k.c(str2, "category");
        a.a(cJRGridProduct, i2, str, (CJRItem) voidR, str2);
    }

    public final void sendGTMAddToCartTagForCouponsPage(CJRGridProduct cJRGridProduct, int i2, Context context, String str, Void voidR, String str2) {
        k.c(cJRGridProduct, "mPopUpCoupon");
        k.c(context, "ajrCouponsActivityV8");
        k.c(str, SDKConstants.EVENT_KEY_SCREEN_NAME);
        k.c(str2, "category");
        a.a(cJRGridProduct, i2, context, str, (CJRItem) voidR, str2);
    }

    public final void sendCheckOutGTMEvent(ArrayList<CJRCartProduct> arrayList, Context context, int i2, String str, boolean z) {
        k.c(str, "category");
        a.a(arrayList, context, i2, str, z);
    }

    public final void sendOpenScreenEvent(Context context, String str) {
        k.c(str, "gtM_EVENT_ACTION_BROWSE_PLAN");
        a.b(context, str);
    }

    public final void sendCustomEventWithMapForUtility(CJRItem cJRItem, Map<String, Object> map, String str, Context context) {
        k.c(map, Item.CTA_URL_TYPE_MAP);
        k.c(str, "gtM_EVENT_RECHARGE_UTILITY_SCREEN_LOADED");
        a.a(cJRItem, map, str, context);
    }

    public final void sendCustomEventWithMapForUtility(String str, Map<String, Object> map, String str2, Context context) {
        k.c(map, Item.CTA_URL_TYPE_MAP);
        k.c(str2, "gtM_EVENT_RECHARGE_UTILITY_SCREEN_LOADED");
        a.a(str, map, str2, context);
    }

    public final void sendGTMRechargeFunnelEvent(FragmentActivity fragmentActivity, String str) {
        k.c(str, "label");
        a.a((Context) fragmentActivity, str);
    }

    public final void sendProductClickInGridForCouponsPage(Context context, CJRGridProduct cJRGridProduct, int i2, String str, String str2) {
        k.c(context, "ajrCouponsActivityV8");
        k.c(cJRGridProduct, "gridProduct");
        k.c(str, "categoryName");
        k.c(str2, SDKConstants.EVENT_KEY_SCREEN_NAME);
        a.a(context, cJRGridProduct, i2, str, str2);
    }

    public final void sendGTMGridEvent(Context context, List<? extends CJRGridProduct> list, String str, String str2, String str3, int i2, String str4, String str5, Void voidR) {
        k.c(context, "context");
        k.c(str, "s");
        k.c(str3, SDKConstants.EVENT_KEY_SCREEN_NAME);
        String str6 = str4;
        k.c(str6, "s1");
        String str7 = str5;
        k.c(str7, "s2");
        a.a(context, (List<CJRGridProduct>) list, str, str2, str3, i2, str6, str7, (Map<String, Object>) (Map) voidR);
    }

    public final void sendOrderDetails(String str, boolean z, Context context, String str2, String str3) {
        k.c(str, "verticalLabel");
        k.c(context, "activity");
        k.c(str2, "categoryIdMap");
        a.a(str, z, context, str2, str3);
    }

    public final void sendCreditCardEvent(Context context, String str, String str2) {
        k.c(str, "gtM_EVENT_CREDIT_CARD_NUMBER_FILED_RE_CLICKED");
        k.c(str2, "s");
        a.a(context, str, str2);
    }

    public final void sendCustomRechargeEvent(HashMap<String, Object> hashMap, Context context) {
        k.c(hashMap, Item.CTA_URL_TYPE_MAP);
        k.c(context, "context");
        a.b((Map<String, Object>) hashMap, context);
    }

    public final void sendCustomGTMEvents(Context context, String str, String str2, String str3, String str4, String str5, String str6) {
        k.c(str, "category");
        k.c(str2, "action");
        k.c(str3, "label");
        k.c(str4, "value");
        k.c(str5, SDKConstants.EVENT_KEY_SCREEN_NAME);
        k.c(str6, "verticalId");
        a.a(context, str, str2, str3, str4, str5, str6);
    }

    public final void sendPromotionClick(CJRHomePageItem cJRHomePageItem, Context context, int i2, String str, String str2) {
        k.c(context, "cjrBaseOrderSummaryActivity");
        k.c(str, "s");
        k.c(str2, "s1");
        a.e(cJRHomePageItem, context, i2, str2);
    }

    public final void sendPaytmAssistGAEvents(CJROrderSummary cJROrderSummary, y yVar, CJRBaseOrderSummaryActivity cJRBaseOrderSummaryActivity) {
        k.c(yVar, "mPaytmAssistGAEventsData");
        k.c(cJRBaseOrderSummaryActivity, "cjrBaseOrderSummaryActivity");
        a.a(cJROrderSummary, yVar, (Context) cJRBaseOrderSummaryActivity);
    }

    public final void sendCreditCardCustomEvent(Context context, String str, String str2, String str3) {
        k.c(str, "actioN_CREDIT_CARD_ENTER_SIX_DIGIT");
        k.c(str2, "label");
        a.b(context, str, str2, str3);
    }

    public final void sendCustomEventWithMapForUtility(CJRItem cJRItem, Map<String, Object> map, String str, FragmentActivity fragmentActivity) {
        k.c(map, Item.CTA_URL_TYPE_MAP);
        k.c(str, "gtM_EVENT_RECHARGE_UTILITY_SCREEN_LOADED");
        a.a(cJRItem, map, str, (Context) fragmentActivity);
    }

    public final void sendGTMAddToCartTagRechargeAndBillPayment(CJRCartProduct cJRCartProduct, Context context, String str, String str2) {
        k.c(context, "mBaseActivity");
        k.c(str2, "gtM_KEY_SCREEN_CART_SCREEN");
        a.a(cJRCartProduct, context, str2);
    }

    public final void sendDthCustomEvent(Context context, String str, String str2, String str3, String str4) {
        k.c(context, "ajrBrowsePlanActivity");
        k.c(str, "eventCategory");
        k.c(str2, "gtmEventRechargesBrowsePlanTabClicked");
        k.c(str3, "mScreenName");
        k.c(str4, "toString");
        a.a(context, str, str2, str3, str4);
    }

    public final void sendRechargeUtilitiesMessageDisplayedEvent(boolean z, boolean z2, String str, Context context, String str2, String str3) {
        k.c(str, "subVertical");
        k.c(context, "context");
        k.c(str2, "serviceType");
        k.c(str3, "eventMessageText");
        a.a(z, z2, str, context, str2, str3);
    }

    public final void sendGTMProductViewTag(CJRDetailProduct cJRDetailProduct, DealDetail dealDetail, CJRItem cJRItem) {
        k.c(cJRDetailProduct, "productDetail");
        k.c(dealDetail, "dealDetail");
        a.a(cJRDetailProduct, (Context) dealDetail, cJRItem);
    }

    public final void sendNewCustomGTMEvents(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        k.c(context, "context");
        k.c(str, "feeCategory");
        k.c(str2, "exploreCollegesClicked");
        k.c(str6, "feeScreenName");
        k.c(str7, "feeVerticalName");
        a.a(context, str, str2, str3, str4, str5, str6, str7);
    }

    public final void sendAppsFlyerPurchaseEvent(String str, String str2, String str3, String str4, String str5, ArrayList<String> arrayList, String str6, String str7, String str8) {
        v.f69802a.a(CJRJarvisApplication.getAppContext(), str, str2, str3, str4, str5, arrayList, str6, str7, str8);
    }

    public final void sendImpsCustomEvent(Context context, String str, String str2, String str3) {
        a.a(context, str, str2, str3);
    }

    public final void sendImpressionEventForWidgets(CJRHomePageItem cJRHomePageItem, int i2, String str, String str2, Context context, String str3, String str4) {
        k.c(cJRHomePageItem, "product");
        k.c(str, "layoutType");
        k.c(str2, "mchildSiteId");
        k.c(context, "context");
        k.c(str3, "gaKey");
        k.c(str4, "widgetType");
        a.a(cJRHomePageItem, i2, context, str3, str4);
    }
}
