package net.one97.paytm.p2b.d;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.Toast;
import com.alipay.iap.android.webapp.sdk.plugin.H5RpcPlugin;
import com.google.gson.f;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.a;
import com.paytm.utility.h;
import java.util.HashMap;
import net.one97.paytm.common.entity.RiskAnalysis.RiskExtendedInfo;
import net.one97.paytm.common.entity.shopping.CJROrderSummary;
import net.one97.paytm.common.entity.upgradeKyc.NearbyRequestCreator;
import net.one97.paytm.common.entity.wallet.CJRSendMoney;
import net.one97.paytm.common.entity.wallet.CJRValidateTransaction;
import net.one97.paytm.p2b.R;
import net.one97.paytm.p2b.b.b;
import net.one97.paytm.p2b.b.c;
import net.one97.paytm.p2b.b.d;
import net.one97.paytm.p2b.data.Bean.CJRWalletResendOtp;
import net.one97.paytm.p2b.view.Activity.SendMoneyToBankActivity;
import net.one97.paytm.upi.util.UpiConstants;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class e implements b, d {

    /* renamed from: a  reason: collision with root package name */
    protected Activity f12686a;

    /* renamed from: b  reason: collision with root package name */
    protected c f12687b;

    /* renamed from: c  reason: collision with root package name */
    net.one97.paytm.p2b.view.b.b f12688c;

    /* renamed from: d  reason: collision with root package name */
    boolean f12689d = false;

    /* renamed from: e  reason: collision with root package name */
    protected String f12690e = "P2P_TRANSFER";

    /* renamed from: f  reason: collision with root package name */
    Bundle f12691f = new Bundle();

    /* renamed from: g  reason: collision with root package name */
    h f12692g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f12693h = true;

    /* renamed from: i  reason: collision with root package name */
    private Dialog f12694i;
    private ProgressDialog j;
    private String k;

    /* access modifiers changed from: protected */
    public abstract void c();

    /* access modifiers changed from: protected */
    public abstract void d();

    /* access modifiers changed from: protected */
    public abstract void e();

    public final void a(Activity activity, String str, c cVar) {
        this.f12686a = activity;
        this.f12687b = cVar;
        h.b().a(activity, (b) this);
        if (!TextUtils.isEmpty(str)) {
            this.f12690e = str;
        }
    }

    public final void f() {
        this.f12686a = null;
        this.f12687b = null;
        h.b().o();
    }

    private void m() {
        try {
            if (this.f12694i != null && this.f12694i.isShowing()) {
                this.f12694i.dismiss();
            }
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                e2.printStackTrace();
            }
        }
    }

    private void n() {
        try {
            if (this.j != null && this.j.isShowing()) {
                this.j.dismiss();
            }
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                e2.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void g() {
        Activity activity = this.f12686a;
        if (activity != null && !activity.isFinishing()) {
            i();
            Activity activity2 = this.f12686a;
            k.a(activity2, activity2.getString(R.string.p2b_no_connection), this.f12686a.getString(R.string.p2b_no_internet));
        }
    }

    /* access modifiers changed from: protected */
    public final void h() {
        c cVar = this.f12687b;
        if (cVar != null) {
            cVar.b();
        }
        if (this.f12693h) {
            try {
                if (this.f12694i == null) {
                    this.f12694i = a(this.f12686a);
                }
                if (this.f12694i != null && !this.f12694i.isShowing()) {
                    this.f12694i.show();
                }
            } catch (Exception e2) {
                if (com.paytm.utility.b.v) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void i() {
        c cVar = this.f12687b;
        if (cVar != null) {
            cVar.c();
        }
        m();
    }

    /* access modifiers changed from: protected */
    public final void c(String str) {
        Activity activity = this.f12686a;
        if (activity != null && !activity.isFinishing()) {
            this.k = str;
            this.f12689d = false;
            new Handler().postDelayed(new Runnable() {
                public final void run() {
                    e.this.f12689d = true;
                    com.paytm.utility.b.j();
                }
            }, 120000);
            Activity activity2 = this.f12686a;
            if (activity2 != null && !activity2.isFinishing()) {
                try {
                    if (this.j == null) {
                        this.j = new ProgressDialog(this.f12686a);
                        this.j.setProgressStyle(0);
                        this.j.setMessage(this.f12686a.getResources().getString(R.string.p2b_paytm_cash_addition_confirmation_message));
                        this.j.setCancelable(false);
                        this.j.setCanceledOnTouchOutside(false);
                    }
                    if (!this.j.isShowing()) {
                        this.j.show();
                    }
                } catch (Exception e2) {
                    if (com.paytm.utility.b.v) {
                        e2.printStackTrace();
                    }
                }
            }
            o();
        }
    }

    /* access modifiers changed from: protected */
    public final void j() {
        Activity activity = this.f12686a;
        if (activity != null && !activity.isFinishing()) {
            if (!com.paytm.utility.b.c((Context) this.f12686a)) {
                g();
            } else if (!TextUtils.isEmpty(a.q(this.f12686a))) {
                h();
                h.b().a(this.f12686a, (com.paytm.network.listener.b) new com.paytm.network.listener.b() {
                    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                        e.this.a(iJRPaytmDataModel);
                    }

                    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                        e.this.a(networkCustomError);
                    }
                });
            } else {
                Activity activity2 = this.f12686a;
                if (activity2 != null && !activity2.isFinishing()) {
                    i();
                    n();
                }
                h.b().a(this.f12686a, (String) null, false);
            }
        }
    }

    /* access modifiers changed from: private */
    public void o() {
        Activity activity;
        if (this.f12689d || (activity = this.f12686a) == null) {
            n();
            p();
            return;
        }
        i.a(activity, this.k, "P2BHelperBase", new com.paytm.network.listener.b() {
            public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                if (iJRPaytmDataModel instanceof CJROrderSummary) {
                    e.this.a(iJRPaytmDataModel);
                }
            }

            public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                e.this.a(networkCustomError);
            }
        });
    }

    private void p() {
        Activity activity = this.f12686a;
        if (activity != null && !activity.isFinishing()) {
            n();
            new AlertDialog.Builder(this.f12686a).setTitle(R.string.p2b_wallet_add_money_delayed_title).setMessage(R.string.p2b_wallet_add_money_delayed_message).setPositiveButton(R.string.p2b_wallet_add_money_delayed_positive_button, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    dialogInterface.dismiss();
                    if (h.b().d(e.this.f12686a)) {
                        e.this.f12686a.finish();
                    }
                }
            }).show();
        }
    }

    /* access modifiers changed from: protected */
    public final void k() {
        Activity activity = this.f12686a;
        if (activity != null && !activity.isFinishing()) {
            n();
            i();
            final h hVar = new h(this.f12686a);
            hVar.setTitle(R.string.p2b_wallet_add_money_failure_title);
            hVar.a(this.f12686a.getString(R.string.p2b_wallet_add_money_failure_message));
            hVar.a(-1, this.f12686a.getString(R.string.p2b_wallet_add_money_failure_positive_button), new View.OnClickListener() {
                public final void onClick(View view) {
                    hVar.dismiss();
                    e.this.e();
                }
            });
            hVar.a(-2, this.f12686a.getString(R.string.p2b_wallet_add_money_failure_negative_button), new View.OnClickListener() {
                public final void onClick(View view) {
                    hVar.dismiss();
                }
            });
            hVar.show();
        }
    }

    /* access modifiers changed from: protected */
    public final void l() {
        Activity activity = this.f12686a;
        if (activity != null && !activity.isFinishing()) {
            n();
            i();
        }
    }

    private void a(String str, String str2, View.OnClickListener onClickListener) {
        this.f12692g = new h(this.f12686a);
        this.f12692g.setTitle(str);
        this.f12692g.a(str2);
        this.f12692g.a(-3, this.f12686a.getResources().getString(R.string.ok), onClickListener);
        this.f12692g.setCancelable(true);
        this.f12692g.show();
    }

    private void q() {
        net.one97.paytm.p2b.view.b.b bVar;
        Activity activity = this.f12686a;
        if (activity != null && !activity.isFinishing() && (bVar = this.f12688c) != null && bVar.isShowing()) {
            this.f12688c.dismiss();
        }
    }

    public final void b(String str) {
        Activity activity = this.f12686a;
        if (activity != null && !activity.isFinishing()) {
            if (com.paytm.utility.b.c((Context) this.f12686a)) {
                Activity activity2 = this.f12686a;
                String str2 = this.f12690e;
                AnonymousClass9 r2 = new com.paytm.network.listener.b() {
                    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                        e.this.a(iJRPaytmDataModel);
                    }

                    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                        e.this.a(networkCustomError);
                    }
                };
                String a2 = h.b().a("walletResendOtp");
                if (URLUtil.isValidUrl(a2)) {
                    String e2 = com.paytm.utility.b.e((Context) activity2, a2);
                    HashMap hashMap = new HashMap();
                    hashMap.put("Content-Type", "application/json");
                    hashMap.put("ssotoken", a.q(activity2));
                    JSONObject jSONObject = new JSONObject();
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("state", str);
                        jSONObject.put("request", jSONObject2);
                        jSONObject.put(NearbyRequestCreator.NearbyRequestConstants.ipAddress, "127.0.0.1");
                        jSONObject.put(NearbyRequestCreator.NearbyRequestConstants.platformName, "PayTM");
                        jSONObject.put(H5RpcPlugin.RpcRequest.RpcParam.OPERATION_TYPE, str2);
                        jSONObject.put("channel", UpiConstants.MP_ANDROID);
                        String str3 = null;
                        try {
                            str3 = activity2.getPackageManager().getPackageInfo(activity2.getPackageName(), 0).versionName;
                        } catch (Exception e3) {
                            if (com.paytm.utility.b.v) {
                                e3.printStackTrace();
                            }
                        }
                        if (str3 != null) {
                            jSONObject.put("version", str3);
                        }
                    } catch (JSONException e4) {
                        if (com.paytm.utility.b.v) {
                            e4.printStackTrace();
                        }
                    }
                    com.paytm.network.b bVar = new com.paytm.network.b();
                    bVar.f42877a = activity2;
                    bVar.f42878b = a.c.P2B;
                    bVar.f42879c = a.C0715a.POST;
                    bVar.n = a.b.SILENT;
                    bVar.o = "P2BHelperBase";
                    bVar.f42884h = jSONObject.toString();
                    bVar.f42882f = hashMap;
                    bVar.f42880d = e2;
                    bVar.f42885i = new CJRWalletResendOtp();
                    bVar.j = r2;
                    bVar.x = 0;
                    com.paytm.network.a l = bVar.l();
                    l.a((Object) "P2BHelperBase");
                    l.a();
                    return;
                }
                return;
            }
            g();
        }
    }

    public final void a(String str, String str2) {
        Activity activity = this.f12686a;
        if (activity != null && !activity.isFinishing()) {
            if (com.paytm.utility.b.c((Context) this.f12686a)) {
                h();
                Activity activity2 = this.f12686a;
                String str3 = this.f12690e;
                AnonymousClass10 r2 = new com.paytm.network.listener.b() {
                    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                        e.this.a(iJRPaytmDataModel);
                    }

                    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                        e.this.a(networkCustomError);
                    }
                };
                String a2 = h.b().a("walletValidateTransaction");
                if (URLUtil.isValidUrl(a2)) {
                    String e2 = com.paytm.utility.b.e((Context) activity2, a2);
                    HashMap hashMap = new HashMap();
                    hashMap.put("Content-Type", "application/json");
                    hashMap.put("ssotoken", com.paytm.utility.a.q(activity2));
                    if (net.one97.paytm.f.b.a().f50402a != null && net.one97.paytm.f.b.a().f50403b) {
                        net.one97.paytm.f.b.a().f50402a.setOtpReadFlag(true);
                        hashMap.put("risk_extended_info", new f().a((Object) net.one97.paytm.f.b.a().f50402a, new com.google.gson.b.a<RiskExtendedInfo>() {
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
                        jSONObject.put(H5RpcPlugin.RpcRequest.RpcParam.OPERATION_TYPE, str3);
                        jSONObject.put("channel", UpiConstants.MP_ANDROID);
                        String str4 = null;
                        try {
                            str4 = activity2.getPackageManager().getPackageInfo(activity2.getPackageName(), 0).versionName;
                        } catch (Exception e3) {
                            if (com.paytm.utility.b.v) {
                                e3.printStackTrace();
                            }
                        }
                        if (str4 != null) {
                            jSONObject.put("version", str4);
                        }
                    } catch (JSONException e4) {
                        if (com.paytm.utility.b.v) {
                            e4.printStackTrace();
                        }
                    }
                    com.paytm.network.b bVar = new com.paytm.network.b();
                    bVar.f42877a = activity2;
                    bVar.f42878b = a.c.P2B;
                    bVar.f42879c = a.C0715a.POST;
                    bVar.n = a.b.SILENT;
                    bVar.o = "P2BHelperBase";
                    bVar.f42884h = jSONObject.toString();
                    bVar.f42882f = hashMap;
                    bVar.f42880d = e2;
                    bVar.f42885i = new CJRValidateTransaction();
                    bVar.j = r2;
                    bVar.x = 0;
                    com.paytm.network.a l = bVar.l();
                    l.a((Object) "P2BHelperBase");
                    l.a();
                    return;
                }
                return;
            }
            g();
        }
    }

    public void a(IJRPaytmDataModel iJRPaytmDataModel) {
        net.one97.paytm.p2b.view.b.b bVar;
        IJRPaytmDataModel iJRPaytmDataModel2 = iJRPaytmDataModel;
        Activity activity = this.f12686a;
        if (activity != null && !activity.isFinishing()) {
            i();
            String str = "";
            if (iJRPaytmDataModel2 instanceof CJRSendMoney) {
                CJRSendMoney cJRSendMoney = (CJRSendMoney) iJRPaytmDataModel2;
                Activity activity2 = this.f12686a;
                if (activity2 != null && !activity2.isFinishing()) {
                    q();
                    if (cJRSendMoney != null && cJRSendMoney.getStatusCode() != null) {
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
                        String str3 = str2;
                        if (cJRSendMoney != null) {
                            try {
                                if (!(cJRSendMoney.getResponse() == null || cJRSendMoney.getResponse().getwalletSysTransactionID() == null)) {
                                    this.f12691f.putString("resultdata", cJRSendMoney.getResponse().getwalletSysTransactionID());
                                }
                                if (cJRSendMoney.getStatusMessage() != null) {
                                    this.f12691f.putString("response Message", cJRSendMoney.getStatusMessage());
                                }
                                if (!(cJRSendMoney.getResponse() == null || cJRSendMoney.getResponse().getHeading() == null)) {
                                    this.f12691f.putString("response title", cJRSendMoney.getResponse().getHeading());
                                }
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                        if (!status.equalsIgnoreCase("SUCCESS") || !str.equalsIgnoreCase("SS_0001")) {
                            if (status.equalsIgnoreCase("FAILURE")) {
                                if (str.equalsIgnoreCase("WM_1006")) {
                                    c();
                                } else if ("AL_0006".equalsIgnoreCase(str)) {
                                    c cVar = this.f12687b;
                                    if (cVar != null) {
                                        cVar.a(cJRSendMoney);
                                    }
                                } else if (!b(this.f12686a) || this.f12686a.isFinishing()) {
                                    a(heading, statusMessage, (View.OnClickListener) new View.OnClickListener() {
                                        public final void onClick(View view) {
                                            e.this.f12692g.dismiss();
                                            d.a.a.c.a().c(e.this.f12691f);
                                            if (e.this.f12686a.getIntent().hasExtra("paymentmode")) {
                                                d.a.a.c.a().d(e.this.f12691f);
                                            }
                                        }
                                    });
                                } else {
                                    c cVar2 = this.f12687b;
                                    if (cVar2 != null) {
                                        cVar2.a(cJRSendMoney);
                                    }
                                }
                            } else if (status.equalsIgnoreCase("PENDING")) {
                                if (str.equalsIgnoreCase("OTP_0001")) {
                                    Activity activity3 = this.f12686a;
                                    if (activity3 != null && !activity3.isFinishing()) {
                                        this.f12688c = new net.one97.paytm.p2b.view.b.b(this.f12686a, heading, statusMessage, str3, this);
                                        this.f12688c.setCanceledOnTouchOutside(false);
                                        this.f12688c.show();
                                    }
                                } else if (str.equalsIgnoreCase("P2P_1001")) {
                                    a(heading, statusMessage, (View.OnClickListener) new View.OnClickListener() {
                                        public final void onClick(View view) {
                                            e.this.f12692g.dismiss();
                                            if (e.this.f12686a.getIntent().hasExtra("paymentmode")) {
                                                d.a.a.c.a().d(e.this.f12691f);
                                            } else if (e.this.f12686a != null && !e.this.f12686a.isFinishing()) {
                                                e.this.f12686a.finish();
                                            }
                                        }
                                    });
                                } else if (!b(this.f12686a) || this.f12686a.isFinishing()) {
                                    a(heading, statusMessage, (View.OnClickListener) new View.OnClickListener() {
                                        public final void onClick(View view) {
                                            e.this.f12692g.dismiss();
                                            if (e.this.f12686a.getIntent().hasExtra("paymentmode")) {
                                                d.a.a.c.a().d(e.this.f12691f);
                                            }
                                        }
                                    });
                                } else {
                                    c cVar3 = this.f12687b;
                                    if (cVar3 != null) {
                                        cVar3.a(cJRSendMoney);
                                    }
                                }
                            } else if (status.equalsIgnoreCase("CONSENT")) {
                                Activity activity4 = this.f12686a;
                                if (activity4 != null && !activity4.isFinishing()) {
                                    final h hVar = new h(this.f12686a);
                                    hVar.setTitle(this.f12686a.getString(R.string.p2b_unverified_wallet_title));
                                    hVar.a(this.f12686a.getString(R.string.p2b_unverified_wallet_message));
                                    hVar.a(-3, this.f12686a.getResources().getString(R.string.p2b_i_understand), new View.OnClickListener() {
                                        public final void onClick(View view) {
                                            hVar.dismiss();
                                        }
                                    });
                                    hVar.setCancelable(true);
                                    hVar.show();
                                }
                            } else {
                                a(heading, statusMessage, (View.OnClickListener) new View.OnClickListener() {
                                    public final void onClick(View view) {
                                        e.this.f12692g.dismiss();
                                        if (e.this.f12686a.getIntent().hasExtra("paymentmode")) {
                                            d.a.a.c.a().d(e.this.f12691f);
                                        }
                                    }
                                });
                            }
                        } else if (this.f12686a.getIntent().hasExtra("paymentmode")) {
                            this.f12691f.putSerializable("postpaymentscreendata", cJRSendMoney);
                            d.a.a.c.a().d(this.f12691f);
                        } else {
                            c cVar4 = this.f12687b;
                            if (cVar4 != null) {
                                cVar4.a(cJRSendMoney);
                            }
                        }
                    }
                }
            } else if (iJRPaytmDataModel2 instanceof CJRWalletResendOtp) {
                CJRWalletResendOtp cJRWalletResendOtp = (CJRWalletResendOtp) iJRPaytmDataModel2;
                Activity activity5 = this.f12686a;
                if (activity5 != null && !activity5.isFinishing() && cJRWalletResendOtp != null && (bVar = this.f12688c) != null && bVar.isShowing()) {
                    String statusMessage2 = cJRWalletResendOtp.getStatusMessage();
                    String statusCode = cJRWalletResendOtp.getStatusCode();
                    if (statusCode == null || !statusCode.trim().equalsIgnoreCase("OTP_1001")) {
                        this.f12688c.a(statusMessage2);
                        this.f12688c.b(true);
                        return;
                    }
                    net.one97.paytm.p2b.view.b.b bVar2 = this.f12688c;
                    try {
                        if (bVar2.f12896b != null) {
                            bVar2.f12896b.setEnabled(false);
                            bVar2.f12896b.setText(R.string.p2b_otp_sent);
                        }
                    } catch (Exception e3) {
                        if (com.paytm.utility.b.v) {
                            e3.printStackTrace();
                        }
                    }
                    new Handler().postDelayed(new Runnable() {
                        public final void run() {
                            if (e.this.f12688c != null && e.this.f12688c.isShowing()) {
                                e.this.f12688c.b(true);
                            }
                        }
                    }, 5000);
                }
            } else if (iJRPaytmDataModel2 instanceof CJRValidateTransaction) {
                CJRValidateTransaction cJRValidateTransaction = (CJRValidateTransaction) iJRPaytmDataModel2;
                Activity activity6 = this.f12686a;
                if (activity6 != null && !activity6.isFinishing() && cJRValidateTransaction != null && cJRValidateTransaction.getStatusCode() != null) {
                    String heading2 = (cJRValidateTransaction.getResponse() == null || cJRValidateTransaction.getResponse().getHeading() == null) ? str : cJRValidateTransaction.getResponse().getHeading();
                    String statusMessage3 = cJRValidateTransaction.getStatusMessage() != null ? cJRValidateTransaction.getStatusMessage() : str;
                    String status2 = cJRValidateTransaction.getStatus() != null ? cJRValidateTransaction.getStatus() : str;
                    if (cJRValidateTransaction.getStatusCode() != null) {
                        str = cJRValidateTransaction.getStatusCode();
                    }
                    if (cJRValidateTransaction != null) {
                        try {
                            if (!(cJRValidateTransaction.getResponse() == null || cJRValidateTransaction.getResponse().getwalletSysTransactionID() == null)) {
                                this.f12691f.putString("resultdata", cJRValidateTransaction.getResponse().getwalletSysTransactionID());
                            }
                            if (cJRValidateTransaction.getStatusMessage() != null) {
                                this.f12691f.putString("response Message", cJRValidateTransaction.getStatusMessage());
                            }
                            if (!(cJRValidateTransaction.getResponse() == null || cJRValidateTransaction.getResponse().getHeading() == null)) {
                                this.f12691f.putString("response title", cJRValidateTransaction.getResponse().getHeading());
                            }
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                    }
                    if (status2.equalsIgnoreCase("SUCCESS") && str.equalsIgnoreCase("SS_0001")) {
                        q();
                        c cVar5 = this.f12687b;
                        if (cVar5 != null) {
                            cVar5.a(cJRValidateTransaction);
                        }
                    } else if (status2.equalsIgnoreCase("FAILURE")) {
                        q();
                        if (str.equalsIgnoreCase("WM_1006")) {
                            c();
                        } else if (!b(this.f12686a) || this.f12686a.isFinishing()) {
                            a(heading2, statusMessage3, (View.OnClickListener) new View.OnClickListener() {
                                public final void onClick(View view) {
                                    e.this.f12692g.dismiss();
                                    if (e.this.f12686a.getIntent().hasExtra("paymentmode")) {
                                        d.a.a.c.a().d(e.this.f12691f);
                                    }
                                }
                            });
                        } else {
                            c cVar6 = this.f12687b;
                            if (cVar6 != null) {
                                cVar6.a(cJRValidateTransaction);
                            }
                        }
                    } else if (!status2.equalsIgnoreCase("PENDING")) {
                        q();
                        a(heading2, statusMessage3, (View.OnClickListener) new View.OnClickListener() {
                            public final void onClick(View view) {
                                e.this.f12692g.dismiss();
                                if (e.this.f12686a.getIntent().hasExtra("paymentmode")) {
                                    d.a.a.c.a().d(e.this.f12691f);
                                }
                            }
                        });
                    } else if (str.equalsIgnoreCase("OTP_1002") || str.equalsIgnoreCase("OTP_1004")) {
                        net.one97.paytm.p2b.view.b.b bVar3 = this.f12688c;
                        if (bVar3 != null && bVar3.isShowing()) {
                            this.f12688c.a(statusMessage3);
                            this.f12688c.a(true);
                        }
                    } else {
                        q();
                        if (!b(this.f12686a) || this.f12686a.isFinishing()) {
                            a(heading2, statusMessage3, (View.OnClickListener) new View.OnClickListener() {
                                public final void onClick(View view) {
                                    e.this.f12692g.dismiss();
                                    if (e.this.f12686a.getIntent().hasExtra("paymentmode")) {
                                        d.a.a.c.a().d(e.this.f12691f);
                                    }
                                }
                            });
                            c cVar7 = this.f12687b;
                            if (cVar7 != null) {
                                cVar7.a(cJRValidateTransaction);
                                return;
                            }
                            return;
                        }
                        c cVar8 = this.f12687b;
                        if (cVar8 != null) {
                            cVar8.a(cJRValidateTransaction);
                        }
                    }
                }
            } else if (iJRPaytmDataModel2 instanceof CJROrderSummary) {
                CJROrderSummary cJROrderSummary = (CJROrderSummary) iJRPaytmDataModel2;
                if (cJROrderSummary == null || cJROrderSummary.getPaymentStatus() == null) {
                    n();
                    return;
                }
                String paymentStatus = cJROrderSummary.getPaymentStatus();
                if (paymentStatus.equalsIgnoreCase("SUCCESS")) {
                    n();
                    d();
                } else if (paymentStatus.equalsIgnoreCase("FAILED")) {
                    n();
                    k();
                } else if (this.f12689d || this.f12686a == null) {
                    n();
                    p();
                } else {
                    com.paytm.utility.b.j();
                    new Handler().postDelayed(new Runnable() {
                        public final void run() {
                            com.paytm.utility.b.j();
                            e.this.o();
                        }
                    }, 5000);
                }
            }
        }
    }

    public final void a(NetworkCustomError networkCustomError) {
        Activity activity = this.f12686a;
        if (activity != null && !activity.isFinishing()) {
            n();
            i();
            if (networkCustomError != null) {
                try {
                    if (networkCustomError.getStatusCode() == 410 || networkCustomError.getStatusCode() == 401 || networkCustomError.getStatusCode() == 403) {
                        this.f12687b.a();
                    } else if (networkCustomError.getMessage() != null && !h.b().a((Context) this.f12686a, (Exception) networkCustomError).booleanValue()) {
                        if (networkCustomError.getMessage() == null || !networkCustomError.getMessage().equalsIgnoreCase("parsing_error")) {
                            com.paytm.utility.b.b((Context) this.f12686a, this.f12686a.getResources().getString(R.string.network_error_heading), this.f12686a.getResources().getString(R.string.network_error_message) + " " + networkCustomError.getUrl());
                            return;
                        }
                        Activity activity2 = this.f12686a;
                        String url = networkCustomError.getUrl();
                        StringBuilder sb = new StringBuilder();
                        sb.append(networkCustomError.getStatusCode());
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
            } else {
                com.paytm.utility.b.b((Context) this.f12686a, this.f12686a.getResources().getString(R.string.network_error_heading), this.f12686a.getResources().getString(R.string.network_error_message) + " " + networkCustomError.getUrl());
            }
        }
    }

    public final void a(String str) {
        Activity activity;
        if (!TextUtils.isEmpty(str) && (activity = this.f12686a) != null && !activity.isFinishing()) {
            Activity activity2 = this.f12686a;
            k.a(activity2, activity2.getString(R.string.p2b_error_title), str);
        }
    }

    public final void a() {
        c cVar = this.f12687b;
        if (cVar != null) {
            cVar.b();
        }
    }

    public final void b() {
        c cVar = this.f12687b;
        if (cVar != null) {
            cVar.c();
        }
    }

    /* access modifiers changed from: package-private */
    public final void b(NetworkCustomError networkCustomError) {
        Activity activity = this.f12686a;
        if (activity != null && !activity.isFinishing()) {
            n();
            i();
            if (networkCustomError != null) {
                int statusCode = networkCustomError.getStatusCode();
                if (statusCode == 401 || statusCode == 403 || statusCode == 410) {
                    this.f12687b.a();
                    return;
                }
                Activity activity2 = this.f12686a;
                Toast.makeText(activity2, activity2.getString(R.string.p2b_something_went_wrong_please_try), 0).show();
                return;
            }
            Activity activity3 = this.f12686a;
            Toast.makeText(activity3, activity3.getString(R.string.p2b_something_went_wrong_please_try), 0).show();
        }
    }

    private static boolean b(Activity activity) {
        return activity != null && (activity instanceof SendMoneyToBankActivity);
    }

    public static Dialog a(Activity activity) {
        if (activity != null) {
            try {
                Dialog dialog = new Dialog(activity);
                dialog.requestWindowFeature(1);
                dialog.setCancelable(false);
                dialog.setContentView(activity.getLayoutInflater().inflate(R.layout.p2b_lyt_progress_bar, (ViewGroup) null));
                return dialog;
            } catch (Exception e2) {
                if (com.paytm.utility.b.v) {
                    e2.printStackTrace();
                }
            }
        }
        return null;
    }
}
