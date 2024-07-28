package net.one97.paytm.o2o.movies.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.e;
import com.google.android.gms.location.f;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import com.paytm.utility.s;
import com.paytm.utility.v;
import io.reactivex.rxjava3.a.y;
import io.reactivex.rxjava3.d.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import net.one97.paytm.common.entity.CJRSelectCitiesModel;
import net.one97.paytm.common.entity.CJRSelectCityModel;
import net.one97.paytm.common.entity.recharge.v2.CJRUtilityLocationModel;
import net.one97.paytm.common.views.ShimmerFrameLayout;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.adapter.ae;
import net.one97.paytm.o2o.movies.adapter.af;
import net.one97.paytm.o2o.movies.adapter.bc;
import net.one97.paytm.o2o.movies.common.c;
import net.one97.paytm.o2o.movies.common.d;
import net.one97.paytm.o2o.movies.entity.CJRCitiesResponse;
import net.one97.paytm.o2o.movies.utils.h;
import net.one97.paytm.o2o.movies.utils.n;
import org.json.JSONException;
import org.json.JSONObject;

public class AJRMoviesSelectCityActivity extends AppBaseActivity implements TextWatcher, e.b, e.c, b, ae.b, ae.d, af.a, c.b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f74059a = AJRMoviesSelectCityActivity.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private LinearLayout f74060b;

    /* renamed from: c  reason: collision with root package name */
    private LinearLayout f74061c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f74062d;

    /* renamed from: e  reason: collision with root package name */
    private e f74063e;

    /* renamed from: f  reason: collision with root package name */
    private String f74064f;

    /* renamed from: g  reason: collision with root package name */
    private EditText f74065g;

    /* renamed from: h  reason: collision with root package name */
    private ArrayList<CJRSelectCityModel> f74066h;

    /* renamed from: i  reason: collision with root package name */
    private c f74067i;
    private String j = null;
    private RecyclerView k;
    private RecyclerView l;
    private ArrayList<CJRSelectCityModel> m;
    private ae n;
    private String o;
    private String p;
    private FrameLayout q;
    private ShimmerFrameLayout r;
    private String s = "NA";
    private List<CJRSelectCityModel> t = new ArrayList();
    private ProgressBar u;
    private io.reactivex.rxjava3.b.c v;

    public void afterTextChanged(Editable editable) {
    }

    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    public void onConnected(Bundle bundle) {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.movies_city_selection);
        try {
            this.f74064f = null;
            if (getIntent() != null) {
                if (getIntent().hasExtra("usercurrentcity")) {
                    this.f74064f = getIntent().getStringExtra("usercurrentcity");
                }
                if (getIntent().hasExtra("sourcename")) {
                    this.o = getIntent().getStringExtra("sourcename");
                }
                if (getIntent().hasExtra("previousScreen")) {
                    this.p = getIntent().getStringExtra("previousScreen");
                }
            }
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
        if (com.paytm.utility.b.O((Context) this) && com.paytm.utility.b.P((Context) this)) {
            try {
                this.f74063e = new e.a(this).a((e.b) this).a((e.c) this).a((a<? extends a.d.C0127d>) f.f11372a).a();
                this.f74067i = new c(this, this, this.f74063e, this);
            } catch (Exception e3) {
                q.b(e3.getMessage());
            }
        }
        try {
            int g2 = com.paytm.utility.b.g((Context) this);
            this.q = (FrameLayout) findViewById(R.id.select_city_progress_bar);
            this.u = (ProgressBar) findViewById(R.id.select_city_progress);
            this.r = (ShimmerFrameLayout) findViewById(R.id.shimmer_movie_city_selection);
            ((LinearLayout) findViewById(R.id.pick_location_lyt)).setPadding(g2 + (g2 / 2), 0, 0, 0);
            this.k = (RecyclerView) findViewById(R.id.parent_recycler_view);
            this.l = (RecyclerView) findViewById(R.id.search_result_recycler_view);
            this.f74060b = (LinearLayout) findViewById(R.id.no_suggestion_lyt);
            this.f74061c = (LinearLayout) findViewById(R.id.layout_current_location);
            this.f74062d = (TextView) findViewById(R.id.error_text_quote);
            this.f74065g = (EditText) findViewById(R.id.search_city_edt_txt);
            this.f74062d = (TextView) findViewById(R.id.error_text_quote);
            this.f74065g.addTextChangedListener(this);
            this.k.setOnTouchListener($$Lambda$AJRMoviesSelectCityActivity$mReKPLEr1zbB9Ah4lBswsDsDb20.INSTANCE);
            this.l.setOnTouchListener($$Lambda$AJRMoviesSelectCityActivity$kPk6w7OKOFsydxVZY2GgArzo4bs.INSTANCE);
            int f2 = com.paytm.utility.b.f((Context) this);
            this.f74060b.setPadding(f2, 0, f2, 0);
            this.f74061c.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    AJRMoviesSelectCityActivity.this.b(view);
                }
            });
            ((AppCompatImageView) findViewById(R.id.back_arrow)).setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    AJRMoviesSelectCityActivity.this.a(view);
                }
            });
        } catch (Exception e4) {
            q.b(e4.getMessage());
        }
        b(this.o);
        String str = this.o;
        if (str == null || !str.equals("moviepass")) {
            this.f74061c.setVisibility(0);
            this.f74065g.setVisibility(0);
            return;
        }
        this.f74061c.setVisibility(8);
        this.f74065g.setVisibility(8);
    }

    private void b(String str) {
        i();
        if (!TextUtils.isEmpty(str)) {
            char c2 = 65535;
            if (str.hashCode() == 1188399937 && str.equals("moviepass")) {
                c2 = 0;
            }
            if (c2 == 0) {
                this.f74066h = n.e();
            } else if ("onepager".equals(this.p)) {
                this.f74066h = n.f();
            } else {
                this.f74066h = n.g();
            }
            if (this.f74066h != null) {
                h();
            } else {
                c(str);
            }
        } else {
            Intent intent = new Intent();
            intent.putExtra("status", "FAILED");
            intent.putExtra("alert_message", "urls type is null");
            setResult(0, intent);
        }
    }

    private void c(String str) {
        String str2;
        if (((str.hashCode() == 1188399937 && str.equals("moviepass")) ? (char) 0 : 65535) != 0) {
            net.one97.paytm.o2o.movies.common.b.c.a();
            str2 = net.one97.paytm.o2o.movies.common.b.c.a("movieCityListV3", (String) null);
        } else {
            net.one97.paytm.o2o.movies.common.b.c.a();
            str2 = net.one97.paytm.o2o.movies.common.b.c.a("movie_pass_cities_list_url", (String) null);
        }
        a(str2, str);
    }

    private void a(String str, String str2) {
        try {
            if (!com.paytm.utility.b.c((Context) this)) {
                g();
            } else if (!URLUtil.isValidUrl(str)) {
                g();
            } else {
                if (com.paytm.utility.b.r((Context) this)) {
                    str = (str + "?customer_id=" + com.paytm.utility.b.n((Context) this)) + "&UserId=" + com.paytm.utility.b.n((Context) this);
                }
                HashMap hashMap = new HashMap();
                hashMap.put("Content-Type", "application/json");
                hashMap.put("ClientId", "paytm");
                hashMap.put("ACCEPTED-LANGUAGE", com.paytm.utility.n.a((Context) this, com.paytm.utility.n.a()));
                net.one97.paytm.o2o.movies.utils.c cVar = new net.one97.paytm.o2o.movies.utils.c();
                cVar.f42877a = this;
                cVar.f42878b = a.c.MOVIES;
                cVar.f42879c = a.C0715a.GET;
                cVar.f42880d = com.paytm.utility.b.s(this, str) + "&lang=" + com.paytm.utility.b.a((Context) this) + "-IN";
                cVar.f42881e = null;
                cVar.f42882f = hashMap;
                cVar.f42883g = null;
                cVar.f42884h = null;
                cVar.f42885i = "moviepass".equals(str2) ? new CJRSelectCitiesModel() : new CJRCitiesResponse();
                cVar.j = this;
                cVar.n = a.b.USER_FACING;
                cVar.o = "movies";
                cVar.t = j();
                com.paytm.network.a l2 = cVar.l();
                l2.f42860d = false;
                l2.f42859c = false;
                l2.a();
                d();
            }
        } catch (Exception unused) {
        }
    }

    private void d() {
        FrameLayout frameLayout = this.q;
        if (frameLayout != null) {
            frameLayout.setVisibility(0);
            try {
                this.r.a();
            } catch (Exception unused) {
            }
        }
    }

    public final void a() {
        FrameLayout frameLayout = this.q;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
            try {
                this.r.b();
            } catch (Exception unused) {
            }
        }
    }

    private void e() {
        ProgressBar progressBar = this.u;
        if (progressBar != null) {
            progressBar.setVisibility(0);
        }
    }

    public final void b() {
        ProgressBar progressBar = this.u;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean b(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0 && action != 2) {
            return false;
        }
        n.b(view);
        return false;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean a(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0 && action != 2) {
            return false;
        }
        n.b(view);
        return false;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        c cVar;
        this.s = "type = Current Location";
        if (!com.paytm.utility.b.c((Context) this) || (cVar = this.f74067i) == null) {
            a();
            b();
            g();
            return;
        }
        cVar.b();
        n.b(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        Intent intent = new Intent();
        d("");
        setResult(-1, intent);
        finish();
        overridePendingTransition(17432576, net.one97.paytm.common.assets.R.anim.slide_out_right);
    }

    public final void a(CJRSelectCityModel cJRSelectCityModel) {
        a();
        b();
        Intent intent = new Intent();
        intent.putExtra("userselectedcity", cJRSelectCityModel);
        n.b((View) this.f74060b);
        d(cJRSelectCityModel.getValue());
        d.a((Context) this, cJRSelectCityModel.getValue(), this.o);
        d.d(this);
        setResult(-1, intent);
        finish();
        overridePendingTransition(17432576, net.one97.paytm.common.assets.R.anim.slide_out_right);
    }

    private void f() {
        bc bcVar;
        if ("moviepass".equalsIgnoreCase(this.o)) {
            bcVar = new bc(this, this.m, this.f74066h, this.f74064f, this.o, (List<CJRSelectCityModel>) null);
        } else {
            bcVar = new bc(this, this.m, (ArrayList<CJRSelectCityModel>) null, this.f74064f, this.o, this.t);
        }
        this.k.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.k.setAdapter(bcVar);
        this.n = new ae(this, this, this, this.f74066h, this.f74064f, this.o);
        this.l.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.l.setAdapter(this.n);
        a();
        b();
    }

    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        try {
            this.f74062d.setText(getString(R.string.movies_err_msg, new Object[]{" '" + charSequence + "'"}));
            if (this.n != null) {
                this.n.getFilter().filter(charSequence);
            }
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
    }

    public final void a(boolean z, boolean z2) {
        if (z) {
            this.f74060b.setVisibility(0);
            this.k.setVisibility(8);
            this.l.setVisibility(8);
            return;
        }
        if (z2) {
            this.k.setVisibility(0);
            this.l.setVisibility(8);
        } else {
            this.k.setVisibility(8);
            this.l.setVisibility(0);
        }
        this.f74060b.setVisibility(8);
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        c cVar;
        e();
        if (i2 == 57) {
            if (!s.a(iArr) || (cVar = this.f74067i) == null) {
                a();
                b();
                Toast.makeText(this, "Please provide Location permission to use this feature.", 1).show();
            } else {
                cVar.b();
            }
        }
        super.onRequestPermissionsResult(i2, strArr, iArr);
    }

    public void onStart() {
        super.onStart();
        try {
            if (this.f74063e != null) {
                this.f74063e.d();
            }
            net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.handlePlayServicesError(this);
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
    }

    public void onPause() {
        super.onPause();
    }

    public void onStop() {
        super.onStop();
        try {
            if (this.f74063e != null && this.f74063e.f()) {
                this.f74063e.e();
            }
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
    }

    public final boolean c() {
        a();
        b();
        return true;
    }

    public final void a(CJRUtilityLocationModel cJRUtilityLocationModel) {
        if (cJRUtilityLocationModel == null) {
            a();
            b();
            com.paytm.utility.b.b((Context) this, "", getResources().getString(R.string.no_gps) + " " + getResources().getString(R.string.recharge_retry_bill_payment));
        } else if (!TextUtils.isEmpty(cJRUtilityLocationModel.getCity())) {
            this.j = cJRUtilityLocationModel.getCity();
            CJRSelectCityModel cJRSelectCityModel = new CJRSelectCityModel();
            cJRSelectCityModel.setlabel(cJRUtilityLocationModel.getCity());
            cJRSelectCityModel.setValue(cJRUtilityLocationModel.getCity());
            cJRSelectCityModel.setLongitude(cJRUtilityLocationModel.getLongitude());
            cJRSelectCityModel.setLatitude(cJRUtilityLocationModel.getLatitude());
            ArrayList<CJRSelectCityModel> arrayList = this.f74066h;
            if (arrayList != null) {
                Iterator<CJRSelectCityModel> it2 = arrayList.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        CJRSelectCityModel next = it2.next();
                        if (next != null && next.getmSeachKeys() != null && next.getmSeachKeys().contains(this.j)) {
                            cJRSelectCityModel.setValue(next.getValue());
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            String value = cJRSelectCityModel.getValue();
            try {
                HashMap hashMap = new HashMap();
                hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/events");
                hashMap.put("event_user_id", com.paytm.utility.b.n((Context) this));
                hashMap.put(net.one97.paytm.common.utility.d.at, value);
                net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.sendCustomEventWithMap(net.one97.paytm.common.utility.d.as, hashMap, this);
            } catch (Exception e2) {
                q.b(e2.getMessage());
            }
            a(cJRSelectCityModel);
        }
    }

    public void onConnectionSuspended(int i2) {
        try {
            if (this.f74063e != null) {
                this.f74063e.d();
            }
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
    }

    public void onConnectionFailed(ConnectionResult connectionResult) {
        c cVar = this.f74067i;
        if (cVar != null) {
            cVar.a();
        }
    }

    private void g() {
        if (!isFinishing()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(getResources().getString(net.one97.paytm.common.assets.R.string.no_connection));
            builder.setMessage(getResources().getString(net.one97.paytm.common.assets.R.string.no_internet));
            builder.setPositiveButton(getResources().getString(net.one97.paytm.common.assets.R.string.network_retry_yes), new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AJRMoviesSelectCityActivity.this.a(dialogInterface, i2);
                }
            });
            builder.show();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(DialogInterface dialogInterface, int i2) {
        dialogInterface.cancel();
        if (!com.paytm.utility.b.c((Context) this) || this.f74067i == null) {
            g();
            return;
        }
        d();
        b(this.o);
    }

    public final void a(String str) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/events");
            hashMap.put("event_user_id", com.paytm.utility.b.n((Context) this));
            hashMap.put(net.one97.paytm.common.utility.d.at, str);
            net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.sendCustomEventWithMap(net.one97.paytm.common.utility.d.ar, hashMap, this);
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 115) {
            if (i3 == -1) {
                e();
                c cVar = this.f74067i;
                if (cVar != null) {
                    cVar.a();
                }
            } else if (i3 == 0) {
                a();
                b();
            }
        }
    }

    public final void b(CJRSelectCityModel cJRSelectCityModel) {
        if (cJRSelectCityModel != null) {
            this.s = "type = Top Cities";
            a(cJRSelectCityModel.getValue());
            a(cJRSelectCityModel);
        }
    }

    private void h() {
        io.reactivex.rxjava3.b.c cVar = this.v;
        if (cVar != null) {
            cVar.dispose();
            this.v = null;
        }
        this.v = y.a(new Callable() {
            public final Object call() {
                return AJRMoviesSelectCityActivity.this.k();
            }
        }).b(io.reactivex.rxjava3.i.a.b()).a(io.reactivex.rxjava3.android.b.a.a()).a(new g() {
            public final void accept(Object obj) {
                AJRMoviesSelectCityActivity.this.a((Boolean) obj);
            }
        }, (g<? super Throwable>) new g() {
            public final void accept(Object obj) {
                AJRMoviesSelectCityActivity.this.a((Throwable) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Boolean k() throws Exception {
        if (this.m == null) {
            List<String> a2 = d.a(d.b(this, this.o));
            ArrayList<CJRSelectCityModel> arrayList = this.f74066h;
            if (arrayList != null && arrayList.size() > 0) {
                this.m = new ArrayList<>();
                Iterator<CJRSelectCityModel> it2 = this.f74066h.iterator();
                while (it2.hasNext()) {
                    CJRSelectCityModel next = it2.next();
                    next.setHeaderShown(false);
                    if (next.isTopCity()) {
                        CJRSelectCityModel cJRSelectCityModel = new CJRSelectCityModel();
                        cJRSelectCityModel.setmCityImageUrl(next.getmCityImageUrl());
                        cJRSelectCityModel.setlabel(next.getLabel());
                        cJRSelectCityModel.setValue(next.getValue());
                        cJRSelectCityModel.setIsTopCity(next.isTopCity());
                        cJRSelectCityModel.setLatitude(next.getLatitude());
                        cJRSelectCityModel.setLongitude(next.getLongitude());
                        cJRSelectCityModel.setEventPresent(next.isEventPresent());
                        this.m.add(cJRSelectCityModel);
                    }
                    String str = this.o;
                    if (str != null && !str.equals("moviepass") && a2 != null && a2.contains(next.getValue())) {
                        this.t.add(next);
                    }
                }
                h hVar = h.f75928a;
                this.t = h.a((List<? extends CJRSelectCityModel>) this.t, a2);
            }
        }
        return Boolean.TRUE;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(Boolean bool) throws Throwable {
        f();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(Throwable th) throws Throwable {
        f();
    }

    public void onDestroy() {
        super.onDestroy();
        io.reactivex.rxjava3.b.c cVar = this.v;
        if (cVar != null) {
            cVar.dispose();
            this.v = null;
        }
    }

    public final void c(CJRSelectCityModel cJRSelectCityModel) {
        if (cJRSelectCityModel != null) {
            this.s = "type = Search";
            a(cJRSelectCityModel.getValue());
            a(cJRSelectCityModel);
        }
    }

    private void d(String str) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, net.one97.paytm.o2o.movies.common.b.b.R);
            hashMap.put(net.one97.paytm.o2o.movies.common.b.b.f75007b, net.one97.paytm.o2o.movies.common.b.b.w);
            hashMap.put(net.one97.paytm.o2o.movies.common.b.b.f75008c, TextUtils.isEmpty(this.f74064f) ? "city_selected_for_first_time" : "City Selected");
            if (!v.a(str)) {
                hashMap.put(net.one97.paytm.o2o.movies.common.b.b.f75009d, str);
                String str2 = net.one97.paytm.o2o.movies.common.b.b.f75010e;
                hashMap.put(str2, this.s + "|city=" + str);
                hashMap.put(net.one97.paytm.o2o.movies.common.b.b.f75013h, str);
            }
            hashMap.put(net.one97.paytm.o2o.movies.common.b.b.p, net.one97.paytm.o2o.movies.common.b.b.r);
            if (com.paytm.utility.b.r((Context) this)) {
                hashMap.put(net.one97.paytm.o2o.movies.common.b.b.q, com.paytm.utility.b.n((Context) this));
            }
            net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.sendCustomEventWithMap(net.one97.paytm.o2o.movies.common.b.b.f75006a, hashMap, this);
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
    }

    public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        if (iJRPaytmDataModel instanceof CJRCitiesResponse) {
            CJRSelectCitiesModel a2 = n.a((CJRCitiesResponse) iJRPaytmDataModel);
            if (a2 != null) {
                this.f74066h = a2.getCities();
            }
        } else if (iJRPaytmDataModel instanceof CJRSelectCitiesModel) {
            this.f74066h = ((CJRSelectCitiesModel) iJRPaytmDataModel).getCities();
        }
        if (!TextUtils.isEmpty(this.o)) {
            String str = this.o;
            char c2 = 65535;
            if (str.hashCode() == 1188399937 && str.equals("moviepass")) {
                c2 = 0;
            }
            if (c2 != 0) {
                n.c(this.f74066h);
            } else {
                n.a(this.f74066h);
            }
        }
        h();
    }

    public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        a();
        b();
        if (networkCustomError != null) {
            try {
                String message = networkCustomError.getMessage();
                if (message != null) {
                    if (message.equalsIgnoreCase("503")) {
                        com.paytm.utility.b.b((Context) this, getResources().getString(R.string.movie_maintenance_error_title), getResources().getString(R.string.movie_maintenance_error_description) + " " + networkCustomError.getUrl());
                        return;
                    }
                }
                if (networkCustomError.getMessage() != null && networkCustomError.getMessage().equalsIgnoreCase("parsing_error")) {
                    com.paytm.utility.b.d((Context) this, networkCustomError.getUrl(), String.valueOf(networkCustomError.networkResponse.statusCode));
                } else if (networkCustomError.getAlertTitle() != null && networkCustomError.getAlertMessage() != null) {
                    com.paytm.utility.b.b((Context) this, networkCustomError.getAlertTitle(), networkCustomError.getAlertMessage());
                } else if (TextUtils.isEmpty(networkCustomError.getAlertTitle()) || TextUtils.isEmpty(networkCustomError.getAlertMessage())) {
                    com.paytm.utility.b.b((Context) this, getResources().getString(R.string.network_error_heading), getResources().getString(R.string.network_error_message) + " " + networkCustomError.getUrl());
                } else {
                    com.paytm.utility.b.b((Context) this, networkCustomError.getAlertTitle(), networkCustomError.getAlertMessage());
                }
            } catch (Exception e2) {
                q.b(e2.getMessage());
            }
        }
    }

    private static JSONObject j() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "AJRMoviesSelectCityActivity");
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    private void i() {
        try {
            net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.sendOpenScreenWithDeviceInfo("/movies/location", "movies", this);
            HashMap hashMap = new HashMap();
            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, net.one97.paytm.o2o.movies.common.b.b.R);
            hashMap.put(net.one97.paytm.o2o.movies.common.b.b.f75007b, net.one97.paytm.o2o.movies.common.b.b.w);
            hashMap.put(net.one97.paytm.o2o.movies.common.b.b.f75008c, "location_screen_loaded");
            hashMap.put(net.one97.paytm.o2o.movies.common.b.b.f75009d, TextUtils.isEmpty(this.f74064f) ? "" : "repeat");
            hashMap.put(net.one97.paytm.o2o.movies.common.b.b.p, net.one97.paytm.o2o.movies.common.b.b.r);
            if (this.f74064f != null && !this.f74064f.isEmpty()) {
                hashMap.put(net.one97.paytm.o2o.movies.common.b.b.f75013h, this.f74064f);
            }
            if (com.paytm.utility.b.r((Context) this)) {
                hashMap.put(net.one97.paytm.o2o.movies.common.b.b.q, com.paytm.utility.b.n((Context) this));
            }
            net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.sendCustomEventWithMap(net.one97.paytm.o2o.movies.common.b.b.f75006a, hashMap, this);
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
    }
}
