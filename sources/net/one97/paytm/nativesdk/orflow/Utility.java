package net.one97.paytm.nativesdk.orflow;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.MerchantBL;
import net.one97.paytm.nativesdk.Utils.LogUtility;
import net.one97.paytm.nativesdk.common.model.Body;
import net.one97.paytm.nativesdk.common.model.CJPayMethodResponse;
import net.one97.paytm.nativesdk.common.model.MerchantPayOption;
import net.one97.paytm.nativesdk.common.model.PaymentIntent;
import net.one97.paytm.nativesdk.common.model.PaymentModes;
import net.one97.paytm.nativesdk.orflow.promo.PromoHelper;

public final class Utility {
    public static final String ACTION_APPLY_ANOTHER_OFFER = "apply_another_offer_click";
    public static final String ACTION_APPLY_CLICKED = "apply_clicked";
    public static final String ACTION_APPLY_OFFER_CLICK = "apply_offer_clicked";
    public static final String ACTION_OFFERDETAIL_CLICKED = "offer_details_clicked";
    public static final String ACTION_OFFERDETAIL_LOADED = "offer_details_loaded";
    public static final String ACTION_OTHER_PAY_OPTION_CLICK = "use_other_payment_options_clicked";
    public static final String ACTION_PAYMENT_REJECTED_POPUP = "payment_rejected_popup_load";
    public static final String ACTION_PROMOCODE_CLICKED = "enter_promocode_clicked";
    public static final String ACTION_PROMOCODE_ENTERED = "promocode_entered";
    public static final String ACTION_RETRY_PAYMENT_CLICK = "retry_payment_clicked";
    public static final String ACTION_SAVEDINSTRUMENT_LOADED = "saved_instrument_loaded";
    public static final String EVENT_CATEGORY_BANKOFFER = "bank_offer";
    public static final String EVENT_CATEGORY_PROMOCODE = "promocode";
    public static final Utility INSTANCE = new Utility();
    public static final String PROMO_SCREEN_NAME = "central_have_a_promocode";
    public static final String VERTICAL_NAME_MALL = "mall";

    private Utility() {
    }

    public final boolean shouldShowNBOnlySheet(CJPayMethodResponse cJPayMethodResponse) {
        Body body;
        MerchantPayOption merchantPayOption;
        ArrayList<PaymentModes> paymentModes;
        if (!(cJPayMethodResponse == null || (body = cJPayMethodResponse.getBody()) == null || (merchantPayOption = body.getMerchantPayOption()) == null || (paymentModes = merchantPayOption.getPaymentModes()) == null)) {
            Iterator<PaymentModes> it2 = paymentModes.iterator();
            if (it2.hasNext()) {
                PaymentModes next = it2.next();
                k.a((Object) next, "item");
                if (p.a("NET_BANKING", next.getPaymentMode(), true) && next.getPayChannelOptions().size() != 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public final float getDensity(Activity activity) {
        k.c(activity, "activity");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.density;
    }

    public final void sendBankOffersEvent(Context context, Map<String, ? extends Object> map) {
        k.c(map, "eventmap");
        PromoHelper.Companion.getInstance().performGAOperation(context, map);
        LogUtility.d("GA Event:: ", convertToStringEvent(map));
    }

    private final String convertToStringEvent(Map<String, ? extends Object> map) {
        String str = "";
        try {
            for (Map.Entry next : map.entrySet()) {
                str = str + ((String) next.getKey()) + " " + next.getValue();
            }
        } catch (Exception e2) {
            LogUtility.printStackTrace(e2);
        }
        return str;
    }

    public final Map<String, Object> getBankOfferEventParams(String str, String str2, String str3, String str4) {
        k.c(str, "eventCategory");
        k.c(str2, "eventAction");
        k.c(str3, "eventLabel");
        k.c(str4, "eventLabel2");
        Map<String, Object> hashMap = new HashMap<>();
        hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, PROMO_SCREEN_NAME);
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("event_category", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("event_action", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put("event_label", str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            hashMap.put("event_label2", str4);
        }
        return hashMap;
    }

    public final Map<String, Object> getBankOfferEventParams(String str, String str2, String str3, String str4, String str5, String str6) {
        k.c(str, "eventCategory");
        k.c(str2, "eventAction");
        k.c(str3, "eventLabel");
        k.c(str4, "eventLabel2");
        k.c(str5, "eventLabel3");
        k.c(str6, "eventLabel4");
        Map<String, Object> hashMap = new HashMap<>();
        hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, PROMO_SCREEN_NAME);
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("event_category", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("event_action", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put("event_label", str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            hashMap.put("event_label2", str4);
        }
        if (!TextUtils.isEmpty(str5)) {
            hashMap.put("event_label3", str5);
        }
        if (!TextUtils.isEmpty(str6)) {
            hashMap.put(SDKConstants.EVENT_KEY_EVENT_LABEL4, str6);
        }
        return hashMap;
    }

    public final void updateTxnAmountPaymentIntent() {
        ArrayList<PaymentIntent> paymentIntent = PromoHelper.Companion.getInstance().getPaymentIntent();
        if (paymentIntent != null) {
            try {
                if (paymentIntent.size() > 0) {
                    PaymentIntent paymentIntent2 = paymentIntent.get(0);
                    k.a((Object) paymentIntent2, "paymentIntent[0]");
                    MerchantBL merchantInstance = MerchantBL.getMerchantInstance();
                    k.a((Object) merchantInstance, "MerchantBL.getMerchantInstance()");
                    paymentIntent2.setTxnAmount(Double.parseDouble(merchantInstance.getAmount()));
                }
            } catch (Exception e2) {
                LogUtility.printStackTrace(e2);
            }
        }
    }
}
