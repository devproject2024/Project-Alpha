package common.insuranceOrderSummary;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import com.google.gson.f;
import com.paytm.network.a;
import com.paytm.network.model.CJRError;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.g.b.y;
import kotlin.m.p;
import net.one97.paytm.common.entity.CJRPGTokenList;
import net.one97.paytm.common.entity.CJRRechargeCart;
import net.one97.paytm.common.entity.insurance.CartItem;
import net.one97.paytm.common.entity.insurance.Configuration;
import net.one97.paytm.common.entity.insurance.InsuranceCartObj;
import net.one97.paytm.common.entity.insurance.SelectQuoteResponse;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;
import net.one97.paytm.common.entity.shopping.CJRCartStatus;
import net.one97.paytm.insurance.R;
import net.one97.paytm.insurance.a.a;
import net.one97.paytm.insurance.b.c;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiUtils;

public final class b implements com.paytm.network.listener.b {

    /* renamed from: a  reason: collision with root package name */
    private ProgressDialog f13433a;

    /* renamed from: b  reason: collision with root package name */
    private Activity f13434b;

    /* renamed from: c  reason: collision with root package name */
    private SelectQuoteResponse f13435c;

    public b(Activity activity, SelectQuoteResponse selectQuoteResponse) {
        k.c(activity, "mActivity");
        this.f13434b = activity;
        this.f13435c = selectQuoteResponse;
    }

    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        Activity activity = this.f13434b;
        if (activity != null && !activity.isFinishing()) {
            c();
            if (networkCustomError != null) {
                try {
                    networkCustomError.getMessage();
                    networkCustomError.getUrl();
                    if (!TextUtils.isEmpty(String.valueOf(networkCustomError.getStatusCode())) && (p.a(String.valueOf(networkCustomError.getStatusCode()), "410", true) || p.a(String.valueOf(networkCustomError.getStatusCode()), UpiUtils.AUTHENTICATION_FAILURE_401, true))) {
                        c.a().handleError(this.f13434b, networkCustomError, (String) null, (Bundle) null, Boolean.FALSE);
                    } else if (networkCustomError.getMessage() == null || c.a().checkErrorCode(this.f13434b, networkCustomError)) {
                        com.paytm.utility.b.b((Context) this.f13434b, networkCustomError.getAlertTitle(), networkCustomError.getAlertMessage());
                    } else if (networkCustomError.getMessage() == null || !p.a(networkCustomError.getMessage(), "parsing_error", true)) {
                        com.paytm.utility.b.b((Context) this.f13434b, this.f13434b.getResources().getString(R.string.network_error_heading), this.f13434b.getResources().getString(R.string.network_error_message) + " " + networkCustomError.getUrl());
                    } else {
                        com.paytm.utility.b.d((Context) this.f13434b, networkCustomError.getUrl(), networkCustomError.getUniqueReference());
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

    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        String str;
        Activity activity = this.f13434b;
        if (activity != null && !activity.isFinishing()) {
            if (iJRPaytmDataModel instanceof CJRRechargeCart) {
                CJRRechargeCart cJRRechargeCart = (CJRRechargeCart) iJRPaytmDataModel;
                if (!(cJRRechargeCart == null || cJRRechargeCart.getCartStatus() == null)) {
                    CJRCartStatus cartStatus = cJRRechargeCart.getCartStatus();
                    k.a((Object) cartStatus, "rechargeCart.cartStatus");
                    if (cartStatus.getResult() != null) {
                        CJRCartStatus cartStatus2 = cJRRechargeCart.getCartStatus();
                        k.a((Object) cartStatus2, "rechargeCart.cartStatus");
                        if (p.a(cartStatus2.getResult(), "SUCCESS", true) && !c.a().containsError(cJRRechargeCart, this.f13434b)) {
                            try {
                                if (this.f13434b == null) {
                                    return;
                                }
                                if (!this.f13434b.isFinishing()) {
                                    String a2 = d.a(this.f13434b);
                                    if (TextUtils.isEmpty(a2)) {
                                        c();
                                        c.a().showSessionTimeoutAlert(this.f13434b, (String) null, (Bundle) null, (NetworkCustomError) null);
                                        return;
                                    } else if (com.paytm.utility.b.c((Context) this.f13434b)) {
                                        b();
                                        c.a().getWalletToken(a2, this.f13434b, this);
                                        return;
                                    } else {
                                        c();
                                        com.paytm.utility.b.b((Context) this.f13434b, this.f13434b.getString(R.string.ins_no_connection), this.f13434b.getString(R.string.ins_no_internet));
                                        return;
                                    }
                                } else {
                                    return;
                                }
                            } catch (Exception e2) {
                                e2.printStackTrace();
                                c();
                                return;
                            }
                        }
                    }
                }
                c();
            } else if (iJRPaytmDataModel instanceof CJRPGTokenList) {
                String pgToken = c.a().getPgToken((CJRPGTokenList) iJRPaytmDataModel);
                if (!TextUtils.isEmpty(pgToken)) {
                    k.a((Object) pgToken, "walletSSOToken");
                    Activity activity2 = this.f13434b;
                    if (activity2 != null && !activity2.isFinishing()) {
                        a a3 = c.a();
                        k.a((Object) a3, "InsuranceHelper.getInsuranceListener()");
                        String b2 = com.paytm.utility.c.b(a3.getCartCheckoutUrl(), (Context) this.f13434b);
                        String k = com.paytm.utility.b.k();
                        Uri parse = Uri.parse(b2);
                        k.a((Object) parse, "Uri.parse(url)");
                        if (parse.getQuery() != null) {
                            str = b2 + "&wallet_token=" + pgToken + "&client_id=" + k;
                        } else {
                            str = b2 + "?wallet_token=" + pgToken + "&client_id=" + k;
                        }
                        String d2 = com.paytm.utility.b.d(str, "POST");
                        HashMap hashMap = new HashMap();
                        hashMap.put("Content-Type", "application/json");
                        HashMap<String, String> a4 = com.paytm.utility.b.a((HashMap<String, String>) hashMap, (Context) this.f13434b);
                        k.a((Object) a4, "CJRAppCommonUtility.addS…eader(headers, mActivity)");
                        c.a().clearRiskExtendedInfo();
                        c.a().setRiskExtendedInfo(this.f13434b, (String) null, (String) null, false, (String) null);
                        a a5 = c.a();
                        k.a((Object) a5, "InsuranceHelper.getInsuranceListener()");
                        String riskExtendedInfoJson = a5.getRiskExtendedInfoJson();
                        if (!TextUtils.isEmpty(riskExtendedInfoJson)) {
                            a4.put("risk_extended_info", riskExtendedInfoJson);
                        }
                        c.a().clearRiskExtendedInfo();
                        com.paytm.network.a l = new com.paytm.network.b().a((Context) this.f13434b).a(a.C0715a.POST).a(a.c.INSURANCE).a(d2).b(new f().b(a(this.f13435c))).a((Map<String, String>) a4).a((IJRPaytmDataModel) new CJRRechargePayment()).c("InsurancePGHelper").a((com.paytm.network.listener.b) this).a(a.b.SILENT).l();
                        if (l != null) {
                            l.a();
                            return;
                        }
                        return;
                    }
                    return;
                }
                c();
                c.a().showSessionTimeoutAlert(this.f13434b, (String) null, (Bundle) null, (NetworkCustomError) null);
            } else if (iJRPaytmDataModel instanceof CJRRechargePayment) {
                CJRRechargePayment cJRRechargePayment = (CJRRechargePayment) iJRPaytmDataModel;
                if (cJRRechargePayment.getStatus() != null && p.a(cJRRechargePayment.getStatus(), "SUCCESS", true)) {
                    net.one97.paytm.insurance.a.a a6 = c.a();
                    k.a((Object) a6, "InsuranceHelper.getInsuranceListener()");
                    Intent intent = new Intent(this.f13434b, a6.getAJRRechargePaymentActivity());
                    intent.putExtra(SDKConstants.PAYMENT_INFO, cJRRechargePayment);
                    intent.putExtra(UpiConstants.FROM, "Insurance");
                    f.a.a aVar = f.a.a.f13515a;
                    if (!p.a(f.a.a.b(), " ", false)) {
                        intent.putExtra("FROM_INSURANCE_SCREEN", true);
                    } else {
                        intent.putExtra("FROM_INSURANCE_SCREEN", false);
                    }
                    c.a().openPaymentPage(this.f13434b, cJRRechargePayment);
                    if (this.f13434b.getIntent().getBooleanExtra("isFromH5", false)) {
                        this.f13434b.finish();
                    }
                } else if (cJRRechargePayment != null && cJRRechargePayment.getCode() == 401) {
                    NetworkCustomError networkCustomError = new NetworkCustomError();
                    net.one97.paytm.insurance.a.a a7 = c.a();
                    k.a((Object) a7, "InsuranceHelper.getInsuranceListener()");
                    if (!TextUtils.isEmpty(a7.getCartCheckoutUrl())) {
                        net.one97.paytm.insurance.a.a a8 = c.a();
                        k.a((Object) a8, "InsuranceHelper.getInsuranceListener()");
                        networkCustomError.setUrl(a8.getCartCheckoutUrl());
                        if (cJRRechargePayment.getError() != null) {
                            CJRError error = cJRRechargePayment.getError();
                            k.a((Object) error, "rechargePayment.error");
                            if (!TextUtils.isEmpty(error.getMessage())) {
                                CJRError error2 = cJRRechargePayment.getError();
                                k.a((Object) error2, "rechargePayment.error");
                                networkCustomError.setAlertMessage(error2.getMessage());
                            }
                        }
                    }
                    c.a().showSessionTimeoutAlert(this.f13434b, (String) null, (Bundle) null, networkCustomError);
                } else if (!(cJRRechargePayment == null || cJRRechargePayment.getError() == null)) {
                    CJRError error3 = cJRRechargePayment.getError();
                    k.a((Object) error3, "rechargePayment.error");
                    String title = error3.getTitle();
                    CJRError error4 = cJRRechargePayment.getError();
                    k.a((Object) error4, "rechargePayment.error");
                    com.paytm.utility.b.a((Context) this.f13434b, title, error4.getMessage());
                }
                c();
            }
        }
    }

    public final void a() {
        net.one97.paytm.insurance.a.a a2 = c.a();
        k.a((Object) a2, "InsuranceHelper.getInsuranceListener()");
        String b2 = com.paytm.utility.c.b(a2.getCartVerifyUrl(), (Context) this.f13434b);
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        HashMap<String, String> a3 = com.paytm.utility.b.a((HashMap<String, String>) hashMap, (Context) this.f13434b);
        k.a((Object) a3, "CJRAppCommonUtility.addS…eader(headers, mActivity)");
        com.paytm.network.a l = new com.paytm.network.b().a((Context) this.f13434b).a(a.C0715a.POST).a(a.c.INSURANCE).a(b2).b(new f().b(a(this.f13435c))).a((Map<String, String>) a3).a((IJRPaytmDataModel) new CJRRechargeCart()).c(y.b(this.f13434b.getClass()).toString()).a((com.paytm.network.listener.b) this).a(a.b.SILENT).l();
        if (l != null) {
            l.a();
        }
        b();
    }

    private static InsuranceCartObj a(SelectQuoteResponse selectQuoteResponse) {
        CartItem cartItem;
        List arrayList = new ArrayList();
        Object obj = null;
        if (!(!TextUtils.isEmpty(selectQuoteResponse != null ? selectQuoteResponse.getAmount() : null) || selectQuoteResponse == null || selectQuoteResponse.getConfiguration() == null)) {
            Configuration configuration = selectQuoteResponse.getConfiguration();
            selectQuoteResponse.setAmount(configuration != null ? configuration.getPrice() : null);
        }
        f.a.a aVar = f.a.a.f13515a;
        f.a.a.f("group");
        if ((selectQuoteResponse != null ? selectQuoteResponse.getProduct_id() : null) != null) {
            Integer product_id = selectQuoteResponse != null ? selectQuoteResponse.getProduct_id() : null;
            String amount = selectQuoteResponse != null ? selectQuoteResponse.getAmount() : null;
            f.a.a aVar2 = f.a.a.f13515a;
            Integer c2 = f.a.a.c();
            f.a.a aVar3 = f.a.a.f13515a;
            Configuration configuration2 = new Configuration(amount, c2, f.a.a.g());
            if (selectQuoteResponse != null) {
                obj = selectQuoteResponse.getMeta_data();
            }
            cartItem = new CartItem(product_id, 1, configuration2, obj);
        } else {
            Integer productId = selectQuoteResponse != null ? selectQuoteResponse.getProductId() : null;
            String amount2 = selectQuoteResponse != null ? selectQuoteResponse.getAmount() : null;
            f.a.a aVar4 = f.a.a.f13515a;
            Integer c3 = f.a.a.c();
            f.a.a aVar5 = f.a.a.f13515a;
            Configuration configuration3 = new Configuration(amount2, c3, f.a.a.g());
            if (selectQuoteResponse != null) {
                obj = selectQuoteResponse.getMeta_data();
            }
            cartItem = new CartItem(productId, 1, configuration3, obj);
        }
        arrayList.add(cartItem);
        return new InsuranceCartObj(arrayList);
    }

    private final void b() {
        Window window;
        Activity activity = this.f13434b;
        if (activity != null && !activity.isFinishing()) {
            ProgressDialog progressDialog = this.f13433a;
            if (progressDialog == null || progressDialog == null || !progressDialog.isShowing()) {
                this.f13433a = new ProgressDialog(this.f13434b);
                try {
                    ProgressDialog progressDialog2 = this.f13433a;
                    if (!(progressDialog2 == null || (window = progressDialog2.getWindow()) == null)) {
                        window.setBackgroundDrawable(new ColorDrawable(-1));
                    }
                    ProgressDialog progressDialog3 = this.f13433a;
                    if (progressDialog3 != null) {
                        progressDialog3.setIndeterminateDrawable(androidx.core.content.b.a((Context) this.f13434b, R.drawable.ins_custom_progress_bar));
                    }
                    ProgressDialog progressDialog4 = this.f13433a;
                    if (progressDialog4 != null) {
                        progressDialog4.setMessage(this.f13434b.getString(R.string.ins_please_wait_progress_msg));
                    }
                    ProgressDialog progressDialog5 = this.f13433a;
                    if (progressDialog5 != null) {
                        progressDialog5.setCancelable(false);
                    }
                    ProgressDialog progressDialog6 = this.f13433a;
                    if (progressDialog6 != null) {
                        progressDialog6.setCanceledOnTouchOutside(false);
                    }
                    ProgressDialog progressDialog7 = this.f13433a;
                    if (progressDialog7 != null) {
                        progressDialog7.show();
                    }
                } catch (IllegalArgumentException e2) {
                    if (com.paytm.utility.b.v) {
                        e2.printStackTrace();
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    private final void c() {
        Activity activity;
        ProgressDialog progressDialog = this.f13433a;
        if (progressDialog != null && progressDialog != null && progressDialog.isShowing() && (activity = this.f13434b) != null && !activity.isFinishing()) {
            ProgressDialog progressDialog2 = this.f13433a;
            if (progressDialog2 != null) {
                progressDialog2.dismiss();
            }
            this.f13433a = null;
        }
    }
}
