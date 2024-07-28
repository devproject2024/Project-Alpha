package net.one97.paytm.jeweller;

import android.content.Context;
import android.text.TextUtils;
import com.business.merchant_payments.common.utility.AppConstants;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.utility.b;
import com.paytm.utility.q;
import com.paytmmall.clpartifact.utils.GAUtil;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    Context f51036a;

    public a(Context context) {
        this.f51036a = context;
    }

    public static String a(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            String Q = b.Q(str2);
            if (TextUtils.isEmpty(Q)) {
                return null;
            }
            String format = String.format("%.4f", new Object[]{Double.valueOf(Double.valueOf(Q).doubleValue() / Double.valueOf(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().k.getmGoldPortfolio().getGoldBuyPrice()).doubleValue())});
            jSONObject.put("type", "quantity");
            jSONObject.put("quantity", format);
            jSONObject.put("amount", Q);
            jSONObject.put("src_message", str);
            return jSONObject.toString();
        } catch (JSONException e2) {
            q.d(String.valueOf(e2));
        }
    }

    public static Map<String, String> a(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        hashMap.put("ssotoken", com.paytm.utility.a.q(context));
        hashMap.put(AppConstants.SSO_TOKEN, com.paytm.utility.a.q(context));
        return hashMap;
    }

    public static String b(Context context) {
        return net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(context, "jewellerPortfolioURL");
    }

    public static void a(Context context, String str, String str2, String str3, String str4, String str5, String str6) {
        HashMap hashMap = new HashMap();
        hashMap.put(AppConstants.NOTIFICATION_DETAILS.EVENT, GAUtil.CUSTOM_EVENT);
        hashMap.put("user_id", b.n(context));
        hashMap.put("vertical_name", "digital_gold");
        hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, str);
        hashMap.put("event_category", str2);
        if (str3 != null) {
            hashMap.put("event_action", str3);
        }
        if (str4 != null) {
            hashMap.put("event_label", str4);
        }
        if (str5 != null) {
            hashMap.put("event_label2", str5);
        }
        if (str6 != null) {
            hashMap.put("event_label3", str6);
        }
        try {
            net.one97.paytm.wallet.communicator.b.a().sendCustomGTMEvent(context, GAUtil.CUSTOM_EVENT, hashMap);
        } catch (Exception e2) {
            q.d(String.valueOf(e2));
        }
    }

    public static void a(Context context, String str) {
        net.one97.paytm.wallet.communicator.b.a().sendGTMOpenScreenWithDeviceInfo(context, str, "digital_gold");
    }
}
