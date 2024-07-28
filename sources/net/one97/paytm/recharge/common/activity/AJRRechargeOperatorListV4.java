package net.one97.paytm.recharge.common.activity;

import android.animation.LayoutTransition;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.f;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.RoboTextView;
import com.squareup.picasso.e;
import com.squareup.picasso.w;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.automatic.b.a.a;
import net.one97.paytm.recharge.automatic.g.d;
import net.one97.paytm.recharge.common.a.n;
import net.one97.paytm.recharge.common.e.ai;
import net.one97.paytm.recharge.common.e.k;
import net.one97.paytm.recharge.common.utils.ab;
import net.one97.paytm.recharge.common.utils.ba;
import net.one97.paytm.recharge.common.utils.g;
import net.one97.paytm.recharge.common.utils.y;
import net.one97.paytm.recharge.common.utils.z;
import net.one97.paytm.recharge.common.widget.BubbleFixAppBarLayoutBehavior;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;
import net.one97.paytm.recharge.metro.f.c;
import net.one97.paytm.recharge.model.v4.CJRAggsItem;
import net.one97.paytm.recharge.model.v4.CJRCategoryData;
import net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper;
import net.one97.paytm.recharge.model.v4.CJRNextGroupData;
import net.one97.paytm.recharge.model.v4.CJRSelectedGroupItem;
import net.one97.paytm.recharge.model.v4.GroupAttributesItem;
import net.one97.paytm.recharge.ordersummary.h.d;
import net.one97.paytm.recharge.presentation.c.a;
import net.one97.paytm.recharge.widgets.model.ACTION_TYPE;
import net.one97.paytm.recharge.widgets.model.ERROR_TYPE;
import org.json.JSONObject;

public class AJRRechargeOperatorListV4 extends PaytmActivity implements AppBarLayout.b, ai, k {
    private String A;
    private CJRNextGroupData B = null;
    private CJRCategoryDataHelper C = null;
    private LinkedList<CJRSelectedGroupItem> D = null;
    private WeakReference<CJRAggsItem> E = null;
    private WeakReference<Map<CJRAggsItem, CJRCategoryData>> F = null;
    /* access modifiers changed from: private */
    public Boolean G = Boolean.FALSE;
    private Boolean H = Boolean.FALSE;
    private String I = null;
    private String J = null;
    /* access modifiers changed from: private */
    public String K = null;

    /* renamed from: a  reason: collision with root package name */
    private AutoCompleteTextView f60777a;

    /* renamed from: b  reason: collision with root package name */
    protected List<CJRAggsItem> f60778b;

    /* renamed from: c  reason: collision with root package name */
    protected RelativeLayout f60779c;

    /* renamed from: d  reason: collision with root package name */
    protected AutoCompleteTextView f60780d;

    /* renamed from: e  reason: collision with root package name */
    protected Toolbar f60781e;

    /* renamed from: f  reason: collision with root package name */
    public FrameLayout f60782f = null;

    /* renamed from: g  reason: collision with root package name */
    public ProgressBar f60783g = null;

    /* renamed from: h  reason: collision with root package name */
    protected boolean f60784h = true;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public TextView f60785i;
    private TextView j;
    /* access modifiers changed from: private */
    public View k;
    /* access modifiers changed from: private */
    public n l;
    private boolean m;
    private String n = "";
    private RecyclerView o;
    private AppBarLayout p;
    private RoboTextView q;
    private RelativeLayout r;
    private ImageView s;
    private TextView t;
    private FrameLayout u;
    private CollapsingToolbarLayout v;
    private LinearLayout w;
    private View x;
    private ImageView y;
    /* access modifiers changed from: private */
    public ImageView z;

    public void onCreate(Bundle bundle) {
        com.paytm.utility.b.e((Activity) this);
        super.onCreate(bundle);
        a();
        this.f60777a = (AutoCompleteTextView) findViewById(R.id.search_operator);
        this.f60785i = (TextView) findViewById(R.id.search_hint);
        this.f60782f = (FrameLayout) findViewById(R.id.layout_progress);
        this.f60779c = (RelativeLayout) findViewById(R.id.search_header);
        this.f60780d = (AutoCompleteTextView) findViewById(R.id.search_operator);
        this.j = (TextView) findViewById(R.id.tv_refer_apartment);
        this.k = findViewById(R.id.content_header_no_apartment);
        this.o = (RecyclerView) findViewById(R.id.operator_list_view);
        this.p = (AppBarLayout) findViewById(R.id.app_bar_layout);
        this.q = (RoboTextView) findViewById(R.id.cancel);
        this.r = (RelativeLayout) findViewById(R.id.custom_toolbar);
        this.s = (ImageView) findViewById(R.id.back_arrow);
        this.t = (TextView) findViewById(R.id.toolbar_title);
        this.u = (FrameLayout) findViewById(R.id.dummy_view);
        this.v = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        this.w = (LinearLayout) findViewById(R.id.action_toolbar);
        this.z = (ImageView) findViewById(R.id.close_btn);
        this.f60783g = (ProgressBar) findViewById(R.id.progress);
        this.j.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AJRRechargeOperatorListV4.this.f(view);
            }
        });
        this.x = findViewById(R.id.content_search_not_found);
        this.y = (ImageView) findViewById(R.id.error_image);
        e();
        c();
        b();
        d();
        if (!TextUtils.isEmpty(this.J)) {
            w.a().a(this.J).a(this.y, (e) null);
        }
    }

    public void d() {
        this.z.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AJRRechargeOperatorListV4.this.e(view);
            }
        });
        this.u.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AJRRechargeOperatorListV4.this.d(view);
            }
        });
        this.s.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AJRRechargeOperatorListV4.this.c(view);
            }
        });
        this.q.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AJRRechargeOperatorListV4.this.b(view);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e(View view) {
        this.f60777a.setText("");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d(View view) {
        this.p.setExpanded(false, true);
        if (this.B != null) {
            if ("166690".equalsIgnoreCase(this.I)) {
                d dVar = new d(this);
                dVar.a("book_cylinder", this.B.getGroupName() + "_search_box_clicked", "", "", "cylinder_booking", "", "");
            } else if ("78640".equalsIgnoreCase(this.I)) {
                d dVar2 = new d(this);
                dVar2.a("book_cylinder", this.B.getGroupName() + "_search_box_clicked", "", "", "cylinder_booking", "", "");
            }
        }
        new Handler().postDelayed(new Runnable() {
            public final void run() {
                AJRRechargeOperatorListV4.this.n();
            }
        }, 200);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void n() {
        this.f60777a.requestFocus();
        ((InputMethodManager) getSystemService("input_method")).showSoftInput(this.f60777a, 1);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        onBackPressed();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        this.p.setExpanded(true, true);
        new Handler().postDelayed(new Runnable() {
            public final void run() {
                AJRRechargeOperatorListV4.this.m();
            }
        }, 200);
    }

    /* access modifiers changed from: protected */
    public void c() {
        setSupportActionBar(this.f60781e);
        getSupportActionBar().b(true);
        getSupportActionBar().c(false);
        this.p.a((AppBarLayout.b) this);
        ((CoordinatorLayout.d) this.p.getLayoutParams()).a((CoordinatorLayout.Behavior) new BubbleFixAppBarLayoutBehavior());
        LayoutTransition layoutTransition = new LayoutTransition();
        layoutTransition.setAnimateParentHierarchy(false);
        this.r.setLayoutTransition(layoutTransition);
        this.f60781e.setTitleTextAppearance(this, R.style.RUToolbarTitleTextAppearance);
        CollapsingToolbarLayout collapsingToolbarLayout = this.v;
        collapsingToolbarLayout.setExpandedTitleTypeface(Typeface.create(collapsingToolbarLayout.getExpandedTitleTypeface(), 1));
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }

    /* access modifiers changed from: protected */
    public String f() {
        StringBuilder sb = new StringBuilder();
        Bundle extras = getIntent().getExtras();
        if (extras == null || !extras.containsKey("title")) {
            return "";
        }
        if (!extras.containsKey("select") || !extras.getBoolean("select")) {
            return extras.getString("title");
        }
        sb.append(getString(R.string.select));
        sb.append(" ");
        if (extras.containsKey("an") && extras.getBoolean("an")) {
            if (g.e((String) Objects.requireNonNull(extras.getString("title")))) {
                sb.append(getString(R.string.an_vowel));
                sb.append(" ");
            } else {
                sb.append(getString(R.string.a_vowel));
                sb.append(" ");
            }
        }
        sb.append(extras.getString("title"));
        return sb.toString();
    }

    public void b() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String f2 = f();
            TextView textView = this.t;
            if (textView != null) {
                textView.setText(f2);
            }
            Toolbar toolbar = this.f60781e;
            if (toolbar != null) {
                toolbar.setTitle((CharSequence) f2);
            }
            if (extras.containsKey("action_back_icon")) {
                try {
                    this.s.setImageDrawable(f.b().a((Context) this, extras.getInt("action_back_icon")));
                } catch (Exception unused) {
                    this.s.setImageResource(R.drawable.back_arrow_black);
                }
            }
            if (extras.containsKey("toolbar_background_color")) {
                try {
                    this.p.setBackgroundColor(androidx.core.content.b.c(this, extras.getInt("toolbar_background_color")));
                } catch (Exception unused2) {
                    this.p.setBackgroundColor(androidx.core.content.b.c(this, R.color.color_fafbfb));
                }
            }
            if (extras.containsKey("list_type")) {
                this.A = extras.getString("list_type");
            }
            if (extras.containsKey("categories")) {
                this.n = getIntent().getStringExtra("categories");
            }
            if (extras.containsKey("category id")) {
                this.I = getIntent().getStringExtra("category id");
            }
            if (extras.containsKey("image url")) {
                this.J = getIntent().getStringExtra("image url");
            }
            a.C1160a aVar = net.one97.paytm.recharge.automatic.b.a.a.f60239a;
            if (extras.containsKey(net.one97.paytm.recharge.automatic.b.a.a.f60240b)) {
                Intent intent = getIntent();
                a.C1160a aVar2 = net.one97.paytm.recharge.automatic.b.a.a.f60239a;
                this.K = intent.getStringExtra(net.one97.paytm.recharge.automatic.b.a.a.f60240b);
            }
            if (extras.containsKey("extra.show.next")) {
                this.f60784h = extras.getBoolean("extra.show.next");
            }
            y yVar = y.f61814b;
            String str = "";
            if ("inputGrouping".equalsIgnoreCase(this.A)) {
                try {
                    this.D = y.h();
                    this.C = y.e();
                    if (this.C != null) {
                        this.B = this.C.getNextGroupItemData();
                        str = this.B.getGroupAttributesItem().getType().getAndroidType();
                        this.f60778b = new ArrayList(this.B.getAggs());
                    } else {
                        this.f60778b = new ArrayList(y.c());
                    }
                } catch (Exception unused3) {
                }
            } else {
                this.C = y.e();
                if (y.c() != null) {
                    this.f60778b = new ArrayList(y.c());
                }
            }
            if (extras != null && extras.containsKey("open_activity_in_automatic_mode")) {
                this.m = extras.getBoolean("open_activity_in_automatic_mode");
            }
            if (this.f60778b != null && this.A != null) {
                boolean z2 = true;
                if (z.b(this.I)) {
                    k();
                    if (this.f60778b.size() >= 5) {
                        z2 = false;
                    }
                    if (z2) {
                        a(8);
                    } else {
                        a(0);
                    }
                } else if ("dropdown".equalsIgnoreCase(this.A) || "dropdown".equalsIgnoreCase(str) || this.m) {
                    k();
                    if (this.f60778b.size() >= 5) {
                        z2 = false;
                    }
                    if (z2) {
                        AppBarLayout.LayoutParams layoutParams = new AppBarLayout.LayoutParams(-2, com.paytm.utility.b.a(100, (Context) this));
                        layoutParams.f35849a = 19;
                        this.v.setLayoutParams(layoutParams);
                        CollapsingToolbarLayout.LayoutParams layoutParams2 = (CollapsingToolbarLayout.LayoutParams) this.f60781e.getLayoutParams();
                        layoutParams2.setMargins(0, 0, 0, 0);
                        this.f60781e.setLayoutParams(layoutParams2);
                        this.w.setVisibility(8);
                        this.f60781e.setVisibility(0);
                        this.r.setVisibility(8);
                        return;
                    }
                    this.r.setVisibility(0);
                } else {
                    h();
                    if (g()) {
                        a(8);
                    } else {
                        a(0);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean g() {
        return this.f60778b.size() < 9;
    }

    public void a(int i2) {
        this.r.setVisibility(i2);
    }

    /* access modifiers changed from: protected */
    public void h() {
        int a2 = com.paytm.utility.b.a(16, (Context) this);
        CJRCategoryDataHelper cJRCategoryDataHelper = this.C;
        int operatorGridColumnCount = (cJRCategoryDataHelper == null || cJRCategoryDataHelper.getCategoryData() == null || this.C.getCategoryData().getExtnAttrs() == null) ? 2 : this.C.getCategoryData().getExtnAttrs().getOperatorGridColumnCount();
        if (operatorGridColumnCount == 0) {
            operatorGridColumnCount = 2;
        }
        this.o.setLayoutManager(new GridLayoutManager(this, operatorGridColumnCount));
        this.o.addItemDecoration(new net.one97.paytm.recharge.common.widget.g(operatorGridColumnCount, a2));
        this.l = new n(this, this.f60778b, this.m, this);
        this.l.f60635d = "inputGrouping".equalsIgnoreCase(this.A);
        n nVar = this.l;
        nVar.f60636e = true;
        this.o.setAdapter(nVar);
        this.f60785i.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AJRRechargeOperatorListV4.this.a(view);
            }
        });
        this.f60777a.addTextChangedListener(new TextWatcher() {
            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void afterTextChanged(Editable editable) {
                AJRRechargeOperatorListV4.this.l.a().filter(editable.toString());
                if (editable.toString().trim().length() > 0) {
                    AJRRechargeOperatorListV4.this.f60785i.setVisibility(8);
                    if (AJRRechargeOperatorListV4.this.z != null) {
                        AJRRechargeOperatorListV4.this.z.setVisibility(0);
                        return;
                    }
                    return;
                }
                AJRRechargeOperatorListV4.this.f60785i.setVisibility(0);
                if (AJRRechargeOperatorListV4.this.z != null) {
                    AJRRechargeOperatorListV4.this.z.setVisibility(8);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        if ("166690".equalsIgnoreCase(this.I)) {
            new d(this).a("book_cylinder", "_search_box_clicked", "", this.B.getGroupName(), "cylinder_booking", "", "");
        } else if ("78640".equalsIgnoreCase(this.I)) {
            d dVar = new d(this);
            dVar.a("book_cylinder", f() + "_search_box_clicked", "", "gas_agency", "cylinder_booking", "", "");
        }
    }

    private boolean j() {
        return this.f60784h && "inputGrouping".equalsIgnoreCase(this.A);
    }

    private void k() {
        boolean z2 = this.m;
        if (z2) {
            d.a aVar = net.one97.paytm.recharge.automatic.g.d.f60295a;
            new net.one97.paytm.recharge.automatic.g.d();
            this.l = new n(this, net.one97.paytm.recharge.automatic.g.d.a(this.f60778b), this.m, this);
        } else {
            this.l = new n(this, this.f60778b, z2, this);
            this.l.f60635d = j();
            if ("apartments".equalsIgnoreCase(this.n)) {
                l();
            }
        }
        if (z.b(this.I)) {
            this.l.f60637f = true;
        }
        this.o.setLayoutManager(new LinearLayoutManager(this));
        this.o.addItemDecoration(new b(com.paytm.utility.b.c(8)));
        this.o.setAdapter(this.l);
        this.f60777a.addTextChangedListener(new TextWatcher() {
            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void afterTextChanged(Editable editable) {
                AJRRechargeOperatorListV4.this.l.a().filter(editable.toString());
                if (editable.toString().trim().length() > 0) {
                    AJRRechargeOperatorListV4.this.f60785i.setVisibility(8);
                    if (AJRRechargeOperatorListV4.this.z != null) {
                        AJRRechargeOperatorListV4.this.z.setVisibility(0);
                        return;
                    }
                    return;
                }
                AJRRechargeOperatorListV4.this.f60785i.setVisibility(0);
                if (AJRRechargeOperatorListV4.this.z != null) {
                    AJRRechargeOperatorListV4.this.z.setVisibility(8);
                }
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    public final void b(int i2) {
        this.f60783g.setVisibility(i2);
    }

    private void a(Handler handler) {
        handler.postDelayed(new Runnable() {
            public final void run() {
                Boolean unused = AJRRechargeOperatorListV4.this.G = Boolean.FALSE;
            }
        }, 1000);
    }

    private void l() {
        AnonymousClass4 r0 = new k() {
            public final void a(boolean z) {
                if (z) {
                    AJRRechargeOperatorListV4.this.k.setVisibility(0);
                    AJRRechargeOperatorListV4.this.m();
                    return;
                }
                AJRRechargeOperatorListV4.this.k.setVisibility(8);
            }

            public final void c(int i2) {
                AJRRechargeOperatorListV4 aJRRechargeOperatorListV4 = AJRRechargeOperatorListV4.this;
                aJRRechargeOperatorListV4.a(aJRRechargeOperatorListV4.l.a(i2));
            }
        };
        this.f60778b.add(new CJRAggsItem());
        this.l = new n(this, this.f60778b, this.m, r0);
        this.l.f60638g = true;
    }

    /* access modifiers changed from: protected */
    public final void a(CJRAggsItem cJRAggsItem) {
        if (com.paytm.utility.e.z.equals(this.I)) {
            net.one97.paytm.recharge.ordersummary.h.d dVar = new net.one97.paytm.recharge.ordersummary.h.d(this);
            c.a aVar = c.f63576a;
            String a2 = c.a.a((String) null);
            StringBuilder sb = new StringBuilder();
            c.a aVar2 = c.f63576a;
            sb.append(c.a.a(cJRAggsItem.getValue()));
            sb.append("_clicked");
            dVar.a(a2, sb.toString(), "", "", ab.f61496a, "", "");
        }
        if (!this.G.booleanValue()) {
            if (this.B != null && "166690".equalsIgnoreCase(this.I)) {
                net.one97.paytm.recharge.ordersummary.h.d dVar2 = new net.one97.paytm.recharge.ordersummary.h.d(this);
                dVar2.a("book_cylinder", this.B.getGroupName() + "_selected", "", cJRAggsItem.getDisplayValue(), "cylinder_booking", "", "");
            }
            this.G = Boolean.TRUE;
            boolean z2 = true;
            if (this.m && !cJRAggsItem.isSchedulable()) {
                String string = getString(R.string.this_operator);
                if (cJRAggsItem.getDisplayValue() != null) {
                    string = cJRAggsItem.getDisplayValue();
                }
                try {
                    net.one97.paytm.recharge.ordersummary.h.d dVar3 = new net.one97.paytm.recharge.ordersummary.h.d(this);
                    String str = this.K;
                    a.C1160a aVar3 = net.one97.paytm.recharge.automatic.b.a.a.f60239a;
                    dVar3.a(str, net.one97.paytm.recharge.automatic.b.a.a.C, "", "", "", "", "");
                } catch (Exception unused) {
                }
                a aVar4 = new a();
                a.C1278a aVar5 = net.one97.paytm.recharge.presentation.c.a.f64795a;
                a.C1278a.a(this, getString(R.string.coming_soon_excalamation), getString(R.string.we_are_working_hard_operator, new Object[]{string}), getString(R.string.ok), aVar4).show(getSupportFragmentManager(), net.one97.paytm.recharge.presentation.c.a.class.getSimpleName());
                a(new Handler());
            } else if ("inputGrouping".equalsIgnoreCase(this.A)) {
                CJRSelectedGroupItem cJRSelectedGroupItem = new CJRSelectedGroupItem(this.B.getGroupName(), this.A, cJRAggsItem.getDisplayValue(), cJRAggsItem.getValue(), this.B.getGroupLevel(), cJRAggsItem);
                LinkedList<CJRSelectedGroupItem> linkedList = this.D;
                if (linkedList != null) {
                    linkedList.add(cJRSelectedGroupItem);
                }
                this.C.addSelectedGroupItem(this.B.getGroupLevel(), cJRSelectedGroupItem);
                CJRNextGroupData nextGroupItemData = this.C.getNextGroupItemData();
                if (nextGroupItemData == null || nextGroupItemData.getGroupAttributesItem() == null || nextGroupItemData.getGroupAttributesItem().getShowAfterInputfield()) {
                    z2 = false;
                }
                if (z2) {
                    a(nextGroupItemData);
                } else if (this.C.isGroupAPICallRequired()) {
                    this.f60782f.setVisibility(0);
                    b(0);
                    this.E = new WeakReference<>(cJRAggsItem);
                    WeakReference<Map<CJRAggsItem, CJRCategoryData>> weakReference = this.F;
                    if (weakReference == null || weakReference.get() == null) {
                        this.F = new WeakReference<>(new HashMap(5));
                    }
                    if (!((Map) this.F.get()).containsKey(cJRAggsItem)) {
                        JSONObject nextGroupingPostBody = this.C.getNextGroupingPostBody();
                        net.one97.paytm.recharge.common.b.c b2 = net.one97.paytm.recharge.common.b.d.b(getApplicationContext());
                        String categoryId = this.C.getCategoryId();
                        String stringExtra = getIntent().getStringExtra("extra_tracking_id");
                        net.one97.paytm.recharge.widgets.c.d dVar4 = net.one97.paytm.recharge.widgets.c.d.f64967a;
                        b2.b("grouping", this, nextGroupingPostBody, categoryId, stringExtra, net.one97.paytm.recharge.widgets.c.d.a(ACTION_TYPE.GET_GROUPING, ERROR_TYPE.UNDEFINED));
                        return;
                    }
                    net.one97.paytm.recharge.widgets.c.d dVar5 = net.one97.paytm.recharge.widgets.c.d.f64967a;
                    a_("grouping", (IJRPaytmDataModel) ((Map) this.F.get()).get(cJRAggsItem), net.one97.paytm.recharge.widgets.c.d.a(ACTION_TYPE.GET_GROUPING, ERROR_TYPE.UNDEFINED));
                } else {
                    setResult(-1, new Intent().putExtras(getIntent().getExtras()).putExtra("extra_agg_item", cJRAggsItem));
                    m();
                    finish();
                }
            } else {
                com.paytm.utility.e.z.equals(this.I);
                Intent intent = new Intent();
                intent.putExtra("intent_extra_item_index", this.f60778b.indexOf(cJRAggsItem));
                intent.putExtra("metro_utility_varient", cJRAggsItem.getValue());
                setResult(1, intent);
                m();
                finish();
            }
        }
    }

    class a implements View.OnClickListener {
        a() {
        }

        public final void onClick(View view) {
            try {
                net.one97.paytm.recharge.ordersummary.h.d dVar = new net.one97.paytm.recharge.ordersummary.h.d(AJRRechargeOperatorListV4.this);
                String e2 = AJRRechargeOperatorListV4.this.K;
                a.C1160a aVar = net.one97.paytm.recharge.automatic.b.a.a.f60239a;
                dVar.a(e2, net.one97.paytm.recharge.automatic.b.a.a.D, "", "", "", "", "");
            } catch (Exception unused) {
            }
        }
    }

    private Class a(String str, boolean z2) {
        return ba.a(str, z2, this.I);
    }

    private void a(CJRNextGroupData cJRNextGroupData) {
        if (cJRNextGroupData == null) {
            LinkedList<CJRSelectedGroupItem> linkedList = this.D;
            if (linkedList != null) {
                linkedList.pop();
            }
            this.C.removeSelectedGroupItem(this.B.getGroupLevel(), this.B.getGroupName());
            Toast.makeText(this, getString(R.string.no_result_found), 1).show();
            return;
        }
        GroupAttributesItem groupAttributesItem = cJRNextGroupData.getGroupAttributesItem();
        startActivityForResult(new Intent(this, a(this.A, this.m)).putExtras(getIntent().getExtras()).putExtra("category id", this.I).putExtra("title", (groupAttributesItem == null || TextUtils.isEmpty(groupAttributesItem.getDisplayName())) ? "" : groupAttributesItem.getDisplayName()), 607);
        a(new Handler());
    }

    public void onBackPressed() {
        String str;
        m();
        CJRNextGroupData cJRNextGroupData = this.B;
        if (cJRNextGroupData == null) {
            str = "gas_provider";
        } else {
            str = cJRNextGroupData.getGroupName();
        }
        String str2 = str;
        if ("166690".equalsIgnoreCase(this.I)) {
            new net.one97.paytm.recharge.ordersummary.h.d(this).a("book_cylinder", "back_button_clicked", "", str2, "cylinder_booking", "", "");
        } else if ("78640".equalsIgnoreCase(this.I)) {
            new net.one97.paytm.recharge.ordersummary.h.d(this).a("book_cylinder", "back_button_clicked", "", str2, "cylinder_booking", "", "");
        }
        if (getIntent() == null || getIntent().getExtras() == null) {
            setResult(0);
        } else if (getIntent().getExtras().containsKey("extra_config_key")) {
            Intent intent = new Intent();
            intent.putExtras(getIntent().getExtras());
            setResult(0, intent);
        } else {
            setResult(0);
        }
        super.onBackPressed();
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        if (i2 == 607) {
            boolean z2 = false;
            boolean booleanExtra = getIntent().getBooleanExtra("skip_clear_grouping_selection", false);
            if (i3 == -1 && booleanExtra) {
                z2 = true;
            }
            if (!z2) {
                LinkedList<CJRSelectedGroupItem> linkedList = this.D;
                if (linkedList != null) {
                    linkedList.pop();
                }
                CJRNextGroupData cJRNextGroupData = this.B;
                if (cJRNextGroupData != null) {
                    this.C.removeSelectedGroupItem(cJRNextGroupData.getGroupLevel(), this.B.getGroupName());
                }
            }
            if (i3 == -1) {
                m();
                setResult(i3, intent);
                finish();
                return;
            }
            return;
        }
        super.onActivityResult(i2, i3, intent);
    }

    public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
        CJRRechargeUtilities.INSTANCE.handleError(str, this, (Fragment) null, networkCustomError, true, 3, obj);
    }

    public final void a(boolean z2) {
        if (!TextUtils.isEmpty(this.I)) {
            net.one97.paytm.recharge.di.helper.c cVar = net.one97.paytm.recharge.di.helper.c.f62654a;
            if (!net.one97.paytm.recharge.di.helper.c.h().contains(Long.valueOf(Long.parseLong(this.I)))) {
                return;
            }
            if (!z2) {
                this.x.setVisibility(8);
            } else if (this.x.getVisibility() == 8) {
                this.x.setVisibility(0);
            }
        }
    }

    public final void c(int i2) {
        a(this.l.a(i2));
    }

    public void onOffsetChanged(AppBarLayout appBarLayout, int i2) {
        float abs = ((float) Math.abs(i2)) / ((float) appBarLayout.getTotalScrollRange());
        if (abs >= 0.7f && this.H.booleanValue()) {
            if (this.r.getVisibility() == 0) {
                this.q.setVisibility(0);
            }
            this.H = Boolean.valueOf(!this.H.booleanValue());
        } else if (abs < 0.7f && !this.H.booleanValue()) {
            if (this.r.getVisibility() == 0) {
                this.q.setVisibility(8);
            }
            this.H = Boolean.valueOf(!this.H.booleanValue());
        }
    }

    /* renamed from: i */
    public final void m() {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (inputMethodManager != null && getCurrentFocus() != null) {
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 2);
        }
    }

    public void a() {
        setContentView(R.layout.activity_operator_list);
    }

    public void e() {
        this.f60781e = (Toolbar) findViewById(R.id.toolbar);
    }

    public class b extends RecyclerView.h {

        /* renamed from: b  reason: collision with root package name */
        private final int f60792b;

        public b(int i2) {
            this.f60792b = i2;
        }

        public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
            rect.bottom = this.f60792b;
        }
    }

    public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
        CJRCategoryData lastGroupingData;
        this.f60782f.setVisibility(8);
        b(8);
        a(new Handler());
        if ((iJRPaytmDataModel instanceof CJRCategoryData) && (lastGroupingData = this.C.getLastGroupingData()) != null) {
            if (!(this.E.get() == null || this.F.get() == null)) {
                ((Map) this.F.get()).put(this.E.get(), (CJRCategoryData) iJRPaytmDataModel);
            }
            lastGroupingData.setNextGroupingData((CJRCategoryData) iJRPaytmDataModel);
            a(this.C.getNextGroupItemData());
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void f(View view) {
        startActivity(new Intent(this, AJRReferApartmentActivity.class));
    }
}
