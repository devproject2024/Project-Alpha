package net.one97.paytm.paymentsBank.chequebook.signaturelanding.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.SystemClock;
import android.text.Selection;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.google.android.material.snackbar.Snackbar;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.activities.CommunityPostActivity;
import com.squareup.picasso.s;
import com.squareup.picasso.w;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.g.b.x;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.bankCommon.model.PBTncData;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.chequebook.model.CBDocumentTypeResponse;
import net.one97.paytm.paymentsBank.chequebook.model.CBGetSignatureResponse;
import net.one97.paytm.paymentsBank.chequebook.model.DocumentCreateResponse;
import net.one97.paytm.paymentsBank.chequebook.model.GetDocumentCreateResponse;
import net.one97.paytm.paymentsBank.chequebook.model.Payload;
import net.one97.paytm.paymentsBank.chequebook.model.SignatureCreateResponse;
import net.one97.paytm.paymentsBank.chequebook.orderFlow.CBorderSummaryActivity;
import net.one97.paytm.paymentsBank.chequebook.signaturelanding.a.a;
import net.one97.paytm.paymentsBank.chequebook.signatureupdate.a;
import net.one97.paytm.paymentsBank.chequebook.utils.ChequeBookBaseActivity;
import net.one97.paytm.paymentsBank.passcode.BankPasscodeActivity;
import net.one97.paytm.paymentsBank.si.c.f;
import net.one97.paytm.paymentsBank.utils.n;
import net.one97.paytm.paymentsBank.widget.croptool.CropImage;
import net.one97.paytm.paymentsBank.widget.croptool.PBCropImageView;

public final class SignatureLandingActivityV2 extends ChequeBookBaseActivity implements AdapterView.OnItemSelectedListener, Response.ErrorListener, Response.Listener<IJRPaytmDataModel>, a.b, f.a {
    private static final String L = L;

    /* renamed from: f  reason: collision with root package name */
    public static final a f17797f = new a((byte) 0);
    private String A = "";
    private int B = 10;
    private String C = "";
    private String D = "";
    private String E;
    private Boolean F = Boolean.TRUE;
    private final ArrayList<String> G = new ArrayList<>();
    private final ArrayList<String> H = new ArrayList<>();
    private final HashMap<String, Payload> I = new HashMap<>();
    private boolean J;
    private boolean K;
    private HashMap M;

    /* renamed from: a  reason: collision with root package name */
    long f17798a;

    /* renamed from: b  reason: collision with root package name */
    public String f17799b;

    /* renamed from: c  reason: collision with root package name */
    public String f17800c;

    /* renamed from: d  reason: collision with root package name */
    public a.C0285a f17801d;

    /* renamed from: e  reason: collision with root package name */
    public Uri f17802e;

    /* renamed from: g  reason: collision with root package name */
    private final int f17803g = 701;

    /* renamed from: h  reason: collision with root package name */
    private final int f17804h = 702;

    /* renamed from: i  reason: collision with root package name */
    private final int f17805i = 703;
    private final String j = "SignatureLandingActivity";
    private String k;
    private String l;
    private String m;
    /* access modifiers changed from: private */
    public boolean n;
    /* access modifiers changed from: private */
    public boolean o;
    private Boolean p;
    private boolean q;
    private boolean r;
    private ArrayList<PBTncData> s = new ArrayList<>();
    private boolean t;
    private int u = 1;
    private int v = 1;
    private CBDocumentTypeResponse w;
    /* access modifiers changed from: private */
    public int x;
    private boolean y;
    private net.one97.paytm.paymentsBank.chequebook.signatureupdate.a z;

    public final View a(int i2) {
        if (this.M == null) {
            this.M = new HashMap();
        }
        View view = (View) this.M.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.M.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void onNothingSelected(AdapterView<?> adapterView) {
    }

    public final /* synthetic */ void onResponse(Object obj) {
        SignatureCreateResponse.Payload payload;
        List<Object> supportDocuments;
        IJRPaytmDataModel iJRPaytmDataModel = (IJRPaytmDataModel) obj;
        if (iJRPaytmDataModel != null) {
            if (iJRPaytmDataModel instanceof SignatureCreateResponse) {
                SignatureCreateResponse signatureCreateResponse = (SignatureCreateResponse) iJRPaytmDataModel;
                String status = signatureCreateResponse.getStatus();
                net.one97.paytm.paymentsBank.chequebook.utils.e eVar = net.one97.paytm.paymentsBank.chequebook.utils.e.f17951a;
                if (p.a(status, net.one97.paytm.paymentsBank.chequebook.utils.e.P(), true) && signatureCreateResponse.getPayload() != null) {
                    SignatureCreateResponse.Payload payload2 = signatureCreateResponse.getPayload();
                    if (payload2 == null) {
                        kotlin.g.b.k.a();
                    }
                    String imageId = payload2.getImageId();
                    if (imageId == null) {
                        kotlin.g.b.k.a();
                    }
                    this.l = imageId;
                    c(true);
                    Uri uri = this.f17802e;
                    if (uri == null) {
                        kotlin.g.b.k.a("selectedImage");
                    }
                    a(uri);
                    this.o = false;
                    try {
                        SignatureCreateResponse.Payload payload3 = ((SignatureCreateResponse) iJRPaytmDataModel).getPayload();
                        if ((payload3 != null ? payload3.getSupportDocuments() : null) == null || !((payload = ((SignatureCreateResponse) iJRPaytmDataModel).getPayload()) == null || (supportDocuments = payload.getSupportDocuments()) == null || supportDocuments.size() != 0)) {
                            j();
                            i();
                        }
                    } catch (Exception unused) {
                        j();
                        i();
                    }
                }
            } else if (iJRPaytmDataModel instanceof DocumentCreateResponse) {
                DocumentCreateResponse documentCreateResponse = (DocumentCreateResponse) iJRPaytmDataModel;
                String status2 = documentCreateResponse.getStatus();
                net.one97.paytm.paymentsBank.chequebook.utils.e eVar2 = net.one97.paytm.paymentsBank.chequebook.utils.e.f17951a;
                if (p.a(status2, net.one97.paytm.paymentsBank.chequebook.utils.e.P(), true) && documentCreateResponse.getPayload() != null) {
                    net.one97.paytm.paymentsBank.chequebook.signatureupdate.a aVar = this.z;
                    if (aVar == null) {
                        kotlin.g.b.k.a("uploadedDocumentAdapter");
                    }
                    aVar.a(documentCreateResponse.getPayload());
                    i();
                }
            }
        }
        a(false);
    }

    static final class l implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SignatureLandingActivityV2 f17819a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.paytm.utility.h f17820b;

        l(SignatureLandingActivityV2 signatureLandingActivityV2, com.paytm.utility.h hVar) {
            this.f17819a = signatureLandingActivityV2;
            this.f17820b = hVar;
        }

        public final void onClick(View view) {
            this.f17820b.cancel();
            this.f17819a.setResult(-1);
            this.f17819a.finish();
        }
    }

    public final void b(String str, String str2) {
        kotlin.g.b.k.c(str, "errorTitle");
        kotlin.g.b.k.c(str2, ImagePickerUtils.IMAGE_PICKER_KEY_ERROR_MESSAGE);
        com.paytm.utility.b.b((Context) this, str, str2);
    }

    public final void a(String str) {
        if (TextUtils.isEmpty(str)) {
            com.paytm.utility.b.b((Context) this, "Error!", getString(R.string.cb_generic_error));
            return;
        }
        Intent intent = new Intent(this, CBorderSummaryActivity.class);
        intent.putExtra("order_id", str);
        intent.putExtra("cheque_book_amount", this.A);
        startActivity(intent);
        setResult(-1);
        finish();
    }

    public final void a(boolean z2) {
        if (z2) {
            String string = getString(R.string.please_wait);
            kotlin.g.b.k.a((Object) string, "getString(R.string.please_wait)");
            a(this, string);
            return;
        }
        h();
    }

    public final a.C0285a f() {
        a.C0285a aVar = this.f17801d;
        if (aVar == null) {
            kotlin.g.b.k.a("presenter");
        }
        return aVar;
    }

    public final int a() {
        return R.layout.pb_upload_signature;
    }

    public final void a(ArrayList<PBTncData> arrayList) {
        kotlin.g.b.k.c(arrayList, "tncList");
        this.s = arrayList;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00db, code lost:
        if (r8 == null) goto L_0x00dd;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onCreate(android.os.Bundle r8) {
        /*
            r7 = this;
            super.onCreate(r8)
            java.lang.String r8 = L
            r7.f17800c = r8
            net.one97.paytm.paymentsBank.chequebook.signaturelanding.b.a r8 = new net.one97.paytm.paymentsBank.chequebook.signaturelanding.b.a
            net.one97.paytm.paymentsBank.chequebook.utils.d r0 = net.one97.paytm.paymentsBank.chequebook.utils.d.f17950a
            android.content.Context r0 = r7.getApplicationContext()
            java.lang.String r1 = "applicationContext"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            net.one97.paytm.paymentsBank.chequebook.utils.g r0 = net.one97.paytm.paymentsBank.chequebook.utils.d.a(r0)
            r1 = r7
            net.one97.paytm.paymentsBank.chequebook.signaturelanding.a.a$b r1 = (net.one97.paytm.paymentsBank.chequebook.signaturelanding.a.a.b) r1
            android.content.Context r2 = r7.getBaseContext()
            java.lang.String r3 = "baseContext"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            r8.<init>(r0, r1, r2)
            net.one97.paytm.paymentsBank.chequebook.signaturelanding.a.a$a r8 = (net.one97.paytm.paymentsBank.chequebook.signaturelanding.a.a.C0285a) r8
            java.lang.String r0 = "<set-?>"
            kotlin.g.b.k.c(r8, r0)
            r7.f17801d = r8
            android.content.Intent r8 = r7.getIntent()
            if (r8 == 0) goto L_0x004c
            android.content.Intent r8 = r7.getIntent()
            java.lang.String r0 = "CHEQUEBOOK_SIGNATURE_STATUS"
            boolean r8 = r8.hasExtra(r0)
            if (r8 == 0) goto L_0x004c
            android.content.Intent r8 = r7.getIntent()
            java.lang.String r8 = r8.getStringExtra(r0)
            r7.E = r8
        L_0x004c:
            android.content.Intent r8 = r7.getIntent()
            r0 = 1
            if (r8 == 0) goto L_0x006d
            android.content.Intent r8 = r7.getIntent()
            java.lang.String r1 = "is_first_time_user"
            boolean r8 = r8.hasExtra(r1)
            if (r8 == 0) goto L_0x006d
            android.content.Intent r8 = r7.getIntent()
            boolean r8 = r8.getBooleanExtra(r1, r0)
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r8)
            r7.F = r8
        L_0x006d:
            android.content.Intent r8 = r7.getIntent()
            r1 = 0
            r2 = 0
            if (r8 == 0) goto L_0x0084
            net.one97.paytm.paymentsBank.chequebook.utils.e r3 = net.one97.paytm.paymentsBank.chequebook.utils.e.f17951a
            java.lang.String r3 = net.one97.paytm.paymentsBank.chequebook.utils.e.c()
            boolean r8 = r8.getBooleanExtra(r3, r2)
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r8)
            goto L_0x0085
        L_0x0084:
            r8 = r1
        L_0x0085:
            r7.p = r8
            android.content.Intent r8 = r7.getIntent()
            if (r8 == 0) goto L_0x0094
            java.lang.String r3 = "EXTRA_IS_SIGN_UPDATE_LOW"
            boolean r8 = r8.getBooleanExtra(r3, r2)
            goto L_0x0095
        L_0x0094:
            r8 = 0
        L_0x0095:
            r7.q = r8
            android.content.Intent r8 = r7.getIntent()
            java.lang.String r3 = ""
            if (r8 == 0) goto L_0x00a7
            java.lang.String r4 = "transaction_amount"
            java.lang.String r8 = r8.getStringExtra(r4)
            if (r8 != 0) goto L_0x00a8
        L_0x00a7:
            r8 = r3
        L_0x00a8:
            r7.A = r8
            android.content.Intent r8 = r7.getIntent()
            r4 = 10
            if (r8 == 0) goto L_0x00b8
            java.lang.String r5 = "leaves_extra"
            int r4 = r8.getIntExtra(r5, r4)
        L_0x00b8:
            r7.B = r4
            android.content.Intent r8 = r7.getIntent()
            if (r8 == 0) goto L_0x00c8
            java.lang.String r4 = "passcode_extra"
            java.lang.String r8 = r8.getStringExtra(r4)
            if (r8 != 0) goto L_0x00c9
        L_0x00c8:
            r8 = r3
        L_0x00c9:
            r7.C = r8
            android.content.Intent r8 = r7.getIntent()
            if (r8 == 0) goto L_0x00dd
            net.one97.paytm.paymentsBank.chequebook.utils.e r4 = net.one97.paytm.paymentsBank.chequebook.utils.e.f17951a
            java.lang.String r4 = net.one97.paytm.paymentsBank.chequebook.utils.e.v()
            java.lang.String r8 = r8.getStringExtra(r4)
            if (r8 != 0) goto L_0x00de
        L_0x00dd:
            r8 = r3
        L_0x00de:
            r7.D = r8
            net.one97.paytm.paymentsBank.chequebook.signaturelanding.a.a$a r8 = r7.f()
            boolean r8 = r8 instanceof net.one97.paytm.paymentsBank.chequebook.signaturelanding.b.a
            if (r8 == 0) goto L_0x0103
            net.one97.paytm.paymentsBank.chequebook.signaturelanding.a.a$a r8 = r7.f()
            java.lang.String r3 = r7.E
            r8.b((java.lang.String) r3)
            net.one97.paytm.paymentsBank.chequebook.signaturelanding.a.a$a r8 = r7.f()
            java.lang.Boolean r3 = r7.F
            if (r3 != 0) goto L_0x00fc
            kotlin.g.b.k.a()
        L_0x00fc:
            boolean r3 = r3.booleanValue()
            r8.a((boolean) r3)
        L_0x0103:
            boolean r8 = r7.q
            java.lang.String r3 = "tv_proceed_payment"
            if (r8 == 0) goto L_0x0120
            int r8 = net.one97.paytm.paymentsBank.R.id.tv_proceed_payment
            android.view.View r8 = r7.a((int) r8)
            android.widget.TextView r8 = (android.widget.TextView) r8
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r3)
            int r3 = net.one97.paytm.paymentsBank.R.string.submit
            java.lang.String r3 = r7.getString(r3)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r8.setText(r3)
            goto L_0x013c
        L_0x0120:
            int r8 = net.one97.paytm.paymentsBank.R.id.tv_proceed_payment
            android.view.View r8 = r7.a((int) r8)
            android.widget.TextView r8 = (android.widget.TextView) r8
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r3)
            int r3 = net.one97.paytm.paymentsBank.R.string.pdc_proceed_to_pay_rupee
            java.lang.Object[] r4 = new java.lang.Object[r0]
            java.lang.String r5 = r7.A
            r4[r2] = r5
            java.lang.String r3 = r7.getString(r3, r4)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r8.setText(r3)
        L_0x013c:
            int r8 = net.one97.paytm.paymentsBank.R.id.tv_change_signature
            android.view.View r8 = r7.a((int) r8)
            android.widget.TextView r8 = (android.widget.TextView) r8
            net.one97.paytm.paymentsBank.chequebook.signaturelanding.view.SignatureLandingActivityV2$c r3 = new net.one97.paytm.paymentsBank.chequebook.signaturelanding.view.SignatureLandingActivityV2$c
            r3.<init>(r7)
            android.view.View$OnClickListener r3 = (android.view.View.OnClickListener) r3
            r8.setOnClickListener(r3)
            int r8 = net.one97.paytm.paymentsBank.R.id.rl_upload_sign
            android.view.View r8 = r7.a((int) r8)
            android.widget.LinearLayout r8 = (android.widget.LinearLayout) r8
            net.one97.paytm.paymentsBank.chequebook.signaturelanding.view.SignatureLandingActivityV2$d r3 = new net.one97.paytm.paymentsBank.chequebook.signaturelanding.view.SignatureLandingActivityV2$d
            r3.<init>(r7)
            android.view.View$OnClickListener r3 = (android.view.View.OnClickListener) r3
            r8.setOnClickListener(r3)
            int r8 = net.one97.paytm.paymentsBank.R.id.btn_upload_signature
            android.view.View r8 = r7.a((int) r8)
            android.widget.RelativeLayout r8 = (android.widget.RelativeLayout) r8
            net.one97.paytm.paymentsBank.chequebook.signaturelanding.view.SignatureLandingActivityV2$e r3 = new net.one97.paytm.paymentsBank.chequebook.signaturelanding.view.SignatureLandingActivityV2$e
            r3.<init>(r7)
            android.view.View$OnClickListener r3 = (android.view.View.OnClickListener) r3
            r8.setOnClickListener(r3)
            int r8 = net.one97.paytm.paymentsBank.R.id.rl_upload_document
            android.view.View r8 = r7.a((int) r8)
            android.widget.RelativeLayout r8 = (android.widget.RelativeLayout) r8
            net.one97.paytm.paymentsBank.chequebook.signaturelanding.view.SignatureLandingActivityV2$f r3 = new net.one97.paytm.paymentsBank.chequebook.signaturelanding.view.SignatureLandingActivityV2$f
            r3.<init>(r7)
            android.view.View$OnClickListener r3 = (android.view.View.OnClickListener) r3
            r8.setOnClickListener(r3)
            int r8 = net.one97.paytm.paymentsBank.R.id.btn_upload_more
            android.view.View r8 = r7.a((int) r8)
            android.widget.TextView r8 = (android.widget.TextView) r8
            net.one97.paytm.paymentsBank.chequebook.signaturelanding.view.SignatureLandingActivityV2$g r3 = new net.one97.paytm.paymentsBank.chequebook.signaturelanding.view.SignatureLandingActivityV2$g
            r3.<init>(r7)
            android.view.View$OnClickListener r3 = (android.view.View.OnClickListener) r3
            r8.setOnClickListener(r3)
            int r8 = net.one97.paytm.paymentsBank.R.id.tv_proceed_payment
            android.view.View r8 = r7.a((int) r8)
            android.widget.TextView r8 = (android.widget.TextView) r8
            net.one97.paytm.paymentsBank.chequebook.signaturelanding.view.SignatureLandingActivityV2$h r3 = new net.one97.paytm.paymentsBank.chequebook.signaturelanding.view.SignatureLandingActivityV2$h
            r3.<init>(r7)
            android.view.View$OnClickListener r3 = (android.view.View.OnClickListener) r3
            r8.setOnClickListener(r3)
            int r8 = net.one97.paytm.paymentsBank.R.id.iv_header_back
            android.view.View r8 = r7.a((int) r8)
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            net.one97.paytm.paymentsBank.chequebook.signaturelanding.view.SignatureLandingActivityV2$i r3 = new net.one97.paytm.paymentsBank.chequebook.signaturelanding.view.SignatureLandingActivityV2$i
            r3.<init>(r7)
            android.view.View$OnClickListener r3 = (android.view.View.OnClickListener) r3
            r8.setOnClickListener(r3)
            r7.c((boolean) r2)
            net.one97.paytm.paymentsBank.chequebook.signatureupdate.a r8 = new net.one97.paytm.paymentsBank.chequebook.signatureupdate.a
            r3 = r7
            android.content.Context r3 = (android.content.Context) r3
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            net.one97.paytm.paymentsBank.chequebook.signaturelanding.view.SignatureLandingActivityV2$j r5 = new net.one97.paytm.paymentsBank.chequebook.signaturelanding.view.SignatureLandingActivityV2$j
            r5.<init>(r7)
            net.one97.paytm.paymentsBank.chequebook.signatureupdate.a$b r5 = (net.one97.paytm.paymentsBank.chequebook.signatureupdate.a.b) r5
            r8.<init>(r3, r4, r5)
            r7.z = r8
            int r8 = net.one97.paytm.paymentsBank.R.id.rv_document_holder
            android.view.View r8 = r7.a((int) r8)
            androidx.recyclerview.widget.RecyclerView r8 = (androidx.recyclerview.widget.RecyclerView) r8
            net.one97.paytm.paymentsBank.chequebook.signatureupdate.a r3 = r7.z
            if (r3 != 0) goto L_0x01e4
            java.lang.String r4 = "uploadedDocumentAdapter"
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x01e4:
            androidx.recyclerview.widget.RecyclerView$a r3 = (androidx.recyclerview.widget.RecyclerView.a) r3
            r8.setAdapter(r3)
            androidx.recyclerview.widget.LinearLayoutManager r3 = new androidx.recyclerview.widget.LinearLayoutManager
            java.lang.String r4 = "this"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r4)
            android.content.Context r4 = r8.getContext()
            r3.<init>(r4)
            androidx.recyclerview.widget.RecyclerView$LayoutManager r3 = (androidx.recyclerview.widget.RecyclerView.LayoutManager) r3
            r8.setLayoutManager(r3)
            r3 = 8
            r8.setVisibility(r3)
            java.lang.Boolean r8 = r7.F
            java.lang.Boolean r4 = java.lang.Boolean.TRUE
            boolean r8 = kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.Object) r4)
            if (r8 == 0) goto L_0x0219
            int r8 = net.one97.paytm.paymentsBank.R.id.tv_signature_footer
            android.view.View r8 = r7.a((int) r8)
            android.widget.TextView r8 = (android.widget.TextView) r8
            if (r8 == 0) goto L_0x0226
            r8.setVisibility(r2)
            goto L_0x0226
        L_0x0219:
            int r8 = net.one97.paytm.paymentsBank.R.id.tv_signature_footer
            android.view.View r8 = r7.a((int) r8)
            android.widget.TextView r8 = (android.widget.TextView) r8
            if (r8 == 0) goto L_0x0226
            r8.setVisibility(r3)
        L_0x0226:
            net.one97.paytm.paymentsBank.chequebook.signaturelanding.a.a$a r8 = r7.f()
            if (r8 == 0) goto L_0x0230
            net.one97.paytm.paymentsBank.chequebook.utils.f$a$a r1 = r8.g()
        L_0x0230:
            if (r1 != 0) goto L_0x0233
            return
        L_0x0233:
            int[] r8 = net.one97.paytm.paymentsBank.chequebook.signaturelanding.view.a.f17821a
            int r1 = r1.ordinal()
            r8 = r8[r1]
            if (r8 == r0) goto L_0x0298
            r0 = 2
            if (r8 == r0) goto L_0x026e
            r0 = 3
            if (r8 == r0) goto L_0x0244
            goto L_0x026d
        L_0x0244:
            int r8 = net.one97.paytm.paymentsBank.R.id.tv_proceed_payment
            android.view.View r8 = r7.a((int) r8)
            android.widget.TextView r8 = (android.widget.TextView) r8
            if (r8 == 0) goto L_0x0259
            int r0 = net.one97.paytm.paymentsBank.R.string.pb_cb_retry_submit
            java.lang.String r0 = r7.getString(r0)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r8.setText(r0)
        L_0x0259:
            int r8 = net.one97.paytm.paymentsBank.R.id.tv_terms_and_condition
            android.view.View r8 = r7.a((int) r8)
            android.widget.TextView r8 = (android.widget.TextView) r8
            if (r8 == 0) goto L_0x0266
            r8.setVisibility(r3)
        L_0x0266:
            net.one97.paytm.paymentsBank.chequebook.signaturelanding.a.a$a r8 = r7.f()
            r8.a()
        L_0x026d:
            return
        L_0x026e:
            int r8 = net.one97.paytm.paymentsBank.R.id.tv_proceed_payment
            android.view.View r8 = r7.a((int) r8)
            android.widget.TextView r8 = (android.widget.TextView) r8
            if (r8 == 0) goto L_0x0283
            int r0 = net.one97.paytm.paymentsBank.R.string.pb_cb_retry_submit
            java.lang.String r0 = r7.getString(r0)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r8.setText(r0)
        L_0x0283:
            int r8 = net.one97.paytm.paymentsBank.R.id.tv_terms_and_condition
            android.view.View r8 = r7.a((int) r8)
            android.widget.TextView r8 = (android.widget.TextView) r8
            if (r8 == 0) goto L_0x0290
            r8.setVisibility(r3)
        L_0x0290:
            net.one97.paytm.paymentsBank.chequebook.signaturelanding.a.a$a r8 = r7.f()
            r8.a()
            return
        L_0x0298:
            int r8 = net.one97.paytm.paymentsBank.R.string.pdc_proceed_agree
            java.lang.String r8 = r7.getString(r8)
            int r0 = net.one97.paytm.paymentsBank.R.string.pdc_tnc
            java.lang.String r0 = r7.getString(r0)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r8)
            java.lang.String r8 = " "
            r1.append(r8)
            r1.append(r0)
            java.lang.String r8 = r1.toString()
            kotlin.g.b.x$e r1 = new kotlin.g.b.x$e
            r1.<init>()
            android.text.SpannableString r3 = new android.text.SpannableString
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            r3.<init>(r8)
            r1.element = r3
            net.one97.paytm.paymentsBank.chequebook.signaturelanding.view.SignatureLandingActivityV2$k r3 = new net.one97.paytm.paymentsBank.chequebook.signaturelanding.view.SignatureLandingActivityV2$k
            r3.<init>(r7, r1)
            T r4 = r1.element
            android.text.SpannableString r4 = (android.text.SpannableString) r4
            java.lang.String r5 = "tncStr"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r5)
            r5 = 6
            int r6 = kotlin.m.p.a((java.lang.CharSequence) r8, (java.lang.String) r0, (int) r2, (boolean) r2, (int) r5)
            int r8 = kotlin.m.p.a((java.lang.CharSequence) r8, (java.lang.String) r0, (int) r2, (boolean) r2, (int) r5)
            int r0 = r0.length()
            int r8 = r8 + r0
            r0 = 33
            r4.setSpan(r3, r6, r8, r0)
            int r8 = net.one97.paytm.paymentsBank.R.id.tv_terms_and_condition
            android.view.View r8 = r7.a((int) r8)
            android.widget.TextView r8 = (android.widget.TextView) r8
            java.lang.String r0 = "tv_terms_and_condition"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r0)
            T r3 = r1.element
            android.text.SpannableString r3 = (android.text.SpannableString) r3
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r8.setText(r3)
            int r8 = net.one97.paytm.paymentsBank.R.id.tv_terms_and_condition
            android.view.View r8 = r7.a((int) r8)
            android.widget.TextView r8 = (android.widget.TextView) r8
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r0)
            android.text.method.MovementMethod r3 = android.text.method.LinkMovementMethod.getInstance()
            r8.setMovementMethod(r3)
            int r8 = net.one97.paytm.paymentsBank.R.id.tv_terms_and_condition
            android.view.View r8 = r7.a((int) r8)
            android.widget.TextView r8 = (android.widget.TextView) r8
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r0)
            T r0 = r1.element
            android.text.SpannableString r0 = (android.text.SpannableString) r0
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r8.setText(r0)
            net.one97.paytm.paymentsBank.chequebook.signaturelanding.a.a$a r8 = r7.f()
            if (r8 == 0) goto L_0x032c
            r8.b((boolean) r2)
        L_0x032c:
            int r8 = net.one97.paytm.paymentsBank.R.id.tv_terms_and_condition
            android.view.View r8 = r7.a((int) r8)
            android.widget.TextView r8 = (android.widget.TextView) r8
            if (r8 == 0) goto L_0x0339
            r8.setVisibility(r2)
        L_0x0339:
            net.one97.paytm.paymentsBank.chequebook.signaturelanding.a.a$a r8 = r7.f()
            r8.a()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.paymentsBank.chequebook.signaturelanding.view.SignatureLandingActivityV2.onCreate(android.os.Bundle):void");
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SignatureLandingActivityV2 f17809a;

        c(SignatureLandingActivityV2 signatureLandingActivityV2) {
            this.f17809a = signatureLandingActivityV2;
        }

        public final void onClick(View view) {
            this.f17809a.a(true, Boolean.TRUE);
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SignatureLandingActivityV2 f17810a;

        d(SignatureLandingActivityV2 signatureLandingActivityV2) {
            this.f17810a = signatureLandingActivityV2;
        }

        public final void onClick(View view) {
            this.f17810a.a(true, Boolean.FALSE);
        }
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SignatureLandingActivityV2 f17811a;

        e(SignatureLandingActivityV2 signatureLandingActivityV2) {
            this.f17811a = signatureLandingActivityV2;
        }

        public final void onClick(View view) {
            this.f17811a.a(true, Boolean.FALSE);
        }
    }

    static final class f implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SignatureLandingActivityV2 f17812a;

        f(SignatureLandingActivityV2 signatureLandingActivityV2) {
            this.f17812a = signatureLandingActivityV2;
        }

        public final void onClick(View view) {
            this.f17812a.a(false, Boolean.FALSE);
        }
    }

    static final class g implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SignatureLandingActivityV2 f17813a;

        g(SignatureLandingActivityV2 signatureLandingActivityV2) {
            this.f17813a = signatureLandingActivityV2;
        }

        public final void onClick(View view) {
            this.f17813a.a(false, Boolean.FALSE);
        }
    }

    static final class h implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SignatureLandingActivityV2 f17814a;

        h(SignatureLandingActivityV2 signatureLandingActivityV2) {
            this.f17814a = signatureLandingActivityV2;
        }

        public final void onClick(View view) {
            if (SystemClock.elapsedRealtime() - this.f17814a.f17798a >= 1000) {
                this.f17814a.f17798a = SystemClock.elapsedRealtime();
                ImageView imageView = (ImageView) this.f17814a.a(R.id.iv_signature);
                kotlin.g.b.k.a((Object) imageView, "iv_signature");
                if (imageView.getVisibility() == 0 && this.f17814a.n && this.f17814a.o && SignatureLandingActivityV2.e(this.f17814a)) {
                    this.f17814a.f().c();
                } else if (!this.f17814a.n) {
                    Snackbar.a((View) (RelativeLayout) this.f17814a.a(R.id.sign_upload_main_parent_lyt), (CharSequence) this.f17814a.getString(R.string.pb_cb_please_upload_sign), -1).c();
                } else {
                    Snackbar.a((View) (RelativeLayout) this.f17814a.a(R.id.sign_upload_main_parent_lyt), (CharSequence) this.f17814a.getString(R.string.pb_cb_please_upload_document), -1).c();
                }
            }
        }
    }

    static final class i implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SignatureLandingActivityV2 f17815a;

        i(SignatureLandingActivityV2 signatureLandingActivityV2) {
            this.f17815a = signatureLandingActivityV2;
        }

        public final void onClick(View view) {
            this.f17815a.onBackPressed();
        }
    }

    static final class j implements a.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SignatureLandingActivityV2 f17816a;

        j(SignatureLandingActivityV2 signatureLandingActivityV2) {
            this.f17816a = signatureLandingActivityV2;
        }

        public final void a(String str, int i2) {
            kotlin.g.b.k.c(str, "documentId");
            SignatureLandingActivityV2.a(this.f17816a, str);
            this.f17816a.x = i2;
        }
    }

    public static final class k extends ClickableSpan {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SignatureLandingActivityV2 f17817a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x.e f17818b;

        k(SignatureLandingActivityV2 signatureLandingActivityV2, x.e eVar) {
            this.f17817a = signatureLandingActivityV2;
            this.f17818b = eVar;
        }

        public final void onClick(View view) {
            kotlin.g.b.k.c(view, "widget");
            Selection.setSelection((SpannableString) this.f17818b.element, 0);
            this.f17817a.f().b(true);
        }

        public final void updateDrawState(TextPaint textPaint) {
            kotlin.g.b.k.c(textPaint, "ds");
            super.updateDrawState(textPaint);
            textPaint.setUnderlineText(false);
            textPaint.setColor(androidx.core.content.b.c(this.f17817a, R.color.paytm_blue));
        }
    }

    public final void b(ArrayList<PBTncData> arrayList) {
        kotlin.g.b.k.c(arrayList, "mTncDataList");
        Context context = this;
        if (!net.one97.paytm.bankCommon.mapping.a.c(context)) {
            com.paytm.utility.b.b(context, getString(R.string.network_error_heading), getString(R.string.pb_check_your_network));
        } else if (arrayList.size() > 0) {
            net.one97.paytm.paymentsBank.si.c.f a2 = net.one97.paytm.paymentsBank.si.c.f.a(arrayList);
            a2.a((f.a) this);
            a2.show(getSupportFragmentManager(), "tncFragment");
        }
    }

    public final void g() {
        f().c(false);
    }

    public final void a(CBDocumentTypeResponse cBDocumentTypeResponse) {
        String description;
        String name;
        kotlin.g.b.k.c(cBDocumentTypeResponse, com.appsflyer.internal.referrer.Payload.RESPONSE);
        this.w = cBDocumentTypeResponse;
        this.G.add(L);
        this.H.add(L);
        Integer num = null;
        this.I.put(L, (Object) null);
        List<Payload> payload = cBDocumentTypeResponse.getPayload();
        if (payload != null) {
            for (Payload next : payload) {
                if (!(next == null || (name = next.getName()) == null)) {
                    this.G.add(name);
                    this.I.put(name, next);
                }
                if (!(next == null || (description = next.getDescription()) == null)) {
                    this.H.add(description);
                }
            }
        }
        ArrayList<String> arrayList = this.H;
        if (arrayList != null) {
            if (arrayList != null) {
                num = Integer.valueOf(arrayList.size());
            }
            if (num.intValue() > 0) {
                Spinner spinner = (Spinner) a(R.id.spinner);
                if (spinner != null) {
                    spinner.setVisibility(0);
                }
                ArrayAdapter arrayAdapter = new ArrayAdapter(this, 17367048, this.H);
                arrayAdapter.setDropDownViewResource(R.layout.custom_simple_spinner_dropdown_item);
                Spinner spinner2 = (Spinner) a(R.id.spinner);
                kotlin.g.b.k.a((Object) spinner2, "spinner");
                spinner2.setAdapter(arrayAdapter);
                Spinner spinner3 = (Spinner) a(R.id.spinner);
                kotlin.g.b.k.a((Object) spinner3, "spinner");
                spinner3.setOnItemSelectedListener(this);
            }
        }
    }

    public final void d() {
        c(false);
        b(false);
    }

    public final void a(Boolean bool) {
        Integer num;
        if (bool == null || bool.booleanValue()) {
            this.J = true;
            String str = this.f17800c;
            if (str == null) {
                kotlin.g.b.k.a("prevSelectedDocumentType");
            }
            if (!TextUtils.isEmpty(str)) {
                ArrayList<String> arrayList = this.G;
                if (arrayList != null) {
                    String str2 = this.f17800c;
                    if (str2 == null) {
                        kotlin.g.b.k.a("prevSelectedDocumentType");
                    }
                    if (arrayList.indexOf(str2) == -1) {
                        return;
                    }
                }
                Spinner spinner = (Spinner) a(R.id.spinner);
                if (spinner != null) {
                    ArrayList<String> arrayList2 = this.G;
                    if (arrayList2 != null) {
                        String str3 = this.f17800c;
                        if (str3 == null) {
                            kotlin.g.b.k.a("prevSelectedDocumentType");
                        }
                        num = Integer.valueOf(arrayList2.indexOf(str3));
                    } else {
                        num = null;
                    }
                    spinner.setSelection(num.intValue());
                    return;
                }
                return;
            }
            return;
        }
        net.one97.paytm.paymentsBank.chequebook.signatureupdate.a aVar = this.z;
        if (aVar == null) {
            kotlin.g.b.k.a("uploadedDocumentAdapter");
        }
        if (aVar != null) {
            aVar.a();
        }
        i();
    }

    public final void a(CBGetSignatureResponse cBGetSignatureResponse) {
        kotlin.g.b.k.c(cBGetSignatureResponse, com.appsflyer.internal.referrer.Payload.RESPONSE);
        if (cBGetSignatureResponse.getPayload() != null) {
            List<CBGetSignatureResponse.Payload> payload = cBGetSignatureResponse.getPayload();
            List<Payload> list = null;
            Integer valueOf = payload != null ? Integer.valueOf(payload.size()) : null;
            if (valueOf == null) {
                kotlin.g.b.k.a();
            }
            if (valueOf.intValue() > 0) {
                List<CBGetSignatureResponse.Payload> payload2 = cBGetSignatureResponse.getPayload();
                if (payload2 == null) {
                    kotlin.g.b.k.a();
                }
                CBGetSignatureResponse.Payload payload3 = payload2.get(0);
                String imageId = payload3 != null ? payload3.getImageId() : null;
                if (TextUtils.isEmpty(imageId)) {
                    b(false);
                } else {
                    if (imageId == null) {
                        kotlin.g.b.k.a();
                    }
                    this.l = imageId;
                    a.C0285a f2 = f();
                    if (f2 != null) {
                        f2.a(this.l);
                    }
                    b(false);
                    c(true);
                }
                List<CBGetSignatureResponse.Payload> payload4 = cBGetSignatureResponse.getPayload();
                if (payload4 == null) {
                    kotlin.g.b.k.a();
                }
                if (payload4.get(0).getSupportDocuments() != null) {
                    List<CBGetSignatureResponse.Payload> payload5 = cBGetSignatureResponse.getPayload();
                    if (payload5 == null) {
                        kotlin.g.b.k.a();
                    }
                    List<DocumentCreateResponse.Payload> supportDocuments = payload5.get(0).getSupportDocuments();
                    Integer valueOf2 = supportDocuments != null ? Integer.valueOf(supportDocuments.size()) : null;
                    if (valueOf2 == null) {
                        kotlin.g.b.k.a();
                    }
                    if (valueOf2.intValue() > 0) {
                        List<CBGetSignatureResponse.Payload> payload6 = cBGetSignatureResponse.getPayload();
                        if (payload6 == null) {
                            kotlin.g.b.k.a();
                        }
                        if (payload6.get(0).getDocumentTypeName() != null) {
                            net.one97.paytm.paymentsBank.chequebook.signatureupdate.a aVar = this.z;
                            if (aVar == null) {
                                kotlin.g.b.k.a("uploadedDocumentAdapter");
                            }
                            List<CBGetSignatureResponse.Payload> payload7 = cBGetSignatureResponse.getPayload();
                            if (payload7 == null) {
                                kotlin.g.b.k.a();
                            }
                            ArrayList arrayList = (ArrayList) payload7.get(0).getSupportDocuments();
                            if (arrayList == null) {
                                kotlin.g.b.k.a();
                            }
                            aVar.a((ArrayList<DocumentCreateResponse.Payload>) arrayList);
                            this.y = true;
                            CBDocumentTypeResponse cBDocumentTypeResponse = this.w;
                            if (cBDocumentTypeResponse != null) {
                                list = cBDocumentTypeResponse.getPayload();
                            }
                            if (list == null) {
                                kotlin.g.b.k.a();
                            }
                            for (Payload next : list) {
                                String name = next.getName();
                                Spinner spinner = (Spinner) a(R.id.spinner);
                                kotlin.g.b.k.a((Object) spinner, "spinner");
                                if (p.a(name, spinner.getSelectedItem().toString(), false)) {
                                    Integer minimumPage = next.getMinimumPage();
                                    if (minimumPage == null) {
                                        kotlin.g.b.k.a();
                                    }
                                    this.u = minimumPage.intValue();
                                    Integer maximumPage = next.getMaximumPage();
                                    if (maximumPage == null) {
                                        kotlin.g.b.k.a();
                                    }
                                    this.v = maximumPage.intValue();
                                    return;
                                }
                                this.J = true;
                                Spinner spinner2 = (Spinner) a(R.id.spinner);
                                List list2 = this.G;
                                List<CBGetSignatureResponse.Payload> payload8 = cBGetSignatureResponse.getPayload();
                                if (payload8 == null) {
                                    kotlin.g.b.k.a();
                                }
                                spinner2.setSelection(kotlin.a.k.a(list2, payload8.get(0).getDocumentTypeName()));
                            }
                        }
                    }
                }
            }
        }
    }

    public final void c(String str) {
        System.out.println("imageUrll===".concat(String.valueOf(str)));
        if (!TextUtils.isEmpty(str)) {
            a(Uri.parse(str));
        }
    }

    public final void a(GetDocumentCreateResponse getDocumentCreateResponse) {
        kotlin.g.b.k.c(getDocumentCreateResponse, "documentCreateResponse");
        System.out.println("response===".concat(String.valueOf(getDocumentCreateResponse)));
        net.one97.paytm.paymentsBank.chequebook.signatureupdate.a aVar = this.z;
        if (aVar == null) {
            kotlin.g.b.k.a("uploadedDocumentAdapter");
        }
        ArrayList arrayList = (ArrayList) getDocumentCreateResponse.getPayload();
        if (arrayList == null) {
            kotlin.g.b.k.a();
        }
        aVar.b(arrayList);
        i();
    }

    public final void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j2) {
        a.C0285a f2;
        if (i2 == 0) {
            this.t = false;
            net.one97.paytm.paymentsBank.chequebook.signatureupdate.a aVar = this.z;
            if (aVar == null) {
                kotlin.g.b.k.a("uploadedDocumentAdapter");
            }
            if (aVar != null) {
                aVar.a();
            }
            RelativeLayout relativeLayout = (RelativeLayout) a(R.id.rl_upload_document);
            kotlin.g.b.k.a((Object) relativeLayout, "rl_upload_document");
            relativeLayout.setVisibility(8);
            TextView textView = (TextView) a(R.id.txt_select_document);
            kotlin.g.b.k.a((Object) textView, "txt_select_document");
            textView.setVisibility(8);
            RecyclerView recyclerView = (RecyclerView) a(R.id.rv_document_holder);
            kotlin.g.b.k.a((Object) recyclerView, "rv_document_holder");
            recyclerView.setVisibility(8);
            TextView textView2 = (TextView) a(R.id.btn_upload_more);
            if (textView2 != null) {
                textView2.setVisibility(8);
                return;
            }
            return;
        }
        if (adapterView != null) {
            this.t = true;
            try {
                String str = this.f17799b;
                if (str == null) {
                    kotlin.g.b.k.a("selectedDocumentType");
                }
                if (str != null) {
                    this.f17800c = str;
                }
            } catch (Exception unused) {
            }
            String str2 = this.G.get(i2);
            kotlin.g.b.k.a((Object) str2, "categories[position]");
            this.f17799b = str2;
            TextView textView3 = (TextView) a(R.id.txt_select_document);
            kotlin.g.b.k.a((Object) textView3, "txt_select_document");
            textView3.setVisibility(0);
            CBDocumentTypeResponse cBDocumentTypeResponse = this.w;
            List<Payload> payload = cBDocumentTypeResponse != null ? cBDocumentTypeResponse.getPayload() : null;
            if (payload == null) {
                kotlin.g.b.k.a();
            }
            Iterator<Payload> it2 = payload.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Payload next = it2.next();
                String name = next.getName();
                String str3 = this.f17799b;
                if (str3 == null) {
                    kotlin.g.b.k.a("selectedDocumentType");
                }
                if (p.a(name, str3, false)) {
                    Integer minimumPage = next.getMinimumPage();
                    if (minimumPage == null) {
                        kotlin.g.b.k.a();
                    }
                    this.u = minimumPage.intValue();
                    Integer maximumPage = next.getMaximumPage();
                    if (maximumPage == null) {
                        kotlin.g.b.k.a();
                    }
                    this.v = maximumPage.intValue();
                }
            }
            i();
        } else {
            this.t = false;
            RelativeLayout relativeLayout2 = (RelativeLayout) a(R.id.rl_upload_document);
            kotlin.g.b.k.a((Object) relativeLayout2, "rl_upload_document");
            relativeLayout2.setVisibility(8);
            TextView textView4 = (TextView) a(R.id.txt_select_document);
            kotlin.g.b.k.a((Object) textView4, "txt_select_document");
            textView4.setVisibility(8);
        }
        if (this.J) {
            this.J = false;
        } else if (f() != null) {
            String str4 = this.f17799b;
            if (str4 == null) {
                kotlin.g.b.k.a("selectedDocumentType");
            }
            if (str4 != null && this.l != null && (f2 = f()) != null) {
                String str5 = this.f17799b;
                if (str5 == null) {
                    kotlin.g.b.k.a("selectedDocumentType");
                }
                String str6 = this.l;
                if (str6 == null) {
                    kotlin.g.b.k.a();
                }
                f2.b(str5, str6);
            }
        }
    }

    private final void a(Uri uri) {
        RelativeLayout relativeLayout = (RelativeLayout) a(R.id.btn_upload_signature);
        kotlin.g.b.k.a((Object) relativeLayout, "btn_upload_signature");
        relativeLayout.setVisibility(8);
        TextView textView = (TextView) a(R.id.tv_upload_sign_title);
        kotlin.g.b.k.a((Object) textView, "tv_upload_sign_title");
        textView.setVisibility(8);
        RelativeLayout relativeLayout2 = (RelativeLayout) a(R.id.rl_uploaded_view_change);
        kotlin.g.b.k.a((Object) relativeLayout2, "rl_uploaded_view_change");
        relativeLayout2.setVisibility(0);
        ImageView imageView = (ImageView) a(R.id.iv_signature);
        kotlin.g.b.k.a((Object) imageView, "iv_signature");
        imageView.setVisibility(0);
        LinearLayout linearLayout = (LinearLayout) a(R.id.rl_upload_sign);
        kotlin.g.b.k.a((Object) linearLayout, "rl_upload_sign");
        linearLayout.setEnabled(false);
        LinearLayout linearLayout2 = (LinearLayout) a(R.id.rl_upload_sign);
        kotlin.g.b.k.a((Object) linearLayout2, "rl_upload_sign");
        linearLayout2.setClickable(false);
        ((LinearLayout) a(R.id.rl_upload_sign)).setBackgroundResource(R.drawable.bg_cb_grey_outline);
        TextView textView2 = (TextView) a(R.id.tv_change_signature);
        kotlin.g.b.k.a((Object) textView2, "tv_change_signature");
        textView2.setVisibility(0);
        w.a().a(uri).a(s.NO_CACHE, new s[0]).a((ImageView) a(R.id.iv_signature));
        this.n = true;
    }

    /* access modifiers changed from: private */
    public final void a(boolean z2, Boolean bool) {
        Integer num;
        if (com.paytm.utility.s.a()) {
            Activity activity = this;
            if (!com.paytm.utility.s.c(activity)) {
                com.paytm.utility.s.b(activity);
                return;
            }
        }
        String str = Environment.getExternalStorageDirectory().toString() + "/Android/data/" + getPackageName();
        if (z2) {
            if (bool == null) {
                kotlin.g.b.k.a();
            }
            if (bool.booleanValue()) {
                num = Integer.valueOf(this.f17805i);
            } else {
                num = Integer.valueOf(this.f17803g);
            }
            CropImage.a().a(PBCropImageView.c.ON).a(str).a(this, num.intValue());
            return;
        }
        CropImage.a().a(PBCropImageView.c.ON).a(str).a(this, this.f17804h);
    }

    public final void b(String str) {
        kotlin.g.b.k.c(str, "imgUrl");
        if (!TextUtils.isEmpty(str)) {
            ImageView imageView = (ImageView) a(R.id.iv_signature);
            kotlin.g.b.k.a((Object) imageView, "iv_signature");
            imageView.setVisibility(0);
            w.a().a(str).a((ImageView) a(R.id.iv_signature));
        }
    }

    public final void b() {
        this.r = true;
        if (!TextUtils.isEmpty(this.A)) {
            BankPasscodeActivity.a aVar = BankPasscodeActivity.r;
            String string = getString(R.string.pb_cb_enter_pscd_to_pay_cb, new Object[]{this.A});
            kotlin.g.b.k.a((Object) string, "getString(R.string.pb_cb…pscd_to_pay_cb, cbAmount)");
            String string2 = getString(R.string.pb_cb_issuance_charge_for_leaves, new Object[]{String.valueOf(this.B)});
            kotlin.g.b.k.a((Object) string2, "getString(R.string.pb_cb…ves, cbLeaves.toString())");
            BankPasscodeActivity.a.a((Activity) this, string, string2, 121);
            return;
        }
        BankPasscodeActivity.a aVar2 = BankPasscodeActivity.r;
        String string3 = getString(R.string.fd_passcode_title);
        kotlin.g.b.k.a((Object) string3, "getString(R.string.fd_passcode_title)");
        BankPasscodeActivity.a.a(this, string3);
    }

    public final void c() {
        this.K = false;
        Toast.makeText(this, getString(R.string.pb_cb_image_upload_failure), 0).show();
        TextView textView = (TextView) a(R.id.tv_change_signature);
        kotlin.g.b.k.a((Object) textView, "tv_change_signature");
        textView.setText(getString(R.string.pb_cb_retry_signature_upload));
        TextView textView2 = (TextView) a(R.id.tv_change_signature);
        kotlin.g.b.k.a((Object) textView2, "tv_change_signature");
        textView2.setVisibility(0);
        b(true);
    }

    private final void b(boolean z2) {
        if (TextUtils.isEmpty(this.l)) {
            RelativeLayout relativeLayout = (RelativeLayout) a(R.id.btn_upload_signature);
            if (relativeLayout != null) {
                relativeLayout.setVisibility(0);
            }
            TextView textView = (TextView) a(R.id.tv_upload_sign_title);
            kotlin.g.b.k.a((Object) textView, "tv_upload_sign_title");
            textView.setVisibility(0);
            if (z2) {
                TextView textView2 = (TextView) a(R.id.tv_upload_sign_title);
                kotlin.g.b.k.a((Object) textView2, "tv_upload_sign_title");
                textView2.setVisibility(0);
                RelativeLayout relativeLayout2 = (RelativeLayout) a(R.id.btn_upload_signature);
                kotlin.g.b.k.a((Object) relativeLayout2, "btn_upload_signature");
                relativeLayout2.setVisibility(0);
                TextView textView3 = (TextView) a(R.id.txt_upload_text);
                kotlin.g.b.k.a((Object) textView3, "txt_upload_text");
                textView3.setText(getString(R.string.pb_cb_retry_signature_upload));
            } else {
                TextView textView4 = (TextView) a(R.id.tv_upload_sign_title);
                kotlin.g.b.k.a((Object) textView4, "tv_upload_sign_title");
                textView4.setVisibility(0);
                RelativeLayout relativeLayout3 = (RelativeLayout) a(R.id.btn_upload_signature);
                kotlin.g.b.k.a((Object) relativeLayout3, "btn_upload_signature");
                relativeLayout3.setVisibility(0);
                TextView textView5 = (TextView) a(R.id.txt_upload_text);
                kotlin.g.b.k.a((Object) textView5, "txt_upload_text");
                textView5.setText(getString(R.string.pb_cb_upload_sign_title));
            }
            ImageView imageView = (ImageView) a(R.id.iv_signature);
            kotlin.g.b.k.a((Object) imageView, "iv_signature");
            imageView.setVisibility(8);
            TextView textView6 = (TextView) a(R.id.tv_change_signature);
            kotlin.g.b.k.a((Object) textView6, "tv_change_signature");
            textView6.setVisibility(8);
        } else {
            TextView textView7 = (TextView) a(R.id.tv_upload_sign_title);
            kotlin.g.b.k.a((Object) textView7, "tv_upload_sign_title");
            textView7.setVisibility(8);
            RelativeLayout relativeLayout4 = (RelativeLayout) a(R.id.btn_upload_signature);
            if (relativeLayout4 != null) {
                relativeLayout4.setVisibility(8);
            }
            RelativeLayout relativeLayout5 = (RelativeLayout) a(R.id.rl_uploaded_view_change);
            if (relativeLayout5 != null) {
                relativeLayout5.setVisibility(0);
            }
        }
        LinearLayout linearLayout = (LinearLayout) a(R.id.rl_upload_sign);
        kotlin.g.b.k.a((Object) linearLayout, "rl_upload_sign");
        linearLayout.setEnabled(true);
        LinearLayout linearLayout2 = (LinearLayout) a(R.id.rl_upload_sign);
        kotlin.g.b.k.a((Object) linearLayout2, "rl_upload_sign");
        linearLayout2.setClickable(true);
        ((LinearLayout) a(R.id.rl_upload_sign)).setBackgroundResource(R.drawable.bg_cb_grey_outline);
    }

    public final void a(DocumentCreateResponse documentCreateResponse) {
        kotlin.g.b.k.c(documentCreateResponse, "documentDeleteResponse");
        net.one97.paytm.paymentsBank.chequebook.signatureupdate.a aVar = this.z;
        if (aVar == null) {
            kotlin.g.b.k.a("uploadedDocumentAdapter");
        }
        aVar.a(this.x);
        i();
    }

    /* JADX WARNING: Removed duplicated region for block: B:63:0x0130 A[Catch:{ Exception -> 0x0133 }] */
    /* JADX WARNING: Removed duplicated region for block: B:67:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void i() {
        /*
            r7 = this;
            net.one97.paytm.paymentsBank.chequebook.signatureupdate.a r0 = r7.z     // Catch:{ Exception -> 0x0133 }
            java.lang.String r1 = "uploadedDocumentAdapter"
            if (r0 != 0) goto L_0x0009
            kotlin.g.b.k.a((java.lang.String) r1)     // Catch:{ Exception -> 0x0133 }
        L_0x0009:
            r2 = 0
            if (r0 == 0) goto L_0x0015
            int r0 = r0.getItemCount()     // Catch:{ Exception -> 0x0133 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x0133 }
            goto L_0x0016
        L_0x0015:
            r0 = r2
        L_0x0016:
            int r0 = r0.intValue()     // Catch:{ Exception -> 0x0133 }
            java.lang.String r3 = "rv_document_holder"
            r4 = 0
            java.lang.String r5 = "rl_upload_document"
            r6 = 8
            if (r0 <= 0) goto L_0x00d4
            int r0 = net.one97.paytm.paymentsBank.R.id.rl_upload_document     // Catch:{ Exception -> 0x0133 }
            android.view.View r0 = r7.a((int) r0)     // Catch:{ Exception -> 0x0133 }
            android.widget.RelativeLayout r0 = (android.widget.RelativeLayout) r0     // Catch:{ Exception -> 0x0133 }
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r5)     // Catch:{ Exception -> 0x0133 }
            r0.setVisibility(r6)     // Catch:{ Exception -> 0x0133 }
            int r0 = net.one97.paytm.paymentsBank.R.id.rv_document_holder     // Catch:{ Exception -> 0x0133 }
            android.view.View r0 = r7.a((int) r0)     // Catch:{ Exception -> 0x0133 }
            androidx.recyclerview.widget.RecyclerView r0 = (androidx.recyclerview.widget.RecyclerView) r0     // Catch:{ Exception -> 0x0133 }
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)     // Catch:{ Exception -> 0x0133 }
            r0.setVisibility(r4)     // Catch:{ Exception -> 0x0133 }
            r0 = 1
            r7.o = r0     // Catch:{ Exception -> 0x0133 }
            java.util.HashMap<java.lang.String, net.one97.paytm.paymentsBank.chequebook.model.Payload> r0 = r7.I     // Catch:{ Exception -> 0x0133 }
            if (r0 == 0) goto L_0x0070
            java.util.ArrayList<java.lang.String> r3 = r7.G     // Catch:{ Exception -> 0x0133 }
            int r5 = net.one97.paytm.paymentsBank.R.id.spinner     // Catch:{ Exception -> 0x0133 }
            android.view.View r5 = r7.a((int) r5)     // Catch:{ Exception -> 0x0133 }
            android.widget.Spinner r5 = (android.widget.Spinner) r5     // Catch:{ Exception -> 0x0133 }
            if (r5 == 0) goto L_0x005b
            int r5 = r5.getSelectedItemPosition()     // Catch:{ Exception -> 0x0133 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ Exception -> 0x0133 }
            goto L_0x005c
        L_0x005b:
            r5 = r2
        L_0x005c:
            if (r5 != 0) goto L_0x0061
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x0133 }
        L_0x0061:
            int r5 = r5.intValue()     // Catch:{ Exception -> 0x0133 }
            java.lang.Object r3 = r3.get(r5)     // Catch:{ Exception -> 0x0133 }
            java.lang.Object r0 = r0.get(r3)     // Catch:{ Exception -> 0x0133 }
            net.one97.paytm.paymentsBank.chequebook.model.Payload r0 = (net.one97.paytm.paymentsBank.chequebook.model.Payload) r0     // Catch:{ Exception -> 0x0133 }
            goto L_0x0071
        L_0x0070:
            r0 = r2
        L_0x0071:
            if (r0 == 0) goto L_0x0078
            java.lang.Integer r3 = r0.getMinimumPage()     // Catch:{ Exception -> 0x0133 }
            goto L_0x0079
        L_0x0078:
            r3 = r2
        L_0x0079:
            if (r3 != 0) goto L_0x007e
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x0133 }
        L_0x007e:
            int r3 = r3.intValue()     // Catch:{ Exception -> 0x0133 }
            r7.u = r3     // Catch:{ Exception -> 0x0133 }
            if (r0 == 0) goto L_0x008a
            java.lang.Integer r2 = r0.getMaximumPage()     // Catch:{ Exception -> 0x0133 }
        L_0x008a:
            if (r2 != 0) goto L_0x008f
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x0133 }
        L_0x008f:
            int r0 = r2.intValue()     // Catch:{ Exception -> 0x0133 }
            r7.v = r0     // Catch:{ Exception -> 0x0133 }
            net.one97.paytm.paymentsBank.chequebook.signatureupdate.a r0 = r7.z     // Catch:{ Exception -> 0x0133 }
            if (r0 != 0) goto L_0x009c
            kotlin.g.b.k.a((java.lang.String) r1)     // Catch:{ Exception -> 0x0133 }
        L_0x009c:
            int r0 = r0.getItemCount()     // Catch:{ Exception -> 0x0133 }
            int r2 = r7.u     // Catch:{ Exception -> 0x0133 }
            java.lang.String r3 = "btn_upload_more"
            if (r0 < r2) goto L_0x00c4
            net.one97.paytm.paymentsBank.chequebook.signatureupdate.a r0 = r7.z     // Catch:{ Exception -> 0x0133 }
            if (r0 != 0) goto L_0x00ad
            kotlin.g.b.k.a((java.lang.String) r1)     // Catch:{ Exception -> 0x0133 }
        L_0x00ad:
            int r0 = r0.getItemCount()     // Catch:{ Exception -> 0x0133 }
            int r1 = r7.v     // Catch:{ Exception -> 0x0133 }
            if (r0 >= r1) goto L_0x00c4
            int r0 = net.one97.paytm.paymentsBank.R.id.btn_upload_more     // Catch:{ Exception -> 0x0133 }
            android.view.View r0 = r7.a((int) r0)     // Catch:{ Exception -> 0x0133 }
            android.widget.TextView r0 = (android.widget.TextView) r0     // Catch:{ Exception -> 0x0133 }
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)     // Catch:{ Exception -> 0x0133 }
            r0.setVisibility(r4)     // Catch:{ Exception -> 0x0133 }
            return
        L_0x00c4:
            int r0 = net.one97.paytm.paymentsBank.R.id.btn_upload_more     // Catch:{ Exception -> 0x0133 }
            android.view.View r0 = r7.a((int) r0)     // Catch:{ Exception -> 0x0133 }
            android.widget.TextView r0 = (android.widget.TextView) r0     // Catch:{ Exception -> 0x0133 }
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)     // Catch:{ Exception -> 0x0133 }
            r1 = 4
            r0.setVisibility(r1)     // Catch:{ Exception -> 0x0133 }
            return
        L_0x00d4:
            int r0 = net.one97.paytm.paymentsBank.R.id.spinner     // Catch:{ Exception -> 0x0133 }
            android.view.View r0 = r7.a((int) r0)     // Catch:{ Exception -> 0x0133 }
            android.widget.Spinner r0 = (android.widget.Spinner) r0     // Catch:{ Exception -> 0x0133 }
            if (r0 == 0) goto L_0x010a
            int r0 = net.one97.paytm.paymentsBank.R.id.spinner     // Catch:{ Exception -> 0x0133 }
            android.view.View r0 = r7.a((int) r0)     // Catch:{ Exception -> 0x0133 }
            android.widget.Spinner r0 = (android.widget.Spinner) r0     // Catch:{ Exception -> 0x0133 }
            if (r0 == 0) goto L_0x00f0
            int r0 = r0.getSelectedItemPosition()     // Catch:{ Exception -> 0x0133 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x0133 }
        L_0x00f0:
            if (r2 != 0) goto L_0x00f5
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x0133 }
        L_0x00f5:
            int r0 = r2.intValue()     // Catch:{ Exception -> 0x0133 }
            if (r0 <= 0) goto L_0x010a
            int r0 = net.one97.paytm.paymentsBank.R.id.rl_upload_document     // Catch:{ Exception -> 0x0133 }
            android.view.View r0 = r7.a((int) r0)     // Catch:{ Exception -> 0x0133 }
            android.widget.RelativeLayout r0 = (android.widget.RelativeLayout) r0     // Catch:{ Exception -> 0x0133 }
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r5)     // Catch:{ Exception -> 0x0133 }
            r0.setVisibility(r4)     // Catch:{ Exception -> 0x0133 }
            goto L_0x0118
        L_0x010a:
            int r0 = net.one97.paytm.paymentsBank.R.id.rl_upload_document     // Catch:{ Exception -> 0x0133 }
            android.view.View r0 = r7.a((int) r0)     // Catch:{ Exception -> 0x0133 }
            android.widget.RelativeLayout r0 = (android.widget.RelativeLayout) r0     // Catch:{ Exception -> 0x0133 }
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r5)     // Catch:{ Exception -> 0x0133 }
            r0.setVisibility(r6)     // Catch:{ Exception -> 0x0133 }
        L_0x0118:
            int r0 = net.one97.paytm.paymentsBank.R.id.rv_document_holder     // Catch:{ Exception -> 0x0133 }
            android.view.View r0 = r7.a((int) r0)     // Catch:{ Exception -> 0x0133 }
            androidx.recyclerview.widget.RecyclerView r0 = (androidx.recyclerview.widget.RecyclerView) r0     // Catch:{ Exception -> 0x0133 }
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)     // Catch:{ Exception -> 0x0133 }
            r0.setVisibility(r6)     // Catch:{ Exception -> 0x0133 }
            int r0 = net.one97.paytm.paymentsBank.R.id.btn_upload_more     // Catch:{ Exception -> 0x0133 }
            android.view.View r0 = r7.a((int) r0)     // Catch:{ Exception -> 0x0133 }
            android.widget.TextView r0 = (android.widget.TextView) r0     // Catch:{ Exception -> 0x0133 }
            if (r0 == 0) goto L_0x0133
            r0.setVisibility(r6)     // Catch:{ Exception -> 0x0133 }
        L_0x0133:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.paymentsBank.chequebook.signaturelanding.view.SignatureLandingActivityV2.i():void");
    }

    private final void c(boolean z2) {
        Spinner spinner = (Spinner) a(R.id.spinner);
        kotlin.g.b.k.a((Object) spinner, "spinner");
        spinner.setEnabled(z2);
    }

    public static final class b extends AsyncTask<String, Void, String> {

        /* renamed from: a  reason: collision with root package name */
        private final Context f17806a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f17807b;

        /* renamed from: c  reason: collision with root package name */
        private final Boolean f17808c;

        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            String[] strArr = (String[]) objArr;
            kotlin.g.b.k.c(strArr, "params");
            if (TextUtils.isEmpty(strArr[0])) {
                return "FAILURE";
            }
            net.one97.paytm.paymentsBank.chequebook.utils.a.a(strArr[0]);
            return "SUCCESS";
        }

        public final /* synthetic */ void onPostExecute(Object obj) {
            String str = (String) obj;
            super.onPostExecute(str);
            if (p.a(str, "SUCCESS", false)) {
                Context context = this.f17806a;
                if (context == null) {
                    throw new u("null cannot be cast to non-null type net.one97.paytm.paymentsBank.chequebook.signaturelanding.view.SignatureLandingActivityV2");
                } else if (this.f17807b) {
                    SignatureLandingActivityV2.a((SignatureLandingActivityV2) context);
                } else {
                    SignatureLandingActivityV2.b((SignatureLandingActivityV2) context);
                }
            }
        }

        public /* synthetic */ b(Context context) {
            this(context, false, Boolean.FALSE);
        }

        public b(Context context, boolean z, Boolean bool) {
            kotlin.g.b.k.c(context, "signatureLandingActivity");
            this.f17806a = context;
            this.f17807b = z;
            this.f17808c = bool;
        }
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == this.f17803g || i2 == this.f17805i) {
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
                        kotlin.g.b.k.a((Object) file2, "temp");
                        if (p.a(file2.getName(), "picture.jpg", true)) {
                            file = file2;
                            break;
                        }
                        i4++;
                    }
                    Uri fromFile = Uri.fromFile(new File(file.getAbsolutePath()));
                    kotlin.g.b.k.a((Object) fromFile, "Uri.fromFile(File(f.absolutePath))");
                    this.f17802e = fromFile;
                    String absolutePath = file.getAbsolutePath();
                    kotlin.g.b.k.a((Object) absolutePath, "f.absolutePath");
                    this.k = absolutePath;
                    new b(this, true, Boolean.valueOf(i2 == this.f17805i)).execute(new String[]{file.getAbsolutePath()});
                }
            }
        } else if (i2 == this.f17804h) {
            CropImage.ActivityResult a3 = CropImage.a(intent);
            if (i3 != -1) {
                return;
            }
            if (intent == null) {
                Toast.makeText(this, getString(R.string.pb_something_wrong_try_again), 1).show();
            } else if (a3 == null) {
                Toast.makeText(this, getString(R.string.pb_something_wrong_try_again), 1).show();
            } else if (p.a(Environment.getExternalStorageState(), "mounted", true)) {
                String str2 = Environment.getExternalStorageDirectory().toString() + "/Android/data/" + getPackageName();
                if (new File(str2).exists()) {
                    File file3 = new File(str2);
                    File[] listFiles2 = file3.listFiles();
                    int length2 = listFiles2.length;
                    int i5 = 0;
                    while (true) {
                        if (i5 >= length2) {
                            break;
                        }
                        File file4 = listFiles2[i5];
                        kotlin.g.b.k.a((Object) file4, "temp");
                        if (p.a(file4.getName(), "picture.jpg", true)) {
                            file3 = file4;
                            break;
                        }
                        i5++;
                    }
                    Uri fromFile2 = Uri.fromFile(new File(file3.getAbsolutePath()));
                    kotlin.g.b.k.a((Object) fromFile2, "Uri.fromFile(File(f.absolutePath))");
                    this.f17802e = fromFile2;
                    String absolutePath2 = file3.getAbsolutePath();
                    kotlin.g.b.k.a((Object) absolutePath2, "f.absolutePath");
                    this.k = absolutePath2;
                    new b(this).execute(new String[]{file3.getAbsolutePath()});
                }
            }
        } else if (i2 == 121 && i3 == -1 && intent != null && !TextUtils.isEmpty(intent.getStringExtra("passcode"))) {
            this.m = intent.getStringExtra("passcode");
            String stringExtra = intent.getStringExtra("passcode");
            a.C0285a f2 = f();
            if (kotlin.g.b.k.a((Object) f2 != null ? f2.f() : null, (Object) Boolean.FALSE)) {
                a.C0285a f3 = f();
                if (f3 != null) {
                    f3.c(stringExtra);
                }
            } else if (this.r) {
                a.C0285a f4 = f();
                kotlin.g.b.k.a((Object) stringExtra, "txnToken");
                f4.a(stringExtra, this.r, this.D);
            }
        }
    }

    private final void j() {
        Spinner spinner;
        System.out.println("clear doc listtttttt");
        net.one97.paytm.paymentsBank.chequebook.signatureupdate.a aVar = this.z;
        if (aVar == null) {
            kotlin.g.b.k.a("uploadedDocumentAdapter");
        }
        if (aVar != null) {
            aVar.a();
        }
        i();
        try {
            if (((Spinner) a(R.id.spinner)) != null) {
                Spinner spinner2 = (Spinner) a(R.id.spinner);
                if ((spinner2 != null ? spinner2.getAdapter() : null) != null) {
                    Spinner spinner3 = (Spinner) a(R.id.spinner);
                    if ((spinner3 == null || spinner3.getSelectedItemPosition() != 0) && (spinner = (Spinner) a(R.id.spinner)) != null) {
                        spinner.setSelection(0);
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    public final void e() {
        Intent intent = new Intent();
        intent.putExtra("is_cb_acknowledge_success", true);
        setResult(-1, intent);
        finish();
    }

    public final void onErrorResponse(VolleyError volleyError) {
        a(false);
        net.one97.paytm.paymentsBank.utils.j.a((Activity) this, (Exception) volleyError, (String) null, (Bundle) null);
    }

    public final void a(NetworkCustomError networkCustomError) {
        net.one97.paytm.paymentsBank.utils.j.a((Activity) this, (Exception) networkCustomError, (String) null, (Bundle) null);
    }

    public final void a(String str, String str2) {
        kotlin.g.b.k.c(str, "title");
        kotlin.g.b.k.c(str2, "msg");
        com.paytm.utility.h hVar = new com.paytm.utility.h(this);
        hVar.setTitle(str);
        hVar.a(str2);
        hVar.setCancelable(false);
        hVar.a(-3, getString(R.string.ok), new l(this, hVar));
        hVar.show();
    }

    public static final /* synthetic */ void a(SignatureLandingActivityV2 signatureLandingActivityV2) {
        Boolean bool;
        net.one97.paytm.paymentsBank.chequebook.utils.j jVar;
        signatureLandingActivityV2.K = true;
        a.C0285a f2 = signatureLandingActivityV2.f();
        if (TextUtils.isEmpty(f2 != null ? f2.e() : null)) {
            bool = Boolean.FALSE;
        } else {
            bool = Boolean.TRUE;
        }
        String E2 = n.E();
        String str = signatureLandingActivityV2.k;
        if (str == null) {
            kotlin.g.b.k.a("filepath");
        }
        if (!TextUtils.isEmpty(str)) {
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            Map map = hashMap;
            String str2 = signatureLandingActivityV2.k;
            if (str2 == null) {
                kotlin.g.b.k.a("filepath");
            }
            map.put(CommunityPostActivity.TYPE_FILE, new File(str2));
            Map map2 = hashMap2;
            net.one97.paytm.paymentsBank.chequebook.utils.e eVar = net.one97.paytm.paymentsBank.chequebook.utils.e.f17951a;
            String a2 = net.one97.paytm.paymentsBank.chequebook.utils.e.a();
            Context context = signatureLandingActivityV2;
            String a3 = com.paytm.utility.d.a(context);
            kotlin.g.b.k.a((Object) a3, "CJRNetUtility.getSSOToke…gnatureLandingActivityV2)");
            map2.put(a2, a3);
            if (bool.booleanValue()) {
                jVar = new net.one97.paytm.paymentsBank.chequebook.utils.j(context, E2, signatureLandingActivityV2, signatureLandingActivityV2, new SignatureCreateResponse(), map, map2, (byte) 0);
            } else {
                jVar = new net.one97.paytm.paymentsBank.chequebook.utils.j(context, E2, signatureLandingActivityV2, signatureLandingActivityV2, new SignatureCreateResponse(), map, map2);
            }
            Volley.newRequestQueue(context).add(jVar);
            signatureLandingActivityV2.a(true);
        }
    }

    public static final /* synthetic */ void b(SignatureLandingActivityV2 signatureLandingActivityV2) {
        String y2 = n.y();
        if (!TextUtils.isEmpty(signatureLandingActivityV2.l)) {
            String str = signatureLandingActivityV2.f17799b;
            if (str == null) {
                kotlin.g.b.k.a("selectedDocumentType");
            }
            if (!TextUtils.isEmpty(str)) {
                kotlin.g.b.k.a((Object) y2, "url");
                String str2 = signatureLandingActivityV2.l;
                if (str2 == null) {
                    kotlin.g.b.k.a();
                }
                String a2 = p.a(y2, "{imageID}", str2, true);
                String str3 = signatureLandingActivityV2.f17799b;
                if (str3 == null) {
                    kotlin.g.b.k.a("selectedDocumentType");
                }
                if (str3 == null) {
                    kotlin.g.b.k.a();
                }
                y2 = p.a(a2, "{docType}", str3, true);
            }
        }
        String str4 = y2;
        String str5 = signatureLandingActivityV2.k;
        if (str5 == null) {
            kotlin.g.b.k.a("filepath");
        }
        if (!TextUtils.isEmpty(str5)) {
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            Map map = hashMap;
            String str6 = signatureLandingActivityV2.k;
            if (str6 == null) {
                kotlin.g.b.k.a("filepath");
            }
            map.put(CommunityPostActivity.TYPE_FILE, new File(str6));
            Map map2 = hashMap2;
            net.one97.paytm.paymentsBank.chequebook.utils.e eVar = net.one97.paytm.paymentsBank.chequebook.utils.e.f17951a;
            String a3 = net.one97.paytm.paymentsBank.chequebook.utils.e.a();
            Context context = signatureLandingActivityV2;
            String a4 = com.paytm.utility.d.a(context);
            kotlin.g.b.k.a((Object) a4, "CJRNetUtility.getSSOToke…gnatureLandingActivityV2)");
            map2.put(a3, a4);
            Volley.newRequestQueue(context).add(new net.one97.paytm.paymentsBank.chequebook.utils.j(context, str4, signatureLandingActivityV2, signatureLandingActivityV2, new DocumentCreateResponse(), map, map2));
            signatureLandingActivityV2.a(true);
        }
    }

    public static final /* synthetic */ boolean e(SignatureLandingActivityV2 signatureLandingActivityV2) {
        net.one97.paytm.paymentsBank.chequebook.signatureupdate.a aVar = signatureLandingActivityV2.z;
        if (aVar == null) {
            kotlin.g.b.k.a("uploadedDocumentAdapter");
        }
        return aVar.getItemCount() >= signatureLandingActivityV2.u;
    }

    public static final /* synthetic */ void a(SignatureLandingActivityV2 signatureLandingActivityV2, String str) {
        a.C0285a f2 = signatureLandingActivityV2.f();
        if (f2 != null) {
            String str2 = signatureLandingActivityV2.l;
            if (str2 == null) {
                kotlin.g.b.k.a();
            }
            f2.a(str, str2);
        }
    }
}
