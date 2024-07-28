package com.travel.flight.flightticket.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import com.travel.cdn.ResourceUtils;
import com.travel.flight.R;
import com.travel.flight.activity.FlightWebViewActivity;
import com.travel.flight.flightticket.i.a;
import com.travel.flight.pojo.CJRBusHolidayList;
import com.travel.flight.pojo.flightticket.CJRViewFareAlerts;
import com.travel.flight.utils.c;
import com.travel.utils.n;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.upi.util.UpiConstants;
import org.json.JSONException;
import org.json.JSONObject;

public class AJRFareAlertSubscribeActivity extends Activity implements View.OnClickListener, b, a {

    /* renamed from: a  reason: collision with root package name */
    boolean f24750a = false;

    /* renamed from: b  reason: collision with root package name */
    private com.travel.flight.pojo.flightticket.b f24751b;

    /* renamed from: c  reason: collision with root package name */
    private com.travel.flight.pojo.flightticket.b f24752c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f24753d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f24754e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f24755f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f24756g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f24757h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f24758i;
    private TextView j;
    private TextView k;
    private ImageView l;
    private Animation m;
    private Animation n;
    private Animation o;
    private Animation p;
    private Animation q;
    private String r;
    private CJRBusHolidayList s;
    private int t = 1;
    private int u = 0;
    private int v = 0;
    private ProgressDialog w;
    private com.travel.flight.flightticket.g.b x;

    public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        CJRViewFareAlerts.a aVar;
        super.onCreate(bundle);
        setContentView(R.layout.pre_f_activity_fare_alert_subscribe);
        com.travel.flight.b.a();
        String s2 = com.paytm.utility.b.s(this, com.travel.flight.b.b().g());
        try {
            if (!isFinishing() && com.paytm.utility.b.c((Context) this)) {
                com.paytm.network.b bVar = new com.paytm.network.b();
                bVar.f42877a = getApplicationContext();
                bVar.n = a.b.SILENT;
                bVar.o = AJRFareAlertSubscribeActivity.class.getSimpleName();
                bVar.f42878b = a.c.FLIGHT;
                bVar.f42879c = a.C0715a.GET;
                bVar.f42880d = s2;
                bVar.f42881e = null;
                bVar.f42882f = null;
                bVar.f42883g = null;
                bVar.f42884h = null;
                bVar.f42885i = new CJRBusHolidayList();
                bVar.j = this;
                bVar.t = null;
                bVar.l().a();
            }
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
        this.x = new com.travel.flight.flightticket.g.b(this);
        this.f24758i = (TextView) findViewById(R.id.source_date);
        ((RelativeLayout) findViewById(R.id.departure_date_lyt)).setOnClickListener(this);
        ((RelativeLayout) findViewById(R.id.source_city)).setOnClickListener(this);
        ((RelativeLayout) findViewById(R.id.destination_city)).setOnClickListener(this);
        this.f24753d = (TextView) findViewById(R.id.source);
        this.f24754e = (TextView) findViewById(R.id.label_source);
        this.f24755f = (TextView) findViewById(R.id.source_city_code);
        this.f24756g = (TextView) findViewById(R.id.destination);
        this.l = (ImageView) findViewById(R.id.sep_route);
        this.f24757h = (TextView) findViewById(R.id.dest_city_code);
        this.l.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AJRFareAlertSubscribeActivity.a(AJRFareAlertSubscribeActivity.this);
            }
        });
        this.j = (TextView) findViewById(R.id.label_desination);
        this.k = (TextView) findViewById(R.id.label_depart_on);
        findViewById(R.id.btn_subscribe_alert).setOnClickListener(this);
        findViewById(R.id.txt_fare_alert_home_terms).setOnClickListener(this);
        ImageView imageView = (ImageView) findViewById(R.id.img_alert_sub_back);
        imageView.setImageResource(com.travel.common.R.drawable.travel_res_common_back_button);
        imageView.setRotation(180.0f);
        imageView.setOnClickListener(this);
        this.n = AnimationUtils.loadAnimation(this, R.anim.move_right);
        this.m = AnimationUtils.loadAnimation(this, R.anim.move_left);
        this.p = AnimationUtils.loadAnimation(this, R.anim.rotate);
        this.p.setRepeatCount(1);
        this.q = AnimationUtils.loadAnimation(this, R.anim.rotate360);
        this.q.setRepeatCount(1);
        this.o = AnimationUtils.loadAnimation(this, R.anim.pre_f_shake);
        this.r = this.f24758i.getTag().toString();
        if (!(getIntent().getExtras() == null || (aVar = (CJRViewFareAlerts.a) getIntent().getExtras().getSerializable("fare_alert_obj")) == null)) {
            this.f24750a = true;
            this.f24753d.setVisibility(0);
            this.f24754e.setVisibility(0);
            this.f24756g.setVisibility(0);
            this.j.setVisibility(0);
            this.k.setVisibility(0);
            this.f24753d.setText(aVar.getSource());
            this.f24755f.setText(aVar.getSource_iata());
            this.f24756g.setText(aVar.getDestination());
            this.f24757h.setText(aVar.getDestination_iata());
            this.f24758i.setText(com.paytm.utility.b.d(aVar.getDoj(), "dd MMM yyyy", "E, dd MMM yy"));
        }
        ResourceUtils.loadFlightImagesFromCDN((ImageView) findViewById(R.id.img_fare_alert_list_bell), "bell_alert.png", false, false, n.a.V1);
        g();
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        com.travel.utils.q.a(context);
        com.travel.flight.b.a();
        super.attachBaseContext(com.travel.flight.b.b().d(context));
        com.travel.utils.q.c(context);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        com.travel.utils.q.c(this);
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.source_city) {
            a(201, "source");
        } else if (id == R.id.destination_city) {
            a(202, "destination");
        } else if (id == R.id.departure_date_lyt) {
            i();
        } else if (id == R.id.btn_subscribe_alert) {
            d();
        } else if (id == R.id.txt_fare_alert_home_terms) {
            Intent intent = new Intent();
            com.travel.flight.b.a();
            intent.putExtra("url", com.travel.flight.b.b().x());
            intent.putExtra("title", getString(R.string.terms_and_conditions));
            intent.setClass(this, FlightWebViewActivity.class);
            startActivity(intent);
        } else if (id == R.id.img_alert_sub_back) {
            finish();
        }
    }

    /* access modifiers changed from: private */
    public void d() {
        String charSequence = this.f24753d.getText().toString();
        String charSequence2 = this.f24756g.getText().toString();
        Resources resources = getResources();
        if (charSequence.equalsIgnoreCase(resources.getString(R.string.enter_origin))) {
            this.f24755f.startAnimation(this.o);
            com.paytm.utility.b.b((Context) this, resources.getString(R.string.special_characters_title), resources.getString(R.string.flight_msg_invalid_origin));
        } else if (charSequence2.equalsIgnoreCase(resources.getString(R.string.enter_destination))) {
            this.f24757h.startAnimation(this.o);
            com.paytm.utility.b.b((Context) this, resources.getString(R.string.special_characters_title), resources.getString(R.string.flight_msg_invalid_destination));
        } else if (charSequence.equalsIgnoreCase(charSequence2)) {
            com.paytm.utility.b.b((Context) this, resources.getString(R.string.passenger_same_city_header), String.format(getResources().getString(R.string.flight_msg_source_destination_same), new Object[]{charSequence, charSequence}));
        } else if (this.f24758i.getText().toString().equalsIgnoreCase(resources.getString(R.string.select_dept_date))) {
            com.paytm.utility.b.b((Context) this, resources.getString(R.string.special_characters_title), resources.getString(R.string.flight_msg_invalid_date));
        } else if (TextUtils.isEmpty(this.f24758i.getText().toString())) {
            com.paytm.utility.b.a((Activity) this, AJRFareAlertSubscribeActivity.class.getName());
        } else if (!com.paytm.utility.b.c((Context) this)) {
            b();
        } else if (this.f24750a) {
            if (f()) {
                this.x.a((CJRViewFareAlerts.a) getIntent().getExtras().getSerializable("fare_alert_obj"), this.f24755f.getText().toString(), this.f24757h.getText().toString(), this.f24758i.getText().toString());
            }
        } else if (com.paytm.utility.b.r(getApplicationContext())) {
            this.x.a(this.f24755f.getText().toString(), this.f24757h.getText().toString(), this.f24758i.getText().toString());
        } else {
            e();
        }
    }

    private void e() {
        Intent intent = new Intent();
        com.travel.flight.b.a();
        com.travel.flight.b.b().a(getApplicationContext(), intent, 111);
    }

    private boolean f() {
        String d2 = com.paytm.utility.b.d(this.f24758i.getText().toString(), "E, dd MMM yy", "dd MMM yy");
        CJRViewFareAlerts.a aVar = (CJRViewFareAlerts.a) getIntent().getExtras().getSerializable("fare_alert_obj");
        StringBuilder sb = new StringBuilder("Validate");
        sb.append(this.f24753d.getText().toString());
        sb.append(" ");
        sb.append(aVar.getSource());
        sb.append(" ");
        sb.append(this.f24756g.getText().toString());
        sb.append(" ");
        sb.append(aVar.getDestination());
        sb.append(" ");
        sb.append(d2);
        sb.append(" ");
        sb.append(aVar.getDoj());
        if (!this.f24753d.getText().toString().equals(aVar.getSource()) || !this.f24756g.getText().toString().equals(aVar.getDestination()) || !d2.equals(aVar.getDoj())) {
            return true;
        }
        Toast.makeText(this, getString(R.string.already_subscribed_note), 0).show();
        return false;
    }

    public final void a() {
        Intent intent = new Intent(this, AJRFareAlertListActivity.class);
        intent.putExtra("citysearched", this.f24753d.getText().toString() + "-" + this.f24756g.getText().toString());
        startActivity(intent);
        finish();
    }

    /* access modifiers changed from: private */
    public void a(int i2, String str) {
        try {
            Intent intent = new Intent(this, AJRSelectAirportActivity.class);
            intent.putExtra("option", str);
            if (this.f24751b != null && !TextUtils.isEmpty(this.f24751b.getCityName())) {
                intent.putExtra("source", this.f24751b.getCityName());
            }
            if (this.f24752c != null && !TextUtils.isEmpty(this.f24752c.getCityName())) {
                intent.putExtra("destination", this.f24752c.getCityName());
            }
            startActivityForResult(intent, i2);
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
    }

    private void a(com.travel.flight.pojo.flightticket.b bVar) {
        try {
            this.f24753d.setText(bVar.getCityName());
            this.f24753d.setTag(bVar);
            ((RelativeLayout.LayoutParams) this.f24753d.getLayoutParams()).addRule(13, 8);
            this.f24753d.setVisibility(0);
            this.f24754e.setVisibility(0);
            String str = "";
            if (bVar.getShortCityName() != null) {
                String substring = bVar.getShortCityName().length() >= 3 ? bVar.getShortCityName().substring(0, 3) : bVar.getShortCityName();
                this.f24755f.setTextColor(getResources().getColor(R.color.cart_black));
                if (bVar.getShortCityName() != null) {
                    this.f24755f.setText(substring.toUpperCase());
                } else {
                    this.f24755f.setText(str);
                }
            }
            if (this.f24751b == null) {
                this.f24751b = new com.travel.flight.pojo.flightticket.b();
            }
            this.f24751b.setCityName(bVar.getCityName());
            this.f24751b.setAirPortName(bVar.getAirPortName());
            com.travel.flight.pojo.flightticket.b bVar2 = this.f24751b;
            if (bVar.getShortCityName() != null) {
                str = bVar.getShortCityName();
            }
            bVar2.setShortCityName(str);
            this.f24751b.setCountryName(bVar.getCountryName());
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i2, int i3, Intent intent) {
        com.travel.flight.pojo.flightticket.b bVar;
        com.travel.flight.pojo.flightticket.b bVar2;
        super.onActivityResult(i2, i3, intent);
        if (i3 == -1) {
            if (i2 != 1) {
                if (i2 != 111) {
                    if (i2 == 201) {
                        if (intent != null && intent.getBooleanExtra("is_recent_search_selected", false)) {
                            a((com.travel.flight.pojo.flightticket.b) intent.getSerializableExtra("flight_source_recent_search_selected"));
                            b((com.travel.flight.pojo.flightticket.b) intent.getSerializableExtra("flight_dest_recent_search_selected"));
                            g();
                        } else if (!(intent == null || !intent.hasExtra("intent_extra_selected_city_name") || (bVar = (com.travel.flight.pojo.flightticket.b) intent.getSerializableExtra("intent_extra_selected_city_name")) == null || bVar.getCityName() == null)) {
                            a(bVar);
                            g();
                        }
                        if (this.f24756g.getText().toString().equals(getResources().getString(R.string.enter_destination)) && !this.f24755f.getText().toString().equalsIgnoreCase(UpiConstants.FROM)) {
                            new Handler().post(new Runnable() {
                                public final void run() {
                                    AJRFareAlertSubscribeActivity.this.a(202, "destination");
                                }
                            });
                        }
                    } else if (i2 == 202) {
                        if (intent != null && intent.getBooleanExtra("is_recent_search_selected", false)) {
                            a((com.travel.flight.pojo.flightticket.b) intent.getSerializableExtra("flight_source_recent_search_selected"));
                            b((com.travel.flight.pojo.flightticket.b) intent.getSerializableExtra("flight_dest_recent_search_selected"));
                            g();
                        } else if (!(intent == null || !intent.hasExtra("intent_extra_selected_city_name") || (bVar2 = (com.travel.flight.pojo.flightticket.b) intent.getSerializableExtra("intent_extra_selected_city_name")) == null || bVar2.getCityName() == null)) {
                            b(bVar2);
                            g();
                        }
                        if (this.f24753d.getText().toString().equalsIgnoreCase(getResources().getString(R.string.enter_origin)) && !this.f24757h.getText().toString().equalsIgnoreCase("To")) {
                            new Handler().post(new Runnable() {
                                public final void run() {
                                    AJRFareAlertSubscribeActivity.this.a(201, "source");
                                }
                            });
                        }
                        if (this.f24758i.getText().toString().equalsIgnoreCase(getResources().getString(R.string.select_dept_date)) && !this.f24757h.getText().toString().equalsIgnoreCase("To")) {
                            new Handler().postDelayed(new Runnable() {
                                public final void run() {
                                    AJRFareAlertSubscribeActivity.this.i();
                                }
                            }, 200);
                        }
                    }
                } else if (com.paytm.utility.b.r(getApplicationContext())) {
                    this.x.a(this.f24755f.getText().toString(), this.f24757h.getText().toString(), this.f24758i.getText().toString());
                }
            } else if (intent != null && intent.hasExtra("intent_extra_selected_depart_date") && intent.hasExtra("intent_extra_selected_return_date")) {
                b(intent.getStringExtra("intent_extra_selected_depart_date"));
            } else if (intent != null && intent.hasExtra("intent_extra_selected_depart_date")) {
                b(intent.getStringExtra("intent_extra_selected_depart_date"));
            }
        }
    }

    private void b(String str) {
        this.f24758i.setTag(str);
        this.f24758i.setText(com.paytm.utility.b.d(str, "dd MMM yy", "E, dd MMM yy"));
        this.f24758i.setTextColor(getResources().getColor(R.color.color_000000));
        com.paytm.utility.b.a(this.f24758i);
        this.k.setVisibility(0);
        this.r = str;
    }

    private void b(com.travel.flight.pojo.flightticket.b bVar) {
        this.f24756g.setText(bVar.getCityName());
        this.f24756g.setTag(bVar);
        ((RelativeLayout.LayoutParams) this.f24756g.getLayoutParams()).addRule(13, 8);
        this.f24756g.setVisibility(0);
        this.j.setVisibility(0);
        String substring = bVar.getShortCityName().length() >= 3 ? bVar.getShortCityName().substring(0, 3) : bVar.getShortCityName();
        this.f24757h.setTextColor(getResources().getColor(R.color.cart_black));
        String str = "";
        if (bVar.getShortCityName() != null) {
            this.f24757h.setText(substring.toUpperCase());
        } else {
            this.f24757h.setText(str);
        }
        if (this.f24752c == null) {
            this.f24752c = new com.travel.flight.pojo.flightticket.b();
        }
        this.f24752c.setCityName(bVar.getCityName());
        this.f24752c.setAirPortName(bVar.getAirPortName());
        com.travel.flight.pojo.flightticket.b bVar2 = this.f24752c;
        if (bVar.getShortCityName() != null) {
            str = bVar.getShortCityName();
        }
        bVar2.setShortCityName(str);
        this.f24752c.setCountryName(bVar.getCountryName());
    }

    private void g() {
        if (!this.f24753d.getText().toString().equals(getString(R.string.enter_origin)) || !this.f24756g.getText().toString().equals(getString(R.string.enter_destination))) {
            ResourceUtils.loadFlightImagesFromCDN(this.l, "one_way_arrow.png", false, false, n.a.V1);
        } else {
            ResourceUtils.loadFlightImagesFromCDN(this.l, "one_way_grey_icon.png", false, false, n.a.V1);
        }
    }

    private static String h() {
        return new SimpleDateFormat("dd MMMM yy").format(Calendar.getInstance().getTime());
    }

    /* access modifiers changed from: private */
    public void i() {
        if (this.f24758i.getText().toString().equalsIgnoreCase(getResources().getString(R.string.select_dept_date))) {
            this.r = h();
        } else {
            this.r = this.f24758i.getTag().toString();
            this.r = com.paytm.utility.b.d(this.r, "dd MMM yy", "dd MMMM yy");
        }
        j();
        if (TextUtils.isEmpty(this.r)) {
            this.r = h();
        }
        String a2 = c.a((Context) this);
        com.travel.flight.b.a();
        startActivityForResult(com.travel.flight.b.b().a((Activity) this, new Locale(com.paytm.utility.n.a()), this.r, 0, com.travel.flight.flightorder.i.c.a(this), a2), 1);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x006c A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x006d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void j() {
        /*
            r7 = this;
            android.widget.TextView r0 = r7.f24755f
            java.lang.CharSequence r0 = r0.getText()
            java.lang.String r0 = r0.toString()
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x012d
            android.widget.TextView r0 = r7.f24757h
            java.lang.CharSequence r0 = r0.getText()
            java.lang.String r0 = r0.toString()
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x0022
            goto L_0x012d
        L_0x0022:
            r0 = 0
            java.text.SimpleDateFormat r1 = new java.text.SimpleDateFormat     // Catch:{ ParseException -> 0x0051 }
            java.lang.String r2 = "yyyy-MM-dd"
            java.util.Locale r3 = java.util.Locale.ENGLISH     // Catch:{ ParseException -> 0x0051 }
            r1.<init>(r2, r3)     // Catch:{ ParseException -> 0x0051 }
            java.util.Calendar r2 = java.util.Calendar.getInstance()     // Catch:{ ParseException -> 0x0051 }
            java.util.Date r3 = r2.getTime()     // Catch:{ ParseException -> 0x0051 }
            java.lang.String r3 = r1.format(r3)     // Catch:{ ParseException -> 0x0051 }
            java.util.Date r4 = r1.parse(r3)     // Catch:{ ParseException -> 0x004f }
            r2.setTime(r4)     // Catch:{ ParseException -> 0x004f }
            r4 = 5
            r5 = 365(0x16d, float:5.11E-43)
            r2.add(r4, r5)     // Catch:{ ParseException -> 0x004f }
            java.util.Date r2 = r2.getTime()     // Catch:{ ParseException -> 0x004f }
            java.lang.String r1 = r1.format(r2)     // Catch:{ ParseException -> 0x004f }
            goto L_0x005b
        L_0x004f:
            r1 = move-exception
            goto L_0x0053
        L_0x0051:
            r1 = move-exception
            r3 = r0
        L_0x0053:
            java.lang.String r1 = r1.getMessage()
            com.paytm.utility.q.b(r1)
            r1 = r0
        L_0x005b:
            com.travel.flight.b.a()
            com.travel.flight.c r2 = com.travel.flight.b.b()
            java.lang.String r2 = r2.i()
            boolean r4 = android.text.TextUtils.isEmpty(r2)
            if (r4 == 0) goto L_0x006d
            return
        L_0x006d:
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
            android.widget.TextView r5 = r7.f24755f
            java.lang.CharSequence r5 = r5.getText()
            java.lang.String r5 = r5.toString()
            java.lang.String r6 = "source"
            r4.put(r6, r5)
            android.widget.TextView r5 = r7.f24757h
            java.lang.CharSequence r5 = r5.getText()
            java.lang.String r5 = r5.toString()
            java.lang.String r6 = "destination"
            r4.put(r6, r5)
            java.lang.String r5 = "start_date"
            r4.put(r5, r3)
            java.lang.String r3 = "end_date"
            r4.put(r3, r1)
            java.lang.String r1 = "opened_from"
            java.lang.String r3 = "homepage"
            r4.put(r1, r3)
            java.lang.String r1 = "class"
            java.lang.String r3 = "E"
            r4.put(r1, r3)
            int r1 = r7.t
            if (r1 <= 0) goto L_0x00b5
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r3 = "adults"
            r4.put(r3, r1)
        L_0x00b5:
            int r1 = r7.v
            if (r1 <= 0) goto L_0x00c2
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r3 = "infants"
            r4.put(r3, r1)
        L_0x00c2:
            int r1 = r7.u
            if (r1 <= 0) goto L_0x00cf
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r3 = "children"
            r4.put(r3, r1)
        L_0x00cf:
            boolean r1 = android.text.TextUtils.isEmpty(r2)
            if (r1 != 0) goto L_0x012d
            com.travel.flight.pojo.flightticket.CJRFlightCalendarPriceModel r1 = new com.travel.flight.pojo.flightticket.CJRFlightCalendarPriceModel
            r1.<init>()
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            android.content.Context r3 = r7.getApplicationContext()
            com.paytm.utility.b.a((java.util.HashMap<java.lang.String, java.lang.String>) r1, (android.content.Context) r3)
            com.paytm.network.b r3 = new com.paytm.network.b
            r3.<init>()
            android.content.Context r5 = r7.getApplicationContext()
            r3.f42877a = r5
            com.paytm.network.a$b r5 = com.paytm.network.a.b.SILENT
            r3.n = r5
            java.lang.Class<com.travel.flight.flightticket.activity.AJRFareAlertSubscribeActivity> r5 = com.travel.flight.flightticket.activity.AJRFareAlertSubscribeActivity.class
            java.lang.String r5 = r5.getSimpleName()
            r3.o = r5
            com.paytm.network.a$c r5 = com.paytm.network.a.c.FLIGHT
            r3.f42878b = r5
            com.paytm.network.a$a r5 = com.paytm.network.a.C0715a.GET
            r3.f42879c = r5
            r3.f42880d = r2
            r3.f42881e = r0
            r3.f42882f = r1
            r3.f42883g = r4
            r3.f42884h = r0
            com.travel.model.CalendarPriceModel r0 = new com.travel.model.CalendarPriceModel
            r0.<init>()
            r3.f42885i = r0
            com.travel.flight.flightticket.activity.AJRFareAlertSubscribeActivity$5 r0 = new com.travel.flight.flightticket.activity.AJRFareAlertSubscribeActivity$5
            r0.<init>()
            r3.j = r0
            org.json.JSONObject r0 = k()
            r3.t = r0
            com.paytm.network.a r0 = r3.l()
            r1 = 1
            r0.f42860d = r1
            r0.a()
        L_0x012d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.flightticket.activity.AJRFareAlertSubscribeActivity.j():void");
    }

    private static JSONObject k() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "FlightFareAlertScreen");
        } catch (JSONException e2) {
            q.b(e2.getMessage());
        }
        return jSONObject;
    }

    public final void b() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getResources().getString(R.string.no_connection));
        builder.setMessage(getResources().getString(R.string.no_internet));
        builder.setPositiveButton(getResources().getString(R.string.network_retry_yes), new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.cancel();
                AJRFareAlertSubscribeActivity.this.d();
            }
        });
        builder.show();
    }

    public final void a(String str) {
        ProgressDialog progressDialog = this.w;
        if (progressDialog == null || !progressDialog.isShowing()) {
            this.w = new ProgressDialog(this);
            try {
                this.w.setProgressStyle(0);
                this.w.setMessage(str);
                this.w.setCancelable(false);
                this.w.setCanceledOnTouchOutside(false);
                this.w.show();
            } catch (IllegalArgumentException e2) {
                if (com.paytm.utility.b.v) {
                    q.b(e2.getMessage());
                }
            } catch (Exception unused) {
            }
        }
    }

    public final void c() {
        try {
            if (this.w != null && this.w.isShowing() && !isFinishing()) {
                this.w.dismiss();
                this.w = null;
            }
        } catch (Exception unused) {
        }
    }

    public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        if (iJRPaytmDataModel instanceof CJRBusHolidayList) {
            CJRBusHolidayList cJRBusHolidayList = (CJRBusHolidayList) iJRPaytmDataModel;
            if (cJRBusHolidayList.getHolidayList() != null && cJRBusHolidayList.getHolidayList().size() > 0) {
                this.s = cJRBusHolidayList;
            }
        }
    }

    static /* synthetic */ void a(AJRFareAlertSubscribeActivity aJRFareAlertSubscribeActivity) {
        String charSequence = aJRFareAlertSubscribeActivity.f24753d.getText().toString();
        String charSequence2 = aJRFareAlertSubscribeActivity.f24756g.getText().toString();
        String charSequence3 = aJRFareAlertSubscribeActivity.f24755f.getText().toString();
        String charSequence4 = aJRFareAlertSubscribeActivity.f24757h.getText().toString();
        com.travel.flight.pojo.flightticket.b bVar = aJRFareAlertSubscribeActivity.f24751b;
        aJRFareAlertSubscribeActivity.f24751b = aJRFareAlertSubscribeActivity.f24752c;
        aJRFareAlertSubscribeActivity.f24752c = bVar;
        Object tag = aJRFareAlertSubscribeActivity.f24753d.getTag();
        Object tag2 = aJRFareAlertSubscribeActivity.f24756g.getTag();
        if (!charSequence.equalsIgnoreCase(aJRFareAlertSubscribeActivity.getResources().getString(R.string.enter_origin)) && !charSequence2.equalsIgnoreCase(aJRFareAlertSubscribeActivity.getResources().getString(R.string.enter_destination))) {
            aJRFareAlertSubscribeActivity.f24753d.setText(charSequence2);
            aJRFareAlertSubscribeActivity.f24756g.setText(charSequence);
            aJRFareAlertSubscribeActivity.f24755f.setText(charSequence4);
            aJRFareAlertSubscribeActivity.f24757h.setText(charSequence3);
            aJRFareAlertSubscribeActivity.f24755f.setTextColor(aJRFareAlertSubscribeActivity.getResources().getColor(R.color.cart_black));
            aJRFareAlertSubscribeActivity.f24757h.setTextColor(aJRFareAlertSubscribeActivity.getResources().getColor(R.color.cart_black));
            aJRFareAlertSubscribeActivity.f24753d.setTag(tag2);
            aJRFareAlertSubscribeActivity.f24756g.setTag(tag);
            aJRFareAlertSubscribeActivity.f24753d.startAnimation(aJRFareAlertSubscribeActivity.m);
            aJRFareAlertSubscribeActivity.f24755f.startAnimation(aJRFareAlertSubscribeActivity.m);
            aJRFareAlertSubscribeActivity.f24756g.startAnimation(aJRFareAlertSubscribeActivity.n);
            aJRFareAlertSubscribeActivity.f24757h.startAnimation(aJRFareAlertSubscribeActivity.n);
            aJRFareAlertSubscribeActivity.l.startAnimation(aJRFareAlertSubscribeActivity.q);
            aJRFareAlertSubscribeActivity.p.setFillAfter(true);
        }
    }
}
