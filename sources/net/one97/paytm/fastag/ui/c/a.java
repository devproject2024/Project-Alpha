package net.one97.paytm.fastag.ui.c;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.webkit.URLUtil;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.b;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.e;
import com.google.android.gms.location.f;
import com.paytm.business.merchantprofile.viewmodel.AddEditGstinViewModelKt;
import com.paytm.contactsSdk.constant.ContactsConstant;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.s;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import net.one97.paytm.common.widgets.CustomCheckBox;
import net.one97.paytm.common.widgets.CustomSwitch;
import net.one97.paytm.fastag.R;
import net.one97.paytm.fastag.b.c;
import net.one97.paytm.fastag.dependencies.j;
import net.one97.paytm.fastag.f.h;
import net.one97.paytm.fastag.model.CJRAddress;
import net.one97.paytm.fastag.model.CJRPincode;
import net.one97.paytm.upi.util.UpiUtils;
import org.json.JSONObject;

public class a extends Fragment implements View.OnClickListener, e.b, e.c {

    /* renamed from: b  reason: collision with root package name */
    static final /* synthetic */ boolean f13860b = (!a.class.desiredAssertionStatus());
    private double A;
    private double B;
    private String C = null;
    private boolean D;
    private RadioButton E;
    private RadioButton F;

    /* renamed from: a  reason: collision with root package name */
    c f13861a;

    /* renamed from: c  reason: collision with root package name */
    private Context f13862c;

    /* renamed from: d  reason: collision with root package name */
    private EditText f13863d;

    /* renamed from: e  reason: collision with root package name */
    private EditText f13864e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public EditText f13865f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public EditText f13866g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public EditText f13867h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public AutoCompleteTextView f13868i;
    private EditText j;
    private boolean k;
    private CJRAddress l;
    private TextView m;
    private LinearLayout n;
    /* access modifiers changed from: private */
    public j o;
    private LinearLayout p;
    private TextView q;
    private int r;
    private LinearLayout s;
    private RelativeLayout t;
    private CustomCheckBox u;
    private CustomSwitch v;
    private TextView w;
    private Button x;
    /* access modifiers changed from: private */
    public String y = "+91";
    private e z;

    public void onConnected(Bundle bundle) {
    }

    public void onConnectionFailed(ConnectionResult connectionResult) {
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        this.f13862c = context;
        if (context instanceof j) {
            this.o = (j) context;
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String l2;
        View inflate = layoutInflater.inflate(R.layout.fastag_add_new_address, viewGroup, false);
        if (h.O((Context) getActivity()) && h.P((Context) getActivity())) {
            try {
                if (getActivity() != null) {
                    this.z = new e.a(getActivity()).a((e.b) this).a((e.c) this).a((com.google.android.gms.common.api.a<? extends a.d.C0127d>) f.f11372a).a();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (getActivity() != null) {
            getActivity().getWindow().setSoftInputMode(16);
        }
        this.f13861a = new c(this.f13862c);
        this.p = (LinearLayout) inflate.findViewById(R.id.animation_layout);
        Bundle arguments = getArguments();
        if (arguments != null) {
            arguments.getBoolean("no address");
            this.k = arguments.getBoolean("edit address");
            if (this.k) {
                this.l = (CJRAddress) arguments.getSerializable("address to update");
            }
            if (arguments.containsKey(net.one97.paytm.fastag.f.f.G)) {
                this.D = arguments.getBoolean(net.one97.paytm.fastag.f.f.G);
            }
        }
        this.f13863d = (EditText) inflate.findViewById(R.id.name);
        this.f13864e = (EditText) inflate.findViewById(R.id.address);
        this.f13865f = (EditText) inflate.findViewById(R.id.address2);
        this.f13866g = (EditText) inflate.findViewById(R.id.zip);
        this.f13867h = (EditText) inflate.findViewById(R.id.city);
        this.q = (TextView) inflate.findViewById(R.id.error_text);
        this.s = (LinearLayout) inflate.findViewById(R.id.error_layout);
        this.s.setOnClickListener(this);
        ((ImageView) inflate.findViewById(R.id.error_message_image)).setOnClickListener(this);
        this.m = (TextView) inflate.findViewById(R.id.add_new_address_tittle);
        this.f13868i = (AutoCompleteTextView) inflate.findViewById(R.id.state);
        this.j = (EditText) inflate.findViewById(R.id.phone);
        this.w = (TextView) inflate.findViewById(R.id.delete_text);
        this.w.setOnClickListener(this);
        this.w.setEnabled(true);
        this.n = (LinearLayout) inflate.findViewById(R.id.delete_layout);
        if (getActivity() != null) {
            getActivity();
            h.a(this.f13863d);
            getActivity();
            h.a(this.f13864e);
            getActivity();
            h.a(this.f13865f);
            getActivity();
            h.a(this.f13866g);
            getActivity();
            h.a(this.f13867h);
            getActivity();
            h.a(this.q);
            getActivity();
            h.a(this.j);
            getActivity();
            h.a(this.j);
        }
        this.t = (RelativeLayout) inflate.findViewById(R.id.switch_button_layout);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.add_current_location_container);
        ((RadioGroup) inflate.findViewById(R.id.radio_group_address_type)).setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public final void onCheckedChanged(RadioGroup radioGroup, int i2) {
                a.this.a(radioGroup, i2);
            }
        });
        String str = "";
        if (h.d() > 11) {
            if (getActivity() != null) {
                this.v = new CustomSwitch(getActivity());
                this.t.addView(this.v);
                this.v.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                        a.this.a(compoundButton, z);
                    }
                });
            }
        } else if (getActivity() != null) {
            this.u = new CustomCheckBox(getActivity());
            this.u.setTextSize(0.0f);
            this.u.setText(str);
            this.t.addView(this.u);
            this.u.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    a.this.a(compoundButton, z);
                }
            });
        }
        this.f13866g.addTextChangedListener(new TextWatcher() {
            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                if (charSequence.length() == 6) {
                    a.this.a();
                    a.a(a.this, charSequence.toString());
                }
            }

            public final void afterTextChanged(Editable editable) {
                if (a.this.f13866g.getText().toString().isEmpty()) {
                    a.this.f13868i.setEnabled(true);
                    a.this.f13867h.setEnabled(true);
                }
            }
        });
        if (getActivity() != null) {
            this.f13868i.setAdapter(new ArrayAdapter(getActivity(), 17367048, net.one97.paytm.fastag.f.f.f13784d));
        }
        if (!(getActivity() == null || (l2 = h.l((Context) getActivity())) == null)) {
            if (!l2.contains("+91")) {
                this.j.setText(String.format("+91%s", new Object[]{l2}));
            } else {
                this.j.setText(l2);
            }
        }
        this.E = (RadioButton) inflate.findViewById(R.id.radio_office);
        this.F = (RadioButton) inflate.findViewById(R.id.radio_home);
        this.F.setChecked(true);
        String h2 = h.h((Context) getActivity());
        String i2 = h.i((Context) getActivity());
        if (h2 != null) {
            str = str + h2;
        }
        if (i2 != null) {
            str = str + " " + i2;
        }
        if (str.trim().length() > 0) {
            this.f13863d.setText(str);
        }
        this.x = (Button) inflate.findViewById(R.id.save_address);
        TextView textView = (TextView) inflate.findViewById(R.id.cancel_address);
        this.x.setOnClickListener(this);
        textView.setOnClickListener(this);
        linearLayout.setOnClickListener(this);
        ((ImageView) inflate.findViewById(R.id.back_iv)).setOnClickListener(this);
        if (getActivity() != null) {
            this.f13863d.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                public final void onFocusChange(View view, boolean z) {
                    a.this.g(view, z);
                }
            });
            this.f13864e.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                public final void onFocusChange(View view, boolean z) {
                    a.this.f(view, z);
                }
            });
            this.f13865f.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                public final void onFocusChange(View view, boolean z) {
                    a.this.e(view, z);
                }
            });
            this.f13866g.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                public final void onFocusChange(View view, boolean z) {
                    a.this.d(view, z);
                }
            });
            this.f13868i.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                public final void onFocusChange(View view, boolean z) {
                    a.this.c(view, z);
                }
            });
            this.f13867h.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                public final void onFocusChange(View view, boolean z) {
                    a.this.b(view, z);
                }
            });
            this.j.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                public final void onFocusChange(View view, boolean z) {
                    a.this.a(view, z);
                }
            });
            this.j.addTextChangedListener(new TextWatcher() {
                public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                }

                public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                }

                public final void afterTextChanged(Editable editable) {
                    if (editable.toString().length() == 1 && !editable.toString().equals("+")) {
                        editable.insert(0, a.this.y);
                    }
                    if (editable.toString().length() < a.this.y.length()) {
                        editable.clear();
                    }
                }
            });
        }
        if (this.D) {
            this.x.setBackground(getResources().getDrawable(R.drawable.fastag_button_mall_tomato_new));
            textView.setTextColor(getResources().getColor(R.color.paytm_blue));
            this.w.setTextColor(getResources().getColor(R.color.paytm_blue));
            if (Build.VERSION.SDK_INT < 21) {
                androidx.core.widget.c.a((CompoundButton) this.F, this.f13862c.getResources().getColorStateList(R.color.nearby_radio_button_color_state_list_fastag));
                androidx.core.widget.c.a((CompoundButton) this.E, this.f13862c.getResources().getColorStateList(R.color.nearby_radio_button_color_state_list_fastag));
            } else {
                this.F.setButtonTintList(this.f13862c.getResources().getColorStateList(R.color.nearby_radio_button_color_state_list_fastag));
                this.E.setButtonTintList(this.f13862c.getResources().getColorStateList(R.color.nearby_radio_button_color_state_list_fastag));
            }
        }
        if (getActivity() != null) {
            this.p.startAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.fade_in_fastag));
        }
        if (this.k) {
            if (getActivity() != null) {
                this.m.setText(getActivity().getString(R.string.edit_address_text));
            }
            this.n.setVisibility(0);
            CJRAddress cJRAddress = this.l;
            if (cJRAddress != null) {
                this.f13863d.setText(cJRAddress.getName());
                this.f13864e.setText(this.l.getAddress1());
                this.f13865f.setText(this.l.getAddress2());
                this.f13866g.setText(this.l.getPin());
                this.f13868i.setText(this.l.getState());
                if (this.l.getMobile() != null) {
                    if (!this.l.getMobile().contains("+91")) {
                        this.j.setText(String.format("+91%s", new Object[]{this.l.getMobile()}));
                    } else {
                        this.j.setText(this.l.getMobile());
                    }
                }
                if (!TextUtils.isEmpty(this.l.getTitle())) {
                    if (this.l.getTitle().toLowerCase().contains("office")) {
                        this.E.setChecked(true);
                        this.E.setTextColor(b.c(this.f13862c, R.color.color_222222));
                    } else {
                        this.F.setChecked(true);
                        this.F.setTextColor(b.c(this.f13862c, R.color.color_222222));
                    }
                }
                if (this.l.getPriority() == 1) {
                    CustomCheckBox customCheckBox = this.u;
                    if (customCheckBox != null) {
                        customCheckBox.setChecked(true);
                    } else {
                        this.v.setChecked(true);
                    }
                } else {
                    CustomCheckBox customCheckBox2 = this.u;
                    if (customCheckBox2 != null) {
                        customCheckBox2.setChecked(false);
                    } else {
                        this.v.setChecked(false);
                    }
                }
            }
        } else {
            String j2 = h.j((Context) getActivity());
            if (!TextUtils.isEmpty(j2)) {
                this.f13863d.setText(j2);
            }
            String l3 = h.l((Context) getActivity());
            if (!TextUtils.isEmpty(l3)) {
                if (!l3.contains("+91")) {
                    this.j.setText(String.format("+91%s", new Object[]{l3}));
                } else {
                    this.j.setText(l3);
                }
            }
        }
        getActivity();
        return inflate;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(RadioGroup radioGroup, int i2) {
        if (i2 == R.id.radio_home) {
            this.F.setTextColor(b.c(this.f13862c, R.color.color_222222));
            this.E.setTextColor(b.c(this.f13862c, R.color.color_999999));
        } else if (i2 == R.id.radio_office) {
            this.E.setTextColor(b.c(this.f13862c, R.color.color_222222));
            this.F.setTextColor(b.c(this.f13862c, R.color.color_999999));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void g(View view, boolean z2) {
        FragmentActivity activity;
        if (!z2 && (activity = getActivity()) != null && !activity.isFinishing()) {
            net.one97.paytm.fastag.c.a.a().f13559b.sendCustomEventScreenWithMap("dlvry_name_entered", "/delivery-address/add-new", "NAME", this.f13863d.getText().toString(), activity);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void f(View view, boolean z2) {
        FragmentActivity activity;
        if (!z2 && (activity = getActivity()) != null && !activity.isFinishing()) {
            net.one97.paytm.fastag.c.a.a().f13559b.sendCustomEventScreenWithMap("dlvry_address1_entered", "/delivery-address/add-new", "ADDRESS1", this.f13864e.getText().toString(), activity);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e(View view, boolean z2) {
        FragmentActivity activity;
        if (!z2 && (activity = getActivity()) != null && !activity.isFinishing()) {
            net.one97.paytm.fastag.c.a.a().f13559b.sendCustomEventScreenWithMap("dlvry_address2_entered", "/delivery-address/add-new", "ADDRESS2", this.f13865f.getText().toString(), activity);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d(View view, boolean z2) {
        FragmentActivity activity;
        if (!z2 && (activity = getActivity()) != null && !activity.isFinishing()) {
            net.one97.paytm.fastag.c.a.a().f13559b.sendCustomEventScreenWithMap("dlvry_pin_code_entered", "/delivery-address/add-new", "PINCODE", this.f13866g.getText().toString(), activity);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(View view, boolean z2) {
        FragmentActivity activity;
        if (!z2 && (activity = getActivity()) != null && !activity.isFinishing()) {
            net.one97.paytm.fastag.c.a.a().f13559b.sendCustomEventScreenWithMap("dlvry_state_entered", "/delivery-address/add-new", "PINCODE", this.f13868i.getText().toString(), activity);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view, boolean z2) {
        FragmentActivity activity;
        if (!z2 && (activity = getActivity()) != null && !activity.isFinishing()) {
            net.one97.paytm.fastag.c.a.a().f13559b.sendCustomEventScreenWithMap("dlvry_field_entered", "/delivery-address/add-new", "PINCODE", this.f13867h.getText().toString(), activity);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view, boolean z2) {
        if (!z2) {
            FragmentActivity activity = getActivity();
            if (activity != null && !activity.isFinishing()) {
                net.one97.paytm.fastag.c.a.a().f13559b.sendCustomEventScreenWithMap("dlvry_phone_entered", "/delivery-address/add-new", "PINCODE", this.j.getText().toString(), activity);
            }
            if (this.j.getText().length() == this.y.length()) {
                this.j.setText("");
            }
        } else if (TextUtils.isEmpty(this.j.getText())) {
            this.j.setText(this.y);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(CompoundButton compoundButton, boolean z2) {
        if (z2) {
            this.r = 1;
        } else {
            this.r = 0;
        }
    }

    public final void a(boolean z2) {
        this.x.setEnabled(z2);
    }

    public final void a(String str) {
        LinearLayout linearLayout = this.s;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
            this.q.setText(str);
        }
    }

    public final void a() {
        LinearLayout linearLayout = this.s;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.save_address) {
            CJRAddress cJRAddress = new CJRAddress();
            cJRAddress.setName(this.f13863d.getText().toString());
            cJRAddress.setAddress1(this.f13864e.getText().toString());
            cJRAddress.setAddress2(this.f13865f.getText().toString());
            cJRAddress.setCity(this.f13867h.getText().toString());
            cJRAddress.setState(this.f13868i.getText().toString());
            cJRAddress.setPin(this.f13866g.getText().toString());
            cJRAddress.setMobile(this.j.getText().toString());
            cJRAddress.setPriority(this.r);
            if (this.E.isChecked()) {
                cJRAddress.setTitle("Office");
            } else if (this.F.isChecked()) {
                cJRAddress.setTitle("Home");
            }
            c();
            String name = cJRAddress.getName();
            String address1 = cJRAddress.getAddress1();
            String address2 = cJRAddress.getAddress2();
            String str = "title";
            String city = cJRAddress.getCity();
            String str2 = "priority";
            String state = cJRAddress.getState();
            String str3 = "mobile";
            String pin = cJRAddress.getPin();
            String str4 = "pin";
            String mobile = cJRAddress.getMobile();
            String str5 = "state";
            int priority = cJRAddress.getPriority();
            String title = cJRAddress.getTitle();
            String str6 = "city";
            Resources resources = getResources();
            if (name.trim().length() <= 0) {
                a(resources.getString(R.string.msg_invalid_name));
                resources.getString(R.string.msg_invalid_name);
            } else {
                String str7 = "address2";
                String str8 = "address1";
                if (mobile.trim().length() != 10 && mobile.trim().length() != 13 && mobile.trim().length() != 14) {
                    a(resources.getString(R.string.msg_invalid_mobile));
                    resources.getString(R.string.msg_invalid_mobile);
                } else if (pin.length() != 6) {
                    a(resources.getString(R.string.msg_invalid_pin));
                    resources.getString(R.string.msg_invalid_pin);
                } else if (address1.trim().length() <= 0) {
                    a(resources.getString(R.string.msg_invalid_address_1));
                    resources.getString(R.string.msg_invalid_address_1);
                } else if (address2.trim().length() < 2) {
                    a(resources.getString(R.string.msg_invalid_address_2));
                    resources.getString(R.string.msg_invalid_address_2);
                } else if (city.trim().length() <= 0) {
                    a(resources.getString(R.string.msg_invalid_city));
                    resources.getString(R.string.msg_invalid_city);
                } else if (state.trim().length() <= 0) {
                    a(resources.getString(R.string.msg_invalid_state));
                    resources.getString(R.string.msg_invalid_state);
                } else {
                    final CJRAddress cJRAddress2 = this.k ? this.l : new CJRAddress();
                    cJRAddress2.setName(name);
                    cJRAddress2.setAddress1(address1);
                    cJRAddress2.setAddress2(address2);
                    cJRAddress2.setCity(city);
                    cJRAddress2.setState(state);
                    cJRAddress2.setPin(pin);
                    cJRAddress2.setMobile(mobile);
                    cJRAddress2.setPriority(priority);
                    cJRAddress2.setTitle(title);
                    if (this.k) {
                        cJRAddress2.setId(this.l.getId());
                        if (getActivity() != null) {
                            final String str9 = net.one97.paytm.fastag.c.a.a().f13559b.getString("addressesV2") + com.paytm.utility.c.a((Context) getActivity(), false);
                            if (URLUtil.isValidUrl(str9)) {
                                Map<String, String> v2 = h.v();
                                JSONObject jSONObject = new JSONObject();
                                try {
                                    jSONObject.put("id", cJRAddress2.getId());
                                    jSONObject.put("name", cJRAddress2.getName());
                                    jSONObject.put(str8, cJRAddress2.getAddress1());
                                    jSONObject.put(str7, cJRAddress2.getAddress2());
                                    jSONObject.put(str6, cJRAddress2.getCity());
                                    jSONObject.put(str5, cJRAddress2.getState());
                                    jSONObject.put(str4, cJRAddress2.getPin());
                                    jSONObject.put(str3, cJRAddress2.getMobile());
                                    jSONObject.put(str2, cJRAddress2.getPriority());
                                    jSONObject.put(str, cJRAddress2.getTitle());
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                }
                                if (h.c((Context) getActivity())) {
                                    this.f13861a.c(new net.one97.paytm.fastag.b.b() {
                                        public final void a(Throwable th) {
                                            a.a(a.this, th, str9);
                                        }

                                        public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
                                            if (iJRPaytmDataModel != null && (iJRPaytmDataModel instanceof CJRAddress)) {
                                                CJRAddress cJRAddress = (CJRAddress) iJRPaytmDataModel;
                                                if (!TextUtils.isEmpty(cJRAddress.getERROR())) {
                                                    a.this.a(cJRAddress.getERROR());
                                                    new StringBuilder("visibleErrorLayout : address.getError() : ").append(cJRAddress2.getERROR());
                                                } else if (!TextUtils.isEmpty(cJRAddress2.getStatus()) && cJRAddress2.getStatus().equalsIgnoreCase("Failure")) {
                                                    a.this.a(cJRAddress2.getMessage());
                                                    new StringBuilder("visibleErrorLayout : address.getMessage() : ").append(cJRAddress2.getMessage());
                                                } else if (a.this.getActivity() != null) {
                                                    a.this.o.a(cJRAddress2);
                                                }
                                            }
                                        }
                                    }, str9, v2, jSONObject);
                                } else {
                                    a(getActivity().getString(R.string.no_internet));
                                }
                            } else {
                                a(getString(R.string.msg_invalid_url));
                            }
                        }
                    } else {
                        String str10 = str;
                        String str11 = str2;
                        String str12 = str3;
                        String str13 = str4;
                        String str14 = str5;
                        String str15 = str6;
                        String str16 = str8;
                        String str17 = str7;
                        if (getActivity() != null) {
                            final String str18 = net.one97.paytm.fastag.c.a.a().f13559b.getString("addressesV2") + com.paytm.utility.c.a((Context) getActivity(), false);
                            Map<String, String> v3 = h.v();
                            JSONObject jSONObject2 = new JSONObject();
                            if (URLUtil.isValidUrl(str18)) {
                                try {
                                    jSONObject2.put("name", cJRAddress2.getName());
                                    jSONObject2.put(str16, cJRAddress2.getAddress1());
                                    jSONObject2.put(str17, cJRAddress2.getAddress2());
                                    jSONObject2.put(str15, cJRAddress2.getCity());
                                    jSONObject2.put(str14, cJRAddress2.getState());
                                    jSONObject2.put(str13, cJRAddress2.getPin());
                                    jSONObject2.put(str12, cJRAddress2.getMobile());
                                    jSONObject2.put(str11, cJRAddress2.getPriority());
                                    jSONObject2.put(str10, cJRAddress2.getTitle());
                                } catch (Exception e3) {
                                    e3.printStackTrace();
                                }
                                if (h.c((Context) getActivity())) {
                                    this.f13861a.a(new net.one97.paytm.fastag.b.b() {
                                        public final void a(Throwable th) {
                                            a.a(a.this, th, str18);
                                        }

                                        public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
                                            if (iJRPaytmDataModel != null && (iJRPaytmDataModel instanceof CJRAddress)) {
                                                CJRAddress cJRAddress = (CJRAddress) iJRPaytmDataModel;
                                                if (!TextUtils.isEmpty(cJRAddress.getERROR())) {
                                                    a.this.a(cJRAddress.getERROR());
                                                    new StringBuilder(" visibleErrorLayout(address.getError()) : ").append(cJRAddress.getERROR());
                                                } else if (!TextUtils.isEmpty(cJRAddress2.getStatus()) && cJRAddress2.getStatus().equalsIgnoreCase("Failure")) {
                                                    a.this.a(cJRAddress2.getMessage());
                                                    new StringBuilder(" visibleErrorLayout(address.getMessage()) : ").append(cJRAddress2.getMessage());
                                                } else if (a.this.getActivity() != null) {
                                                    a.this.o.c(cJRAddress2);
                                                }
                                            }
                                        }
                                    }, str18, v3, jSONObject2);
                                } else {
                                    a(getActivity().getString(R.string.no_internet));
                                }
                            } else {
                                a(getString(R.string.msg_invalid_url));
                            }
                        }
                    }
                }
            }
            net.one97.paytm.fastag.c.a.a().f13559b.sendCustomEventsWithScreenName("deliver_to_this_address_clicked", "/delivery-address/add-new", getActivity());
            return;
        }
        String str19 = "priority";
        String str20 = "title";
        String str21 = "mobile";
        String str22 = "address1";
        String str23 = "pin";
        String str24 = "address2";
        String str25 = "state";
        String str26 = "city";
        if (id == R.id.delete_text) {
            CJRAddress cJRAddress3 = this.l;
            if (getActivity() != null) {
                String string = net.one97.paytm.fastag.c.a.a().f13559b.getString("addressesV2");
                if (!URLUtil.isValidUrl(string)) {
                    a(getString(R.string.msg_invalid_url));
                } else {
                    final String str27 = string + com.paytm.utility.c.a((Context) getActivity(), false);
                    Map<String, String> v4 = h.v();
                    JSONObject jSONObject3 = new JSONObject();
                    try {
                        jSONObject3.put("id", cJRAddress3.getId());
                        jSONObject3.put("name", cJRAddress3.getName());
                        if (!TextUtils.isEmpty(cJRAddress3.getAddress1())) {
                            jSONObject3.put(str22, cJRAddress3.getAddress1());
                        }
                        if (!TextUtils.isEmpty(cJRAddress3.getAddress2())) {
                            jSONObject3.put(str24, cJRAddress3.getAddress2());
                        }
                        jSONObject3.put(str26, cJRAddress3.getCity());
                        jSONObject3.put(str25, cJRAddress3.getState());
                        jSONObject3.put(str23, cJRAddress3.getPin());
                        jSONObject3.put(str21, cJRAddress3.getMobile());
                        jSONObject3.put(str20, cJRAddress3.getTitle());
                        jSONObject3.put(str19, cJRAddress3.getPriority());
                        jSONObject3.put("isDeleted", true);
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                    if (h.c((Context) getActivity())) {
                        this.f13861a.b(new net.one97.paytm.fastag.b.b() {
                            public final void a(Throwable th) {
                                a.a(a.this, th, str27);
                            }

                            public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
                                if (iJRPaytmDataModel != null && (iJRPaytmDataModel instanceof CJRAddress)) {
                                    CJRAddress cJRAddress = (CJRAddress) iJRPaytmDataModel;
                                    if (cJRAddress != null && cJRAddress.getStatus() != null && cJRAddress.getStatus().equals("Failure")) {
                                        a.this.a(cJRAddress.getMessage());
                                        a.this.w.setEnabled(true);
                                    } else if (a.this.o != null) {
                                        a.this.o.b(cJRAddress);
                                    }
                                }
                            }
                        }, str27, v4, jSONObject3);
                    } else {
                        a(getString(R.string.no_internet));
                    }
                }
            }
            this.w.setEnabled(false);
            return;
        }
        boolean z2 = true;
        if (id == R.id.error_message_image) {
            a();
        } else if (id == R.id.cancel_address || id == R.id.back_iv) {
            c();
            this.o.a();
        } else if (id == R.id.add_current_location_container) {
            try {
                if (!b()) {
                    if (!s.a() || s.e((Context) getActivity())) {
                        z2 = false;
                    } else {
                        s.d((Activity) getActivity());
                    }
                    if (!(z2 || this.z == null || getContext() == null)) {
                        if (androidx.core.app.a.a(getContext(), "android.permission.ACCESS_FINE_LOCATION") == 0 || androidx.core.app.a.a(getContext(), "android.permission.ACCESS_COARSE_LOCATION") == 0) {
                            Location a2 = f.f11373b.a(this.z);
                            if (a2 != null) {
                                this.A = a2.getLatitude();
                                this.B = a2.getLongitude();
                                final double d2 = this.A;
                                final double d3 = this.B;
                                final FragmentActivity activity = getActivity();
                                final C0190a aVar = new C0190a(this, (byte) 0);
                                new Thread() {
                                    public final void run() {
                                        String str;
                                        Address address;
                                        try {
                                            List<Address> fromLocation = new Geocoder(activity, Locale.getDefault()).getFromLocation(d2, d3, 1);
                                            if (fromLocation == null || fromLocation.size() <= 0) {
                                                address = null;
                                                str = null;
                                            } else {
                                                address = fromLocation.get(0);
                                                str = address.getLocality() + address.getPostalCode();
                                            }
                                            Message obtain = Message.obtain();
                                            obtain.setTarget(aVar);
                                            if (str != null) {
                                                obtain.what = 1;
                                                Bundle bundle = new Bundle();
                                                bundle.putParcelable(AddEditGstinViewModelKt.BODY_PARAM_ADDRESS, address);
                                                obtain.setData(bundle);
                                            } else {
                                                obtain.what = 1;
                                                obtain.setData((Bundle) null);
                                            }
                                            obtain.sendToTarget();
                                        } catch (IOException e2) {
                                            e2.printStackTrace();
                                            Message obtain2 = Message.obtain();
                                            obtain2.setTarget(aVar);
                                            obtain2.what = 1;
                                            obtain2.setData((Bundle) null);
                                            obtain2.sendToTarget();
                                        } catch (Throwable th) {
                                            Message obtain3 = Message.obtain();
                                            obtain3.setTarget(aVar);
                                            obtain3.what = 1;
                                            obtain3.setData((Bundle) null);
                                            obtain3.sendToTarget();
                                            throw th;
                                        }
                                    }
                                }.start();
                            }
                        }
                    }
                }
            } catch (Exception e5) {
                e5.printStackTrace();
            }
            Toast.makeText(getActivity(), "Updating current location", 0).show();
        }
    }

    public void onStart() {
        super.onStart();
        try {
            if (this.z != null && !this.z.f()) {
                this.z.d();
            }
            net.one97.paytm.fastag.c.a.a().f13559b.handlePlayServicesError();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void onStop() {
        super.onStop();
        try {
            if (this.z != null && this.z.f()) {
                this.z.e();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private boolean b() {
        boolean z2;
        boolean z3;
        try {
            if (getActivity() != null) {
                LocationManager locationManager = (LocationManager) getActivity().getSystemService("location");
                try {
                    if (!f13860b) {
                        if (locationManager == null) {
                            throw new AssertionError();
                        }
                    }
                    z2 = locationManager.isProviderEnabled("gps");
                } catch (Exception unused) {
                    z2 = false;
                }
                try {
                    z3 = locationManager.isProviderEnabled(ContactsConstant.NETWORK);
                } catch (Exception unused2) {
                    z3 = false;
                }
                if (!z2 && !z3) {
                    try {
                        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                        builder.setMessage(getResources().getString(R.string.gps_turned_off_alert_msg));
                        builder.setPositiveButton(getResources().getString(R.string.open_location_settings), new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                a.this.startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
                            }
                        });
                        builder.setNegativeButton(getString(R.string.cancel), new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i2) {
                            }
                        });
                        builder.show();
                        return true;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        return true;
                    }
                }
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        return false;
    }

    public void onConnectionSuspended(int i2) {
        try {
            if (this.z != null) {
                this.z.d();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void c() {
        if (getActivity() != null) {
            FragmentActivity activity = getActivity();
            getActivity();
            InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
            View currentFocus = getActivity().getCurrentFocus();
            if (currentFocus == null) {
                EditText editText = this.f13863d;
                if (editText != null) {
                    editText.requestFocus();
                }
                currentFocus = getActivity().getCurrentFocus();
            }
            if (currentFocus != null && inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 2);
            }
        }
    }

    /* renamed from: net.one97.paytm.fastag.ui.c.a$a  reason: collision with other inner class name */
    class C0190a extends Handler {
        /* synthetic */ C0190a(a aVar, byte b2) {
            this();
        }

        private C0190a() {
        }

        public final void handleMessage(Message message) {
            Address address;
            try {
                if (message.what != 1) {
                    address = null;
                } else {
                    address = (Address) message.getData().getParcelable(AddEditGstinViewModelKt.BODY_PARAM_ADDRESS);
                    new StringBuilder("rishi").append(address);
                }
                if (address != null) {
                    a.this.f13865f.setText(address.getAddressLine(1));
                    a.this.f13868i.setText(address.getAdminArea());
                    String addressLine = address.getAddressLine(2);
                    if (!TextUtils.isEmpty(addressLine)) {
                        try {
                            a.this.f13866g.setText(addressLine.substring(addressLine.length() - 6, addressLine.length()));
                        } catch (ArrayIndexOutOfBoundsException e2) {
                            e2.printStackTrace();
                        }
                    } else {
                        String postalCode = address.getPostalCode();
                        if (!TextUtils.isEmpty(postalCode)) {
                            a.this.f13866g.setText(postalCode);
                        }
                    }
                    String locality = address.getLocality();
                    if (!TextUtils.isEmpty(locality)) {
                        a.this.f13867h.setText(locality);
                        a.this.f13867h.setEnabled(false);
                    }
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    static /* synthetic */ void a(a aVar, String str) {
        if (aVar.getActivity() != null) {
            final String b2 = com.paytm.utility.c.b(net.one97.paytm.fastag.c.a.a().f13559b.getString("getLocation") + "/" + str, (Context) aVar.getActivity());
            if (!URLUtil.isValidUrl(b2)) {
                aVar.a(aVar.getString(R.string.msg_invalid_url));
            } else if (h.c((Context) aVar.getActivity())) {
                aVar.f13861a.b(new net.one97.paytm.fastag.b.b() {
                    public final void a(Throwable th) {
                        a.a(a.this, th, b2);
                    }

                    public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
                        if (iJRPaytmDataModel != null && (iJRPaytmDataModel instanceof CJRPincode)) {
                            CJRPincode cJRPincode = (CJRPincode) iJRPaytmDataModel;
                            a.this.a(true);
                            a.this.f13868i.setText(cJRPincode.getState());
                            a.this.f13867h.setText(cJRPincode.getCity());
                            if (!a.this.f13866g.getText().toString().isEmpty()) {
                                a.this.f13867h.setEnabled(false);
                                a.this.f13868i.setEnabled(false);
                            }
                        }
                    }
                }, b2);
            } else {
                aVar.a(aVar.getActivity().getString(R.string.no_internet));
            }
        }
    }

    static /* synthetic */ void a(a aVar, Throwable th, String str) {
        String str2;
        if (th != null) {
            NetworkCustomError networkCustomError = (NetworkCustomError) th;
            String valueOf = String.valueOf(networkCustomError.getStatusCode());
            if (!TextUtils.isEmpty(valueOf) && valueOf.equalsIgnoreCase("PI_FT_4001")) {
                aVar.a(false);
            }
            if (TextUtils.isEmpty(networkCustomError.getMessage()) || (!networkCustomError.getMessage().equalsIgnoreCase("410") && !networkCustomError.getMessage().equalsIgnoreCase(UpiUtils.AUTHENTICATION_FAILURE_401))) {
                if (networkCustomError.getMessage() != null && networkCustomError.getMessage().equalsIgnoreCase("parsing_error")) {
                    String string = aVar.getResources().getString(R.string.message_error_data_display);
                    if (str != null) {
                        string = string + "(" + str + ")";
                    }
                    aVar.a(string);
                } else if (!TextUtils.isEmpty(networkCustomError.getMessage()) && networkCustomError.getMessage().equalsIgnoreCase("406")) {
                    aVar.a(networkCustomError.getMessage());
                    new StringBuilder(" visibleErrorLayout : error.getMessage() : ").append(networkCustomError.getMessage());
                } else if (networkCustomError.getMessage() != null && networkCustomError.getMessage().equalsIgnoreCase("failure_error")) {
                    aVar.a(networkCustomError.getMessage());
                    new StringBuilder(" visibleErrorLayout : error.getAlertMessage() : ").append(networkCustomError.getMessage());
                } else if (aVar.getActivity() != null) {
                    if (!TextUtils.isEmpty(networkCustomError.getMessage())) {
                        str2 = networkCustomError.getMessage();
                    } else {
                        str2 = aVar.getResources().getString(R.string.network_error_message) + " " + str;
                    }
                    aVar.a(str2);
                }
            } else if (aVar.getActivity() != null) {
                FragmentActivity activity = aVar.getActivity();
                a.class.getName();
                h.a(activity, networkCustomError, str);
            }
        }
    }
}
