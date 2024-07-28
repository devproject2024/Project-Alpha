package net.one97.paytm.upgradeKyc.d;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.alipay.iap.android.webapp.sdk.app.manager.AppManagerUtil;
import com.business.merchant_payments.common.utility.AppConstants;
import com.business.merchant_payments.utility.StringUtility;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.paytm.business.merchantprofile.viewmodel.AddEditGstinViewModelKt;
import com.paytm.network.a;
import com.paytm.network.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.c;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.one97.paytm.common.entity.offline_pg.pgTransactionRequest.CJRPGTransactionRequestUtils;
import net.one97.paytm.common.entity.shopping.CJRAddress;
import net.one97.paytm.common.entity.shopping.CJRAddressList;
import net.one97.paytm.common.entity.shopping.CoreCJRAddresses;
import net.one97.paytm.common.entity.upgradeKyc.KycBookApptmt;
import net.one97.paytm.common.entity.upgradeKyc.KycDateTime;
import net.one97.paytm.common.entity.upgradeKyc.PayTMPartnerListModal;
import net.one97.paytm.common.entity.upgradeKyc.UADPincode;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import net.one97.paytm.i.h;
import net.one97.paytm.upgradeKyc.R;
import net.one97.paytm.upgradeKyc.activity.AppointmentBookActivityV2;
import net.one97.paytm.upgradeKyc.activity.FullKYCPendingActivity;
import net.one97.paytm.upgradeKyc.activity.KYCAddNewAddress;
import net.one97.paytm.upgradeKyc.helper.a;
import net.one97.paytm.upgradeKyc.helper.d;
import net.one97.paytm.upgradeKyc.helper.e;
import net.one97.paytm.upgradeKyc.utils.l;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class s extends h implements View.OnClickListener {
    private String A = "kyc";
    private String B;
    private String C;
    private ArrayList<PayTMPartnerListModal.Response> D = null;
    private TextWatcher E = new TextWatcher() {
        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            if (charSequence != null && charSequence.length() == 6) {
                s.a(s.this, charSequence.toString());
            }
            s.this.w.setError("");
            s.this.f65754g.setError("");
            s.this.f65755h.setError("");
            s.this.j.setError("");
            s.this.k.setError("");
            s.this.f65756i.setError("");
            s.this.l.setError("");
            s.this.t.setError("");
        }
    };
    private TextWatcher F = new TextWatcher() {
        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            s.this.f65754g.setError("");
            s.this.w.setError("");
            s.this.f65755h.setError("");
            s.this.j.setError("");
            s.this.k.setError("");
            s.this.f65756i.setError("");
            s.this.l.setError("");
            s.this.t.setError("");
        }
    };

    /* renamed from: a  reason: collision with root package name */
    StringBuilder f65748a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public LottieAnimationView f65749b;

    /* renamed from: c  reason: collision with root package name */
    private LinearLayout f65750c;

    /* renamed from: d  reason: collision with root package name */
    private CJRAddressList f65751d;

    /* renamed from: e  reason: collision with root package name */
    private LinearLayout f65752e;

    /* renamed from: f  reason: collision with root package name */
    private LinearLayout f65753f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public TextInputLayout f65754g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public TextInputLayout f65755h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public TextInputLayout f65756i;
    /* access modifiers changed from: private */
    public TextInputLayout j;
    /* access modifiers changed from: private */
    public TextInputLayout k;
    /* access modifiers changed from: private */
    public TextInputLayout l;
    private TextInputEditText m;
    private TextInputEditText n;
    private TextInputEditText o;
    /* access modifiers changed from: private */
    public TextInputEditText p;
    /* access modifiers changed from: private */
    public TextInputEditText q;
    private TextInputEditText r;
    private TextInputEditText s;
    /* access modifiers changed from: private */
    public TextInputLayout t;
    private ArrayList<String> u = new ArrayList<>();
    private HashMap<String, ArrayList<String>> v = new HashMap<>();
    /* access modifiers changed from: private */
    public TextInputLayout w;
    private TextInputEditText x;
    private ScrollView y;
    private long z = 0;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        e.a aVar = e.f66028b;
        e.a.b().a("/kyc-wallet-upgrade/in-person/doorstep", "kyc", (Context) getActivity());
        return layoutInflater.inflate(R.layout.activity_request_visit_v2, viewGroup, false);
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f65750c = (LinearLayout) getView().findViewById(R.id.fragment_request_visit_lyt_address);
        TextView textView = (TextView) getView().findViewById(R.id.fragment_request_visit_tv_new_address);
        this.f65752e = (LinearLayout) getView().findViewById(R.id.fragment_request_visit_lyt_no_address);
        this.f65753f = (LinearLayout) getView().findViewById(R.id.fragment_request_visit_lyt_appointment);
        this.y = (ScrollView) getView().findViewById(R.id.fragment_request_vist_scroll_parent);
        this.w = (TextInputLayout) getView().findViewById(R.id.fragment_request_visit_lyt_name);
        this.f65754g = (TextInputLayout) getView().findViewById(R.id.fragment_request_visit_lyt_address1);
        this.f65755h = (TextInputLayout) getView().findViewById(R.id.fragment_request_visit_lyt_address2);
        this.f65756i = (TextInputLayout) getView().findViewById(R.id.fragment_request_visit_lyt_pincode);
        this.j = (TextInputLayout) getView().findViewById(R.id.fragment_request_visit_lyt_city);
        this.k = (TextInputLayout) getView().findViewById(R.id.fragment_request_visit_lyt_state);
        this.l = (TextInputLayout) getView().findViewById(R.id.fragment_request_visit_lyt_title);
        this.t = (TextInputLayout) getView().findViewById(R.id.fragment_request_visit_lyt_alternate_mobile);
        this.x = (TextInputEditText) getView().findViewById(R.id.fragment_request_visit_et_name);
        this.m = (TextInputEditText) getView().findViewById(R.id.fragment_request_visit_et_address1);
        this.n = (TextInputEditText) getView().findViewById(R.id.fragment_request_visit_et_address2);
        this.o = (TextInputEditText) getView().findViewById(R.id.fragment_request_visit_et_pincode);
        this.p = (TextInputEditText) getView().findViewById(R.id.fragment_request_visit_et_city);
        this.q = (TextInputEditText) getView().findViewById(R.id.fragment_request_visit_et_state);
        this.r = (TextInputEditText) getView().findViewById(R.id.fragment_request_visit_et_title);
        this.s = (TextInputEditText) getView().findViewById(R.id.fragment_request_visit_et_alt_mobile);
        Button button = (Button) getView().findViewById(R.id.fragment_request_visit_button_add_address);
        this.f65749b = (LottieAnimationView) getView().findViewById(R.id.wallet_loader);
        this.x.setFilters(new InputFilter[]{new InputFilter.LengthFilter(60), new InputFilter.AllCaps()});
        this.m.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
        this.n.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
        if (!TextUtils.isEmpty(getArguments().getString("name"))) {
            this.x.setText(getArguments().getString("name"));
        }
        this.p.setFilters(new InputFilter[]{new InputFilter.LengthFilter(30), new InputFilter.AllCaps()});
        this.q.setFilters(new InputFilter[]{new InputFilter.LengthFilter(30), new InputFilter.AllCaps()});
        this.p.addTextChangedListener(new TextWatcher() {
            public final void afterTextChanged(Editable editable) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                s.this.f65754g.setError("");
                s.this.w.setError("");
                s.this.f65755h.setError("");
                s.this.j.setError("");
                s.this.k.setError("");
                s.this.f65756i.setError("");
                s.this.l.setError("");
                s.this.t.setError("");
                String obj = s.this.p.getText().toString();
                if (obj.length() > 0 && obj.charAt(obj.length() - 1) >= '0' && obj.charAt(obj.length() - 1) <= '9') {
                    s.this.p.setText(obj.substring(0, obj.length() - 1));
                }
                s.this.p.setSelection(s.this.p.getText().length());
            }
        });
        this.q.addTextChangedListener(new TextWatcher() {
            public final void afterTextChanged(Editable editable) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                s.this.f65754g.setError("");
                s.this.w.setError("");
                s.this.f65755h.setError("");
                s.this.j.setError("");
                s.this.k.setError("");
                s.this.f65756i.setError("");
                s.this.l.setError("");
                s.this.t.setError("");
                String obj = s.this.q.getText().toString();
                if (obj.length() > 0 && obj.charAt(obj.length() - 1) >= '0' && obj.charAt(obj.length() - 1) <= '9') {
                    s.this.q.setText(obj.substring(0, obj.length() - 1));
                }
                s.this.q.setSelection(s.this.q.getText().length());
            }
        });
        this.o.addTextChangedListener(this.E);
        this.m.addTextChangedListener(this.F);
        this.x.addTextChangedListener(this.F);
        this.n.addTextChangedListener(this.F);
        this.r.addTextChangedListener(this.F);
        this.s.addTextChangedListener(this.F);
        getView().findViewById(R.id.fragment_request_visit_button_book).setOnClickListener(this);
        textView.setOnClickListener(this);
        button.setOnClickListener(this);
        a();
        if (getActivity().getIntent() != null) {
            this.A = getActivity().getIntent().getStringExtra("vertical");
        }
        if (TextUtils.isEmpty(this.A)) {
            this.A = "kyc";
        }
    }

    private void a() {
        String str;
        d.a aVar = d.f66026a;
        if (d.a.a() != null) {
            d.a aVar2 = d.f66026a;
            d.a.a();
            str = d.a("addressesV2");
        } else {
            str = null;
        }
        if (URLUtil.isValidUrl(str)) {
            String str2 = str + c.a(getActivity());
            a.C1317a aVar3 = a.f66022a;
            Map<String, String> a2 = a.C1317a.a(getActivity());
            a.C1317a aVar4 = a.f66022a;
            b a3 = a.C1317a.a();
            a3.f42877a = getActivity();
            a3.f42879c = a.C0715a.GET;
            a3.f42882f = a2;
            a3.f42885i = new CoreCJRAddresses();
            a3.f42880d = str2;
            a3.o = s.class.getName();
            a3.n = a.b.USER_FACING;
            a3.j = new com.paytm.network.listener.b() {
                public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                    s.a(s.this, iJRPaytmDataModel);
                }

                public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                    if (s.this.getActivity() != null) {
                        l.a();
                        if (!l.a((Context) s.this.getActivity(), networkCustomError)) {
                            net.one97.paytm.common.widgets.a.b(s.this.f65749b);
                        }
                    }
                }
            };
            com.paytm.network.a l2 = a3.l();
            if (com.paytm.utility.b.c((Context) getActivity())) {
                net.one97.paytm.common.widgets.a.a(this.f65749b);
                l2.a();
            } else if (getContext() != null) {
                a.C1317a aVar5 = net.one97.paytm.upgradeKyc.helper.a.f66022a;
                a.C1317a.a(getContext(), l2);
            }
        } else {
            com.paytm.utility.b.b((Context) getActivity(), getString(R.string.error), getString(R.string.msg_invalid_url));
        }
    }

    private void b() {
        if (this.f65750c != null) {
            for (int i2 = 0; i2 < this.f65750c.getChildCount(); i2++) {
                ((RadioButton) this.f65750c.getChildAt(i2).findViewById(R.id.layout_kyc_address_rb)).setChecked(false);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view, View view2) {
        CJRAddress cJRAddress = this.f65751d.get(((Integer) view.getTag()).intValue());
        Intent intent = new Intent(getActivity(), KYCAddNewAddress.class);
        intent.putExtra("name", getArguments().getString("name"));
        intent.putExtra("edit address", cJRAddress);
        startActivityForResult(intent, 202);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(RadioButton radioButton, View view) {
        b();
        radioButton.setChecked(true);
    }

    private void a(String str) {
        if (str != null) {
            com.paytm.utility.b.b((Context) getActivity(), getResources().getString(R.string.error), str);
        }
    }

    public void onClick(View view) {
        String str;
        if (view.getId() == R.id.fragment_request_visit_tv_new_address) {
            Intent intent = new Intent(getActivity(), KYCAddNewAddress.class);
            intent.putExtra("name", getArguments().getString("name"));
            startActivityForResult(intent, 202);
        } else if (view.getId() == R.id.fragment_request_visit_button_book) {
            if (this.A.equalsIgnoreCase("kyc")) {
                HashMap hashMap = new HashMap();
                hashMap.put("kyc_user_id", com.paytm.utility.b.n((Context) getActivity()));
                hashMap.put("verify_doc_option", "Request a visit");
                e.a aVar = e.f66028b;
                e.a.b().a("kyc_verify_document_book_appointment_clicked", (HashMap<String, Object>) hashMap, (Context) getActivity());
            }
            c();
        }
        if (view.getId() == R.id.fragment_request_visit_button_add_address) {
            boolean z2 = false;
            if (TextUtils.isEmpty(this.x.getText())) {
                this.w.setErrorEnabled(true);
                TextInputLayout textInputLayout = this.w;
                textInputLayout.setError(getString(R.string.please_enter) + " " + this.w.getHint());
                a(this.y, (View) this.w);
            } else if (TextUtils.isEmpty(this.m.getText())) {
                this.f65754g.setErrorEnabled(true);
                TextInputLayout textInputLayout2 = this.f65754g;
                textInputLayout2.setError(getString(R.string.please_enter) + " " + this.f65754g.getHint());
                a(this.y, (View) this.f65754g);
            } else if (TextUtils.isEmpty(this.n.getText())) {
                this.f65755h.setErrorEnabled(true);
                TextInputLayout textInputLayout3 = this.f65755h;
                textInputLayout3.setError(getString(R.string.please_enter) + " " + this.f65755h.getHint());
                a(this.y, (View) this.f65755h);
            } else if (TextUtils.isEmpty(this.o.getText())) {
                this.f65756i.setErrorEnabled(true);
                TextInputLayout textInputLayout4 = this.f65756i;
                textInputLayout4.setError(getString(R.string.please_enter) + " " + this.f65756i.getHint());
                a(this.y, (View) this.f65756i);
            } else if (this.o.getText().length() < 6) {
                this.f65756i.setErrorEnabled(true);
                this.f65756i.setError(getString(R.string.msg_invalid_pin));
                a(this.y, (View) this.f65756i);
            } else if (!TextUtils.isEmpty(this.o.getText()) && Integer.parseInt(this.o.getText().subSequence(0, 1).toString()) == 0) {
                this.f65756i.setErrorEnabled(true);
                this.f65756i.setError(getString(R.string.msg_invalid_pin));
                a(this.y, (View) this.f65756i);
            } else if (TextUtils.isEmpty(this.p.getText())) {
                this.j.setErrorEnabled(true);
                TextInputLayout textInputLayout5 = this.j;
                textInputLayout5.setError(getString(R.string.please_enter) + " " + this.j.getHint());
                a(this.y, (View) this.j);
            } else if (TextUtils.isEmpty(this.q.getText())) {
                this.k.setErrorEnabled(true);
                TextInputLayout textInputLayout6 = this.k;
                textInputLayout6.setError(getString(R.string.please_enter) + " " + this.k.getHint());
                a(this.y, (View) this.k);
            } else if (TextUtils.isEmpty(this.s.getText()) || this.s.getText().length() >= 10) {
                if (!TextUtils.isEmpty(this.s.getText())) {
                    String obj = this.s.getText().toString();
                    getActivity();
                    if (!com.paytm.utility.b.b(obj)) {
                        this.t.setErrorEnabled(true);
                        this.t.setError(getString(R.string.mob_no_error));
                        a(this.y, (View) this.t);
                    }
                }
                z2 = true;
            } else {
                this.t.setErrorEnabled(true);
                this.t.setError(getString(R.string.msg_invalid_mobile_number));
                a(this.y, (View) this.t);
            }
            if (z2) {
                com.paytm.utility.b.c((Activity) getActivity());
                CJRAddress cJRAddress = new CJRAddress();
                cJRAddress.setName(this.x.getText().toString());
                cJRAddress.setAddress1(this.m.getText().toString());
                cJRAddress.setAddress2(this.n.getText().toString());
                cJRAddress.setCity(this.p.getText().toString());
                cJRAddress.setState(this.q.getText().toString());
                cJRAddress.setPin(this.o.getText().toString());
                if (!TextUtils.isEmpty(this.s.getText().toString())) {
                    str = this.s.getText().toString();
                } else {
                    str = com.paytm.utility.b.l((Context) getActivity());
                }
                cJRAddress.setMobile(str);
                cJRAddress.setTitle(this.r.getText().toString());
                String str2 = null;
                d.a aVar2 = d.f66026a;
                if (d.a.a() != null) {
                    StringBuilder sb = new StringBuilder();
                    d.a aVar3 = d.f66026a;
                    d.a.a();
                    sb.append(d.a("addressesV2"));
                    sb.append(c.a(getActivity()));
                    str2 = sb.toString();
                }
                a.C1317a aVar4 = net.one97.paytm.upgradeKyc.helper.a.f66022a;
                Map<String, String> a2 = a.C1317a.a(getActivity());
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("name", cJRAddress.getName());
                    jSONObject.put("address1", cJRAddress.getAddress1());
                    jSONObject.put("address2", cJRAddress.getAddress2());
                    jSONObject.put("city", cJRAddress.getCity());
                    jSONObject.put("state", cJRAddress.getState());
                    jSONObject.put("pin", cJRAddress.getPin());
                    jSONObject.put("mobile", cJRAddress.getMobile());
                    jSONObject.put("title", cJRAddress.getTitle());
                    jSONObject.put(AppManagerUtil.EXTEND_TYPE, " ");
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                a.C1317a aVar5 = net.one97.paytm.upgradeKyc.helper.a.f66022a;
                b a3 = a.C1317a.a();
                a3.f42877a = getActivity();
                a3.f42879c = a.C0715a.POST;
                a3.f42882f = a2;
                a3.f42885i = new CJRAddress();
                a3.f42884h = jSONObject.toString();
                a3.f42880d = str2;
                a3.o = s.class.getName();
                a3.n = a.b.USER_FACING;
                a3.j = new com.paytm.network.listener.b() {
                    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                        s.a(s.this, iJRPaytmDataModel);
                    }

                    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                        if (s.this.getActivity() != null) {
                            l.a();
                            if (!l.a((Context) s.this.getActivity(), networkCustomError)) {
                                net.one97.paytm.common.widgets.a.b(s.this.f65749b);
                                if (s.this.getActivity() != null) {
                                    a.C1317a aVar = net.one97.paytm.upgradeKyc.helper.a.f66022a;
                                    a.C1317a.a((Context) s.this.getActivity(), networkCustomError);
                                }
                            }
                        }
                    }
                };
                com.paytm.network.a l2 = a3.l();
                net.one97.paytm.common.widgets.a.a(this.f65749b);
                l2.a();
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

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 201 && i3 == -1) {
            a();
        }
        if (i2 == 202 && i3 == -1) {
            if (intent.hasExtra("kyc_new_address_ID")) {
                this.z = Long.parseLong(intent.getStringExtra("kyc_new_address_ID"));
            }
            a();
        }
    }

    private void c() {
        String str;
        String str2;
        d.a aVar = d.f66026a;
        CJRAddress cJRAddress = null;
        if (d.a.a() != null) {
            d.a aVar2 = d.f66026a;
            d.a.a();
            str = d.a("mw_post_appointment_url");
        } else {
            str = null;
        }
        if (!URLUtil.isValidUrl(str)) {
            com.paytm.utility.b.b((Context) getActivity(), getResources().getString(R.string.error), getResources().getString(R.string.msg_invalid_url));
            return;
        }
        if (getActivity() != null) {
            str = com.paytm.utility.b.e((Context) getActivity(), str);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(com.paytm.utility.b.n((Context) getActivity()))) {
                jSONObject.put("customerId", com.paytm.utility.b.n((Context) getActivity()));
            }
            if (this.A.equalsIgnoreCase(CJRPGTransactionRequestUtils.PAYER_BANK_NAME)) {
                jSONObject.put("leadSource", "App_SA");
            } else {
                jSONObject.put("leadSource", "App");
            }
            if (!TextUtils.isEmpty(com.paytm.utility.b.m((Context) getActivity()))) {
                jSONObject.put(AppConstants.KEY_EMAIL, com.paytm.utility.b.m((Context) getActivity()));
            }
            if (!TextUtils.isEmpty(com.paytm.utility.b.l((Context) getActivity()))) {
                jSONObject.put("phoneNumber", com.paytm.utility.b.l((Context) getActivity()));
            }
            if (this.f65750c != null) {
                CJRAddress cJRAddress2 = null;
                for (int i2 = 0; i2 < this.f65750c.getChildCount(); i2++) {
                    if (((RadioButton) this.f65750c.getChildAt(i2).findViewById(R.id.layout_kyc_address_rb)).isChecked()) {
                        cJRAddress2 = this.f65751d.get(i2);
                    }
                }
                cJRAddress = cJRAddress2;
            }
            this.f65748a = new StringBuilder();
            if (cJRAddress != null) {
                JSONObject jSONObject2 = new JSONObject();
                if (!TextUtils.isEmpty(cJRAddress.getAddress1())) {
                    StringBuilder sb = this.f65748a;
                    sb.append(cJRAddress.getAddress1());
                    this.f65748a = sb;
                    StringBuilder sb2 = this.f65748a;
                    sb2.append(", ");
                    this.f65748a = sb2;
                    jSONObject2.put("addressLine1", cJRAddress.getAddress1());
                }
                if (!TextUtils.isEmpty(cJRAddress.getAddress2())) {
                    StringBuilder sb3 = this.f65748a;
                    sb3.append(cJRAddress.getAddress2());
                    this.f65748a = sb3;
                    StringBuilder sb4 = this.f65748a;
                    sb4.append(", ");
                    this.f65748a = sb4;
                    jSONObject2.put("addressLine2", cJRAddress.getAddress2());
                }
                if (!TextUtils.isEmpty(cJRAddress.getPin())) {
                    StringBuilder sb5 = this.f65748a;
                    sb5.append(cJRAddress.getPin());
                    this.f65748a = sb5;
                    StringBuilder sb6 = this.f65748a;
                    sb6.append(", ");
                    this.f65748a = sb6;
                    this.C = cJRAddress.getPin();
                    jSONObject2.put(AddEditGstinViewModelKt.BODY_PARAM_PINCODE, cJRAddress.getPin());
                }
                if (!TextUtils.isEmpty(cJRAddress.getCity())) {
                    StringBuilder sb7 = this.f65748a;
                    sb7.append(cJRAddress.getCity());
                    this.f65748a = sb7;
                    StringBuilder sb8 = this.f65748a;
                    sb8.append(", ");
                    this.f65748a = sb8;
                    jSONObject2.put("city", cJRAddress.getCity());
                }
                if (!TextUtils.isEmpty(cJRAddress.getState())) {
                    StringBuilder sb9 = this.f65748a;
                    sb9.append(cJRAddress.getState());
                    this.f65748a = sb9;
                    jSONObject2.put("state", cJRAddress.getState());
                }
                if (!TextUtils.isEmpty(cJRAddress.getMobile())) {
                    jSONObject.put("altPhoneNumber", cJRAddress.getMobile());
                }
                jSONObject.put("kycAddress", jSONObject2);
            }
            JSONObject jSONObject3 = new JSONObject();
            if (!TextUtils.isEmpty(getArguments().getString("doc_type"))) {
                if (getArguments().getString("doc_type").equalsIgnoreCase("aadhaar card")) {
                    str2 = "aadhar card";
                } else {
                    str2 = getArguments().getString("doc_type");
                }
                jSONObject3.put("type", str2);
            }
            if (!TextUtils.isEmpty(getArguments().getString("name"))) {
                jSONObject3.put("name", getArguments().getString("name"));
            }
            String string = getArguments().getString("doc_number");
            if (!TextUtils.isEmpty(string) && string.length() <= 14) {
                jSONObject3.put("number", string.replaceAll("-", ""));
            }
            if (!TextUtils.isEmpty(getArguments().getString("doc_expiry"))) {
                try {
                    jSONObject3.put("expiry", new SimpleDateFormat("yyyy-MM-dd").format(new SimpleDateFormat("dd-MM-yyyy").parse(getArguments().getString("doc_expiry"))));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            jSONObject.put("kycDocument", jSONObject3);
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
        String jSONObject4 = jSONObject.toString();
        HashMap hashMap = new HashMap();
        hashMap.put("session_token", com.paytm.utility.a.q(getActivity()));
        hashMap.put("Content-Type", "application/json");
        a.C1317a aVar3 = net.one97.paytm.upgradeKyc.helper.a.f66022a;
        b a2 = a.C1317a.a();
        a2.f42877a = getActivity();
        a2.f42879c = a.C0715a.POST;
        a2.f42882f = hashMap;
        a2.k = false;
        a2.f42885i = new KycBookApptmt();
        a2.f42884h = jSONObject4;
        a2.o = s.class.getName();
        a2.f42880d = str;
        a2.n = a.b.USER_FACING;
        a2.j = new com.paytm.network.listener.b() {
            public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                s.a(s.this, iJRPaytmDataModel);
            }

            public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                if (s.this.getActivity() != null) {
                    l.a();
                    if (!l.a((Context) s.this.getActivity(), networkCustomError)) {
                        net.one97.paytm.common.widgets.a.b(s.this.f65749b);
                        if (s.this.getActivity() != null) {
                            a.C1317a aVar = net.one97.paytm.upgradeKyc.helper.a.f66022a;
                            a.C1317a.a((Context) s.this.getActivity(), networkCustomError);
                        }
                    }
                }
            }
        };
        com.paytm.network.a l2 = a2.l();
        if (com.paytm.utility.b.c((Context) getActivity())) {
            net.one97.paytm.common.widgets.a.a(this.f65749b);
            l2.a();
            return;
        }
        a.C1317a aVar4 = net.one97.paytm.upgradeKyc.helper.a.f66022a;
        a.C1317a.a((Context) getActivity(), l2);
    }

    static /* synthetic */ void a(s sVar, IJRPaytmDataModel iJRPaytmDataModel) {
        int i2 = 0;
        if (iJRPaytmDataModel instanceof CoreCJRAddresses) {
            net.one97.paytm.common.widgets.a.b(sVar.f65749b);
            CoreCJRAddresses coreCJRAddresses = (CoreCJRAddresses) iJRPaytmDataModel;
            if (!TextUtils.isEmpty(coreCJRAddresses.getError())) {
                sVar.f65752e.setVisibility(0);
                sVar.f65753f.setVisibility(8);
                com.paytm.utility.b.b((Context) sVar.getActivity(), sVar.getResources().getString(R.string.error_get_address_title), coreCJRAddresses.getError());
            } else if (!TextUtils.isEmpty(coreCJRAddresses.getStatus()) && coreCJRAddresses.getStatus().equalsIgnoreCase("Failure")) {
                sVar.f65752e.setVisibility(0);
                sVar.f65753f.setVisibility(8);
                sVar.a(coreCJRAddresses.getMessage());
            } else if (sVar.getActivity() != null && coreCJRAddresses != null) {
                sVar.f65751d = coreCJRAddresses.getAddress();
                CJRAddressList cJRAddressList = sVar.f65751d;
                if (cJRAddressList == null || cJRAddressList.size() <= 0) {
                    sVar.f65752e.setVisibility(0);
                    sVar.f65753f.setVisibility(8);
                    return;
                }
                sVar.f65752e.setVisibility(8);
                sVar.f65753f.setVisibility(0);
                sVar.f65750c.removeAllViews();
                int i3 = 0;
                while (i2 < sVar.f65751d.size()) {
                    if (Long.parseLong(sVar.f65751d.get(i2).getId()) == sVar.z) {
                        i3 = i2;
                    }
                    i2++;
                }
                Iterator it2 = sVar.f65751d.iterator();
                while (it2.hasNext()) {
                    CJRAddress cJRAddress = (CJRAddress) it2.next();
                    View inflate = LayoutInflater.from(sVar.getActivity()).inflate(R.layout.layout_kyc_address, (ViewGroup) null);
                    inflate.findViewById(R.id.layout_kyc_address_title);
                    RadioButton radioButton = (RadioButton) inflate.findViewById(R.id.layout_kyc_address_rb);
                    inflate.findViewById(R.id.layout_kyc_address_divider);
                    TextView textView = (TextView) inflate.findViewById(R.id.layout_kyc_address_heading);
                    TextView textView2 = (TextView) inflate.findViewById(R.id.layout_kyc_address_details);
                    ((TextView) inflate.findViewById(R.id.layout_kyc_address_btn_edit)).setOnClickListener(new View.OnClickListener(inflate) {
                        private final /* synthetic */ View f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void onClick(View view) {
                            s.this.a(this.f$1, view);
                        }
                    });
                    radioButton.setOnClickListener(new View.OnClickListener(radioButton) {
                        private final /* synthetic */ RadioButton f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void onClick(View view) {
                            s.this.a(this.f$1, view);
                        }
                    });
                    if (sVar.f65751d.indexOf(cJRAddress) == i3) {
                        sVar.b();
                        radioButton.setChecked(true);
                    }
                    inflate.setTag(Integer.valueOf(sVar.f65751d.indexOf(cJRAddress)));
                    if (!TextUtils.isEmpty(cJRAddress.getName())) {
                        textView.setText(cJRAddress.getName());
                    }
                    String str = "";
                    if (!TextUtils.isEmpty(cJRAddress.getAddress1())) {
                        str = str + cJRAddress.getAddress1() + ",\n";
                    }
                    if (!TextUtils.isEmpty(cJRAddress.getAddress2())) {
                        str = str + cJRAddress.getAddress2() + ",\n";
                    }
                    if (!TextUtils.isEmpty(cJRAddress.getCity())) {
                        str = str + cJRAddress.getCity() + ", ";
                    }
                    if (!TextUtils.isEmpty(cJRAddress.getPin())) {
                        str = str + cJRAddress.getPin() + ",\n";
                    }
                    if (!TextUtils.isEmpty(cJRAddress.getState())) {
                        str = str + cJRAddress.getState() + ",\n";
                    }
                    if (!TextUtils.isEmpty(cJRAddress.getMobile())) {
                        str = str + cJRAddress.getMobile() + StringUtility.NEW_LINE;
                    }
                    if (!TextUtils.isEmpty(str)) {
                        textView2.setText(str);
                    }
                    sVar.f65750c.addView(inflate);
                }
                a(sVar.y, sVar.f65750c.getChildAt(i3));
            }
        } else if (iJRPaytmDataModel instanceof KycBookApptmt) {
            net.one97.paytm.common.widgets.a.b(sVar.f65749b);
            KycBookApptmt kycBookApptmt = (KycBookApptmt) iJRPaytmDataModel;
            if (kycBookApptmt == null) {
                return;
            }
            if (kycBookApptmt.getErrorCode() == null || !kycBookApptmt.getErrorCode().equalsIgnoreCase("success") || kycBookApptmt.getStatusCode() != 201) {
                if (kycBookApptmt.getErrorCode() != null && kycBookApptmt.getErrorCode().equalsIgnoreCase(ImagePickerUtils.IMAGE_PICKER_KEY_STATUS_FAILURE) && kycBookApptmt.getStatusCode() == 202) {
                    sVar.f65748a.setLength(0);
                    if (!TextUtils.isEmpty(kycBookApptmt.getMessage())) {
                        sVar.a(kycBookApptmt.getMessage());
                    }
                } else if (kycBookApptmt.getErrorCode() == null || !kycBookApptmt.getErrorCode().equalsIgnoreCase(ImagePickerUtils.IMAGE_PICKER_KEY_STATUS_FAILURE) || kycBookApptmt.getStatusCode() != 200) {
                    sVar.f65748a.setLength(0);
                } else {
                    sVar.f65748a.setLength(0);
                    r rVar = new r();
                    Bundle bundle = new Bundle();
                    bundle.putString(AddEditGstinViewModelKt.BODY_PARAM_PINCODE, sVar.C);
                    if (sVar.getArguments() != null) {
                        bundle.putAll(sVar.getArguments());
                    }
                    rVar.setArguments(bundle);
                    rVar.show(sVar.getFragmentManager(), rVar.getTag());
                }
            } else if (sVar.getActivity() == null) {
            } else {
                if (!TextUtils.isEmpty(sVar.B)) {
                    try {
                        String decode = URLDecoder.decode(sVar.B, com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.UTF_8);
                        e.a aVar = e.f66028b;
                        e.a.b().a((Context) sVar.getActivity(), decode);
                        sVar.getActivity().finish();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                } else if (TextUtils.isEmpty(sVar.getArguments().getString("kycState")) || !sVar.getArguments().getString("kycState").equalsIgnoreCase("without_cersai")) {
                    Intent intent = new Intent(sVar.getActivity(), AppointmentBookActivityV2.class);
                    if (sVar.getArguments() != null) {
                        intent.putExtra("docType", sVar.getArguments().getString("doc_type"));
                        intent.putExtra("number", sVar.getArguments().getString("doc_number"));
                        intent.putExtra(AddEditGstinViewModelKt.BODY_PARAM_ADDRESS, sVar.f65748a.toString());
                    }
                    sVar.getActivity().startActivityForResult(intent, 102);
                } else {
                    Intent intent2 = new Intent(sVar.getActivity(), FullKYCPendingActivity.class);
                    intent2.setFlags(67108864);
                    sVar.startActivity(intent2);
                }
            }
        } else if (iJRPaytmDataModel instanceof CJRAddress) {
            net.one97.paytm.common.widgets.a.b(sVar.f65749b);
            CJRAddress cJRAddress2 = (CJRAddress) iJRPaytmDataModel;
            if (!TextUtils.isEmpty(cJRAddress2.getError())) {
                com.paytm.utility.b.b((Context) sVar.getActivity(), sVar.getString(R.string.error_add_update_address_title), cJRAddress2.getError());
            } else if (TextUtils.isEmpty(cJRAddress2.getStatus()) || !cJRAddress2.getStatus().equalsIgnoreCase("Failure")) {
                sVar.a();
            } else {
                sVar.a(cJRAddress2.getMessage());
            }
        } else if (iJRPaytmDataModel instanceof UADPincode) {
            net.one97.paytm.common.widgets.a.b(sVar.f65749b);
            UADPincode uADPincode = (UADPincode) iJRPaytmDataModel;
            if (uADPincode.getResponseCode() == null || !uADPincode.getResponseCode().equals("200")) {
                sVar.f65756i.setErrorEnabled(true);
                if (TextUtils.isEmpty(uADPincode.getResponseMessage())) {
                    sVar.f65756i.setError(sVar.getString(R.string.msg_invalid_pin));
                } else {
                    sVar.f65756i.setError(uADPincode.getResponseMessage());
                }
            } else if (uADPincode.getPincodeMap() != null) {
                Map<String, List<UADPincode.SubPincode>> pincodeMap = uADPincode.getPincodeMap();
                Set<String> keySet = pincodeMap.keySet();
                System.out.println("All keys are: ".concat(String.valueOf(keySet)));
                for (String next : keySet) {
                    System.out.println(next + ": " + pincodeMap.get(next));
                    List list = pincodeMap.get(next);
                    sVar.p.setText(((UADPincode.SubPincode) list.get(0)).getTier3Value());
                    sVar.q.setText(((UADPincode.SubPincode) list.get(0)).getState());
                }
            } else {
                sVar.f65756i.setErrorEnabled(true);
                sVar.f65756i.setError(sVar.getString(R.string.msg_invalid_pin));
            }
        } else if (iJRPaytmDataModel instanceof KycDateTime) {
            net.one97.paytm.common.widgets.a.b(sVar.f65749b);
            KycDateTime kycDateTime = (KycDateTime) iJRPaytmDataModel;
            if (kycDateTime == null) {
                return;
            }
            if (kycDateTime.getStatusCode() == 200) {
                if (kycDateTime.getDateTime() != null && kycDateTime.getDateTime().size() > 0) {
                    while (i2 < kycDateTime.getDateTime().size()) {
                        KycDateTime.DateTime dateTime = kycDateTime.getDateTime().get(i2);
                        if (dateTime != null) {
                            sVar.u.add(dateTime.getDate());
                            sVar.v.put(dateTime.getDate(), dateTime.getTimeSlot());
                        }
                        i2++;
                    }
                }
            } else if (!TextUtils.isEmpty(kycDateTime.getErrorMessage())) {
                sVar.a(kycDateTime.getErrorMessage());
            }
        }
    }

    static /* synthetic */ void a(s sVar, String str) {
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
        String e2 = com.paytm.utility.b.e((Context) sVar.getActivity(), str2);
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        hashMap.put("session_token", com.paytm.utility.a.q(sVar.getActivity()));
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(str);
            jSONObject.put("pincodes", jSONArray);
            jSONObject.put("addressResponseType", "SECONDARY");
            jSONObject.put("tier3Type", "UNIQUE");
            str3 = jSONObject.toString();
        } catch (Exception e3) {
            e3.printStackTrace();
            str3 = "";
        }
        UADPincode uADPincode = new UADPincode();
        uADPincode.setPincode(str);
        a.C1317a aVar3 = net.one97.paytm.upgradeKyc.helper.a.f66022a;
        b a2 = a.C1317a.a();
        a2.f42877a = sVar.getActivity();
        a2.f42879c = a.C0715a.POST;
        a2.f42882f = hashMap;
        a2.f42885i = uADPincode;
        a2.o = s.class.getName();
        a2.f42884h = str3;
        a2.f42880d = e2;
        a2.n = a.b.USER_FACING;
        a2.j = new com.paytm.network.listener.b() {
            public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                s.a(s.this, iJRPaytmDataModel);
            }

            public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                if (s.this.getActivity() != null) {
                    l.a();
                    if (!l.a((Context) s.this.getActivity(), networkCustomError)) {
                        net.one97.paytm.common.widgets.a.b(s.this.f65749b);
                        if (s.this.getActivity() != null) {
                            a.C1317a aVar = net.one97.paytm.upgradeKyc.helper.a.f66022a;
                            a.C1317a.a((Context) s.this.getActivity(), networkCustomError);
                        }
                    }
                }
            }
        };
        com.paytm.network.a l2 = a2.l();
        if (com.paytm.utility.b.c((Context) sVar.getActivity())) {
            net.one97.paytm.common.widgets.a.a(sVar.f65749b);
            l2.a();
            return;
        }
        a.C1317a aVar4 = net.one97.paytm.upgradeKyc.helper.a.f66022a;
        a.C1317a.a((Context) sVar.getActivity(), l2);
    }
}
