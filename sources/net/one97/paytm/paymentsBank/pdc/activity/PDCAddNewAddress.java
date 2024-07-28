package net.one97.paytm.paymentsBank.pdc.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.inputmethod.InputMethodManager;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import com.alipay.iap.android.webapp.sdk.app.manager.AppManagerUtil;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.paytm.business.merchantprofile.viewmodel.AddEditGstinViewModelKt;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.b;
import com.paytm.utility.c;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.bankCommon.g.g;
import net.one97.paytm.bankCommon.model.CJRPincode;
import net.one97.paytm.bankCommon.model.PBCJRAddress;
import net.one97.paytm.bankCommon.model.PBUADPincode;
import net.one97.paytm.bankCommon.utils.d;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.activity.PBBaseToolbarActivity;
import org.json.JSONArray;
import org.json.JSONObject;

public class PDCAddNewAddress extends PBBaseToolbarActivity implements View.OnClickListener, g.a, g.b<IJRPaytmDataModel> {

    /* renamed from: b  reason: collision with root package name */
    private Resources f18653b;

    /* renamed from: c  reason: collision with root package name */
    private TextInputEditText f18654c;

    /* renamed from: d  reason: collision with root package name */
    private TextInputEditText f18655d;

    /* renamed from: f  reason: collision with root package name */
    private TextInputEditText f18656f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public TextInputEditText f18657g;

    /* renamed from: h  reason: collision with root package name */
    private TextInputEditText f18658h;

    /* renamed from: i  reason: collision with root package name */
    private TextInputEditText f18659i;
    /* access modifiers changed from: private */
    public TextInputEditText j;
    /* access modifiers changed from: private */
    public TextInputLayout k;
    /* access modifiers changed from: private */
    public TextInputLayout l;
    /* access modifiers changed from: private */
    public TextInputLayout m;
    /* access modifiers changed from: private */
    public TextInputLayout n;
    /* access modifiers changed from: private */
    public TextInputLayout o;
    /* access modifiers changed from: private */
    public TextInputLayout p;
    /* access modifiers changed from: private */
    public TextInputLayout q;
    private ScrollView r;
    private Button s;
    private PBCJRAddress t;
    private int u = -1;
    private int v = -1;
    private boolean w = false;
    private TextWatcher x = new TextWatcher() {
        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            if (charSequence == null || charSequence.length() != 6) {
                PDCAddNewAddress.this.f18657g.setEnabled(true);
                PDCAddNewAddress.this.j.setEnabled(true);
                PDCAddNewAddress.this.j.setText("");
                PDCAddNewAddress.this.f18657g.setText("");
            } else {
                PDCAddNewAddress.a(PDCAddNewAddress.this, charSequence.toString());
            }
            PDCAddNewAddress.this.k.setError("");
            PDCAddNewAddress.this.l.setError("");
            PDCAddNewAddress.this.m.setError("");
            PDCAddNewAddress.this.o.setError("");
            PDCAddNewAddress.this.p.setError("");
            PDCAddNewAddress.this.n.setError("");
            PDCAddNewAddress.this.q.setError("");
        }
    };
    private TextWatcher y = new TextWatcher() {
        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            PDCAddNewAddress.this.l.setError("");
            PDCAddNewAddress.this.k.setError("");
            PDCAddNewAddress.this.m.setError("");
            PDCAddNewAddress.this.o.setError("");
            PDCAddNewAddress.this.p.setError("");
            PDCAddNewAddress.this.n.setError("");
            PDCAddNewAddress.this.q.setError("");
        }
    };

    public final int e() {
        return R.layout.pb_activity_kyc_add_new_address;
    }

    public final int f() {
        return R.layout.pb_toolbar_center_title;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ((TextView) findViewById(R.id.toolbar_title)).setText(R.string.pb_add_kyc_address);
        if (getIntent() != null) {
            if (getIntent().hasExtra("edit address")) {
                this.t = (PBCJRAddress) getIntent().getSerializableExtra("edit address");
            }
            if (getIntent().hasExtra("address1Length")) {
                this.u = getIntent().getIntExtra("address1Length", -1);
            }
            if (getIntent().hasExtra("address2Length")) {
                this.v = getIntent().getIntExtra("address2Length", -1);
            }
            if (getIntent().hasExtra("saveAdressOnserver")) {
                this.w = getIntent().hasExtra("saveAdressOnserver");
            }
        }
        this.f18653b = getResources();
        this.k = (TextInputLayout) findViewById(R.id.kyc_lyt_txt_name);
        this.l = (TextInputLayout) findViewById(R.id.kyc_textinputlayout_address_1);
        this.m = (TextInputLayout) findViewById(R.id.kyc_textinputlayout_address_2);
        this.n = (TextInputLayout) findViewById(R.id.kyc_lyt_txt_pin);
        this.o = (TextInputLayout) findViewById(R.id.kyc_lyt_txt_city);
        this.p = (TextInputLayout) findViewById(R.id.kyc_lyt_state);
        this.q = (TextInputLayout) findViewById(R.id.kyc_lyt_txt_mobile_number);
        this.f18654c = (TextInputEditText) findViewById(R.id.kyc_edit_txt_name);
        this.f18655d = (TextInputEditText) findViewById(R.id.kyc_edit_txt_address_1);
        this.f18656f = (TextInputEditText) findViewById(R.id.kyc_edit_txt_address_2);
        this.f18657g = (TextInputEditText) findViewById(R.id.kyc_edit_txt_city);
        this.j = (TextInputEditText) findViewById(R.id.kyc_state);
        this.k.setHint(getString(R.string.label_name));
        this.l.setHint(getString(R.string.house_building_apartment));
        this.m.setHint(getString(R.string.area_locality_sector));
        this.n.setHint(getString(R.string.pin));
        this.o.setHint(getString(R.string.events_traveller_city));
        this.p.setHint(getString(R.string.state));
        this.q.setHint(getString(R.string.alternate_mobile));
        this.f18658h = (TextInputEditText) findViewById(R.id.kyc_edit_txt_pin);
        this.f18659i = (TextInputEditText) findViewById(R.id.kyc_edit_txt_mobile_number);
        this.s = (Button) findViewById(R.id.kyc_btn_save_address);
        this.s.setOnClickListener(this);
        this.r = (ScrollView) findViewById(R.id.kyc_scroll_view);
        this.f18659i.setFocusable(true);
        this.f18654c.setFilters(new InputFilter[]{new InputFilter.LengthFilter(60), new InputFilter.AllCaps()});
        int i2 = this.u;
        if (i2 != -1) {
            this.f18655d.setFilters(new InputFilter[]{new InputFilter.LengthFilter(i2), new InputFilter.AllCaps()});
        } else {
            this.f18655d.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
        }
        int i3 = this.v;
        if (i3 != -1) {
            this.f18656f.setFilters(new InputFilter[]{new InputFilter.LengthFilter(i3), new InputFilter.AllCaps()});
        } else {
            this.f18656f.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
        }
        this.f18657g.setFilters(new InputFilter[]{new InputFilter.LengthFilter(30), new InputFilter.AllCaps()});
        this.j.setFilters(new InputFilter[]{new InputFilter.LengthFilter(30), new InputFilter.AllCaps()});
        this.f18657g.addTextChangedListener(new TextWatcher() {
            public final void afterTextChanged(Editable editable) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                PDCAddNewAddress.this.k.setError("");
                PDCAddNewAddress.this.l.setError("");
                PDCAddNewAddress.this.m.setError("");
                PDCAddNewAddress.this.o.setError("");
                PDCAddNewAddress.this.p.setError("");
                PDCAddNewAddress.this.n.setError("");
                PDCAddNewAddress.this.q.setError("");
                String obj = PDCAddNewAddress.this.f18657g.getText().toString();
                if (obj.length() > 0 && obj.charAt(obj.length() - 1) >= '0' && obj.charAt(obj.length() - 1) <= '9') {
                    PDCAddNewAddress.this.f18657g.setText(obj.substring(0, obj.length() - 1));
                }
                PDCAddNewAddress.this.f18657g.setSelection(PDCAddNewAddress.this.f18657g.getText().length());
            }
        });
        this.j.addTextChangedListener(new TextWatcher() {
            public final void afterTextChanged(Editable editable) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                PDCAddNewAddress.this.k.setError("");
                PDCAddNewAddress.this.l.setError("");
                PDCAddNewAddress.this.m.setError("");
                PDCAddNewAddress.this.o.setError("");
                PDCAddNewAddress.this.p.setError("");
                PDCAddNewAddress.this.n.setError("");
                PDCAddNewAddress.this.q.setError("");
                String obj = PDCAddNewAddress.this.j.getText().toString();
                if (obj.length() > 0 && obj.charAt(obj.length() - 1) >= '0' && obj.charAt(obj.length() - 1) <= '9') {
                    PDCAddNewAddress.this.j.setText(obj.substring(0, obj.length() - 1));
                }
                PDCAddNewAddress.this.j.setSelection(PDCAddNewAddress.this.j.getText().length());
            }
        });
        this.f18658h.addTextChangedListener(this.x);
        this.f18654c.addTextChangedListener(this.y);
        this.f18655d.addTextChangedListener(this.y);
        this.f18656f.addTextChangedListener(this.y);
        this.f18659i.addTextChangedListener(this.y);
        b.c((TextView) this.s);
        int f2 = b.f((Context) this);
        b.f((Context) this);
        int i4 = f2 / 2;
        this.r.setPadding(i4, i4, i4, i4);
        String str = "";
        String h2 = b.h((Context) this);
        String i5 = b.i((Context) this);
        if (h2 != null) {
            str = str + h2;
        }
        if (i5 != null) {
            str = str + " " + i5;
        }
        if (str.trim().length() > 0) {
            this.f18654c.setText(str);
        }
        if (getIntent().hasExtra("name")) {
            String stringExtra = getIntent().getStringExtra("name");
            if (!TextUtils.isEmpty(stringExtra)) {
                this.f18654c.setText(stringExtra);
            }
        }
        if (this.t != null) {
            setTitle(getResources().getString(R.string.edit_address_text));
            this.s.setText(getString(R.string.update_address));
            if (!TextUtils.isEmpty(this.t.getAddress1())) {
                this.f18655d.setText(this.t.getAddress1());
            }
            if (!TextUtils.isEmpty(this.t.getAddress2())) {
                this.f18656f.setText(this.t.getAddress2());
            }
            if (!TextUtils.isEmpty(this.t.getState())) {
                this.j.setText(this.t.getState());
            }
            if (!TextUtils.isEmpty(this.t.getCity())) {
                this.f18657g.setText(this.t.getCity());
            }
            if (!TextUtils.isEmpty(this.t.getPin())) {
                this.f18658h.setText(this.t.getPin());
            }
            if (!TextUtils.isEmpty(this.t.getMobile())) {
                this.f18659i.setText(this.t.getMobile());
            }
            if (!TextUtils.isEmpty(this.t.getName())) {
                this.f18654c.setText(this.t.getName());
            }
        }
    }

    private static void a(ScrollView scrollView, View view) {
        Point point = new Point();
        a(scrollView, view.getParent(), view, point);
        scrollView.smoothScrollTo(0, point.y);
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

    public void onClick(View view) {
        String str;
        PDCAddNewAddress pDCAddNewAddress;
        c();
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (!(inputMethodManager == null || getCurrentFocus() == null || getCurrentFocus().getWindowToken() == null)) {
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 2);
        }
        String trim = this.f18654c.getText().toString().trim();
        String trim2 = this.f18655d.getText().toString().trim();
        String trim3 = this.f18656f.getText().toString().trim();
        String trim4 = this.f18657g.getText().toString().trim();
        String trim5 = this.j.getText().toString().trim();
        String trim6 = this.f18658h.getText().toString().trim();
        if (!TextUtils.isEmpty(this.f18659i.getText().toString())) {
            str = this.f18659i.getText().toString();
        } else if (b.l((Context) this) != null) {
            str = b.l((Context) this);
        } else {
            str = "";
        }
        getResources();
        if (trim.length() <= 0) {
            this.f18654c.setText("");
            this.k.setErrorEnabled(true);
            TextInputLayout textInputLayout = this.k;
            textInputLayout.setError(getString(R.string.please_enter) + " " + this.k.getHint());
            a(this.r, (View) this.k);
            this.k.requestFocus();
        } else if (trim2.length() <= 0) {
            this.f18655d.setText("");
            this.l.setErrorEnabled(true);
            TextInputLayout textInputLayout2 = this.l;
            textInputLayout2.setError(getString(R.string.please_enter) + " " + this.l.getHint());
            a(this.r, (View) this.l);
            this.l.requestFocus();
        } else if (trim3.trim().length() <= 0) {
            this.f18656f.setText("");
            this.m.setErrorEnabled(true);
            TextInputLayout textInputLayout3 = this.m;
            textInputLayout3.setError(getString(R.string.please_enter) + " " + this.m.getHint());
            a(this.r, (View) this.m);
            this.m.requestFocus();
        } else if (TextUtils.isEmpty(this.f18658h.getText())) {
            this.n.setErrorEnabled(true);
            TextInputLayout textInputLayout4 = this.n;
            textInputLayout4.setError(getString(R.string.please_enter) + " " + this.n.getHint());
            a(this.r, (View) this.n);
            this.n.requestFocus();
        } else if (this.f18658h.getText().length() != 6) {
            this.n.setErrorEnabled(true);
            this.n.setError(getString(R.string.msg_invalid_pin));
            a(this.r, (View) this.n);
            this.n.requestFocus();
        } else if (!TextUtils.isEmpty(this.f18658h.getText()) && Integer.parseInt(this.f18658h.getText().subSequence(0, 1).toString()) == 0) {
            this.n.setErrorEnabled(true);
            this.n.setError(getString(R.string.msg_invalid_pin));
            a(this.r, (View) this.n);
            this.n.requestFocus();
        } else if (trim4.trim().length() <= 0) {
            this.n.setErrorEnabled(true);
            this.n.setError(getString(R.string.msg_invalid_pin));
            a(this.r, (View) this.n);
            this.n.requestFocus();
        } else if (trim5.trim().length() <= 0) {
            this.n.setErrorEnabled(true);
            this.n.setError(getString(R.string.msg_invalid_pin));
            a(this.r, (View) this.n);
            this.n.requestFocus();
        } else if (TextUtils.isEmpty(str.trim()) || (b.b(str.trim()) && str.trim().length() == 10)) {
            PBCJRAddress pBCJRAddress = new PBCJRAddress();
            pBCJRAddress.setName(trim);
            pBCJRAddress.setAddress1(trim2);
            pBCJRAddress.setAddress2(trim3);
            pBCJRAddress.setCity(trim4);
            pBCJRAddress.setState(trim5);
            pBCJRAddress.setPin(trim6);
            pBCJRAddress.setMobile(str);
            pBCJRAddress.setPriority(0);
            pBCJRAddress.setTitle((String) null);
            if (this.w) {
                a(pBCJRAddress);
                return;
            }
            PBCJRAddress pBCJRAddress2 = this.t;
            if (pBCJRAddress2 == null) {
                StringBuilder sb = new StringBuilder();
                net.one97.paytm.bankCommon.mapping.g.a();
                sb.append(d.a("addressesV2"));
                sb.append(c.a(this));
                String sb2 = sb.toString();
                Map<String, String> e2 = net.one97.paytm.bankCommon.mapping.d.e(this);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("name", pBCJRAddress.getName());
                    jSONObject.put("address1", pBCJRAddress.getAddress1());
                    jSONObject.put("address2", pBCJRAddress.getAddress2());
                    jSONObject.put("city", pBCJRAddress.getCity());
                    jSONObject.put("state", pBCJRAddress.getState());
                    jSONObject.put("pin", pBCJRAddress.getPin());
                    jSONObject.put("mobile", pBCJRAddress.getMobile());
                    jSONObject.put("priority", pBCJRAddress.getPriority());
                    jSONObject.put("title", pBCJRAddress.getTitle());
                    jSONObject.put(AppManagerUtil.EXTEND_TYPE, " ");
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
                HashMap hashMap = new HashMap();
                hashMap.put("screen_name", getClass().getSimpleName());
                net.one97.paytm.bankCommon.g.b bVar = new net.one97.paytm.bankCommon.g.b(sb2, (g.b<IJRPaytmDataModel>) this, (g.a) this, (IJRPaytmDataModel) new PBCJRAddress(), (Map<String, String>) null, e2, jSONObject.toString(), a.C0715a.POST, a.c.PAYMENTSBANK, a.b.USER_FACING, (HashMap<String, String>) hashMap);
                if (b.c((Context) this)) {
                    a(this, getResources().getString(R.string.pb_please_wait_progress_msg));
                    getApplicationContext();
                    new net.one97.paytm.bankCommon.g.c();
                    net.one97.paytm.bankCommon.g.c.a(bVar);
                    return;
                }
                b(bVar);
                return;
            }
            if (!TextUtils.isEmpty(pBCJRAddress2.getId())) {
                pBCJRAddress.setId(this.t.getId());
            }
            StringBuilder sb3 = new StringBuilder();
            getApplicationContext();
            net.one97.paytm.bankCommon.mapping.g.a();
            sb3.append(d.a("addressesV2"));
            sb3.append(c.a(this));
            String sb4 = sb3.toString();
            if (URLUtil.isValidUrl(sb4)) {
                Map<String, String> e4 = net.one97.paytm.bankCommon.mapping.d.e(this);
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("id", pBCJRAddress.getId());
                    jSONObject2.put("name", pBCJRAddress.getName());
                    jSONObject2.put("address1", pBCJRAddress.getAddress1());
                    jSONObject2.put("address2", pBCJRAddress.getAddress2());
                    jSONObject2.put("city", pBCJRAddress.getCity());
                    jSONObject2.put("state", pBCJRAddress.getState());
                    jSONObject2.put("pin", pBCJRAddress.getPin());
                    jSONObject2.put("mobile", pBCJRAddress.getMobile());
                    jSONObject2.put("priority", pBCJRAddress.getPriority());
                    jSONObject2.put("title", pBCJRAddress.getTitle());
                } catch (Exception e5) {
                    if (b.v) {
                        e5.printStackTrace();
                    }
                }
                HashMap hashMap2 = new HashMap();
                hashMap2.put("screen_name", getClass().getSimpleName());
                net.one97.paytm.bankCommon.g.b bVar2 = new net.one97.paytm.bankCommon.g.b(sb4, (g.b<IJRPaytmDataModel>) this, (g.a) this, (IJRPaytmDataModel) new PBCJRAddress(), (Map<String, String>) null, e4, jSONObject2.toString(), a.C0715a.PUT, a.c.PAYMENTSBANK, a.b.USER_FACING, (HashMap<String, String>) hashMap2);
                if (b.c((Context) this)) {
                    pDCAddNewAddress = this;
                    pDCAddNewAddress.a(pDCAddNewAddress, getResources().getString(R.string.pb_please_wait_progress_msg));
                    getApplicationContext();
                    new net.one97.paytm.bankCommon.g.c();
                    net.one97.paytm.bankCommon.g.c.a(bVar2);
                } else {
                    pDCAddNewAddress = this;
                }
                pDCAddNewAddress.b(bVar2);
                return;
            }
        } else {
            this.q.setErrorEnabled(true);
            this.q.setError(getString(R.string.err_valid_phone));
            a(this.r, (View) this.q);
        }
    }

    /* renamed from: a_ */
    public final void onResponse(IJRPaytmDataModel iJRPaytmDataModel) {
        ah_();
        if (iJRPaytmDataModel instanceof CJRPincode) {
            CJRPincode cJRPincode = (CJRPincode) iJRPaytmDataModel;
            if (cJRPincode != null) {
                String state = cJRPincode.getState();
                String city = cJRPincode.getCity();
                if (state != null) {
                    this.j.setText(state);
                }
                if (city != null) {
                    this.f18657g.setText(city);
                }
                c();
            }
        } else if (iJRPaytmDataModel instanceof PBCJRAddress) {
            PBCJRAddress pBCJRAddress = (PBCJRAddress) iJRPaytmDataModel;
            if (!TextUtils.isEmpty(pBCJRAddress.getError())) {
                b.b((Context) this, this.f18653b.getString(R.string.error_add_update_address_title), pBCJRAddress.getError());
            } else if (TextUtils.isEmpty(pBCJRAddress.getStatus()) || !pBCJRAddress.getStatus().equalsIgnoreCase("Failure")) {
                a(pBCJRAddress);
            } else {
                String message = pBCJRAddress.getMessage();
                if (message != null) {
                    b.b((Context) this, this.f18653b.getString(R.string.error_add_update_address_title), message);
                }
            }
        } else if (iJRPaytmDataModel instanceof PBUADPincode) {
            c();
            PBUADPincode pBUADPincode = (PBUADPincode) iJRPaytmDataModel;
            if (pBUADPincode.getResponseCode() == null || !pBUADPincode.getResponseCode().equals("200")) {
                this.n.setErrorEnabled(true);
                this.n.setError(getString(R.string.msg_invalid_pin));
            } else if (pBUADPincode.getPincodeList() == null || pBUADPincode.getPincodeList().size() <= 0) {
                this.n.setErrorEnabled(true);
                this.n.setError(getString(R.string.msg_invalid_pin));
            } else {
                this.f18657g.setText(pBUADPincode.getPincodeList().get(0).getTier3Value());
                this.j.setText(pBUADPincode.getPincodeList().get(0).getState());
                c();
            }
        }
    }

    public void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        if (networkCustomError == null) {
            return;
        }
        if (!TextUtils.isEmpty(networkCustomError.getUrl()) && networkCustomError.getUrl().contains(AddEditGstinViewModelKt.BODY_PARAM_PINCODE) && networkCustomError.getAlertTitle() != null && networkCustomError.getAlertTitle().equalsIgnoreCase("404")) {
            this.n.setError("");
        } else if (!TextUtils.isEmpty(networkCustomError.getUrl()) && networkCustomError.getUrl().contains(AddEditGstinViewModelKt.BODY_PARAM_PINCODE)) {
            c();
            if (!TextUtils.isEmpty(networkCustomError.getAlertMessage())) {
                this.n.setError(networkCustomError.getAlertMessage());
                return;
            }
            this.n.setErrorEnabled(true);
            this.n.setError(getString(R.string.msg_invalid_pin));
        }
    }

    private void a(PBCJRAddress pBCJRAddress) {
        Intent intent = getIntent();
        String id = pBCJRAddress.getId();
        intent.putExtra("new_address", pBCJRAddress);
        intent.putExtra("kyc_new_address_ID", id);
        setResult(-1, intent);
        finish();
    }

    static /* synthetic */ void a(PDCAddNewAddress pDCAddNewAddress, String str) {
        String str2;
        net.one97.paytm.bankCommon.mapping.g.a();
        String a2 = d.a("pb_bank_get_city_url");
        if (TextUtils.isEmpty(a2)) {
            a2 = "https://uad.paytmbank.com/uad/v1/addressInformation/oauth/pincode";
        }
        String e2 = b.e((Context) pDCAddNewAddress, a2);
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        hashMap.put("session_token", com.paytm.utility.a.q(pDCAddNewAddress));
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(str);
            jSONObject.put("pincodes", jSONArray);
            jSONObject.put("addressResponseType", "SECONDARY");
            jSONObject.put("tier3Type", "UNIQUE");
            str2 = jSONObject.toString();
        } catch (Exception e3) {
            e3.printStackTrace();
            str2 = "";
        }
        PBUADPincode pBUADPincode = new PBUADPincode();
        pBUADPincode.setPincode(str);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("screen_name", pDCAddNewAddress.getClass().getSimpleName());
        net.one97.paytm.bankCommon.g.b bVar = new net.one97.paytm.bankCommon.g.b(e2, (g.b<IJRPaytmDataModel>) pDCAddNewAddress, (g.a) pDCAddNewAddress, (IJRPaytmDataModel) pBUADPincode, (Map<String, String>) null, (Map<String, String>) hashMap, str2, a.C0715a.POST, a.c.PAYMENTSBANK, a.b.USER_FACING, (HashMap<String, String>) hashMap2);
        if (b.c((Context) pDCAddNewAddress)) {
            pDCAddNewAddress.a(pDCAddNewAddress, pDCAddNewAddress.getString(R.string.pb_please_wait));
            pDCAddNewAddress.getApplicationContext();
            new net.one97.paytm.bankCommon.g.c();
            net.one97.paytm.bankCommon.g.c.a(bVar);
            return;
        }
        pDCAddNewAddress.b(bVar);
    }
}
