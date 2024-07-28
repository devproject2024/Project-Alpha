package net.one97.paytm.managebeneficiary;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import com.google.android.material.textfield.TextInputLayout;

public class AdvanceSettingBeneficiaryActivity extends BeneficiaryActivity implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private ViewGroup f53208a;

    /* renamed from: c  reason: collision with root package name */
    private AppCompatEditText f53209c;

    /* renamed from: d  reason: collision with root package name */
    private AppCompatEditText f53210d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public TextInputLayout f53211e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public TextInputLayout f53212f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f53213g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f53214h;

    /* renamed from: i  reason: collision with root package name */
    private String f53215i;
    private String j;
    private String k;
    /* access modifiers changed from: private */
    public d l;
    private TextWatcher m = new TextWatcher() {
        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            if (AdvanceSettingBeneficiaryActivity.this.l != null) {
                AdvanceSettingBeneficiaryActivity.this.l.a();
            }
            AdvanceSettingBeneficiaryActivity.this.f53212f.setError("");
            AdvanceSettingBeneficiaryActivity.this.f53211e.setError("");
        }
    };

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_advance_setting_beneficiary);
        if (getSupportActionBar() != null) {
            getSupportActionBar().f();
        }
        f.a().sendOpenScreenWithDeviceInfo("/beneficiary/wallet/advanced_settings", "beneficiary", this);
        if (getIntent() != null) {
            this.f53215i = getIntent().getStringExtra("which_setting");
            this.j = getIntent().getStringExtra("transfer_limit");
            this.k = getIntent().getStringExtra("max_no_transac");
        }
        this.l = new d(this);
        this.f53208a = (ViewGroup) findViewById(R.id.root_view);
        findViewById(R.id.bene_back_arrow_iv).setOnClickListener(this);
        findViewById(R.id.bene_limit_iv).setOnClickListener(this);
        findViewById(R.id.bene_transaction_iv).setOnClickListener(this);
        this.f53211e = (TextInputLayout) findViewById(R.id.layout_monthly_fund_transfer);
        this.f53209c = (AppCompatEditText) findViewById(R.id.edit_monthly_fund_transfer);
        this.f53209c.addTextChangedListener(this.m);
        this.f53209c.setOnClickListener(this);
        this.f53212f = (TextInputLayout) findViewById(R.id.layout_maximum_transaction);
        this.f53210d = (AppCompatEditText) findViewById(R.id.edit_maximum_transaction);
        this.f53210d.addTextChangedListener(this.m);
        this.f53210d.setOnClickListener(this);
        this.f53213g = (TextView) findViewById(R.id.wallet_benef_advanced_setting);
        this.f53213g.setOnClickListener(this);
        if (!TextUtils.isEmpty(this.j)) {
            this.f53209c.setText(this.j);
        }
        if (!TextUtils.isEmpty(this.k)) {
            this.f53210d.setText(this.k);
        }
        this.f53214h = (TextView) findViewById(R.id.note_advance_setting_tv);
        findViewById(R.id.scrollView).getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            public final void onScrollChanged() {
                if (AdvanceSettingBeneficiaryActivity.this.l != null) {
                    AdvanceSettingBeneficiaryActivity.this.l.a();
                }
            }
        });
        if ("bank_bank_setting".equalsIgnoreCase(this.f53215i)) {
            this.f53214h.setText(getString(R.string.pb_mb_advance_setting_note_bank));
        } else {
            this.f53214h.setText(getString(R.string.pb_mb_advance_setting_note_wallet));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:54:0x0118  */
    /* JADX WARNING: Removed duplicated region for block: B:69:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onClick(android.view.View r6) {
        /*
            r5 = this;
            int r0 = r6.getId()
            int r1 = net.one97.paytm.managebeneficiary.R.id.bene_back_arrow_iv
            if (r0 != r1) goto L_0x0013
            net.one97.paytm.managebeneficiary.d r6 = r5.l
            if (r6 == 0) goto L_0x000f
            r6.a()
        L_0x000f:
            r5.onBackPressed()
            return
        L_0x0013:
            int r1 = net.one97.paytm.managebeneficiary.R.id.bene_limit_iv
            if (r0 != r1) goto L_0x003a
            net.one97.paytm.managebeneficiary.d r0 = r5.l
            if (r0 == 0) goto L_0x0183
            boolean r0 = r0.b(r6)
            if (r0 != 0) goto L_0x0034
            net.one97.paytm.managebeneficiary.d r0 = r5.l
            r0.a()
            net.one97.paytm.managebeneficiary.d r0 = r5.l
            android.view.ViewGroup r1 = r5.f53208a
            int r2 = net.one97.paytm.managebeneficiary.R.string.pb_mb_bene_limit_per_month
            java.lang.String r2 = r5.getString(r2)
            r0.a((android.view.View) r6, (android.view.ViewGroup) r1, (java.lang.String) r2)
            return
        L_0x0034:
            net.one97.paytm.managebeneficiary.d r6 = r5.l
            r6.a()
            return
        L_0x003a:
            int r1 = net.one97.paytm.managebeneficiary.R.id.bene_transaction_iv
            if (r0 != r1) goto L_0x0061
            net.one97.paytm.managebeneficiary.d r0 = r5.l
            if (r0 == 0) goto L_0x0183
            boolean r0 = r0.b(r6)
            if (r0 != 0) goto L_0x005b
            net.one97.paytm.managebeneficiary.d r0 = r5.l
            r0.a()
            net.one97.paytm.managebeneficiary.d r0 = r5.l
            android.view.ViewGroup r1 = r5.f53208a
            int r2 = net.one97.paytm.managebeneficiary.R.string.pb_mb_bene_max_transaction
            java.lang.String r2 = r5.getString(r2)
            r0.a((android.view.View) r6, (android.view.ViewGroup) r1, (java.lang.String) r2)
            return
        L_0x005b:
            net.one97.paytm.managebeneficiary.d r6 = r5.l
            r6.a()
            return
        L_0x0061:
            int r6 = net.one97.paytm.managebeneficiary.R.id.wallet_benef_advanced_setting
            if (r0 != r6) goto L_0x0183
            net.one97.paytm.managebeneficiary.d r6 = r5.l
            if (r6 == 0) goto L_0x006c
            r6.a()
        L_0x006c:
            androidx.appcompat.widget.AppCompatEditText r6 = r5.f53209c
            android.text.Editable r6 = r6.getText()
            java.lang.String r6 = r6.toString()
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            r0 = 1000000(0xf4240, float:1.401298E-39)
            r1 = 100000(0x186a0, float:1.4013E-40)
            java.lang.String r2 = "bank_bank_setting"
            r3 = 0
            if (r6 != 0) goto L_0x00c5
            androidx.appcompat.widget.AppCompatEditText r6 = r5.f53209c
            android.text.Editable r6 = r6.getText()
            java.lang.String r6 = r6.toString()
            int r6 = java.lang.Integer.parseInt(r6)
            java.lang.String r4 = r5.f53215i
            boolean r4 = r2.equalsIgnoreCase(r4)
            if (r4 == 0) goto L_0x00b0
            if (r6 <= 0) goto L_0x009f
            if (r6 <= r0) goto L_0x00c5
        L_0x009f:
            com.google.android.material.textfield.TextInputLayout r6 = r5.f53211e
            int r0 = net.one97.paytm.managebeneficiary.R.string.pb_mb_error_max_amt_limit_bank
            java.lang.String r0 = r5.getString(r0)
            r6.setError(r0)
            androidx.appcompat.widget.AppCompatEditText r6 = r5.f53209c
            r6.requestFocus()
            goto L_0x0116
        L_0x00b0:
            if (r6 <= 0) goto L_0x00b4
            if (r6 <= r1) goto L_0x00c5
        L_0x00b4:
            com.google.android.material.textfield.TextInputLayout r6 = r5.f53211e
            int r0 = net.one97.paytm.managebeneficiary.R.string.pb_mb_error_max_amt_limit
            java.lang.String r0 = r5.getString(r0)
            r6.setError(r0)
            androidx.appcompat.widget.AppCompatEditText r6 = r5.f53209c
            r6.requestFocus()
            goto L_0x0116
        L_0x00c5:
            androidx.appcompat.widget.AppCompatEditText r6 = r5.f53210d
            android.text.Editable r6 = r6.getText()
            java.lang.String r6 = r6.toString()
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 != 0) goto L_0x0115
            androidx.appcompat.widget.AppCompatEditText r6 = r5.f53210d
            android.text.Editable r6 = r6.getText()
            java.lang.String r6 = r6.toString()
            int r6 = java.lang.Integer.parseInt(r6)
            java.lang.String r4 = r5.f53215i
            boolean r2 = r2.equalsIgnoreCase(r4)
            if (r2 == 0) goto L_0x0100
            if (r6 <= 0) goto L_0x00ef
            if (r6 <= r0) goto L_0x0115
        L_0x00ef:
            com.google.android.material.textfield.TextInputLayout r6 = r5.f53212f
            int r0 = net.one97.paytm.managebeneficiary.R.string.pb_mb_error_max_txn_limit_bank
            java.lang.String r0 = r5.getString(r0)
            r6.setError(r0)
            androidx.appcompat.widget.AppCompatEditText r6 = r5.f53210d
            r6.requestFocus()
            goto L_0x0116
        L_0x0100:
            if (r6 <= 0) goto L_0x0104
            if (r6 <= r1) goto L_0x0115
        L_0x0104:
            com.google.android.material.textfield.TextInputLayout r6 = r5.f53212f
            int r0 = net.one97.paytm.managebeneficiary.R.string.pb_mb_error_max_txn_limit
            java.lang.String r0 = r5.getString(r0)
            r6.setError(r0)
            androidx.appcompat.widget.AppCompatEditText r6 = r5.f53210d
            r6.requestFocus()
            goto L_0x0116
        L_0x0115:
            r3 = 1
        L_0x0116:
            if (r3 == 0) goto L_0x0183
            java.lang.String r6 = r5.f53215i
            java.lang.String r0 = "wallet_wallet_setting"
            boolean r6 = r0.equals(r6)
            java.lang.String r0 = "/beneficiary/wallet/advanced_settings"
            java.lang.String r1 = "save_new_advanced_settings"
            java.lang.String r2 = "beneficiary_wallet"
            if (r6 == 0) goto L_0x012f
            java.lang.String r6 = "pb_mb_paytm_wallet"
            net.one97.paytm.managebeneficiary.e.a(r5, r2, r1, r6, r0)
            goto L_0x0134
        L_0x012f:
            java.lang.String r6 = "bank_account"
            net.one97.paytm.managebeneficiary.e.a(r5, r2, r1, r6, r0)
        L_0x0134:
            androidx.appcompat.widget.AppCompatEditText r6 = r5.f53209c
            android.text.Editable r6 = r6.getText()
            java.lang.String r6 = r6.toString()
            androidx.appcompat.widget.AppCompatEditText r0 = r5.f53210d
            android.text.Editable r0 = r0.getText()
            java.lang.String r0 = r0.toString()
            android.content.Intent r1 = new android.content.Intent
            r1.<init>()
            java.lang.String r2 = r5.f53215i
            java.lang.String r3 = "which_setting"
            r1.putExtra(r3, r2)
            java.lang.String r2 = r6.trim()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x0169
            java.lang.String r6 = r6.trim()
            java.lang.String r2 = "transfer_limit"
            r1.putExtra(r2, r6)
        L_0x0169:
            java.lang.String r6 = r0.trim()
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 != 0) goto L_0x017c
            java.lang.String r6 = r0.trim()
            java.lang.String r0 = "max_no_transac"
            r1.putExtra(r0, r6)
        L_0x017c:
            r6 = -1
            r5.setResult(r6, r1)
            r5.finish()
        L_0x0183:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.managebeneficiary.AdvanceSettingBeneficiaryActivity.onClick(android.view.View):void");
    }
}
