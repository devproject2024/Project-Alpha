package com.travel.train.activity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.SslErrorHandler;
import android.webkit.URLUtil;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.ProgressBar;
import androidx.fragment.app.Fragment;
import com.alipay.mobile.h5container.api.H5Param;
import com.business.merchant_payments.common.utility.AppConstants;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import com.paytm.utility.s;
import com.travel.train.CJRTrainBaseActivity;
import com.travel.train.R;
import com.travel.train.d.c;
import com.travel.train.d.d;
import com.travel.train.fragment.ao;
import com.travel.train.helper.CJRSmsReceiver;
import com.travel.train.i.j;
import com.travel.train.j.g;
import com.travel.train.j.n;
import com.travel.train.j.o;
import com.travel.train.j.w;
import com.travel.train.model.trainticket.CJRCancelRequest;
import com.travel.train.model.trainticket.CJRIRCTCRedirect;
import com.travel.train.model.trainticket.CJRTrainForgotPassword;
import com.travel.train.model.trainticket.CJRTrainTrackingInfo;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.nativesdk.transcation.viewmodel.DirectFormItemType;
import net.one97.paytm.upi.util.UpiConstants;

public class AJRTrainLoginActivity extends CJRTrainBaseActivity implements com.paytm.network.listener.b, j {

    /* renamed from: a  reason: collision with root package name */
    public boolean f25997a = false;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public WebView f25998b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public ProgressDialog f25999c;

    /* renamed from: d  reason: collision with root package name */
    private String f26000d;

    /* renamed from: e  reason: collision with root package name */
    private String f26001e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public CJRIRCTCRedirect f26002f;

    /* renamed from: g  reason: collision with root package name */
    private String f26003g;

    /* renamed from: h  reason: collision with root package name */
    private String f26004h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public int f26005i = 0;
    /* access modifiers changed from: private */
    public boolean j = false;
    private com.travel.train.d.b k;
    /* access modifiers changed from: private */
    public AlertDialog l;
    private b m = b.AutoTryWithEnteredNumber;
    private CJRSmsReceiver n;
    private AlertDialog o;
    /* access modifiers changed from: private */
    public boolean p = false;
    /* access modifiers changed from: private */
    public boolean q = false;
    /* access modifiers changed from: private */
    public String r = "AJRTrainLoginActivity";
    private BroadcastReceiver s = new BroadcastReceiver() {
        public final void onReceive(Context context, Intent intent) {
            AJRTrainLoginActivity.a(AJRTrainLoginActivity.this);
        }
    };
    /* access modifiers changed from: private */
    public Fragment t;

    public enum b {
        AutoTryWithEnteredNumber,
        AutoTryWithPaytmNumber,
        AutoTryWithEmailId,
        NoAutoTry
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.pre_t_train_login);
        com.travel.train.b.a();
        this.f25997a = com.travel.train.b.b().l();
        this.k = new com.travel.train.d.b(this.f25997a);
        Bundle bundle2 = new Bundle();
        com.travel.train.b.a();
        bundle2.putBoolean("enable-travel-helper", com.travel.train.b.b().o());
        this.k.setArguments(bundle2);
        getSupportFragmentManager().a().b(R.id.easypayBrowserFragment, this.k, (String) null).b();
    }

    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        com.travel.train.d.b bVar = this.k;
        bVar.f26601f.putString("merchant_mid", "");
        bVar.f26601f.apply();
        this.f25998b = bVar.f26596a;
        this.f25998b.setWebChromeClient(new WebChromeClient());
        this.f25998b.setWebViewClient(new a(this.k));
        this.f25998b.getSettings().setBuiltInZoomControls(true);
        this.f25998b.getSettings().setJavaScriptEnabled(true);
        this.f25998b.getSettings().setDomStorageEnabled(true);
        this.f25998b.requestFocus(130);
        this.f25998b.setScrollBarStyle(33554432);
        this.f25998b.getSettings().setUseWideViewPort(true);
        this.f25998b.getSettings().setLoadWithOverviewMode(true);
        if (Build.VERSION.SDK_INT >= 21) {
            this.f25998b.getSettings().setMixedContentMode(0);
        }
        this.l = new AlertDialog.Builder(this).create();
        this.f26003g = com.paytm.utility.b.W((Context) this);
        this.f26002f = (CJRIRCTCRedirect) getIntent().getSerializableExtra("irctc_redirect");
        this.f26001e = getIntent().getStringExtra(UpiConstants.EXTRA_UPI_PENDING_REQUEST_TRANSACTION_ID);
        this.f26004h = getIntent().getStringExtra("order_id");
        this.f26000d = "<html>\n<body>\n<form action=\"" + this.f26002f.getMurl() + "\"\nmethod=\"post\">\n<input type=\"hidden\" name=\"wsloginId\" value=\"" + this.f26003g + "\"\n/>\n<input type=\"hidden\" name=\"wsTxnId\" value=\"" + this.f26002f.getMwsTxnId() + "\" />\n<input type=\"hidden\" name=\"wsReturnUrl\" value=\"" + this.f26002f.getMwsReturnUrl() + "\" />\n</form>\n</body>\n<script type=\"text/javascript\">\ndocument.forms[0].submit()\n</script>\n</html>\n";
        this.f25999c = ProgressDialog.show(this, getResources().getString(R.string.please_wait_progress_msg), getResources().getString(R.string.train_IRCRC_Redirect));
        this.f25999c.hide();
        androidx.localbroadcastmanager.a.a.a(getApplicationContext()).a(this.s, new IntentFilter("reset-password-action"));
        this.f25998b.loadData(this.f26000d, "text/html; charset=UTF-8", (String) null);
    }

    private boolean b() {
        this.m = b.AutoTryWithPaytmNumber;
        String l2 = com.paytm.utility.b.l(getApplicationContext());
        if (TextUtils.isEmpty(l2)) {
            c();
            return false;
        }
        a(l2, true);
        return false;
    }

    private void c() {
        this.m = b.NoAutoTry;
        if (this.t == null) {
            this.t = new ao();
            Bundle bundle = new Bundle();
            bundle.putBoolean("dismiss-dialog", true);
            this.t.setArguments(bundle);
            d();
            return;
        }
        g();
    }

    private void d() {
        if (!isFinishing()) {
            if (this.f25997a) {
                f();
            }
            getSupportFragmentManager().b();
            getSupportFragmentManager().a().a(R.id.easypayBrowserFragment, this.t).a((String) null).b();
        }
    }

    private void a(String str, String str2, String str3, boolean z) {
        String str4;
        if (TextUtils.isEmpty(str3)) {
            a(getResources().getString(R.string.error), getResources().getString(R.string.irctc_userid_incorrect), getResources().getString(R.string.ok));
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            StringBuilder sb = new StringBuilder();
            com.travel.train.b.a();
            sb.append(com.travel.train.b.b().r());
            sb.append("email=");
            sb.append(str);
            sb.append("&userLoginId=");
            sb.append(str3);
            sb.append("&otpType=E");
            str4 = sb.toString();
        } else if (!TextUtils.isEmpty(str2)) {
            StringBuilder sb2 = new StringBuilder();
            com.travel.train.b.a();
            sb2.append(com.travel.train.b.b().r());
            sb2.append("mobile=");
            sb2.append(str2);
            sb2.append("&userLoginId=");
            sb2.append(str3);
            sb2.append("&otpType=M");
            str4 = sb2.toString();
        } else {
            str4 = null;
        }
        String b2 = o.b(getApplicationContext(), str4);
        if (URLUtil.isValidUrl(b2)) {
            b2 = com.paytm.utility.b.s(getApplicationContext(), b2);
        }
        if (com.paytm.utility.b.c(getApplicationContext())) {
            com.paytm.network.b bVar = new com.paytm.network.b();
            bVar.f42877a = this;
            bVar.f42878b = a.c.TRAIN;
            bVar.n = a.b.SILENT;
            bVar.o = g.r;
            bVar.f42879c = a.C0715a.GET;
            bVar.f42880d = b2;
            bVar.f42882f = n.b((Context) this);
            bVar.f42885i = new CJRTrainForgotPassword();
            bVar.j = this;
            com.paytm.network.a l2 = bVar.l();
            l2.f42859c = false;
            l2.a();
            Fragment fragment = this.t;
            if (fragment == null) {
                this.t = new ao();
                if (!TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("train-number", str2);
                    bundle.putString("train-email", str);
                    bundle.putBoolean("dismiss-dialog", z);
                    this.t.setArguments(bundle);
                }
                d();
            } else if (!z) {
                ((ao) fragment).a(str2, false);
            }
        } else {
            com.paytm.network.b bVar2 = new com.paytm.network.b();
            bVar2.f42877a = this;
            bVar2.f42878b = a.c.TRAIN;
            bVar2.n = a.b.SILENT;
            bVar2.o = g.r;
            bVar2.f42879c = a.C0715a.GET;
            bVar2.f42880d = b2;
            bVar2.f42882f = n.b((Context) this);
            bVar2.f42885i = new CJRTrainForgotPassword();
            bVar2.j = this;
            com.paytm.network.a l3 = bVar2.l();
            l3.f42859c = false;
            showNetworkDialog(l3, getResources().getString(R.string.no_connection), getResources().getString(R.string.no_internet));
        }
    }

    private void a(String str, String str2, final String str3) {
        if (!isFinishing()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(str);
            builder.setMessage(str2);
            builder.setPositiveButton(str3, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    EditText editText;
                    dialogInterface.cancel();
                    dialogInterface.dismiss();
                    if (Build.VERSION.SDK_INT < 17) {
                        return;
                    }
                    if (str3.equalsIgnoreCase(AJRTrainLoginActivity.this.getString(R.string.ok)) && !AJRTrainLoginActivity.this.isFinishing() && !AJRTrainLoginActivity.this.isDestroyed() && AJRTrainLoginActivity.this.t != null) {
                        ao aoVar = (ao) AJRTrainLoginActivity.this.t;
                        if (!aoVar.isDetached() && aoVar.f26910a != null && (editText = (EditText) aoVar.f26910a.findViewById(R.id.train_assist_reset_password_edittext)) != null) {
                            editText.setText("");
                        }
                    } else if (str3.equalsIgnoreCase(AJRTrainLoginActivity.this.getString(R.string.continue_text)) && AJRTrainLoginActivity.this.t != null) {
                        AJRTrainLoginActivity.this.a();
                    }
                }
            });
            builder.create().show();
        }
    }

    public final boolean a() {
        if (getSupportFragmentManager().f() > 0) {
            getSupportFragmentManager().d();
            this.t = null;
            getSupportFragmentManager().b();
            return true;
        }
        this.t = null;
        return false;
    }

    public final void a(String str, boolean z) {
        String str2;
        a();
        if (!TextUtils.isEmpty(str)) {
            if (TextUtils.isDigitsOnly(str)) {
                str2 = str;
                str = "";
            } else {
                str2 = "";
            }
            a(str, str2, w.a(getApplicationContext()).b("registered_user_id", "", false), z);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.s != null) {
            androidx.localbroadcastmanager.a.a.a(getApplicationContext()).a(this.s);
        }
        h();
    }

    /* access modifiers changed from: private */
    public void e() {
        Intent a2 = o.a(getApplicationContext());
        a2.putExtra(UpiConstants.FROM, "Payment");
        a2.putExtra("order_id", this.f26004h);
        a2.putExtra(AppConstants.IS_CANCEL, false);
        startActivity(a2);
        finish();
    }

    public void onBackPressed() {
        a("train_irctc_back_clicked", Boolean.FALSE, "");
        if (!this.f25997a) {
            try {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Cancel Transaction");
                builder.setMessage(getResources().getString(R.string.train_cancel_transaction_message));
                builder.setPositiveButton(getResources().getString(R.string.yes), new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        dialogInterface.dismiss();
                        AJRTrainLoginActivity.this.e();
                    }
                });
                builder.setNegativeButton(getResources().getString(R.string.no), new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        dialogInterface.dismiss();
                    }
                });
                builder.setCancelable(false);
                builder.show();
            } catch (Exception e2) {
                q.c(e2.getMessage());
            }
        } else if (!a()) {
            a("");
        }
        this.t = null;
    }

    /* access modifiers changed from: private */
    public void a(final String str) {
        try {
            final Dialog dialog = new Dialog(this);
            dialog.requestWindowFeature(1);
            dialog.setCanceledOnTouchOutside(false);
            View inflate = getLayoutInflater().inflate(R.layout.pre_t_train_cancel_transaction_dialog, (ViewGroup) null);
            dialog.setContentView(inflate);
            inflate.findViewById(R.id.close_dialog).setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    dialog.dismiss();
                    AJRTrainLoginActivity.this.f();
                }
            });
            inflate.findViewById(R.id.proceed_with_cancellation).setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    if (TextUtils.isEmpty(str) || AJRTrainLoginActivity.this.f25998b == null) {
                        dialog.dismiss();
                        AJRTrainLoginActivity.this.e();
                        return;
                    }
                    AJRTrainLoginActivity.this.f25998b.loadUrl(str);
                    dialog.dismiss();
                }
            });
            inflate.findViewById(R.id.reset_pwd).setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    dialog.dismiss();
                    androidx.localbroadcastmanager.a.a a2 = androidx.localbroadcastmanager.a.a.a((Context) AJRTrainLoginActivity.this);
                    Intent intent = new Intent();
                    intent.setAction("reset-password-action");
                    a2.a(intent);
                }
            });
            dialog.show();
            Window window = dialog.getWindow();
            window.setLayout(-1, -2);
            window.setGravity(80);
            window.setBackgroundDrawable(new ColorDrawable(0));
        } catch (Exception e2) {
            q.c(e2.getMessage());
        }
    }

    /* access modifiers changed from: private */
    public void f() {
        com.travel.train.d.b bVar = this.k;
        if (bVar != null) {
            bVar.d();
        }
        this.q = false;
        this.p = false;
        this.f25998b.loadUrl("javascript:document.getElementById('loginbutton').disabled = false");
        this.f25998b.loadUrl("javascript:document.getElementById('loginbuttonw').disabled = false");
        this.f25998b.loadUrl("javascript:document.getElementById('loginCancel').disabled = false");
        this.f25998b.loadUrl("javascript:document.getElementById('loginForget').disabled = false");
        this.f25998b.loadUrl("javascript:document:enableForm()");
    }

    public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        if (!isFinishing()) {
            if (iJRPaytmDataModel instanceof CJRCancelRequest) {
                if (this.f25999c.isShowing()) {
                    this.f25999c.dismiss();
                }
                CJRCancelRequest cJRCancelRequest = (CJRCancelRequest) iJRPaytmDataModel;
                if (cJRCancelRequest.getmStatus() != null && cJRCancelRequest.getmStatus().getmResult().equalsIgnoreCase("success")) {
                    e();
                }
            } else if (!(iJRPaytmDataModel instanceof CJRTrainTrackingInfo) && (iJRPaytmDataModel instanceof CJRTrainForgotPassword)) {
                CJRTrainForgotPassword cJRTrainForgotPassword = (CJRTrainForgotPassword) iJRPaytmDataModel;
                if (cJRTrainForgotPassword.getForgotPasswordStatus() != null && cJRTrainForgotPassword.getForgotPasswordStatus().f27714a != null && cJRTrainForgotPassword.getForgotPasswordStatus().f27714a.equalsIgnoreCase("success")) {
                    String str = cJRTrainForgotPassword.getPasswordBody().f27713a;
                    g();
                    if (this.m == b.NoAutoTry) {
                        a((String) null, str, getString(R.string.continue_text));
                        return;
                    }
                    try {
                        if (!isFinishing()) {
                            if (this.m != b.AutoTryWithEmailId) {
                                if (!s.a() || s.d((Context) this)) {
                                    if (this.n == null) {
                                        this.n = new CJRSmsReceiver();
                                        this.n.f27253a = this;
                                        IntentFilter intentFilter = new IntentFilter();
                                        intentFilter.addAction("android.provider.Telephony.SMS_RECEIVED");
                                        intentFilter.setPriority(1000);
                                        registerReceiver(this.n, intentFilter);
                                        StringBuilder sb = new StringBuilder();
                                        sb.append(getClass().getSimpleName());
                                        sb.append(" : register");
                                        com.paytm.utility.b.j();
                                    }
                                }
                            }
                        }
                    } catch (Exception e2) {
                        if (com.paytm.utility.b.v) {
                            q.c(e2.getMessage());
                        }
                    }
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setTitle((CharSequence) null);
                    builder.setMessage(str);
                    builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            dialogInterface.cancel();
                            dialogInterface.dismiss();
                            if (!AJRTrainLoginActivity.this.isFinishing()) {
                                AJRTrainLoginActivity.this.a();
                            }
                        }
                    });
                    this.o = builder.create();
                    this.o.show();
                    return;
                }
                return;
            }
            this.k.a();
        }
    }

    public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        if (!isFinishing()) {
            if (this.f25999c.isShowing()) {
                this.f25999c.dismiss();
            }
            int i3 = AnonymousClass9.f26019a[this.m.ordinal()];
            if (i3 == 1) {
                b();
            } else if (i3 == 2) {
                this.m = b.AutoTryWithEmailId;
                String b2 = w.a(getApplicationContext()).b("registered_irctc_email_id", "", false);
                if (!TextUtils.isEmpty(b2)) {
                    a(b2, true);
                } else {
                    c();
                }
            } else if (i3 != 3) {
                if (i3 == 4) {
                    g();
                }
                a(networkCustomError.getAlertTitle(), networkCustomError.getAlertMessage(), getResources().getString(R.string.continue_text));
            } else {
                c();
            }
        }
    }

    /* renamed from: com.travel.train.activity.AJRTrainLoginActivity$9  reason: invalid class name */
    static /* synthetic */ class AnonymousClass9 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f26019a = new int[b.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            /*
                com.travel.train.activity.AJRTrainLoginActivity$b[] r0 = com.travel.train.activity.AJRTrainLoginActivity.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f26019a = r0
                int[] r0 = f26019a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.travel.train.activity.AJRTrainLoginActivity$b r1 = com.travel.train.activity.AJRTrainLoginActivity.b.AutoTryWithEnteredNumber     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f26019a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.travel.train.activity.AJRTrainLoginActivity$b r1 = com.travel.train.activity.AJRTrainLoginActivity.b.AutoTryWithPaytmNumber     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f26019a     // Catch:{ NoSuchFieldError -> 0x002a }
                com.travel.train.activity.AJRTrainLoginActivity$b r1 = com.travel.train.activity.AJRTrainLoginActivity.b.AutoTryWithEmailId     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = f26019a     // Catch:{ NoSuchFieldError -> 0x0035 }
                com.travel.train.activity.AJRTrainLoginActivity$b r1 = com.travel.train.activity.AJRTrainLoginActivity.b.NoAutoTry     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.travel.train.activity.AJRTrainLoginActivity.AnonymousClass9.<clinit>():void");
        }
    }

    private void g() {
        Fragment fragment = this.t;
        if (fragment != null) {
            ((ao) fragment).a();
        }
    }

    private void h() {
        try {
            if (this.n != null) {
                unregisterReceiver(this.n);
                this.n.f27253a = null;
                this.n = null;
                StringBuilder sb = new StringBuilder();
                sb.append(getClass().getSimpleName());
                sb.append(" : unregister");
                com.paytm.utility.b.j();
            }
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.c(e2.getMessage());
            }
        }
    }

    public final void a(String str, String str2) {
        com.travel.train.d.b bVar;
        if (!isFinishing()) {
            String h2 = com.paytm.utility.b.h(str, str2);
            if (!TextUtils.isEmpty(h2) && (bVar = this.k) != null) {
                if (bVar.p != null && !TextUtils.isEmpty(h2)) {
                    d dVar = bVar.p;
                    String str3 = dVar.f26628d.get("fields");
                    dVar.f26626b.loadUrl("javascript:" + dVar.f26628d.get("functionStart") + str3 + (str3 + "var a=fields; for(var i=0;i<a.length;i++){if(a[i].type=='password'){a[i].blur();a[i].value=\"" + h2 + "\"}}") + dVar.f26628d.get("functionEnd"));
                    dVar.f26627c.a(R.id.leftTravelHelperView, h2);
                }
                a();
                h();
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(String str, Boolean bool, String str2) {
        try {
            String n2 = com.paytm.utility.b.n((Context) this);
            HashMap hashMap = new HashMap();
            if (bool.booleanValue()) {
                hashMap.put("train_irctc_button", str2);
            }
            if (n2 == null) {
                n2 = "";
            }
            hashMap.put("train_user_id", n2);
            hashMap.put("trains_order_id", this.f26004h);
            com.travel.train.b.a();
            com.travel.train.b.b().a(str, (Map<String, Object>) hashMap, (Context) this);
        } catch (Exception e2) {
            q.c(e2.getMessage());
        }
    }

    class a extends c {
        public a(com.travel.train.d.b bVar) {
            super(bVar);
        }

        public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            try {
                if (!AJRTrainLoginActivity.this.isFinishing()) {
                    if (AJRTrainLoginActivity.this.f25997a && str.equalsIgnoreCase(AJRTrainLoginActivity.this.f26002f.getMurl())) {
                        boolean unused = AJRTrainLoginActivity.this.p = false;
                        boolean unused2 = AJRTrainLoginActivity.this.q = false;
                    }
                    ProgressBar progressBar = (ProgressBar) AJRTrainLoginActivity.this.findViewById(R.id.login_load_indicator);
                    if (progressBar != null) {
                        progressBar.setVisibility(0);
                    }
                    com.paytm.utility.b.j();
                    "--------------onPageStarted-----1----------".concat(String.valueOf(str));
                    com.paytm.utility.b.j();
                    if (str != null) {
                        if (!str.contains("<html>") && str.toLowerCase().contains("cancelbutton=y")) {
                            AJRTrainLoginActivity.this.a("train_irctc_button_clicked", Boolean.TRUE, DirectFormItemType.CANCEL);
                        }
                    }
                    if (str != null && !str.contains("<html>") && (str.toLowerCase().contains("irctc/notification") || str.toLowerCase().contains("irctc/notification?cancelbutton=y"))) {
                        AJRTrainLoginActivity.this.e();
                    }
                    super.onPageStarted(webView, str, bitmap);
                }
            } catch (Exception e2) {
                String unused3 = AJRTrainLoginActivity.this.r;
                q.c(e2.getMessage());
            }
        }

        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            try {
                if (AJRTrainLoginActivity.this.isFinishing()) {
                    return true;
                }
                if (AJRTrainLoginActivity.this.f25997a && str.contains("CancelButton=F") && !AJRTrainLoginActivity.this.q) {
                    AJRTrainLoginActivity.a(AJRTrainLoginActivity.this);
                    boolean unused = AJRTrainLoginActivity.this.q = true;
                    return true;
                } else if (!AJRTrainLoginActivity.this.f25997a || !str.contains("CancelButton=Y") || AJRTrainLoginActivity.this.p) {
                    return false;
                } else {
                    AJRTrainLoginActivity.this.a(str);
                    boolean unused2 = AJRTrainLoginActivity.this.p = true;
                    return true;
                }
            } catch (Exception e2) {
                if (!com.paytm.utility.b.v) {
                    return false;
                }
                String unused3 = AJRTrainLoginActivity.this.r;
                q.c(e2.getMessage());
                return false;
            }
        }

        public final void onPageFinished(WebView webView, String str) {
            if (!AJRTrainLoginActivity.this.isFinishing()) {
                ProgressBar progressBar = (ProgressBar) AJRTrainLoginActivity.this.findViewById(R.id.login_load_indicator);
                if (progressBar != null) {
                    progressBar.setVisibility(8);
                }
                if (!AJRTrainLoginActivity.this.j) {
                    boolean unused = AJRTrainLoginActivity.this.j = true;
                    AJRTrainLoginActivity.a(AJRTrainLoginActivity.this, "", "SUCCESS");
                }
                q.a("Finished loading URL: ".concat(String.valueOf(str)));
                if (AJRTrainLoginActivity.this.f25999c.isShowing()) {
                    AJRTrainLoginActivity.this.f25999c.dismiss();
                }
                super.onPageFinished(webView, str);
            }
        }

        public final void onReceivedError(WebView webView, int i2, String str, String str2) {
            AJRTrainLoginActivity aJRTrainLoginActivity = AJRTrainLoginActivity.this;
            if (aJRTrainLoginActivity != null && !aJRTrainLoginActivity.isFinishing()) {
                q.b("Error: ".concat(String.valueOf(str)));
                boolean unused = AJRTrainLoginActivity.this.j = false;
                AJRTrainLoginActivity.a(AJRTrainLoginActivity.this, str, com.paytm.business.merchantprofile.common.utility.AppConstants.TRANSACTION_STATUS_ERROR);
                AJRTrainLoginActivity.this.f25998b.loadUrl(H5Param.ABOUT_BLANK);
                AJRTrainLoginActivity.this.l.setTitle("Error");
                AJRTrainLoginActivity.this.l.setMessage(str);
                AJRTrainLoginActivity.this.l.setButton("Retry", new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        if (AJRTrainLoginActivity.this.f26005i < 2) {
                            int unused = AJRTrainLoginActivity.this.f26005i = AJRTrainLoginActivity.this.f26005i + 1;
                            AJRTrainLoginActivity.n(AJRTrainLoginActivity.this);
                            return;
                        }
                        AJRTrainLoginActivity.this.e();
                    }
                });
                AJRTrainLoginActivity.this.l.show();
            }
        }

        public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            if (sslErrorHandler != null) {
                sslErrorHandler.cancel();
            }
            AJRTrainLoginActivity.this.finish();
        }
    }

    static /* synthetic */ void a(AJRTrainLoginActivity aJRTrainLoginActivity) {
        if (aJRTrainLoginActivity.m == b.AutoTryWithEnteredNumber) {
            com.travel.train.b.a();
            if (com.travel.train.b.b().n()) {
                aJRTrainLoginActivity.m = b.AutoTryWithEnteredNumber;
                String l2 = com.paytm.utility.b.l(aJRTrainLoginActivity.getApplicationContext());
                String b2 = w.a(aJRTrainLoginActivity.getApplicationContext()).b("registered_irctc_mobile_number", "", false);
                if (TextUtils.isEmpty(l2)) {
                    return;
                }
                if (!TextUtils.isEmpty(b2) && l2.equals(b2)) {
                    aJRTrainLoginActivity.b();
                    return;
                } else if (!TextUtils.isEmpty(b2)) {
                    aJRTrainLoginActivity.a(b2, true);
                    return;
                } else {
                    aJRTrainLoginActivity.b();
                    return;
                }
            }
        }
        aJRTrainLoginActivity.c();
    }

    static /* synthetic */ void a(AJRTrainLoginActivity aJRTrainLoginActivity, String str, String str2) {
        if (com.paytm.utility.b.c((Context) aJRTrainLoginActivity)) {
            com.travel.train.b.a();
            String q2 = com.travel.train.b.b().q();
            if (!TextUtils.isEmpty(q2)) {
                String str3 = q2 + "transaction_id=" + aJRTrainLoginActivity.f26001e + "&type=irctc_redirect&status=" + str2;
                if (!TextUtils.isEmpty(str)) {
                    str3 = str3 + "&info=" + str;
                }
                com.paytm.utility.b.j();
                String b2 = o.b((Context) aJRTrainLoginActivity, com.paytm.utility.b.s(aJRTrainLoginActivity, str3));
                com.paytm.network.b bVar = new com.paytm.network.b();
                bVar.f42877a = aJRTrainLoginActivity;
                bVar.f42878b = a.c.TRAIN;
                bVar.n = a.b.SILENT;
                bVar.o = g.r;
                bVar.f42879c = a.C0715a.GET;
                bVar.f42880d = b2;
                bVar.f42882f = n.b((Context) aJRTrainLoginActivity);
                bVar.f42885i = new CJRTrainTrackingInfo();
                bVar.j = aJRTrainLoginActivity;
                com.paytm.network.a l2 = bVar.l();
                l2.f42859c = false;
                l2.a();
            }
        }
    }

    static /* synthetic */ void n(AJRTrainLoginActivity aJRTrainLoginActivity) {
        WebView webView = aJRTrainLoginActivity.f25998b;
        if (webView != null) {
            webView.clearHistory();
            aJRTrainLoginActivity.f25998b.clearView();
            aJRTrainLoginActivity.f25998b.loadData(aJRTrainLoginActivity.f26000d, "text/html; charset=UTF-8", (String) null);
        }
    }
}
