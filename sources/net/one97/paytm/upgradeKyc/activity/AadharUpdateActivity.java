package net.one97.paytm.upgradeKyc.activity;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.URLUtil;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.RoboTextView;
import com.paytm.utility.a;
import com.paytm.utility.b;
import com.paytm.utility.g;
import com.paytm.utility.h;
import java.util.HashMap;
import net.one97.paytm.common.entity.CJRAadharPanSave;
import net.one97.paytm.common.entity.offline_pg.pgTransactionRequest.CJRPGTransactionRequestUtils;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.common.utility.f;
import net.one97.paytm.upgradeKyc.R;
import net.one97.paytm.upgradeKyc.helper.a;
import net.one97.paytm.upgradeKyc.helper.d;
import net.one97.paytm.upgradeKyc.helper.e;
import net.one97.paytm.upgradeKyc.utils.l;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AadharUpdateActivity extends UpgradeKycBaseActivity implements View.OnClickListener {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public TextInputEditText f65238a;

    /* renamed from: b  reason: collision with root package name */
    private TextInputEditText f65239b;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public TextInputLayout f65240d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public TextInputLayout f65241e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f65242f = false;

    /* renamed from: g  reason: collision with root package name */
    private LinearLayout f65243g;

    /* renamed from: h  reason: collision with root package name */
    private RelativeLayout f65244h;

    /* renamed from: i  reason: collision with root package name */
    private RelativeLayout f65245i;
    private RoboTextView j;
    private RoboTextView k;
    private RoboTextView l;
    private CJRHomePageItem m;
    private String n = "kyc";
    private String o;
    private CheckBox p;
    private TextWatcher q = new TextWatcher() {
        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            AadharUpdateActivity.this.f65241e.setErrorEnabled(false);
            AadharUpdateActivity.this.f65241e.setError("");
            AadharUpdateActivity.this.f65240d.setError("");
        }

        public final void afterTextChanged(Editable editable) {
            if (editable.length() > 0 && editable.length() % 5 == 0 && '-' == editable.charAt(editable.length() - 1)) {
                editable.delete(editable.length() - 1, editable.length());
            }
            if (editable.length() > 0 && editable.length() % 5 == 0 && Character.isDigit(editable.charAt(editable.length() - 1)) && TextUtils.split(editable.toString(), "-").length <= 3) {
                editable.insert(editable.length() - 1, "-");
            }
        }
    };

    public final int a() {
        return 0;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.aadhar_update_activity);
        if (getIntent() != null) {
            this.f65242f = getIntent().getBooleanExtra("update_both_pan_adhar", false);
            this.m = (CJRHomePageItem) getIntent().getSerializableExtra("extra_home_data");
        }
        CJRHomePageItem cJRHomePageItem = this.m;
        if (cJRHomePageItem != null) {
            if (!TextUtils.isEmpty(cJRHomePageItem.getVertical())) {
                this.n = this.m.getVertical();
            } else {
                this.n = "kyc";
            }
            this.o = this.m.getCallBackUrl();
        }
        if (this.n.equalsIgnoreCase(CJRPGTransactionRequestUtils.PAYER_BANK_NAME)) {
            getSupportActionBar().f();
            findViewById(R.id.lyt_bank_header).setVisibility(0);
        } else {
            setTitle("");
            if (getSupportActionBar() != null) {
                getSupportActionBar().a(0.0f);
            }
        }
        findViewById(R.id.payments_bank_info_btn_close).setOnClickListener(this);
        this.f65238a = (TextInputEditText) findViewById(R.id.edit_aadhar_name);
        this.f65239b = (TextInputEditText) findViewById(R.id.edit_aadhar_number);
        this.f65240d = (TextInputLayout) findViewById(R.id.layout_aadhar_name);
        this.f65241e = (TextInputLayout) findViewById(R.id.layout_aadhar_number);
        this.p = (CheckBox) findViewById(R.id.activity_aadhaar_update_checkbox);
        this.p.setText(String.format(getString(R.string.aadhaar_pan_consent), new Object[]{getString(R.string.aadhaar_number)}));
        this.j = (RoboTextView) findViewById(R.id.title_aadhar_text);
        this.k = (RoboTextView) findViewById(R.id.middle_aadhar_text);
        this.l = (RoboTextView) findViewById(R.id.bottom_aadhar_text);
        this.f65243g = (LinearLayout) findViewById(R.id.aadhar_details_lyt);
        this.f65244h = (RelativeLayout) findViewById(R.id.aadhar_postdetails_lyt);
        this.f65245i = (RelativeLayout) findViewById(R.id.other_item_update);
        this.f65238a.setFilters(new InputFilter[]{new InputFilter.LengthFilter(60), new InputFilter.AllCaps()});
        ((RoboTextView) findViewById(R.id.aadhar_submit)).setOnClickListener(this);
        ((RoboTextView) findViewById(R.id.aadhar_update_now)).setOnClickListener(this);
        ((RoboTextView) findViewById(R.id.aadhar_will_do_later)).setOnClickListener(this);
        if (getIntent() == null || !getIntent().getBooleanExtra("is_kyc_doc_deeplink", false) || getIntent().getBooleanExtra("is_doc_not_uploaded", false)) {
            e.a aVar = e.f66028b;
            e.a.b().a("/kyc/aadhaar/update", "kyc", (Context) this);
        } else if (getIntent().getBooleanExtra("is_doc_verified", false)) {
            f();
        } else {
            e();
        }
        this.f65239b.addTextChangedListener(this.q);
        this.f65238a.addTextChangedListener(new TextWatcher() {
            public final void afterTextChanged(Editable editable) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                AadharUpdateActivity.this.f65240d.setError("");
                AadharUpdateActivity.this.f65241e.setError("");
                String obj = AadharUpdateActivity.this.f65238a.getText().toString();
                if (obj.length() > 0 && obj.charAt(obj.length() - 1) >= '0' && obj.charAt(obj.length() - 1) <= '9') {
                    AadharUpdateActivity.this.f65238a.setText(obj.substring(0, obj.length() - 1));
                }
                AadharUpdateActivity.this.f65238a.setSelection(AadharUpdateActivity.this.f65238a.getText().length());
            }
        });
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

    private boolean d() {
        if (TextUtils.isEmpty(this.f65239b.getText())) {
            a((EditText) this.f65239b);
            this.f65241e.setError(getString(R.string.kyc_error_aadhaar_no));
            return false;
        } else if (!b.H(this.f65239b.getText().toString())) {
            this.f65241e.setError(getString(R.string.error_correct_aadhaar));
            a((EditText) this.f65239b);
            return false;
        } else if (TextUtils.isEmpty(this.f65238a.getText())) {
            this.f65240d.setError(getString(R.string.kyc_error_name));
            a((EditText) this.f65238a);
            return false;
        } else if (this.p.isChecked()) {
            return true;
        } else {
            a((EditText) this.f65238a);
            b.b((Context) this, getString(R.string.alert), getString(R.string.error_aadhaar_pan_consent));
            return false;
        }
    }

    private void a(EditText editText) {
        try {
            ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(editText.getWindowToken(), 0);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.payments_bank_info_btn_close) {
            Intent intent = null;
            try {
                e.a aVar = e.f66028b;
                intent = new Intent(this, Class.forName(e.a.b().b()));
            } catch (ClassNotFoundException e2) {
                e2.printStackTrace();
            }
            intent.setFlags(67108864);
            intent.putExtra("open_bank_tab", true);
            startActivity(intent);
            finish();
        } else if (id == R.id.aadhar_submit) {
            if (d()) {
                b.c((Activity) this);
                HashMap hashMap = new HashMap();
                hashMap.put("kyc_user_id", b.n((Context) this));
                e.a aVar2 = e.f66028b;
                e.a.b().a("kyc_aadhaar_submit_clicked", (HashMap<String, Object>) hashMap, (Context) this);
                d.a aVar3 = d.f66026a;
                d.a.a();
                String a2 = d.a("kyc_save_profile_info");
                if (!URLUtil.isValidUrl(a2)) {
                    b.b((Context) this, getResources().getString(R.string.error), getResources().getString(R.string.msg_invalid_url));
                    return;
                }
                String e3 = b.e((Context) this, a2);
                HashMap hashMap2 = new HashMap();
                hashMap2.put("session_token", a.q(this));
                String e4 = b.e();
                String f2 = b.f();
                try {
                    e.a aVar4 = e.f66028b;
                    String c2 = e.a.b().c();
                    hashMap2.put("x-keyiv", f.a(c2, e4 + ':' + f2));
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
                CJRAadharPanSave cJRAadharPanSave = new CJRAadharPanSave();
                cJRAadharPanSave.setIv(f2);
                cJRAadharPanSave.setKey(e4);
                String replaceAll = this.f65239b.getText().toString().replaceAll("-", "");
                String obj = this.f65238a.getText().toString();
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONArray jSONArray = new JSONArray();
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("docCode", "aadhar");
                    jSONObject2.put("docValue", replaceAll);
                    jSONObject2.put("nameOnDoc", obj);
                    jSONArray.put(jSONObject2);
                    jSONObject.put("documents", jSONArray);
                } catch (JSONException e6) {
                    e6.printStackTrace();
                }
                String jSONObject3 = jSONObject.toString();
                try {
                    jSONObject3 = f.a(f2, e4, jSONObject3);
                } catch (Exception e7) {
                    e7.printStackTrace();
                }
                a.C1317a aVar5 = net.one97.paytm.upgradeKyc.helper.a.f66022a;
                com.paytm.network.b a3 = a.C1317a.a();
                a3.f42877a = this;
                a3.f42879c = a.C0715a.POST;
                a3.f42882f = hashMap2;
                a3.f42885i = cJRAadharPanSave;
                a3.f42884h = jSONObject3;
                a3.f42880d = e3;
                a3.k = false;
                a3.o = AadharUpdateActivity.class.getName();
                a3.n = a.b.USER_FACING;
                a3.j = new com.paytm.network.listener.b() {
                    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                        if (iJRPaytmDataModel != null && (iJRPaytmDataModel instanceof CJRAadharPanSave)) {
                            b.p();
                            AadharUpdateActivity.a(AadharUpdateActivity.this, (CJRAadharPanSave) iJRPaytmDataModel);
                        }
                    }

                    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                        l.a();
                        if (!l.a((Context) AadharUpdateActivity.this, networkCustomError)) {
                            AadharUpdateActivity aadharUpdateActivity = AadharUpdateActivity.this;
                            g.b(aadharUpdateActivity, aadharUpdateActivity.getString(R.string.error_dialog_title), AadharUpdateActivity.this.getString(R.string.error_dialog_message));
                            b.p();
                        }
                    }
                };
                com.paytm.network.a l2 = a3.l();
                if (b.c((Context) this)) {
                    b.k(this, getString(R.string.please_wait));
                    l2.a();
                    return;
                }
                a.C1317a aVar6 = net.one97.paytm.upgradeKyc.helper.a.f66022a;
                a.C1317a.a((Context) this, l2);
            }
        } else if (id == R.id.aadhar_update_now) {
            HashMap hashMap3 = new HashMap();
            hashMap3.put("kyc_user_id", b.n((Context) this));
            e.a aVar7 = e.f66028b;
            e.a.b().a("kyc_pan_aadhaar_success_update_clicked", (HashMap<String, Object>) hashMap3, (Context) this);
        } else if (id == R.id.aadhar_will_do_later) {
            finish();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(h hVar, View view) {
        hVar.dismiss();
        finish();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(DialogInterface dialogInterface, int i2) {
        String format = String.format("paytmmp://csttree?featuretype=cst_issue&verticalid=%s&l1=%s&l2=%s", new Object[]{"10000", "1600021", "1600024"});
        e.a aVar = e.f66028b;
        e.a.b().a((Context) this, format);
        dialogInterface.dismiss();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(DialogInterface dialogInterface, int i2) {
        dialogInterface.dismiss();
        e.a aVar = e.f66028b;
        e.a.b().b((Context) this);
        finish();
    }

    private void e() {
        this.j.setText(getString(R.string.adhar_verified));
        d.a aVar = d.f66026a;
        d.a.a();
        if (d.a("shouldShowAadhaarWidget", false)) {
            this.k.setVisibility(0);
        } else {
            this.k.setVisibility(8);
        }
        this.k.setText(getString(R.string.aadhar_middle_verified));
        this.l.setVisibility(8);
        this.f65243g.setVisibility(8);
        this.f65244h.setVisibility(0);
        if (this.f65242f) {
            this.f65245i.setVisibility(0);
        }
    }

    private void f() {
        this.j.setText(getString(R.string.aadhar_title_pending));
        this.k.setVisibility(0);
        this.k.setText(getString(R.string.aadhar_pan_middle_pending));
        d.a aVar = d.f66026a;
        d.a.a();
        if (d.a("shouldShowAadhaarWidget", false)) {
            this.l.setVisibility(0);
        } else {
            this.l.setVisibility(8);
        }
        this.l.setText(getString(R.string.aadhar_bottom_pending));
        this.f65243g.setVisibility(8);
        this.f65244h.setVisibility(0);
        if (this.f65242f) {
            this.f65245i.setVisibility(0);
        }
    }

    public void onBackPressed() {
        if (this.n.equalsIgnoreCase(CJRPGTransactionRequestUtils.PAYER_BANK_NAME)) {
            Intent intent = null;
            try {
                e.a aVar = e.f66028b;
                intent = new Intent(this, Class.forName(e.a.b().b()));
            } catch (ClassNotFoundException e2) {
                e2.printStackTrace();
            }
            intent.setFlags(67108864);
            intent.putExtra("open_bank_tab", true);
            startActivity(intent);
            finish();
        } else {
            super.onBackPressed();
        }
        super.onBackPressed();
    }

    public final int b() {
        return R.layout.base_toolbar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0101, code lost:
        if (r8.equals("EDITABLE_EXCLAMATED") != false) goto L_0x0105;
     */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0107  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x016e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(net.one97.paytm.upgradeKyc.activity.AadharUpdateActivity r7, net.one97.paytm.common.entity.CJRAadharPanSave r8) {
        /*
            r0 = 0
            if (r8 == 0) goto L_0x0092
            java.lang.String r1 = r8.getErrorErrorMessage()
            if (r1 == 0) goto L_0x0092
            java.lang.String r1 = r8.getErrorErrorCode()
            java.lang.String r2 = "4009"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x003d
            com.paytm.utility.h r0 = new com.paytm.utility.h
            r0.<init>(r7)
            int r1 = net.one97.paytm.upgradeKyc.R.string.error
            java.lang.String r1 = r7.getString(r1)
            r0.setTitle(r1)
            java.lang.String r8 = r8.getErrorErrorMessage()
            r0.a(r8)
            r8 = -3
            int r1 = net.one97.paytm.upgradeKyc.R.string.ok
            java.lang.String r1 = r7.getString(r1)
            net.one97.paytm.upgradeKyc.activity.-$$Lambda$AadharUpdateActivity$gDMiz21TvOJVoExC5poMMzY1Tog r2 = new net.one97.paytm.upgradeKyc.activity.-$$Lambda$AadharUpdateActivity$gDMiz21TvOJVoExC5poMMzY1Tog
            r2.<init>(r0)
            r0.a(r8, r1, r2)
            r0.show()
            return
        L_0x003d:
            java.lang.String r1 = r8.getErrorErrorCode()
            java.lang.String r2 = "9561"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0082
            java.lang.String r1 = r8.getErrorErrorMessage()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x017b
            android.app.AlertDialog$Builder r1 = new android.app.AlertDialog$Builder
            r1.<init>(r7)
            java.lang.String r8 = r8.getErrorErrorMessage()
            r1.setMessage(r8)
            r1.setCancelable(r0)
            int r8 = net.one97.paytm.upgradeKyc.R.string.report_issue
            java.lang.String r8 = r7.getString(r8)
            net.one97.paytm.upgradeKyc.activity.-$$Lambda$AadharUpdateActivity$NwMUTNBFTNtOYMnID81K1eKc_eQ r0 = new net.one97.paytm.upgradeKyc.activity.-$$Lambda$AadharUpdateActivity$NwMUTNBFTNtOYMnID81K1eKc_eQ
            r0.<init>()
            r1.setNegativeButton(r8, r0)
            int r8 = net.one97.paytm.upgradeKyc.R.string.ok
            java.lang.String r8 = r7.getString(r8)
            net.one97.paytm.upgradeKyc.activity.-$$Lambda$AadharUpdateActivity$mc7mMquVv8021IERsg0Efw6SHDU r0 = new net.one97.paytm.upgradeKyc.activity.-$$Lambda$AadharUpdateActivity$mc7mMquVv8021IERsg0Efw6SHDU
            r0.<init>()
            r1.setPositiveButton(r8, r0)
            r1.show()
            return
        L_0x0082:
            int r8 = net.one97.paytm.upgradeKyc.R.string.error
            java.lang.String r8 = r7.getString(r8)
            int r0 = net.one97.paytm.upgradeKyc.R.string.some_went_wrong
            java.lang.String r0 = r7.getString(r0)
            com.paytm.utility.g.b(r7, r8, r0)
            return
        L_0x0092:
            if (r8 == 0) goto L_0x017b
            java.util.List r1 = r8.getDocuments()
            if (r1 == 0) goto L_0x017b
            java.util.List r1 = r8.getDocuments()
            int r1 = r1.size()
            if (r1 <= 0) goto L_0x017b
            java.util.List r8 = r8.getDocuments()
            java.util.Iterator r8 = r8.iterator()
        L_0x00ac:
            boolean r1 = r8.hasNext()
            if (r1 == 0) goto L_0x017b
            java.lang.Object r1 = r8.next()
            net.one97.paytm.common.entity.CJRAadharPanDocList r1 = (net.one97.paytm.common.entity.CJRAadharPanDocList) r1
            if (r1 == 0) goto L_0x00ac
            java.lang.String r2 = r1.getDocCode()
            if (r2 == 0) goto L_0x00ac
            java.lang.String r2 = r1.getDocCode()
            java.lang.String r3 = "aadhar"
            boolean r2 = r2.equalsIgnoreCase(r3)
            if (r2 == 0) goto L_0x00ac
            java.lang.String r8 = r1.getEditableAction()
            r2 = -1
            int r3 = r8.hashCode()
            r4 = -10211755(0xffffffffff642e55, float:-3.0330455E38)
            r5 = 2
            r6 = 1
            if (r3 == r4) goto L_0x00fb
            r0 = 23774884(0x16ac6a4, float:4.312153E-38)
            if (r3 == r0) goto L_0x00f1
            r0 = 1584648101(0x5e73cfa5, float:4.39211052E18)
            if (r3 == r0) goto L_0x00e7
            goto L_0x0104
        L_0x00e7:
            java.lang.String r0 = "NON_EDITABLE_TICKED"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L_0x0104
            r0 = 1
            goto L_0x0105
        L_0x00f1:
            java.lang.String r0 = "NON_EDITABLE_WAITING"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L_0x0104
            r0 = 2
            goto L_0x0105
        L_0x00fb:
            java.lang.String r3 = "EDITABLE_EXCLAMATED"
            boolean r8 = r8.equals(r3)
            if (r8 == 0) goto L_0x0104
            goto L_0x0105
        L_0x0104:
            r0 = -1
        L_0x0105:
            if (r0 == 0) goto L_0x016e
            java.lang.String r8 = "UTF-8"
            java.lang.String r1 = "kyc"
            if (r0 == r6) goto L_0x013f
            if (r0 == r5) goto L_0x0110
            goto L_0x013e
        L_0x0110:
            net.one97.paytm.upgradeKyc.helper.e$a r0 = net.one97.paytm.upgradeKyc.helper.e.f66028b
            net.one97.paytm.upgradeKyc.helper.f r0 = net.one97.paytm.upgradeKyc.helper.e.a.b()
            java.lang.String r2 = "/kyc/aadhaar/verification-pending"
            r0.a((java.lang.String) r2, (java.lang.String) r1, (android.content.Context) r7)
            java.lang.String r0 = r7.o
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x013b
            java.lang.String r0 = r7.o     // Catch:{ UnsupportedEncodingException -> 0x0136 }
            java.lang.String r8 = java.net.URLDecoder.decode(r0, r8)     // Catch:{ UnsupportedEncodingException -> 0x0136 }
            net.one97.paytm.upgradeKyc.helper.e$a r0 = net.one97.paytm.upgradeKyc.helper.e.f66028b     // Catch:{ UnsupportedEncodingException -> 0x0136 }
            net.one97.paytm.upgradeKyc.helper.f r0 = net.one97.paytm.upgradeKyc.helper.e.a.b()     // Catch:{ UnsupportedEncodingException -> 0x0136 }
            r0.a((android.content.Context) r7, (java.lang.String) r8)     // Catch:{ UnsupportedEncodingException -> 0x0136 }
            r7.finish()     // Catch:{ UnsupportedEncodingException -> 0x0136 }
            return
        L_0x0136:
            r7 = move-exception
            r7.printStackTrace()
            return
        L_0x013b:
            r7.f()
        L_0x013e:
            return
        L_0x013f:
            net.one97.paytm.upgradeKyc.helper.e$a r0 = net.one97.paytm.upgradeKyc.helper.e.f66028b
            net.one97.paytm.upgradeKyc.helper.f r0 = net.one97.paytm.upgradeKyc.helper.e.a.b()
            java.lang.String r2 = "/kyc/aadhaar/verication-success"
            r0.a((java.lang.String) r2, (java.lang.String) r1, (android.content.Context) r7)
            java.lang.String r0 = r7.o
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x016a
            java.lang.String r0 = r7.o     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            java.lang.String r8 = java.net.URLDecoder.decode(r0, r8)     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            net.one97.paytm.upgradeKyc.helper.e$a r0 = net.one97.paytm.upgradeKyc.helper.e.f66028b     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            net.one97.paytm.upgradeKyc.helper.f r0 = net.one97.paytm.upgradeKyc.helper.e.a.b()     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            r0.a((android.content.Context) r7, (java.lang.String) r8)     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            r7.finish()     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            return
        L_0x0165:
            r7 = move-exception
            r7.printStackTrace()
            return
        L_0x016a:
            r7.e()
            return
        L_0x016e:
            int r8 = net.one97.paytm.upgradeKyc.R.string.error
            java.lang.String r8 = r7.getString(r8)
            java.lang.String r0 = r1.getEditableActionMsg()
            com.paytm.utility.g.b(r7, r8, r0)
        L_0x017b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.upgradeKyc.activity.AadharUpdateActivity.a(net.one97.paytm.upgradeKyc.activity.AadharUpdateActivity, net.one97.paytm.common.entity.CJRAadharPanSave):void");
    }
}
