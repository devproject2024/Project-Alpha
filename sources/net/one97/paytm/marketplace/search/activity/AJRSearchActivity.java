package net.one97.paytm.marketplace.search.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.URLUtil;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.appsflyer.internal.referrer.Payload;
import com.business.merchant_payments.common.utility.AppConstants;
import com.business.merchant_payments.settlement.helper.P4BSettlementsDataHelperMP;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.a;
import com.paytm.utility.q;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.paytmmall.clpartifact.utils.GAUtil;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.g.b.k;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.app.CJRJarvisApplication;
import net.one97.paytm.common.b.e;
import net.one97.paytm.common.entity.CJRFilterValue;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.shopping.CJRGrid;
import net.one97.paytm.common.entity.shopping.CJRGridProduct;
import net.one97.paytm.common.entity.shopping.CJRHomePageDetailV2;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.common.entity.shopping.CJRHomePageV2;
import net.one97.paytm.common.entity.shopping.CJRSearchCuration;
import net.one97.paytm.common.entity.shopping.CJRSearchLayout;
import net.one97.paytm.common.entity.shopping.CJRSearchPage;
import net.one97.paytm.common.entity.shopping.CJRSearchSuggestion;
import net.one97.paytm.common.entity.shopping.CJRUrlUtmData;
import net.one97.paytm.common.entity.shopping.StringResponse;
import net.one97.paytm.j.c;
import net.one97.paytm.marketplace.search.a.b;
import net.one97.paytm.marketplace.search.a.d;
import net.one97.paytm.marketplace.search.a.f;
import net.one97.paytm.marketplace.search.model.CJRSearchPageV2;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.paytm_finance.R;
import net.one97.paytm.upi.util.UpiUtils;
import net.one97.paytm.utils.ShimmerFrameLayout;
import net.one97.paytm.utils.ac;
import net.one97.paytm.utils.ag;
import net.one97.paytm.utils.r;

public class AJRSearchActivity extends PaytmActivity implements b.C0957b, d.b {

    /* renamed from: a  reason: collision with root package name */
    public static ArrayList<CJRSearchLayout> f53438a;

    /* renamed from: g  reason: collision with root package name */
    public static final Integer f53439g = 8;
    private String A;
    private String B = "";
    private String C;
    private String D;
    /* access modifiers changed from: private */
    public HashMap<String, String> E;
    /* access modifiers changed from: private */
    public boolean F = false;
    private TextView G;
    private String H = Payload.TYPE_STORE;
    private String I = P4BSettlementsDataHelperMP.ONLINE_SETTLEMENT;
    private String J;
    private String K = "";
    private HashMap<String, String> L;
    private Context M;
    private RecyclerView N;
    private RecyclerView O;
    private RecyclerView P;
    private f Q;
    private f R;
    private f S;
    private Group T;
    private Group U;
    private Group V;
    /* access modifiers changed from: private */
    public CJRHomePageV2 W;
    private TextView X;
    private FrameLayout Y;
    private boolean Z = false;
    /* access modifiers changed from: private */
    public ImageView aa;
    /* access modifiers changed from: private */
    public ConstraintLayout ab;
    /* access modifiers changed from: private */
    public Group ac;
    private ShimmerFrameLayout ad;
    private ShimmerFrameLayout ae;
    private String af = "";

    /* renamed from: b  reason: collision with root package name */
    public String f53440b;

    /* renamed from: c  reason: collision with root package name */
    public String f53441c;

    /* renamed from: d  reason: collision with root package name */
    public String f53442d;

    /* renamed from: e  reason: collision with root package name */
    public String f53443e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f53444f;

    /* renamed from: h  reason: collision with root package name */
    ArrayList<CJRHomePageItem> f53445h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public EditText f53446i;
    private RecyclerView j;
    private Group k;
    private RecyclerView l;
    private TextView m;
    /* access modifiers changed from: private */
    public b n;
    private d o;
    private CJRSearchPage p;
    /* access modifiers changed from: private */
    public CJRSearchPage q;
    /* access modifiers changed from: private */
    public String r = "";
    private TextView s;
    /* access modifiers changed from: private */
    public LottieAnimationView t;
    private CharSequence u;
    private boolean v;
    private boolean w;
    private CJRHomePageItem x;
    private boolean y = false;
    private String z;

    public void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        this.M = this;
        this.u = getIntent().getStringExtra(CLPConstants.EXTRA_INTENT_HEADER_EDITABLE);
        this.v = getIntent().getBooleanExtra("is_from_search", false);
        this.w = getIntent().getBooleanExtra("is_from_grid", false);
        this.C = getIntent().getStringExtra(AppConstants.TAG_CHILD_SITE_ID);
        this.f53443e = getIntent().getStringExtra("badge_url");
        this.f53440b = getIntent().getStringExtra("logo_url");
        this.f53441c = getIntent().getStringExtra("banner_url");
        this.f53442d = getIntent().getStringExtra("display_title");
        this.D = getIntent().getStringExtra("brand_tag_slot");
        this.af = getIntent().getStringExtra("from");
        this.E = (HashMap) getIntent().getSerializableExtra(CLPConstants.EXTRA_INTENT_CONTEXT_PARAMS_OBJECT);
        if (getIntent().getStringExtra(CLPConstants.CONTEXT_STORE_CATEGORY_NAME) != null) {
            this.H = getIntent().getStringExtra(CLPConstants.CONTEXT_STORE_CATEGORY_NAME);
        }
        try {
            CJRHomePageItem cJRHomePageItem = (CJRHomePageItem) getIntent().getSerializableExtra("extra_home_data");
            if (!(cJRHomePageItem == null || cJRHomePageItem.getQueryString() == null)) {
                this.A = cJRHomePageItem.getQueryString();
            }
        } catch (Exception unused) {
        }
        Intent intent = getIntent();
        if (!(intent == null || intent.getExtras() == null)) {
            this.Z = intent.getExtras().getBoolean("isMall");
        }
        HashMap<String, String> hashMap = this.E;
        if (hashMap != null && hashMap.size() > 0) {
            this.F = true;
            if (this.E.get(CLPConstants.DISCOVERABILITY) != null) {
                this.I = this.E.get(CLPConstants.DISCOVERABILITY);
            }
        }
        String b2 = ag.a(getApplicationContext()).b("search_cookie", "", true);
        if (!TextUtils.isEmpty(b2)) {
            str = b2 + ";_ga=" + a.w(this);
        } else {
            str = "_ga=" + a.w(this);
        }
        this.J = str;
        setContentView((int) R.layout.activity_search_paytm_v2);
        if (getSupportActionBar() != null) {
            getSupportActionBar().f();
        }
        this.aa = (ImageView) findViewById(R.id.clear_search_icon);
        this.X = (TextView) findViewById(R.id.header_text_tag);
        this.T = (Group) findViewById(R.id.verical_widget_layout);
        this.V = (Group) findViewById(R.id.popular_service_widget_layout);
        this.U = (Group) findViewById(R.id.ads_widget_layout);
        this.O = (RecyclerView) findViewById(R.id.ads_horizontal_recycler);
        this.N = (RecyclerView) findViewById(R.id.category_horizontal_recycler);
        this.P = (RecyclerView) findViewById(R.id.popularRecyclerView);
        this.j = (RecyclerView) findViewById(R.id.listView);
        this.k = (Group) findViewById(R.id.no_search_results_view);
        this.m = (TextView) findViewById(R.id.shopping_offers_header);
        this.l = (RecyclerView) findViewById(R.id.shopping_offers_rv);
        this.s = (TextView) findViewById(R.id.search_suggestion_keywords_tv);
        this.n = new b(this, new CJRSearchPage(), this);
        this.o = new d(this, new CJRSearchPage(), this);
        this.j.setAdapter(this.o);
        this.j.setLayoutManager(new LinearLayoutManager(this.M, 1, false));
        this.t = (LottieAnimationView) findViewById(R.id.lyt_search_progress_bar);
        this.G = (TextView) findViewById(R.id.no_result_txt_view);
        this.ab = (ConstraintLayout) findViewById(R.id.no_network_layout);
        this.Y = (FrameLayout) findViewById(R.id.upi_layout);
        this.ac = (Group) findViewById(R.id.searchMainLayout);
        this.f53446i = (EditText) findViewById(R.id.searchHeader).findViewById(R.id.search_action_bar);
        this.ad = (ShimmerFrameLayout) findViewById(R.id.topServicesShimmer);
        this.ae = (ShimmerFrameLayout) findViewById(R.id.listShimmer);
        this.f53446i.requestFocus();
        ((ImageView) findViewById(R.id.back_arrow)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AJRSearchActivity.this.onBackPressed();
            }
        });
        this.aa.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AJRSearchActivity.this.f53446i.setText("");
            }
        });
        ArrayList<CJRSearchLayout> c2 = c();
        f53438a = c2;
        if (c2 == null) {
            f53438a = new ArrayList<>();
        }
        try {
            net.one97.paytm.j.a.a("screen_loaded_search", "Search Screen" + a(getIntent()), getApplicationContext());
        } catch (Exception unused2) {
        }
        if (getIntent().hasExtra("query")) {
            String stringExtra = getIntent().getStringExtra("query");
            this.y = false;
            this.z = "organic";
            this.f53446i.setText(stringExtra);
            c(stringExtra);
            this.f53446i.clearFocus();
        }
        if (!this.F || !"1".equalsIgnoreCase(this.E.get("merchantSearch"))) {
            a();
            if (getIntent().getBooleanExtra("SHOW_SMART_WIDGET_SEARCH", true) && a.m(this)) {
                e();
            }
        } else {
            LottieAnimationView lottieAnimationView = this.t;
            if (lottieAnimationView != null) {
                lottieAnimationView.setVisibility(8);
            }
        }
        this.f53446i.setHint(getResources().getString(R.string.search_paytm));
        if (this.F && "1".equalsIgnoreCase(this.E.get("merchantSearch"))) {
            EditText editText = this.f53446i;
            String string = getResources().getString(R.string.search_bar_hint);
            String str2 = this.E.get("searchLabel");
            if (!TextUtils.isEmpty(str2)) {
                string = str2;
            }
            editText.setHint(string);
        }
        CharSequence charSequence = this.u;
        if (charSequence != null && !charSequence.toString().isEmpty() && this.v) {
            this.f53446i.setText(this.u);
        }
        if (this.I.equalsIgnoreCase(P4BSettlementsDataHelperMP.OFFLINE_SETTLEMENT)) {
            this.f53446i.setHint(getResources().getString(R.string.search_within_offline_store, new Object[]{this.H}));
        }
        if (this.F && !TextUtils.isEmpty(this.E.get("merchant_id"))) {
            if (this.I.equalsIgnoreCase(P4BSettlementsDataHelperMP.OFFLINE_SETTLEMENT)) {
                this.f53446i.setHint(this.E.get("searchLabel"));
            } else {
                this.f53446i.setHint(getResources().getString(R.string.search));
            }
        }
        this.f53446i.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                return AJRSearchActivity.this.a(textView, i2, keyEvent);
            }
        });
        this.f53446i.addTextChangedListener(new TextWatcher() {

            /* renamed from: b  reason: collision with root package name */
            private final boolean f53469b = false;

            public final void afterTextChanged(Editable editable) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            /* JADX WARNING: Code restructure failed: missing block: B:9:0x003a, code lost:
                if ("0".equalsIgnoreCase((java.lang.String) net.one97.paytm.marketplace.search.activity.AJRSearchActivity.i(r3.f53468a).get("merchantSearch")) != false) goto L_0x003c;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void onTextChanged(java.lang.CharSequence r4, int r5, int r6, int r7) {
                /*
                    r3 = this;
                    net.one97.paytm.marketplace.search.activity.AJRSearchActivity r5 = net.one97.paytm.marketplace.search.activity.AJRSearchActivity.this     // Catch:{ Exception -> 0x00ff }
                    r6 = 0
                    r5.a((boolean) r6)     // Catch:{ Exception -> 0x00ff }
                    java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x00ff }
                    boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x00ff }
                    if (r5 != 0) goto L_0x0014
                    java.lang.String r4 = r4.replaceAll("\\s+", " ")     // Catch:{ Exception -> 0x00ff }
                L_0x0014:
                    net.one97.paytm.marketplace.search.activity.AJRSearchActivity r5 = net.one97.paytm.marketplace.search.activity.AJRSearchActivity.this     // Catch:{ Exception -> 0x00ff }
                    java.lang.String unused = r5.r = r4     // Catch:{ Exception -> 0x00ff }
                    net.one97.paytm.marketplace.search.activity.AJRSearchActivity r5 = net.one97.paytm.marketplace.search.activity.AJRSearchActivity.this     // Catch:{ Exception -> 0x00ff }
                    r5.g()     // Catch:{ Exception -> 0x00ff }
                    net.one97.paytm.marketplace.search.activity.AJRSearchActivity r5 = net.one97.paytm.marketplace.search.activity.AJRSearchActivity.this     // Catch:{ Exception -> 0x00ff }
                    boolean r5 = r5.F     // Catch:{ Exception -> 0x00ff }
                    java.lang.String r7 = "merchantSearch"
                    java.lang.String r0 = "0"
                    if (r5 == 0) goto L_0x003c
                    net.one97.paytm.marketplace.search.activity.AJRSearchActivity r5 = net.one97.paytm.marketplace.search.activity.AJRSearchActivity.this     // Catch:{ Exception -> 0x00ff }
                    java.util.HashMap r5 = r5.E     // Catch:{ Exception -> 0x00ff }
                    java.lang.Object r5 = r5.get(r7)     // Catch:{ Exception -> 0x00ff }
                    java.lang.String r5 = (java.lang.String) r5     // Catch:{ Exception -> 0x00ff }
                    boolean r5 = r0.equalsIgnoreCase(r5)     // Catch:{ Exception -> 0x00ff }
                    if (r5 == 0) goto L_0x0041
                L_0x003c:
                    net.one97.paytm.marketplace.search.activity.AJRSearchActivity r5 = net.one97.paytm.marketplace.search.activity.AJRSearchActivity.this     // Catch:{ Exception -> 0x00ff }
                    net.one97.paytm.marketplace.search.activity.AJRSearchActivity.b((net.one97.paytm.marketplace.search.activity.AJRSearchActivity) r5, (java.lang.String) r4)     // Catch:{ Exception -> 0x00ff }
                L_0x0041:
                    boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x00ff }
                    r1 = 8
                    if (r5 != 0) goto L_0x0053
                    net.one97.paytm.marketplace.search.activity.AJRSearchActivity r5 = net.one97.paytm.marketplace.search.activity.AJRSearchActivity.this     // Catch:{ Exception -> 0x00ff }
                    android.widget.ImageView r5 = r5.aa     // Catch:{ Exception -> 0x00ff }
                    r5.setVisibility(r6)     // Catch:{ Exception -> 0x00ff }
                    goto L_0x005c
                L_0x0053:
                    net.one97.paytm.marketplace.search.activity.AJRSearchActivity r5 = net.one97.paytm.marketplace.search.activity.AJRSearchActivity.this     // Catch:{ Exception -> 0x00ff }
                    android.widget.ImageView r5 = r5.aa     // Catch:{ Exception -> 0x00ff }
                    r5.setVisibility(r1)     // Catch:{ Exception -> 0x00ff }
                L_0x005c:
                    r5 = 1
                    if (r4 == 0) goto L_0x0085
                    int r2 = r4.length()     // Catch:{ Exception -> 0x00ff }
                    if (r2 <= r5) goto L_0x0085
                    net.one97.paytm.marketplace.search.activity.AJRSearchActivity r5 = net.one97.paytm.marketplace.search.activity.AJRSearchActivity.this     // Catch:{ Exception -> 0x00ff }
                    boolean r5 = r5.F     // Catch:{ Exception -> 0x00ff }
                    if (r5 != 0) goto L_0x0073
                    net.one97.paytm.marketplace.search.activity.AJRSearchActivity r5 = net.one97.paytm.marketplace.search.activity.AJRSearchActivity.this     // Catch:{ Exception -> 0x00ff }
                    r5.a((java.lang.String) r4)     // Catch:{ Exception -> 0x00ff }
                    return
                L_0x0073:
                    net.one97.paytm.marketplace.search.activity.AJRSearchActivity r4 = net.one97.paytm.marketplace.search.activity.AJRSearchActivity.this     // Catch:{ Exception -> 0x00ff }
                    com.airbnb.lottie.LottieAnimationView r4 = r4.t     // Catch:{ Exception -> 0x00ff }
                    if (r4 == 0) goto L_0x00ff
                    net.one97.paytm.marketplace.search.activity.AJRSearchActivity r4 = net.one97.paytm.marketplace.search.activity.AJRSearchActivity.this     // Catch:{ Exception -> 0x00ff }
                    com.airbnb.lottie.LottieAnimationView r4 = r4.t     // Catch:{ Exception -> 0x00ff }
                    r4.setVisibility(r1)     // Catch:{ Exception -> 0x00ff }
                    return
                L_0x0085:
                    if (r4 == 0) goto L_0x00ff
                    int r2 = r4.length()     // Catch:{ Exception -> 0x00ff }
                    if (r2 > r5) goto L_0x00ff
                    net.one97.paytm.marketplace.search.activity.AJRSearchActivity r2 = net.one97.paytm.marketplace.search.activity.AJRSearchActivity.this     // Catch:{ Exception -> 0x00ff }
                    net.one97.paytm.marketplace.search.a.b r2 = r2.n     // Catch:{ Exception -> 0x00ff }
                    if (r2 == 0) goto L_0x009e
                    net.one97.paytm.marketplace.search.activity.AJRSearchActivity r2 = net.one97.paytm.marketplace.search.activity.AJRSearchActivity.this     // Catch:{ Exception -> 0x00ff }
                    net.one97.paytm.marketplace.search.a.b r2 = r2.n     // Catch:{ Exception -> 0x00ff }
                    r2.a(r4)     // Catch:{ Exception -> 0x00ff }
                L_0x009e:
                    net.one97.paytm.marketplace.search.activity.AJRSearchActivity r2 = net.one97.paytm.marketplace.search.activity.AJRSearchActivity.this     // Catch:{ Exception -> 0x00ff }
                    net.one97.paytm.common.entity.shopping.CJRSearchPage r2 = r2.q     // Catch:{ Exception -> 0x00ff }
                    if (r2 == 0) goto L_0x00b2
                    net.one97.paytm.marketplace.search.activity.AJRSearchActivity r6 = net.one97.paytm.marketplace.search.activity.AJRSearchActivity.this     // Catch:{ Exception -> 0x00ff }
                    net.one97.paytm.marketplace.search.activity.AJRSearchActivity r7 = net.one97.paytm.marketplace.search.activity.AJRSearchActivity.this     // Catch:{ Exception -> 0x00ff }
                    net.one97.paytm.common.entity.shopping.CJRSearchPage r7 = r7.q     // Catch:{ Exception -> 0x00ff }
                    r6.a((net.one97.paytm.common.entity.shopping.CJRSearchPage) r7)     // Catch:{ Exception -> 0x00ff }
                    goto L_0x00f4
                L_0x00b2:
                    net.one97.paytm.marketplace.search.activity.AJRSearchActivity r2 = net.one97.paytm.marketplace.search.activity.AJRSearchActivity.this     // Catch:{ Exception -> 0x00ff }
                    com.airbnb.lottie.LottieAnimationView r2 = r2.t     // Catch:{ Exception -> 0x00ff }
                    if (r2 == 0) goto L_0x00d5
                    net.one97.paytm.marketplace.search.activity.AJRSearchActivity r2 = net.one97.paytm.marketplace.search.activity.AJRSearchActivity.this     // Catch:{ Exception -> 0x00ff }
                    boolean r2 = r2.F     // Catch:{ Exception -> 0x00ff }
                    if (r2 == 0) goto L_0x00cc
                    net.one97.paytm.marketplace.search.activity.AJRSearchActivity r6 = net.one97.paytm.marketplace.search.activity.AJRSearchActivity.this     // Catch:{ Exception -> 0x00ff }
                    com.airbnb.lottie.LottieAnimationView r6 = r6.t     // Catch:{ Exception -> 0x00ff }
                    r6.setVisibility(r1)     // Catch:{ Exception -> 0x00ff }
                    goto L_0x00d5
                L_0x00cc:
                    net.one97.paytm.marketplace.search.activity.AJRSearchActivity r1 = net.one97.paytm.marketplace.search.activity.AJRSearchActivity.this     // Catch:{ Exception -> 0x00ff }
                    com.airbnb.lottie.LottieAnimationView r1 = r1.t     // Catch:{ Exception -> 0x00ff }
                    r1.setVisibility(r6)     // Catch:{ Exception -> 0x00ff }
                L_0x00d5:
                    net.one97.paytm.marketplace.search.activity.AJRSearchActivity r6 = net.one97.paytm.marketplace.search.activity.AJRSearchActivity.this     // Catch:{ Exception -> 0x00ff }
                    boolean r6 = r6.F     // Catch:{ Exception -> 0x00ff }
                    if (r6 == 0) goto L_0x00ef
                    net.one97.paytm.marketplace.search.activity.AJRSearchActivity r6 = net.one97.paytm.marketplace.search.activity.AJRSearchActivity.this     // Catch:{ Exception -> 0x00ff }
                    java.util.HashMap r6 = r6.E     // Catch:{ Exception -> 0x00ff }
                    java.lang.Object r6 = r6.get(r7)     // Catch:{ Exception -> 0x00ff }
                    java.lang.String r6 = (java.lang.String) r6     // Catch:{ Exception -> 0x00ff }
                    boolean r6 = r0.equalsIgnoreCase(r6)     // Catch:{ Exception -> 0x00ff }
                    if (r6 == 0) goto L_0x00f4
                L_0x00ef:
                    net.one97.paytm.marketplace.search.activity.AJRSearchActivity r6 = net.one97.paytm.marketplace.search.activity.AJRSearchActivity.this     // Catch:{ Exception -> 0x00ff }
                    r6.a()     // Catch:{ Exception -> 0x00ff }
                L_0x00f4:
                    boolean r4 = r4.isEmpty()     // Catch:{ Exception -> 0x00ff }
                    if (r4 == 0) goto L_0x00ff
                    net.one97.paytm.marketplace.search.activity.AJRSearchActivity r4 = net.one97.paytm.marketplace.search.activity.AJRSearchActivity.this     // Catch:{ Exception -> 0x00ff }
                    r4.a((boolean) r5)     // Catch:{ Exception -> 0x00ff }
                L_0x00ff:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.marketplace.search.activity.AJRSearchActivity.AnonymousClass9.onTextChanged(java.lang.CharSequence, int, int, int):void");
            }
        });
        if (!TextUtils.isEmpty(this.A)) {
            this.f53446i.setText(this.A);
            this.r = this.A;
            a(this.r);
        }
    }

    public static String a(Intent intent) {
        String b2 = b(intent);
        return TextUtils.isEmpty(b2) ? "" : "_".concat(String.valueOf(b2));
    }

    private void b(boolean z2) {
        if (z2) {
            this.ad.setVisibility(0);
            this.ad.a();
            return;
        }
        this.ad.setVisibility(4);
        this.ad.b();
    }

    private void c(boolean z2) {
        if (z2) {
            this.ad.setVisibility(8);
        } else {
            this.ad.setVisibility(4);
        }
    }

    /* access modifiers changed from: private */
    public void d(boolean z2) {
        if (z2) {
            this.ae.setVisibility(8);
        } else {
            this.ae.setVisibility(4);
        }
    }

    /* access modifiers changed from: private */
    public void e(boolean z2) {
        if (z2) {
            this.ae.setVisibility(0);
            this.ae.a();
            return;
        }
        this.ae.setVisibility(4);
        this.ae.b();
    }

    private static ArrayList<CJRSearchLayout> c() {
        if (net.one97.paytm.common.b.d.a() == null) {
            return null;
        }
        return net.one97.paytm.common.b.d.a().d();
    }

    public final void a() {
        try {
            c.a();
            String a2 = c.a("popularsearch", (String) null);
            if (URLUtil.isValidUrl(a2)) {
                e(true);
                String d2 = com.paytm.utility.b.d((Context) this, a2);
                String f2 = f();
                HashMap hashMap = new HashMap();
                if (!TextUtils.isEmpty(f2)) {
                    hashMap.put("search_user_id", m(f2));
                }
                hashMap.put("Cookie", this.J);
                final String j2 = j(d2);
                final com.paytm.network.b bVar = new com.paytm.network.b();
                bVar.f42877a = getApplicationContext();
                bVar.f42880d = j2;
                bVar.f42882f = hashMap;
                bVar.f42879c = a.C0715a.GET;
                bVar.f42878b = a.c.MALL;
                bVar.o = "Search";
                bVar.z = false;
                bVar.k = false;
                bVar.n = a.b.SILENT;
                bVar.f42884h = null;
                bVar.j = new com.paytm.network.listener.b() {
                    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                        if (iJRPaytmDataModel instanceof CJRSearchPage) {
                            AJRSearchActivity.a(AJRSearchActivity.this, (CJRSearchPage) iJRPaytmDataModel);
                        }
                    }

                    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                        AJRSearchActivity.this.a(networkCustomError, j2, bVar);
                    }
                };
                bVar.f42885i = new CJRSearchPage();
                if (com.paytm.utility.a.m(this)) {
                    bVar.l().a();
                } else {
                    a(bVar);
                }
            }
        } catch (Exception unused) {
        }
    }

    public final void a(String str) {
        String str2 = "?";
        try {
            StringBuilder sb = new StringBuilder();
            c.a();
            sb.append(c.a("autosuggest_v2", (String) null));
            sb.append("?s=");
            sb.append(URLEncoder.encode(str, com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.UTF_8).replace("+", "%20"));
            final String d2 = com.paytm.utility.b.d((Context) this, sb.toString());
            if (!URLUtil.isValidUrl(d2)) {
                com.paytm.utility.b.b((Context) this, getResources().getString(R.string.error), getResources().getString(R.string.msg_invalid_url));
                return;
            }
            if (this.F) {
                d2 = i(d2);
            }
            String f2 = f();
            HashMap hashMap = new HashMap();
            if (!TextUtils.isEmpty(f2)) {
                hashMap.put("search_user_id", m(f2));
                hashMap.put("Cookie", this.J);
            }
            if (d2 != null && this.Z) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(d2);
                if (d2.contains(str2)) {
                    str2 = com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.AND_SIGN;
                }
                sb2.append(str2);
                d2 = sb2.toString() + "site_tab=mall";
            }
            final com.paytm.network.b bVar = new com.paytm.network.b();
            bVar.f42877a = getApplicationContext();
            bVar.f42879c = a.C0715a.GET;
            bVar.f42882f = hashMap;
            bVar.f42880d = d2;
            bVar.f42878b = a.c.MALL;
            bVar.o = "Search";
            bVar.k = false;
            bVar.n = a.b.SILENT;
            bVar.f42884h = null;
            bVar.k = false;
            bVar.j = new com.paytm.network.listener.b() {
                public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                    if (iJRPaytmDataModel instanceof CJRSearchPageV2) {
                        AJRSearchActivity.a(AJRSearchActivity.this, (CJRSearchPageV2) iJRPaytmDataModel);
                    }
                }

                public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                    AJRSearchActivity.this.a(networkCustomError, d2, bVar);
                }
            };
            bVar.f42885i = new CJRSearchPageV2();
            if (com.paytm.utility.a.m(this)) {
                bVar.l().a();
            }
        } catch (UnsupportedEncodingException unused) {
        }
    }

    /* access modifiers changed from: private */
    public void a(CJRSearchPage cJRSearchPage) {
        this.X.setVisibility(8);
        d();
        this.o.a(cJRSearchPage);
        this.j.setAdapter(this.o);
    }

    private void a(CJRSearchPage cJRSearchPage, boolean z2) {
        String str = this.r;
        if (str == null) {
            return;
        }
        if (z2) {
            if (str.length() <= 1) {
                a(cJRSearchPage);
            }
        } else if (str.length() > 1) {
            this.P.setVisibility(8);
            if (cJRSearchPage.getKeyWordsLayoutList() == null || !cJRSearchPage.getKeyWordsLayoutList().isEmpty()) {
                this.X.setText(getString(R.string.marketplace_serch));
                this.X.setVisibility(0);
            } else {
                this.X.setVisibility(8);
            }
            b bVar = this.n;
            k.c(cJRSearchPage, "searchpage");
            bVar.f53337a = cJRSearchPage.getKeyWordsLayoutList();
            bVar.f53338b = cJRSearchPage.getProductsLayoutList();
            bVar.f53340d = cJRSearchPage.getmSearchPopularProductsList();
            bVar.notifyDataSetChanged();
            b bVar2 = this.n;
            if (bVar2 != null) {
                bVar2.a(this.r);
            }
            this.j.setAdapter(this.n);
            if (cJRSearchPage instanceof CJRSearchPageV2) {
                CJRSearchPageV2 cJRSearchPageV2 = (CJRSearchPageV2) cJRSearchPage;
                ArrayList<CJRHomePageItem> arrayList = cJRSearchPageV2.getmRelatedServicesList();
                if (arrayList == null || arrayList.isEmpty()) {
                    this.V.setVisibility(8);
                    this.T.setVisibility(8);
                    return;
                }
                ArrayList<CJRHomePageItem> a2 = a(getIntent(), cJRSearchPageV2.getmRelatedServicesList(), Boolean.FALSE);
                if (!a2.isEmpty()) {
                    a((ArrayList<CJRHomePageItem>) null, a2);
                    ((TextView) findViewById(R.id.suggestion_txt)).setText(getResources().getString(R.string.related_services));
                    this.T.setVisibility(0);
                    return;
                }
                this.T.setVisibility(8);
            }
        }
    }

    public final void a(final com.paytm.network.b bVar) {
        LottieAnimationView lottieAnimationView = this.t;
        if (lottieAnimationView != null) {
            lottieAnimationView.setVisibility(8);
        }
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        View currentFocus = getCurrentFocus();
        if (currentFocus != null) {
            this.f53446i.clearFocus();
            this.f53446i.setEnabled(false);
            inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
        }
        Group group = this.T;
        if (group != null && group.getVisibility() == 0) {
            this.T.setVisibility(8);
            c(true);
        }
        Group group2 = this.ac;
        if (group2 != null && group2.getVisibility() == 0) {
            this.ac.setVisibility(8);
        }
        g();
        d(true);
        c(true);
        this.ab.setVisibility(0);
        ConstraintLayout constraintLayout = this.ab;
        if (constraintLayout != null) {
            constraintLayout.findViewById(R.id.retry_network).setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    if (com.paytm.utility.a.m(AJRSearchActivity.this.getApplicationContext())) {
                        bVar.l().a();
                        AJRSearchActivity.this.e();
                        AJRSearchActivity.this.d(false);
                        AJRSearchActivity.this.ac.setVisibility(0);
                        AJRSearchActivity.this.e(true);
                        AJRSearchActivity.this.ab.setVisibility(8);
                        AJRSearchActivity.this.f53446i.setEnabled(true);
                        return;
                    }
                    AJRSearchActivity.this.a(bVar);
                }
            });
        }
    }

    public void onDestroy() {
        super.onDestroy();
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
            }
        } catch (Exception unused) {
        }
    }

    public void onResume() {
        InputMethodManager inputMethodManager;
        super.onResume();
        this.K = "";
        this.L = null;
        if (this.f53446i != null && com.paytm.utility.a.m(this)) {
            this.f53446i.requestFocus();
            this.f53446i.setEnabled(true);
            if (com.paytm.utility.a.m(this) && (inputMethodManager = (InputMethodManager) getSystemService("input_method")) != null) {
                inputMethodManager.toggleSoftInput(0, 2);
            }
        }
        a(true);
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean a(TextView textView, int i2, KeyEvent keyEvent) {
        if (i2 != 3 && i2 != 2 && i2 != 6) {
            return false;
        }
        this.y = false;
        this.L = null;
        this.z = "organic";
        c(textView.getText().toString());
        this.f53446i.clearFocus();
        return true;
    }

    private void c(String str) {
        try {
            c.a();
            String a2 = c.a("searchurl_v2", (String) null);
            if (URLUtil.isValidUrl(a2) && !TextUtils.isEmpty(str)) {
                String trim = str.trim();
                this.x = new CJRHomePageItem();
                this.x.setSearchUrl(a2);
                this.x.setSearcKey(trim);
                this.f53444f = false;
                a(a2, trim);
                d(trim, "");
            }
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    public void d() {
        if (this.W != null) {
            b(false);
            ((TextView) findViewById(R.id.suggestion_txt)).setText(getResources().getString(R.string.popular_service));
            ArrayList<CJRHomePageItem> a2 = a(getIntent(), net.one97.paytm.landingpage.c.a(this.W), Boolean.TRUE);
            if (a2.isEmpty()) {
                this.V.setVisibility(8);
                c(true);
            } else {
                this.V.setVisibility(0);
                c(false);
            }
            ConstraintLayout constraintLayout = this.ab;
            if (constraintLayout != null && constraintLayout.getVisibility() == 0) {
                this.V.setVisibility(8);
                this.U.setVisibility(8);
                c(true);
            }
            a(a2, (ArrayList<CJRHomePageItem>) null);
        }
    }

    private void a(ArrayList<CJRHomePageItem> arrayList, ArrayList<CJRHomePageItem> arrayList2) {
        if (arrayList != null) {
            this.P.setVisibility(0);
            this.N.setVisibility(8);
            f fVar = this.R;
            if (fVar == null) {
                this.R = new f(this.M, arrayList, (List<CJRHomePageItem>) null, "", this.af);
                this.R.f53426a = true;
                GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 4);
                this.P.addItemDecoration(new net.one97.paytm.marketplace.search.utils.a());
                this.P.setNestedScrollingEnabled(false);
                this.P.setLayoutManager(gridLayoutManager);
                this.P.setAdapter(this.R);
                return;
            }
            fVar.a(arrayList, (ArrayList<CJRHomePageItem>) null);
        } else if (arrayList2 != null) {
            this.P.setVisibility(8);
            this.N.setVisibility(0);
            f fVar2 = this.Q;
            if (fVar2 == null) {
                this.N.setLayoutManager(new LinearLayoutManager(this.M, 0, false));
                this.Q = new f(this.M, (List<CJRHomePageItem>) null, arrayList2, "", this.af);
                f fVar3 = this.Q;
                fVar3.f53426a = true;
                this.N.setAdapter(fVar3);
                return;
            }
            fVar2.a((ArrayList<CJRHomePageItem>) null, arrayList2);
        }
    }

    private static ArrayList<CJRHomePageItem> a(Intent intent, ArrayList<CJRHomePageItem> arrayList, Boolean bool) {
        ArrayList<CJRHomePageItem> arrayList2 = new ArrayList<>();
        String b2 = b(intent);
        if (TextUtils.isEmpty(b2)) {
            return bool.booleanValue() ? a(arrayList) : arrayList;
        }
        Iterator<CJRHomePageItem> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            CJRHomePageItem next = it2.next();
            if (next != null && b2.equalsIgnoreCase(next.getVertical())) {
                arrayList2.add(next);
            }
        }
        return (!bool.booleanValue() || arrayList2.isEmpty()) ? arrayList2 : a(arrayList2);
    }

    private static ArrayList<CJRHomePageItem> a(ArrayList<CJRHomePageItem> arrayList) {
        ArrayList<CJRHomePageItem> arrayList2 = new ArrayList<>();
        for (int i2 = 0; i2 < f53439g.intValue(); i2++) {
            arrayList2.add(arrayList.get(i2));
        }
        return arrayList2;
    }

    private static String b(Intent intent) {
        Uri parse;
        String stringExtra = intent.hasExtra("deeplink") ? intent.getStringExtra("deeplink") : "";
        if (TextUtils.isEmpty(stringExtra) || (parse = Uri.parse(stringExtra)) == null) {
            return "";
        }
        return parse.getQueryParameter("vertical");
    }

    /* access modifiers changed from: private */
    public void e() {
        if (this.Z) {
            c(true);
            return;
        }
        b(true);
        c.a();
        String a2 = c.a("search_widget_url", (String) null);
        if (TextUtils.isEmpty(a2)) {
            a2 = "https://storefront.paytm.com/v2/h/search-screen";
        }
        net.one97.paytm.landingpage.c.a(com.paytm.utility.a.c(this.M, a2), (com.paytm.network.listener.b) new com.paytm.network.listener.b() {
            public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                CJRHomePageV2 unused = AJRSearchActivity.this.W = (CJRHomePageV2) iJRPaytmDataModel;
                AJRSearchActivity.this.f53445h = new ArrayList<>();
                Iterator<CJRHomePageDetailV2> it2 = AJRSearchActivity.this.W.getmPage().iterator();
                while (it2.hasNext()) {
                    CJRHomePageDetailV2 next = it2.next();
                    if ("294990".equals(next.getmId())) {
                        AJRSearchActivity.this.f53445h.addAll(next.getHomePageLayoutList().get(0).getHomePageItemList());
                    }
                }
                AJRSearchActivity.this.a(true);
                AJRSearchActivity.this.d();
            }

            public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                AJRSearchActivity.this.a(false);
            }
        }, this.M);
    }

    private void a(String str, final String str2) {
        String str3;
        try {
            this.t.setVisibility(0);
            g();
            if (Uri.parse(str).getQuery() != null) {
                str3 = str + "&userQuery=" + URLEncoder.encode(str2, com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.UTF_8) + "&from=" + URLEncoder.encode(this.z, com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.UTF_8) + "&cat_tree=1&curated=1";
            } else {
                str3 = str + "?userQuery=" + URLEncoder.encode(str2, com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.UTF_8) + "&from=" + URLEncoder.encode(this.z, com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.UTF_8) + "&cat_tree=1&curated=1";
            }
            if (this.L != null && this.L.size() > 0) {
                Uri.Builder buildUpon = Uri.parse(str3).buildUpon();
                for (Map.Entry next : this.L.entrySet()) {
                    buildUpon.appendQueryParameter((String) next.getKey(), (String) next.getValue());
                }
                str3 = buildUpon.build().toString();
            }
            if (this.F) {
                str3 = i(str3);
            }
            if (this.x != null) {
                this.x.setSearchUrl(str3);
            }
            if (this.C != null && this.B != null && this.B.contains("Brand Store") && this.f53444f) {
                str3 = str3 + "&child_site_id=" + this.C;
            }
            if (!URLUtil.isValidUrl(str3)) {
                com.paytm.utility.b.b((Context) this, getResources().getString(R.string.error), getResources().getString(R.string.msg_invalid_url));
                return;
            }
            String c2 = com.paytm.utility.a.c(this, str3);
            HashMap hashMap = new HashMap();
            String f2 = f();
            if (!TextUtils.isEmpty(f2)) {
                hashMap.put("search_user_id", m(f2));
                hashMap.put("Cookie", this.J);
            }
            final String f3 = f(d(j(c2)));
            final com.paytm.network.b bVar = new com.paytm.network.b();
            bVar.f42877a = getApplicationContext();
            bVar.f42879c = a.C0715a.GET;
            bVar.f42882f = hashMap;
            bVar.f42878b = a.c.MALL;
            bVar.o = "Search";
            bVar.f42885i = new StringResponse() {
                public final StringResponse parseResponse(String str, com.google.gsonhtcfix.f fVar) throws Exception {
                    setResponse(str);
                    return this;
                }
            };
            bVar.n = a.b.SILENT;
            bVar.f42884h = null;
            bVar.f42880d = f3;
            bVar.k = false;
            bVar.j = new com.paytm.network.listener.b() {
                public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                    if (iJRPaytmDataModel instanceof StringResponse) {
                        String response = ((StringResponse) iJRPaytmDataModel).getResponse();
                        if (!TextUtils.isEmpty(response)) {
                            AJRSearchActivity.a(AJRSearchActivity.this, response, str2);
                        }
                    }
                }

                public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                    AJRSearchActivity.this.a(networkCustomError, f3, bVar);
                }
            };
            if (com.paytm.utility.a.m(this)) {
                bVar.l().a();
            } else {
                a(bVar);
            }
        } catch (Exception unused) {
        }
    }

    private static String d(String str) {
        try {
            return Uri.parse(str).buildUpon().appendQueryParameter("allow_spe", "1").toString();
        } catch (Exception unused) {
            return str;
        }
    }

    private String e(String str) {
        Uri.Builder buildUpon = Uri.parse(str).buildUpon();
        Context applicationContext = getApplicationContext();
        String c2 = net.one97.paytm.marketplace.a.c(applicationContext);
        if (!TextUtils.isEmpty(c2)) {
            buildUpon.appendQueryParameter("pin_code", c2);
        }
        HashMap<String, String> d2 = net.one97.paytm.marketplace.a.d(applicationContext);
        if (d2 != null) {
            for (Map.Entry next : d2.entrySet()) {
                buildUpon.appendQueryParameter((String) next.getKey(), (String) next.getValue());
            }
        }
        return buildUpon.build().toString();
    }

    private static String f(String str) {
        try {
            return Uri.parse(str).buildUpon().appendQueryParameter("page_count", "1").appendQueryParameter("items_per_page", "16").toString();
        } catch (Exception unused) {
            return str;
        }
    }

    private void b(String str, String str2) {
        d dVar;
        CJRSearchLayout cJRSearchLayout = new CJRSearchLayout();
        cJRSearchLayout.setText(this.x.getSearchKey());
        cJRSearchLayout.setmFilterAttributes(this.L);
        if (TextUtils.isEmpty(str2) || !net.one97.paytm.marketplace.a.a(str2)) {
            cJRSearchLayout.setPaytm(Boolean.TRUE);
        } else {
            cJRSearchLayout.setAPIUrl(str);
            cJRSearchLayout.setPaytm(Boolean.FALSE);
        }
        if (!(f53438a == null || (dVar = this.o) == null || dVar.f53395b != f53438a.size())) {
            ArrayList<CJRSearchLayout> arrayList = f53438a;
            arrayList.remove(arrayList.size() - 1);
        }
        e a2 = net.one97.paytm.common.b.d.a();
        if (a2 != null) {
            a2.a((Activity) this, cJRSearchLayout);
        }
    }

    private String f() {
        return ag.a(getApplicationContext()).b("search_user_id", "", true);
    }

    private void g(String str) {
        if (!TextUtils.isEmpty(str)) {
            String f2 = f();
            if (TextUtils.isEmpty(f2) || !str.equalsIgnoreCase(f2)) {
                ag.a(getApplicationContext()).a("search_user_id", str, true);
            }
        }
    }

    private boolean h(String str) {
        ArrayList<CJRSearchLayout> keyWordsLayoutList;
        if (str == null) {
            return false;
        }
        try {
            if (this.o != null) {
                int i2 = this.o.f53395b;
                if (f53438a != null) {
                    int size = f53438a.size();
                    if (size < i2) {
                        i2 = size;
                    }
                    for (int i3 = 0; i3 < i2; i3++) {
                        if (str.equalsIgnoreCase(f53438a.get(i3).getText())) {
                            f53438a.remove(i3);
                            e a2 = net.one97.paytm.common.b.d.a();
                            if (a2 != null) {
                                a2.b(i3);
                            }
                            return false;
                        }
                    }
                }
            }
            if (!(this.q == null || (keyWordsLayoutList = this.q.getKeyWordsLayoutList()) == null)) {
                for (int i4 = 0; i4 < keyWordsLayoutList.size(); i4++) {
                    if (str.equalsIgnoreCase(keyWordsLayoutList.get(i4).getText())) {
                        return true;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x0109  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0128  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x012e  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0175 A[Catch:{ Exception -> 0x01dc }] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x01a1 A[Catch:{ Exception -> 0x01dc }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(java.lang.String r21, net.one97.paytm.common.entity.IJRDataModel r22, java.lang.String r23, java.lang.String r24) {
        /*
            r20 = this;
            r0 = r20
            r1 = r21
            r2 = r22
            r3 = r23
            android.content.Intent r4 = new android.content.Intent
            r4.<init>()
            java.lang.String r5 = "search"
            boolean r6 = r1.equalsIgnoreCase(r5)
            java.lang.String r7 = "badge_url"
            java.lang.String r8 = "display_title"
            java.lang.String r9 = "banner_url"
            java.lang.String r10 = "logo_url"
            java.lang.String r11 = "Brand Store"
            java.lang.String r12 = "UTF-8"
            java.lang.String r13 = "is_from_search"
            java.lang.String r14 = "extra_home_data"
            java.lang.String r15 = "AJRGridPageActivityTag"
            r16 = r15
            java.lang.String r15 = "origin"
            r17 = r5
            java.lang.String r5 = "grid"
            r18 = r5
            java.lang.String r5 = "product"
            java.lang.String r19 = ""
            if (r6 == 0) goto L_0x0086
            r4.putExtra(r14, r2)
            r1 = r2
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r1 = (net.one97.paytm.common.entity.shopping.CJRHomePageItem) r1
            r6 = 0
            r1.setCategoryId(r6)
            r1 = 1
            r4.putExtra(r13, r1)
            r1 = 0
            java.lang.String r6 = "modify_url"
            r4.putExtra(r6, r1)
            java.lang.String r1 = r0.f53441c
            if (r1 == 0) goto L_0x007c
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x007c
            java.lang.String r1 = r0.B
            if (r1 == 0) goto L_0x007c
            boolean r1 = r1.contains(r11)
            if (r1 == 0) goto L_0x007c
            boolean r1 = r0.f53444f
            if (r1 == 0) goto L_0x007c
            java.lang.String r1 = r0.f53440b
            r4.putExtra(r10, r1)
            java.lang.String r1 = r0.f53441c
            r4.putExtra(r9, r1)
            java.lang.String r1 = r0.f53442d
            r4.putExtra(r8, r1)
            java.lang.String r1 = r0.f53443e
            r4.putExtra(r7, r1)
            java.lang.String r1 = r0.C
            java.lang.String r6 = "child_site_id"
            r4.putExtra(r6, r1)
        L_0x007c:
            java.lang.String r1 = java.net.URLEncoder.encode(r3, r12)     // Catch:{ UnsupportedEncodingException -> 0x0083 }
            r4.putExtra(r15, r1)     // Catch:{ UnsupportedEncodingException -> 0x0083 }
        L_0x0083:
            r17 = r5
            goto L_0x009e
        L_0x0086:
            boolean r6 = r1.equalsIgnoreCase(r5)
            if (r6 == 0) goto L_0x00a1
            java.lang.String r1 = "cart_item_url"
            r3 = r24
            r4.putExtra(r1, r3)
            r1 = r17
            r4.putExtra(r15, r1)
            java.lang.String r15 = "AJRProductDetailActivityTag"
            r17 = r5
            r16 = r15
        L_0x009e:
            r6 = r18
            goto L_0x0105
        L_0x00a1:
            r6 = r18
            boolean r17 = r1.equalsIgnoreCase(r6)
            if (r17 != 0) goto L_0x00c0
            r17 = r5
            java.lang.String r5 = "list"
            boolean r5 = r1.equalsIgnoreCase(r5)
            if (r5 != 0) goto L_0x00c2
            java.lang.String r5 = "smart_list"
            boolean r1 = r1.equalsIgnoreCase(r5)
            if (r1 == 0) goto L_0x00bd
            goto L_0x00c2
        L_0x00bd:
            r16 = r19
            goto L_0x0105
        L_0x00c0:
            r17 = r5
        L_0x00c2:
            r4.putExtra(r14, r2)
            r1 = 1
            r4.putExtra(r13, r1)
            java.lang.String r1 = r0.f53441c
            if (r1 == 0) goto L_0x00fc
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x00fc
            java.lang.String r1 = r0.B
            if (r1 == 0) goto L_0x00fc
            boolean r1 = r1.contains(r11)
            if (r1 == 0) goto L_0x00fc
            boolean r1 = r0.f53444f
            if (r1 == 0) goto L_0x00fc
            java.lang.String r1 = r0.f53440b
            r4.putExtra(r10, r1)
            java.lang.String r1 = r0.f53441c
            r4.putExtra(r9, r1)
            java.lang.String r1 = r0.f53442d
            r4.putExtra(r8, r1)
            java.lang.String r1 = r0.f53443e
            r4.putExtra(r7, r1)
            java.lang.String r1 = r0.C
            java.lang.String r5 = "child_site_id"
            r4.putExtra(r5, r1)
        L_0x00fc:
            java.lang.String r1 = java.net.URLEncoder.encode(r3, r12)     // Catch:{ UnsupportedEncodingException -> 0x0104 }
            r4.putExtra(r15, r1)     // Catch:{ UnsupportedEncodingException -> 0x0104 }
            goto L_0x0105
        L_0x0104:
        L_0x0105:
            boolean r1 = r2 instanceof net.one97.paytm.common.entity.shopping.CJRHomePageItem
            if (r1 == 0) goto L_0x0124
            r1 = r2
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r1 = (net.one97.paytm.common.entity.shopping.CJRHomePageItem) r1
            java.lang.String r3 = r1.getSearchType()
            if (r3 == 0) goto L_0x0124
            java.lang.String r1 = r1.getSearchType()
            java.lang.String r3 = "popularsearch"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0124
            java.lang.String r1 = "is_normal_search"
            r3 = 1
            r4.putExtra(r1, r3)
        L_0x0124:
            boolean r1 = r0.w
            if (r1 == 0) goto L_0x012e
            r1 = -1
            r0.setResult(r1, r4)
            goto L_0x01df
        L_0x012e:
            java.lang.String r1 = net.one97.paytm.marketplace.a.d((java.lang.String) r16)
            r4.setClassName(r0, r1)
            net.one97.paytm.common.b.e r1 = net.one97.paytm.common.b.d.a()     // Catch:{ Exception -> 0x01dc }
            android.content.ComponentName r3 = r4.getComponent()     // Catch:{ Exception -> 0x01dc }
            if (r3 == 0) goto L_0x0156
            android.content.ComponentName r3 = r4.getComponent()     // Catch:{ Exception -> 0x01dc }
            java.lang.String r3 = r3.getClassName()     // Catch:{ Exception -> 0x01dc }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x01dc }
            if (r3 == 0) goto L_0x0156
            android.content.ComponentName r3 = r4.getComponent()     // Catch:{ Exception -> 0x01dc }
            java.lang.String r3 = r3.getClassName()     // Catch:{ Exception -> 0x01dc }
            goto L_0x0158
        L_0x0156:
            r3 = r19
        L_0x0158:
            if (r2 == 0) goto L_0x016b
            boolean r5 = r2 instanceof net.one97.paytm.common.entity.shopping.CJRHomePageItem     // Catch:{ Exception -> 0x01dc }
            if (r5 == 0) goto L_0x0164
            r5 = r2
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r5 = (net.one97.paytm.common.entity.shopping.CJRHomePageItem) r5     // Catch:{ Exception -> 0x01dc }
            java.lang.String r5 = r5.mSearchResultType     // Catch:{ Exception -> 0x01dc }
            goto L_0x016d
        L_0x0164:
            boolean r5 = r2 instanceof net.one97.paytm.common.entity.shopping.CJRGridProduct     // Catch:{ Exception -> 0x01dc }
            if (r5 == 0) goto L_0x016b
            r5 = r17
            goto L_0x016d
        L_0x016b:
            r5 = r19
        L_0x016d:
            java.lang.String r1 = r1.a((java.lang.String) r3, (java.lang.String) r5)     // Catch:{ Exception -> 0x01dc }
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r3 = r0.x     // Catch:{ Exception -> 0x01dc }
            if (r3 == 0) goto L_0x0199
            java.lang.String r19 = r3.getSearchUrl()     // Catch:{ Exception -> 0x01dc }
            boolean r5 = android.text.TextUtils.isEmpty(r19)     // Catch:{ Exception -> 0x01dc }
            if (r5 != 0) goto L_0x0199
            android.net.Uri r5 = android.net.Uri.parse(r19)     // Catch:{ Exception -> 0x01dc }
            android.net.Uri$Builder r5 = r5.buildUpon()     // Catch:{ Exception -> 0x01dc }
            java.lang.String r7 = "current_category"
            java.lang.String r3 = r3.getCategoryId()     // Catch:{ Exception -> 0x01dc }
            android.net.Uri$Builder r3 = r5.appendQueryParameter(r7, r3)     // Catch:{ Exception -> 0x01dc }
            android.net.Uri r3 = r3.build()     // Catch:{ Exception -> 0x01dc }
            java.lang.String r19 = r3.toString()     // Catch:{ Exception -> 0x01dc }
        L_0x0199:
            r3 = r19
            boolean r5 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x01dc }
            if (r5 != 0) goto L_0x01df
            boolean r5 = r1.equals(r6)     // Catch:{ Exception -> 0x01dc }
            if (r5 != 0) goto L_0x01b0
            r5 = r17
            boolean r7 = r1.equals(r5)     // Catch:{ Exception -> 0x01dc }
            if (r7 == 0) goto L_0x01df
            goto L_0x01b2
        L_0x01b0:
            r5 = r17
        L_0x01b2:
            boolean r6 = r1.equals(r6)     // Catch:{ Exception -> 0x01dc }
            if (r6 == 0) goto L_0x01c2
            net.one97.paytm.common.b.e r6 = net.one97.paytm.common.b.d.a()     // Catch:{ Exception -> 0x01dc }
            boolean r3 = r6.b((java.lang.String) r1, (java.lang.String) r3)     // Catch:{ Exception -> 0x01dc }
            if (r3 != 0) goto L_0x01d8
        L_0x01c2:
            boolean r3 = r1.equals(r5)     // Catch:{ Exception -> 0x01dc }
            if (r3 == 0) goto L_0x01df
            net.one97.paytm.common.b.e r3 = net.one97.paytm.common.b.d.a()     // Catch:{ Exception -> 0x01dc }
            net.one97.paytm.common.entity.shopping.CJRGridProduct r2 = (net.one97.paytm.common.entity.shopping.CJRGridProduct) r2     // Catch:{ Exception -> 0x01dc }
            java.lang.String r2 = r2.getURL()     // Catch:{ Exception -> 0x01dc }
            boolean r1 = r3.b((java.lang.String) r1, (java.lang.String) r2)     // Catch:{ Exception -> 0x01dc }
            if (r1 == 0) goto L_0x01df
        L_0x01d8:
            r0.startActivity(r4)     // Catch:{ Exception -> 0x01dc }
            goto L_0x01df
        L_0x01dc:
            r0.startActivity(r4)
        L_0x01df:
            r20.finish()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.marketplace.search.activity.AJRSearchActivity.a(java.lang.String, net.one97.paytm.common.entity.IJRDataModel, java.lang.String, java.lang.String):void");
    }

    /* access modifiers changed from: private */
    public void g() {
        Group group = this.k;
        if (group != null && group.getVisibility() != 8) {
            this.k.setVisibility(8);
        }
    }

    private void a(CJRGrid cJRGrid) {
        LottieAnimationView lottieAnimationView = this.t;
        if (lottieAnimationView != null) {
            lottieAnimationView.setVisibility(8);
        }
        EditText editText = this.f53446i;
        if (editText != null) {
            editText.requestFocus();
        }
        Group group = this.k;
        if (group != null) {
            group.setVisibility(0);
            if (this.F) {
                if (!TextUtils.isEmpty(this.E.get("merchant_id"))) {
                    if (this.F) {
                        this.G.setText(getResources().getString(R.string.no_results_merchant));
                    }
                } else if (!TextUtils.isEmpty(this.E.get("store_id"))) {
                    this.G.setText(getString(R.string.no_results_store, new Object[]{this.H}));
                }
            }
        }
        ArrayList<CJRSearchSuggestion> searchSuggestionList = (cJRGrid == null || cJRGrid.getSearchSuggestionList() == null) ? null : cJRGrid.getSearchSuggestionList();
        if (searchSuggestionList == null || searchSuggestionList.size() == 0) {
            this.s.setText(getString(R.string.search_try_again_different_keyword));
        } else {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append("Search for ");
            for (int i2 = 0; i2 < searchSuggestionList.size(); i2++) {
                final String value = searchSuggestionList.get(i2).getValue();
                spannableStringBuilder.append(value);
                spannableStringBuilder.setSpan(new ClickableSpan() {
                    public final void updateDrawState(TextPaint textPaint) {
                        textPaint.setColor(AJRSearchActivity.this.getResources().getColor(R.color.blue_dot));
                        textPaint.setUnderlineText(false);
                    }

                    public final void onClick(View view) {
                        if (AJRSearchActivity.this.f53446i != null) {
                            AJRSearchActivity.this.f53446i.setText(value);
                            AJRSearchActivity.this.f53446i.requestFocus();
                        }
                    }
                }, spannableStringBuilder.length() - value.length(), spannableStringBuilder.length(), 33);
                if (i2 != searchSuggestionList.size() - 1) {
                    spannableStringBuilder.append(", ");
                }
            }
            spannableStringBuilder.append(" instead");
            this.s.setMovementMethod(LinkMovementMethod.getInstance());
            this.s.setText(spannableStringBuilder);
        }
        r.a(this.M, "", "");
        HashMap<String, String> i3 = com.paytm.utility.a.i();
        final String b2 = com.paytm.utility.b.b((Context) this, "https://catalog.paytm.com/v1/g/paytm-home/exclusive-discount-deals");
        final com.paytm.network.b bVar = new com.paytm.network.b();
        bVar.f42877a = getApplicationContext();
        bVar.f42879c = a.C0715a.POST;
        bVar.f42880d = b2;
        bVar.n = a.b.SILENT;
        bVar.f42884h = null;
        bVar.f42878b = a.c.MALL;
        bVar.o = "Search";
        bVar.f42882f = i3;
        bVar.f42885i = new CJRGrid();
        bVar.j = new com.paytm.network.listener.b() {
            public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                if (iJRPaytmDataModel instanceof CJRGrid) {
                    AJRSearchActivity.a(AJRSearchActivity.this, (CJRGrid) iJRPaytmDataModel);
                }
            }

            public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                AJRSearchActivity.this.a(networkCustomError, b2, bVar);
            }
        };
        if (com.paytm.utility.a.m(this)) {
            bVar.l().a();
        } else {
            a(bVar);
        }
    }

    private void a(CJRGrid cJRGrid, String str) {
        String str2;
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("user_id", net.one97.paytm.j.a.b((Context) this));
            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/search");
            hashMap.put("event_label", str);
            if (!(cJRGrid == null || cJRGrid.getGridMeta() == null)) {
                hashMap.put("event_label3", cJRGrid.getGridMeta().getVersion() + ";" + this.K);
            }
            hashMap.put(SDKConstants.EVENT_KEY_EVENT_LABEL4, this.af);
            hashMap.put(net.one97.paytm.common.utility.d.cv, "search" + a(getIntent()));
            hashMap.put("event_category", "search");
            if ("organic".equalsIgnoreCase(this.z)) {
                str2 = "manual/organic";
            } else {
                str2 = this.z + "/organic";
            }
            hashMap.put("search_type", str2);
            hashMap.put("search_within_category", "");
            hashMap.put("search_term", str);
            hashMap.put("event_action", "no_results_".concat(String.valueOf(str2)));
            net.one97.paytm.j.a.b(GAUtil.CUSTOM_EVENT, (Map<String, Object>) hashMap, (Context) this);
        } catch (Exception unused) {
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            EditText editText = this.f53446i;
            if (editText != null) {
                editText.clearFocus();
            }
            finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public final void a(NetworkCustomError networkCustomError, String str, com.paytm.network.b bVar) {
        if (networkCustomError == null) {
            return;
        }
        if (!TextUtils.isEmpty(networkCustomError.getAlertMessage()) && ("410".equalsIgnoreCase(networkCustomError.getMessage()) || UpiUtils.AUTHENTICATION_FAILURE_401.equalsIgnoreCase(networkCustomError.getMessage()))) {
            r.a((Activity) this, (Exception) networkCustomError, (String) null, (Bundle) null);
        } else if (networkCustomError.getMessage() == null || r.a((Context) this, (Exception) networkCustomError)) {
            if ("NoConnectionError".equalsIgnoreCase(networkCustomError.mErrorType.name())) {
                a(bVar);
            }
        } else if (networkCustomError.getMessage() == null || !networkCustomError.getMessage().equalsIgnoreCase("parsing_error")) {
            com.paytm.utility.b.b((Context) this, getResources().getString(R.string.network_error_heading), getResources().getString(R.string.network_error_message) + " " + str);
        } else {
            com.paytm.utility.b.d((Context) this, str, String.valueOf(networkCustomError.getStatusCode()));
        }
    }

    public final void a(String str, String str2, String str3, String str4, HashMap<String, String> hashMap, CJRSearchCuration cJRSearchCuration) {
        try {
            this.K = str4;
            this.L = hashMap;
            if (URLUtil.isValidUrl(str) && !TextUtils.isEmpty(str3)) {
                String trim = str3.trim();
                this.x = new CJRHomePageItem();
                this.x.setSearchUrl(str);
                this.x.setSearcKey(trim);
                this.x.setTitle(trim);
                this.x.setSearchUrl(str);
                this.x.setSearcKey(trim);
                this.x.setTitle(trim);
                this.x.setSearchType("autosuggest");
                this.B = str2;
                this.x.setSearchCategory(str2);
                this.x.setSearchTerm(trim);
                this.z = "autosuggest";
                d(trim, trim);
                if (this.C != null) {
                    c(this.D, trim);
                }
                this.f53444f = true;
                if (cJRSearchCuration == null || TextUtils.isEmpty(cJRSearchCuration.getmAppUrl())) {
                    a(str, trim);
                } else {
                    ac.b(this, cJRSearchCuration.getmAppUrl());
                }
            }
        } catch (Exception unused) {
        }
    }

    public final void a(String str, CJRGridProduct cJRGridProduct) {
        this.L = null;
        if (cJRGridProduct == null) {
            cJRGridProduct = new CJRGridProduct();
        }
        a("product", (IJRDataModel) cJRGridProduct, "search", str);
    }

    public final void a(String str, int i2, HashMap<String, String> hashMap, CJRSearchCuration cJRSearchCuration) {
        this.F = false;
        this.y = true;
        this.L = hashMap;
        this.z = i2 == this.o.f53398e ? "recent" : "popularsearch";
        a(str, cJRSearchCuration);
        try {
            net.one97.paytm.j.a.a("search_hot_search_selected", "Search Screen" + a(getIntent()), "HOT_SEARCH_TERM", str, (Context) this);
        } catch (Exception unused) {
        }
    }

    private void a(String str, CJRSearchCuration cJRSearchCuration) {
        if (cJRSearchCuration == null || TextUtils.isEmpty(cJRSearchCuration.getmAppUrl())) {
            c(str);
            return;
        }
        if (this.x == null) {
            this.x = new CJRHomePageItem();
        }
        this.x.setSearcKey(str);
        h();
        d(str, "");
        ac.b(this, cJRSearchCuration.getmAppUrl());
    }

    private void h() {
        this.x.setSearchType(this.z);
        this.x.setAutoSuggestMetaData(this.K);
        this.x.setSearchCategory(this.B);
        this.x.setIsFromSearch(true);
        HashMap<String, Object> a2 = net.one97.paytm.marketplace.a.a(this.x);
        a2.put("search_term", this.x.getSearchKey());
        a2.put("experimentName", "");
        net.one97.paytm.marketplace.a.b(a2);
    }

    public final void b() {
        ArrayList<CJRSearchLayout> arrayList = f53438a;
        if (arrayList != null) {
            arrayList.clear();
        }
        e a2 = net.one97.paytm.common.b.d.a();
        if (a2 != null) {
            a2.e();
        }
        c();
        this.o.a(this.q);
    }

    public final void a(String str, String str2, HashMap<String, String> hashMap, CJRSearchCuration cJRSearchCuration) {
        this.y = true;
        this.z = "autosuggest";
        this.K = str2;
        this.L = hashMap;
        if (this.C != null) {
            c(this.D, str);
        }
        a(str, cJRSearchCuration);
    }

    private void c(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "BrandStore" + a(getIntent()));
        hashMap.put("brandstore_site_id", com.paytm.utility.a.b());
        hashMap.put("brandstore_brandtag", str);
        hashMap.put("brandstore_search_term", str2);
        hashMap.put(SDKConstants.EVENT_KEY_EVENT_LABEL4, this.af);
        net.one97.paytm.j.a.b("brandstore_search_performed", (Map<String, Object>) hashMap, (Context) this);
    }

    private String i(String str) {
        StringBuilder sb = new StringBuilder();
        try {
            boolean z2 = true;
            for (Map.Entry next : this.E.entrySet()) {
                if (z2) {
                    if (!str.contains("?")) {
                        sb = new StringBuilder("?" + ((String) next.getKey()) + "=" + URLEncoder.encode((String) next.getValue(), com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.UTF_8));
                        z2 = false;
                    }
                }
                sb.append(com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.AND_SIGN);
                sb.append((String) next.getKey());
                sb.append("=");
                sb.append(URLEncoder.encode((String) next.getValue(), com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.UTF_8));
                z2 = false;
            }
        } catch (UnsupportedEncodingException e2) {
            q.b(e2.getMessage());
        }
        return str + sb;
    }

    private void d(String str, String str2) {
        String str3;
        HashMap hashMap = new HashMap();
        hashMap.put("user_id", net.one97.paytm.j.a.b((Context) this));
        hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/search" + a(getIntent()));
        hashMap.put("event_label", str);
        hashMap.put("event_label3", this.K);
        String str4 = net.one97.paytm.common.utility.d.cv;
        hashMap.put(str4, "search" + a(getIntent()));
        hashMap.put("event_category", "search");
        hashMap.put("event_action", "input_submitted");
        if ("organic".equalsIgnoreCase(this.z)) {
            str3 = "manual";
        } else if ("recent".equalsIgnoreCase(this.z)) {
            str3 = "recent_search";
        } else if ("autosuggest".equalsIgnoreCase(this.z)) {
            EditText editText = this.f53446i;
            if (!(editText == null || editText.getText() == null || TextUtils.isEmpty(this.f53446i.getText().toString()))) {
                hashMap.put("oq", this.f53446i.getText().toString());
            }
            str3 = "auto";
        } else if ("popularsearch".equals(this.z)) {
            str3 = "hot_list";
        } else {
            str3 = this.z;
        }
        hashMap.put(SDKConstants.EVENT_KEY_EVENT_LABEL4, this.af);
        hashMap.put("search_type", str3);
        hashMap.put("search_within_category", str2);
        hashMap.put("search_term", str);
        net.one97.paytm.j.a.b(GAUtil.CUSTOM_EVENT, (Map<String, Object>) hashMap, (Context) this);
    }

    private static void i() {
        CJRUrlUtmData g2 = CJRJarvisApplication.g();
        if (g2 == null) {
            g2 = new CJRUrlUtmData();
            g2.addToUtmSource("search");
        } else if (!g2.isFromPush()) {
            g2.addToUtmSource("search");
        }
        CJRJarvisApplication.a(g2);
    }

    private String j(String str) {
        return k(e(l(str)));
    }

    private String k(String str) {
        Uri parse;
        if (str == null || str.contains("&vertical_id=")) {
            return str;
        }
        Intent intent = getIntent();
        String str2 = "";
        String stringExtra = intent.hasExtra("deeplink") ? intent.getStringExtra("deeplink") : str2;
        if (!TextUtils.isEmpty(stringExtra) && (parse = Uri.parse(stringExtra)) != null) {
            str2 = parse.getQueryParameter("vertical_id");
        }
        try {
            if (str2.isEmpty()) {
                return str;
            }
            if (str.contains("?")) {
                return str + "&vertical_id=" + URLEncoder.encode(str2, com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.UTF_8);
            }
            return str + "&vertical_id=".replace(com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.AND_SIGN, "?") + URLEncoder.encode(str2, com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.UTF_8);
        } catch (Exception e2) {
            q.b(e2.getMessage());
            return str;
        }
    }

    private static String l(String str) {
        if (str == null || str.contains("&site_id=")) {
            return str;
        }
        try {
            String b2 = com.paytm.utility.a.b();
            String b3 = com.paytm.utility.a.b();
            if (b2 != null) {
                if (str.contains("?")) {
                    str = str + "&child_site_id=" + URLEncoder.encode(b2, com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.UTF_8);
                } else {
                    str = str + "&child_site_id=".replace(com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.AND_SIGN, "?") + URLEncoder.encode(b2, com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.UTF_8);
                }
            }
            if (b3 == null) {
                return str;
            }
            return str + "&site_id=" + URLEncoder.encode(b3, com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.UTF_8);
        } catch (Exception e2) {
            q.b(e2.getMessage());
            return str;
        }
    }

    public final void a(boolean z2) {
        if (!com.paytm.utility.a.p(this) || !z2 || !net.one97.paytm.common.b.d.b().a("upi_onsearch_enable", false)) {
            this.Y.setVisibility(8);
            return;
        }
        this.Y.setVisibility(0);
        boolean e2 = net.one97.paytm.upi.registration.b.a.a.a.a((Context) this).e();
        boolean h2 = net.one97.paytm.upi.registration.b.a.a.a.a((Context) this).h();
        if (!e2 || !h2) {
            j();
        } else {
            k();
        }
    }

    private void j() {
        androidx.fragment.app.q a2 = getSupportFragmentManager().a();
        net.one97.paytm.addmoney.landing.view.b bVar = new net.one97.paytm.addmoney.landing.view.b();
        a(a2);
        Bundle bundle = new Bundle();
        bundle.putString("upi_address", "");
        bVar.setArguments(bundle);
        a2.a(R.id.upi_layout, bVar, "upiwidget").c();
    }

    private void k() {
        ArrayList<CJRHomePageItem> arrayList = this.f53445h;
        if (arrayList == null || arrayList.isEmpty()) {
            this.Y.setVisibility(8);
            return;
        }
        androidx.fragment.app.q a2 = getSupportFragmentManager().a();
        a(a2);
        net.one97.paytm.i.d dVar = new net.one97.paytm.i.d();
        Bundle bundle = new Bundle();
        bundle.putSerializable("banner_item_list", this.f53445h);
        dVar.setArguments(bundle);
        a2.a(R.id.upi_layout, dVar, "upibanner").c();
    }

    private void a(androidx.fragment.app.q qVar) {
        if (getSupportFragmentManager().c("upiwidget") != null) {
            qVar.a(getSupportFragmentManager().c("upiwidget"));
        }
        if (getSupportFragmentManager().c("upibanner") != null) {
            qVar.a(getSupportFragmentManager().c("upibanner"));
        }
    }

    private static Uri.Builder a(Uri.Builder builder, ArrayList<CJRFilterValue> arrayList) {
        StringBuilder sb = new StringBuilder();
        Iterator<CJRFilterValue> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            String id = it2.next().getID();
            if (id != null) {
                if (sb.length() == 0) {
                    sb.append(id);
                } else {
                    sb.append(com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.COMMA);
                    sb.append(id);
                }
            }
        }
        return builder.appendQueryParameter("category", sb.toString());
    }

    public void attachBaseContext(Context context) {
        super.attachBaseContext(net.one97.paytm.locale.b.e.a(context));
    }

    private static String m(String str) {
        try {
            return URLEncoder.encode(str, com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.UTF_8);
        } catch (UnsupportedEncodingException e2) {
            q.b(e2.getMessage());
            return str;
        }
    }

    static /* synthetic */ void a(AJRSearchActivity aJRSearchActivity, CJRSearchPage cJRSearchPage) {
        if (!aJRSearchActivity.isFinishing()) {
            aJRSearchActivity.e(false);
            if (cJRSearchPage.getSearchUserId() != null) {
                aJRSearchActivity.g(cJRSearchPage.getSearchUserId());
            }
            aJRSearchActivity.q = cJRSearchPage;
            aJRSearchActivity.a(aJRSearchActivity.q, true);
        }
    }

    static /* synthetic */ void a(AJRSearchActivity aJRSearchActivity, CJRSearchPageV2 cJRSearchPageV2) {
        if (!aJRSearchActivity.isFinishing()) {
            if (cJRSearchPageV2.getSearchUserId() != null) {
                aJRSearchActivity.g(cJRSearchPageV2.getSearchUserId());
            }
            aJRSearchActivity.p = cJRSearchPageV2;
            aJRSearchActivity.a(aJRSearchActivity.p, false);
        }
    }

    static /* synthetic */ void b(AJRSearchActivity aJRSearchActivity, String str) {
        ConstraintLayout constraintLayout;
        CJRHomePageV2 cJRHomePageV2 = aJRSearchActivity.W;
        if (cJRHomePageV2 != null) {
            ArrayList<CJRHomePageItem> a2 = net.one97.paytm.landingpage.c.a(cJRHomePageV2, str, "303514");
            if (a2 == null || a2.isEmpty() || str.length() < 3 || ((constraintLayout = aJRSearchActivity.ab) != null && constraintLayout.getVisibility() == 0)) {
                aJRSearchActivity.U.setVisibility(8);
                return;
            }
            aJRSearchActivity.U.setVisibility(0);
            f fVar = aJRSearchActivity.S;
            if (fVar == null) {
                aJRSearchActivity.O.setLayoutManager(new LinearLayoutManager(aJRSearchActivity.M, 0, false));
                aJRSearchActivity.S = new f(aJRSearchActivity.M, a2, (List<CJRHomePageItem>) null, "", aJRSearchActivity.af);
                f fVar2 = aJRSearchActivity.S;
                fVar2.f53426a = true;
                aJRSearchActivity.O.setAdapter(fVar2);
                return;
            }
            fVar.a(a2, (ArrayList<CJRHomePageItem>) null);
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(10:4|5|6|7|(1:9)|10|11|(3:13|14|(1:41)(5:18|(1:20)|21|(4:(1:31)(1:30)|32|(2:34|(1:38))|39)|40))(2:(2:47|(1:49)(2:50|(6:52|(2:54|(3:56|(14:58|(2:60|(12:62|63|64|(1:66)|67|71|(4:74|(2:76|114)(2:77|115)|112|72)|113|79|(3:83|(3:85|(2:87|117)(1:118)|88)|116)|89|(1:99)))|78|79|81|83|(0)|116|89|91|93|95|97|99)|100))|101|(1:103)|104|(1:108))))|109)|110|119) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x003b */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x005f A[SYNTHETIC, Splitter:B:13:0x005f] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x010f A[ADDED_TO_REGION, Catch:{ Exception -> 0x02cf }] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x01cc A[Catch:{ Exception -> 0x02cf }] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0041 A[Catch:{ Exception -> 0x02cf }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(net.one97.paytm.marketplace.search.activity.AJRSearchActivity r16, java.lang.String r17, java.lang.String r18) {
        /*
            r1 = r16
            r2 = r18
            java.lang.String r3 = "search"
            java.lang.String r0 = "url="
            net.one97.paytm.marketplace.a.b((java.lang.String) r17)     // Catch:{ Exception -> 0x02cf }
            com.google.gsonhtcfix.f r4 = new com.google.gsonhtcfix.f     // Catch:{ Exception -> 0x02cf }
            r4.<init>()     // Catch:{ Exception -> 0x02cf }
            java.lang.Class<net.one97.paytm.common.entity.shopping.CJRGrid> r5 = net.one97.paytm.common.entity.shopping.CJRGrid.class
            r6 = r17
            java.lang.Object r4 = r4.a((java.lang.String) r6, r5)     // Catch:{ Exception -> 0x02cf }
            net.one97.paytm.common.entity.shopping.CJRGrid r4 = (net.one97.paytm.common.entity.shopping.CJRGrid) r4     // Catch:{ Exception -> 0x02cf }
            boolean r5 = r16.isFinishing()     // Catch:{ Exception -> 0x02cf }
            if (r5 != 0) goto L_0x02cf
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r5 = r1.x     // Catch:{ Exception -> 0x003b }
            net.one97.paytm.common.entity.shopping.CJRGridMeta r6 = r4.getGridMeta()     // Catch:{ Exception -> 0x003b }
            java.lang.String r6 = r6.getExperimentName()     // Catch:{ Exception -> 0x003b }
            r5.setSearchABValue(r6)     // Catch:{ Exception -> 0x003b }
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r5 = r1.x     // Catch:{ Exception -> 0x003b }
            net.one97.paytm.common.entity.shopping.CJRGridMeta r6 = r4.getGridMeta()     // Catch:{ Exception -> 0x003b }
            java.lang.String r6 = r6.getExperimentName()     // Catch:{ Exception -> 0x003b }
            r5.setExperimentName(r6)     // Catch:{ Exception -> 0x003b }
        L_0x003b:
            java.lang.String r5 = r4.getSearchUserId()     // Catch:{ Exception -> 0x02cf }
            if (r5 == 0) goto L_0x0048
            java.lang.String r5 = r4.getSearchUserId()     // Catch:{ Exception -> 0x02cf }
            r1.g((java.lang.String) r5)     // Catch:{ Exception -> 0x02cf }
        L_0x0048:
            java.lang.String r5 = "curated"
            java.lang.String r6 = r4.getResultType()     // Catch:{ Exception -> 0x02cf }
            boolean r5 = r5.equalsIgnoreCase(r6)     // Catch:{ Exception -> 0x02cf }
            java.lang.String r6 = "experimentName"
            java.lang.String r7 = "search_term"
            java.lang.String r8 = "manual"
            java.lang.String r9 = "organic"
            java.lang.String r10 = ""
            r11 = 1
            if (r5 == 0) goto L_0x010f
            java.lang.String r2 = r4.getAppUrl()     // Catch:{ Exception -> 0x02cf }
            if (r2 == 0) goto L_0x0101
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x02cf }
            if (r3 != 0) goto L_0x0101
            java.lang.String r3 = r1.z     // Catch:{ Exception -> 0x02cf }
            boolean r3 = r9.equalsIgnoreCase(r3)     // Catch:{ Exception -> 0x02cf }
            if (r3 == 0) goto L_0x0075
            r1.z = r8     // Catch:{ Exception -> 0x02cf }
        L_0x0075:
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r3 = r1.x     // Catch:{ Exception -> 0x02cf }
            java.lang.String r5 = r1.z     // Catch:{ Exception -> 0x02cf }
            r3.setSearchType(r5)     // Catch:{ Exception -> 0x02cf }
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r3 = r1.x     // Catch:{ Exception -> 0x02cf }
            java.lang.String r5 = r4.getResultType()     // Catch:{ Exception -> 0x02cf }
            r3.setSearchResultType(r5)     // Catch:{ Exception -> 0x02cf }
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r3 = r1.x     // Catch:{ Exception -> 0x02cf }
            java.lang.String r5 = r1.K     // Catch:{ Exception -> 0x02cf }
            r3.setAutoSuggestMetaData(r5)     // Catch:{ Exception -> 0x02cf }
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r3 = r1.x     // Catch:{ Exception -> 0x02cf }
            java.lang.String r5 = r1.B     // Catch:{ Exception -> 0x02cf }
            r3.setSearchCategory(r5)     // Catch:{ Exception -> 0x02cf }
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r3 = r1.x     // Catch:{ Exception -> 0x02cf }
            r3.setIsFromSearch(r11)     // Catch:{ Exception -> 0x02cf }
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r3 = r1.x     // Catch:{ Exception -> 0x02cf }
            java.util.HashMap r3 = net.one97.paytm.marketplace.a.a((net.one97.paytm.common.entity.shopping.CJRHomePageItem) r3)     // Catch:{ Exception -> 0x02cf }
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r5 = r1.x     // Catch:{ Exception -> 0x02cf }
            java.lang.String r5 = r5.getSearchKey()     // Catch:{ Exception -> 0x02cf }
            r3.put(r7, r5)     // Catch:{ Exception -> 0x02cf }
            r3.put(r6, r10)     // Catch:{ Exception -> 0x02cf }
            net.one97.paytm.marketplace.a.b((java.util.HashMap<java.lang.String, java.lang.Object>) r3)     // Catch:{ Exception -> 0x02cf }
            r16.g()     // Catch:{ Exception -> 0x02cf }
            i()     // Catch:{ Exception -> 0x02cf }
            net.one97.paytm.deeplink.h$a r3 = net.one97.paytm.deeplink.h.f50349a     // Catch:{ Exception -> 0x02cf }
            r3 = 0
            net.one97.paytm.deeplink.h.a.a(r1, r2, r3)     // Catch:{ Exception -> 0x02cf }
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r5 = r1.x     // Catch:{ Exception -> 0x02cf }
            if (r5 == 0) goto L_0x00fc
            java.util.ArrayList<net.one97.paytm.common.entity.shopping.CJRSearchLayout> r5 = f53438a     // Catch:{ Exception -> 0x02cf }
            if (r5 == 0) goto L_0x00fc
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r5 = r1.x     // Catch:{ Exception -> 0x02cf }
            java.lang.String r5 = r5.getSearchKey()     // Catch:{ Exception -> 0x02cf }
            boolean r5 = r1.h((java.lang.String) r5)     // Catch:{ Exception -> 0x02cf }
            if (r5 != 0) goto L_0x00fc
            if (r2 == 0) goto L_0x00e0
            boolean r5 = r2.contains(r0)     // Catch:{ Exception -> 0x02cf }
            if (r5 == 0) goto L_0x00e0
            int r0 = r2.indexOf(r0)     // Catch:{ Exception -> 0x02cf }
            int r0 = r0 + 4
            java.lang.String r0 = r2.substring(r0)     // Catch:{ Exception -> 0x02cf }
            goto L_0x00e1
        L_0x00e0:
            r0 = r2
        L_0x00e1:
            boolean r5 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x02cf }
            if (r5 != 0) goto L_0x00f9
            net.one97.paytm.deeplink.i r5 = net.one97.paytm.deeplink.i.f50350a     // Catch:{ Exception -> 0x02cf }
            net.one97.paytm.deeplink.DeepLinkData r2 = net.one97.paytm.deeplink.i.a((android.content.Context) r1, (java.lang.String) r2, (android.os.Bundle) r3)     // Catch:{ Exception -> 0x02cf }
            if (r2 == 0) goto L_0x00f9
            java.lang.String r5 = r2.f50284b     // Catch:{ Exception -> 0x02cf }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x02cf }
            if (r5 != 0) goto L_0x00f9
            java.lang.String r3 = r2.f50284b     // Catch:{ Exception -> 0x02cf }
        L_0x00f9:
            r1.b((java.lang.String) r0, (java.lang.String) r3)     // Catch:{ Exception -> 0x02cf }
        L_0x00fc:
            r16.finish()     // Catch:{ Exception -> 0x02cf }
            goto L_0x02bd
        L_0x0101:
            r1.a((net.one97.paytm.common.entity.shopping.CJRGrid) r4)     // Catch:{ Exception -> 0x02cf }
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r0 = r1.x     // Catch:{ Exception -> 0x02cf }
            java.lang.String r0 = r0.getSearchKey()     // Catch:{ Exception -> 0x02cf }
            r1.a((net.one97.paytm.common.entity.shopping.CJRGrid) r4, (java.lang.String) r0)     // Catch:{ Exception -> 0x02cf }
            goto L_0x02bd
        L_0x010f:
            if (r4 == 0) goto L_0x02b1
            java.util.ArrayList r0 = r4.getGridLayout()     // Catch:{ Exception -> 0x02cf }
            if (r0 == 0) goto L_0x02b1
            java.util.ArrayList r0 = r4.getGridLayout()     // Catch:{ Exception -> 0x02cf }
            int r0 = r0.size()     // Catch:{ Exception -> 0x02cf }
            if (r0 == 0) goto L_0x02b1
            java.lang.String r0 = r4.getResultType()     // Catch:{ Exception -> 0x02cf }
            if (r0 != 0) goto L_0x0129
            goto L_0x02b1
        L_0x0129:
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r0 = r1.x     // Catch:{ Exception -> 0x02cf }
            if (r0 == 0) goto L_0x02bd
            java.lang.String r5 = "userQuery"
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r0 = r1.x     // Catch:{ Exception -> 0x02cf }
            java.lang.String r0 = r0.getSearchUrl()     // Catch:{ Exception -> 0x02cf }
            boolean r12 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x02cf }
            if (r12 != 0) goto L_0x022d
            android.net.Uri r12 = android.net.Uri.parse(r0)     // Catch:{ Exception -> 0x02cf }
            android.net.Uri$Builder r0 = new android.net.Uri$Builder     // Catch:{ Exception -> 0x02cf }
            r0.<init>()     // Catch:{ Exception -> 0x02cf }
            if (r4 == 0) goto L_0x022d
            net.one97.paytm.common.entity.shopping.CJRGridMeta r13 = r4.getGridMeta()     // Catch:{ Exception -> 0x02cf }
            if (r13 == 0) goto L_0x0224
            boolean r14 = android.text.TextUtils.isEmpty(r18)     // Catch:{ Exception -> 0x02cf }
            if (r14 != 0) goto L_0x01b6
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r14 = r1.x     // Catch:{ Exception -> 0x02cf }
            r14.setSearcKey(r2)     // Catch:{ Exception -> 0x02cf }
            java.util.Set r14 = r12.getQueryParameterNames()     // Catch:{ Exception -> 0x02cf }
            if (r14 == 0) goto L_0x01b6
            java.lang.String r15 = r12.getScheme()     // Catch:{ Exception -> 0x02cf }
            android.net.Uri$Builder r0 = r0.scheme(r15)     // Catch:{ Exception -> 0x02cf }
            java.lang.String r15 = r12.getAuthority()     // Catch:{ Exception -> 0x02cf }
            android.net.Uri$Builder r15 = r0.authority(r15)     // Catch:{ Exception -> 0x02cf }
            java.lang.String r0 = r12.getEncodedPath()     // Catch:{ UnsupportedEncodingException -> 0x018a }
            java.lang.String r11 = "UTF-8"
            java.lang.String r0 = java.net.URLDecoder.decode(r0, r11)     // Catch:{ UnsupportedEncodingException -> 0x018a }
            java.lang.String r11 = "/"
            boolean r11 = r0.startsWith(r11)     // Catch:{ UnsupportedEncodingException -> 0x018a }
            if (r11 == 0) goto L_0x0185
            r11 = 1
            java.lang.String r0 = r0.substring(r11)     // Catch:{ UnsupportedEncodingException -> 0x018a }
        L_0x0185:
            android.net.Uri$Builder r15 = r15.appendEncodedPath(r0)     // Catch:{ UnsupportedEncodingException -> 0x018a }
            goto L_0x0192
        L_0x018a:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()     // Catch:{ Exception -> 0x02cf }
            com.paytm.utility.q.b(r0)     // Catch:{ Exception -> 0x02cf }
        L_0x0192:
            java.util.Iterator r0 = r14.iterator()     // Catch:{ Exception -> 0x02cf }
        L_0x0196:
            boolean r11 = r0.hasNext()     // Catch:{ Exception -> 0x02cf }
            if (r11 == 0) goto L_0x01b7
            java.lang.Object r11 = r0.next()     // Catch:{ Exception -> 0x02cf }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ Exception -> 0x02cf }
            boolean r14 = r11.equalsIgnoreCase(r5)     // Catch:{ Exception -> 0x02cf }
            if (r14 == 0) goto L_0x01ad
            android.net.Uri$Builder r15 = r15.appendQueryParameter(r5, r2)     // Catch:{ Exception -> 0x02cf }
            goto L_0x0196
        L_0x01ad:
            java.lang.String r14 = r12.getQueryParameter(r11)     // Catch:{ Exception -> 0x02cf }
            android.net.Uri$Builder r15 = r15.appendQueryParameter(r11, r14)     // Catch:{ Exception -> 0x02cf }
            goto L_0x0196
        L_0x01b6:
            r15 = r0
        L_0x01b7:
            java.util.ArrayList r0 = r13.getBrand()     // Catch:{ Exception -> 0x02cf }
            r2 = 0
            if (r0 == 0) goto L_0x01ff
            int r5 = r0.size()     // Catch:{ Exception -> 0x02cf }
            if (r5 <= 0) goto L_0x01ff
            int r5 = r0.size()     // Catch:{ Exception -> 0x02cf }
            r12 = r10
            r11 = 0
        L_0x01ca:
            if (r11 >= r5) goto L_0x01ff
            java.lang.Object r13 = r0.get(r11)     // Catch:{ Exception -> 0x02cf }
            java.lang.String r13 = (java.lang.String) r13     // Catch:{ Exception -> 0x02cf }
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02cf }
            r14.<init>()     // Catch:{ Exception -> 0x02cf }
            r14.append(r12)     // Catch:{ Exception -> 0x02cf }
            r14.append(r13)     // Catch:{ Exception -> 0x02cf }
            java.lang.String r12 = r14.toString()     // Catch:{ Exception -> 0x02cf }
            int r13 = r5 + -1
            if (r11 == r13) goto L_0x01f6
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02cf }
            r13.<init>()     // Catch:{ Exception -> 0x02cf }
            r13.append(r12)     // Catch:{ Exception -> 0x02cf }
            java.lang.String r12 = ","
            r13.append(r12)     // Catch:{ Exception -> 0x02cf }
            java.lang.String r12 = r13.toString()     // Catch:{ Exception -> 0x02cf }
        L_0x01f6:
            java.lang.String r13 = "brand"
            android.net.Uri$Builder r15 = r15.appendQueryParameter(r13, r12)     // Catch:{ Exception -> 0x02cf }
            int r11 = r11 + 1
            goto L_0x01ca
        L_0x01ff:
            r0 = r15
            java.util.ArrayList r5 = r4.getFrontEndFilterList()     // Catch:{ Exception -> 0x02cf }
            if (r5 == 0) goto L_0x0224
            int r11 = r5.size()     // Catch:{ Exception -> 0x02cf }
            if (r11 <= 0) goto L_0x0224
            java.lang.Object r2 = r5.get(r2)     // Catch:{ Exception -> 0x02cf }
            net.one97.paytm.common.entity.CJRFrontEndFilter r2 = (net.one97.paytm.common.entity.CJRFrontEndFilter) r2     // Catch:{ Exception -> 0x02cf }
            if (r2 == 0) goto L_0x0224
            java.util.ArrayList r2 = r2.getAppliedFrontEndFiltersList()     // Catch:{ Exception -> 0x02cf }
            if (r2 == 0) goto L_0x0224
            int r5 = r2.size()     // Catch:{ Exception -> 0x02cf }
            if (r5 <= 0) goto L_0x0224
            android.net.Uri$Builder r0 = a((android.net.Uri.Builder) r0, (java.util.ArrayList<net.one97.paytm.common.entity.CJRFilterValue>) r2)     // Catch:{ Exception -> 0x02cf }
        L_0x0224:
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x02cf }
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r2 = r1.x     // Catch:{ Exception -> 0x02cf }
            r2.setSearchUrl(r0)     // Catch:{ Exception -> 0x02cf }
        L_0x022d:
            java.lang.String r0 = r1.z     // Catch:{ Exception -> 0x02cf }
            boolean r0 = r9.equalsIgnoreCase(r0)     // Catch:{ Exception -> 0x02cf }
            if (r0 == 0) goto L_0x0237
            r1.z = r8     // Catch:{ Exception -> 0x02cf }
        L_0x0237:
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r0 = r1.x     // Catch:{ Exception -> 0x02cf }
            java.lang.String r2 = r1.z     // Catch:{ Exception -> 0x02cf }
            r0.setSearchType(r2)     // Catch:{ Exception -> 0x02cf }
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r0 = r1.x     // Catch:{ Exception -> 0x02cf }
            java.lang.String r2 = r1.B     // Catch:{ Exception -> 0x02cf }
            r0.setSearchCategory(r2)     // Catch:{ Exception -> 0x02cf }
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r0 = r1.x     // Catch:{ Exception -> 0x02cf }
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r2 = r1.x     // Catch:{ Exception -> 0x02cf }
            java.lang.String r2 = r2.getSearchKey()     // Catch:{ Exception -> 0x02cf }
            r0.setSearchTerm(r2)     // Catch:{ Exception -> 0x02cf }
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r0 = r1.x     // Catch:{ Exception -> 0x02cf }
            java.lang.String r2 = r4.getResultType()     // Catch:{ Exception -> 0x02cf }
            r0.setSearchResultType(r2)     // Catch:{ Exception -> 0x02cf }
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r0 = r1.x     // Catch:{ Exception -> 0x02cf }
            java.lang.String r2 = r1.K     // Catch:{ Exception -> 0x02cf }
            r0.setAutoSuggestMetaData(r2)     // Catch:{ Exception -> 0x02cf }
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r0 = r1.x     // Catch:{ Exception -> 0x02cf }
            java.util.HashMap r0 = net.one97.paytm.marketplace.a.a((net.one97.paytm.common.entity.shopping.CJRHomePageItem) r0)     // Catch:{ Exception -> 0x02cf }
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r2 = r1.x     // Catch:{ Exception -> 0x02cf }
            java.lang.String r2 = r2.getSearchTerm()     // Catch:{ Exception -> 0x02cf }
            r0.put(r7, r2)     // Catch:{ Exception -> 0x02cf }
            java.lang.String r2 = "search_autosuggest_data"
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r5 = r1.x     // Catch:{ Exception -> 0x02cf }
            java.lang.String r5 = r5.getAutoSuggestMetaData()     // Catch:{ Exception -> 0x02cf }
            r0.put(r2, r5)     // Catch:{ Exception -> 0x02cf }
            net.one97.paytm.common.entity.shopping.CJRGridMeta r2 = r4.getGridMeta()     // Catch:{ Exception -> 0x02cf }
            java.lang.String r2 = r2.getExperimentName()     // Catch:{ Exception -> 0x02cf }
            r0.put(r6, r2)     // Catch:{ Exception -> 0x02cf }
            net.one97.paytm.marketplace.a.b((java.util.HashMap<java.lang.String, java.lang.Object>) r0)     // Catch:{ Exception -> 0x02cf }
            r16.g()     // Catch:{ Exception -> 0x02cf }
            i()     // Catch:{ Exception -> 0x02cf }
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r0 = r1.x     // Catch:{ Exception -> 0x02cf }
            r1.a((java.lang.String) r3, (net.one97.paytm.common.entity.IJRDataModel) r0, (java.lang.String) r3, (java.lang.String) r10)     // Catch:{ Exception -> 0x02cf }
            java.util.ArrayList<net.one97.paytm.common.entity.shopping.CJRSearchLayout> r0 = f53438a     // Catch:{ Exception -> 0x02cf }
            if (r0 == 0) goto L_0x02bd
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r0 = r1.x     // Catch:{ Exception -> 0x02cf }
            java.lang.String r0 = r0.getSearchKey()     // Catch:{ Exception -> 0x02cf }
            boolean r0 = r1.h((java.lang.String) r0)     // Catch:{ Exception -> 0x02cf }
            if (r0 != 0) goto L_0x02bd
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r0 = r1.x     // Catch:{ Exception -> 0x02cf }
            java.lang.String r0 = r0.getSearchUrl()     // Catch:{ Exception -> 0x02cf }
            java.lang.String r2 = r4.getResultType()     // Catch:{ Exception -> 0x02cf }
            r1.b((java.lang.String) r0, (java.lang.String) r2)     // Catch:{ Exception -> 0x02cf }
            goto L_0x02bd
        L_0x02b1:
            r1.a((net.one97.paytm.common.entity.shopping.CJRGrid) r4)     // Catch:{ Exception -> 0x02cf }
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r0 = r1.x     // Catch:{ Exception -> 0x02cf }
            java.lang.String r0 = r0.getSearchKey()     // Catch:{ Exception -> 0x02cf }
            r1.a((net.one97.paytm.common.entity.shopping.CJRGrid) r4, (java.lang.String) r0)     // Catch:{ Exception -> 0x02cf }
        L_0x02bd:
            java.lang.String r0 = r4.getSearchCookie()     // Catch:{ Exception -> 0x02cf }
            android.content.Context r1 = r16.getApplicationContext()     // Catch:{ Exception -> 0x02cf }
            com.paytm.b.a.a r1 = net.one97.paytm.utils.ag.a(r1)     // Catch:{ Exception -> 0x02cf }
            java.lang.String r2 = "search_cookie"
            r3 = 1
            r1.a((java.lang.String) r2, (java.lang.String) r0, (boolean) r3)     // Catch:{ Exception -> 0x02cf }
        L_0x02cf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.marketplace.search.activity.AJRSearchActivity.a(net.one97.paytm.marketplace.search.activity.AJRSearchActivity, java.lang.String, java.lang.String):void");
    }

    static /* synthetic */ void a(AJRSearchActivity aJRSearchActivity, CJRGrid cJRGrid) {
        if (cJRGrid != null && cJRGrid.getGridLayout() != null && cJRGrid.getGridLayout().size() != 0) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(aJRSearchActivity);
            linearLayoutManager.setOrientation(0);
            aJRSearchActivity.m.setVisibility(0);
            RecyclerView recyclerView = aJRSearchActivity.l;
            if (recyclerView != null) {
                recyclerView.setLayoutManager(linearLayoutManager);
                if (aJRSearchActivity.l.getAdapter() == null) {
                    aJRSearchActivity.l.addItemDecoration(new RecyclerView.h() {
                        public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
                            rect.set(com.paytm.utility.b.a(10.0f, recyclerView.getContext()), 0, 0, com.paytm.utility.b.a(10.0f, recyclerView.getContext()));
                        }
                    });
                }
                aJRSearchActivity.l.setAdapter(new net.one97.paytm.marketplace.search.a.c(cJRGrid.getGridLayout(), aJRSearchActivity));
            }
        }
    }
}
