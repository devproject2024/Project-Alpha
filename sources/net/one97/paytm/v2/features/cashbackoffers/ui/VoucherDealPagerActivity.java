package net.one97.paytm.v2.features.cashbackoffers.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.am;
import androidx.lifecycle.z;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.appbar.AppBarLayout;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.a.m;
import kotlin.g.b.v;
import kotlin.g.b.w;
import kotlin.g.b.x;
import kotlin.g.b.y;
import kotlin.u;
import kotlin.x;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.common.assets.R;
import net.one97.paytm.common.entity.vipcashback.VoucherFilterItem;
import net.one97.paytm.vipcashback.f.d;

public final class VoucherDealPagerActivity extends PaytmActivity {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ kotlin.k.i[] f20383a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final int f20384b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final int f20385c = 1;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public ViewPager f20386d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public net.one97.paytm.vipcashback.a.g f20387e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public int f20388f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public int f20389g;

    /* renamed from: h  reason: collision with root package name */
    private final kotlin.g f20390h = kotlin.h.a(new k(this));
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public int f20391i;
    /* access modifiers changed from: private */
    public int j;
    private final kotlin.g k = kotlin.h.a(new a(this));
    private final kotlin.g l = kotlin.h.a(new l(this));
    /* access modifiers changed from: private */
    public net.one97.paytm.v2.features.cashbackoffers.c.c m;
    /* access modifiers changed from: private */
    public m<? super ArrayList<VoucherFilterItem>, ? super Integer, x> n;
    private HashMap o;

    static {
        Class<VoucherDealPagerActivity> cls = VoucherDealPagerActivity.class;
        f20383a = new kotlin.k.i[]{y.a((v) new w(y.b(cls), "tollBarHeightDiff", "getTollBarHeightDiff()I")), y.a((v) new w(y.b(cls), "headerTittleTextSizeDiff", "getHeaderTittleTextSizeDiff()I")), y.a((v) new w(y.b(cls), "translationX", "getTranslationX()I"))};
    }

    public final View a(int i2) {
        if (this.o == null) {
            this.o = new HashMap();
        }
        View view = (View) this.o.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.o.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    static final class g<T> implements z<net.one97.paytm.vipcashback.f.h<Object>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ VoucherDealPagerActivity f20398a;

        g(VoucherDealPagerActivity voucherDealPagerActivity) {
            this.f20398a = voucherDealPagerActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.vipcashback.f.h hVar = (net.one97.paytm.vipcashback.f.h) obj;
            Integer valueOf = hVar != null ? Integer.valueOf(hVar.f20893a) : null;
            if ((valueOf != null && valueOf.intValue() == 102) || (valueOf != null && valueOf.intValue() == 104)) {
                d.a aVar = net.one97.paytm.vipcashback.f.d.f20859a;
                d.a.a((Context) this.f20398a, (kotlin.g.a.a<x>) new kotlin.g.a.a<x>(this) {
                    final /* synthetic */ g this$0;

                    {
                        this.this$0 = r1;
                    }

                    public final void invoke() {
                        this.this$0.f20398a.finish();
                    }
                });
            }
        }
    }

    static final class i extends kotlin.g.b.l implements m<ArrayList<VoucherFilterItem>, Integer, x> {
        final /* synthetic */ VoucherDealPagerActivity this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(VoucherDealPagerActivity voucherDealPagerActivity) {
            super(2);
            this.this$0 = voucherDealPagerActivity;
        }

        public final /* synthetic */ Object invoke(Object obj, Object obj2) {
            invoke((ArrayList<VoucherFilterItem>) (ArrayList) obj, ((Number) obj2).intValue());
            return x.f47997a;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0009, code lost:
            r5 = r5.f20641a;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void invoke(java.util.ArrayList<net.one97.paytm.common.entity.vipcashback.VoucherFilterItem> r4, int r5) {
            /*
                r3 = this;
                net.one97.paytm.v2.features.cashbackoffers.ui.VoucherDealPagerActivity r5 = r3.this$0
                net.one97.paytm.vipcashback.a.g r5 = r5.f20387e
                r0 = 0
                if (r5 == 0) goto L_0x0012
                java.util.ArrayList<net.one97.paytm.v2.features.cashbackoffers.ui.a> r5 = r5.f20641a
                if (r5 == 0) goto L_0x0012
                int r5 = r5.size()
                goto L_0x0013
            L_0x0012:
                r5 = 0
            L_0x0013:
                r1 = 1
                if (r5 <= r1) goto L_0x0050
                net.one97.paytm.v2.features.cashbackoffers.ui.VoucherDealPagerActivity r5 = r3.this$0
                net.one97.paytm.vipcashback.a.g r5 = r5.f20387e
                r2 = 0
                if (r5 == 0) goto L_0x002a
                java.util.ArrayList<net.one97.paytm.v2.features.cashbackoffers.ui.a> r5 = r5.f20641a
                if (r5 == 0) goto L_0x002a
                java.lang.Object r5 = r5.get(r0)
                net.one97.paytm.v2.features.cashbackoffers.ui.a r5 = (net.one97.paytm.v2.features.cashbackoffers.ui.a) r5
                goto L_0x002b
            L_0x002a:
                r5 = r2
            L_0x002b:
                boolean r0 = r5 instanceof net.one97.paytm.v2.features.cashbackoffers.ui.b
                if (r0 == 0) goto L_0x0034
                net.one97.paytm.v2.features.cashbackoffers.ui.b r5 = (net.one97.paytm.v2.features.cashbackoffers.ui.b) r5
                r5.a((java.util.ArrayList<net.one97.paytm.common.entity.vipcashback.VoucherFilterItem>) r4)
            L_0x0034:
                net.one97.paytm.v2.features.cashbackoffers.ui.VoucherDealPagerActivity r5 = r3.this$0
                net.one97.paytm.vipcashback.a.g r5 = r5.f20387e
                if (r5 == 0) goto L_0x0047
                java.util.ArrayList<net.one97.paytm.v2.features.cashbackoffers.ui.a> r5 = r5.f20641a
                if (r5 == 0) goto L_0x0047
                java.lang.Object r5 = r5.get(r1)
                r2 = r5
                net.one97.paytm.v2.features.cashbackoffers.ui.a r2 = (net.one97.paytm.v2.features.cashbackoffers.ui.a) r2
            L_0x0047:
                boolean r5 = r2 instanceof net.one97.paytm.v2.features.cashbackoffers.ui.b
                if (r5 == 0) goto L_0x0050
                net.one97.paytm.v2.features.cashbackoffers.ui.b r2 = (net.one97.paytm.v2.features.cashbackoffers.ui.b) r2
                r2.a((java.util.ArrayList<net.one97.paytm.common.entity.vipcashback.VoucherFilterItem>) r4)
            L_0x0050:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.v2.features.cashbackoffers.ui.VoucherDealPagerActivity.i.invoke(java.util.ArrayList, int):void");
        }
    }

    static final class k extends kotlin.g.b.l implements kotlin.g.a.a<Integer> {
        final /* synthetic */ VoucherDealPagerActivity this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k(VoucherDealPagerActivity voucherDealPagerActivity) {
            super(0);
            this.this$0 = voucherDealPagerActivity;
        }

        public final int invoke() {
            return this.this$0.f20389g - this.this$0.f20388f;
        }
    }

    static final class a extends kotlin.g.b.l implements kotlin.g.a.a<Integer> {
        final /* synthetic */ VoucherDealPagerActivity this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(VoucherDealPagerActivity voucherDealPagerActivity) {
            super(0);
            this.this$0 = voucherDealPagerActivity;
        }

        public final int invoke() {
            return this.this$0.j - this.this$0.f20391i;
        }
    }

    static final class l extends kotlin.g.b.l implements kotlin.g.a.a<Integer> {
        final /* synthetic */ VoucherDealPagerActivity this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        l(VoucherDealPagerActivity voucherDealPagerActivity) {
            super(0);
            this.this$0 = voucherDealPagerActivity;
        }

        public final int invoke() {
            return this.this$0.getResources().getDimensionPixelOffset(R.dimen.dimen_40dp);
        }
    }

    public final void onCreate(Bundle bundle) {
        Drawable background;
        LiveData<String> liveData;
        LiveData liveData2;
        net.one97.paytm.v2.features.cashbackoffers.b.c cVar;
        super.onCreate(bundle);
        setContentView(net.one97.paytm.vipcashback.R.layout.activity_voucher_deal_pager);
        this.f20388f = getResources().getDimensionPixelOffset(R.dimen.dimen_64dp);
        this.f20389g = getResources().getDimensionPixelOffset(R.dimen.dimen_160dp);
        this.f20391i = getResources().getDimensionPixelSize(R.dimen.dimen_16sp);
        this.j = getResources().getDimensionPixelSize(net.one97.paytm.vipcashback.R.dimen.dimen_32sp);
        ImageView imageView = (ImageView) a(net.one97.paytm.vipcashback.R.id.backArrowVoucher);
        if (imageView != null) {
            imageView.setOnClickListener(new b(this));
        }
        TextView textView = (TextView) a(net.one97.paytm.vipcashback.R.id.headerTitle);
        Drawable drawable = null;
        ViewGroup.LayoutParams layoutParams = textView != null ? textView.getLayoutParams() : null;
        if (layoutParams != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.setMargins(getResources().getDimensionPixelOffset(R.dimen.dimen_20dp), 0, getResources().getDimensionPixelOffset(R.dimen.dimen_120dp), getResources().getDimensionPixelOffset(R.dimen.dimen_14dp));
            TextView textView2 = (TextView) a(net.one97.paytm.vipcashback.R.id.headerTitle);
            if (textView2 != null) {
                textView2.setLayoutParams(marginLayoutParams);
            }
            TextView textView3 = (TextView) a(net.one97.paytm.vipcashback.R.id.headerTitle);
            if (textView3 != null) {
                textView3.setText(net.one97.paytm.vipcashback.R.string.voucher_deals_won);
            }
            ImageView imageView2 = (ImageView) a(net.one97.paytm.vipcashback.R.id.headerImage);
            if (imageView2 != null) {
                imageView2.setBackgroundColor(getResources().getColor(net.one97.paytm.vipcashback.R.color.color_07448e));
            }
            TextView textView4 = (TextView) a(net.one97.paytm.vipcashback.R.id.amountHeading);
            if (textView4 != null) {
                textView4.setVisibility(8);
            }
            TextView textView5 = (TextView) a(net.one97.paytm.vipcashback.R.id.singleHeading);
            if (textView5 != null) {
                textView5.setVisibility(8);
            }
            TextView textView6 = (TextView) a(net.one97.paytm.vipcashback.R.id.headerTitle);
            if (textView6 != null) {
                textView6.setVisibility(0);
            }
            this.m = (net.one97.paytm.v2.features.cashbackoffers.c.c) am.a((FragmentActivity) this).a(net.one97.paytm.v2.features.cashbackoffers.c.c.class);
            net.one97.paytm.v2.features.cashbackoffers.c.c cVar2 = this.m;
            if (cVar2 != null) {
                net.one97.paytm.v2.features.cashbackoffers.b.c cVar3 = new net.one97.paytm.v2.features.cashbackoffers.b.c(this);
                kotlin.g.b.k.c(cVar3, "merchantUserFilterRepo");
                cVar2.f20379d = cVar3;
            }
            this.f20386d = (ViewPager) findViewById(net.one97.paytm.vipcashback.R.id.viewPager);
            Context context = this;
            androidx.fragment.app.j supportFragmentManager = getSupportFragmentManager();
            kotlin.g.b.k.a((Object) supportFragmentManager, "supportFragmentManager");
            this.f20387e = new net.one97.paytm.vipcashback.a.g(context, supportFragmentManager);
            ViewPager viewPager = this.f20386d;
            int i2 = 1;
            if (viewPager != null) {
                viewPager.setOffscreenPageLimit(1);
            }
            ViewPager viewPager2 = this.f20386d;
            if (viewPager2 != null) {
                viewPager2.setAdapter(this.f20387e);
            }
            ViewPager viewPager3 = this.f20386d;
            if (viewPager3 != null) {
                viewPager3.addOnPageChangeListener(new f(this));
            }
            Intent intent = getIntent();
            Integer valueOf = intent != null ? Integer.valueOf(intent.getIntExtra("KEY_FRAGMENT", 1)) : null;
            if ((valueOf != null && valueOf.intValue() == 1) || valueOf == null || valueOf.intValue() != 2) {
                i2 = 0;
            }
            ViewPager viewPager4 = this.f20386d;
            if (viewPager4 != null) {
                viewPager4.setCurrentItem(i2);
            }
            net.one97.paytm.v2.features.cashbackoffers.c.c cVar4 = this.m;
            if (!(cVar4 == null || (cVar = cVar4.f20379d) == null)) {
                cVar.a(cVar4.f20376a);
            }
            net.one97.paytm.v2.features.cashbackoffers.c.c cVar5 = this.m;
            if (!(cVar5 == null || (liveData2 = cVar5.f20378c) == null)) {
                liveData2.observe(this, new g(this));
            }
            net.one97.paytm.v2.features.cashbackoffers.c.c cVar6 = this.m;
            if (!(cVar6 == null || (liveData = cVar6.f20380e) == null)) {
                liveData.observe(this, new h());
            }
            this.n = new i(this);
            ImageView imageView3 = (ImageView) a(net.one97.paytm.vipcashback.R.id.iv_filter);
            if (imageView3 != null) {
                imageView3.setOnClickListener(new j(this));
            }
            View a2 = a(net.one97.paytm.vipcashback.R.id.view_active);
            if (!(a2 == null || (background = a2.getBackground()) == null)) {
                drawable = background.mutate();
            }
            if (drawable != null) {
                ((GradientDrawable) drawable).setColor(androidx.core.content.b.c(context, net.one97.paytm.vipcashback.R.color.cashback_voucher_selector_color));
                ((ConstraintLayout) a(net.one97.paytm.vipcashback.R.id.cl_active_layout)).setOnClickListener(new d(this));
                ((ConstraintLayout) a(net.one97.paytm.vipcashback.R.id.cl_expired_layout)).setOnClickListener(new e(this));
                x.a aVar = new x.a();
                aVar.element = false;
                AppBarLayout appBarLayout = (AppBarLayout) a(net.one97.paytm.vipcashback.R.id.appBarLayoutVoucher);
                if (appBarLayout != null) {
                    appBarLayout.a((AppBarLayout.b) new c(this, aVar));
                    return;
                }
                return;
            }
            throw new u("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        }
        throw new u("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ VoucherDealPagerActivity f20392a;

        b(VoucherDealPagerActivity voucherDealPagerActivity) {
            this.f20392a = voucherDealPagerActivity;
        }

        public final void onClick(View view) {
            this.f20392a.onBackPressed();
        }
    }

    static final class c implements AppBarLayout.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ VoucherDealPagerActivity f20393a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x.a f20394b;

        c(VoucherDealPagerActivity voucherDealPagerActivity, x.a aVar) {
            this.f20393a = voucherDealPagerActivity;
            this.f20394b = aVar;
        }

        public final void onOffsetChanged(AppBarLayout appBarLayout, int i2) {
            if (!this.f20394b.element) {
                this.f20394b.element = true;
                TextView textView = (TextView) this.f20393a.a(net.one97.paytm.vipcashback.R.id.headerTitle);
                if (textView != null) {
                    float a2 = ((float) this.f20393a.j) - ((((float) ((Number) this.f20393a.k.getValue()).intValue()) / ((float) ((Number) this.f20393a.f20390h.getValue()).intValue())) * ((float) Math.abs(i2)));
                    Resources resources = this.f20393a.getResources();
                    kotlin.g.b.k.a((Object) resources, "resources");
                    textView.setTextSize(a2 / resources.getDisplayMetrics().scaledDensity);
                }
                TextView textView2 = (TextView) this.f20393a.a(net.one97.paytm.vipcashback.R.id.headerTitle);
                if (textView2 != null) {
                    textView2.setTranslationX(((float) ((Number) this.f20393a.l.getValue()).intValue()) * (((float) Math.abs(i2)) / ((float) ((Number) this.f20393a.f20390h.getValue()).intValue())));
                }
                int abs = Math.abs(i2);
                kotlin.g.b.k.a((Object) appBarLayout, "appBarLayout");
                ViewGroup.LayoutParams layoutParams = null;
                if (abs == appBarLayout.getTotalScrollRange()) {
                    TextView textView3 = (TextView) this.f20393a.a(net.one97.paytm.vipcashback.R.id.headerTitle);
                    if (textView3 != null) {
                        textView3.setTranslationX((((float) ((Number) this.f20393a.l.getValue()).intValue()) * (((float) Math.abs(i2)) / ((float) ((Number) this.f20393a.f20390h.getValue()).intValue()))) - this.f20393a.getResources().getDimension(net.one97.paytm.vipcashback.R.dimen.dimen_10dp));
                    }
                    TextView textView4 = (TextView) this.f20393a.a(net.one97.paytm.vipcashback.R.id.headerTitle);
                    ViewGroup.LayoutParams layoutParams2 = textView4 != null ? textView4.getLayoutParams() : null;
                    if (layoutParams2 != null) {
                        ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin = this.f20393a.getResources().getDimensionPixelOffset(R.dimen.dimen_22dp);
                    } else {
                        throw new u("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                    }
                }
                if (i2 == 0) {
                    TextView textView5 = (TextView) this.f20393a.a(net.one97.paytm.vipcashback.R.id.headerTitle);
                    if (textView5 != null) {
                        layoutParams = textView5.getLayoutParams();
                    }
                    if (layoutParams != null) {
                        ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = this.f20393a.getResources().getDimensionPixelOffset(R.dimen.dimen_14dp);
                    } else {
                        throw new u("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                    }
                }
                this.f20394b.element = false;
            }
        }
    }

    public static final class f implements ViewPager.e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ VoucherDealPagerActivity f20397a;

        public final void onPageScrollStateChanged(int i2) {
        }

        public final void onPageScrolled(int i2, float f2, int i3) {
        }

        f(VoucherDealPagerActivity voucherDealPagerActivity) {
            this.f20397a = voucherDealPagerActivity;
        }

        public final void onPageSelected(int i2) {
            VoucherDealPagerActivity.a(this.f20397a, i2);
        }
    }

    public static final class h implements z<String> {
        h() {
        }

        public final /* synthetic */ void onChanged(Object obj) {
            System.out.println((String) obj);
        }
    }

    static final class j implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ VoucherDealPagerActivity f20399a;

        j(VoucherDealPagerActivity voucherDealPagerActivity) {
            this.f20399a = voucherDealPagerActivity;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0012, code lost:
            r3 = r3.f20641a;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onClick(android.view.View r3) {
            /*
                r2 = this;
                net.one97.paytm.vipcashback.f.d$a r0 = net.one97.paytm.vipcashback.f.d.f20859a
                java.lang.String r0 = "it"
                kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r0)
                net.one97.paytm.vipcashback.f.d.a.a((android.view.View) r3)
                net.one97.paytm.v2.features.cashbackoffers.ui.VoucherDealPagerActivity r3 = r2.f20399a
                net.one97.paytm.vipcashback.a.g r3 = r3.f20387e
                if (r3 == 0) goto L_0x001b
                java.util.ArrayList<net.one97.paytm.v2.features.cashbackoffers.ui.a> r3 = r3.f20641a
                if (r3 == 0) goto L_0x001b
                int r3 = r3.size()
                goto L_0x001c
            L_0x001b:
                r3 = 0
            L_0x001c:
                if (r3 <= 0) goto L_0x0088
                net.one97.paytm.v2.features.cashbackoffers.ui.VoucherDealPagerActivity r3 = r2.f20399a
                net.one97.paytm.vipcashback.a.g r3 = r3.f20387e
                r0 = 0
                if (r3 == 0) goto L_0x0041
                java.util.ArrayList<net.one97.paytm.v2.features.cashbackoffers.ui.a> r3 = r3.f20641a
                if (r3 == 0) goto L_0x0041
                net.one97.paytm.v2.features.cashbackoffers.ui.VoucherDealPagerActivity r1 = r2.f20399a
                androidx.viewpager.widget.ViewPager r1 = r1.f20386d
                if (r1 != 0) goto L_0x0036
                kotlin.g.b.k.a()
            L_0x0036:
                int r1 = r1.getCurrentItem()
                java.lang.Object r3 = r3.get(r1)
                net.one97.paytm.v2.features.cashbackoffers.ui.a r3 = (net.one97.paytm.v2.features.cashbackoffers.ui.a) r3
                goto L_0x0042
            L_0x0041:
                r3 = r0
            L_0x0042:
                boolean r1 = r3 instanceof net.one97.paytm.v2.features.cashbackoffers.ui.b
                if (r1 == 0) goto L_0x0088
                net.one97.paytm.v2.features.cashbackoffers.ui.VoucherDealPagerActivity r1 = r2.f20399a
                net.one97.paytm.v2.features.cashbackoffers.c.c r1 = r1.m
                if (r1 == 0) goto L_0x0059
                androidx.lifecycle.y<java.util.ArrayList<net.one97.paytm.common.entity.vipcashback.Facets>> r1 = r1.f20377b
                if (r1 == 0) goto L_0x0059
                java.lang.Object r1 = r1.getValue()
                java.util.ArrayList r1 = (java.util.ArrayList) r1
                goto L_0x005a
            L_0x0059:
                r1 = r0
            L_0x005a:
                if (r1 == 0) goto L_0x0088
                net.one97.paytm.v2.features.cashbackoffers.ui.b r3 = (net.one97.paytm.v2.features.cashbackoffers.ui.b) r3
                net.one97.paytm.v2.features.cashbackoffers.ui.VoucherDealPagerActivity r1 = r2.f20399a
                net.one97.paytm.v2.features.cashbackoffers.c.c r1 = r1.m
                if (r1 == 0) goto L_0x0070
                androidx.lifecycle.y<java.util.ArrayList<net.one97.paytm.common.entity.vipcashback.Facets>> r1 = r1.f20377b
                if (r1 == 0) goto L_0x0070
                java.lang.Object r0 = r1.getValue()
                java.util.ArrayList r0 = (java.util.ArrayList) r0
            L_0x0070:
                if (r0 != 0) goto L_0x0075
                kotlin.g.b.k.a()
            L_0x0075:
                java.lang.String r1 = "voucherDealPagerViewModel?.filterData?.value!!"
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
                net.one97.paytm.v2.features.cashbackoffers.ui.VoucherDealPagerActivity r1 = r2.f20399a
                kotlin.g.a.m r1 = r1.n
                if (r1 != 0) goto L_0x0085
                kotlin.g.b.k.a()
            L_0x0085:
                r3.a(r0, r1)
            L_0x0088:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.v2.features.cashbackoffers.ui.VoucherDealPagerActivity.j.onClick(android.view.View):void");
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ VoucherDealPagerActivity f20395a;

        d(VoucherDealPagerActivity voucherDealPagerActivity) {
            this.f20395a = voucherDealPagerActivity;
        }

        public final void onClick(View view) {
            VoucherDealPagerActivity voucherDealPagerActivity = this.f20395a;
            VoucherDealPagerActivity.a(voucherDealPagerActivity, voucherDealPagerActivity.f20384b);
        }
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ VoucherDealPagerActivity f20396a;

        e(VoucherDealPagerActivity voucherDealPagerActivity) {
            this.f20396a = voucherDealPagerActivity;
        }

        public final void onClick(View view) {
            VoucherDealPagerActivity voucherDealPagerActivity = this.f20396a;
            VoucherDealPagerActivity.a(voucherDealPagerActivity, voucherDealPagerActivity.f20385c);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0059, code lost:
        r0 = r0.getBackground();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void a(net.one97.paytm.v2.features.cashbackoffers.ui.VoucherDealPagerActivity r5, int r6) {
        /*
            int r0 = r5.f20384b
            java.lang.String r1 = "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable"
            r2 = 0
            if (r6 != r0) goto L_0x00a8
            int r0 = net.one97.paytm.vipcashback.R.id.tv_active
            android.view.View r0 = r5.a((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            if (r0 == 0) goto L_0x001d
            r3 = r5
            android.content.Context r3 = (android.content.Context) r3
            int r4 = net.one97.paytm.vipcashback.R.color.color_1d2f54
            int r3 = androidx.core.content.b.c(r3, r4)
            r0.setTextColor(r3)
        L_0x001d:
            int r0 = net.one97.paytm.vipcashback.R.id.tv_active
            android.view.View r0 = r5.a((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            if (r0 == 0) goto L_0x002c
            android.graphics.Typeface r3 = android.graphics.Typeface.DEFAULT_BOLD
            r0.setTypeface(r3)
        L_0x002c:
            int r0 = net.one97.paytm.vipcashback.R.id.tv_expired
            android.view.View r0 = r5.a((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            if (r0 == 0) goto L_0x003b
            android.graphics.Typeface r3 = android.graphics.Typeface.DEFAULT
            r0.setTypeface(r3)
        L_0x003b:
            int r0 = net.one97.paytm.vipcashback.R.id.tv_expired
            android.view.View r0 = r5.a((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            if (r0 == 0) goto L_0x0051
            r3 = r5
            android.content.Context r3 = (android.content.Context) r3
            int r4 = net.one97.paytm.vipcashback.R.color.cashback_voucher_grey_color
            int r3 = androidx.core.content.b.c(r3, r4)
            r0.setTextColor(r3)
        L_0x0051:
            int r0 = net.one97.paytm.vipcashback.R.id.view_active
            android.view.View r0 = r5.a((int) r0)
            if (r0 == 0) goto L_0x0064
            android.graphics.drawable.Drawable r0 = r0.getBackground()
            if (r0 == 0) goto L_0x0064
            android.graphics.drawable.Drawable r0 = r0.mutate()
            goto L_0x0065
        L_0x0064:
            r0 = r2
        L_0x0065:
            if (r0 == 0) goto L_0x00a2
            android.graphics.drawable.GradientDrawable r0 = (android.graphics.drawable.GradientDrawable) r0
            r3 = r5
            android.content.Context r3 = (android.content.Context) r3
            int r4 = net.one97.paytm.vipcashback.R.color.cashback_voucher_selector_color
            int r4 = androidx.core.content.b.c(r3, r4)
            r0.setColor(r4)
            int r0 = net.one97.paytm.vipcashback.R.id.view_expired
            android.view.View r0 = r5.a((int) r0)
            if (r0 == 0) goto L_0x0087
            android.graphics.drawable.Drawable r0 = r0.getBackground()
            if (r0 == 0) goto L_0x0087
            android.graphics.drawable.Drawable r2 = r0.mutate()
        L_0x0087:
            if (r2 == 0) goto L_0x009c
            android.graphics.drawable.GradientDrawable r2 = (android.graphics.drawable.GradientDrawable) r2
            int r0 = net.one97.paytm.vipcashback.R.color.white
            int r0 = androidx.core.content.b.c(r3, r0)
            r2.setColor(r0)
            androidx.viewpager.widget.ViewPager r5 = r5.f20386d
            if (r5 == 0) goto L_0x009b
            r5.setCurrentItem(r6)
        L_0x009b:
            return
        L_0x009c:
            kotlin.u r5 = new kotlin.u
            r5.<init>(r1)
            throw r5
        L_0x00a2:
            kotlin.u r5 = new kotlin.u
            r5.<init>(r1)
            throw r5
        L_0x00a8:
            int r0 = r5.f20385c
            if (r6 != r0) goto L_0x014d
            int r0 = net.one97.paytm.vipcashback.R.id.tv_active
            android.view.View r0 = r5.a((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            if (r0 == 0) goto L_0x00c2
            r3 = r5
            android.content.Context r3 = (android.content.Context) r3
            int r4 = net.one97.paytm.vipcashback.R.color.cashback_voucher_grey_color
            int r3 = androidx.core.content.b.c(r3, r4)
            r0.setTextColor(r3)
        L_0x00c2:
            int r0 = net.one97.paytm.vipcashback.R.id.tv_expired
            android.view.View r0 = r5.a((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            if (r0 == 0) goto L_0x00d8
            r3 = r5
            android.content.Context r3 = (android.content.Context) r3
            int r4 = net.one97.paytm.vipcashback.R.color.color_1d2f54
            int r3 = androidx.core.content.b.c(r3, r4)
            r0.setTextColor(r3)
        L_0x00d8:
            int r0 = net.one97.paytm.vipcashback.R.id.tv_active
            android.view.View r0 = r5.a((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            if (r0 == 0) goto L_0x00e7
            android.graphics.Typeface r3 = android.graphics.Typeface.DEFAULT
            r0.setTypeface(r3)
        L_0x00e7:
            int r0 = net.one97.paytm.vipcashback.R.id.tv_expired
            android.view.View r0 = r5.a((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            if (r0 == 0) goto L_0x00f6
            android.graphics.Typeface r3 = android.graphics.Typeface.DEFAULT_BOLD
            r0.setTypeface(r3)
        L_0x00f6:
            int r0 = net.one97.paytm.vipcashback.R.id.view_active
            android.view.View r0 = r5.a((int) r0)
            if (r0 == 0) goto L_0x0109
            android.graphics.drawable.Drawable r0 = r0.getBackground()
            if (r0 == 0) goto L_0x0109
            android.graphics.drawable.Drawable r0 = r0.mutate()
            goto L_0x010a
        L_0x0109:
            r0 = r2
        L_0x010a:
            if (r0 == 0) goto L_0x0147
            android.graphics.drawable.GradientDrawable r0 = (android.graphics.drawable.GradientDrawable) r0
            r3 = r5
            android.content.Context r3 = (android.content.Context) r3
            int r4 = net.one97.paytm.vipcashback.R.color.white
            int r4 = androidx.core.content.b.c(r3, r4)
            r0.setColor(r4)
            int r0 = net.one97.paytm.vipcashback.R.id.view_expired
            android.view.View r0 = r5.a((int) r0)
            if (r0 == 0) goto L_0x012c
            android.graphics.drawable.Drawable r0 = r0.getBackground()
            if (r0 == 0) goto L_0x012c
            android.graphics.drawable.Drawable r2 = r0.mutate()
        L_0x012c:
            if (r2 == 0) goto L_0x0141
            android.graphics.drawable.GradientDrawable r2 = (android.graphics.drawable.GradientDrawable) r2
            int r0 = net.one97.paytm.vipcashback.R.color.cashback_voucher_selector_color
            int r0 = androidx.core.content.b.c(r3, r0)
            r2.setColor(r0)
            androidx.viewpager.widget.ViewPager r5 = r5.f20386d
            if (r5 == 0) goto L_0x014d
            r5.setCurrentItem(r6)
            return
        L_0x0141:
            kotlin.u r5 = new kotlin.u
            r5.<init>(r1)
            throw r5
        L_0x0147:
            kotlin.u r5 = new kotlin.u
            r5.<init>(r1)
            throw r5
        L_0x014d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.v2.features.cashbackoffers.ui.VoucherDealPagerActivity.a(net.one97.paytm.v2.features.cashbackoffers.ui.VoucherDealPagerActivity, int):void");
    }
}
