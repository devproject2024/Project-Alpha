package net.one97.paytm.wallet.d;

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
import android.webkit.URLUtil;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.z;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.common.entity.CJRPGTokenList;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.shopping.CJROrderSummary;
import net.one97.paytm.common.entity.wallet.CJRCashWallet;
import net.one97.paytm.common.entity.wallet.CJRPostcardCreateEvent;
import net.one97.paytm.common.entity.wallet.postcard.data.CRJCreateLifafaReq;
import net.one97.paytm.network.h;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.communicator.b;
import net.one97.paytm.wallet.f.j;
import net.one97.paytm.wallet.newdesign.postcard.PostCardMainActivity;
import net.one97.paytm.wallet.newdesign.postcard.b.f;
import net.one97.paytm.wallet.utility.a;
import org.json.JSONObject;

public final class i implements b {

    /* renamed from: a  reason: collision with root package name */
    protected Activity f70240a;

    /* renamed from: b  reason: collision with root package name */
    protected j f70241b;

    /* renamed from: c  reason: collision with root package name */
    protected a f70242c;

    /* renamed from: d  reason: collision with root package name */
    boolean f70243d = false;

    /* renamed from: e  reason: collision with root package name */
    private String f70244e;

    /* renamed from: f  reason: collision with root package name */
    private String f70245f;

    /* renamed from: g  reason: collision with root package name */
    private String f70246g;

    /* renamed from: h  reason: collision with root package name */
    private String f70247h;

    /* renamed from: i  reason: collision with root package name */
    private ProgressDialog f70248i;
    private String j;
    private Dialog k;
    private String l;
    private boolean m;

    public final void a() {
    }

    public final void b() {
    }

    public final void a(Activity activity, j jVar) {
        this.f70240a = activity;
        this.f70241b = jVar;
        if (this.f70242c == null) {
            this.f70242c = b.b();
        }
        this.f70242c.onAttachToFragment(activity, this);
    }

    public final void a(NetworkCustomError networkCustomError) {
        Activity activity = this.f70240a;
        if (activity != null && !activity.isFinishing()) {
            i();
            h();
            if (networkCustomError != null) {
                try {
                    if (this.f70240a == null) {
                        return;
                    }
                    if ((!TextUtils.isEmpty(networkCustomError.getMessage()) && networkCustomError.getStatusCode() == 410) || networkCustomError.getStatusCode() == 401) {
                        b.a().handleError(this.f70240a, networkCustomError, (String) null, (Bundle) null, false);
                    } else if (networkCustomError.getMessage() == null || b.a().checkErrorCode(this.f70240a, networkCustomError)) {
                        a.a(this.f70240a, this.f70240a.getResources().getString(R.string.network_error_heading), this.f70240a.getResources().getString(R.string.network_error_message), new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                Fragment c2 = ((PostCardMainActivity) i.this.f70240a).getSupportFragmentManager().c(f.class.getSimpleName());
                                if ((c2 instanceof f) && c2.isVisible()) {
                                    ((PostCardMainActivity) i.this.f70240a).getSupportFragmentManager().d();
                                }
                            }
                        });
                    } else if (networkCustomError.getMessage() == null || !networkCustomError.getMessage().equalsIgnoreCase("parsing_error")) {
                        this.f70241b.b((IJRDataModel) null);
                    } else {
                        this.f70241b.b((IJRDataModel) null);
                    }
                } catch (Resources.NotFoundException e2) {
                    if (com.paytm.utility.b.v) {
                        q.d(String.valueOf(e2));
                    }
                } catch (Exception e3) {
                    if (com.paytm.utility.b.v) {
                        q.d(String.valueOf(e3));
                    }
                }
            }
        }
    }

    public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
        Activity activity = this.f70240a;
        if (activity != null && !activity.isFinishing()) {
            if (iJRPaytmDataModel instanceof CJRPGTokenList) {
                CJRPGTokenList cJRPGTokenList = (CJRPGTokenList) iJRPaytmDataModel;
                Activity activity2 = this.f70240a;
                if (activity2 != null && !activity2.isFinishing()) {
                    String pgToken = b.a().getPgToken(cJRPGTokenList);
                    if (!TextUtils.isEmpty(pgToken)) {
                        Activity activity3 = this.f70240a;
                        if (activity3 != null && !activity3.isFinishing()) {
                            try {
                                if (this.m) {
                                    Integer.parseInt(this.f70246g);
                                }
                                com.google.gson.f fVar = new com.google.gson.f();
                                if (this.f70240a != null && (this.f70240a instanceof PostCardMainActivity)) {
                                    String stringFromGTM = b.a().getStringFromGTM(this.f70240a, "lifafaCreateURL");
                                    if (URLUtil.isValidUrl(stringFromGTM)) {
                                        CRJCreateLifafaReq cRJCreateLifafaReq = new CRJCreateLifafaReq();
                                        cRJCreateLifafaReq.setName(this.f70247h);
                                        if (this.m) {
                                            cRJCreateLifafaReq.setStrategyType("RANDOM");
                                            cRJCreateLifafaReq.setDistributionType("BROADCAST");
                                            cRJCreateLifafaReq.setProposedReceiverCount(Integer.parseInt(this.f70246g));
                                        } else {
                                            cRJCreateLifafaReq.setStrategyType("UNIFORM");
                                            cRJCreateLifafaReq.setDistributionType("SINGLE");
                                            cRJCreateLifafaReq.setProposedReceiverCount(1);
                                            ArrayList arrayList = new ArrayList();
                                            arrayList.add(this.f70246g);
                                            cRJCreateLifafaReq.setRecipientList(arrayList);
                                        }
                                        cRJCreateLifafaReq.setProposedQuantity(new BigDecimal(this.f70244e));
                                        cRJCreateLifafaReq.setCreatorType(AppConstants.USER);
                                        cRJCreateLifafaReq.setThemeGuid(this.l);
                                        cRJCreateLifafaReq.setUnit("INR");
                                        cRJCreateLifafaReq.setCreatorId(com.paytm.utility.b.n((Context) this.f70240a));
                                        cRJCreateLifafaReq.setCategory("Wallet");
                                        cRJCreateLifafaReq.setRecipientListType("PHONENO");
                                        cRJCreateLifafaReq.setMinQuantity(BigDecimal.valueOf(1));
                                        cRJCreateLifafaReq.setMessage(this.f70245f);
                                        cRJCreateLifafaReq.setMerchantLogo(com.paytm.utility.b.al(this.f70240a));
                                        cRJCreateLifafaReq.setShowOtherRecipients(true);
                                        HashMap hashMap = new HashMap();
                                        new HashMap();
                                        hashMap.put("Content-Type", "application/json");
                                        hashMap.put("ssotoken", pgToken);
                                        if (com.paytm.utility.b.c((Context) this.f70240a)) {
                                            q.d("URL : " + stringFromGTM + "Body " + fVar.a((Object) cRJCreateLifafaReq, (Type) CRJCreateLifafaReq.class) + "Headers " + hashMap);
                                            new net.one97.paytm.network.b(stringFromGTM, new CJRPostcardCreateEvent(), (Map<String, String>) null, hashMap, fVar.a((Object) cRJCreateLifafaReq, (Type) CRJCreateLifafaReq.class)).c().observeForever(new z() {
                                                public final void onChanged(Object obj) {
                                                    i.this.c((net.one97.paytm.network.f) obj);
                                                }
                                            });
                                            return;
                                        }
                                        a.a(this.f70240a, this.f70240a.getResources().getString(R.string.network_error_heading), this.f70240a.getResources().getString(R.string.network_error_message), new DialogInterface.OnClickListener() {
                                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                                Fragment c2 = ((PostCardMainActivity) i.this.f70240a).getSupportFragmentManager().c(f.class.getSimpleName());
                                                if ((c2 instanceof f) && c2.isVisible()) {
                                                    ((PostCardMainActivity) i.this.f70240a).getSupportFragmentManager().d();
                                                }
                                            }
                                        });
                                    }
                                }
                            } catch (Exception e2) {
                                h();
                                Toast.makeText(this.f70240a, e2.getMessage(), 0);
                                if (com.paytm.utility.b.v) {
                                    q.d(String.valueOf(e2));
                                }
                            }
                        }
                    } else {
                        h();
                        b.a().showSessionTimeoutAlert(this.f70240a);
                    }
                }
            } else if (iJRPaytmDataModel instanceof CJRPostcardCreateEvent) {
                CJRPostcardCreateEvent cJRPostcardCreateEvent = (CJRPostcardCreateEvent) iJRPaytmDataModel;
                Activity activity4 = this.f70240a;
                if (activity4 != null && !activity4.isFinishing()) {
                    i();
                    h();
                    if (cJRPostcardCreateEvent == null) {
                        this.f70241b.b((IJRDataModel) null);
                    } else if (CJRPostcardCreateEvent.STATUS_SUCCESS.equals(cJRPostcardCreateEvent.getStatusCode())) {
                        this.f70241b.a(cJRPostcardCreateEvent);
                    } else {
                        this.f70241b.b(cJRPostcardCreateEvent);
                    }
                }
            } else if (iJRPaytmDataModel instanceof CJROrderSummary) {
                CJROrderSummary cJROrderSummary = (CJROrderSummary) iJRPaytmDataModel;
                if (cJROrderSummary == null || cJROrderSummary.getPaymentStatus() == null) {
                    i();
                    return;
                }
                String paymentStatus = cJROrderSummary.getPaymentStatus();
                if (paymentStatus.equalsIgnoreCase("SUCCESS")) {
                    i();
                    g();
                } else if (paymentStatus.equalsIgnoreCase("FAILED")) {
                    i();
                    d();
                } else if (this.f70243d || this.f70240a == null) {
                    i();
                    e();
                } else {
                    com.paytm.utility.b.j();
                    new Handler().postDelayed(new Runnable() {
                        public final void run() {
                            com.paytm.utility.b.j();
                            i.this.f();
                        }
                    }, 5000);
                }
            }
        }
    }

    public final void a(String str, String str2, String str3, String str4, String str5, boolean z) {
        Activity activity = this.f70240a;
        if (activity != null && !activity.isFinishing()) {
            this.f70244e = str3;
            this.f70245f = str4;
            if (TextUtils.isEmpty(str)) {
                str = str2;
            }
            this.f70247h = str;
            this.f70246g = str2;
            this.l = str5;
            this.m = z;
            try {
                String stringFromGTM = b.a().getStringFromGTM(this.f70240a, "check_user_balance_service");
                if (stringFromGTM == null) {
                    return;
                }
                if (URLUtil.isValidUrl(stringFromGTM)) {
                    String e2 = com.paytm.utility.b.e((Context) this.f70240a, stringFromGTM);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("request", new JSONObject());
                    HashMap hashMap = new HashMap();
                    hashMap.put("ssotoken", com.paytm.utility.a.q(this.f70240a));
                    hashMap.put("Accept-Encoding", "gzip");
                    new StringBuilder("SSO Token :: ").append(com.paytm.utility.a.q(this.f70240a));
                    com.paytm.utility.b.j();
                    if (com.paytm.utility.b.c((Context) this.f70240a)) {
                        new net.one97.paytm.network.b(e2, new CJRCashWallet(), (Map<String, String>) null, hashMap, jSONObject.toString()).c().observeForever(new z() {
                            public final void onChanged(Object obj) {
                                i.this.a((net.one97.paytm.network.f) obj);
                            }
                        });
                        return;
                    }
                    a.a(this.f70240a, this.f70240a.getResources().getString(R.string.network_error_heading), this.f70240a.getResources().getString(R.string.network_error_message), new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            Fragment c2 = ((PostCardMainActivity) i.this.f70240a).getSupportFragmentManager().c(f.class.getSimpleName());
                            if ((c2 instanceof f) && c2.isVisible()) {
                                ((PostCardMainActivity) i.this.f70240a).getSupportFragmentManager().d();
                            }
                        }
                    });
                }
            } catch (Exception e3) {
                q.d(String.valueOf(e3));
            }
        }
    }

    public final void b(String str) {
        if (!TextUtils.isEmpty(str)) {
            Activity activity = this.f70240a;
            if (activity != null && !activity.isFinishing()) {
                this.j = str;
                this.f70243d = false;
                new Handler().postDelayed(new Runnable() {
                    public final void run() {
                        i.this.f70243d = true;
                        com.paytm.utility.b.j();
                    }
                }, 120000);
                f();
                return;
            }
            return;
        }
        d();
    }

    private void d() {
        Activity activity = this.f70240a;
        if (activity != null && !activity.isFinishing()) {
            i();
            new AlertDialog.Builder(this.f70240a).setTitle(R.string.wallet_add_money_failure_title).setMessage(R.string.wallet_add_money_failure_message).setPositiveButton(R.string.wallet_add_money_failure_positive_button, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    dialogInterface.dismiss();
                    i.this.c();
                }
            }).setNegativeButton(R.string.wallet_add_money_failure_negative_button, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    dialogInterface.dismiss();
                }
            }).show();
        }
    }

    private void e() {
        Activity activity = this.f70240a;
        if (activity != null && !activity.isFinishing()) {
            i();
            new AlertDialog.Builder(this.f70240a).setTitle(R.string.wallet_add_money_delayed_title).setMessage(R.string.wallet_add_money_delayed_message).setPositiveButton(R.string.wallet_add_money_delayed_positive_button, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    dialogInterface.dismiss();
                }
            }).show();
        }
    }

    /* access modifiers changed from: private */
    public void f() {
        if (this.f70243d || this.f70240a == null) {
            i();
            e();
            return;
        }
        String str = b.a().getStringFromGTM(this.f70240a, "orderdetail") + this.j;
        new net.one97.paytm.network.a(com.paytm.utility.b.b((Context) this.f70240a, str) + "&actions=1", new CJROrderSummary(), (Map<String, String>) null, (Map<String, String>) null).c().observeForever(new z() {
            public final void onChanged(Object obj) {
                i.this.b((net.one97.paytm.network.f) obj);
            }
        });
    }

    /* access modifiers changed from: protected */
    public final void c() {
        if (!com.paytm.utility.b.c((Context) this.f70240a)) {
            String string = this.f70240a.getResources().getString(R.string.network_error_message);
            Activity activity = this.f70240a;
            a.a(activity, activity.getResources().getString(R.string.network_error_heading), string, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    Fragment c2 = ((PostCardMainActivity) i.this.f70240a).getSupportFragmentManager().c(f.class.getSimpleName());
                    if ((c2 instanceof f) && c2.isVisible()) {
                        ((PostCardMainActivity) i.this.f70240a).getSupportFragmentManager().d();
                    }
                }
            });
        } else if (this.f70242c != null) {
            this.f70242c.addMoneyForInsufficientBalanceError(a.a(a.a((Context) this.f70240a), this.f70244e), true, new StringBuilder("P2P_POSTCARD").toString());
        }
    }

    private void g() {
        Activity activity = this.f70240a;
        if (activity != null && !activity.isFinishing()) {
            if (com.paytm.utility.b.c((Context) this.f70240a)) {
                String q = com.paytm.utility.a.q(this.f70240a);
                if (!TextUtils.isEmpty(q)) {
                    b.a().getWalletToken(q, this.f70240a, new com.paytm.network.listener.b() {
                        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                            i.this.a(iJRPaytmDataModel);
                        }

                        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                            i.this.a(networkCustomError);
                        }
                    });
                } else {
                    b.a().showSessionTimeoutAlert(this.f70240a);
                }
            } else {
                String string = this.f70240a.getResources().getString(R.string.network_error_message);
                Activity activity2 = this.f70240a;
                a.a(activity2, activity2.getResources().getString(R.string.network_error_heading), string, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        Fragment c2 = ((PostCardMainActivity) i.this.f70240a).getSupportFragmentManager().c(f.class.getSimpleName());
                        if ((c2 instanceof f) && c2.isVisible()) {
                            ((PostCardMainActivity) i.this.f70240a).getSupportFragmentManager().d();
                        }
                    }
                });
            }
        }
    }

    public final void a(String str) {
        Activity activity;
        if (!TextUtils.isEmpty(str) && (activity = this.f70240a) != null && !activity.isFinishing()) {
            Activity activity2 = this.f70240a;
            a.a(activity2, activity2.getString(R.string.error), str);
        }
    }

    private void h() {
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

    private void i() {
        try {
            if (this.f70248i != null && this.f70248i.isShowing()) {
                this.f70248i.dismiss();
            }
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.d(String.valueOf(e2));
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(net.one97.paytm.network.f fVar) {
        if (fVar.f55796a == h.SUCCESS) {
            h();
            CJRCashWallet cJRCashWallet = (CJRCashWallet) fVar.f55797b;
            if (cJRCashWallet.getResponse() != null) {
                double paytmWalletBalance = cJRCashWallet.getResponse().getPaytmWalletBalance();
                String b2 = com.paytm.utility.b.b(Double.valueOf(paytmWalletBalance));
                a.a((Context) this.f70240a, paytmWalletBalance);
                if (TextUtils.isEmpty(b2)) {
                    g();
                } else if (Double.parseDouble(this.f70244e) > paytmWalletBalance) {
                    this.f70240a.getResources().getString(R.string.insufficient_balance_error_title);
                    this.f70240a.getResources().getString(R.string.insufficient_balance_error_message);
                    Activity activity = this.f70240a;
                    if (activity != null && !activity.isFinishing()) {
                        c();
                    }
                    if (this.f70241b == null) {
                    }
                } else {
                    g();
                }
            }
        } else if (fVar.f55796a == h.ERROR) {
            a(fVar.f55798c.f55801c);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(net.one97.paytm.network.f fVar) {
        if (fVar.f55796a == h.SUCCESS) {
            a(fVar.f55797b);
        } else if (fVar.f55796a == h.ERROR) {
            a(fVar.f55798c.f55801c);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(net.one97.paytm.network.f fVar) {
        if (fVar.f55796a == h.SUCCESS) {
            a(fVar.f55797b);
        } else if (fVar.f55796a == h.ERROR) {
            a(fVar.f55798c.f55801c);
        }
    }
}
