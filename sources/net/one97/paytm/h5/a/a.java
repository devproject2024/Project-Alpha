package net.one97.paytm.h5.a;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.business.merchant_payments.common.utility.AppConstants;
import com.paytm.network.model.NetworkCustomError;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import kotlin.g.b.k;
import kotlin.m.l;
import net.one97.paytm.common.entity.CJRRechargeCart;
import net.one97.paytm.common.entity.shopping.CJRCart;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.phoenix.PhoenixManager;
import net.one97.paytm.phoenix.api.H5Event;
import net.one97.paytm.phoenix.api.b;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

public final class a extends net.one97.paytm.phoenix.core.a implements net.one97.paytm.recharge.d.a {

    /* renamed from: a  reason: collision with root package name */
    public static final C0253a f16787a = new C0253a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private static H5Event f16788b;

    public a() {
        super("paytmOpenPromoSDK");
    }

    /* renamed from: net.one97.paytm.h5.a.a$a  reason: collision with other inner class name */
    public static final class C0253a {
        private C0253a() {
        }

        public /* synthetic */ C0253a(byte b2) {
            this();
        }
    }

    public final boolean a(H5Event h5Event, b bVar) {
        String bridgeName;
        k.c(h5Event, AppConstants.NOTIFICATION_DETAILS.EVENT);
        k.c(bVar, "bridgeContext");
        super.a(h5Event, bVar);
        b(h5Event, bVar);
        f16788b = h5Event;
        Object activity = h5Event.getActivity();
        if (activity != null && (bridgeName = h5Event.getBridgeName()) != null && bridgeName.hashCode() == -2074597162 && bridgeName.equals("paytmOpenPromoSDK")) {
            Class<?> cls = Class.forName("net.one97.paytm.recharge.e");
            k.a((Object) cls, "Class.forName(\"net.one97….recharge.H5PromoHelper\")");
            Object newInstance = cls.newInstance();
            Method declaredMethod = cls.getDeclaredMethod("initHelper", new Class[]{Context.class, JSONObject.class, String.class, net.one97.paytm.recharge.d.a.class});
            k.a((Object) declaredMethod, "h5PromoHelper.getDeclare…backListener::class.java)");
            JSONObject params = h5Event.getParams();
            Object obj = null;
            Object obj2 = params != null ? params.get("data") : null;
            if (obj2 instanceof JSONObject) {
                obj = obj2;
            }
            JSONObject jSONObject = (JSONObject) obj;
            if (jSONObject == null || !jSONObject.has("removePromo") || !jSONObject.getBoolean("removePromo")) {
                PhoenixManager.addSubscribeBridges(kotlin.a.k.c("paytmOpenPromoSDKSubscription"));
                if (params != null && params.has("data")) {
                    declaredMethod.invoke(newInstance, new Object[]{activity, params.getJSONObject("data"), "", this});
                }
            } else {
                PhoenixManager.removeSubScribeBridges("paytmOpenPromoSDKSubscription");
                Method declaredMethod2 = cls.getDeclaredMethod("clearExistingPromoCode", new Class[0]);
                k.a((Object) declaredMethod2, "h5PromoHelper.getDeclare…LEAR_EXISTING_PROMO_CODE)");
                declaredMethod2.invoke(newInstance, new Object[0]);
                return true;
            }
        }
        return true;
    }

    public final void a(String str, String str2, boolean z, String str3, CJRRechargeCart cJRRechargeCart) {
        k.c(cJRRechargeCart, "rechargeCart");
        JSONObject jSONObject = new JSONObject();
        if (str == null) {
            str = "";
        }
        jSONObject.put("promo", str);
        if (str2 == null) {
            str2 = "";
        }
        jSONObject.put("tnc", str2);
        CJRCart cart = cJRRechargeCart.getCart();
        k.a((Object) cart, "rechargeCart.cart");
        if (!TextUtils.isEmpty(cart.getAggregatePGConvFee())) {
            CJRCart cart2 = cJRRechargeCart.getCart();
            k.a((Object) cart2, "rechargeCart.cart");
            if (a(cart2.getAggregatePGConvFee()) > 0.0d) {
                CJRCart cart3 = cJRRechargeCart.getCart();
                k.a((Object) cart3, "rechargeCart.cart");
                jSONObject.put("aggregate_pg_conv_fee", cart3.getAggregatePGConvFee());
            }
        }
        if (z) {
            jSONObject.put(SDKConstants.IS_BANK_OFFER, z);
            if (str3 == null) {
                str3 = "";
            }
            jSONObject.put("payment_intent", str3);
        }
        CJRCart cart4 = cJRRechargeCart.getCart();
        k.a((Object) cart4, "rechargeCart.cart");
        jSONObject.put("final_price", cart4.getFinalPrice());
        H5Event h5Event = f16788b;
        if (h5Event != null) {
            if (h5Event == null) {
                k.a();
            }
            net.one97.paytm.phoenix.core.a.a(this, h5Event, jSONObject, false, 4);
        }
    }

    private static double a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return -1.0d;
            }
            if (str == null) {
                k.a();
            }
            CharSequence replace = new l("[₹, ]").replace((CharSequence) str, "");
            int length = replace.length() - 1;
            int i2 = 0;
            boolean z = false;
            while (i2 <= length) {
                boolean z2 = replace.charAt(!z ? i2 : length) <= ' ';
                if (z) {
                    if (!z2) {
                        break;
                    }
                    length--;
                } else if (!z2) {
                    z = true;
                } else {
                    i2++;
                }
            }
            return new BigDecimal(new l("\\.0*$").replace((CharSequence) new l("^\\s+").replace((CharSequence) replace.subSequence(i2, length + 1).toString(), ""), "")).doubleValue();
        } catch (Exception unused) {
            return -1.0d;
        }
    }

    public final void a(CJRRechargeCart cJRRechargeCart) {
        k.c(cJRRechargeCart, "rechargeCart");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("isPromoNeedToBeRemoved", true);
        H5Event h5Event = f16788b;
        Activity activity = null;
        if ((h5Event != null ? h5Event.getActivity() : null) != null) {
            H5Event h5Event2 = f16788b;
            if (h5Event2 != null) {
                activity = h5Event2.getActivity();
            }
            if (activity == null) {
                k.a();
            }
            PhoenixManager.sendDataOnSubscribeEvent("paytmOpenPromoSDKSubscription", jSONObject, activity);
        }
    }

    public final void a(NetworkCustomError networkCustomError) {
        k.c(networkCustomError, "error");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(CLConstants.FIELD_ERROR_CODE, networkCustomError.getStatusCode());
        jSONObject.put(ImagePickerUtils.IMAGE_PICKER_KEY_ERROR_MESSAGE, networkCustomError.getAlertMessage());
        H5Event h5Event = f16788b;
        Activity activity = null;
        if ((h5Event != null ? h5Event.getActivity() : null) != null) {
            H5Event h5Event2 = f16788b;
            if (h5Event2 != null) {
                activity = h5Event2.getActivity();
            }
            if (activity == null) {
                k.a();
            }
            PhoenixManager.sendDataOnSubscribeEvent("paytmOpenPromoSDKSubscription", jSONObject, activity);
        }
    }
}
