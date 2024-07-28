package net.one97.paytm.paymentsBank.slfd.tds.view;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.appsflyer.internal.referrer.Payload;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.bankCommon.activity.PBBaseActivity;
import net.one97.paytm.bankCommon.model.auth.CJRUserDefaultInfo;
import net.one97.paytm.bankCommon.model.auth.CJRUserInfoV2;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.slfd.tds.modal.CertificateResponseModal;
import net.one97.paytm.paymentsBank.utils.o;

public final class TDSCertificateActivity extends PBBaseActivity implements net.one97.paytm.bankCommon.f.d {

    /* renamed from: b  reason: collision with root package name */
    public static final a f19343b = new a((byte) 0);

    /* renamed from: c  reason: collision with root package name */
    private int f19344c = 2016;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public String f19345d = "";
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public String f19346e = "";
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public String f19347f = "Q1";

    /* renamed from: g  reason: collision with root package name */
    private TextInputLayout f19348g;

    /* renamed from: h  reason: collision with root package name */
    private TextInputLayout f19349h;

    /* renamed from: i  reason: collision with root package name */
    private TextInputLayout f19350i;
    private TextInputEditText j;
    private TextInputEditText k;
    private TextInputEditText l;
    private TextView m;
    private net.one97.paytm.paymentsBank.slfd.tds.a.a.a n;
    private net.one97.paytm.paymentsBank.slfd.tds.a o;
    private String p = "";
    private CJRUserInfoV2 q;
    /* access modifiers changed from: private */
    public ArrayList<String> r;
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

    public static final /* synthetic */ net.one97.paytm.paymentsBank.slfd.tds.a.a.a c(TDSCertificateActivity tDSCertificateActivity) {
        net.one97.paytm.paymentsBank.slfd.tds.a.a.a aVar = tDSCertificateActivity.n;
        if (aVar == null) {
            kotlin.g.b.k.a("certificateUIConfiguration");
        }
        return aVar;
    }

    public static final /* synthetic */ net.one97.paytm.paymentsBank.slfd.tds.a d(TDSCertificateActivity tDSCertificateActivity) {
        net.one97.paytm.paymentsBank.slfd.tds.a aVar = tDSCertificateActivity.o;
        if (aVar == null) {
            kotlin.g.b.k.a("certificateManager");
        }
        return aVar;
    }

    public static final /* synthetic */ TextInputLayout i(TDSCertificateActivity tDSCertificateActivity) {
        TextInputLayout textInputLayout = tDSCertificateActivity.f19349h;
        if (textInputLayout == null) {
            kotlin.g.b.k.a("til_2");
        }
        return textInputLayout;
    }

    public static final /* synthetic */ TextInputLayout j(TDSCertificateActivity tDSCertificateActivity) {
        TextInputLayout textInputLayout = tDSCertificateActivity.f19348g;
        if (textInputLayout == null) {
            kotlin.g.b.k.a("til_1");
        }
        return textInputLayout;
    }

    public static final /* synthetic */ TextInputLayout k(TDSCertificateActivity tDSCertificateActivity) {
        TextInputLayout textInputLayout = tDSCertificateActivity.f19350i;
        if (textInputLayout == null) {
            kotlin.g.b.k.a("til_3");
        }
        return textInputLayout;
    }

    public final void onFragmentAction(int i2, Object obj) {
        if (i2 == 109) {
            TextInputLayout textInputLayout = this.f19348g;
            if (textInputLayout == null) {
                kotlin.g.b.k.a("til_1");
            }
            textInputLayout.setError((CharSequence) null);
            this.f19345d = String.valueOf(obj);
            ((TextInputEditText) a(R.id.financial_year_et)).setText(this.f19345d);
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.pb_tds_activity);
        Context context = this;
        net.one97.paytm.paymentsBank.slfd.tds.a a2 = net.one97.paytm.paymentsBank.slfd.tds.a.a(context);
        kotlin.g.b.k.a((Object) a2, "CertificateManager.getCe…cateManagerInstance(this)");
        this.o = a2;
        View findViewById = findViewById(R.id.financial_year_til);
        kotlin.g.b.k.a((Object) findViewById, "findViewById(R.id.financial_year_til)");
        this.f19348g = (TextInputLayout) findViewById;
        View findViewById2 = findViewById(R.id.financial_quarter_til);
        kotlin.g.b.k.a((Object) findViewById2, "findViewById(R.id.financial_quarter_til)");
        this.f19349h = (TextInputLayout) findViewById2;
        View findViewById3 = findViewById(R.id.email_til);
        kotlin.g.b.k.a((Object) findViewById3, "findViewById(R.id.email_til)");
        this.f19350i = (TextInputLayout) findViewById3;
        View findViewById4 = findViewById(R.id.financial_year_et);
        kotlin.g.b.k.a((Object) findViewById4, "findViewById(R.id.financial_year_et)");
        this.j = (TextInputEditText) findViewById4;
        View findViewById5 = findViewById(R.id.financial_quarter_et);
        kotlin.g.b.k.a((Object) findViewById5, "findViewById(R.id.financial_quarter_et)");
        this.k = (TextInputEditText) findViewById5;
        View findViewById6 = findViewById(R.id.email_et);
        kotlin.g.b.k.a((Object) findViewById6, "findViewById(R.id.email_et)");
        this.l = (TextInputEditText) findViewById6;
        View findViewById7 = findViewById(R.id.textView);
        kotlin.g.b.k.a((Object) findViewById7, "findViewById(R.id.textView)");
        this.m = (TextView) findViewById7;
        Serializable serializableExtra = getIntent().getSerializableExtra("extra_certificate_ui_config");
        if (serializableExtra != null) {
            this.n = (net.one97.paytm.paymentsBank.slfd.tds.a.a.a) serializableExtra;
            net.one97.paytm.paymentsBank.slfd.tds.a.a.a aVar = this.n;
            if (aVar == null) {
                kotlin.g.b.k.a("certificateUIConfiguration");
            }
            net.one97.paytm.paymentsBank.slfd.tds.a.a.b bVar = new net.one97.paytm.paymentsBank.slfd.tds.a.a.b(context, aVar);
            net.one97.paytm.paymentsBank.slfd.tds.a.a.a aVar2 = net.one97.paytm.paymentsBank.slfd.tds.a.a.a.INTEREST_CERTIFICATE;
            net.one97.paytm.paymentsBank.slfd.tds.a.a.a aVar3 = this.n;
            if (aVar3 == null) {
                kotlin.g.b.k.a("certificateUIConfiguration");
            }
            if (aVar2.equals(aVar3)) {
                int i2 = 1;
                for (String next : bVar.a()) {
                    if (i2 == 1) {
                        TextInputLayout textInputLayout = this.f19348g;
                        if (textInputLayout == null) {
                            kotlin.g.b.k.a("til_1");
                        }
                        textInputLayout.setHint(next);
                    }
                    if (i2 == 2) {
                        TextInputLayout textInputLayout2 = this.f19350i;
                        if (textInputLayout2 == null) {
                            kotlin.g.b.k.a("til_3");
                        }
                        textInputLayout2.setHint(next);
                    }
                    i2++;
                }
                TextInputLayout textInputLayout3 = this.f19349h;
                if (textInputLayout3 == null) {
                    kotlin.g.b.k.a("til_2");
                }
                textInputLayout3.setVisibility(8);
            } else {
                net.one97.paytm.paymentsBank.slfd.tds.a.a.a aVar4 = net.one97.paytm.paymentsBank.slfd.tds.a.a.a.TDS_CERTIFICATE;
                net.one97.paytm.paymentsBank.slfd.tds.a.a.a aVar5 = this.n;
                if (aVar5 == null) {
                    kotlin.g.b.k.a("certificateUIConfiguration");
                }
                if (aVar4.equals(aVar5)) {
                    int i3 = 1;
                    for (String next2 : bVar.a()) {
                        if (i3 == 1) {
                            TextInputLayout textInputLayout4 = this.f19348g;
                            if (textInputLayout4 == null) {
                                kotlin.g.b.k.a("til_1");
                            }
                            textInputLayout4.setHint(next2);
                        }
                        if (i3 == 2) {
                            TextInputLayout textInputLayout5 = this.f19349h;
                            if (textInputLayout5 == null) {
                                kotlin.g.b.k.a("til_2");
                            }
                            textInputLayout5.setHint(next2);
                        }
                        if (i3 == 3) {
                            TextInputLayout textInputLayout6 = this.f19350i;
                            if (textInputLayout6 == null) {
                                kotlin.g.b.k.a("til_3");
                            }
                            textInputLayout6.setHint(next2);
                        }
                        i3++;
                    }
                }
            }
            TextView textView = this.m;
            if (textView == null) {
                kotlin.g.b.k.a("titleTV");
            }
            textView.setText(bVar.b());
            Calendar instance = Calendar.getInstance();
            int i4 = instance.get(1);
            int i5 = instance.get(2);
            this.r = new ArrayList<>();
            ArrayList<String> arrayList = this.r;
            if (arrayList != null) {
                arrayList.add(getString(R.string.pb_tds_quarter_one));
            }
            ArrayList<String> arrayList2 = this.r;
            if (arrayList2 != null) {
                arrayList2.add(getString(R.string.pb_tds_quarter_two));
            }
            ArrayList<String> arrayList3 = this.r;
            if (arrayList3 != null) {
                arrayList3.add(getString(R.string.pb_tds_quarter_three));
            }
            ArrayList<String> arrayList4 = this.r;
            if (arrayList4 != null) {
                arrayList4.add(getString(R.string.pb_tds_quarter_four));
            }
            int i6 = 0;
            String str = null;
            if (i5 <= 2) {
                i4--;
                ArrayList<String> arrayList5 = this.r;
                if (arrayList5 != null) {
                    str = arrayList5.get(2);
                }
                this.f19346e = String.valueOf(str);
            } else if (3 <= i5 && 5 >= i5) {
                ArrayList<String> arrayList6 = this.r;
                if (arrayList6 != null) {
                    str = arrayList6.get(3);
                }
                this.f19346e = String.valueOf(str);
            } else if (6 <= i5 && 8 >= i5) {
                ArrayList<String> arrayList7 = this.r;
                if (arrayList7 != null) {
                    str = arrayList7.get(0);
                }
                this.f19346e = String.valueOf(str);
            } else if (9 <= i5 && 11 >= i5) {
                ArrayList<String> arrayList8 = this.r;
                if (arrayList8 != null) {
                    str = arrayList8.get(1);
                }
                this.f19346e = String.valueOf(str);
            }
            this.f19344c = i4;
            int i7 = this.f19344c + 1;
            net.one97.paytm.paymentsBank.slfd.tds.a.a.a aVar6 = net.one97.paytm.paymentsBank.slfd.tds.a.a.a.TDS_CERTIFICATE;
            net.one97.paytm.paymentsBank.slfd.tds.a.a.a aVar7 = this.n;
            if (aVar7 == null) {
                kotlin.g.b.k.a("certificateUIConfiguration");
            }
            if (aVar6.equals(aVar7)) {
                if (3 <= i5 && 5 >= i5) {
                    this.f19345d = String.valueOf(this.f19344c - 1) + "-" + (i7 - 1);
                } else {
                    this.f19345d = String.valueOf(this.f19344c) + "-" + i7;
                }
                ((TextInputEditText) a(R.id.financial_quarter_et)).setText(this.f19346e);
            } else {
                this.f19345d = String.valueOf(this.f19344c - 1) + "-" + (i7 - 1);
            }
            ((TextInputEditText) a(R.id.financial_year_et)).setText(this.f19345d);
            ArrayList<String> arrayList9 = this.r;
            if (arrayList9 == null) {
                kotlin.g.b.k.a();
            }
            Iterator<String> it2 = arrayList9.iterator();
            while (it2.hasNext()) {
                i6++;
                if (it2.next().equals(this.f19346e)) {
                    this.f19347f = "Q" + String.valueOf(i6);
                }
            }
            ((TextInputEditText) a(R.id.financial_year_et)).setOnClickListener(new b(this));
            ((TextInputEditText) a(R.id.financial_quarter_et)).setOnClickListener(new c(this));
            ((TextInputLayout) a(R.id.financial_year_til)).setOnClickListener(new d(this));
            ((TextInputLayout) a(R.id.financial_quarter_til)).setOnClickListener(new e(this));
            ((TextInputEditText) a(R.id.email_et)).setOnClickListener(new f(this));
            ((TextInputLayout) a(R.id.email_til)).setOnClickListener(new g(this));
            ((ImageView) a(R.id.imageView2)).setOnClickListener(new h(this));
            ((Button) a(R.id.button)).setOnClickListener(new i(this));
            TextInputEditText textInputEditText = this.j;
            if (textInputEditText == null) {
                kotlin.g.b.k.a("tie_1");
            }
            textInputEditText.addTextChangedListener(new k(this));
            TextInputEditText textInputEditText2 = this.k;
            if (textInputEditText2 == null) {
                kotlin.g.b.k.a("tie_2");
            }
            textInputEditText2.addTextChangedListener(new l(this));
            TextInputEditText textInputEditText3 = this.l;
            if (textInputEditText3 == null) {
                kotlin.g.b.k.a("tie_3");
            }
            textInputEditText3.addTextChangedListener(new m(this));
            return;
        }
        throw new u("null cannot be cast to non-null type net.one97.paytm.paymentsBank.slfd.tds.config.ui.CertificateUIConfiguration");
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TDSCertificateActivity f19351a;

        b(TDSCertificateActivity tDSCertificateActivity) {
            this.f19351a = tDSCertificateActivity;
        }

        public final void onClick(View view) {
            this.f19351a.e();
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TDSCertificateActivity f19352a;

        c(TDSCertificateActivity tDSCertificateActivity) {
            this.f19352a = tDSCertificateActivity;
        }

        public final void onClick(View view) {
            this.f19352a.f();
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TDSCertificateActivity f19353a;

        d(TDSCertificateActivity tDSCertificateActivity) {
            this.f19353a = tDSCertificateActivity;
        }

        public final void onClick(View view) {
            this.f19353a.e();
        }
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TDSCertificateActivity f19354a;

        e(TDSCertificateActivity tDSCertificateActivity) {
            this.f19354a = tDSCertificateActivity;
        }

        public final void onClick(View view) {
            this.f19354a.f();
        }
    }

    static final class f implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TDSCertificateActivity f19355a;

        f(TDSCertificateActivity tDSCertificateActivity) {
            this.f19355a = tDSCertificateActivity;
        }

        public final void onClick(View view) {
            TDSCertificateActivity.a(this.f19355a);
        }
    }

    static final class g implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TDSCertificateActivity f19356a;

        g(TDSCertificateActivity tDSCertificateActivity) {
            this.f19356a = tDSCertificateActivity;
        }

        public final void onClick(View view) {
            TDSCertificateActivity.a(this.f19356a);
        }
    }

    static final class h implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TDSCertificateActivity f19357a;

        h(TDSCertificateActivity tDSCertificateActivity) {
            this.f19357a = tDSCertificateActivity;
        }

        public final void onClick(View view) {
            this.f19357a.onBackPressed();
        }
    }

    static final class i implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TDSCertificateActivity f19358a;

        i(TDSCertificateActivity tDSCertificateActivity) {
            this.f19358a = tDSCertificateActivity;
        }

        public final void onClick(View view) {
            if (TDSCertificateActivity.b(this.f19358a)) {
                if (com.paytm.utility.b.c((Context) this.f19358a)) {
                    TDSCertificateActivity tDSCertificateActivity = this.f19358a;
                    com.paytm.utility.b.k(tDSCertificateActivity, tDSCertificateActivity.getString(R.string.please_wait));
                    if (net.one97.paytm.paymentsBank.slfd.tds.a.a.a.TDS_CERTIFICATE.equals(TDSCertificateActivity.c(this.f19358a))) {
                        net.one97.paytm.paymentsBank.slfd.tds.a d2 = TDSCertificateActivity.d(this.f19358a);
                        String e2 = this.f19358a.f19345d;
                        String f2 = this.f19358a.f19347f;
                        TDSCertificateActivity tDSCertificateActivity2 = this.f19358a;
                        d2.a(e2, f2, tDSCertificateActivity2, tDSCertificateActivity2);
                    } else if (net.one97.paytm.paymentsBank.slfd.tds.a.a.a.INTEREST_CERTIFICATE.equals(TDSCertificateActivity.c(this.f19358a))) {
                        net.one97.paytm.paymentsBank.slfd.tds.a d3 = TDSCertificateActivity.d(this.f19358a);
                        String e3 = this.f19358a.f19345d;
                        TDSCertificateActivity tDSCertificateActivity3 = this.f19358a;
                        d3.a(e3, tDSCertificateActivity3, tDSCertificateActivity3);
                    }
                } else {
                    this.f19358a.d();
                }
            }
        }
    }

    public final void onResume() {
        super.onResume();
        g();
    }

    public final void e() {
        ArrayList arrayList = new ArrayList();
        for (int i2 = this.f19344c; i2 > 2016; i2 += -1) {
            arrayList.add(String.valueOf(i2) + "-" + (i2 + 1));
        }
        Bundle bundle = new Bundle();
        bundle.putSerializable("year_list", arrayList);
        bundle.putString("selectedYear", this.f19345d);
        bundle.putString("title", getString(R.string.pb_tds_select_financial_year));
        bundle.putInt("columnCount", 3);
        c cVar = new c();
        cVar.setArguments(bundle);
        cVar.a((net.one97.paytm.bankCommon.f.d) this);
        cVar.show(getSupportFragmentManager(), "TDS_BSDF");
    }

    private void g() {
        Context context = this;
        a(context, getString(R.string.please_wait));
        StringBuilder sb = new StringBuilder();
        kotlin.g.b.k.a((Object) net.one97.paytm.bankCommon.mapping.g.a(), "GTMLoader.getInstance(this)");
        sb.append(net.one97.paytm.bankCommon.utils.d.c());
        net.one97.paytm.paymentsBank.h.a a2 = o.a();
        kotlin.g.b.k.a((Object) a2, "PaymentsBankHelper.getImplListener()");
        sb.append(a2.getFetchStrategyParamsForUserInfo());
        String sb2 = sb.toString();
        HashMap hashMap = new HashMap();
        hashMap.put("screen_name", getClass().getSimpleName());
        getApplicationContext();
        net.one97.paytm.bankCommon.g.c.a();
        net.one97.paytm.bankCommon.g.c.a(new net.one97.paytm.bankCommon.g.a(sb2, this, this, new CJRUserInfoV2(), net.one97.paytm.bankCommon.mapping.d.d(context), a.c.PAYMENTSBANK, a.b.SILENT, hashMap));
    }

    public final void f() {
        Bundle bundle = new Bundle();
        bundle.putSerializable("year_list", this.r);
        bundle.putString("selectedYear", this.f19346e);
        bundle.putString("title", getString(R.string.pb_tds_select_financial_quarter));
        bundle.putInt("columnCount", 2);
        c cVar = new c();
        cVar.setArguments(bundle);
        cVar.a((net.one97.paytm.bankCommon.f.d) new j(this));
        cVar.show(getSupportFragmentManager(), "TDS_BSDF");
    }

    public static final class j implements net.one97.paytm.bankCommon.f.d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TDSCertificateActivity f19359a;

        j(TDSCertificateActivity tDSCertificateActivity) {
            this.f19359a = tDSCertificateActivity;
        }

        public final void onFragmentAction(int i2, Object obj) {
            if (i2 == 109) {
                this.f19359a.f19346e = String.valueOf(obj);
                ((TextInputEditText) this.f19359a.a(R.id.financial_quarter_et)).setText(this.f19359a.f19346e);
                int i3 = 0;
                ArrayList h2 = this.f19359a.r;
                if (h2 == null) {
                    kotlin.g.b.k.a();
                }
                Iterator it2 = h2.iterator();
                while (it2.hasNext()) {
                    i3++;
                    if (((String) it2.next()).equals(this.f19359a.f19346e)) {
                        TDSCertificateActivity.i(this.f19359a).setError((CharSequence) null);
                        TDSCertificateActivity tDSCertificateActivity = this.f19359a;
                        tDSCertificateActivity.f19347f = "Q" + String.valueOf(i3);
                    }
                }
            }
        }
    }

    /* renamed from: a_ */
    public final void onResponse(IJRPaytmDataModel iJRPaytmDataModel) {
        kotlin.g.b.k.c(iJRPaytmDataModel, Payload.RESPONSE);
        ah_();
        try {
            com.paytm.utility.b.Z((Context) this);
            if (iJRPaytmDataModel instanceof CertificateResponseModal) {
                CertificateResponseModal certificateResponseModal = (CertificateResponseModal) iJRPaytmDataModel;
                if (p.a(certificateResponseModal.getStatus(), ImagePickerUtils.IMAGE_PICKER_KEY_STATUS_FAILURE, true)) {
                    com.paytm.utility.b.b((Context) this, getString(R.string.error), certificateResponseModal.getMessage());
                } else if (p.a(certificateResponseModal.getStatus(), "success", true)) {
                    Bundle bundle = new Bundle();
                    String str = "";
                    net.one97.paytm.paymentsBank.slfd.tds.a.a.a aVar = net.one97.paytm.paymentsBank.slfd.tds.a.a.a.TDS_CERTIFICATE;
                    net.one97.paytm.paymentsBank.slfd.tds.a.a.a aVar2 = this.n;
                    if (aVar2 == null) {
                        kotlin.g.b.k.a("certificateUIConfiguration");
                    }
                    if (aVar.equals(aVar2)) {
                        str = getString(R.string.pb_tds_certificate_of_tds_success);
                        kotlin.g.b.k.a((Object) str, "getString(R.string.pb_td…rtificate_of_tds_success)");
                    } else {
                        net.one97.paytm.paymentsBank.slfd.tds.a.a.a aVar3 = net.one97.paytm.paymentsBank.slfd.tds.a.a.a.INTEREST_CERTIFICATE;
                        net.one97.paytm.paymentsBank.slfd.tds.a.a.a aVar4 = this.n;
                        if (aVar4 == null) {
                            kotlin.g.b.k.a("certificateUIConfiguration");
                        }
                        if (aVar3.equals(aVar4)) {
                            str = getString(R.string.pb_tds_certificate_of_interest_success);
                            kotlin.g.b.k.a((Object) str, "getString(R.string.pb_td…cate_of_interest_success)");
                        }
                    }
                    bundle.putString("EXTRA_CERTIFICATE_CONFIRMATION_BOTTOM_SHEET_TITLE", str);
                    bundle.putString("email_extra", this.p);
                    a aVar5 = new a();
                    aVar5.setArguments(bundle);
                    aVar5.show(getSupportFragmentManager(), "TDS_BSDF");
                }
            } else if (iJRPaytmDataModel instanceof CJRUserInfoV2) {
                this.q = (CJRUserInfoV2) iJRPaytmDataModel;
                CJRUserDefaultInfo userDefaultInfo = ((CJRUserInfoV2) iJRPaytmDataModel).getUserDefaultInfo();
                kotlin.g.b.k.a((Object) userDefaultInfo, "response.userDefaultInfo");
                String email = userDefaultInfo.getEmail();
                kotlin.g.b.k.a((Object) email, "response.userDefaultInfo.email");
                this.p = email;
                if (!TextUtils.isEmpty(this.p)) {
                    TextInputEditText textInputEditText = this.l;
                    if (textInputEditText == null) {
                        kotlin.g.b.k.a("tie_3");
                    }
                    textInputEditText.setText(this.p);
                }
            }
        } catch (Exception unused) {
        }
    }

    public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        kotlin.g.b.k.c(iJRPaytmDataModel, "model");
        kotlin.g.b.k.c(networkCustomError, "error");
        try {
            com.paytm.utility.b.Z((Context) this);
            net.one97.paytm.bankCommon.utils.f.a((Context) this, networkCustomError, i2);
        } catch (Exception unused) {
        }
    }

    public static final class k implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TDSCertificateActivity f19360a;

        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        k(TDSCertificateActivity tDSCertificateActivity) {
            this.f19360a = tDSCertificateActivity;
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            TDSCertificateActivity.j(this.f19360a).setError((CharSequence) null);
            TDSCertificateActivity.j(this.f19360a).setErrorEnabled(false);
        }
    }

    public static final class l implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TDSCertificateActivity f19361a;

        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        l(TDSCertificateActivity tDSCertificateActivity) {
            this.f19361a = tDSCertificateActivity;
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            TDSCertificateActivity.i(this.f19361a).setError((CharSequence) null);
            TDSCertificateActivity.i(this.f19361a).setErrorEnabled(false);
        }
    }

    public static final class m implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TDSCertificateActivity f19362a;

        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        m(TDSCertificateActivity tDSCertificateActivity) {
            this.f19362a = tDSCertificateActivity;
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            TDSCertificateActivity.k(this.f19362a).setError((CharSequence) null);
            TDSCertificateActivity.i(this.f19362a).setErrorEnabled(false);
        }
    }

    public static final /* synthetic */ void a(TDSCertificateActivity tDSCertificateActivity) {
        CJRUserInfoV2 cJRUserInfoV2 = tDSCertificateActivity.q;
        if (cJRUserInfoV2 != null) {
            if (cJRUserInfoV2 == null) {
                kotlin.g.b.k.a();
            }
            if (cJRUserInfoV2.getUserDefaultInfo() != null) {
                o.a().openEmailUpdatePage(tDSCertificateActivity, tDSCertificateActivity.q);
                return;
            }
        }
        tDSCertificateActivity.g();
    }

    public static final /* synthetic */ boolean b(TDSCertificateActivity tDSCertificateActivity) {
        net.one97.paytm.paymentsBank.slfd.tds.a.a.a aVar = net.one97.paytm.paymentsBank.slfd.tds.a.a.a.TDS_CERTIFICATE;
        net.one97.paytm.paymentsBank.slfd.tds.a.a.a aVar2 = tDSCertificateActivity.n;
        if (aVar2 == null) {
            kotlin.g.b.k.a("certificateUIConfiguration");
        }
        if (!aVar.equals(aVar2)) {
            net.one97.paytm.paymentsBank.slfd.tds.a.a.a aVar3 = net.one97.paytm.paymentsBank.slfd.tds.a.a.a.INTEREST_CERTIFICATE;
            net.one97.paytm.paymentsBank.slfd.tds.a.a.a aVar4 = tDSCertificateActivity.n;
            if (aVar4 == null) {
                kotlin.g.b.k.a("certificateUIConfiguration");
            }
            if (!aVar3.equals(aVar4)) {
                return false;
            }
            if (TextUtils.isEmpty(tDSCertificateActivity.f19345d)) {
                TextInputLayout textInputLayout = tDSCertificateActivity.f19348g;
                if (textInputLayout == null) {
                    kotlin.g.b.k.a("til_1");
                }
                textInputLayout.setErrorEnabled(true);
                TextInputLayout textInputLayout2 = tDSCertificateActivity.f19348g;
                if (textInputLayout2 == null) {
                    kotlin.g.b.k.a("til_1");
                }
                textInputLayout2.setError(tDSCertificateActivity.getString(R.string.pb_tds_select_valid_financial_year));
                return false;
            } else if (!TextUtils.isEmpty(tDSCertificateActivity.p)) {
                return true;
            } else {
                TextInputLayout textInputLayout3 = tDSCertificateActivity.f19350i;
                if (textInputLayout3 == null) {
                    kotlin.g.b.k.a("til_3");
                }
                textInputLayout3.setErrorEnabled(true);
                TextInputLayout textInputLayout4 = tDSCertificateActivity.f19350i;
                if (textInputLayout4 == null) {
                    kotlin.g.b.k.a("til_3");
                }
                textInputLayout4.setError(tDSCertificateActivity.getString(R.string.pb_tds_email_error));
                return false;
            }
        } else if (TextUtils.isEmpty(tDSCertificateActivity.f19345d)) {
            TextInputLayout textInputLayout5 = tDSCertificateActivity.f19348g;
            if (textInputLayout5 == null) {
                kotlin.g.b.k.a("til_1");
            }
            textInputLayout5.setErrorEnabled(true);
            TextInputLayout textInputLayout6 = tDSCertificateActivity.f19348g;
            if (textInputLayout6 == null) {
                kotlin.g.b.k.a("til_1");
            }
            textInputLayout6.setError(tDSCertificateActivity.getString(R.string.pb_tds_select_valid_financial_year));
            return false;
        } else if (TextUtils.isEmpty(tDSCertificateActivity.f19346e)) {
            TextInputLayout textInputLayout7 = tDSCertificateActivity.f19349h;
            if (textInputLayout7 == null) {
                kotlin.g.b.k.a("til_2");
            }
            textInputLayout7.setErrorEnabled(true);
            TextInputLayout textInputLayout8 = tDSCertificateActivity.f19349h;
            if (textInputLayout8 == null) {
                kotlin.g.b.k.a("til_2");
            }
            textInputLayout8.setError(tDSCertificateActivity.getString(R.string.pb_tds_valid_quarter));
            return false;
        } else if (!TextUtils.isEmpty(tDSCertificateActivity.p)) {
            return true;
        } else {
            TextInputLayout textInputLayout9 = tDSCertificateActivity.f19350i;
            if (textInputLayout9 == null) {
                kotlin.g.b.k.a("til_3");
            }
            textInputLayout9.setErrorEnabled(true);
            TextInputLayout textInputLayout10 = tDSCertificateActivity.f19350i;
            if (textInputLayout10 == null) {
                kotlin.g.b.k.a("til_3");
            }
            textInputLayout10.setError(tDSCertificateActivity.getString(R.string.pb_tds_email_error));
            return false;
        }
    }
}
