package net.one97.paytm.wallet.d;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.lifecycle.z;
import com.alipay.iap.android.webapp.sdk.plugin.H5RpcPlugin;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.gson.f;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.utility.b;
import com.paytm.utility.q;
import com.paytmmall.clpartifact.view.fragment.FilterPriceSliderFragment;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.net.URLEncoder;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import net.one97.paytm.common.entity.CJRPGTokenList;
import net.one97.paytm.common.entity.RiskAnalysis.RiskExtendedInfo;
import net.one97.paytm.common.entity.auth.KYCStatusV2;
import net.one97.paytm.common.entity.p2p.WalletPaymentCallbackListener;
import net.one97.paytm.common.entity.upgradeKyc.NearbyRequestCreator;
import net.one97.paytm.common.entity.wallet.CJRCashWallet;
import net.one97.paytm.common.entity.wallet.CJRLimitStatus;
import net.one97.paytm.common.entity.wallet.CJRLimitStatusResponse;
import net.one97.paytm.common.entity.wallet.CJRQRScanResultModel;
import net.one97.paytm.network.g;
import net.one97.paytm.network.h;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.entity.CJRSendMoney;
import net.one97.paytm.wallet.utility.a;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class e extends f {
    private static final String j = e.class.getSimpleName();
    private String k;
    private String l;
    private String m;
    /* access modifiers changed from: private */
    public String n;
    private String o;
    private String p = "0";
    private String q = "0";
    private CJRQRScanResultModel r = null;
    private boolean s;
    private Button t;
    /* access modifiers changed from: private */
    public double u;
    private double v;
    private double w;
    private double x;
    private String y = "OTHERS";
    private String z;

    public final void a(String str, String str2, String str3, String str4, CJRQRScanResultModel cJRQRScanResultModel) {
        if (this.f70188a != null && !this.f70188a.isFinishing()) {
            this.r = cJRQRScanResultModel;
            this.k = str;
            this.l = str2;
            this.m = null;
            this.n = str3;
            this.o = str4;
            this.s = true;
            g();
            c(this.l, this.m);
        }
    }

    public final void a(String str, String str2, String str3, String str4) {
        if (this.f70188a != null && !this.f70188a.isFinishing()) {
            this.k = null;
            this.l = str;
            this.m = null;
            this.n = str2;
            this.o = str3;
            this.s = false;
            this.z = str4;
            this.f70196i = false;
            l();
        }
    }

    public final void a(String str, String str2, String str3, boolean z2) {
        if (this.f70188a != null && !this.f70188a.isFinishing()) {
            this.k = null;
            this.l = str;
            this.m = null;
            this.n = str2;
            this.o = str3;
            this.s = false;
            this.f70196i = z2;
            if (z2) {
                g();
            }
            c(this.l, this.m);
        }
    }

    public final void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z2) {
        this.k = str2;
        this.l = str3;
        this.m = str4;
        this.n = str5;
        this.o = str6;
        this.p = str7;
        this.q = str8;
        if (z2) {
            n();
        } else if (!TextUtils.isEmpty(str)) {
            c(str);
        } else {
            m();
        }
    }

    /* access modifiers changed from: protected */
    public final void c() {
        if (this.f70188a != null && !this.f70188a.isFinishing()) {
            d();
        }
    }

    /* access modifiers changed from: protected */
    public final void d() {
        CJRQRScanResultModel cJRQRScanResultModel;
        if (this.f70191d != null) {
            String a2 = a.a(a.a((Context) this.f70188a), this.n);
            StringBuilder sb = new StringBuilder("");
            if (!this.s || (cJRQRScanResultModel = this.r) == null) {
                sb.append("P2P_");
                String str = this.l;
                if (str != null) {
                    sb.append(str);
                } else {
                    String str2 = this.k;
                    if (str2 != null) {
                        sb.append(str2);
                    } else if (!TextUtils.isEmpty(b.n(this.f70188a.getApplicationContext()))) {
                        sb.append(b.n(this.f70188a.getApplicationContext()));
                    }
                }
            } else {
                sb.append(cJRQRScanResultModel.getOrderID());
            }
            this.f70191d.addMoneyForInsufficientBalanceError(a2, true, this.k, this.l, this.m, this.n, this.o, (String) null, this.p, this.q, sb.toString());
        }
    }

    public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
        JSONObject jSONObject;
        String str;
        IJRPaytmDataModel iJRPaytmDataModel2 = iJRPaytmDataModel;
        super.a(iJRPaytmDataModel);
        if (iJRPaytmDataModel2 instanceof CJRPGTokenList) {
            CJRPGTokenList cJRPGTokenList = (CJRPGTokenList) iJRPaytmDataModel2;
            if (this.f70188a != null && !this.f70188a.isFinishing()) {
                String pgToken = net.one97.paytm.wallet.communicator.b.a().getPgToken(cJRPGTokenList);
                if (TextUtils.isEmpty(pgToken)) {
                    k();
                    net.one97.paytm.wallet.communicator.b.a().showSessionTimeoutAlert(this.f70188a);
                } else if (this.f70188a != null && !this.f70188a.isFinishing()) {
                    String stringFromGTM = net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(this.f70188a, "walletSendMoneyV2");
                    if (URLUtil.isValidUrl(stringFromGTM)) {
                        String e2 = b.e((Context) this.f70188a, stringFromGTM);
                        StringBuilder sb = new StringBuilder("&isContactInPhonebook=");
                        String str2 = "displayName";
                        String str3 = pgToken;
                        sb.append(net.one97.paytm.wallet.communicator.b.a().contactExists(this.f70188a, this.l));
                        String str4 = e2 + sb.toString() + ("&uuid=" + UUID.randomUUID().toString() + "&timestamp=" + System.currentTimeMillis());
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            if (this.r != null) {
                                jSONObject = this.r.getJson();
                                jSONObject.put(CJRQRScanResultModel.KEY_MERCHANT_ORDER_ID, this.r.getOrderID());
                            } else {
                                jSONObject = new JSONObject();
                            }
                            jSONObject.put("isToVerify", this.p);
                            jSONObject.put("isLimitApplicable", this.q);
                            if (this.m != null) {
                                jSONObject.put("payeeSsoId", this.m);
                            }
                            if (this.m == null) {
                                if (this.l != null) {
                                    jSONObject.put("payeePhoneNumber", this.l);
                                } else {
                                    jSONObject.put("payeeEmailId", this.k);
                                }
                            }
                            if (!TextUtils.isEmpty(this.z)) {
                                JSONObject jSONObject3 = new JSONObject();
                                jSONObject3.put("paymentsThemeId", this.z);
                                jSONObject.put("extendedInfo", jSONObject3);
                            }
                            if (net.one97.paytm.wallet.newdesign.universalp2p.c.b.a(this.f70188a).q) {
                                jSONObject.put("pcFail", true);
                            }
                            jSONObject.put("amount", this.n);
                            jSONObject.put("currencyCode", "INR");
                            jSONObject.put(CJRQRScanResultModel.KEY_COMMENT_SMALL, this.o);
                            jSONObject.put("mode", this.y);
                            jSONObject2.put("request", jSONObject);
                            jSONObject2.put(NearbyRequestCreator.NearbyRequestConstants.ipAddress, "127.0.0.1");
                            jSONObject2.put(NearbyRequestCreator.NearbyRequestConstants.platformName, "PayTM");
                            jSONObject2.put(H5RpcPlugin.RpcRequest.RpcParam.OPERATION_TYPE, "P2P_TRANSFER");
                            jSONObject2.put("channel", UpiConstants.MP_ANDROID);
                            try {
                                str = this.f70188a.getPackageManager().getPackageInfo(this.f70188a.getPackageName(), 0).versionName;
                            } catch (Exception e3) {
                                if (b.v) {
                                    q.d(String.valueOf(e3));
                                }
                                str = null;
                            }
                            if (str != null) {
                                jSONObject2.put("version", str);
                            }
                        } catch (JSONException e4) {
                            k();
                            if (b.v) {
                                q.d(String.valueOf(e4));
                            }
                        }
                        HashMap hashMap = new HashMap();
                        hashMap.put("Content-Type", "application/json");
                        hashMap.put("ssotoken", str3);
                        if (net.one97.paytm.f.b.a().f50402a != null) {
                            try {
                                JSONObject jSONObject4 = new JSONObject(new f().a((Object) net.one97.paytm.f.b.a().f50402a, new com.google.gson.b.a<RiskExtendedInfo>() {
                                }.getType()));
                                String str5 = str2;
                                jSONObject4.put(str5, URLEncoder.encode((String) jSONObject4.get(str5), AppConstants.UTF_8));
                                JSONArray jSONArray = (JSONArray) jSONObject4.get("wifissid");
                                JSONArray jSONArray2 = new JSONArray();
                                if (jSONArray != null && jSONArray.length() > 0) {
                                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                                        jSONArray2.put(URLEncoder.encode(jSONArray.getString(i2), AppConstants.UTF_8));
                                    }
                                }
                                jSONObject4.put("wifissid", jSONArray2);
                                hashMap.put("risk_extended_info", jSONObject4.toString());
                            } catch (Exception unused) {
                            }
                        }
                        if (b.c((Context) this.f70188a)) {
                            j();
                            net.one97.paytm.network.b bVar = new net.one97.paytm.network.b(str4, new CJRSendMoney(), (Map<String, String>) null, hashMap, jSONObject2.toString());
                            bVar.e();
                            bVar.a(a.a(net.one97.paytm.wallet.communicator.b.a().getIntegerFromGTM((Context) this.f70188a, "sendMoneyAPITimeout")));
                            bVar.c().observeForever(new z() {
                                public final void onChanged(Object obj) {
                                    e.this.d((net.one97.paytm.network.f) obj);
                                }
                            });
                        } else {
                            i();
                        }
                        this.p = "0";
                        this.q = "0";
                    }
                }
            }
        } else if (iJRPaytmDataModel2 instanceof KYCStatusV2) {
            h();
            if (((KYCStatusV2) iJRPaytmDataModel2).getIsKycDone() == 1) {
                net.one97.paytm.wallet.communicator.b.a().setKYCUserStatus(this.f70188a, 1);
            }
            if (net.one97.paytm.wallet.communicator.b.a().getKYCUserStatus(this.f70188a) == -1) {
                g();
                String stringFromGTM2 = net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(this.f70188a, "min_kyc_status_v3_url");
                if (URLUtil.isValidUrl(stringFromGTM2)) {
                    String e5 = b.e((Context) this.f70188a, stringFromGTM2);
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("session_token", com.paytm.utility.a.q(this.f70188a));
                    if (b.c((Context) this.f70188a)) {
                        new net.one97.paytm.network.a(e5, new KYCStatusV2(), (Map<String, String>) null, hashMap2).c().observeForever(new z() {
                            public final void onChanged(Object obj) {
                                e.this.a((net.one97.paytm.network.f) obj);
                            }
                        });
                        return;
                    }
                    return;
                }
                return;
            }
            String str6 = null;
            if (this.f70188a != null && !this.f70188a.isFinishing()) {
                g();
                String stringFromGTM3 = net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(this.f70188a, "walletLimitStatus");
                if (URLUtil.isValidUrl(stringFromGTM3)) {
                    String e6 = b.e((Context) this.f70188a, stringFromGTM3);
                    HashMap hashMap3 = new HashMap();
                    hashMap3.put("Content-Type", "application/json");
                    hashMap3.put("ssotoken", com.paytm.utility.a.q(this.f70188a));
                    JSONObject jSONObject5 = new JSONObject();
                    JSONObject jSONObject6 = new JSONObject();
                    try {
                        jSONObject6.put("requestType", "CREDIT");
                        jSONObject5.put("request", jSONObject6);
                        jSONObject5.put(NearbyRequestCreator.NearbyRequestConstants.ipAddress, "127.0.0.1");
                        jSONObject5.put(NearbyRequestCreator.NearbyRequestConstants.platformName, "PayTM");
                        jSONObject5.put("channel", UpiConstants.MP_ANDROID);
                        try {
                            str6 = this.f70188a.getPackageManager().getPackageInfo(this.f70188a.getPackageName(), 0).versionName;
                        } catch (Exception e7) {
                            if (b.v) {
                                q.d(String.valueOf(e7));
                            }
                        }
                        if (str6 != null) {
                            jSONObject5.put("version", str6);
                        }
                    } catch (JSONException e8) {
                        if (b.v) {
                            q.d(String.valueOf(e8));
                        }
                    }
                    if (b.c((Context) this.f70188a)) {
                        new net.one97.paytm.network.b(e6, new CJRLimitStatus(), (Map<String, String>) null, hashMap3, jSONObject5.toString()).c().observeForever(new z() {
                            public final void onChanged(Object obj) {
                                e.this.b((net.one97.paytm.network.f) obj);
                            }
                        });
                    }
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void e() {
        l();
    }

    private void c(String str, String str2) {
        try {
            String stringFromGTM = net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(this.f70188a, "check_user_balance_service");
            if (stringFromGTM == null) {
                return;
            }
            if (URLUtil.isValidUrl(stringFromGTM)) {
                String e2 = b.e((Context) this.f70188a, stringFromGTM);
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                if (!TextUtils.isEmpty(str)) {
                    jSONObject2.put("payeePhoneNo", str);
                }
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject2.put("payeeSsoId", str2);
                }
                jSONObject.put("request", jSONObject2);
                HashMap hashMap = new HashMap();
                hashMap.put("ssotoken", com.paytm.utility.a.q(this.f70188a));
                hashMap.put("Accept-Encoding", "gzip");
                new StringBuilder("SSO Token :: ").append(com.paytm.utility.a.q(this.f70188a));
                b.j();
                if (b.c((Context) this.f70188a)) {
                    new net.one97.paytm.network.b(e2, new CJRCashWallet(), (Map<String, String>) null, hashMap, jSONObject.toString()).c().observeForever(new z() {
                        public final void onChanged(Object obj) {
                            e.this.c((net.one97.paytm.network.f) obj);
                        }
                    });
                }
            }
        } catch (Exception e3) {
            q.d(String.valueOf(e3));
        }
    }

    /* access modifiers changed from: protected */
    public final void a(Double d2, Double d3) {
        CJRQRScanResultModel cJRQRScanResultModel;
        if (this.f70191d != null) {
            String a2 = a.a((Context) this.f70188a);
            StringBuilder sb = new StringBuilder();
            sb.append(d2.doubleValue() + d3.doubleValue());
            String a3 = a.a(a2, sb.toString());
            StringBuilder sb2 = new StringBuilder("");
            if (!this.s || (cJRQRScanResultModel = this.r) == null) {
                sb2.append("P2P_");
                String str = this.l;
                if (str != null) {
                    sb2.append(str);
                } else {
                    String str2 = this.k;
                    if (str2 != null) {
                        sb2.append(str2);
                    } else if (!TextUtils.isEmpty(b.n(this.f70188a.getApplicationContext()))) {
                        sb2.append(b.n(this.f70188a.getApplicationContext()));
                    }
                }
            } else {
                sb2.append(cJRQRScanResultModel.getOrderID());
            }
            this.f70191d.addMoneyForInsufficientBalanceError(a3, true, this.k, this.l, this.m, String.valueOf(d2), this.o, (String) null, this.p, this.q, sb2.toString());
        }
    }

    public final void b(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.y = str;
        }
    }

    public final void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        this.k = str;
        this.l = str2;
        this.m = null;
        this.n = str3;
        this.o = str4;
        this.p = str5;
        this.q = str6;
        this.y = str7;
        this.z = str8;
    }

    public final void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z2, boolean z3, WalletPaymentCallbackListener walletPaymentCallbackListener) {
        WalletPaymentCallbackListener walletPaymentCallbackListener2 = walletPaymentCallbackListener;
        this.k = str2;
        this.l = str3;
        this.m = str4;
        this.n = str5;
        this.o = str6;
        this.p = str7;
        this.q = str8;
        a(this.k, this.l, this.m, this.n, this.o, this.p, this.q, this.y, this.z);
        if (z2) {
            a(walletPaymentCallbackListener2);
        } else if (!TextUtils.isEmpty(str)) {
            String str9 = str;
            a(str, z3, walletPaymentCallbackListener2);
        } else {
            b(walletPaymentCallbackListener2);
        }
    }

    public final void a(String str, String str2, boolean z2, WalletPaymentCallbackListener walletPaymentCallbackListener) {
        try {
            String stringFromGTM = net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(this.f70188a, "check_user_balance_service");
            if (stringFromGTM == null) {
                return;
            }
            if (URLUtil.isValidUrl(stringFromGTM)) {
                String e2 = b.e((Context) this.f70188a, stringFromGTM);
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject2.put("payeePhoneNo", str2);
                }
                if (!TextUtils.isEmpty((CharSequence) null)) {
                    jSONObject2.put("payeeSsoId", (Object) null);
                }
                jSONObject.put("request", jSONObject2);
                HashMap hashMap = new HashMap();
                hashMap.put("ssotoken", com.paytm.utility.a.q(this.f70188a));
                hashMap.put("Accept-Encoding", "gzip");
                new StringBuilder("SSO Token :: ").append(com.paytm.utility.a.q(this.f70188a));
                b.j();
                if (b.c((Context) this.f70188a)) {
                    new net.one97.paytm.network.b(e2, new CJRCashWallet(), (Map<String, String>) null, hashMap, jSONObject.toString()).c().observeForever(new z(str, z2, walletPaymentCallbackListener) {
                        private final /* synthetic */ String f$1;
                        private final /* synthetic */ boolean f$2;
                        private final /* synthetic */ WalletPaymentCallbackListener f$3;

                        {
                            this.f$1 = r2;
                            this.f$2 = r3;
                            this.f$3 = r4;
                        }

                        public final void onChanged(Object obj) {
                            e.this.a(this.f$1, this.f$2, this.f$3, (net.one97.paytm.network.f) obj);
                        }
                    });
                }
            }
        } catch (Exception e3) {
            q.d(String.valueOf(e3));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(String str, boolean z2, WalletPaymentCallbackListener walletPaymentCallbackListener, net.one97.paytm.network.f fVar) {
        if (fVar.f55796a == h.SUCCESS) {
            CJRCashWallet cJRCashWallet = (CJRCashWallet) fVar.f55797b;
            if (cJRCashWallet.getResponse() != null) {
                double totalBalance = cJRCashWallet.getResponse().getTotalBalance();
                String b2 = b.b(Double.valueOf(totalBalance));
                a.a((Context) this.f70188a, totalBalance);
                if (TextUtils.isEmpty(b2)) {
                    a(z2, walletPaymentCallbackListener);
                } else if (Double.parseDouble(str) <= totalBalance) {
                    a(z2, walletPaymentCallbackListener);
                } else if (this.f70188a != null && !this.f70188a.isFinishing()) {
                    this.f70188a.getResources().getString(R.string.insufficient_balance_error_title);
                    this.f70188a.getResources().getString(R.string.insufficient_balance_error_message);
                    c();
                }
            } else {
                walletPaymentCallbackListener.onAddMoneyFailure(this.f70188a.getString(R.string.wallet_add_money_failure_title), this.f70188a.getString(R.string.wallet_add_money_failure_message));
            }
        } else if (fVar.f55796a == h.ERROR) {
            g gVar = fVar.f55798c;
            if (gVar == null || !(gVar.f55799a == 401 || gVar.f55799a == 410 || gVar.f55799a == 403)) {
                walletPaymentCallbackListener.onAddMoneyFailure(this.f70188a.getString(R.string.wallet_add_money_failure_title), this.f70188a.getString(R.string.wallet_add_money_failure_message));
            } else {
                net.one97.paytm.wallet.communicator.b.a().handleError(this.f70188a, gVar.f55801c, h.class.getName(), (Bundle) null, false);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(net.one97.paytm.network.f fVar) {
        if (fVar.f55796a == h.SUCCESS) {
            a(fVar.f55797b);
        } else if (fVar.f55796a == h.ERROR) {
            a(fVar.f55798c.f55801c);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(net.one97.paytm.network.f fVar) {
        if (fVar.f55796a == h.SUCCESS) {
            h();
            if (fVar.f55797b != null && (fVar.f55797b instanceof CJRLimitStatus)) {
                CJRLimitStatusResponse response = ((CJRLimitStatus) fVar.f55797b).getResponse();
                this.v = response.getCreditConsumed();
                this.w = response.getAllowedLimit();
                this.x = this.w - this.v;
                double parseDouble = Double.parseDouble(a.a((Context) this.f70188a));
                Double valueOf = Double.valueOf(Double.parseDouble(a.a(String.valueOf(parseDouble), this.n)));
                if (this.x > valueOf.doubleValue() && this.x > valueOf.doubleValue() + 1500.0d) {
                    View inflate = this.f70188a.getLayoutInflater().inflate(R.layout.bottomsheet_addnpay_intermediate_intermediate, (ViewGroup) null);
                    final com.google.android.material.bottomsheet.a aVar = new com.google.android.material.bottomsheet.a(this.f70188a);
                    aVar.setContentView(inflate);
                    final BottomSheetBehavior from = BottomSheetBehavior.from((View) inflate.getParent());
                    try {
                        double parseDouble2 = Double.parseDouble(a.a((Context) this.f70188a));
                        double parseDouble3 = Double.parseDouble(a.a(String.valueOf(parseDouble2), this.n));
                        this.t = (Button) inflate.findViewById(R.id.addnpay_intermediate_proceed_btn);
                        this.t.setText(String.format(this.f70188a.getResources().getString(R.string.add_n_pay_proceed_btn), new Object[]{Double.valueOf(parseDouble3)}));
                        Double valueOf2 = Double.valueOf(parseDouble2);
                        Double valueOf3 = Double.valueOf(parseDouble3);
                        Double valueOf4 = Double.valueOf(valueOf3.doubleValue() + valueOf2.doubleValue());
                        String format = String.format(this.f70188a.getResources().getString(R.string.addnpay_intermediate_current_wallet_blnc), new Object[]{valueOf2});
                        String format2 = String.format(this.f70188a.getResources().getString(R.string.addnpay_intermediate_msg_added_blnc), new Object[]{valueOf4});
                        String format3 = String.format(this.f70188a.getResources().getString(R.string.simple_amount), new Object[]{valueOf3});
                        String format4 = String.format(this.f70188a.getResources().getString(R.string.add_n_pay_msg_balance_btm), new Object[]{valueOf4});
                        ((TextView) inflate.findViewById(R.id.addnpay_intermediate_wallet_blnc_tv)).setText(format);
                        ((TextView) inflate.findViewById(R.id.addnpay_intermediate_total_mnt_tv)).setText(format2);
                        ((TextView) inflate.findViewById(R.id.addnpay_intermediate_amnt_to_add_tv)).setText(format3);
                        ((TextView) inflate.findViewById(R.id.addnpay_intermediate_msg_tv)).setText(format4);
                        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.addnpay_intermediate_parent_scroll);
                        int childCount = linearLayout.getChildCount();
                        for (int i2 = 0; i2 < childCount; i2++) {
                            Button button = (Button) linearLayout.getChildAt(i2);
                            button.setTag(button.getText());
                            button.setOnClickListener(new View.OnClickListener() {
                                public final void onClick(View view) {
                                    e.a(e.this, view);
                                }
                            });
                        }
                    } catch (Exception e2) {
                        q.d(String.valueOf(e2));
                    }
                    aVar.show();
                    from.setState(3);
                    from.setBottomSheetCallback(new BottomSheetBehavior.a() {
                        public final void onSlide(View view, float f2) {
                        }

                        public final void onStateChanged(View view, int i2) {
                            from.setState(3);
                        }
                    });
                    aVar.setOnDismissListener(new DialogInterface.OnDismissListener() {
                        public final void onDismiss(DialogInterface dialogInterface) {
                            from.setState(4);
                            double unused = e.this.u = 0.0d;
                        }
                    });
                    inflate.findViewById(R.id.addnpay_intermediate_proceed_btn).setOnClickListener(new View.OnClickListener() {
                        public final void onClick(View view) {
                            aVar.dismiss();
                            if (e.this.u > 0.0d) {
                                e eVar = e.this;
                                eVar.a(Double.valueOf(Double.parseDouble(eVar.n)), Double.valueOf(e.this.u));
                                return;
                            }
                            e.this.d();
                        }
                    });
                } else if (this.x > valueOf.doubleValue()) {
                    d();
                } else if (net.one97.paytm.wallet.communicator.b.a().getKYCUserStatus(this.f70188a) == 0) {
                    b.b((Context) this.f70188a, "", String.format(this.f70188a.getString(R.string.limit_error_non_kyc), new Object[]{Double.valueOf(this.x)}));
                } else {
                    b.b((Context) this.f70188a, "", String.format(this.f70188a.getString(R.string.limit_error_kyc), new Object[]{Double.valueOf(this.w - parseDouble)}));
                }
            }
        } else if (fVar.f55796a == h.ERROR) {
            h();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(net.one97.paytm.network.f fVar) {
        if (fVar.f55796a == h.SUCCESS) {
            h();
            CJRCashWallet cJRCashWallet = (CJRCashWallet) fVar.f55797b;
            if (cJRCashWallet.getResponse() != null) {
                double totalBalance = cJRCashWallet.getResponse().getTotalBalance();
                String b2 = b.b(Double.valueOf(totalBalance));
                a.a((Context) this.f70188a, totalBalance);
                if (TextUtils.isEmpty(b2)) {
                    l();
                } else if (Double.parseDouble(this.n) > totalBalance) {
                    if (this.f70188a != null && !this.f70188a.isFinishing()) {
                        this.f70188a.getResources().getString(R.string.insufficient_balance_error_title);
                        this.f70188a.getResources().getString(R.string.insufficient_balance_error_message);
                        c();
                    }
                    if (this.f70189b != null) {
                        this.f70189b.b();
                    }
                } else {
                    l();
                }
            } else {
                k();
            }
        } else if (fVar.f55796a == h.ERROR) {
            h();
            g gVar = fVar.f55798c;
            if (gVar == null || !(gVar.f55799a == 401 || gVar.f55799a == 410 || gVar.f55799a == 403)) {
                k();
            } else {
                net.one97.paytm.wallet.communicator.b.a().handleError(this.f70188a, gVar.f55801c, h.class.getName(), (Bundle) null, false);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d(net.one97.paytm.network.f fVar) {
        if (fVar.f55796a == h.SUCCESS) {
            a(fVar.f55797b);
        } else if (fVar.f55796a == h.ERROR) {
            a(fVar.f55798c.f55801c);
        }
    }

    static /* synthetic */ void a(e eVar, View view) {
        try {
            double doubleValue = NumberFormat.getInstance(Locale.ENGLISH).parse(((String) view.getTag()).replace("+", "").replace(FilterPriceSliderFragment.RUPEE_SYMBOL, "").trim()).doubleValue();
            if (eVar.x > eVar.u + doubleValue) {
                view.setEnabled(false);
                ((Button) view).setTextColor(-1);
                eVar.u += doubleValue;
                eVar.t.setText(String.format(eVar.f70188a.getResources().getString(R.string.add_n_pay_proceed_btn), new Object[]{Double.valueOf(Double.parseDouble(a.a(String.valueOf(a.a((Context) eVar.f70188a)), eVar.n)) + eVar.u)}));
                return;
            }
            Toast.makeText(eVar.f70188a, eVar.f70188a.getResources().getString(R.string.err_no_add_money), 1).show();
        } catch (Exception e2) {
            q.d(String.valueOf(e2));
        }
    }
}
