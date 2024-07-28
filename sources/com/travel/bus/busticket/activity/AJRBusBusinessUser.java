package com.travel.bus.busticket.activity;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.URLUtil;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.network.a;
import com.paytm.utility.RoboTextView;
import com.paytm.utility.a;
import com.paytm.utility.b;
import com.paytm.utility.q;
import com.paytm.utility.v;
import com.travel.bus.R;
import com.travel.bus.busticket.a.i;
import com.travel.bus.busticket.i.x;
import com.travel.bus.model.PincodeResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.common.widgets.CJRFloatingLabel;

public class AJRBusBusinessUser extends PaytmActivity implements View.OnClickListener, x.a {
    /* access modifiers changed from: private */
    public TextView A;
    /* access modifiers changed from: private */
    public TextView B;
    private Button C;
    /* access modifiers changed from: private */
    public boolean D = false;
    private boolean E = false;
    /* access modifiers changed from: private */
    public Dialog F = null;
    private String G = "";
    private String H = "";
    private String I = "";
    private String J = "";
    private String K = "";
    private String L = "";
    private String M = "";
    private String N = "";
    private View.OnClickListener O = new View.OnClickListener() {
        public final void onClick(View view) {
            int id = view.getId();
            if (id == R.id.gst_number_clear) {
                if (AJRBusBusinessUser.this.l != null) {
                    AJRBusBusinessUser.this.l.setText((CharSequence) "");
                    AJRBusBusinessUser.this.w.setVisibility(8);
                }
            } else if (id == R.id.gst_company_clear) {
                if (AJRBusBusinessUser.this.m != null) {
                    AJRBusBusinessUser.this.m.setText((CharSequence) "");
                    AJRBusBusinessUser.this.x.setVisibility(8);
                }
            } else if (id == R.id.gst_email_clear) {
                if (AJRBusBusinessUser.this.n != null) {
                    AJRBusBusinessUser.this.n.setText((CharSequence) "");
                    AJRBusBusinessUser.this.y.setVisibility(8);
                }
            } else if (id == R.id.gst_flat_clear) {
                if (AJRBusBusinessUser.this.o != null) {
                    AJRBusBusinessUser.this.o.setText((CharSequence) "");
                    AJRBusBusinessUser.this.z.setVisibility(8);
                }
            } else if (id == R.id.gst_street_clear) {
                if (AJRBusBusinessUser.this.p != null) {
                    AJRBusBusinessUser.this.p.setText((CharSequence) "");
                    AJRBusBusinessUser.this.A.setVisibility(8);
                }
            } else if (id == R.id.gst_pincode_clear && AJRBusBusinessUser.this.q != null) {
                AJRBusBusinessUser.this.q.setText((CharSequence) "");
                AJRBusBusinessUser.this.B.setVisibility(8);
            }
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public ProgressDialog f21817a;

    /* renamed from: b  reason: collision with root package name */
    private List<PincodeResponse.Cities> f21818b = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public ImageView f21819c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public ImageView f21820d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public ImageView f21821e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public ImageView f21822f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public ImageView f21823g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public ImageView f21824h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public RelativeLayout f21825i;
    /* access modifiers changed from: private */
    public CJRFloatingLabel j;
    private LinearLayout k;
    /* access modifiers changed from: private */
    public CJRFloatingLabel l;
    /* access modifiers changed from: private */
    public CJRFloatingLabel m;
    /* access modifiers changed from: private */
    public CJRFloatingLabel n;
    /* access modifiers changed from: private */
    public CJRFloatingLabel o;
    /* access modifiers changed from: private */
    public CJRFloatingLabel p;
    /* access modifiers changed from: private */
    public CJRFloatingLabel q;
    /* access modifiers changed from: private */
    public CJRFloatingLabel r;
    /* access modifiers changed from: private */
    public RoboTextView s;
    /* access modifiers changed from: private */
    public RelativeLayout t;
    /* access modifiers changed from: private */
    public RelativeLayout u;
    /* access modifiers changed from: private */
    public Spinner v;
    /* access modifiers changed from: private */
    public TextView w;
    /* access modifiers changed from: private */
    public TextView x;
    /* access modifiers changed from: private */
    public TextView y;
    /* access modifiers changed from: private */
    public TextView z;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_ajrbus_business_user_new);
        setSupportActionBar((Toolbar) findViewById(R.id.bus_business_user_toolbar));
        getSupportActionBar().c(false);
        TextView textView = (TextView) findViewById(R.id.bus_toolbar_reset_text);
        ((TextView) findViewById(R.id.bus_toolbar_title)).setText(getResources().getString(R.string.business_user_details));
        textView.setVisibility(0);
        ((ImageView) findViewById(R.id.bus_toolbar_back_arrow)).setOnClickListener(this);
        textView.setOnClickListener(this);
        this.k = (LinearLayout) findViewById(R.id.gst_container_lyt);
        this.l = (CJRFloatingLabel) findViewById(R.id.gstin_edit_text);
        this.l.setHintText(getResources().getString(R.string.bus_enter_gstin_hint_text));
        this.f21819c = (ImageView) findViewById(R.id.gst_number_clear);
        this.f21819c.setOnClickListener(this.O);
        this.m = (CJRFloatingLabel) findViewById(R.id.gst_name_edit_text);
        this.m.setHintText(getResources().getString(R.string.bus_enter_name_hint_text));
        this.f21820d = (ImageView) findViewById(R.id.gst_company_clear);
        this.f21820d.setOnClickListener(this.O);
        this.n = (CJRFloatingLabel) findViewById(R.id.email_edit_text);
        this.n.setHintText(getResources().getString(R.string.bus_enter_email_hint_text));
        this.f21822f = (ImageView) findViewById(R.id.gst_email_clear);
        this.f21822f.setOnClickListener(this.O);
        this.f21821e = (ImageView) findViewById(R.id.gst_flat_clear);
        this.f21821e.setOnClickListener(this.O);
        this.f21823g = (ImageView) findViewById(R.id.gst_street_clear);
        this.f21823g.setOnClickListener(this.O);
        this.f21824h = (ImageView) findViewById(R.id.gst_pincode_clear);
        this.f21824h.setOnClickListener(this.O);
        this.o = (CJRFloatingLabel) findViewById(R.id.flat_edit_text);
        this.o.setHintText(getResources().getString(R.string.bus_enter_flat_hint_text));
        this.p = (CJRFloatingLabel) findViewById(R.id.street_edit_text);
        this.p.setHintText(getResources().getString(R.string.bus_enter_street_hint_text));
        this.q = (CJRFloatingLabel) findViewById(R.id.pincode_edit_text);
        this.q.setHintText(getResources().getString(R.string.bus_enter_pincode_hint_text));
        this.t = (RelativeLayout) findViewById(R.id.state_container);
        this.r = (CJRFloatingLabel) findViewById(R.id.state_edit_text);
        this.r.setHintText(getResources().getString(R.string.bus_state_hint_text));
        this.f21825i = (RelativeLayout) findViewById(R.id.city_con);
        this.j = (CJRFloatingLabel) findViewById(R.id.city_edit);
        this.j.setHintText("City/Town");
        this.u = (RelativeLayout) findViewById(R.id.city_container);
        this.s = (RoboTextView) findViewById(R.id.city_label_view);
        this.v = (Spinner) findViewById(R.id.city_town);
        this.C = (Button) findViewById(R.id.save_button);
        this.C.setOnClickListener(this);
        this.u.setVisibility(8);
        this.t.setVisibility(8);
        this.f21825i.setVisibility(8);
        this.w = (TextView) findViewById(R.id.gstin_error);
        this.x = (TextView) findViewById(R.id.gst_name_error);
        this.y = (TextView) findViewById(R.id.email_error);
        this.z = (TextView) findViewById(R.id.flat_error);
        this.A = (TextView) findViewById(R.id.street_error);
        this.B = (TextView) findViewById(R.id.pincode_error);
        b();
        a(getResources().getString(R.string.city), this.v);
        this.v.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public final void onNothingSelected(AdapterView<?> adapterView) {
            }

            public final void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j) {
                if (!AJRBusBusinessUser.this.D || AJRBusBusinessUser.this.s == null || AJRBusBusinessUser.this.s.getVisibility() != 8) {
                    boolean unused = AJRBusBusinessUser.this.D = true;
                } else {
                    AJRBusBusinessUser.this.u.setVisibility(0);
                    AJRBusBusinessUser.this.s.setVisibility(0);
                }
                AJRBusBusinessUser.this.j.setFocusable(false);
                AJRBusBusinessUser.this.j.setEdittextEditable(false);
                if (AJRBusBusinessUser.this.v.getSelectedItem() != null) {
                    AJRBusBusinessUser.this.j.setText((CharSequence) AJRBusBusinessUser.this.v.getSelectedItem().toString());
                }
            }
        });
        this.l.f49690a = new CJRFloatingLabel.c() {
            public final void a(CharSequence charSequence) {
                if (charSequence.length() > 0) {
                    AJRBusBusinessUser.this.f21819c.setVisibility(0);
                    AJRBusBusinessUser.this.w.setVisibility(8);
                } else {
                    AJRBusBusinessUser.this.f21819c.setVisibility(8);
                }
                int i2 = (charSequence == null || charSequence.length() == 0) ? R.string.bus_enter_gstin_hint_text : R.string.bus_gstin_hint_text;
                if (AJRBusBusinessUser.this.l != null) {
                    AJRBusBusinessUser.this.l.setHintText(i2);
                }
            }
        };
        this.m.f49690a = new CJRFloatingLabel.c() {
            public final void a(CharSequence charSequence) {
                if (charSequence.length() > 0) {
                    AJRBusBusinessUser.this.f21820d.setVisibility(0);
                    AJRBusBusinessUser.this.x.setVisibility(8);
                } else {
                    AJRBusBusinessUser.this.f21820d.setVisibility(8);
                }
                int i2 = (charSequence == null || charSequence.length() == 0) ? R.string.bus_enter_name_hint_text : R.string.bus_name_hint_text;
                if (AJRBusBusinessUser.this.m != null) {
                    AJRBusBusinessUser.this.m.setHintText(i2);
                }
            }
        };
        this.n.f49690a = new CJRFloatingLabel.c() {
            public final void a(CharSequence charSequence) {
                if (charSequence.length() > 0) {
                    AJRBusBusinessUser.this.f21822f.setVisibility(0);
                    AJRBusBusinessUser.this.y.setVisibility(8);
                } else {
                    AJRBusBusinessUser.this.f21822f.setVisibility(8);
                }
                int i2 = (charSequence == null || charSequence.length() == 0) ? R.string.bus_enter_email_hint_text : R.string.bus_email_hint_text;
                if (AJRBusBusinessUser.this.n != null) {
                    AJRBusBusinessUser.this.n.setHintText(i2);
                }
            }
        };
        this.o.f49690a = new CJRFloatingLabel.c() {
            public final void a(CharSequence charSequence) {
                if (charSequence.length() > 0) {
                    AJRBusBusinessUser.this.f21821e.setVisibility(0);
                    AJRBusBusinessUser.this.z.setVisibility(8);
                } else {
                    AJRBusBusinessUser.this.f21821e.setVisibility(8);
                }
                int i2 = (charSequence == null || charSequence.length() == 0) ? R.string.bus_enter_flat_hint_text : R.string.bus_flat_hint_text;
                if (AJRBusBusinessUser.this.o != null) {
                    AJRBusBusinessUser.this.o.setHintText(i2);
                }
            }
        };
        this.p.f49690a = new CJRFloatingLabel.c() {
            public final void a(CharSequence charSequence) {
                if (charSequence.length() > 0) {
                    AJRBusBusinessUser.this.f21823g.setVisibility(0);
                    AJRBusBusinessUser.this.A.setVisibility(8);
                } else {
                    AJRBusBusinessUser.this.f21823g.setVisibility(8);
                }
                int i2 = (charSequence == null || charSequence.length() == 0) ? R.string.bus_enter_street_hint_text : R.string.bus_street_hint_text;
                if (AJRBusBusinessUser.this.p != null) {
                    AJRBusBusinessUser.this.p.setHintText(i2);
                }
            }
        };
        this.q.f49690a = new CJRFloatingLabel.c() {
            public final void a(CharSequence charSequence) {
                int i2 = (charSequence == null || charSequence.length() == 0) ? R.string.bus_enter_pincode_hint_text : R.string.bus_pincode_hint_text;
                if (AJRBusBusinessUser.this.q != null) {
                    AJRBusBusinessUser.this.q.setHintText(i2);
                }
                if (charSequence.length() > 0) {
                    AJRBusBusinessUser.this.f21824h.setVisibility(0);
                    AJRBusBusinessUser.this.B.setVisibility(8);
                } else {
                    AJRBusBusinessUser.this.f21824h.setVisibility(8);
                }
                if (!TextUtils.isEmpty(charSequence)) {
                    String charSequence2 = charSequence.toString();
                    if (charSequence2 == null || charSequence2.length() != 6) {
                        AJRBusBusinessUser.this.t.setVisibility(8);
                        AJRBusBusinessUser.this.f21825i.setVisibility(8);
                        AJRBusBusinessUser.this.j.setText((CharSequence) "");
                        AJRBusBusinessUser.this.r.setText((CharSequence) "");
                        AJRBusBusinessUser.this.u.setVisibility(8);
                        AJRBusBusinessUser aJRBusBusinessUser = AJRBusBusinessUser.this;
                        aJRBusBusinessUser.a(aJRBusBusinessUser.getResources().getString(R.string.city), AJRBusBusinessUser.this.v);
                        return;
                    }
                    AJRBusBusinessUser aJRBusBusinessUser2 = AJRBusBusinessUser.this;
                    String string = aJRBusBusinessUser2.getResources().getString(R.string.please_wait_progress_msg);
                    if (!aJRBusBusinessUser2.isFinishing()) {
                        if (aJRBusBusinessUser2.f21817a == null || !aJRBusBusinessUser2.f21817a.isShowing()) {
                            aJRBusBusinessUser2.f21817a = new ProgressDialog(aJRBusBusinessUser2);
                            try {
                                aJRBusBusinessUser2.f21817a.setProgressStyle(0);
                                aJRBusBusinessUser2.f21817a.setMessage(string);
                                aJRBusBusinessUser2.f21817a.setCancelable(true);
                                aJRBusBusinessUser2.f21817a.setCanceledOnTouchOutside(false);
                                aJRBusBusinessUser2.f21817a.show();
                            } catch (IllegalArgumentException e2) {
                                q.c(e2.getMessage());
                            } catch (Exception e3) {
                                q.c(e3.getMessage());
                            }
                        } else {
                            aJRBusBusinessUser2.f21817a.setMessage(string);
                        }
                    }
                    AJRBusBusinessUser aJRBusBusinessUser3 = AJRBusBusinessUser.this;
                    x xVar = new x(aJRBusBusinessUser3, aJRBusBusinessUser3);
                    AJRBusBusinessUser.b((Activity) AJRBusBusinessUser.this);
                    String concat = "https://travel.paytm.com/api/trains/v1/user/address?pin=".concat(String.valueOf(charSequence2));
                    HashMap hashMap = new HashMap();
                    hashMap.put(AppConstants.SSO_TOKEN, a.q(x.f22478a));
                    if (URLUtil.isValidUrl(concat)) {
                        String s = b.s(x.f22478a, concat);
                        Context context = x.f22478a;
                        if (s != null && URLUtil.isValidUrl(s)) {
                            if (b.m(context) != null) {
                                s = v.a(s, com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.AND_SIGN, "user_email", "=", b.m(context));
                            }
                            if (b.l(context) != null) {
                                s = v.a(s, com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.AND_SIGN, "user_mobile", "=", b.l(context));
                            }
                        }
                        com.paytm.network.b bVar = new com.paytm.network.b();
                        bVar.f42877a = x.f22478a;
                        bVar.f42878b = a.c.BUS;
                        bVar.n = a.b.SILENT;
                        bVar.o = "traveller_business_user";
                        bVar.f42879c = a.C0715a.GET;
                        bVar.f42880d = s;
                        bVar.f42882f = hashMap;
                        bVar.f42885i = new PincodeResponse();
                        bVar.j = xVar;
                        com.paytm.network.a l = bVar.l();
                        l.f42859c = false;
                        if (b.c(x.f22478a)) {
                            l.a();
                        } else {
                            xVar.a(l);
                        }
                    } else {
                        Context context2 = x.f22478a;
                        b.b(context2, context2.getString(R.string.error), x.f22478a.getString(R.string.msg_invalid_url_bus));
                    }
                } else {
                    AJRBusBusinessUser.this.t.setVisibility(8);
                    AJRBusBusinessUser.this.r.setText((CharSequence) "");
                    AJRBusBusinessUser.this.f21825i.setVisibility(8);
                    AJRBusBusinessUser.this.j.setText((CharSequence) "");
                    AJRBusBusinessUser.this.u.setVisibility(8);
                    AJRBusBusinessUser aJRBusBusinessUser4 = AJRBusBusinessUser.this;
                    aJRBusBusinessUser4.a(aJRBusBusinessUser4.getResources().getString(R.string.city), AJRBusBusinessUser.this.v);
                }
            }
        };
        if (getIntent() != null) {
            this.G = getIntent().getStringExtra("BUSINESS_GST");
            this.H = getIntent().getStringExtra("BUSINESS_COMPANY");
            this.N = getIntent().getStringExtra("BUSINESS_EMAIL");
            this.I = getIntent().getStringExtra("BUSINESS_FLAT");
            this.J = getIntent().getStringExtra("BUSINESS_STREET");
            this.K = getIntent().getStringExtra("BUSINESS_PIN");
            this.L = getIntent().getStringExtra("BUSINESS_STATE");
            this.M = getIntent().getStringExtra("BUSINESS_CITY");
            this.l.setText((CharSequence) this.G);
            this.m.setText((CharSequence) this.H);
            this.n.setText((CharSequence) this.N);
            this.o.setText((CharSequence) this.I);
            this.p.setText((CharSequence) this.J);
            this.q.setText((CharSequence) this.K);
            this.r.setText((CharSequence) this.L);
        }
    }

    private void b() {
        this.w.setVisibility(8);
        this.x.setVisibility(8);
        this.y.setVisibility(8);
        this.z.setVisibility(8);
        this.A.setVisibility(8);
        this.B.setVisibility(8);
    }

    public final void a(String str, Spinner spinner) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        spinner.setAdapter(new ArrayAdapter(this, R.layout.pre_b_bus_spinner_item, arrayList));
        spinner.setEnabled(false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x011c  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x014f  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0203  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x024a  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0278  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a() {
        /*
            r6 = this;
            net.one97.paytm.common.widgets.CJRFloatingLabel r0 = r6.l
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0088
            java.lang.CharSequence r0 = r0.getText()
            if (r0 == 0) goto L_0x0088
            net.one97.paytm.common.widgets.CJRFloatingLabel r0 = r6.l
            java.lang.CharSequence r0 = r0.getText()
            java.lang.String r0 = r0.toString()
            java.lang.String r0 = r0.trim()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0088
            net.one97.paytm.common.widgets.CJRFloatingLabel r0 = r6.l
            android.widget.EditText r0 = r0.getEditText()
            android.text.Editable r0 = r0.getText()
            java.lang.String r0 = r0.toString()
            java.lang.String r0 = r0.trim()
            java.lang.String r3 = "^([0][1-9]|[1-2][0-9]|[3][0-7])([a-zA-Z]{5}[0-9]{4}[a-zA-Z]{1}[1-9a-zA-Z]{1}[zZ]{1}[0-9a-zA-Z]{1})+$"
            java.util.regex.Pattern r3 = java.util.regex.Pattern.compile(r3)
            java.util.regex.Matcher r0 = r3.matcher(r0)
            net.one97.paytm.common.widgets.CJRFloatingLabel r3 = r6.l
            java.lang.CharSequence r3 = r3.getText()
            int r3 = r3.length()
            if (r3 <= 0) goto L_0x006b
            net.one97.paytm.common.widgets.CJRFloatingLabel r3 = r6.l
            java.lang.CharSequence r3 = r3.getText()
            int r3 = r3.length()
            r4 = 15
            if (r3 == r4) goto L_0x006b
            android.widget.TextView r0 = r6.w
            android.content.res.Resources r3 = r6.getResources()
            int r4 = com.travel.bus.R.string.gst_15_digit_error
            java.lang.String r3 = r3.getString(r4)
            r0.setText(r3)
            android.widget.TextView r0 = r6.w
            r0.setVisibility(r2)
            goto L_0x009c
        L_0x006b:
            boolean r0 = r0.matches()
            if (r0 != 0) goto L_0x0086
            android.widget.TextView r0 = r6.w
            android.content.res.Resources r3 = r6.getResources()
            int r4 = com.travel.bus.R.string.gst_invalid
            java.lang.String r3 = r3.getString(r4)
            r0.setText(r3)
            android.widget.TextView r0 = r6.w
            r0.setVisibility(r2)
            goto L_0x009c
        L_0x0086:
            r0 = 1
            goto L_0x009d
        L_0x0088:
            android.widget.TextView r0 = r6.w
            android.content.res.Resources r3 = r6.getResources()
            int r4 = com.travel.bus.R.string.field_mandatory_error
            java.lang.String r3 = r3.getString(r4)
            r0.setText(r3)
            android.widget.TextView r0 = r6.w
            r0.setVisibility(r2)
        L_0x009c:
            r0 = 0
        L_0x009d:
            net.one97.paytm.common.widgets.CJRFloatingLabel r3 = r6.m
            r4 = 5
            if (r3 == 0) goto L_0x00e9
            java.lang.CharSequence r3 = r3.getText()
            if (r3 == 0) goto L_0x00e9
            net.one97.paytm.common.widgets.CJRFloatingLabel r3 = r6.m
            java.lang.CharSequence r3 = r3.getText()
            java.lang.String r3 = r3.toString()
            java.lang.String r3 = r3.trim()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x00e9
            net.one97.paytm.common.widgets.CJRFloatingLabel r3 = r6.m
            android.widget.EditText r3 = r3.getEditText()
            android.text.Editable r3 = r3.getText()
            java.lang.String r3 = r3.toString()
            java.lang.String r3 = r3.trim()
            int r3 = r3.length()
            if (r3 >= r4) goto L_0x00fe
            android.widget.TextView r0 = r6.x
            android.content.res.Resources r3 = r6.getResources()
            int r5 = com.travel.bus.R.string.name_invalid
            java.lang.String r3 = r3.getString(r5)
            r0.setText(r3)
            android.widget.TextView r0 = r6.x
            r0.setVisibility(r2)
            goto L_0x00fd
        L_0x00e9:
            android.widget.TextView r0 = r6.x
            android.content.res.Resources r3 = r6.getResources()
            int r5 = com.travel.bus.R.string.field_mandatory_error
            java.lang.String r3 = r3.getString(r5)
            r0.setText(r3)
            android.widget.TextView r0 = r6.x
            r0.setVisibility(r2)
        L_0x00fd:
            r0 = 0
        L_0x00fe:
            net.one97.paytm.common.widgets.CJRFloatingLabel r3 = r6.n
            if (r3 == 0) goto L_0x014f
            java.lang.CharSequence r3 = r3.getText()
            if (r3 == 0) goto L_0x014f
            net.one97.paytm.common.widgets.CJRFloatingLabel r3 = r6.n
            java.lang.CharSequence r3 = r3.getText()
            java.lang.String r3 = r3.toString()
            java.lang.String r3 = r3.trim()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x014f
            net.one97.paytm.common.widgets.CJRFloatingLabel r3 = r6.n
            android.widget.EditText r3 = r3.getEditText()
            android.text.Editable r3 = r3.getText()
            java.lang.String r3 = r3.toString()
            java.lang.String r3 = r3.trim()
            java.util.regex.Pattern r5 = android.util.Patterns.EMAIL_ADDRESS
            java.util.regex.Matcher r3 = r5.matcher(r3)
            boolean r3 = r3.matches()
            if (r3 != 0) goto L_0x0164
            android.widget.TextView r0 = r6.y
            android.content.res.Resources r3 = r6.getResources()
            int r5 = com.travel.bus.R.string.email_invalid
            java.lang.String r3 = r3.getString(r5)
            r0.setText(r3)
            android.widget.TextView r0 = r6.y
            r0.setVisibility(r2)
            goto L_0x0163
        L_0x014f:
            android.widget.TextView r0 = r6.y
            android.content.res.Resources r3 = r6.getResources()
            int r5 = com.travel.bus.R.string.field_mandatory_error
            java.lang.String r3 = r3.getString(r5)
            r0.setText(r3)
            android.widget.TextView r0 = r6.y
            r0.setVisibility(r2)
        L_0x0163:
            r0 = 0
        L_0x0164:
            net.one97.paytm.common.widgets.CJRFloatingLabel r3 = r6.o
            if (r3 == 0) goto L_0x0182
            java.lang.CharSequence r3 = r3.getText()
            if (r3 == 0) goto L_0x0182
            net.one97.paytm.common.widgets.CJRFloatingLabel r3 = r6.o
            java.lang.CharSequence r3 = r3.getText()
            java.lang.String r3 = r3.toString()
            java.lang.String r3 = r3.trim()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 == 0) goto L_0x0197
        L_0x0182:
            android.widget.TextView r0 = r6.z
            android.content.res.Resources r3 = r6.getResources()
            int r5 = com.travel.bus.R.string.field_mandatory_error
            java.lang.String r3 = r3.getString(r5)
            r0.setText(r3)
            android.widget.TextView r0 = r6.z
            r0.setVisibility(r2)
            r0 = 0
        L_0x0197:
            net.one97.paytm.common.widgets.CJRFloatingLabel r3 = r6.p
            if (r3 == 0) goto L_0x01b5
            java.lang.CharSequence r3 = r3.getText()
            if (r3 == 0) goto L_0x01b5
            net.one97.paytm.common.widgets.CJRFloatingLabel r3 = r6.p
            java.lang.CharSequence r3 = r3.getText()
            java.lang.String r3 = r3.toString()
            java.lang.String r3 = r3.trim()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 == 0) goto L_0x01ca
        L_0x01b5:
            android.widget.TextView r0 = r6.A
            android.content.res.Resources r3 = r6.getResources()
            int r5 = com.travel.bus.R.string.field_mandatory_error
            java.lang.String r3 = r3.getString(r5)
            r0.setText(r3)
            android.widget.TextView r0 = r6.A
            r0.setVisibility(r2)
            r0 = 0
        L_0x01ca:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            net.one97.paytm.common.widgets.CJRFloatingLabel r5 = r6.o
            android.widget.EditText r5 = r5.getEditText()
            android.text.Editable r5 = r5.getText()
            java.lang.String r5 = r5.toString()
            java.lang.String r5 = r5.trim()
            r3.append(r5)
            net.one97.paytm.common.widgets.CJRFloatingLabel r5 = r6.p
            android.widget.EditText r5 = r5.getEditText()
            android.text.Editable r5 = r5.getText()
            java.lang.String r5 = r5.toString()
            java.lang.String r5 = r5.trim()
            r3.append(r5)
            java.lang.String r3 = r3.toString()
            int r3 = r3.length()
            if (r3 >= r4) goto L_0x022c
            android.widget.TextView r0 = r6.z
            android.content.res.Resources r3 = r6.getResources()
            int r4 = com.travel.bus.R.string.address_invalid
            java.lang.String r3 = r3.getString(r4)
            r0.setText(r3)
            android.widget.TextView r0 = r6.A
            android.content.res.Resources r3 = r6.getResources()
            int r4 = com.travel.bus.R.string.address_invalid
            java.lang.String r3 = r3.getString(r4)
            r0.setText(r3)
            android.widget.TextView r0 = r6.z
            r0.setVisibility(r2)
            android.widget.TextView r0 = r6.A
            r0.setVisibility(r2)
            r0 = 0
        L_0x022c:
            net.one97.paytm.common.widgets.CJRFloatingLabel r3 = r6.q
            if (r3 == 0) goto L_0x0278
            java.lang.CharSequence r3 = r3.getText()
            if (r3 == 0) goto L_0x0278
            net.one97.paytm.common.widgets.CJRFloatingLabel r3 = r6.q
            java.lang.CharSequence r3 = r3.getText()
            java.lang.String r3 = r3.toString()
            java.lang.String r3 = r3.trim()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x0278
            net.one97.paytm.common.widgets.CJRFloatingLabel r3 = r6.q
            java.lang.CharSequence r3 = r3.getText()
            java.lang.String r3 = r3.toString()
            int r4 = r3.length()
            if (r4 <= r1) goto L_0x0276
            int r1 = r3.length()
            r3 = 6
            if (r1 >= r3) goto L_0x0276
            android.widget.TextView r0 = r6.B
            android.content.res.Resources r1 = r6.getResources()
            int r3 = com.travel.bus.R.string.bus_msg_pincode_err
            java.lang.String r1 = r1.getString(r3)
            r0.setText(r1)
            android.widget.TextView r0 = r6.B
            r0.setVisibility(r2)
            goto L_0x028c
        L_0x0276:
            r2 = r0
            goto L_0x028c
        L_0x0278:
            android.widget.TextView r0 = r6.B
            android.content.res.Resources r1 = r6.getResources()
            int r3 = com.travel.bus.R.string.field_mandatory_error
            java.lang.String r1 = r1.getString(r3)
            r0.setText(r1)
            android.widget.TextView r0 = r6.B
            r0.setVisibility(r2)
        L_0x028c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.bus.busticket.activity.AJRBusBusinessUser.a():boolean");
    }

    public final void a(PincodeResponse pincodeResponse) {
        ProgressDialog progressDialog;
        this.D = false;
        if (!isFinishing() && (progressDialog = this.f21817a) != null && progressDialog.isShowing() && !isFinishing()) {
            this.f21817a.dismiss();
            this.f21817a = null;
        }
        if (pincodeResponse != null && pincodeResponse.getPincodeBody() != null) {
            this.t.setVisibility(0);
            this.u.setVisibility(0);
            if (pincodeResponse.getPincodeBody().getState() != null) {
                this.r.setFocusable(false);
                this.r.setEdittextEditable(false);
                this.r.setText((CharSequence) pincodeResponse.getPincodeBody().getState());
            }
            this.f21818b = pincodeResponse.getPincodeBody().getCityList();
            List<PincodeResponse.Cities> list = this.f21818b;
            if (list != null && list.size() > 0) {
                this.E = false;
                this.f21825i.setVisibility(8);
                this.u.setVisibility(0);
                Spinner spinner = this.v;
                if (spinner != null) {
                    spinner.setEnabled(true);
                    ArrayList arrayList = new ArrayList();
                    for (PincodeResponse.Cities next : this.f21818b) {
                        if (!(next == null || next.getCityName() == null)) {
                            arrayList.add(next.getCityName());
                        }
                    }
                    this.v.setAdapter(new i(R.layout.pre_b_bus_city_item_layout, this, arrayList, this, getResources().getString(R.string.city)));
                    if (this.f21818b.size() == 1) {
                        this.v.setSelection(1);
                        this.v.setEnabled(false);
                    }
                }
            }
        }
    }

    public void onBackPressed() {
        b((Activity) this);
        super.onBackPressed();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.bus_toolbar_back_arrow) {
            onBackPressed();
        } else if (id == R.id.bus_toolbar_reset_text) {
            CJRFloatingLabel cJRFloatingLabel = this.l;
            if (!(cJRFloatingLabel == null || cJRFloatingLabel.getEditText() == null)) {
                this.l.setText((CharSequence) null);
            }
            CJRFloatingLabel cJRFloatingLabel2 = this.m;
            if (!(cJRFloatingLabel2 == null || cJRFloatingLabel2.getEditText() == null)) {
                this.m.setText((CharSequence) null);
            }
            CJRFloatingLabel cJRFloatingLabel3 = this.n;
            if (!(cJRFloatingLabel3 == null || cJRFloatingLabel3.getEditText() == null)) {
                this.n.setText((CharSequence) null);
            }
            CJRFloatingLabel cJRFloatingLabel4 = this.o;
            if (!(cJRFloatingLabel4 == null || cJRFloatingLabel4.getEditText() == null)) {
                this.o.setText((CharSequence) null);
            }
            CJRFloatingLabel cJRFloatingLabel5 = this.p;
            if (!(cJRFloatingLabel5 == null || cJRFloatingLabel5.getEditText() == null)) {
                this.p.setText((CharSequence) null);
            }
            CJRFloatingLabel cJRFloatingLabel6 = this.q;
            if (!(cJRFloatingLabel6 == null || cJRFloatingLabel6.getEditText() == null)) {
                this.q.setText((CharSequence) null);
            }
            CJRFloatingLabel cJRFloatingLabel7 = this.r;
            if (!(cJRFloatingLabel7 == null || cJRFloatingLabel7.getEditText() == null)) {
                this.p.setText((CharSequence) null);
            }
            if (this.v != null) {
                ArrayList arrayList = new ArrayList();
                this.v.setAdapter(new i(R.layout.pre_b_bus_city_item_layout, this, arrayList, this, getResources().getString(R.string.city)));
            }
            b();
        } else if (id == R.id.save_button) {
            b((Activity) this);
            if (this.l.getText() == null || TextUtils.isEmpty(this.l.getText().toString().trim()) || this.m.getText() == null || TextUtils.isEmpty(this.m.getText().toString().trim()) || this.n.getText() == null || TextUtils.isEmpty(this.n.getText().toString().trim()) || this.o.getText() == null || TextUtils.isEmpty(this.o.getText().toString().trim()) || this.p.getText() == null || TextUtils.isEmpty(this.p.getText().toString().trim()) || this.q.getText() == null || TextUtils.isEmpty(this.q.getText().toString().trim()) || this.r.getText() == null || TextUtils.isEmpty(this.r.getText().toString().trim()) || this.j.getText() == null || TextUtils.isEmpty(this.j.getText().toString().trim())) {
                Dialog dialog = this.F;
                if (dialog != null && dialog.isShowing()) {
                    this.F.dismiss();
                }
                this.F = new Dialog(this);
                this.F.getWindow().setContentView(R.layout.traveller_business_user_dialog);
                this.F.getWindow().setBackgroundDrawable(new ColorDrawable(0));
                ((Button) this.F.findViewById(R.id.btnGoBackBusinessUserDialog)).setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        AJRBusBusinessUser.this.a();
                        AJRBusBusinessUser.this.F.dismiss();
                    }
                });
                ((Button) this.F.findViewById(R.id.btnProceedBusinessUserDialog)).setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        Intent intent = new Intent();
                        intent.putExtra("BUSINESS_GST", AJRBusBusinessUser.this.l.getText().toString());
                        intent.putExtra("BUSINESS_COMPANY", AJRBusBusinessUser.this.m.getText().toString());
                        intent.putExtra("BUSINESS_EMAIL", AJRBusBusinessUser.this.n.getText().toString());
                        intent.putExtra("BUSINESS_FLAT", AJRBusBusinessUser.this.o.getText().toString());
                        intent.putExtra("BUSINESS_STREET", AJRBusBusinessUser.this.p.getText().toString());
                        intent.putExtra("BUSINESS_PIN", AJRBusBusinessUser.this.q.getText().toString());
                        intent.putExtra("BUSINESS_STATE", AJRBusBusinessUser.this.r.getText().toString());
                        intent.putExtra("BUSINESS_CITY", AJRBusBusinessUser.this.j.getText().toString());
                        AJRBusBusinessUser.this.setResult(0, intent);
                        AJRBusBusinessUser.this.finish();
                        AJRBusBusinessUser.this.F.dismiss();
                    }
                });
                this.F.setCancelable(false);
                this.F.setCanceledOnTouchOutside(false);
                this.F.show();
            } else if (a()) {
                Intent intent = new Intent();
                intent.putExtra("BUSINESS_GST", this.l.getText().toString());
                intent.putExtra("BUSINESS_COMPANY", this.m.getText().toString());
                intent.putExtra("BUSINESS_EMAIL", this.n.getText().toString().trim());
                intent.putExtra("BUSINESS_FLAT", this.o.getText().toString());
                intent.putExtra("BUSINESS_STREET", this.p.getText().toString());
                intent.putExtra("BUSINESS_PIN", this.q.getText().toString());
                intent.putExtra("BUSINESS_STATE", this.r.getText().toString());
                intent.putExtra("BUSINESS_CITY", this.j.getText().toString());
                setResult(-1, intent);
                finish();
            }
        }
    }

    /* access modifiers changed from: private */
    public static void b(Activity activity) {
        InputMethodManager inputMethodManager;
        if (activity != null && (inputMethodManager = (InputMethodManager) activity.getSystemService("input_method")) != null && activity.getCurrentFocus() != null && activity.getCurrentFocus().getWindowToken() != null) {
            inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 2);
        }
    }
}
