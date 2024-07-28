package net.one97.paytm.wallet.newdesign.addmoney.view;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.q;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.e;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.addmoney.R;
import net.one97.paytm.addmoney.utils.h;
import net.one97.paytm.addmoney.utils.m;
import net.one97.paytm.wallet.newdesign.addmoney.c.d;
import net.one97.paytm.wallet.newdesign.addmoney.c.g;
import net.one97.paytm.wallet.newdesign.addmoney.nearby.b;
import net.one97.paytm.wallet.newdesign.addmoney.nearby.datamodals.PayTMPartnerListModal;

public class NearByAddMoneyActivity extends PaytmActivity implements View.OnClickListener, e.b, e.c, com.google.android.gms.location.e, d, b.a {

    /* renamed from: a  reason: collision with root package name */
    HashMap<String, ArrayList<PayTMPartnerListModal.Response>> f70689a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f70690b = false;

    /* renamed from: c  reason: collision with root package name */
    Vector<g> f70691c = new Vector<>();

    /* renamed from: d  reason: collision with root package name */
    private Toolbar f70692d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f70693e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f70694f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f70695g;

    /* renamed from: h  reason: collision with root package name */
    private LinearLayout f70696h;

    /* renamed from: i  reason: collision with root package name */
    private ImageView f70697i;
    private Fragment j;
    /* access modifiers changed from: private */
    public View k;
    private e l;
    private LocationRequest m;
    private Location n;
    private double[] o = new double[2];
    private double[] p = new double[2];
    private a q;
    private LocationManager r;
    private boolean s = false;
    private boolean t = false;
    private boolean u = false;
    private String v = "";
    private LayoutInflater w;
    private Vector<Object> x = new Vector<>();

    public void onConnectionSuspended(int i2) {
    }

    public void onLocationSearchClick(View view) {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.v = getString(R.string.nearby_heading);
        this.r = (LocationManager) getSystemService("location");
        this.w = LayoutInflater.from(this);
        setContentView(R.layout.activity_nearby_addmoney);
        int intExtra = getIntent().getIntExtra("nearby_points", m.NEARBY_CASH_POINT.getIdentifier());
        if (intExtra == m.NEARBY_CASH_POINT.getIdentifier() || intExtra != m.NEARBY_BANKING_POINT.getIdentifier()) {
            b(getString(R.string.add_wallet_cash));
        } else {
            b(getString(R.string.uam_ppb_nearby_banking_point_title));
        }
        g();
        if (h.a(getApplicationContext()).b("isNearbyTutorialMessageDone", 0, true) <= 0) {
            this.t = true;
            findViewById(R.id.nearby_messagebanner).setVisibility(0);
        } else {
            this.t = false;
            findViewById(R.id.nearby_messagebanner).setVisibility(8);
        }
        if (Build.VERSION.SDK_INT < 23) {
            c();
        } else if (androidx.core.content.b.a((Context) this, "android.permission.ACCESS_FINE_LOCATION") != 0) {
            requestPermissions(new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 109);
        } else {
            c();
        }
        try {
            findViewById(R.id.passbooksendtobank_okgotit_tv).setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    NearByAddMoneyActivity.this.a(view);
                }
            });
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (b.a().a(this, this)) {
            this.l = new e.a(this).a((a<? extends a.d.C0127d>) f.f11372a).a((e.b) this).a((e.c) this).a();
        }
        this.m = new LocationRequest();
        this.m.a(10000);
        this.m.b(1000);
        this.m.a(100);
        net.one97.paytm.helper.a.b().a("/wallet/nearby", "", (Context) this);
    }

    private void c() {
        if (this.f70696h == null) {
            this.f70696h = (LinearLayout) findViewById(R.id.nearby_error_layout_id);
        }
        if (!d()) {
            this.f70696h.setVisibility(8);
            this.f70696h.setVisibility(8);
            if (this.q == null) {
                Bundle bundle = new Bundle();
                bundle.putInt("nearby_points", getIntent().getIntExtra("nearby_points", m.NEARBY_CASH_POINT.getIdentifier()));
                this.q = new a();
                this.q.setArguments(bundle);
            }
            if (this.j == null) {
                a((Fragment) this.q);
            }
            if (this.f70689a == null) {
                this.f70689a = new HashMap<>();
            }
        }
    }

    private boolean d() {
        b.a();
        if (!b.a(this.r)) {
            if (Double.compare(this.p[0], 0.0d) == 0 && Double.compare(this.p[1], 0.0d) == 0) {
                View inflate = this.w.inflate(R.layout.error_location_off_addmoney, (ViewGroup) null);
                this.f70696h.removeAllViews();
                this.f70696h.addView(inflate);
                this.f70696h.setVisibility(0);
                a(false);
                return true;
            }
            a(true);
            return false;
        } else if (com.paytm.utility.b.c((Context) this)) {
            return false;
        } else {
            View inflate2 = this.w.inflate(R.layout.error_location_off_addmoney, (ViewGroup) null);
            this.f70696h.removeAllViews();
            this.f70696h.addView(inflate2);
            this.f70696h.setVisibility(0);
            return true;
        }
    }

    private void a(boolean z) {
        if (this.k == null) {
            this.k = findViewById(R.id.nearby_no_location_banner);
        }
        if (this.f70694f == null) {
            this.f70694f = (TextView) findViewById(R.id.tv_turn_on_location);
        }
        this.f70694f.setVisibility(0);
        this.f70694f.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                NearByAddMoneyActivity.this.k.setVisibility(8);
                NearByAddMoneyActivity.this.openLocationSetting(view);
            }
        });
        if (!z || this.t || this.u) {
            this.k.setVisibility(8);
            return;
        }
        this.k.setVisibility(0);
        this.f70694f.setVisibility(0);
    }

    public void openLocationSetting(View view) {
        startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
    }

    private void b(String str) {
        this.f70692d = (Toolbar) findViewById(R.id.nearby_tool_bar);
        this.f70695g = (TextView) findViewById(R.id.toolbar_heading_toolbar);
        this.f70693e = (TextView) this.f70692d.findViewById(R.id.toolbar_heading_nearby_location);
        this.f70697i = (ImageView) this.f70692d.findViewById(R.id.header_back_button);
        this.f70697i.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                NearByAddMoneyActivity.this.handleBackpressed(view);
            }
        });
        this.f70693e.setText(str);
        this.f70695g.setText(str);
        this.f70697i.setOnClickListener(this);
        setSupportActionBar(this.f70692d);
    }

    public void onClick(View view) {
        if (view.getId() == R.id.header_back_button) {
            finish();
        }
    }

    public final ArrayList<PayTMPartnerListModal.Response> a(String str) {
        if (this.f70689a == null) {
            this.f70689a = new HashMap<>();
        }
        ArrayList<PayTMPartnerListModal.Response> arrayList = this.f70689a.get(str);
        return arrayList == null ? new ArrayList<>() : arrayList;
    }

    private void a(Fragment fragment) {
        try {
            q a2 = getSupportFragmentManager().a();
            a2.b(R.id.nearbywithoutfilterfragment, fragment, fragment.getClass().getSimpleName());
            a2.c();
            this.j = fragment;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void onBackPressed() {
        if (getSupportFragmentManager().f() > 0) {
            getSupportFragmentManager().d();
        } else {
            super.onBackPressed();
        }
    }

    public void onResume() {
        super.onResume();
        if (this.s) {
            b.a().a(this, this);
        }
        this.s = false;
        e();
    }

    public void onStart() {
        super.onStart();
        e eVar = this.l;
        if (eVar != null) {
            eVar.d();
            this.l.a((e.b) this);
        }
    }

    public void onStop() {
        super.onStop();
    }

    public void onDestroy() {
        super.onDestroy();
        e eVar = this.l;
        if (eVar != null) {
            eVar.e();
        }
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (i2 == 109) {
            HashMap hashMap = new HashMap();
            hashMap.put("app_permissions_and_status", "location=true");
            if (!(androidx.core.app.a.a((Context) this, "android.permission.ACCESS_FINE_LOCATION") == 0 || androidx.core.app.a.a((Context) this, "android.permission.ACCESS_COARSE_LOCATION") == 0)) {
                hashMap.put("app_permissions_and_status", "location=false");
            }
            net.one97.paytm.helper.a.b().a("app_permissions_provided", (Map<String, Object>) hashMap, getApplicationContext());
            if (iArr.length <= 0 || iArr[0] != 0) {
                Toast.makeText(getApplicationContext(), "Please go to setting and enable the location permission", 1).show();
                finish();
            } else {
                c();
            }
        }
        super.onRequestPermissionsResult(i2, strArr, iArr);
    }

    public void onConnected(Bundle bundle) {
        e();
    }

    public void onConnectionFailed(ConnectionResult connectionResult) {
        getClass().getSimpleName();
        new StringBuilder("onConnectionFailed: ConnectionResult.getErrorCode() = ").append(connectionResult.f8334b);
        Toast.makeText(this, "Could not connect to Google API Client: Error " + connectionResult.f8334b, 0).show();
    }

    public final void a(Location location) {
        if (location != null) {
            double[] dArr = {location.getLatitude(), location.getLongitude()};
            double d2 = dArr[0];
            double d3 = dArr[1];
            com.paytm.b.a.a a2 = h.a(getApplicationContext());
            a2.a("nearby_lat", (float) d2);
            a2.a("nearby_long", (float) d3);
            g();
            if (Double.compare(this.o[0], 0.0d) == 0 && Double.compare(this.o[1], 0.0d) == 0) {
                f();
            }
            this.o = dArr;
            LinearLayout linearLayout = this.f70696h;
            if (linearLayout != null && linearLayout.getVisibility() == 0) {
                if (com.paytm.utility.b.c((Context) this)) {
                    double[] dArr2 = new double[2];
                    if (androidx.core.app.a.a((Context) this, "android.permission.ACCESS_FINE_LOCATION") == 0) {
                        this.n = f.f11373b.a(this.l);
                        Location location2 = this.n;
                        if (location2 != null) {
                            double latitude = location2.getLatitude();
                            double longitude = this.n.getLongitude();
                            dArr2[0] = latitude;
                            dArr2[1] = longitude;
                            if (!(Double.compare(this.o[0], 0.0d) == 0 || Double.compare(this.o[1], 0.0d) == 0)) {
                                this.o = dArr2;
                                f();
                            }
                            this.o = dArr2;
                        }
                    }
                    if (!com.paytm.utility.b.c((Context) this)) {
                        Toast.makeText(this, getString(R.string.err_nonetwork_msg), 1).show();
                    } else {
                        this.f70696h.setVisibility(8);
                    }
                } else {
                    if (this.w == null) {
                        this.w = LayoutInflater.from(this);
                    }
                    View inflate = this.w.inflate(R.layout.error_location_off_addmoney, (ViewGroup) null);
                    this.f70696h.removeAllViews();
                    this.f70696h.addView(inflate);
                    this.f70696h.setVisibility(0);
                }
            }
        }
    }

    private void e() {
        e eVar = this.l;
        if (eVar != null && eVar.f()) {
            if (androidx.core.app.a.a((Context) this, "android.permission.ACCESS_FINE_LOCATION") == 0 || androidx.core.app.a.a((Context) this, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
                f.f11373b.a(this.l, this.m, this);
            }
        }
    }

    public final void a() {
        this.s = true;
    }

    public final double[] b() {
        double[] dArr = new double[2];
        String s2 = com.paytm.utility.b.s((Context) this);
        String t2 = com.paytm.utility.b.t((Context) this);
        if (TextUtils.isEmpty(s2) || TextUtils.isEmpty(t2)) {
            double[] dArr2 = this.o;
            if (dArr2 == null || Double.compare(dArr2[0], 0.0d) == 0 || Double.compare(this.o[1], 0.0d) == 0) {
                return this.p;
            }
            return this.o;
        }
        dArr[0] = Double.parseDouble(s2);
        dArr[1] = Double.parseDouble(t2);
        return dArr;
    }

    public final void a(g gVar) {
        this.f70691c.add(gVar);
    }

    private void f() {
        Iterator<g> it2 = this.f70691c.iterator();
        while (it2.hasNext()) {
            it2.next().a();
        }
    }

    /* renamed from: handleOKGotIt */
    public void a(View view) {
        findViewById(R.id.nearby_messagebanner).setVisibility(8);
        h.a(getApplicationContext()).a("isNearbyTutorialMessageDone", 1, true);
    }

    public void handleBackpressed(View view) {
        finish();
    }

    private void g() {
        com.paytm.b.a.a a2 = h.a(getApplicationContext());
        this.p[0] = (double) a2.a("nearby_lat");
        this.p[1] = (double) a2.a("nearby_long");
    }
}
