package com.travel.flight.flightticket.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.utils.GAUtil;
import com.travel.flight.R;
import com.travel.flight.b;
import com.travel.flight.pojo.flightticket.CJRFlightClientLoginPayload;
import com.travel.utils.q;
import java.util.HashMap;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public class AJRAddTravellerActivity extends Activity implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private int f24725a = 1;

    /* renamed from: b  reason: collision with root package name */
    private int f24726b = 0;

    /* renamed from: c  reason: collision with root package name */
    private int f24727c = 0;

    /* renamed from: d  reason: collision with root package name */
    private RelativeLayout f24728d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f24729e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f24730f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f24731g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f24732h;

    /* renamed from: i  reason: collision with root package name */
    private RelativeLayout f24733i;
    private String j = "";
    private boolean k = false;
    private RadioButton l;
    private RadioButton m;
    private RadioButton n;
    private ImageView o;
    private ImageView p;
    private ImageView q;
    private ImageView r;
    private ImageView s;
    private ImageView t;
    private LinearLayout u;
    private LinearLayout v;
    private LinearLayout w;
    private LinearLayout x;
    private LinearLayout y;
    private LinearLayout z;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        q.c(this);
        getWindow().getDecorView().setSystemUiVisibility(1280);
        setContentView(R.layout.pre_f_activity_add_travellers);
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra("intent_extra_flight_search_no_of_adult_passengers")) {
                this.f24725a = intent.getIntExtra("intent_extra_flight_search_no_of_adult_passengers", 1);
            }
            if (intent.hasExtra("intent_extra_flight_search_no_of_child_passengers")) {
                this.f24726b = intent.getIntExtra("intent_extra_flight_search_no_of_child_passengers", 0);
            }
            if (intent.hasExtra("intent_extra_flight_search_no_of_infants_passengers")) {
                this.f24727c = intent.getIntExtra("intent_extra_flight_search_no_of_infants_passengers", 0);
            }
            if (intent.hasExtra("intent_extra_trip_type")) {
                this.j = intent.getStringExtra("intent_extra_trip_type");
            }
            if (intent.hasExtra("screen_type")) {
                this.k = intent.getExtras().getBoolean("screen_type");
            }
        }
        try {
            this.f24728d = (RelativeLayout) findViewById(R.id.done_passenger_selection);
            this.f24728d.setOnClickListener(this);
            this.f24729e = (TextView) findViewById(R.id.flight_infants_error_msg);
            this.f24733i = (RelativeLayout) findViewById(R.id.flight_infants_error_msg_root);
            this.p = (ImageView) findViewById(R.id.adult_nagative_icon);
            this.f24730f = (TextView) findViewById(R.id.adult_count_textview);
            this.o = (ImageView) findViewById(R.id.adult_positive_icon);
            this.r = (ImageView) findViewById(R.id.children_nagative_icon);
            this.f24731g = (TextView) findViewById(R.id.children_count_textview);
            this.q = (ImageView) findViewById(R.id.children_positive_icon);
            this.t = (ImageView) findViewById(R.id.infant_nagative_icon);
            this.f24732h = (TextView) findViewById(R.id.infant_count_textview);
            this.s = (ImageView) findViewById(R.id.infant_positive_icon);
            this.v = (LinearLayout) findViewById(R.id.adult_negative_lyt);
            this.u = (LinearLayout) findViewById(R.id.adult_positive_lyt);
            this.w = (LinearLayout) findViewById(R.id.child_negative_lyt);
            this.x = (LinearLayout) findViewById(R.id.child_positive_lyt);
            this.y = (LinearLayout) findViewById(R.id.infant_negative_lyt);
            this.z = (LinearLayout) findViewById(R.id.infant_positive_lyt);
            this.l = (RadioButton) findViewById(R.id.radio_economy);
            this.m = (RadioButton) findViewById(R.id.radio_premium_economy);
            this.n = (RadioButton) findViewById(R.id.radio_business);
            this.v.setOnClickListener(this);
            this.u.setOnClickListener(this);
            this.w.setOnClickListener(this);
            this.x.setOnClickListener(this);
            this.y.setOnClickListener(this);
            this.z.setOnClickListener(this);
            this.l.setOnClickListener(this);
            this.m.setOnClickListener(this);
            this.n.setOnClickListener(this);
            findViewById(R.id.lyt_flight_close_view).setOnClickListener(this);
        } catch (Exception unused) {
        }
        int i2 = this.f24725a;
        if (this.f24726b + i2 + this.f24727c == 9) {
            this.f24730f.setText(Integer.toString(i2));
            this.f24731g.setText(String.valueOf(this.f24726b));
            this.f24732h.setText(String.valueOf(this.f24727c));
            if (this.f24725a == 0 || this.f24726b == 0 || this.f24727c == 0) {
                int i3 = this.f24725a;
                if (i3 == 9) {
                    d();
                    g();
                    m();
                    l();
                    h();
                    i();
                } else if (this.f24726b + i3 == 9) {
                    g();
                    d();
                    k();
                    h();
                    l();
                    m();
                } else if (i3 + this.f24727c == 9) {
                    g();
                    d();
                    i();
                    h();
                    o();
                    l();
                }
            } else {
                g();
                o();
                k();
                d();
                h();
                l();
            }
        } else {
            this.f24730f.setText(Integer.toString(i2));
            if (this.f24725a == 1) {
                e();
                f();
            } else {
                g();
                f();
            }
            this.f24731g.setText(String.valueOf(this.f24726b));
            int i4 = this.f24726b;
            if (i4 == 0) {
                i();
                j();
            } else if (i4 == 8) {
                k();
                h();
            } else {
                k();
                j();
            }
            this.f24732h.setText(String.valueOf(this.f24727c));
            int i5 = this.f24727c;
            if (i5 == 0) {
                m();
                n();
            } else if (i5 == 4) {
                o();
                l();
            } else {
                o();
                n();
            }
        }
        a(this.j);
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        b.a();
        super.attachBaseContext(b.b().d(context));
        q.a(this);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        q.a(this);
    }

    private void a(String str) {
        this.j = str;
        c(this.j);
        if (this.j.equals(getString(R.string.economy_flight))) {
            this.l.setChecked(true);
            this.l.setTypeface(Typeface.create("sans-serif-medium", 0));
            this.m.setChecked(false);
            this.m.setTypeface(Typeface.create("sans-serif", 0));
            this.n.setChecked(false);
            this.n.setTypeface(Typeface.create("sans-serif", 0));
        } else if (this.j.equals(getString(R.string.premium_economy))) {
            this.l.setChecked(false);
            this.l.setTypeface(Typeface.create("sans-serif", 0));
            this.m.setChecked(true);
            this.m.setTypeface(Typeface.create("sans-serif-medium", 0));
            this.n.setChecked(false);
            this.n.setTypeface(Typeface.create("sans-serif", 0));
        } else {
            this.l.setChecked(false);
            this.l.setTypeface(Typeface.create("sans-serif", 0));
            this.m.setChecked(false);
            this.m.setTypeface(Typeface.create("sans-serif", 0));
            this.n.setChecked(true);
            this.n.setTypeface(Typeface.create("sans-serif-medium", 0));
        }
        CJRFlightClientLoginPayload.getInstance().setEvent(Item.KEY_CLASS, str);
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.done_passenger_selection) {
            a();
        } else if (id == R.id.radio_economy) {
            a(getString(R.string.economy_flight));
        } else if (id == R.id.radio_premium_economy) {
            a(getString(R.string.premium_economy));
        } else if (id == R.id.radio_business) {
            a(getString(R.string.business));
        } else if (id == R.id.adult_negative_lyt) {
            this.f24733i.setVisibility(8);
            int i2 = this.f24725a;
            if (i2 == 1) {
                e();
            } else if (i2 > 1) {
                try {
                    this.f24725a = Integer.parseInt(this.f24730f.getText().toString()) - 1;
                } catch (NumberFormatException unused) {
                }
                this.f24730f.setText(String.valueOf(this.f24725a));
                if (this.f24725a == 1) {
                    e();
                } else {
                    f();
                }
                f();
                n();
                j();
            }
            CJRFlightClientLoginPayload.getInstance().setEvent("adults", String.valueOf(this.f24725a));
        } else if (id == R.id.adult_positive_lyt) {
            this.f24733i.setVisibility(8);
            int i3 = this.f24725a;
            if (this.f24726b + i3 + this.f24727c == 9) {
                if (c() != null && !c().equals("")) {
                    Toast.makeText(this, c(), 0).show();
                }
            } else if (i3 == 9) {
                d();
            } else if (i3 < 9) {
                try {
                    this.f24725a = Integer.parseInt(this.f24730f.getText().toString()) + 1;
                } catch (NumberFormatException unused2) {
                }
                this.f24730f.setText(String.valueOf(this.f24725a));
                int i4 = this.f24725a;
                if (this.f24726b + i4 + this.f24727c == 9) {
                    d();
                    h();
                    l();
                    g();
                } else if (i4 == 9) {
                    d();
                } else {
                    g();
                    f();
                }
            }
            CJRFlightClientLoginPayload.getInstance().setEvent("adults", String.valueOf(this.f24725a));
        } else if (id == R.id.child_negative_lyt) {
            this.f24733i.setVisibility(8);
            int i5 = this.f24726b;
            if (i5 == 0) {
                i();
            } else if (i5 > 0) {
                try {
                    this.f24726b = Integer.parseInt(this.f24731g.getText().toString()) - 1;
                } catch (NumberFormatException unused3) {
                }
                this.f24731g.setText(String.valueOf(this.f24726b));
                if (this.f24726b == 0) {
                    i();
                } else {
                    k();
                }
                j();
                f();
                n();
            }
            CJRFlightClientLoginPayload.getInstance().setEvent("children", String.valueOf(this.f24726b));
        } else if (id == R.id.child_positive_lyt) {
            this.f24733i.setVisibility(8);
            int i6 = this.f24725a;
            int i7 = this.f24726b;
            if (i6 + i7 + this.f24727c == 9) {
                if (c() != null && !c().equals("")) {
                    Toast.makeText(this, c(), 0).show();
                }
            } else if (i7 == 8) {
                h();
            } else if (i7 < 8) {
                try {
                    this.f24726b = Integer.parseInt(this.f24731g.getText().toString()) + 1;
                } catch (NumberFormatException unused4) {
                }
                this.f24731g.setText(String.valueOf(this.f24726b));
                int i8 = this.f24725a;
                int i9 = this.f24726b;
                if (i8 + i9 + this.f24727c == 9) {
                    d();
                    h();
                    l();
                    k();
                } else if (i9 == 8) {
                    h();
                } else {
                    k();
                    j();
                }
            }
            CJRFlightClientLoginPayload.getInstance().setEvent("children", String.valueOf(this.f24726b));
        } else if (id == R.id.infant_negative_lyt) {
            this.f24733i.setVisibility(8);
            int i10 = this.f24727c;
            if (i10 == 0) {
                m();
            } else if (i10 > 0) {
                try {
                    this.f24727c = Integer.parseInt(this.f24732h.getText().toString()) - 1;
                } catch (NumberFormatException unused5) {
                }
                this.f24732h.setText(String.valueOf(this.f24727c));
                if (this.f24727c == 0) {
                    m();
                } else {
                    o();
                }
                f();
                j();
                n();
            }
            CJRFlightClientLoginPayload.getInstance().setEvent("infants", String.valueOf(this.f24727c));
        } else if (id == R.id.infant_positive_lyt) {
            this.f24733i.setVisibility(8);
            int i11 = this.f24725a + this.f24726b;
            int i12 = this.f24727c;
            if (i11 + i12 == 9) {
                if (c() != null && !c().equals("")) {
                    Toast.makeText(this, c(), 0).show();
                }
            } else if (i12 == 4) {
                l();
            } else if (i12 < 4) {
                try {
                    this.f24727c = Integer.parseInt(this.f24732h.getText().toString()) + 1;
                } catch (NumberFormatException unused6) {
                }
                int i13 = this.f24725a;
                int i14 = this.f24727c;
                if (this.f24726b + i13 + i14 == 9) {
                    this.f24732h.setText(String.valueOf(i14));
                    d();
                    h();
                    l();
                    o();
                } else if (i14 >= i13) {
                    if (i14 > i13) {
                        this.f24727c = i14 - 1;
                        Toast.makeText(this, getString(R.string.flight_infants_error_msg), 0).show();
                    } else {
                        this.f24732h.setText(String.valueOf(i14));
                    }
                    if (this.f24727c == 0) {
                        m();
                        n();
                    } else {
                        l();
                        o();
                    }
                } else if (i14 == 4) {
                    this.f24732h.setText(String.valueOf(i14));
                    l();
                } else {
                    this.f24732h.setText(String.valueOf(i14));
                    n();
                    o();
                }
            }
            CJRFlightClientLoginPayload.getInstance().setEvent("infants", String.valueOf(this.f24727c));
        } else if (id == R.id.lyt_flight_close_view) {
            a();
        }
    }

    private void a() {
        Boolean bool = Boolean.TRUE;
        if (b().booleanValue()) {
            Intent intent = new Intent();
            intent.putExtra("intent_extra_adult_passenger", String.valueOf(this.f24725a));
            intent.putExtra("intent_extra_children_passenger", String.valueOf(this.f24726b));
            intent.putExtra("intent_extra_infant_passenger", String.valueOf(this.f24727c));
            intent.putExtra("intent_extra_trip_type", this.j);
            setResult(-1, intent);
            finish();
        }
    }

    private Boolean b() {
        Resources resources = getResources();
        if (this.f24725a < net.one97.paytmflight.common.b.b.f30012b.intValue()) {
            b(resources.getString(R.string.msg_invalid_least_adult_passenger));
            return Boolean.FALSE;
        } else if (this.f24725a > net.one97.paytmflight.common.b.b.f30011a.intValue()) {
            b(resources.getString(R.string.msg_invalid_max_adult_passenger));
            return Boolean.FALSE;
        } else if (this.f24727c > this.f24725a) {
            b(resources.getString(R.string.flight_infants_error_msg));
            return Boolean.FALSE;
        } else if (this.f24726b > net.one97.paytmflight.common.b.b.f30013c.intValue()) {
            b(resources.getString(R.string.msg_invalid_max_child_passenger));
            return Boolean.FALSE;
        } else if (this.f24725a + this.f24726b + this.f24727c <= net.one97.paytmflight.common.b.b.f30014d.intValue()) {
            return Boolean.TRUE;
        } else {
            b(resources.getString(R.string.msg_invalid_max_total_passenger));
            return Boolean.FALSE;
        }
    }

    private void b(String str) {
        this.f24733i.setVisibility(0);
        this.f24729e.setText(str);
    }

    private String c() {
        Resources resources = getResources();
        if (this.f24725a + this.f24726b + this.f24727c == net.one97.paytmflight.common.b.b.f30014d.intValue()) {
            return resources.getString(R.string.msg_invalid_max_total_passenger);
        }
        if (this.f24725a == net.one97.paytmflight.common.b.b.f30012b.intValue()) {
            return resources.getString(R.string.msg_invalid_least_adult_passenger);
        }
        if (this.f24725a == net.one97.paytmflight.common.b.b.f30011a.intValue()) {
            return resources.getString(R.string.msg_invalid_max_adult_passenger);
        }
        if (this.f24727c == this.f24725a) {
            return resources.getString(R.string.flight_infants_error_msg);
        }
        return this.f24726b == net.one97.paytmflight.common.b.b.f30013c.intValue() ? resources.getString(R.string.msg_invalid_max_child_passenger) : "";
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    private void d() {
        this.u.setBackgroundResource(R.drawable.pre_f_flight_rounded_cornered_with_6dp_radius_grey_filled);
        this.o.setImageResource(R.drawable.pre_f_ic_positive_disabled);
    }

    private void e() {
        this.v.setBackgroundResource(R.drawable.pre_f_flight_rounded_cornered_with_6dp_radius_grey_filled);
        this.p.setImageResource(R.drawable.pre_f_ic_negative_disbled);
    }

    private void f() {
        this.u.setBackgroundResource(R.drawable.pre_f_flight_rounded_cornered_with_6dp_radius_blue_filled);
        this.o.setImageResource(R.drawable.pre_f_ic_positive_enbled);
    }

    private void g() {
        this.v.setBackgroundResource(R.drawable.pre_f_flight_rounded_cornered_with_6dp_radius_blue_filled);
        this.p.setImageResource(R.drawable.pre_f_ic_negative_enbled);
    }

    private void h() {
        this.x.setBackgroundResource(R.drawable.pre_f_flight_rounded_cornered_with_6dp_radius_grey_filled);
        this.q.setImageResource(R.drawable.pre_f_ic_positive_disabled);
    }

    private void i() {
        this.w.setBackgroundResource(R.drawable.pre_f_flight_rounded_cornered_with_6dp_radius_grey_filled);
        this.r.setImageResource(R.drawable.pre_f_ic_negative_disbled);
    }

    private void j() {
        this.x.setBackgroundResource(R.drawable.pre_f_flight_rounded_cornered_with_6dp_radius_blue_filled);
        this.q.setImageResource(R.drawable.pre_f_ic_positive_enbled);
    }

    private void k() {
        this.w.setBackgroundResource(R.drawable.pre_f_flight_rounded_cornered_with_6dp_radius_blue_filled);
        this.r.setImageResource(R.drawable.pre_f_ic_negative_enbled);
    }

    private void l() {
        this.z.setBackgroundResource(R.drawable.pre_f_flight_rounded_cornered_with_6dp_radius_grey_filled);
        this.s.setImageResource(R.drawable.pre_f_ic_positive_disabled);
    }

    private void m() {
        this.y.setBackgroundResource(R.drawable.pre_f_flight_rounded_cornered_with_6dp_radius_grey_filled);
        this.t.setImageResource(R.drawable.pre_f_ic_negative_disbled);
    }

    private void n() {
        this.z.setBackgroundResource(R.drawable.pre_f_flight_rounded_cornered_with_6dp_radius_blue_filled);
        this.s.setImageResource(R.drawable.pre_f_ic_positive_enbled);
    }

    private void o() {
        this.y.setBackgroundResource(R.drawable.pre_f_flight_rounded_cornered_with_6dp_radius_blue_filled);
        this.t.setImageResource(R.drawable.pre_f_ic_negative_enbled);
    }

    private void c(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("event_label", Integer.valueOf(this.f24725a));
        hashMap.put("event_label2", Integer.valueOf(this.f24726b));
        hashMap.put("event_label3", Integer.valueOf(this.f24727c));
        hashMap.put(SDKConstants.EVENT_KEY_EVENT_LABEL4, str);
        a("traveller_class_clicked", hashMap);
    }

    private static void a(String str, HashMap<String, Object> hashMap) {
        b.a();
        b.b().a(GAUtil.CUSTOM_EVENT, "/flights", "flights_home", str, hashMap);
    }
}
