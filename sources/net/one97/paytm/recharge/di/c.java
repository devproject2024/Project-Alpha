package net.one97.paytm.recharge.di;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.common.entity.shopping.CJRCartProduct;
import net.one97.paytm.common.entity.shopping.CJRDetailProduct;
import net.one97.paytm.common.entity.shopping.CJRGridProduct;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.common.entity.shopping.CJROrderSummary;
import net.one97.paytm.recharge.coupons.activity.DealDetail;
import net.one97.paytm.recharge.ordersummary.activity.CJRBaseOrderSummaryActivity;
import net.one97.paytm.y;

public interface c {
    void sendAppsFlyerPurchaseEvent(String str, String str2, String str3, String str4, String str5, ArrayList<String> arrayList, String str6, String str7, String str8);

    void sendCheckOutGTMEvent(ArrayList<CJRCartProduct> arrayList, Context context, int i2, String str, boolean z);

    void sendCreditCardCustomEvent(Context context, String str, String str2, String str3);

    void sendCreditCardEvent(Context context, String str, String str2);

    void sendCustomEventWithMap(String str, HashMap<String, Object> hashMap, Context context);

    void sendCustomEventWithMap(String str, Map<String, ? extends Object> map, Context context);

    void sendCustomEventWithMapForUtility(String str, Map<String, Object> map, String str2, Context context);

    void sendCustomEventWithMapForUtility(CJRItem cJRItem, Map<String, Object> map, String str, Context context);

    void sendCustomEventWithMapForUtility(CJRItem cJRItem, Map<String, Object> map, String str, FragmentActivity fragmentActivity);

    void sendCustomGTMEvents(Context context, String str, String str2, String str3, String str4, String str5, String str6);

    void sendCustomRechargeEvent(HashMap<String, Object> hashMap, Context context);

    void sendDthCustomEvent(Context context, String str, String str2, String str3, String str4);

    void sendEvent(Context context, String str, String str2, String str3);

    void sendGTMAddToCartTagForCouponsPage(CJRGridProduct cJRGridProduct, int i2, Context context, String str, Void voidR, String str2);

    void sendGTMAddToCartTagRechargeAndBillPayment(CJRCartProduct cJRCartProduct, Context context, String str, String str2);

    void sendGTMGridEvent(Context context, List<? extends CJRGridProduct> list, String str, String str2, String str3, int i2, String str4, String str5, Void voidR);

    void sendGTMProductViewTag(CJRDetailProduct cJRDetailProduct, DealDetail dealDetail, CJRItem cJRItem);

    void sendGTMRechargeFunnelEvent(FragmentActivity fragmentActivity, String str);

    void sendGTMRemoveCartTagForCouponsPage(CJRGridProduct cJRGridProduct, int i2, Context context, String str, Void voidR, String str2);

    void sendImpressionEventForWidgets(CJRHomePageItem cJRHomePageItem, int i2, String str, String str2, Context context, String str3, String str4);

    void sendImpsCustomEvent(Context context, String str, String str2, String str3);

    void sendNewCustomGTMEvents(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7);

    void sendOpenScreenEvent(Context context, String str);

    void sendOrderDetails(String str, boolean z, Context context, String str2, String str3);

    void sendPaytmAssistGAEvents(CJROrderSummary cJROrderSummary, y yVar, CJRBaseOrderSummaryActivity cJRBaseOrderSummaryActivity);

    void sendProductClickInGridForCouponsPage(Context context, CJRGridProduct cJRGridProduct, int i2, String str, String str2);

    void sendPromotionClick(CJRHomePageItem cJRHomePageItem, Context context, int i2, String str, String str2);

    void sendRechargeUtilitiesMessageDisplayedEvent(boolean z, boolean z2, String str, Context context, String str2, String str3);
}
