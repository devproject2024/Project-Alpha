package com.google.android.material.tabs;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.ae;
import androidx.core.g.e;
import androidx.core.h.a.c;
import androidx.core.h.s;
import androidx.core.h.u;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.R;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.internal.k;
import com.google.android.material.internal.q;
import com.google.android.material.k.i;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

@ViewPager.a
public class TabLayout extends HorizontalScrollView {
    private static final int y = R.style.Widget_Design_TabLayout;
    private static final e.a<f> z = new e.c(16);
    private final ArrayList<f> A;
    private f B;
    /* access modifiers changed from: private */
    public final RectF C;
    private final int D;
    private final int E;
    private int F;
    private b G;
    private final ArrayList<b> H;
    private b I;
    private ValueAnimator J;
    private androidx.viewpager.widget.a K;
    private DataSetObserver L;
    private g M;
    private a N;
    private boolean O;
    private final e.a<TabView> P;

    /* renamed from: a  reason: collision with root package name */
    final e f36723a;

    /* renamed from: b  reason: collision with root package name */
    int f36724b;

    /* renamed from: c  reason: collision with root package name */
    int f36725c;

    /* renamed from: d  reason: collision with root package name */
    int f36726d;

    /* renamed from: e  reason: collision with root package name */
    int f36727e;

    /* renamed from: f  reason: collision with root package name */
    int f36728f;

    /* renamed from: g  reason: collision with root package name */
    ColorStateList f36729g;

    /* renamed from: h  reason: collision with root package name */
    ColorStateList f36730h;

    /* renamed from: i  reason: collision with root package name */
    ColorStateList f36731i;
    Drawable j;
    PorterDuff.Mode k;
    float l;
    float m;
    final int n;
    int o;
    protected final int p;
    int q;
    int r;
    int s;
    int t;
    boolean u;
    boolean v;
    boolean w;
    ViewPager x;

    @Deprecated
    public interface b<T extends f> {
        void onTabReselected(T t);

        void onTabSelected(T t);

        void onTabUnselected(T t);
    }

    public interface c extends b<f> {
    }

    public TabLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public TabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.tabStyle);
    }

    /* JADX INFO: finally extract failed */
    public TabLayout(Context context, AttributeSet attributeSet, int i2) {
        super(com.google.android.material.theme.a.a.a(context, attributeSet, i2, y), attributeSet, i2);
        this.A = new ArrayList<>();
        this.C = new RectF();
        this.o = Integer.MAX_VALUE;
        this.H = new ArrayList<>();
        this.P = new e.b(12);
        Context context2 = getContext();
        setHorizontalScrollBarEnabled(false);
        this.f36723a = new e(context2);
        super.addView(this.f36723a, 0, new FrameLayout.LayoutParams(-2, -1));
        TypedArray a2 = k.a(context2, attributeSet, R.styleable.TabLayout, i2, y, R.styleable.TabLayout_tabTextAppearance);
        if (getBackground() instanceof ColorDrawable) {
            com.google.android.material.k.h hVar = new com.google.android.material.k.h();
            hVar.g(ColorStateList.valueOf(((ColorDrawable) getBackground()).getColor()));
            hVar.a(context2);
            hVar.r(u.v(this));
            u.a((View) this, (Drawable) hVar);
        }
        this.f36723a.b(a2.getDimensionPixelSize(R.styleable.TabLayout_tabIndicatorHeight, -1));
        this.f36723a.a(a2.getColor(R.styleable.TabLayout_tabIndicatorColor, 0));
        setSelectedTabIndicator(com.google.android.material.h.c.b(context2, a2, R.styleable.TabLayout_tabIndicator));
        setSelectedTabIndicatorGravity(a2.getInt(R.styleable.TabLayout_tabIndicatorGravity, 0));
        setTabIndicatorFullWidth(a2.getBoolean(R.styleable.TabLayout_tabIndicatorFullWidth, true));
        int dimensionPixelSize = a2.getDimensionPixelSize(R.styleable.TabLayout_tabPadding, 0);
        this.f36727e = dimensionPixelSize;
        this.f36726d = dimensionPixelSize;
        this.f36725c = dimensionPixelSize;
        this.f36724b = dimensionPixelSize;
        this.f36724b = a2.getDimensionPixelSize(R.styleable.TabLayout_tabPaddingStart, this.f36724b);
        this.f36725c = a2.getDimensionPixelSize(R.styleable.TabLayout_tabPaddingTop, this.f36725c);
        this.f36726d = a2.getDimensionPixelSize(R.styleable.TabLayout_tabPaddingEnd, this.f36726d);
        this.f36727e = a2.getDimensionPixelSize(R.styleable.TabLayout_tabPaddingBottom, this.f36727e);
        this.f36728f = a2.getResourceId(R.styleable.TabLayout_tabTextAppearance, R.style.TextAppearance_Design_Tab);
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(this.f36728f, androidx.appcompat.R.styleable.TextAppearance);
        try {
            this.l = (float) obtainStyledAttributes.getDimensionPixelSize(androidx.appcompat.R.styleable.TextAppearance_android_textSize, 0);
            this.f36729g = com.google.android.material.h.c.a(context2, obtainStyledAttributes, androidx.appcompat.R.styleable.TextAppearance_android_textColor);
            obtainStyledAttributes.recycle();
            if (a2.hasValue(R.styleable.TabLayout_tabTextColor)) {
                this.f36729g = com.google.android.material.h.c.a(context2, a2, R.styleable.TabLayout_tabTextColor);
            }
            if (a2.hasValue(R.styleable.TabLayout_tabSelectedTextColor)) {
                this.f36729g = a(this.f36729g.getDefaultColor(), a2.getColor(R.styleable.TabLayout_tabSelectedTextColor, 0));
            }
            this.f36730h = com.google.android.material.h.c.a(context2, a2, R.styleable.TabLayout_tabIconTint);
            this.k = q.a(a2.getInt(R.styleable.TabLayout_tabIconTintMode, -1), (PorterDuff.Mode) null);
            this.f36731i = com.google.android.material.h.c.a(context2, a2, R.styleable.TabLayout_tabRippleColor);
            this.r = a2.getInt(R.styleable.TabLayout_tabIndicatorAnimationDuration, 300);
            this.D = a2.getDimensionPixelSize(R.styleable.TabLayout_tabMinWidth, -1);
            this.E = a2.getDimensionPixelSize(R.styleable.TabLayout_tabMaxWidth, -1);
            this.n = a2.getResourceId(R.styleable.TabLayout_tabBackground, 0);
            this.F = a2.getDimensionPixelSize(R.styleable.TabLayout_tabContentStart, 0);
            this.t = a2.getInt(R.styleable.TabLayout_tabMode, 1);
            this.q = a2.getInt(R.styleable.TabLayout_tabGravity, 0);
            this.u = a2.getBoolean(R.styleable.TabLayout_tabInlineLabel, false);
            this.w = a2.getBoolean(R.styleable.TabLayout_tabUnboundedRipple, false);
            a2.recycle();
            Resources resources = getResources();
            this.m = (float) resources.getDimensionPixelSize(R.dimen.design_tab_text_size_2line);
            this.p = resources.getDimensionPixelSize(R.dimen.design_tab_scrollable_min_width);
            g();
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    public void setSelectedTabIndicatorColor(int i2) {
        this.f36723a.a(i2);
    }

    @Deprecated
    public void setSelectedTabIndicatorHeight(int i2) {
        this.f36723a.b(i2);
    }

    public void setScrollPosition(int i2, float f2, boolean z2) {
        setScrollPosition(i2, f2, z2, true);
    }

    public void setScrollPosition(int i2, float f2, boolean z2, boolean z3) {
        int round = Math.round(((float) i2) + f2);
        if (round >= 0 && round < this.f36723a.getChildCount()) {
            if (z3) {
                e eVar = this.f36723a;
                if (eVar.f36751e != null && eVar.f36751e.isRunning()) {
                    eVar.f36751e.cancel();
                }
                eVar.f36747a = i2;
                eVar.f36748b = f2;
                eVar.a();
            }
            ValueAnimator valueAnimator = this.J;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.J.cancel();
            }
            scrollTo(a(i2, f2), 0);
            if (z2) {
                setSelectedTabView(round);
            }
        }
    }

    public final void a(f fVar) {
        a(fVar, this.A.isEmpty());
    }

    public final void a(f fVar, boolean z2) {
        a(fVar, this.A.size(), z2);
    }

    private void a(f fVar, int i2, boolean z2) {
        if (fVar.f36768h == this) {
            a(fVar, i2);
            c(fVar);
            if (z2) {
                fVar.d();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
    }

    private void a(TabItem tabItem) {
        f a2 = a();
        if (tabItem.f36720a != null) {
            a2.a(tabItem.f36720a);
        }
        if (tabItem.f36721b != null) {
            a2.a(tabItem.f36721b);
        }
        if (tabItem.f36722c != 0) {
            a2.a(LayoutInflater.from(a2.f36769i.getContext()).inflate(tabItem.f36722c, a2.f36769i, false));
        }
        if (!TextUtils.isEmpty(tabItem.getContentDescription())) {
            a2.f36764d = tabItem.getContentDescription();
            a2.f();
        }
        a(a2);
    }

    @Deprecated
    public void setOnTabSelectedListener(c cVar) {
        setOnTabSelectedListener((b) cVar);
    }

    @Deprecated
    public void setOnTabSelectedListener(b bVar) {
        b bVar2 = this.G;
        if (bVar2 != null) {
            b(bVar2);
        }
        this.G = bVar;
        if (bVar != null) {
            a(bVar);
        }
    }

    public final void a(c cVar) {
        a((b) cVar);
    }

    @Deprecated
    public final void a(b bVar) {
        if (!this.H.contains(bVar)) {
            this.H.add(bVar);
        }
    }

    @Deprecated
    public final void b(b bVar) {
        this.H.remove(bVar);
    }

    public int getTabCount() {
        return this.A.size();
    }

    public final f a(int i2) {
        if (i2 < 0 || i2 >= getTabCount()) {
            return null;
        }
        return this.A.get(i2);
    }

    public int getSelectedTabPosition() {
        f fVar = this.B;
        if (fVar != null) {
            return fVar.f36765e;
        }
        return -1;
    }

    public final void b() {
        int childCount = this.f36723a.getChildCount();
        while (true) {
            childCount--;
            if (childCount < 0) {
                break;
            }
            TabView tabView = (TabView) this.f36723a.getChildAt(childCount);
            this.f36723a.removeViewAt(childCount);
            if (tabView != null) {
                tabView.setTab((f) null);
                tabView.setSelected(false);
                this.P.a(tabView);
            }
            requestLayout();
        }
        Iterator<f> it2 = this.A.iterator();
        while (it2.hasNext()) {
            f next = it2.next();
            it2.remove();
            next.f36768h = null;
            next.f36769i = null;
            next.f36761a = null;
            next.f36762b = null;
            next.f36763c = null;
            next.f36764d = null;
            next.f36765e = -1;
            next.f36766f = null;
            z.a(next);
        }
        this.B = null;
    }

    public void setTabMode(int i2) {
        if (i2 != this.t) {
            this.t = i2;
            g();
        }
    }

    public int getTabMode() {
        return this.t;
    }

    public void setTabGravity(int i2) {
        if (this.q != i2) {
            this.q = i2;
            g();
        }
    }

    public int getTabGravity() {
        return this.q;
    }

    public void setSelectedTabIndicatorGravity(int i2) {
        if (this.s != i2) {
            this.s = i2;
            u.g(this.f36723a);
        }
    }

    public int getTabIndicatorGravity() {
        return this.s;
    }

    public void setTabIndicatorFullWidth(boolean z2) {
        this.v = z2;
        u.g(this.f36723a);
    }

    public void setInlineLabel(boolean z2) {
        if (this.u != z2) {
            this.u = z2;
            for (int i2 = 0; i2 < this.f36723a.getChildCount(); i2++) {
                View childAt = this.f36723a.getChildAt(i2);
                if (childAt instanceof TabView) {
                    TabView tabView = (TabView) childAt;
                    tabView.setOrientation(TabLayout.this.u ^ true ? 1 : 0);
                    if (tabView.f36735c == null && tabView.f36736d == null) {
                        tabView.a(tabView.f36733a, tabView.f36734b);
                    } else {
                        tabView.a(tabView.f36735c, tabView.f36736d);
                    }
                }
            }
            g();
        }
    }

    public void setInlineLabelResource(int i2) {
        setInlineLabel(getResources().getBoolean(i2));
    }

    public void setUnboundedRipple(boolean z2) {
        if (this.w != z2) {
            this.w = z2;
            for (int i2 = 0; i2 < this.f36723a.getChildCount(); i2++) {
                View childAt = this.f36723a.getChildAt(i2);
                if (childAt instanceof TabView) {
                    ((TabView) childAt).a(getContext());
                }
            }
        }
    }

    public void setUnboundedRippleResource(int i2) {
        setUnboundedRipple(getResources().getBoolean(i2));
    }

    public void setTabTextColors(ColorStateList colorStateList) {
        if (this.f36729g != colorStateList) {
            this.f36729g = colorStateList;
            d();
        }
    }

    public ColorStateList getTabTextColors() {
        return this.f36729g;
    }

    public void setTabTextColors(int i2, int i3) {
        setTabTextColors(a(i2, i3));
    }

    public void setTabIconTint(ColorStateList colorStateList) {
        if (this.f36730h != colorStateList) {
            this.f36730h = colorStateList;
            d();
        }
    }

    public void setTabIconTintResource(int i2) {
        setTabIconTint(androidx.appcompat.a.a.a.a(getContext(), i2));
    }

    public ColorStateList getTabIconTint() {
        return this.f36730h;
    }

    public ColorStateList getTabRippleColor() {
        return this.f36731i;
    }

    public void setTabRippleColor(ColorStateList colorStateList) {
        if (this.f36731i != colorStateList) {
            this.f36731i = colorStateList;
            for (int i2 = 0; i2 < this.f36723a.getChildCount(); i2++) {
                View childAt = this.f36723a.getChildAt(i2);
                if (childAt instanceof TabView) {
                    ((TabView) childAt).a(getContext());
                }
            }
        }
    }

    public void setTabRippleColorResource(int i2) {
        setTabRippleColor(androidx.appcompat.a.a.a.a(getContext(), i2));
    }

    public Drawable getTabSelectedIndicator() {
        return this.j;
    }

    public void setSelectedTabIndicator(Drawable drawable) {
        if (this.j != drawable) {
            this.j = drawable;
            u.g(this.f36723a);
        }
    }

    public void setSelectedTabIndicator(int i2) {
        if (i2 != 0) {
            setSelectedTabIndicator(androidx.appcompat.a.a.a.b(getContext(), i2));
        } else {
            setSelectedTabIndicator((Drawable) null);
        }
    }

    public void setupWithViewPager(ViewPager viewPager) {
        setupWithViewPager(viewPager, true);
    }

    public void setupWithViewPager(ViewPager viewPager, boolean z2) {
        a(viewPager, z2, false);
    }

    private void a(ViewPager viewPager, boolean z2, boolean z3) {
        ViewPager viewPager2 = this.x;
        if (viewPager2 != null) {
            g gVar = this.M;
            if (gVar != null) {
                viewPager2.removeOnPageChangeListener(gVar);
            }
            a aVar = this.N;
            if (aVar != null) {
                this.x.removeOnAdapterChangeListener(aVar);
            }
        }
        b bVar = this.I;
        if (bVar != null) {
            b(bVar);
            this.I = null;
        }
        if (viewPager != null) {
            this.x = viewPager;
            if (this.M == null) {
                this.M = new g(this);
            }
            this.M.a();
            viewPager.addOnPageChangeListener(this.M);
            this.I = new h(viewPager);
            a(this.I);
            androidx.viewpager.widget.a adapter = viewPager.getAdapter();
            if (adapter != null) {
                a(adapter, z2);
            }
            if (this.N == null) {
                this.N = new a();
            }
            a aVar2 = this.N;
            aVar2.f36744a = z2;
            viewPager.addOnAdapterChangeListener(aVar2);
            setScrollPosition(viewPager.getCurrentItem(), 0.0f, true);
        } else {
            this.x = null;
            a((androidx.viewpager.widget.a) null, false);
        }
        this.O = z3;
    }

    @Deprecated
    public void setTabsFromPagerAdapter(androidx.viewpager.widget.a aVar) {
        a(aVar, false);
    }

    public boolean shouldDelayChildPressedState() {
        return getTabScrollRange() > 0;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        i.a((View) this);
        if (this.x == null) {
            ViewParent parent = getParent();
            if (parent instanceof ViewPager) {
                a((ViewPager) parent, true, true);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.O) {
            setupWithViewPager((ViewPager) null);
            this.O = false;
        }
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.f36723a.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    /* access modifiers changed from: package-private */
    public final void a(androidx.viewpager.widget.a aVar, boolean z2) {
        DataSetObserver dataSetObserver;
        androidx.viewpager.widget.a aVar2 = this.K;
        if (!(aVar2 == null || (dataSetObserver = this.L) == null)) {
            aVar2.unregisterDataSetObserver(dataSetObserver);
        }
        this.K = aVar;
        if (z2 && aVar != null) {
            if (this.L == null) {
                this.L = new d();
            }
            aVar.registerDataSetObserver(this.L);
        }
        c();
    }

    /* access modifiers changed from: package-private */
    public final void c() {
        int currentItem;
        b();
        androidx.viewpager.widget.a aVar = this.K;
        if (aVar != null) {
            int count = aVar.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                a(a().a(this.K.getPageTitle(i2)), false);
            }
            ViewPager viewPager = this.x;
            if (viewPager != null && count > 0 && (currentItem = viewPager.getCurrentItem()) != getSelectedTabPosition() && currentItem < getTabCount()) {
                b(a(currentItem), true);
            }
        }
    }

    private void d() {
        int size = this.A.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.A.get(i2).f();
        }
    }

    private void c(f fVar) {
        TabView tabView = fVar.f36769i;
        tabView.setSelected(false);
        tabView.setActivated(false);
        this.f36723a.addView(tabView, fVar.f36765e, e());
    }

    public void addView(View view) {
        a(view);
    }

    public void addView(View view, int i2) {
        a(view);
    }

    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        a(view);
    }

    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        a(view);
    }

    private void a(View view) {
        if (view instanceof TabItem) {
            a((TabItem) view);
            return;
        }
        throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
    }

    private LinearLayout.LayoutParams e() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        a(layoutParams);
        return layoutParams;
    }

    private void a(LinearLayout.LayoutParams layoutParams) {
        if (this.t == 1 && this.q == 0) {
            layoutParams.width = 0;
            layoutParams.weight = 1.0f;
            return;
        }
        layoutParams.width = -2;
        layoutParams.weight = 0.0f;
    }

    public void setElevation(float f2) {
        super.setElevation(f2);
        i.a((View) this, f2);
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        androidx.core.h.a.c.a(accessibilityNodeInfo).a((Object) c.b.a(1, getTabCount(), false, 1));
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        for (int i2 = 0; i2 < this.f36723a.getChildCount(); i2++) {
            View childAt = this.f36723a.getChildAt(i2);
            if (childAt instanceof TabView) {
                TabView.a((TabView) childAt, canvas);
            }
        }
        super.onDraw(canvas);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0073, code lost:
        if (r0 != 2) goto L_0x008d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x007e, code lost:
        if (r7.getMeasuredWidth() != getMeasuredWidth()) goto L_0x0080;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0080, code lost:
        r4 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x008a, code lost:
        if (r7.getMeasuredWidth() < getMeasuredWidth()) goto L_0x0080;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r7, int r8) {
        /*
            r6 = this;
            android.content.Context r0 = r6.getContext()
            int r1 = r6.getDefaultHeight()
            float r0 = com.google.android.material.internal.q.a((android.content.Context) r0, (int) r1)
            int r0 = java.lang.Math.round(r0)
            int r1 = android.view.View.MeasureSpec.getMode(r8)
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = 1073741824(0x40000000, float:2.0)
            r4 = 0
            r5 = 1
            if (r1 == r2) goto L_0x002e
            if (r1 == 0) goto L_0x001f
            goto L_0x0041
        L_0x001f:
            int r8 = r6.getPaddingTop()
            int r0 = r0 + r8
            int r8 = r6.getPaddingBottom()
            int r0 = r0 + r8
            int r8 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r3)
            goto L_0x0041
        L_0x002e:
            int r1 = r6.getChildCount()
            if (r1 != r5) goto L_0x0041
            int r1 = android.view.View.MeasureSpec.getSize(r8)
            if (r1 < r0) goto L_0x0041
            android.view.View r1 = r6.getChildAt(r4)
            r1.setMinimumHeight(r0)
        L_0x0041:
            int r0 = android.view.View.MeasureSpec.getSize(r7)
            int r1 = android.view.View.MeasureSpec.getMode(r7)
            if (r1 == 0) goto L_0x005f
            int r1 = r6.E
            if (r1 <= 0) goto L_0x0050
            goto L_0x005d
        L_0x0050:
            float r0 = (float) r0
            android.content.Context r1 = r6.getContext()
            r2 = 56
            float r1 = com.google.android.material.internal.q.a((android.content.Context) r1, (int) r2)
            float r0 = r0 - r1
            int r1 = (int) r0
        L_0x005d:
            r6.o = r1
        L_0x005f:
            super.onMeasure(r7, r8)
            int r7 = r6.getChildCount()
            if (r7 != r5) goto L_0x00ad
            android.view.View r7 = r6.getChildAt(r4)
            int r0 = r6.t
            if (r0 == 0) goto L_0x0082
            if (r0 == r5) goto L_0x0076
            r1 = 2
            if (r0 == r1) goto L_0x0082
            goto L_0x008d
        L_0x0076:
            int r0 = r7.getMeasuredWidth()
            int r1 = r6.getMeasuredWidth()
            if (r0 == r1) goto L_0x008d
        L_0x0080:
            r4 = 1
            goto L_0x008d
        L_0x0082:
            int r0 = r7.getMeasuredWidth()
            int r1 = r6.getMeasuredWidth()
            if (r0 >= r1) goto L_0x008d
            goto L_0x0080
        L_0x008d:
            if (r4 == 0) goto L_0x00ad
            int r0 = r6.getPaddingTop()
            int r1 = r6.getPaddingBottom()
            int r0 = r0 + r1
            android.view.ViewGroup$LayoutParams r1 = r7.getLayoutParams()
            int r1 = r1.height
            int r8 = getChildMeasureSpec(r8, r0, r1)
            int r0 = r6.getMeasuredWidth()
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r3)
            r7.measure(r0, r8)
        L_0x00ad:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.tabs.TabLayout.onMeasure(int, int):void");
    }

    private void b(int i2) {
        boolean z2;
        if (i2 != -1) {
            if (getWindowToken() != null && u.J(this)) {
                e eVar = this.f36723a;
                int childCount = eVar.getChildCount();
                int i3 = 0;
                while (true) {
                    if (i3 >= childCount) {
                        z2 = false;
                        break;
                    } else if (eVar.getChildAt(i3).getWidth() <= 0) {
                        z2 = true;
                        break;
                    } else {
                        i3++;
                    }
                }
                if (!z2) {
                    int scrollX = getScrollX();
                    int a2 = a(i2, 0.0f);
                    if (scrollX != a2) {
                        f();
                        this.J.setIntValues(new int[]{scrollX, a2});
                        this.J.start();
                    }
                    e eVar2 = this.f36723a;
                    int i4 = this.r;
                    if (eVar2.f36751e != null && eVar2.f36751e.isRunning()) {
                        eVar2.f36751e.cancel();
                    }
                    eVar2.a(true, i2, i4);
                    return;
                }
            }
            setScrollPosition(i2, 0.0f, true);
        }
    }

    private void f() {
        if (this.J == null) {
            this.J = new ValueAnimator();
            this.J.setInterpolator(com.google.android.material.a.a.f35801b);
            this.J.setDuration((long) this.r);
            this.J.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    TabLayout.this.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    public void setScrollAnimatorListener(Animator.AnimatorListener animatorListener) {
        f();
        this.J.addListener(animatorListener);
    }

    private void setSelectedTabView(int i2) {
        int childCount = this.f36723a.getChildCount();
        if (i2 < childCount) {
            int i3 = 0;
            while (i3 < childCount) {
                View childAt = this.f36723a.getChildAt(i3);
                boolean z2 = true;
                childAt.setSelected(i3 == i2);
                if (i3 != i2) {
                    z2 = false;
                }
                childAt.setActivated(z2);
                i3++;
            }
        }
    }

    public final void b(f fVar) {
        b(fVar, true);
    }

    public final void b(f fVar, boolean z2) {
        int i2;
        f fVar2 = this.B;
        if (fVar2 != fVar) {
            if (fVar != null) {
                i2 = fVar.f36765e;
            } else {
                i2 = -1;
            }
            if (z2) {
                if ((fVar2 == null || fVar2.f36765e == -1) && i2 != -1) {
                    setScrollPosition(i2, 0.0f, true);
                } else {
                    b(i2);
                }
                if (i2 != -1) {
                    setSelectedTabView(i2);
                }
            }
            this.B = fVar;
            if (fVar2 != null) {
                e(fVar2);
            }
            if (fVar != null) {
                d(fVar);
            }
        } else if (fVar2 != null) {
            f(fVar);
            b(fVar.f36765e);
        }
    }

    private void d(f fVar) {
        for (int size = this.H.size() - 1; size >= 0; size--) {
            this.H.get(size).onTabSelected(fVar);
        }
    }

    private void e(f fVar) {
        for (int size = this.H.size() - 1; size >= 0; size--) {
            this.H.get(size).onTabUnselected(fVar);
        }
    }

    private void f(f fVar) {
        for (int size = this.H.size() - 1; size >= 0; size--) {
            this.H.get(size).onTabReselected(fVar);
        }
    }

    private int a(int i2, float f2) {
        int i3 = this.t;
        int i4 = 0;
        if (i3 != 0 && i3 != 2) {
            return 0;
        }
        View childAt = this.f36723a.getChildAt(i2);
        int i5 = i2 + 1;
        View childAt2 = i5 < this.f36723a.getChildCount() ? this.f36723a.getChildAt(i5) : null;
        int width = childAt != null ? childAt.getWidth() : 0;
        if (childAt2 != null) {
            i4 = childAt2.getWidth();
        }
        int left = (childAt.getLeft() + (width / 2)) - (getWidth() / 2);
        int i6 = (int) (((float) (width + i4)) * 0.5f * f2);
        return u.j(this) == 0 ? left + i6 : left - i6;
    }

    private void g() {
        int i2;
        int i3 = this.t;
        if (i3 == 0 || i3 == 2) {
            i2 = Math.max(0, this.F - this.f36724b);
        } else {
            i2 = 0;
        }
        u.b(this.f36723a, i2, 0, 0, 0);
        int i4 = this.t;
        if (i4 == 0) {
            c(this.q);
        } else if (i4 == 1 || i4 == 2) {
            this.f36723a.setGravity(1);
        }
        a(true);
    }

    private void c(int i2) {
        if (i2 != 0) {
            if (i2 == 1) {
                this.f36723a.setGravity(1);
                return;
            } else if (i2 != 2) {
                return;
            }
        }
        this.f36723a.setGravity(8388611);
    }

    /* access modifiers changed from: package-private */
    public final void a(boolean z2) {
        for (int i2 = 0; i2 < this.f36723a.getChildCount(); i2++) {
            View childAt = this.f36723a.getChildAt(i2);
            childAt.setMinimumWidth(getTabMinWidth());
            a((LinearLayout.LayoutParams) childAt.getLayoutParams());
            if (z2) {
                childAt.requestLayout();
            }
        }
    }

    public static class f {

        /* renamed from: a  reason: collision with root package name */
        Object f36761a;

        /* renamed from: b  reason: collision with root package name */
        Drawable f36762b;

        /* renamed from: c  reason: collision with root package name */
        public CharSequence f36763c;

        /* renamed from: d  reason: collision with root package name */
        CharSequence f36764d;

        /* renamed from: e  reason: collision with root package name */
        public int f36765e = -1;

        /* renamed from: f  reason: collision with root package name */
        public View f36766f;

        /* renamed from: g  reason: collision with root package name */
        int f36767g = 1;

        /* renamed from: h  reason: collision with root package name */
        public TabLayout f36768h;

        /* renamed from: i  reason: collision with root package name */
        public TabView f36769i;

        public final View a() {
            return this.f36766f;
        }

        public final f a(View view) {
            this.f36766f = view;
            f();
            return this;
        }

        public final int b() {
            return this.f36765e;
        }

        public final CharSequence c() {
            return this.f36763c;
        }

        public final f a(Drawable drawable) {
            this.f36762b = drawable;
            if (this.f36768h.q == 1 || this.f36768h.t == 2) {
                this.f36768h.a(true);
            }
            f();
            if (com.google.android.material.badge.a.f35899a && this.f36769i.g() && this.f36769i.f36740h.isVisible()) {
                this.f36769i.invalidate();
            }
            return this;
        }

        public final f a(CharSequence charSequence) {
            if (TextUtils.isEmpty(this.f36764d) && !TextUtils.isEmpty(charSequence)) {
                this.f36769i.setContentDescription(charSequence);
            }
            this.f36763c = charSequence;
            f();
            return this;
        }

        public final void d() {
            TabLayout tabLayout = this.f36768h;
            if (tabLayout != null) {
                tabLayout.b(this);
                return;
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        public final boolean e() {
            TabLayout tabLayout = this.f36768h;
            if (tabLayout != null) {
                return tabLayout.getSelectedTabPosition() == this.f36765e;
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        /* access modifiers changed from: package-private */
        public final void f() {
            TabView tabView = this.f36769i;
            if (tabView != null) {
                tabView.a();
            }
        }
    }

    public final class TabView extends LinearLayout {

        /* renamed from: a  reason: collision with root package name */
        TextView f36733a;

        /* renamed from: b  reason: collision with root package name */
        ImageView f36734b;

        /* renamed from: c  reason: collision with root package name */
        TextView f36735c;

        /* renamed from: d  reason: collision with root package name */
        ImageView f36736d;

        /* renamed from: f  reason: collision with root package name */
        private f f36738f;

        /* renamed from: g  reason: collision with root package name */
        private View f36739g;
        /* access modifiers changed from: private */

        /* renamed from: h  reason: collision with root package name */
        public BadgeDrawable f36740h;

        /* renamed from: i  reason: collision with root package name */
        private View f36741i;
        private Drawable j;
        private int k = 2;

        public TabView(Context context) {
            super(context);
            a(context);
            u.b(this, TabLayout.this.f36724b, TabLayout.this.f36725c, TabLayout.this.f36726d, TabLayout.this.f36727e);
            setGravity(17);
            setOrientation(TabLayout.this.u ^ true ? 1 : 0);
            setClickable(true);
            u.a((View) this, s.a(getContext()));
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v5, resolved type: android.graphics.drawable.GradientDrawable} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v6, resolved type: android.graphics.drawable.GradientDrawable} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v7, resolved type: android.graphics.drawable.GradientDrawable} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v8, resolved type: android.graphics.drawable.GradientDrawable} */
        /* access modifiers changed from: private */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a(android.content.Context r7) {
            /*
                r6 = this;
                com.google.android.material.tabs.TabLayout r0 = com.google.android.material.tabs.TabLayout.this
                int r0 = r0.n
                r1 = 0
                if (r0 == 0) goto L_0x0025
                com.google.android.material.tabs.TabLayout r0 = com.google.android.material.tabs.TabLayout.this
                int r0 = r0.n
                android.graphics.drawable.Drawable r7 = androidx.appcompat.a.a.a.b(r7, r0)
                r6.j = r7
                android.graphics.drawable.Drawable r7 = r6.j
                if (r7 == 0) goto L_0x0027
                boolean r7 = r7.isStateful()
                if (r7 == 0) goto L_0x0027
                android.graphics.drawable.Drawable r7 = r6.j
                int[] r0 = r6.getDrawableState()
                r7.setState(r0)
                goto L_0x0027
            L_0x0025:
                r6.j = r1
            L_0x0027:
                android.graphics.drawable.GradientDrawable r7 = new android.graphics.drawable.GradientDrawable
                r7.<init>()
                r0 = r7
                android.graphics.drawable.GradientDrawable r0 = (android.graphics.drawable.GradientDrawable) r0
                r2 = 0
                r0.setColor(r2)
                com.google.android.material.tabs.TabLayout r0 = com.google.android.material.tabs.TabLayout.this
                android.content.res.ColorStateList r0 = r0.f36731i
                if (r0 == 0) goto L_0x0080
                android.graphics.drawable.GradientDrawable r0 = new android.graphics.drawable.GradientDrawable
                r0.<init>()
                r3 = 925353388(0x3727c5ac, float:1.0E-5)
                r0.setCornerRadius(r3)
                r3 = -1
                r0.setColor(r3)
                com.google.android.material.tabs.TabLayout r3 = com.google.android.material.tabs.TabLayout.this
                android.content.res.ColorStateList r3 = r3.f36731i
                android.content.res.ColorStateList r3 = com.google.android.material.i.b.a((android.content.res.ColorStateList) r3)
                int r4 = android.os.Build.VERSION.SDK_INT
                r5 = 21
                if (r4 < r5) goto L_0x006b
                android.graphics.drawable.RippleDrawable r2 = new android.graphics.drawable.RippleDrawable
                com.google.android.material.tabs.TabLayout r4 = com.google.android.material.tabs.TabLayout.this
                boolean r4 = r4.w
                if (r4 == 0) goto L_0x005f
                r7 = r1
            L_0x005f:
                com.google.android.material.tabs.TabLayout r4 = com.google.android.material.tabs.TabLayout.this
                boolean r4 = r4.w
                if (r4 == 0) goto L_0x0066
                r0 = r1
            L_0x0066:
                r2.<init>(r3, r7, r0)
                r7 = r2
                goto L_0x0080
            L_0x006b:
                android.graphics.drawable.Drawable r0 = androidx.core.graphics.drawable.a.f(r0)
                androidx.core.graphics.drawable.a.a((android.graphics.drawable.Drawable) r0, (android.content.res.ColorStateList) r3)
                android.graphics.drawable.LayerDrawable r1 = new android.graphics.drawable.LayerDrawable
                r3 = 2
                android.graphics.drawable.Drawable[] r3 = new android.graphics.drawable.Drawable[r3]
                r3[r2] = r7
                r7 = 1
                r3[r7] = r0
                r1.<init>(r3)
                r7 = r1
            L_0x0080:
                androidx.core.h.u.a((android.view.View) r6, (android.graphics.drawable.Drawable) r7)
                com.google.android.material.tabs.TabLayout r7 = com.google.android.material.tabs.TabLayout.this
                r7.invalidate()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.tabs.TabLayout.TabView.a(android.content.Context):void");
        }

        /* access modifiers changed from: protected */
        public final void drawableStateChanged() {
            super.drawableStateChanged();
            int[] drawableState = getDrawableState();
            Drawable drawable = this.j;
            boolean z = false;
            if (drawable != null && drawable.isStateful()) {
                z = false | this.j.setState(drawableState);
            }
            if (z) {
                invalidate();
                TabLayout.this.invalidate();
            }
        }

        public final boolean performClick() {
            boolean performClick = super.performClick();
            if (this.f36738f == null) {
                return performClick;
            }
            if (!performClick) {
                playSoundEffect(0);
            }
            this.f36738f.d();
            return true;
        }

        public final void setSelected(boolean z) {
            boolean z2 = isSelected() != z;
            super.setSelected(z);
            if (z2 && z && Build.VERSION.SDK_INT < 16) {
                sendAccessibilityEvent(4);
            }
            TextView textView = this.f36733a;
            if (textView != null) {
                textView.setSelected(z);
            }
            ImageView imageView = this.f36734b;
            if (imageView != null) {
                imageView.setSelected(z);
            }
            View view = this.f36741i;
            if (view != null) {
                view.setSelected(z);
            }
        }

        public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            BadgeDrawable badgeDrawable = this.f36740h;
            if (badgeDrawable != null && badgeDrawable.isVisible()) {
                CharSequence contentDescription = getContentDescription();
                accessibilityNodeInfo.setContentDescription(contentDescription + ", " + this.f36740h.b());
            }
            androidx.core.h.a.c a2 = androidx.core.h.a.c.a(accessibilityNodeInfo);
            a2.b((Object) c.C0046c.a(0, 1, this.f36738f.f36765e, 1, false, isSelected()));
            if (isSelected()) {
                a2.g(false);
                a2.b(c.a.f3048e);
            }
            a2.g((CharSequence) "Tab");
        }

        public final void onMeasure(int i2, int i3) {
            Layout layout;
            int size = View.MeasureSpec.getSize(i2);
            int mode = View.MeasureSpec.getMode(i2);
            int tabMaxWidth = TabLayout.this.getTabMaxWidth();
            if (tabMaxWidth > 0 && (mode == 0 || size > tabMaxWidth)) {
                i2 = View.MeasureSpec.makeMeasureSpec(TabLayout.this.o, Integer.MIN_VALUE);
            }
            super.onMeasure(i2, i3);
            if (this.f36733a != null) {
                float f2 = TabLayout.this.l;
                int i4 = this.k;
                ImageView imageView = this.f36734b;
                boolean z = true;
                if (imageView == null || imageView.getVisibility() != 0) {
                    TextView textView = this.f36733a;
                    if (textView != null && textView.getLineCount() > 1) {
                        f2 = TabLayout.this.m;
                    }
                } else {
                    i4 = 1;
                }
                float textSize = this.f36733a.getTextSize();
                int lineCount = this.f36733a.getLineCount();
                int a2 = androidx.core.widget.i.a(this.f36733a);
                int i5 = (f2 > textSize ? 1 : (f2 == textSize ? 0 : -1));
                if (i5 != 0 || (a2 >= 0 && i4 != a2)) {
                    if (TabLayout.this.t == 1 && i5 > 0 && lineCount == 1 && ((layout = this.f36733a.getLayout()) == null || layout.getLineWidth(0) * (f2 / layout.getPaint().getTextSize()) > ((float) ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight())))) {
                        z = false;
                    }
                    if (z) {
                        this.f36733a.setTextSize(0, f2);
                        this.f36733a.setMaxLines(i4);
                        super.onMeasure(i2, i3);
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final void setTab(f fVar) {
            if (fVar != this.f36738f) {
                this.f36738f = fVar;
                a();
            }
        }

        /* access modifiers changed from: package-private */
        public final void a() {
            View view;
            f fVar = this.f36738f;
            Drawable drawable = null;
            if (fVar != null) {
                view = fVar.f36766f;
            } else {
                view = null;
            }
            if (view != null) {
                ViewParent parent = view.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(view);
                    }
                    addView(view);
                }
                this.f36741i = view;
                TextView textView = this.f36733a;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.f36734b;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.f36734b.setImageDrawable((Drawable) null);
                }
                this.f36735c = (TextView) view.findViewById(16908308);
                TextView textView2 = this.f36735c;
                if (textView2 != null) {
                    this.k = androidx.core.widget.i.a(textView2);
                }
                this.f36736d = (ImageView) view.findViewById(16908294);
            } else {
                View view2 = this.f36741i;
                if (view2 != null) {
                    removeView(view2);
                    this.f36741i = null;
                }
                this.f36735c = null;
                this.f36736d = null;
            }
            if (this.f36741i == null) {
                if (this.f36734b == null) {
                    b();
                }
                if (!(fVar == null || fVar.f36762b == null)) {
                    drawable = androidx.core.graphics.drawable.a.f(fVar.f36762b).mutate();
                }
                if (drawable != null) {
                    androidx.core.graphics.drawable.a.a(drawable, TabLayout.this.f36730h);
                    if (TabLayout.this.k != null) {
                        androidx.core.graphics.drawable.a.a(drawable, TabLayout.this.k);
                    }
                }
                if (this.f36733a == null) {
                    c();
                    this.k = androidx.core.widget.i.a(this.f36733a);
                }
                androidx.core.widget.i.a(this.f36733a, TabLayout.this.f36728f);
                if (TabLayout.this.f36729g != null) {
                    this.f36733a.setTextColor(TabLayout.this.f36729g);
                }
                a(this.f36733a, this.f36734b);
                e();
                a((View) this.f36734b);
                a((View) this.f36733a);
            } else if (!(this.f36735c == null && this.f36736d == null)) {
                a(this.f36735c, this.f36736d);
            }
            if (fVar != null && !TextUtils.isEmpty(fVar.f36764d)) {
                setContentDescription(fVar.f36764d);
            }
            setSelected(fVar != null && fVar.e());
        }

        private void b() {
            ViewGroup viewGroup;
            if (com.google.android.material.badge.a.f35899a) {
                viewGroup = d();
                addView(viewGroup, 0);
            } else {
                viewGroup = this;
            }
            this.f36734b = (ImageView) LayoutInflater.from(getContext()).inflate(R.layout.design_layout_tab_icon, viewGroup, false);
            viewGroup.addView(this.f36734b, 0);
        }

        private void c() {
            ViewGroup viewGroup;
            if (com.google.android.material.badge.a.f35899a) {
                viewGroup = d();
                addView(viewGroup);
            } else {
                viewGroup = this;
            }
            this.f36733a = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.design_layout_tab_text, viewGroup, false);
            viewGroup.addView(this.f36733a);
        }

        private FrameLayout d() {
            FrameLayout frameLayout = new FrameLayout(getContext());
            frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            return frameLayout;
        }

        private BadgeDrawable getOrCreateBadge() {
            if (this.f36740h == null) {
                this.f36740h = BadgeDrawable.a(getContext());
            }
            e();
            BadgeDrawable badgeDrawable = this.f36740h;
            if (badgeDrawable != null) {
                return badgeDrawable;
            }
            throw new IllegalStateException("Unable to create badge");
        }

        private BadgeDrawable getBadge() {
            return this.f36740h;
        }

        private void a(final View view) {
            if (view != null) {
                view.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
                    public final void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
                        if (view.getVisibility() == 0) {
                            TabView.this.c(view);
                        }
                    }
                });
            }
        }

        private void e() {
            f fVar;
            f fVar2;
            if (g()) {
                if (this.f36741i == null) {
                    if (this.f36734b != null && (fVar2 = this.f36738f) != null && fVar2.f36762b != null) {
                        View view = this.f36739g;
                        ImageView imageView = this.f36734b;
                        if (view != imageView) {
                            f();
                            b((View) this.f36734b);
                            return;
                        }
                        c((View) imageView);
                        return;
                    } else if (!(this.f36733a == null || (fVar = this.f36738f) == null || fVar.f36767g != 1)) {
                        View view2 = this.f36739g;
                        TextView textView = this.f36733a;
                        if (view2 != textView) {
                            f();
                            b((View) this.f36733a);
                            return;
                        }
                        c((View) textView);
                        return;
                    }
                }
                f();
            }
        }

        private void b(View view) {
            if (g() && view != null) {
                a(false);
                com.google.android.material.badge.a.a(this.f36740h, view, d(view));
                this.f36739g = view;
            }
        }

        private void f() {
            if (g()) {
                a(true);
                View view = this.f36739g;
                if (view != null) {
                    com.google.android.material.badge.a.b(this.f36740h, view, d(view));
                    this.f36739g = null;
                }
            }
        }

        private void a(boolean z) {
            setClipChildren(z);
            setClipToPadding(z);
            ViewGroup viewGroup = (ViewGroup) getParent();
            if (viewGroup != null) {
                viewGroup.setClipChildren(z);
                viewGroup.setClipToPadding(z);
            }
        }

        /* access modifiers changed from: package-private */
        public final void a(TextView textView, ImageView imageView) {
            CharSequence charSequence;
            CharSequence charSequence2;
            f fVar = this.f36738f;
            Drawable mutate = (fVar == null || fVar.f36762b == null) ? null : androidx.core.graphics.drawable.a.f(this.f36738f.f36762b).mutate();
            f fVar2 = this.f36738f;
            if (fVar2 != null) {
                charSequence = fVar2.f36763c;
            } else {
                charSequence = null;
            }
            if (imageView != null) {
                if (mutate != null) {
                    imageView.setImageDrawable(mutate);
                    imageView.setVisibility(0);
                    setVisibility(0);
                } else {
                    imageView.setVisibility(8);
                    imageView.setImageDrawable((Drawable) null);
                }
            }
            boolean z = !TextUtils.isEmpty(charSequence);
            if (textView != null) {
                if (z) {
                    textView.setText(charSequence);
                    if (this.f36738f.f36767g == 1) {
                        textView.setVisibility(0);
                    } else {
                        textView.setVisibility(8);
                    }
                    setVisibility(0);
                } else {
                    textView.setVisibility(8);
                    textView.setText((CharSequence) null);
                }
            }
            if (imageView != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                int a2 = (!z || imageView.getVisibility() != 0) ? 0 : (int) q.a(getContext(), 8);
                if (TabLayout.this.u) {
                    if (a2 != androidx.core.h.h.b(marginLayoutParams)) {
                        androidx.core.h.h.b(marginLayoutParams, a2);
                        marginLayoutParams.bottomMargin = 0;
                        imageView.setLayoutParams(marginLayoutParams);
                        imageView.requestLayout();
                    }
                } else if (a2 != marginLayoutParams.bottomMargin) {
                    marginLayoutParams.bottomMargin = a2;
                    androidx.core.h.h.b(marginLayoutParams, 0);
                    imageView.setLayoutParams(marginLayoutParams);
                    imageView.requestLayout();
                }
            }
            f fVar3 = this.f36738f;
            if (fVar3 != null) {
                charSequence2 = fVar3.f36764d;
            } else {
                charSequence2 = null;
            }
            if (z) {
                charSequence2 = null;
            }
            ae.a(this, charSequence2);
        }

        /* access modifiers changed from: private */
        public void c(View view) {
            if (g() && view == this.f36739g) {
                com.google.android.material.badge.a.c(this.f36740h, view, d(view));
            }
        }

        /* access modifiers changed from: private */
        public boolean g() {
            return this.f36740h != null;
        }

        private FrameLayout d(View view) {
            if ((view == this.f36734b || view == this.f36733a) && com.google.android.material.badge.a.f35899a) {
                return (FrameLayout) view.getParent();
            }
            return null;
        }

        /* access modifiers changed from: private */
        public int getContentWidth() {
            View[] viewArr = {this.f36733a, this.f36734b, this.f36741i};
            int i2 = 0;
            int i3 = 0;
            boolean z = false;
            for (int i4 = 0; i4 < 3; i4++) {
                View view = viewArr[i4];
                if (view != null && view.getVisibility() == 0) {
                    i3 = z ? Math.min(i3, view.getLeft()) : view.getLeft();
                    i2 = z ? Math.max(i2, view.getRight()) : view.getRight();
                    z = true;
                }
            }
            return i2 - i3;
        }

        public final f getTab() {
            return this.f36738f;
        }

        static /* synthetic */ void a(TabView tabView, Canvas canvas) {
            Drawable drawable = tabView.j;
            if (drawable != null) {
                drawable.setBounds(tabView.getLeft(), tabView.getTop(), tabView.getRight(), tabView.getBottom());
                tabView.j.draw(canvas);
            }
        }
    }

    class e extends LinearLayout {

        /* renamed from: a  reason: collision with root package name */
        int f36747a = -1;

        /* renamed from: b  reason: collision with root package name */
        float f36748b;

        /* renamed from: c  reason: collision with root package name */
        int f36749c = -1;

        /* renamed from: d  reason: collision with root package name */
        int f36750d = -1;

        /* renamed from: e  reason: collision with root package name */
        ValueAnimator f36751e;

        /* renamed from: g  reason: collision with root package name */
        private int f36753g;

        /* renamed from: h  reason: collision with root package name */
        private final Paint f36754h;

        /* renamed from: i  reason: collision with root package name */
        private final GradientDrawable f36755i;
        private int j = -1;
        /* access modifiers changed from: private */
        public int k = -1;
        /* access modifiers changed from: private */
        public int l = -1;

        e(Context context) {
            super(context);
            setWillNotDraw(false);
            this.f36754h = new Paint();
            this.f36755i = new GradientDrawable();
        }

        /* access modifiers changed from: package-private */
        public final void a(int i2) {
            if (this.f36754h.getColor() != i2) {
                this.f36754h.setColor(i2);
                u.g(this);
            }
        }

        /* access modifiers changed from: package-private */
        public final void b(int i2) {
            if (this.f36753g != i2) {
                this.f36753g = i2;
                u.g(this);
            }
        }

        public final void onRtlPropertiesChanged(int i2) {
            super.onRtlPropertiesChanged(i2);
            if (Build.VERSION.SDK_INT < 23 && this.j != i2) {
                requestLayout();
                this.j = i2;
            }
        }

        /* access modifiers changed from: protected */
        public final void onMeasure(int i2, int i3) {
            boolean z;
            super.onMeasure(i2, i3);
            if (View.MeasureSpec.getMode(i2) == 1073741824) {
                if (TabLayout.this.q == 1 || TabLayout.this.t == 2) {
                    int childCount = getChildCount();
                    int i4 = 0;
                    for (int i5 = 0; i5 < childCount; i5++) {
                        View childAt = getChildAt(i5);
                        if (childAt.getVisibility() == 0) {
                            i4 = Math.max(i4, childAt.getMeasuredWidth());
                        }
                    }
                    if (i4 > 0) {
                        if (i4 * childCount <= getMeasuredWidth() - (((int) q.a(getContext(), 16)) * 2)) {
                            z = false;
                            for (int i6 = 0; i6 < childCount; i6++) {
                                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getChildAt(i6).getLayoutParams();
                                if (layoutParams.width != i4 || layoutParams.weight != 0.0f) {
                                    layoutParams.width = i4;
                                    layoutParams.weight = 0.0f;
                                    z = true;
                                }
                            }
                        } else {
                            TabLayout tabLayout = TabLayout.this;
                            tabLayout.q = 0;
                            tabLayout.a(false);
                            z = true;
                        }
                        if (z) {
                            super.onMeasure(i2, i3);
                        }
                    }
                }
            }
        }

        /* access modifiers changed from: protected */
        public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
            super.onLayout(z, i2, i3, i4, i5);
            ValueAnimator valueAnimator = this.f36751e;
            if (valueAnimator == null || !valueAnimator.isRunning()) {
                a();
            } else {
                a(false, this.f36747a, -1);
            }
        }

        /* access modifiers changed from: package-private */
        public final void a() {
            int i2;
            int i3;
            View childAt = getChildAt(this.f36747a);
            if (childAt == null || childAt.getWidth() <= 0) {
                i3 = -1;
                i2 = -1;
            } else {
                i3 = childAt.getLeft();
                i2 = childAt.getRight();
                if (!TabLayout.this.v && (childAt instanceof TabView)) {
                    a((TabView) childAt, TabLayout.this.C);
                    i3 = (int) TabLayout.this.C.left;
                    i2 = (int) TabLayout.this.C.right;
                }
                if (this.f36748b > 0.0f && this.f36747a < getChildCount() - 1) {
                    View childAt2 = getChildAt(this.f36747a + 1);
                    int left = childAt2.getLeft();
                    int right = childAt2.getRight();
                    if (!TabLayout.this.v && (childAt2 instanceof TabView)) {
                        a((TabView) childAt2, TabLayout.this.C);
                        left = (int) TabLayout.this.C.left;
                        right = (int) TabLayout.this.C.right;
                    }
                    float f2 = this.f36748b;
                    i3 = (int) ((((float) left) * f2) + ((1.0f - f2) * ((float) i3)));
                    i2 = (int) ((((float) right) * f2) + ((1.0f - f2) * ((float) i2)));
                }
            }
            a(i3, i2);
        }

        /* access modifiers changed from: package-private */
        public final void a(int i2, int i3) {
            if (i2 != this.f36749c || i3 != this.f36750d) {
                this.f36749c = i2;
                this.f36750d = i3;
                u.g(this);
            }
        }

        /* access modifiers changed from: package-private */
        public final void a(boolean z, final int i2, int i3) {
            View childAt = getChildAt(i2);
            if (childAt == null) {
                a();
                return;
            }
            final int left = childAt.getLeft();
            final int right = childAt.getRight();
            if (!TabLayout.this.v && (childAt instanceof TabView)) {
                a((TabView) childAt, TabLayout.this.C);
                left = (int) TabLayout.this.C.left;
                right = (int) TabLayout.this.C.right;
            }
            int i4 = this.f36749c;
            int i5 = this.f36750d;
            if (i4 != left || i5 != right) {
                if (z) {
                    this.k = i4;
                    this.l = i5;
                }
                AnonymousClass1 r0 = new ValueAnimator.AnimatorUpdateListener() {
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float animatedFraction = valueAnimator.getAnimatedFraction();
                        e eVar = e.this;
                        eVar.a(com.google.android.material.a.a.a(eVar.k, left, animatedFraction), com.google.android.material.a.a.a(e.this.l, right, animatedFraction));
                    }
                };
                if (z) {
                    ValueAnimator valueAnimator = new ValueAnimator();
                    this.f36751e = valueAnimator;
                    valueAnimator.setInterpolator(com.google.android.material.a.a.f35801b);
                    valueAnimator.setDuration((long) i3);
                    valueAnimator.setFloatValues(new float[]{0.0f, 1.0f});
                    valueAnimator.addUpdateListener(r0);
                    valueAnimator.addListener(new AnimatorListenerAdapter() {
                        public final void onAnimationStart(Animator animator) {
                            e.this.f36747a = i2;
                        }

                        public final void onAnimationEnd(Animator animator) {
                            e eVar = e.this;
                            eVar.f36747a = i2;
                            eVar.f36748b = 0.0f;
                        }
                    });
                    valueAnimator.start();
                    return;
                }
                this.f36751e.removeAllUpdateListeners();
                this.f36751e.addUpdateListener(r0);
            }
        }

        private void a(TabView tabView, RectF rectF) {
            int c2 = tabView.getContentWidth();
            int a2 = (int) q.a(getContext(), 24);
            if (c2 < a2) {
                c2 = a2;
            }
            int left = (tabView.getLeft() + tabView.getRight()) / 2;
            int i2 = c2 / 2;
            rectF.set((float) (left - i2), 0.0f, (float) (left + i2), 0.0f);
        }

        public final void draw(Canvas canvas) {
            int i2 = 0;
            int intrinsicHeight = TabLayout.this.j != null ? TabLayout.this.j.getIntrinsicHeight() : 0;
            int i3 = this.f36753g;
            if (i3 >= 0) {
                intrinsicHeight = i3;
            }
            int i4 = TabLayout.this.s;
            if (i4 == 0) {
                i2 = getHeight() - intrinsicHeight;
                intrinsicHeight = getHeight();
            } else if (i4 == 1) {
                i2 = (getHeight() - intrinsicHeight) / 2;
                intrinsicHeight = (getHeight() + intrinsicHeight) / 2;
            } else if (i4 != 2) {
                intrinsicHeight = i4 != 3 ? 0 : getHeight();
            }
            int i5 = this.f36749c;
            if (i5 >= 0 && this.f36750d > i5) {
                Drawable mutate = androidx.core.graphics.drawable.a.f(TabLayout.this.j != null ? TabLayout.this.j : this.f36755i).mutate();
                mutate.setBounds(this.f36749c, i2, this.f36750d, intrinsicHeight);
                if (this.f36754h != null) {
                    if (Build.VERSION.SDK_INT == 21) {
                        mutate.setColorFilter(this.f36754h.getColor(), PorterDuff.Mode.SRC_IN);
                    } else {
                        androidx.core.graphics.drawable.a.a(mutate, this.f36754h.getColor());
                    }
                }
                mutate.draw(canvas);
            }
            super.draw(canvas);
        }
    }

    private static ColorStateList a(int i2, int i3) {
        return new ColorStateList(new int[][]{SELECTED_STATE_SET, EMPTY_STATE_SET}, new int[]{i3, i2});
    }

    private int getDefaultHeight() {
        int size = this.A.size();
        boolean z2 = false;
        int i2 = 0;
        while (true) {
            if (i2 < size) {
                f fVar = this.A.get(i2);
                if (fVar != null && fVar.f36762b != null && !TextUtils.isEmpty(fVar.f36763c)) {
                    z2 = true;
                    break;
                }
                i2++;
            } else {
                break;
            }
        }
        return (!z2 || this.u) ? 48 : 72;
    }

    private int getTabMinWidth() {
        int i2 = this.D;
        if (i2 != -1) {
            return i2;
        }
        int i3 = this.t;
        if (i3 == 0 || i3 == 2) {
            return this.p;
        }
        return 0;
    }

    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    /* access modifiers changed from: package-private */
    public int getTabMaxWidth() {
        return this.o;
    }

    public static class g implements ViewPager.e {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<TabLayout> f36770a;

        /* renamed from: b  reason: collision with root package name */
        private int f36771b;

        /* renamed from: c  reason: collision with root package name */
        private int f36772c;

        public g(TabLayout tabLayout) {
            this.f36770a = new WeakReference<>(tabLayout);
        }

        public final void onPageScrollStateChanged(int i2) {
            this.f36771b = this.f36772c;
            this.f36772c = i2;
        }

        public final void onPageScrolled(int i2, float f2, int i3) {
            TabLayout tabLayout = (TabLayout) this.f36770a.get();
            if (tabLayout != null) {
                boolean z = false;
                boolean z2 = this.f36772c != 2 || this.f36771b == 1;
                if (!(this.f36772c == 2 && this.f36771b == 0)) {
                    z = true;
                }
                tabLayout.setScrollPosition(i2, f2, z2, z);
            }
        }

        public final void onPageSelected(int i2) {
            TabLayout tabLayout = (TabLayout) this.f36770a.get();
            if (tabLayout != null && tabLayout.getSelectedTabPosition() != i2 && i2 < tabLayout.getTabCount()) {
                int i3 = this.f36772c;
                tabLayout.b(tabLayout.a(i2), i3 == 0 || (i3 == 2 && this.f36771b == 0));
            }
        }

        /* access modifiers changed from: package-private */
        public final void a() {
            this.f36772c = 0;
            this.f36771b = 0;
        }
    }

    public static class h implements c {

        /* renamed from: a  reason: collision with root package name */
        private final ViewPager f36773a;

        public final void onTabReselected(f fVar) {
        }

        public final void onTabUnselected(f fVar) {
        }

        public h(ViewPager viewPager) {
            this.f36773a = viewPager;
        }

        public final void onTabSelected(f fVar) {
            this.f36773a.setCurrentItem(fVar.f36765e);
        }
    }

    class d extends DataSetObserver {
        d() {
        }

        public final void onChanged() {
            TabLayout.this.c();
        }

        public final void onInvalidated() {
            TabLayout.this.c();
        }
    }

    class a implements ViewPager.d {

        /* renamed from: a  reason: collision with root package name */
        boolean f36744a;

        a() {
        }

        public final void onAdapterChanged(ViewPager viewPager, androidx.viewpager.widget.a aVar, androidx.viewpager.widget.a aVar2) {
            if (TabLayout.this.x == viewPager) {
                TabLayout.this.a(aVar2, this.f36744a);
            }
        }
    }

    public f a() {
        f a2 = z.a();
        if (a2 == null) {
            a2 = new f();
        }
        a2.f36768h = this;
        e.a<TabView> aVar = this.P;
        TabView a3 = aVar != null ? aVar.a() : null;
        if (a3 == null) {
            a3 = new TabView(getContext());
        }
        a3.setTab(a2);
        a3.setFocusable(true);
        a3.setMinimumWidth(getTabMinWidth());
        if (TextUtils.isEmpty(a2.f36764d)) {
            a3.setContentDescription(a2.f36763c);
        } else {
            a3.setContentDescription(a2.f36764d);
        }
        a2.f36769i = a3;
        return a2;
    }

    private void a(f fVar, int i2) {
        fVar.f36765e = i2;
        this.A.add(i2, fVar);
        int size = this.A.size();
        while (true) {
            i2++;
            if (i2 < size) {
                this.A.get(i2).f36765e = i2;
            } else {
                return;
            }
        }
    }
}
