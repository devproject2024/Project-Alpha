package net.one97.paytm.wallet.d;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.webkit.URLUtil;
import androidx.lifecycle.z;
import com.alipay.iap.android.webapp.sdk.plugin.H5RpcPlugin;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.utility.b;
import com.paytm.utility.c;
import com.paytm.utility.k;
import com.paytm.utility.q;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.common.entity.CJRPGTokenList;
import net.one97.paytm.common.entity.RiskAnalysis.RiskExtendedInfo;
import net.one97.paytm.common.entity.paymentsbank.CustProductList;
import net.one97.paytm.common.entity.upgradeKyc.NearbyRequestCreator;
import net.one97.paytm.common.entity.wallet.CJRIMPSInitiateDataModel;
import net.one97.paytm.common.entity.wallet.CJRQRScanResultModel;
import net.one97.paytm.network.f;
import net.one97.paytm.network.h;
import net.one97.paytm.upi.util.UpiConstantServiceApi;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.wallet.entity.CJRSendMoney;
import net.one97.paytm.wallet.utility.a;
import org.json.JSONException;
import org.json.JSONObject;

public final class g extends f {
    private String j;
    private String k;
    private String l;
    private String m;
    private String n;
    private String o;
    private String p;
    private String q;
    private boolean r;
    private boolean s = true;
    private boolean t;

    /* access modifiers changed from: protected */
    public final void c() {
        if (this.f70188a != null && !this.f70188a.isFinishing()) {
            d();
        }
    }

    /* access modifiers changed from: protected */
    public final void e() {
        l();
    }

    /* access modifiers changed from: protected */
    public final void d() {
        if (this.f70191d != null) {
            String a2 = a.a(a.a((Context) this.f70188a), this.p);
            StringBuilder sb = new StringBuilder("P2B_");
            if (!TextUtils.isEmpty(b.n(this.f70188a.getApplicationContext()))) {
                sb.append(b.n(this.f70188a.getApplicationContext()));
            }
            this.f70191d.addMoneyForInsufficientBalanceError(a2, true, sb.toString());
        }
    }

    public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
        super.a(iJRPaytmDataModel);
        if (iJRPaytmDataModel instanceof CJRPGTokenList) {
            CJRPGTokenList cJRPGTokenList = (CJRPGTokenList) iJRPaytmDataModel;
            if (this.f70188a != null && !this.f70188a.isFinishing()) {
                String pgToken = net.one97.paytm.wallet.communicator.b.a().getPgToken(cJRPGTokenList);
                if (TextUtils.isEmpty(pgToken) || !this.r) {
                    if (!this.r) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("screen_name", this.f70188a.getClass().getSimpleName());
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("User-Token", com.paytm.utility.a.q(this.f70188a));
                        hashMap2.put("Content-Type", "application/json");
                        hashMap2.put("channel", UpiConstants.B2C_ANDROID);
                        net.one97.paytm.network.b bVar = new net.one97.paytm.network.b(net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(this.f70188a, UpiConstantServiceApi.GTM_KEY_PPB_GET_FIN_PRODUCT), new CustProductList(), hashMap, hashMap2, (String) null);
                        if (b.c((Context) this.f70188a)) {
                            this.t = false;
                            j();
                            bVar.c().observeForever(new z() {
                                public final void onChanged(Object obj) {
                                    g.this.b((f) obj);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    net.one97.paytm.wallet.communicator.b.a().showSessionTimeoutAlert(this.f70188a);
                } else if (this.f70188a != null && !this.f70188a.isFinishing()) {
                    String stringFromGTM = net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(this.f70188a, "transferToBank");
                    if (URLUtil.isValidUrl(stringFromGTM)) {
                        String e2 = b.e((Context) this.f70188a, stringFromGTM);
                        JSONObject jSONObject = new JSONObject();
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.put("nickName", this.j);
                            jSONObject2.put("senderName", this.k);
                            jSONObject2.put("bankName", this.l);
                            jSONObject2.put("ifscCode", this.m);
                            jSONObject2.put("bankAccountNo", this.n);
                            jSONObject2.put("contactNo", this.o);
                            jSONObject2.put("amount", this.p);
                            jSONObject2.put("currencyCode", "INR");
                            jSONObject2.put(CJRQRScanResultModel.KEY_COMMENT_SMALL, this.q);
                            jSONObject.put("request", jSONObject2);
                            jSONObject.put(NearbyRequestCreator.NearbyRequestConstants.ipAddress, "127.0.0.1");
                            jSONObject.put(NearbyRequestCreator.NearbyRequestConstants.platformName, "PayTM");
                            jSONObject.put(H5RpcPlugin.RpcRequest.RpcParam.OPERATION_TYPE, "P2B_TRANSFER");
                            jSONObject.put("channel", UpiConstants.MP_ANDROID);
                            String Q = b.Q((Context) this.f70188a);
                            if (Q != null) {
                                jSONObject.put("version", Q);
                            }
                        } catch (JSONException e3) {
                            q.d(String.valueOf(e3));
                        }
                        HashMap hashMap3 = new HashMap();
                        hashMap3.put("Content-Type", "application/json");
                        hashMap3.put("ssotoken", pgToken);
                        if (net.one97.paytm.f.b.a().f50402a != null) {
                            try {
                                hashMap3.put("risk_extended_info", new com.google.gson.f().a((Object) net.one97.paytm.f.b.a().f50402a, new com.google.gson.b.a<RiskExtendedInfo>() {
                                }.getType()));
                            } catch (Exception unused) {
                            }
                        }
                        if (b.c((Context) this.f70188a)) {
                            j();
                            new net.one97.paytm.network.b(e2, new CJRSendMoney(), (Map<String, String>) null, hashMap3, jSONObject.toString()).c().observeForever(new z() {
                                public final void onChanged(Object obj) {
                                    g.this.c((f) obj);
                                }
                            });
                            return;
                        }
                        i();
                    }
                }
            }
        } else if (iJRPaytmDataModel instanceof CustProductList) {
            this.t = true;
            k();
            CustProductList custProductList = (CustProductList) iJRPaytmDataModel;
            if (!TextUtils.isEmpty(custProductList.getIsaStatus())) {
                net.one97.paytm.wallet.communicator.b.a().setBankAccStatus(this.f70188a, custProductList);
                if (custProductList.getIsaStatus().equals("ISSUED")) {
                    String isaAccNum = custProductList.getIsaAccNum();
                    if (this.f70188a != null && !this.f70188a.isFinishing()) {
                        JSONObject jSONObject3 = new JSONObject();
                        try {
                            jSONObject3.put("amount", this.p);
                            jSONObject3.put("benAccNo", this.n);
                            jSONObject3.put("benBankName", this.l);
                            jSONObject3.put("benIfsc", this.m);
                            jSONObject3.put("benName", this.k);
                            jSONObject3.put("channel", "MOB");
                            jSONObject3.put("client", "androidapp");
                            jSONObject3.put("remAccNo", isaAccNum);
                            jSONObject3.put("transactionType", "IMPS_OUTWARD");
                            jSONObject3.put("isAddBeneficiary", this.s);
                            jSONObject3.put("txnReqId", b.q());
                            JSONObject d2 = c.d(this.f70188a);
                            if (k.b()) {
                                d2.getJSONObject("deviceInfo").put("appName", "ppb-app");
                            }
                            jSONObject3.put("properties", d2);
                        } catch (JSONException e4) {
                            q.d(String.valueOf(e4));
                        }
                        String stringFromGTM2 = net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(this.f70188a, "ppb_funds_transfer");
                        HashMap hashMap4 = new HashMap();
                        hashMap4.put("Content-Type", "application/json");
                        hashMap4.put("channel", "MOB");
                        hashMap4.put("User-Agent", UpiConstants.B2C_ANDROID);
                        JSONObject jSONObject4 = new JSONObject();
                        try {
                            jSONObject4.put("userToken", com.paytm.utility.a.q(this.f70188a));
                        } catch (JSONException unused2) {
                        }
                        hashMap4.put("authorization", jSONObject4.toString());
                        new HashMap().put("screen_name", this.f70188a.getClass().getSimpleName());
                        net.one97.paytm.network.b bVar2 = new net.one97.paytm.network.b(stringFromGTM2, new CJRIMPSInitiateDataModel(), (Map<String, String>) null, hashMap4, (String) null);
                        if (b.c((Context) this.f70188a)) {
                            j();
                            bVar2.c().observeForever(new z() {
                                public final void onChanged(Object obj) {
                                    g.this.a((f) obj);
                                }
                            });
                            return;
                        }
                        i();
                    }
                }
            }
        } else if (iJRPaytmDataModel instanceof CJRIMPSInitiateDataModel) {
            k();
            CJRIMPSInitiateDataModel cJRIMPSInitiateDataModel = (CJRIMPSInitiateDataModel) iJRPaytmDataModel;
            if (this.f70188a != null && !this.f70188a.isFinishing() && cJRIMPSInitiateDataModel != null && cJRIMPSInitiateDataModel.getmStatus() != null) {
                if (cJRIMPSInitiateDataModel.getmStatus() != null) {
                    cJRIMPSInitiateDataModel.getmStatus();
                }
                if (cJRIMPSInitiateDataModel.getMessage() != null) {
                    cJRIMPSInitiateDataModel.getMessage();
                }
                String str = cJRIMPSInitiateDataModel.getmStatus() != null ? cJRIMPSInitiateDataModel.getmStatus() : "";
                new StringBuilder().append(cJRIMPSInitiateDataModel.getResponse_code());
                if (str.equalsIgnoreCase("SUCCESS")) {
                    if (this.f70189b != null) {
                        this.f70189b.a(cJRIMPSInitiateDataModel);
                    }
                } else if (str.equalsIgnoreCase("failed") || str.equalsIgnoreCase("FAILURE")) {
                    if (this.f70189b != null) {
                        this.f70189b.a(cJRIMPSInitiateDataModel);
                    }
                } else if (str.equalsIgnoreCase("PENDING")) {
                    if (this.f70189b != null) {
                        this.f70189b.a(cJRIMPSInitiateDataModel);
                    }
                } else if (str.equalsIgnoreCase("passcode_required")) {
                    Intent enterPasscodeIntent = net.one97.paytm.wallet.communicator.b.a().getEnterPasscodeIntent(this.f70188a);
                    enterPasscodeIntent.putExtra("imps_passcode_flow", true);
                    enterPasscodeIntent.putExtra("ENTER_HEADER", cJRIMPSInitiateDataModel.getMessage());
                    enterPasscodeIntent.putExtra("imps_data", cJRIMPSInitiateDataModel);
                    this.f70188a.startActivityForResult(enterPasscodeIntent, 3333);
                } else if (str.equalsIgnoreCase("need_verify")) {
                    net.one97.paytm.wallet.communicator.b.a().callVerifierIntent(this.f70188a, cJRIMPSInitiateDataModel);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(f fVar) {
        if (fVar.f55796a == h.SUCCESS) {
            a(fVar.f55797b);
        } else if (fVar.f55796a == h.ERROR) {
            a(fVar.f55798c.f55801c);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(f fVar) {
        if (fVar.f55796a == h.SUCCESS) {
            a(fVar.f55797b);
        } else if (fVar.f55796a == h.ERROR) {
            a(fVar.f55798c.f55801c);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(f fVar) {
        if (fVar.f55796a == h.SUCCESS) {
            a(fVar.f55797b);
        } else if (fVar.f55796a == h.ERROR) {
            a(fVar.f55798c.f55801c);
        }
    }
}
