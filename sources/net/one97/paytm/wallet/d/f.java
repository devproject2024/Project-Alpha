package net.one97.paytm.wallet.d;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.webkit.URLUtil;
import androidx.lifecycle.z;
import com.alipay.iap.android.webapp.sdk.plugin.H5RpcPlugin;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.h;
import com.paytm.utility.q;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import net.one97.paytm.common.entity.CJRPGTokenList;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.RiskAnalysis.RiskExtendedInfo;
import net.one97.paytm.common.entity.p2p.WalletPaymentCallbackListener;
import net.one97.paytm.common.entity.shopping.CJROrderSummary;
import net.one97.paytm.common.entity.upgradeKyc.NearbyRequestCreator;
import net.one97.paytm.common.entity.wallet.CJRQRScanResultModel;
import net.one97.paytm.common.entity.wallet.CJRValidateTransaction;
import net.one97.paytm.common.entity.wallet.CJRWalletResendOtp;
import net.one97.paytm.network.f;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.utils.ah;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.communicator.b;
import net.one97.paytm.wallet.dialog.c;
import net.one97.paytm.wallet.entity.CJRSendMoney;
import net.one97.paytm.wallet.f.g;
import net.one97.paytm.wallet.f.k;
import net.one97.paytm.wallet.newdesign.activity.P2PActivity;
import net.one97.paytm.wallet.utility.a;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class f implements ah, b, k {

    /* renamed from: a  reason: collision with root package name */
    protected Activity f70188a;

    /* renamed from: b  reason: collision with root package name */
    protected g f70189b;

    /* renamed from: c  reason: collision with root package name */
    c f70190c;

    /* renamed from: d  reason: collision with root package name */
    protected a f70191d;

    /* renamed from: e  reason: collision with root package name */
    boolean f70192e = false;

    /* renamed from: f  reason: collision with root package name */
    protected String f70193f = "P2P_TRANSFER";

    /* renamed from: g  reason: collision with root package name */
    Bundle f70194g = new Bundle();

    /* renamed from: h  reason: collision with root package name */
    h f70195h;

    /* renamed from: i  reason: collision with root package name */
    boolean f70196i = true;
    private Dialog j;
    private ProgressDialog k;
    private String l;
    private CJRQRScanResultModel m = null;
    private String n = "0";
    private String o = "0";
    private String p;
    private String q;
    private String r;
    private String s;
    private String t;
    private String u;
    private String v;

    /* access modifiers changed from: protected */
    public abstract void c();

    /* access modifiers changed from: protected */
    public abstract void d();

    /* access modifiers changed from: protected */
    public abstract void e();

    public final void a(Activity activity, String str, g gVar) {
        this.f70188a = activity;
        this.f70189b = gVar;
        if (this.f70191d == null) {
            this.f70191d = b.b();
        }
        this.f70191d.onAttachToFragment(activity, this);
        if (!TextUtils.isEmpty(str)) {
            this.f70193f = str;
        }
    }

    public final void f() {
        this.f70188a = null;
        this.f70189b = null;
    }

    /* access modifiers changed from: protected */
    public final void g() {
        try {
            if (this.j == null) {
                this.j = a.b(this.f70188a);
            }
            if (this.j != null && !this.j.isShowing()) {
                this.j.show();
            }
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.d(String.valueOf(e2));
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void h() {
        try {
            if (this.j != null && this.j.isShowing()) {
                this.j.dismiss();
            }
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.d(String.valueOf(e2));
            }
        }
    }

    private void o() {
        try {
            if (this.k != null && this.k.isShowing()) {
                this.k.dismiss();
            }
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.d(String.valueOf(e2));
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void i() {
        Activity activity = this.f70188a;
        if (activity != null && !activity.isFinishing()) {
            k();
            a.a(this.f70188a);
        }
    }

    /* access modifiers changed from: protected */
    public final void j() {
        g gVar = this.f70189b;
        if (gVar != null) {
            gVar.a();
        }
        if (this.f70196i) {
            g();
        }
    }

    /* access modifiers changed from: protected */
    public final void k() {
        g gVar = this.f70189b;
        if (gVar != null) {
            gVar.b();
        }
        h();
    }

    /* access modifiers changed from: protected */
    public final void c(String str) {
        Activity activity = this.f70188a;
        if (activity != null && !activity.isFinishing()) {
            this.l = str;
            this.f70192e = false;
            new Handler().postDelayed(new Runnable() {
                public final void run() {
                    f.this.f70192e = true;
                    com.paytm.utility.b.j();
                }
            }, 120000);
            Activity activity2 = this.f70188a;
            if (activity2 != null && !activity2.isFinishing()) {
                try {
                    if (this.k == null) {
                        this.k = new ProgressDialog(this.f70188a);
                        this.k.setProgressStyle(0);
                        this.k.setMessage(this.f70188a.getResources().getString(R.string.paytm_cash_addition_confirmation_message));
                        this.k.setCancelable(false);
                        this.k.setCanceledOnTouchOutside(false);
                    }
                    if (!this.k.isShowing()) {
                        this.k.show();
                    }
                } catch (Exception e2) {
                    if (com.paytm.utility.b.v) {
                        q.d(String.valueOf(e2));
                    }
                }
            }
            p();
        }
    }

    /* access modifiers changed from: protected */
    public final void l() {
        Activity activity = this.f70188a;
        if (activity != null && !activity.isFinishing()) {
            if (com.paytm.utility.b.c((Context) this.f70188a)) {
                String q2 = com.paytm.utility.a.q(this.f70188a);
                if (!TextUtils.isEmpty(q2)) {
                    j();
                    b.a().getWalletToken(q2, this.f70188a, new com.paytm.network.listener.b() {
                        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                            f.this.a(iJRPaytmDataModel);
                        }

                        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                            f.this.a(networkCustomError);
                        }
                    });
                    return;
                }
                b.a().showSessionTimeoutAlert(this.f70188a);
                return;
            }
            i();
        }
    }

    /* access modifiers changed from: private */
    public void p() {
        if (this.f70192e || this.f70188a == null) {
            o();
            r();
            return;
        }
        String str = b.a().getStringFromGTM(this.f70188a, "orderdetail") + this.l;
        new net.one97.paytm.network.a(com.paytm.utility.b.b((Context) this.f70188a, str) + "&actions=1", new CJROrderSummary(), (Map<String, String>) null, (Map<String, String>) null).c().observeForever(new z() {
            public final void onChanged(Object obj) {
                f.this.c((f) obj);
            }
        });
    }

    private void a(String str, String str2, String str3) {
        Activity activity = this.f70188a;
        if (activity != null && !activity.isFinishing()) {
            this.f70190c = new c(this.f70188a, str, str2, str3, this);
            this.f70190c.setCanceledOnTouchOutside(false);
            this.f70190c.show();
        }
    }

    private void q() {
        Activity activity = this.f70188a;
        if (activity != null && !activity.isFinishing()) {
            final h hVar = new h(this.f70188a);
            hVar.setTitle(this.f70188a.getString(R.string.unverified_wallet_title));
            hVar.a(this.f70188a.getString(R.string.unverified_wallet_message));
            hVar.a(-3, this.f70188a.getResources().getString(R.string.i_understand), new View.OnClickListener() {
                public final void onClick(View view) {
                    hVar.dismiss();
                }
            });
            hVar.setCancelable(true);
            hVar.show();
        }
    }

    private void r() {
        Activity activity = this.f70188a;
        if (activity != null && !activity.isFinishing()) {
            o();
            new AlertDialog.Builder(this.f70188a).setTitle(R.string.wallet_add_money_delayed_title).setMessage(R.string.wallet_add_money_delayed_message).setPositiveButton(R.string.wallet_add_money_delayed_positive_button, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    dialogInterface.dismiss();
                    if (b.a().isFromMainActivity(f.this.f70188a)) {
                        f.this.f70188a.finish();
                    }
                }
            }).show();
        }
    }

    /* access modifiers changed from: protected */
    public final void m() {
        Activity activity = this.f70188a;
        if (activity != null && !activity.isFinishing()) {
            o();
            final h hVar = new h(this.f70188a);
            hVar.setTitle(R.string.wallet_add_money_failure_title);
            hVar.a(this.f70188a.getString(R.string.wallet_add_money_failure_message));
            hVar.a(-1, this.f70188a.getString(R.string.wallet_add_money_failure_positive_button), new View.OnClickListener() {
                public final void onClick(View view) {
                    hVar.dismiss();
                    f.this.d();
                }
            });
            hVar.a(-2, this.f70188a.getString(R.string.wallet_add_money_failure_negative_button), new View.OnClickListener() {
                public final void onClick(View view) {
                    hVar.dismiss();
                }
            });
            hVar.show();
        }
    }

    /* access modifiers changed from: protected */
    public final void n() {
        Activity activity = this.f70188a;
        if (activity != null && !activity.isFinishing()) {
            o();
        }
    }

    private void a(String str, String str2, View.OnClickListener onClickListener) {
        this.f70195h = new h(this.f70188a);
        this.f70195h.setTitle(str);
        this.f70195h.a(str2);
        this.f70195h.a(-3, this.f70188a.getResources().getString(R.string.ok), onClickListener);
        this.f70195h.setCancelable(true);
        this.f70195h.show();
    }

    private void s() {
        c cVar;
        Activity activity = this.f70188a;
        if (activity != null && !activity.isFinishing() && (cVar = this.f70190c) != null && cVar.isShowing()) {
            this.f70190c.dismiss();
        }
    }

    public final void d(String str) {
        Activity activity = this.f70188a;
        if (activity != null && !activity.isFinishing()) {
            String stringFromGTM = b.a().getStringFromGTM(this.f70188a, "walletResendOtp");
            if (URLUtil.isValidUrl(stringFromGTM)) {
                String e2 = com.paytm.utility.b.e((Context) this.f70188a, stringFromGTM);
                HashMap hashMap = new HashMap();
                hashMap.put("Content-Type", "application/json");
                hashMap.put("ssotoken", com.paytm.utility.a.q(this.f70188a));
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("state", str);
                    jSONObject.put("request", jSONObject2);
                    jSONObject.put(NearbyRequestCreator.NearbyRequestConstants.ipAddress, "127.0.0.1");
                    jSONObject.put(NearbyRequestCreator.NearbyRequestConstants.platformName, "PayTM");
                    jSONObject.put(H5RpcPlugin.RpcRequest.RpcParam.OPERATION_TYPE, this.f70193f);
                    jSONObject.put("channel", UpiConstants.MP_ANDROID);
                    String str2 = null;
                    try {
                        str2 = this.f70188a.getPackageManager().getPackageInfo(this.f70188a.getPackageName(), 0).versionName;
                    } catch (Exception e3) {
                        if (com.paytm.utility.b.v) {
                            q.d(String.valueOf(e3));
                        }
                    }
                    if (str2 != null) {
                        jSONObject.put("version", str2);
                    }
                } catch (JSONException e4) {
                    if (com.paytm.utility.b.v) {
                        q.d(String.valueOf(e4));
                    }
                }
                if (com.paytm.utility.b.c((Context) this.f70188a)) {
                    new net.one97.paytm.network.b(e2, new CJRWalletResendOtp(), (Map<String, String>) null, hashMap, jSONObject.toString()).c().observeForever(new z() {
                        public final void onChanged(Object obj) {
                            f.this.b((f) obj);
                        }
                    });
                } else {
                    i();
                }
            }
        }
    }

    public final void a(String str, String str2) {
        Activity activity = this.f70188a;
        if (activity != null && !activity.isFinishing()) {
            String stringFromGTM = b.a().getStringFromGTM(this.f70188a, "walletValidateTransaction");
            if (URLUtil.isValidUrl(stringFromGTM)) {
                String e2 = com.paytm.utility.b.e((Context) this.f70188a, stringFromGTM);
                HashMap hashMap = new HashMap();
                hashMap.put("Content-Type", "application/json");
                hashMap.put("ssotoken", com.paytm.utility.a.q(this.f70188a));
                if (this instanceof e) {
                    if (net.one97.paytm.f.b.a().f50402a != null && net.one97.paytm.f.b.a().f50403b) {
                        net.one97.paytm.f.b.a().f50402a.setOtpReadFlag(true);
                        hashMap.put("risk_extended_info", new com.google.gson.f().a((Object) net.one97.paytm.f.b.a().f50402a, new com.google.gson.b.a<RiskExtendedInfo>() {
                        }.getType()));
                    }
                } else if ((this instanceof g) && net.one97.paytm.f.b.a().f50402a != null && net.one97.paytm.f.b.a().f50403b) {
                    net.one97.paytm.f.b.a().f50402a.setOtpReadFlag(true);
                    hashMap.put("risk_extended_info", new com.google.gson.f().a((Object) net.one97.paytm.f.b.a().f50402a, new com.google.gson.b.a<RiskExtendedInfo>() {
                    }.getType()));
                }
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("state", str2);
                    jSONObject2.put("otp", str);
                    jSONObject.put("request", jSONObject2);
                    jSONObject.put(NearbyRequestCreator.NearbyRequestConstants.ipAddress, "127.0.0.1");
                    jSONObject.put(NearbyRequestCreator.NearbyRequestConstants.platformName, "PayTM");
                    jSONObject.put(H5RpcPlugin.RpcRequest.RpcParam.OPERATION_TYPE, this.f70193f);
                    jSONObject.put("channel", UpiConstants.MP_ANDROID);
                    String str3 = null;
                    try {
                        str3 = this.f70188a.getPackageManager().getPackageInfo(this.f70188a.getPackageName(), 0).versionName;
                    } catch (Exception e3) {
                        if (com.paytm.utility.b.v) {
                            q.d(String.valueOf(e3));
                        }
                    }
                    if (str3 != null) {
                        jSONObject.put("version", str3);
                    }
                } catch (JSONException e4) {
                    if (com.paytm.utility.b.v) {
                        q.d(String.valueOf(e4));
                    }
                }
                if (com.paytm.utility.b.c((Context) this.f70188a)) {
                    j();
                    new net.one97.paytm.network.b(e2, new CJRValidateTransaction(), (Map<String, String>) null, hashMap, jSONObject.toString()).c().observeForever(new z() {
                        public final void onChanged(Object obj) {
                            f.this.a((f) obj);
                        }
                    });
                    return;
                }
                i();
            }
        }
    }

    public final void b(String str, String str2) {
        c cVar;
        String e2;
        Activity activity = this.f70188a;
        if (activity != null && !activity.isFinishing() && (cVar = this.f70190c) != null && cVar.isShowing() && (e2 = com.paytm.utility.b.e(str, str2)) != null) {
            c cVar2 = this.f70190c;
            if (e2 != null && cVar2.f70299b != null) {
                cVar2.f70299b.setText(e2);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:63:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x013d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.paytm.network.model.IJRPaytmDataModel r17) {
        /*
            r16 = this;
            r1 = r16
            r0 = r17
            android.app.Activity r2 = r1.f70188a
            if (r2 == 0) goto L_0x0470
            boolean r2 = r2.isFinishing()
            if (r2 == 0) goto L_0x0010
            goto L_0x0470
        L_0x0010:
            r16.k()
            boolean r2 = r0 instanceof net.one97.paytm.wallet.entity.CJRSendMoney
            java.lang.String r3 = "response title"
            java.lang.String r4 = "resultdata"
            java.lang.String r5 = "response Message"
            java.lang.String r6 = "WM_1006"
            java.lang.String r7 = "PENDING"
            java.lang.String r8 = "SS_0001"
            java.lang.String r9 = "FAILURE"
            java.lang.String r10 = "SUCCESS"
            java.lang.String r11 = ""
            if (r2 == 0) goto L_0x024a
            r2 = r0
            net.one97.paytm.wallet.entity.CJRSendMoney r2 = (net.one97.paytm.wallet.entity.CJRSendMoney) r2
            android.app.Activity r0 = r1.f70188a
            if (r0 == 0) goto L_0x0249
            boolean r0 = r0.isFinishing()
            if (r0 == 0) goto L_0x0038
            goto L_0x0249
        L_0x0038:
            r16.s()
            if (r2 == 0) goto L_0x0249
            java.lang.String r0 = r2.getStatusCode()
            if (r0 == 0) goto L_0x0249
            net.one97.paytm.wallet.entity.CJRSendMoneyResponse r0 = r2.getResponse()
            if (r0 == 0) goto L_0x005d
            net.one97.paytm.wallet.entity.CJRSendMoneyResponse r0 = r2.getResponse()
            java.lang.String r0 = r0.getHeading()
            if (r0 == 0) goto L_0x005d
            net.one97.paytm.wallet.entity.CJRSendMoneyResponse r0 = r2.getResponse()
            java.lang.String r0 = r0.getHeading()
            r12 = r0
            goto L_0x005e
        L_0x005d:
            r12 = r11
        L_0x005e:
            java.lang.String r0 = r2.getStatusMessage()
            if (r0 == 0) goto L_0x006a
            java.lang.String r0 = r2.getStatusMessage()
            r13 = r0
            goto L_0x006b
        L_0x006a:
            r13 = r11
        L_0x006b:
            java.lang.String r0 = r2.getStatus()
            if (r0 == 0) goto L_0x0077
            java.lang.String r0 = r2.getStatus()
            r14 = r0
            goto L_0x0078
        L_0x0077:
            r14 = r11
        L_0x0078:
            java.lang.String r0 = r2.getStatusCode()
            if (r0 == 0) goto L_0x0082
            java.lang.String r11 = r2.getStatusCode()
        L_0x0082:
            r0 = 0
            net.one97.paytm.wallet.entity.CJRSendMoneyResponse r15 = r2.getResponse()
            if (r15 == 0) goto L_0x0091
            net.one97.paytm.wallet.entity.CJRSendMoneyResponse r0 = r2.getResponse()
            java.lang.String r0 = r0.getState()
        L_0x0091:
            r15 = r0
            if (r2 == 0) goto L_0x00f0
            net.one97.paytm.wallet.entity.CJRSendMoneyResponse r0 = r2.getResponse()     // Catch:{ Exception -> 0x00e5 }
            if (r0 == 0) goto L_0x00b4
            net.one97.paytm.wallet.entity.CJRSendMoneyResponse r0 = r2.getResponse()     // Catch:{ Exception -> 0x00e5 }
            java.lang.String r0 = r0.getwalletSysTransactionID()     // Catch:{ Exception -> 0x00e5 }
            if (r0 == 0) goto L_0x00b4
            net.one97.paytm.wallet.entity.CJRSendMoneyResponse r0 = r2.getResponse()     // Catch:{ Exception -> 0x00e5 }
            java.lang.String r0 = r0.getwalletSysTransactionID()     // Catch:{ Exception -> 0x00e5 }
            r17 = r15
            android.os.Bundle r15 = r1.f70194g     // Catch:{ Exception -> 0x00e3 }
            r15.putString(r4, r0)     // Catch:{ Exception -> 0x00e3 }
            goto L_0x00b6
        L_0x00b4:
            r17 = r15
        L_0x00b6:
            java.lang.String r0 = r2.getStatusMessage()     // Catch:{ Exception -> 0x00e3 }
            if (r0 == 0) goto L_0x00c5
            android.os.Bundle r0 = r1.f70194g     // Catch:{ Exception -> 0x00e3 }
            java.lang.String r4 = r2.getStatusMessage()     // Catch:{ Exception -> 0x00e3 }
            r0.putString(r5, r4)     // Catch:{ Exception -> 0x00e3 }
        L_0x00c5:
            net.one97.paytm.wallet.entity.CJRSendMoneyResponse r0 = r2.getResponse()     // Catch:{ Exception -> 0x00e3 }
            if (r0 == 0) goto L_0x00f2
            net.one97.paytm.wallet.entity.CJRSendMoneyResponse r0 = r2.getResponse()     // Catch:{ Exception -> 0x00e3 }
            java.lang.String r0 = r0.getHeading()     // Catch:{ Exception -> 0x00e3 }
            if (r0 == 0) goto L_0x00f2
            android.os.Bundle r0 = r1.f70194g     // Catch:{ Exception -> 0x00e3 }
            net.one97.paytm.wallet.entity.CJRSendMoneyResponse r4 = r2.getResponse()     // Catch:{ Exception -> 0x00e3 }
            java.lang.String r4 = r4.getHeading()     // Catch:{ Exception -> 0x00e3 }
            r0.putString(r3, r4)     // Catch:{ Exception -> 0x00e3 }
            goto L_0x00f2
        L_0x00e3:
            r0 = move-exception
            goto L_0x00e8
        L_0x00e5:
            r0 = move-exception
            r17 = r15
        L_0x00e8:
            java.lang.String r0 = java.lang.String.valueOf(r0)
            com.paytm.utility.q.d(r0)
            goto L_0x00f2
        L_0x00f0:
            r17 = r15
        L_0x00f2:
            boolean r0 = r14.equalsIgnoreCase(r10)
            java.lang.String r3 = "postpaymentscreendata"
            java.lang.String r4 = "paymentmode"
            if (r0 == 0) goto L_0x013d
            boolean r0 = r11.equalsIgnoreCase(r8)
            if (r0 == 0) goto L_0x013d
            net.one97.paytm.wallet.entity.CJRSendMoneyResponse r0 = r2.getmResponse()
            if (r0 == 0) goto L_0x011a
            net.one97.paytm.wallet.entity.CJRSendMoneyResponse r0 = r2.getmResponse()
            net.one97.paytm.common.entity.offline_pg.paymethodresponse.CJRFastForwardResponse r0 = r0.getmFFResponse()
            if (r0 == 0) goto L_0x011a
            net.one97.paytm.wallet.f.g r0 = r1.f70189b
            if (r0 == 0) goto L_0x0249
            r0.a(r2)
            return
        L_0x011a:
            android.app.Activity r0 = r1.f70188a
            android.content.Intent r0 = r0.getIntent()
            boolean r0 = r0.hasExtra(r4)
            if (r0 == 0) goto L_0x0135
            android.os.Bundle r0 = r1.f70194g
            r0.putSerializable(r3, r2)
            d.a.a.c r0 = d.a.a.c.a()
            android.os.Bundle r2 = r1.f70194g
            r0.d(r2)
            return
        L_0x0135:
            net.one97.paytm.wallet.f.g r0 = r1.f70189b
            if (r0 == 0) goto L_0x0249
            r0.a(r2)
            return
        L_0x013d:
            boolean r0 = r14.equalsIgnoreCase(r9)
            if (r0 == 0) goto L_0x01c2
            net.one97.paytm.wallet.entity.CJRSendMoneyResponse r0 = r2.getmResponse()
            if (r0 == 0) goto L_0x015b
            net.one97.paytm.wallet.entity.CJRSendMoneyResponse r0 = r2.getmResponse()
            net.one97.paytm.common.entity.offline_pg.paymethodresponse.CJRFastForwardResponse r0 = r0.getmFFResponse()
            if (r0 == 0) goto L_0x015b
            net.one97.paytm.wallet.f.g r0 = r1.f70189b
            if (r0 == 0) goto L_0x0249
            r0.a(r2)
            return
        L_0x015b:
            boolean r0 = r11.equalsIgnoreCase(r6)
            if (r0 == 0) goto L_0x0173
            android.app.Activity r0 = r1.f70188a
            boolean r0 = r0 instanceof net.one97.paytm.wallet.newdesign.activity.P2PActivity
            if (r0 == 0) goto L_0x016f
            net.one97.paytm.wallet.f.g r0 = r1.f70189b
            if (r0 == 0) goto L_0x016f
            r0.a(r2)
            return
        L_0x016f:
            r16.c()
            return
        L_0x0173:
            java.lang.String r0 = "AL_0006"
            boolean r0 = r0.equalsIgnoreCase(r11)
            if (r0 == 0) goto L_0x0183
            net.one97.paytm.wallet.f.g r0 = r1.f70189b
            if (r0 == 0) goto L_0x0249
            r0.a(r2)
            return
        L_0x0183:
            net.one97.paytm.wallet.communicator.c r0 = net.one97.paytm.wallet.communicator.b.a()
            android.app.Activity r3 = r1.f70188a
            boolean r0 = r0.instanceOfTransferToBank(r3)
            if (r0 != 0) goto L_0x019b
            net.one97.paytm.wallet.communicator.c r0 = net.one97.paytm.wallet.communicator.b.a()
            android.app.Activity r3 = r1.f70188a
            boolean r0 = r0.instanceOfAddToPPB(r3)
            if (r0 == 0) goto L_0x01ab
        L_0x019b:
            android.app.Activity r0 = r1.f70188a
            boolean r0 = r0.isFinishing()
            if (r0 != 0) goto L_0x01ab
            net.one97.paytm.wallet.f.g r0 = r1.f70189b
            if (r0 == 0) goto L_0x0249
            r0.a(r2)
            return
        L_0x01ab:
            android.app.Activity r0 = r1.f70188a
            boolean r0 = r0 instanceof net.one97.paytm.wallet.newdesign.activity.P2PActivity
            if (r0 == 0) goto L_0x01b9
            net.one97.paytm.wallet.f.g r0 = r1.f70189b
            if (r0 == 0) goto L_0x01b9
            r0.a(r2)
            return
        L_0x01b9:
            net.one97.paytm.wallet.d.f$18 r0 = new net.one97.paytm.wallet.d.f$18
            r0.<init>()
            r1.a((java.lang.String) r12, (java.lang.String) r13, (android.view.View.OnClickListener) r0)
            return
        L_0x01c2:
            boolean r0 = r14.equalsIgnoreCase(r7)
            if (r0 == 0) goto L_0x0235
            android.app.Activity r0 = r1.f70188a
            android.content.Intent r0 = r0.getIntent()
            boolean r0 = r0.hasExtra(r4)
            if (r0 == 0) goto L_0x01e3
            android.os.Bundle r0 = r1.f70194g
            r0.putSerializable(r3, r2)
            d.a.a.c r0 = d.a.a.c.a()
            android.os.Bundle r2 = r1.f70194g
            r0.d(r2)
            return
        L_0x01e3:
            java.lang.String r0 = "OTP_0001"
            boolean r0 = r11.equalsIgnoreCase(r0)
            if (r0 == 0) goto L_0x01f1
            r3 = r17
            r1.a((java.lang.String) r12, (java.lang.String) r13, (java.lang.String) r3)
            return
        L_0x01f1:
            java.lang.String r0 = "P2P_1001"
            boolean r0 = r11.equalsIgnoreCase(r0)
            if (r0 == 0) goto L_0x0202
            net.one97.paytm.wallet.d.f$19 r0 = new net.one97.paytm.wallet.d.f$19
            r0.<init>()
            r1.a((java.lang.String) r12, (java.lang.String) r13, (android.view.View.OnClickListener) r0)
            return
        L_0x0202:
            net.one97.paytm.wallet.communicator.c r0 = net.one97.paytm.wallet.communicator.b.a()
            android.app.Activity r3 = r1.f70188a
            boolean r0 = r0.instanceOfTransferToBank(r3)
            if (r0 == 0) goto L_0x021e
            android.app.Activity r0 = r1.f70188a
            boolean r0 = r0.isFinishing()
            if (r0 != 0) goto L_0x021e
            net.one97.paytm.wallet.f.g r0 = r1.f70189b
            if (r0 == 0) goto L_0x0249
            r0.a(r2)
            return
        L_0x021e:
            android.app.Activity r0 = r1.f70188a
            boolean r0 = r0 instanceof net.one97.paytm.wallet.newdesign.activity.P2PActivity
            if (r0 == 0) goto L_0x022c
            net.one97.paytm.wallet.f.g r0 = r1.f70189b
            if (r0 == 0) goto L_0x022c
            r0.a(r2)
            return
        L_0x022c:
            net.one97.paytm.wallet.d.f$2 r0 = new net.one97.paytm.wallet.d.f$2
            r0.<init>()
            r1.a((java.lang.String) r12, (java.lang.String) r13, (android.view.View.OnClickListener) r0)
            return
        L_0x0235:
            java.lang.String r0 = "CONSENT"
            boolean r0 = r14.equalsIgnoreCase(r0)
            if (r0 == 0) goto L_0x0241
            r16.q()
            return
        L_0x0241:
            net.one97.paytm.wallet.d.f$3 r0 = new net.one97.paytm.wallet.d.f$3
            r0.<init>()
            r1.a((java.lang.String) r12, (java.lang.String) r13, (android.view.View.OnClickListener) r0)
        L_0x0249:
            return
        L_0x024a:
            boolean r2 = r0 instanceof net.one97.paytm.common.entity.wallet.CJRWalletResendOtp
            r12 = 5000(0x1388, double:2.4703E-320)
            r14 = 1
            if (r2 == 0) goto L_0x02b9
            net.one97.paytm.common.entity.wallet.CJRWalletResendOtp r0 = (net.one97.paytm.common.entity.wallet.CJRWalletResendOtp) r0
            android.app.Activity r2 = r1.f70188a
            if (r2 == 0) goto L_0x02b8
            boolean r2 = r2.isFinishing()
            if (r2 == 0) goto L_0x025e
            goto L_0x02b8
        L_0x025e:
            if (r0 == 0) goto L_0x02b8
            net.one97.paytm.wallet.dialog.c r2 = r1.f70190c
            if (r2 == 0) goto L_0x02b8
            boolean r2 = r2.isShowing()
            if (r2 == 0) goto L_0x02b8
            java.lang.String r2 = r0.getStatusMessage()
            java.lang.String r0 = r0.getStatusCode()
            if (r0 == 0) goto L_0x02ae
            java.lang.String r0 = r0.trim()
            java.lang.String r3 = "OTP_1001"
            boolean r0 = r0.equalsIgnoreCase(r3)
            if (r0 == 0) goto L_0x02ae
            net.one97.paytm.wallet.dialog.c r0 = r1.f70190c
            android.widget.TextView r2 = r0.f70300c     // Catch:{ Exception -> 0x0294 }
            if (r2 == 0) goto L_0x02a0
            android.widget.TextView r2 = r0.f70300c     // Catch:{ Exception -> 0x0294 }
            r3 = 0
            r2.setEnabled(r3)     // Catch:{ Exception -> 0x0294 }
            android.widget.TextView r0 = r0.f70300c     // Catch:{ Exception -> 0x0294 }
            int r2 = net.one97.paytm.wallet.R.string.otp_sent     // Catch:{ Exception -> 0x0294 }
            r0.setText(r2)     // Catch:{ Exception -> 0x0294 }
            goto L_0x02a0
        L_0x0294:
            r0 = move-exception
            boolean r2 = com.paytm.utility.b.v
            if (r2 == 0) goto L_0x02a0
            java.lang.String r0 = java.lang.String.valueOf(r0)
            com.paytm.utility.q.d(r0)
        L_0x02a0:
            android.os.Handler r0 = new android.os.Handler
            r0.<init>()
            net.one97.paytm.wallet.d.f$17 r2 = new net.one97.paytm.wallet.d.f$17
            r2.<init>()
            r0.postDelayed(r2, r12)
            return
        L_0x02ae:
            net.one97.paytm.wallet.dialog.c r0 = r1.f70190c
            r0.a((java.lang.String) r2)
            net.one97.paytm.wallet.dialog.c r0 = r1.f70190c
            r0.b((boolean) r14)
        L_0x02b8:
            return
        L_0x02b9:
            boolean r2 = r0 instanceof net.one97.paytm.common.entity.wallet.CJRValidateTransaction
            if (r2 == 0) goto L_0x041e
            r2 = r0
            net.one97.paytm.common.entity.wallet.CJRValidateTransaction r2 = (net.one97.paytm.common.entity.wallet.CJRValidateTransaction) r2
            android.app.Activity r0 = r1.f70188a
            if (r0 == 0) goto L_0x041d
            boolean r0 = r0.isFinishing()
            if (r0 == 0) goto L_0x02cc
            goto L_0x041d
        L_0x02cc:
            if (r2 == 0) goto L_0x041d
            java.lang.String r0 = r2.getStatusCode()
            if (r0 == 0) goto L_0x041d
            net.one97.paytm.common.entity.wallet.CJRSendMoneyResponse r0 = r2.getResponse()
            if (r0 == 0) goto L_0x02ee
            net.one97.paytm.common.entity.wallet.CJRSendMoneyResponse r0 = r2.getResponse()
            java.lang.String r0 = r0.getHeading()
            if (r0 == 0) goto L_0x02ee
            net.one97.paytm.common.entity.wallet.CJRSendMoneyResponse r0 = r2.getResponse()
            java.lang.String r0 = r0.getHeading()
            r12 = r0
            goto L_0x02ef
        L_0x02ee:
            r12 = r11
        L_0x02ef:
            java.lang.String r0 = r2.getStatusMessage()
            if (r0 == 0) goto L_0x02fb
            java.lang.String r0 = r2.getStatusMessage()
            r13 = r0
            goto L_0x02fc
        L_0x02fb:
            r13 = r11
        L_0x02fc:
            java.lang.String r0 = r2.getStatus()
            if (r0 == 0) goto L_0x0308
            java.lang.String r0 = r2.getStatus()
            r15 = r0
            goto L_0x0309
        L_0x0308:
            r15 = r11
        L_0x0309:
            java.lang.String r0 = r2.getStatusCode()
            if (r0 == 0) goto L_0x0313
            java.lang.String r11 = r2.getStatusCode()
        L_0x0313:
            if (r2 == 0) goto L_0x0367
            net.one97.paytm.common.entity.wallet.CJRSendMoneyResponse r0 = r2.getResponse()     // Catch:{ Exception -> 0x035f }
            if (r0 == 0) goto L_0x0332
            net.one97.paytm.common.entity.wallet.CJRSendMoneyResponse r0 = r2.getResponse()     // Catch:{ Exception -> 0x035f }
            java.lang.String r0 = r0.getwalletSysTransactionID()     // Catch:{ Exception -> 0x035f }
            if (r0 == 0) goto L_0x0332
            net.one97.paytm.common.entity.wallet.CJRSendMoneyResponse r0 = r2.getResponse()     // Catch:{ Exception -> 0x035f }
            java.lang.String r0 = r0.getwalletSysTransactionID()     // Catch:{ Exception -> 0x035f }
            android.os.Bundle r14 = r1.f70194g     // Catch:{ Exception -> 0x035f }
            r14.putString(r4, r0)     // Catch:{ Exception -> 0x035f }
        L_0x0332:
            java.lang.String r0 = r2.getStatusMessage()     // Catch:{ Exception -> 0x035f }
            if (r0 == 0) goto L_0x0341
            android.os.Bundle r0 = r1.f70194g     // Catch:{ Exception -> 0x035f }
            java.lang.String r4 = r2.getStatusMessage()     // Catch:{ Exception -> 0x035f }
            r0.putString(r5, r4)     // Catch:{ Exception -> 0x035f }
        L_0x0341:
            net.one97.paytm.common.entity.wallet.CJRSendMoneyResponse r0 = r2.getResponse()     // Catch:{ Exception -> 0x035f }
            if (r0 == 0) goto L_0x0367
            net.one97.paytm.common.entity.wallet.CJRSendMoneyResponse r0 = r2.getResponse()     // Catch:{ Exception -> 0x035f }
            java.lang.String r0 = r0.getHeading()     // Catch:{ Exception -> 0x035f }
            if (r0 == 0) goto L_0x0367
            android.os.Bundle r0 = r1.f70194g     // Catch:{ Exception -> 0x035f }
            net.one97.paytm.common.entity.wallet.CJRSendMoneyResponse r4 = r2.getResponse()     // Catch:{ Exception -> 0x035f }
            java.lang.String r4 = r4.getHeading()     // Catch:{ Exception -> 0x035f }
            r0.putString(r3, r4)     // Catch:{ Exception -> 0x035f }
            goto L_0x0367
        L_0x035f:
            r0 = move-exception
            java.lang.String r0 = java.lang.String.valueOf(r0)
            com.paytm.utility.q.d(r0)
        L_0x0367:
            boolean r0 = r15.equalsIgnoreCase(r10)
            if (r0 == 0) goto L_0x037e
            boolean r0 = r11.equalsIgnoreCase(r8)
            if (r0 == 0) goto L_0x037e
            r16.s()
            net.one97.paytm.wallet.f.g r0 = r1.f70189b
            if (r0 == 0) goto L_0x041d
            r0.a(r2)
            return
        L_0x037e:
            boolean r0 = r15.equalsIgnoreCase(r9)
            if (r0 == 0) goto L_0x03b6
            r16.s()
            boolean r0 = r11.equalsIgnoreCase(r6)
            if (r0 == 0) goto L_0x0391
            r16.c()
            return
        L_0x0391:
            net.one97.paytm.wallet.communicator.c r0 = net.one97.paytm.wallet.communicator.b.a()
            android.app.Activity r3 = r1.f70188a
            boolean r0 = r0.instanceOfTransferToBank(r3)
            if (r0 == 0) goto L_0x03ad
            android.app.Activity r0 = r1.f70188a
            boolean r0 = r0.isFinishing()
            if (r0 != 0) goto L_0x03ad
            net.one97.paytm.wallet.f.g r0 = r1.f70189b
            if (r0 == 0) goto L_0x041d
            r0.a(r2)
            return
        L_0x03ad:
            net.one97.paytm.wallet.d.f$4 r0 = new net.one97.paytm.wallet.d.f$4
            r0.<init>()
            r1.a((java.lang.String) r12, (java.lang.String) r13, (android.view.View.OnClickListener) r0)
            return
        L_0x03b6:
            boolean r0 = r15.equalsIgnoreCase(r7)
            if (r0 == 0) goto L_0x0412
            java.lang.String r0 = "OTP_1002"
            boolean r0 = r11.equalsIgnoreCase(r0)
            if (r0 != 0) goto L_0x03fc
            java.lang.String r0 = "OTP_1004"
            boolean r0 = r11.equalsIgnoreCase(r0)
            if (r0 == 0) goto L_0x03cd
            goto L_0x03fc
        L_0x03cd:
            r16.s()
            net.one97.paytm.wallet.communicator.c r0 = net.one97.paytm.wallet.communicator.b.a()
            android.app.Activity r3 = r1.f70188a
            boolean r0 = r0.instanceOfTransferToBank(r3)
            if (r0 == 0) goto L_0x03ec
            android.app.Activity r0 = r1.f70188a
            boolean r0 = r0.isFinishing()
            if (r0 != 0) goto L_0x03ec
            net.one97.paytm.wallet.f.g r0 = r1.f70189b
            if (r0 == 0) goto L_0x041d
            r0.a(r2)
            return
        L_0x03ec:
            net.one97.paytm.wallet.d.f$5 r0 = new net.one97.paytm.wallet.d.f$5
            r0.<init>()
            r1.a((java.lang.String) r12, (java.lang.String) r13, (android.view.View.OnClickListener) r0)
            net.one97.paytm.wallet.f.g r0 = r1.f70189b
            if (r0 == 0) goto L_0x041d
            r0.a(r2)
            return
        L_0x03fc:
            net.one97.paytm.wallet.dialog.c r0 = r1.f70190c
            if (r0 == 0) goto L_0x041d
            boolean r0 = r0.isShowing()
            if (r0 == 0) goto L_0x041d
            net.one97.paytm.wallet.dialog.c r0 = r1.f70190c
            r0.a((java.lang.String) r13)
            net.one97.paytm.wallet.dialog.c r0 = r1.f70190c
            r2 = 1
            r0.a((boolean) r2)
            return
        L_0x0412:
            r16.s()
            net.one97.paytm.wallet.d.f$6 r0 = new net.one97.paytm.wallet.d.f$6
            r0.<init>()
            r1.a((java.lang.String) r12, (java.lang.String) r13, (android.view.View.OnClickListener) r0)
        L_0x041d:
            return
        L_0x041e:
            boolean r2 = r0 instanceof net.one97.paytm.common.entity.shopping.CJROrderSummary
            if (r2 == 0) goto L_0x0470
            net.one97.paytm.common.entity.shopping.CJROrderSummary r0 = (net.one97.paytm.common.entity.shopping.CJROrderSummary) r0
            if (r0 == 0) goto L_0x046d
            java.lang.String r2 = r0.getPaymentStatus()
            if (r2 == 0) goto L_0x046d
            java.lang.String r0 = r0.getPaymentStatus()
            boolean r2 = r0.equalsIgnoreCase(r10)
            if (r2 == 0) goto L_0x043d
            r16.o()
            r16.e()
            return
        L_0x043d:
            java.lang.String r2 = "FAILED"
            boolean r0 = r0.equalsIgnoreCase(r2)
            if (r0 == 0) goto L_0x044c
            r16.o()
            r16.m()
            return
        L_0x044c:
            boolean r0 = r1.f70192e
            if (r0 != 0) goto L_0x0466
            android.app.Activity r0 = r1.f70188a
            if (r0 != 0) goto L_0x0455
            goto L_0x0466
        L_0x0455:
            com.paytm.utility.b.j()
            android.os.Handler r0 = new android.os.Handler
            r0.<init>()
            net.one97.paytm.wallet.d.f$7 r2 = new net.one97.paytm.wallet.d.f$7
            r2.<init>()
            r0.postDelayed(r2, r12)
            return
        L_0x0466:
            r16.o()
            r16.r()
            return
        L_0x046d:
            r16.o()
        L_0x0470:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.wallet.d.f.a(com.paytm.network.model.IJRPaytmDataModel):void");
    }

    public final void a(NetworkCustomError networkCustomError) {
        Activity activity = this.f70188a;
        if (activity != null && !activity.isFinishing()) {
            o();
            k();
            if (networkCustomError != null) {
                try {
                    if ((this.f70188a instanceof P2PActivity) && ((NetworkCustomError.ErrorType.NoConnectionError.equals(networkCustomError.getErrorType()) || NetworkCustomError.ErrorType.TimeOutError.equals(networkCustomError.getErrorType())) && this.f70189b != null)) {
                        this.f70189b.a((IJRDataModel) null);
                    }
                    if (!(networkCustomError.getStatusCode() == 410 || networkCustomError.getStatusCode() == 401)) {
                        if (networkCustomError.getStatusCode() != 403) {
                            if (networkCustomError.getMessage() != null && !b.a().checkErrorCode(this.f70188a, networkCustomError)) {
                                if (networkCustomError.getMessage() == null || !networkCustomError.getMessage().equalsIgnoreCase("parsing_error")) {
                                    com.paytm.utility.b.b((Context) this.f70188a, this.f70188a.getResources().getString(R.string.network_error_heading), this.f70188a.getResources().getString(R.string.network_error_message) + " " + networkCustomError.getUrl());
                                    return;
                                }
                                Activity activity2 = this.f70188a;
                                String url = networkCustomError.getUrl();
                                StringBuilder sb = new StringBuilder();
                                sb.append(networkCustomError.getStatusCode());
                                com.paytm.utility.b.d((Context) activity2, url, sb.toString());
                                return;
                            }
                            return;
                        }
                    }
                    b.a().handleError(this.f70188a, networkCustomError, (String) null, (Bundle) null, false);
                } catch (Resources.NotFoundException e2) {
                    if (com.paytm.utility.b.v) {
                        q.d(String.valueOf(e2));
                    }
                } catch (Exception e3) {
                    if (com.paytm.utility.b.v) {
                        q.d(String.valueOf(e3));
                    }
                }
            } else {
                com.paytm.utility.b.b((Context) this.f70188a, this.f70188a.getResources().getString(R.string.network_error_heading), this.f70188a.getResources().getString(R.string.network_error_message) + " " + networkCustomError.getUrl());
            }
        }
    }

    public final void a(String str) {
        Activity activity;
        if (!TextUtils.isEmpty(str) && (activity = this.f70188a) != null && !activity.isFinishing()) {
            Activity activity2 = this.f70188a;
            a.a(activity2, activity2.getString(R.string.error), str);
        }
    }

    public final void a() {
        g gVar = this.f70189b;
        if (gVar != null) {
            gVar.a();
        }
    }

    public final void b() {
        g gVar = this.f70189b;
        if (gVar != null) {
            gVar.b();
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(WalletPaymentCallbackListener walletPaymentCallbackListener) {
        Activity activity = this.f70188a;
        if (activity != null && !activity.isFinishing()) {
            walletPaymentCallbackListener.onAddMoneyCancelled();
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(String str, boolean z, WalletPaymentCallbackListener walletPaymentCallbackListener) {
        Activity activity = this.f70188a;
        if (activity != null && !activity.isFinishing()) {
            this.l = str;
            this.f70192e = false;
            new Handler().postDelayed(new Runnable() {
                public final void run() {
                    f.this.t();
                }
            }, 120000);
            walletPaymentCallbackListener.onAddMoneyStart();
            b(z, walletPaymentCallbackListener);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void t() {
        this.f70192e = true;
        com.paytm.utility.b.j();
    }

    private void b(boolean z, WalletPaymentCallbackListener walletPaymentCallbackListener) {
        Activity activity = this.f70188a;
        if (activity != null && !activity.isFinishing()) {
            String str = b.a().getStringFromGTM(this.f70188a, "orderdetail") + this.l;
            new net.one97.paytm.network.a(com.paytm.utility.b.b((Context) this.f70188a, str) + "&actions=1", new CJROrderSummary(), (Map<String, String>) null, (Map<String, String>) null).c().observeForever(new z(z, walletPaymentCallbackListener) {
                private final /* synthetic */ boolean f$1;
                private final /* synthetic */ WalletPaymentCallbackListener f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void onChanged(Object obj) {
                    f.this.b(this.f$1, this.f$2, (f) obj);
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    public final void b(WalletPaymentCallbackListener walletPaymentCallbackListener) {
        Activity activity = this.f70188a;
        if (activity != null && !activity.isFinishing()) {
            walletPaymentCallbackListener.onAddMoneyFailure(this.f70188a.getString(R.string.wallet_add_money_failure_title), this.f70188a.getString(R.string.wallet_add_money_failure_message));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(boolean z, WalletPaymentCallbackListener walletPaymentCallbackListener) {
        com.paytm.utility.b.j();
        b(z, walletPaymentCallbackListener);
    }

    public final void a(final boolean z, final WalletPaymentCallbackListener walletPaymentCallbackListener) {
        Activity activity = this.f70188a;
        if (activity != null && !activity.isFinishing() && com.paytm.utility.b.c((Context) this.f70188a)) {
            String q2 = com.paytm.utility.a.q(this.f70188a);
            if (!TextUtils.isEmpty(q2)) {
                b.a().getWalletToken(q2, this.f70188a, new com.paytm.network.listener.b() {
                    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                        if (iJRPaytmDataModel instanceof CJRPGTokenList) {
                            f.a(f.this, z, (CJRPGTokenList) iJRPaytmDataModel, walletPaymentCallbackListener);
                        }
                    }

                    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                        f.this.a(networkCustomError);
                    }
                });
            } else {
                b.a().showSessionTimeoutAlert(this.f70188a);
            }
        }
    }

    public final void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        this.p = str;
        this.q = str2;
        this.r = str3;
        this.s = str4;
        this.t = str5;
        this.n = str6;
        this.o = str7;
        this.u = str8;
        this.v = str9;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        this.f70195h.dismiss();
        if (this.f70188a.getIntent().hasExtra("paymentmode")) {
            d.a.a.c.a().d(this.f70194g);
            return;
        }
        Activity activity = this.f70188a;
        if (activity != null && !activity.isFinishing()) {
            this.f70188a.finish();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(WalletPaymentCallbackListener walletPaymentCallbackListener, View view) {
        this.f70195h.dismiss();
        walletPaymentCallbackListener.onPaymentFailure();
        if (this.f70188a.getIntent().hasExtra("paymentmode")) {
            d.a.a.c.a().d(this.f70194g);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        this.f70195h.dismiss();
        if (this.f70188a.getIntent().hasExtra("paymentmode")) {
            d.a.a.c.a().d(this.f70194g);
        }
    }

    private void a(NetworkCustomError networkCustomError, WalletPaymentCallbackListener walletPaymentCallbackListener) {
        Activity activity = this.f70188a;
        if (activity != null && !activity.isFinishing()) {
            walletPaymentCallbackListener.onPaymentFailure();
            if (networkCustomError != null) {
                try {
                    if ((NetworkCustomError.ErrorType.NoConnectionError.equals(networkCustomError.getErrorType()) || NetworkCustomError.ErrorType.TimeOutError.equals(networkCustomError.getErrorType())) && this.f70189b != null) {
                        this.f70189b.a((IJRDataModel) null);
                    }
                    if (!(networkCustomError.getStatusCode() == 410 || networkCustomError.getStatusCode() == 401)) {
                        if (networkCustomError.getStatusCode() != 403) {
                            if (networkCustomError.getMessage() != null && !b.a().checkErrorCode(this.f70188a, networkCustomError)) {
                                if (networkCustomError.getMessage() == null || !networkCustomError.getMessage().equalsIgnoreCase("parsing_error")) {
                                    com.paytm.utility.b.b((Context) this.f70188a, this.f70188a.getResources().getString(R.string.network_error_heading), this.f70188a.getResources().getString(R.string.network_error_message) + " " + networkCustomError.getUrl());
                                    return;
                                }
                                Activity activity2 = this.f70188a;
                                String url = networkCustomError.getUrl();
                                StringBuilder sb = new StringBuilder();
                                sb.append(networkCustomError.getStatusCode());
                                com.paytm.utility.b.d((Context) activity2, url, sb.toString());
                                return;
                            }
                            return;
                        }
                    }
                    b.a().handleError(this.f70188a, networkCustomError, (String) null, (Bundle) null, false);
                } catch (Resources.NotFoundException e2) {
                    if (com.paytm.utility.b.v) {
                        q.d(String.valueOf(e2));
                    }
                } catch (Exception e3) {
                    if (com.paytm.utility.b.v) {
                        q.d(String.valueOf(e3));
                    }
                }
            } else {
                com.paytm.utility.b.b((Context) this.f70188a, this.f70188a.getResources().getString(R.string.network_error_heading), this.f70188a.getResources().getString(R.string.network_error_message) + " " + networkCustomError.getUrl());
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(boolean z, WalletPaymentCallbackListener walletPaymentCallbackListener, net.one97.paytm.network.f fVar) {
        g gVar;
        if (fVar.f55796a == net.one97.paytm.network.h.SUCCESS) {
            if (fVar.f55797b instanceof CJRSendMoney) {
                CJRSendMoney cJRSendMoney = (CJRSendMoney) fVar.f55797b;
                Activity activity = this.f70188a;
                if (activity != null && !activity.isFinishing() && cJRSendMoney != null && cJRSendMoney.getStatusCode() != null) {
                    String str = "";
                    String heading = (cJRSendMoney.getResponse() == null || cJRSendMoney.getResponse().getHeading() == null) ? str : cJRSendMoney.getResponse().getHeading();
                    String statusMessage = cJRSendMoney.getStatusMessage() != null ? cJRSendMoney.getStatusMessage() : str;
                    String status = cJRSendMoney.getStatus() != null ? cJRSendMoney.getStatus() : str;
                    if (cJRSendMoney.getStatusCode() != null) {
                        str = cJRSendMoney.getStatusCode();
                    }
                    String str2 = null;
                    if (cJRSendMoney.getResponse() != null) {
                        str2 = cJRSendMoney.getResponse().getState();
                    }
                    if (cJRSendMoney != null) {
                        try {
                            if (!(cJRSendMoney.getResponse() == null || cJRSendMoney.getResponse().getwalletSysTransactionID() == null)) {
                                this.f70194g.putString("resultdata", cJRSendMoney.getResponse().getwalletSysTransactionID());
                            }
                            if (cJRSendMoney.getStatusMessage() != null) {
                                this.f70194g.putString("response Message", cJRSendMoney.getStatusMessage());
                            }
                            if (!(cJRSendMoney.getResponse() == null || cJRSendMoney.getResponse().getHeading() == null)) {
                                this.f70194g.putString("response title", cJRSendMoney.getResponse().getHeading());
                            }
                        } catch (Exception e2) {
                            q.d(String.valueOf(e2));
                        }
                    }
                    cJRSendMoney.setAmount(this.s);
                    if (!status.equalsIgnoreCase("SUCCESS") || !str.equalsIgnoreCase("SS_0001")) {
                        if (status.equalsIgnoreCase("FAILURE")) {
                            if (z) {
                                Intent intent = new Intent();
                                cJRSendMoney.setComment(this.t);
                                this.f70188a.setResult(-1, intent);
                                this.f70188a.finish();
                                this.f70194g.putSerializable("postpaymentscreendata", cJRSendMoney);
                                d.a.a.c.a().d(this.f70194g);
                                return;
                            }
                            g gVar2 = this.f70189b;
                            if (gVar2 != null) {
                                gVar2.a(cJRSendMoney);
                            }
                        } else if (status.equalsIgnoreCase("PENDING")) {
                            if (z) {
                                Intent intent2 = new Intent();
                                cJRSendMoney.setComment(this.t);
                                this.f70188a.setResult(-1, intent2);
                                this.f70188a.finish();
                                this.f70194g.putSerializable("postpaymentscreendata", cJRSendMoney);
                                d.a.a.c.a().d(this.f70194g);
                            } else if (str.equalsIgnoreCase("OTP_0001")) {
                                a(heading, statusMessage, str2);
                            } else if (str.equalsIgnoreCase("P2P_1001")) {
                                a(heading, statusMessage, (View.OnClickListener) new View.OnClickListener() {
                                    public final void onClick(View view) {
                                        f.this.b(view);
                                    }
                                });
                            } else if (b.a().instanceOfTransferToBank(this.f70188a) && !this.f70188a.isFinishing()) {
                                g gVar3 = this.f70189b;
                                if (gVar3 != null) {
                                    gVar3.a(cJRSendMoney);
                                }
                            } else if (!(this.f70188a instanceof P2PActivity) || (gVar = this.f70189b) == null) {
                                a(heading, statusMessage, (View.OnClickListener) new View.OnClickListener(walletPaymentCallbackListener) {
                                    private final /* synthetic */ WalletPaymentCallbackListener f$1;

                                    {
                                        this.f$1 = r2;
                                    }

                                    public final void onClick(View view) {
                                        f.this.a(this.f$1, view);
                                    }
                                });
                            } else {
                                gVar.a(cJRSendMoney);
                            }
                        } else if (status.equalsIgnoreCase("CONSENT")) {
                            q();
                        } else {
                            a(heading, statusMessage, (View.OnClickListener) new View.OnClickListener() {
                                public final void onClick(View view) {
                                    f.this.a(view);
                                }
                            });
                        }
                    } else if (cJRSendMoney.getmResponse() != null && cJRSendMoney.getmResponse().getmFFResponse() != null) {
                        g gVar4 = this.f70189b;
                        if (gVar4 != null) {
                            gVar4.a(cJRSendMoney);
                        }
                    } else if (z) {
                        Intent intent3 = new Intent();
                        cJRSendMoney.setComment(this.t);
                        this.f70188a.setResult(-1, intent3);
                        this.f70188a.finish();
                        this.f70194g.putSerializable("postpaymentscreendata", cJRSendMoney);
                        d.a.a.c.a().d(this.f70194g);
                    } else {
                        g gVar5 = this.f70189b;
                        if (gVar5 != null) {
                            gVar5.a(cJRSendMoney);
                        }
                    }
                }
            }
        } else if (fVar.f55796a == net.one97.paytm.network.h.ERROR) {
            a(fVar.f55798c.f55801c, walletPaymentCallbackListener);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(boolean z, WalletPaymentCallbackListener walletPaymentCallbackListener, net.one97.paytm.network.f fVar) {
        if (fVar.f55796a == net.one97.paytm.network.h.SUCCESS) {
            if (fVar.f55797b instanceof CJROrderSummary) {
                CJROrderSummary cJROrderSummary = (CJROrderSummary) fVar.f55797b;
                if (!(cJROrderSummary == null || cJROrderSummary.getPaymentStatus() == null)) {
                    String paymentStatus = cJROrderSummary.getPaymentStatus();
                    if (paymentStatus.equalsIgnoreCase("SUCCESS")) {
                        walletPaymentCallbackListener.onAddMoneySuccess();
                        a(z, walletPaymentCallbackListener);
                        return;
                    } else if (!paymentStatus.equalsIgnoreCase("FAILED")) {
                        com.paytm.utility.b.j();
                        new Handler().postDelayed(new Runnable(z, walletPaymentCallbackListener) {
                            private final /* synthetic */ boolean f$1;
                            private final /* synthetic */ WalletPaymentCallbackListener f$2;

                            {
                                this.f$1 = r2;
                                this.f$2 = r3;
                            }

                            public final void run() {
                                f.this.c(this.f$1, this.f$2);
                            }
                        }, 5000);
                        return;
                    }
                }
                walletPaymentCallbackListener.onAddMoneyFailure(this.f70188a.getString(R.string.wallet_add_money_failure_title), this.f70188a.getString(R.string.wallet_add_money_failure_message));
            }
        } else if (fVar.f55796a == net.one97.paytm.network.h.ERROR) {
            a(fVar.f55798c.f55801c, walletPaymentCallbackListener);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(net.one97.paytm.network.f fVar) {
        if (fVar.f55796a == net.one97.paytm.network.h.SUCCESS) {
            a(fVar.f55797b);
        } else if (fVar.f55796a == net.one97.paytm.network.h.ERROR) {
            a(fVar.f55798c.f55801c);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(net.one97.paytm.network.f fVar) {
        if (fVar.f55796a == net.one97.paytm.network.h.SUCCESS) {
            a(fVar.f55797b);
        } else if (fVar.f55796a == net.one97.paytm.network.h.ERROR) {
            a(fVar.f55798c.f55801c);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(net.one97.paytm.network.f fVar) {
        if (fVar.f55796a == net.one97.paytm.network.h.SUCCESS) {
            if (fVar.f55797b instanceof CJROrderSummary) {
                a(fVar.f55797b);
            }
        } else if (fVar.f55796a == net.one97.paytm.network.h.ERROR) {
            a(fVar.f55798c.f55801c);
        }
    }

    static /* synthetic */ void a(f fVar, boolean z, CJRPGTokenList cJRPGTokenList, WalletPaymentCallbackListener walletPaymentCallbackListener) {
        JSONObject jSONObject;
        f fVar2 = fVar;
        Activity activity = fVar2.f70188a;
        if (activity != null && !activity.isFinishing()) {
            String pgToken = b.a().getPgToken(cJRPGTokenList);
            if (!TextUtils.isEmpty(pgToken)) {
                Activity activity2 = fVar2.f70188a;
                if (activity2 != null && !activity2.isFinishing()) {
                    String stringFromGTM = b.a().getStringFromGTM(fVar2.f70188a, "walletSendMoneyV2");
                    if (URLUtil.isValidUrl(stringFromGTM)) {
                        String str = com.paytm.utility.b.e((Context) fVar2.f70188a, stringFromGTM) + ("&isContactInPhonebook=" + b.a().contactExists(fVar2.f70188a, fVar2.q)) + ("&uuid=" + UUID.randomUUID().toString() + "&timestamp=" + System.currentTimeMillis());
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            if (fVar2.m != null) {
                                jSONObject = fVar2.m.getJson();
                                jSONObject.put(CJRQRScanResultModel.KEY_MERCHANT_ORDER_ID, fVar2.m.getOrderID());
                            } else {
                                jSONObject = new JSONObject();
                            }
                            jSONObject.put("isToVerify", fVar2.n);
                            jSONObject.put("isLimitApplicable", fVar2.o);
                            if (fVar2.r != null) {
                                jSONObject.put("payeeSsoId", fVar2.r);
                            }
                            if (fVar2.r == null) {
                                if (fVar2.q != null) {
                                    jSONObject.put("payeePhoneNumber", fVar2.q);
                                } else {
                                    jSONObject.put("payeeEmailId", fVar2.p);
                                }
                            }
                            if (!TextUtils.isEmpty(fVar2.v)) {
                                JSONObject jSONObject3 = new JSONObject();
                                jSONObject3.put("paymentsThemeId", fVar2.v);
                                jSONObject.put("extendedInfo", jSONObject3);
                            }
                            if (net.one97.paytm.wallet.newdesign.universalp2p.c.b.a(fVar2.f70188a).q) {
                                jSONObject.put("pcFail", true);
                            }
                            jSONObject.put("amount", fVar2.s);
                            jSONObject.put("currencyCode", "INR");
                            jSONObject.put(CJRQRScanResultModel.KEY_COMMENT_SMALL, fVar2.t);
                            jSONObject.put("mode", fVar2.u);
                            jSONObject2.put("request", jSONObject);
                            jSONObject2.put(NearbyRequestCreator.NearbyRequestConstants.ipAddress, "127.0.0.1");
                            jSONObject2.put(NearbyRequestCreator.NearbyRequestConstants.platformName, "PayTM");
                            jSONObject2.put(H5RpcPlugin.RpcRequest.RpcParam.OPERATION_TYPE, "P2P_TRANSFER");
                            jSONObject2.put("channel", UpiConstants.MP_ANDROID);
                            String str2 = null;
                            try {
                                str2 = fVar2.f70188a.getPackageManager().getPackageInfo(fVar2.f70188a.getPackageName(), 0).versionName;
                            } catch (Exception e2) {
                                if (com.paytm.utility.b.v) {
                                    q.d(String.valueOf(e2));
                                }
                            }
                            if (str2 != null) {
                                jSONObject2.put("version", str2);
                            }
                        } catch (JSONException e3) {
                            fVar.k();
                            if (com.paytm.utility.b.v) {
                                q.d(String.valueOf(e3));
                            }
                        }
                        HashMap hashMap = new HashMap();
                        hashMap.put("Content-Type", "application/json");
                        hashMap.put("ssotoken", pgToken);
                        if (net.one97.paytm.f.b.a().f50402a != null) {
                            try {
                                JSONObject jSONObject4 = new JSONObject(new com.google.gson.f().a((Object) net.one97.paytm.f.b.a().f50402a, new com.google.gson.b.a<RiskExtendedInfo>() {
                                }.getType()));
                                jSONObject4.put("displayName", URLEncoder.encode((String) jSONObject4.get("displayName"), AppConstants.UTF_8));
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
                        net.one97.paytm.network.b bVar = new net.one97.paytm.network.b(str, new CJRSendMoney(), (Map<String, String>) null, hashMap, jSONObject2.toString());
                        bVar.e();
                        bVar.a(a.a(b.a().getIntegerFromGTM((Context) fVar2.f70188a, "sendMoneyAPITimeout")));
                        bVar.c().observeForever(new z(z, walletPaymentCallbackListener) {
                            private final /* synthetic */ boolean f$1;
                            private final /* synthetic */ WalletPaymentCallbackListener f$2;

                            {
                                this.f$1 = r2;
                                this.f$2 = r3;
                            }

                            public final void onChanged(Object obj) {
                                f.this.a(this.f$1, this.f$2, (f) obj);
                            }
                        });
                        return;
                    }
                    return;
                }
                return;
            }
            WalletPaymentCallbackListener walletPaymentCallbackListener2 = walletPaymentCallbackListener;
            walletPaymentCallbackListener.onPaymentFailure();
            b.a().showSessionTimeoutAlert(fVar2.f70188a);
        }
    }
}
