package net.one97.paytm.upgradeKyc.activity;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.URLUtil;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.q;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.RoboTextView;
import com.paytm.utility.b;
import com.paytm.utility.g;
import com.paytm.utility.h;
import java.util.HashMap;
import net.one97.paytm.common.entity.CJRAadharPanSave;
import net.one97.paytm.common.entity.offline_pg.pgTransactionRequest.CJRPGTransactionRequestUtils;
import net.one97.paytm.common.entity.upgradeKyc.KYCForm60;
import net.one97.paytm.common.utility.f;
import net.one97.paytm.upgradeKyc.R;
import net.one97.paytm.upgradeKyc.form60.view.FillForm60Activity;
import net.one97.paytm.upgradeKyc.form60.view.Form60DetailsFilledActivity;
import net.one97.paytm.upgradeKyc.form60.view.a;
import net.one97.paytm.upgradeKyc.helper.a;
import net.one97.paytm.upgradeKyc.helper.d;
import net.one97.paytm.upgradeKyc.helper.e;
import net.one97.paytm.upgradeKyc.utils.l;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PanUpdateActivity extends UpgradeKycBaseActivity implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private TextInputEditText f65389a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public TextInputLayout f65390b;

    /* renamed from: d  reason: collision with root package name */
    private LinearLayout f65391d;

    /* renamed from: e  reason: collision with root package name */
    private RelativeLayout f65392e;

    /* renamed from: f  reason: collision with root package name */
    private RoboTextView f65393f;

    /* renamed from: g  reason: collision with root package name */
    private RoboTextView f65394g;

    /* renamed from: h  reason: collision with root package name */
    private RoboTextView f65395h;

    /* renamed from: i  reason: collision with root package name */
    private String f65396i = "kyc";
    private String j;
    private CheckBox k;
    private KYCForm60 l;
    private TextWatcher m = new TextWatcher() {
        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            PanUpdateActivity.this.f65390b.setErrorEnabled(false);
            PanUpdateActivity.this.f65390b.setError("");
        }
    };

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent() != null) {
            getIntent().getBooleanExtra("update_both_pan_adhar", false);
        }
        if (this.f65396i.equalsIgnoreCase(CJRPGTransactionRequestUtils.PAYER_BANK_NAME)) {
            getSupportActionBar().f();
            findViewById(R.id.lyt_bank_header).setVisibility(0);
        } else {
            if (getSupportActionBar() != null) {
                getSupportActionBar().a(0.0f);
            }
            setTitle("");
        }
        findViewById(R.id.payments_bank_info_btn_close).setOnClickListener(this);
        this.f65389a = (TextInputEditText) findViewById(R.id.edit_pan_number);
        this.f65390b = (TextInputLayout) findViewById(R.id.layout_pan_number);
        findViewById(R.id.dont_have_pan_lyt);
        this.k = (CheckBox) findViewById(R.id.activity_pan_update_checkbox);
        this.k.setText(String.format(getString(R.string.aadhaar_pan_consent), new Object[]{getString(R.string.pan_no)}));
        this.f65393f = (RoboTextView) findViewById(R.id.title_pan_text);
        this.f65394g = (RoboTextView) findViewById(R.id.middle_pan_text);
        this.f65395h = (RoboTextView) findViewById(R.id.bottom_pan_text);
        this.f65391d = (LinearLayout) findViewById(R.id.pan_details_lyt);
        this.f65392e = (RelativeLayout) findViewById(R.id.pan_postdetails_lyt);
        findViewById(R.id.pan_other_item_update);
        RoboTextView roboTextView = (RoboTextView) findViewById(R.id.pan_submit);
        RoboTextView roboTextView2 = (RoboTextView) findViewById(R.id.pan_home_button);
        RoboTextView roboTextView3 = (RoboTextView) findViewById(R.id.pan_update_now);
        RoboTextView roboTextView4 = (RoboTextView) findViewById(R.id.pan_will_do_later);
        if (getIntent() != null && getIntent().hasExtra("kycform60")) {
            this.l = (KYCForm60) getIntent().getSerializableExtra("kycform60");
        }
        findViewById(R.id.dont_have_pan_lyt).setOnClickListener(this);
        roboTextView.setOnClickListener(this);
        roboTextView2.setOnClickListener(this);
        roboTextView3.setOnClickListener(this);
        roboTextView4.setOnClickListener(this);
        this.f65389a.setFilters(new InputFilter[]{new InputFilter.LengthFilter(10), new InputFilter.AllCaps()});
        this.f65389a.addTextChangedListener(this.m);
        if (getIntent() == null || !getIntent().getBooleanExtra("is_kyc_doc_deeplink", false) || getIntent().getBooleanExtra("is_doc_not_uploaded", false)) {
            e.a aVar = e.f66028b;
            e.a.b().a("/kyc/pan/update", "kyc", (Context) this);
        } else if (getIntent().getBooleanExtra("is_doc_verified", false)) {
            f();
        } else {
            e();
        }
        KYCForm60 kYCForm60 = this.l;
        if (kYCForm60 != null && !TextUtils.isEmpty(kYCForm60.getAgriIncom()) && !TextUtils.isEmpty(this.l.getNonAgriIncom())) {
            d();
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(a aVar) {
        if (aVar != null && aVar.isVisible()) {
            aVar.dismiss();
        }
    }

    public void onPause() {
        super.onPause();
        a aVar = (a) getSupportFragmentManager().c(a.class.getSimpleName());
        if (aVar != null && aVar.isVisible()) {
            aVar.dismiss();
        }
    }

    private void d() {
        ((RoboTextView) findViewById(R.id.dontHavePanTitle)).setText(R.string.form60_details);
        RoboTextView roboTextView = (RoboTextView) findViewById(R.id.form_60_subText);
        roboTextView.setText(R.string.submitted_successfully);
        roboTextView.setTextColor(getResources().getColor(R.color.color_21c17a));
    }

    public void onClick(View view) {
        Boolean bool;
        Intent intent;
        String str = null;
        if (view.getId() == R.id.payments_bank_info_btn_close) {
            try {
                e.a aVar = e.f66028b;
                intent = new Intent(this, Class.forName(e.a.b().b()));
            } catch (ClassNotFoundException e2) {
                e2.printStackTrace();
                intent = null;
            }
            intent.setFlags(67108864);
            intent.putExtra("open_bank_tab", true);
            startActivity(intent);
            finish();
        } else if (view.getId() == R.id.pan_submit) {
            if (TextUtils.isEmpty(this.f65389a.getText())) {
                a((EditText) this.f65389a);
                this.f65390b.setError(getString(R.string.empty_pan_error));
                bool = Boolean.FALSE;
            } else if (this.f65389a.getText().toString().length() < 10 || !b.W(this.f65389a.getText().toString())) {
                this.f65390b.setError(getString(R.string.invalid_pan_error));
                a((EditText) this.f65389a);
                bool = Boolean.FALSE;
            } else if (!this.k.isChecked()) {
                a((EditText) this.f65389a);
                b.b((Context) this, getString(R.string.alert), getString(R.string.error_aadhaar_pan_consent));
                bool = Boolean.FALSE;
            } else {
                bool = Boolean.TRUE;
            }
            if (bool.booleanValue()) {
                b.c((Activity) this);
                HashMap hashMap = new HashMap();
                hashMap.put("kyc_user_id", b.n((Context) this));
                e.a aVar2 = e.f66028b;
                e.a.b().a("kyc_pan_submit_clicked", (HashMap<String, Object>) hashMap, (Context) this);
                d.a aVar3 = d.f66026a;
                if (d.a.a() != null) {
                    d.a aVar4 = d.f66026a;
                    d.a.a();
                    str = d.a("kyc_save_profile_info");
                }
                if (!URLUtil.isValidUrl(str)) {
                    b.b((Context) this, getResources().getString(R.string.error), getResources().getString(R.string.msg_invalid_url));
                    return;
                }
                String e3 = b.e((Context) this, str);
                HashMap hashMap2 = new HashMap();
                hashMap2.put("session_token", com.paytm.utility.a.q(this));
                String e4 = b.e();
                String f2 = b.f();
                try {
                    e.a aVar5 = e.f66028b;
                    hashMap2.put("x-keyiv", f.a(e.a.b().c(), e4 + ':' + f2));
                    hashMap2.put("Content-Type", "application/json; charset=utf-8");
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
                CJRAadharPanSave cJRAadharPanSave = new CJRAadharPanSave();
                cJRAadharPanSave.setIv(f2);
                cJRAadharPanSave.setKey(e4);
                String obj = this.f65389a.getText().toString();
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONArray jSONArray = new JSONArray();
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("docCode", "pan");
                    jSONObject2.put("docValue", obj);
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
                a.C1317a aVar6 = net.one97.paytm.upgradeKyc.helper.a.f66022a;
                com.paytm.network.b a2 = a.C1317a.a();
                a2.f42877a = this;
                a2.f42879c = a.C0715a.POST;
                a2.f42882f = hashMap2;
                a2.f42885i = cJRAadharPanSave;
                a2.f42884h = jSONObject3;
                a2.f42880d = e3;
                a2.k = false;
                a2.o = PanUpdateActivity.class.getName();
                a2.n = a.b.USER_FACING;
                a2.j = new com.paytm.network.listener.b() {
                    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                        PanUpdateActivity.a(PanUpdateActivity.this, iJRPaytmDataModel);
                    }

                    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                        l.a();
                        if (!l.a((Context) PanUpdateActivity.this, networkCustomError)) {
                            PanUpdateActivity panUpdateActivity = PanUpdateActivity.this;
                            g.b(panUpdateActivity, panUpdateActivity.getString(R.string.error_dialog_title), PanUpdateActivity.this.getString(R.string.error_dialog_message));
                            b.p();
                        }
                    }
                };
                com.paytm.network.a l2 = a2.l();
                if (b.c((Context) this)) {
                    b.k(this, getString(R.string.please_wait));
                    l2.a();
                    return;
                }
                a.C1317a aVar7 = net.one97.paytm.upgradeKyc.helper.a.f66022a;
                a.C1317a.a((Context) this, l2);
            }
        } else if (view.getId() == R.id.pan_home_button) {
            finish();
        } else if (view.getId() == R.id.pan_update_now) {
            new HashMap().put("kyc_user_id", b.n((Context) this));
            finish();
        } else if (view.getId() == R.id.pan_will_do_later) {
            finish();
        } else if (view.getId() != R.id.dont_have_pan_lyt) {
        } else {
            if (this.l != null) {
                Intent intent2 = new Intent(this, Form60DetailsFilledActivity.class);
                intent2.putExtra("kycform60", this.l);
                startActivityForResult(intent2, 121);
                return;
            }
            startActivityForResult(new Intent(this, FillForm60Activity.class), 121);
        }
    }

    private void a(EditText editText) {
        try {
            ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(editText.getWindowToken(), 0);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(h hVar, View view) {
        hVar.dismiss();
        finish();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(DialogInterface dialogInterface, int i2) {
        String format = String.format("paytmmp://csttree?featuretype=cst_issue&verticalid=%s&l1=%s&l2=%s", new Object[]{"1000007", "1600021", "1600024"});
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
        this.f65393f.setText(getString(R.string.pan_title_verified));
        d.a aVar = d.f66026a;
        if (d.a.a() != null) {
            d.a aVar2 = d.f66026a;
            d.a.a();
            if (d.a("shouldShowPanWidget", false)) {
                this.f65394g.setVisibility(0);
            } else {
                this.f65394g.setVisibility(8);
            }
        }
        this.f65394g.setText(getString(R.string.pan_middle_verified));
        this.f65395h.setVisibility(8);
        this.f65391d.setVisibility(8);
        this.f65392e.setVisibility(0);
    }

    private void f() {
        this.f65393f.setText(getString(R.string.pan_title_pending));
        this.f65394g.setVisibility(0);
        this.f65394g.setText(getString(R.string.aadhar_pan_middle_pending));
        this.f65395h.setText(getString(R.string.pan_bottom_pending));
        d.a aVar = d.f66026a;
        if (d.a.a() != null) {
            d.a aVar2 = d.f66026a;
            d.a.a();
            if (d.a("shouldShowPanWidget", false)) {
                this.f65395h.setVisibility(0);
            } else {
                this.f65395h.setVisibility(8);
            }
        }
        this.f65391d.setVisibility(8);
        this.f65392e.setVisibility(0);
    }

    public void onBackPressed() {
        if (this.f65396i.equalsIgnoreCase(CJRPGTransactionRequestUtils.PAYER_BANK_NAME)) {
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
            return;
        }
        super.onBackPressed();
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 121 && i3 == -1) {
            if (intent != null) {
                this.l = (KYCForm60) intent.getSerializableExtra("kycform60");
                if (intent.hasExtra("showDialogForm60Submitted")) {
                    if (this.f65396i.equalsIgnoreCase(CJRPGTransactionRequestUtils.PAYER_BANK_NAME)) {
                        if (!TextUtils.isEmpty(this.j)) {
                            e.a aVar = e.f66028b;
                            e.a.b().a((Context) this, this.j);
                            finish();
                        }
                    } else if (intent.getBooleanExtra("showDialogForm60Submitted", false)) {
                        net.one97.paytm.upgradeKyc.form60.view.a a2 = net.one97.paytm.upgradeKyc.form60.view.a.a();
                        q a3 = getSupportFragmentManager().a();
                        a3.a((Fragment) a2, net.one97.paytm.upgradeKyc.form60.view.a.class.getSimpleName());
                        a3.c();
                        new Handler().postDelayed(new Runnable() {
                            public final void run() {
                                PanUpdateActivity.a(net.one97.paytm.upgradeKyc.form60.view.a.this);
                            }
                        }, 2000);
                    }
                }
            }
            if (this.l != null) {
                d();
            }
        }
    }

    public final int a() {
        return R.layout.activity_pan_update;
    }

    public final int b() {
        return R.layout.base_toolbar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0124, code lost:
        if (r8.equals("EDITABLE_EXCLAMATED") != false) goto L_0x0128;
     */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x012a  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0191  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(net.one97.paytm.upgradeKyc.activity.PanUpdateActivity r7, com.paytm.network.model.IJRPaytmDataModel r8) {
        /*
            if (r8 == 0) goto L_0x019e
            boolean r0 = r8 instanceof net.one97.paytm.common.entity.CJRAadharPanSave
            if (r0 == 0) goto L_0x019e
            net.one97.paytm.common.entity.CJRAadharPanSave r8 = (net.one97.paytm.common.entity.CJRAadharPanSave) r8
            com.paytm.utility.b.p()
            r0 = 0
            if (r8 == 0) goto L_0x00b5
            java.lang.String r1 = r8.getErrorErrorMessage()
            if (r1 == 0) goto L_0x00b5
            java.lang.String r1 = r8.getErrorErrorCode()
            java.lang.String r2 = "4009"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0054
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
            net.one97.paytm.upgradeKyc.activity.-$$Lambda$PanUpdateActivity$CjrTl9ENoy7o9kEH9d52VfLD_Uw r2 = new net.one97.paytm.upgradeKyc.activity.-$$Lambda$PanUpdateActivity$CjrTl9ENoy7o9kEH9d52VfLD_Uw
            r2.<init>(r0)
            r0.a(r8, r1, r2)
            boolean r8 = r7.isFinishing()
            if (r8 != 0) goto L_0x0053
            boolean r7 = r7.isDestroyed()
            if (r7 != 0) goto L_0x0053
            r0.show()
        L_0x0053:
            return
        L_0x0054:
            java.lang.String r1 = r8.getErrorErrorCode()
            java.lang.String r2 = "9561"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x00a5
            java.lang.String r1 = r8.getErrorErrorMessage()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x019e
            android.app.AlertDialog$Builder r1 = new android.app.AlertDialog$Builder
            r1.<init>(r7)
            java.lang.String r8 = r8.getErrorErrorMessage()
            r1.setMessage(r8)
            r1.setCancelable(r0)
            int r8 = net.one97.paytm.upgradeKyc.R.string.report_issue
            java.lang.String r8 = r7.getString(r8)
            net.one97.paytm.upgradeKyc.activity.-$$Lambda$PanUpdateActivity$bMiZBDOQtbhTBM5ETBvtr0RzzRg r0 = new net.one97.paytm.upgradeKyc.activity.-$$Lambda$PanUpdateActivity$bMiZBDOQtbhTBM5ETBvtr0RzzRg
            r0.<init>()
            r1.setNegativeButton(r8, r0)
            int r8 = net.one97.paytm.upgradeKyc.R.string.ok
            java.lang.String r8 = r7.getString(r8)
            net.one97.paytm.upgradeKyc.activity.-$$Lambda$PanUpdateActivity$FolgTunbreTFjRjxjjzH7cGj8Rg r0 = new net.one97.paytm.upgradeKyc.activity.-$$Lambda$PanUpdateActivity$FolgTunbreTFjRjxjjzH7cGj8Rg
            r0.<init>()
            r1.setPositiveButton(r8, r0)
            boolean r8 = r7.isFinishing()
            if (r8 != 0) goto L_0x00a4
            boolean r7 = r7.isDestroyed()
            if (r7 != 0) goto L_0x00a4
            r1.show()
        L_0x00a4:
            return
        L_0x00a5:
            int r8 = net.one97.paytm.upgradeKyc.R.string.error
            java.lang.String r8 = r7.getString(r8)
            int r0 = net.one97.paytm.upgradeKyc.R.string.some_went_wrong
            java.lang.String r0 = r7.getString(r0)
            com.paytm.utility.g.b(r7, r8, r0)
            return
        L_0x00b5:
            if (r8 == 0) goto L_0x019e
            java.util.List r1 = r8.getDocuments()
            if (r1 == 0) goto L_0x019e
            java.util.List r1 = r8.getDocuments()
            int r1 = r1.size()
            if (r1 <= 0) goto L_0x019e
            java.util.List r8 = r8.getDocuments()
            java.util.Iterator r8 = r8.iterator()
        L_0x00cf:
            boolean r1 = r8.hasNext()
            if (r1 == 0) goto L_0x019e
            java.lang.Object r1 = r8.next()
            net.one97.paytm.common.entity.CJRAadharPanDocList r1 = (net.one97.paytm.common.entity.CJRAadharPanDocList) r1
            if (r1 == 0) goto L_0x00cf
            java.lang.String r2 = r1.getDocCode()
            if (r2 == 0) goto L_0x00cf
            java.lang.String r2 = r1.getDocCode()
            java.lang.String r3 = "pan"
            boolean r2 = r2.equalsIgnoreCase(r3)
            if (r2 == 0) goto L_0x00cf
            java.lang.String r8 = r1.getEditableAction()
            r2 = -1
            int r3 = r8.hashCode()
            r4 = -10211755(0xffffffffff642e55, float:-3.0330455E38)
            r5 = 2
            r6 = 1
            if (r3 == r4) goto L_0x011e
            r0 = 23774884(0x16ac6a4, float:4.312153E-38)
            if (r3 == r0) goto L_0x0114
            r0 = 1584648101(0x5e73cfa5, float:4.39211052E18)
            if (r3 == r0) goto L_0x010a
            goto L_0x0127
        L_0x010a:
            java.lang.String r0 = "NON_EDITABLE_TICKED"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L_0x0127
            r0 = 1
            goto L_0x0128
        L_0x0114:
            java.lang.String r0 = "NON_EDITABLE_WAITING"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L_0x0127
            r0 = 2
            goto L_0x0128
        L_0x011e:
            java.lang.String r3 = "EDITABLE_EXCLAMATED"
            boolean r8 = r8.equals(r3)
            if (r8 == 0) goto L_0x0127
            goto L_0x0128
        L_0x0127:
            r0 = -1
        L_0x0128:
            if (r0 == 0) goto L_0x0191
            java.lang.String r8 = "UTF-8"
            java.lang.String r1 = "kyc"
            if (r0 == r6) goto L_0x0162
            if (r0 == r5) goto L_0x0133
            goto L_0x0161
        L_0x0133:
            net.one97.paytm.upgradeKyc.helper.e$a r0 = net.one97.paytm.upgradeKyc.helper.e.f66028b
            net.one97.paytm.upgradeKyc.helper.f r0 = net.one97.paytm.upgradeKyc.helper.e.a.b()
            java.lang.String r2 = "/kyc/pan/verification-pending"
            r0.a((java.lang.String) r2, (java.lang.String) r1, (android.content.Context) r7)
            java.lang.String r0 = r7.j
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x015e
            java.lang.String r0 = r7.j     // Catch:{ UnsupportedEncodingException -> 0x0159 }
            java.lang.String r8 = java.net.URLDecoder.decode(r0, r8)     // Catch:{ UnsupportedEncodingException -> 0x0159 }
            net.one97.paytm.upgradeKyc.helper.e$a r0 = net.one97.paytm.upgradeKyc.helper.e.f66028b     // Catch:{ UnsupportedEncodingException -> 0x0159 }
            net.one97.paytm.upgradeKyc.helper.f r0 = net.one97.paytm.upgradeKyc.helper.e.a.b()     // Catch:{ UnsupportedEncodingException -> 0x0159 }
            r0.a((android.content.Context) r7, (java.lang.String) r8)     // Catch:{ UnsupportedEncodingException -> 0x0159 }
            r7.finish()     // Catch:{ UnsupportedEncodingException -> 0x0159 }
            return
        L_0x0159:
            r7 = move-exception
            r7.printStackTrace()
            return
        L_0x015e:
            r7.f()
        L_0x0161:
            return
        L_0x0162:
            net.one97.paytm.upgradeKyc.helper.e$a r0 = net.one97.paytm.upgradeKyc.helper.e.f66028b
            net.one97.paytm.upgradeKyc.helper.f r0 = net.one97.paytm.upgradeKyc.helper.e.a.b()
            java.lang.String r2 = "/kyc/pan/verification-success"
            r0.a((java.lang.String) r2, (java.lang.String) r1, (android.content.Context) r7)
            java.lang.String r0 = r7.j
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x018d
            java.lang.String r0 = r7.j     // Catch:{ UnsupportedEncodingException -> 0x0188 }
            java.lang.String r8 = java.net.URLDecoder.decode(r0, r8)     // Catch:{ UnsupportedEncodingException -> 0x0188 }
            net.one97.paytm.upgradeKyc.helper.e$a r0 = net.one97.paytm.upgradeKyc.helper.e.f66028b     // Catch:{ UnsupportedEncodingException -> 0x0188 }
            net.one97.paytm.upgradeKyc.helper.f r0 = net.one97.paytm.upgradeKyc.helper.e.a.b()     // Catch:{ UnsupportedEncodingException -> 0x0188 }
            r0.a((android.content.Context) r7, (java.lang.String) r8)     // Catch:{ UnsupportedEncodingException -> 0x0188 }
            r7.finish()     // Catch:{ UnsupportedEncodingException -> 0x0188 }
            return
        L_0x0188:
            r7 = move-exception
            r7.printStackTrace()
            return
        L_0x018d:
            r7.e()
            return
        L_0x0191:
            int r8 = net.one97.paytm.upgradeKyc.R.string.error
            java.lang.String r8 = r7.getString(r8)
            java.lang.String r0 = r1.getEditableActionMsg()
            com.paytm.utility.g.b(r7, r8, r0)
        L_0x019e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.upgradeKyc.activity.PanUpdateActivity.a(net.one97.paytm.upgradeKyc.activity.PanUpdateActivity, com.paytm.network.model.IJRPaytmDataModel):void");
    }
}
