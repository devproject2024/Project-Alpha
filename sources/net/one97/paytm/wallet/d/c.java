package net.one97.paytm.wallet.d;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.business.merchant_payments.common.utility.AppUtility;
import com.google.gson.o;
import com.google.gson.p;
import com.google.gson.q;
import com.paytm.network.listener.b;
import com.paytm.network.model.NetworkCustomError;
import com.paytmmall.clpartifact.utils.CLPConstants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.one97.paytm.addmoney.R;
import net.one97.paytm.addmoney.utils.h;
import net.one97.paytm.addmoney.utils.j;
import net.one97.paytm.common.entity.CJRRechargeCart;
import net.one97.paytm.common.entity.offline_pg.pgTransactionRequest.CJRPGTransactionRequestUtils;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;
import net.one97.paytm.common.entity.shopping.CJRCartProduct;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.orflow.Utility;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.wallet.f.e;
import net.one97.paytm.wallet.f.f;
import net.one97.paytm.wallet.newdesign.addmoney.b.a;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

public class c implements b, net.one97.paytm.wallet.newdesign.addmoney.c.b {
    static final /* synthetic */ boolean v = (!c.class.desiredAssertionStatus());
    private String A;
    private Dialog B;
    private String C;
    private boolean D = false;
    private boolean E = false;
    private boolean F;
    private String G;
    private String H;
    private boolean I = false;
    private boolean J = true;
    private boolean K = false;
    private JSONArray L;
    private boolean M = false;
    private String N = "";
    private String O = "wallet";
    private String P = "";
    private long Q = 0;
    /* access modifiers changed from: private */
    public long R = 0;
    private JSONObject S;
    private boolean T = false;

    /* renamed from: a  reason: collision with root package name */
    public Activity f70164a;

    /* renamed from: b  reason: collision with root package name */
    public String f70165b;

    /* renamed from: c  reason: collision with root package name */
    public String f70166c = null;

    /* renamed from: d  reason: collision with root package name */
    public String f70167d;

    /* renamed from: e  reason: collision with root package name */
    public double f70168e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f70169f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f70170g = false;

    /* renamed from: h  reason: collision with root package name */
    public String f70171h;

    /* renamed from: i  reason: collision with root package name */
    public String f70172i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n = "0";
    public String o = "0";
    public String p;
    public boolean q;
    public String r;
    public String s;
    public CJRRechargeCart t;
    public double u = 0.0d;
    private net.one97.paytm.addmoney.common.b.b w;
    private f x;
    private e y;
    private a z;

    public final void b(String str) {
        this.P = str;
    }

    public final void c(String str) {
        try {
            this.L = new JSONArray(str);
            for (int i2 = 0; i2 < this.L.length(); i2++) {
                if (this.L.getJSONObject(i2).has("txnAmount")) {
                    this.L.getJSONObject(i2).remove("txnAmount");
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public c(boolean z2) {
        this.J = z2;
    }

    public c() {
    }

    public final void a(Activity activity, f fVar) {
        a(activity, fVar, "addPayMoneyWallet");
    }

    public final void a(Activity activity, f fVar, String str) {
        this.f70164a = activity;
        this.x = fVar;
        try {
            this.A = net.one97.paytm.helper.a.b().f("maxAmountPaytmcash");
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                e2.printStackTrace();
            }
        }
        this.N = str;
    }

    public final void a(e eVar) {
        this.y = eVar;
    }

    public final void a(Activity activity, f fVar, a aVar) {
        this.f70164a = activity;
        this.x = fVar;
        this.z = aVar;
        try {
            this.A = net.one97.paytm.helper.a.b().f("maxAmountPaytmcash");
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                e2.printStackTrace();
            }
        }
    }

    public final void a(boolean z2) {
        this.M = z2;
    }

    public final void a() {
        this.f70164a = null;
        this.x = null;
        this.z = null;
        this.p = null;
        this.K = false;
    }

    private void f() {
        try {
            if (this.B == null) {
                this.B = j.b(this.f70164a);
            }
            if (this.B != null && !this.B.isShowing()) {
                this.B.show();
            }
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                e2.printStackTrace();
            }
        }
    }

    private void g() {
        try {
            if (this.B != null && this.B.isShowing()) {
                this.B.dismiss();
            }
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                e2.printStackTrace();
            }
        }
    }

    public final void b() {
        f fVar = this.x;
        if (fVar != null) {
            fVar.onAddMoneyRequestStart();
        }
        if (this.J) {
            f();
        }
    }

    public final void c() {
        f fVar = this.x;
        if (fVar != null) {
            fVar.onAddMoneyRequestComplete();
        }
        if (this.J) {
            g();
        }
    }

    public final void d(String str) {
        String str2;
        Activity activity = this.f70164a;
        if (activity != null && !activity.isFinishing()) {
            if (TextUtils.isEmpty(this.p)) {
                this.p = "Add_Money";
            }
            if (this.f70170g) {
                g("send_money");
            }
            try {
                this.f70168e = 0.0d;
                this.f70165b = str;
                if (!TextUtils.isEmpty(str)) {
                    if (!str.equalsIgnoreCase(AppUtility.CENTER_DOT) && !h(str) && i(this.f70165b)) {
                        try {
                            HashMap hashMap = new HashMap();
                            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "BOTTOM NAV");
                            hashMap.put("wallet_add_amount", str);
                            hashMap.put(SDKConstants.EVENT_KEY_EVENT_LABEL4, this.P);
                            net.one97.paytm.helper.a.b().a("wallet_add_money_clicked", (Map<String, Object>) hashMap, this.f70164a.getApplicationContext());
                        } catch (Exception e2) {
                            if (com.paytm.utility.b.v) {
                                e2.printStackTrace();
                            }
                        }
                        if (j.a()) {
                            a(this.f70166c, true);
                            return;
                        } else {
                            a((b) this);
                            return;
                        }
                    }
                }
                if (j(this.f70165b)) {
                    Resources resources = this.f70164a.getResources();
                    int i2 = R.string.add_money_max_amount_error;
                    str2 = resources.getString(i2, new Object[]{this.f70164a.getString(R.string.rupees) + " " + this.A});
                } else {
                    str2 = this.f70164a.getResources().getString(R.string.invalid_amount);
                }
                try {
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("wallet_error_type", "add_money_error");
                    hashMap2.put("wallet_error_text", str2);
                    hashMap2.put(SDKConstants.EVENT_KEY_EVENT_LABEL4, this.P);
                    net.one97.paytm.helper.a.b().a("wallet_error_displayed", (Map<String, Object>) hashMap2, this.f70164a.getApplicationContext());
                } catch (Exception e3) {
                    if (com.paytm.utility.b.v) {
                        e3.printStackTrace();
                    }
                }
                if (this.x != null) {
                    this.x.onAddMoneyInvalidAmountEntered(str2);
                }
            } catch (Exception e4) {
                if (com.paytm.utility.b.v) {
                    e4.printStackTrace();
                }
            }
        }
    }

    private void g(String str) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("new_wallet_screen_type", str);
            hashMap.put(SDKConstants.EVENT_KEY_EVENT_LABEL4, this.P);
            net.one97.paytm.helper.a.b().a("new_wallet_pay_insufficient_balance_screen_loaded", (Map<String, Object>) hashMap, this.f70164a.getApplicationContext());
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                e2.printStackTrace();
            }
        }
    }

    private static boolean h(String str) {
        try {
            return Double.parseDouble(str) == 0.0d;
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                e2.printStackTrace();
            }
            return false;
        }
    }

    public final void a(String str, boolean z2, String str2) {
        this.f70165b = str;
        this.f70170g = z2;
        this.p = str2;
        d(str);
    }

    public final void a(String str, String str2) {
        Activity activity = this.f70164a;
        if (activity != null && !activity.isFinishing()) {
            this.f70165b = str;
            if (!TextUtils.isEmpty(this.f70165b)) {
                a(str2);
                return;
            }
            f fVar = this.x;
            if (fVar != null) {
                fVar.onAddMoneyInvalidAmountEntered(this.f70164a.getResources().getString(R.string.invalid_amount));
            }
        }
    }

    public final void d() {
        this.f70166c = null;
    }

    public final void e(String str) {
        this.f70166c = str;
    }

    private boolean i(String str) {
        Activity activity = this.f70164a;
        if (activity != null && !activity.isFinishing()) {
            try {
                if (!TextUtils.isEmpty(str) && !j(this.f70165b) && !k(this.f70165b)) {
                    return true;
                }
                return false;
            } catch (Exception e2) {
                if (com.paytm.utility.b.v) {
                    e2.printStackTrace();
                }
            }
        }
        return false;
    }

    private boolean j(String str) {
        Activity activity = this.f70164a;
        if (activity != null && !activity.isFinishing()) {
            try {
                if (!TextUtils.isEmpty(this.A) && !TextUtils.isEmpty(str)) {
                    if (Double.parseDouble(str) > Double.parseDouble(this.A)) {
                        return true;
                    }
                }
            } catch (Exception e2) {
                if (com.paytm.utility.b.v) {
                    e2.printStackTrace();
                }
            }
        }
        return false;
    }

    private boolean k(String str) {
        Activity activity = this.f70164a;
        if (activity != null && !activity.isFinishing()) {
            try {
                if (TextUtils.isEmpty(str) || Double.parseDouble(str) >= 1.0d) {
                    return false;
                }
                return true;
            } catch (NumberFormatException e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }

    public final void e() {
        Activity activity = this.f70164a;
        if (activity != null && !activity.isFinishing()) {
            c();
            j.a(this.f70164a);
        }
    }

    public static String a(double d2) {
        int i2 = (int) d2;
        if (d2 > ((double) i2)) {
            return String.valueOf(d2);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(i2);
        return sb.toString();
    }

    private void a(String str, boolean z2) {
        Activity activity = this.f70164a;
        if (activity != null && !activity.isFinishing()) {
            this.f70169f = z2;
            JSONObject f2 = f(str);
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", "application/json");
            hashMap.put("x-user-id", com.paytm.utility.b.n((Context) this.f70164a));
            if (!j.a() || !this.f70169f) {
                this.f70167d = net.one97.paytm.helper.a.b().f("cartVerify");
            } else {
                if (net.one97.paytm.helper.a.b().h("addMoneyDeferedApiVersion") == 1) {
                    this.f70167d = net.one97.paytm.helper.a.b().f("addMoneyCartVerify");
                } else {
                    this.f70167d = net.one97.paytm.helper.a.b().f("addMoneyCartVerifyV2");
                }
                this.f70167d += "?payment_info=1&payment_info_version=2";
            }
            this.f70167d = com.paytm.utility.b.b((Context) this.f70164a, this.f70167d);
            net.one97.paytm.wallet.utility.f fVar = net.one97.paytm.wallet.utility.f.f72321a;
            this.f70167d = net.one97.paytm.wallet.utility.f.a(this.f70167d);
            net.one97.paytm.wallet.utility.f fVar2 = net.one97.paytm.wallet.utility.f.f72321a;
            this.f70167d = net.one97.paytm.wallet.utility.f.b(this.f70167d);
            this.f70167d = net.one97.paytm.helper.a.b().i(this.f70167d);
            this.f70167d += "&source=paytm-app";
            if (com.paytm.utility.b.c((Context) this.f70164a)) {
                this.C = str;
                b();
                com.paytm.network.b b2 = net.one97.paytm.addmoney.common.a.b();
                b2.f42877a = this.f70164a.getApplicationContext();
                b2.f42884h = f2.toString();
                b2.k = false;
                b2.f42885i = new CJRRechargeCart();
                b2.f42882f = hashMap;
                b2.j = this;
                b2.f42880d = this.f70167d;
                com.paytm.network.a l2 = b2.l();
                l2.a((Object) this.f70164a.getClass().getSimpleName());
                l2.a();
                return;
            }
            e();
        }
    }

    public final JSONObject f(String str) {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject2 = new JSONObject();
        try {
            if (this.E) {
                jSONObject2.put(CLPConstants.PRODUCT_ID, net.one97.paytm.helper.a.b().f("bankProductIdAddMoney"));
            } else {
                this.I = true;
                jSONObject2.put(CLPConstants.PRODUCT_ID, net.one97.paytm.helper.a.b().f("PaytmCashProductId"));
            }
            if (this.q) {
                jSONObject2.put(CLPConstants.PRODUCT_ID, net.one97.paytm.helper.a.b().f("PaytmGiftVoucherProductId"));
            }
            if (this.F) {
                jSONObject2.put(CLPConstants.PRODUCT_ID, this.H);
            }
            jSONObject2.put("qty", 1);
            if (Double.compare(this.u, 0.0d) != 0) {
                jSONObject2.put("wallet_conv_fee", this.u);
            }
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("price", Double.parseDouble(this.f70165b));
            if (Double.compare(this.f70168e, 0.0d) != 0) {
                jSONObject3.put("rcf", this.f70168e);
            }
            jSONObject2.put(CLConstants.INPUT_KEY_CONFIGURATION, jSONObject3);
            jSONArray.put(jSONObject2);
            jSONObject.put("cart_items", jSONArray);
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put(Utility.EVENT_CATEGORY_PROMOCODE, str);
            }
            if (this.F) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("lender", this.G);
                jSONObject4.put("source", "ANDROID");
                jSONObject2.put("meta_data", jSONObject4);
            } else if (!TextUtils.isEmpty(this.p)) {
                jSONObject.put("merc_uniq_ref", this.p);
            }
            if (!(this.L == null || this.L.length() <= 0 || net.one97.paytm.helper.a.b().h("addMoneyDeferedApiVersion") == 1)) {
                jSONObject.put("payment_intent", this.L);
                this.L = null;
            }
            if (this.S != null) {
                jSONObject.put("payment_offers_applied", this.S);
                this.S = null;
            }
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                e2.printStackTrace();
            }
        }
        return jSONObject;
    }

    private void h() {
        e eVar;
        Activity activity = this.f70164a;
        if (activity != null && !activity.isFinishing()) {
            if (!TextUtils.isEmpty(h.a(this.f70164a.getApplicationContext()).b("sso_token=", "", true))) {
                b();
                net.one97.paytm.helper.a.b().a(this.f70164a, (b) this);
                return;
            }
            this.T = false;
            if (!this.M || (eVar = this.y) == null) {
                net.one97.paytm.helper.a.b().a(this.f70164a, (String) null, (Bundle) null);
            } else {
                eVar.a();
            }
        }
    }

    public final void a(b bVar) {
        String str;
        Activity activity = this.f70164a;
        if (activity != null && !activity.isFinishing()) {
            JSONObject f2 = f(this.f70166c);
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", "application/json");
            hashMap.put("x-user-id", com.paytm.utility.b.n((Context) this.f70164a));
            net.one97.paytm.helper.a.b().k();
            if (this.f70164a != null) {
                net.one97.paytm.helper.a.b().a((Context) this.f70164a, (String) null, (String) null, (String) null);
            }
            String d2 = net.one97.paytm.helper.a.b().d();
            if (!TextUtils.isEmpty(d2)) {
                hashMap.put("risk_extended_info", d2);
            }
            net.one97.paytm.helper.a.b().k();
            if (!j.a()) {
                str = net.one97.paytm.helper.a.b().f("cartCheckout");
            } else if (this.T || net.one97.paytm.helper.a.b().h("addMoneyDeferedApiVersion") == 1) {
                str = net.one97.paytm.helper.a.b().f("addMoneyCartCheckout");
            } else {
                str = net.one97.paytm.helper.a.b().f("addMoneyCartCheckoutV2");
            }
            String b2 = com.paytm.utility.b.b((Context) this.f70164a, str);
            net.one97.paytm.wallet.utility.f fVar = net.one97.paytm.wallet.utility.f.f72321a;
            String a2 = net.one97.paytm.wallet.utility.f.a(b2);
            String k2 = com.paytm.utility.b.k();
            Uri.Builder buildUpon = Uri.parse(a2).buildUpon();
            buildUpon.appendQueryParameter("client_id", k2);
            String uri = buildUpon.build().toString();
            net.one97.paytm.wallet.utility.f fVar2 = net.one97.paytm.wallet.utility.f.f72321a;
            String d3 = com.paytm.utility.b.d(net.one97.paytm.wallet.utility.f.b(uri), "POST");
            if (net.one97.paytm.helper.a.b().g("shouldUseUniversalAddMoneyNative7.4") && this.I) {
                d3 = net.one97.paytm.helper.a.b().i(d3);
            }
            String str2 = d3 + "&source=paytm-app";
            if (com.paytm.utility.b.c((Context) this.f70164a)) {
                b();
                com.paytm.network.b b3 = net.one97.paytm.addmoney.common.a.b();
                b3.f42877a = this.f70164a.getApplicationContext();
                b3.f42884h = f2.toString();
                b3.f42885i = new CJRRechargePayment();
                b3.f42882f = hashMap;
                b3.j = bVar;
                b3.k = false;
                b3.f42880d = str2;
                com.paytm.network.a l2 = b3.l();
                l2.a((Object) this.f70164a.getClass().getSimpleName());
                l2.a();
                this.Q = System.currentTimeMillis();
                return;
            }
            e();
        }
    }

    private static boolean a(NetworkCustomError networkCustomError) {
        if (networkCustomError == null || networkCustomError.networkResponse == null) {
            return false;
        }
        return networkCustomError.networkResponse.statusCode == 403 || networkCustomError.networkResponse.statusCode == 401 || networkCustomError.networkResponse.statusCode == 410;
    }

    /* access modifiers changed from: private */
    public boolean a(CJRRechargeCart cJRRechargeCart) {
        if (cJRRechargeCart == null || cJRRechargeCart.getCart() == null || TextUtils.isEmpty(cJRRechargeCart.getCart().getErrorCode())) {
            return false;
        }
        String errorCode = cJRRechargeCart.getCart().getErrorCode();
        if (!errorCode.equalsIgnoreCase("RWL_1000") && !errorCode.equalsIgnoreCase("RWL_0003") && !errorCode.equalsIgnoreCase("RWL_1001")) {
            return false;
        }
        String errorInfo = cJRRechargeCart.getCart().getErrorInfo();
        String error = cJRRechargeCart.getCart().getError();
        Activity activity = this.f70164a;
        if (activity != null && !activity.isFinishing() && !TextUtils.isEmpty(error)) {
            if (TextUtils.isEmpty(errorInfo) || !errorInfo.equalsIgnoreCase("PRIME")) {
                try {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this.f70164a);
                    builder.setTitle(this.f70164a.getString(R.string.add_money));
                    builder.setMessage(error);
                    builder.setPositiveButton(this.f70164a.getString(R.string.ok), new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            if (c.this.f70164a != null) {
                                try {
                                    c.this.f70164a.startActivity(net.one97.paytm.helper.a.b().l(c.this.f70164a));
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                }
                            }
                        }
                    });
                    builder.setNegativeButton(this.f70164a.getString(R.string.cancel), new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            if (c.this.f70164a == null) {
                                c.this.f70164a.isFinishing();
                            }
                        }
                    });
                    builder.setCancelable(true);
                    builder.show();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } else {
                Activity activity2 = this.f70164a;
                com.paytm.utility.b.b((Context) activity2, activity2.getString(R.string.add_money), error);
            }
        }
        return true;
    }

    /* access modifiers changed from: private */
    public void a(CJRRechargePayment cJRRechargePayment, String str) {
        HashMap<String, String> hashMap;
        Intent f2 = net.one97.paytm.helper.a.b().f(this.f70164a);
        f2.putExtra(SDKConstants.PAYMENT_INFO, cJRRechargePayment);
        f2.putExtra(UpiConstants.FROM, "Add_to_paytm_cash");
        f2.putExtra("intent_extra_wallet_send_money_insufficient_balance_error", true);
        f2.putExtra("intent_extra_wallet_email", this.f70171h);
        f2.putExtra("intent_extra_wallet_phone_number", this.f70172i);
        f2.putExtra("intent_extra_wallet_payee_sso_id", this.j);
        f2.putExtra("intent_extra_wallet_send_money_amount", this.k);
        f2.putExtra("intent_extra_wallet_comment", this.l);
        f2.putExtra("intent_extra_wallet_request_code", this.m);
        f2.putExtra("intent_extra_wallet_is_to_verify", this.n);
        f2.putExtra("intent_extra_wallet_is_limit_applicable", this.o);
        f2.putExtra("is_bank_add_money", this.E);
        f2.putExtra("is_for_Gift_voucher", this.q);
        f2.putExtra("isSessionTimeoutCallbackRequiredH5", this.M);
        f2.putExtra("vertical_name", this.N);
        if (str != null) {
            f2.putExtra(CJRRechargeCart.KEY_PAYMENT_INSTRUMENT, str);
        }
        net.one97.paytm.helper.a.b().a(cJRRechargePayment, f2);
        if (this.f70170g) {
            f2.putExtra("add_money_title_key", String.format(this.f70164a.getString(R.string.add_n_pay_money_title), new Object[]{this.f70165b}));
        }
        if (!TextUtils.isEmpty(this.r) && (hashMap = cJRRechargePayment.getmPGParams()) != null) {
            hashMap.put((this.r.equalsIgnoreCase(net.one97.paytm.common.utility.j.FIXED.name()) || this.r.equalsIgnoreCase(net.one97.paytm.common.utility.j.GENERIC.name())) ? CJRPGTransactionRequestUtils.LINK_ID : CJRPGTransactionRequestUtils.INVOICE_ID, this.s);
        }
        net.one97.paytm.helper.a.b().a(this.f70164a, f2, this);
    }

    public final void a(String str) {
        this.D = true;
        a(str, false);
    }

    public final void b(boolean z2) {
        this.q = z2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:106:0x01dd  */
    /* JADX WARNING: Removed duplicated region for block: B:160:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onApiSuccess(com.paytm.network.model.IJRPaytmDataModel r15) {
        /*
            r14 = this;
            android.app.Activity r0 = r14.f70164a
            if (r0 == 0) goto L_0x031c
            boolean r0 = r0.isFinishing()
            if (r0 == 0) goto L_0x000c
            goto L_0x031c
        L_0x000c:
            r14.c()
            boolean r0 = r15 instanceof net.one97.paytm.common.entity.CJRRechargeCart
            r1 = 1
            java.lang.String r2 = "1"
            java.lang.String r3 = "SUCCESS"
            r4 = 0
            r5 = 0
            if (r0 == 0) goto L_0x01e3
            net.one97.paytm.common.entity.CJRRechargeCart r15 = (net.one97.paytm.common.entity.CJRRechargeCart) r15
            r14.t = r15
            net.one97.paytm.common.entity.CJRRechargeCart r15 = r14.t
            boolean r0 = r14.a((net.one97.paytm.common.entity.CJRRechargeCart) r15)
            if (r0 != 0) goto L_0x01c5
            android.app.Activity r0 = r14.f70164a
            int r6 = net.one97.paytm.addmoney.R.string.unable_to_proceed
            java.lang.String r6 = r0.getString(r6)
            boolean r0 = a((net.one97.paytm.common.entity.CJRRechargeCart) r15, (android.content.Context) r0, (java.lang.String) r6)
            if (r0 != 0) goto L_0x01c5
            net.one97.paytm.common.entity.shopping.CJRCartStatus r0 = r15.getCartStatus()
            if (r0 == 0) goto L_0x01c5
            net.one97.paytm.common.entity.shopping.CJRCartStatus r0 = r15.getCartStatus()
            java.lang.String r0 = r0.getResult()
            boolean r0 = r3.equalsIgnoreCase(r0)
            if (r0 == 0) goto L_0x01c5
            net.one97.paytm.common.entity.shopping.CJRCart r0 = r15.getCart()
            net.one97.paytm.helper.c r6 = net.one97.paytm.helper.a.b()
            android.app.Activity r7 = r14.f70164a
            r6.a((android.app.Activity) r7, (net.one97.paytm.common.entity.shopping.CJRCart) r0)
            boolean r6 = r14.D
            if (r6 == 0) goto L_0x006a
            r14.D = r4
            if (r0 == 0) goto L_0x006a
            java.util.ArrayList r6 = r0.getCartItems()
            if (r6 == 0) goto L_0x006a
            java.util.ArrayList r6 = r0.getCartItems()
            r6.size()
        L_0x006a:
            android.app.Activity r6 = r14.f70164a
            if (r6 == 0) goto L_0x0160
            boolean r6 = r6.isFinishing()
            if (r6 == 0) goto L_0x0076
            goto L_0x0160
        L_0x0076:
            if (r0 == 0) goto L_0x00e5
            java.lang.String r6 = r0.getPromoStatus()
            if (r6 == 0) goto L_0x00e5
            java.lang.String r6 = r0.getPromoStatus()
            boolean r3 = r6.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x00e5
            java.util.ArrayList r3 = r0.getCartItems()
            if (r3 == 0) goto L_0x00ab
            java.util.ArrayList r3 = r0.getCartItems()
            int r3 = r3.size()
            if (r3 <= 0) goto L_0x00ab
            java.util.ArrayList r3 = r0.getCartItems()
            java.lang.Object r3 = r3.get(r4)
            net.one97.paytm.common.entity.shopping.CJRCartProduct r3 = (net.one97.paytm.common.entity.shopping.CJRCartProduct) r3
            java.lang.String r4 = r3.getPromoCode()
            java.lang.String r3 = r3.getPromoText()
            goto L_0x00ad
        L_0x00ab:
            r3 = r5
            r4 = r3
        L_0x00ad:
            boolean r6 = android.text.TextUtils.isEmpty(r4)
            if (r6 == 0) goto L_0x00bb
            net.one97.paytm.addmoney.common.b.b r6 = r14.w
            if (r6 == 0) goto L_0x00bb
            java.lang.String r4 = r6.b()
        L_0x00bb:
            r14.f70166c = r4
            boolean r6 = android.text.TextUtils.isEmpty(r3)
            if (r6 == 0) goto L_0x00c7
            java.lang.String r3 = r0.getPromoText()
        L_0x00c7:
            net.one97.paytm.addmoney.common.b.b r6 = r14.w
            if (r6 == 0) goto L_0x00d6
            boolean r6 = r6.isShowing()
            if (r6 == 0) goto L_0x00d6
            net.one97.paytm.addmoney.common.b.b r6 = r14.w
            r6.a(r4, r3)
        L_0x00d6:
            boolean r4 = r14.f70169f
            if (r4 != 0) goto L_0x015e
            net.one97.paytm.wallet.newdesign.addmoney.b.a r4 = r14.z
            if (r4 == 0) goto L_0x015e
            java.lang.String r6 = r14.f70166c
            r4.a(r6, r3)
            goto L_0x015e
        L_0x00e5:
            r14.f70166c = r5
            if (r0 == 0) goto L_0x00ee
            java.lang.String r3 = r0.getPromoFailureText()
            goto L_0x00ef
        L_0x00ee:
            r3 = r5
        L_0x00ef:
            if (r3 == 0) goto L_0x00fb
            java.lang.String r4 = r3.trim()
            int r4 = r4.length()
            if (r4 != 0) goto L_0x0107
        L_0x00fb:
            android.app.Activity r3 = r14.f70164a
            android.content.res.Resources r3 = r3.getResources()
            int r4 = net.one97.paytm.addmoney.R.string.msg_invalid_recharge_promo_code
            java.lang.String r3 = r3.getString(r4)
        L_0x0107:
            java.util.HashMap r4 = new java.util.HashMap     // Catch:{ Exception -> 0x013a }
            r4.<init>()     // Catch:{ Exception -> 0x013a }
            java.lang.String r6 = "wallet_error_type"
            java.lang.String r7 = "add_money_error"
            r4.put(r6, r7)     // Catch:{ Exception -> 0x013a }
            java.lang.String r6 = "wallet_error_text"
            r4.put(r6, r3)     // Catch:{ Exception -> 0x013a }
            java.lang.String r6 = "wallet_error_promocode"
            net.one97.paytm.addmoney.common.b.b r7 = r14.w     // Catch:{ Exception -> 0x013a }
            java.lang.String r7 = r7.b()     // Catch:{ Exception -> 0x013a }
            r4.put(r6, r7)     // Catch:{ Exception -> 0x013a }
            java.lang.String r6 = "event_label4"
            java.lang.String r7 = r14.P     // Catch:{ Exception -> 0x013a }
            r4.put(r6, r7)     // Catch:{ Exception -> 0x013a }
            net.one97.paytm.helper.c r6 = net.one97.paytm.helper.a.b()     // Catch:{ Exception -> 0x013a }
            java.lang.String r7 = "wallet_error_displayed"
            android.app.Activity r8 = r14.f70164a     // Catch:{ Exception -> 0x013a }
            android.content.Context r8 = r8.getApplicationContext()     // Catch:{ Exception -> 0x013a }
            r6.a((java.lang.String) r7, (java.util.Map<java.lang.String, java.lang.Object>) r4, (android.content.Context) r8)     // Catch:{ Exception -> 0x013a }
            goto L_0x0142
        L_0x013a:
            r4 = move-exception
            boolean r6 = com.paytm.utility.b.v
            if (r6 == 0) goto L_0x0142
            r4.printStackTrace()
        L_0x0142:
            net.one97.paytm.addmoney.common.b.b r4 = r14.w
            if (r4 == 0) goto L_0x0151
            boolean r4 = r4.isShowing()
            if (r4 == 0) goto L_0x0151
            net.one97.paytm.addmoney.common.b.b r4 = r14.w
            r4.a((java.lang.String) r3)
        L_0x0151:
            boolean r4 = r14.f70169f
            if (r4 != 0) goto L_0x015e
            net.one97.paytm.wallet.newdesign.addmoney.b.a r4 = r14.z
            if (r4 == 0) goto L_0x015e
            java.lang.String r6 = r14.C
            r4.b(r6, r3)
        L_0x015e:
            r14.C = r5
        L_0x0160:
            boolean r3 = net.one97.paytm.addmoney.utils.j.a()
            if (r3 == 0) goto L_0x01bd
            boolean r3 = r14.f70169f
            if (r3 == 0) goto L_0x01bd
            com.google.gsonhtcfix.o r0 = r0.getPaymentInfo()
            java.lang.String r3 = "native_withdraw"
            com.google.gsonhtcfix.l r0 = r0.b(r3)
            if (r0 == 0) goto L_0x01b3
            java.lang.String r0 = r0.b()
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x01b3
            com.google.gsonhtcfix.f r0 = new com.google.gsonhtcfix.f
            r0.<init>()
            net.one97.paytm.common.entity.shopping.CJRCart r1 = r15.getCart()
            com.google.gsonhtcfix.o r1 = r1.getPaymentInfo()
            java.lang.String r1 = r0.a((com.google.gsonhtcfix.l) r1)
            net.one97.paytm.common.entity.recharge.CJRRechargePayment r2 = new net.one97.paytm.common.entity.recharge.CJRRechargePayment
            r2.<init>()
            r2.parseResponse(r1, r0)     // Catch:{ Exception -> 0x019a }
            goto L_0x019e
        L_0x019a:
            r0 = move-exception
            r0.printStackTrace()
        L_0x019e:
            com.google.gsonhtcfix.f r0 = new com.google.gsonhtcfix.f
            r0.<init>()
            net.one97.paytm.common.entity.shopping.CJRCart r15 = r15.getCart()
            com.google.gsonhtcfix.o r15 = r15.getPaymentInstruments()
            java.lang.String r15 = r0.a((com.google.gsonhtcfix.l) r15)
            r14.a((net.one97.paytm.common.entity.recharge.CJRRechargePayment) r2, (java.lang.String) r15)
            goto L_0x01d9
        L_0x01b3:
            boolean r15 = r14.f70169f
            if (r15 == 0) goto L_0x01d9
            r14.T = r1
            r14.h()
            goto L_0x01d9
        L_0x01bd:
            boolean r15 = r14.f70169f
            if (r15 == 0) goto L_0x01d9
            r14.h()
            goto L_0x01d9
        L_0x01c5:
            net.one97.paytm.addmoney.common.b.b r15 = r14.w
            if (r15 == 0) goto L_0x01d9
            r15.a()
            net.one97.paytm.addmoney.common.b.b r15 = r14.w
            boolean r15 = r15.isShowing()
            if (r15 == 0) goto L_0x01d9
            net.one97.paytm.addmoney.common.b.b r15 = r14.w
            r15.dismiss()
        L_0x01d9:
            net.one97.paytm.wallet.f.f r15 = r14.x
            if (r15 == 0) goto L_0x031c
            java.lang.String r0 = r14.f70166c
            r15.onAddMoneyVerifyResponse(r0)
            return
        L_0x01e3:
            boolean r0 = r15 instanceof net.one97.paytm.common.entity.CJRPGTokenList
            if (r0 == 0) goto L_0x0213
            net.one97.paytm.common.entity.CJRPGTokenList r15 = (net.one97.paytm.common.entity.CJRPGTokenList) r15
            net.one97.paytm.helper.c r0 = net.one97.paytm.helper.a.b()
            java.lang.String r15 = r0.a((net.one97.paytm.common.entity.CJRPGTokenList) r15)
            boolean r15 = android.text.TextUtils.isEmpty(r15)
            if (r15 != 0) goto L_0x01fb
            r14.a((com.paytm.network.listener.b) r14)
            return
        L_0x01fb:
            r14.T = r4
            boolean r15 = r14.M
            if (r15 == 0) goto L_0x0209
            net.one97.paytm.wallet.f.e r15 = r14.y
            if (r15 == 0) goto L_0x0209
            r15.a()
            return
        L_0x0209:
            net.one97.paytm.helper.c r15 = net.one97.paytm.helper.a.b()
            android.app.Activity r0 = r14.f70164a
            r15.a((android.app.Activity) r0, (java.lang.String) r5, (android.os.Bundle) r5)
            return
        L_0x0213:
            boolean r0 = r15 instanceof net.one97.paytm.common.entity.recharge.CJRRechargePayment
            if (r0 == 0) goto L_0x031c
            net.one97.paytm.common.entity.recharge.CJRRechargePayment r15 = (net.one97.paytm.common.entity.recharge.CJRRechargePayment) r15
            java.lang.String r0 = r15.getStatus()
            java.lang.String r6 = "cartCheckout"
            if (r0 == 0) goto L_0x024e
            java.lang.String r0 = r15.getStatus()
            boolean r0 = r0.equalsIgnoreCase(r3)
            if (r0 == 0) goto L_0x024e
            java.lang.String r0 = r15.isNativeEnabled()
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x0249
            net.one97.paytm.helper.c r0 = net.one97.paytm.helper.a.b()
            android.app.Activity r2 = r14.f70164a
            android.content.Context r2 = r2.getApplicationContext()
            net.one97.paytm.wallet.d.c$5 r3 = new net.one97.paytm.wallet.d.c$5
            r3.<init>(r15)
            r0.a((android.content.Context) r2, (net.one97.paytm.common.entity.recharge.CJRRechargePayment) r15, (net.one97.paytm.addmoney.togv.b.c) r3)
            goto L_0x02d8
        L_0x0249:
            r14.a((net.one97.paytm.common.entity.recharge.CJRRechargePayment) r15, (java.lang.String) r5)
            goto L_0x02d8
        L_0x024e:
            if (r15 == 0) goto L_0x02bb
            int r0 = r15.getCode()
            r2 = 401(0x191, float:5.62E-43)
            if (r0 == r2) goto L_0x0268
            int r0 = r15.getCode()
            r2 = 403(0x193, float:5.65E-43)
            if (r0 == r2) goto L_0x0268
            int r0 = r15.getCode()
            r2 = 410(0x19a, float:5.75E-43)
            if (r0 != r2) goto L_0x02bb
        L_0x0268:
            com.paytm.network.model.NetworkCustomError r0 = new com.paytm.network.model.NetworkCustomError
            r0.<init>()
            boolean r2 = r14.M
            if (r2 == 0) goto L_0x0279
            net.one97.paytm.wallet.f.e r2 = r14.y
            if (r2 == 0) goto L_0x0279
            r2.a()
            goto L_0x02da
        L_0x0279:
            net.one97.paytm.helper.c r2 = net.one97.paytm.helper.a.b()
            java.lang.String r2 = r2.f((java.lang.String) r6)
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x02b1
            net.one97.paytm.helper.c r2 = net.one97.paytm.helper.a.b()
            java.lang.String r2 = r2.f((java.lang.String) r6)
            r0.setUrl(r2)
            com.paytm.network.model.CJRError r2 = r15.getError()
            if (r2 == 0) goto L_0x02b1
            com.paytm.network.model.CJRError r2 = r15.getError()
            java.lang.String r2 = r2.getMessage()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x02b1
            com.paytm.network.model.CJRError r15 = r15.getError()
            java.lang.String r15 = r15.getMessage()
            r0.setAlertMessage(r15)
        L_0x02b1:
            net.one97.paytm.helper.c r15 = net.one97.paytm.helper.a.b()
            android.app.Activity r0 = r14.f70164a
            r15.a((android.app.Activity) r0, (java.lang.String) r5, (android.os.Bundle) r5)
            goto L_0x02da
        L_0x02bb:
            if (r15 == 0) goto L_0x02d8
            com.paytm.network.model.CJRError r0 = r15.getError()
            if (r0 == 0) goto L_0x02d8
            android.app.Activity r0 = r14.f70164a
            com.paytm.network.model.CJRError r2 = r15.getError()
            java.lang.String r2 = r2.getTitle()
            com.paytm.network.model.CJRError r15 = r15.getError()
            java.lang.String r15 = r15.getMessage()
            net.one97.paytm.addmoney.utils.j.a((android.app.Activity) r0, (java.lang.String) r2, (java.lang.String) r15)
        L_0x02d8:
            r14.T = r4
        L_0x02da:
            long r2 = java.lang.System.currentTimeMillis()
            long r7 = r14.Q
            long r2 = r2 - r7
            android.app.Activity r7 = r14.f70164a
            net.one97.paytm.helper.c r15 = net.one97.paytm.helper.a.b()
            java.lang.String r0 = "wallet_merchant_id"
            java.lang.String r9 = r15.f((java.lang.String) r0)
            java.lang.String r10 = r14.N
            java.util.ArrayList r11 = new java.util.ArrayList
            r15 = 4
            java.lang.String[] r15 = new java.lang.String[r15]
            net.one97.paytm.helper.c r0 = net.one97.paytm.helper.a.b()
            java.lang.String r0 = r0.f((java.lang.String) r6)
            r15[r4] = r0
            java.lang.String r0 = ""
            r15[r1] = r0
            r1 = 2
            r15[r1] = r0
            r0 = 3
            java.lang.String r1 = r14.P
            r15[r0] = r1
            java.util.List r15 = java.util.Arrays.asList(r15)
            r11.<init>(r15)
            java.lang.String r12 = java.lang.String.valueOf(r2)
            java.lang.String r13 = r14.O
            java.lang.String r8 = "payment_gateway"
            net.one97.paytm.addmoney.utils.d.a(r7, r8, r9, r10, r11, r12, r13)
        L_0x031c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.wallet.d.c.onApiSuccess(com.paytm.network.model.IJRPaytmDataModel):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00a2, code lost:
        if (r22.getNetworkResponse().statusCode != 401) goto L_0x00a4;
     */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x0221 A[Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }] */
    /* JADX WARNING: Removed duplicated region for block: B:125:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00bb A[Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00d0 A[Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00d3 A[Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00de A[Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00f5 A[Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void handleErrorCode(int r20, com.paytm.network.model.IJRPaytmDataModel r21, com.paytm.network.model.NetworkCustomError r22) {
        /*
            r19 = this;
            r1 = r19
            r0 = r22
            java.lang.String r9 = ""
            r10 = 0
            r1.T = r10
            com.paytm.network.model.NetworkCustomError r2 = b((com.paytm.network.model.NetworkCustomError) r22)
            android.app.Activity r3 = r1.f70164a
            if (r3 == 0) goto L_0x027c
            boolean r3 = r3.isFinishing()
            if (r3 == 0) goto L_0x0019
            goto L_0x027c
        L_0x0019:
            r19.c()
            boolean r3 = r1.M
            if (r3 == 0) goto L_0x0030
            net.one97.paytm.wallet.f.e r3 = r1.y
            if (r3 == 0) goto L_0x0030
            boolean r3 = a((com.paytm.network.model.NetworkCustomError) r22)
            if (r3 == 0) goto L_0x0030
            net.one97.paytm.wallet.f.e r0 = r1.y
            r0.a()
            return
        L_0x0030:
            android.app.Activity r3 = r1.f70164a
            r4 = 0
            if (r3 == 0) goto L_0x0086
            boolean r3 = r3.isFinishing()
            if (r3 == 0) goto L_0x003c
            goto L_0x0086
        L_0x003c:
            if (r2 == 0) goto L_0x005d
            java.lang.String r3 = r2.getFullUrl()
            java.lang.String r5 = r1.f70167d
            if (r5 == 0) goto L_0x005d
            if (r3 == 0) goto L_0x005d
            boolean r3 = r3.equalsIgnoreCase(r5)
            if (r3 == 0) goto L_0x005d
            net.one97.paytm.addmoney.common.b.b r3 = r1.w
            if (r3 == 0) goto L_0x005d
            boolean r3 = r3.isShowing()
            if (r3 == 0) goto L_0x005d
            net.one97.paytm.addmoney.common.b.b r3 = r1.w
            r3.dismiss()
        L_0x005d:
            boolean r3 = r1.M
            if (r3 == 0) goto L_0x0071
            net.one97.paytm.wallet.f.e r3 = r1.y
            if (r3 == 0) goto L_0x0071
            boolean r3 = a((com.paytm.network.model.NetworkCustomError) r2)
            if (r3 == 0) goto L_0x0071
            net.one97.paytm.wallet.f.e r3 = r1.y
            r3.a()
            goto L_0x0086
        L_0x0071:
            boolean r3 = r1.f70169f
            if (r3 != 0) goto L_0x0086
            net.one97.paytm.wallet.newdesign.addmoney.b.a r3 = r1.z
            if (r3 == 0) goto L_0x0086
            java.lang.String r5 = r1.f70166c
            if (r2 == 0) goto L_0x0082
            java.lang.String r6 = r2.getAlertMessage()
            goto L_0x0083
        L_0x0082:
            r6 = r4
        L_0x0083:
            r3.b(r5, r6)
        L_0x0086:
            if (r0 == 0) goto L_0x027c
            com.paytm.network.model.NetworkResponse r3 = r22.getNetworkResponse()     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            java.lang.String r11 = "cartCheckout"
            if (r3 == 0) goto L_0x00a4
            com.paytm.network.model.NetworkResponse r3 = r22.getNetworkResponse()     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            int r3 = r3.statusCode     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            r5 = 410(0x19a, float:5.75E-43)
            if (r3 == r5) goto L_0x00ae
            com.paytm.network.model.NetworkResponse r3 = r22.getNetworkResponse()     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            int r3 = r3.statusCode     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            r5 = 401(0x191, float:5.62E-43)
            if (r3 == r5) goto L_0x00ae
        L_0x00a4:
            com.paytm.network.model.NetworkResponse r3 = r22.getNetworkResponse()     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            int r3 = r3.statusCode     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            r5 = 403(0x193, float:5.65E-43)
            if (r3 != r5) goto L_0x0103
        L_0x00ae:
            android.os.Bundle r5 = new android.os.Bundle     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            r5.<init>()     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            java.lang.String r2 = r1.f70165b     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            if (r2 != 0) goto L_0x00ca
            java.lang.String r2 = "amount"
            java.lang.String r3 = r1.f70165b     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            java.lang.Double r3 = java.lang.Double.valueOf(r3)     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            double r3 = r3.doubleValue()     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            r5.putDouble(r2, r3)     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
        L_0x00ca:
            java.lang.String r2 = "tab"
            boolean r3 = r1.q     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            if (r3 == 0) goto L_0x00d3
            java.lang.String r3 = "giftVoucher"
            goto L_0x00d5
        L_0x00d3:
            java.lang.String r3 = "wallet"
        L_0x00d5:
            r5.putString(r2, r3)     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            android.app.Activity r2 = r1.f70164a     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            boolean r2 = r2 instanceof net.one97.paytm.newaddmoney.view.AddMoneyNewActivity     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            if (r2 == 0) goto L_0x00f5
            android.app.Activity r2 = r1.f70164a     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            android.app.Activity r3 = r1.f70164a     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            java.lang.Class r3 = r3.getClass()     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            java.lang.String r4 = r3.getCanonicalName()     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            java.lang.Boolean r6 = java.lang.Boolean.FALSE     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            r7 = 0
            r8 = 1
            r3 = r22
            net.one97.paytm.addmoney.utils.AddMoneyUtils.a((android.app.Activity) r2, (com.paytm.network.model.NetworkCustomError) r3, (java.lang.String) r4, (android.os.Bundle) r5, (java.lang.Boolean) r6, (boolean) r7, (boolean) r8)     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            goto L_0x020f
        L_0x00f5:
            android.app.Activity r2 = r1.f70164a     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            r4 = 0
            java.lang.Boolean r6 = java.lang.Boolean.FALSE     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            r7 = 0
            r8 = 1
            r3 = r22
            net.one97.paytm.addmoney.utils.AddMoneyUtils.a((android.app.Activity) r2, (com.paytm.network.model.NetworkCustomError) r3, (java.lang.String) r4, (android.os.Bundle) r5, (java.lang.Boolean) r6, (boolean) r7, (boolean) r8)     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            goto L_0x020f
        L_0x0103:
            java.lang.String r3 = r22.getMessage()     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            java.lang.String r5 = "We could not process the transaction. Please try again."
            if (r3 == 0) goto L_0x019a
            java.lang.String r3 = r22.getFullUrl()     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            boolean r3 = r3.contains(r11)     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            if (r3 != 0) goto L_0x019a
            net.one97.paytm.helper.c r3 = net.one97.paytm.helper.a.b()     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            android.app.Activity r6 = r1.f70164a     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            boolean r3 = r3.a((android.content.Context) r6, (com.paytm.network.model.NetworkCustomError) r0)     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            if (r3 == 0) goto L_0x019a
            java.lang.String r2 = r22.getMessage()     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            if (r2 == 0) goto L_0x013e
            java.lang.String r2 = r22.getMessage()     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            java.lang.String r3 = "parsing_error"
            boolean r2 = r2.equalsIgnoreCase(r3)     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            if (r2 == 0) goto L_0x013e
            android.app.Activity r2 = r1.f70164a     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            java.lang.String r3 = r22.getUrl()     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            com.paytm.utility.b.d((android.content.Context) r2, (java.lang.String) r3, (java.lang.String) r4)     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            goto L_0x020f
        L_0x013e:
            com.paytm.network.model.NetworkCustomError$ErrorType r2 = r22.getErrorType()     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            if (r2 == 0) goto L_0x0163
            com.paytm.network.model.NetworkCustomError$ErrorType r2 = r22.getErrorType()     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            com.paytm.network.model.NetworkCustomError$ErrorType r3 = com.paytm.network.model.NetworkCustomError.ErrorType.TimeOutError     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            boolean r2 = r2.equals(r3)     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            if (r2 == 0) goto L_0x0163
            android.app.Activity r2 = r1.f70164a     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            android.app.Activity r3 = r1.f70164a     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            android.content.res.Resources r3 = r3.getResources()     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            int r4 = net.one97.paytm.addmoney.R.string.network_error_heading     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            java.lang.String r3 = r3.getString(r4)     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            com.paytm.utility.b.b((android.content.Context) r2, (java.lang.String) r3, (java.lang.String) r5)     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            goto L_0x020f
        L_0x0163:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            r2.<init>()     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            android.app.Activity r3 = r1.f70164a     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            android.content.res.Resources r3 = r3.getResources()     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            int r4 = net.one97.paytm.addmoney.R.string.network_error_message     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            java.lang.String r3 = r3.getString(r4)     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            r2.append(r3)     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            java.lang.String r3 = " "
            r2.append(r3)     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            java.lang.String r3 = r22.getUrl()     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            r2.append(r3)     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            java.lang.String r2 = r2.toString()     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            android.app.Activity r3 = r1.f70164a     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            android.app.Activity r4 = r1.f70164a     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            android.content.res.Resources r4 = r4.getResources()     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            int r5 = net.one97.paytm.addmoney.R.string.network_error_heading     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            java.lang.String r4 = r4.getString(r5)     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            com.paytm.utility.b.b((android.content.Context) r3, (java.lang.String) r4, (java.lang.String) r2)     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            goto L_0x020f
        L_0x019a:
            com.paytm.network.model.NetworkCustomError$ErrorType r3 = r22.getErrorType()     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            if (r3 == 0) goto L_0x01be
            com.paytm.network.model.NetworkCustomError$ErrorType r3 = r22.getErrorType()     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            com.paytm.network.model.NetworkCustomError$ErrorType r4 = com.paytm.network.model.NetworkCustomError.ErrorType.TimeOutError     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            boolean r3 = r3.equals(r4)     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            if (r3 == 0) goto L_0x01be
            android.app.Activity r2 = r1.f70164a     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            android.app.Activity r3 = r1.f70164a     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            android.content.res.Resources r3 = r3.getResources()     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            int r4 = net.one97.paytm.addmoney.R.string.network_error_heading     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            java.lang.String r3 = r3.getString(r4)     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            com.paytm.utility.b.b((android.content.Context) r2, (java.lang.String) r3, (java.lang.String) r5)     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            goto L_0x020f
        L_0x01be:
            com.paytm.network.model.NetworkCustomError$ErrorType r3 = r22.getErrorType()     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            if (r3 == 0) goto L_0x01de
            com.paytm.network.model.NetworkCustomError$ErrorType r3 = r22.getErrorType()     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            com.paytm.network.model.NetworkCustomError$ErrorType r4 = com.paytm.network.model.NetworkCustomError.ErrorType.ServerError     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            boolean r3 = r3.equals(r4)     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            if (r3 == 0) goto L_0x01de
            android.app.Activity r2 = r1.f70164a     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            java.lang.String r3 = r22.getAlertTitle()     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            java.lang.String r4 = r22.getAlertMessage()     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            com.paytm.utility.b.b((android.content.Context) r2, (java.lang.String) r3, (java.lang.String) r4)     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            goto L_0x020f
        L_0x01de:
            boolean r3 = v     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            if (r3 != 0) goto L_0x01eb
            if (r2 == 0) goto L_0x01e5
            goto L_0x01eb
        L_0x01e5:
            java.lang.AssertionError r0 = new java.lang.AssertionError     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            r0.<init>()     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            throw r0     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
        L_0x01eb:
            java.lang.String r3 = r1.f70167d     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            if (r3 == 0) goto L_0x0202
            java.lang.String r3 = r2.getFullUrl()     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            if (r3 == 0) goto L_0x0202
            java.lang.String r3 = r2.getFullUrl()     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            java.lang.String r4 = r1.f70167d     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            boolean r3 = r3.equalsIgnoreCase(r4)     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            if (r3 == 0) goto L_0x0202
            return
        L_0x0202:
            android.app.Activity r3 = r1.f70164a     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            java.lang.String r4 = r2.getAlertTitle()     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            java.lang.String r2 = r2.getAlertMessage()     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            com.paytm.utility.b.b((android.content.Context) r3, (java.lang.String) r4, (java.lang.String) r2)     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
        L_0x020f:
            java.lang.String r0 = r22.getFullUrl()     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            net.one97.paytm.helper.c r2 = net.one97.paytm.helper.a.b()     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            java.lang.String r2 = r2.f((java.lang.String) r11)     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            boolean r0 = r0.contains(r2)     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            if (r0 == 0) goto L_0x027c
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            long r4 = r1.Q     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            long r2 = r2 - r4
            r4 = 0
            r1.Q = r4     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            android.app.Activity r12 = r1.f70164a     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            java.lang.String r13 = "payment_gateway"
            net.one97.paytm.helper.c r0 = net.one97.paytm.helper.a.b()     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            java.lang.String r4 = "wallet_merchant_id"
            java.lang.String r14 = r0.f((java.lang.String) r4)     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            java.lang.String r15 = r1.N     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            r4 = 4
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            net.one97.paytm.helper.c r5 = net.one97.paytm.helper.a.b()     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            java.lang.String r5 = r5.f((java.lang.String) r11)     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            r4[r10] = r5     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            r5 = 1
            r4[r5] = r9     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            r5 = 2
            r4[r5] = r9     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            r5 = 3
            java.lang.String r6 = r1.P     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            r4[r5] = r6     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            java.util.List r4 = java.util.Arrays.asList(r4)     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            r0.<init>(r4)     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            java.lang.String r17 = java.lang.String.valueOf(r2)     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            java.lang.String r2 = r1.O     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            r16 = r0
            r18 = r2
            net.one97.paytm.addmoney.utils.d.a(r12, r13, r14, r15, r16, r17, r18)     // Catch:{ NotFoundException -> 0x0274, Exception -> 0x026b }
            goto L_0x027c
        L_0x026b:
            r0 = move-exception
            boolean r2 = com.paytm.utility.b.v
            if (r2 == 0) goto L_0x0273
            r0.printStackTrace()
        L_0x0273:
            return
        L_0x0274:
            r0 = move-exception
            boolean r2 = com.paytm.utility.b.v
            if (r2 == 0) goto L_0x027c
            r0.printStackTrace()
        L_0x027c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.wallet.d.c.handleErrorCode(int, com.paytm.network.model.IJRPaytmDataModel, com.paytm.network.model.NetworkCustomError):void");
    }

    public static boolean a(CJRRechargeCart cJRRechargeCart, Context context, String str) {
        if (cJRRechargeCart == null || cJRRechargeCart.getCart() == null) {
            return false;
        }
        if (cJRRechargeCart.getCart().getCartItems() != null) {
            Iterator<CJRCartProduct> it2 = cJRRechargeCart.getCart().getCartItems().iterator();
            while (it2.hasNext()) {
                CJRCartProduct next = it2.next();
                if (next.getError() != null) {
                    String errorCode = next.getErrorCode();
                    if (TextUtils.isEmpty(errorCode) || (!"CT_CP_4001".equalsIgnoreCase(errorCode) && !"CT_CP_4010".equalsIgnoreCase(errorCode))) {
                        String errorTitle = next.getErrorTitle();
                        if (errorTitle == null || errorTitle.trim().length() <= 0) {
                            com.paytm.utility.b.b(context, str, next.getError());
                        } else {
                            com.paytm.utility.b.b(context, errorTitle, next.getError());
                        }
                        return true;
                    }
                    com.paytm.utility.b.b(context, context.getResources().getString(R.string.title_msg_for_deals), context.getResources().getString(R.string.error_msg_for_deals));
                    return true;
                }
            }
        }
        if (cJRRechargeCart.getCart().getError() == null) {
            return false;
        }
        if (cJRRechargeCart == null || cJRRechargeCart.getCart() == null) {
            com.paytm.utility.b.b(context, context.getResources().getString(R.string.network_error_heading), context.getResources().getString(R.string.network_error_message));
        } else {
            String errorTitle2 = cJRRechargeCart.getCart().getErrorTitle();
            if (errorTitle2 != null && errorTitle2.trim().length() > 0) {
                str = errorTitle2;
            }
            com.paytm.utility.b.b(context, str, cJRRechargeCart.getCart().getError());
        }
        return true;
    }

    private static NetworkCustomError b(NetworkCustomError networkCustomError) {
        try {
            if (networkCustomError.networkResponse == null) {
                return null;
            }
            String str = new String(networkCustomError.networkResponse.data);
            new q();
            o oVar = (o) q.a(str);
            networkCustomError.setmAlertTitle("Error");
            if (oVar.b("error") != null) {
                networkCustomError.setAlertMessage(oVar.b("error").c());
            }
            return networkCustomError;
        } catch (p e2) {
            e2.printStackTrace();
            return null;
        } catch (Exception e3) {
            e3.printStackTrace();
            return null;
        }
    }
}
