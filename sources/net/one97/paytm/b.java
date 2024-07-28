package net.one97.paytm;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytmmall.clpartifact.utils.CLPConstants;
import java.util.HashMap;
import net.one97.paytm.addmoney.R;
import net.one97.paytm.addmoney.utils.AddMoneyUtils;
import net.one97.paytm.addmoney.utils.h;
import net.one97.paytm.addmoney.utils.j;
import net.one97.paytm.common.entity.CJRPGTokenList;
import net.one97.paytm.common.entity.CJRRechargeCart;
import net.one97.paytm.common.entity.offline_pg.pgTransactionRequest.CJRPGTransactionRequestUtils;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;
import net.one97.paytm.helper.a;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiUtils;
import net.one97.paytm.wallet.d.c;
import org.json.JSONArray;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

public final class b implements com.paytm.network.listener.b {

    /* renamed from: a  reason: collision with root package name */
    public Activity f52339a;

    /* renamed from: b  reason: collision with root package name */
    public String f52340b;

    /* renamed from: c  reason: collision with root package name */
    private Dialog f52341c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f52342d;

    public final void b() {
        Activity activity = this.f52339a;
        if (activity != null && !activity.isFinishing()) {
            d();
            j.a(this.f52339a);
        }
    }

    public final JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put(CLPConstants.PRODUCT_ID, a.b().f("PaytmCashProductId"));
            jSONObject2.put("qty", 1);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("price", (double) Float.parseFloat(this.f52340b));
            jSONObject2.put(CLConstants.INPUT_KEY_CONFIGURATION, jSONObject3);
            jSONArray.put(jSONObject2);
            jSONObject.put("cart_items", jSONArray);
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                e2.printStackTrace();
            }
        }
        return jSONObject;
    }

    /* access modifiers changed from: package-private */
    public final void a(CJRPGTokenList cJRPGTokenList) {
        String str;
        if (cJRPGTokenList != null) {
            String a2 = a.b().a(cJRPGTokenList);
            if (!TextUtils.isEmpty(a2)) {
                Activity activity = this.f52339a;
                if (activity != null && !activity.isFinishing()) {
                    JSONObject c2 = c();
                    a.b().k();
                    a.b().a((Context) this.f52339a, (String) null, (String) null, (String) null);
                    String d2 = a.b().d();
                    HashMap hashMap = new HashMap();
                    hashMap.put("Content-Type", "application/json");
                    if (!TextUtils.isEmpty(d2)) {
                        hashMap.put("risk_extended_info", d2);
                    }
                    a.b().k();
                    hashMap.put(AppConstants.SSO_TOKEN, com.paytm.utility.a.q(this.f52339a));
                    String s = com.paytm.utility.b.s(this.f52339a, a.b().f("cartCheckout"));
                    String k = com.paytm.utility.b.k();
                    if (Uri.parse(s).getQuery() != null) {
                        str = s + "&wallet_token=" + a2 + "&client_id=" + k;
                    } else {
                        str = s + "?wallet_token=" + a2 + "&client_id=" + k;
                    }
                    String d3 = com.paytm.utility.b.d(str, "POST");
                    if (com.paytm.utility.b.c((Context) this.f52339a)) {
                        a();
                        com.paytm.network.b b2 = net.one97.paytm.addmoney.common.a.b();
                        b2.f42885i = new CJRRechargePayment();
                        b2.f42884h = c2.toString();
                        b2.f42880d = d3;
                        b2.j = this;
                        b2.f42882f = hashMap;
                        b2.l().a();
                        return;
                    }
                    b();
                    return;
                }
                return;
            }
            a.b().a(this.f52339a, (String) null, (Bundle) null);
        }
    }

    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        Activity activity = this.f52339a;
        if (activity != null && !activity.isFinishing()) {
            d();
            if (iJRPaytmDataModel instanceof CJRRechargeCart) {
                CJRRechargeCart cJRRechargeCart = (CJRRechargeCart) iJRPaytmDataModel;
                Activity activity2 = this.f52339a;
                if (!c.a(cJRRechargeCart, (Context) activity2, activity2.getString(R.string.unable_to_proceed)) && cJRRechargeCart.getCartStatus().getResult().equalsIgnoreCase("SUCCESS")) {
                    if (!(cJRRechargeCart == null || cJRRechargeCart.getCart() == null)) {
                        a.b().a(this.f52339a, cJRRechargeCart.getCart());
                    }
                    Activity activity3 = this.f52339a;
                    if (activity3 != null && !activity3.isFinishing()) {
                        if (!TextUtils.isEmpty(h.a(this.f52339a.getApplicationContext()).b("sso_token=", "", true))) {
                            a();
                            a.b().a(this.f52339a, (com.paytm.network.listener.b) new com.paytm.network.listener.b() {
                                public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                                    if (iJRPaytmDataModel instanceof CJRPGTokenList) {
                                        b.this.a((CJRPGTokenList) iJRPaytmDataModel);
                                    }
                                }

                                public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                                    AddMoneyUtils.a(b.this.f52339a, networkCustomError, (String) null, Boolean.FALSE);
                                }
                            });
                            return;
                        }
                        a.b().a(this.f52339a, (String) null, (Bundle) null);
                    }
                }
            } else if (iJRPaytmDataModel instanceof CJRPGTokenList) {
                a((CJRPGTokenList) iJRPaytmDataModel);
            } else if (iJRPaytmDataModel instanceof CJRRechargePayment) {
                CJRRechargePayment cJRRechargePayment = (CJRRechargePayment) iJRPaytmDataModel;
                if (cJRRechargePayment.getStatus() != null && cJRRechargePayment.getStatus().equalsIgnoreCase("SUCCESS")) {
                    if (cJRRechargePayment.getPGParams() != null) {
                        cJRRechargePayment.getPGParams().put(CJRPGTransactionRequestUtils.THEME, "merchantLow|ccdc");
                    }
                    if (!this.f52342d) {
                        Intent f2 = a.b().f(this.f52339a);
                        f2.putExtra(SDKConstants.PAYMENT_INFO, cJRRechargePayment);
                        f2.putExtra(UpiConstants.FROM, "Add_to_paytm_cash");
                        this.f52339a.startActivity(f2);
                        return;
                    }
                    Intent f3 = a.b().f(this.f52339a);
                    f3.putExtra(SDKConstants.PAYMENT_INFO, cJRRechargePayment);
                    f3.putExtra(UpiConstants.FROM, "Add_to_paytm_cash");
                    f3.putExtra("intent_extra_wallet_send_money_insufficient_balance_error", true);
                    this.f52339a.startActivityForResult(f3, 104);
                } else if (cJRRechargePayment != null && cJRRechargePayment.getCode() == 401) {
                    NetworkCustomError networkCustomError = new NetworkCustomError();
                    String f4 = a.b().f("cartCheckout");
                    if (!TextUtils.isEmpty(f4)) {
                        networkCustomError.setUrl(f4);
                        if (cJRRechargePayment.getError() != null && !TextUtils.isEmpty(cJRRechargePayment.getError().getMessage())) {
                            networkCustomError.setAlertMessage(cJRRechargePayment.getError().getMessage());
                        }
                    }
                    a.b().a(this.f52339a, (String) null, (Bundle) null);
                } else if (cJRRechargePayment != null && cJRRechargePayment.getError() != null) {
                    j.a(this.f52339a, cJRRechargePayment.getError().getTitle(), cJRRechargePayment.getError().getMessage());
                }
            }
        }
    }

    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        Activity activity = this.f52339a;
        if (activity != null && !activity.isFinishing()) {
            d();
            if (networkCustomError != null) {
                try {
                    if (!TextUtils.isEmpty(networkCustomError.getMessage()) && (networkCustomError.getMessage().equalsIgnoreCase("410") || networkCustomError.getMessage().equalsIgnoreCase(UpiUtils.AUTHENTICATION_FAILURE_401))) {
                        AddMoneyUtils.a(this.f52339a, networkCustomError, (String) null, Boolean.FALSE);
                    } else if (networkCustomError != null && networkCustomError.networkResponse != null && (networkCustomError.networkResponse.statusCode == 403 || networkCustomError.networkResponse.statusCode == 401 || networkCustomError.networkResponse.statusCode == 410)) {
                        a.b().a(this.f52339a, (String) null, (Bundle) null);
                    } else if (networkCustomError.getMessage() != null && !a.b().a((Context) this.f52339a, networkCustomError)) {
                        if (networkCustomError.getMessage() == null || !networkCustomError.getMessage().equalsIgnoreCase("parsing_error")) {
                            com.paytm.utility.b.b((Context) this.f52339a, this.f52339a.getResources().getString(R.string.network_error_heading), this.f52339a.getResources().getString(R.string.network_error_message) + " " + networkCustomError.getUrl());
                            return;
                        }
                        Activity activity2 = this.f52339a;
                        String url = networkCustomError.getUrl();
                        StringBuilder sb = new StringBuilder();
                        sb.append(networkCustomError.getNetworkResponse().statusCode);
                        com.paytm.utility.b.d((Context) activity2, url, sb.toString());
                    }
                } catch (Resources.NotFoundException e2) {
                    if (com.paytm.utility.b.v) {
                        e2.printStackTrace();
                    }
                } catch (Exception e3) {
                    if (com.paytm.utility.b.v) {
                        e3.printStackTrace();
                    }
                }
            }
        }
    }

    public final void a() {
        try {
            if (this.f52341c == null) {
                this.f52341c = j.b(this.f52339a);
            }
            if (this.f52341c != null && !this.f52341c.isShowing()) {
                this.f52341c.show();
            }
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                e2.printStackTrace();
            }
        }
    }

    private void d() {
        try {
            if (this.f52341c != null && this.f52341c.isShowing()) {
                this.f52341c.dismiss();
            }
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                e2.printStackTrace();
            }
        }
    }
}
