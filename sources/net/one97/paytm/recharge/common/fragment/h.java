package net.one97.paytm.recharge.common.fragment;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.Html;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.RoboTextView;
import io.reactivex.rxjava3.a.ab;
import io.reactivex.rxjava3.a.u;
import io.reactivex.rxjava3.a.y;
import io.reactivex.rxjava3.a.z;
import io.reactivex.rxjava3.d.q;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.m.p;
import net.one97.paytm.common.entity.shopping.CJRHomePage;
import net.one97.paytm.common.views.ShimmerFrameLayout;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.a.v;
import net.one97.paytm.recharge.common.a.w;
import net.one97.paytm.recharge.common.c.f;
import net.one97.paytm.recharge.common.d.f;
import net.one97.paytm.recharge.common.e.ae;
import net.one97.paytm.recharge.common.e.ah;
import net.one97.paytm.recharge.common.e.ai;
import net.one97.paytm.recharge.common.utils.ax;
import net.one97.paytm.recharge.common.utils.az;
import net.one97.paytm.recharge.common.utils.ba;
import net.one97.paytm.recharge.common.utils.t;
import net.one97.paytm.recharge.common.widget.c;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;
import net.one97.paytm.recharge.model.mobile.CJRMadeForYouPlanData;
import net.one97.paytm.recharge.model.rechargeutility.CJRBowsePlanGroupingListV8;
import net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList;
import net.one97.paytm.recharge.widgets.model.ACTION_TYPE;
import net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel;
import net.one97.paytm.recharge.widgets.model.CRUFlowModel;
import net.one97.paytm.recharge.widgets.model.ERROR_TYPE;
import net.one97.paytm.recharge.widgets.model.VERTICAL;

public final class h extends Fragment implements View.OnClickListener, ViewPager.e, AppBarLayout.b, w.b, f.a, ae, ah, ai {

    /* renamed from: c  reason: collision with root package name */
    public static final a f61211c = new a((byte) 0);
    private static final String u;

    /* renamed from: a  reason: collision with root package name */
    net.one97.paytm.recharge.common.e.d f61212a;

    /* renamed from: b  reason: collision with root package name */
    net.one97.paytm.recharge.common.widget.c f61213b;

    /* renamed from: d  reason: collision with root package name */
    private List<? extends CJRBowsePlanGroupingListV8> f61214d;

    /* renamed from: e  reason: collision with root package name */
    private net.one97.paytm.recharge.common.a.c f61215e;

    /* renamed from: f  reason: collision with root package name */
    private net.one97.paytm.recharge.common.a.e f61216f;

    /* renamed from: g  reason: collision with root package name */
    private CJRBowsePlanGroupingListV8 f61217g;

    /* renamed from: h  reason: collision with root package name */
    private List<? extends CJRMadeForYouPlanData> f61218h;

    /* renamed from: i  reason: collision with root package name */
    private io.reactivex.rxjava3.b.c f61219i;
    private TextView j;
    private Integer k;
    /* access modifiers changed from: private */
    public b l = b.IDLE;
    /* access modifiers changed from: private */
    public AppBarLayout m;
    private ShimmerFrameLayout n;
    private float o;
    /* access modifiers changed from: private */
    public String p = "";
    /* access modifiers changed from: private */
    public final io.reactivex.rxjava3.j.b<String> q;
    /* access modifiers changed from: private */
    public final Handler r;
    /* access modifiers changed from: private */
    public net.one97.paytm.recharge.common.e.a<IJRPaytmDataModel> s;
    /* access modifiers changed from: private */
    public String t;
    private HashMap v;

    public enum b {
        EXPANDED,
        COLLAPSED,
        IDLE
    }

    public final View a(int i2) {
        if (this.v == null) {
            this.v = new HashMap();
        }
        View view = (View) this.v.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.v.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void onPageScrollStateChanged(int i2) {
    }

    static final class f<T> implements q<String> {

        /* renamed from: a  reason: collision with root package name */
        public static final f f61223a = new f();

        f() {
        }

        public final /* synthetic */ boolean test(Object obj) {
            String str = (String) obj;
            kotlin.g.b.k.a((Object) str, "it");
            return !p.a(str);
        }
    }

    static final class g<T, R> implements io.reactivex.rxjava3.d.h<T, u<? extends R>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f61224a;

        g(h hVar) {
            this.f61224a = hVar;
        }

        public final /* synthetic */ Object apply(Object obj) {
            final String str = (String) obj;
            return y.a(new ab<IJRPaytmDataModel>(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ g f61225a;

                {
                    this.f61225a = r1;
                }

                public final void subscribe(z<IJRPaytmDataModel> zVar) {
                    net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
                    final CJRRechargeErrorModel a2 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
                    a2.setErrorType(ERROR_TYPE.UNDEFINED);
                    CRUFlowModel flowName = a2.getFlowName();
                    if (flowName != null) {
                        flowName.setErrorType(ERROR_TYPE.UNDEFINED.name());
                    }
                    CRUFlowModel flowName2 = a2.getFlowName();
                    if (flowName2 != null) {
                        flowName2.setActionType(ACTION_TYPE.PLAN_SEARCH.name());
                    }
                    net.one97.paytm.recharge.common.e.a c2 = this.f61225a.f61224a.s;
                    if (c2 == null) {
                        kotlin.g.b.k.a();
                    }
                    c2.a(zVar);
                    String str = str;
                    kotlin.g.b.k.a((Object) str, "searchedQuery");
                    if (str != null) {
                        if (ba.b(p.b(str).toString(), this.f61225a.f61224a.t)) {
                            String str2 = str;
                            kotlin.g.b.k.a((Object) str2, "searchedQuery");
                            if (str2 != null) {
                                String a3 = ba.a(Double.valueOf(Double.parseDouble(p.b(str2).toString())));
                                if (a3 != null) {
                                    if (!(a3.length() == 0)) {
                                        this.f61225a.f61224a.p = a3;
                                    }
                                }
                                this.f61225a.f61224a.p = "";
                            } else {
                                throw new kotlin.u("null cannot be cast to non-null type kotlin.CharSequence");
                            }
                        } else {
                            this.f61225a.f61224a.p = "";
                        }
                        this.f61225a.f61224a.r.post(new Runnable(this) {

                            /* renamed from: a  reason: collision with root package name */
                            final /* synthetic */ AnonymousClass1 f61227a;

                            {
                                this.f61227a = r1;
                            }

                            public final void run() {
                                net.one97.paytm.recharge.common.e.d dVar = this.f61227a.f61225a.f61224a.f61212a;
                                if (dVar != null) {
                                    net.one97.paytm.recharge.common.e.a c2 = this.f61227a.f61225a.f61224a.s;
                                    if (c2 == null) {
                                        kotlin.g.b.k.a();
                                    }
                                    String str = str;
                                    kotlin.g.b.k.a((Object) str, "searchedQuery");
                                    dVar.a("search_browse_plan", (ai) c2, str, new String[0], (Object) a2);
                                }
                            }
                        });
                        return;
                    }
                    throw new kotlin.u("null cannot be cast to non-null type kotlin.CharSequence");
                }
            }).e().subscribeOn(io.reactivex.rxjava3.i.a.b());
        }
    }

    public h() {
        io.reactivex.rxjava3.j.b<String> a2 = io.reactivex.rxjava3.j.b.a();
        kotlin.g.b.k.a((Object) a2, "PublishSubject.create()");
        this.q = a2;
        this.r = new Handler();
        this.t = "";
    }

    public final net.one97.paytm.recharge.common.e.d a() {
        if (getContext() instanceof ah) {
            Context context = getContext();
            if (context != null) {
                return ((ah) context).a();
            }
            throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.recharge.common.listener.IJRRechargeViewModelActivity");
        } else if (!(getParentFragment() instanceof ah)) {
            return null;
        } else {
            Fragment parentFragment = getParentFragment();
            if (parentFragment != null) {
                return ((ah) parentFragment).a();
            }
            throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.recharge.common.listener.IJRRechargeViewModelActivity");
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        String simpleName = h.class.getSimpleName();
        kotlin.g.b.k.a((Object) simpleName, "FJRBrowsePlansFragmentV3::class.java.simpleName");
        u = simpleName;
    }

    public final void onAttach(Context context) {
        kotlin.g.b.k.c(context, "context");
        super.onAttach(context);
        if (context instanceof ah) {
            this.f61212a = ((ah) context).a();
        }
        if (getParentFragment() instanceof ah) {
            Fragment parentFragment = getParentFragment();
            if (parentFragment != null) {
                this.f61212a = ((ah) parentFragment).a();
            } else {
                throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.recharge.common.listener.IJRRechargeViewModelActivity");
            }
        }
        int i2 = Build.VERSION.SDK_INT;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|(1:4)(1:5)|6|7|8|(1:14)|15|(1:19)|22|(2:24|25)(1:26)) */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0056, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0057, code lost:
        net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE.debugLogExceptions(r4);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onCreate(android.os.Bundle r4) {
        /*
            r3 = this;
            super.onCreate(r4)
            r4 = 0
            net.one97.paytm.recharge.di.helper.b r0 = net.one97.paytm.recharge.di.helper.b.f62652a     // Catch:{ all -> 0x002a }
            android.content.Context r0 = r3.getContext()     // Catch:{ all -> 0x002a }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x002a }
            java.lang.String r2 = "/"
            r1.<init>(r2)     // Catch:{ all -> 0x002a }
            net.one97.paytm.recharge.common.e.d r2 = r3.f61212a     // Catch:{ all -> 0x002a }
            if (r2 == 0) goto L_0x001a
            java.lang.Object r2 = r2.e()     // Catch:{ all -> 0x002a }
            goto L_0x001b
        L_0x001a:
            r2 = r4
        L_0x001b:
            r1.append(r2)     // Catch:{ all -> 0x002a }
            java.lang.String r2 = "/browse_plans"
            r1.append(r2)     // Catch:{ all -> 0x002a }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x002a }
            net.one97.paytm.recharge.di.helper.b.a((android.content.Context) r0, (java.lang.String) r1)     // Catch:{ all -> 0x002a }
        L_0x002a:
            androidx.fragment.app.FragmentActivity r0 = r3.getActivity()     // Catch:{ all -> 0x0056 }
            if (r0 == 0) goto L_0x0042
            android.view.Window r0 = r0.getWindow()     // Catch:{ all -> 0x0056 }
            if (r0 == 0) goto L_0x0042
            android.view.WindowManager$LayoutParams r0 = r0.getAttributes()     // Catch:{ all -> 0x0056 }
            if (r0 == 0) goto L_0x0042
            int r4 = r0.softInputMode     // Catch:{ all -> 0x0056 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x0056 }
        L_0x0042:
            r3.k = r4     // Catch:{ all -> 0x0056 }
            androidx.fragment.app.FragmentActivity r4 = r3.getActivity()     // Catch:{ all -> 0x0056 }
            if (r4 == 0) goto L_0x005c
            android.view.Window r4 = r4.getWindow()     // Catch:{ all -> 0x0056 }
            if (r4 == 0) goto L_0x005c
            r0 = 48
            r4.setSoftInputMode(r0)     // Catch:{ all -> 0x0056 }
            goto L_0x005c
        L_0x0056:
            r4 = move-exception
            net.one97.paytm.recharge.di.helper.CJRRechargeUtilities r0 = net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE
            r0.debugLogExceptions(r4)
        L_0x005c:
            android.os.Bundle r4 = r3.getArguments()
            if (r4 == 0) goto L_0x0071
            java.lang.String r0 = "price_regex"
            java.lang.String r1 = ""
            java.lang.String r4 = r4.getString(r0, r1)
            java.lang.String r0 = "it.getString(RechargeUtils.PRICE_REGEX,\"\")"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r0)
            r3.t = r4
        L_0x0071:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.fragment.h.onCreate(android.os.Bundle):void");
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.g.b.k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.v3_fragment_browse_plans, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        net.one97.paytm.recharge.common.widget.c cVar;
        Resources resources;
        kotlin.g.b.k.c(view, "view");
        this.m = (AppBarLayout) view.findViewById(R.id.appbar_layout);
        this.n = (ShimmerFrameLayout) view.findViewById(R.id.lyt_content_shimmer_browse_plan);
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) a(R.id.txt_search);
        if (autoCompleteTextView != null) {
            autoCompleteTextView.addTextChangedListener(new C1185h(this));
        }
        net.one97.paytm.recharge.common.e.a<IJRPaytmDataModel> aVar = this.s;
        if (aVar != null) {
            aVar.a();
        }
        this.s = new net.one97.paytm.recharge.common.e.a<>("search_browse_plan", this);
        io.reactivex.rxjava3.a.p<R> observeOn = this.q.debounce(500, TimeUnit.MILLISECONDS).distinctUntilChanged().filter(f.f61223a).switchMap(new g(this)).subscribeOn(io.reactivex.rxjava3.i.a.b()).observeOn(io.reactivex.rxjava3.android.b.a.a());
        net.one97.paytm.recharge.common.e.a<IJRPaytmDataModel> aVar2 = this.s;
        if (aVar2 == null) {
            kotlin.g.b.k.a();
        }
        observeOn.subscribe((io.reactivex.rxjava3.a.w<? super R>) aVar2);
        AutoCompleteTextView autoCompleteTextView2 = (AutoCompleteTextView) a(R.id.txt_search);
        if (autoCompleteTextView2 != null) {
            autoCompleteTextView2.setOnFocusChangeListener(new e(this));
        }
        View a2 = a(R.id.lyt_search);
        if (a2 != null) {
            a2.setOnClickListener(this);
        }
        RoboTextView roboTextView = (RoboTextView) a(R.id.view_all_button);
        if (roboTextView != null) {
            roboTextView.setOnClickListener(this);
        }
        RelativeLayout relativeLayout = (RelativeLayout) a(R.id.customRechargeRL);
        if (relativeLayout != null) {
            relativeLayout.setOnClickListener(this);
        }
        Context context = getContext();
        String str = null;
        if (context != null) {
            c.a aVar3 = net.one97.paytm.recharge.common.widget.c.f62144e;
            kotlin.g.b.k.a((Object) context, "it");
            cVar = c.a.a(context);
        } else {
            cVar = null;
        }
        this.f61213b = cVar;
        net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
        CJRRechargeErrorModel a3 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
        a3.setErrorType(ERROR_TYPE.UNDEFINED);
        CRUFlowModel flowName = a3.getFlowName();
        if (flowName != null) {
            flowName.setErrorType(ERROR_TYPE.UNDEFINED.name());
        }
        CRUFlowModel flowName2 = a3.getFlowName();
        if (flowName2 != null) {
            flowName2.setActionType(ACTION_TYPE.BROWSE_PLAN.name());
        }
        ViewPager viewPager = (ViewPager) a(R.id.viewpager);
        if (viewPager != null) {
            viewPager.setVisibility(0);
        }
        RelativeLayout relativeLayout2 = (RelativeLayout) a(R.id.customRechargeRL);
        if (relativeLayout2 != null) {
            relativeLayout2.setVisibility(8);
        }
        View a4 = a(R.id.customRechargeDivider);
        if (a4 != null) {
            a4.setVisibility(8);
        }
        RecyclerView recyclerView = (RecyclerView) a(R.id.browse_plan_search_recycler_view);
        if (recyclerView != null) {
            recyclerView.setVisibility(8);
        }
        StringBuilder sb = new StringBuilder();
        Bundle arguments = getArguments();
        if (arguments == null) {
            kotlin.g.b.k.a();
        }
        if (!TextUtils.isEmpty(arguments.getString("title"))) {
            Context context2 = getContext();
            if (!(context2 == null || (resources = context2.getResources()) == null)) {
                str = resources.getString(R.string.string_for);
            }
            sb.append(str);
            sb.append(arguments.getString("title"));
        }
        AppBarLayout appBarLayout = this.m;
        if (appBarLayout != null) {
            appBarLayout.a((AppBarLayout.b) this);
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            AppCompatActivity appCompatActivity = (AppCompatActivity) activity;
            FragmentActivity fragmentActivity = appCompatActivity;
            Toolbar toolbar = (Toolbar) fragmentActivity.findViewById(R.id.toolbar);
            if (toolbar != null) {
                toolbar.setTitle((CharSequence) "");
            }
            appCompatActivity.setSupportActionBar((Toolbar) fragmentActivity.findViewById(R.id.toolbar));
            ActionBar supportActionBar = appCompatActivity.getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.b(true);
            }
            appCompatActivity.getSupportActionBar();
            Toolbar toolbar2 = (Toolbar) a(R.id.toolbar);
            if (toolbar2 != null) {
                toolbar2.setOnTouchListener(new i(this));
            }
            TabLayout tabLayout = (TabLayout) a(R.id.tabs);
            if (tabLayout != null) {
                tabLayout.setVisibility(8);
            }
            View a5 = a(R.id.lyt_search);
            if (a5 != null) {
                a5.setVisibility(8);
            }
            View a6 = a(R.id.divider);
            if (a6 != null) {
                a6.setVisibility(8);
            }
            ShimmerFrameLayout shimmerFrameLayout = this.n;
            if (shimmerFrameLayout != null) {
                shimmerFrameLayout.a();
            }
            EditText editText = (EditText) a(R.id.focus_empty_view);
            if (editText != null) {
                editText.requestFocus();
            }
            net.one97.paytm.recharge.common.e.d dVar2 = this.f61212a;
            if (dVar2 == null || !dVar2.b()) {
                net.one97.paytm.recharge.common.e.d dVar3 = this.f61212a;
                if (dVar3 != null) {
                    dVar3.a("tag.get.browse.plans", this, a3);
                    return;
                }
                return;
            }
            net.one97.paytm.recharge.common.e.d dVar4 = this.f61212a;
            if (dVar4 != null) {
                dVar4.b("tag.get.one2one.plans", this, a3);
                return;
            }
            return;
        }
        throw new kotlin.u("null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
    }

    public static final class i implements View.OnTouchListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f61230a;

        i(h hVar) {
            this.f61230a = hVar;
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            if (this.f61230a.l != b.COLLAPSED) {
                return false;
            }
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) this.f61230a.a(R.id.txt_search);
            if (autoCompleteTextView != null) {
                autoCompleteTextView.requestFocus();
            }
            h hVar = this.f61230a;
            AutoCompleteTextView autoCompleteTextView2 = (AutoCompleteTextView) hVar.a(R.id.txt_search);
            kotlin.g.b.k.a((Object) autoCompleteTextView2, "txt_search");
            View view2 = autoCompleteTextView2;
            kotlin.g.b.k.c(view2, "view");
            try {
                if (hVar.getActivity() == null || !view2.requestFocus()) {
                    return false;
                }
                FragmentActivity activity = hVar.getActivity();
                if (activity == null) {
                    kotlin.g.b.k.a();
                }
                Object systemService = activity.getSystemService("input_method");
                if (systemService != null) {
                    ((InputMethodManager) systemService).showSoftInput(view2, 1);
                    return false;
                }
                throw new kotlin.u("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            } catch (Throwable th) {
                CJRRechargeUtilities.INSTANCE.debugLogExceptions(th);
                return false;
            }
        }
    }

    /* JADX WARNING: type inference failed for: r10v2, types: [android.text.Editable] */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x027c, code lost:
        if (r10.intValue() == 0) goto L_0x027e;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a_(java.lang.String r31, com.paytm.network.model.IJRPaytmDataModel r32, java.lang.Object r33) {
        /*
            r30 = this;
            r6 = r30
            r1 = r31
            r0 = r32
            r5 = r33
            net.one97.paytm.recharge.di.helper.CJRRechargeUtilities r2 = net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "ViewPager is "
            r3.<init>(r4)
            int r4 = net.one97.paytm.recharge.R.id.viewpager
            android.view.View r4 = r6.a((int) r4)
            androidx.viewpager.widget.ViewPager r4 = (androidx.viewpager.widget.ViewPager) r4
            r3.append(r4)
            java.lang.String r4 = " activity "
            r3.append(r4)
            androidx.fragment.app.FragmentActivity r4 = r30.getActivity()
            r3.append(r4)
            java.lang.String r4 = " isDetached "
            r3.append(r4)
            boolean r4 = r30.isDetached()
            r3.append(r4)
            java.lang.String r4 = " isAdded "
            r3.append(r4)
            boolean r4 = r30.isAdded()
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r2.debugLog(r3)
            androidx.fragment.app.FragmentActivity r2 = r30.getActivity()
            if (r2 == 0) goto L_0x0514
            boolean r2 = r30.isDetached()
            if (r2 != 0) goto L_0x0514
            boolean r2 = r30.isAdded()
            if (r2 != 0) goto L_0x005b
            goto L_0x0514
        L_0x005b:
            if (r1 != 0) goto L_0x005e
            return
        L_0x005e:
            int r2 = r31.hashCode()
            r3 = -2042516569(0xffffffff8641aba7, float:-3.6425376E-35)
            java.lang.String r4 = ""
            java.lang.String r7 = "null cannot be cast to non-null type net.one97.paytm.recharge.mobile.viewmodel.CJRMobileRechargeViewModel"
            r8 = 1
            r9 = 0
            r10 = 0
            if (r2 == r3) goto L_0x0410
            r3 = -1721320982(0xffffffff9966b9ea, float:-1.1928266E-23)
            java.lang.String r11 = "tag.get.browse.plans"
            if (r2 == r3) goto L_0x0389
            r3 = -692018830(0xffffffffd6c0a172, float:-1.05899817E14)
            if (r2 == r3) goto L_0x007c
            goto L_0x0514
        L_0x007c:
            boolean r2 = r1.equals(r11)
            if (r2 == 0) goto L_0x0514
            net.one97.paytm.recharge.common.e.d r2 = r6.f61212a
            boolean r3 = r2 instanceof net.one97.paytm.recharge.mobile.d.a
            if (r3 == 0) goto L_0x010b
            if (r2 == 0) goto L_0x0105
            net.one97.paytm.recharge.mobile.d.a r2 = (net.one97.paytm.recharge.mobile.d.a) r2
            r2.a_(r1, r0, r5)
            net.one97.paytm.recharge.common.e.d r2 = r6.f61212a
            if (r2 == 0) goto L_0x00ff
            net.one97.paytm.recharge.mobile.d.a r2 = (net.one97.paytm.recharge.mobile.d.a) r2
            r2.a_(r1, r0, r5)
            boolean r1 = r0 instanceof net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanResponseModelV8
            if (r1 != 0) goto L_0x009e
            r1 = r10
            goto L_0x009f
        L_0x009e:
            r1 = r0
        L_0x009f:
            net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanResponseModelV8 r1 = (net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanResponseModelV8) r1
            if (r1 == 0) goto L_0x010b
            boolean r3 = r5 instanceof net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel
            if (r3 != 0) goto L_0x00a8
            r5 = r10
        L_0x00a8:
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r5 = (net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r5
            if (r5 == 0) goto L_0x00b7
            java.lang.String r3 = r5.getProductId()
            java.lang.String r3 = java.lang.String.valueOf(r3)
            kotlin.x r5 = kotlin.x.f47997a
            goto L_0x00b8
        L_0x00b7:
            r3 = r4
        L_0x00b8:
            r5 = r3
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            int r5 = r5.length()
            if (r5 <= 0) goto L_0x00c3
            r5 = 1
            goto L_0x00c4
        L_0x00c3:
            r5 = 0
        L_0x00c4:
            if (r5 == 0) goto L_0x00fc
            androidx.a.e<java.lang.Object, java.util.WeakHashMap<java.lang.String, net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanResponseModelV8>> r5 = r2.V
            java.lang.Object r5 = r5.get(r3)
            if (r5 != 0) goto L_0x00d4
            java.util.WeakHashMap r5 = new java.util.WeakHashMap
            r5.<init>()
            goto L_0x00dc
        L_0x00d4:
            androidx.a.e<java.lang.Object, java.util.WeakHashMap<java.lang.String, net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanResponseModelV8>> r5 = r2.V
            java.lang.Object r5 = r5.get(r3)
            java.util.WeakHashMap r5 = (java.util.WeakHashMap) r5
        L_0x00dc:
            if (r5 == 0) goto L_0x00fc
            androidx.lifecycle.y<java.lang.String> r7 = r2.z
            androidx.lifecycle.LiveData r7 = (androidx.lifecycle.LiveData) r7
            java.lang.Object r7 = r7.getValue()
            boolean r7 = r5.containsKey(r7)
            if (r7 != 0) goto L_0x00fc
            androidx.lifecycle.y<java.lang.String> r7 = r2.z
            androidx.lifecycle.LiveData r7 = (androidx.lifecycle.LiveData) r7
            java.lang.Object r7 = r7.getValue()
            r5.put(r7, r1)
            androidx.a.e<java.lang.Object, java.util.WeakHashMap<java.lang.String, net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanResponseModelV8>> r1 = r2.V
            r1.put(r3, r5)
        L_0x00fc:
            kotlin.x r1 = kotlin.x.f47997a
            goto L_0x010b
        L_0x00ff:
            kotlin.u r0 = new kotlin.u
            r0.<init>(r7)
            throw r0
        L_0x0105:
            kotlin.u r0 = new kotlin.u
            r0.<init>(r7)
            throw r0
        L_0x010b:
            boolean r1 = r0 instanceof net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanResponseModelV8
            if (r1 != 0) goto L_0x0110
            r0 = r10
        L_0x0110:
            net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanResponseModelV8 r0 = (net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanResponseModelV8) r0
            if (r0 == 0) goto L_0x014c
            java.util.List r0 = r0.getGroupings()
            if (r0 == 0) goto L_0x014c
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Collection r1 = (java.util.Collection) r1
            java.util.Iterator r0 = r0.iterator()
        L_0x0127:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0149
            java.lang.Object r2 = r0.next()
            r3 = r2
            net.one97.paytm.recharge.model.rechargeutility.CJRBowsePlanGroupingListV8 r3 = (net.one97.paytm.recharge.model.rechargeutility.CJRBowsePlanGroupingListV8) r3
            java.lang.String r5 = "it"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r5)
            java.util.List r3 = r3.getProductList()
            java.util.Collection r3 = (java.util.Collection) r3
            boolean r3 = net.one97.paytm.nativesdk.ExtensionsKt.isNotNullNotEmpty(r3)
            if (r3 == 0) goto L_0x0127
            r1.add(r2)
            goto L_0x0127
        L_0x0149:
            java.util.List r1 = (java.util.List) r1
            goto L_0x0154
        L_0x014c:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = r0
            java.util.List r1 = (java.util.List) r1
        L_0x0154:
            r6.f61214d = r1
            java.util.List<? extends net.one97.paytm.recharge.model.rechargeutility.CJRBowsePlanGroupingListV8> r0 = r6.f61214d
            r1 = 8
            if (r0 == 0) goto L_0x0162
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x016f
        L_0x0162:
            java.util.List<? extends net.one97.paytm.recharge.model.mobile.CJRMadeForYouPlanData> r0 = r6.f61218h
            if (r0 == 0) goto L_0x0314
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            r0 = r0 ^ r8
            if (r0 != r8) goto L_0x0314
        L_0x016f:
            net.one97.paytm.recharge.common.a.c r0 = r6.f61215e
            if (r0 != 0) goto L_0x0514
            net.one97.paytm.recharge.common.e.d r0 = r6.f61212a
            if (r0 == 0) goto L_0x018f
            boolean r0 = r0.b()
            if (r0 != r8) goto L_0x018f
            java.util.List<? extends net.one97.paytm.recharge.model.mobile.CJRMadeForYouPlanData> r0 = r6.f61218h
            if (r0 == 0) goto L_0x018f
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            r0 = r0 ^ r8
            if (r0 != r8) goto L_0x018f
            java.util.List<? extends net.one97.paytm.recharge.model.rechargeutility.CJRBowsePlanGroupingListV8> r0 = r6.f61214d
            r6.a((java.util.List<? extends net.one97.paytm.recharge.model.rechargeutility.CJRBowsePlanGroupingListV8>) r0, (java.util.List<? extends net.one97.paytm.recharge.model.mobile.CJRMadeForYouPlanData>) r10)
        L_0x018f:
            net.one97.paytm.recharge.common.a.c r0 = new net.one97.paytm.recharge.common.a.c
            androidx.fragment.app.j r12 = r30.getChildFragmentManager()
            java.lang.String r2 = "childFragmentManager"
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r2)
            java.util.List<? extends net.one97.paytm.recharge.model.rechargeutility.CJRBowsePlanGroupingListV8> r13 = r6.f61214d
            int r2 = net.one97.paytm.recharge.R.id.viewpager
            android.view.View r2 = r6.a((int) r2)
            r14 = r2
            androidx.viewpager.widget.ViewPager r14 = (androidx.viewpager.widget.ViewPager) r14
            java.lang.String r2 = "viewpager"
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r2)
            r15 = r6
            net.one97.paytm.recharge.common.d.f$a r15 = (net.one97.paytm.recharge.common.d.f.a) r15
            net.one97.paytm.recharge.common.e.d r2 = r6.f61212a
            if (r2 == 0) goto L_0x01bb
            java.lang.Object r2 = r2.e()
            if (r2 != 0) goto L_0x01b8
            goto L_0x01bb
        L_0x01b8:
            r16 = r2
            goto L_0x01bd
        L_0x01bb:
            r16 = r4
        L_0x01bd:
            r11 = r0
            r11.<init>(r12, r13, r14, r15, r16)
            r6.f61215e = r0
            java.util.List<? extends net.one97.paytm.recharge.model.rechargeutility.CJRBowsePlanGroupingListV8> r0 = r6.f61214d
            if (r0 != 0) goto L_0x01ca
            kotlin.g.b.k.a()
        L_0x01ca:
            int r0 = r0.size()
            r2 = 3
            if (r0 <= r2) goto L_0x01de
            int r0 = net.one97.paytm.recharge.R.id.tabs
            android.view.View r0 = r6.a((int) r0)
            com.google.android.material.tabs.TabLayout r0 = (com.google.android.material.tabs.TabLayout) r0
            if (r0 == 0) goto L_0x01de
            r0.setTabMode(r9)
        L_0x01de:
            int r0 = net.one97.paytm.recharge.R.id.viewpager
            android.view.View r0 = r6.a((int) r0)
            androidx.viewpager.widget.ViewPager r0 = (androidx.viewpager.widget.ViewPager) r0
            if (r0 == 0) goto L_0x01ef
            net.one97.paytm.recharge.common.a.c r2 = r6.f61215e
            androidx.viewpager.widget.a r2 = (androidx.viewpager.widget.a) r2
            r0.setAdapter(r2)
        L_0x01ef:
            int r0 = net.one97.paytm.recharge.R.id.tabs
            android.view.View r0 = r6.a((int) r0)
            com.google.android.material.tabs.TabLayout r0 = (com.google.android.material.tabs.TabLayout) r0
            if (r0 == 0) goto L_0x0206
            int r2 = net.one97.paytm.recharge.R.id.viewpager
            android.view.View r2 = r6.a((int) r2)
            androidx.viewpager.widget.ViewPager r2 = (androidx.viewpager.widget.ViewPager) r2
            r0.setupWithViewPager(r2)
            kotlin.x r0 = kotlin.x.f47997a
        L_0x0206:
            int r0 = net.one97.paytm.recharge.R.id.viewpager
            android.view.View r0 = r6.a((int) r0)
            androidx.viewpager.widget.ViewPager r0 = (androidx.viewpager.widget.ViewPager) r0
            if (r0 == 0) goto L_0x0214
            r2 = 5
            r0.setOffscreenPageLimit(r2)
        L_0x0214:
            int r0 = net.one97.paytm.recharge.R.id.viewpager
            android.view.View r0 = r6.a((int) r0)
            androidx.viewpager.widget.ViewPager r0 = (androidx.viewpager.widget.ViewPager) r0
            if (r0 == 0) goto L_0x0226
            r2 = r6
            androidx.viewpager.widget.ViewPager$e r2 = (androidx.viewpager.widget.ViewPager.e) r2
            r0.addOnPageChangeListener(r2)
            kotlin.x r0 = kotlin.x.f47997a
        L_0x0226:
            net.one97.paytm.recharge.common.e.d r0 = r6.f61212a
            if (r0 == 0) goto L_0x02cf
            boolean r0 = r0.b()
            if (r0 != r8) goto L_0x02cf
            java.util.List<? extends net.one97.paytm.recharge.model.mobile.CJRMadeForYouPlanData> r0 = r6.f61218h
            if (r0 == 0) goto L_0x02cf
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            r0 = r0 ^ r8
            if (r0 != r8) goto L_0x02cf
            net.one97.paytm.recharge.common.a.c r0 = r6.f61215e
            if (r0 == 0) goto L_0x02b5
            androidx.fragment.app.Fragment r0 = r0.a()
            boolean r2 = r0 instanceof net.one97.paytm.recharge.common.fragment.r
            if (r2 == 0) goto L_0x02b3
            net.one97.paytm.recharge.common.fragment.r r0 = (net.one97.paytm.recharge.common.fragment.r) r0
            net.one97.paytm.recharge.model.rechargeutility.CJRBowsePlanGroupingListV8 r2 = r0.f61385c
            if (r2 == 0) goto L_0x02a6
            boolean r2 = r2.isOneToOne()
            if (r2 != r8) goto L_0x02a6
            net.one97.paytm.recharge.model.rechargeutility.CJRBowsePlanGroupingListV8 r2 = r0.f61385c
            if (r2 == 0) goto L_0x025e
            java.util.List r2 = r2.getProductList()
            goto L_0x025f
        L_0x025e:
            r2 = r10
        L_0x025f:
            if (r2 == 0) goto L_0x027e
            net.one97.paytm.recharge.model.rechargeutility.CJRBowsePlanGroupingListV8 r2 = r0.f61385c
            if (r2 == 0) goto L_0x0273
            java.util.List r2 = r2.getProductList()
            if (r2 == 0) goto L_0x0273
            int r2 = r2.size()
            java.lang.Integer r10 = java.lang.Integer.valueOf(r2)
        L_0x0273:
            if (r10 != 0) goto L_0x0278
            kotlin.g.b.k.a()
        L_0x0278:
            int r2 = r10.intValue()
            if (r2 != 0) goto L_0x02a6
        L_0x027e:
            int r2 = net.one97.paytm.recharge.R.id.layout_progress_bar
            android.view.View r2 = r0.a((int) r2)
            android.widget.RelativeLayout r2 = (android.widget.RelativeLayout) r2
            if (r2 == 0) goto L_0x028b
            r2.setVisibility(r9)
        L_0x028b:
            int r2 = net.one97.paytm.recharge.R.id.loading
            android.view.View r2 = r0.a((int) r2)
            android.widget.ProgressBar r2 = (android.widget.ProgressBar) r2
            if (r2 == 0) goto L_0x0298
            r2.setVisibility(r9)
        L_0x0298:
            int r2 = net.one97.paytm.recharge.R.id.plans_not_available
            android.view.View r0 = r0.a((int) r2)
            android.widget.TextView r0 = (android.widget.TextView) r0
            if (r0 == 0) goto L_0x02b3
            r0.setVisibility(r1)
            goto L_0x02b3
        L_0x02a6:
            int r2 = net.one97.paytm.recharge.R.id.layout_progress_bar
            android.view.View r0 = r0.a((int) r2)
            android.widget.RelativeLayout r0 = (android.widget.RelativeLayout) r0
            if (r0 == 0) goto L_0x02b3
            r0.setVisibility(r1)
        L_0x02b3:
            kotlin.x r0 = kotlin.x.f47997a
        L_0x02b5:
            java.util.List<? extends net.one97.paytm.recharge.model.rechargeutility.CJRBowsePlanGroupingListV8> r0 = r6.f61214d
            java.util.List<? extends net.one97.paytm.recharge.model.mobile.CJRMadeForYouPlanData> r2 = r6.f61218h
            r6.a((java.util.List<? extends net.one97.paytm.recharge.model.rechargeutility.CJRBowsePlanGroupingListV8>) r0, (java.util.List<? extends net.one97.paytm.recharge.model.mobile.CJRMadeForYouPlanData>) r2)
            int r0 = net.one97.paytm.recharge.R.id.viewpager
            android.view.View r0 = r6.a((int) r0)
            androidx.viewpager.widget.ViewPager r0 = (androidx.viewpager.widget.ViewPager) r0
            if (r0 == 0) goto L_0x02cf
            int r0 = r0.getCurrentItem()
            if (r0 != 0) goto L_0x02cf
            r6.onPageSelected(r9)
        L_0x02cf:
            r30.b()
            r6.onPageSelected(r9)
            int r0 = net.one97.paytm.recharge.R.id.browsePlanLYT
            android.view.View r0 = r6.a((int) r0)
            if (r0 == 0) goto L_0x02e0
            r0.setVisibility(r9)
        L_0x02e0:
            int r0 = net.one97.paytm.recharge.R.id.lyt_search
            android.view.View r0 = r6.a((int) r0)
            if (r0 == 0) goto L_0x02eb
            r0.setVisibility(r9)
        L_0x02eb:
            int r0 = net.one97.paytm.recharge.R.id.divider
            android.view.View r0 = r6.a((int) r0)
            if (r0 == 0) goto L_0x02f6
            r0.setVisibility(r9)
        L_0x02f6:
            int r0 = net.one97.paytm.recharge.R.id.tabs
            android.view.View r0 = r6.a((int) r0)
            com.google.android.material.tabs.TabLayout r0 = (com.google.android.material.tabs.TabLayout) r0
            if (r0 == 0) goto L_0x0303
            r0.setVisibility(r9)
        L_0x0303:
            net.one97.paytm.common.views.ShimmerFrameLayout r0 = r6.n
            if (r0 == 0) goto L_0x030a
            r0.setVisibility(r1)
        L_0x030a:
            net.one97.paytm.common.views.ShimmerFrameLayout r0 = r6.n
            if (r0 == 0) goto L_0x0313
            r0.b()
            kotlin.x r0 = kotlin.x.f47997a
        L_0x0313:
            return
        L_0x0314:
            net.one97.paytm.common.views.ShimmerFrameLayout r0 = r6.n
            if (r0 == 0) goto L_0x031d
            r0.b()
            kotlin.x r0 = kotlin.x.f47997a
        L_0x031d:
            net.one97.paytm.common.views.ShimmerFrameLayout r0 = r6.n
            if (r0 == 0) goto L_0x0324
            r0.setVisibility(r1)
        L_0x0324:
            int r0 = net.one97.paytm.recharge.R.id.lyt_search
            android.view.View r0 = r6.a((int) r0)
            if (r0 == 0) goto L_0x032f
            r0.setVisibility(r1)
        L_0x032f:
            int r0 = net.one97.paytm.recharge.R.id.divider
            android.view.View r0 = r6.a((int) r0)
            if (r0 == 0) goto L_0x033a
            r0.setVisibility(r1)
        L_0x033a:
            int r0 = net.one97.paytm.recharge.R.id.tabs
            android.view.View r0 = r6.a((int) r0)
            com.google.android.material.tabs.TabLayout r0 = (com.google.android.material.tabs.TabLayout) r0
            if (r0 == 0) goto L_0x0347
            r0.setVisibility(r1)
        L_0x0347:
            int r0 = net.one97.paytm.recharge.R.id.plans_not_available
            android.view.View r0 = r6.a((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            if (r0 == 0) goto L_0x0354
            r0.setVisibility(r9)
        L_0x0354:
            com.google.android.material.appbar.AppBarLayout r0 = r6.m
            if (r0 == 0) goto L_0x035d
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            goto L_0x035e
        L_0x035d:
            r0 = r10
        L_0x035e:
            boolean r2 = r0 instanceof androidx.coordinatorlayout.widget.CoordinatorLayout.d
            if (r2 != 0) goto L_0x0363
            r0 = r10
        L_0x0363:
            androidx.coordinatorlayout.widget.CoordinatorLayout$d r0 = (androidx.coordinatorlayout.widget.CoordinatorLayout.d) r0
            com.google.android.material.appbar.AppBarLayout$Behavior r2 = new com.google.android.material.appbar.AppBarLayout$Behavior
            r2.<init>()
            net.one97.paytm.recharge.widgets.c.f r3 = new net.one97.paytm.recharge.widgets.c.f
            r3.<init>(r9)
            com.google.android.material.appbar.AppBarLayout$BaseBehavior$a r3 = (com.google.android.material.appbar.AppBarLayout.BaseBehavior.a) r3
            r2.setDragCallback(r3)
            if (r0 == 0) goto L_0x037b
            androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior r2 = (androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior) r2
            r0.a((androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior) r2)
        L_0x037b:
            int r0 = net.one97.paytm.recharge.R.id.scroll
            android.view.View r0 = r6.a((int) r0)
            androidx.core.widget.NestedScrollView r0 = (androidx.core.widget.NestedScrollView) r0
            if (r0 == 0) goto L_0x0388
            r0.setVisibility(r1)
        L_0x0388:
            return
        L_0x0389:
            java.lang.String r2 = "tag.get.one2one.plans"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0514
            net.one97.paytm.recharge.common.e.d r2 = r6.f61212a
            boolean r3 = r2 instanceof net.one97.paytm.recharge.mobile.d.a
            if (r3 == 0) goto L_0x03a5
            if (r2 == 0) goto L_0x039f
            net.one97.paytm.recharge.mobile.d.a r2 = (net.one97.paytm.recharge.mobile.d.a) r2
            r2.a_(r1, r0, r5)
            goto L_0x03a5
        L_0x039f:
            kotlin.u r0 = new kotlin.u
            r0.<init>(r7)
            throw r0
        L_0x03a5:
            boolean r2 = r0 instanceof net.one97.paytm.recharge.model.mobile.CJRMadeForYouResponse
            if (r2 == 0) goto L_0x0403
            net.one97.paytm.recharge.model.mobile.CJRMadeForYouResponse r0 = (net.one97.paytm.recharge.model.mobile.CJRMadeForYouResponse) r0
            java.util.List r0 = r0.getPlansData()
            r6.f61218h = r0
            boolean r0 = r5 instanceof net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel
            if (r0 == 0) goto L_0x03dc
            r12 = r5
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r12 = (net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r12
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 32719(0x7fcf, float:4.5849E-41)
            r29 = 0
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r0 = net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel.copy$default(r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29)
            goto L_0x03e2
        L_0x03dc:
            net.one97.paytm.recharge.widgets.c.d r0 = net.one97.paytm.recharge.widgets.c.d.f64967a
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r0 = net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r10, (net.one97.paytm.recharge.widgets.model.ERROR_TYPE) r10)
        L_0x03e2:
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r1 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UNDEFINED
            r0.setErrorType(r1)
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r1 = r0.getFlowName()
            if (r1 == 0) goto L_0x03f6
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r2 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UNDEFINED
            java.lang.String r2 = r2.name()
            r1.setErrorType(r2)
        L_0x03f6:
            net.one97.paytm.recharge.common.e.d r1 = r6.f61212a
            if (r1 == 0) goto L_0x0402
            r2 = r6
            net.one97.paytm.recharge.common.e.ai r2 = (net.one97.paytm.recharge.common.e.ai) r2
            r1.a(r11, r2, r0)
            kotlin.x r0 = kotlin.x.f47997a
        L_0x0402:
            return
        L_0x0403:
            r2 = 0
            r3 = 0
            r4 = 0
            r0 = r30
            r1 = r31
            r5 = r33
            r0.a(r1, r2, r3, r4, r5)
            return
        L_0x0410:
            java.lang.String r2 = "search_browse_plan"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0514
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            boolean r3 = r0 instanceof net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanSearchModelV8
            if (r3 != 0) goto L_0x0423
            r11 = r10
            goto L_0x0424
        L_0x0423:
            r11 = r0
        L_0x0424:
            net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanSearchModelV8 r11 = (net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanSearchModelV8) r11
            if (r11 == 0) goto L_0x0437
            java.util.List r11 = r11.getProductList()
            if (r11 == 0) goto L_0x0437
            java.util.Collection r11 = (java.util.Collection) r11
            boolean r11 = r2.addAll(r11)
            java.lang.Boolean.valueOf(r11)
        L_0x0437:
            net.one97.paytm.recharge.common.e.d r11 = r6.f61212a
            boolean r12 = r11 instanceof net.one97.paytm.recharge.mobile.d.a
            if (r12 == 0) goto L_0x050f
            if (r11 == 0) goto L_0x0509
            net.one97.paytm.recharge.mobile.d.a r11 = (net.one97.paytm.recharge.mobile.d.a) r11
            r11.a_(r1, r0, r5)
            r1 = r2
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = net.one97.paytm.nativesdk.ExtensionsKt.isNotNullNotEmpty(r1)
            if (r1 == 0) goto L_0x050f
            boolean r1 = r5 instanceof net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel
            if (r1 != 0) goto L_0x0452
            r5 = r10
        L_0x0452:
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r5 = (net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r5
            if (r5 == 0) goto L_0x0481
            java.lang.String r1 = r5.getProductId()
            if (r1 == 0) goto L_0x0481
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r4 = r5.getProductId()
            r1.append(r4)
            r4 = 45
            r1.append(r4)
            androidx.lifecycle.y<java.lang.String> r4 = r11.z
            androidx.lifecycle.LiveData r4 = (androidx.lifecycle.LiveData) r4
            java.lang.Object r4 = r4.getValue()
            java.lang.String r4 = (java.lang.String) r4
            r1.append(r4)
            java.lang.String r1 = r1.toString()
            kotlin.x r4 = kotlin.x.f47997a
            r4 = r1
        L_0x0481:
            androidx.a.e<java.lang.Object, java.util.HashMap<java.lang.String, net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanSearchModelV8>> r1 = r11.U
            java.lang.Object r1 = r1.get(r4)
            if (r1 != 0) goto L_0x048f
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            goto L_0x0497
        L_0x048f:
            androidx.a.e<java.lang.Object, java.util.HashMap<java.lang.String, net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanSearchModelV8>> r1 = r11.U
            java.lang.Object r1 = r1.get(r4)
            java.util.HashMap r1 = (java.util.HashMap) r1
        L_0x0497:
            if (r1 == 0) goto L_0x050f
            int r5 = net.one97.paytm.recharge.R.id.txt_search
            android.view.View r5 = r6.a((int) r5)
            android.widget.AutoCompleteTextView r5 = (android.widget.AutoCompleteTextView) r5
            if (r5 == 0) goto L_0x04a8
            android.text.Editable r5 = r5.getText()
            goto L_0x04a9
        L_0x04a8:
            r5 = r10
        L_0x04a9:
            java.lang.String r5 = java.lang.String.valueOf(r5)
            java.lang.String r7 = "null cannot be cast to non-null type kotlin.CharSequence"
            if (r5 == 0) goto L_0x0503
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            java.lang.CharSequence r5 = kotlin.m.p.b(r5)
            java.lang.String r5 = r5.toString()
            boolean r5 = r1.containsKey(r5)
            if (r5 != 0) goto L_0x050f
            if (r3 != 0) goto L_0x04c4
            r0 = r10
        L_0x04c4:
            net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanSearchModelV8 r0 = (net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanSearchModelV8) r0
            if (r0 == 0) goto L_0x04f0
            int r3 = net.one97.paytm.recharge.R.id.txt_search
            android.view.View r3 = r6.a((int) r3)
            android.widget.AutoCompleteTextView r3 = (android.widget.AutoCompleteTextView) r3
            if (r3 == 0) goto L_0x04d6
            android.text.Editable r10 = r3.getText()
        L_0x04d6:
            java.lang.String r3 = java.lang.String.valueOf(r10)
            if (r3 == 0) goto L_0x04ea
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            java.lang.CharSequence r3 = kotlin.m.p.b(r3)
            java.lang.String r3 = r3.toString()
            r1.put(r3, r0)
            goto L_0x04f0
        L_0x04ea:
            kotlin.u r0 = new kotlin.u
            r0.<init>(r7)
            throw r0
        L_0x04f0:
            r0 = r4
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r0 = r0.length()
            if (r0 <= 0) goto L_0x04fa
            goto L_0x04fb
        L_0x04fa:
            r8 = 0
        L_0x04fb:
            if (r8 == 0) goto L_0x050f
            androidx.a.e<java.lang.Object, java.util.HashMap<java.lang.String, net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanSearchModelV8>> r0 = r11.U
            r0.put(r4, r1)
            goto L_0x050f
        L_0x0503:
            kotlin.u r0 = new kotlin.u
            r0.<init>(r7)
            throw r0
        L_0x0509:
            kotlin.u r0 = new kotlin.u
            r0.<init>(r7)
            throw r0
        L_0x050f:
            java.util.List r2 = (java.util.List) r2
            r6.a((java.util.List<? extends net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList>) r2)
        L_0x0514:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.fragment.h.a_(java.lang.String, com.paytm.network.model.IJRPaytmDataModel, java.lang.Object):void");
    }

    private final void a(List<? extends CJRBrowsePlanProductList> list) {
        Object obj;
        Object e2;
        boolean z;
        net.one97.paytm.recharge.common.a.e eVar;
        Object obj2;
        Object obj3;
        Object e3;
        List<? extends CJRBrowsePlanProductList> list2 = list;
        if (!list.isEmpty()) {
            Context context = getContext();
            if (context != null) {
                kotlin.g.b.k.a((Object) context, "it");
                net.one97.paytm.recharge.ordersummary.h.d dVar = new net.one97.paytm.recharge.ordersummary.h.d(context);
                net.one97.paytm.recharge.common.e.d dVar2 = this.f61212a;
                if (dVar2 == null || (e3 = dVar2.e()) == null) {
                    obj3 = "";
                } else {
                    obj3 = e3;
                }
                net.one97.paytm.recharge.ordersummary.h.d.a(dVar, obj3, "browse_plan_searched", "", "search result true", (Object) null, (Object) null, (Object) null, 112);
            }
            if (this.f61216f == null) {
                net.one97.paytm.recharge.common.e.d dVar3 = this.f61212a;
                if (dVar3 == null || (obj2 = dVar3.e()) == null) {
                    obj2 = "";
                }
                this.f61216f = new net.one97.paytm.recharge.common.a.e(list2, obj2, this);
                RecyclerView recyclerView = (RecyclerView) a(R.id.browse_plan_search_recycler_view);
                if (recyclerView != null) {
                    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                }
                RecyclerView recyclerView2 = (RecyclerView) a(R.id.browse_plan_search_recycler_view);
                if (recyclerView2 != null) {
                    recyclerView2.setAdapter(this.f61216f);
                }
            } else {
                Collection collection = list2;
                if ((!collection.isEmpty()) && (eVar = this.f61216f) != null) {
                    kotlin.g.b.k.c(list2, "result");
                    if (eVar.f60491a instanceof ArrayList) {
                        ((ArrayList) eVar.f60491a).clear();
                        ((ArrayList) eVar.f60491a).addAll(collection);
                    }
                    eVar.notifyDataSetChanged();
                }
            }
            Iterator<? extends CJRBrowsePlanProductList> it2 = list.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    z = false;
                    break;
                }
                CJRBrowsePlanProductList cJRBrowsePlanProductList = (CJRBrowsePlanProductList) it2.next();
                if (!TextUtils.isEmpty(this.p) && kotlin.g.b.k.a(cJRBrowsePlanProductList.getPrice(), Double.parseDouble(this.p))) {
                    z = true;
                    break;
                }
            }
            if (z || TextUtils.isEmpty(this.p)) {
                RelativeLayout relativeLayout = (RelativeLayout) a(R.id.customRechargeRL);
                if (relativeLayout != null) {
                    relativeLayout.setVisibility(8);
                }
                View a2 = a(R.id.customRechargeDivider);
                if (a2 != null) {
                    a2.setVisibility(8);
                }
                TextView textView = (TextView) a(R.id.customRechargeTv);
                if (textView != null) {
                    textView.setText("");
                }
                this.p = "";
            } else {
                RelativeLayout relativeLayout2 = (RelativeLayout) a(R.id.customRechargeRL);
                if (relativeLayout2 != null) {
                    relativeLayout2.setVisibility(0);
                }
                View a3 = a(R.id.customRechargeDivider);
                if (a3 != null) {
                    a3.setVisibility(0);
                }
                TextView textView2 = (TextView) a(R.id.customRechargeTv);
                if (textView2 != null) {
                    textView2.setText(getString(R.string.custom_recharge_text, this.p));
                }
            }
            RoboTextView roboTextView = (RoboTextView) a(R.id.view_all_button);
            if (roboTextView != null) {
                roboTextView.setVisibility(8);
            }
            RoboTextView roboTextView2 = (RoboTextView) a(R.id.no_match_found);
            if (roboTextView2 != null) {
                roboTextView2.setVisibility(8);
            }
            RecyclerView recyclerView3 = (RecyclerView) a(R.id.browse_plan_search_recycler_view);
            if (recyclerView3 != null) {
                recyclerView3.setVisibility(0);
                return;
            }
            return;
        }
        Context context2 = getContext();
        if (context2 != null) {
            kotlin.g.b.k.a((Object) context2, "it");
            net.one97.paytm.recharge.ordersummary.h.d dVar4 = new net.one97.paytm.recharge.ordersummary.h.d(context2);
            net.one97.paytm.recharge.common.e.d dVar5 = this.f61212a;
            if (dVar5 == null || (e2 = dVar5.e()) == null) {
                obj = "";
            } else {
                obj = e2;
            }
            net.one97.paytm.recharge.ordersummary.h.d.a(dVar4, obj, "browse_plan_searched", "", "search result false", (Object) null, (Object) null, (Object) null, 112);
        }
        if (!TextUtils.isEmpty(this.p)) {
            RelativeLayout relativeLayout3 = (RelativeLayout) a(R.id.customRechargeRL);
            if (relativeLayout3 != null) {
                relativeLayout3.setVisibility(0);
            }
            View a4 = a(R.id.customRechargeDivider);
            if (a4 != null) {
                a4.setVisibility(0);
            }
            TextView textView3 = (TextView) a(R.id.customRechargeTv);
            if (textView3 != null) {
                textView3.setText(getString(R.string.custom_recharge_text, this.p));
            }
        } else {
            RelativeLayout relativeLayout4 = (RelativeLayout) a(R.id.customRechargeRL);
            if (relativeLayout4 != null) {
                relativeLayout4.setVisibility(8);
            }
            View a5 = a(R.id.customRechargeDivider);
            if (a5 != null) {
                a5.setVisibility(8);
            }
            TextView textView4 = (TextView) a(R.id.customRechargeTv);
            if (textView4 != null) {
                textView4.setText("");
            }
        }
        RoboTextView roboTextView3 = (RoboTextView) a(R.id.view_all_button);
        if (roboTextView3 != null) {
            roboTextView3.setVisibility(0);
        }
        RoboTextView roboTextView4 = (RoboTextView) a(R.id.no_match_found);
        if (roboTextView4 != null) {
            roboTextView4.setVisibility(0);
        }
        RecyclerView recyclerView4 = (RecyclerView) a(R.id.browse_plan_search_recycler_view);
        if (recyclerView4 != null) {
            recyclerView4.setVisibility(8);
        }
    }

    public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
        CJRRechargeErrorModel cJRRechargeErrorModel;
        String str2 = str;
        Object obj2 = obj;
        if (str2 != null) {
            int hashCode = str.hashCode();
            if (hashCode != -2042516569) {
                if (hashCode != -1721320982) {
                    if (hashCode == -692018830 && str2.equals("tag.get.browse.plans")) {
                        a_(str2, (IJRPaytmDataModel) null, obj2);
                        if (obj2 instanceof CJRRechargeErrorModel) {
                            az azVar = az.f61525a;
                            az.a((CJRRechargeErrorModel) obj2);
                        }
                    }
                } else if (str2.equals("tag.get.one2one.plans")) {
                    boolean z = obj2 instanceof CJRRechargeErrorModel;
                    if (z) {
                        cJRRechargeErrorModel = CJRRechargeErrorModel.copy$default((CJRRechargeErrorModel) obj2, (VERTICAL) null, (ERROR_TYPE) null, (String) null, (a.b) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (CRUFlowModel) null, (HashMap) null, (String) null, (Bundle) null, (Object) null, 32719, (Object) null);
                        CRUFlowModel flowName = cJRRechargeErrorModel.getFlowName();
                        if (flowName != null) {
                            flowName.setErrorType(ERROR_TYPE.UNDEFINED.name());
                        }
                    } else {
                        net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
                        cJRRechargeErrorModel = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
                    }
                    cJRRechargeErrorModel.setErrorType(ERROR_TYPE.UNDEFINED);
                    CRUFlowModel flowName2 = cJRRechargeErrorModel.getFlowName();
                    if (flowName2 != null) {
                        flowName2.setErrorType(ERROR_TYPE.UNDEFINED.name());
                    }
                    net.one97.paytm.recharge.common.e.d dVar2 = this.f61212a;
                    if (dVar2 != null) {
                        dVar2.a("tag.get.browse.plans", this, cJRRechargeErrorModel);
                    }
                    if (z) {
                        az azVar2 = az.f61525a;
                        az.a((CJRRechargeErrorModel) obj2);
                    }
                }
            } else if (str2.equals("search_browse_plan")) {
                a_(str2, (IJRPaytmDataModel) null, obj2);
                if (obj2 instanceof CJRRechargeErrorModel) {
                    az azVar3 = az.f61525a;
                    az.a((CJRRechargeErrorModel) obj2);
                }
            }
        }
    }

    private final void b() {
        int tabCount = ((TabLayout) a(R.id.tabs)).getTabCount();
        int i2 = 0;
        while (i2 < tabCount) {
            View childAt = ((TabLayout) a(R.id.tabs)).getChildAt(0);
            if (childAt != null) {
                View childAt2 = ((ViewGroup) childAt).getChildAt(i2);
                kotlin.g.b.k.a((Object) childAt2, "tab");
                ViewGroup.LayoutParams layoutParams = childAt2.getLayoutParams();
                if (layoutParams != null) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    int c2 = i2 != 0 ? com.paytm.utility.b.c(16) : 0;
                    TabLayout tabLayout = (TabLayout) a(R.id.tabs);
                    kotlin.g.b.k.a((Object) tabLayout, CJRHomePage.LAYOUT_HOME_PAGE_TABS);
                    marginLayoutParams.setMargins(c2, com.paytm.utility.b.c(11), i2 == tabLayout.getTabCount() + -1 ? com.paytm.utility.b.c(16) : 0, com.paytm.utility.b.c(11));
                    childAt2.requestLayout();
                    i2++;
                } else {
                    throw new kotlin.u("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                }
            } else {
                throw new kotlin.u("null cannot be cast to non-null type android.view.ViewGroup");
            }
        }
    }

    private void a(List<? extends CJRBowsePlanGroupingListV8> list, List<? extends CJRMadeForYouPlanData> list2) {
        CJRBowsePlanGroupingListV8 cJRBowsePlanGroupingListV8;
        Object obj;
        List<CJRBrowsePlanProductList> list3 = null;
        if (list != null) {
            Iterator it2 = list.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it2.next();
                if (((CJRBowsePlanGroupingListV8) obj).isOneToOne()) {
                    break;
                }
            }
            cJRBowsePlanGroupingListV8 = (CJRBowsePlanGroupingListV8) obj;
        } else {
            cJRBowsePlanGroupingListV8 = null;
        }
        this.f61217g = cJRBowsePlanGroupingListV8;
        this.f61217g = a(this.f61217g, list2);
        CJRBowsePlanGroupingListV8 cJRBowsePlanGroupingListV82 = this.f61217g;
        if (cJRBowsePlanGroupingListV82 != null) {
            net.one97.paytm.recharge.common.e.d dVar = this.f61212a;
            cJRBowsePlanGroupingListV82.setDisclaimer(dVar != null ? dVar.c() : null);
        }
        net.one97.paytm.recharge.common.e.d dVar2 = this.f61212a;
        String a2 = dVar2 != null ? dVar2.a() : null;
        CharSequence charSequence = a2;
        if (charSequence == null || p.a(charSequence)) {
            a2 = "121 Made for You";
        }
        CJRBowsePlanGroupingListV8 cJRBowsePlanGroupingListV83 = this.f61217g;
        if (cJRBowsePlanGroupingListV83 != null) {
            cJRBowsePlanGroupingListV83.setName(a2);
        }
        if (this.f61217g != null && list != null) {
            Iterator<? extends CJRBowsePlanGroupingListV8> it3 = list.iterator();
            int i2 = 0;
            while (true) {
                if (!it3.hasNext()) {
                    i2 = -1;
                    break;
                } else if (((CJRBowsePlanGroupingListV8) it3.next()).isOneToOne()) {
                    break;
                } else {
                    i2++;
                }
            }
            if (i2 != -1) {
                net.one97.paytm.recharge.common.a.c cVar = this.f61215e;
                if (cVar != null && cVar != null) {
                    Fragment a3 = cVar.a();
                    if (a3 instanceof r) {
                        r rVar = (r) a3;
                        rVar.a();
                        CJRBowsePlanGroupingListV8 cJRBowsePlanGroupingListV84 = rVar.f61385c;
                        if ((cJRBowsePlanGroupingListV84 != null ? cJRBowsePlanGroupingListV84.getProductList() : null) != null) {
                            ArrayList<CJRBrowsePlanProductList> arrayList = rVar.f61387e;
                            CJRBowsePlanGroupingListV8 cJRBowsePlanGroupingListV85 = rVar.f61385c;
                            if (cJRBowsePlanGroupingListV85 != null) {
                                list3 = cJRBowsePlanGroupingListV85.getProductList();
                            }
                            if (list3 == null) {
                                kotlin.g.b.k.a();
                            }
                            arrayList.addAll(list3);
                            v vVar = rVar.f61384b;
                            if (vVar != null) {
                                vVar.notifyDataSetChanged();
                            }
                        }
                    }
                }
            } else if (list instanceof ArrayList) {
                ArrayList arrayList2 = (ArrayList) list;
                CJRBowsePlanGroupingListV8 cJRBowsePlanGroupingListV86 = this.f61217g;
                if (cJRBowsePlanGroupingListV86 == null) {
                    kotlin.g.b.k.a();
                }
                arrayList2.add(0, cJRBowsePlanGroupingListV86);
            }
        }
    }

    static final class e implements View.OnFocusChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f61222a;

        e(h hVar) {
            this.f61222a = hVar;
        }

        public final void onFocusChange(View view, boolean z) {
            AppBarLayout b2;
            h hVar = this.f61222a;
            if (z) {
                if (!(hVar.l == b.COLLAPSED || (b2 = hVar.m) == null)) {
                    b2.setExpanded(false);
                }
                AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) hVar.a(R.id.txt_search);
                if (autoCompleteTextView != null) {
                    autoCompleteTextView.requestFocus();
                }
            }
        }
    }

    public final void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        View a2 = a(R.id.lyt_search);
        kotlin.g.b.k.a((Object) a2, "lyt_search");
        int id = a2.getId();
        if (valueOf != null && valueOf.intValue() == id) {
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) a(R.id.txt_search);
            if (autoCompleteTextView != null) {
                autoCompleteTextView.post(new d(this));
                return;
            }
            return;
        }
        RoboTextView roboTextView = (RoboTextView) a(R.id.view_all_button);
        kotlin.g.b.k.a((Object) roboTextView, "view_all_button");
        int id2 = roboTextView.getId();
        if (valueOf != null && valueOf.intValue() == id2) {
            RoboTextView roboTextView2 = (RoboTextView) a(R.id.view_all_button);
            if (roboTextView2 != null) {
                roboTextView2.setVisibility(8);
            }
            RoboTextView roboTextView3 = (RoboTextView) a(R.id.no_match_found);
            if (roboTextView3 != null) {
                roboTextView3.setVisibility(8);
            }
            AutoCompleteTextView autoCompleteTextView2 = (AutoCompleteTextView) a(R.id.txt_search);
            if (autoCompleteTextView2 != null) {
                autoCompleteTextView2.setText((CharSequence) null);
            }
            TabLayout tabLayout = (TabLayout) a(R.id.tabs);
            if (tabLayout != null) {
                tabLayout.setVisibility(0);
            }
            ViewPager viewPager = (ViewPager) a(R.id.viewpager);
            if (viewPager != null) {
                viewPager.setVisibility(0);
            }
            AutoCompleteTextView autoCompleteTextView3 = (AutoCompleteTextView) a(R.id.txt_search);
            if (autoCompleteTextView3 != null) {
                autoCompleteTextView3.clearFocus();
            }
            RelativeLayout relativeLayout = (RelativeLayout) a(R.id.customRechargeRL);
            if (relativeLayout != null) {
                relativeLayout.setVisibility(8);
            }
            View a3 = a(R.id.customRechargeDivider);
            if (a3 != null) {
                a3.setVisibility(8);
            }
            RecyclerView recyclerView = (RecyclerView) a(R.id.browse_plan_search_recycler_view);
            if (recyclerView != null) {
                recyclerView.setVisibility(8);
            }
            AppBarLayout appBarLayout = this.m;
            if (appBarLayout != null) {
                appBarLayout.setExpanded(true);
            }
            FragmentActivity activity = getActivity();
            if (activity != null) {
                kotlin.g.b.k.a((Object) activity, "it");
                new t(activity).a();
                return;
            }
            return;
        }
        RelativeLayout relativeLayout2 = (RelativeLayout) a(R.id.customRechargeRL);
        kotlin.g.b.k.a((Object) relativeLayout2, "customRechargeRL");
        int id3 = relativeLayout2.getId();
        if (valueOf != null && valueOf.intValue() == id3 && !TextUtils.isEmpty(this.p)) {
            CJRBrowsePlanProductList cJRBrowsePlanProductList = new CJRBrowsePlanProductList();
            cJRBrowsePlanProductList.setPrice(Double.valueOf(Double.parseDouble(this.p)));
            cJRBrowsePlanProductList.setFromPlanResponse(false);
            b(cJRBrowsePlanProductList);
        }
    }

    static final class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f61221a;

        d(h hVar) {
            this.f61221a = hVar;
        }

        public final void run() {
            try {
                AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) this.f61221a.a(R.id.txt_search);
                if (autoCompleteTextView != null) {
                    autoCompleteTextView.requestFocusFromTouch();
                }
                Context context = this.f61221a.getContext();
                Object systemService = context != null ? context.getSystemService("input_method") : null;
                if (systemService != null) {
                    ((InputMethodManager) systemService).showSoftInput((AutoCompleteTextView) this.f61221a.a(R.id.txt_search), 0);
                    return;
                }
                throw new kotlin.u("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            } catch (Exception e2) {
                com.paytm.utility.q.d(e2.getMessage());
            }
        }
    }

    public final void a(String str, io.reactivex.rxjava3.b.c cVar) {
        if (str != null && str.hashCode() == -2042516569 && str.equals("search_browse_plan")) {
            this.f61219i = cVar;
        }
    }

    /* renamed from: net.one97.paytm.recharge.common.fragment.h$h  reason: collision with other inner class name */
    public static final class C1185h implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f61229a;

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        C1185h(h hVar) {
            this.f61229a = hVar;
        }

        public final void afterTextChanged(Editable editable) {
            this.f61229a.q.onNext(String.valueOf(editable));
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            AutoCompleteTextView autoCompleteTextView;
            AutoCompleteTextView autoCompleteTextView2;
            CharSequence charSequence2 = null;
            if (p.a(String.valueOf(charSequence))) {
                RelativeLayout relativeLayout = (RelativeLayout) this.f61229a.a(R.id.customRechargeRL);
                if (relativeLayout != null) {
                    relativeLayout.setVisibility(8);
                }
                View a2 = this.f61229a.a(R.id.customRechargeDivider);
                if (a2 != null) {
                    a2.setVisibility(8);
                }
                RecyclerView recyclerView = (RecyclerView) this.f61229a.a(R.id.browse_plan_search_recycler_view);
                if (recyclerView != null) {
                    recyclerView.setVisibility(8);
                }
                TabLayout tabLayout = (TabLayout) this.f61229a.a(R.id.tabs);
                if (tabLayout != null) {
                    tabLayout.setVisibility(0);
                }
                ViewPager viewPager = (ViewPager) this.f61229a.a(R.id.viewpager);
                if (viewPager != null) {
                    viewPager.setVisibility(0);
                }
                TextView textView = (TextView) this.f61229a.a(R.id.plans_not_available);
                if (textView != null) {
                    textView.setVisibility(8);
                }
                RoboTextView roboTextView = (RoboTextView) this.f61229a.a(R.id.view_all_button);
                if (roboTextView != null) {
                    roboTextView.setVisibility(8);
                }
                RoboTextView roboTextView2 = (RoboTextView) this.f61229a.a(R.id.no_match_found);
                if (roboTextView2 != null) {
                    roboTextView2.setVisibility(8);
                }
                this.f61229a.p = "";
                AutoCompleteTextView autoCompleteTextView3 = (AutoCompleteTextView) this.f61229a.a(R.id.txt_search);
                if (autoCompleteTextView3 != null) {
                    charSequence2 = autoCompleteTextView3.getHint();
                }
                if (p.a(String.valueOf(charSequence2)) && (autoCompleteTextView2 = (AutoCompleteTextView) this.f61229a.a(R.id.txt_search)) != null) {
                    autoCompleteTextView2.setHint(this.f61229a.getString(R.string.search_plan_or_enter_amount));
                    return;
                }
                return;
            }
            TabLayout tabLayout2 = (TabLayout) this.f61229a.a(R.id.tabs);
            if (tabLayout2 != null) {
                tabLayout2.setVisibility(8);
            }
            ViewPager viewPager2 = (ViewPager) this.f61229a.a(R.id.viewpager);
            if (viewPager2 != null) {
                viewPager2.setVisibility(8);
            }
            AutoCompleteTextView autoCompleteTextView4 = (AutoCompleteTextView) this.f61229a.a(R.id.txt_search);
            if (autoCompleteTextView4 != null) {
                charSequence2 = autoCompleteTextView4.getHint();
            }
            if (!p.a(String.valueOf(charSequence2)) && (autoCompleteTextView = (AutoCompleteTextView) this.f61229a.a(R.id.txt_search)) != null) {
                autoCompleteTextView.setHint("");
            }
        }
    }

    public final void a(CJRBrowsePlanProductList cJRBrowsePlanProductList) {
        kotlin.g.b.k.c(cJRBrowsePlanProductList, "itemProduct");
        net.one97.paytm.recharge.common.c.f fVar = new net.one97.paytm.recharge.common.c.f(cJRBrowsePlanProductList, this);
        androidx.fragment.app.j childFragmentManager = getChildFragmentManager();
        kotlin.g.b.k.a((Object) childFragmentManager, "childFragmentManager");
        f.a aVar = net.one97.paytm.recharge.common.c.f.f60991a;
        fVar.show(childFragmentManager, net.one97.paytm.recharge.common.c.f.f60992d);
    }

    public final void b(CJRBrowsePlanProductList cJRBrowsePlanProductList) {
        kotlin.g.b.k.c(cJRBrowsePlanProductList, "itemProduct");
        net.one97.paytm.recharge.common.e.d dVar = this.f61212a;
        if (dVar != null) {
            dVar.a(cJRBrowsePlanProductList);
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setResult(-1);
        }
        FragmentActivity activity2 = getActivity();
        if (activity2 != null) {
            activity2.onBackPressed();
        }
    }

    public final void onDestroy() {
        Window window;
        super.onDestroy();
        try {
            Integer num = this.k;
            if (num != null) {
                int intValue = num.intValue();
                FragmentActivity activity = getActivity();
                if (!(activity == null || (window = activity.getWindow()) == null)) {
                    window.setSoftInputMode(intValue);
                }
            }
        } catch (Throwable th) {
            CJRRechargeUtilities.INSTANCE.debugLogExceptions(th);
        }
        io.reactivex.rxjava3.b.c cVar = this.f61219i;
        if (cVar != null) {
            cVar.dispose();
        }
    }

    private static CJRBowsePlanGroupingListV8 a(CJRBowsePlanGroupingListV8 cJRBowsePlanGroupingListV8, List<? extends CJRMadeForYouPlanData> list) {
        String str;
        String actualPrice;
        if (cJRBowsePlanGroupingListV8 == null) {
            try {
                cJRBowsePlanGroupingListV8 = new CJRBowsePlanGroupingListV8();
                cJRBowsePlanGroupingListV8.setIsOneToOne(true);
            } catch (Exception e2) {
                CJRRechargeUtilities.INSTANCE.debugLogExceptions(e2);
                return null;
            }
        }
        if (list != null) {
            List arrayList = new ArrayList();
            for (CJRMadeForYouPlanData cJRMadeForYouPlanData : list) {
                CJRBrowsePlanProductList cJRBrowsePlanProductList = new CJRBrowsePlanProductList();
                cJRBrowsePlanProductList.setDescription(cJRMadeForYouPlanData != null ? cJRMadeForYouPlanData.getName() : null);
                cJRBrowsePlanProductList.setPrice((cJRMadeForYouPlanData == null || (actualPrice = cJRMadeForYouPlanData.getActualPrice()) == null) ? null : Double.valueOf(Double.parseDouble(actualPrice)));
                cJRBrowsePlanProductList.setValidity(cJRMadeForYouPlanData != null ? cJRMadeForYouPlanData.getValidity() : null);
                if (cJRMadeForYouPlanData != null) {
                    str = cJRMadeForYouPlanData.getTalktime();
                } else {
                    str = null;
                }
                cJRBrowsePlanProductList.setTalktime(str);
                arrayList.add(cJRBrowsePlanProductList);
            }
            if (cJRBowsePlanGroupingListV8 != null) {
                cJRBowsePlanGroupingListV8.setProductList(arrayList);
            }
        }
        return cJRBowsePlanGroupingListV8;
    }

    public final void onPageScrolled(int i2, float f2, int i3) {
        if (f2 < this.o && ((double) f2) < 0.5d) {
            onPageSelected(i2);
        } else if (f2 > this.o && ((double) f2) > 0.5d) {
            onPageSelected(i2 + 1);
        }
        this.o = f2;
    }

    /* JADX WARNING: type inference failed for: r0v13, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void a(java.lang.String r4, boolean r5) {
        /*
            r3 = this;
            android.content.Context r0 = r3.getContext()
            if (r0 == 0) goto L_0x00b6
            boolean r0 = r3.isAdded()
            if (r0 != 0) goto L_0x000e
            goto L_0x00b6
        L_0x000e:
            net.one97.paytm.recharge.common.widget.c r0 = r3.f61213b
            if (r0 == 0) goto L_0x001a
            boolean r0 = r0.e()
            if (r0 != 0) goto L_0x001a
            r0 = 1
            goto L_0x001b
        L_0x001a:
            r0 = 0
        L_0x001b:
            if (r0 != 0) goto L_0x002f
            net.one97.paytm.recharge.common.widget.c r0 = r3.f61213b
            if (r0 == 0) goto L_0x0028
            boolean r0 = r0.b()
            if (r0 != 0) goto L_0x0028
            goto L_0x002f
        L_0x0028:
            r3.b(r4, r5)
            r3.c()
            return
        L_0x002f:
            android.view.View r0 = r3.getView()
            if (r0 == 0) goto L_0x00b6
            net.one97.paytm.recharge.common.widget.c r1 = r3.f61213b
            if (r1 == 0) goto L_0x004b
            int r2 = net.one97.paytm.recharge.R.layout.v3_disclaimer_snack_bar
            r1.f62145a = r2
            net.one97.paytm.recharge.common.widget.c$b r2 = net.one97.paytm.recharge.common.widget.c.b.INDEFINITE
            net.one97.paytm.recharge.common.widget.c r1 = r1.a((net.one97.paytm.recharge.common.widget.c.b) r2)
            java.lang.String r2 = "it"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            r1.a((android.view.View) r0)
        L_0x004b:
            net.one97.paytm.recharge.common.widget.c r0 = r3.f61213b
            r1 = 0
            if (r0 == 0) goto L_0x005f
            android.view.View r0 = r0.a()
            if (r0 == 0) goto L_0x005f
            int r2 = net.one97.paytm.recharge.R.id.disclaimerText
            android.view.View r0 = r0.findViewById(r2)
            android.widget.TextView r0 = (android.widget.TextView) r0
            goto L_0x0060
        L_0x005f:
            r0 = r1
        L_0x0060:
            if (r0 == 0) goto L_0x00ae
            r3.j = r0
            r3.b(r4, r5)
            net.one97.paytm.recharge.common.widget.c r0 = r3.f61213b
            if (r0 == 0) goto L_0x007a
            android.view.View r0 = r0.a()
            if (r0 == 0) goto L_0x007a
            int r1 = net.one97.paytm.recharge.R.id.btn_okay_click
            android.view.View r0 = r0.findViewById(r1)
            r1 = r0
            com.paytm.utility.RoboTextView r1 = (com.paytm.utility.RoboTextView) r1
        L_0x007a:
            if (r1 == 0) goto L_0x00a6
            net.one97.paytm.recharge.common.fragment.h$j r0 = new net.one97.paytm.recharge.common.fragment.h$j
            r0.<init>(r3, r4, r5)
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r1.setOnClickListener(r0)
            net.one97.paytm.recharge.common.widget.c r0 = r3.f61213b
            if (r0 == 0) goto L_0x0094
            net.one97.paytm.recharge.common.fragment.h$k r1 = new net.one97.paytm.recharge.common.fragment.h$k
            r1.<init>(r3, r4, r5)
            com.google.android.material.snackbar.Snackbar$a r1 = (com.google.android.material.snackbar.Snackbar.a) r1
            r0.a((com.google.android.material.snackbar.Snackbar.a) r1)
        L_0x0094:
            android.os.Handler r0 = new android.os.Handler
            r0.<init>()
            net.one97.paytm.recharge.common.fragment.h$l r1 = new net.one97.paytm.recharge.common.fragment.h$l
            r1.<init>(r3, r4, r5)
            java.lang.Runnable r1 = (java.lang.Runnable) r1
            r4 = 100
            r0.postDelayed(r1, r4)
            return
        L_0x00a6:
            kotlin.u r4 = new kotlin.u
            java.lang.String r5 = "null cannot be cast to non-null type com.paytm.utility.RoboTextView"
            r4.<init>(r5)
            throw r4
        L_0x00ae:
            kotlin.u r4 = new kotlin.u
            java.lang.String r5 = "null cannot be cast to non-null type android.widget.TextView"
            r4.<init>(r5)
            throw r4
        L_0x00b6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.fragment.h.a(java.lang.String, boolean):void");
    }

    static final class j implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f61231a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f61232b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ boolean f61233c;

        j(h hVar, String str, boolean z) {
            this.f61231a = hVar;
            this.f61232b = str;
            this.f61233c = z;
        }

        public final void onClick(View view) {
            h hVar = this.f61231a;
            h.a(hVar, hVar.f61213b);
        }
    }

    public static final class k extends Snackbar.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f61234a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f61235b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ boolean f61236c;

        k(h hVar, String str, boolean z) {
            this.f61234a = hVar;
            this.f61235b = str;
            this.f61236c = z;
        }

        public final void a(Snackbar snackbar, int i2) {
            super.a(snackbar, i2);
            this.f61234a.c();
        }

        public final void a(Snackbar snackbar) {
            super.a(snackbar);
            if (Build.VERSION.SDK_INT < 21) {
                this.f61234a.b(this.f61235b, this.f61236c);
            }
        }
    }

    static final class l implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f61237a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f61238b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ boolean f61239c;

        l(h hVar, String str, boolean z) {
            this.f61237a = hVar;
            this.f61238b = str;
            this.f61239c = z;
        }

        public final void run() {
            net.one97.paytm.recharge.common.widget.c cVar = this.f61237a.f61213b;
            if (cVar != null) {
                cVar.c();
            }
            this.f61237a.c();
        }
    }

    /* access modifiers changed from: private */
    public final void b(String str, boolean z) {
        boolean z2 = false;
        if (z) {
            CharSequence charSequence = str;
            if (charSequence == null || p.a(charSequence)) {
                z2 = true;
            }
            if (z2) {
                TextView textView = this.j;
                if (textView != null) {
                    textView.setText(Html.fromHtml(getString(R.string.disclaimer_text_one_2_one_html)));
                    return;
                }
                return;
            }
            TextView textView2 = this.j;
            if (textView2 != null) {
                textView2.setText(charSequence);
                return;
            }
            return;
        }
        CharSequence charSequence2 = str;
        if (charSequence2 == null || p.a(charSequence2)) {
            z2 = true;
        }
        if (z2) {
            TextView textView3 = this.j;
            if (textView3 != null) {
                textView3.setText(getString(R.string.disclaimer_text_html));
                return;
            }
            return;
        }
        TextView textView4 = this.j;
        if (textView4 != null) {
            textView4.setText(charSequence2);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x001f A[Catch:{ Exception -> 0x0045 }] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0028 A[Catch:{ Exception -> 0x0045 }] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x002f A[Catch:{ Exception -> 0x0045 }] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0036 A[Catch:{ Exception -> 0x0045 }] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x003b A[Catch:{ Exception -> 0x0045 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String a(boolean r5) {
        /*
            r4 = this;
            r0 = 0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0045 }
            r1.<init>()     // Catch:{ Exception -> 0x0045 }
            android.content.Context r2 = r4.getContext()     // Catch:{ Exception -> 0x0045 }
            java.lang.String r2 = com.paytm.utility.b.A((android.content.Context) r2)     // Catch:{ Exception -> 0x0045 }
            r3 = r2
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ Exception -> 0x0045 }
            if (r3 == 0) goto L_0x001c
            boolean r3 = kotlin.m.p.a(r3)     // Catch:{ Exception -> 0x0045 }
            if (r3 == 0) goto L_0x001a
            goto L_0x001c
        L_0x001a:
            r3 = 0
            goto L_0x001d
        L_0x001c:
            r3 = 1
        L_0x001d:
            if (r3 != 0) goto L_0x0022
            r1.append(r2)     // Catch:{ Exception -> 0x0045 }
        L_0x0022:
            android.os.Bundle r2 = r4.getArguments()     // Catch:{ Exception -> 0x0045 }
            if (r2 == 0) goto L_0x002f
            java.lang.String r3 = "title"
            java.lang.String r2 = r2.getString(r3)     // Catch:{ Exception -> 0x0045 }
            goto L_0x0030
        L_0x002f:
            r2 = r0
        L_0x0030:
            boolean r3 = net.one97.paytm.recharge.common.utils.g.c(r2)     // Catch:{ Exception -> 0x0045 }
            if (r3 == 0) goto L_0x0039
            r1.append(r2)     // Catch:{ Exception -> 0x0045 }
        L_0x0039:
            if (r5 == 0) goto L_0x0040
            java.lang.String r5 = "121"
            r1.append(r5)     // Catch:{ Exception -> 0x0045 }
        L_0x0040:
            java.lang.String r5 = r1.toString()     // Catch:{ Exception -> 0x0045 }
            return r5
        L_0x0045:
            r5 = move-exception
            net.one97.paytm.recharge.di.helper.CJRRechargeUtilities r1 = net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE
            java.lang.Throwable r5 = (java.lang.Throwable) r5
            r1.debugLogExceptions(r5)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.fragment.h.a(boolean):java.lang.String");
    }

    /* access modifiers changed from: private */
    public final void c() {
        net.one97.paytm.recharge.common.widget.c cVar;
        ViewTreeObserver f2;
        net.one97.paytm.recharge.common.widget.c cVar2;
        net.one97.paytm.recharge.common.widget.c cVar3 = this.f61213b;
        if ((cVar3 == null || cVar3.e()) && ((cVar = this.f61213b) == null || !cVar.e() || (cVar2 = this.f61213b) == null || cVar2.b())) {
            net.one97.paytm.recharge.common.widget.c cVar4 = this.f61213b;
            if (cVar4 != null && (f2 = cVar4.f()) != null) {
                f2.addOnGlobalLayoutListener(new c(this));
                return;
            }
            return;
        }
        a((Integer) 0);
    }

    public static final class c implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f61220a;

        c(h hVar) {
            this.f61220a = hVar;
        }

        public final void onGlobalLayout() {
            ViewTreeObserver f2;
            ViewTreeObserver f3;
            h hVar = this.f61220a;
            net.one97.paytm.recharge.common.widget.c cVar = hVar.f61213b;
            hVar.a(cVar != null ? Integer.valueOf(cVar.g()) : null);
            if (Build.VERSION.SDK_INT >= 16) {
                net.one97.paytm.recharge.common.widget.c cVar2 = this.f61220a.f61213b;
                if (cVar2 != null && (f3 = cVar2.f()) != null) {
                    f3.removeOnGlobalLayoutListener(this);
                    return;
                }
                return;
            }
            net.one97.paytm.recharge.common.widget.c cVar3 = this.f61220a.f61213b;
            if (cVar3 != null && (f2 = cVar3.f()) != null) {
                f2.removeGlobalOnLayoutListener(this);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void a(Integer num) {
        if (num != null) {
            num.intValue();
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, num.intValue());
            layoutParams.addRule(12);
            FrameLayout frameLayout = (FrameLayout) a(R.id.empty_view);
            if (frameLayout != null) {
                frameLayout.setLayoutParams(layoutParams);
            }
        }
    }

    public final void onDestroyView() {
        net.one97.paytm.recharge.common.widget.c cVar;
        net.one97.paytm.recharge.common.widget.c cVar2 = this.f61213b;
        if (!(cVar2 == null || !cVar2.e() || (cVar = this.f61213b) == null)) {
            cVar.d();
        }
        super.onDestroyView();
        HashMap hashMap = this.v;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final void onOffsetChanged(AppBarLayout appBarLayout, int i2) {
        if (i2 == 0) {
            this.l = b.EXPANDED;
            ImageView imageView = (ImageView) a(R.id.img_search);
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            TextView textView = (TextView) a(R.id.browsPlanTV);
            if (textView != null) {
                textView.setVisibility(0);
                return;
            }
            return;
        }
        int abs = Math.abs(i2);
        if (appBarLayout == null) {
            kotlin.g.b.k.a();
        }
        if (abs >= appBarLayout.getTotalScrollRange()) {
            this.l = b.COLLAPSED;
            ImageView imageView2 = (ImageView) a(R.id.img_search);
            if (imageView2 != null) {
                imageView2.setVisibility(4);
            }
            TextView textView2 = (TextView) a(R.id.browsPlanTV);
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
        } else if (this.l != b.IDLE) {
            this.l = b.IDLE;
        }
    }

    public final void onPageSelected(int i2) {
        net.one97.paytm.recharge.common.widget.c cVar;
        net.one97.paytm.recharge.common.widget.c cVar2;
        Context applicationContext;
        net.one97.paytm.recharge.common.widget.c cVar3;
        net.one97.paytm.recharge.common.widget.c cVar4;
        List<CJRBowsePlanGroupingListV8> list;
        FragmentActivity activity = getActivity();
        Object obj = null;
        if ((activity != null ? activity.getCurrentFocus() : null) != null) {
            try {
                FragmentActivity activity2 = getActivity();
                if (activity2 == null) {
                    kotlin.g.b.k.a();
                }
                Object systemService = activity2.getSystemService("input_method");
                if (systemService != null) {
                    InputMethodManager inputMethodManager = (InputMethodManager) systemService;
                    FragmentActivity activity3 = getActivity();
                    if (activity3 == null) {
                        kotlin.g.b.k.a();
                    }
                    kotlin.g.b.k.a((Object) activity3, "activity!!");
                    View currentFocus = activity3.getCurrentFocus();
                    inputMethodManager.hideSoftInputFromWindow(currentFocus != null ? currentFocus.getWindowToken() : null, 0);
                } else {
                    throw new kotlin.u("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
                }
            } catch (Throwable th) {
                CJRRechargeUtilities.INSTANCE.debugLogExceptions(th);
            }
        }
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) a(R.id.txt_search);
        if (autoCompleteTextView != null) {
            autoCompleteTextView.clearFocus();
        }
        EditText editText = (EditText) a(R.id.focus_empty_view);
        if (editText != null) {
            editText.requestFocus();
        }
        net.one97.paytm.recharge.common.a.c cVar5 = this.f61215e;
        CJRBowsePlanGroupingListV8 cJRBowsePlanGroupingListV8 = (cVar5 == null || (list = cVar5.f60479a) == null) ? null : list.get(i2);
        if (cJRBowsePlanGroupingListV8 != null) {
            if (cJRBowsePlanGroupingListV8.getProductList() != null) {
                List<CJRBrowsePlanProductList> productList = cJRBowsePlanGroupingListV8.getProductList();
                Integer valueOf = productList != null ? Integer.valueOf(productList.size()) : null;
                if (valueOf == null) {
                    kotlin.g.b.k.a();
                }
                if (valueOf.intValue() > 0) {
                    Context context = getContext();
                    if (!(context == null || (applicationContext = context.getApplicationContext()) == null)) {
                        ax.a aVar = ax.f61521a;
                        com.paytm.b.a.a a2 = ax.a.a(applicationContext);
                        String a3 = a(cJRBowsePlanGroupingListV8.isOneToOne());
                        if (net.one97.paytm.recharge.common.utils.g.c(a3)) {
                            if (a3 == null) {
                                kotlin.g.b.k.a();
                            }
                            if (a2.b(a3, false, true)) {
                                net.one97.paytm.recharge.common.widget.c cVar6 = this.f61213b;
                                if (!(cVar6 == null || !cVar6.e() || (cVar3 = this.f61213b) == null || !cVar3.b() || (cVar4 = this.f61213b) == null)) {
                                    cVar4.d();
                                }
                            } else if (cJRBowsePlanGroupingListV8.isOneToOne()) {
                                a(cJRBowsePlanGroupingListV8.getDisclaimer(), cJRBowsePlanGroupingListV8.isOneToOne());
                            } else {
                                net.one97.paytm.recharge.common.e.d dVar = this.f61212a;
                                a(dVar != null ? dVar.d() : null, cJRBowsePlanGroupingListV8.isOneToOne());
                            }
                        }
                    }
                }
            }
            net.one97.paytm.recharge.common.widget.c cVar7 = this.f61213b;
            if (!(cVar7 == null || !cVar7.e() || (cVar = this.f61213b) == null || !cVar.b() || (cVar2 = this.f61213b) == null)) {
                cVar2.d();
            }
        }
        try {
            Context context2 = getContext();
            if (context2 == null) {
                kotlin.g.b.k.a();
            }
            kotlin.g.b.k.a((Object) context2, "context!!");
            net.one97.paytm.recharge.ordersummary.h.d dVar2 = new net.one97.paytm.recharge.ordersummary.h.d(context2);
            StringBuilder sb = new StringBuilder("/");
            net.one97.paytm.recharge.common.e.d dVar3 = this.f61212a;
            if (dVar3 != null) {
                obj = dVar3.e();
            }
            sb.append(obj);
            sb.append("/browse_plans");
            String sb2 = sb.toString();
            net.one97.paytm.recharge.common.a.c cVar8 = this.f61215e;
            if (cVar8 == null) {
                kotlin.g.b.k.a();
            }
            ViewPager viewPager = (ViewPager) a(R.id.viewpager);
            kotlin.g.b.k.a((Object) viewPager, "viewpager");
            CharSequence pageTitle = cVar8.getPageTitle(viewPager.getCurrentItem());
            if (pageTitle == null) {
                kotlin.g.b.k.a();
            }
            net.one97.paytm.recharge.ordersummary.h.d.a(dVar2, "mobile_prepaid", "browse_plans_tabs_clicked", sb2, pageTitle, (Object) null, (Object) null, (Object) null, 112);
        } catch (Throwable unused) {
        }
    }

    public static final /* synthetic */ void a(h hVar, net.one97.paytm.recharge.common.widget.c cVar) {
        List<CJRBowsePlanGroupingListV8> list;
        Context applicationContext;
        if (cVar != null) {
            cVar.d();
        }
        if (((ViewPager) hVar.a(R.id.viewpager)) != null) {
            boolean z = false;
            net.one97.paytm.recharge.common.a.c cVar2 = hVar.f61215e;
            if (cVar2 != null) {
                list = cVar2.f60479a;
            } else {
                list = null;
            }
            if (list != null) {
                int size = list.size();
                ViewPager viewPager = (ViewPager) hVar.a(R.id.viewpager);
                kotlin.g.b.k.a((Object) viewPager, "viewpager");
                if (size >= viewPager.getCurrentItem()) {
                    ViewPager viewPager2 = (ViewPager) hVar.a(R.id.viewpager);
                    kotlin.g.b.k.a((Object) viewPager2, "viewpager");
                    z = list.get(viewPager2.getCurrentItem()).isOneToOne();
                }
            }
            FragmentActivity activity = hVar.getActivity();
            if (activity != null && (applicationContext = activity.getApplicationContext()) != null) {
                ax.a aVar = ax.f61521a;
                com.paytm.b.a.a a2 = ax.a.a(applicationContext);
                String a3 = hVar.a(z);
                if (net.one97.paytm.recharge.common.utils.g.c(a3)) {
                    if (a3 == null) {
                        kotlin.g.b.k.a();
                    }
                    a2.a(a3, true, true);
                }
            }
        }
    }
}
