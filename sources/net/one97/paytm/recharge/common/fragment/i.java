package net.one97.paytm.recharge.common.fragment;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.y;
import androidx.lifecycle.z;
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
import io.reactivex.rxjava3.d.q;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.common.entity.shopping.CJRHomePage;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.a.w;
import net.one97.paytm.recharge.common.c.f;
import net.one97.paytm.recharge.common.e.ah;
import net.one97.paytm.recharge.common.e.ai;
import net.one97.paytm.recharge.common.utils.ax;
import net.one97.paytm.recharge.common.utils.az;
import net.one97.paytm.recharge.common.utils.bb;
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

public final class i extends Fragment implements View.OnClickListener, ViewPager.e, AppBarLayout.b, w.b, ah, ai {

    /* renamed from: d  reason: collision with root package name */
    public static final a f61240d = new a((byte) 0);
    /* access modifiers changed from: private */
    public static final String n;

    /* renamed from: a  reason: collision with root package name */
    net.one97.paytm.recharge.common.e.d f61241a;

    /* renamed from: b  reason: collision with root package name */
    z<List<CJRBrowsePlanProductList>> f61242b;

    /* renamed from: c  reason: collision with root package name */
    net.one97.paytm.recharge.common.widget.c f61243c;

    /* renamed from: e  reason: collision with root package name */
    private net.one97.paytm.recharge.common.a.d f61244e;

    /* renamed from: f  reason: collision with root package name */
    private net.one97.paytm.recharge.common.a.f f61245f;

    /* renamed from: g  reason: collision with root package name */
    private CJRBowsePlanGroupingListV8 f61246g;

    /* renamed from: h  reason: collision with root package name */
    private List<? extends CJRMadeForYouPlanData> f61247h;

    /* renamed from: i  reason: collision with root package name */
    private io.reactivex.rxjava3.b.c f61248i;
    private TextView j;
    private Integer k;
    private b l = b.IDLE;
    private AppBarLayout m;
    private HashMap o;

    public enum b {
        EXPANDED,
        COLLAPSED,
        IDLE
    }

    public final View a(int i2) {
        if (this.o == null) {
            this.o = new HashMap();
        }
        View view = (View) this.o.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.o.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void onPageScrollStateChanged(int i2) {
    }

    public final void onPageScrolled(int i2, float f2, int i3) {
    }

    static final class e<T> implements z<List<? extends CJRBrowsePlanProductList>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i f61251a;

        e(i iVar) {
            this.f61251a = iVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            List list = (List) obj;
            if (list == null || list.isEmpty()) {
                CoordinatorLayout coordinatorLayout = (CoordinatorLayout) this.f61251a.a(R.id.plan_container);
                if (coordinatorLayout != null) {
                    coordinatorLayout.setVisibility(8);
                }
                LinearLayout linearLayout = (LinearLayout) this.f61251a.a(R.id.search_container_list);
                if (linearLayout != null) {
                    linearLayout.setVisibility(8);
                }
                ImageView imageView = (ImageView) this.f61251a.a(R.id.img_clear_search);
                if (imageView != null) {
                    imageView.setVisibility(0);
                }
                RelativeLayout relativeLayout = (RelativeLayout) this.f61251a.a(R.id.no_result_container);
                if (relativeLayout != null) {
                    relativeLayout.setVisibility(0);
                }
            } else {
                i.a(this.f61251a, list);
                CoordinatorLayout coordinatorLayout2 = (CoordinatorLayout) this.f61251a.a(R.id.plan_container);
                if (coordinatorLayout2 != null) {
                    coordinatorLayout2.setVisibility(8);
                }
                LinearLayout linearLayout2 = (LinearLayout) this.f61251a.a(R.id.search_container_list);
                if (linearLayout2 != null) {
                    linearLayout2.setVisibility(0);
                }
                ImageView imageView2 = (ImageView) this.f61251a.a(R.id.img_clear_search);
                if (imageView2 != null) {
                    imageView2.setVisibility(0);
                }
                RelativeLayout relativeLayout2 = (RelativeLayout) this.f61251a.a(R.id.no_result_container);
                if (relativeLayout2 != null) {
                    relativeLayout2.setVisibility(8);
                }
            }
            TabLayout tabLayout = (TabLayout) this.f61251a.a(R.id.tabs);
            k.a((Object) tabLayout, CJRHomePage.LAYOUT_HOME_PAGE_TABS);
            tabLayout.setVisibility(8);
        }
    }

    static final class f<T> implements q<String> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i f61252a;

        f(i iVar) {
            this.f61252a = iVar;
        }

        public final /* synthetic */ boolean test(Object obj) {
            String str = (String) obj;
            k.a((Object) str, "it");
            if (p.a(str)) {
                TabLayout tabLayout = (TabLayout) this.f61252a.a(R.id.tabs);
                if (tabLayout != null) {
                    tabLayout.setVisibility(0);
                }
                CoordinatorLayout coordinatorLayout = (CoordinatorLayout) this.f61252a.a(R.id.plan_container);
                if (coordinatorLayout != null) {
                    coordinatorLayout.setVisibility(0);
                }
                LinearLayout linearLayout = (LinearLayout) this.f61252a.a(R.id.search_container_list);
                if (linearLayout != null) {
                    linearLayout.setVisibility(8);
                }
                ImageView imageView = (ImageView) this.f61252a.a(R.id.img_clear_search);
                if (imageView != null) {
                    imageView.setVisibility(4);
                }
                RelativeLayout relativeLayout = (RelativeLayout) this.f61252a.a(R.id.no_result_container);
                if (relativeLayout != null) {
                    relativeLayout.setVisibility(8);
                }
                return false;
            }
            ProgressBar progressBar = (ProgressBar) this.f61252a.a(R.id.action_progress);
            if (progressBar == null) {
                return true;
            }
            net.one97.paytm.recharge.common.utils.ai.a(progressBar);
            return true;
        }
    }

    static final class g<T, R> implements io.reactivex.rxjava3.d.h<T, R> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i f61253a;

        g(i iVar) {
            this.f61253a = iVar;
        }

        public final /* synthetic */ Object apply(Object obj) {
            String str = (String) obj;
            net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
            CJRRechargeErrorModel a2 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
            a2.setErrorType(ERROR_TYPE.UNDEFINED);
            CRUFlowModel flowName = a2.getFlowName();
            if (flowName != null) {
                flowName.setErrorType(ERROR_TYPE.UNDEFINED.name());
            }
            CRUFlowModel flowName2 = a2.getFlowName();
            if (flowName2 != null) {
                flowName2.setActionType(ACTION_TYPE.PLAN_SEARCH.name());
            }
            net.one97.paytm.recharge.common.e.d dVar2 = this.f61253a.f61241a;
            if (dVar2 != null) {
                k.a((Object) str, "it");
                LiveData<List<CJRBrowsePlanProductList>> a3 = dVar2.a("search_browse_plan", str, new String[0], a2);
                if (a3 != null) {
                    return a3;
                }
            }
            return new y();
        }
    }

    static final class h<T> implements io.reactivex.rxjava3.d.g<LiveData<List<? extends CJRBrowsePlanProductList>>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i f61254a;

        h(i iVar) {
            this.f61254a = iVar;
        }

        public final /* synthetic */ void accept(Object obj) {
            LiveData liveData = (LiveData) obj;
            if (liveData != null) {
                i iVar = this.f61254a;
                androidx.lifecycle.q qVar = iVar;
                z<List<CJRBrowsePlanProductList>> zVar = iVar.f61242b;
                if (zVar == null) {
                    k.a();
                }
                liveData.observe(qVar, zVar);
            }
            ProgressBar progressBar = (ProgressBar) this.f61254a.a(R.id.action_progress);
            if (progressBar != null) {
                net.one97.paytm.recharge.common.utils.ai.b(progressBar);
            }
        }
    }

    public final net.one97.paytm.recharge.common.e.d a() {
        if (getContext() instanceof ah) {
            Context context = getContext();
            if (context != null) {
                return ((ah) context).a();
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.common.listener.IJRRechargeViewModelActivity");
        } else if (!(getParentFragment() instanceof ah)) {
            return null;
        } else {
            Fragment parentFragment = getParentFragment();
            if (parentFragment != null) {
                return ((ah) parentFragment).a();
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.common.listener.IJRRechargeViewModelActivity");
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
        String simpleName = i.class.getSimpleName();
        k.a((Object) simpleName, "FJRBrowsePlansFragmentV8::class.java.simpleName");
        n = simpleName;
    }

    public final void onAttach(Context context) {
        k.c(context, "context");
        super.onAttach(context);
        if (context instanceof ah) {
            this.f61241a = ((ah) context).a();
        }
        if (getParentFragment() instanceof ah) {
            Fragment parentFragment = getParentFragment();
            if (parentFragment != null) {
                this.f61241a = ((ah) parentFragment).a();
            } else {
                throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.common.listener.IJRRechargeViewModelActivity");
            }
        }
        int i2 = Build.VERSION.SDK_INT;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|(1:4)(1:5)|6|7|8|(1:14)|15|(1:25)(2:19|23)) */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0056, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0057, code lost:
        net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE.debugLogExceptions(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005c, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0050 A[Catch:{ all -> 0x0056 }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
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
            net.one97.paytm.recharge.common.e.d r2 = r3.f61241a     // Catch:{ all -> 0x002a }
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
            if (r4 == 0) goto L_0x0055
            android.view.Window r4 = r4.getWindow()     // Catch:{ all -> 0x0056 }
            if (r4 == 0) goto L_0x0055
            r0 = 48
            r4.setSoftInputMode(r0)     // Catch:{ all -> 0x0056 }
        L_0x0055:
            return
        L_0x0056:
            r4 = move-exception
            net.one97.paytm.recharge.di.helper.CJRRechargeUtilities r0 = net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE
            r0.debugLogExceptions(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.fragment.i.onCreate(android.os.Bundle):void");
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.v8_fragment_browse_plans, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        net.one97.paytm.recharge.common.widget.c cVar;
        Resources resources;
        k.c(view, "view");
        this.m = (AppBarLayout) view.findViewById(R.id.appbar_layout);
        ProgressBar progressBar = (ProgressBar) a(R.id.action_progress_no_data);
        if (progressBar != null) {
            progressBar.setVisibility(0);
        }
        new bb();
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) a(R.id.txt_search);
        k.a((Object) autoCompleteTextView, "txt_search");
        TextView textView = autoCompleteTextView;
        k.c(textView, "searchView");
        io.reactivex.rxjava3.j.b a2 = io.reactivex.rxjava3.j.b.a();
        k.a((Object) a2, "PublishSubject.create()");
        textView.addTextChangedListener(new bb.a(a2));
        this.f61248i = a2.debounce(500, TimeUnit.MILLISECONDS).distinctUntilChanged().observeOn(io.reactivex.rxjava3.android.b.a.a()).filter(new f(this)).subscribeOn(io.reactivex.rxjava3.i.a.b()).map(new g(this)).subscribe(new h(this));
        View a3 = a(R.id.lyt_search);
        if (a3 != null) {
            a3.setOnClickListener(this);
        }
        ImageView imageView = (ImageView) a(R.id.img_clear_search);
        if (imageView != null) {
            imageView.setOnClickListener(this);
        }
        ImageView imageView2 = (ImageView) a(R.id.img_close_screen);
        if (imageView2 != null) {
            imageView2.setOnClickListener(this);
        }
        RoboTextView roboTextView = (RoboTextView) a(R.id.view_all_button);
        if (roboTextView != null) {
            roboTextView.setOnClickListener(this);
        }
        Context context = getContext();
        String str = null;
        if (context != null) {
            c.a aVar = net.one97.paytm.recharge.common.widget.c.f62144e;
            k.a((Object) context, "it");
            cVar = c.a.a(context);
        } else {
            cVar = null;
        }
        this.f61243c = cVar;
        net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
        CJRRechargeErrorModel a4 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
        a4.setErrorType(ERROR_TYPE.UNDEFINED);
        CRUFlowModel flowName = a4.getFlowName();
        if (flowName != null) {
            flowName.setErrorType(ERROR_TYPE.UNDEFINED.name());
        }
        CRUFlowModel flowName2 = a4.getFlowName();
        if (flowName2 != null) {
            flowName2.setActionType(ACTION_TYPE.BROWSE_PLAN.name());
        }
        net.one97.paytm.recharge.common.e.d dVar2 = this.f61241a;
        if (dVar2 == null || !dVar2.b()) {
            net.one97.paytm.recharge.common.e.d dVar3 = this.f61241a;
            if (dVar3 != null) {
                dVar3.a("tag.get.browse.plans", this, a4);
            }
        } else {
            net.one97.paytm.recharge.common.e.d dVar4 = this.f61241a;
            if (dVar4 != null) {
                dVar4.b("tag.get.one2one.plans", this, a4);
            }
        }
        this.f61242b = new e(this);
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) a(R.id.plan_container);
        if (coordinatorLayout != null) {
            coordinatorLayout.setVisibility(0);
        }
        LinearLayout linearLayout = (LinearLayout) a(R.id.search_container_list);
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        ImageView imageView3 = (ImageView) a(R.id.img_clear_search);
        if (imageView3 != null) {
            imageView3.setVisibility(4);
        }
        StringBuilder sb = new StringBuilder();
        Bundle arguments = getArguments();
        if (arguments == null) {
            k.a();
        }
        if (!TextUtils.isEmpty(arguments.getString("title"))) {
            Context context2 = getContext();
            if (!(context2 == null || (resources = context2.getResources()) == null)) {
                str = resources.getString(R.string.string_for);
            }
            sb.append(str);
            sb.append(arguments.getString("title"));
            TextView textView2 = (TextView) a(R.id.txt_sub_header_browse_plan);
            k.a((Object) textView2, "txt_sub_header_browse_plan");
            textView2.setText(sb);
        }
        AppBarLayout appBarLayout = this.m;
        if (appBarLayout != null) {
            appBarLayout.a((AppBarLayout.b) this);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:123:0x0240, code lost:
        if (r8.intValue() == 0) goto L_0x0242;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a_(java.lang.String r28, com.paytm.network.model.IJRPaytmDataModel r29, java.lang.Object r30) {
        /*
            r27 = this;
            r6 = r27
            r1 = r28
            r0 = r29
            r5 = r30
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
            androidx.fragment.app.FragmentActivity r4 = r27.getActivity()
            r3.append(r4)
            java.lang.String r4 = " isDetached "
            r3.append(r4)
            boolean r4 = r27.isDetached()
            r3.append(r4)
            java.lang.String r4 = " isAdded "
            r3.append(r4)
            boolean r4 = r27.isAdded()
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r2.debugLog(r3)
            androidx.fragment.app.FragmentActivity r2 = r27.getActivity()
            if (r2 == 0) goto L_0x0315
            boolean r2 = r27.isDetached()
            if (r2 != 0) goto L_0x0315
            boolean r2 = r27.isAdded()
            if (r2 != 0) goto L_0x005b
            goto L_0x0315
        L_0x005b:
            if (r1 != 0) goto L_0x005e
            return
        L_0x005e:
            int r2 = r28.hashCode()
            r3 = -1721320982(0xffffffff9966b9ea, float:-1.1928266E-23)
            java.lang.String r4 = "null cannot be cast to non-null type net.one97.paytm.recharge.mobile.viewmodel.CJRMobileRechargeViewModel"
            java.lang.String r7 = "tag.get.browse.plans"
            r8 = 0
            if (r2 == r3) goto L_0x0293
            r3 = -692018830(0xffffffffd6c0a172, float:-1.05899817E14)
            if (r2 == r3) goto L_0x0074
            goto L_0x0315
        L_0x0074:
            boolean r2 = r1.equals(r7)
            if (r2 == 0) goto L_0x0315
            net.one97.paytm.recharge.common.e.d r2 = r6.f61241a
            boolean r3 = r2 instanceof net.one97.paytm.recharge.mobile.d.a
            if (r3 == 0) goto L_0x008e
            if (r2 == 0) goto L_0x0088
            net.one97.paytm.recharge.mobile.d.a r2 = (net.one97.paytm.recharge.mobile.d.a) r2
            r2.a_(r1, r0, r5)
            goto L_0x008e
        L_0x0088:
            kotlin.u r0 = new kotlin.u
            r0.<init>(r4)
            throw r0
        L_0x008e:
            boolean r1 = r0 instanceof net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanResponseModelV8
            if (r1 != 0) goto L_0x0093
            r0 = r8
        L_0x0093:
            net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanResponseModelV8 r0 = (net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanResponseModelV8) r0
            if (r0 == 0) goto L_0x00cf
            java.util.List r0 = r0.getGroupings()
            if (r0 == 0) goto L_0x00cf
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Collection r1 = (java.util.Collection) r1
            java.util.Iterator r0 = r0.iterator()
        L_0x00aa:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x00cc
            java.lang.Object r2 = r0.next()
            r3 = r2
            net.one97.paytm.recharge.model.rechargeutility.CJRBowsePlanGroupingListV8 r3 = (net.one97.paytm.recharge.model.rechargeutility.CJRBowsePlanGroupingListV8) r3
            java.lang.String r4 = "it"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
            java.util.List r3 = r3.getProductList()
            java.util.Collection r3 = (java.util.Collection) r3
            boolean r3 = net.one97.paytm.nativesdk.ExtensionsKt.isNotNullNotEmpty(r3)
            if (r3 == 0) goto L_0x00aa
            r1.add(r2)
            goto L_0x00aa
        L_0x00cc:
            java.util.List r1 = (java.util.List) r1
            goto L_0x00d7
        L_0x00cf:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = r0
            java.util.List r1 = (java.util.List) r1
        L_0x00d7:
            boolean r0 = r1.isEmpty()
            r2 = 8
            r3 = 0
            r4 = 1
            if (r0 == 0) goto L_0x0149
            java.util.List<? extends net.one97.paytm.recharge.model.mobile.CJRMadeForYouPlanData> r0 = r6.f61247h
            if (r0 == 0) goto L_0x00ef
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            r0 = r0 ^ r4
            if (r0 != r4) goto L_0x00ef
            goto L_0x0149
        L_0x00ef:
            int r0 = net.one97.paytm.recharge.R.id.action_progress_no_data
            android.view.View r0 = r6.a((int) r0)
            android.widget.ProgressBar r0 = (android.widget.ProgressBar) r0
            if (r0 == 0) goto L_0x00fc
            r0.setVisibility(r2)
        L_0x00fc:
            int r0 = net.one97.paytm.recharge.R.id.plans_not_available
            android.view.View r0 = r6.a((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            if (r0 == 0) goto L_0x0109
            r0.setVisibility(r3)
        L_0x0109:
            int r0 = net.one97.paytm.recharge.R.id.lyt_search
            android.view.View r0 = r6.a((int) r0)
            if (r0 == 0) goto L_0x0114
            r0.setVisibility(r2)
        L_0x0114:
            com.google.android.material.appbar.AppBarLayout r0 = r6.m
            if (r0 == 0) goto L_0x011d
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            goto L_0x011e
        L_0x011d:
            r0 = r8
        L_0x011e:
            boolean r1 = r0 instanceof androidx.coordinatorlayout.widget.CoordinatorLayout.d
            if (r1 != 0) goto L_0x0123
            r0 = r8
        L_0x0123:
            androidx.coordinatorlayout.widget.CoordinatorLayout$d r0 = (androidx.coordinatorlayout.widget.CoordinatorLayout.d) r0
            com.google.android.material.appbar.AppBarLayout$Behavior r1 = new com.google.android.material.appbar.AppBarLayout$Behavior
            r1.<init>()
            net.one97.paytm.recharge.widgets.c.f r4 = new net.one97.paytm.recharge.widgets.c.f
            r4.<init>(r3)
            com.google.android.material.appbar.AppBarLayout$BaseBehavior$a r4 = (com.google.android.material.appbar.AppBarLayout.BaseBehavior.a) r4
            r1.setDragCallback(r4)
            if (r0 == 0) goto L_0x013b
            androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior r1 = (androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior) r1
            r0.a((androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior) r1)
        L_0x013b:
            int r0 = net.one97.paytm.recharge.R.id.scroll
            android.view.View r0 = r6.a((int) r0)
            androidx.core.widget.NestedScrollView r0 = (androidx.core.widget.NestedScrollView) r0
            if (r0 == 0) goto L_0x0148
            r0.setVisibility(r2)
        L_0x0148:
            return
        L_0x0149:
            int r0 = net.one97.paytm.recharge.R.id.action_progress_no_data
            android.view.View r0 = r6.a((int) r0)
            android.widget.ProgressBar r0 = (android.widget.ProgressBar) r0
            if (r0 == 0) goto L_0x0156
            r0.setVisibility(r2)
        L_0x0156:
            net.one97.paytm.recharge.common.a.d r0 = r6.f61244e
            if (r0 != 0) goto L_0x0315
            net.one97.paytm.recharge.common.e.d r0 = r6.f61241a
            if (r0 == 0) goto L_0x0174
            boolean r0 = r0.b()
            if (r0 != r4) goto L_0x0174
            java.util.List<? extends net.one97.paytm.recharge.model.mobile.CJRMadeForYouPlanData> r0 = r6.f61247h
            if (r0 == 0) goto L_0x0174
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            r0 = r0 ^ r4
            if (r0 != r4) goto L_0x0174
            r6.a((java.util.List<? extends net.one97.paytm.recharge.model.rechargeutility.CJRBowsePlanGroupingListV8>) r1, (java.util.List<? extends net.one97.paytm.recharge.model.mobile.CJRMadeForYouPlanData>) r8)
        L_0x0174:
            net.one97.paytm.recharge.common.a.d r0 = new net.one97.paytm.recharge.common.a.d
            androidx.fragment.app.j r5 = r27.getChildFragmentManager()
            java.lang.String r7 = "childFragmentManager"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r7)
            int r7 = net.one97.paytm.recharge.R.id.viewpager
            android.view.View r7 = r6.a((int) r7)
            androidx.viewpager.widget.ViewPager r7 = (androidx.viewpager.widget.ViewPager) r7
            java.lang.String r9 = "viewpager"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r9)
            r0.<init>(r5, r1, r7)
            r6.f61244e = r0
            int r0 = r1.size()
            r5 = 3
            if (r0 <= r5) goto L_0x01a6
            int r0 = net.one97.paytm.recharge.R.id.tabs
            android.view.View r0 = r6.a((int) r0)
            com.google.android.material.tabs.TabLayout r0 = (com.google.android.material.tabs.TabLayout) r0
            if (r0 == 0) goto L_0x01a6
            r0.setTabMode(r3)
        L_0x01a6:
            int r0 = net.one97.paytm.recharge.R.id.viewpager
            android.view.View r0 = r6.a((int) r0)
            androidx.viewpager.widget.ViewPager r0 = (androidx.viewpager.widget.ViewPager) r0
            if (r0 == 0) goto L_0x01b7
            net.one97.paytm.recharge.common.a.d r5 = r6.f61244e
            androidx.viewpager.widget.a r5 = (androidx.viewpager.widget.a) r5
            r0.setAdapter(r5)
        L_0x01b7:
            int r0 = net.one97.paytm.recharge.R.id.tabs
            android.view.View r0 = r6.a((int) r0)
            com.google.android.material.tabs.TabLayout r0 = (com.google.android.material.tabs.TabLayout) r0
            if (r0 == 0) goto L_0x01cc
            int r5 = net.one97.paytm.recharge.R.id.viewpager
            android.view.View r5 = r6.a((int) r5)
            androidx.viewpager.widget.ViewPager r5 = (androidx.viewpager.widget.ViewPager) r5
            r0.setupWithViewPager(r5)
        L_0x01cc:
            int r0 = net.one97.paytm.recharge.R.id.viewpager
            android.view.View r0 = r6.a((int) r0)
            androidx.viewpager.widget.ViewPager r0 = (androidx.viewpager.widget.ViewPager) r0
            if (r0 == 0) goto L_0x01da
            r5 = 5
            r0.setOffscreenPageLimit(r5)
        L_0x01da:
            int r0 = net.one97.paytm.recharge.R.id.viewpager
            android.view.View r0 = r6.a((int) r0)
            androidx.viewpager.widget.ViewPager r0 = (androidx.viewpager.widget.ViewPager) r0
            if (r0 == 0) goto L_0x01ea
            r5 = r6
            androidx.viewpager.widget.ViewPager$e r5 = (androidx.viewpager.widget.ViewPager.e) r5
            r0.addOnPageChangeListener(r5)
        L_0x01ea:
            net.one97.paytm.recharge.common.e.d r0 = r6.f61241a
            if (r0 == 0) goto L_0x028f
            boolean r0 = r0.b()
            if (r0 != r4) goto L_0x028f
            java.util.List<? extends net.one97.paytm.recharge.model.mobile.CJRMadeForYouPlanData> r0 = r6.f61247h
            if (r0 == 0) goto L_0x028f
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            r0 = r0 ^ r4
            if (r0 != r4) goto L_0x028f
            net.one97.paytm.recharge.common.a.d r0 = r6.f61244e
            if (r0 == 0) goto L_0x0277
            androidx.fragment.app.Fragment r0 = r0.a()
            boolean r5 = r0 instanceof net.one97.paytm.recharge.common.fragment.q
            if (r5 == 0) goto L_0x0277
            net.one97.paytm.recharge.common.fragment.q r0 = (net.one97.paytm.recharge.common.fragment.q) r0
            net.one97.paytm.recharge.model.rechargeutility.CJRBowsePlanGroupingListV8 r5 = r0.f61376c
            if (r5 == 0) goto L_0x026a
            boolean r5 = r5.isOneToOne()
            if (r5 != r4) goto L_0x026a
            net.one97.paytm.recharge.model.rechargeutility.CJRBowsePlanGroupingListV8 r4 = r0.f61376c
            if (r4 == 0) goto L_0x0222
            java.util.List r4 = r4.getProductList()
            goto L_0x0223
        L_0x0222:
            r4 = r8
        L_0x0223:
            if (r4 == 0) goto L_0x0242
            net.one97.paytm.recharge.model.rechargeutility.CJRBowsePlanGroupingListV8 r4 = r0.f61376c
            if (r4 == 0) goto L_0x0237
            java.util.List r4 = r4.getProductList()
            if (r4 == 0) goto L_0x0237
            int r4 = r4.size()
            java.lang.Integer r8 = java.lang.Integer.valueOf(r4)
        L_0x0237:
            if (r8 != 0) goto L_0x023c
            kotlin.g.b.k.a()
        L_0x023c:
            int r4 = r8.intValue()
            if (r4 != 0) goto L_0x026a
        L_0x0242:
            int r4 = net.one97.paytm.recharge.R.id.layout_progress_bar
            android.view.View r4 = r0.a((int) r4)
            android.widget.RelativeLayout r4 = (android.widget.RelativeLayout) r4
            if (r4 == 0) goto L_0x024f
            r4.setVisibility(r3)
        L_0x024f:
            int r4 = net.one97.paytm.recharge.R.id.loading
            android.view.View r4 = r0.a((int) r4)
            android.widget.ProgressBar r4 = (android.widget.ProgressBar) r4
            if (r4 == 0) goto L_0x025c
            r4.setVisibility(r3)
        L_0x025c:
            int r4 = net.one97.paytm.recharge.R.id.plans_not_available
            android.view.View r0 = r0.a((int) r4)
            android.widget.TextView r0 = (android.widget.TextView) r0
            if (r0 == 0) goto L_0x0277
            r0.setVisibility(r2)
            goto L_0x0277
        L_0x026a:
            int r4 = net.one97.paytm.recharge.R.id.layout_progress_bar
            android.view.View r0 = r0.a((int) r4)
            android.widget.RelativeLayout r0 = (android.widget.RelativeLayout) r0
            if (r0 == 0) goto L_0x0277
            r0.setVisibility(r2)
        L_0x0277:
            java.util.List<? extends net.one97.paytm.recharge.model.mobile.CJRMadeForYouPlanData> r0 = r6.f61247h
            r6.a((java.util.List<? extends net.one97.paytm.recharge.model.rechargeutility.CJRBowsePlanGroupingListV8>) r1, (java.util.List<? extends net.one97.paytm.recharge.model.mobile.CJRMadeForYouPlanData>) r0)
            int r0 = net.one97.paytm.recharge.R.id.viewpager
            android.view.View r0 = r6.a((int) r0)
            androidx.viewpager.widget.ViewPager r0 = (androidx.viewpager.widget.ViewPager) r0
            if (r0 == 0) goto L_0x028f
            int r0 = r0.getCurrentItem()
            if (r0 != 0) goto L_0x028f
            r6.onPageSelected(r3)
        L_0x028f:
            r6.onPageSelected(r3)
            return
        L_0x0293:
            java.lang.String r2 = "tag.get.one2one.plans"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0315
            net.one97.paytm.recharge.common.e.d r2 = r6.f61241a
            boolean r3 = r2 instanceof net.one97.paytm.recharge.mobile.d.a
            if (r3 == 0) goto L_0x02b0
            if (r2 == 0) goto L_0x02aa
            net.one97.paytm.recharge.mobile.d.a r2 = (net.one97.paytm.recharge.mobile.d.a) r2
            r2.a_(r1, r0, r5)
            goto L_0x02b0
        L_0x02aa:
            kotlin.u r0 = new kotlin.u
            r0.<init>(r4)
            throw r0
        L_0x02b0:
            boolean r2 = r0 instanceof net.one97.paytm.recharge.model.mobile.CJRMadeForYouResponse
            if (r2 == 0) goto L_0x0309
            net.one97.paytm.recharge.model.mobile.CJRMadeForYouResponse r0 = (net.one97.paytm.recharge.model.mobile.CJRMadeForYouResponse) r0
            java.util.List r0 = r0.getPlansData()
            r6.f61247h = r0
            boolean r0 = r5 instanceof net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel
            if (r0 == 0) goto L_0x02e4
            r9 = r5
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r9 = (net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r9
            r10 = 0
            r11 = 0
            r12 = 0
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
            r25 = 32719(0x7fcf, float:4.5849E-41)
            r26 = 0
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r0 = net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel.copy$default(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26)
            goto L_0x02ea
        L_0x02e4:
            net.one97.paytm.recharge.widgets.c.d r0 = net.one97.paytm.recharge.widgets.c.d.f64967a
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r0 = net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r8, (net.one97.paytm.recharge.widgets.model.ERROR_TYPE) r8)
        L_0x02ea:
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r1 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UNDEFINED
            r0.setErrorType(r1)
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r1 = r0.getFlowName()
            if (r1 == 0) goto L_0x02fe
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r2 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UNDEFINED
            java.lang.String r2 = r2.name()
            r1.setErrorType(r2)
        L_0x02fe:
            net.one97.paytm.recharge.common.e.d r1 = r6.f61241a
            if (r1 == 0) goto L_0x0308
            r2 = r6
            net.one97.paytm.recharge.common.e.ai r2 = (net.one97.paytm.recharge.common.e.ai) r2
            r1.a(r7, r2, r0)
        L_0x0308:
            return
        L_0x0309:
            r2 = 0
            r3 = 0
            r4 = 0
            r0 = r27
            r1 = r28
            r5 = r30
            r0.a(r1, r2, r3, r4, r5)
        L_0x0315:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.fragment.i.a_(java.lang.String, com.paytm.network.model.IJRPaytmDataModel, java.lang.Object):void");
    }

    public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
        CJRRechargeErrorModel cJRRechargeErrorModel;
        String str2 = str;
        Object obj2 = obj;
        if (str2 != null) {
            int hashCode = str.hashCode();
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
                net.one97.paytm.recharge.common.e.d dVar2 = this.f61241a;
                if (dVar2 != null) {
                    dVar2.a("tag.get.browse.plans", this, cJRRechargeErrorModel);
                }
                if (z) {
                    az azVar2 = az.f61525a;
                    az.a((CJRRechargeErrorModel) obj2);
                }
            }
        }
    }

    private void a(List<? extends CJRBowsePlanGroupingListV8> list, List<? extends CJRMadeForYouPlanData> list2) {
        List<CJRBrowsePlanProductList> list3;
        Object obj;
        Iterator it2 = list.iterator();
        while (true) {
            list3 = null;
            if (!it2.hasNext()) {
                obj = null;
                break;
            }
            obj = it2.next();
            if (((CJRBowsePlanGroupingListV8) obj).isOneToOne()) {
                break;
            }
        }
        this.f61246g = (CJRBowsePlanGroupingListV8) obj;
        this.f61246g = a(this.f61246g, list2);
        CJRBowsePlanGroupingListV8 cJRBowsePlanGroupingListV8 = this.f61246g;
        if (cJRBowsePlanGroupingListV8 != null) {
            net.one97.paytm.recharge.common.e.d dVar = this.f61241a;
            cJRBowsePlanGroupingListV8.setDisclaimer(dVar != null ? dVar.c() : null);
        }
        net.one97.paytm.recharge.common.e.d dVar2 = this.f61241a;
        String a2 = dVar2 != null ? dVar2.a() : null;
        CharSequence charSequence = a2;
        if (charSequence == null || p.a(charSequence)) {
            a2 = "121 Made for You";
        }
        CJRBowsePlanGroupingListV8 cJRBowsePlanGroupingListV82 = this.f61246g;
        if (cJRBowsePlanGroupingListV82 != null) {
            cJRBowsePlanGroupingListV82.setName(a2);
        }
        if (this.f61246g != null) {
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
            if (i2 == -1) {
                ArrayList arrayList = (ArrayList) list;
                CJRBowsePlanGroupingListV8 cJRBowsePlanGroupingListV83 = this.f61246g;
                if (cJRBowsePlanGroupingListV83 == null) {
                    k.a();
                }
                arrayList.add(0, cJRBowsePlanGroupingListV83);
                return;
            }
            net.one97.paytm.recharge.common.a.d dVar3 = this.f61244e;
            if (dVar3 != null && dVar3 != null) {
                Fragment a3 = dVar3.a();
                if (a3 instanceof q) {
                    q qVar = (q) a3;
                    qVar.a();
                    CJRBowsePlanGroupingListV8 cJRBowsePlanGroupingListV84 = qVar.f61376c;
                    if ((cJRBowsePlanGroupingListV84 != null ? cJRBowsePlanGroupingListV84.getProductList() : null) != null) {
                        ArrayList<CJRBrowsePlanProductList> arrayList2 = qVar.f61377d;
                        CJRBowsePlanGroupingListV8 cJRBowsePlanGroupingListV85 = qVar.f61376c;
                        if (cJRBowsePlanGroupingListV85 != null) {
                            list3 = cJRBowsePlanGroupingListV85.getProductList();
                        }
                        if (list3 == null) {
                            k.a();
                        }
                        arrayList2.addAll(list3);
                        w wVar = qVar.f61375b;
                        if (wVar != null) {
                            wVar.notifyDataSetChanged();
                        }
                    }
                }
            }
        }
    }

    public final void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        View a2 = a(R.id.lyt_search);
        k.a((Object) a2, "lyt_search");
        int id = a2.getId();
        if (valueOf != null && valueOf.intValue() == id) {
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) a(R.id.txt_search);
            if (autoCompleteTextView != null) {
                autoCompleteTextView.post(new d(this));
                return;
            }
            return;
        }
        ImageView imageView = (ImageView) a(R.id.img_clear_search);
        k.a((Object) imageView, "img_clear_search");
        int id2 = imageView.getId();
        if (valueOf != null && valueOf.intValue() == id2) {
            AutoCompleteTextView autoCompleteTextView2 = (AutoCompleteTextView) a(R.id.txt_search);
            if (autoCompleteTextView2 != null) {
                autoCompleteTextView2.setText("");
                return;
            }
            return;
        }
        ImageView imageView2 = (ImageView) a(R.id.img_close_screen);
        k.a((Object) imageView2, "img_close_screen");
        int id3 = imageView2.getId();
        if (valueOf != null && valueOf.intValue() == id3) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.onBackPressed();
            }
            try {
                Context context = getContext();
                if (context == null) {
                    k.a();
                }
                k.a((Object) context, "context!!");
                net.one97.paytm.recharge.ordersummary.h.d.a(new net.one97.paytm.recharge.ordersummary.h.d(context), "mobile_prepaid", "browse_plans_cross_button_clicked", (Object) null, (Object) null, (Object) null, (Object) null, (Object) null, 124);
            } catch (Throwable unused) {
            }
            d();
            return;
        }
        RoboTextView roboTextView = (RoboTextView) a(R.id.view_all_button);
        k.a((Object) roboTextView, "view_all_button");
        int id4 = roboTextView.getId();
        if (valueOf != null && valueOf.intValue() == id4) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) a(R.id.plan_container);
            if (coordinatorLayout != null) {
                coordinatorLayout.setVisibility(0);
            }
            LinearLayout linearLayout = (LinearLayout) a(R.id.search_container_list);
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
            ImageView imageView3 = (ImageView) a(R.id.img_clear_search);
            if (imageView3 != null) {
                imageView3.setVisibility(4);
            }
            RelativeLayout relativeLayout = (RelativeLayout) a(R.id.no_result_container);
            if (relativeLayout != null) {
                relativeLayout.setVisibility(8);
            }
            AutoCompleteTextView autoCompleteTextView3 = (AutoCompleteTextView) a(R.id.txt_search);
            if (autoCompleteTextView3 != null) {
                autoCompleteTextView3.setText((CharSequence) null);
            }
            TabLayout tabLayout = (TabLayout) a(R.id.tabs);
            if (tabLayout != null) {
                tabLayout.setVisibility(0);
            }
            AutoCompleteTextView autoCompleteTextView4 = (AutoCompleteTextView) a(R.id.txt_search);
            if (autoCompleteTextView4 != null) {
                autoCompleteTextView4.clearFocus();
            }
            FragmentActivity activity2 = getActivity();
            if (activity2 != null) {
                k.a((Object) activity2, "it");
                new t(activity2).a();
            }
        }
    }

    static final class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i f61250a;

        d(i iVar) {
            this.f61250a = iVar;
        }

        public final void run() {
            try {
                AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) this.f61250a.a(R.id.txt_search);
                if (autoCompleteTextView != null) {
                    autoCompleteTextView.requestFocusFromTouch();
                }
                Context context = this.f61250a.getContext();
                Object systemService = context != null ? context.getSystemService("input_method") : null;
                if (systemService != null) {
                    ((InputMethodManager) systemService).showSoftInput((AutoCompleteTextView) this.f61250a.a(R.id.txt_search), 0);
                    return;
                }
                throw new u("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            } catch (Exception e2) {
                com.paytm.utility.q.d(e2.getMessage());
            }
        }
    }

    public final void a(CJRBrowsePlanProductList cJRBrowsePlanProductList) {
        k.c(cJRBrowsePlanProductList, "itemProduct");
        net.one97.paytm.recharge.common.c.f fVar = new net.one97.paytm.recharge.common.c.f(cJRBrowsePlanProductList, this);
        androidx.fragment.app.j childFragmentManager = getChildFragmentManager();
        k.a((Object) childFragmentManager, "childFragmentManager");
        f.a aVar = net.one97.paytm.recharge.common.c.f.f60991a;
        fVar.show(childFragmentManager, net.one97.paytm.recharge.common.c.f.f60992d);
    }

    public final void b(CJRBrowsePlanProductList cJRBrowsePlanProductList) {
        k.c(cJRBrowsePlanProductList, "itemProduct");
        net.one97.paytm.recharge.common.e.d dVar = this.f61241a;
        if (dVar != null) {
            dVar.a(cJRBrowsePlanProductList);
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.onBackPressed();
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
        io.reactivex.rxjava3.b.c cVar = this.f61248i;
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

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0015, code lost:
        r0 = r0.f60486a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onPageSelected(int r12) {
        /*
            r11 = this;
            r11.d()
            int r0 = net.one97.paytm.recharge.R.id.txt_search
            android.view.View r0 = r11.a((int) r0)
            android.widget.AutoCompleteTextView r0 = (android.widget.AutoCompleteTextView) r0
            if (r0 == 0) goto L_0x0010
            r0.clearFocus()
        L_0x0010:
            net.one97.paytm.recharge.common.a.d r0 = r11.f61244e
            r1 = 0
            if (r0 == 0) goto L_0x0020
            java.util.List<net.one97.paytm.recharge.model.rechargeutility.CJRBowsePlanGroupingListV8> r0 = r0.f60486a
            if (r0 == 0) goto L_0x0020
            java.lang.Object r12 = r0.get(r12)
            net.one97.paytm.recharge.model.rechargeutility.CJRBowsePlanGroupingListV8 r12 = (net.one97.paytm.recharge.model.rechargeutility.CJRBowsePlanGroupingListV8) r12
            goto L_0x0021
        L_0x0020:
            r12 = r1
        L_0x0021:
            if (r12 == 0) goto L_0x00d5
            java.util.List r0 = r12.getProductList()
            r2 = 1
            if (r0 == 0) goto L_0x00ba
            java.util.List r0 = r12.getProductList()
            if (r0 == 0) goto L_0x0039
            int r0 = r0.size()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x003a
        L_0x0039:
            r0 = r1
        L_0x003a:
            if (r0 != 0) goto L_0x003f
            kotlin.g.b.k.a()
        L_0x003f:
            int r0 = r0.intValue()
            if (r0 <= 0) goto L_0x00ba
            android.content.Context r0 = r11.getContext()
            if (r0 == 0) goto L_0x00d5
            android.content.Context r0 = r0.getApplicationContext()
            if (r0 == 0) goto L_0x00d5
            net.one97.paytm.recharge.common.utils.ax$a r3 = net.one97.paytm.recharge.common.utils.ax.f61521a
            android.content.Context r0 = r0.getApplicationContext()
            java.lang.String r3 = "context.applicationContext"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
            com.paytm.b.a.a r0 = net.one97.paytm.recharge.common.utils.ax.a.a(r0)
            boolean r3 = r12.isOneToOne()
            java.lang.String r3 = r11.a((boolean) r3)
            boolean r4 = net.one97.paytm.recharge.common.utils.g.c(r3)
            if (r4 == 0) goto L_0x00d5
            if (r3 != 0) goto L_0x0073
            kotlin.g.b.k.a()
        L_0x0073:
            r4 = 0
            boolean r0 = r0.b((java.lang.String) r3, (boolean) r4, (boolean) r2)
            if (r0 != 0) goto L_0x009e
            boolean r0 = r12.isOneToOne()
            if (r0 == 0) goto L_0x008c
            java.lang.String r0 = r12.getDisclaimer()
            boolean r12 = r12.isOneToOne()
            r11.a((java.lang.String) r0, (boolean) r12)
            goto L_0x00d5
        L_0x008c:
            net.one97.paytm.recharge.common.e.d r0 = r11.f61241a
            if (r0 == 0) goto L_0x0095
            java.lang.String r0 = r0.d()
            goto L_0x0096
        L_0x0095:
            r0 = r1
        L_0x0096:
            boolean r12 = r12.isOneToOne()
            r11.a((java.lang.String) r0, (boolean) r12)
            goto L_0x00d5
        L_0x009e:
            net.one97.paytm.recharge.common.widget.c r12 = r11.f61243c
            if (r12 == 0) goto L_0x00d5
            boolean r12 = r12.e()
            if (r12 != r2) goto L_0x00d5
            net.one97.paytm.recharge.common.widget.c r12 = r11.f61243c
            if (r12 == 0) goto L_0x00d5
            boolean r12 = r12.b()
            if (r12 != r2) goto L_0x00d5
            net.one97.paytm.recharge.common.widget.c r12 = r11.f61243c
            if (r12 == 0) goto L_0x00d5
            r12.d()
            goto L_0x00d5
        L_0x00ba:
            net.one97.paytm.recharge.common.widget.c r12 = r11.f61243c
            if (r12 == 0) goto L_0x00d5
            boolean r12 = r12.e()
            if (r12 != r2) goto L_0x00d5
            net.one97.paytm.recharge.common.widget.c r12 = r11.f61243c
            if (r12 == 0) goto L_0x00d5
            boolean r12 = r12.b()
            if (r12 != r2) goto L_0x00d5
            net.one97.paytm.recharge.common.widget.c r12 = r11.f61243c
            if (r12 == 0) goto L_0x00d5
            r12.d()
        L_0x00d5:
            net.one97.paytm.recharge.ordersummary.h.d r2 = new net.one97.paytm.recharge.ordersummary.h.d     // Catch:{ all -> 0x0131 }
            android.content.Context r12 = r11.getContext()     // Catch:{ all -> 0x0131 }
            if (r12 != 0) goto L_0x00e0
            kotlin.g.b.k.a()     // Catch:{ all -> 0x0131 }
        L_0x00e0:
            java.lang.String r0 = "context!!"
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r0)     // Catch:{ all -> 0x0131 }
            r2.<init>(r12)     // Catch:{ all -> 0x0131 }
            java.lang.String r3 = "mobile_prepaid"
            java.lang.String r4 = "browse_plans_tabs_clicked"
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x0131 }
            java.lang.String r0 = "/"
            r12.<init>(r0)     // Catch:{ all -> 0x0131 }
            net.one97.paytm.recharge.common.e.d r0 = r11.f61241a     // Catch:{ all -> 0x0131 }
            if (r0 == 0) goto L_0x00fb
            java.lang.Object r1 = r0.e()     // Catch:{ all -> 0x0131 }
        L_0x00fb:
            r12.append(r1)     // Catch:{ all -> 0x0131 }
            java.lang.String r0 = "/browse_plans"
            r12.append(r0)     // Catch:{ all -> 0x0131 }
            java.lang.String r5 = r12.toString()     // Catch:{ all -> 0x0131 }
            net.one97.paytm.recharge.common.a.d r12 = r11.f61244e     // Catch:{ all -> 0x0131 }
            if (r12 != 0) goto L_0x010e
            kotlin.g.b.k.a()     // Catch:{ all -> 0x0131 }
        L_0x010e:
            int r0 = net.one97.paytm.recharge.R.id.viewpager     // Catch:{ all -> 0x0131 }
            android.view.View r0 = r11.a((int) r0)     // Catch:{ all -> 0x0131 }
            androidx.viewpager.widget.ViewPager r0 = (androidx.viewpager.widget.ViewPager) r0     // Catch:{ all -> 0x0131 }
            java.lang.String r1 = "viewpager"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)     // Catch:{ all -> 0x0131 }
            int r0 = r0.getCurrentItem()     // Catch:{ all -> 0x0131 }
            java.lang.CharSequence r6 = r12.getPageTitle(r0)     // Catch:{ all -> 0x0131 }
            if (r6 != 0) goto L_0x0129
            kotlin.g.b.k.a()     // Catch:{ all -> 0x0131 }
        L_0x0129:
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 112(0x70, float:1.57E-43)
            net.one97.paytm.recharge.ordersummary.h.d.a(r2, r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ all -> 0x0131 }
        L_0x0131:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.fragment.i.onPageSelected(int):void");
    }

    /* JADX WARNING: type inference failed for: r0v12, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void a(java.lang.String r4, boolean r5) {
        /*
            r3 = this;
            android.content.Context r0 = r3.getContext()
            if (r0 == 0) goto L_0x00af
            boolean r0 = r3.isAdded()
            if (r0 != 0) goto L_0x000e
            goto L_0x00af
        L_0x000e:
            net.one97.paytm.recharge.common.widget.c r0 = r3.f61243c
            if (r0 == 0) goto L_0x001a
            boolean r0 = r0.e()
            if (r0 != 0) goto L_0x001a
            r0 = 1
            goto L_0x001b
        L_0x001a:
            r0 = 0
        L_0x001b:
            if (r0 != 0) goto L_0x002f
            net.one97.paytm.recharge.common.widget.c r0 = r3.f61243c
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
            if (r0 == 0) goto L_0x00af
            net.one97.paytm.recharge.common.widget.c r1 = r3.f61243c
            if (r1 == 0) goto L_0x004b
            int r2 = net.one97.paytm.recharge.R.layout.disclaimer_snack_bar
            r1.f62145a = r2
            net.one97.paytm.recharge.common.widget.c$b r2 = net.one97.paytm.recharge.common.widget.c.b.INDEFINITE
            net.one97.paytm.recharge.common.widget.c r1 = r1.a((net.one97.paytm.recharge.common.widget.c.b) r2)
            java.lang.String r2 = "it"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            r1.a((android.view.View) r0)
        L_0x004b:
            net.one97.paytm.recharge.common.widget.c r0 = r3.f61243c
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
            if (r0 == 0) goto L_0x00a7
            r3.j = r0
            r3.b(r4, r5)
            net.one97.paytm.recharge.common.widget.c r0 = r3.f61243c
            if (r0 == 0) goto L_0x007a
            android.view.View r0 = r0.a()
            if (r0 == 0) goto L_0x007a
            int r1 = net.one97.paytm.recharge.R.id.btn_okay_click
            android.view.View r0 = r0.findViewById(r1)
            r1 = r0
            com.paytm.utility.RoboTextView r1 = (com.paytm.utility.RoboTextView) r1
        L_0x007a:
            if (r1 == 0) goto L_0x009f
            net.one97.paytm.recharge.common.fragment.i$i r0 = new net.one97.paytm.recharge.common.fragment.i$i
            r0.<init>(r3, r4, r5)
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r1.setOnClickListener(r0)
            net.one97.paytm.recharge.common.widget.c r0 = r3.f61243c
            if (r0 == 0) goto L_0x0094
            net.one97.paytm.recharge.common.fragment.i$j r1 = new net.one97.paytm.recharge.common.fragment.i$j
            r1.<init>(r3, r4, r5)
            com.google.android.material.snackbar.Snackbar$a r1 = (com.google.android.material.snackbar.Snackbar.a) r1
            r0.a((com.google.android.material.snackbar.Snackbar.a) r1)
        L_0x0094:
            net.one97.paytm.recharge.common.widget.c r4 = r3.f61243c
            if (r4 == 0) goto L_0x009b
            r4.c()
        L_0x009b:
            r3.c()
            return
        L_0x009f:
            kotlin.u r4 = new kotlin.u
            java.lang.String r5 = "null cannot be cast to non-null type com.paytm.utility.RoboTextView"
            r4.<init>(r5)
            throw r4
        L_0x00a7:
            kotlin.u r4 = new kotlin.u
            java.lang.String r5 = "null cannot be cast to non-null type android.widget.TextView"
            r4.<init>(r5)
            throw r4
        L_0x00af:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.fragment.i.a(java.lang.String, boolean):void");
    }

    /* renamed from: net.one97.paytm.recharge.common.fragment.i$i  reason: collision with other inner class name */
    static final class C1186i implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i f61255a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f61256b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ boolean f61257c;

        C1186i(i iVar, String str, boolean z) {
            this.f61255a = iVar;
            this.f61256b = str;
            this.f61257c = z;
        }

        public final void onClick(View view) {
            i iVar = this.f61255a;
            i.a(iVar, iVar.f61243c);
        }
    }

    public static final class j extends Snackbar.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i f61258a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f61259b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ boolean f61260c;

        j(i iVar, String str, boolean z) {
            this.f61258a = iVar;
            this.f61259b = str;
            this.f61260c = z;
        }

        public final void a(Snackbar snackbar, int i2) {
            super.a(snackbar, i2);
            this.f61258a.c();
        }

        public final void a(Snackbar snackbar) {
            super.a(snackbar);
            if (Build.VERSION.SDK_INT < 21) {
                this.f61258a.b(this.f61259b, this.f61260c);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void b(String str, boolean z) {
        if (getContext() != null) {
            boolean z2 = false;
            if (z) {
                CharSequence charSequence = str;
                if (charSequence == null || p.a(charSequence)) {
                    z2 = true;
                }
                if (z2) {
                    TextView textView = this.j;
                    if (textView != null) {
                        Context context = getContext();
                        if (context == null) {
                            k.a();
                        }
                        textView.setText(Html.fromHtml(context.getString(R.string.disclaimer_text_one_2_one_html)));
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
                    Context context2 = getContext();
                    if (context2 == null) {
                        k.a();
                    }
                    textView3.setText(context2.getString(R.string.disclaimer_text_html));
                    return;
                }
                return;
            }
            TextView textView4 = this.j;
            if (textView4 != null) {
                textView4.setText(charSequence2);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x001f A[Catch:{ Exception -> 0x0046 }] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0028 A[Catch:{ Exception -> 0x0046 }] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0030 A[Catch:{ Exception -> 0x0046 }] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0037 A[Catch:{ Exception -> 0x0046 }] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x003c A[Catch:{ Exception -> 0x0046 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String a(boolean r5) {
        /*
            r4 = this;
            r0 = 0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0046 }
            r1.<init>()     // Catch:{ Exception -> 0x0046 }
            android.content.Context r2 = r4.getContext()     // Catch:{ Exception -> 0x0046 }
            java.lang.String r2 = com.paytm.utility.b.A((android.content.Context) r2)     // Catch:{ Exception -> 0x0046 }
            r3 = r2
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ Exception -> 0x0046 }
            if (r3 == 0) goto L_0x001c
            boolean r3 = kotlin.m.p.a(r3)     // Catch:{ Exception -> 0x0046 }
            if (r3 == 0) goto L_0x001a
            goto L_0x001c
        L_0x001a:
            r3 = 0
            goto L_0x001d
        L_0x001c:
            r3 = 1
        L_0x001d:
            if (r3 != 0) goto L_0x0022
            r1.append(r2)     // Catch:{ Exception -> 0x0046 }
        L_0x0022:
            android.os.Bundle r2 = r4.getArguments()     // Catch:{ Exception -> 0x0046 }
            if (r2 == 0) goto L_0x0030
            java.lang.String r3 = "title"
            java.lang.String r2 = r2.getString(r3)     // Catch:{ Exception -> 0x0046 }
            goto L_0x0031
        L_0x0030:
            r2 = r0
        L_0x0031:
            boolean r3 = net.one97.paytm.recharge.common.utils.g.c(r2)     // Catch:{ Exception -> 0x0046 }
            if (r3 == 0) goto L_0x003a
            r1.append(r2)     // Catch:{ Exception -> 0x0046 }
        L_0x003a:
            if (r5 == 0) goto L_0x0041
            java.lang.String r5 = "121"
            r1.append(r5)     // Catch:{ Exception -> 0x0046 }
        L_0x0041:
            java.lang.String r5 = r1.toString()     // Catch:{ Exception -> 0x0046 }
            return r5
        L_0x0046:
            r5 = move-exception
            net.one97.paytm.recharge.di.helper.CJRRechargeUtilities r1 = net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE
            java.lang.Throwable r5 = (java.lang.Throwable) r5
            r1.debugLogExceptions(r5)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.fragment.i.a(boolean):java.lang.String");
    }

    /* access modifiers changed from: private */
    public final void c() {
        net.one97.paytm.recharge.common.widget.c cVar;
        ViewTreeObserver f2;
        net.one97.paytm.recharge.common.widget.c cVar2;
        net.one97.paytm.recharge.common.widget.c cVar3 = this.f61243c;
        if ((cVar3 == null || cVar3.e()) && ((cVar = this.f61243c) == null || !cVar.e() || (cVar2 = this.f61243c) == null || cVar2.b())) {
            net.one97.paytm.recharge.common.widget.c cVar4 = this.f61243c;
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
        final /* synthetic */ i f61249a;

        c(i iVar) {
            this.f61249a = iVar;
        }

        public final void onGlobalLayout() {
            ViewTreeObserver f2;
            ViewTreeObserver f3;
            i iVar = this.f61249a;
            net.one97.paytm.recharge.common.widget.c cVar = iVar.f61243c;
            iVar.a(cVar != null ? Integer.valueOf(cVar.g()) : null);
            if (Build.VERSION.SDK_INT >= 16) {
                net.one97.paytm.recharge.common.widget.c cVar2 = this.f61249a.f61243c;
                if (cVar2 != null && (f3 = cVar2.f()) != null) {
                    f3.removeOnGlobalLayoutListener(this);
                    return;
                }
                return;
            }
            net.one97.paytm.recharge.common.widget.c cVar3 = this.f61249a.f61243c;
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
        net.one97.paytm.recharge.common.widget.c cVar2 = this.f61243c;
        if (!(cVar2 == null || !cVar2.e() || (cVar = this.f61243c) == null)) {
            cVar.d();
        }
        super.onDestroyView();
        HashMap hashMap = this.o;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    private void d() {
        FragmentActivity activity = getActivity();
        IBinder iBinder = null;
        if ((activity != null ? activity.getCurrentFocus() : null) != null) {
            try {
                FragmentActivity activity2 = getActivity();
                if (activity2 == null) {
                    k.a();
                }
                Object systemService = activity2.getSystemService("input_method");
                if (systemService != null) {
                    InputMethodManager inputMethodManager = (InputMethodManager) systemService;
                    FragmentActivity activity3 = getActivity();
                    if (activity3 == null) {
                        k.a();
                    }
                    k.a((Object) activity3, "activity!!");
                    View currentFocus = activity3.getCurrentFocus();
                    if (currentFocus != null) {
                        iBinder = currentFocus.getWindowToken();
                    }
                    inputMethodManager.hideSoftInputFromWindow(iBinder, 0);
                    return;
                }
                throw new u("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            } catch (Throwable th) {
                CJRRechargeUtilities.INSTANCE.debugLogExceptions(th);
            }
        }
    }

    public final void onOffsetChanged(AppBarLayout appBarLayout, int i2) {
        if (i2 == 0) {
            if (!(this.l == b.EXPANDED || ((AutoCompleteTextView) a(R.id.txt_search)) == null || !((AutoCompleteTextView) a(R.id.txt_search)).hasFocus())) {
                AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) a(R.id.txt_search);
                k.a((Object) autoCompleteTextView, "txt_search");
                View view = autoCompleteTextView;
                k.c(view, "view");
                try {
                    if (getActivity() != null && view.requestFocus()) {
                        FragmentActivity activity = getActivity();
                        if (activity == null) {
                            k.a();
                        }
                        Object systemService = activity.getSystemService("input_method");
                        if (systemService != null) {
                            ((InputMethodManager) systemService).showSoftInput(view, 1);
                        } else {
                            throw new u("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
                        }
                    }
                } catch (Throwable th) {
                    CJRRechargeUtilities.INSTANCE.debugLogExceptions(th);
                }
            }
            this.l = b.EXPANDED;
            return;
        }
        int abs = Math.abs(i2);
        if (appBarLayout == null) {
            k.a();
        }
        if (abs >= appBarLayout.getTotalScrollRange()) {
            if (this.l != b.COLLAPSED) {
                AutoCompleteTextView autoCompleteTextView2 = (AutoCompleteTextView) a(R.id.txt_search);
                if (autoCompleteTextView2 != null) {
                    autoCompleteTextView2.clearFocus();
                }
                d();
            }
            this.l = b.COLLAPSED;
        } else if (this.l != b.IDLE) {
            this.l = b.IDLE;
        }
    }

    public static final /* synthetic */ void a(i iVar, List list) {
        net.one97.paytm.recharge.common.a.f fVar;
        if (iVar.f61245f == null) {
            iVar.f61245f = new net.one97.paytm.recharge.common.a.f(list, iVar);
            RecyclerView recyclerView = (RecyclerView) iVar.a(R.id.browse_plan_search_recycler_view);
            if (recyclerView != null) {
                recyclerView.setLayoutManager(new LinearLayoutManager(iVar.getContext()));
            }
            RecyclerView recyclerView2 = (RecyclerView) iVar.a(R.id.browse_plan_search_recycler_view);
            if (recyclerView2 != null) {
                recyclerView2.setAdapter(iVar.f61245f);
                return;
            }
            return;
        }
        Collection collection = list;
        if (collection != null && (!collection.isEmpty()) && (fVar = iVar.f61245f) != null) {
            k.c(list, "result");
            if (fVar.f60494a instanceof ArrayList) {
                ((ArrayList) fVar.f60494a).clear();
                ((ArrayList) fVar.f60494a).addAll(collection);
            }
            fVar.notifyDataSetChanged();
        }
    }

    public static final /* synthetic */ void a(i iVar, net.one97.paytm.recharge.common.widget.c cVar) {
        List<CJRBowsePlanGroupingListV8> list;
        Context applicationContext;
        if (cVar != null) {
            cVar.d();
        }
        if (((ViewPager) iVar.a(R.id.viewpager)) != null) {
            boolean z = false;
            net.one97.paytm.recharge.common.a.d dVar = iVar.f61244e;
            if (dVar != null) {
                list = dVar.f60486a;
            } else {
                list = null;
            }
            if (list != null) {
                int size = list.size();
                ViewPager viewPager = (ViewPager) iVar.a(R.id.viewpager);
                k.a((Object) viewPager, "viewpager");
                if (size >= viewPager.getCurrentItem()) {
                    ViewPager viewPager2 = (ViewPager) iVar.a(R.id.viewpager);
                    k.a((Object) viewPager2, "viewpager");
                    z = list.get(viewPager2.getCurrentItem()).isOneToOne();
                }
            }
            Context context = iVar.getContext();
            if (context != null && (applicationContext = context.getApplicationContext()) != null) {
                ax.a aVar = ax.f61521a;
                com.paytm.b.a.a a2 = ax.a.a(applicationContext);
                String a3 = iVar.a(z);
                if (net.one97.paytm.recharge.common.utils.g.c(a3)) {
                    if (a3 == null) {
                        k.a();
                    }
                    a2.a(a3, true, true);
                }
            }
        }
    }
}
