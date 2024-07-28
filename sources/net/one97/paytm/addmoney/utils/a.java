package net.one97.paytm.addmoney.utils;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytmmall.clpartifact.utils.CLPConstants;
import java.util.HashMap;
import net.one97.paytm.addmoney.R;
import net.one97.paytm.addmoney.common.model.PaymentDestinationType;
import net.one97.paytm.addmoney.h;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;
import net.one97.paytm.nativesdk.orflow.Utility;
import net.one97.paytm.newaddmoney.view.c;
import org.json.JSONArray;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public Context f48941a;

    /* renamed from: b  reason: collision with root package name */
    private Fragment f48942b;

    public a(Context context, Fragment fragment) {
        this.f48941a = context;
        this.f48942b = fragment;
    }

    public a(Context context) {
        this.f48941a = context;
    }

    public final void a(final h hVar) {
        if (!TextUtils.isEmpty(h.a(this.f48941a.getApplicationContext()).b("sso_token=", "", true))) {
            net.one97.paytm.helper.a.b().a(this.f48941a.getApplicationContext(), (b) new b() {
                public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                    hVar.a(iJRPaytmDataModel);
                }

                public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                    hVar.b(networkCustomError);
                }
            });
        } else if (this.f48941a instanceof Activity) {
            net.one97.paytm.helper.a.b().a((Activity) this.f48941a, (String) null, (Bundle) null);
        }
    }

    public final void a(final h hVar, String str, String str2, int i2, String str3) {
        String str4;
        String str5;
        if (com.paytm.utility.b.c(this.f48941a)) {
            Fragment fragment = this.f48942b;
            if (fragment == null || !(fragment instanceof net.one97.paytm.addmoney.common.view.a)) {
                Fragment fragment2 = this.f48942b;
                if (fragment2 == null || !(fragment2 instanceof c)) {
                    str4 = null;
                } else {
                    str4 = ((c) fragment2).f55891a;
                }
            } else {
                str4 = ((net.one97.paytm.addmoney.common.view.a) fragment).f48506c;
            }
            JSONObject a2 = a(str4, str2, i2);
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", "application/json");
            hashMap.put(AppConstants.SSO_TOKEN, com.paytm.utility.a.q(this.f48941a));
            net.one97.paytm.helper.a.b().k();
            net.one97.paytm.helper.a.b().a(this.f48941a, (String) null, (String) null, (String) null);
            String d2 = net.one97.paytm.helper.a.b().d();
            if (!TextUtils.isEmpty(d2)) {
                hashMap.put("risk_extended_info", d2);
            }
            net.one97.paytm.helper.a.b().k();
            String s = com.paytm.utility.b.s(this.f48941a, net.one97.paytm.helper.a.b().f("cartCheckout"));
            String k = com.paytm.utility.b.k();
            if (Uri.parse(s).getQuery() != null) {
                str5 = s + "&wallet_token=" + str + "&client_id=" + k;
            } else {
                str5 = s + "?wallet_token=" + str + "&client_id=" + k;
            }
            String d3 = com.paytm.utility.b.d(str5 + "&native_withdraw=1", "POST");
            com.paytm.network.b b2 = net.one97.paytm.addmoney.common.a.b();
            b2.f42885i = new CJRRechargePayment();
            b2.f42880d = d3;
            b2.f42884h = a2.toString();
            b2.f42882f = hashMap;
            b2.j = new b() {
                public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                    hVar.a(iJRPaytmDataModel);
                }

                public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                    hVar.b(networkCustomError);
                }
            };
            com.paytm.network.a l = b2.l();
            l.a((Object) str3);
            l.a();
            return;
        }
        hVar.b(new NetworkCustomError(this.f48941a.getString(R.string.check_your_network)));
    }

    public static JSONObject a(String str, String str2, int i2) {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject2 = new JSONObject();
        try {
            if (i2 == PaymentDestinationType.TO_PAYTM_BANK.getNumVal()) {
                jSONObject2.put(CLPConstants.PRODUCT_ID, net.one97.paytm.helper.a.b().f("add_money_ppb_product_id"));
            } else if (i2 == PaymentDestinationType.TO_WALLET.getNumVal()) {
                jSONObject2.put(CLPConstants.PRODUCT_ID, net.one97.paytm.helper.a.b().f("PaytmCashProductId"));
            }
            jSONObject2.put("qty", 1);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("price", Double.parseDouble(str2));
            jSONObject2.put(CLConstants.INPUT_KEY_CONFIGURATION, jSONObject3);
            jSONArray.put(jSONObject2);
            jSONObject.put("cart_items", jSONArray);
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put(Utility.EVENT_CATEGORY_PROMOCODE, str);
            }
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                e2.printStackTrace();
            }
        }
        return jSONObject;
    }
}
