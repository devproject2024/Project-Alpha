package net.one97.paytm.upgradeKyc.form60.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.InputFilter;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.core.content.b;
import androidx.fragment.app.Fragment;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.RoboTextView;
import com.paytm.utility.g;
import com.paytm.utility.q;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import net.one97.paytm.common.entity.auth.TncData;
import net.one97.paytm.common.entity.upgradeKyc.KYCForm60;
import net.one97.paytm.upgradeKyc.R;
import net.one97.paytm.upgradeKyc.activity.UpgradeKycBaseActivity;
import net.one97.paytm.upgradeKyc.d.m;
import net.one97.paytm.upgradeKyc.form60.a.a;
import net.one97.paytm.upgradeKyc.utils.d;
import net.one97.paytm.upgradeKyc.utils.f;
import net.one97.paytm.upgradeKyc.utils.l;

public class FillForm60Activity extends UpgradeKycBaseActivity implements View.OnClickListener, View.OnFocusChangeListener, a.c, d.a {

    /* renamed from: a  reason: collision with root package name */
    String f66006a = null;

    /* renamed from: b  reason: collision with root package name */
    String f66007b = null;

    /* renamed from: d  reason: collision with root package name */
    TextWatcher f66008d = new TextWatcher() {
        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            FillForm60Activity.this.q.setError((CharSequence) null);
            if (i3 == 0) {
                if (charSequence.length() == 2 || charSequence.length() == 5) {
                    TextInputEditText b2 = FillForm60Activity.this.n;
                    b2.setText(FillForm60Activity.this.n.getText() + "/");
                    FillForm60Activity.this.n.setSelection(FillForm60Activity.this.n.getText().length());
                }
                if (FillForm60Activity.this.n.getText().length() == 10) {
                    try {
                        int parseInt = Integer.parseInt(FillForm60Activity.this.n.getText().toString().substring(FillForm60Activity.this.n.getText().length() - 4));
                        Calendar unused = FillForm60Activity.this.r = Calendar.getInstance();
                        FillForm60Activity.this.r.set(1, parseInt);
                    } catch (NumberFormatException unused2) {
                    }
                }
            }
        }
    };

    /* renamed from: e  reason: collision with root package name */
    private a.b f66009e;

    /* renamed from: f  reason: collision with root package name */
    private TextInputEditText f66010f;

    /* renamed from: g  reason: collision with root package name */
    private TextInputEditText f66011g;

    /* renamed from: h  reason: collision with root package name */
    private ScrollView f66012h;

    /* renamed from: i  reason: collision with root package name */
    private final String f66013i = FillForm60Activity.class.getName();
    /* access modifiers changed from: private */
    public TextInputLayout j;
    /* access modifiers changed from: private */
    public TextInputLayout k;
    private RadioGroup l;
    private KYCForm60 m;
    /* access modifiers changed from: private */
    public TextInputEditText n;
    private TextInputEditText o;
    /* access modifiers changed from: private */
    public TextInputLayout p;
    /* access modifiers changed from: private */
    public TextInputLayout q;
    /* access modifiers changed from: private */
    public Calendar r;
    private RoboTextView s;
    /* access modifiers changed from: private */
    public ArrayList<TncData> t;
    private LottieAnimationView u;
    private TextWatcher v = new TextWatcher() {
        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            FillForm60Activity.this.p.setError("");
        }
    };

    /* access modifiers changed from: private */
    public static /* synthetic */ void j() {
    }

    public final Activity aD_() {
        return this;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getSupportActionBar() != null) {
            getSupportActionBar().a(0.0f);
        }
        this.f66009e = new net.one97.paytm.upgradeKyc.form60.b.a(this);
        this.f66009e.e();
        this.u = (LottieAnimationView) findViewById(R.id.wallet_loader);
        this.f66012h = (ScrollView) findViewById(R.id.form60_parent_sv);
        this.l = (RadioGroup) findViewById(R.id.layout_kyc_have_applied_pan);
        this.f66010f = (TextInputEditText) findViewById(R.id.agricultureEt);
        this.f66011g = (TextInputEditText) findViewById(R.id.nonAgricultureEt);
        this.j = (TextInputLayout) findViewById(R.id.agricultureInputLayout);
        this.k = (TextInputLayout) findViewById(R.id.nonAgricultureInputLayout);
        TextView textView = (TextView) findViewById(R.id.tnc_set_form60_tv);
        this.s = (RoboTextView) findViewById(R.id.form60detailsSubmit);
        this.f66010f.addTextChangedListener(new TextWatcher() {
            public final void afterTextChanged(Editable editable) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                FillForm60Activity.this.j.setError("");
            }
        });
        this.f66011g.addTextChangedListener(new TextWatcher() {
            public final void afterTextChanged(Editable editable) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                FillForm60Activity.this.k.setError("");
            }
        });
        if (getIntent() != null && getIntent().hasExtra("kycform60")) {
            this.m = (KYCForm60) getIntent().getSerializableExtra("kycform60");
        }
        KYCForm60 kYCForm60 = this.m;
        if (kYCForm60 != null) {
            if (!TextUtils.isEmpty(kYCForm60.getAgriIncom())) {
                this.f66010f.setText(this.m.getAgriIncom());
            }
            if (!TextUtils.isEmpty(this.m.getNonAgriIncom())) {
                this.f66011g.setText(this.m.getNonAgriIncom());
            }
        }
        this.s.setOnClickListener(this);
        String string = getString(R.string.tnc_form60);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(Html.fromHtml(String.format(string, new Object[]{" <a style=\"text-decoration:none\" href=https://www.google.com\">" + getString(R.string.kyc_terms_and_conditions) + "</a> "})));
        textView.setLinkTextColor(b.c(this, R.color.paytm_blue));
        textView.setText(spannableStringBuilder);
        textView.setMovementMethod(new f() {
            public final void a(String str) {
                if (FillForm60Activity.this.t != null) {
                    FillForm60Activity.f(FillForm60Activity.this);
                }
            }
        });
        this.l = (RadioGroup) findViewById(R.id.layout_kyc_have_applied_pan);
        this.n = (TextInputEditText) findViewById(R.id.pan_ack_date_et);
        this.o = (TextInputEditText) findViewById(R.id.pan_ack_num_et);
        this.q = (TextInputLayout) findViewById(R.id.pan_ack_date_til);
        this.p = (TextInputLayout) findViewById(R.id.pan_ack_num_til);
        findViewById(R.id.have_applied_pan_tv);
        this.o.setFilters(new InputFilter[]{new InputFilter.LengthFilter(30), new InputFilter.AllCaps()});
        this.o.addTextChangedListener(this.v);
        this.n.addTextChangedListener(this.f66008d);
        this.n.setOnFocusChangeListener(this);
        this.n.setOnClickListener(this);
        this.l.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public final void onCheckedChanged(RadioGroup radioGroup, int i2) {
                FillForm60Activity.this.a(radioGroup, i2);
            }
        });
        ((LinearLayout) findViewById(R.id.have_applied_pan_lyt)).setVisibility(0);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(RadioGroup radioGroup, int i2) {
        if (i2 == R.id.no_have_applied_pan) {
            this.q.setVisibility(8);
            this.p.setVisibility(8);
        } else if (i2 == R.id.yes_have_applied_pan) {
            this.q.setVisibility(0);
            this.p.setVisibility(0);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00f6, code lost:
        if (r0 == false) goto L_0x00f9;
     */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00fc  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onClick(android.view.View r8) {
        /*
            r7 = this;
            int r0 = r8.getId()
            int r1 = net.one97.paytm.upgradeKyc.R.id.form60detailsSubmit
            if (r0 != r1) goto L_0x0151
            com.google.android.material.textfield.TextInputEditText r0 = r7.f66010f
            android.text.Editable r0 = r0.getText()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0028
            com.google.android.material.textfield.TextInputLayout r0 = r7.j
            int r1 = net.one97.paytm.upgradeKyc.R.string.error_valid_income
            java.lang.String r1 = r7.getString(r1)
            r0.setError(r1)
            com.google.android.material.textfield.TextInputLayout r0 = r7.j
            r7.a((android.view.View) r0)
            goto L_0x00f9
        L_0x0028:
            com.google.android.material.textfield.TextInputEditText r0 = r7.f66010f
            android.text.Editable r0 = r0.getText()
            java.lang.String r0 = r0.toString()
            long r3 = java.lang.Long.parseLong(r0)
            r5 = 1000000000(0x3b9aca00, double:4.94065646E-315)
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 <= 0) goto L_0x004f
            com.google.android.material.textfield.TextInputLayout r0 = r7.j
            int r1 = net.one97.paytm.upgradeKyc.R.string.error_greater_agri
            java.lang.String r1 = r7.getString(r1)
            r0.setError(r1)
            com.google.android.material.textfield.TextInputLayout r0 = r7.j
            r7.a((android.view.View) r0)
            goto L_0x00f9
        L_0x004f:
            com.google.android.material.textfield.TextInputEditText r0 = r7.f66011g
            android.text.Editable r0 = r0.getText()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x006d
            com.google.android.material.textfield.TextInputLayout r0 = r7.k
            int r1 = net.one97.paytm.upgradeKyc.R.string.error_valid_income
            java.lang.String r1 = r7.getString(r1)
            r0.setError(r1)
            com.google.android.material.textfield.TextInputLayout r0 = r7.k
            r7.a((android.view.View) r0)
            goto L_0x00f9
        L_0x006d:
            com.google.android.material.textfield.TextInputEditText r0 = r7.f66011g
            android.text.Editable r0 = r0.getText()
            java.lang.String r0 = r0.toString()
            int r0 = java.lang.Integer.parseInt(r0)
            r3 = 250000(0x3d090, float:3.50325E-40)
            if (r0 <= r3) goto L_0x0091
            com.google.android.material.textfield.TextInputLayout r0 = r7.k
            int r1 = net.one97.paytm.upgradeKyc.R.string.error_greater_nonagri
            java.lang.String r1 = r7.getString(r1)
            r0.setError(r1)
            com.google.android.material.textfield.TextInputLayout r0 = r7.k
            r7.a((android.view.View) r0)
            goto L_0x00f9
        L_0x0091:
            android.widget.RadioGroup r0 = r7.l
            int r0 = r0.getCheckedRadioButtonId()
            int r3 = net.one97.paytm.upgradeKyc.R.id.yes_have_applied_pan
            if (r0 != r3) goto L_0x00fa
            com.google.android.material.textfield.TextInputEditText r0 = r7.o
            android.text.Editable r0 = r0.getText()
            java.lang.String r0 = r0.toString()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x00bd
            com.google.android.material.textfield.TextInputLayout r0 = r7.p
            int r3 = net.one97.paytm.upgradeKyc.R.string.pan_ack_num_error
            java.lang.String r3 = r7.getString(r3)
            r0.setError(r3)
            com.google.android.material.textfield.TextInputLayout r0 = r7.p
            r7.a((android.view.View) r0)
        L_0x00bb:
            r0 = 0
            goto L_0x00f6
        L_0x00bd:
            com.google.android.material.textfield.TextInputEditText r0 = r7.n
            android.text.Editable r0 = r0.getText()
            java.lang.String r0 = r0.toString()
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            if (r3 == 0) goto L_0x00de
            com.google.android.material.textfield.TextInputLayout r0 = r7.q
            int r3 = net.one97.paytm.upgradeKyc.R.string.pan_ack_date_error
            java.lang.String r3 = r7.getString(r3)
            r0.setError(r3)
            com.google.android.material.textfield.TextInputLayout r0 = r7.q
            r7.a((android.view.View) r0)
            goto L_0x00bb
        L_0x00de:
            boolean r0 = b((java.lang.String) r0)
            if (r0 == 0) goto L_0x00f5
            com.google.android.material.textfield.TextInputLayout r0 = r7.q
            int r3 = net.one97.paytm.upgradeKyc.R.string.pan_ack_date_error
            java.lang.String r3 = r7.getString(r3)
            r0.setError(r3)
            com.google.android.material.textfield.TextInputLayout r0 = r7.q
            r7.a((android.view.View) r0)
            goto L_0x00bb
        L_0x00f5:
            r0 = 1
        L_0x00f6:
            if (r0 == 0) goto L_0x00f9
            goto L_0x00fa
        L_0x00f9:
            r1 = 0
        L_0x00fa:
            if (r1 == 0) goto L_0x0151
            net.one97.paytm.common.entity.upgradeKyc.KYCForm60 r0 = new net.one97.paytm.common.entity.upgradeKyc.KYCForm60
            r0.<init>()
            r7.m = r0
            net.one97.paytm.common.entity.upgradeKyc.KYCForm60 r0 = r7.m
            com.google.android.material.textfield.TextInputEditText r1 = r7.f66010f
            android.text.Editable r1 = r1.getText()
            java.lang.String r1 = r1.toString()
            r0.setAgriIncom(r1)
            net.one97.paytm.common.entity.upgradeKyc.KYCForm60 r0 = r7.m
            com.google.android.material.textfield.TextInputEditText r1 = r7.f66011g
            android.text.Editable r1 = r1.getText()
            java.lang.String r1 = r1.toString()
            r0.setNonAgriIncom(r1)
            android.widget.RadioGroup r0 = r7.l
            int r0 = r0.getCheckedRadioButtonId()
            int r1 = net.one97.paytm.upgradeKyc.R.id.yes_have_applied_pan
            if (r0 != r1) goto L_0x0143
            com.google.android.material.textfield.TextInputEditText r0 = r7.n
            android.text.Editable r0 = r0.getText()
            java.lang.String r0 = r0.toString()
            r7.f66006a = r0
            com.google.android.material.textfield.TextInputEditText r0 = r7.o
            android.text.Editable r0 = r0.getText()
            java.lang.String r0 = r0.toString()
            r7.f66007b = r0
        L_0x0143:
            net.one97.paytm.upgradeKyc.form60.a.a$b r0 = r7.f66009e
            if (r0 == 0) goto L_0x0151
            java.util.ArrayList<net.one97.paytm.common.entity.auth.TncData> r1 = r7.t
            r0.a((java.util.ArrayList<net.one97.paytm.common.entity.auth.TncData>) r1)
            com.paytm.utility.RoboTextView r0 = r7.s
            r0.setEnabled(r2)
        L_0x0151:
            int r8 = r8.getId()
            int r0 = net.one97.paytm.upgradeKyc.R.id.pan_ack_date_et
            if (r8 != r0) goto L_0x015c
            r7.i()
        L_0x015c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.upgradeKyc.form60.view.FillForm60Activity.onClick(android.view.View):void");
    }

    private void a(View view) {
        Point point = new Point();
        a(this.f66012h, view.getParent(), view, point);
        this.f66012h.smoothScrollTo(0, point.y);
    }

    public final void d() {
        net.one97.paytm.common.widgets.a.a(this.u);
    }

    public final void e() {
        net.one97.paytm.common.widgets.a.b(this.u);
    }

    public final void f() {
        net.one97.paytm.common.widgets.a.b(this.u);
        com.paytm.utility.b.b((Context) this, getResources().getString(R.string.error), getResources().getString(R.string.msg_invalid_url));
    }

    public final void g() {
        this.s.setEnabled(true);
        Intent intent = new Intent();
        intent.putExtra("kycform60", this.m);
        intent.putExtra("showDialogForm60Submitted", true);
        setResult(-1, intent);
        finish();
    }

    public final void a(String str) {
        this.s.setEnabled(true);
        if (!TextUtils.isEmpty(str)) {
            g.b(this, getString(R.string.error), str);
        } else {
            g.b(this, getString(R.string.error), getString(R.string.some_went_wrong));
        }
    }

    public final void a(ArrayList<TncData> arrayList) {
        this.t = arrayList;
    }

    public final void h() {
        this.f66009e.a(this.f66006a, this.f66007b, this.f66010f.getText().toString(), this.f66011g.getText().toString());
    }

    private static void a(ViewGroup viewGroup, ViewParent viewParent, View view, Point point) {
        while (true) {
            ViewGroup viewGroup2 = (ViewGroup) viewParent;
            point.x += view.getLeft();
            point.y += view.getTop();
            if (!viewGroup2.equals(viewGroup)) {
                view = viewGroup2;
                viewParent = viewGroup2.getParent();
            } else {
                return;
            }
        }
    }

    public void onDestroy() {
        super.onDestroy();
        a.b bVar = this.f66009e;
        if (bVar != null) {
            bVar.b();
            this.f66009e = null;
        }
    }

    public void onFocusChange(View view, boolean z) {
        if (view == this.n && z) {
            i();
        }
    }

    private void i() {
        d dVar;
        if (TextUtils.isEmpty(this.n.getText().toString())) {
            dVar = d.a();
        } else {
            String[] split = this.n.getText().toString().split("/");
            int parseInt = Integer.parseInt(split[2]);
            dVar = d.a(Integer.parseInt(split[0]), Integer.parseInt(split[1]), parseInt);
        }
        dVar.show(getSupportFragmentManager(), "DatePicker");
        dVar.f66323f = this;
    }

    public final void a(int i2, int i3, int i4) {
        q.d("Selected Date is" + i2 + " " + i3 + " " + i4);
        this.r = Calendar.getInstance();
        this.r.set(5, i2);
        this.r.set(2, i3 + -1);
        this.r.set(1, i4);
        TextInputEditText textInputEditText = this.n;
        textInputEditText.setText(String.format("%02d", new Object[]{Integer.valueOf(i2)}) + "/" + String.format("%02d", new Object[]{Integer.valueOf(i3)}) + "/" + i4);
    }

    private static boolean b(String str) {
        Date date;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date2 = null;
        try {
            date = simpleDateFormat.parse(simpleDateFormat.format(new Date()));
            try {
                date2 = simpleDateFormat.parse(str);
            } catch (ParseException unused) {
            }
        } catch (ParseException unused2) {
            date = null;
        }
        return date2 != null && date2.after(date);
    }

    public final int a() {
        return R.layout.activity_fill_form60;
    }

    public final int b() {
        return R.layout.base_toolbar;
    }

    public final void a(NetworkCustomError networkCustomError) {
        l.a();
        l.a((Context) this, networkCustomError);
    }

    static /* synthetic */ void f(FillForm60Activity fillForm60Activity) {
        ArrayList<TncData> arrayList = fillForm60Activity.t;
        if (arrayList != null && arrayList.size() > 0) {
            m a2 = m.a(fillForm60Activity.t);
            a2.f65713a = $$Lambda$FillForm60Activity$H5eJdARH8VE1zkhc68jDyOVGpNk.INSTANCE;
            androidx.fragment.app.q a3 = fillForm60Activity.getSupportFragmentManager().a();
            a3.a((Fragment) a2, "KycTNCFragment");
            a3.c();
        }
    }
}
