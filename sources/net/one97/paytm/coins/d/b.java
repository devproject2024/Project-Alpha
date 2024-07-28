package net.one97.paytm.coins.d;

import android.text.TextUtils;
import androidx.lifecycle.ai;
import androidx.lifecycle.y;
import com.google.gson.f;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytmmall.clpartifact.utils.CLPConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.coins.customview.SlideButton;
import net.one97.paytm.coins.model.BalanceModel;
import net.one97.paytm.coins.model.CheckBalanceApiModel;
import net.one97.paytm.coins.model.CheckoutModel;
import net.one97.paytm.coins.model.CollectModel;
import net.one97.paytm.coins.model.PgResponseModel;
import net.one97.paytm.coins.model.Reward;
import net.one97.paytm.coins.model.RewardsModel;
import net.one97.paytm.vipcashback.f.d;
import org.json.JSONArray;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

public final class b extends ai {

    /* renamed from: a  reason: collision with root package name */
    public y<ArrayList<Reward>> f16765a = new y<>();

    /* renamed from: b  reason: collision with root package name */
    public y<CollectModel> f16766b = new y<>();

    /* renamed from: c  reason: collision with root package name */
    public y<Boolean> f16767c = new y<>();

    /* renamed from: d  reason: collision with root package name */
    public y<NetworkCustomError> f16768d = new y<>();

    /* renamed from: e  reason: collision with root package name */
    public String f16769e;

    /* renamed from: f  reason: collision with root package name */
    public String f16770f;

    public static final class c implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f16776a;

        public c(b bVar) {
            this.f16776a = bVar;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            if (iJRPaytmDataModel == null) {
                this.f16776a.f16767c.postValue(Boolean.TRUE);
            } else if (iJRPaytmDataModel instanceof RewardsModel) {
                RewardsModel rewardsModel = (RewardsModel) iJRPaytmDataModel;
                if (rewardsModel.getGrid_layout() != null) {
                    ArrayList<Reward> grid_layout = rewardsModel.getGrid_layout();
                    if (grid_layout == null) {
                        k.a();
                    }
                    if (grid_layout.size() > 0) {
                        this.f16776a.f16765a.postValue(rewardsModel.getGrid_layout());
                        return;
                    }
                }
                this.f16776a.f16767c.postValue(Boolean.TRUE);
            }
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            k.c(iJRPaytmDataModel, "p1");
            k.c(networkCustomError, "error");
            this.f16776a.f16768d.postValue(networkCustomError);
        }
    }

    public final HashMap<String, String> a(String str) {
        HashMap<String, String> appCommonHeaders = net.one97.paytm.vipcashback.c.a.b().getAppCommonHeaders();
        if (appCommonHeaders == null) {
            appCommonHeaders = new HashMap<>();
        }
        appCommonHeaders.put("Content-Type", "application/json");
        net.one97.paytm.vipcashback.c.b b2 = net.one97.paytm.vipcashback.c.a.b();
        k.a((Object) b2, "CashbackHelper.getImplListener()");
        appCommonHeaders.put("ssotoken", b2.getSSOToken());
        if (a()) {
            appCommonHeaders.putAll(c(str));
        }
        return appCommonHeaders;
    }

    public static final class a implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f16771a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f16772b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ SlideButton f16773c;

        public a(b bVar, int i2, SlideButton slideButton) {
            this.f16771a = bVar;
            this.f16772b = i2;
            this.f16773c = slideButton;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            if (iJRPaytmDataModel == null) {
                this.f16773c.a();
                this.f16771a.f16767c.postValue(Boolean.TRUE);
            } else if (iJRPaytmDataModel instanceof CheckoutModel) {
                b bVar = this.f16771a;
                CheckoutModel checkoutModel = (CheckoutModel) iJRPaytmDataModel;
                SlideButton slideButton = this.f16773c;
                k.c(checkoutModel, "model");
                k.c(slideButton, "sliderButton");
                String pgUrlToHit = checkoutModel.getPgUrlToHit();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("orderId", checkoutModel.getORDER_ID());
                jSONObject.put("paymentPayload", new JSONObject(new f().b(checkoutModel.getPaymentPayload())));
                d.a aVar = d.f20859a;
                com.paytm.network.b b2 = d.a.c().a(a.C0715a.POST).a(pgUrlToHit).b(jSONObject.toString());
                HashMap<String, String> appCommonHeaders = net.one97.paytm.vipcashback.c.a.b().getAppCommonHeaders();
                if (appCommonHeaders == null) {
                    appCommonHeaders = new HashMap<>();
                }
                appCommonHeaders.put("Content-Type", "application/json");
                net.one97.paytm.vipcashback.c.b b3 = net.one97.paytm.vipcashback.c.a.b();
                k.a((Object) b3, "CashbackHelper.getImplListener()");
                appCommonHeaders.put(AppConstants.SSO_TOKEN, b3.getSSOToken());
                b2.a((Map<String, String>) appCommonHeaders).a((IJRPaytmDataModel) new CollectModel((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (PgResponseModel) null, 127, (g) null)).a(a.c.CASHBACK).a(a.b.USER_FACING).c("PaytmCoinLandingActivity").a((com.paytm.network.listener.b) new C0249b(bVar, slideButton)).l().a();
            }
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            k.c(iJRPaytmDataModel, "p1");
            k.c(networkCustomError, "error");
            this.f16773c.a();
            this.f16771a.f16768d.postValue(networkCustomError);
        }
    }

    public static String b(String str) {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("mode", "LOYALTY_POINT");
        jSONArray.put(jSONObject2);
        jSONObject.put("payment_intent", jSONArray);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("qty", 1);
        jSONObject3.put(CLPConstants.PRODUCT_ID, str);
        JSONObject jSONObject4 = new JSONObject();
        jSONObject4.put("pointsOrderSummary", "GV");
        jSONObject3.put(CLConstants.INPUT_KEY_CONFIGURATION, jSONObject4);
        JSONArray jSONArray2 = new JSONArray();
        jSONArray2.put(jSONObject3);
        jSONObject.put("cart_items", jSONArray2);
        String jSONObject5 = jSONObject.toString();
        k.a((Object) jSONObject5, "_rootObject.toString()");
        return jSONObject5;
    }

    /* renamed from: net.one97.paytm.coins.d.b$b  reason: collision with other inner class name */
    public static final class C0249b implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f16774a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ SlideButton f16775b;

        C0249b(b bVar, SlideButton slideButton) {
            this.f16774a = bVar;
            this.f16775b = slideButton;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            if (iJRPaytmDataModel == null) {
                this.f16775b.a();
                this.f16774a.f16767c.postValue(Boolean.TRUE);
            } else if (iJRPaytmDataModel instanceof CollectModel) {
                this.f16775b.a();
                this.f16774a.f16766b.postValue(iJRPaytmDataModel);
            }
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            k.c(iJRPaytmDataModel, "p1");
            k.c(networkCustomError, "error");
            this.f16775b.a();
            this.f16774a.f16768d.postValue(networkCustomError);
        }
    }

    public final void a(com.paytm.network.listener.b bVar) {
        String str;
        k.c(bVar, "listner");
        if (a()) {
            k.a((Object) net.one97.paytm.vipcashback.f.f.a(), "GTMHelper.getInstance()");
            str = net.one97.paytm.vipcashback.f.f.A();
        } else {
            k.a((Object) net.one97.paytm.vipcashback.f.f.a(), "GTMHelper.getInstance()");
            str = net.one97.paytm.vipcashback.f.f.z();
        }
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("body", new JSONObject());
        jSONObject.put("request", jSONObject2);
        d.a aVar = d.f20859a;
        d.a.c().a(a.C0715a.POST).a(str).b(jSONObject.toString()).a((Map<String, String>) a("checkbalanceType")).a((IJRPaytmDataModel) new CheckBalanceApiModel((BalanceModel) null, 1, (g) null)).a(a.c.CASHBACK).a(a.b.USER_FACING).c("PaytmCoinLandingActivity").a(bVar).l().a();
    }

    public final boolean a() {
        return !TextUtils.isEmpty(this.f16769e) && "merchant".equals(this.f16769e) && !TextUtils.isEmpty(this.f16770f);
    }

    public final HashMap<String, String> c(String str) {
        k.c(str, "type");
        HashMap<String, String> hashMap = new HashMap<>();
        if (a()) {
            hashMap.put("x-auth-ump", "umpapp-3754-36d-aqr-cn7");
            net.one97.paytm.vipcashback.c.b b2 = net.one97.paytm.vipcashback.c.a.b();
            k.a((Object) b2, "CashbackHelper.getImplListener()");
            hashMap.put("x-user-token", b2.getSSOToken());
            String str2 = this.f16770f;
            if (str2 != null) {
                if (str.equals("checkoutType")) {
                    hashMap.put("X-USER-PGMID", str2);
                }
                if (str.equals("checkbalanceType")) {
                    hashMap.put("x-user-mid", str2);
                }
            }
            net.one97.paytm.vipcashback.c.b b3 = net.one97.paytm.vipcashback.c.a.b();
            k.a((Object) b3, "CashbackHelper.getImplListener()");
            hashMap.put("x-user-id", net.one97.paytm.vipcashback.c.a.b().getUserId(b3.getApplicationContext()));
        }
        return hashMap;
    }
}
