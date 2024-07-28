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
import java.util.Locale;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.chequebook.model.CBGetSignatureResponse;
import net.one97.paytm.paymentsBank.chequebook.model.ChequeBookFinResponse;
import net.one97.paytm.paymentsBank.chequebook.model.ChequeBookResponse;
import net.one97.paytm.paymentsBank.chequebook.model.ChequeBookSignature;
import net.one97.paytm.paymentsBank.chequebook.signaturelanding.a.b;
import net.one97.paytm.paymentsBank.chequebook.trackingflow.view.CBTLandingView;
import net.one97.paytm.paymentsBank.chequebook.utils.ChequeBookBaseActivity;
import net.one97.paytm.paymentsBank.chequebook.utils.h;
import net.one97.paytm.paymentsBank.passcode.BankPasscodeActivity;
import net.one97.paytm.paymentsBank.widget.croptool.CropImage;
import net.one97.paytm.paymentsBank.widget.croptool.PBCropImageView;

public final class SignatureReUploadActivity extends ChequeBookBaseActivity implements b.C0286b {

    /* renamed from: d  reason: collision with root package name */
    public static final a f17860d = new a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    long f17861a;

    /* renamed from: b  reason: collision with root package name */
    public b.a f17862b;

    /* renamed from: c  reason: collision with root package name */
    public Uri f17863c;

    /* renamed from: e  reason: collision with root package name */
    private final String f17864e = "SRUA";

    /* renamed from: f  reason: collision with root package name */
    private String f17865f;

    /* renamed from: g  reason: collision with root package name */
    private String f17866g;

    /* renamed from: h  reason: collision with root package name */
    private String f17867h;

    /* renamed from: i  reason: collision with root package name */
    private String f17868i;
    /* access modifiers changed from: private */
    public boolean j;
    /* access modifiers changed from: private */
    public boolean k;
    private String l = "";
    private boolean m;
    private h n;
    private String o;
    private boolean p;
    private HashMap q;

    public final View a(int i2) {
        if (this.q == null) {
            this.q = new HashMap();
        }
        View view = (View) this.q.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.q.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void a(CBGetSignatureResponse cBGetSignatureResponse) {
        k.c(cBGetSignatureResponse, Payload.RESPONSE);
    }

    public final void d(String str, String str2) {
    }

    public final void e() {
    }

    public final void d() {
        this.j = false;
    }

    public final void c() {
        startActivity(new Intent(this, CBTLandingView.class));
        finish();
    }

    public final void b() {
        if (this.m) {
            f().d();
        } else {
            a(false);
        }
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
        b.a aVar = this.f17862b;
        if (aVar == null) {
            k.a("presenter");
        }
        return aVar;
    }

    public final int a() {
        return R.layout.pb_activity_cheque_signature;
    }

    public final void onCreate(Bundle bundle) {
        ChequeBookResponse response;
        ChequeBookSignature signature;
        super.onCreate(bundle);
        if (this.f17862b == null) {
            net.one97.paytm.paymentsBank.chequebook.utils.d dVar = net.one97.paytm.paymentsBank.chequebook.utils.d.f17950a;
            Context applicationContext = getApplicationContext();
            k.a((Object) applicationContext, "applicationContext");
            Context baseContext = getBaseContext();
            k.a((Object) baseContext, "baseContext");
            b.a bVar = new net.one97.paytm.paymentsBank.chequebook.signaturelanding.b.b(net.one97.paytm.paymentsBank.chequebook.utils.d.a(applicationContext), this, baseContext);
            k.c(bVar, "<set-?>");
            this.f17862b = bVar;
        }
        com.google.gson.f fVar = new com.google.gson.f();
        this.n = h.a((Context) this);
        String str = null;
        this.o = this.n != null ? h.a("CB_KEY_FIN_RESPONSE") : null;
        ChequeBookFinResponse chequeBookFinResponse = (ChequeBookFinResponse) fVar.a(this.o, ChequeBookFinResponse.class);
        f().a();
        if (chequeBookFinResponse != null && bundle == null) {
            k.c(chequeBookFinResponse, "chequeBookFinResponse");
            if (p.a(chequeBookFinResponse.getMessage(), "SUCCESS", true) && chequeBookFinResponse.getResponseCode().equals("200") && (response = chequeBookFinResponse.getResponse()) != null && (signature = response.getSignature()) != null) {
                String status = signature.getStatus();
                if (status == null) {
                    k.a();
                }
                this.l = status;
            }
            k();
        } else if (bundle != null) {
            b.a f2 = f();
            Context baseContext2 = getBaseContext();
            k.a((Object) baseContext2, "baseContext");
            b.C0286b bVar2 = this;
            String string = bundle.getString("signature");
            if (string == null) {
                k.a();
            }
            f2.a(baseContext2, bVar2, string);
            String string2 = bundle.getString("CHEQUEBOOK_SIGNATURE_STATUS");
            if (string2 == null) {
                k.a();
            }
            this.l = string2;
            k();
        }
        ((RelativeLayout) a(R.id.ll_btns_change_signature)).setOnClickListener(new d(this));
        ((TextView) a(R.id.btn_submit_signature)).setOnClickListener(new e(this));
        ((RelativeLayout) a(R.id.upload_first_time_lyt)).setOnClickListener(new f(this));
        View a2 = a(R.id.pb_signature_verfication_toolbar);
        k.a((Object) a2, "pb_signature_verfication_toolbar");
        boolean z = false;
        a2.setVisibility(0);
        Intent intent = getIntent();
        if (intent != null) {
            str = intent.getStringExtra("passcode_extra");
        }
        this.f17868i = str;
        if (!TextUtils.isEmpty(this.f17868i)) {
            b.a f3 = f();
            String str2 = this.f17868i;
            if (str2 == null) {
                k.a();
            }
            f3.b(str2);
        } else {
            RelativeLayout relativeLayout = (RelativeLayout) a(R.id.upload_first_time_lyt);
            k.a((Object) relativeLayout, "upload_first_time_lyt");
            relativeLayout.setVisibility(0);
            TextView textView = (TextView) a(R.id.tv_signa_title);
            k.a((Object) textView, "tv_signa_title");
            textView.setText(getString(R.string.pb_cb_upload_sign_title));
        }
        Intent intent2 = getIntent();
        if (intent2 != null) {
            net.one97.paytm.paymentsBank.chequebook.utils.e eVar = net.one97.paytm.paymentsBank.chequebook.utils.e.f17951a;
            z = intent2.getBooleanExtra(net.one97.paytm.paymentsBank.chequebook.utils.e.T(), false);
        }
        this.m = z;
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SignatureReUploadActivity f17871a;

        d(SignatureReUploadActivity signatureReUploadActivity) {
            this.f17871a = signatureReUploadActivity;
        }

        public final void onClick(View view) {
            SignatureReUploadActivity.c(this.f17871a);
        }
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SignatureReUploadActivity f17872a;

        e(SignatureReUploadActivity signatureReUploadActivity) {
            this.f17872a = signatureReUploadActivity;
        }

        public final void onClick(View view) {
            if (SystemClock.elapsedRealtime() - this.f17872a.f17861a >= 1000) {
                this.f17872a.f17861a = SystemClock.elapsedRealtime();
                if (!this.f17872a.j) {
                    this.f17872a.j = true;
                    BankPasscodeActivity.a aVar = BankPasscodeActivity.r;
                    SignatureReUploadActivity signatureReUploadActivity = this.f17872a;
                    String string = signatureReUploadActivity.getString(R.string.pb_cb_enter_passcode_for_sign);
                    k.a((Object) string, "getString(R.string.pb_cb_enter_passcode_for_sign)");
                    BankPasscodeActivity.a.a(signatureReUploadActivity, string);
                }
            }
        }
    }

    static final class f implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SignatureReUploadActivity f17873a;

        f(SignatureReUploadActivity signatureReUploadActivity) {
            this.f17873a = signatureReUploadActivity;
        }

        public final void onClick(View view) {
            SignatureReUploadActivity.c(this.f17873a);
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
                    this.f17863c = fromFile;
                    String absolutePath = file.getAbsolutePath();
                    k.a((Object) absolutePath, "f.absolutePath");
                    this.f17865f = absolutePath;
                    new b(this).execute(new String[]{file.getAbsolutePath()});
                }
            }
        } else if (i2 != 121) {
        } else {
            if (i3 == -1) {
                if (intent != null && !TextUtils.isEmpty(intent.getStringExtra("passcode"))) {
                    String stringExtra = intent.getStringExtra("passcode");
                    k.a((Object) stringExtra, "data.getStringExtra(Paym…Constants.EXTRA_PASSCODE)");
                    this.f17867h = stringExtra;
                    if (this.j) {
                        b.a f2 = f();
                        String str2 = this.f17867h;
                        if (str2 == null) {
                            k.a("bankScopeToken");
                        }
                        Uri uri = this.f17863c;
                        if (uri == null) {
                            k.a("selectedImage");
                        }
                        String str3 = this.f17865f;
                        if (str3 == null) {
                            k.a("filepath");
                        }
                        f2.a(str2, uri, str3);
                        return;
                    }
                    b.a f3 = f();
                    String str4 = this.f17867h;
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

    private final void k() {
        if (p.a(this.l, "APPROVAL_PENDING", true)) {
            g();
        } else if (p.a(this.l, "ACCEPTED", true)) {
            j();
        } else if (p.a(this.l, "REJECTED", true)) {
            i();
        } else {
            l();
        }
    }

    private final void l() {
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
        private final Context f17870a;

        public c(Context context) {
            k.c(context, "signatureReuploadActivity");
            this.f17870a = context;
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
            Context context = this.f17870a;
            if (context != null) {
                SignatureReUploadActivity signatureReUploadActivity = (SignatureReUploadActivity) context;
                if (p.a(str, "SUCCESS", false)) {
                    signatureReUploadActivity.b(true);
                } else {
                    signatureReUploadActivity.j = false;
                    signatureReUploadActivity.a(false);
                }
                super.onPostExecute(str);
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.paymentsBank.chequebook.signatureupdate.view.SignatureReUploadActivity");
        }
    }

    public final void b(String str, String str2) {
        k.c(str, "s3Url");
        k.c(str2, "imageId");
        this.f17866g = str2;
        String str3 = this.f17865f;
        if (str3 == null) {
            k.a("filepath");
        }
        if (!TextUtils.isEmpty(str3)) {
            c cVar = new c(this);
            String[] strArr = new String[2];
            strArr[0] = str;
            String str4 = this.f17865f;
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
        this.p = false;
        if (z) {
            b.a f2 = f();
            String str = this.f17866g;
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
        private final Context f17869a;

        public b(Context context) {
            k.c(context, "signatureReuploadActivity");
            this.f17869a = context;
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
            if (this.f17869a == null) {
                throw new u("null cannot be cast to non-null type net.one97.paytm.paymentsBank.chequebook.signatureupdate.view.SignatureReUploadActivity");
            } else if (p.a(str, "SUCCESS", false)) {
                ((SignatureReUploadActivity) this.f17869a).k = true;
                SignatureReUploadActivity.b((SignatureReUploadActivity) this.f17869a);
            } else {
                ((SignatureReUploadActivity) this.f17869a).k = false;
            }
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        k.c(bundle, "outState");
        bundle.putString("signature", f().c());
        bundle.putString("CHEQUEBOOK_SIGNATURE_STATUS", this.l);
        super.onSaveInstanceState(bundle);
    }

    public static final /* synthetic */ void b(SignatureReUploadActivity signatureReUploadActivity) {
        String str = signatureReUploadActivity.f17865f;
        if (str == null) {
            k.a("filepath");
        }
        new File(str);
        Uri uri = signatureReUploadActivity.f17863c;
        if (uri == null) {
            k.a("selectedImage");
        }
        w.a().a(uri).a(s.NO_CACHE, new s[0]).a((ImageView) signatureReUploadActivity.a(R.id.iv_signature));
        ImageView imageView = (ImageView) signatureReUploadActivity.a(R.id.iv_signature);
        k.a((Object) imageView, "iv_signature");
        imageView.setVisibility(0);
        TextView textView = (TextView) signatureReUploadActivity.a(R.id.tv_signature_verified);
        k.a((Object) textView, "tv_signature_verified");
        net.one97.paytm.paymentsBank.chequebook.utils.b.b(textView);
        ImageView imageView2 = (ImageView) signatureReUploadActivity.a(R.id.iv_verify_icon);
        k.a((Object) imageView2, "iv_verify_icon");
        net.one97.paytm.paymentsBank.chequebook.utils.b.b(imageView2);
        signatureReUploadActivity.a(true, p.a(signatureReUploadActivity.l, "UPLOAD_PENDING", true));
        RelativeLayout relativeLayout = (RelativeLayout) signatureReUploadActivity.a(R.id.ll_btns_change_signature);
        k.a((Object) relativeLayout, "ll_btns_change_signature");
        relativeLayout.setVisibility(0);
        TextView textView2 = (TextView) signatureReUploadActivity.a(R.id.tv_authorized_sign_title);
        k.a((Object) textView2, "tv_authorized_sign_title");
        net.one97.paytm.paymentsBank.chequebook.utils.b.a(textView2);
        TextView textView3 = (TextView) signatureReUploadActivity.a(R.id.tv_authorized_sign_title);
        k.a((Object) textView3, "tv_authorized_sign_title");
        textView3.setText(signatureReUploadActivity.getString(R.string.pb_new_signature));
        RelativeLayout relativeLayout2 = (RelativeLayout) signatureReUploadActivity.a(R.id.upload_first_time_lyt);
        k.a((Object) relativeLayout2, "upload_first_time_lyt");
        relativeLayout2.setVisibility(8);
        TextView textView4 = (TextView) signatureReUploadActivity.a(R.id.tv_signa_title);
        k.a((Object) textView4, "tv_signa_title");
        textView4.setText(signatureReUploadActivity.getString(R.string.pb_signature));
        TextView textView5 = (TextView) signatureReUploadActivity.a(R.id.tv_signature_status_msg);
        k.a((Object) textView5, "tv_signature_status_msg");
        net.one97.paytm.paymentsBank.chequebook.utils.b.b(textView5);
        ImageView imageView3 = (ImageView) signatureReUploadActivity.a(R.id.iv_signature_status);
        k.a((Object) imageView3, "iv_signature_status");
        net.one97.paytm.paymentsBank.chequebook.utils.b.b(imageView3);
        TextView textView6 = (TextView) signatureReUploadActivity.a(R.id.tv_signature_status);
        k.a((Object) textView6, "tv_signature_status");
        net.one97.paytm.paymentsBank.chequebook.utils.b.b(textView6);
        TextView textView7 = (TextView) signatureReUploadActivity.a(R.id.tv_sign_msg);
        k.a((Object) textView7, "tv_sign_msg");
        net.one97.paytm.paymentsBank.chequebook.utils.b.a(textView7);
        RelativeLayout relativeLayout3 = (RelativeLayout) signatureReUploadActivity.a(R.id.ll_signature_status_cont);
        k.a((Object) relativeLayout3, "ll_signature_status_cont");
        net.one97.paytm.paymentsBank.chequebook.utils.b.b(relativeLayout3);
    }

    public static final /* synthetic */ void c(SignatureReUploadActivity signatureReUploadActivity) {
        new Intent("android.intent.action.GET_CONTENT");
        if (com.paytm.utility.s.a()) {
            Activity activity = signatureReUploadActivity;
            if (!com.paytm.utility.s.c(activity)) {
                com.paytm.utility.s.b(activity);
                return;
            }
        }
        CropImage.a().a(PBCropImageView.c.ON).a(Environment.getExternalStorageDirectory().toString() + "/Android/data/" + signatureReUploadActivity.getPackageName()).a((Activity) signatureReUploadActivity);
    }
}
