package net.one97.paytm.o2o.movies.moviepass.f;

import android.text.TextUtils;
import com.business.merchant_payments.common.utility.AppConstants;
import com.google.gsonhtcfix.f;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.network.model.NetworkCustomVolleyError;
import com.paytm.utility.v;
import com.paytmmall.clpartifact.utils.CLPConstants;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.common.entity.CJRPGTokenList;
import net.one97.paytm.common.entity.movies.moviepass.CJRMoviePassBaseInstructionClass;
import net.one97.paytm.common.entity.movies.moviepass.CJRMoviePassRedeemInstructionModel;
import net.one97.paytm.common.entity.movies.moviepass.CJRMoviePassTncInstructionModel;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;
import net.one97.paytm.common.entity.shopping.CJRCartProduct;
import net.one97.paytm.nativesdk.app.PaytmSDKRequestClient;
import net.one97.paytm.nativesdk.orflow.promo.utils.Constants;
import net.one97.paytm.o2o.movies.common.b.c;
import net.one97.paytm.o2o.movies.common.movies.booking.CJRCampaign;
import net.one97.paytm.o2o.movies.common.movies.booking.CJRMCart;
import net.one97.paytm.o2o.movies.common.movies.booking.CJRMovieCart;
import net.one97.paytm.o2o.movies.common.movies.booking.CJRPromoMetaData;
import net.one97.paytm.o2o.movies.common.movies.moviepass.CJRMoviePassFaqInstructionModel;
import net.one97.paytm.o2o.movies.common.movies.moviepass.CJRMoviePassModelNew;
import net.one97.paytm.o2o.movies.common.movies.moviepass.CJRMoviePassPrevalidateResponseModel;
import net.one97.paytm.o2o.movies.d.e;
import net.one97.paytm.o2o.movies.entity.CJRMovieOffers;
import net.one97.paytm.o2o.movies.moviepass.b.b;
import net.one97.paytm.o2o.movies.moviepass.d;
import net.one97.paytm.o2o.movies.utils.n;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

public final class a implements e.a, net.one97.paytm.o2o.movies.moviepass.a {

    /* renamed from: a  reason: collision with root package name */
    public boolean f75598a;

    /* renamed from: b  reason: collision with root package name */
    public Map<String, CJRMoviePassBaseInstructionClass> f75599b;

    /* renamed from: c  reason: collision with root package name */
    public String f75600c;

    /* renamed from: d  reason: collision with root package name */
    public CJRMoviePassModelNew f75601d;

    /* renamed from: e  reason: collision with root package name */
    private final b.a f75602e;

    /* renamed from: f  reason: collision with root package name */
    private final e.b f75603f;

    /* renamed from: g  reason: collision with root package name */
    private CJRMoviePassPrevalidateResponseModel f75604g = null;

    /* renamed from: h  reason: collision with root package name */
    private CJRMovieCart f75605h;

    /* renamed from: i  reason: collision with root package name */
    private String f75606i;
    private int j;
    private String k;
    private boolean l;
    private String m;
    private boolean n;
    private String o;
    private PaytmSDKRequestClient.OtherPayOptionsListener p;
    private String q;

    public a(b.a aVar) {
        this.f75602e = aVar;
        this.f75603f = net.one97.paytm.o2o.movies.common.a.f74984b.a();
    }

    public final void a(String str, CJRMoviePassModelNew cJRMoviePassModelNew, Map<String, CJRMoviePassFaqInstructionModel> map, Map<String, CJRMoviePassRedeemInstructionModel> map2, Map<String, CJRMoviePassTncInstructionModel> map3) {
        HashMap hashMap = new HashMap();
        if (map != null) {
            try {
                hashMap.put(String.valueOf(cJRMoviePassModelNew.getFAQ()), map.get(cJRMoviePassModelNew.getFAQ()));
            } catch (Exception unused) {
            }
        }
        if (map3 != null) {
            hashMap.put(String.valueOf(cJRMoviePassModelNew.getTnc()), map3.get(cJRMoviePassModelNew.getTnc()));
        }
        if (map2 != null) {
            hashMap.put(String.valueOf(cJRMoviePassModelNew.getRedeemSteps()), map2.get(cJRMoviePassModelNew.getRedeemSteps()));
        }
        this.f75598a = true;
        this.p = null;
        if (this.f75605h != null) {
            b();
        } else if (this.f75604g == null) {
            a(str, cJRMoviePassModelNew, hashMap);
        } else {
            c();
        }
    }

    public final void a(String str, int i2, String str2, boolean z) {
        this.f75606i = str;
        this.j = i2;
        this.k = str2;
        this.l = z;
        this.m = null;
        HashMap hashMap = new HashMap();
        if (this.f75604g == null) {
            a(this.f75600c, this.f75601d, hashMap);
        } else {
            c();
        }
    }

    public final void a(String str, String str2) {
        this.m = str;
        this.o = str2;
        c();
    }

    public final void a(String str) {
        this.q = str;
        e();
    }

    public final void a(PaytmSDKRequestClient.OtherPayOptionsListener otherPayOptionsListener) {
        this.p = otherPayOptionsListener;
        this.f75602e.a();
        this.m = null;
        this.k = null;
        this.j = 0;
        this.l = false;
        c();
    }

    public final void d() {
        this.f75602e.a();
    }

    public final void a(boolean z) {
        if (!z) {
            this.f75606i = null;
            this.k = null;
            this.m = null;
            this.j = 0;
        }
        this.f75602e.c();
    }

    public final void b(String str) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put(CLPConstants.PRODUCT_ID, str);
            hashMap.put("price", this.f75601d.getTotalPrice());
            this.f75603f.a(this, "", e.b.a.MOVIEPASS_PROMO, hashMap);
        } catch (Exception unused) {
        }
    }

    public final void a() {
        this.f75606i = null;
        this.j = 0;
        this.m = null;
        this.k = null;
        this.f75605h = null;
    }

    private void a(String str, CJRMoviePassModelNew cJRMoviePassModelNew, Map<String, CJRMoviePassBaseInstructionClass> map) {
        String b2 = b(str, cJRMoviePassModelNew, map);
        this.f75602e.d();
        this.f75603f.a(this, b2, e.b.a.MOVIEPASS_PREVAIDATE_API);
    }

    private static String b(String str, CJRMoviePassModelNew cJRMoviePassModelNew, Map<String, CJRMoviePassBaseInstructionClass> map) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        try {
            f fVar = new f();
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("price", cJRMoviePassModelNew.getTotalPrice());
            jSONObject3.put("ty", "mp");
            jSONObject3.put("conv_fee", 0);
            jSONObject3.put("customer_id", com.paytm.utility.b.n(n.c()));
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("name", com.paytm.utility.b.j(n.c()));
            jSONObject4.put(AppConstants.KEY_EMAIL, com.paytm.utility.b.m(n.c()));
            jSONObject4.put("mobileNumber", com.paytm.utility.b.l(n.c()));
            JSONObject jSONObject5 = new JSONObject(fVar.a((Object) cJRMoviePassModelNew));
            if (!v.a((String) cJRMoviePassModelNew.getFAQ())) {
                jSONObject5.put("FAQ", fVar.a((Object) map.get(cJRMoviePassModelNew.getFAQ())));
            }
            if (!v.a((String) cJRMoviePassModelNew.getRedeemSteps())) {
                jSONObject5.put("redeemSteps", fVar.a((Object) map.get(cJRMoviePassModelNew.getRedeemSteps())));
            }
            if (!v.a((String) cJRMoviePassModelNew.getTnc())) {
                jSONObject5.put("terms&Conditions", fVar.a((Object) map.get(cJRMoviePassModelNew.getTnc())));
            }
            JSONObject jSONObject6 = new JSONObject();
            jSONObject6.put("passId", cJRMoviePassModelNew.getDbId());
            jSONObject6.put("paytmCityId", cJRMoviePassModelNew.getPaytmCityId());
            jSONObject6.put("totalChargedPrice", cJRMoviePassModelNew.getTotalPrice());
            jSONObject6.put("data", jSONObject5);
            JSONObject jSONObject7 = new JSONObject(fVar.a((Object) map));
            JSONObject jSONObject8 = new JSONObject();
            jSONObject8.put("ticketNotPresent", true);
            jSONObject8.put("moviePassPresent", true);
            jSONObject8.put("customer_id", com.paytm.utility.b.n(n.c()));
            jSONObject8.put("passenger", jSONObject4);
            jSONObject8.put("movie_pass", jSONObject6);
            jSONObject8.put("instructions", jSONObject7);
            jSONObject8.put("cityName", str);
            jSONObject2.put(CLPConstants.PRODUCT_ID, cJRMoviePassModelNew.getProductId());
            jSONObject2.put("qty", 1);
            jSONObject2.put(CLConstants.INPUT_KEY_CONFIGURATION, jSONObject3);
            jSONObject2.put("meta_data", jSONObject8);
            jSONArray.put(jSONObject2);
            jSONObject.put("cart_items", jSONArray);
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }

    public final void a(IJRPaytmDataModel iJRPaytmDataModel, HashMap<String, e.b.a> hashMap) {
        b.a aVar;
        String str;
        HashMap<String, CJRCampaign> hashMap2;
        if (iJRPaytmDataModel instanceof CJRPGTokenList) {
            String pgToken = net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.getPgToken((CJRPGTokenList) iJRPaytmDataModel);
            if (!v.a(pgToken)) {
                this.f75602e.d();
                try {
                    String k2 = com.paytm.utility.b.k();
                    HashMap hashMap3 = new HashMap();
                    hashMap3.put("wallet_token", pgToken);
                    hashMap3.put("client_id", k2);
                    JSONObject jSONObject = new JSONObject(new f().a((Object) this.f75604g));
                    a(jSONObject);
                    if (this.q != null) {
                        jSONObject.put("payment_intent", this.q);
                    }
                    this.f75603f.a(this, jSONObject.toString(), e.b.a.MOVIEPASS_CHECKOUT_API, hashMap3);
                } catch (Exception unused) {
                }
            }
        } else {
            String str2 = null;
            if (iJRPaytmDataModel instanceof CJRMovieCart) {
                CJRMovieCart cJRMovieCart = (CJRMovieCart) iJRPaytmDataModel;
                this.f75602e.d();
                String str3 = this.k;
                if (str3 != null) {
                    if (this.l) {
                        this.f75602e.a(cJRMovieCart, this.f75606i, str3);
                    } else {
                        d.a().a(cJRMovieCart.getCart(), false);
                    }
                    this.k = null;
                    return;
                }
                if (this.j == 1) {
                    this.j = 0;
                    CJRPromoMetaData cJRPromoMetaData = cJRMovieCart.getCart().promoMetaData;
                    if (!(cJRPromoMetaData == null || (hashMap2 = cJRPromoMetaData.campData) == null || !Constants.BANK_OFFER_KEY.equalsIgnoreCase(hashMap2.get(this.f75606i).campaignType))) {
                        d.a().a(cJRMovieCart.getCart(), false);
                        return;
                    }
                }
                this.f75605h = cJRMovieCart;
                if (this.f75598a) {
                    b();
                    return;
                }
                CJRMCart cart = this.f75605h.getCart();
                if (cart == null || cart.getPromoStatus() == null || !cart.getPromoStatus().equalsIgnoreCase("SUCCESS")) {
                    if (cart != null) {
                        str2 = cart.getPromoFailureText();
                    }
                    d.a().a(str2);
                    b.a aVar2 = this.f75602e;
                    if (aVar2 != null && this.l && this.m == null) {
                        cart.getPaytmCashBack();
                        aVar2.a(str2);
                    }
                } else {
                    if (cart.getCartItems() == null || cart.getCartItems().size() <= 0) {
                        str = null;
                    } else {
                        CJRCartProduct cJRCartProduct = cart.getCartItems().get(0);
                        this.f75606i = cJRCartProduct.getPromoCode();
                        str2 = this.f75606i;
                        str = cJRCartProduct.getPromoText();
                    }
                    if (TextUtils.isEmpty(str)) {
                        str = cart.getPromoText();
                    }
                    d.a().a(cart, true);
                    if (this.f75602e != null) {
                        this.f75602e.a(str2, "0".equalsIgnoreCase(cart.getPaytmCashBack()) ? cart.getPaytmPGCashBack() : cart.getPaytmCashBack(), str);
                    }
                }
                this.f75602e.c();
            } else if (iJRPaytmDataModel instanceof CJRMoviePassPrevalidateResponseModel) {
                this.f75604g = (CJRMoviePassPrevalidateResponseModel) iJRPaytmDataModel;
                this.f75602e.d();
                c();
            } else if (iJRPaytmDataModel instanceof CJRRechargePayment) {
                CJRRechargePayment cJRRechargePayment = (CJRRechargePayment) iJRPaytmDataModel;
                b.a aVar3 = this.f75602e;
                if (aVar3 != null) {
                    aVar3.c();
                }
                if (cJRRechargePayment == null || cJRRechargePayment.getStatus() == null || !cJRRechargePayment.getStatus().equalsIgnoreCase("SUCCESS")) {
                    if (cJRRechargePayment != null && cJRRechargePayment.getCode() == 401) {
                        NetworkCustomVolleyError networkCustomVolleyError = new NetworkCustomVolleyError();
                        c.a();
                        if (!TextUtils.isEmpty(c.a("cartCheckout", (String) null))) {
                            c.a();
                            networkCustomVolleyError.setUrl(c.a("cartCheckout", (String) null));
                            if (cJRRechargePayment.getError() != null && !TextUtils.isEmpty(cJRRechargePayment.getError().getMessage())) {
                                networkCustomVolleyError.setAlertMessage(cJRRechargePayment.getError().getMessage());
                            }
                        }
                    } else if (cJRRechargePayment != null && cJRRechargePayment.getError() != null && (aVar = this.f75602e) != null) {
                        aVar.a(cJRRechargePayment.getError().getTitle(), cJRRechargePayment.getError().getMessage(), (e.b.a) null);
                    }
                } else if (this.n) {
                    d.a().a(cJRRechargePayment);
                } else {
                    b.a aVar4 = this.f75602e;
                    if (aVar4 != null) {
                        aVar4.a(cJRRechargePayment);
                    }
                }
            } else if (iJRPaytmDataModel instanceof CJRMovieOffers) {
                this.f75602e.a((CJRMovieOffers) iJRPaytmDataModel);
                this.f75602e.c();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000c, code lost:
        r0 = r5.f75605h.getCart().paymentInfo;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b() {
        /*
            r5 = this;
            net.one97.paytm.o2o.movies.common.movies.booking.CJRMovieCart r0 = r5.f75605h
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x001c
            net.one97.paytm.o2o.movies.common.movies.booking.CJRMCart r0 = r0.getCart()
            if (r0 == 0) goto L_0x001c
            net.one97.paytm.o2o.movies.common.movies.booking.CJRMovieCart r0 = r5.f75605h
            net.one97.paytm.o2o.movies.common.movies.booking.CJRMCart r0 = r0.getCart()
            net.one97.paytm.o2o.movies.common.movies.booking.CJRPaymentInfo r0 = r0.paymentInfo
            if (r0 == 0) goto L_0x001c
            int r0 = r0.native_withdraw
            if (r0 != r2) goto L_0x001c
            r0 = 1
            goto L_0x001d
        L_0x001c:
            r0 = 0
        L_0x001d:
            if (r0 == 0) goto L_0x0033
            r5.n = r2
            net.one97.paytm.o2o.movies.moviepass.b.b$a r0 = r5.f75602e
            net.one97.paytm.o2o.movies.common.movies.booking.CJRMovieCart r3 = r5.f75605h
            java.lang.String r4 = r5.m
            if (r4 == 0) goto L_0x002a
            r1 = 1
        L_0x002a:
            net.one97.paytm.nativesdk.app.PaytmSDKRequestClient$OtherPayOptionsListener r2 = r5.p
            r0.a((net.one97.paytm.o2o.movies.common.movies.booking.CJRMovieCart) r3, (boolean) r1, (net.one97.paytm.nativesdk.app.PaytmSDKRequestClient.OtherPayOptionsListener) r2)
            r0 = 0
            r5.p = r0
            return
        L_0x0033:
            r5.e()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.moviepass.f.a.b():void");
    }

    private void c() {
        try {
            JSONObject jSONObject = new JSONObject(new f().a((Object) this.f75604g));
            if (!TextUtils.isEmpty(this.k)) {
                jSONObject.put("paymentFilters", this.k);
            } else if (!TextUtils.isEmpty(this.m)) {
                jSONObject.put("payment_intent", this.m);
                jSONObject.put("enable_upi_psp", this.o);
            }
            if (TextUtils.isEmpty(this.k) || this.j == 1) {
                a(jSONObject);
            }
            HashMap hashMap = new HashMap();
            hashMap.put("manual_promo", Integer.valueOf(this.j));
            this.f75603f.a(this, jSONObject.toString(), e.b.a.MOVIEPASS_VERIFY_API, hashMap);
        } catch (Exception unused) {
        }
    }

    private void a(JSONObject jSONObject) {
        if (!TextUtils.isEmpty(this.f75606i)) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("action", "applypromo");
                jSONObject2.put("globalcode", this.f75606i);
                jSONObject.put("promo_action", jSONObject2);
            } catch (JSONException unused) {
            }
        }
    }

    private void e() {
        this.f75603f.a(this.f75602e.e(), this);
    }

    public final void a(boolean z, String str, int i2, e.b.a aVar, String str2, String str3, NetworkCustomError networkCustomError) {
        this.f75602e.c();
        if (e.b.a.MOVIEPASS_PREVAIDATE_API.equals(aVar) || e.b.a.MOVIEPASS_VERIFY_API.equals(aVar)) {
            PaytmSDKRequestClient.ApiResponseError apiResponseError = new PaytmSDKRequestClient.ApiResponseError();
            apiResponseError.setErrorMsg(str3);
            apiResponseError.setErrorTitle(str2);
            if (networkCustomError != null) {
                apiResponseError.setStatusCode(networkCustomError.getStatusCode());
            }
            apiResponseError.setShouldClosePG(false);
            if (d.a().a(apiResponseError)) {
                return;
            }
        } else if (e.b.a.MOVIEPASS_CHECKOUT_API.equals(aVar)) {
            PaytmSDKRequestClient.ApiResponseError apiResponseError2 = new PaytmSDKRequestClient.ApiResponseError();
            apiResponseError2.setErrorMsg(str3);
            apiResponseError2.setErrorTitle(str2);
            apiResponseError2.setShouldClosePG(true);
            d.a().b(apiResponseError2);
        }
        if (!e.b.a.MOVIEPASS_PROMO.equals(aVar)) {
            this.f75602e.a(str2, str3, aVar);
        }
    }
}
