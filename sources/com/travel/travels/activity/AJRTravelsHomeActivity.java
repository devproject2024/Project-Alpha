package com.travel.travels.activity;

import android.app.AlertDialog;
import android.app.assist.AssistContent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.paytm.utility.b.b;
import com.paytm.utility.n;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.paytmmall.clpartifact.utils.GAUtil;
import com.paytmmoney.lite.mod.helper.CJRConstants;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import com.travel.AJRTravelOffersActivity;
import com.travel.CJRActionBarBaseActivity;
import com.travel.R;
import com.travel.TravelGenericNavActivity;
import com.travel.d;
import com.travel.travel.CJRTravelHomePage;
import com.travel.travel.CJRTravelSubPage;
import com.travel.travel.CJRTravelViewPage;
import com.travel.travels.a.a;
import com.travel.travels.a.b;
import com.travel.travels.c.a;
import com.travel.utils.i;
import com.travel.utils.o;
import com.travel.utils.p;
import com.travel.utils.q;
import com.travel.utils.r;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.common.entity.wallet.CJRQRScanResultModel;
import net.one97.paytm.deeplink.DeepLinkData;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.transcation.PayUtility;
import net.one97.paytm.upi.util.UpiConstants;
import org.json.JSONException;
import org.json.JSONObject;

public class AJRTravelsHomeActivity extends CJRActionBarBaseActivity implements b.a, a {

    /* renamed from: g  reason: collision with root package name */
    private static int f28449g = 302;

    /* renamed from: h  reason: collision with root package name */
    private static String f28450h = "AJRTravelHomeActivity";

    /* renamed from: i  reason: collision with root package name */
    private static String f28451i = "language_change_prev_tab";
    /* access modifiers changed from: private */
    public String A = "";
    /* access modifiers changed from: private */
    public boolean B = true;
    private ConstraintLayout C;
    private ImageView D;
    private ImageView E;
    /* access modifiers changed from: private */
    public ImageView F;
    /* access modifiers changed from: private */
    public ImageView G;
    private FrameLayout H;
    private ImageView I;
    private ImageView J;
    private ImageView K;
    /* access modifiers changed from: private */
    public ConstraintLayout L;
    private String M;
    private DeepLinkData N;
    /* access modifiers changed from: private */
    public Boolean O = Boolean.FALSE;
    private Handler P = new Handler();
    private BroadcastReceiver Q = new BroadcastReceiver() {
        public final void onReceive(Context context, Intent intent) {
            if (intent.getBooleanExtra("setLanguage", false)) {
                AJRTravelsHomeActivity.this.l();
            }
        }
    };
    private a.C0493a R = new a.C0493a() {
        public final void a(CJRHomePageItem cJRHomePageItem) {
            AJRTravelsHomeActivity.a(AJRTravelsHomeActivity.this, cJRHomePageItem);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    RecyclerView f28452a;

    /* renamed from: b  reason: collision with root package name */
    LinearLayoutManager f28453b;

    /* renamed from: c  reason: collision with root package name */
    com.travel.travels.a.a f28454c;

    /* renamed from: d  reason: collision with root package name */
    public CJRHomePageItem f28455d;

    /* renamed from: e  reason: collision with root package name */
    int f28456e;

    /* renamed from: f  reason: collision with root package name */
    com.paytm.b.a.a f28457f;
    private TabLayout j;
    private ViewPager k;
    private ProgressBar l;
    private com.travel.travels.d.a m;
    /* access modifiers changed from: private */
    public b n;
    /* access modifiers changed from: private */
    public List<CJRHomePageItem> o;
    private List<CJRHomePageItem> p;
    /* access modifiers changed from: private */
    public int q = 0;
    private int r = -1;
    private CJRItem x = null;
    private String y = null;
    private Bundle z = null;

    public void attachBaseContext(Context context) {
        d.a();
        super.attachBaseContext(d.b().c(context));
        q.a(context);
    }

    public void onStart() {
        super.onStart();
        q.a(getApplicationContext());
    }

    public void onStop() {
        super.onStop();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.pre_td_activity_travels_home);
        this.f28457f = r.a(getApplicationContext());
        boolean b2 = this.f28457f.b("language_change", true, false);
        this.f28456e = com.paytm.utility.b.b(com.paytm.utility.b.N((Context) this), (Context) this);
        this.L = (ConstraintLayout) findViewById(R.id.languageLayout);
        this.K = (ImageView) findViewById(R.id.closeImg);
        this.K.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AJRTravelsHomeActivity.this.L.setVisibility(8);
                AJRTravelsHomeActivity.this.f28457f.a("language_change", false, false);
            }
        });
        this.s = getSupportActionBar();
        if (this.s != null) {
            this.s.f();
        }
        a(getIntent());
        if (getIntent() != null && getIntent().hasExtra(f28451i)) {
            this.r = getIntent().getIntExtra(f28451i, -1);
        }
        this.z = null;
        if (getIntent().hasExtra("from_bus_retry") && getIntent().getBooleanExtra("from_bus_retry", false)) {
            this.z = getIntent().getExtras();
        }
        this.m = new com.travel.travels.d.a(getApplicationContext(), this);
        this.j = (TabLayout) findViewById(R.id.travels_home_tab);
        this.j.setVisibility(8);
        this.k = (ViewPager) findViewById(R.id.travels_home_pager);
        this.k.setVisibility(8);
        this.k.setOffscreenPageLimit(0);
        this.l = (ProgressBar) findViewById(R.id.th_progress_bar_main);
        this.f28452a = (RecyclerView) findViewById(R.id.bottomMenuRecyclerView);
        this.C = (ConstraintLayout) findViewById(R.id.constraint_travel_bottom_view);
        this.F = (ImageView) findViewById(R.id.left_image);
        this.G = (ImageView) findViewById(R.id.right_image);
        this.D = (ImageView) findViewById(R.id.img_back);
        this.E = (ImageView) findViewById(R.id.img_travel_home);
        this.H = (FrameLayout) findViewById(R.id.frame);
        this.I = (ImageView) findViewById(R.id.img_bg);
        this.D.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AJRTravelsHomeActivity.this.onBackPressed();
            }
        });
        this.J = (ImageView) findViewById(R.id.img_language_change);
        this.D.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AJRTravelsHomeActivity.this.onBackPressed();
            }
        });
        this.J.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AJRTravelsHomeActivity.l(AJRTravelsHomeActivity.this);
            }
        });
        this.L.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AJRTravelsHomeActivity.l(AJRTravelsHomeActivity.this);
                AJRTravelsHomeActivity.this.L.setVisibility(8);
                AJRTravelsHomeActivity.this.f28457f.a("language_change", false, false);
            }
        });
        this.f28453b = new LinearLayoutManager(getApplicationContext(), 0, false);
        this.f28452a.setLayoutManager(this.f28453b);
        this.m.a();
        this.k.addOnPageChangeListener(new ViewPager.e() {
            public final void onPageScrolled(int i2, float f2, int i3) {
            }

            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v9, resolved type: java.lang.Object} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: net.one97.paytm.common.entity.shopping.CJRHomePageItem} */
            /* JADX WARNING: Multi-variable type inference failed */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void onPageSelected(int r6) {
                /*
                    r5 = this;
                    com.travel.travels.activity.AJRTravelsHomeActivity r0 = com.travel.travels.activity.AJRTravelsHomeActivity.this
                    java.util.List r0 = r0.o
                    r1 = 0
                    if (r0 == 0) goto L_0x0096
                    com.travel.travels.activity.AJRTravelsHomeActivity r0 = com.travel.travels.activity.AJRTravelsHomeActivity.this
                    java.util.List r0 = r0.o
                    int r0 = r0.size()
                    if (r0 <= 0) goto L_0x0096
                    com.travel.travels.activity.AJRTravelsHomeActivity r0 = com.travel.travels.activity.AJRTravelsHomeActivity.this
                    java.util.List r0 = r0.o
                    int r0 = r0.size()
                    if (r0 <= r6) goto L_0x0096
                    com.travel.travels.activity.AJRTravelsHomeActivity r0 = com.travel.travels.activity.AJRTravelsHomeActivity.this
                    java.util.List r0 = r0.o
                    java.lang.Object r0 = r0.get(r6)
                    net.one97.paytm.common.entity.shopping.CJRHomePageItem r0 = (net.one97.paytm.common.entity.shopping.CJRHomePageItem) r0
                    java.lang.String r0 = r0.getAltImageUrl()
                    if (r0 == 0) goto L_0x0096
                    com.travel.travels.activity.AJRTravelsHomeActivity r0 = com.travel.travels.activity.AJRTravelsHomeActivity.this
                    android.widget.ImageView r0 = r0.F
                    r2 = 0
                    r0.setVisibility(r2)
                    com.travel.travels.activity.AJRTravelsHomeActivity r0 = com.travel.travels.activity.AJRTravelsHomeActivity.this
                    android.widget.ImageView r0 = r0.G
                    r0.setVisibility(r2)
                    com.travel.travels.activity.AJRTravelsHomeActivity r0 = com.travel.travels.activity.AJRTravelsHomeActivity.this
                    android.content.Context r0 = r0.getApplicationContext()
                    com.paytm.utility.b.b$a$a r0 = com.paytm.utility.b.b.a(r0)
                    com.travel.travels.activity.AJRTravelsHomeActivity r2 = com.travel.travels.activity.AJRTravelsHomeActivity.this
                    java.util.List r2 = r2.o
                    java.lang.Object r2 = r2.get(r6)
                    net.one97.paytm.common.entity.shopping.CJRHomePageItem r2 = (net.one97.paytm.common.entity.shopping.CJRHomePageItem) r2
                    java.lang.String r2 = r2.getAltImageUrl()
                    r0.f43753a = r2
                    com.travel.travels.activity.AJRTravelsHomeActivity r2 = com.travel.travels.activity.AJRTravelsHomeActivity.this
                    android.widget.ImageView r2 = r2.F
                    r3 = 2
                    com.paytm.utility.b.b.a.C0750a.a(r0, r2, r1, r3)
                    com.travel.travels.activity.AJRTravelsHomeActivity r0 = com.travel.travels.activity.AJRTravelsHomeActivity.this
                    android.content.Context r0 = r0.getApplicationContext()
                    com.paytm.utility.b.b$a$a r0 = com.paytm.utility.b.b.a(r0)
                    com.travel.travels.activity.AJRTravelsHomeActivity r2 = com.travel.travels.activity.AJRTravelsHomeActivity.this
                    java.util.List r2 = r2.o
                    java.lang.Object r2 = r2.get(r6)
                    net.one97.paytm.common.entity.shopping.CJRHomePageItem r2 = (net.one97.paytm.common.entity.shopping.CJRHomePageItem) r2
                    java.lang.String r2 = r2.getAltImageUrl()
                    r0.f43753a = r2
                    r2 = 180(0xb4, float:2.52E-43)
                    r0.E = r2
                    com.travel.travels.activity.AJRTravelsHomeActivity r2 = com.travel.travels.activity.AJRTravelsHomeActivity.this
                    android.widget.ImageView r2 = r2.G
                    com.paytm.utility.b.b.a.C0750a.a(r0, r2, r1, r3)
                    goto L_0x00aa
                L_0x0096:
                    com.travel.travels.activity.AJRTravelsHomeActivity r0 = com.travel.travels.activity.AJRTravelsHomeActivity.this
                    android.widget.ImageView r0 = r0.F
                    r2 = 8
                    r0.setVisibility(r2)
                    com.travel.travels.activity.AJRTravelsHomeActivity r0 = com.travel.travels.activity.AJRTravelsHomeActivity.this
                    android.widget.ImageView r0 = r0.G
                    r0.setVisibility(r2)
                L_0x00aa:
                    com.travel.travels.activity.AJRTravelsHomeActivity r0 = com.travel.travels.activity.AJRTravelsHomeActivity.this
                    java.util.List r0 = r0.o
                    if (r0 == 0) goto L_0x0157
                    com.travel.travels.activity.AJRTravelsHomeActivity r0 = com.travel.travels.activity.AJRTravelsHomeActivity.this
                    java.util.List r0 = r0.o
                    int r0 = r0.size()
                    com.travel.travels.activity.AJRTravelsHomeActivity r2 = com.travel.travels.activity.AJRTravelsHomeActivity.this
                    int r2 = r2.q
                    if (r0 <= r2) goto L_0x0157
                    com.travel.travels.activity.AJRTravelsHomeActivity r0 = com.travel.travels.activity.AJRTravelsHomeActivity.this
                    int r2 = r0.q
                    com.travel.travels.activity.AJRTravelsHomeActivity r3 = com.travel.travels.activity.AJRTravelsHomeActivity.this
                    java.lang.Boolean r3 = r3.O
                    boolean r3 = r3.booleanValue()
                    r0.a((int) r2, (int) r6, (boolean) r3)
                    com.travel.travels.activity.AJRTravelsHomeActivity r0 = com.travel.travels.activity.AJRTravelsHomeActivity.this
                    java.lang.Boolean r0 = r0.O
                    boolean r0 = r0.booleanValue()
                    java.lang.String r2 = "toVertical"
                    java.lang.String r3 = "fromVertical"
                    if (r0 == 0) goto L_0x0124
                    com.travel.travels.activity.AJRTravelsHomeActivity r0 = com.travel.travels.activity.AJRTravelsHomeActivity.this
                    java.lang.Boolean r4 = java.lang.Boolean.FALSE
                    java.lang.Boolean unused = r0.O = r4
                    com.travel.utils.o$a r0 = com.travel.utils.o.f28549a
                    com.travel.travels.activity.AJRTravelsHomeActivity r0 = com.travel.travels.activity.AJRTravelsHomeActivity.this
                    java.util.List r0 = r0.o
                    com.travel.travels.activity.AJRTravelsHomeActivity r4 = com.travel.travels.activity.AJRTravelsHomeActivity.this
                    int r4 = r4.q
                    java.lang.Object r0 = r0.get(r4)
                    net.one97.paytm.common.entity.shopping.CJRHomePageItem r0 = (net.one97.paytm.common.entity.shopping.CJRHomePageItem) r0
                    java.lang.String r0 = r0.getName()
                    com.travel.travels.activity.AJRTravelsHomeActivity r4 = com.travel.travels.activity.AJRTravelsHomeActivity.this
                    java.util.List r4 = r4.o
                    java.lang.Object r4 = r4.get(r6)
                    net.one97.paytm.common.entity.shopping.CJRHomePageItem r4 = (net.one97.paytm.common.entity.shopping.CJRHomePageItem) r4
                    java.lang.String r4 = r4.getName()
                    kotlin.g.b.k.c(r0, r3)
                    kotlin.g.b.k.c(r4, r2)
                    java.lang.String r2 = "travel_cross_swipe"
                    com.travel.utils.o.a.a(r2, r0, r4)
                    goto L_0x0157
                L_0x0124:
                    com.travel.utils.o$a r0 = com.travel.utils.o.f28549a
                    com.travel.travels.activity.AJRTravelsHomeActivity r0 = com.travel.travels.activity.AJRTravelsHomeActivity.this
                    java.util.List r0 = r0.o
                    com.travel.travels.activity.AJRTravelsHomeActivity r4 = com.travel.travels.activity.AJRTravelsHomeActivity.this
                    int r4 = r4.q
                    java.lang.Object r0 = r0.get(r4)
                    net.one97.paytm.common.entity.shopping.CJRHomePageItem r0 = (net.one97.paytm.common.entity.shopping.CJRHomePageItem) r0
                    java.lang.String r0 = r0.getName()
                    com.travel.travels.activity.AJRTravelsHomeActivity r4 = com.travel.travels.activity.AJRTravelsHomeActivity.this
                    java.util.List r4 = r4.o
                    java.lang.Object r4 = r4.get(r6)
                    net.one97.paytm.common.entity.shopping.CJRHomePageItem r4 = (net.one97.paytm.common.entity.shopping.CJRHomePageItem) r4
                    java.lang.String r4 = r4.getName()
                    kotlin.g.b.k.c(r0, r3)
                    kotlin.g.b.k.c(r4, r2)
                    java.lang.String r2 = "cross_promotion_tab_clicked"
                    com.travel.utils.o.a.a(r2, r0, r4)
                L_0x0157:
                    com.travel.travels.activity.AJRTravelsHomeActivity r0 = com.travel.travels.activity.AJRTravelsHomeActivity.this
                    int unused = r0.q = r6
                    com.travel.travels.activity.AJRTravelsHomeActivity r0 = com.travel.travels.activity.AJRTravelsHomeActivity.this
                    com.travel.travels.a.b r0 = r0.n
                    if (r0 == 0) goto L_0x016d
                    com.travel.travels.activity.AJRTravelsHomeActivity r0 = com.travel.travels.activity.AJRTravelsHomeActivity.this
                    com.travel.travels.a.b r0 = r0.n
                    android.util.SparseArray<androidx.fragment.app.Fragment> r0 = r0.f28428b
                    goto L_0x016e
                L_0x016d:
                    r0 = r1
                L_0x016e:
                    if (r0 == 0) goto L_0x018f
                    int r2 = r0.size()
                    if (r2 <= 0) goto L_0x018f
                    com.travel.travels.activity.AJRTravelsHomeActivity r2 = com.travel.travels.activity.AJRTravelsHomeActivity.this
                    int r2 = r2.q
                    int r3 = r0.size()
                    if (r2 >= r3) goto L_0x018f
                    com.travel.travels.activity.AJRTravelsHomeActivity r2 = com.travel.travels.activity.AJRTravelsHomeActivity.this
                    int r2 = r2.q
                    java.lang.Object r0 = r0.get(r2)
                    androidx.fragment.app.Fragment r0 = (androidx.fragment.app.Fragment) r0
                    goto L_0x0190
                L_0x018f:
                    r0 = r1
                L_0x0190:
                    if (r0 == 0) goto L_0x0215
                    java.lang.Class r2 = r0.getClass()
                    java.lang.String r2 = r2.getSimpleName()
                    java.lang.String r3 = "FJRBusTicketFragment"
                    boolean r2 = r2.equalsIgnoreCase(r3)
                    if (r2 == 0) goto L_0x01b3
                    com.travel.travels.activity.AJRTravelsHomeActivity r0 = com.travel.travels.activity.AJRTravelsHomeActivity.this
                    java.lang.String r2 = r0.A
                    java.lang.String r3 = "Bus"
                    com.travel.travels.activity.AJRTravelsHomeActivity.a((com.travel.travels.activity.AJRTravelsHomeActivity) r0, (java.lang.String) r2, (java.lang.String) r3)
                    com.travel.travels.activity.AJRTravelsHomeActivity r0 = com.travel.travels.activity.AJRTravelsHomeActivity.this
                    java.lang.String unused = r0.A = r3
                    goto L_0x0215
                L_0x01b3:
                    java.lang.Class r2 = r0.getClass()
                    java.lang.String r2 = r2.getSimpleName()
                    java.lang.String r3 = "FJRFlightTicketFragment"
                    boolean r2 = r2.equals(r3)
                    if (r2 == 0) goto L_0x01d4
                    com.travel.travels.activity.AJRTravelsHomeActivity r0 = com.travel.travels.activity.AJRTravelsHomeActivity.this
                    java.lang.String r2 = r0.A
                    java.lang.String r3 = "Flights"
                    com.travel.travels.activity.AJRTravelsHomeActivity.a((com.travel.travels.activity.AJRTravelsHomeActivity) r0, (java.lang.String) r2, (java.lang.String) r3)
                    com.travel.travels.activity.AJRTravelsHomeActivity r0 = com.travel.travels.activity.AJRTravelsHomeActivity.this
                    java.lang.String unused = r0.A = r3
                    goto L_0x0215
                L_0x01d4:
                    java.lang.Class r2 = r0.getClass()
                    java.lang.String r2 = r2.getSimpleName()
                    java.lang.String r3 = "FJRTrainHomeFragment"
                    boolean r2 = r2.equalsIgnoreCase(r3)
                    if (r2 == 0) goto L_0x01f5
                    com.travel.travels.activity.AJRTravelsHomeActivity r0 = com.travel.travels.activity.AJRTravelsHomeActivity.this
                    java.lang.String r2 = r0.A
                    java.lang.String r3 = "Trains"
                    com.travel.travels.activity.AJRTravelsHomeActivity.a((com.travel.travels.activity.AJRTravelsHomeActivity) r0, (java.lang.String) r2, (java.lang.String) r3)
                    com.travel.travels.activity.AJRTravelsHomeActivity r0 = com.travel.travels.activity.AJRTravelsHomeActivity.this
                    java.lang.String unused = r0.A = r3
                    goto L_0x0215
                L_0x01f5:
                    java.lang.Class r0 = r0.getClass()
                    java.lang.String r0 = r0.getSimpleName()
                    java.lang.String r2 = "FJRSecondaryHomeFragmentTravelOffer"
                    boolean r0 = r0.equalsIgnoreCase(r2)
                    if (r0 == 0) goto L_0x0215
                    com.travel.travels.activity.AJRTravelsHomeActivity r0 = com.travel.travels.activity.AJRTravelsHomeActivity.this
                    java.lang.String r2 = r0.A
                    java.lang.String r3 = "Offers"
                    com.travel.travels.activity.AJRTravelsHomeActivity.a((com.travel.travels.activity.AJRTravelsHomeActivity) r0, (java.lang.String) r2, (java.lang.String) r3)
                    com.travel.travels.activity.AJRTravelsHomeActivity r0 = com.travel.travels.activity.AJRTravelsHomeActivity.this
                    java.lang.String unused = r0.A = r3
                L_0x0215:
                    com.travel.travels.activity.AJRTravelsHomeActivity r0 = com.travel.travels.activity.AJRTravelsHomeActivity.this
                    java.util.List r0 = r0.o
                    if (r0 == 0) goto L_0x0236
                    com.travel.travels.activity.AJRTravelsHomeActivity r0 = com.travel.travels.activity.AJRTravelsHomeActivity.this
                    java.util.List r0 = r0.o
                    int r0 = r0.size()
                    if (r6 >= r0) goto L_0x0236
                    com.travel.travels.activity.AJRTravelsHomeActivity r0 = com.travel.travels.activity.AJRTravelsHomeActivity.this
                    java.util.List r0 = r0.o
                    java.lang.Object r6 = r0.get(r6)
                    r1 = r6
                    net.one97.paytm.common.entity.shopping.CJRHomePageItem r1 = (net.one97.paytm.common.entity.shopping.CJRHomePageItem) r1
                L_0x0236:
                    com.travel.travels.activity.AJRTravelsHomeActivity r6 = com.travel.travels.activity.AJRTravelsHomeActivity.this
                    boolean r6 = r6.B
                    if (r6 == 0) goto L_0x027d
                    if (r1 == 0) goto L_0x027d
                    java.lang.String r6 = r1.getURLType()
                    if (r6 == 0) goto L_0x027d
                    java.lang.String r6 = r1.getURLType()
                    java.lang.String r0 = "busticket"
                    boolean r6 = r6.equalsIgnoreCase(r0)
                    if (r6 == 0) goto L_0x027d
                    com.travel.d.a()
                    com.travel.common.b r6 = com.travel.d.b()
                    com.travel.travels.activity.AJRTravelsHomeActivity r0 = com.travel.travels.activity.AJRTravelsHomeActivity.this
                    android.content.Context r0 = r0.getApplicationContext()
                    java.lang.String r1 = "/bus-tickets"
                    java.lang.String r2 = "BusTicket"
                    r6.a((java.lang.String) r1, (java.lang.String) r2, (android.content.Context) r0)
                    com.travel.d.a()
                    com.travel.common.b r6 = com.travel.d.b()
                    com.travel.travels.activity.AJRTravelsHomeActivity r0 = com.travel.travels.activity.AJRTravelsHomeActivity.this
                    android.content.Context r0 = r0.getApplicationContext()
                    java.lang.String r1 = "screen_loaded_bus_ticket"
                    r6.a((java.lang.String) r1, (android.content.Context) r0)
                    com.travel.travels.activity.AJRTravelsHomeActivity r6 = com.travel.travels.activity.AJRTravelsHomeActivity.this
                    boolean unused = r6.B = false
                L_0x027d:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.travel.travels.activity.AJRTravelsHomeActivity.AnonymousClass14.onPageSelected(int):void");
            }

            public final void onPageScrollStateChanged(int i2) {
                if (i2 == 1) {
                    Boolean unused = AJRTravelsHomeActivity.this.O = Boolean.TRUE;
                }
            }
        });
        CJRItem cJRItem = this.x;
        if (cJRItem != null && !TextUtils.isEmpty(cJRItem.getName())) {
            this.A = this.x.getName().trim();
        }
        d.a();
        if (com.paytm.utility.b.a(getApplicationContext(), d.b().g())) {
            g();
        }
        if (b2) {
            this.L.setVisibility(0);
            new Handler().postDelayed(new Runnable() {
                public final void run() {
                    if (AJRTravelsHomeActivity.this.L != null) {
                        AJRTravelsHomeActivity.this.L.setVisibility(8);
                    }
                }
            }, 4000);
        } else {
            this.L.setVisibility(8);
        }
        androidx.localbroadcastmanager.a.a.a((Context) this).a(this.Q, new IntentFilter("net.paytm.one97.action.REFRESH_LOGIN"));
    }

    public void onDestroy() {
        super.onDestroy();
        this.R = null;
        this.f28457f = null;
        this.f28456e = 0;
        this.L = null;
        this.K = null;
        this.s = null;
        this.x = null;
        this.y = null;
        this.r = 0;
        this.z = null;
        ViewPager viewPager = this.k;
        if (viewPager != null) {
            viewPager.setAdapter((androidx.viewpager.widget.a) null);
            this.k.removeAllViews();
            this.k = null;
        }
        b bVar = this.n;
        if (bVar != null) {
            if (bVar.f28428b != null) {
                bVar.f28428b.clear();
                bVar.f28428b = null;
            }
            if (bVar.f28427a != null) {
                bVar.f28427a.clear();
                bVar.f28427a = null;
            }
            bVar.f28432f = null;
            bVar.f28429c = null;
            bVar.f28430d = null;
            bVar.f28433g = null;
            bVar.f28431e = null;
            this.n = null;
        }
        com.travel.travels.d.a aVar = this.m;
        if (aVar != null) {
            aVar.f28489a = null;
            aVar.f28490b = null;
            aVar.f28491c = null;
        }
        this.m = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.f28452a = null;
        this.C = null;
        this.D = null;
        this.E = null;
        this.H = null;
        this.I = null;
        this.J = null;
        this.f28453b = null;
        this.A = null;
        this.x = null;
        this.F = null;
        this.G = null;
        try {
            androidx.localbroadcastmanager.a.a.a((Context) this).a(this.Q);
        } catch (Exception unused) {
        }
    }

    private void a(Intent intent) {
        if (intent != null) {
            this.N = (DeepLinkData) intent.getParcelableExtra("EXTRA_DEEP_LINK_DATA");
            if (intent.getSerializableExtra("extra_home_data") instanceof CJRItem) {
                this.x = (CJRItem) intent.getSerializableExtra("extra_home_data");
            }
            this.M = intent.getStringExtra(UpiConstants.FROM);
            if (this.x == null && this.N != null) {
                this.x = new CJRHomePageItem();
                a((CJRHomePageItem) this.x, this.N);
            }
            this.y = intent.getStringExtra("origin");
        }
    }

    private static void a(CJRHomePageItem cJRHomePageItem, DeepLinkData deepLinkData) {
        if (deepLinkData == null) {
            com.paytm.utility.q.d("DeepLinkData is Empty");
            return;
        }
        String str = deepLinkData.f50283a;
        String str2 = deepLinkData.f50284b;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (str2.contains("paytm.com")) {
                int indexOf = str.indexOf("paytm.com");
                int indexOf2 = str.indexOf("-");
                if (indexOf != -1) {
                    str2 = indexOf2 != -1 ? str.substring(indexOf + 10, indexOf2) : str.substring(indexOf + 10);
                }
            }
            if (!TextUtils.isEmpty(str) && str.contains("$")) {
                str = str.replaceAll("\\$", AppConstants.AND_SIGN);
            }
            if (!TextUtils.isEmpty(str)) {
                cJRHomePageItem.setUrl(str);
            }
            Uri parse = Uri.parse(str);
            cJRHomePageItem.setUrlType(str2);
            cJRHomePageItem.setPushUtmSource(parse.getQueryParameter("utm_source"));
            if (!TextUtils.isEmpty(str) && parse.getQueryParameterNames() != null) {
                if (!TextUtils.isEmpty(str) && str.contains(AppConstants.AND_SIGN) && !str.contains("?")) {
                    str = str.replaceFirst(AppConstants.AND_SIGN, "?");
                }
                if (!TextUtils.isEmpty(str) && !str.contains("versionidentifier") && !TextUtils.isEmpty(str2) && !str2.equalsIgnoreCase("train_order_summary")) {
                    if (!str.contains("?")) {
                        str = str + "?versionidentifier=1";
                    } else {
                        str = str + "&versionidentifier=1";
                    }
                }
                cJRHomePageItem.setUrl(str);
            }
            cJRHomePageItem.setPushQuantity(parse.getQueryParameter("quantity"));
            cJRHomePageItem.setPushPromoCode(parse.getQueryParameter(PayUtility.PROMO_CODE));
            cJRHomePageItem.setPushProductId(parse.getQueryParameter(CLPConstants.PRODUCT_ID));
            cJRHomePageItem.setPushCashAdd(parse.getQueryParameter("amount"));
            cJRHomePageItem.setPushFeatureType(parse.getQueryParameter("featuretype"));
            cJRHomePageItem.setPushWalletCode(parse.getQueryParameter("wallet_code"));
            cJRHomePageItem.setPushRecipient(parse.getQueryParameter("recipient"));
            cJRHomePageItem.setPushComment(parse.getQueryParameter(CJRQRScanResultModel.KEY_COMMENT_SMALL));
            cJRHomePageItem.setUtmMedium(parse.getQueryParameter("utm_medium"));
            cJRHomePageItem.setUtmTerm(parse.getQueryParameter("utm_term"));
            cJRHomePageItem.setUtmContent(parse.getQueryParameter("utm_content"));
            cJRHomePageItem.setUtmCampaign(parse.getQueryParameter("utm_campaign"));
            cJRHomePageItem.setDeepLinking(true);
            String queryParameter = parse.getQueryParameter("showpopup");
            boolean z2 = false;
            if (TextUtils.isEmpty(queryParameter) || !queryParameter.equalsIgnoreCase("true")) {
                cJRHomePageItem.setPushShowPopup(false);
            } else {
                cJRHomePageItem.setPushShowPopup(true);
            }
            cJRHomePageItem.setPushCheckInDate(parse.getQueryParameter("check_in_date"));
            cJRHomePageItem.setPushCheckOutDate(parse.getQueryParameter("check_out_date"));
            cJRHomePageItem.setPushCity(parse.getQueryParameter("city"));
            cJRHomePageItem.setPushCityValue(parse.getQueryParameter("city_value"));
            cJRHomePageItem.setPushRoomDetailsJson(parse.getQueryParameter("rooms_details"));
            cJRHomePageItem.setQueryString(parse.getQueryParameter("query_string"));
            cJRHomePageItem.setQrid(parse.getQueryParameter("qrid"));
            cJRHomePageItem.setPushHotelName(parse.getQueryParameter("hotel_name"));
            cJRHomePageItem.setPushHotelId(parse.getQueryParameter("hotel_id"));
            cJRHomePageItem.setPushHotelExtras(parse.getQueryParameter("hotel_extras"));
            cJRHomePageItem.setPushHotelFinalPriceWithTax(parse.getQueryParameter("hotel_final_price_with_tax"));
            cJRHomePageItem.setPushSourceCityName(parse.getQueryParameter("source_city_name"));
            cJRHomePageItem.setPushSourceCityShortName(parse.getQueryParameter("source_city_short_name"));
            cJRHomePageItem.setPushDestinationCityName(parse.getQueryParameter("destination_city_name"));
            cJRHomePageItem.setPushDestinationCityShortName(parse.getQueryParameter("destination_city_short_name"));
            cJRHomePageItem.setPushDate(parse.getQueryParameter(CJRGiftCardUserInputField.FIELD_TYPE_CALENDAR));
            cJRHomePageItem.setPushPassengerCount(parse.getQueryParameter("passenger_count"));
            cJRHomePageItem.setPushRechargeNumber(parse.getQueryParameter("recharge_number"));
            cJRHomePageItem.setPushRechargeAmount(parse.getQueryParameter("price"));
            cJRHomePageItem.setPushRechargePromo(parse.getQueryParameter("promo"));
            cJRHomePageItem.setPushRechargeRoaming(parse.getQueryParameter("roaming"));
            cJRHomePageItem.setPushType(parse.getQueryParameter("type"));
            cJRHomePageItem.setPushCode(parse.getQueryParameter("code"));
            cJRHomePageItem.setPushFlightClass(parse.getQueryParameter("flight_class"));
            cJRHomePageItem.setPushFlightTripType(parse.getQueryParameter("flight_trip_type"));
            cJRHomePageItem.setPushFlightDepartDate(parse.getQueryParameter("flight_depart_date"));
            cJRHomePageItem.setPushFlightReturnDate(parse.getQueryParameter("flight_return_date"));
            cJRHomePageItem.setTrainSourceCityCode(parse.getQueryParameter("source"));
            cJRHomePageItem.setTrainDestinationCityCode(parse.getQueryParameter("destination"));
            cJRHomePageItem.setTrainDepartureDate(parse.getQueryParameter("departureDate"));
            cJRHomePageItem.setTrainSourceCityName(parse.getQueryParameter("source_name"));
            cJRHomePageItem.setTrainDestinationCityName(parse.getQueryParameter("destination_name"));
            if (!(parse == null || parse.getQueryParameter("is_round_trip") == null)) {
                z2 = Boolean.valueOf(parse.getQueryParameter("is_round_trip")).booleanValue();
            }
            cJRHomePageItem.setTrainRoundTrip(z2);
            cJRHomePageItem.setOrigin("deeplinking");
            cJRHomePageItem.setmFlightReferral(parse.getQueryParameter("referral"));
        }
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        d.a();
        if (com.paytm.utility.b.a(getApplicationContext(), d.b().g())) {
            g();
        }
        a(intent);
        b bVar = this.n;
        if (bVar != null) {
            CJRItem cJRItem = this.x;
            String str = this.M;
            bVar.f28429c = cJRItem;
            bVar.f28433g = str;
        }
        h();
        n();
    }

    private void g() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getResources().getString(R.string.wrong_setting));
        builder.setMessage(getResources().getString(R.string.dont_keep_activities_error_message));
        builder.setPositiveButton(getResources().getString(R.string.ok), new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.cancel();
                AJRTravelsHomeActivity.b(AJRTravelsHomeActivity.this);
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.cancel();
            }
        });
        builder.show();
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        d();
        c();
        return super.onPrepareOptionsMenu(menu);
    }

    public final void b() {
        a(-1, -1, false);
    }

    /* access modifiers changed from: private */
    public void a(int i2, int i3, final boolean z2) {
        SparseArray<WeakReference<Fragment>> sparseArray;
        int i4;
        if (this.n.j.size() > 0 && this.n.j.get(this.q) != null) {
            this.n.j.get(this.q).get();
        }
        b bVar = this.n;
        if (bVar != null && (sparseArray = bVar.j) != null && sparseArray.size() > 0) {
            if (i2 != -1 || (i4 = this.q) < 0) {
                final WeakReference weakReference = sparseArray.get(i2);
                final WeakReference weakReference2 = sparseArray.get(i3);
                this.P.post(new Runnable() {
                    public final void run() {
                        WeakReference weakReference = weakReference;
                        if (weakReference != null && weakReference.get() != null && (weakReference.get() instanceof com.travel.common.a.b)) {
                            ((com.travel.common.a.b) weakReference.get()).onVisibilityGone();
                        }
                    }
                });
                this.P.post(new Runnable() {
                    public final void run() {
                        WeakReference weakReference = weakReference2;
                        if (weakReference != null && weakReference.get() != null && (weakReference2.get() instanceof com.travel.common.a.b)) {
                            ((com.travel.common.a.b) weakReference2.get()).onVisibleToUser(z2);
                        }
                    }
                });
                return;
            }
            final WeakReference weakReference3 = sparseArray.get(i4);
            this.P.post(new Runnable() {
                public final void run() {
                    WeakReference weakReference = weakReference3;
                    if (weakReference != null && weakReference.get() != null && (weakReference3.get() instanceof com.travel.common.a.b)) {
                        ((com.travel.common.a.b) weakReference3.get()).onVisibleToUser(z2);
                    }
                }
            });
        }
    }

    public void onBackPressed() {
        SparseArray<Fragment> sparseArray;
        super.onBackPressed();
        b bVar = this.n;
        Fragment fragment = null;
        if (bVar != null) {
            sparseArray = bVar.f28428b;
        } else {
            sparseArray = null;
        }
        if (sparseArray != null && sparseArray.size() > 0) {
            fragment = sparseArray.get(this.q);
        }
        if (fragment != null && fragment.getClass() != null && fragment.getClass().getName() != null && fragment.getClass().getName().equalsIgnoreCase("net.one97.paytm.hotels2.fragment.HotelHomeFragment")) {
            new CJRHomePageItem().setUrl(r.a(getApplicationContext()).b("home_url", "", true));
            Intent intent = new Intent();
            intent.addFlags(67108864);
            intent.addFlags(268435456);
            intent.setFlags(536870912);
            intent.putExtra("CLEAR_MOBILE_DATA", true);
            intent.putExtra(CJRConstants.EXTRA_INTENT_RESULTANT_FRAGMENT_TYPE, "main");
            d.a();
            d.b().a((Context) this, intent);
            finish();
        }
    }

    public final void a(IJRDataModel iJRDataModel) {
        String str;
        String str2;
        Bundle extras;
        ArrayList<CJRTravelSubPage> arrayList;
        CJRTravelSubPage cJRTravelSubPage;
        ProgressBar progressBar = this.l;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
        String str3 = "";
        if (iJRDataModel != null) {
            CJRTravelHomePage cJRTravelHomePage = (CJRTravelHomePage) iJRDataModel;
            String image_url = cJRTravelHomePage.getImage_url();
            if (cJRTravelHomePage.getRootLayout() != null && !TextUtils.isEmpty(cJRTravelHomePage.getRootLayout().f28406a)) {
                str3 = cJRTravelHomePage.getRootLayout().f28406a;
            }
            str = str3;
            str2 = image_url;
        } else {
            str2 = str3;
            str = str2;
        }
        if (this.m != null) {
            CJRTravelHomePage cJRTravelHomePage2 = (CJRTravelHomePage) iJRDataModel;
            ArrayList<CJRHomePageItem> arrayList2 = null;
            ArrayList<CJRTravelSubPage> arrayList3 = (cJRTravelHomePage2 == null || cJRTravelHomePage2.getmCjrTravelSubPages() == null || cJRTravelHomePage2.getmCjrTravelSubPages().size() <= 0) ? null : cJRTravelHomePage2.getmCjrTravelSubPages();
            CJRTravelSubPage cJRTravelSubPage2 = arrayList3 != null ? arrayList3.get(0) : null;
            this.o = ((cJRTravelSubPage2 == null || cJRTravelSubPage2.getmHomePageLayoutList() == null || cJRTravelSubPage2.getmHomePageLayoutList().size() <= 0) ? null : cJRTravelSubPage2.getmHomePageLayoutList()).get(0).getCjrTravelItemPages();
            if (!(cJRTravelHomePage2 == null || cJRTravelHomePage2.getmCjrTravelSubPages() == null || (arrayList = cJRTravelHomePage2.getmCjrTravelSubPages()) == null || arrayList.size() < 2 || (cJRTravelSubPage = arrayList.get(1)) == null || cJRTravelSubPage.getmHomePageLayoutList() == null)) {
                ArrayList<CJRTravelViewPage> arrayList4 = cJRTravelSubPage.getmHomePageLayoutList();
                if (!(arrayList4.size() == 0 || arrayList4.get(0).getCjrTravelItemPages() == null)) {
                    arrayList2 = arrayList4.get(0).getCjrTravelItemPages();
                }
            }
            this.p = arrayList2;
            List<CJRHomePageItem> list = this.o;
            int i2 = ((list == null || list.size() <= 0) ? 0 : this.o.size()) < 5 ? 1 : 0;
            TabLayout tabLayout = this.j;
            if (tabLayout != null) {
                tabLayout.setVisibility(0);
                this.j.setTabMode(i2);
            }
            b bVar = this.n;
            if (bVar != null) {
                List<CJRHomePageItem> list2 = this.o;
                String str4 = this.y;
                String str5 = this.M;
                Bundle bundle = this.z;
                bVar.f28427a = list2;
                bVar.f28430d = str4;
                bVar.f28433g = str5;
                bVar.f28431e = bundle;
                bVar.f28435i = false;
                bVar.j.clear();
                b bVar2 = this.n;
                bVar2.f28434h = true;
                bVar2.notifyDataSetChanged();
            } else {
                this.n = new b(getSupportFragmentManager(), this.o, this.x, this.y, this.M, this.z, this.N, this);
            }
            if (!(getIntent() == null || (extras = getIntent().getExtras()) == null || extras.get("EXTRA_DEEP_LINK_DATA") == null || !(extras.get("EXTRA_DEEP_LINK_DATA") instanceof DeepLinkData))) {
                DeepLinkData deepLinkData = (DeepLinkData) extras.get("EXTRA_DEEP_LINK_DATA");
                if (deepLinkData.f50283a != null && deepLinkData.f50283a.contains("isApplink")) {
                    try {
                        Uri parse = Uri.parse(deepLinkData.f50283a);
                        String str6 = parse.getQueryParameter("source_city_name") + "/" + parse.getQueryParameter("destination_city_name") + "/" + parse.getQueryParameter(CJRGiftCardUserInputField.FIELD_TYPE_CALENDAR);
                        Context applicationContext = getApplicationContext();
                        try {
                            HashMap hashMap = new HashMap();
                            hashMap.put("event_category", "bus_home");
                            hashMap.put("user_id", com.paytm.utility.b.n(applicationContext));
                            hashMap.put("event_action", "seo_link_activated");
                            hashMap.put("event_label", str6);
                            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "bus-tickets");
                            hashMap.put(net.one97.paytm.common.utility.d.cv, "bus");
                            d.a();
                            d.b().a(GAUtil.CUSTOM_EVENT, (Map<String, Object>) hashMap, applicationContext);
                        } catch (Exception e2) {
                            com.paytm.utility.q.c(e2.getMessage());
                        }
                    } catch (Exception e3) {
                        com.paytm.utility.q.c(e3.getMessage());
                    }
                }
            }
            h();
            List<CJRHomePageItem> list3 = this.p;
            if (list3 == null || list3.size() <= 0) {
                this.C.setVisibility(8);
            } else {
                this.C.setVisibility(0);
                this.f28454c = new com.travel.travels.a.a(this, this.p, this.R);
                this.f28452a.setAdapter(this.f28454c);
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, 0, 0, this.f28456e);
            this.I.setLayoutParams(layoutParams);
            if (!TextUtils.isEmpty(str2)) {
                b.a.C0750a a2 = com.paytm.utility.b.b.a(this);
                a2.f43753a = str2;
                a2.a(this.E);
            }
            if (!TextUtils.isEmpty(str)) {
                b.a.C0750a a3 = com.paytm.utility.b.b.a(this);
                a3.f43753a = str;
                a3.a(this.I);
            }
            n();
        }
    }

    public final void f() {
        h();
        com.travel.travels.a.b bVar = this.n;
        if (bVar != null) {
            bVar.f28434h = true;
        }
        n();
    }

    private void h() {
        com.paytm.utility.q.d(" View Pager is refreshed ");
        int j2 = j();
        ViewPager viewPager = this.k;
        if (viewPager != null) {
            viewPager.setVisibility(0);
            this.k.setAdapter(this.n);
            this.j.setupWithViewPager(this.k);
            this.j.setSelectedTabIndicatorColor(Color.parseColor("#00b9f5"));
            this.q = j2;
            com.travel.travels.a.b bVar = this.n;
            if (bVar != null) {
                bVar.k = this.q;
            }
            this.k.setCurrentItem(j2);
            i();
            a(this.j, com.paytm.utility.b.c(22), com.paytm.utility.b.c(25));
        }
    }

    private void i() {
        List<CJRHomePageItem> list = this.p;
        if (list != null && list.size() > 0) {
            for (int i2 = 0; i2 < this.o.size(); i2++) {
                RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this).inflate(R.layout.pre_tc_custom_home_tab_item, (ViewGroup) null);
                RelativeLayout relativeLayout2 = (RelativeLayout) relativeLayout.findViewById(R.id.tag_container);
                TextView textView = (TextView) relativeLayout.findViewById(R.id.txt_tag);
                ImageView imageView = (ImageView) relativeLayout.findViewById(R.id.img_tab);
                ((TextView) relativeLayout.findViewById(R.id.txt_tab)).setText(this.o.get(i2).getName());
                String label = this.o.get(i2).getLayoutParam() != null ? this.o.get(i2).getLayoutParam().getLabel() : "";
                if (!TextUtils.isEmpty(label)) {
                    relativeLayout2.setVisibility(8);
                    textView.setText(label);
                } else {
                    relativeLayout2.setVisibility(8);
                }
                b.a.C0750a a2 = com.paytm.utility.b.b.a(getApplicationContext());
                a2.f43753a = this.o.get(i2).getImageUrl();
                b.a.C0750a.a(a2, imageView, (com.paytm.utility.b.b.b) null, 2);
                this.j.a(i2).a((View) relativeLayout);
            }
        }
    }

    private static void a(TabLayout tabLayout, int i2, int i3) {
        View childAt = tabLayout.getChildAt(0);
        if (childAt instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) childAt;
            int childCount = viewGroup.getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt2 = viewGroup.getChildAt(i4);
                childAt2.setMinimumWidth(0);
                childAt2.setPadding(0, childAt2.getPaddingTop(), 0, childAt2.getPaddingBottom());
                if (childAt2.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt2.getLayoutParams();
                    if (i4 == 0) {
                        a(marginLayoutParams, i2, 0);
                    } else if (i4 == childCount - 1) {
                        a(marginLayoutParams, i3, i2);
                    } else {
                        a(marginLayoutParams, i3, 0);
                    }
                }
            }
            tabLayout.requestLayout();
        }
    }

    private static void a(ViewGroup.MarginLayoutParams marginLayoutParams, int i2, int i3) {
        if (Build.VERSION.SDK_INT >= 17) {
            marginLayoutParams.setMarginStart(i2);
            marginLayoutParams.setMarginEnd(i3);
        }
        marginLayoutParams.leftMargin = i2;
        marginLayoutParams.rightMargin = i3;
    }

    private int j() {
        int i2 = this.r;
        if (i2 != -1) {
            return i2;
        }
        CJRItem cJRItem = this.x;
        if (cJRItem != null) {
            cJRItem.getURLType();
        }
        Pair<String, Integer> k2 = k();
        if (((Integer) k2.second).intValue() != -1) {
            return ((Integer) k2.second).intValue();
        }
        return 0;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.util.Pair<java.lang.String, java.lang.Integer> k() {
        /*
            r16 = this;
            r0 = r16
            android.util.Pair r1 = new android.util.Pair
            r2 = -1
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)
            java.lang.String r4 = ""
            r1.<init>(r4, r3)
            net.one97.paytm.common.entity.CJRItem r3 = r0.x
            if (r3 == 0) goto L_0x0015
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r3 = (net.one97.paytm.common.entity.shopping.CJRHomePageItem) r3
            goto L_0x0016
        L_0x0015:
            r3 = 0
        L_0x0016:
            if (r3 == 0) goto L_0x01a5
            java.lang.String r4 = r3.getURLType()
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 == 0) goto L_0x0024
            goto L_0x01a5
        L_0x0024:
            java.util.List<net.one97.paytm.common.entity.shopping.CJRHomePageItem> r4 = r0.o
            if (r4 == 0) goto L_0x01a5
            int r4 = r4.size()
            if (r4 <= 0) goto L_0x01a5
            java.util.List<net.one97.paytm.common.entity.shopping.CJRHomePageItem> r4 = r0.o
            java.util.Iterator r4 = r4.iterator()
            r6 = 0
        L_0x0035:
            boolean r7 = r4.hasNext()
            if (r7 == 0) goto L_0x01a5
            java.lang.Object r7 = r4.next()
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r7 = (net.one97.paytm.common.entity.shopping.CJRHomePageItem) r7
            java.lang.String r8 = r7.getURLType()
            int r9 = r8.hashCode()
            java.lang.String r10 = "internationalflights"
            java.lang.String r11 = "citybus"
            java.lang.String r12 = "travelpass"
            java.lang.String r13 = "travelmetro"
            java.lang.String r14 = "hotel-booking"
            java.lang.String r15 = "busticket"
            java.lang.String r2 = "trainticket"
            java.lang.String r5 = "travelcampaign"
            java.lang.String r0 = "homepage"
            switch(r9) {
                case -1871399148: goto L_0x00bc;
                case -1565513625: goto L_0x00b2;
                case -881784436: goto L_0x00aa;
                case -485371922: goto L_0x00a2;
                case -416630464: goto L_0x009a;
                case -312570305: goto L_0x0091;
                case 1295914: goto L_0x0088;
                case 682739243: goto L_0x0080;
                case 785443125: goto L_0x0077;
                case 1176719504: goto L_0x006c;
                case 2128330677: goto L_0x0064;
                default: goto L_0x0062;
            }
        L_0x0062:
            goto L_0x00c4
        L_0x0064:
            boolean r8 = r8.equals(r10)
            if (r8 == 0) goto L_0x00c4
            r8 = 4
            goto L_0x00c5
        L_0x006c:
            java.lang.String r9 = "trainticketv2"
            boolean r8 = r8.equals(r9)
            if (r8 == 0) goto L_0x00c4
            r8 = 3
            goto L_0x00c5
        L_0x0077:
            boolean r8 = r8.equals(r11)
            if (r8 == 0) goto L_0x00c4
            r8 = 10
            goto L_0x00c5
        L_0x0080:
            boolean r8 = r8.equals(r12)
            if (r8 == 0) goto L_0x00c4
            r8 = 5
            goto L_0x00c5
        L_0x0088:
            boolean r8 = r8.equals(r5)
            if (r8 == 0) goto L_0x00c4
            r8 = 8
            goto L_0x00c5
        L_0x0091:
            boolean r8 = r8.equals(r13)
            if (r8 == 0) goto L_0x00c4
            r8 = 9
            goto L_0x00c5
        L_0x009a:
            boolean r8 = r8.equals(r14)
            if (r8 == 0) goto L_0x00c4
            r8 = 6
            goto L_0x00c5
        L_0x00a2:
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L_0x00c4
            r8 = 7
            goto L_0x00c5
        L_0x00aa:
            boolean r8 = r8.equals(r15)
            if (r8 == 0) goto L_0x00c4
            r8 = 0
            goto L_0x00c5
        L_0x00b2:
            java.lang.String r9 = "bustickets"
            boolean r8 = r8.equals(r9)
            if (r8 == 0) goto L_0x00c4
            r8 = 1
            goto L_0x00c5
        L_0x00bc:
            boolean r8 = r8.equals(r2)
            if (r8 == 0) goto L_0x00c4
            r8 = 2
            goto L_0x00c5
        L_0x00c4:
            r8 = -1
        L_0x00c5:
            switch(r8) {
                case 0: goto L_0x018a;
                case 1: goto L_0x018a;
                case 2: goto L_0x0176;
                case 3: goto L_0x0176;
                case 4: goto L_0x0162;
                case 5: goto L_0x014e;
                case 6: goto L_0x013a;
                case 7: goto L_0x0114;
                case 8: goto L_0x00f2;
                case 9: goto L_0x00de;
                case 10: goto L_0x00ca;
                default: goto L_0x00c8;
            }
        L_0x00c8:
            goto L_0x019e
        L_0x00ca:
            java.lang.String r0 = r3.getURLType()
            boolean r0 = com.travel.utils.p.h(r0)
            if (r0 == 0) goto L_0x019e
            android.util.Pair r0 = new android.util.Pair
            java.lang.Integer r1 = java.lang.Integer.valueOf(r6)
            r0.<init>(r11, r1)
            return r0
        L_0x00de:
            java.lang.String r0 = r3.getURLType()
            boolean r0 = com.travel.utils.p.c(r0)
            if (r0 == 0) goto L_0x019e
            android.util.Pair r0 = new android.util.Pair
            java.lang.Integer r1 = java.lang.Integer.valueOf(r6)
            r0.<init>(r13, r1)
            return r0
        L_0x00f2:
            java.lang.String r0 = r3.getURLType()
            boolean r0 = r0.equalsIgnoreCase(r5)
            if (r0 == 0) goto L_0x019e
            java.lang.String r0 = r3.getURL()
            java.lang.String r2 = r7.getURL()
            boolean r0 = r0.contains(r2)
            if (r0 == 0) goto L_0x019e
            android.util.Pair r0 = new android.util.Pair
            java.lang.Integer r1 = java.lang.Integer.valueOf(r6)
            r0.<init>(r5, r1)
            return r0
        L_0x0114:
            java.lang.String r2 = r3.getURLType()
            boolean r2 = r2.equalsIgnoreCase(r0)
            if (r2 == 0) goto L_0x019e
            java.lang.String r2 = r3.getURL()
            java.lang.String r2 = android.net.Uri.decode(r2)
            java.lang.String r5 = r7.getURL()
            boolean r2 = r2.contains(r5)
            if (r2 == 0) goto L_0x019e
            android.util.Pair r1 = new android.util.Pair
            java.lang.Integer r2 = java.lang.Integer.valueOf(r6)
            r1.<init>(r0, r2)
            return r1
        L_0x013a:
            java.lang.String r0 = r3.getURLType()
            boolean r0 = com.travel.utils.p.g(r0)
            if (r0 == 0) goto L_0x019e
            android.util.Pair r0 = new android.util.Pair
            java.lang.Integer r1 = java.lang.Integer.valueOf(r6)
            r0.<init>(r14, r1)
            return r0
        L_0x014e:
            java.lang.String r0 = r3.getURLType()
            boolean r0 = com.travel.utils.p.a(r0)
            if (r0 == 0) goto L_0x019e
            android.util.Pair r0 = new android.util.Pair
            java.lang.Integer r1 = java.lang.Integer.valueOf(r6)
            r0.<init>(r12, r1)
            return r0
        L_0x0162:
            java.lang.String r0 = r3.getURLType()
            boolean r0 = com.travel.utils.p.e(r0)
            if (r0 == 0) goto L_0x019e
            android.util.Pair r0 = new android.util.Pair
            java.lang.Integer r1 = java.lang.Integer.valueOf(r6)
            r0.<init>(r10, r1)
            return r0
        L_0x0176:
            java.lang.String r0 = r3.getURLType()
            boolean r0 = com.travel.utils.p.b(r0)
            if (r0 == 0) goto L_0x019e
            android.util.Pair r0 = new android.util.Pair
            java.lang.Integer r1 = java.lang.Integer.valueOf(r6)
            r0.<init>(r2, r1)
            return r0
        L_0x018a:
            java.lang.String r0 = r3.getURLType()
            boolean r0 = com.travel.utils.p.d(r0)
            if (r0 == 0) goto L_0x019e
            android.util.Pair r0 = new android.util.Pair
            java.lang.Integer r1 = java.lang.Integer.valueOf(r6)
            r0.<init>(r15, r1)
            return r0
        L_0x019e:
            int r6 = r6 + 1
            r2 = -1
            r0 = r16
            goto L_0x0035
        L_0x01a5:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.travels.activity.AJRTravelsHomeActivity.k():android.util.Pair");
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        StringBuilder sb = new StringBuilder("TravelsHomeActivity :: onActivityResult requestCode ");
        sb.append(i2);
        sb.append(" resultCode ");
        sb.append(i3);
        if (i3 != -1) {
            Fragment m2 = m();
            if (m2 != null) {
                m2.onActivityResult(i2, i3, intent);
            }
        } else if (i2 == 101) {
            b(this.f28455d);
        } else if (i2 == f28449g) {
            l();
        } else {
            Fragment m3 = m();
            new StringBuilder("TravelsHomeActivity :: onActivityResult current Fragment ").append(m3);
            if (m3 != null) {
                m3.onActivityResult(i2, i3, intent);
            }
        }
    }

    /* access modifiers changed from: private */
    public void l() {
        int i2;
        d.a();
        d.b().b(this);
        n.b(getApplicationContext(), n.a((Context) this, n.a()));
        Intent intent = new Intent(this, AJRTravelsHomeActivity.class);
        List<CJRHomePageItem> list = this.o;
        if (list != null && list.size() > (i2 = this.q)) {
            intent.putExtra("extra_home_data", this.o.get(i2));
        }
        intent.putExtra(f28451i, this.q);
        finish();
        startActivity(intent);
    }

    private Fragment m() {
        SparseArray<Fragment> sparseArray;
        int i2;
        com.travel.travels.a.b bVar = this.n;
        if (bVar != null) {
            sparseArray = bVar.f28428b;
        } else {
            sparseArray = null;
        }
        if (sparseArray == null || sparseArray.size() <= 0 || (i2 = this.q) < 0) {
            return null;
        }
        return sparseArray.get(i2);
    }

    private void a(CJRHomePageItem cJRHomePageItem) {
        List<CJRHomePageItem> list = this.o;
        if (list != null && list.size() > 0) {
            int i2 = 0;
            for (CJRHomePageItem next : this.o) {
                if (next.getURLType() != null && (next.getURLType().equalsIgnoreCase("travelpass") || next.getURLType().equalsIgnoreCase("travel-pass-about") || next.getURLType().equalsIgnoreCase("travel-pass-details") || next.getURLType().equalsIgnoreCase("travel-my-pass"))) {
                    break;
                }
                i2++;
            }
            if (i2 == 0 || i2 >= this.o.size()) {
                Intent intent = new Intent(this, TravelGenericNavActivity.class);
                intent.putExtra("deeplink", "paytmmp://" + cJRHomePageItem.getURLType());
                startActivity(intent);
                return;
            }
            this.k.setCurrentItem(i2);
        }
    }

    private void b(CJRHomePageItem cJRHomePageItem) {
        if (cJRHomePageItem != null) {
            String str = "paytmmp://" + cJRHomePageItem.getURLType();
            String uRLType = cJRHomePageItem.getURLType();
            CJRHomePageItem a2 = i.a(getApplicationContext(), str);
            if (!TextUtils.isEmpty(uRLType)) {
                d.a();
                startActivity(d.b().a(uRLType, getApplicationContext(), a2));
            }
        }
    }

    public void onProvideAssistContent(AssistContent assistContent) {
        super.onProvideAssistContent(assistContent);
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("@type", "TaxiReservation");
                jSONObject.put("name", "Book  Bus");
                jSONObject.put("url", "https://paytm.com/bus-tickets");
                assistContent.setStructuredData(jSONObject.toString());
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public void onProvideAssistData(Bundle bundle) {
        super.onProvideAssistData(bundle);
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        try {
            Fragment m2 = m();
            if (m2 != null) {
                m2.onRequestPermissionsResult(i2, strArr, iArr);
            }
        } catch (Exception unused) {
        }
    }

    private void n() {
        if (!o()) {
            CJRItem cJRItem = this.x;
            CJRHomePageItem cJRHomePageItem = cJRItem != null ? (CJRHomePageItem) cJRItem : null;
            if (c(cJRHomePageItem)) {
                Intent intent = new Intent(this, TravelGenericNavActivity.class);
                intent.putExtra("deeplink", cJRHomePageItem.getURL());
                startActivity(intent);
            }
        }
    }

    private static boolean c(CJRHomePageItem cJRHomePageItem) {
        if (cJRHomePageItem == null || TextUtils.isEmpty(cJRHomePageItem.getURLType())) {
            return false;
        }
        return !p.i(cJRHomePageItem.getURLType());
    }

    private boolean o() {
        return ((Integer) k().second).intValue() != -1;
    }

    static /* synthetic */ void b(AJRTravelsHomeActivity aJRTravelsHomeActivity) {
        try {
            Intent intent = new Intent("android.settings.APPLICATION_DEVELOPMENT_SETTINGS");
            intent.setFlags(1073741824);
            aJRTravelsHomeActivity.startActivity(intent);
        } catch (Exception unused) {
        }
    }

    static /* synthetic */ void a(AJRTravelsHomeActivity aJRTravelsHomeActivity, String str, String str2) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("train_user_id", com.paytm.utility.b.n(aJRTravelsHomeActivity.getApplicationContext()) != null ? com.paytm.utility.b.n(aJRTravelsHomeActivity.getApplicationContext()) : "");
            hashMap.put("travel_cross_promotion_clicked", str2);
            hashMap.put("travel_current_tab_cross_promotion", str);
            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "Travel Homepage");
            d.a();
            d.b().a("cross_promotion_tab_clicked", (Map<String, Object>) hashMap, aJRTravelsHomeActivity.getApplicationContext());
        } catch (Exception e2) {
            com.paytm.utility.q.c(e2.getMessage());
        }
    }

    static /* synthetic */ void l(AJRTravelsHomeActivity aJRTravelsHomeActivity) {
        Intent intent = new Intent();
        d.a();
        d.b().b(aJRTravelsHomeActivity, intent, f28449g);
    }

    static /* synthetic */ void a(AJRTravelsHomeActivity aJRTravelsHomeActivity, CJRHomePageItem cJRHomePageItem) {
        int i2;
        List<CJRHomePageItem> list = aJRTravelsHomeActivity.o;
        if (list != null && list.size() > 0 && aJRTravelsHomeActivity.o.size() > (i2 = aJRTravelsHomeActivity.q) && aJRTravelsHomeActivity.o.get(i2) != null && !TextUtils.isEmpty(aJRTravelsHomeActivity.o.get(aJRTravelsHomeActivity.q).getName())) {
            o.a aVar = o.f28549a;
            String name = aJRTravelsHomeActivity.o.get(aJRTravelsHomeActivity.q).getName();
            String name2 = cJRHomePageItem.getName();
            k.c(name, "fromVertical");
            k.c(name2, "toTab");
            o.a.a("cross_promotion_bottom_tab_clicked", name, name2);
        }
        if ("travelpreferences".equals(cJRHomePageItem.getURLType()) || "travelmybookings".equals(cJRHomePageItem.getURLType())) {
            if (!"travelmybookings".equals(cJRHomePageItem.getURLType()) || com.paytm.utility.b.c(aJRTravelsHomeActivity.getApplicationContext())) {
                aJRTravelsHomeActivity.f28455d = cJRHomePageItem;
                boolean z2 = true;
                String b2 = r.a(aJRTravelsHomeActivity.getApplicationContext()).b("sso_token=", "", true);
                if (b2 == null || b2.length() <= 0) {
                    z2 = false;
                }
                if (!z2) {
                    Intent intent = new Intent();
                    d.a();
                    d.b().a((Context) aJRTravelsHomeActivity, intent, 101);
                    return;
                }
                aJRTravelsHomeActivity.b(aJRTravelsHomeActivity.f28455d);
                return;
            }
            aJRTravelsHomeActivity.a((Context) aJRTravelsHomeActivity);
        } else if ("travelexplore".equals(cJRHomePageItem.getURLType())) {
            if (!com.paytm.utility.b.c(aJRTravelsHomeActivity.getApplicationContext())) {
                aJRTravelsHomeActivity.a((Context) aJRTravelsHomeActivity);
                return;
            }
            d.a();
            d.b().a(aJRTravelsHomeActivity.getApplicationContext(), cJRHomePageItem.getURL());
        } else if (CLPConstants.GA_CHANNEL_NAME.equals(cJRHomePageItem.getURLType())) {
            Intent intent2 = new Intent(aJRTravelsHomeActivity, AJRTravelOffersActivity.class);
            intent2.putExtra("bundle_extra_category_item", cJRHomePageItem);
            intent2.putExtra("extra_home_data", aJRTravelsHomeActivity.x);
            aJRTravelsHomeActivity.startActivity(intent2);
        } else if ("travelhelp".equals(cJRHomePageItem.getURLType())) {
            if (!com.paytm.utility.b.c(aJRTravelsHomeActivity.getApplicationContext())) {
                aJRTravelsHomeActivity.a((Context) aJRTravelsHomeActivity);
                return;
            }
            try {
                String url = cJRHomePageItem.getURL();
                if (!TextUtils.isEmpty(url)) {
                    d.a();
                    d.b().a((Context) aJRTravelsHomeActivity, url);
                }
            } catch (Exception unused) {
            }
        } else if (!p.a(cJRHomePageItem.getURLType())) {
        } else {
            if (!com.paytm.utility.b.c(aJRTravelsHomeActivity.getApplicationContext())) {
                aJRTravelsHomeActivity.a((Context) aJRTravelsHomeActivity);
            } else {
                aJRTravelsHomeActivity.a(cJRHomePageItem);
            }
        }
    }
}
