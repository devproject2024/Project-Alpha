package net.one97.paytm.o2o.amusementpark.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
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
import com.paytm.utility.n;
import com.paytm.utility.q;
import com.paytm.utility.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.common.entity.CJRSelectCitiesModel;
import net.one97.paytm.common.entity.CJRSelectCityModel;
import net.one97.paytm.common.entity.recharge.v2.CJRUtilityLocationModel;
import net.one97.paytm.common.views.ShimmerFrameLayout;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.o2o.amparkeventcommonlib.a.a;
import net.one97.paytm.o2o.amusementpark.R;
import net.one97.paytm.o2o.amusementpark.a.i;
import net.one97.paytm.o2o.amusementpark.a.j;
import net.one97.paytm.o2o.amusementpark.a.p;
import net.one97.paytm.o2o.amusementpark.utils.g;
import net.one97.paytm.o2o.amusementpark.utils.m;
import org.json.JSONException;
import org.json.JSONObject;

public class AJRAmParkSelectCityActivity extends PaytmActivity implements TextWatcher, e.b, e.c, b, a.b, i.b, i.d, j.a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f73337a = AJRAmParkSelectCityActivity.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private LinearLayout f73338b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f73339c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f73340d;

    /* renamed from: e  reason: collision with root package name */
    private e f73341e;

    /* renamed from: f  reason: collision with root package name */
    private String f73342f;

    /* renamed from: g  reason: collision with root package name */
    private EditText f73343g;

    /* renamed from: h  reason: collision with root package name */
    private ArrayList<CJRSelectCityModel> f73344h;

    /* renamed from: i  reason: collision with root package name */
    private a f73345i;
    private String j = null;
    private RecyclerView k;
    private RecyclerView l;
    private ArrayList<CJRSelectCityModel> m;
    private i n;
    private String o;
    private FrameLayout p;
    private ShimmerFrameLayout q;
    private String r = "NA";
    private List<CJRSelectCityModel> s = new ArrayList();
    private ProgressBar t;

    public void afterTextChanged(Editable editable) {
    }

    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    public void onConnected(Bundle bundle) {
    }

    public void attachBaseContext(Context context) {
        if (net.one97.paytm.o2o.amusementpark.a.a() == null) {
            new m();
            m.a();
            super.attachBaseContext(context);
        } else {
            super.attachBaseContext(net.one97.paytm.o2o.amusementpark.a.a().getBaseContext(context));
        }
        com.google.android.play.core.splitcompat.a.a((Context) this);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.park_city_selection);
        try {
            this.f73342f = null;
            if (getIntent() != null) {
                if (getIntent().hasExtra("usercurrentcity")) {
                    this.f73342f = getIntent().getStringExtra("usercurrentcity");
                }
                if (getIntent().hasExtra("sourcename")) {
                    this.o = getIntent().getStringExtra("sourcename");
                }
            }
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
        if (com.paytm.utility.b.O((Context) this) && com.paytm.utility.b.P((Context) this)) {
            try {
                this.f73341e = new e.a(this).a((e.b) this).a((e.c) this).a((com.google.android.gms.common.api.a<? extends a.d.C0127d>) f.f11372a).a();
                this.f73345i = new net.one97.paytm.o2o.amparkeventcommonlib.a.a(this, this, this.f73341e, this);
            } catch (Exception e3) {
                q.b(e3.getMessage());
            }
        }
        try {
            int g2 = com.paytm.utility.b.g((Context) this);
            this.p = (FrameLayout) findViewById(R.id.select_city_progress_bar);
            this.t = (ProgressBar) findViewById(R.id.select_city_progress);
            this.q = (ShimmerFrameLayout) findViewById(R.id.shimmer_movie_city_selection);
            ((LinearLayout) findViewById(R.id.pick_location_lyt)).setPadding(g2 + (g2 / 2), 0, 0, 0);
            this.k = (RecyclerView) findViewById(R.id.parent_recycler_view);
            this.l = (RecyclerView) findViewById(R.id.search_result_recycler_view);
            this.f73338b = (LinearLayout) findViewById(R.id.no_suggestion_lyt);
            this.f73339c = (TextView) findViewById(R.id.current_location_lyt);
            this.f73340d = (TextView) findViewById(R.id.error_text_quote);
            this.f73343g = (EditText) findViewById(R.id.search_city_edt_txt);
            this.f73340d = (TextView) findViewById(R.id.error_text_quote);
            this.f73343g.addTextChangedListener(this);
            this.k.setOnTouchListener(new View.OnTouchListener() {
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    return AJRAmParkSelectCityActivity.this.b(view, motionEvent);
                }
            });
            this.l.setOnTouchListener(new View.OnTouchListener() {
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    return AJRAmParkSelectCityActivity.this.a(view, motionEvent);
                }
            });
            int f2 = com.paytm.utility.b.f((Context) this);
            this.f73338b.setPadding(f2, 0, f2, 0);
            this.f73339c.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    AJRAmParkSelectCityActivity.this.b(view);
                }
            });
            ((AppCompatImageView) findViewById(R.id.back_arrow)).setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    AJRAmParkSelectCityActivity.this.a(view);
                }
            });
        } catch (Exception e4) {
            q.b(e4.getMessage());
        }
        if (!TextUtils.isEmpty(this.o)) {
            this.f73344h = net.one97.paytm.o2o.amusementpark.utils.e.f73650a;
            if (this.f73344h != null) {
                i();
            } else {
                String stringFromGTM = net.one97.paytm.o2o.amusementpark.a.a().getStringFromGTM("ampark_cities_url");
                try {
                    if (!com.paytm.utility.b.c((Context) this)) {
                        h();
                    } else if (!URLUtil.isValidUrl(stringFromGTM)) {
                        h();
                    } else {
                        if (com.paytm.utility.b.r((Context) this)) {
                            stringFromGTM = stringFromGTM + "?customer_id=" + com.paytm.utility.b.n((Context) this);
                        }
                        String s2 = com.paytm.utility.b.s(this, stringFromGTM);
                        HashMap hashMap = new HashMap();
                        hashMap.put("Content-Type", "application/json; charset=utf-8");
                        hashMap.put("ClientId", "paytm");
                        hashMap.put("ACCEPTED-LANGUAGE", n.a((Context) this, n.a()));
                        com.paytm.network.b bVar = new com.paytm.network.b();
                        bVar.f42877a = this;
                        bVar.f42878b = a.c.AM_PARK;
                        bVar.f42879c = a.C0715a.GET;
                        bVar.f42880d = s2;
                        bVar.f42881e = null;
                        bVar.f42882f = hashMap;
                        bVar.f42883g = null;
                        bVar.f42884h = null;
                        bVar.f42885i = new CJRSelectCitiesModel();
                        bVar.j = this;
                        bVar.n = a.b.USER_FACING;
                        bVar.o = "AmPark";
                        bVar.t = k();
                        com.paytm.network.a l2 = bVar.l();
                        l2.f42860d = false;
                        l2.f42859c = false;
                        l2.a();
                        d();
                    }
                } catch (Exception unused) {
                }
            }
        } else {
            Intent intent = new Intent();
            intent.putExtra("status", "FAILED");
            intent.putExtra("alert_message", "urls type is null");
            setResult(0, intent);
        }
        this.f73339c.setVisibility(0);
        this.f73343g.setVisibility(0);
    }

    private void d() {
        FrameLayout frameLayout = this.p;
        if (frameLayout != null) {
            frameLayout.setVisibility(0);
            this.q.a();
        }
    }

    public final void b() {
        FrameLayout frameLayout = this.p;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
            this.q.b();
        }
    }

    private void e() {
        ProgressBar progressBar = this.t;
        if (progressBar != null) {
            progressBar.setVisibility(0);
        }
    }

    public final void c() {
        ProgressBar progressBar = this.t;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
    }

    private void f() {
        List<String> a2 = net.one97.paytm.o2o.amusementpark.f.b.a(getSharedPreferences("paytmPref", 0).getString("key_user_recent_cities".concat(String.valueOf(this.o)), (String) null));
        ArrayList<CJRSelectCityModel> arrayList = this.f73344h;
        if (arrayList != null && arrayList.size() > 0) {
            this.m = new ArrayList<>();
            Iterator<CJRSelectCityModel> it2 = this.f73344h.iterator();
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
                if (str != null && !str.equals("moviepass") && a2 != null && a2.contains(next.getLabel())) {
                    this.s.add(next);
                }
            }
            g gVar = g.f73665a;
            this.s = g.a(this.s, a2);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean b(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0 && action != 2) {
            return false;
        }
        j();
        return false;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean a(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0 && action != 2) {
            return false;
        }
        j();
        return false;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        net.one97.paytm.o2o.amparkeventcommonlib.a.a aVar;
        this.r = "type = Current Location";
        if (!com.paytm.utility.b.c((Context) this) || (aVar = this.f73345i) == null) {
            b();
            c();
            h();
            return;
        }
        aVar.b();
        j();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        setResult(-1, new Intent());
        finish();
    }

    public final void a(CJRSelectCityModel cJRSelectCityModel) {
        b();
        c();
        Intent intent = new Intent();
        intent.putExtra("userselectedcity", cJRSelectCityModel);
        j();
        String label = cJRSelectCityModel.getLabel();
        String str = this.o;
        SharedPreferences sharedPreferences = getSharedPreferences("paytmPref", 0);
        String string = sharedPreferences.getString("key_user_recent_cities".concat(String.valueOf(str)), (String) null);
        if (string != null) {
            label = string + "#" + label;
        }
        sharedPreferences.edit().putString("key_user_recent_cities".concat(String.valueOf(str)), net.one97.paytm.o2o.amusementpark.f.b.a(net.one97.paytm.o2o.amusementpark.f.b.a(label))).commit();
        setResult(-1, intent);
        finish();
    }

    private void g() {
        p pVar = new p(this, this.m, this.f73342f, this.o, this.s);
        this.k.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.k.setAdapter(pVar);
        this.n = new i(this, this, this, this.f73344h, this.f73342f, this.o);
        this.l.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.l.setAdapter(this.n);
        b();
        c();
    }

    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        try {
            this.f73340d.setText(getString(R.string.movies_err_msg, new Object[]{" '" + charSequence + "'"}));
            if (this.n != null) {
                this.n.getFilter().filter(charSequence);
            }
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
    }

    public final void a(boolean z, boolean z2) {
        if (z) {
            this.f73338b.setVisibility(0);
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
        this.f73338b.setVisibility(8);
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        net.one97.paytm.o2o.amparkeventcommonlib.a.a aVar;
        e();
        if (i2 == 57) {
            if (!s.a(iArr) || (aVar = this.f73345i) == null) {
                b();
                c();
                Toast.makeText(this, "Please provide Location permission to use this feature.", 1).show();
            } else {
                aVar.b();
            }
        }
        super.onRequestPermissionsResult(i2, strArr, iArr);
    }

    public void onStart() {
        super.onStart();
        try {
            if (this.f73341e != null) {
                this.f73341e.d();
            }
            net.one97.paytm.o2o.amusementpark.a.a().handlePlayServicesError(this);
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
            if (this.f73341e != null && this.f73341e.f()) {
                this.f73341e.e();
            }
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
    }

    public final boolean a() {
        b();
        c();
        return true;
    }

    public final void a(CJRUtilityLocationModel cJRUtilityLocationModel) {
        if (cJRUtilityLocationModel == null) {
            b();
            c();
            com.paytm.utility.b.b((Context) this, "", getResources().getString(R.string.no_gps) + " " + getResources().getString(R.string.recharge_retry_bill_payment));
        } else if (!TextUtils.isEmpty(cJRUtilityLocationModel.getCity())) {
            this.j = cJRUtilityLocationModel.getCity();
            CJRSelectCityModel cJRSelectCityModel = new CJRSelectCityModel();
            cJRSelectCityModel.setlabel(cJRUtilityLocationModel.getCity());
            cJRSelectCityModel.setValue(cJRUtilityLocationModel.getCity());
            cJRSelectCityModel.setLongitude(cJRUtilityLocationModel.getLongitude());
            cJRSelectCityModel.setLatitude(cJRUtilityLocationModel.getLatitude());
            a(cJRSelectCityModel);
        }
        new StringBuilder("Current location is ").append(this.j);
    }

    public void onConnectionSuspended(int i2) {
        try {
            if (this.f73341e != null) {
                this.f73341e.d();
            }
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
    }

    public void onConnectionFailed(ConnectionResult connectionResult) {
        net.one97.paytm.o2o.amparkeventcommonlib.a.a aVar = this.f73345i;
        if (aVar != null) {
            aVar.a();
        }
    }

    private void h() {
        if (!isFinishing()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(getResources().getString(R.string.no_connection));
            builder.setMessage(getResources().getString(R.string.no_internet));
            builder.setPositiveButton(getResources().getString(R.string.network_retry_yes), new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AJRAmParkSelectCityActivity.this.a(dialogInterface, i2);
                }
            });
            builder.show();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(DialogInterface dialogInterface, int i2) {
        dialogInterface.cancel();
        if (!com.paytm.utility.b.c((Context) this) || this.f73345i == null) {
            h();
            return;
        }
        d();
        this.f73345i.b();
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 115) {
            if (i3 == -1) {
                e();
                net.one97.paytm.o2o.amparkeventcommonlib.a.a aVar = this.f73345i;
                if (aVar != null) {
                    aVar.a();
                }
            } else if (i3 == 0) {
                b();
                c();
            }
        }
    }

    public final void b(CJRSelectCityModel cJRSelectCityModel) {
        if (cJRSelectCityModel != null) {
            this.r = "type = Top Cities";
            a(cJRSelectCityModel);
        }
    }

    private void i() {
        if (this.m == null) {
            f();
        }
        g();
    }

    private void j() {
        if (!isFinishing()) {
            try {
                InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
                if (inputMethodManager != null) {
                    inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                }
            } catch (Exception e2) {
                q.b(e2.getMessage());
            }
        }
    }

    public final void c(CJRSelectCityModel cJRSelectCityModel) {
        if (cJRSelectCityModel != null) {
            this.r = "type = Search";
            a(cJRSelectCityModel);
        }
    }

    public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        if (iJRPaytmDataModel instanceof CJRSelectCitiesModel) {
            this.f73344h = ((CJRSelectCitiesModel) iJRPaytmDataModel).getCities();
            if (!TextUtils.isEmpty(this.o)) {
                net.one97.paytm.o2o.amusementpark.utils.e.a(this.f73344h);
            }
            i();
        }
    }

    public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        b();
        c();
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

    private static JSONObject k() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "AJRAmParkSearchPage");
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
