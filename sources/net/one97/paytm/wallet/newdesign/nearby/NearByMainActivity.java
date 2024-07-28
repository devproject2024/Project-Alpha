package net.one97.paytm.wallet.newdesign.nearby;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.q;
import com.google.android.gms.location.LocationResult;
import com.paytm.network.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.common.utility.k;
import net.one97.paytm.wallet.newdesign.R;
import net.one97.paytm.wallet.newdesign.nearby.b;
import net.one97.paytm.wallet.newdesign.nearby.b.c;
import net.one97.paytm.wallet.newdesign.nearby.b.f;
import net.one97.paytm.wallet.newdesign.nearby.c.a;
import net.one97.paytm.wallet.newdesign.nearby.datamodals.NearbyCategorySubCategoryModal;
import net.one97.paytm.wallet.newdesign.nearby.datamodals.NearbyOffersBannerModal;
import net.one97.paytm.wallet.newdesign.nearby.datamodals.PayTMPartnerListModal;
import net.one97.paytm.wallet.newdesign.nearby.helper.a;
import net.one97.paytm.wallet.newdesign.nearby.helper.c;
import net.one97.paytm.wallet.newdesign.nearby.helper.d;

public class NearByMainActivity extends PaytmActivity implements View.OnClickListener, k, b.a, c.b, f.a, net.one97.paytm.wallet.newdesign.widget.b {

    /* renamed from: a  reason: collision with root package name */
    public double[] f70990a = new double[2];

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, ArrayList<PayTMPartnerListModal.Response>> f70991b;

    /* renamed from: c  reason: collision with root package name */
    public LocationManager f70992c;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<NearbyCategorySubCategoryModal.CategoryDetail> f70993d;

    /* renamed from: e  reason: collision with root package name */
    private int f70994e = -1;

    /* renamed from: f  reason: collision with root package name */
    private final int f70995f = 1;

    /* renamed from: g  reason: collision with root package name */
    private final int f70996g = 2;

    /* renamed from: h  reason: collision with root package name */
    private final int f70997h = 3;

    /* renamed from: i  reason: collision with root package name */
    private TextView f70998i;
    private LinearLayout j;
    private Fragment k;
    private View l;
    private ConstraintLayout m;
    private double[] n = new double[2];
    private f o;
    private boolean p = false;
    private boolean q = false;
    private boolean r = false;
    private LayoutInflater s;
    private boolean t = false;
    private net.one97.paytm.wallet.newdesign.nearby.helper.b u;
    private boolean v;
    private Vector<net.one97.paytm.wallet.newdesign.widget.c> w = new Vector<>();
    private Vector<Object> x = new Vector<>();

    public void onLocationSearchClick(View view) {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        boolean z = false;
        if (!(getIntent() == null || getIntent().getExtras() == null || !getIntent().getExtras().containsKey("isForFastTag"))) {
            this.v = getIntent().getExtras().getBoolean("isForFastTag", false);
        }
        String string = getString(R.string.nearby_heading);
        this.f70992c = (LocationManager) getSystemService("location");
        this.s = LayoutInflater.from(this);
        setContentView(R.layout.nb_activity_nearby_main);
        ((TextView) findViewById(R.id.toolbar_heading_toolbar)).setText(getString(this.v ? R.string.nearby_heading_name_fastag : R.string.nearby_heading_name));
        this.m = (ConstraintLayout) findViewById(R.id.parent_lyt);
        this.j = (LinearLayout) findViewById(R.id.nearby_error_layout_id);
        this.j.setVisibility(8);
        Toolbar toolbar = (Toolbar) findViewById(R.id.nearby_tool_bar);
        toolbar.setVisibility(8);
        ((TextView) toolbar.findViewById(R.id.toolbar_heading_nearby_location)).setText(string);
        ((ImageView) toolbar.findViewById(R.id.header_back_button)).setOnClickListener(this);
        if (Integer.valueOf(a.a(getApplicationContext()).b("isNearbyTutorialMessageDone", 0, true)).intValue() <= 0) {
            z = true;
        }
        this.q = z;
        this.u = new net.one97.paytm.wallet.newdesign.nearby.helper.b(this, this, bundle);
        d.a aVar = d.f71130b;
        d.a.b().a("/wallet/nearby", "", (Context) this);
        ((ConstraintLayout) findViewById(R.id.parent_lyt)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                NearByMainActivity.this.d(view);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d(View view) {
        try {
            d.a aVar = d.f71130b;
            Intent intent = new Intent(this, Class.forName(d.a.b().a()));
            c.a aVar2 = net.one97.paytm.wallet.newdesign.nearby.helper.c.f71128a;
            if (c.a.a() != null) {
                c.a aVar3 = net.one97.paytm.wallet.newdesign.nearby.helper.c.f71128a;
                c.a.a();
                String a2 = net.one97.paytm.wallet.newdesign.nearby.helper.c.a("withoutAadhaarKnowMoreUrl");
                if (!TextUtils.isEmpty(a2)) {
                    intent.putExtra("url", a2);
                }
            }
            intent.putExtra("title", getString(R.string.terms_amp_conditions));
            startActivity(intent);
        } catch (ClassNotFoundException unused) {
        }
    }

    public void attachBaseContext(Context context) {
        d.a aVar = d.f71130b;
        super.attachBaseContext(d.a.a().f71132a.a(context));
    }

    private void j() {
        int i2 = 8;
        this.j.setVisibility(8);
        if (this.o == null) {
            this.o = new f();
            Bundle bundle = new Bundle();
            bundle.putBoolean("isForFastTag", this.v);
            this.o.setArguments(bundle);
        }
        Fragment fragment = this.k;
        if (fragment == null) {
            f fVar = this.o;
            if (fragment == null || fVar == null || fVar != fragment) {
                try {
                    q a2 = getSupportFragmentManager().a();
                    a2.b(R.id.nearbywithoutfilterfragment, fVar, fVar.getClass().getSimpleName());
                    a2.c();
                    this.k = fVar;
                } catch (Exception unused) {
                }
            }
        }
        if (this.f70991b == null) {
            this.f70991b = new HashMap<>();
        }
        ConstraintLayout constraintLayout = this.m;
        if (!this.v) {
            i2 = 0;
        }
        constraintLayout.setVisibility(i2);
    }

    public final boolean f() {
        b.a();
        if (!b.a(this.f70992c)) {
            if (Double.compare(this.n[0], 0.0d) == 0 && Double.compare(this.n[1], 0.0d) == 0) {
                View inflate = this.s.inflate(R.layout.nb_error_location_off, (ViewGroup) null);
                this.j.removeAllViews();
                this.j.addView(inflate);
                this.j.setVisibility(0);
                a(false);
                return true;
            }
            a(true);
            return false;
        } else if (com.paytm.utility.b.c((Context) this)) {
            return false;
        } else {
            View inflate2 = this.s.inflate(R.layout.nb_error_network_off, (ViewGroup) null);
            this.j.removeAllViews();
            this.j.addView(inflate2);
            this.j.setVisibility(0);
            return true;
        }
    }

    private void a(boolean z) {
        if (this.l == null) {
            this.l = findViewById(R.id.nearby_no_location_banner);
        }
        if (this.f70998i == null) {
            this.f70998i = (TextView) findViewById(R.id.tv_turn_on_location);
        }
        this.f70998i.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                NearByMainActivity.this.c(view);
            }
        });
        int i2 = 0;
        if (!z || this.q || this.r) {
            ConstraintLayout constraintLayout = this.m;
            if (this.v) {
                i2 = 8;
            }
            constraintLayout.setVisibility(i2);
            this.l.setVisibility(8);
            return;
        }
        this.l.setVisibility(0);
        this.m.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        int i2 = 8;
        this.l.setVisibility(8);
        ConstraintLayout constraintLayout = this.m;
        if (!this.v) {
            i2 = 0;
        }
        constraintLayout.setVisibility(i2);
        openLocationSetting(view);
    }

    public void openLocationSetting(View view) {
        startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
    }

    public void onClick(View view) {
        if (view.getId() == R.id.iv_back_button) {
            finish();
        }
    }

    public final void a(ArrayList<PayTMPartnerListModal.Response> arrayList, String str) {
        if (arrayList != null && arrayList.size() != 0 && !TextUtils.isEmpty(str)) {
            if (this.f70991b == null) {
                this.f70991b = new HashMap<>();
            }
            ArrayList<PayTMPartnerListModal.Response> a2 = a(str);
            a2.addAll(arrayList);
            this.f70991b.put(str, a2);
        }
    }

    public final ArrayList<PayTMPartnerListModal.Response> a(String str) {
        if (this.f70991b == null) {
            this.f70991b = new HashMap<>();
        }
        ArrayList<PayTMPartnerListModal.Response> arrayList = this.f70991b.get(str);
        return arrayList == null ? new ArrayList<>() : arrayList;
    }

    public final void a(Fragment fragment) {
        try {
            if (!isFinishing()) {
                q a2 = getSupportFragmentManager().a();
                if (this.k != null) {
                    a2.a(this.k);
                }
                this.r = true;
                a2.b(R.id.nearbywithoutfilterfragment, fragment, fragment.getClass().getSimpleName());
                a2.a("category");
                a2.c();
                this.k = fragment;
            }
        } catch (Exception unused) {
        }
    }

    public void onBackPressed() {
        if (getSupportFragmentManager().f() > 0) {
            getSupportFragmentManager().d();
        } else {
            super.onBackPressed();
        }
    }

    public final void g() {
        this.p = true;
    }

    public final double[] h() {
        double[] dArr = new double[2];
        String s2 = com.paytm.utility.b.s((Context) this);
        String t2 = com.paytm.utility.b.t((Context) this);
        if (TextUtils.isEmpty(s2) || TextUtils.isEmpty(t2)) {
            double[] dArr2 = this.f70990a;
            if (dArr2 == null || Double.compare(dArr2[0], 0.0d) == 0 || Double.compare(this.f70990a[1], 0.0d) == 0) {
                return this.n;
            }
            return this.f70990a;
        }
        dArr[0] = Double.parseDouble(s2);
        dArr[1] = Double.parseDouble(t2);
        return dArr;
    }

    public final void a(net.one97.paytm.wallet.newdesign.widget.c cVar) {
        this.w.add(cVar);
    }

    public final void b(net.one97.paytm.wallet.newdesign.widget.c cVar) {
        this.w.remove(cVar);
    }

    private void k() {
        Iterator<net.one97.paytm.wallet.newdesign.widget.c> it2 = this.w.iterator();
        while (it2.hasNext()) {
            it2.next().a();
        }
    }

    public final void a(int i2, ArrayList<NearbyCategorySubCategoryModal.CategoryDetail> arrayList) {
        this.f70993d = arrayList;
        Bundle bundle = new Bundle();
        bundle.putInt("SELECTED_CATEGORY_INDEX", i2);
        net.one97.paytm.wallet.newdesign.nearby.b.d dVar = new net.one97.paytm.wallet.newdesign.nearby.b.d();
        dVar.setArguments(bundle);
        a((Fragment) dVar);
    }

    public final void i() {
        if (!this.t) {
            findViewById(R.id.error_service_not_available_tv).setVisibility(0);
            this.t = true;
            new Handler().postDelayed(new Runnable() {
                public final void run() {
                    NearByMainActivity.this.l();
                }
            }, 2500);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void l() {
        if (!isFinishing()) {
            findViewById(R.id.error_service_not_available_tv).setVisibility(8);
        }
        this.t = false;
    }

    public void handleOKGotIt(View view) {
        view.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                NearByMainActivity.this.b(view);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        a.a(getApplicationContext()).a("isNearbyTutorialMessageDone", 1, true);
    }

    public final void b(String str) {
        String str2;
        if (!f()) {
            List<Fragment> d2 = getSupportFragmentManager().f3424a.d();
            if (d2 != null || d2.size() <= 0) {
                this.k = d2.get(0);
                Fragment fragment = this.k;
                if (fragment != null && (fragment instanceof f)) {
                    f fVar = (f) fragment;
                    if (fVar.getActivity() != null && !fVar.getActivity().isFinishing() && fVar.f71101d) {
                        if (fVar.f71099b != null) {
                            str2 = fVar.f71099b.getDefaultUrl();
                            int size = fVar.f71099b.getResponse().size();
                            int i2 = 0;
                            while (true) {
                                if (i2 >= size) {
                                    break;
                                }
                                String city = fVar.f71099b.getResponse().get(i2).getCity();
                                if (!TextUtils.isEmpty(city) && city.equalsIgnoreCase(str)) {
                                    str2 = fVar.f71099b.getResponse().get(i2).getUrl();
                                    break;
                                }
                                i2++;
                            }
                        } else {
                            str2 = "";
                        }
                        if (fVar.f71098a != null && fVar.f71098a.getHomepageLayout() != null && fVar.f71098a.getHomepageLayout().size() > 0) {
                            fVar.a(fVar.f71098a.getHomepageLayout().get(0).getItems());
                            fVar.f71100c.setVisibility(0);
                        } else if (!TextUtils.isEmpty(str2)) {
                            a.C1440a aVar = net.one97.paytm.wallet.newdesign.nearby.helper.a.f71113a;
                            com.paytm.network.b a2 = a.C1440a.a();
                            a2.f42877a = fVar.getActivity();
                            a2.f42879c = a.C0715a.GET;
                            a.C1440a aVar2 = net.one97.paytm.wallet.newdesign.nearby.helper.a.f71113a;
                            FragmentActivity activity = fVar.getActivity();
                            kotlin.g.b.k.c(activity, "context");
                            HashMap hashMap = new HashMap();
                            hashMap.put("Content-Type", "application/json");
                            hashMap.put("Accept", "application/json");
                            hashMap.put("client_id", com.paytm.utility.b.k());
                            hashMap.put("client_secret", com.paytm.utility.b.l());
                            hashMap.put("session_token", com.paytm.utility.a.q(activity));
                            hashMap.put("Authorization", com.paytm.utility.b.m());
                            if (com.paytm.utility.d.b(activity) != null) {
                                String b2 = com.paytm.utility.d.b(activity);
                                kotlin.g.b.k.a((Object) b2, "CJRNetUtility.getCartID(context)");
                                hashMap.put("cart_id", b2);
                            }
                            a2.f42882f = hashMap;
                            a2.f42885i = new NearbyOffersBannerModal();
                            a2.f42880d = str2;
                            a2.o = f.class.getName();
                            a2.n = a.b.USER_FACING;
                            a2.j = fVar;
                            com.paytm.network.a l2 = a2.l();
                            if (com.paytm.utility.b.c(fVar.getContext())) {
                                l2.a();
                            }
                        }
                    }
                }
            }
        }
    }

    public void handleBackpressed(View view) {
        finish();
    }

    public void onResume() {
        super.onResume();
        if (this.p) {
            b.a();
            b.a((Context) this, (b.a) this);
        }
        this.p = false;
        net.one97.paytm.wallet.newdesign.nearby.helper.b bVar = this.u;
        if (!bVar.f71117a) {
            return;
        }
        if (!bVar.f71119c || bVar.a()) {
            if (bVar.b()) {
                bVar.e();
            } else if (!bVar.b()) {
                if (androidx.core.app.a.a((Activity) bVar.f71121e, "android.permission.ACCESS_FINE_LOCATION")) {
                    bVar.f71122f.a();
                } else if (bVar.f71118b) {
                    bVar.f71122f.c();
                } else {
                    bVar.c();
                }
            }
            bVar.f71119c = false;
            return;
        }
        bVar.f();
        bVar.f71122f.d();
    }

    public void onStop() {
        super.onStop();
        this.u.d();
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        net.one97.paytm.wallet.newdesign.nearby.helper.b bVar = this.u;
        if (i2 == 1) {
            if (i3 == -1) {
                bVar.e();
            } else if (i3 == 0) {
                bVar.f();
                bVar.f71119c = true;
            }
        }
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        net.one97.paytm.wallet.newdesign.nearby.helper.b bVar = this.u;
        kotlin.g.b.k.c(strArr, "permissions");
        kotlin.g.b.k.c(iArr, "grantResults");
        if (i2 == 34) {
            if (!(iArr.length == 0)) {
                if (iArr[0] == 0) {
                    bVar.f71118b = false;
                    bVar.f71117a = true;
                    bVar.f71120d = true;
                    bVar.e();
                } else if (androidx.core.app.a.a((Activity) bVar.f71121e, "android.permission.ACCESS_FINE_LOCATION")) {
                    bVar.f71122f.a();
                } else {
                    bVar.f71118b = true;
                }
            }
        }
        super.onRequestPermissionsResult(i2, strArr, iArr);
    }

    public final void b() {
        finish();
    }

    public final void a() {
        this.f70994e = 3;
        c("Allow Permissions");
    }

    public final void c() {
        this.f70994e = 2;
        c("Take me to settings");
    }

    public final void d() {
        c("Enable GPS");
        this.f70994e = 1;
    }

    private void c(String str) {
        View inflate = this.s.inflate(R.layout.nb_error_location_off, (ViewGroup) null);
        this.j.removeAllViews();
        this.j.addView(inflate);
        this.j.setVisibility(0);
        this.m.setVisibility(8);
        Button button = (Button) findViewById(R.id.btn_locationsetting);
        button.setText(str);
        button.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                NearByMainActivity.this.a(view);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        int i2 = this.f70994e;
        if (i2 == 1) {
            net.one97.paytm.wallet.newdesign.nearby.helper.b bVar = this.u;
            bVar.f71119c = true;
            bVar.f71121e.startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
        } else if (i2 == 2) {
            net.one97.paytm.wallet.newdesign.nearby.helper.b bVar2 = this.u;
            AppCompatActivity appCompatActivity = bVar2.f71121e;
            Intent intent = new Intent();
            intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts("package", bVar2.f71121e.getPackageName(), (String) null));
            appCompatActivity.startActivity(intent);
        } else if (i2 == 3) {
            this.u.c();
        }
    }

    public final void e() {
        j();
    }

    public final void a(LocationResult locationResult) {
        Location location = (locationResult == null || locationResult.f11350b.isEmpty()) ? null : new Location(locationResult.f11350b.get(locationResult.f11350b.size() - 1));
        if (location != null) {
            j();
            double[] dArr = {location.getLatitude(), location.getLongitude()};
            double d2 = dArr[0];
            double d3 = dArr[1];
            com.paytm.b.a.a a2 = net.one97.paytm.wallet.newdesign.nearby.c.a.a(getApplicationContext());
            a2.a("nearby_lat", (float) d2);
            a2.a("nearby_long", (float) d3);
            com.paytm.b.a.a a3 = net.one97.paytm.wallet.newdesign.nearby.c.a.a(getApplicationContext());
            this.n[0] = (double) a3.a("nearby_lat");
            this.n[1] = (double) a3.a("nearby_long");
            this.f70990a = dArr;
            k();
            net.one97.paytm.wallet.newdesign.nearby.helper.b bVar = this.u;
            if (bVar.f71117a) {
                bVar.d();
                bVar.f71117a = false;
            }
        }
    }
}
