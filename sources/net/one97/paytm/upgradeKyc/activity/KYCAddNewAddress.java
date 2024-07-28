package net.one97.paytm.upgradeKyc.activity;

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
import com.airbnb.lottie.LottieAnimationView;
import com.alipay.iap.android.webapp.sdk.app.manager.AppManagerUtil;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.b;
import com.paytm.utility.c;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.one97.paytm.common.entity.shopping.CJRAddress;
import net.one97.paytm.common.entity.upgradeKyc.UADPincode;
import net.one97.paytm.upgradeKyc.R;
import net.one97.paytm.upgradeKyc.helper.a;
import net.one97.paytm.upgradeKyc.helper.d;
import net.one97.paytm.upgradeKyc.utils.l;
import org.json.JSONArray;
import org.json.JSONObject;

public class KYCAddNewAddress extends UpgradeKycBaseActivity implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private Resources f65296a;

    /* renamed from: b  reason: collision with root package name */
    private TextInputEditText f65297b;

    /* renamed from: d  reason: collision with root package name */
    private TextInputEditText f65298d;

    /* renamed from: e  reason: collision with root package name */
    private TextInputEditText f65299e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public TextInputEditText f65300f;

    /* renamed from: g  reason: collision with root package name */
    private TextInputEditText f65301g;

    /* renamed from: h  reason: collision with root package name */
    private TextInputEditText f65302h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public TextInputEditText f65303i;
    /* access modifiers changed from: private */
    public TextInputLayout j;
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
    private ScrollView q;
    /* access modifiers changed from: private */
    public LottieAnimationView r;
    private Button s;
    private CJRAddress t;
    private int u = -1;
    private int v = -1;
    private TextWatcher w = new TextWatcher() {
        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            if (charSequence != null && charSequence.length() == 6) {
                KYCAddNewAddress.a(KYCAddNewAddress.this, charSequence.toString());
            }
            KYCAddNewAddress.this.j.setError("");
            KYCAddNewAddress.this.k.setError("");
            KYCAddNewAddress.this.l.setError("");
            KYCAddNewAddress.this.n.setError("");
            KYCAddNewAddress.this.o.setError("");
            KYCAddNewAddress.this.m.setError("");
            KYCAddNewAddress.this.p.setError("");
            KYCAddNewAddress.this.f65303i.setText("");
            KYCAddNewAddress.this.f65300f.setText("");
        }
    };
    private TextWatcher x = new TextWatcher() {
        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            KYCAddNewAddress.this.k.setError("");
            KYCAddNewAddress.this.j.setError("");
            KYCAddNewAddress.this.l.setError("");
            KYCAddNewAddress.this.n.setError("");
            KYCAddNewAddress.this.o.setError("");
            KYCAddNewAddress.this.m.setError("");
            KYCAddNewAddress.this.p.setError("");
        }
    };

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitle(getResources().getString(R.string.add_kyc_address));
        if (getIntent() != null) {
            if (getIntent().hasExtra("edit address")) {
                this.t = (CJRAddress) getIntent().getSerializableExtra("edit address");
            }
            if (getIntent().hasExtra("address1Length")) {
                this.u = getIntent().getIntExtra("address1Length", -1);
            }
            if (getIntent().hasExtra("address2Length")) {
                this.v = getIntent().getIntExtra("address2Length", -1);
            }
        }
        this.f65296a = getResources();
        this.r = (LottieAnimationView) findViewById(R.id.wallet_loader);
        this.j = (TextInputLayout) findViewById(R.id.kyc_lyt_txt_name);
        this.k = (TextInputLayout) findViewById(R.id.kyc_textinputlayout_address_1);
        this.l = (TextInputLayout) findViewById(R.id.kyc_textinputlayout_address_2);
        this.m = (TextInputLayout) findViewById(R.id.kyc_lyt_txt_pin);
        this.n = (TextInputLayout) findViewById(R.id.kyc_lyt_txt_city);
        this.o = (TextInputLayout) findViewById(R.id.kyc_lyt_state);
        this.p = (TextInputLayout) findViewById(R.id.kyc_lyt_txt_mobile_number);
        this.f65297b = (TextInputEditText) findViewById(R.id.kyc_edit_txt_name);
        this.f65298d = (TextInputEditText) findViewById(R.id.kyc_edit_txt_address_1);
        this.f65299e = (TextInputEditText) findViewById(R.id.kyc_edit_txt_address_2);
        this.f65300f = (TextInputEditText) findViewById(R.id.kyc_edit_txt_city);
        this.f65303i = (TextInputEditText) findViewById(R.id.kyc_state);
        this.f65301g = (TextInputEditText) findViewById(R.id.kyc_edit_txt_pin);
        this.f65302h = (TextInputEditText) findViewById(R.id.kyc_edit_txt_mobile_number);
        this.s = (Button) findViewById(R.id.kyc_btn_save_address);
        b.f((Context) this);
        this.s.setOnClickListener(this);
        this.q = (ScrollView) findViewById(R.id.kyc_scroll_view);
        this.f65302h.setFocusable(true);
        this.f65297b.setFilters(new InputFilter[]{new InputFilter.LengthFilter(60), new InputFilter.AllCaps()});
        int i2 = this.u;
        if (i2 != -1) {
            this.f65298d.setFilters(new InputFilter[]{new InputFilter.LengthFilter(i2), new InputFilter.AllCaps()});
        } else {
            this.f65298d.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
        }
        int i3 = this.v;
        if (i3 != -1) {
            this.f65299e.setFilters(new InputFilter[]{new InputFilter.LengthFilter(i3), new InputFilter.AllCaps()});
        } else {
            this.f65299e.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
        }
        this.f65300f.setFilters(new InputFilter[]{new InputFilter.LengthFilter(30), new InputFilter.AllCaps()});
        this.f65303i.setFilters(new InputFilter[]{new InputFilter.LengthFilter(30), new InputFilter.AllCaps()});
        this.f65300f.addTextChangedListener(new TextWatcher() {
            public final void afterTextChanged(Editable editable) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                KYCAddNewAddress.this.j.setError("");
                KYCAddNewAddress.this.k.setError("");
                KYCAddNewAddress.this.l.setError("");
                KYCAddNewAddress.this.n.setError("");
                KYCAddNewAddress.this.o.setError("");
                KYCAddNewAddress.this.m.setError("");
                KYCAddNewAddress.this.p.setError("");
                String obj = KYCAddNewAddress.this.f65300f.getText().toString();
                if (obj.length() > 0 && obj.charAt(obj.length() - 1) >= '0' && obj.charAt(obj.length() - 1) <= '9') {
                    KYCAddNewAddress.this.f65300f.setText(obj.substring(0, obj.length() - 1));
                }
                KYCAddNewAddress.this.f65300f.setSelection(KYCAddNewAddress.this.f65300f.getText().length());
            }
        });
        this.f65303i.addTextChangedListener(new TextWatcher() {
            public final void afterTextChanged(Editable editable) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                KYCAddNewAddress.this.j.setError("");
                KYCAddNewAddress.this.k.setError("");
                KYCAddNewAddress.this.l.setError("");
                KYCAddNewAddress.this.n.setError("");
                KYCAddNewAddress.this.o.setError("");
                KYCAddNewAddress.this.m.setError("");
                KYCAddNewAddress.this.p.setError("");
                String obj = KYCAddNewAddress.this.f65303i.getText().toString();
                if (obj.length() > 0 && obj.charAt(obj.length() - 1) >= '0' && obj.charAt(obj.length() - 1) <= '9') {
                    KYCAddNewAddress.this.f65303i.setText(obj.substring(0, obj.length() - 1));
                }
                KYCAddNewAddress.this.f65303i.setSelection(KYCAddNewAddress.this.f65303i.getText().length());
            }
        });
        this.f65301g.addTextChangedListener(this.w);
        this.f65297b.addTextChangedListener(this.x);
        this.f65298d.addTextChangedListener(this.x);
        this.f65299e.addTextChangedListener(this.x);
        this.f65302h.addTextChangedListener(this.x);
        b.c((TextView) this.s);
        int f2 = b.f((Context) this);
        b.f((Context) this);
        int i4 = f2 / 2;
        this.q.setPadding(i4, i4, i4, i4);
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
            this.f65297b.setText(str);
        }
        if (getIntent().hasExtra("name")) {
            String stringExtra = getIntent().getStringExtra("name");
            if (!TextUtils.isEmpty(stringExtra)) {
                this.f65297b.setText(stringExtra);
            }
        }
        if (this.t != null) {
            setTitle(getResources().getString(R.string.edit_address_text));
            this.s.setText(getString(R.string.update_address));
            if (!TextUtils.isEmpty(this.t.getAddress1())) {
                this.f65298d.setText(this.t.getAddress1());
            }
            if (!TextUtils.isEmpty(this.t.getAddress2())) {
                this.f65299e.setText(this.t.getAddress2());
            }
            if (!TextUtils.isEmpty(this.t.getState())) {
                this.f65303i.setText(this.t.getState());
            }
            if (!TextUtils.isEmpty(this.t.getCity())) {
                this.f65300f.setText(this.t.getCity());
            }
            if (!TextUtils.isEmpty(this.t.getPin())) {
                this.f65301g.setText(this.t.getPin());
            }
            if (!TextUtils.isEmpty(this.t.getMobile())) {
                this.f65302h.setText(this.t.getMobile());
            }
            if (!TextUtils.isEmpty(this.t.getName())) {
                this.f65297b.setText(this.t.getName());
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

    public final int a() {
        return R.layout.activity_kyc_add_new_address;
    }

    public final int b() {
        return R.layout.base_toolbar;
    }

    public void onClick(View view) {
        String str;
        Class<KYCAddNewAddress> cls = KYCAddNewAddress.class;
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (!(inputMethodManager == null || getCurrentFocus() == null)) {
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 2);
        }
        String obj = this.f65297b.getText().toString();
        String obj2 = this.f65298d.getText().toString();
        String obj3 = this.f65299e.getText().toString();
        String obj4 = this.f65300f.getText().toString();
        String obj5 = this.f65303i.getText().toString();
        String obj6 = this.f65301g.getText().toString();
        if (!TextUtils.isEmpty(this.f65302h.getText().toString())) {
            str = this.f65302h.getText().toString();
        } else {
            str = b.l((Context) this) != null ? b.l((Context) this) : "";
        }
        getResources();
        if (obj.trim().length() <= 0) {
            this.j.setErrorEnabled(true);
            TextInputLayout textInputLayout = this.j;
            textInputLayout.setError(getString(R.string.please_enter) + " " + this.j.getHint());
            a(this.q, (View) this.j);
        } else if (obj2.trim().length() <= 0) {
            this.k.setErrorEnabled(true);
            TextInputLayout textInputLayout2 = this.k;
            textInputLayout2.setError(getString(R.string.please_enter) + " " + this.k.getHint());
            a(this.q, (View) this.k);
        } else if (obj3.trim().length() <= 0) {
            this.l.setErrorEnabled(true);
            TextInputLayout textInputLayout3 = this.l;
            textInputLayout3.setError(getString(R.string.please_enter) + " " + this.l.getHint());
            a(this.q, (View) this.l);
        } else if (TextUtils.isEmpty(this.f65301g.getText())) {
            this.m.setErrorEnabled(true);
            TextInputLayout textInputLayout4 = this.m;
            textInputLayout4.setError(getString(R.string.please_enter) + " " + this.m.getHint());
            a(this.q, (View) this.m);
        } else if (this.f65301g.getText().length() != 6) {
            this.m.setErrorEnabled(true);
            this.m.setError(getString(R.string.msg_invalid_pin));
            a(this.q, (View) this.m);
        } else if (!TextUtils.isEmpty(this.f65301g.getText()) && Integer.parseInt(this.f65301g.getText().subSequence(0, 1).toString()) == 0) {
            this.m.setErrorEnabled(true);
            this.m.setError(getString(R.string.msg_invalid_pin));
            a(this.q, (View) this.m);
        } else if (obj4.trim().length() <= 0) {
            this.n.setErrorEnabled(true);
            TextInputLayout textInputLayout5 = this.n;
            textInputLayout5.setError(getString(R.string.please_enter) + " " + this.n.getHint());
            a(this.q, (View) this.n);
        } else if (obj5.trim().length() <= 0) {
            this.o.setErrorEnabled(true);
            TextInputLayout textInputLayout6 = this.o;
            textInputLayout6.setError(getString(R.string.please_enter) + " " + this.o.getHint());
            a(this.q, (View) this.o);
        } else if (TextUtils.isEmpty(str.trim()) || (b.b(str.trim()) && str.trim().length() == 10)) {
            CJRAddress cJRAddress = new CJRAddress();
            cJRAddress.setName(obj);
            cJRAddress.setAddress1(obj2);
            cJRAddress.setAddress2(obj3);
            cJRAddress.setCity(obj4);
            cJRAddress.setState(obj5);
            cJRAddress.setPin(obj6);
            cJRAddress.setMobile(str);
            cJRAddress.setPriority(0);
            String str2 = null;
            cJRAddress.setTitle((String) null);
            CJRAddress cJRAddress2 = this.t;
            if (cJRAddress2 == null) {
                d.a aVar = d.f66026a;
                if (d.a.a() != null) {
                    StringBuilder sb = new StringBuilder();
                    d.a aVar2 = d.f66026a;
                    d.a.a();
                    sb.append(d.a("addressesV2"));
                    sb.append(c.a(this));
                    str2 = sb.toString();
                }
                a.C1317a aVar3 = a.f66022a;
                Map<String, String> a2 = a.C1317a.a(this);
                JSONObject jSONObject = new JSONObject();
                Class<KYCAddNewAddress> cls2 = cls;
                try {
                    jSONObject.put("name", cJRAddress.getName());
                    jSONObject.put("address1", cJRAddress.getAddress1());
                    jSONObject.put("address2", cJRAddress.getAddress2());
                    jSONObject.put("city", cJRAddress.getCity());
                    jSONObject.put("state", cJRAddress.getState());
                    jSONObject.put("pin", cJRAddress.getPin());
                    jSONObject.put("mobile", cJRAddress.getMobile());
                    jSONObject.put("priority", cJRAddress.getPriority());
                    jSONObject.put("title", cJRAddress.getTitle());
                    jSONObject.put(AppManagerUtil.EXTEND_TYPE, " ");
                } catch (Exception unused) {
                }
                a.C1317a aVar4 = a.f66022a;
                com.paytm.network.b a3 = a.C1317a.a();
                a3.f42877a = this;
                a3.f42879c = a.C0715a.POST;
                a3.f42882f = a2;
                a3.f42885i = new CJRAddress();
                a3.f42884h = jSONObject.toString();
                a3.f42880d = str2;
                a3.o = cls2.getName();
                a3.n = a.b.USER_FACING;
                a3.j = new com.paytm.network.listener.b() {
                    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                        KYCAddNewAddress.a(KYCAddNewAddress.this, iJRPaytmDataModel);
                    }

                    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                        l.a();
                        if (!l.a((Context) KYCAddNewAddress.this, networkCustomError)) {
                            a.C1317a aVar = net.one97.paytm.upgradeKyc.helper.a.f66022a;
                            a.C1317a.a((Context) KYCAddNewAddress.this, networkCustomError);
                        }
                    }
                };
                com.paytm.network.a l2 = a3.l();
                if (b.c((Context) this)) {
                    net.one97.paytm.common.widgets.a.a(this.r);
                    l2.a();
                    return;
                }
                a.C1317a aVar5 = net.one97.paytm.upgradeKyc.helper.a.f66022a;
                a.C1317a.a((Context) this, l2);
                return;
            }
            Class<KYCAddNewAddress> cls3 = cls;
            if (!TextUtils.isEmpty(cJRAddress2.getId())) {
                cJRAddress.setId(this.t.getId());
            }
            d.a aVar6 = d.f66026a;
            if (d.a.a() != null) {
                StringBuilder sb2 = new StringBuilder();
                d.a aVar7 = d.f66026a;
                d.a.a();
                sb2.append(d.a("addressesV2"));
                sb2.append(c.a(this));
                str2 = sb2.toString();
            }
            String str3 = str2;
            if (URLUtil.isValidUrl(str3)) {
                a.C1317a aVar8 = net.one97.paytm.upgradeKyc.helper.a.f66022a;
                Map<String, String> a4 = a.C1317a.a(this);
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("id", cJRAddress.getId());
                    jSONObject2.put("name", cJRAddress.getName());
                    jSONObject2.put("address1", cJRAddress.getAddress1());
                    jSONObject2.put("address2", cJRAddress.getAddress2());
                    jSONObject2.put("city", cJRAddress.getCity());
                    jSONObject2.put("state", cJRAddress.getState());
                    jSONObject2.put("pin", cJRAddress.getPin());
                    jSONObject2.put("mobile", cJRAddress.getMobile());
                    jSONObject2.put("priority", cJRAddress.getPriority());
                    jSONObject2.put("title", cJRAddress.getTitle());
                } catch (Exception e2) {
                    if (b.v) {
                        e2.printStackTrace();
                    }
                }
                a.C1317a aVar9 = net.one97.paytm.upgradeKyc.helper.a.f66022a;
                com.paytm.network.b a5 = a.C1317a.a();
                a5.f42877a = this;
                a5.f42879c = a.C0715a.PUT;
                a5.f42882f = a4;
                a5.f42885i = new CJRAddress();
                a5.f42884h = jSONObject2.toString();
                a5.f42880d = str3;
                a5.o = cls3.getName();
                a5.n = a.b.USER_FACING;
                a5.j = new com.paytm.network.listener.b() {
                    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                        KYCAddNewAddress.a(KYCAddNewAddress.this, iJRPaytmDataModel);
                    }

                    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                        l.a();
                        if (!l.a((Context) KYCAddNewAddress.this, networkCustomError)) {
                            a.C1317a aVar = net.one97.paytm.upgradeKyc.helper.a.f66022a;
                            a.C1317a.a((Context) KYCAddNewAddress.this, networkCustomError);
                        }
                    }
                };
                com.paytm.network.a l3 = a5.l();
                if (b.c((Context) this)) {
                    net.one97.paytm.common.widgets.a.a(this.r);
                    l3.a();
                    return;
                }
                a.C1317a aVar10 = net.one97.paytm.upgradeKyc.helper.a.f66022a;
                a.C1317a.a((Context) this, l3);
            }
        } else {
            this.p.setErrorEnabled(true);
            this.p.setError(getString(R.string.err_valid_phone));
            a(this.q, (View) this.p);
        }
    }

    static /* synthetic */ void a(KYCAddNewAddress kYCAddNewAddress, String str) {
        String str2;
        String str3;
        d.a aVar = d.f66026a;
        if (d.a.a() != null) {
            d.a aVar2 = d.f66026a;
            d.a.a();
            str2 = d.a("uadPincode");
        } else {
            str2 = null;
        }
        String e2 = b.e((Context) kYCAddNewAddress, str2);
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        hashMap.put("session_token", com.paytm.utility.a.q(kYCAddNewAddress));
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(str);
            jSONObject.put("pincodes", jSONArray);
            jSONObject.put("addressResponseType", "SECONDARY");
            jSONObject.put("tier3Type", "UNIQUE");
            str3 = jSONObject.toString();
        } catch (Exception unused) {
            str3 = "";
        }
        UADPincode uADPincode = new UADPincode();
        uADPincode.setPincode(str);
        a.C1317a aVar3 = net.one97.paytm.upgradeKyc.helper.a.f66022a;
        com.paytm.network.b a2 = a.C1317a.a();
        a2.f42877a = kYCAddNewAddress;
        a2.f42879c = a.C0715a.POST;
        a2.f42882f = hashMap;
        a2.f42885i = uADPincode;
        a2.f42884h = str3;
        a2.f42880d = e2;
        a2.o = KYCAddNewAddress.class.getName();
        a2.n = a.b.USER_FACING;
        a2.j = new com.paytm.network.listener.b() {
            public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                KYCAddNewAddress.a(KYCAddNewAddress.this, iJRPaytmDataModel);
            }

            public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                l.a();
                if (!l.a((Context) KYCAddNewAddress.this, networkCustomError)) {
                    net.one97.paytm.common.widgets.a.b(KYCAddNewAddress.this.r);
                    a.C1317a aVar = net.one97.paytm.upgradeKyc.helper.a.f66022a;
                    a.C1317a.a((Context) KYCAddNewAddress.this, networkCustomError);
                }
            }
        };
        com.paytm.network.a l2 = a2.l();
        if (b.c((Context) kYCAddNewAddress)) {
            net.one97.paytm.common.widgets.a.a(kYCAddNewAddress.r);
            l2.a();
            return;
        }
        a.C1317a aVar4 = net.one97.paytm.upgradeKyc.helper.a.f66022a;
        a.C1317a.a((Context) kYCAddNewAddress, l2);
    }

    static /* synthetic */ void a(KYCAddNewAddress kYCAddNewAddress, IJRPaytmDataModel iJRPaytmDataModel) {
        if (iJRPaytmDataModel instanceof UADPincode) {
            net.one97.paytm.common.widgets.a.b(kYCAddNewAddress.r);
            UADPincode uADPincode = (UADPincode) iJRPaytmDataModel;
            if (uADPincode.getResponseCode() == null || !uADPincode.getResponseCode().equals("200")) {
                kYCAddNewAddress.m.setErrorEnabled(true);
                if (TextUtils.isEmpty(uADPincode.getResponseMessage())) {
                    kYCAddNewAddress.m.setError(kYCAddNewAddress.getString(R.string.msg_invalid_pin));
                } else {
                    kYCAddNewAddress.m.setError(uADPincode.getResponseMessage());
                }
            } else if (uADPincode.getPincodeMap() != null) {
                Map<String, List<UADPincode.SubPincode>> pincodeMap = uADPincode.getPincodeMap();
                for (String next : pincodeMap.keySet()) {
                    PrintStream printStream = System.out;
                    printStream.println(next + ": " + pincodeMap.get(next));
                    List list = pincodeMap.get(next);
                    kYCAddNewAddress.f65300f.setText(((UADPincode.SubPincode) list.get(0)).getTier3Value());
                    kYCAddNewAddress.f65303i.setText(((UADPincode.SubPincode) list.get(0)).getState());
                }
            } else {
                kYCAddNewAddress.m.setErrorEnabled(true);
                kYCAddNewAddress.m.setError(kYCAddNewAddress.getString(R.string.msg_invalid_pin));
            }
        } else if (iJRPaytmDataModel instanceof CJRAddress) {
            net.one97.paytm.common.widgets.a.b(kYCAddNewAddress.r);
            CJRAddress cJRAddress = (CJRAddress) iJRPaytmDataModel;
            if (!TextUtils.isEmpty(cJRAddress.getError())) {
                b.b((Context) kYCAddNewAddress, kYCAddNewAddress.f65296a.getString(R.string.error_add_update_address_title), cJRAddress.getError());
            } else if (TextUtils.isEmpty(cJRAddress.getStatus()) || !cJRAddress.getStatus().equalsIgnoreCase("Failure")) {
                Intent intent = kYCAddNewAddress.getIntent();
                String id = cJRAddress.getId();
                intent.putExtra("new_address", cJRAddress);
                intent.putExtra("kyc_new_address_ID", id);
                kYCAddNewAddress.setResult(-1, intent);
                kYCAddNewAddress.finish();
            } else {
                String message = cJRAddress.getMessage();
                if (message != null) {
                    b.b((Context) kYCAddNewAddress, kYCAddNewAddress.f65296a.getString(R.string.error_add_update_address_title), message);
                }
            }
        }
    }
}
