package net.one97.paytm.paymentsBank.chequebook.signatureupdate.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.appsflyer.internal.referrer.Payload;
import com.squareup.picasso.s;
import com.squareup.picasso.w;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.chequebook.model.CBGetSignatureResponse;
import net.one97.paytm.paymentsBank.chequebook.signaturelanding.a.b;
import net.one97.paytm.paymentsBank.chequebook.signaturelanding.view.SignatureLandingActivityV2;
import net.one97.paytm.paymentsBank.chequebook.trackingflow.view.CBTLandingView;
import net.one97.paytm.paymentsBank.chequebook.utils.ChequeBookBaseActivity;
import net.one97.paytm.paymentsBank.chequebook.utils.h;
import net.one97.paytm.paymentsBank.passcode.BankPasscodeActivity;
import net.one97.paytm.paymentsBank.widget.croptool.CropImage;
import net.one97.paytm.paymentsBank.widget.croptool.PBCropImageView;

public final class SignatureReUploadActivityV2 extends ChequeBookBaseActivity implements b.C0286b {

    /* renamed from: d  reason: collision with root package name */
    public static final a f17874d = new a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    long f17875a;

    /* renamed from: b  reason: collision with root package name */
    public b.a f17876b;

    /* renamed from: c  reason: collision with root package name */
    public Uri f17877c;

    /* renamed from: e  reason: collision with root package name */
    private final String f17878e = "SRUA";

    /* renamed from: f  reason: collision with root package name */
    private String f17879f;

    /* renamed from: g  reason: collision with root package name */
    private String f17880g;

    /* renamed from: h  reason: collision with root package name */
    private String f17881h;

    /* renamed from: i  reason: collision with root package name */
    private String f17882i;
    /* access modifiers changed from: private */
    public boolean j;
    /* access modifiers changed from: private */
    public boolean k;
    private String l = "";
    /* access modifiers changed from: private */
    public String m = "";
    private boolean n;
    private String o;
    private h p;
    private String q;
    private boolean r;
    private HashMap s;

    public final View a(int i2) {
        if (this.s == null) {
            this.s = new HashMap();
        }
        View view = (View) this.s.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.s.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void d() {
        this.j = false;
    }

    public final void c() {
        startActivity(new Intent(this, CBTLandingView.class));
        finish();
    }

    public final void b() {
        if (this.n) {
            f().d();
        } else {
            a(false);
        }
    }

    public final void d(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            Uri parse = Uri.parse(str);
            k.a((Object) parse, "Uri.parse(url)");
            a(parse);
        }
    }

    public final void a(CBGetSignatureResponse cBGetSignatureResponse) {
        k.c(cBGetSignatureResponse, Payload.RESPONSE);
        if (cBGetSignatureResponse.getPayload() != null) {
            List<CBGetSignatureResponse.Payload> payload = cBGetSignatureResponse.getPayload();
            Integer valueOf = payload != null ? Integer.valueOf(payload.size()) : null;
            if (valueOf == null) {
                k.a();
            }
            if (valueOf.intValue() > 0) {
                List<CBGetSignatureResponse.Payload> payload2 = cBGetSignatureResponse.getPayload();
                if (payload2 == null) {
                    k.a();
                }
                CBGetSignatureResponse.Payload payload3 = payload2.get(0);
                String imageId = payload3 != null ? payload3.getImageId() : null;
                if (!TextUtils.isEmpty(imageId)) {
                    if (imageId == null) {
                        k.a();
                    }
                    this.o = imageId;
                    b.a f2 = f();
                    if (f2 != null) {
                        f2.a(this.o, (String) null);
                        return;
                    }
                    return;
                }
            }
        }
        c(false);
    }

    public final void e() {
        c(false);
    }

    public final void a(String str, String str2) {
        k.c(str, "errorTitle");
        k.c(str2, ImagePickerUtils.IMAGE_PICKER_KEY_ERROR_MESSAGE);
        com.paytm.utility.b.b((Context) this, str, str2);
    }

    public final void a(boolean z) {
        if (z) {
            String string = getString(R.string.please_wait);
            k.a((Object) string, "getString(R.string.please_wait)");
            a(this, string);
            return;
        }
        h();
    }

    private b.a f() {
        b.a aVar = this.f17876b;
        if (aVar == null) {
            k.a("presenter");
        }
        return aVar;
    }

    public final int a() {
        return R.layout.pb_activity_cheque_signature;
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0116  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0128  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0133  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onCreate(android.os.Bundle r6) {
        /*
            r5 = this;
            super.onCreate(r6)
            r0 = r5
            net.one97.paytm.paymentsBank.chequebook.signatureupdate.view.SignatureReUploadActivityV2 r0 = (net.one97.paytm.paymentsBank.chequebook.signatureupdate.view.SignatureReUploadActivityV2) r0
            net.one97.paytm.paymentsBank.chequebook.signaturelanding.a.b$a r0 = r0.f17876b
            java.lang.String r1 = "baseContext"
            if (r0 != 0) goto L_0x0033
            net.one97.paytm.paymentsBank.chequebook.signaturelanding.b.b r0 = new net.one97.paytm.paymentsBank.chequebook.signaturelanding.b.b
            net.one97.paytm.paymentsBank.chequebook.utils.d r2 = net.one97.paytm.paymentsBank.chequebook.utils.d.f17950a
            android.content.Context r2 = r5.getApplicationContext()
            java.lang.String r3 = "applicationContext"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            net.one97.paytm.paymentsBank.chequebook.utils.g r2 = net.one97.paytm.paymentsBank.chequebook.utils.d.a(r2)
            r3 = r5
            net.one97.paytm.paymentsBank.chequebook.signaturelanding.a.b$b r3 = (net.one97.paytm.paymentsBank.chequebook.signaturelanding.a.b.C0286b) r3
            android.content.Context r4 = r5.getBaseContext()
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r1)
            r0.<init>(r2, r3, r4)
            net.one97.paytm.paymentsBank.chequebook.signaturelanding.a.b$a r0 = (net.one97.paytm.paymentsBank.chequebook.signaturelanding.a.b.a) r0
            java.lang.String r2 = "<set-?>"
            kotlin.g.b.k.c(r0, r2)
            r5.f17876b = r0
        L_0x0033:
            com.google.gson.f r0 = new com.google.gson.f
            r0.<init>()
            r2 = r5
            android.content.Context r2 = (android.content.Context) r2
            net.one97.paytm.paymentsBank.chequebook.utils.h r2 = net.one97.paytm.paymentsBank.chequebook.utils.h.a((android.content.Context) r2)
            r5.p = r2
            net.one97.paytm.paymentsBank.chequebook.utils.h r2 = r5.p
            r3 = 0
            if (r2 == 0) goto L_0x004d
            java.lang.String r2 = "CB_KEY_FIN_RESPONSE"
            java.lang.String r2 = net.one97.paytm.paymentsBank.chequebook.utils.h.a((java.lang.String) r2)
            goto L_0x004e
        L_0x004d:
            r2 = r3
        L_0x004e:
            r5.q = r2
            java.lang.String r2 = r5.q
            java.lang.Class<net.one97.paytm.paymentsBank.chequebook.model.ChequeBookFinResponse> r4 = net.one97.paytm.paymentsBank.chequebook.model.ChequeBookFinResponse.class
            java.lang.Object r0 = r0.a((java.lang.String) r2, r4)
            net.one97.paytm.paymentsBank.chequebook.model.ChequeBookFinResponse r0 = (net.one97.paytm.paymentsBank.chequebook.model.ChequeBookFinResponse) r0
            net.one97.paytm.paymentsBank.chequebook.signaturelanding.a.b$a r2 = r5.f()
            r2.a()
            if (r0 == 0) goto L_0x009d
            if (r6 != 0) goto L_0x009d
            java.lang.String r6 = "chequeBookFinResponse"
            kotlin.g.b.k.c(r0, r6)
            java.lang.String r6 = r0.getMessage()
            r1 = 1
            java.lang.String r2 = "SUCCESS"
            boolean r6 = kotlin.m.p.a((java.lang.String) r6, (java.lang.String) r2, (boolean) r1)
            if (r6 == 0) goto L_0x009a
            java.lang.String r6 = r0.getResponseCode()
            java.lang.String r1 = "200"
            boolean r6 = r6.equals(r1)
            if (r6 == 0) goto L_0x009a
            net.one97.paytm.paymentsBank.chequebook.model.ChequeBookResponse r6 = r0.getResponse()
            if (r6 == 0) goto L_0x009a
            net.one97.paytm.paymentsBank.chequebook.model.ChequeBookSignature r6 = r6.getSignature()
            if (r6 == 0) goto L_0x009a
            java.lang.String r6 = r6.getStatus()
            if (r6 != 0) goto L_0x0098
            kotlin.g.b.k.a()
        L_0x0098:
            r5.l = r6
        L_0x009a:
            java.lang.String r6 = "UPLOADED"
            goto L_0x00c6
        L_0x009d:
            if (r6 == 0) goto L_0x00cb
            net.one97.paytm.paymentsBank.chequebook.signaturelanding.a.b$a r0 = r5.f()
            android.content.Context r2 = r5.getBaseContext()
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r1)
            r1 = r5
            net.one97.paytm.paymentsBank.chequebook.signaturelanding.a.b$b r1 = (net.one97.paytm.paymentsBank.chequebook.signaturelanding.a.b.C0286b) r1
            java.lang.String r4 = "signature"
            java.lang.String r4 = r6.getString(r4)
            if (r4 != 0) goto L_0x00b8
            kotlin.g.b.k.a()
        L_0x00b8:
            r0.a((android.content.Context) r2, (net.one97.paytm.paymentsBank.chequebook.signaturelanding.a.b.C0286b) r1, (java.lang.String) r4)
            java.lang.String r0 = "CHEQUEBOOK_SIGNATURE_STATUS"
            java.lang.String r6 = r6.getString(r0)
            if (r6 != 0) goto L_0x00c6
            kotlin.g.b.k.a()
        L_0x00c6:
            r5.l = r6
            r5.l()
        L_0x00cb:
            int r6 = net.one97.paytm.paymentsBank.R.id.ll_btns_change_signature
            android.view.View r6 = r5.a((int) r6)
            android.widget.RelativeLayout r6 = (android.widget.RelativeLayout) r6
            net.one97.paytm.paymentsBank.chequebook.signatureupdate.view.SignatureReUploadActivityV2$d r0 = new net.one97.paytm.paymentsBank.chequebook.signatureupdate.view.SignatureReUploadActivityV2$d
            r0.<init>(r5)
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r6.setOnClickListener(r0)
            int r6 = net.one97.paytm.paymentsBank.R.id.btn_submit_signature
            android.view.View r6 = r5.a((int) r6)
            android.widget.TextView r6 = (android.widget.TextView) r6
            net.one97.paytm.paymentsBank.chequebook.signatureupdate.view.SignatureReUploadActivityV2$e r0 = new net.one97.paytm.paymentsBank.chequebook.signatureupdate.view.SignatureReUploadActivityV2$e
            r0.<init>(r5)
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r6.setOnClickListener(r0)
            int r6 = net.one97.paytm.paymentsBank.R.id.upload_first_time_lyt
            android.view.View r6 = r5.a((int) r6)
            android.widget.RelativeLayout r6 = (android.widget.RelativeLayout) r6
            net.one97.paytm.paymentsBank.chequebook.signatureupdate.view.SignatureReUploadActivityV2$f r0 = new net.one97.paytm.paymentsBank.chequebook.signatureupdate.view.SignatureReUploadActivityV2$f
            r0.<init>(r5)
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r6.setOnClickListener(r0)
            int r6 = net.one97.paytm.paymentsBank.R.id.pb_signature_verfication_toolbar
            android.view.View r6 = r5.a((int) r6)
            java.lang.String r0 = "pb_signature_verfication_toolbar"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r0)
            r0 = 0
            r6.setVisibility(r0)
            android.content.Intent r6 = r5.getIntent()
            if (r6 == 0) goto L_0x011c
            java.lang.String r1 = "passcode_extra"
            java.lang.String r3 = r6.getStringExtra(r1)
        L_0x011c:
            r5.f17882i = r3
            java.lang.String r6 = r5.l
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 != 0) goto L_0x012d
            java.lang.String r6 = "CURRENT"
            r5.a((java.lang.String) r6)
        L_0x012d:
            android.content.Intent r6 = r5.getIntent()
            if (r6 == 0) goto L_0x013d
            net.one97.paytm.paymentsBank.chequebook.utils.e r1 = net.one97.paytm.paymentsBank.chequebook.utils.e.f17951a
            java.lang.String r1 = net.one97.paytm.paymentsBank.chequebook.utils.e.T()
            boolean r0 = r6.getBooleanExtra(r1, r0)
        L_0x013d:
            r5.n = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.paymentsBank.chequebook.signatureupdate.view.SignatureReUploadActivityV2.onCreate(android.os.Bundle):void");
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SignatureReUploadActivityV2 f17885a;

        d(SignatureReUploadActivityV2 signatureReUploadActivityV2) {
            this.f17885a = signatureReUploadActivityV2;
        }

        public final void onClick(View view) {
            SignatureReUploadActivityV2.c(this.f17885a);
        }
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SignatureReUploadActivityV2 f17886a;

        e(SignatureReUploadActivityV2 signatureReUploadActivityV2) {
            this.f17886a = signatureReUploadActivityV2;
        }

        public final void onClick(View view) {
            if (SystemClock.elapsedRealtime() - this.f17886a.f17875a >= 1000) {
                this.f17886a.f17875a = SystemClock.elapsedRealtime();
                if (!this.f17886a.j) {
                    this.f17886a.j = true;
                    BankPasscodeActivity.a aVar = BankPasscodeActivity.r;
                    SignatureReUploadActivityV2 signatureReUploadActivityV2 = this.f17886a;
                    String string = signatureReUploadActivityV2.getString(R.string.pb_cb_enter_passcode_for_sign);
                    k.a((Object) string, "getString(R.string.pb_cb_enter_passcode_for_sign)");
                    BankPasscodeActivity.a.a(signatureReUploadActivityV2, string);
                }
            }
        }
    }

    static final class f implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SignatureReUploadActivityV2 f17887a;

        f(SignatureReUploadActivityV2 signatureReUploadActivityV2) {
            this.f17887a = signatureReUploadActivityV2;
        }

        public final void onClick(View view) {
            SignatureReUploadActivityV2.d(this.f17887a);
        }
    }

    private final void c(boolean z) {
        if (z) {
            if (!TextUtils.isEmpty(this.m) && this.m.equals("ACCEPTED")) {
                this.m = "";
                this.l = "ACCEPTED";
                l();
            }
        } else if (!TextUtils.isEmpty(this.m) && this.m.equals("ACCEPTED")) {
            this.m = "";
        }
    }

    /* access modifiers changed from: private */
    public final void a(String str) {
        b.a f2 = f();
        if (f2 != null) {
            f2.c(str);
        }
    }

    private void g() {
        TextView textView = (TextView) a(R.id.tv_sign_msg);
        k.a((Object) textView, "tv_sign_msg");
        textView.setVisibility(0);
        ImageView imageView = (ImageView) a(R.id.iv_verify_icon);
        k.a((Object) imageView, "iv_verify_icon");
        imageView.setVisibility(8);
        TextView textView2 = (TextView) a(R.id.tv_signature_verified);
        k.a((Object) textView2, "tv_signature_verified");
        textView2.setVisibility(8);
        RelativeLayout relativeLayout = (RelativeLayout) a(R.id.ll_signature_status_cont);
        k.a((Object) relativeLayout, "ll_signature_status_cont");
        relativeLayout.setVisibility(0);
        TextView textView3 = (TextView) a(R.id.tv_authorized_sign_title);
        k.a((Object) textView3, "tv_authorized_sign_title");
        net.one97.paytm.paymentsBank.chequebook.utils.b.a(textView3);
        TextView textView4 = (TextView) a(R.id.tv_authorized_sign_title);
        k.a((Object) textView4, "tv_authorized_sign_title");
        textView4.setText(getString(R.string.pb_new_signature));
        TextView textView5 = (TextView) a(R.id.tv_signature_status);
        k.a((Object) textView5, "tv_signature_status");
        textView5.setText(getString(R.string.pb_signature_status_pending));
        ((TextView) a(R.id.tv_signature_status)).setTextColor(androidx.core.content.b.c(this, R.color.color_ffa400));
        ((ImageView) a(R.id.iv_signature_status)).setImageResource(R.drawable.pb_ic_pending_small);
        TextView textView6 = (TextView) a(R.id.tv_signature_status_msg);
        k.a((Object) textView6, "tv_signature_status_msg");
        textView6.setVisibility(0);
        TextView textView7 = (TextView) a(R.id.tv_signature_date);
        k.a((Object) textView7, "tv_signature_date");
        textView7.setVisibility(8);
        TextView textView8 = (TextView) a(R.id.tv_ok_understand);
        k.a((Object) textView8, "tv_ok_understand");
        textView8.setVisibility(8);
        RelativeLayout relativeLayout2 = (RelativeLayout) a(R.id.upload_first_time_lyt);
        k.a((Object) relativeLayout2, "upload_first_time_lyt");
        relativeLayout2.setVisibility(8);
        ImageView imageView2 = (ImageView) a(R.id.iv_signature);
        k.a((Object) imageView2, "iv_signature");
        imageView2.setVisibility(0);
        TextView textView9 = (TextView) a(R.id.tv_signa_title);
        k.a((Object) textView9, "tv_signa_title");
        textView9.setText(getString(R.string.pb_signature));
        RelativeLayout relativeLayout3 = (RelativeLayout) a(R.id.ll_btns_change_signature);
        k.a((Object) relativeLayout3, "ll_btns_change_signature");
        net.one97.paytm.paymentsBank.chequebook.utils.b.b(relativeLayout3);
        TextView textView10 = (TextView) a(R.id.tv_signature_status);
        k.a((Object) textView10, "tv_signature_status");
        net.one97.paytm.paymentsBank.chequebook.utils.b.a(textView10);
        ImageView imageView3 = (ImageView) a(R.id.iv_signature_status);
        k.a((Object) imageView3, "iv_signature_status");
        net.one97.paytm.paymentsBank.chequebook.utils.b.a(imageView3);
        TextView textView11 = (TextView) a(R.id.tv_signature_status_msg);
        k.a((Object) textView11, "tv_signature_status_msg");
        net.one97.paytm.paymentsBank.chequebook.utils.b.a(textView11);
        RelativeLayout relativeLayout4 = (RelativeLayout) a(R.id.rl_approved_sig_change_id);
        if (relativeLayout4 != null) {
            relativeLayout4.setVisibility(8);
        }
    }

    private void i() {
        TextView textView = (TextView) a(R.id.tv_sign_msg);
        k.a((Object) textView, "tv_sign_msg");
        textView.setVisibility(8);
        ImageView imageView = (ImageView) a(R.id.iv_verify_icon);
        k.a((Object) imageView, "iv_verify_icon");
        imageView.setVisibility(8);
        TextView textView2 = (TextView) a(R.id.tv_signature_verified);
        k.a((Object) textView2, "tv_signature_verified");
        textView2.setVisibility(8);
        RelativeLayout relativeLayout = (RelativeLayout) a(R.id.ll_signature_status_cont);
        k.a((Object) relativeLayout, "ll_signature_status_cont");
        relativeLayout.setVisibility(0);
        TextView textView3 = (TextView) a(R.id.tv_authorized_sign_title);
        k.a((Object) textView3, "tv_authorized_sign_title");
        net.one97.paytm.paymentsBank.chequebook.utils.b.a(textView3);
        TextView textView4 = (TextView) a(R.id.tv_authorized_sign_title);
        k.a((Object) textView4, "tv_authorized_sign_title");
        textView4.setText(getString(R.string.pb_autho_signature));
        TextView textView5 = (TextView) a(R.id.tv_signature_status);
        k.a((Object) textView5, "tv_signature_status");
        textView5.setText(getString(R.string.pb_request_for_signature_change_rejected));
        ((TextView) a(R.id.tv_signature_status)).setTextColor(androidx.core.content.b.c(this, R.color.color_fd5c5c));
        ((ImageView) a(R.id.iv_signature_status)).setImageResource(R.drawable.pb_ic_failed_small);
        TextView textView6 = (TextView) a(R.id.tv_signature_status_msg);
        k.a((Object) textView6, "tv_signature_status_msg");
        textView6.setText(getString(R.string.pb_cb_reject_sign_desc));
        TextView textView7 = (TextView) a(R.id.tv_signature_date);
        k.a((Object) textView7, "tv_signature_date");
        textView7.setVisibility(8);
        RelativeLayout relativeLayout2 = (RelativeLayout) a(R.id.upload_first_time_lyt);
        k.a((Object) relativeLayout2, "upload_first_time_lyt");
        relativeLayout2.setVisibility(8);
        TextView textView8 = (TextView) a(R.id.tv_signa_title);
        k.a((Object) textView8, "tv_signa_title");
        textView8.setText(getString(R.string.pb_signature));
        ImageView imageView2 = (ImageView) a(R.id.iv_signature);
        k.a((Object) imageView2, "iv_signature");
        imageView2.setVisibility(0);
        RelativeLayout relativeLayout3 = (RelativeLayout) a(R.id.ll_btns_change_signature);
        k.a((Object) relativeLayout3, "ll_btns_change_signature");
        net.one97.paytm.paymentsBank.chequebook.utils.b.a(relativeLayout3);
        RelativeLayout relativeLayout4 = (RelativeLayout) a(R.id.rl_approved_sig_change_id);
        if (relativeLayout4 != null) {
            relativeLayout4.setVisibility(8);
        }
    }

    private void j() {
        TextView textView = (TextView) a(R.id.tv_sign_msg);
        k.a((Object) textView, "tv_sign_msg");
        textView.setVisibility(0);
        TextView textView2 = (TextView) a(R.id.tv_authorized_sign_title);
        k.a((Object) textView2, "tv_authorized_sign_title");
        net.one97.paytm.paymentsBank.chequebook.utils.b.a(textView2);
        TextView textView3 = (TextView) a(R.id.tv_authorized_sign_title);
        k.a((Object) textView3, "tv_authorized_sign_title");
        textView3.setText(getString(R.string.pb_autho_signature));
        RelativeLayout relativeLayout = (RelativeLayout) a(R.id.ll_signature_status_cont);
        k.a((Object) relativeLayout, "ll_signature_status_cont");
        relativeLayout.setVisibility(8);
        ImageView imageView = (ImageView) a(R.id.iv_verify_icon);
        k.a((Object) imageView, "iv_verify_icon");
        imageView.setVisibility(0);
        TextView textView4 = (TextView) a(R.id.tv_signature_verified);
        k.a((Object) textView4, "tv_signature_verified");
        textView4.setVisibility(0);
        RelativeLayout relativeLayout2 = (RelativeLayout) a(R.id.upload_first_time_lyt);
        k.a((Object) relativeLayout2, "upload_first_time_lyt");
        relativeLayout2.setVisibility(8);
        TextView textView5 = (TextView) a(R.id.tv_signa_title);
        k.a((Object) textView5, "tv_signa_title");
        textView5.setText(getString(R.string.pb_signature));
        ImageView imageView2 = (ImageView) a(R.id.iv_signature);
        k.a((Object) imageView2, "iv_signature");
        imageView2.setVisibility(0);
        RelativeLayout relativeLayout3 = (RelativeLayout) a(R.id.ll_btns_change_signature);
        k.a((Object) relativeLayout3, "ll_btns_change_signature");
        net.one97.paytm.paymentsBank.chequebook.utils.b.a(relativeLayout3);
        RelativeLayout relativeLayout4 = (RelativeLayout) a(R.id.rl_approved_sig_change_id);
        if (relativeLayout4 != null) {
            relativeLayout4.setVisibility(8);
        }
    }

    private void k() {
        TextView textView = (TextView) a(R.id.tv_sign_msg);
        k.a((Object) textView, "tv_sign_msg");
        textView.setVisibility(0);
        TextView textView2 = (TextView) a(R.id.tv_authorized_sign_title);
        k.a((Object) textView2, "tv_authorized_sign_title");
        net.one97.paytm.paymentsBank.chequebook.utils.b.a(textView2);
        TextView textView3 = (TextView) a(R.id.tv_authorized_sign_title);
        k.a((Object) textView3, "tv_authorized_sign_title");
        textView3.setText(getString(R.string.pb_autho_signature));
        RelativeLayout relativeLayout = (RelativeLayout) a(R.id.ll_signature_status_cont);
        k.a((Object) relativeLayout, "ll_signature_status_cont");
        relativeLayout.setVisibility(8);
        ImageView imageView = (ImageView) a(R.id.iv_verify_icon);
        k.a((Object) imageView, "iv_verify_icon");
        imageView.setVisibility(8);
        TextView textView4 = (TextView) a(R.id.tv_signature_verified);
        k.a((Object) textView4, "tv_signature_verified");
        textView4.setVisibility(8);
        RelativeLayout relativeLayout2 = (RelativeLayout) a(R.id.upload_first_time_lyt);
        k.a((Object) relativeLayout2, "upload_first_time_lyt");
        relativeLayout2.setVisibility(8);
        TextView textView5 = (TextView) a(R.id.tv_signa_title);
        k.a((Object) textView5, "tv_signa_title");
        textView5.setText(getString(R.string.pb_signature));
        ImageView imageView2 = (ImageView) a(R.id.iv_signature);
        k.a((Object) imageView2, "iv_signature");
        imageView2.setVisibility(0);
        RelativeLayout relativeLayout3 = (RelativeLayout) a(R.id.ll_btns_change_signature);
        k.a((Object) relativeLayout3, "ll_btns_change_signature");
        net.one97.paytm.paymentsBank.chequebook.utils.b.a(relativeLayout3);
        RelativeLayout relativeLayout4 = (RelativeLayout) a(R.id.rl_approved_sig_change_id);
        if (relativeLayout4 != null) {
            relativeLayout4.setVisibility(0);
        }
        TextView textView6 = (TextView) a(R.id.tv_appv_sig_yes);
        if (textView6 != null) {
            textView6.setOnClickListener(new g(this));
        }
    }

    static final class g implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SignatureReUploadActivityV2 f17888a;

        g(SignatureReUploadActivityV2 signatureReUploadActivityV2) {
            this.f17888a = signatureReUploadActivityV2;
        }

        public final void onClick(View view) {
            this.f17888a.m = "ACCEPTED";
            this.f17888a.a("ACCEPTED");
        }
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 203) {
            CropImage.ActivityResult a2 = CropImage.a(intent);
            if (i3 != -1) {
                return;
            }
            if (intent == null) {
                Toast.makeText(this, getString(R.string.pb_something_wrong_try_again), 1).show();
            } else if (a2 == null) {
                Toast.makeText(this, getString(R.string.pb_something_wrong_try_again), 1).show();
            } else if (p.a(Environment.getExternalStorageState(), "mounted", true)) {
                String str = Environment.getExternalStorageDirectory().toString() + "/Android/data/" + getPackageName();
                if (new File(str).exists()) {
                    File file = new File(str);
                    File[] listFiles = file.listFiles();
                    int length = listFiles.length;
                    int i4 = 0;
                    while (true) {
                        if (i4 >= length) {
                            break;
                        }
                        File file2 = listFiles[i4];
                        k.a((Object) file2, "temp");
                        if (p.a(file2.getName(), "picture.jpg", true)) {
                            file = file2;
                            break;
                        }
                        i4++;
                    }
                    Uri fromFile = Uri.fromFile(new File(file.getAbsolutePath()));
                    k.a((Object) fromFile, "Uri.fromFile(File(f.absolutePath))");
                    this.f17877c = fromFile;
                    String absolutePath = file.getAbsolutePath();
                    k.a((Object) absolutePath, "f.absolutePath");
                    this.f17879f = absolutePath;
                    new b(this).execute(new String[]{file.getAbsolutePath()});
                }
            }
        } else if (i2 != 121) {
        } else {
            if (i3 == -1) {
                if (intent != null && !TextUtils.isEmpty(intent.getStringExtra("passcode"))) {
                    String stringExtra = intent.getStringExtra("passcode");
                    k.a((Object) stringExtra, "data.getStringExtra(Paym…Constants.EXTRA_PASSCODE)");
                    this.f17881h = stringExtra;
                    if (this.j) {
                        b.a f2 = f();
                        String str2 = this.f17881h;
                        if (str2 == null) {
                            k.a("bankScopeToken");
                        }
                        Uri uri = this.f17877c;
                        if (uri == null) {
                            k.a("selectedImage");
                        }
                        String str3 = this.f17879f;
                        if (str3 == null) {
                            k.a("filepath");
                        }
                        f2.a(str2, uri, str3);
                        return;
                    }
                    b.a f3 = f();
                    String str4 = this.f17881h;
                    if (str4 == null) {
                        k.a("bankScopeToken");
                    }
                    f3.b(str4);
                }
            } else if (!this.j) {
                finish();
            } else {
                this.j = false;
            }
        }
    }

    private final void a(Uri uri) {
        c(true);
        w.a().a(uri).a(s.NO_CACHE, new s[0]).a((ImageView) a(R.id.iv_signature));
        ImageView imageView = (ImageView) a(R.id.iv_signature);
        k.a((Object) imageView, "iv_signature");
        imageView.setVisibility(0);
    }

    private final void l() {
        if (p.a(this.l, "APPROVAL_PENDING", true)) {
            g();
        } else if (p.a(this.l, "ACCEPTED", true)) {
            j();
        } else if (p.a(this.l, "REJECTED", true)) {
            i();
        } else if (this.l.equals("UPLOADED")) {
            k();
        } else {
            m();
        }
    }

    private final void m() {
        ImageView imageView = (ImageView) a(R.id.iv_verify_icon);
        k.a((Object) imageView, "iv_verify_icon");
        imageView.setVisibility(8);
        TextView textView = (TextView) a(R.id.tv_signature_verified);
        k.a((Object) textView, "tv_signature_verified");
        textView.setVisibility(8);
        RelativeLayout relativeLayout = (RelativeLayout) a(R.id.ll_signature_status_cont);
        k.a((Object) relativeLayout, "ll_signature_status_cont");
        relativeLayout.setVisibility(8);
        TextView textView2 = (TextView) a(R.id.tv_authorized_sign_title);
        k.a((Object) textView2, "tv_authorized_sign_title");
        net.one97.paytm.paymentsBank.chequebook.utils.b.a(textView2);
        TextView textView3 = (TextView) a(R.id.tv_authorized_sign_title);
        k.a((Object) textView3, "tv_authorized_sign_title");
        textView3.setText(getString(R.string.pb_autho_signature));
        RelativeLayout relativeLayout2 = (RelativeLayout) a(R.id.upload_first_time_lyt);
        k.a((Object) relativeLayout2, "upload_first_time_lyt");
        relativeLayout2.setVisibility(0);
        TextView textView4 = (TextView) a(R.id.tv_signa_title);
        k.a((Object) textView4, "tv_signa_title");
        textView4.setText(getString(R.string.pb_cb_upload_sign_title));
        ImageView imageView2 = (ImageView) a(R.id.iv_signature);
        k.a((Object) imageView2, "iv_signature");
        imageView2.setVisibility(8);
        RelativeLayout relativeLayout3 = (RelativeLayout) a(R.id.ll_btns_change_signature);
        k.a((Object) relativeLayout3, "ll_btns_change_signature");
        relativeLayout3.setVisibility(8);
        RelativeLayout relativeLayout4 = (RelativeLayout) a(R.id.rl_approved_sig_change_id);
        if (relativeLayout4 != null) {
            relativeLayout4.setVisibility(8);
        }
    }

    public final void c(String str, String str2) {
        k.c(str, "imgUrl");
        k.c(str2, "signStatus");
        if (!TextUtils.isEmpty(str)) {
            ImageView imageView = (ImageView) a(R.id.iv_signature);
            k.a((Object) imageView, "iv_signature");
            imageView.setVisibility(0);
            w.a().a(str).a((ImageView) a(R.id.iv_signature));
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        if (str2.equals("APPROVAL_PENDING")) {
            g();
        } else if (k.a((Object) str2, (Object) "REJECTED")) {
            i();
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public static final class c extends AsyncTask<String, Void, String> {

        /* renamed from: a  reason: collision with root package name */
        private final Context f17884a;

        public c(Context context) {
            k.c(context, "signatureReuploadActivity");
            this.f17884a = context;
        }

        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            String[] strArr = (String[]) objArr;
            k.c(strArr, "params");
            String format = new SimpleDateFormat("EEE', 'dd' 'MMM' 'yyyy' 'HH:mm:ss' 'Z", Locale.US).format(new Date());
            URLConnection openConnection = new URL(strArr[0]).openConnection();
            if (openConnection != null) {
                HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setRequestMethod("PUT");
                httpURLConnection.setRequestProperty("Accept", "*/*");
                httpURLConnection.setRequestProperty("Date", format);
                httpURLConnection.setRequestProperty("Content-type", "application/octet-stream");
                OutputStream outputStream = httpURLConnection.getOutputStream();
                FileInputStream fileInputStream = new FileInputStream(new File(strArr[1]));
                byte[] bArr = new byte[4096];
                for (int read = fileInputStream.read(bArr); read != -1; read = fileInputStream.read(bArr)) {
                    outputStream.write(bArr, 0, read);
                }
                outputStream.close();
                fileInputStream.close();
                return httpURLConnection.getResponseCode() == 200 ? "SUCCESS" : "FAILURE";
            }
            throw new u("null cannot be cast to non-null type java.net.HttpURLConnection");
        }

        public final /* synthetic */ void onPostExecute(Object obj) {
            String str = (String) obj;
            Context context = this.f17884a;
            if (context != null) {
                SignatureReUploadActivityV2 signatureReUploadActivityV2 = (SignatureReUploadActivityV2) context;
                if (p.a(str, "SUCCESS", false)) {
                    signatureReUploadActivityV2.b(true);
                } else {
                    signatureReUploadActivityV2.j = false;
                    signatureReUploadActivityV2.a(false);
                }
                super.onPostExecute(str);
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.paymentsBank.chequebook.signatureupdate.view.SignatureReUploadActivityV2");
        }
    }

    public final void b(String str, String str2) {
        k.c(str, "s3Url");
        k.c(str2, "imageId");
        this.f17880g = str2;
        String str3 = this.f17879f;
        if (str3 == null) {
            k.a("filepath");
        }
        if (!TextUtils.isEmpty(str3)) {
            c cVar = new c(this);
            String[] strArr = new String[2];
            strArr[0] = str;
            String str4 = this.f17879f;
            if (str4 == null) {
                k.a("filepath");
            }
            strArr[1] = str4;
            cVar.execute(strArr);
        }
    }

    private final void a(boolean z, boolean z2) {
        if (z) {
            TextView textView = (TextView) a(R.id.btn_submit_signature);
            k.a((Object) textView, "btn_submit_signature");
            textView.setVisibility(0);
            if (z2) {
                TextView textView2 = (TextView) a(R.id.btn_submit_signature);
                k.a((Object) textView2, "btn_submit_signature");
                textView2.setText(getString(R.string.pb_cb_btn_submit_sign));
                return;
            }
            TextView textView3 = (TextView) a(R.id.btn_submit_signature);
            k.a((Object) textView3, "btn_submit_signature");
            textView3.setText(getString(R.string.pb_btn_submit_sign));
            return;
        }
        TextView textView4 = (TextView) a(R.id.btn_submit_signature);
        k.a((Object) textView4, "btn_submit_signature");
        textView4.setVisibility(8);
    }

    public final void b(boolean z) {
        this.r = false;
        if (z) {
            b.a f2 = f();
            String str = this.f17880g;
            if (str == null) {
                k.a("imageID");
            }
            f2.a(str);
            this.l = "APPROVAL_PENDING";
            a(false, false);
            g();
            Toast.makeText(this, getString(R.string.pb_cb_image_upload_success), 0).show();
            return;
        }
        Toast.makeText(this, getString(R.string.pb_cb_image_upload_failure), 0).show();
        TextView textView = (TextView) a(R.id.tv_change_signature);
        k.a((Object) textView, "tv_change_signature");
        textView.setText(getString(R.string.pb_cb_retry_signature_upload));
        TextView textView2 = (TextView) a(R.id.tv_change_signature);
        k.a((Object) textView2, "tv_change_signature");
        textView2.setVisibility(0);
        c(f().c(), "");
        a(false, false);
    }

    public static final class b extends AsyncTask<String, Void, String> {

        /* renamed from: a  reason: collision with root package name */
        private final Context f17883a;

        public b(Context context) {
            k.c(context, "signatureReuploadActivity");
            this.f17883a = context;
        }

        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            String[] strArr = (String[]) objArr;
            k.c(strArr, "params");
            if (TextUtils.isEmpty(strArr[0])) {
                return "FAILURE";
            }
            net.one97.paytm.paymentsBank.chequebook.utils.a.a(strArr[0]);
            return "SUCCESS";
        }

        public final /* synthetic */ void onPostExecute(Object obj) {
            String str = (String) obj;
            super.onPostExecute(str);
            if (this.f17883a == null) {
                throw new u("null cannot be cast to non-null type net.one97.paytm.paymentsBank.chequebook.signatureupdate.view.SignatureReUploadActivityV2");
            } else if (p.a(str, "SUCCESS", false)) {
                ((SignatureReUploadActivityV2) this.f17883a).k = true;
                SignatureReUploadActivityV2.b((SignatureReUploadActivityV2) this.f17883a);
            } else {
                ((SignatureReUploadActivityV2) this.f17883a).k = false;
            }
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        k.c(bundle, "outState");
        bundle.putString("signature", f().c());
        bundle.putString("CHEQUEBOOK_SIGNATURE_STATUS", this.l);
        super.onSaveInstanceState(bundle);
    }

    public static final /* synthetic */ void b(SignatureReUploadActivityV2 signatureReUploadActivityV2) {
        String str = signatureReUploadActivityV2.f17879f;
        if (str == null) {
            k.a("filepath");
        }
        new File(str);
        Uri uri = signatureReUploadActivityV2.f17877c;
        if (uri == null) {
            k.a("selectedImage");
        }
        signatureReUploadActivityV2.a(uri);
        TextView textView = (TextView) signatureReUploadActivityV2.a(R.id.tv_signature_verified);
        k.a((Object) textView, "tv_signature_verified");
        net.one97.paytm.paymentsBank.chequebook.utils.b.b(textView);
        ImageView imageView = (ImageView) signatureReUploadActivityV2.a(R.id.iv_verify_icon);
        k.a((Object) imageView, "iv_verify_icon");
        net.one97.paytm.paymentsBank.chequebook.utils.b.b(imageView);
        signatureReUploadActivityV2.a(true, p.a(signatureReUploadActivityV2.l, "UPLOAD_PENDING", true));
        RelativeLayout relativeLayout = (RelativeLayout) signatureReUploadActivityV2.a(R.id.ll_btns_change_signature);
        k.a((Object) relativeLayout, "ll_btns_change_signature");
        relativeLayout.setVisibility(0);
        TextView textView2 = (TextView) signatureReUploadActivityV2.a(R.id.tv_authorized_sign_title);
        k.a((Object) textView2, "tv_authorized_sign_title");
        net.one97.paytm.paymentsBank.chequebook.utils.b.a(textView2);
        TextView textView3 = (TextView) signatureReUploadActivityV2.a(R.id.tv_authorized_sign_title);
        k.a((Object) textView3, "tv_authorized_sign_title");
        textView3.setText(signatureReUploadActivityV2.getString(R.string.pb_new_signature));
        RelativeLayout relativeLayout2 = (RelativeLayout) signatureReUploadActivityV2.a(R.id.upload_first_time_lyt);
        k.a((Object) relativeLayout2, "upload_first_time_lyt");
        relativeLayout2.setVisibility(8);
        TextView textView4 = (TextView) signatureReUploadActivityV2.a(R.id.tv_signa_title);
        k.a((Object) textView4, "tv_signa_title");
        textView4.setText(signatureReUploadActivityV2.getString(R.string.pb_signature));
        TextView textView5 = (TextView) signatureReUploadActivityV2.a(R.id.tv_signature_status_msg);
        k.a((Object) textView5, "tv_signature_status_msg");
        net.one97.paytm.paymentsBank.chequebook.utils.b.b(textView5);
        ImageView imageView2 = (ImageView) signatureReUploadActivityV2.a(R.id.iv_signature_status);
        k.a((Object) imageView2, "iv_signature_status");
        net.one97.paytm.paymentsBank.chequebook.utils.b.b(imageView2);
        TextView textView6 = (TextView) signatureReUploadActivityV2.a(R.id.tv_signature_status);
        k.a((Object) textView6, "tv_signature_status");
        net.one97.paytm.paymentsBank.chequebook.utils.b.b(textView6);
        TextView textView7 = (TextView) signatureReUploadActivityV2.a(R.id.tv_sign_msg);
        k.a((Object) textView7, "tv_sign_msg");
        net.one97.paytm.paymentsBank.chequebook.utils.b.a(textView7);
        RelativeLayout relativeLayout3 = (RelativeLayout) signatureReUploadActivityV2.a(R.id.ll_signature_status_cont);
        k.a((Object) relativeLayout3, "ll_signature_status_cont");
        net.one97.paytm.paymentsBank.chequebook.utils.b.b(relativeLayout3);
    }

    public static final /* synthetic */ void c(SignatureReUploadActivityV2 signatureReUploadActivityV2) {
        Intent intent = new Intent(signatureReUploadActivityV2, SignatureLandingActivityV2.class);
        intent.putExtra("CHEQUEBOOK_SIGNATURE_STATUS", signatureReUploadActivityV2.l);
        intent.putExtra("is_first_time_user", false);
        signatureReUploadActivityV2.startActivityForResult(intent, 104);
        signatureReUploadActivityV2.finish();
    }

    public static final /* synthetic */ void d(SignatureReUploadActivityV2 signatureReUploadActivityV2) {
        new Intent("android.intent.action.GET_CONTENT");
        if (com.paytm.utility.s.a()) {
            Activity activity = signatureReUploadActivityV2;
            if (!com.paytm.utility.s.c(activity)) {
                com.paytm.utility.s.b(activity);
                return;
            }
        }
        CropImage.a().a(PBCropImageView.c.ON).a(Environment.getExternalStorageDirectory().toString() + "/Android/data/" + signatureReUploadActivityV2.getPackageName()).a((Activity) signatureReUploadActivityV2);
    }
}
