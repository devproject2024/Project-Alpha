package net.one97.paytm.p2b.d;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.alipay.iap.android.webapp.sdk.plugin.H5RpcPlugin;
import com.google.gson.f;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.a;
import com.paytm.utility.c;
import com.paytm.utility.k;
import java.util.HashMap;
import net.one97.paytm.common.entity.CJRPGTokenList;
import net.one97.paytm.common.entity.RiskAnalysis.RiskExtendedInfo;
import net.one97.paytm.common.entity.paymentsbank.CustProductList;
import net.one97.paytm.common.entity.upgradeKyc.NearbyRequestCreator;
import net.one97.paytm.common.entity.wallet.CJRCashWallet;
import net.one97.paytm.common.entity.wallet.CJRIMPSInitiateDataModel;
import net.one97.paytm.common.entity.wallet.CJRQRScanResultModel;
import net.one97.paytm.common.entity.wallet.CJRSendMoney;
import net.one97.paytm.p2b.R;
import net.one97.paytm.p2b.view.Activity.SendMoneyToBankActivity;
import net.one97.paytm.upi.util.UpiConstantServiceApi;
import net.one97.paytm.upi.util.UpiConstants;
import org.json.JSONException;
import org.json.JSONObject;

public class d extends e {

    /* renamed from: i  reason: collision with root package name */
    private String f12680i;
    private String j;
    private String k;
    private String l;
    private String m;
    private String n;
    /* access modifiers changed from: private */
    public String o;
    private String p;
    private String q;
    private boolean r;
    private boolean s = true;
    private boolean t;
    private String u = d.class.getName();
    /* access modifiers changed from: private */
    public String v = "";

    public final void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        if (this.f12686a != null && !this.f12686a.isFinishing()) {
            this.f12680i = str;
            this.j = str2;
            this.k = str3;
            this.l = str4;
            this.m = str5;
            this.n = str6;
            this.o = str7;
            this.p = str8;
            this.q = str9;
            this.r = true;
            h();
            i.a((Context) this.f12686a, (b) new b() {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ boolean f12682a = true;

                public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                    d.this.b(networkCustomError);
                }

                public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                    if (d.this.f12686a != null && !d.this.f12686a.isFinishing()) {
                        CJRCashWallet cJRCashWallet = (CJRCashWallet) iJRPaytmDataModel;
                        if (cJRCashWallet.getResponse() == null || !cJRCashWallet.getStatus().equalsIgnoreCase("SUCCESS")) {
                            d.this.i();
                            return;
                        }
                        double paytmWalletBalance = cJRCashWallet.getResponse().getPaytmWalletBalance();
                        String unused = d.this.v = Double.toString(paytmWalletBalance);
                        if (TextUtils.isEmpty(d.this.v)) {
                            d.this.j();
                        } else if (Double.parseDouble(d.this.o) <= paytmWalletBalance || !this.f12682a) {
                            d.this.j();
                        } else {
                            d dVar = d.this;
                            dVar.f12686a.getResources().getString(R.string.p2b_insufficient_balance_error_title);
                            d.this.f12686a.getResources().getString(R.string.p2b_insufficient_balance_error_message);
                            dVar.c();
                            if (d.this.f12687b != null) {
                                d.this.f12687b.c();
                            }
                        }
                    }
                }
            }, this.u);
        }
    }

    public final void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, boolean z) {
        this.f12680i = str2;
        this.j = str3;
        this.k = str4;
        this.l = str5;
        this.m = str6;
        this.n = str7;
        this.o = str8;
        this.p = str9;
        this.q = str10;
        if (z) {
            l();
        } else if (!TextUtils.isEmpty(str)) {
            c(str);
        } else {
            k();
        }
    }

    /* access modifiers changed from: protected */
    public final void c() {
        if (this.f12686a != null && !this.f12686a.isFinishing()) {
            e();
        }
    }

    /* access modifiers changed from: protected */
    public final void d() {
        j();
    }

    /* access modifiers changed from: protected */
    public final void e() {
        String b2 = k.b(this.v, this.o);
        StringBuilder sb = new StringBuilder("P2B_");
        if (!TextUtils.isEmpty(com.paytm.utility.b.n(this.f12686a.getApplicationContext()))) {
            sb.append(com.paytm.utility.b.n(this.f12686a.getApplicationContext()));
        }
        h.b().b(b2, sb.toString());
        h.b().a(this.f12686a, "P2B", "Add_money_screen_triggered", (String) null, SendMoneyToBankActivity.f12799a, (String) null, "p2b", "P2B");
    }

    public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
        IJRPaytmDataModel iJRPaytmDataModel2 = iJRPaytmDataModel;
        super.a(iJRPaytmDataModel);
        if (iJRPaytmDataModel2 instanceof CJRPGTokenList) {
            CJRPGTokenList cJRPGTokenList = (CJRPGTokenList) iJRPaytmDataModel2;
            if (this.f12686a == null || this.f12686a.isFinishing()) {
                return;
            }
            String a2 = h.b().a(cJRPGTokenList);
            if (TextUtils.isEmpty(a2) || !this.r) {
                Object obj = "application/json";
                if (!this.r) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("screen_name", this.f12686a.getClass().getSimpleName());
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("User-Token", a.q(this.f12686a));
                    hashMap2.put("Content-Type", obj);
                    hashMap2.put("channel", UpiConstants.B2C_ANDROID);
                    String a3 = h.b().a(UpiConstantServiceApi.GTM_KEY_PPB_GET_FIN_PRODUCT);
                    com.paytm.network.b bVar = new com.paytm.network.b();
                    bVar.f42877a = this.f12686a;
                    bVar.f42878b = a.c.P2B;
                    bVar.f42879c = a.C0715a.POST;
                    bVar.n = a.b.SILENT;
                    bVar.o = this.f12686a.getClass().getSimpleName();
                    bVar.f42882f = hashMap2;
                    bVar.f42883g = hashMap;
                    bVar.f42880d = a3;
                    bVar.f42885i = new CustProductList();
                    bVar.j = new b() {
                        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                            d.this.a(iJRPaytmDataModel);
                        }

                        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                            d.this.a(networkCustomError);
                        }
                    };
                    com.paytm.network.a l2 = bVar.l();
                    if (com.paytm.utility.b.c((Context) this.f12686a)) {
                        this.t = false;
                        h();
                        l2.a();
                        return;
                    }
                    return;
                }
                this.f12687b.a();
            } else if (this.f12686a != null && !this.f12686a.isFinishing()) {
                if (k.a((Context) this.f12686a)) {
                    h();
                    Activity activity = this.f12686a;
                    String str = this.f12680i;
                    String str2 = this.j;
                    String str3 = this.k;
                    String str4 = this.l;
                    String str5 = this.m;
                    String str6 = this.n;
                    String str7 = this.o;
                    String str8 = this.p;
                    String str9 = this.q;
                    String str10 = a2;
                    String str11 = this.u;
                    AnonymousClass1 r2 = new b() {
                        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                            d.this.a(iJRPaytmDataModel);
                        }

                        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                            d.this.a(networkCustomError);
                        }
                    };
                    String i2 = h.b().i();
                    if (URLUtil.isValidUrl(i2)) {
                        String e2 = com.paytm.utility.b.e((Context) activity, i2);
                        AnonymousClass1 r18 = r2;
                        JSONObject jSONObject = new JSONObject();
                        String str12 = e2;
                        JSONObject jSONObject2 = new JSONObject();
                        Object obj2 = "application/json";
                        try {
                            jSONObject2.put("nickName", str);
                            jSONObject2.put("senderName", str2);
                            jSONObject2.put("bankName", str3);
                            jSONObject2.put("ifscCode", str4);
                            jSONObject2.put("bankAccountNo", str5);
                            jSONObject2.put("contactNo", str6);
                            jSONObject2.put("amount", str7);
                            jSONObject2.put("currencyCode", "INR");
                            jSONObject2.put(CJRQRScanResultModel.KEY_COMMENT_SMALL, str8);
                            if (!TextUtils.isEmpty(str9)) {
                                jSONObject2.put("netCommission", str9);
                            }
                            jSONObject.put("request", jSONObject2);
                            jSONObject.put(NearbyRequestCreator.NearbyRequestConstants.ipAddress, "127.0.0.1");
                            jSONObject.put(NearbyRequestCreator.NearbyRequestConstants.platformName, "PayTM");
                            jSONObject.put(H5RpcPlugin.RpcRequest.RpcParam.OPERATION_TYPE, "P2B_TRANSFER");
                            jSONObject.put("channel", UpiConstants.MP_ANDROID);
                            String Q = com.paytm.utility.b.Q((Context) activity);
                            if (Q != null) {
                                jSONObject.put("version", Q);
                            }
                        } catch (JSONException e3) {
                            e3.printStackTrace();
                        }
                        HashMap hashMap3 = new HashMap();
                        hashMap3.put("Content-Type", obj2);
                        hashMap3.put("ssotoken", str10);
                        if (net.one97.paytm.f.b.a().f50402a != null) {
                            try {
                                hashMap3.put("risk_extended_info", new f().a((Object) net.one97.paytm.f.b.a().f50402a, new com.google.gson.b.a<RiskExtendedInfo>() {
                                }.getType()));
                            } catch (Exception unused) {
                            }
                        }
                        com.paytm.network.b bVar2 = new com.paytm.network.b();
                        bVar2.f42877a = activity;
                        bVar2.f42878b = a.c.P2B;
                        bVar2.f42879c = a.C0715a.POST;
                        bVar2.n = a.b.SILENT;
                        bVar2.o = activity.getClass().getSimpleName();
                        bVar2.f42884h = jSONObject.toString();
                        bVar2.f42882f = hashMap3;
                        bVar2.f42880d = str12;
                        bVar2.f42885i = new CJRSendMoney();
                        bVar2.j = r18;
                        bVar2.x = 0;
                        com.paytm.network.a l3 = bVar2.l();
                        l3.a((Object) str11);
                        l3.a();
                        return;
                    }
                    return;
                }
                g();
            }
        } else {
            Object obj3 = "application/json";
            if (iJRPaytmDataModel2 instanceof CustProductList) {
                this.t = true;
                i();
                CustProductList custProductList = (CustProductList) iJRPaytmDataModel2;
                if (!TextUtils.isEmpty(custProductList.getIsaStatus()) && custProductList.getIsaStatus().equals("ISSUED")) {
                    String isaAccNum = custProductList.getIsaAccNum();
                    if (this.f12686a != null && !this.f12686a.isFinishing()) {
                        JSONObject jSONObject3 = new JSONObject();
                        try {
                            jSONObject3.put("amount", this.o);
                            jSONObject3.put("benAccNo", this.m);
                            jSONObject3.put("benBankName", this.k);
                            jSONObject3.put("benIfsc", this.l);
                            jSONObject3.put("benName", this.j);
                            jSONObject3.put("channel", "MOB");
                            jSONObject3.put("client", "androidapp");
                            jSONObject3.put("remAccNo", isaAccNum);
                            jSONObject3.put("transactionType", "IMPS_OUTWARD");
                            jSONObject3.put("isAddBeneficiary", this.s);
                            jSONObject3.put("txnReqId", com.paytm.utility.b.q());
                            JSONObject d2 = c.d(this.f12686a);
                            if (k.b()) {
                                d2.getJSONObject("deviceInfo").put("appName", "ppb-app");
                            }
                            jSONObject3.put("properties", d2);
                        } catch (JSONException e4) {
                            e4.printStackTrace();
                        }
                        String a4 = h.b().a("ppb_funds_transfer");
                        HashMap hashMap4 = new HashMap();
                        hashMap4.put("Content-Type", obj3);
                        hashMap4.put("channel", "MOB");
                        hashMap4.put("User-Agent", UpiConstants.B2C_ANDROID);
                        JSONObject jSONObject4 = new JSONObject();
                        try {
                            jSONObject4.put("userToken", com.paytm.utility.a.q(this.f12686a));
                        } catch (JSONException unused2) {
                        }
                        hashMap4.put("authorization", jSONObject4.toString());
                        new HashMap().put("screen_name", this.f12686a.getClass().getSimpleName());
                        com.paytm.network.b bVar3 = new com.paytm.network.b();
                        bVar3.f42877a = this.f12686a;
                        bVar3.f42878b = a.c.P2B;
                        bVar3.f42879c = a.C0715a.POST;
                        bVar3.n = a.b.SILENT;
                        bVar3.o = this.f12686a.getClass().getSimpleName();
                        bVar3.f42882f = hashMap4;
                        bVar3.f42880d = a4;
                        bVar3.f42885i = new CJRIMPSInitiateDataModel();
                        bVar3.j = new b() {
                            public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                                d.this.a(iJRPaytmDataModel);
                            }

                            public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                                d.this.a(networkCustomError);
                            }
                        };
                        com.paytm.network.a l4 = bVar3.l();
                        if (com.paytm.utility.b.c((Context) this.f12686a)) {
                            h();
                            l4.a();
                            return;
                        }
                        g();
                    }
                }
            } else if (iJRPaytmDataModel2 instanceof CJRIMPSInitiateDataModel) {
                i();
            }
        }
    }
}
