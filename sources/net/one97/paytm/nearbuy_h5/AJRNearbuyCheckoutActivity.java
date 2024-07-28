package net.one97.paytm.nearbuy_h5;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ProgressBar;
import com.appsflyer.internal.referrer.Payload;
import com.google.android.play.core.splitcompat.a;
import com.paytm.android.chat.bean.jsonbean.TxNotifyData;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.network.a;
import com.paytm.network.b.g;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.b;
import com.paytm.utility.q;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import net.one97.paytm.AJRRechargePaymentActivity;
import net.one97.paytm.auth.activity.AJRAuthActivity;
import net.one97.paytm.base.BaseActivity;
import net.one97.paytm.common.entity.CJRPGTokenList;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import net.one97.paytm.j.c;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.paytm_finance.R;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.utils.r;
import net.one97.paytm.utils.t;
import org.json.JSONException;
import org.json.JSONObject;

public class AJRNearbuyCheckoutActivity extends BaseActivity {
    private static final String TAG = AJRNearbuyCheckoutActivity.class.getSimpleName();
    private boolean hasEnoughBalance = false;
    private boolean isCheckoutInProgress = false;
    private boolean isFastForward = false;
    private ProgressBar progressBar;
    private String receivedData;

    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        a.a((Context) this);
    }

    public void onCreate(Bundle bundle) {
        if (Build.VERSION.SDK_INT < 26) {
            setRequestedOrientation(1);
        }
        super.onCreate(bundle);
        setContentView((int) R.layout.nearbuy_checkout);
        try {
            getSupportActionBar().f();
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
        this.progressBar = (ProgressBar) findViewById(R.id.progress);
        if (getIntent() != null) {
            this.receivedData = getIntent().getStringExtra("data");
            String str = this.receivedData;
            if (str != null) {
                try {
                    this.isFastForward = new JSONObject(str).getBoolean("fast_forward");
                } catch (JSONException unused) {
                }
            }
            if (com.paytm.utility.a.p(this)) {
                doApiCallVerificationApi(this.receivedData);
            } else {
                doApiCallLoginRequest();
            }
        }
    }

    private void doApiCallLoginRequest() {
        startActivityForResult(new Intent(this, AJRAuthActivity.class), 111);
    }

    private void doApiCallVerificationApi(String str) {
        String k = b.k();
        c.a();
        String b2 = com.paytm.utility.c.b(c.a("nearbuyCartVerify", (String) null), (Context) this);
        String d2 = b.d(b2 + "&token_type=oauth&client_id=" + k + "&networktype=" + com.paytm.utility.a.l(this), "POST");
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        hashMap.put("accept-encoding", "deflate");
        HashMap<String, String> a2 = com.paytm.utility.a.a((HashMap<String, String>) hashMap, (Context) this);
        new JSONObject();
        try {
            new JSONObject(str);
        } catch (JSONException unused) {
        }
        showProgress();
        this.isCheckoutInProgress = true;
        com.paytm.network.b bVar = new com.paytm.network.b();
        bVar.f42877a = this;
        bVar.f42878b = a.c.EDUCATION;
        bVar.f42879c = a.C0715a.POST;
        bVar.n = a.b.SILENT;
        bVar.o = AJRNearbuyCheckoutActivity.class.getSimpleName();
        bVar.f42884h = this.receivedData;
        bVar.f42882f = a2;
        bVar.f42880d = d2;
        bVar.f42885i = new NearbuyVerificationModel();
        bVar.j = new com.paytm.network.listener.b() {
            public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                String str;
                try {
                    if (iJRPaytmDataModel instanceof NearbuyVerificationModel) {
                        String str2 = iJRPaytmDataModel.getNetworkResponse().headers.get("Content-Encoding");
                        if (TextUtils.isEmpty(str2) || !"gzip".equalsIgnoreCase(str2)) {
                            str = new String(iJRPaytmDataModel.getNetworkResponse().data);
                        } else {
                            str = g.a(g.a(iJRPaytmDataModel.getNetworkResponse().data));
                        }
                        AJRNearbuyCheckoutActivity.this.handleVerificationResponse(new JSONObject(str));
                    }
                } catch (Exception e2) {
                    q.b(e2.getMessage());
                }
            }

            public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                AJRNearbuyCheckoutActivity.this.handleErrorCode(i2, iJRPaytmDataModel, networkCustomError);
            }
        };
        bVar.l().a();
    }

    /* access modifiers changed from: private */
    public void handleVerificationResponse(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("status");
            JSONObject jSONObject3 = jSONObject.getJSONObject("cart");
            if (jSONObject3 != null) {
                if (jSONObject2 != null) {
                    String optString = jSONObject3.optString("promostatus", "");
                    String optString2 = jSONObject3.optString("promofailuretext", "");
                    if (!ImagePickerUtils.IMAGE_PICKER_KEY_STATUS_FAILURE.equalsIgnoreCase(optString) || TextUtils.isEmpty(optString2)) {
                        String optString3 = jSONObject2.optString("result", "");
                        String optString4 = jSONObject3.optString("place_order_url", "");
                        if (!"SUCCESS".equalsIgnoreCase(optString3) || TextUtils.isEmpty(optString4)) {
                            showUnknownApiErrorAlert();
                            finishProgress();
                            return;
                        } else if (this.isFastForward) {
                            walletBalanceApiCall(jSONObject3);
                            return;
                        } else {
                            getWalletTokenAndCheckout(jSONObject3, (JSONObject) null);
                            return;
                        }
                    } else {
                        onPromoAppliedError(optString2);
                        finishProgress();
                        return;
                    }
                }
            }
            showUnknownApiErrorAlert();
            finishProgress();
        } catch (JSONException unused) {
            finishProgress();
        }
    }

    private void walletBalanceApiCall(final JSONObject jSONObject) {
        com.paytm.utility.a.c();
        c.a();
        String b2 = com.paytm.utility.c.b(c.a("checkBalance", ""), (Context) this);
        HashMap hashMap = new HashMap();
        hashMap.put("ssotoken", t.b((Context) this));
        com.paytm.network.b bVar = new com.paytm.network.b();
        bVar.f42877a = this;
        bVar.f42878b = a.c.EDUCATION;
        bVar.f42879c = a.C0715a.GET;
        bVar.n = a.b.SILENT;
        bVar.o = AJRNearbuyCheckoutActivity.class.getSimpleName();
        bVar.f42882f = hashMap;
        bVar.f42880d = b2;
        bVar.f42885i = new NearbuyVerificationModel();
        bVar.j = new com.paytm.network.listener.b() {
            public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                String str;
                try {
                    if (iJRPaytmDataModel instanceof NearbuyVerificationModel) {
                        String str2 = iJRPaytmDataModel.getNetworkResponse().headers.get("Content-Encoding");
                        if (TextUtils.isEmpty(str2) || !"gzip".equalsIgnoreCase(str2)) {
                            str = new String(iJRPaytmDataModel.getNetworkResponse().data);
                        } else {
                            str = g.a(g.a(iJRPaytmDataModel.getNetworkResponse().data));
                        }
                        AJRNearbuyCheckoutActivity.this.getWalletTokenAndCheckout(jSONObject, new JSONObject(str));
                    }
                } catch (Exception e2) {
                    q.b(e2.getMessage());
                }
            }

            public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                AJRNearbuyCheckoutActivity.this.handleErrorCode(i2, iJRPaytmDataModel, networkCustomError);
            }
        };
        bVar.l().a();
    }

    /* access modifiers changed from: private */
    public void getWalletTokenAndCheckout(final JSONObject jSONObject, final JSONObject jSONObject2) {
        t.a((Activity) this, (com.paytm.network.listener.b) new com.paytm.network.listener.b() {
            public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                if (iJRPaytmDataModel instanceof CJRPGTokenList) {
                    AJRNearbuyCheckoutActivity.this.handleWalletTokenResponse((CJRPGTokenList) iJRPaytmDataModel, jSONObject, jSONObject2);
                }
            }

            public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                AJRNearbuyCheckoutActivity.this.handleErrorCode(i2, iJRPaytmDataModel, networkCustomError);
            }
        }, a.c.EDUCATION);
    }

    /* access modifiers changed from: private */
    public void handleWalletTokenResponse(CJRPGTokenList cJRPGTokenList, JSONObject jSONObject, JSONObject jSONObject2) {
        String a2 = t.a(cJRPGTokenList);
        if (!TextUtils.isEmpty(a2)) {
            doApiCallForDealExpressCheckout(jSONObject, jSONObject2, a2);
            return;
        }
        finishProgress();
        b.b((Context) this, getString(R.string.error), getString(R.string.oops_something_went_wrong));
    }

    /* access modifiers changed from: private */
    public void handleCheckoutResponse(CJRRechargePayment cJRRechargePayment) {
        if (cJRRechargePayment == null) {
            showUnknownApiErrorAlert();
        } else if (!"SUCCESS".equalsIgnoreCase(cJRRechargePayment.getStatus())) {
            showUnknownApiErrorAlert();
        } else if (!this.hasEnoughBalance || !this.isFastForward || TextUtils.isEmpty(cJRRechargePayment.getOrderId())) {
            startPaymentActivity(cJRRechargePayment);
        } else {
            a aVar = a.f55773a;
            a.a((Context) this, "https://paytmmall.com/shop/summary/" + cJRRechargePayment.getOrderId());
            if (!isFinishing()) {
                finish();
            }
        }
        finishProgress();
    }

    private void doApiCallForDealExpressCheckout(JSONObject jSONObject, JSONObject jSONObject2, String str) {
        String optString = jSONObject.optString("place_order_url", "");
        HashMap hashMap = new HashMap();
        hashMap.put("wallet_token", str);
        hashMap.put("client_id", "nearbuy");
        String jSONObject3 = jSONObject.toString();
        HashMap<String, String> a2 = com.paytm.utility.a.a((HashMap<String, String>) new HashMap(), (Context) this);
        if (!TextUtils.isEmpty(str)) {
            a2.put("wallet_token", str);
        }
        a2.put("Content-Type", "application/json");
        String appendPGWithdrawParam = appendPGWithdrawParam(jSONObject, jSONObject2, b.j(constructCheckoutUrl(optString, hashMap), constructSignatureUrl(optString, jSONObject.optString("signature_url", ""), hashMap), "POST"));
        com.paytm.network.b bVar = new com.paytm.network.b();
        bVar.f42877a = this;
        bVar.f42878b = a.c.EDUCATION;
        bVar.f42879c = a.C0715a.POST;
        bVar.n = a.b.SILENT;
        bVar.o = AJRNearbuyCheckoutActivity.class.getSimpleName();
        bVar.f42882f = a2;
        bVar.f42883g = hashMap;
        bVar.f42884h = jSONObject3;
        bVar.f42880d = appendPGWithdrawParam;
        bVar.f42885i = new CJRRechargePayment();
        bVar.j = new com.paytm.network.listener.b() {
            public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                try {
                    if (iJRPaytmDataModel instanceof CJRRechargePayment) {
                        AJRNearbuyCheckoutActivity.this.handleCheckoutResponse((CJRRechargePayment) iJRPaytmDataModel);
                    }
                } catch (Exception e2) {
                    q.b(e2.getMessage());
                }
            }

            public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                AJRNearbuyCheckoutActivity.this.handleErrorCode(i2, iJRPaytmDataModel, networkCustomError);
            }
        };
        bVar.l().a();
    }

    private String appendPGWithdrawParam(JSONObject jSONObject, JSONObject jSONObject2, String str) {
        double d2;
        double d3;
        if (this.isFastForward && jSONObject2 != null) {
            try {
                d3 = jSONObject2.getJSONObject(Payload.RESPONSE).getDouble("amount");
                d2 = Double.parseDouble(jSONObject.getString("final_price"));
            } catch (Exception unused) {
                d3 = -1.0d;
                d2 = 0.0d;
            }
            if (d3 > 0.0d && d2 <= d3) {
                this.hasEnoughBalance = true;
                return str + "&withdraw=1";
            }
        }
        return str + "&native_withdraw=1";
    }

    private String constructSignatureUrl(String str, String str2, Map<String, String> map) {
        try {
            Uri.Builder buildUpon = Uri.parse(str2).buildUpon();
            Map<String, String> b2 = com.paytm.utility.c.b((Context) this, false);
            populateRequestQueryParams(str, buildUpon, map);
            populateRequestQueryParams(str, buildUpon, b2);
            return buildUpon.build().toString();
        } catch (Exception e2) {
            q.b(e2.getMessage());
            return null;
        }
    }

    private String constructCheckoutUrl(String str, Map<String, String> map) {
        try {
            Uri.Builder buildUpon = Uri.parse(str).buildUpon();
            Map<String, String> b2 = com.paytm.utility.c.b((Context) this, false);
            populateRequestQueryParams(str, buildUpon, map);
            populateRequestQueryParams(str, buildUpon, b2);
            return buildUpon.build().toString();
        } catch (Exception e2) {
            q.b(e2.getMessage());
            return null;
        }
    }

    private void populateRequestQueryParams(String str, Uri.Builder builder, Map<String, String> map) {
        if (builder != null && map != null) {
            Set<String> keySet = map.keySet();
            Set<String> queryParameterNames = Uri.parse(str).getQueryParameterNames();
            for (String next : keySet) {
                if ((TextUtils.isEmpty(next) || !next.equalsIgnoreCase(AppConstants.SSO_TOKEN)) && (queryParameterNames == null || !queryParameterNames.contains(next))) {
                    builder.appendQueryParameter(next, URLEncoder.encode(map.get(next)));
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        finishProgress();
        if (i2 == 401 || i2 == 410) {
            r.a((Activity) this, (String) null, (Bundle) null);
            finish();
        } else if (TextUtils.isEmpty(networkCustomError.getAlertTitle()) || TextUtils.isEmpty(networkCustomError.getAlertMessage())) {
            showUnknownApiErrorAlert();
        } else {
            b.b((Context) this, networkCustomError.getAlertTitle(), networkCustomError.getAlertMessage());
        }
    }

    private void finishProgress() {
        ProgressBar progressBar2 = this.progressBar;
        if (progressBar2 != null) {
            progressBar2.setVisibility(8);
        }
        this.isCheckoutInProgress = false;
    }

    private void showProgress() {
        ProgressBar progressBar2 = this.progressBar;
        if (progressBar2 != null) {
            progressBar2.setVisibility(0);
        }
    }

    private void showUnknownApiErrorAlert() {
        b.b((Context) this, getString(R.string.error), getString(R.string.oops_something_went_wrong));
    }

    private void onPromoAppliedError(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "Aw snap! Looks like this promo code is not valid. Please check.";
        }
        b.b((Context) this, getString(R.string.error), str);
    }

    private void startPaymentActivity(CJRRechargePayment cJRRechargePayment) {
        Intent intent = new Intent(this, AJRRechargePaymentActivity.class);
        a aVar = a.f55773a;
        a.a(cJRRechargePayment, intent);
        intent.putExtra(SDKConstants.PAYMENT_INFO, cJRRechargePayment);
        intent.putExtra(UpiConstants.FROM, "Shopping_cart");
        startActivity(intent);
        finish();
    }

    public void onBackPressed() {
        if (!this.isCheckoutInProgress) {
            super.onBackPressed();
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 111) {
            if (i3 == -1) {
                String str = this.receivedData;
                if (str != null) {
                    doApiCallVerificationApi(str);
                } else {
                    showUnknownApiErrorAlert();
                }
            } else {
                finish();
            }
        } else if (i2 == 112) {
            if (i3 == -1 && !intent.getBooleanExtra(TxNotifyData.UPI_STATUS_CANCELLED, false)) {
                a aVar = a.f55773a;
                a.a((Context) this, "https://paytmmall.com/shop/summary/" + intent.getStringExtra("order_id"));
            }
            finish();
        }
    }
}
