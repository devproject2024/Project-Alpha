package net.one97.paytm.bankOpen.b;

import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Filter;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.paytm.business.merchantprofile.viewmodel.AddEditGstinViewModelKt;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import net.one97.paytm.bankCommon.c.a;
import net.one97.paytm.bankCommon.d.b;
import net.one97.paytm.bankCommon.f.e;
import net.one97.paytm.bankCommon.g.g;
import net.one97.paytm.bankCommon.mapping.c;
import net.one97.paytm.bankCommon.model.BankAccOpen;
import net.one97.paytm.bankCommon.model.NomineeAdd;
import net.one97.paytm.bankCommon.model.NomineeModel;
import net.one97.paytm.bankCommon.model.PBUADPincode;
import net.one97.paytm.bankCommon.model.nominee.NomineeUpdateResponse;
import net.one97.paytm.bankCommon.model.slfd.SlfdAddNomineeResponseModel;
import net.one97.paytm.bankCommon.utils.f;
import net.one97.paytm.bankOpen.R;
import net.one97.paytm.bankOpen.b.c;
import net.one97.paytm.common.widgets.d;
import net.one97.paytm.upi.util.CJRGTMConstants;
import org.json.JSONArray;
import org.json.JSONObject;

public class d extends b implements View.OnClickListener, View.OnFocusChangeListener, TextView.OnEditorActionListener, g.a, g.b<IJRPaytmDataModel>, d.a {
    private boolean A;
    private boolean B;
    private String C;
    private TextInputLayout D;
    private NomineeModel E;
    private NomineeModel F;
    private FrameLayout G;
    private c H;
    private View I;

    /* renamed from: b  reason: collision with root package name */
    private final String[] f16375b = {"Husband", "Wife", "Mother", "Father", "Son", "Daughter", "Brother", "Sister", "Guardian", "Other"};

    /* renamed from: c  reason: collision with root package name */
    public boolean f16376c;

    /* renamed from: d  reason: collision with root package name */
    public Context f16377d;

    /* renamed from: e  reason: collision with root package name */
    public TextInputEditText f16378e;

    /* renamed from: f  reason: collision with root package name */
    public int f16379f = -1;

    /* renamed from: g  reason: collision with root package name */
    TextWatcher f16380g = new TextWatcher() {
        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            d.this.j();
        }
    };

    /* renamed from: h  reason: collision with root package name */
    TextWatcher f16381h = new TextWatcher() {
        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            d.this.j();
            if (i3 == 0) {
                if (charSequence.length() == 2 || charSequence.length() == 5) {
                    TextInputEditText b2 = d.this.q;
                    b2.setText(d.this.q.getText() + "/");
                    d.this.q.setSelection(d.this.q.getText().length());
                }
                if (d.this.q.getText().length() == 10) {
                    try {
                        int parseInt = Integer.parseInt(d.this.q.getText().toString().substring(d.this.q.getText().length() - 4));
                        Calendar unused = d.this.r = Calendar.getInstance();
                        d.this.r.set(1, parseInt);
                    } catch (NumberFormatException unused2) {
                    }
                }
            }
        }
    };

    /* renamed from: i  reason: collision with root package name */
    private TextInputEditText f16382i;
    private TextInputLayout j;
    private TextInputLayout k;
    private TextInputLayout l;
    private TextInputLayout m;
    private TextInputLayout n;
    /* access modifiers changed from: private */
    public TextInputLayout o;
    private TextInputLayout p;
    /* access modifiers changed from: private */
    public TextInputEditText q;
    /* access modifiers changed from: private */
    public Calendar r;
    private TextInputEditText s;
    private TextInputEditText t;
    private TextInputEditText u;
    /* access modifiers changed from: private */
    public TextInputEditText v;
    /* access modifiers changed from: private */
    public AutoCompleteTextView w;
    /* access modifiers changed from: private */
    public TextInputEditText x;
    private TextInputEditText y;
    private NestedScrollView z;

    public int d() {
        return 0;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        this.f16377d = context;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (d() == 0) {
            this.C = getArguments().getString("ACCOUNT_NUMBER");
            this.A = getArguments().getBoolean("DO_CREATE_ACCOUNT", true);
            this.B = getArguments().getBoolean("add_nominee_for_slfd", false);
            if (this.B) {
                c.a("/fixed-deposit/pb_nominee-details", "fixed-deposit", this.f16377d);
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_payment_bank_add_nominee, (ViewGroup) null);
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (d() == 0) {
            c.a("/bank/saving-account/add-details-pb_nominee", CJRGTMConstants.GTM_VERTICAL_BANK_SAVINGS_ACCOUNT, (Context) getActivity());
        }
        this.f16382i = (TextInputEditText) getView().findViewById(R.id.add_nominee_edt_name);
        this.q = (TextInputEditText) getView().findViewById(R.id.add_nominee_edt_dob);
        this.s = (TextInputEditText) getView().findViewById(R.id.add_nominee_edt_address_line1);
        this.t = (TextInputEditText) getView().findViewById(R.id.add_nominee_edt_address_line2);
        this.u = (TextInputEditText) getView().findViewById(R.id.add_nominee_edt_address_line3);
        this.v = (TextInputEditText) getView().findViewById(R.id.add_nominee_edt_pincode);
        this.w = (AutoCompleteTextView) getView().findViewById(R.id.add_nominee_edt_city);
        this.x = (TextInputEditText) getView().findViewById(R.id.add_nominee_edt_state);
        this.f16378e = (TextInputEditText) getView().findViewById(R.id.add_nominee_edt_relationship);
        this.y = (TextInputEditText) getView().findViewById(R.id.add_nominee_edt_email);
        if (d() == 0) {
            getView().findViewById(R.id.add_nominee_img_close).setOnClickListener(this);
        }
        this.j = (TextInputLayout) getView().findViewById(R.id.add_nominee_til_name);
        this.k = (TextInputLayout) getView().findViewById(R.id.add_nominee_til_dob);
        this.l = (TextInputLayout) getView().findViewById(R.id.add_nominee_til_relationship);
        this.m = (TextInputLayout) getView().findViewById(R.id.add_nominee_til_address_line1);
        this.n = (TextInputLayout) getView().findViewById(R.id.add_nominee_til_address_line2);
        this.D = (TextInputLayout) getView().findViewById(R.id.add_nominee_til_address_line3);
        this.o = (TextInputLayout) getView().findViewById(R.id.add_nominee_til_pincode);
        this.p = (TextInputLayout) getView().findViewById(R.id.add_nominee_til_email_address);
        this.z = (NestedScrollView) getView().findViewById(R.id.add_nominee_sv_layout);
        this.G = (FrameLayout) getView().findViewById(R.id.fragment_container);
        if (getArguments() != null) {
            this.E = (NomineeModel) getArguments().getSerializable("NOMINEE_ITEM");
        }
        if (this.E != null) {
            getView().findViewById(R.id.toolbarLayout).setVisibility(8);
            this.f16382i.setText(this.E.getName());
            this.q.setText(this.E.getDob());
            this.y.setText(this.E.getEmail());
            this.x.setText(this.E.getState());
            this.w.setText(this.E.getCity());
            this.v.setText(this.E.getPinCode());
            this.s.setText(this.E.getHouseNo());
            this.t.setText(this.E.getStreetName());
            this.u.setText(this.E.getAreaName());
            this.f16378e.setText(this.E.getRelationship());
            if (this.E.getGuardians() != null && this.E.getGuardians().size() > 0) {
                k();
            }
        }
        this.f16382i.addTextChangedListener(this.f16380g);
        this.q.addTextChangedListener(this.f16381h);
        this.s.addTextChangedListener(this.f16380g);
        this.t.addTextChangedListener(this.f16380g);
        this.u.addTextChangedListener(this.f16380g);
        this.f16378e.addTextChangedListener(this.f16380g);
        this.y.addTextChangedListener(this.f16380g);
        this.q.setOnFocusChangeListener(this);
        this.q.setOnClickListener(this);
        this.q.setFocusable(false);
        this.q.setLongClickable(false);
        this.f16378e.setOnFocusChangeListener(this);
        this.f16378e.setOnClickListener(this);
        this.x.setEnabled(false);
        this.w.setFocusable(false);
        this.w.setClickable(true);
        getView().findViewById(R.id.add_nominee_img_dob_info).setOnClickListener(this);
        getView().findViewById(R.id.paytments_bank_add_nominee_btn_submit).setOnClickListener(this);
        this.v.addTextChangedListener(new TextWatcher() {
            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                d.this.o.setError("");
                d.this.o.setErrorEnabled(false);
                if (d.this.v.getText().toString().length() >= 6) {
                    d dVar = d.this;
                    d.a(dVar, dVar.v.getText().toString());
                }
            }

            public final void afterTextChanged(Editable editable) {
                d.this.w.setText("");
                d.this.w.setAdapter((ListAdapter) null);
                d.this.x.setText("");
            }
        });
        this.f16382i.setOnEditorActionListener(this);
        this.y.setImeOptions(6);
    }

    public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
        if (textView.getId() == this.f16382i.getId()) {
            c();
            this.q.performClick();
            this.f16382i.clearFocus();
            return true;
        } else if (textView.getId() != this.y.getId()) {
            return false;
        } else {
            c();
            return true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x00b7 A[Catch:{ Exception -> 0x00cf }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00cb A[Catch:{ Exception -> 0x00cf }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onClick(android.view.View r15) {
        /*
            r14 = this;
            java.lang.String r0 = "isAadhaarConsent"
            int r15 = r15.getId()
            int r1 = net.one97.paytm.bankOpen.R.id.add_nominee_img_close
            if (r15 != r1) goto L_0x000e
            r14.i()
            return
        L_0x000e:
            int r1 = net.one97.paytm.bankOpen.R.id.add_nominee_img_dob_info
            r2 = 0
            if (r15 != r1) goto L_0x003d
            android.content.Context r15 = r14.f16377d
            java.lang.String r0 = "layout_inflater"
            java.lang.Object r15 = r15.getSystemService(r0)
            android.view.LayoutInflater r15 = (android.view.LayoutInflater) r15
            int r0 = net.one97.paytm.bankOpen.R.layout.add_nominee_dob_info
            r1 = 0
            android.view.View r15 = r15.inflate(r0, r1)
            android.widget.PopupWindow r0 = new android.widget.PopupWindow
            r1 = -2
            r0.<init>(r15, r1, r1)
            int r15 = android.os.Build.VERSION.SDK_INT
            r1 = 21
            if (r15 < r1) goto L_0x0035
            r15 = 1084227584(0x40a00000, float:5.0)
            r0.setElevation(r15)
        L_0x0035:
            com.google.android.material.textfield.TextInputEditText r15 = r14.q
            r1 = 17
            r0.showAtLocation(r15, r1, r2, r2)
            return
        L_0x003d:
            int r1 = net.one97.paytm.bankOpen.R.id.paytments_bank_add_nominee_btn_submit
            if (r15 != r1) goto L_0x02b5
            int r15 = r14.d()
            r1 = 1
            if (r15 != 0) goto L_0x02a8
            boolean r15 = r14.f()
            if (r15 == 0) goto L_0x02c4
            androidx.fragment.app.FragmentActivity r3 = r14.getActivity()
            java.lang.String r4 = "bank_saving_account"
            java.lang.String r5 = "add_nominee_details_proceed_clicked"
            java.lang.String r6 = ""
            java.lang.String r7 = ""
            java.lang.String r8 = "/bank/saving-account/add-details-pb_nominee"
            java.lang.String r9 = "banksavingsaccount"
            net.one97.paytm.bankCommon.mapping.c.a(r3, r4, r5, r6, r7, r8, r9)
            boolean r15 = r14.A
            java.lang.String r3 = "screen_name"
            if (r15 == 0) goto L_0x00d8
            androidx.fragment.app.FragmentActivity r15 = r14.getActivity()     // Catch:{ Exception -> 0x00cf }
            boolean r15 = r15 instanceof net.one97.paytm.bankOpen.activity.PaymentsBankBaseActivity     // Catch:{ Exception -> 0x00cf }
            if (r15 == 0) goto L_0x0079
            androidx.fragment.app.FragmentActivity r15 = r14.getActivity()     // Catch:{ Exception -> 0x00cf }
            net.one97.paytm.bankOpen.activity.PaymentsBankBaseActivity r15 = (net.one97.paytm.bankOpen.activity.PaymentsBankBaseActivity) r15     // Catch:{ Exception -> 0x00cf }
            boolean r2 = r15.f16348b     // Catch:{ Exception -> 0x00cf }
        L_0x0077:
            r15 = r2
            goto L_0x008d
        L_0x0079:
            android.os.Bundle r15 = r14.getArguments()     // Catch:{ Exception -> 0x00cf }
            boolean r15 = r15.containsKey(r0)     // Catch:{ Exception -> 0x00cf }
            if (r15 == 0) goto L_0x008c
            android.os.Bundle r15 = r14.getArguments()     // Catch:{ Exception -> 0x00cf }
            boolean r2 = r15.getBoolean(r0)     // Catch:{ Exception -> 0x00cf }
            goto L_0x0077
        L_0x008c:
            r15 = 0
        L_0x008d:
            java.util.HashMap r8 = new java.util.HashMap     // Catch:{ Exception -> 0x00cf }
            r8.<init>()     // Catch:{ Exception -> 0x00cf }
            java.lang.Class r0 = r14.getClass()     // Catch:{ Exception -> 0x00cf }
            java.lang.String r0 = r0.getSimpleName()     // Catch:{ Exception -> 0x00cf }
            r8.put(r3, r0)     // Catch:{ Exception -> 0x00cf }
            android.content.Context r0 = r14.f16377d     // Catch:{ Exception -> 0x00cf }
            r1 = 1
            net.one97.paytm.bankCommon.model.NomineeModel r2 = r14.g()     // Catch:{ Exception -> 0x00cf }
            com.paytm.network.a$c r6 = com.paytm.network.a.c.PAYMENTSBANK     // Catch:{ Exception -> 0x00cf }
            com.paytm.network.a$b r7 = com.paytm.network.a.b.USER_FACING     // Catch:{ Exception -> 0x00cf }
            r3 = r15
            r4 = r14
            r5 = r14
            net.one97.paytm.bankCommon.g.f r15 = net.one97.paytm.bankOpen.a.a.a((android.content.Context) r0, (boolean) r1, (net.one97.paytm.bankCommon.model.NomineeModel) r2, (boolean) r3, (net.one97.paytm.bankCommon.g.g.b<com.paytm.network.model.IJRPaytmDataModel>) r4, (net.one97.paytm.bankCommon.g.g.a) r5, (com.paytm.network.a.c) r6, (com.paytm.network.a.b) r7, (java.util.HashMap<java.lang.String, java.lang.String>) r8)     // Catch:{ Exception -> 0x00cf }
            android.content.Context r0 = r14.f16377d     // Catch:{ Exception -> 0x00cf }
            boolean r0 = com.paytm.utility.b.c((android.content.Context) r0)     // Catch:{ Exception -> 0x00cf }
            if (r0 == 0) goto L_0x00cb
            android.content.Context r0 = r14.f16377d     // Catch:{ Exception -> 0x00cf }
            int r1 = net.one97.paytm.bankOpen.R.string.pb_please_wait     // Catch:{ Exception -> 0x00cf }
            java.lang.String r1 = r14.getString(r1)     // Catch:{ Exception -> 0x00cf }
            r14.a(r0, r1)     // Catch:{ Exception -> 0x00cf }
            net.one97.paytm.bankCommon.g.c r0 = new net.one97.paytm.bankCommon.g.c     // Catch:{ Exception -> 0x00cf }
            r0.<init>()     // Catch:{ Exception -> 0x00cf }
            net.one97.paytm.bankCommon.g.c.a(r15)     // Catch:{ Exception -> 0x00cf }
            return
        L_0x00cb:
            r14.a((net.one97.paytm.bankCommon.g.f) r15)     // Catch:{ Exception -> 0x00cf }
            return
        L_0x00cf:
            r15 = move-exception
            boolean r0 = com.paytm.utility.b.v
            if (r0 == 0) goto L_0x00d7
            r15.printStackTrace()
        L_0x00d7:
            return
        L_0x00d8:
            boolean r15 = r14.B
            if (r15 == 0) goto L_0x0230
            androidx.fragment.app.FragmentActivity r4 = r14.getActivity()
            r7 = 0
            r8 = 0
            r9 = 0
            java.lang.String r5 = "fixed_deposit"
            java.lang.String r6 = "nominee_details_submit_button_clicked"
            java.lang.String r10 = "/fixed-deposit/pb_nominee-details"
            java.lang.String r11 = "fixed_deposit"
            net.one97.paytm.bankCommon.mapping.c.a(r4, r5, r6, r7, r8, r9, r10, r11)
            net.one97.paytm.bankCommon.utils.d.b()
            java.lang.String r15 = "slfd_add_nominee_api"
            java.lang.String r5 = net.one97.paytm.bankCommon.utils.d.a(r15)
            java.util.HashMap r9 = new java.util.HashMap
            r9.<init>()
            net.one97.paytm.bankOpen.c r15 = net.one97.paytm.bankOpen.f.a()
            android.content.Context r0 = r14.f16377d
            java.lang.String r15 = r15.getUserToken(r0)
            java.lang.String r0 = "User-Token"
            r9.put(r0, r15)
            org.json.JSONObject r15 = new org.json.JSONObject
            r15.<init>()
            java.lang.String r0 = "active"
            r15.put(r0, r1)     // Catch:{ JSONException -> 0x022b }
            com.google.android.material.textfield.TextInputEditText r0 = r14.f16382i     // Catch:{ JSONException -> 0x022b }
            android.text.Editable r0 = r0.getText()     // Catch:{ JSONException -> 0x022b }
            java.lang.String r0 = r0.toString()     // Catch:{ JSONException -> 0x022b }
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ JSONException -> 0x022b }
            if (r1 != 0) goto L_0x012b
            java.lang.String r1 = "name"
            r15.put(r1, r0)     // Catch:{ JSONException -> 0x022b }
        L_0x012b:
            com.google.android.material.textfield.TextInputEditText r0 = r14.q     // Catch:{ JSONException -> 0x022b }
            android.text.Editable r0 = r0.getText()     // Catch:{ JSONException -> 0x022b }
            java.lang.String r0 = r0.toString()     // Catch:{ JSONException -> 0x022b }
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ JSONException -> 0x022b }
            if (r1 != 0) goto L_0x0140
            java.lang.String r1 = "dob"
            r15.put(r1, r0)     // Catch:{ JSONException -> 0x022b }
        L_0x0140:
            com.google.android.material.textfield.TextInputEditText r0 = r14.f16378e     // Catch:{ JSONException -> 0x022b }
            android.text.Editable r0 = r0.getText()     // Catch:{ JSONException -> 0x022b }
            java.lang.String r0 = r0.toString()     // Catch:{ JSONException -> 0x022b }
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ JSONException -> 0x022b }
            if (r1 != 0) goto L_0x0155
            java.lang.String r1 = "relationship"
            r15.put(r1, r0)     // Catch:{ JSONException -> 0x022b }
        L_0x0155:
            com.google.android.material.textfield.TextInputEditText r0 = r14.s     // Catch:{ JSONException -> 0x022b }
            android.text.Editable r0 = r0.getText()     // Catch:{ JSONException -> 0x022b }
            java.lang.String r0 = r0.toString()     // Catch:{ JSONException -> 0x022b }
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ JSONException -> 0x022b }
            if (r1 != 0) goto L_0x016a
            java.lang.String r1 = "houseNo"
            r15.put(r1, r0)     // Catch:{ JSONException -> 0x022b }
        L_0x016a:
            com.google.android.material.textfield.TextInputEditText r0 = r14.t     // Catch:{ JSONException -> 0x022b }
            android.text.Editable r0 = r0.getText()     // Catch:{ JSONException -> 0x022b }
            java.lang.String r0 = r0.toString()     // Catch:{ JSONException -> 0x022b }
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ JSONException -> 0x022b }
            if (r1 != 0) goto L_0x0180
            java.lang.String r1 = "streetName"
            r15.put(r1, r0)     // Catch:{ JSONException -> 0x022b }
        L_0x0180:
            com.google.android.material.textfield.TextInputEditText r0 = r14.u     // Catch:{ JSONException -> 0x022b }
            android.text.Editable r0 = r0.getText()     // Catch:{ JSONException -> 0x022b }
            java.lang.String r0 = r0.toString()     // Catch:{ JSONException -> 0x022b }
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ JSONException -> 0x022b }
            if (r1 != 0) goto L_0x0195
            java.lang.String r1 = "areaName"
            r15.put(r1, r0)     // Catch:{ JSONException -> 0x022b }
        L_0x0195:
            com.google.android.material.textfield.TextInputEditText r0 = r14.v     // Catch:{ JSONException -> 0x022b }
            android.text.Editable r0 = r0.getText()     // Catch:{ JSONException -> 0x022b }
            java.lang.String r0 = r0.toString()     // Catch:{ JSONException -> 0x022b }
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ JSONException -> 0x022b }
            if (r1 != 0) goto L_0x01aa
            java.lang.String r1 = "pinCode"
            r15.put(r1, r0)     // Catch:{ JSONException -> 0x022b }
        L_0x01aa:
            android.widget.AutoCompleteTextView r0 = r14.w     // Catch:{ JSONException -> 0x022b }
            android.text.Editable r0 = r0.getText()     // Catch:{ JSONException -> 0x022b }
            java.lang.String r0 = r0.toString()     // Catch:{ JSONException -> 0x022b }
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ JSONException -> 0x022b }
            if (r1 != 0) goto L_0x01bf
            java.lang.String r1 = "city"
            r15.put(r1, r0)     // Catch:{ JSONException -> 0x022b }
        L_0x01bf:
            com.google.android.material.textfield.TextInputEditText r0 = r14.x     // Catch:{ JSONException -> 0x022b }
            android.text.Editable r0 = r0.getText()     // Catch:{ JSONException -> 0x022b }
            java.lang.String r0 = r0.toString()     // Catch:{ JSONException -> 0x022b }
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ JSONException -> 0x022b }
            if (r1 != 0) goto L_0x01d5
            java.lang.String r1 = "state"
            r15.put(r1, r0)     // Catch:{ JSONException -> 0x022b }
        L_0x01d5:
            com.google.android.material.textfield.TextInputEditText r0 = r14.y     // Catch:{ JSONException -> 0x022b }
            android.text.Editable r0 = r0.getText()     // Catch:{ JSONException -> 0x022b }
            java.lang.String r0 = r0.toString()     // Catch:{ JSONException -> 0x022b }
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ JSONException -> 0x022b }
            if (r1 != 0) goto L_0x01ea
            java.lang.String r1 = "email"
            r15.put(r1, r0)     // Catch:{ JSONException -> 0x022b }
        L_0x01ea:
            java.util.HashMap r13 = new java.util.HashMap     // Catch:{ JSONException -> 0x022b }
            r13.<init>()     // Catch:{ JSONException -> 0x022b }
            java.lang.Class r0 = r14.getClass()     // Catch:{ JSONException -> 0x022b }
            java.lang.String r0 = r0.getSimpleName()     // Catch:{ JSONException -> 0x022b }
            r13.put(r3, r0)     // Catch:{ JSONException -> 0x022b }
            android.content.Context r0 = r14.f16377d     // Catch:{ JSONException -> 0x022b }
            boolean r0 = com.paytm.utility.b.c((android.content.Context) r0)     // Catch:{ JSONException -> 0x022b }
            if (r0 == 0) goto L_0x022a
            android.content.Context r0 = r14.f16377d     // Catch:{ JSONException -> 0x022b }
            int r1 = net.one97.paytm.bankOpen.R.string.pb_please_wait     // Catch:{ JSONException -> 0x022b }
            java.lang.String r1 = r14.getString(r1)     // Catch:{ JSONException -> 0x022b }
            r14.a(r0, r1)     // Catch:{ JSONException -> 0x022b }
            net.one97.paytm.bankCommon.g.c r0 = new net.one97.paytm.bankCommon.g.c     // Catch:{ JSONException -> 0x022b }
            r0.<init>()     // Catch:{ JSONException -> 0x022b }
            net.one97.paytm.bankCommon.g.b r0 = new net.one97.paytm.bankCommon.g.b     // Catch:{ JSONException -> 0x022b }
            net.one97.paytm.bankCommon.model.slfd.SlfdAddNomineeResponseModel r8 = new net.one97.paytm.bankCommon.model.slfd.SlfdAddNomineeResponseModel     // Catch:{ JSONException -> 0x022b }
            r8.<init>()     // Catch:{ JSONException -> 0x022b }
            java.lang.String r10 = r15.toString()     // Catch:{ JSONException -> 0x022b }
            com.paytm.network.a$c r11 = com.paytm.network.a.c.PAYMENTSBANK     // Catch:{ JSONException -> 0x022b }
            com.paytm.network.a$b r12 = com.paytm.network.a.b.USER_FACING     // Catch:{ JSONException -> 0x022b }
            r4 = r0
            r6 = r14
            r7 = r14
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13)     // Catch:{ JSONException -> 0x022b }
            net.one97.paytm.bankCommon.g.c.a(r0)     // Catch:{ JSONException -> 0x022b }
        L_0x022a:
            return
        L_0x022b:
            r15 = move-exception
            r15.printStackTrace()
            return
        L_0x0230:
            net.one97.paytm.bankCommon.model.NomineeModel r1 = r14.g()
            java.util.HashMap r7 = new java.util.HashMap
            r7.<init>()
            java.lang.Class r15 = r14.getClass()
            java.lang.String r15 = r15.getSimpleName()
            r7.put(r3, r15)
            net.one97.paytm.bankCommon.model.NomineeModel r15 = r14.E
            if (r15 == 0) goto L_0x025f
            java.lang.String r15 = r15.getNomineeId()
            r1.setNomineeId(r15)
            r14.F = r1
            android.content.Context r0 = r14.f16377d
            com.paytm.network.a$c r4 = com.paytm.network.a.c.PAYMENTSBANK
            com.paytm.network.a$b r5 = com.paytm.network.a.b.USER_FACING
            r2 = r14
            r3 = r14
            r6 = r7
            net.one97.paytm.bankCommon.g.f r15 = net.one97.paytm.bankOpen.a.a.a((android.content.Context) r0, (net.one97.paytm.bankCommon.model.NomineeModel) r1, (net.one97.paytm.bankCommon.g.g.b<com.paytm.network.model.IJRPaytmDataModel>) r2, (net.one97.paytm.bankCommon.g.g.a) r3, (com.paytm.network.a.c) r4, (com.paytm.network.a.b) r5, (java.util.HashMap<java.lang.String, java.lang.String>) r6)
            goto L_0x026d
        L_0x025f:
            android.content.Context r0 = r14.f16377d
            java.lang.String r2 = r14.C
            com.paytm.network.a$c r5 = com.paytm.network.a.c.PAYMENTSBANK
            com.paytm.network.a$b r6 = com.paytm.network.a.b.USER_FACING
            r3 = r14
            r4 = r14
            net.one97.paytm.bankCommon.g.f r15 = net.one97.paytm.bankOpen.a.a.a(r0, r1, r2, r3, r4, r5, r6, r7)
        L_0x026d:
            if (r15 == 0) goto L_0x0294
            android.content.Context r0 = r14.f16377d
            boolean r0 = com.paytm.utility.b.c((android.content.Context) r0)
            if (r0 == 0) goto L_0x0290
            android.content.Context r0 = r14.f16377d
            int r1 = net.one97.paytm.bankOpen.R.string.pb_please_wait
            java.lang.String r1 = r14.getString(r1)
            r14.a(r0, r1)
            android.content.Context r0 = r14.f16377d
            r0.getApplicationContext()
            net.one97.paytm.bankCommon.g.c r0 = new net.one97.paytm.bankCommon.g.c
            r0.<init>()
            net.one97.paytm.bankCommon.g.c.a(r15)
            return
        L_0x0290:
            r14.a((net.one97.paytm.bankCommon.g.f) r15)
            return
        L_0x0294:
            androidx.fragment.app.FragmentActivity r15 = r14.getActivity()
            int r0 = net.one97.paytm.bankOpen.R.string.error
            java.lang.String r0 = r14.getString(r0)
            int r1 = net.one97.paytm.bankOpen.R.string.pb_something_wrong_try_again
            java.lang.String r1 = r14.getString(r1)
            com.paytm.utility.b.b((android.content.Context) r15, (java.lang.String) r0, (java.lang.String) r1)
            return
        L_0x02a8:
            int r15 = r14.d()
            if (r15 != r1) goto L_0x02c4
            boolean r15 = r14.f()
            if (r15 == 0) goto L_0x02c4
            return
        L_0x02b5:
            int r0 = net.one97.paytm.bankOpen.R.id.add_nominee_edt_relationship
            if (r15 != r0) goto L_0x02bd
            r14.e()
            return
        L_0x02bd:
            int r0 = net.one97.paytm.bankOpen.R.id.add_nominee_edt_dob
            if (r15 != r0) goto L_0x02c4
            r14.l()
        L_0x02c4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.bankOpen.b.d.onClick(android.view.View):void");
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332 && getActivity() != null && (getActivity() instanceof e)) {
            ((e) getActivity()).a(1);
        }
        return super.onOptionsItemSelected(menuItem);
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

    public final boolean f() {
        Calendar calendar;
        c cVar;
        Calendar calendar2;
        j();
        String obj = this.f16382i.getText().toString();
        if (obj.equals("") || obj.length() < 3 || a(obj) || obj.matches(".*\\d+.*")) {
            if (obj.equals("")) {
                this.j.setError(this.f16377d.getString(R.string.please_enter_the_name));
            } else if (obj.length() < 3) {
                this.j.setError(this.f16377d.getString(R.string.min_3_characters_msg));
            } else if (a(obj)) {
                this.j.setError(this.f16377d.getString(R.string.special_characters_msg));
            } else if (obj.matches(".*\\d+.*")) {
                this.j.setError(this.f16377d.getString(R.string.numeric_character_msg));
            }
            a((View) this.j);
            return false;
        } else if (TextUtils.isEmpty(this.q.getText())) {
            this.k.setError(this.f16377d.getString(R.string.please_enter_the_dob));
            a((View) this.k);
            return false;
        } else if (!this.q.getText().toString().matches("^(((0[1-9]|[12]\\d|3[01])\\/(0[13578]|1[02])\\/((1[6-9]|[2-9]\\d)\\d{2}))|((0[1-9]|[12]\\d|30)\\/(0[13456789]|1[012])\\/((1[6-9]|[2-9]\\d)\\d{2}))|((0[1-9]|1\\d|2[0-8])\\/02\\/((1[6-9]|[2-9]\\d)\\d{2}))|(29\\/02\\/((1[6-9]|[2-9]\\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))))$")) {
            this.k.setError(this.f16377d.getString(R.string.please_enter_the_dob_in_correct_form));
            a((View) this.k);
            return false;
        } else {
            Calendar calendar3 = this.r;
            if (calendar3 != null && !calendar3.before(Calendar.getInstance())) {
                this.k.setError(this.f16377d.getString(R.string.please_provide_a_valid_date));
                a((View) this.k);
                return false;
            } else if (d() == 2 && (calendar2 = this.r) != null && a(calendar2)) {
                this.k.setError(this.f16377d.getString(R.string.age_18_years_required_msg));
                a((View) this.k);
                return false;
            } else if (this.f16378e.getText().toString().equals("")) {
                this.l.setError(this.f16377d.getString(R.string.please_specify_your_relationship_with_this_nominee));
                a((View) this.l);
                return false;
            } else if (this.s.getText().toString().equals("")) {
                this.m.setError(this.f16377d.getString(R.string.please_provide_valid_address_of_nominee));
                a((View) this.m);
                return false;
            } else if (this.s.getText().length() < 5) {
                this.m.setError(this.f16377d.getString(R.string.please_enter_minimum_5_characters));
                a((View) this.m);
                return false;
            } else if (!this.t.getText().toString().equals("") && this.t.getText().length() < 5) {
                this.n.setError(this.f16377d.getString(R.string.please_enter_minimum_5_characters));
                a((View) this.n);
                return false;
            } else if (!this.u.getText().toString().equals("") && this.u.getText().length() < 5) {
                this.D.setError(this.f16377d.getString(R.string.please_enter_minimum_5_characters));
                a((View) this.D);
                return false;
            } else if (this.v.getText().toString().equals("")) {
                this.v.setText("");
                this.o.setError(this.f16377d.getString(R.string.please_enter_pincode));
                this.o.setErrorEnabled(true);
                a((View) this.o);
                return false;
            } else if (this.y.getText().toString().length() != 0 && !Patterns.EMAIL_ADDRESS.matcher(this.y.getText().toString()).matches()) {
                this.p.setError(this.f16377d.getString(R.string.please_provide_a_valid_email));
                a((View) this.p);
                return false;
            } else if (this.x.getText().toString().equals("") || this.w.getText().toString().equals("")) {
                this.o.setError(this.f16377d.getString(R.string.please_enter_pincode));
                this.o.setErrorEnabled(true);
                a((View) this.o);
                return false;
            } else if (d() != 0 || (calendar = this.r) == null || !a(calendar) || (cVar = this.H) == null || cVar.f()) {
                return true;
            } else {
                a(this.H.I);
                return false;
            }
        }
    }

    /* access modifiers changed from: private */
    public void j() {
        this.j.setError((CharSequence) null);
        this.j.setErrorEnabled(false);
        this.k.setError((CharSequence) null);
        this.k.setErrorEnabled(false);
        this.l.setError((CharSequence) null);
        this.l.setErrorEnabled(false);
        this.m.setError((CharSequence) null);
        this.m.setErrorEnabled(false);
        this.n.setError((CharSequence) null);
        this.n.setErrorEnabled(false);
        this.D.setError((CharSequence) null);
        this.D.setErrorEnabled(false);
        this.o.setError((CharSequence) null);
        this.o.setErrorEnabled(false);
        this.p.setError((CharSequence) null);
        this.p.setErrorEnabled(false);
    }

    private static boolean a(String str) {
        return Pattern.compile("[$&+,:;=?@#|]").matcher(str).find();
    }

    public void onFocusChange(View view, boolean z2) {
        if (view == this.q && z2) {
            l();
        } else if (view == this.f16378e && z2) {
            e();
        }
    }

    public final NomineeModel g() {
        NomineeModel nomineeModel = new NomineeModel();
        nomineeModel.setEmail(this.y.getText().toString());
        nomineeModel.setState(this.x.getText().toString());
        nomineeModel.setCity(this.w.getText().toString());
        nomineeModel.setPinCode(this.v.getText().toString());
        nomineeModel.setStreetName(this.t.getText().toString());
        nomineeModel.setAreaName(this.u.getText().toString());
        nomineeModel.setHouseNo(this.s.getText().toString());
        nomineeModel.setRelationship(this.f16378e.getText().toString());
        nomineeModel.setDob(this.q.getText().toString());
        nomineeModel.setName(this.f16382i.getText().toString());
        Calendar calendar = this.r;
        if ((calendar == null || !a(calendar)) && this.G.getVisibility() != 0) {
            nomineeModel.setGuardians((ArrayList<NomineeModel>) null);
        } else if (this.H != null && d() == 0) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.H.g());
            nomineeModel.setGuardians(arrayList);
        }
        return nomineeModel;
    }

    /* access modifiers changed from: protected */
    public void h() {
        net.one97.paytm.bankOpen.d.b.a(getActivity(), (e) getActivity());
    }

    /* renamed from: a */
    public final void onResponse(IJRPaytmDataModel iJRPaytmDataModel) {
        if (isAdded()) {
            if (iJRPaytmDataModel instanceof PBUADPincode) {
                W_();
                PBUADPincode pBUADPincode = (PBUADPincode) iJRPaytmDataModel;
                if (pBUADPincode.getResponseCode() == null || !pBUADPincode.getResponseCode().equals("200")) {
                    this.o.setErrorEnabled(true);
                    this.o.setError(pBUADPincode.getResponseMessage());
                    return;
                }
                if (pBUADPincode.getPincodeList() != null && pBUADPincode.getPincodeList().size() > 0) {
                    this.w.setAdapter(new a(getActivity(), pBUADPincode.getCities()));
                    this.w.setOnClickListener(new View.OnClickListener() {
                        public final void onClick(View view) {
                            d.this.b(view);
                        }
                    });
                    this.w.setText(pBUADPincode.getPincodeList().get(0).getTier3Value());
                    this.x.setText(pBUADPincode.getPincodeList().get(0).getState());
                    c();
                }
                this.o.setError("");
                this.o.setErrorEnabled(false);
            } else if (iJRPaytmDataModel instanceof NomineeAdd) {
                W_();
                NomineeAdd nomineeAdd = (NomineeAdd) iJRPaytmDataModel;
                String nomineeId = nomineeAdd.getNomineeId();
                if (!TextUtils.isEmpty(nomineeAdd.getErrorMessage())) {
                    com.paytm.utility.b.b((Context) getActivity(), getString(R.string.error), nomineeAdd.getErrorMessage());
                } else if (!TextUtils.isEmpty(nomineeId)) {
                    net.one97.paytm.bankCommon.h.b.d((Context) getActivity(), "Y");
                    if (getActivity() != null) {
                        getActivity().setResult(-1);
                        getActivity().finish();
                    }
                }
            } else if (iJRPaytmDataModel instanceof BankAccOpen) {
                W_();
                BankAccOpen bankAccOpen = (BankAccOpen) iJRPaytmDataModel;
                if (!TextUtils.isEmpty(bankAccOpen.getErrorMessage())) {
                    com.paytm.utility.b.b((Context) getActivity(), getString(R.string.error), bankAccOpen.getErrorMessage());
                } else if (!TextUtils.isEmpty(bankAccOpen.getMessage()) && bankAccOpen.getMessage().equalsIgnoreCase("PRODUCT_INITIATED")) {
                    net.one97.paytm.bankCommon.h.b.k(getActivity());
                    net.one97.paytm.bankCommon.h.b.d((Context) getActivity(), "Y");
                    if (getActivity() != null && (getActivity() instanceof e)) {
                        h();
                    }
                }
            } else if (iJRPaytmDataModel instanceof SlfdAddNomineeResponseModel) {
                W_();
                SlfdAddNomineeResponseModel slfdAddNomineeResponseModel = (SlfdAddNomineeResponseModel) iJRPaytmDataModel;
                if (TextUtils.isEmpty(slfdAddNomineeResponseModel.getNomineeId())) {
                    Context context = this.f16377d;
                    Toast.makeText(context, "Error - " + slfdAddNomineeResponseModel.getMessage(), 0).show();
                } else if (getActivity() != null) {
                    getActivity().setResult(-1);
                    getActivity().finish();
                }
            } else if (iJRPaytmDataModel instanceof NomineeUpdateResponse) {
                W_();
                NomineeUpdateResponse nomineeUpdateResponse = (NomineeUpdateResponse) iJRPaytmDataModel;
                if (nomineeUpdateResponse == null) {
                    return;
                }
                if (nomineeUpdateResponse.isSuccess()) {
                    com.paytm.utility.b.a((Context) getActivity(), TextUtils.isEmpty(nomineeUpdateResponse.getResponse()) ? getString(R.string.pb_nominee_updated_msg) : nomineeUpdateResponse.getResponse());
                    Intent intent = new Intent();
                    intent.putExtra("NOMINEE_ITEM", this.F);
                    getActivity().setResult(-1, intent);
                    getActivity().finish();
                } else if (!TextUtils.isEmpty(nomineeUpdateResponse.getErrorMessage())) {
                    com.paytm.utility.b.b((Context) getActivity(), getString(R.string.error), nomineeUpdateResponse.getErrorMessage());
                } else {
                    com.paytm.utility.b.b((Context) getActivity(), getString(R.string.error), getString(R.string.pb_something_wrong_try_again));
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        this.w.showDropDown();
    }

    /* access modifiers changed from: protected */
    public void i() {
        if (getActivity() != null) {
            getActivity().finish();
        }
    }

    public void e() {
        net.one97.paytm.bankCommon.c.a aVar = new net.one97.paytm.bankCommon.c.a(this.f16377d, getResources().getStringArray(R.array.payment_bank_relationship), this.f16379f);
        aVar.f16219a = new a.C0221a(aVar) {
            private final /* synthetic */ a f$1;

            {
                this.f$1 = r2;
            }

            public final void onItemSelected(int i2) {
                d.this.a(this.f$1, i2);
            }
        };
        aVar.a();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(net.one97.paytm.bankCommon.c.a aVar, int i2) {
        aVar.b();
        this.f16379f = i2;
        this.f16378e.setText(this.f16375b[this.f16379f]);
    }

    public final void a(int i2, int i3, int i4) {
        this.r = Calendar.getInstance();
        this.r.set(5, i2);
        this.r.set(2, i3 - 1);
        this.r.set(1, i4);
        TextInputEditText textInputEditText = this.q;
        textInputEditText.setText(String.format("%02d", new Object[]{Integer.valueOf(i2)}) + "/" + String.format("%02d", new Object[]{Integer.valueOf(i3)}) + "/" + i4);
        if (d() != 2) {
            if (!this.r.before(Calendar.getInstance()) || !a(this.r)) {
                this.G.setVisibility(8);
            } else {
                k();
            }
        }
    }

    private static boolean a(Calendar calendar) {
        Calendar instance = Calendar.getInstance();
        instance.add(1, -18);
        return instance.before(calendar);
    }

    private void k() {
        this.G.setVisibility(0);
        if (this.H == null) {
            NomineeModel nomineeModel = null;
            NomineeModel nomineeModel2 = this.E;
            if (!(nomineeModel2 == null || nomineeModel2.getGuardians() == null || this.E.getGuardians().size() <= 0)) {
                nomineeModel = this.E.getGuardians().get(0);
            }
            c.a aVar = c.f16371b;
            this.H = c.a.a(nomineeModel);
        }
        if (getChildFragmentManager().c(R.id.fragment_container) == null) {
            getChildFragmentManager().a().a(R.id.fragment_container, (Fragment) this.H).b();
        }
    }

    public void onPause() {
        c();
        super.onPause();
    }

    private void l() {
        net.one97.paytm.common.widgets.d dVar;
        if (TextUtils.isEmpty(this.q.getText())) {
            dVar = net.one97.paytm.common.widgets.d.a();
        } else {
            String[] split = this.q.getText().toString().split("/");
            if (split.length < 3) {
                dVar = net.one97.paytm.common.widgets.d.a();
            } else {
                int parseInt = Integer.parseInt(split[2]);
                dVar = net.one97.paytm.common.widgets.d.a(Integer.parseInt(split[0]), Integer.parseInt(split[1]), parseInt);
            }
        }
        dVar.show(getActivity().getFragmentManager(), "DatePicker");
        dVar.f49892f = this;
    }

    public void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        W_();
        if (networkCustomError != null) {
            if (!TextUtils.isEmpty(networkCustomError.getUrl()) && networkCustomError.getUrl().contains(AddEditGstinViewModelKt.BODY_PARAM_PINCODE)) {
                this.v.setText("");
                if (!TextUtils.isEmpty(networkCustomError.getAlertMessage())) {
                    this.o.setError(networkCustomError.getAlertMessage());
                    this.o.setErrorEnabled(true);
                    a((View) this.o);
                }
            }
            f.a((Context) getActivity(), networkCustomError, i2);
        }
    }

    public class a<T> extends ArrayAdapter<T> {

        /* renamed from: a  reason: collision with root package name */
        public T[] f16386a;

        /* renamed from: c  reason: collision with root package name */
        private Filter f16388c = new C0230a(this, (byte) 0);

        /* JADX WARNING: type inference failed for: r3v0, types: [int, T[], java.lang.Object[]] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public a(android.content.Context r2, int r3) {
            /*
                r0 = this;
                net.one97.paytm.bankOpen.b.d.this = r1
                r1 = 17367043(0x1090003, float:2.5162934E-38)
                r0.<init>(r2, r1, r3)
                net.one97.paytm.bankOpen.b.d$a$a r1 = new net.one97.paytm.bankOpen.b.d$a$a
                r2 = 0
                r1.<init>(r0, r2)
                r0.f16388c = r1
                r0.f16386a = r3
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.bankOpen.b.d.a.<init>(net.one97.paytm.bankOpen.b.d, android.content.Context, java.lang.Object[]):void");
        }

        public final Filter getFilter() {
            return this.f16388c;
        }

        /* renamed from: net.one97.paytm.bankOpen.b.d$a$a  reason: collision with other inner class name */
        class C0230a extends Filter {
            private C0230a() {
            }

            /* synthetic */ C0230a(a aVar, byte b2) {
                this();
            }

            /* access modifiers changed from: protected */
            public final Filter.FilterResults performFiltering(CharSequence charSequence) {
                Filter.FilterResults filterResults = new Filter.FilterResults();
                filterResults.values = a.this.f16386a;
                filterResults.count = a.this.f16386a.length;
                return filterResults;
            }

            /* access modifiers changed from: protected */
            public final void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
                a.this.notifyDataSetChanged();
            }
        }
    }

    private void a(View view) {
        this.I = view;
        this.z.a(((View) view.getParent().getParent()).getTop() + view.getTop(), false);
        Point point = new Point();
        a(this.z, view.getParent(), view, point);
        this.z.a(point.y, false);
    }

    static /* synthetic */ void a(d dVar, String str) {
        String str2;
        dVar.getActivity();
        net.one97.paytm.bankCommon.mapping.g.a();
        String e2 = com.paytm.utility.b.e((Context) dVar.getActivity(), net.one97.paytm.bankCommon.utils.d.a("uadPincode"));
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        hashMap.put("session_token", net.one97.paytm.bankOpen.f.a().getUserToken(dVar.getActivity()));
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
        hashMap2.put("screen_name", dVar.getClass().getSimpleName());
        net.one97.paytm.bankCommon.g.b bVar = new net.one97.paytm.bankCommon.g.b(e2, (g.b<IJRPaytmDataModel>) dVar, (g.a) dVar, (IJRPaytmDataModel) pBUADPincode, (Map<String, String>) null, (Map<String, String>) hashMap, str2, a.C0715a.POST, a.c.PAYMENTSBANK, a.b.SILENT, (HashMap<String, String>) hashMap2);
        if (com.paytm.utility.b.c((Context) dVar.getActivity())) {
            Context context = dVar.f16377d;
            dVar.a(context, context.getString(R.string.pb_please_wait));
            dVar.getActivity().getApplicationContext();
            new net.one97.paytm.bankCommon.g.c();
            net.one97.paytm.bankCommon.g.c.a(bVar);
            return;
        }
        dVar.a((net.one97.paytm.bankCommon.g.f) bVar);
    }
}
