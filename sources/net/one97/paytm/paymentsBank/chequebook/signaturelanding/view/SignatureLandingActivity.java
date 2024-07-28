package net.one97.paytm.paymentsBank.chequebook.signaturelanding.view;

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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.appsflyer.internal.referrer.Payload;
import com.google.android.material.snackbar.Snackbar;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.activities.CommunityPostActivity;
import com.squareup.picasso.s;
import com.squareup.picasso.w;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.bankCommon.model.PBTncData;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.chequebook.model.CBDocumentTypeResponse;
import net.one97.paytm.paymentsBank.chequebook.model.CBGetSignatureResponse;
import net.one97.paytm.paymentsBank.chequebook.model.ChequeBookFinResponse;
import net.one97.paytm.paymentsBank.chequebook.model.ChequeBookResponse;
import net.one97.paytm.paymentsBank.chequebook.model.ChequeBookSignature;
import net.one97.paytm.paymentsBank.chequebook.model.DocumentCreateResponse;
import net.one97.paytm.paymentsBank.chequebook.model.GetDocumentCreateResponse;
import net.one97.paytm.paymentsBank.chequebook.model.SignatureCreateResponse;
import net.one97.paytm.paymentsBank.chequebook.orderFlow.CBorderSummaryActivity;
import net.one97.paytm.paymentsBank.chequebook.signaturelanding.a.a;
import net.one97.paytm.paymentsBank.chequebook.signatureupdate.a;
import net.one97.paytm.paymentsBank.chequebook.utils.ChequeBookBaseActivity;
import net.one97.paytm.paymentsBank.passcode.BankPasscodeActivity;
import net.one97.paytm.paymentsBank.widget.croptool.CropImage;
import net.one97.paytm.paymentsBank.widget.croptool.PBCropImageView;

public final class SignatureLandingActivity extends ChequeBookBaseActivity implements AdapterView.OnItemSelectedListener, Response.ErrorListener, Response.Listener<IJRPaytmDataModel>, a.b {

    /* renamed from: f  reason: collision with root package name */
    public static final a f17776f = new a((byte) 0);
    private int A = 10;
    private String B = "";
    private final ArrayList<String> C = new ArrayList<>();
    private boolean D;
    private HashMap E;

    /* renamed from: a  reason: collision with root package name */
    long f17777a;

    /* renamed from: b  reason: collision with root package name */
    public String f17778b;

    /* renamed from: c  reason: collision with root package name */
    public CBDocumentTypeResponse f17779c;

    /* renamed from: d  reason: collision with root package name */
    public a.C0285a f17780d;

    /* renamed from: e  reason: collision with root package name */
    public Uri f17781e;

    /* renamed from: g  reason: collision with root package name */
    private final int f17782g = 701;

    /* renamed from: h  reason: collision with root package name */
    private final int f17783h = 702;

    /* renamed from: i  reason: collision with root package name */
    private final String f17784i = "SignatureLandingActivity";
    private String j;
    private String k;
    private String l;
    /* access modifiers changed from: private */
    public boolean m;
    /* access modifiers changed from: private */
    public boolean n;
    private Boolean o;
    private boolean p;
    private boolean q;
    private ArrayList<PBTncData> r = new ArrayList<>();
    private boolean s;
    private int t = 1;
    private int u = 1;
    /* access modifiers changed from: private */
    public int v;
    private net.one97.paytm.paymentsBank.chequebook.signatureupdate.a w;
    private net.one97.paytm.paymentsBank.chequebook.utils.h x;
    private String y;
    private String z = "";

    public final View a(int i2) {
        if (this.E == null) {
            this.E = new HashMap();
        }
        View view = (View) this.E.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.E.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void a(Boolean bool) {
    }

    public final void a(GetDocumentCreateResponse getDocumentCreateResponse) {
        kotlin.g.b.k.c(getDocumentCreateResponse, "documentCreateResponse");
    }

    public final void b(ArrayList<PBTncData> arrayList) {
        kotlin.g.b.k.c(arrayList, "mTncDataList");
    }

    public final void c(String str) {
    }

    public final void d() {
    }

    public final void e() {
    }

    public final void onNothingSelected(AdapterView<?> adapterView) {
    }

    public final /* synthetic */ void onResponse(Object obj) {
        IJRPaytmDataModel iJRPaytmDataModel = (IJRPaytmDataModel) obj;
        if (iJRPaytmDataModel != null) {
            if (iJRPaytmDataModel instanceof SignatureCreateResponse) {
                SignatureCreateResponse signatureCreateResponse = (SignatureCreateResponse) iJRPaytmDataModel;
                String status = signatureCreateResponse.getStatus();
                net.one97.paytm.paymentsBank.chequebook.utils.e eVar = net.one97.paytm.paymentsBank.chequebook.utils.e.f17951a;
                if (p.a(status, net.one97.paytm.paymentsBank.chequebook.utils.e.P(), true) && signatureCreateResponse.getPayload() != null) {
                    SignatureCreateResponse.Payload payload = signatureCreateResponse.getPayload();
                    if (payload == null) {
                        kotlin.g.b.k.a();
                    }
                    String imageId = payload.getImageId();
                    if (imageId == null) {
                        kotlin.g.b.k.a();
                    }
                    this.k = imageId;
                    c(true);
                    Uri uri = this.f17781e;
                    if (uri == null) {
                        kotlin.g.b.k.a("selectedImage");
                    }
                    a(uri);
                    this.n = false;
                }
            } else if (iJRPaytmDataModel instanceof DocumentCreateResponse) {
                DocumentCreateResponse documentCreateResponse = (DocumentCreateResponse) iJRPaytmDataModel;
                String status2 = documentCreateResponse.getStatus();
                net.one97.paytm.paymentsBank.chequebook.utils.e eVar2 = net.one97.paytm.paymentsBank.chequebook.utils.e.f17951a;
                if (p.a(status2, net.one97.paytm.paymentsBank.chequebook.utils.e.P(), true) && documentCreateResponse.getPayload() != null) {
                    net.one97.paytm.paymentsBank.chequebook.signatureupdate.a aVar = this.w;
                    if (aVar == null) {
                        kotlin.g.b.k.a("uploadedDocumentAdapter");
                    }
                    aVar.a(documentCreateResponse.getPayload());
                    g();
                }
            }
        }
        a(false);
    }

    static final class k implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SignatureLandingActivity f17795a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.paytm.utility.h f17796b;

        k(SignatureLandingActivity signatureLandingActivity, com.paytm.utility.h hVar) {
            this.f17795a = signatureLandingActivity;
            this.f17796b = hVar;
        }

        public final void onClick(View view) {
            this.f17796b.cancel();
            this.f17795a.setResult(-1);
            this.f17795a.finish();
        }
    }

    public final void b(String str, String str2) {
        kotlin.g.b.k.c(str, "errorTitle");
        kotlin.g.b.k.c(str2, ImagePickerUtils.IMAGE_PICKER_KEY_ERROR_MESSAGE);
        com.paytm.utility.b.b((Context) this, str, str2);
    }

    public final void a(String str) {
        Intent intent = new Intent(this, CBorderSummaryActivity.class);
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra("order_id", str);
        } else {
            intent.putExtra("order_id", "");
        }
        startActivity(intent);
        setResult(-1);
        finish();
    }

    public final void a(boolean z2) {
        if (z2) {
            com.paytm.utility.b.k(this, getString(R.string.please_wait));
        } else {
            com.paytm.utility.b.p();
        }
    }

    public final a.C0285a f() {
        a.C0285a aVar = this.f17780d;
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
        this.r = arrayList;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void onCreate(Bundle bundle) {
        Boolean bool;
        String str;
        String str2;
        ChequeBookResponse response;
        super.onCreate(bundle);
        net.one97.paytm.paymentsBank.chequebook.utils.d dVar = net.one97.paytm.paymentsBank.chequebook.utils.d.f17950a;
        Context applicationContext = getApplicationContext();
        kotlin.g.b.k.a((Object) applicationContext, "applicationContext");
        Context baseContext = getBaseContext();
        kotlin.g.b.k.a((Object) baseContext, "baseContext");
        a.C0285a aVar = new net.one97.paytm.paymentsBank.chequebook.signaturelanding.b.a(net.one97.paytm.paymentsBank.chequebook.utils.d.a(applicationContext), this, baseContext);
        kotlin.g.b.k.c(aVar, "<set-?>");
        this.f17780d = aVar;
        Intent intent = getIntent();
        String str3 = null;
        if (intent != null) {
            net.one97.paytm.paymentsBank.chequebook.utils.e eVar = net.one97.paytm.paymentsBank.chequebook.utils.e.f17951a;
            bool = Boolean.valueOf(intent.getBooleanExtra(net.one97.paytm.paymentsBank.chequebook.utils.e.c(), false));
        } else {
            bool = null;
        }
        this.o = bool;
        Intent intent2 = getIntent();
        Boolean valueOf = intent2 != null ? Boolean.valueOf(intent2.getBooleanExtra("EXTRA_IS_SIGN_UPDATE_LOW", false)) : null;
        if (valueOf == null) {
            kotlin.g.b.k.a();
        }
        this.p = valueOf.booleanValue();
        Intent intent3 = getIntent();
        if (intent3 == null || (str = intent3.getStringExtra(SDKConstants.AI_TRANSACTION_AMOUNT)) == null) {
            str = "";
        }
        this.z = str;
        Intent intent4 = getIntent();
        int i2 = 10;
        if (intent4 != null) {
            i2 = intent4.getIntExtra("leaves_extra", 10);
        }
        this.A = i2;
        Intent intent5 = getIntent();
        if (intent5 == null || (str2 = intent5.getStringExtra("passcode_extra")) == null) {
            str2 = "";
        }
        this.B = str2;
        com.google.gson.f fVar = new com.google.gson.f();
        Context context = this;
        this.x = net.one97.paytm.paymentsBank.chequebook.utils.h.a(context);
        if (this.x != null) {
            str3 = net.one97.paytm.paymentsBank.chequebook.utils.h.a("CB_KEY_FIN_RESPONSE");
        }
        this.y = str3;
        ChequeBookFinResponse chequeBookFinResponse = (ChequeBookFinResponse) fVar.a(this.y, ChequeBookFinResponse.class);
        if (chequeBookFinResponse != null) {
            kotlin.g.b.k.c(chequeBookFinResponse, "chequeBookFinResponse");
            if (p.a(chequeBookFinResponse.getResponseCode(), "200", true) && (response = chequeBookFinResponse.getResponse()) != null) {
                ChequeBookSignature signature = response.getSignature();
                if (signature != null) {
                    String status = signature.getStatus();
                    if (status == null) {
                        kotlin.g.b.k.a();
                    }
                    if (p.a(status, "UPLOAD_PENDING", true)) {
                        b(false);
                    }
                } else if (!p.a("", "ACCEPTED", true) && !p.a("", "APPROVAL_PENDING", true)) {
                    p.a("", "REJECTED", true);
                }
            }
        }
        if (this.p) {
            TextView textView = (TextView) a(R.id.tv_proceed_payment);
            kotlin.g.b.k.a((Object) textView, "tv_proceed_payment");
            textView.setText(getString(R.string.submit));
        } else {
            TextView textView2 = (TextView) a(R.id.tv_proceed_payment);
            kotlin.g.b.k.a((Object) textView2, "tv_proceed_payment");
            textView2.setText(getString(R.string.pdc_proceed_to_pay_rupee, new Object[]{this.z}));
        }
        ((TextView) a(R.id.tv_change_signature)).setOnClickListener(new c(this));
        ((LinearLayout) a(R.id.rl_upload_sign)).setOnClickListener(new d(this));
        ((RelativeLayout) a(R.id.btn_upload_signature)).setOnClickListener(new e(this));
        ((RelativeLayout) a(R.id.rl_upload_document)).setOnClickListener(new f(this));
        ((TextView) a(R.id.btn_upload_more)).setOnClickListener(new g(this));
        ((TextView) a(R.id.tv_proceed_payment)).setOnClickListener(new h(this));
        ((ImageView) a(R.id.iv_header_back)).setOnClickListener(new i(this));
        c(false);
        this.w = new net.one97.paytm.paymentsBank.chequebook.signatureupdate.a(context, new ArrayList(), new j(this));
        RecyclerView recyclerView = (RecyclerView) a(R.id.rv_document_holder);
        net.one97.paytm.paymentsBank.chequebook.signatureupdate.a aVar2 = this.w;
        if (aVar2 == null) {
            kotlin.g.b.k.a("uploadedDocumentAdapter");
        }
        recyclerView.setAdapter(aVar2);
        kotlin.g.b.k.a((Object) recyclerView, "this");
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setVisibility(8);
        f().a();
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SignatureLandingActivity f17787a;

        c(SignatureLandingActivity signatureLandingActivity) {
            this.f17787a = signatureLandingActivity;
        }

        public final void onClick(View view) {
            SignatureLandingActivity.a(this.f17787a, true);
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SignatureLandingActivity f17788a;

        d(SignatureLandingActivity signatureLandingActivity) {
            this.f17788a = signatureLandingActivity;
        }

        public final void onClick(View view) {
            SignatureLandingActivity.a(this.f17788a, true);
        }
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SignatureLandingActivity f17789a;

        e(SignatureLandingActivity signatureLandingActivity) {
            this.f17789a = signatureLandingActivity;
        }

        public final void onClick(View view) {
            SignatureLandingActivity.a(this.f17789a, true);
        }
    }

    static final class f implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SignatureLandingActivity f17790a;

        f(SignatureLandingActivity signatureLandingActivity) {
            this.f17790a = signatureLandingActivity;
        }

        public final void onClick(View view) {
            SignatureLandingActivity.a(this.f17790a, false);
        }
    }

    static final class g implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SignatureLandingActivity f17791a;

        g(SignatureLandingActivity signatureLandingActivity) {
            this.f17791a = signatureLandingActivity;
        }

        public final void onClick(View view) {
            SignatureLandingActivity.a(this.f17791a, false);
        }
    }

    static final class h implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SignatureLandingActivity f17792a;

        h(SignatureLandingActivity signatureLandingActivity) {
            this.f17792a = signatureLandingActivity;
        }

        public final void onClick(View view) {
            if (SystemClock.elapsedRealtime() - this.f17792a.f17777a >= 1000) {
                this.f17792a.f17777a = SystemClock.elapsedRealtime();
                ImageView imageView = (ImageView) this.f17792a.a(R.id.iv_signature);
                kotlin.g.b.k.a((Object) imageView, "iv_signature");
                if (imageView.getVisibility() != 0 || !this.f17792a.m || !this.f17792a.n || !SignatureLandingActivity.e(this.f17792a)) {
                    Snackbar.a((View) (RelativeLayout) this.f17792a.a(R.id.sign_upload_main_parent_lyt), (CharSequence) this.f17792a.getString(R.string.pb_cb_please_upload_sign), -1).c();
                } else {
                    this.f17792a.f().c();
                }
            }
        }
    }

    static final class i implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SignatureLandingActivity f17793a;

        i(SignatureLandingActivity signatureLandingActivity) {
            this.f17793a = signatureLandingActivity;
        }

        public final void onClick(View view) {
            this.f17793a.onBackPressed();
        }
    }

    static final class j implements a.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SignatureLandingActivity f17794a;

        j(SignatureLandingActivity signatureLandingActivity) {
            this.f17794a = signatureLandingActivity;
        }

        public final void a(String str, int i2) {
            kotlin.g.b.k.c(str, "documentId");
            SignatureLandingActivity.a(this.f17794a, str);
            this.f17794a.v = i2;
        }
    }

    public final void a(CBDocumentTypeResponse cBDocumentTypeResponse) {
        kotlin.g.b.k.c(cBDocumentTypeResponse, Payload.RESPONSE);
        this.f17779c = cBDocumentTypeResponse;
        this.C.add("Select Document");
        List<net.one97.paytm.paymentsBank.chequebook.model.Payload> payload = cBDocumentTypeResponse.getPayload();
        if (payload == null) {
            kotlin.g.b.k.a();
        }
        for (net.one97.paytm.paymentsBank.chequebook.model.Payload name : payload) {
            ArrayList<String> arrayList = this.C;
            String name2 = name.getName();
            if (name2 == null) {
                kotlin.g.b.k.a();
            }
            arrayList.add(name2);
        }
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, 17367048, this.C);
        arrayAdapter.setDropDownViewResource(17367049);
        Spinner spinner = (Spinner) a(R.id.spinner);
        kotlin.g.b.k.a((Object) spinner, "spinner");
        spinner.setAdapter(arrayAdapter);
        Spinner spinner2 = (Spinner) a(R.id.spinner);
        kotlin.g.b.k.a((Object) spinner2, "spinner");
        spinner2.setOnItemSelectedListener(this);
        f().d();
    }

    public final void a(CBGetSignatureResponse cBGetSignatureResponse) {
        kotlin.g.b.k.c(cBGetSignatureResponse, Payload.RESPONSE);
        if (cBGetSignatureResponse.getPayload() != null) {
            List<CBGetSignatureResponse.Payload> payload = cBGetSignatureResponse.getPayload();
            if (payload == null) {
                kotlin.g.b.k.a();
            }
            Object url = payload.get(0).getUrl();
            if (url != null) {
                a((Uri) url);
                List<CBGetSignatureResponse.Payload> payload2 = cBGetSignatureResponse.getPayload();
                if (payload2 == null) {
                    kotlin.g.b.k.a();
                }
                if (payload2.get(0).getSupportDocuments() != null) {
                    net.one97.paytm.paymentsBank.chequebook.signatureupdate.a aVar = this.w;
                    if (aVar == null) {
                        kotlin.g.b.k.a("uploadedDocumentAdapter");
                    }
                    List<CBGetSignatureResponse.Payload> payload3 = cBGetSignatureResponse.getPayload();
                    if (payload3 == null) {
                        kotlin.g.b.k.a();
                    }
                    ArrayList arrayList = (ArrayList) payload3.get(0).getSupportDocuments();
                    if (arrayList == null) {
                        kotlin.g.b.k.a();
                    }
                    aVar.a((ArrayList<DocumentCreateResponse.Payload>) arrayList);
                    g();
                    Spinner spinner = (Spinner) a(R.id.spinner);
                    List list = this.C;
                    List<CBGetSignatureResponse.Payload> payload4 = cBGetSignatureResponse.getPayload();
                    if (payload4 == null) {
                        kotlin.g.b.k.a();
                    }
                    spinner.setSelection(kotlin.a.k.a(list, payload4.get(0).getDocumentTypeName()));
                    CBDocumentTypeResponse cBDocumentTypeResponse = this.f17779c;
                    if (cBDocumentTypeResponse == null) {
                        kotlin.g.b.k.a("documentTypeResponse");
                    }
                    List<net.one97.paytm.paymentsBank.chequebook.model.Payload> payload5 = cBDocumentTypeResponse.getPayload();
                    if (payload5 == null) {
                        kotlin.g.b.k.a();
                    }
                    for (net.one97.paytm.paymentsBank.chequebook.model.Payload next : payload5) {
                        String name = next.getName();
                        Spinner spinner2 = (Spinner) a(R.id.spinner);
                        kotlin.g.b.k.a((Object) spinner2, "spinner");
                        if (p.a(name, spinner2.getSelectedItem().toString(), false)) {
                            Integer minimumPage = next.getMinimumPage();
                            if (minimumPage == null) {
                                kotlin.g.b.k.a();
                            }
                            this.t = minimumPage.intValue();
                            Integer maximumPage = next.getMaximumPage();
                            if (maximumPage == null) {
                                kotlin.g.b.k.a();
                            }
                            this.u = maximumPage.intValue();
                            return;
                        }
                    }
                    return;
                }
                return;
            }
            throw new u("null cannot be cast to non-null type android.net.Uri");
        }
    }

    public final void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j2) {
        if (i2 == 0 || adapterView == null) {
            this.s = false;
            RelativeLayout relativeLayout = (RelativeLayout) a(R.id.rl_upload_document);
            kotlin.g.b.k.a((Object) relativeLayout, "rl_upload_document");
            relativeLayout.setVisibility(8);
            TextView textView = (TextView) a(R.id.txt_select_document);
            kotlin.g.b.k.a((Object) textView, "txt_select_document");
            textView.setVisibility(8);
            return;
        }
        this.s = true;
        this.f17778b = adapterView.getItemAtPosition(i2).toString();
        RelativeLayout relativeLayout2 = (RelativeLayout) a(R.id.rl_upload_document);
        kotlin.g.b.k.a((Object) relativeLayout2, "rl_upload_document");
        relativeLayout2.setVisibility(0);
        TextView textView2 = (TextView) a(R.id.txt_select_document);
        kotlin.g.b.k.a((Object) textView2, "txt_select_document");
        textView2.setVisibility(0);
        CBDocumentTypeResponse cBDocumentTypeResponse = this.f17779c;
        if (cBDocumentTypeResponse == null) {
            kotlin.g.b.k.a("documentTypeResponse");
        }
        List<net.one97.paytm.paymentsBank.chequebook.model.Payload> payload = cBDocumentTypeResponse.getPayload();
        if (payload == null) {
            kotlin.g.b.k.a();
        }
        for (net.one97.paytm.paymentsBank.chequebook.model.Payload next : payload) {
            String name = next.getName();
            String str = this.f17778b;
            if (str == null) {
                kotlin.g.b.k.a("selectedDocumentType");
            }
            if (p.a(name, str, false)) {
                Integer minimumPage = next.getMinimumPage();
                if (minimumPage == null) {
                    kotlin.g.b.k.a();
                }
                this.t = minimumPage.intValue();
                Integer maximumPage = next.getMaximumPage();
                if (maximumPage == null) {
                    kotlin.g.b.k.a();
                }
                this.u = maximumPage.intValue();
                return;
            }
        }
    }

    private final void a(Uri uri) {
        RelativeLayout relativeLayout = (RelativeLayout) a(R.id.btn_upload_signature);
        kotlin.g.b.k.a((Object) relativeLayout, "btn_upload_signature");
        relativeLayout.setVisibility(8);
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
        TextView textView = (TextView) a(R.id.tv_change_signature);
        kotlin.g.b.k.a((Object) textView, "tv_change_signature");
        textView.setVisibility(0);
        w.a().a(uri).a(s.NO_CACHE, new s[0]).a((ImageView) a(R.id.iv_signature));
        this.m = true;
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
        this.q = true;
        BankPasscodeActivity.a aVar = BankPasscodeActivity.r;
        String string = getString(R.string.pb_cb_enter_pscd_to_pay_cb, new Object[]{this.z});
        kotlin.g.b.k.a((Object) string, "getString(R.string.pb_cb…pscd_to_pay_cb, cbAmount)");
        String string2 = getString(R.string.pb_cb_issuance_charge_for_leaves, new Object[]{String.valueOf(this.A)});
        kotlin.g.b.k.a((Object) string2, "getString(R.string.pb_cb…ves, cbLeaves.toString())");
        BankPasscodeActivity.a.a((Activity) this, string, string2, 121);
    }

    public final void c() {
        this.D = false;
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
        if (z2) {
            RelativeLayout relativeLayout = (RelativeLayout) a(R.id.btn_upload_signature);
            kotlin.g.b.k.a((Object) relativeLayout, "btn_upload_signature");
            relativeLayout.setVisibility(0);
            TextView textView = (TextView) a(R.id.txt_upload_text);
            kotlin.g.b.k.a((Object) textView, "txt_upload_text");
            textView.setText(getString(R.string.pb_cb_retry_signature_upload));
        } else {
            RelativeLayout relativeLayout2 = (RelativeLayout) a(R.id.btn_upload_signature);
            kotlin.g.b.k.a((Object) relativeLayout2, "btn_upload_signature");
            relativeLayout2.setVisibility(0);
            TextView textView2 = (TextView) a(R.id.txt_upload_text);
            kotlin.g.b.k.a((Object) textView2, "txt_upload_text");
            textView2.setText(getString(R.string.pb_cb_upload_sign_title));
        }
        ImageView imageView = (ImageView) a(R.id.iv_signature);
        kotlin.g.b.k.a((Object) imageView, "iv_signature");
        imageView.setVisibility(8);
        TextView textView3 = (TextView) a(R.id.tv_change_signature);
        kotlin.g.b.k.a((Object) textView3, "tv_change_signature");
        textView3.setVisibility(8);
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
        net.one97.paytm.paymentsBank.chequebook.signatureupdate.a aVar = this.w;
        if (aVar == null) {
            kotlin.g.b.k.a("uploadedDocumentAdapter");
        }
        aVar.a(this.v);
        g();
    }

    private final void g() {
        net.one97.paytm.paymentsBank.chequebook.signatureupdate.a aVar = this.w;
        if (aVar == null) {
            kotlin.g.b.k.a("uploadedDocumentAdapter");
        }
        if (aVar.getItemCount() > 0) {
            RelativeLayout relativeLayout = (RelativeLayout) a(R.id.rl_upload_document);
            kotlin.g.b.k.a((Object) relativeLayout, "rl_upload_document");
            relativeLayout.setVisibility(8);
            RecyclerView recyclerView = (RecyclerView) a(R.id.rv_document_holder);
            kotlin.g.b.k.a((Object) recyclerView, "rv_document_holder");
            recyclerView.setVisibility(0);
            this.n = true;
        } else {
            RelativeLayout relativeLayout2 = (RelativeLayout) a(R.id.rl_upload_document);
            kotlin.g.b.k.a((Object) relativeLayout2, "rl_upload_document");
            relativeLayout2.setVisibility(0);
            RecyclerView recyclerView2 = (RecyclerView) a(R.id.rv_document_holder);
            kotlin.g.b.k.a((Object) recyclerView2, "rv_document_holder");
            recyclerView2.setVisibility(8);
        }
        net.one97.paytm.paymentsBank.chequebook.signatureupdate.a aVar2 = this.w;
        if (aVar2 == null) {
            kotlin.g.b.k.a("uploadedDocumentAdapter");
        }
        if (aVar2.getItemCount() < this.u) {
            TextView textView = (TextView) a(R.id.btn_upload_more);
            kotlin.g.b.k.a((Object) textView, "btn_upload_more");
            textView.setVisibility(0);
            return;
        }
        TextView textView2 = (TextView) a(R.id.btn_upload_more);
        kotlin.g.b.k.a((Object) textView2, "btn_upload_more");
        textView2.setVisibility(4);
    }

    private final void c(boolean z2) {
        Spinner spinner = (Spinner) a(R.id.spinner);
        kotlin.g.b.k.a((Object) spinner, "spinner");
        spinner.setEnabled(z2);
    }

    public static final class b extends AsyncTask<String, Void, String> {

        /* renamed from: a  reason: collision with root package name */
        private final Context f17785a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f17786b;

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
                Context context = this.f17785a;
                if (context == null) {
                    throw new u("null cannot be cast to non-null type net.one97.paytm.paymentsBank.chequebook.signaturelanding.view.SignatureLandingActivity");
                } else if (this.f17786b) {
                    SignatureLandingActivity.a((SignatureLandingActivity) context);
                } else {
                    SignatureLandingActivity.b((SignatureLandingActivity) context);
                }
            }
        }

        public b(Context context, boolean z) {
            kotlin.g.b.k.c(context, "signatureLandingActivity");
            this.f17785a = context;
            this.f17786b = z;
        }
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == this.f17782g) {
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
                    this.f17781e = fromFile;
                    String absolutePath = file.getAbsolutePath();
                    kotlin.g.b.k.a((Object) absolutePath, "f.absolutePath");
                    this.j = absolutePath;
                    new b(this, true).execute(new String[]{file.getAbsolutePath()});
                }
            }
        } else if (i2 == this.f17783h) {
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
                    this.f17781e = fromFile2;
                    String absolutePath2 = file3.getAbsolutePath();
                    kotlin.g.b.k.a((Object) absolutePath2, "f.absolutePath");
                    this.j = absolutePath2;
                    new b(this, false).execute(new String[]{file3.getAbsolutePath()});
                }
            }
        } else if (i2 == 121 && i3 == -1 && intent != null && !TextUtils.isEmpty(intent.getStringExtra("passcode"))) {
            String stringExtra = intent.getStringExtra("passcode");
            kotlin.g.b.k.a((Object) stringExtra, "data.getStringExtra(Paym…Constants.EXTRA_PASSCODE)");
            this.l = stringExtra;
            intent.getStringExtra("passcode");
        }
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
        hVar.a(-3, getString(R.string.ok), new k(this, hVar));
        hVar.show();
    }

    public static final /* synthetic */ void a(SignatureLandingActivity signatureLandingActivity) {
        signatureLandingActivity.D = true;
        String str = signatureLandingActivity.j;
        if (str == null) {
            kotlin.g.b.k.a("filepath");
        }
        if (!TextUtils.isEmpty(str)) {
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            Map map = hashMap;
            String str2 = signatureLandingActivity.j;
            if (str2 == null) {
                kotlin.g.b.k.a("filepath");
            }
            map.put(CommunityPostActivity.TYPE_FILE, new File(str2));
            Map map2 = hashMap2;
            net.one97.paytm.paymentsBank.chequebook.utils.e eVar = net.one97.paytm.paymentsBank.chequebook.utils.e.f17951a;
            String a2 = net.one97.paytm.paymentsBank.chequebook.utils.e.a();
            Context context = signatureLandingActivity;
            String a3 = com.paytm.utility.d.a(context);
            kotlin.g.b.k.a((Object) a3, "CJRNetUtility.getSSOToke…SignatureLandingActivity)");
            map2.put(a2, a3);
            Volley.newRequestQueue(context).add(new net.one97.paytm.paymentsBank.chequebook.utils.j(context, "https://productpref-ite.paytmbank.com/pps/ext/v1/signatures", signatureLandingActivity, signatureLandingActivity, new SignatureCreateResponse(), map, map2));
            signatureLandingActivity.a(true);
        }
    }

    public static final /* synthetic */ void b(SignatureLandingActivity signatureLandingActivity) {
        StringBuilder sb = new StringBuilder("https://productpref-ite.paytmbank.com/pps/ext/v1/signature/");
        String str = signatureLandingActivity.k;
        if (str == null) {
            kotlin.g.b.k.a("signImageID");
        }
        sb.append(str);
        sb.append("/support-documents?documentType=");
        String str2 = signatureLandingActivity.f17778b;
        if (str2 == null) {
            kotlin.g.b.k.a("selectedDocumentType");
        }
        sb.append(str2);
        String sb2 = sb.toString();
        String str3 = signatureLandingActivity.j;
        if (str3 == null) {
            kotlin.g.b.k.a("filepath");
        }
        if (!TextUtils.isEmpty(str3)) {
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            Map map = hashMap;
            String str4 = signatureLandingActivity.j;
            if (str4 == null) {
                kotlin.g.b.k.a("filepath");
            }
            map.put(CommunityPostActivity.TYPE_FILE, new File(str4));
            Map map2 = hashMap2;
            net.one97.paytm.paymentsBank.chequebook.utils.e eVar = net.one97.paytm.paymentsBank.chequebook.utils.e.f17951a;
            String a2 = net.one97.paytm.paymentsBank.chequebook.utils.e.a();
            Context context = signatureLandingActivity;
            String a3 = com.paytm.utility.d.a(context);
            kotlin.g.b.k.a((Object) a3, "CJRNetUtility.getSSOToke…SignatureLandingActivity)");
            map2.put(a2, a3);
            Volley.newRequestQueue(context).add(new net.one97.paytm.paymentsBank.chequebook.utils.j(context, sb2, signatureLandingActivity, signatureLandingActivity, new DocumentCreateResponse(), map, map2));
            signatureLandingActivity.a(true);
        }
    }

    public static final /* synthetic */ void a(SignatureLandingActivity signatureLandingActivity, boolean z2) {
        if (com.paytm.utility.s.a()) {
            Activity activity = signatureLandingActivity;
            if (!com.paytm.utility.s.c(activity)) {
                com.paytm.utility.s.b(activity);
                return;
            }
        }
        String str = Environment.getExternalStorageDirectory().toString() + "/Android/data/" + signatureLandingActivity.getPackageName();
        if (z2) {
            CropImage.a().a(PBCropImageView.c.ON).a(str).a(signatureLandingActivity, signatureLandingActivity.f17782g);
        } else {
            CropImage.a().a(PBCropImageView.c.ON).a(str).a(signatureLandingActivity, signatureLandingActivity.f17783h);
        }
    }

    public static final /* synthetic */ boolean e(SignatureLandingActivity signatureLandingActivity) {
        net.one97.paytm.paymentsBank.chequebook.signatureupdate.a aVar = signatureLandingActivity.w;
        if (aVar == null) {
            kotlin.g.b.k.a("uploadedDocumentAdapter");
        }
        return aVar.getItemCount() >= signatureLandingActivity.t;
    }

    public static final /* synthetic */ void a(SignatureLandingActivity signatureLandingActivity, String str) {
        a.C0285a f2 = signatureLandingActivity.f();
        String str2 = signatureLandingActivity.k;
        if (str2 == null) {
            kotlin.g.b.k.a("signImageID");
        }
        f2.a(str, str2);
    }
}
