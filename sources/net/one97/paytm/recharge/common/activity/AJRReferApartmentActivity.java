package net.one97.paytm.recharge.common.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import com.google.android.material.textfield.TextInputLayout;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.b;
import java.util.HashMap;
import net.one97.paytm.common.entity.CJRPincode;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.e.ai;
import net.one97.paytm.recharge.di.helper.c;
import net.one97.paytm.recharge.widgets.c.d;
import net.one97.paytm.recharge.widgets.model.ACTION_TYPE;
import net.one97.paytm.recharge.widgets.model.ERROR_TYPE;

public class AJRReferApartmentActivity extends CJRRechargeToolbarActivity implements View.OnClickListener, ai {

    /* renamed from: a  reason: collision with root package name */
    TextView f60811a;

    /* renamed from: b  reason: collision with root package name */
    TextInputLayout f60812b;

    /* renamed from: c  reason: collision with root package name */
    TextInputLayout f60813c;

    /* renamed from: d  reason: collision with root package name */
    TextInputLayout f60814d;

    /* renamed from: e  reason: collision with root package name */
    TextInputLayout f60815e;

    /* renamed from: f  reason: collision with root package name */
    TextInputLayout f60816f;

    /* renamed from: g  reason: collision with root package name */
    AutoCompleteTextView f60817g;

    /* renamed from: h  reason: collision with root package name */
    AutoCompleteTextView f60818h;

    /* renamed from: i  reason: collision with root package name */
    AutoCompleteTextView f60819i;
    AutoCompleteTextView j;
    AutoCompleteTextView k;
    AutoCompleteTextView l;
    TextWatcher m = new TextWatcher() {
        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            if (charSequence != null && charSequence.length() == 6 && b.c((Context) AJRReferApartmentActivity.this)) {
                AJRReferApartmentActivity aJRReferApartmentActivity = AJRReferApartmentActivity.this;
                String charSequence2 = charSequence.toString();
                d dVar = d.f64967a;
                AJRReferApartmentActivity.a(aJRReferApartmentActivity, "pin_code_change", charSequence2, d.a(ACTION_TYPE.SEARCH_LOCATION, ERROR_TYPE.UNDEFINED));
            }
        }

        public final void afterTextChanged(Editable editable) {
            AJRReferApartmentActivity.this.f60814d.setError((CharSequence) null);
            AJRReferApartmentActivity.this.f60814d.setErrorEnabled(false);
            if (AJRReferApartmentActivity.this.f60819i.getText().toString().isEmpty()) {
                AJRReferApartmentActivity.this.j.setEnabled(true);
                AJRReferApartmentActivity.this.k.setEnabled(true);
            }
        }
    };
    private String n;
    private String o;

    public final void a() {
    }

    public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_apartment_refer);
        al_();
        this.f60812b = (TextInputLayout) findViewById(R.id.edit_apt_name_input_layout);
        this.f60813c = (TextInputLayout) findViewById(R.id.edit_apt_address_input_layout);
        this.f60814d = (TextInputLayout) findViewById(R.id.edit_apt_pincode_input_layout);
        this.f60815e = (TextInputLayout) findViewById(R.id.edit_apt_state_input_layout);
        this.f60816f = (TextInputLayout) findViewById(R.id.edit_apt_city_input_layout);
        this.f60811a = (TextView) findViewById(R.id.tv_submit);
        this.f60811a.setOnClickListener(this);
        this.f60817g = (AutoCompleteTextView) findViewById(R.id.edit_apt_name);
        this.f60818h = (AutoCompleteTextView) findViewById(R.id.edit_apt_address);
        this.f60819i = (AutoCompleteTextView) findViewById(R.id.edit_apt_pincode);
        this.j = (AutoCompleteTextView) findViewById(R.id.edit_apt_state);
        this.k = (AutoCompleteTextView) findViewById(R.id.edit_apt_city);
        this.l = (AutoCompleteTextView) findViewById(R.id.edit_apt_number);
        this.f60817g.addTextChangedListener(new a(this.f60812b));
        this.f60818h.addTextChangedListener(new a(this.f60813c));
        this.f60819i.addTextChangedListener(this.m);
        this.j.addTextChangedListener(new a(this.f60815e));
        this.k.addTextChangedListener(new a(this.f60816f));
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onClick(android.view.View r6) {
        /*
            r5 = this;
            int r6 = r6.getId()
            int r0 = net.one97.paytm.recharge.R.id.tv_submit
            if (r6 != r0) goto L_0x0233
            android.widget.AutoCompleteTextView r6 = r5.f60817g
            android.text.Editable r6 = r6.getText()
            java.lang.String r6 = r6.toString()
            boolean r6 = r6.isEmpty()
            r0 = 1
            r1 = 0
            if (r6 == 0) goto L_0x0036
            com.google.android.material.textfield.TextInputLayout r6 = r5.f60812b
            r6.requestFocus()
            com.google.android.material.textfield.TextInputLayout r6 = r5.f60812b
            r6.setErrorEnabled(r0)
            com.google.android.material.textfield.TextInputLayout r6 = r5.f60812b
            android.content.res.Resources r0 = r5.getResources()
            int r2 = net.one97.paytm.recharge.R.string.error_enter_name
            java.lang.String r0 = r0.getString(r2)
            r6.setError(r0)
        L_0x0033:
            r0 = 0
            goto L_0x00f2
        L_0x0036:
            android.widget.AutoCompleteTextView r6 = r5.f60818h
            android.text.Editable r6 = r6.getText()
            java.lang.String r6 = r6.toString()
            boolean r6 = r6.isEmpty()
            if (r6 == 0) goto L_0x005b
            com.google.android.material.textfield.TextInputLayout r6 = r5.f60813c
            r6.requestFocus()
            com.google.android.material.textfield.TextInputLayout r6 = r5.f60813c
            android.content.res.Resources r0 = r5.getResources()
            int r2 = net.one97.paytm.recharge.R.string.error_enter_address
            java.lang.String r0 = r0.getString(r2)
            r6.setError(r0)
            goto L_0x0033
        L_0x005b:
            android.widget.AutoCompleteTextView r6 = r5.f60819i
            android.text.Editable r6 = r6.getText()
            java.lang.String r6 = r6.toString()
            boolean r6 = r6.isEmpty()
            if (r6 == 0) goto L_0x0080
            com.google.android.material.textfield.TextInputLayout r6 = r5.f60814d
            r6.requestFocus()
            com.google.android.material.textfield.TextInputLayout r6 = r5.f60814d
            android.content.res.Resources r0 = r5.getResources()
            int r2 = net.one97.paytm.recharge.R.string.error_enter_pincode
            java.lang.String r0 = r0.getString(r2)
            r6.setError(r0)
            goto L_0x0033
        L_0x0080:
            android.widget.AutoCompleteTextView r6 = r5.f60819i
            android.text.Editable r6 = r6.getText()
            java.lang.String r6 = r6.toString()
            int r6 = r6.length()
            r2 = 6
            if (r6 == r2) goto L_0x00a6
            com.google.android.material.textfield.TextInputLayout r6 = r5.f60814d
            r6.requestFocus()
            com.google.android.material.textfield.TextInputLayout r6 = r5.f60814d
            android.content.res.Resources r0 = r5.getResources()
            int r2 = net.one97.paytm.recharge.R.string.error_mmtc599_msg
            java.lang.String r0 = r0.getString(r2)
            r6.setError(r0)
            goto L_0x0033
        L_0x00a6:
            android.widget.AutoCompleteTextView r6 = r5.j
            android.text.Editable r6 = r6.getText()
            java.lang.String r6 = r6.toString()
            boolean r6 = r6.isEmpty()
            if (r6 == 0) goto L_0x00cc
            com.google.android.material.textfield.TextInputLayout r6 = r5.f60815e
            r6.requestFocus()
            com.google.android.material.textfield.TextInputLayout r6 = r5.f60815e
            android.content.res.Resources r0 = r5.getResources()
            int r2 = net.one97.paytm.recharge.R.string.error_enter_state
            java.lang.String r0 = r0.getString(r2)
            r6.setError(r0)
            goto L_0x0033
        L_0x00cc:
            android.widget.AutoCompleteTextView r6 = r5.k
            android.text.Editable r6 = r6.getText()
            java.lang.String r6 = r6.toString()
            boolean r6 = r6.isEmpty()
            if (r6 == 0) goto L_0x00f2
            com.google.android.material.textfield.TextInputLayout r6 = r5.f60816f
            r6.requestFocus()
            com.google.android.material.textfield.TextInputLayout r6 = r5.f60816f
            android.content.res.Resources r0 = r5.getResources()
            int r2 = net.one97.paytm.recharge.R.string.error_enter_city
            java.lang.String r0 = r0.getString(r2)
            r6.setError(r0)
            goto L_0x0033
        L_0x00f2:
            if (r0 == 0) goto L_0x0233
            android.widget.AutoCompleteTextView r6 = r5.f60817g
            android.text.Editable r6 = r6.getText()
            java.lang.String r6 = r6.toString()
            r5.n = r6
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            android.content.res.Resources r0 = r5.getResources()
            int r2 = net.one97.paytm.recharge.R.string.apartment_name
            java.lang.String r0 = r0.getString(r2)
            r6.append(r0)
            java.lang.String r0 = ": "
            r6.append(r0)
            java.lang.String r2 = r5.n
            r6.append(r2)
            java.lang.String r2 = "\n"
            r6.append(r2)
            android.content.res.Resources r3 = r5.getResources()
            int r4 = net.one97.paytm.recharge.R.string.address
            java.lang.String r3 = r3.getString(r4)
            r6.append(r3)
            r6.append(r0)
            android.widget.AutoCompleteTextView r3 = r5.f60818h
            android.text.Editable r3 = r3.getText()
            java.lang.String r3 = r3.toString()
            r6.append(r3)
            r6.append(r2)
            android.content.res.Resources r3 = r5.getResources()
            int r4 = net.one97.paytm.recharge.R.string.pincode
            java.lang.String r3 = r3.getString(r4)
            r6.append(r3)
            r6.append(r0)
            android.widget.AutoCompleteTextView r3 = r5.f60819i
            android.text.Editable r3 = r3.getText()
            java.lang.String r3 = r3.toString()
            r6.append(r3)
            r6.append(r2)
            android.content.res.Resources r3 = r5.getResources()
            int r4 = net.one97.paytm.recharge.R.string.city
            java.lang.String r3 = r3.getString(r4)
            r6.append(r3)
            r6.append(r0)
            android.widget.AutoCompleteTextView r3 = r5.k
            android.text.Editable r3 = r3.getText()
            java.lang.String r3 = r3.toString()
            r6.append(r3)
            r6.append(r2)
            android.content.res.Resources r3 = r5.getResources()
            int r4 = net.one97.paytm.recharge.R.string.state
            java.lang.String r3 = r3.getString(r4)
            r6.append(r3)
            r6.append(r0)
            android.widget.AutoCompleteTextView r3 = r5.j
            android.text.Editable r3 = r3.getText()
            java.lang.String r3 = r3.toString()
            r6.append(r3)
            r6.append(r2)
            android.content.res.Resources r2 = r5.getResources()
            int r3 = net.one97.paytm.recharge.R.string.contact_number
            java.lang.String r2 = r2.getString(r3)
            r6.append(r2)
            r6.append(r0)
            android.widget.AutoCompleteTextView r0 = r5.l
            android.text.Editable r0 = r0.getText()
            java.lang.String r0 = r0.toString()
            r6.append(r0)
            java.lang.String r6 = r6.toString()
            r5.o = r6
            android.content.Intent r6 = new android.content.Intent
            java.lang.String r0 = "android.intent.action.SENDTO"
            r6.<init>(r0)
            java.lang.String r0 = "mailto:"
            android.net.Uri r0 = android.net.Uri.parse(r0)
            r6.setData(r0)
            java.lang.String r0 = "leads.apartments@paytm.com"
            java.lang.String[] r0 = new java.lang.String[]{r0}
            java.lang.String r2 = "android.intent.extra.EMAIL"
            r6.putExtra(r2, r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            android.content.res.Resources r2 = r5.getResources()
            int r3 = net.one97.paytm.recharge.R.string.subject_apartment_lead
            java.lang.String r2 = r2.getString(r3)
            r0.append(r2)
            java.lang.String r2 = " "
            r0.append(r2)
            java.lang.String r2 = r5.n
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            java.lang.String r2 = "android.intent.extra.SUBJECT"
            r6.putExtra(r2, r0)
            java.lang.String r0 = r5.o
            java.lang.String r2 = "android.intent.extra.TEXT"
            r6.putExtra(r2, r0)
            android.content.pm.PackageManager r0 = r5.getPackageManager()
            android.content.ComponentName r0 = r6.resolveActivity(r0)
            if (r0 == 0) goto L_0x0223
            int r0 = net.one97.paytm.recharge.R.string.apartment_select_option
            java.lang.String r0 = r5.getString(r0)
            android.content.Intent r6 = android.content.Intent.createChooser(r6, r0)
            r5.startActivityForResult(r6, r1)
            return
        L_0x0223:
            android.content.res.Resources r6 = r5.getResources()
            int r0 = net.one97.paytm.recharge.R.string.details_not_submitted
            java.lang.String r6 = r6.getString(r0)
            r0 = 0
            java.lang.String r1 = "utility_hide_title"
            com.paytm.utility.g.b(r5, r1, r6, r0)
        L_0x0233:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.activity.AJRReferApartmentActivity.onClick(android.view.View):void");
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 0) {
            finish();
        }
    }

    public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
        if (iJRPaytmDataModel instanceof CJRPincode) {
            CJRPincode cJRPincode = (CJRPincode) iJRPaytmDataModel;
            String state = cJRPincode.getState();
            String city = cJRPincode.getCity();
            if (state != null) {
                this.j.setText(state);
            }
            if (city != null) {
                this.k.setText(city);
            }
            if (!this.f60819i.getText().toString().isEmpty()) {
                this.k.setEnabled(false);
                this.j.setEnabled(false);
            }
        }
    }

    class a implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        TextInputLayout f60821a;

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        a(TextInputLayout textInputLayout) {
            this.f60821a = textInputLayout;
        }

        public final void afterTextChanged(Editable editable) {
            this.f60821a.setError((CharSequence) null);
            this.f60821a.setErrorEnabled(false);
        }
    }

    static /* synthetic */ void a(AJRReferApartmentActivity aJRReferApartmentActivity, String str, String str2, Object obj) {
        HashMap<String, String> a2 = b.a((HashMap<String, String>) new HashMap(), (Context) aJRReferApartmentActivity);
        StringBuilder sb = new StringBuilder();
        c cVar = c.f62654a;
        sb.append(c.au());
        sb.append("/");
        sb.append(str2);
        String s = b.s(aJRReferApartmentActivity, sb.toString());
        aJRReferApartmentActivity.getApplicationContext();
        net.one97.paytm.recharge.common.f.d.a();
        net.one97.paytm.recharge.common.f.d.b(new net.one97.paytm.recharge.common.f.b(str, s, aJRReferApartmentActivity, new CJRPincode(), a2, obj));
    }
}
