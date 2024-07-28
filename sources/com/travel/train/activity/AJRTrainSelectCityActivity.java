package com.travel.train.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.al;
import androidx.lifecycle.am;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.e;
import com.google.android.gms.location.f;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.paytm.network.model.NetworkCustomError;
import com.travel.cdn.ResourceUtils;
import com.travel.train.CJRTrainBaseActivity;
import com.travel.train.R;
import com.travel.train.b.y;
import com.travel.train.helper.q;
import com.travel.train.i.ac;
import com.travel.train.i.m;
import com.travel.train.i.w;
import com.travel.train.j.d;
import com.travel.train.j.g;
import com.travel.train.j.o;
import com.travel.train.k.g;
import com.travel.train.l.b;
import com.travel.train.model.CJRUtilityLocationModel;
import com.travel.train.model.trainticket.CJRTrainCity;
import com.travel.train.model.trainticket.CJRTrainOriginCityItem;
import com.travel.train.model.trainticket.CJRTrainRecentsItemModel;
import com.travel.train.model.trainticket.CJRTrainRouteStations;
import com.travel.train.model.trainticket.CJRTrainStation;
import com.travel.train.viewholder.bj;
import com.travel.utils.n;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.widgets.a;
import net.one97.paytm.upi.util.UpiConstants;

public class AJRTrainSelectCityActivity extends CJRTrainBaseActivity implements View.OnClickListener, e.b, e.c, w, d.b {
    private String A = null;
    private int B = -1;
    /* access modifiers changed from: private */
    public RelativeLayout C;
    private d D;
    private e E;
    private ac F;
    private TextView G;
    private TextView H;
    private ImageView I;
    private ConstraintLayout J;
    /* access modifiers changed from: private */
    public BottomSheetBehavior K;
    /* access modifiers changed from: private */
    public LottieAnimationView L;
    /* access modifiers changed from: private */
    public ConstraintLayout M;
    /* access modifiers changed from: private */
    public ConstraintLayout N;
    private TextView O;
    /* access modifiers changed from: private */
    public boolean P = false;
    /* access modifiers changed from: private */
    public boolean Q = false;
    private final float R = 0.005f;
    private final float S = 0.5f;
    /* access modifiers changed from: private */
    public b T;
    private io.reactivex.rxjava3.b.b U = new io.reactivex.rxjava3.b.b();
    /* access modifiers changed from: private */
    public String V = "AJRTrainSelectCityActivity";

    /* renamed from: a  reason: collision with root package name */
    ViewGroup f26089a;

    /* renamed from: b  reason: collision with root package name */
    Handler f26090b = new Handler();

    /* renamed from: c  reason: collision with root package name */
    Runnable f26091c = new Runnable() {
        public final void run() {
            if (AJRTrainSelectCityActivity.this.K.getState() == 3 && !AJRTrainSelectCityActivity.this.Q) {
                AJRTrainSelectCityActivity.this.M.setVisibility(8);
                AJRTrainSelectCityActivity.this.N.setVisibility(0);
                AJRTrainSelectCityActivity.this.f26092d.f27448b.stopListening();
                boolean unused = AJRTrainSelectCityActivity.this.P = true;
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public q f26092d;

    /* renamed from: e  reason: collision with root package name */
    private String f26093e = AJRTrainSelectCityActivity.class.getSimpleName();

    /* renamed from: f  reason: collision with root package name */
    private String f26094f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public EditText f26095g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public RelativeLayout f26096h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public RelativeLayout f26097i;
    private RelativeLayout j;
    private LinearLayout k;
    private ImageButton l;
    /* access modifiers changed from: private */
    public ImageButton m;
    /* access modifiers changed from: private */
    public ImageButton n;
    private ImageView o;
    private SharedPreferences p;
    private RecyclerView q;
    private RecyclerView r;
    private y s;
    private y t;
    private LinearLayout u;
    private LottieAnimationView v;
    private int w = 0;
    private String x;
    private CJRTrainCity y = new CJRTrainCity();
    private TextView z;

    public final void a(CJRUtilityLocationModel cJRUtilityLocationModel) {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent != null) {
            this.f26094f = intent.getStringExtra("option");
            if (intent.getExtras().containsKey("selected_source_name")) {
                this.x = intent.getStringExtra("selected_source_name");
            }
            if (intent.getExtras().containsKey(g.Q)) {
                this.y = (CJRTrainCity) intent.getSerializableExtra(g.Q);
            }
        }
        String str = this.f26094f;
        if (str == null || !str.equalsIgnoreCase("source")) {
            setTitle(getResources().getString(R.string.pre_t_select_destination_train_city));
        } else {
            setTitle(getResources().getString(R.string.pre_t_select_source_train_city));
        }
        setContentView(R.layout.train_select_city);
        getLayoutInflater().inflate(R.layout.train_select_city, (ViewGroup) null);
        getSupportActionBar().f();
        this.f26089a = (CoordinatorLayout) findViewById(R.id.coordinateLyt);
        this.f26095g = (EditText) findViewById(R.id.city_search);
        this.f26096h = (RelativeLayout) findViewById(R.id.suggestion_lyt);
        this.G = (TextView) findViewById(R.id.no_suggestions_found);
        this.H = (TextView) findViewById(R.id.message_verify_text);
        this.u = (LinearLayout) findViewById(R.id.linearProgress);
        this.v = (LottieAnimationView) findViewById(R.id.lottieAnim);
        a.a(this.v);
        this.j = (RelativeLayout) findViewById(R.id.typed_list_rel_lyt);
        this.k = (LinearLayout) findViewById(R.id.title_container);
        this.f26097i = (RelativeLayout) findViewById(R.id.recent_popular_rel_lyt);
        this.I = (ImageView) findViewById(R.id.ic_gps_location);
        ResourceUtils.loadTrainImagesFromCDN(this.I, "current_location.png", false, false, n.a.V1);
        String str2 = this.f26094f;
        if (str2 == null || !str2.equalsIgnoreCase("source")) {
            this.f26095g.setHint(R.string.pre_t_select_destination_train_city);
        } else {
            this.f26095g.setHint(R.string.pre_t_select_source_train_city);
        }
        this.f26095g.setFilters(new InputFilter[]{new InputFilter() {
            public final CharSequence filter(CharSequence charSequence, int i2, int i3, Spanned spanned, int i4, int i5) {
                if (!charSequence.equals("") && !charSequence.toString().matches("[a-zA-Z ]+")) {
                    return "";
                }
                return charSequence;
            }
        }});
        this.l = (ImageButton) findViewById(R.id.back_button);
        this.l.setImageResource(com.travel.common.R.drawable.travel_res_common_close);
        this.l.setOnClickListener(this);
        this.m = (ImageButton) findViewById(R.id.close_icon);
        this.n = (ImageButton) findViewById(R.id.voice_icon);
        ResourceUtils.loadTrainImagesFromCDN(this.n, "microphone.png", false, false, n.a.V1);
        this.m.setOnClickListener(this);
        this.n.setOnClickListener(this);
        this.C = (RelativeLayout) findViewById(R.id.gps_location_container);
        this.C.setOnClickListener(this);
        this.z = (TextView) findViewById(R.id.station_same_error_message);
        this.r = (RecyclerView) findViewById(R.id.recycler_view_train_after_search);
        this.r.setLayoutManager(new LinearLayoutManager(this));
        this.q = (RecyclerView) findViewById(R.id.recycler_view_train);
        this.q.setLayoutManager(new LinearLayoutManager(this));
        this.L = (LottieAnimationView) findViewById(R.id.listening_anim);
        String c2 = o.c(this, "voice_wave.json");
        if (!TextUtils.isEmpty(c2)) {
            this.L.setAnimationFromJson(c2, (String) null);
            this.L.setSpeed(1.0f);
            this.L.loop(true);
            this.L.setMinAndMaxProgress(0.0f, 0.005f);
            this.L.playAnimation();
        }
        this.J = (ConstraintLayout) findViewById(R.id.bottom_sheet);
        this.o = (ImageView) findViewById(R.id.close_voice);
        this.o.setOnClickListener(this);
        this.M = (ConstraintLayout) findViewById(R.id.mainLayout);
        this.N = (ConstraintLayout) findViewById(R.id.errorLayout);
        this.O = (TextView) findViewById(R.id.tryAgainVoice);
        this.O.setOnClickListener(this);
        this.f26092d = new q(this) {
            public final void a(String str) {
                if (str != null) {
                    boolean unused = AJRTrainSelectCityActivity.this.Q = true;
                    if (!AJRTrainSelectCityActivity.this.P) {
                        AJRTrainSelectCityActivity.this.f26095g.setText(str);
                        AJRTrainSelectCityActivity.this.K.setState(4);
                    }
                }
            }

            public final void a(float f2) {
                String.valueOf(f2);
                if (f2 < 0.0f) {
                    AJRTrainSelectCityActivity.this.L.setMinAndMaxProgress(0.5f, 1.0f);
                } else {
                    AJRTrainSelectCityActivity.this.L.setMinAndMaxProgress(0.0f, 0.005f);
                }
            }
        };
        this.K = BottomSheetBehavior.from(this.J);
        this.K.setState(4);
        this.K.setBottomSheetCallback(new BottomSheetBehavior.a() {
            public final void onSlide(View view, float f2) {
            }

            public final void onStateChanged(View view, int i2) {
                if (i2 == 4) {
                    AJRTrainSelectCityActivity.this.f26092d.f27448b.stopListening();
                    boolean unused = AJRTrainSelectCityActivity.this.Q = false;
                    boolean unused2 = AJRTrainSelectCityActivity.this.P = false;
                } else if (i2 == 3) {
                    AJRTrainSelectCityActivity.this.f26092d.a();
                    AJRTrainSelectCityActivity.this.M.setVisibility(0);
                    AJRTrainSelectCityActivity.this.N.setVisibility(8);
                    com.paytm.utility.b.c((Activity) AJRTrainSelectCityActivity.this);
                }
            }
        });
        this.p = getSharedPreferences("trainCitySearchHint", 0);
        SharedPreferences sharedPreferences = this.p;
        if (sharedPreferences != null && !sharedPreferences.getBoolean("trainCitySearchHint", false)) {
            com.travel.train.hintsbuilder.b c3 = new com.travel.train.hintsbuilder.b(this).a((View) this.n).a(getResources().getString(R.string.train_show_tip_view_title)).b(getResources().getString(R.string.train_show_tip_view_desc)).b().c().a(false).c(getResources().getString(R.string.train_show_tip_view_positive_button3));
            c3.f27479a.setButtonColor(-65536);
            c3.f27479a.setButtonTextColor(-16711936);
            c3.a(R.layout.pre_t_train_audio_show_tip_layout).f27479a.a((Activity) this);
            SharedPreferences.Editor edit = this.p.edit();
            if (edit != null) {
                edit.putBoolean("trainCitySearchHint", true);
                edit.apply();
            }
        }
        g.a a2 = new g.a(g.b.SELECT_CITY).a(com.travel.train.a.a.a((com.travel.train.a.a.b) new com.travel.train.a.a.a(this)));
        Application application = getApplication();
        k.c(application, "mApplication");
        a2.f27668c = application;
        a2.f27669d = this.f26094f;
        a2.f27670e = this.x;
        a2.f27671f = this.y;
        a2.f27672g = getResources().getString(R.string.train_popular_cities);
        this.T = (b) am.a((FragmentActivity) this, (al.b) new com.travel.train.k.g(a2)).a(b.class);
        this.T.l.observe(this, new z() {
            public final void onChanged(Object obj) {
                AJRTrainSelectCityActivity.this.a(((Boolean) obj).booleanValue());
            }
        });
        this.T.f27681a.observe(this, new z() {
            public final void onChanged(Object obj) {
                AJRTrainSelectCityActivity.this.a((com.paytm.network.a) obj);
            }
        });
        this.T.f27687g.observe(this, new z() {
            public final void onChanged(Object obj) {
                AJRTrainSelectCityActivity.this.f(((Boolean) obj).booleanValue());
            }
        });
        this.T.f27688h.observe(this, new z() {
            public final void onChanged(Object obj) {
                AJRTrainSelectCityActivity.this.b((String) obj);
            }
        });
        this.T.f27689i.observe(this, new z() {
            public final void onChanged(Object obj) {
                AJRTrainSelectCityActivity.this.g(((Boolean) obj).booleanValue());
            }
        });
        this.T.j.observe(this, new z() {
            public final void onChanged(Object obj) {
                AJRTrainSelectCityActivity.this.h(((Boolean) obj).booleanValue());
            }
        });
        this.T.k.observe(this, new z() {
            public final void onChanged(Object obj) {
                AJRTrainSelectCityActivity.this.a((NetworkCustomError) obj);
            }
        });
        this.T.f27682b.observe(this, new z() {
            public final void onChanged(Object obj) {
                AJRTrainSelectCityActivity.this.a((IJRDataModel) obj);
            }
        });
        this.T.q.observe(this, new z() {
            public final void onChanged(Object obj) {
                AJRTrainSelectCityActivity.this.a((Pair<String, String>) (Pair) obj);
            }
        });
        this.T.f27683c.observe(this, new z() {
            public final void onChanged(Object obj) {
                AJRTrainSelectCityActivity.this.a((ac) obj);
            }
        });
        this.T.f27684d.observe(this, new z() {
            public final void onChanged(Object obj) {
                AJRTrainSelectCityActivity.this.a((ArrayList) obj);
            }
        });
        this.T.f27685e.observe(this, new z() {
            public final void onChanged(Object obj) {
                AJRTrainSelectCityActivity.this.b((ArrayList<IJRDataModel>) (ArrayList) obj);
            }
        });
        this.T.f27686f.observe(this, new z() {
            public final void onChanged(Object obj) {
                AJRTrainSelectCityActivity.this.a((String) obj);
            }
        });
        this.T.m.observe(this, new z() {
            public final void onChanged(Object obj) {
                AJRTrainSelectCityActivity.this.b(((Boolean) obj).booleanValue());
            }
        });
        this.T.n.observe(this, new z() {
            public final void onChanged(Object obj) {
                AJRTrainSelectCityActivity.this.c(((Boolean) obj).booleanValue());
            }
        });
        this.T.o.observe(this, new z() {
            public final void onChanged(Object obj) {
                AJRTrainSelectCityActivity.this.d(((Boolean) obj).booleanValue());
            }
        });
        this.T.p.observe(this, new z() {
            public final void onChanged(Object obj) {
                AJRTrainSelectCityActivity.this.e(((Boolean) obj).booleanValue());
            }
        });
        this.U.a(com.travel.train.h.a.a(this.f26095g).debounce(300, TimeUnit.MILLISECONDS).distinctUntilChanged().subscribeOn(io.reactivex.rxjava3.i.a.b()).observeOn(io.reactivex.rxjava3.android.b.a.a()).subscribe(new io.reactivex.rxjava3.d.g<String>() {
            public final /* synthetic */ void accept(Object obj) throws Throwable {
                String str = (String) obj;
                try {
                    AJRTrainSelectCityActivity.this.a((Context) AJRTrainSelectCityActivity.this);
                    if (str != null) {
                        str = str.trim();
                    }
                    if (str.length() == 0) {
                        AJRTrainSelectCityActivity.this.m.setVisibility(8);
                        AJRTrainSelectCityActivity.this.n.setVisibility(0);
                        AJRTrainSelectCityActivity.this.a();
                        return;
                    }
                    AJRTrainSelectCityActivity.this.m.setVisibility(0);
                    AJRTrainSelectCityActivity.this.n.setVisibility(8);
                    AJRTrainSelectCityActivity.this.f26097i.setVisibility(8);
                    AJRTrainSelectCityActivity.this.f26096h.setVisibility(8);
                    AJRTrainSelectCityActivity.this.C.setVisibility(8);
                    AJRTrainSelectCityActivity.this.T.a(ac.SEARCH_STATION, str);
                } catch (Exception e2) {
                    String unused = AJRTrainSelectCityActivity.this.V;
                    com.paytm.utility.q.c(e2.getMessage());
                }
            }
        }));
        com.travel.train.b.a();
        com.travel.train.b.b().a("/trains/station-search", "Trains", (Context) this);
    }

    public void a(String str) {
        this.w = Integer.parseInt(str);
    }

    public void a(boolean z2) {
        this.C.setVisibility(z2 ? 0 : 8);
    }

    public void b(boolean z2) {
        this.j.setVisibility(z2 ? 0 : 8);
    }

    public void c(boolean z2) {
        this.f26097i.setVisibility(z2 ? 0 : 8);
    }

    public void d(boolean z2) {
        this.f26096h.setVisibility(z2 ? 0 : 8);
    }

    public void e(boolean z2) {
        this.k.removeAllViews();
    }

    /* access modifiers changed from: private */
    public void a(ac acVar) {
        this.F = acVar;
    }

    /* access modifiers changed from: private */
    public void a(Pair<String, String> pair) {
        removeProgressDialog();
        b((String) pair.first, (String) pair.second);
    }

    /* access modifiers changed from: private */
    public void a(ArrayList arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.r.setAdapter((RecyclerView.a) null);
        } else {
            this.t = new y(this, arrayList, -1, this.f26094f, this.F);
            this.t.a(this);
            this.r.setAdapter(this.t);
            this.j.setVisibility(0);
        }
        removeProgressDialog();
    }

    public void a(IJRDataModel iJRDataModel) {
        View inflate = ((LayoutInflater) getSystemService("layout_inflater")).inflate(R.layout.pre_t_recet_popular_train_city_item, this.k, false);
        new bj(this, inflate, this.w, (w) null, (m) null, this.F).a(iJRDataModel, 0, this.w);
        this.k.addView(inflate);
    }

    /* access modifiers changed from: private */
    public void b(ArrayList<IJRDataModel> arrayList) {
        y yVar = this.s;
        int i2 = 0;
        if (yVar != null) {
            if (yVar.f26578a != null && yVar.f26578a.size() > 0) {
                i2 = yVar.f26578a.size();
            }
            yVar.f26578a.addAll(arrayList);
            yVar.notifyItemRangeChanged(i2, yVar.f26578a.size());
        } else {
            this.s = new y(this, arrayList, this.y.getmTrainSearchedCityDetails() != null ? this.y.getmTrainSearchedCityDetails().size() : 0, this.f26094f, this.F);
            this.s.a(this);
            this.j.setVisibility(8);
            this.f26097i.setVisibility(0);
            this.q.setAdapter(this.s);
        }
        removeProgressDialog();
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.close_icon) {
            this.f26095g.setText("");
            a();
        } else if (id == R.id.back_button) {
            o.a((Activity) this);
            onBackPressed();
        } else if (id == R.id.gps_location_container) {
            a((Context) this);
            if (com.paytm.utility.b.O((Context) this) && com.paytm.utility.b.P((Context) this)) {
                try {
                    this.E = new e.a(this).a((e.b) this).a((e.c) this).a((com.google.android.gms.common.api.a<? extends a.d.C0127d>) f.f11372a).a();
                    if (this.E != null) {
                        this.D = new d(this, this, this.E, this);
                        this.D.f27518a = true;
                        this.D.b();
                    }
                    if (this.E != null && !this.E.f()) {
                        this.E.d();
                    }
                } catch (Exception e2) {
                    if (com.paytm.utility.b.v) {
                        com.paytm.utility.q.b(e2.getMessage());
                    }
                }
            }
        } else if (id == R.id.voice_icon) {
            androidx.core.app.a.a(this, new String[]{"android.permission.RECORD_AUDIO"}, 100);
        } else if (id == R.id.close_voice) {
            this.K.setState(4);
        } else if (id == R.id.tryAgainVoice) {
            this.N.setVisibility(8);
            this.M.setVisibility(0);
            this.f26092d.a();
            this.f26090b.removeCallbacks(this.f26091c);
            c();
            this.P = false;
            this.Q = false;
        }
    }

    /* access modifiers changed from: private */
    public void a() {
        removeProgressDialog();
        b();
        this.j.setVisibility(8);
        this.f26097i.setVisibility(0);
        this.f26096h.setVisibility(8);
    }

    public void onBackPressed() {
        o.a((Activity) this);
        super.onBackPressed();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }

    public void a(final com.paytm.network.a aVar) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getResources().getString(R.string.no_connection));
        builder.setMessage(getResources().getString(R.string.no_internet_train));
        builder.setPositiveButton(getResources().getString(R.string.network_retry_yes), new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.cancel();
                if (com.paytm.utility.b.c((Context) AJRTrainSelectCityActivity.this)) {
                    aVar.a();
                } else {
                    AJRTrainSelectCityActivity.this.a(aVar);
                }
            }
        });
        builder.show();
    }

    private void b(String str, String str2) {
        this.j.setVisibility(8);
        this.f26097i.setVisibility(8);
        this.f26096h.setVisibility(0);
        this.G.setText(str);
        this.H.setText(str2);
    }

    public void f(boolean z2) {
        if (!isFinishing()) {
            String string = getResources().getString(R.string.bus_maintenance_error_title);
            String string2 = getResources().getString(R.string.bus_maintenance_error_description);
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(string).setMessage(string2).setCancelable(false);
            builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    dialogInterface.cancel();
                    AJRTrainSelectCityActivity.i(AJRTrainSelectCityActivity.this);
                }
            });
            builder.show();
        }
    }

    public void b(String str) {
        if (!isFinishing()) {
            com.paytm.utility.b.f((Context) this, str);
            removeProgressDialog();
        }
    }

    public void g(boolean z2) {
        if (!isFinishing()) {
            b(getResources().getString(R.string.train_no_nearby_stations), getResources().getString(R.string.no_nearby_station_msg));
            removeProgressDialog();
        }
    }

    public void h(boolean z2) {
        if (!isFinishing()) {
            b(getResources().getString(R.string.pre_t_train_no_suggetions), getResources().getString(R.string.pre_t_train_confirm_suggetion_msg));
            removeProgressDialog();
        }
    }

    public void a(NetworkCustomError networkCustomError) {
        if (!isFinishing()) {
            com.paytm.utility.b.b((Context) this, getResources().getString(R.string.network_error_heading), getResources().getString(R.string.network_error_message_train) + " " + networkCustomError.getUrl());
            removeProgressDialog();
        }
    }

    public void onDestroy() {
        try {
            if (this.t != null) {
                y yVar = this.t;
                if (yVar.f26578a != null) {
                    yVar.f26578a.clear();
                    yVar.f26578a = null;
                }
            }
        } catch (Exception e2) {
            com.paytm.utility.q.c(e2.getMessage());
        }
        this.U.dispose();
        super.onDestroy();
    }

    public final void a(int i2, IJRDataModel iJRDataModel, String str) {
        IJRDataModel iJRDataModel2 = iJRDataModel;
        String str2 = str;
        o.a((Activity) this);
        this.z.setVisibility(8);
        if (iJRDataModel2 == null) {
            return;
        }
        if (iJRDataModel2 instanceof CJRTrainStation) {
            CJRTrainStation cJRTrainStation = (CJRTrainStation) iJRDataModel2;
            if (!str2.equalsIgnoreCase("recent") && !str2.equalsIgnoreCase("popular")) {
                str2.equalsIgnoreCase("search");
            }
            this.B = i2;
            if (cJRTrainStation.isExpandable()) {
                Intent intent = new Intent(this, AJRTrainSelectStationActivity.class);
                intent.putExtra("intent_extra_train_station_list", cJRTrainStation);
                intent.putExtra(UpiConstants.FROM, this.f26094f);
                intent.putExtra("intent_extra_train_search_input", this.f26095g.getText().toString());
                startActivityForResult(intent, 123);
            } else {
                CJRTrainOriginCityItem cityItem = cJRTrainStation.getCityItem();
                if (!(cityItem == null || cityItem.getCityCode() == null || cityItem.getCityName() == null)) {
                    String cityCode = cityItem.getCityCode();
                    cityCode.concat("-" + cityItem.getCityName());
                }
                o.a("train_homepage", (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, "orig_dest_selected", "/trains", this, (Map<String, Object>) null);
                Intent intent2 = new Intent();
                intent2.putExtra("intent_extra_selected_city_name", cityItem);
                int i3 = this.B;
                if (i3 >= 0) {
                    this.B = i3 + 1;
                    intent2.putExtra("intent_extra_selected_city_position", this.B);
                }
                String str3 = this.A;
                if (str3 != null && !TextUtils.isEmpty(str3)) {
                    intent2.putExtra("intent_extra_last_known_search_keyword", this.A);
                }
                setResult(-1, intent2);
                onBackPressed();
            }
            this.A = null;
        } else if (iJRDataModel2 instanceof CJRTrainRouteStations) {
            Intent intent3 = new Intent();
            intent3.putExtra("intent_extra_selected_city_name", (CJRTrainRouteStations) iJRDataModel2);
            int i4 = this.B;
            if (i4 >= 0) {
                this.B = i4 + 1;
                intent3.putExtra("intent_extra_selected_city_position", this.B);
            }
            String str4 = this.A;
            if (str4 != null && !TextUtils.isEmpty(str4)) {
                intent3.putExtra("intent_extra_last_known_search_keyword", this.A);
            }
            setResult(-1, intent3);
            onBackPressed();
            this.A = null;
        } else if (iJRDataModel2 instanceof CJRTrainRecentsItemModel) {
            Intent intent4 = new Intent();
            intent4.putExtra(com.travel.train.j.g.R, (CJRTrainRecentsItemModel) iJRDataModel2);
            setResult(-1, intent4);
            onBackPressed();
        }
    }

    public final void a(Context context) {
        if (context != null || isFinishing()) {
            this.u.setVisibility(0);
            net.one97.paytm.common.widgets.a.a(this.v);
            this.j.setVisibility(8);
            this.f26097i.setVisibility(8);
            this.f26096h.setVisibility(8);
        }
    }

    public void removeProgressDialog() {
        this.u.setVisibility(8);
        net.one97.paytm.common.widgets.a.b(this.v);
    }

    private void b() {
        if (com.travel.train.j.g.f27551a == null || !com.travel.train.j.g.f27551a.isNearByStationEnable()) {
            this.T.l.postValue(Boolean.FALSE);
        } else {
            this.T.l.postValue(Boolean.TRUE);
        }
    }

    public void onStop() {
        super.onStop();
        try {
            if (this.E != null && this.E.f()) {
                this.E.e();
            }
        } catch (Exception unused) {
            com.paytm.utility.q.c("onStop");
        }
        this.f26092d.f27448b.stopListening();
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        o.a((Activity) this);
        if (i2 != 115) {
            if (i2 == 123 && i3 == -1) {
                setResult(-1, intent);
                onBackPressed();
            }
        } else if (i3 == -1) {
            a((Context) this);
            Toast.makeText(this, getResources().getString(R.string.location_on), 1).show();
            d dVar = this.D;
            if (dVar != null) {
                dVar.a();
            }
        } else if (i3 == 0) {
            removeProgressDialog();
            a();
        }
    }

    private void c() {
        this.f26090b.postDelayed(this.f26091c, 5000);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0006, code lost:
        if (r3 != 100) goto L_0x0035;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onRequestPermissionsResult(int r3, java.lang.String[] r4, int[] r5) {
        /*
            r2 = this;
            r0 = 57
            if (r3 == r0) goto L_0x0009
            r0 = 100
            if (r3 == r0) goto L_0x001a
            goto L_0x0035
        L_0x0009:
            r2.a((android.content.Context) r2)
            boolean r0 = com.paytm.utility.s.a((int[]) r5)
            if (r0 == 0) goto L_0x001a
            com.travel.train.j.d r0 = r2.D
            if (r0 == 0) goto L_0x001a
            r0.b()
            goto L_0x0035
        L_0x001a:
            int r0 = r5.length
            r1 = 0
            if (r0 <= 0) goto L_0x002c
            r0 = r5[r1]
            if (r0 != 0) goto L_0x002c
            com.google.android.material.bottomsheet.BottomSheetBehavior r0 = r2.K
            r1 = 3
            r0.setState(r1)
            r2.c()
            goto L_0x0035
        L_0x002c:
            java.lang.String r0 = "Permission Denied!"
            android.widget.Toast r0 = android.widget.Toast.makeText(r2, r0, r1)
            r0.show()
        L_0x0035:
            super.onRequestPermissionsResult(r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.train.activity.AJRTrainSelectCityActivity.onRequestPermissionsResult(int, java.lang.String[], int[]):void");
    }

    public final void d() {
        removeProgressDialog();
    }

    public final void a(String str, String str2) {
        removeProgressDialog();
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            com.paytm.utility.b.b((Context) this, "", getResources().getString(R.string.no_gps) + " " + getResources().getString(R.string.recharge_retry_bill_payment));
            return;
        }
        b bVar = this.T;
        ac acVar = ac.NEAR_BY;
        bVar.a(acVar, "latit=" + str + "&lon=" + str2);
    }

    public void onConnected(Bundle bundle) {
        removeProgressDialog();
        a((Context) this);
        d dVar = this.D;
        if (dVar != null) {
            dVar.a();
        }
    }

    public void onConnectionSuspended(int i2) {
        try {
            if (this.E != null) {
                this.E.d();
            }
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                com.paytm.utility.q.b(e2.getMessage());
            }
        }
    }

    public void onConnectionFailed(ConnectionResult connectionResult) {
        d dVar = this.D;
        if (dVar != null) {
            dVar.a();
        }
    }

    static /* synthetic */ void i(AJRTrainSelectCityActivity aJRTrainSelectCityActivity) {
        Intent intent = new Intent();
        intent.addFlags(67108864);
        intent.addFlags(268435456);
        com.travel.train.b.a();
        com.travel.train.b.b().a((Context) aJRTrainSelectCityActivity, intent);
    }
}
