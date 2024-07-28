package net.one97.paytm.o2o.movies.common.customui;

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
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.ae;
import androidx.core.g.e;
import androidx.core.h.s;
import androidx.core.h.u;
import androidx.core.widget.i;
import androidx.viewpager.widget.ViewPager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import net.one97.paytm.o2o.movies.R;

@ViewPager.a
public class CustomTabLayout extends HorizontalScrollView {
    private static final e.a<e> n = new e.c(16);
    private DataSetObserver A;
    private f B;
    private a C;
    private boolean D;
    private final e.a<TabView> E;

    /* renamed from: a  reason: collision with root package name */
    int f75037a;

    /* renamed from: b  reason: collision with root package name */
    int f75038b;

    /* renamed from: c  reason: collision with root package name */
    int f75039c;

    /* renamed from: d  reason: collision with root package name */
    int f75040d;

    /* renamed from: e  reason: collision with root package name */
    int f75041e;

    /* renamed from: f  reason: collision with root package name */
    ColorStateList f75042f;

    /* renamed from: g  reason: collision with root package name */
    float f75043g;

    /* renamed from: h  reason: collision with root package name */
    float f75044h;

    /* renamed from: i  reason: collision with root package name */
    int f75045i;
    int j;
    int k;
    int l;
    ViewPager m;
    private final ArrayList<e> o;
    private e p;
    private final d q;
    private int r;
    private int s;
    private int t;
    private int u;
    private b v;
    private final ArrayList<b> w;
    private b x;
    private ValueAnimator y;
    private androidx.viewpager.widget.a z;

    public interface b {
        void a(e eVar);

        void b(e eVar);
    }

    public CustomTabLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public CustomTabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CustomTabLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        TypedArray obtainStyledAttributes;
        this.o = new ArrayList<>();
        this.j = Integer.MAX_VALUE;
        this.w = new ArrayList<>();
        this.E = new e.b(12);
        d.a(context);
        setHorizontalScrollBarEnabled(false);
        this.q = new d(context);
        super.addView(this.q, 0, new FrameLayout.LayoutParams(-2, -1));
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, R.styleable.CustomTabLayout, i2, com.google.android.material.R.style.Widget_Design_TabLayout);
        try {
            this.q.b(obtainStyledAttributes2.getDimensionPixelSize(R.styleable.CustomTabLayout_tabIndicatorHeight, 0));
            this.q.c(obtainStyledAttributes2.getDimensionPixelSize(R.styleable.CustomTabLayout_tabIndicatorWidth, b(28)));
            this.q.a(obtainStyledAttributes2.getColor(R.styleable.CustomTabLayout_tabIndicatorColor, 0));
            int dimensionPixelSize = obtainStyledAttributes2.getDimensionPixelSize(R.styleable.CustomTabLayout_tabPadding, 0);
            this.f75040d = dimensionPixelSize;
            this.f75039c = dimensionPixelSize;
            this.f75038b = dimensionPixelSize;
            this.f75037a = dimensionPixelSize;
            this.f75037a = obtainStyledAttributes2.getDimensionPixelSize(R.styleable.CustomTabLayout_tabPaddingStart, this.f75037a);
            this.f75038b = obtainStyledAttributes2.getDimensionPixelSize(R.styleable.CustomTabLayout_tabPaddingTop, this.f75038b);
            this.f75039c = obtainStyledAttributes2.getDimensionPixelSize(R.styleable.CustomTabLayout_tabPaddingEnd, this.f75039c);
            this.f75040d = obtainStyledAttributes2.getDimensionPixelSize(R.styleable.CustomTabLayout_tabPaddingBottom, this.f75040d);
            this.f75041e = obtainStyledAttributes2.getResourceId(R.styleable.CustomTabLayout_tabTextAppearance, com.google.android.material.R.style.TextAppearance_Design_Tab);
            obtainStyledAttributes = context.obtainStyledAttributes(this.f75041e, com.google.android.material.R.styleable.TextAppearance);
            this.f75043g = (float) obtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R.styleable.TextAppearance_android_textSize, 0);
            this.f75042f = obtainStyledAttributes.getColorStateList(com.google.android.material.R.styleable.TextAppearance_android_textColor);
            obtainStyledAttributes.recycle();
            if (obtainStyledAttributes2.hasValue(R.styleable.CustomTabLayout_tabTextColor)) {
                this.f75042f = obtainStyledAttributes2.getColorStateList(R.styleable.CustomTabLayout_tabTextColor);
            }
            if (obtainStyledAttributes2.hasValue(R.styleable.CustomTabLayout_tabSelectedTextColor)) {
                this.f75042f = a(this.f75042f.getDefaultColor(), obtainStyledAttributes2.getColor(R.styleable.CustomTabLayout_tabSelectedTextColor, 0));
            }
            this.r = obtainStyledAttributes2.getDimensionPixelSize(R.styleable.CustomTabLayout_tabMinWidth, -1);
            this.s = obtainStyledAttributes2.getDimensionPixelSize(R.styleable.CustomTabLayout_tabMaxWidth, -1);
            this.f75045i = obtainStyledAttributes2.getResourceId(R.styleable.CustomTabLayout_tabBackground, 0);
            this.u = obtainStyledAttributes2.getDimensionPixelSize(R.styleable.CustomTabLayout_tabContentStart, 0);
            this.l = obtainStyledAttributes2.getInt(R.styleable.CustomTabLayout_tabModebundle, 1);
            this.k = obtainStyledAttributes2.getInt(R.styleable.CustomTabLayout_tabGravitybundle, 0);
        } catch (Exception unused) {
        } catch (Throwable th) {
            obtainStyledAttributes2.recycle();
            throw th;
        }
        obtainStyledAttributes2.recycle();
        Resources resources = getResources();
        this.f75044h = (float) resources.getDimensionPixelSize(com.google.android.material.R.dimen.design_tab_text_size_2line);
        this.t = resources.getDimensionPixelSize(com.google.android.material.R.dimen.design_tab_scrollable_min_width);
        g();
    }

    public void setSelectedTabIndicatorColor(int i2) {
        this.q.a(i2);
    }

    public void setSelectedTabIndicatorHeight(int i2) {
        this.q.b(i2);
    }

    public void setSelectedTabIndicatorWidth(int i2) {
        this.q.c(i2);
    }

    public void setScrollPosition(int i2, float f2, boolean z2) {
        a(i2, f2, z2, true);
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2, float f2, boolean z2, boolean z3) {
        int round = Math.round(((float) i2) + f2);
        if (round >= 0 && round < this.q.getChildCount()) {
            if (z3) {
                this.q.a(i2, f2);
            }
            ValueAnimator valueAnimator = this.y;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.y.cancel();
            }
            scrollTo(a(i2, f2), 0);
            if (z2) {
                setSelectedTabView(round);
            }
        }
    }

    private float getScrollPosition() {
        d dVar = this.q;
        return ((float) dVar.f75058a) + dVar.f75059b;
    }

    public final void a(e eVar) {
        a(eVar, this.o.isEmpty());
    }

    public final void a(e eVar, boolean z2) {
        a(eVar, this.o.size(), z2);
    }

    private void a(e eVar, int i2, boolean z2) {
        if (eVar.f75079f == this) {
            a(eVar, i2);
            d(eVar);
            if (z2) {
                eVar.a();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
    }

    private void a(CustomTabItem customTabItem) {
        e a2 = a();
        if (customTabItem.f75034a != null) {
            a2.a(customTabItem.f75034a);
        }
        if (customTabItem.f75035b != null) {
            a2.f75074a = customTabItem.f75035b;
            a2.c();
        }
        if (customTabItem.f75036c != 0) {
            a2.a(LayoutInflater.from(a2.f75080g.getContext()).inflate(customTabItem.f75036c, a2.f75080g, false));
        }
        if (!TextUtils.isEmpty(customTabItem.getContentDescription())) {
            a2.f75076c = customTabItem.getContentDescription();
            a2.c();
        }
        a(a2);
    }

    @Deprecated
    public void setOnTabSelectedListener(b bVar) {
        b bVar2 = this.v;
        if (bVar2 != null) {
            b(bVar2);
        }
        this.v = bVar;
        if (bVar != null) {
            a(bVar);
        }
    }

    public final void a(b bVar) {
        if (!this.w.contains(bVar)) {
            this.w.add(bVar);
        }
    }

    private void b(b bVar) {
        this.w.remove(bVar);
    }

    public final e a() {
        e a2 = n.a();
        if (a2 == null) {
            a2 = new e();
        }
        a2.f75079f = this;
        a2.f75080g = c(a2);
        return a2;
    }

    public int getTabCount() {
        return this.o.size();
    }

    public final e a(int i2) {
        if (i2 < 0 || i2 >= getTabCount()) {
            return null;
        }
        return this.o.get(i2);
    }

    public int getSelectedTabPosition() {
        e eVar = this.p;
        if (eVar != null) {
            return eVar.f75077d;
        }
        return -1;
    }

    public final void b() {
        for (int childCount = this.q.getChildCount() - 1; childCount >= 0; childCount--) {
            c(childCount);
        }
        Iterator<e> it2 = this.o.iterator();
        while (it2.hasNext()) {
            e next = it2.next();
            it2.remove();
            next.d();
            n.a(next);
        }
        this.p = null;
    }

    public void setTabMode(int i2) {
        if (i2 != this.l) {
            this.l = i2;
            g();
        }
    }

    public int getTabMode() {
        return this.l;
    }

    public void setTabGravity(int i2) {
        if (this.k != i2) {
            this.k = i2;
            g();
        }
    }

    public int getTabGravity() {
        return this.k;
    }

    public void setTabTextColors(ColorStateList colorStateList) {
        if (this.f75042f != colorStateList) {
            this.f75042f = colorStateList;
            int size = this.o.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.o.get(i2).c();
            }
        }
    }

    public ColorStateList getTabTextColors() {
        return this.f75042f;
    }

    public void setTabTextColors(int i2, int i3) {
        setTabTextColors(a(i2, i3));
    }

    public void setupWithViewPager(ViewPager viewPager) {
        setupWithViewPager(viewPager, true);
    }

    public void setupWithViewPager(ViewPager viewPager, boolean z2) {
        a(viewPager, z2, false);
    }

    private void a(ViewPager viewPager, boolean z2, boolean z3) {
        ViewPager viewPager2 = this.m;
        if (viewPager2 != null) {
            f fVar = this.B;
            if (fVar != null) {
                viewPager2.removeOnPageChangeListener(fVar);
            }
            a aVar = this.C;
            if (aVar != null) {
                this.m.removeOnAdapterChangeListener(aVar);
            }
        }
        b bVar = this.x;
        if (bVar != null) {
            b(bVar);
            this.x = null;
        }
        if (viewPager != null) {
            this.m = viewPager;
            if (this.B == null) {
                this.B = new f(this);
            }
            this.B.a();
            viewPager.addOnPageChangeListener(this.B);
            this.x = new g(viewPager);
            a(this.x);
            androidx.viewpager.widget.a adapter = viewPager.getAdapter();
            if (adapter != null) {
                a(adapter, z2);
            }
            if (this.C == null) {
                this.C = new a();
            }
            a aVar2 = this.C;
            aVar2.f75055a = z2;
            viewPager.addOnAdapterChangeListener(aVar2);
            setScrollPosition(viewPager.getCurrentItem(), 0.0f, true);
        } else {
            this.m = null;
            a((androidx.viewpager.widget.a) null, false);
        }
        this.D = z3;
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
        if (this.m == null) {
            ViewParent parent = getParent();
            if (parent instanceof ViewPager) {
                a((ViewPager) parent, true, true);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.D) {
            setupWithViewPager((ViewPager) null);
            this.D = false;
        }
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.q.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    /* access modifiers changed from: package-private */
    public final void a(androidx.viewpager.widget.a aVar, boolean z2) {
        DataSetObserver dataSetObserver;
        androidx.viewpager.widget.a aVar2 = this.z;
        if (!(aVar2 == null || (dataSetObserver = this.A) == null)) {
            aVar2.unregisterDataSetObserver(dataSetObserver);
        }
        this.z = aVar;
        if (z2 && aVar != null) {
            if (this.A == null) {
                this.A = new c();
            }
            aVar.registerDataSetObserver(this.A);
        }
        c();
    }

    /* access modifiers changed from: package-private */
    public final void c() {
        int currentItem;
        b();
        androidx.viewpager.widget.a aVar = this.z;
        if (aVar != null) {
            int count = aVar.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                a(a().a(this.z.getPageTitle(i2)), false);
            }
            ViewPager viewPager = this.m;
            if (viewPager != null && count > 0 && (currentItem = viewPager.getCurrentItem()) != getSelectedTabPosition() && currentItem < getTabCount()) {
                b(a(currentItem), true);
            }
        }
    }

    private TabView c(e eVar) {
        e.a<TabView> aVar = this.E;
        TabView a2 = aVar != null ? aVar.a() : null;
        if (a2 == null) {
            a2 = new TabView(getContext());
        }
        a2.setTab(eVar);
        a2.setFocusable(true);
        a2.setMinimumWidth(getTabMinWidth());
        return a2;
    }

    private void d(e eVar) {
        this.q.addView(eVar.f75080g, eVar.f75077d, d());
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
        if (view instanceof CustomTabItem) {
            a((CustomTabItem) view);
            return;
        }
        throw new IllegalArgumentException("Only CustomTabItem instances can be added to TabLayout");
    }

    private LinearLayout.LayoutParams d() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        a(layoutParams);
        return layoutParams;
    }

    private void a(LinearLayout.LayoutParams layoutParams) {
        if (this.l == 1 && this.k == 0) {
            layoutParams.width = 0;
            layoutParams.weight = 1.0f;
            return;
        }
        layoutParams.width = -2;
        layoutParams.weight = 0.0f;
    }

    /* access modifiers changed from: package-private */
    public final int b(int i2) {
        return Math.round(getResources().getDisplayMetrics().density * ((float) i2));
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int b2 = b(getDefaultHeight()) + getPaddingTop() + getPaddingBottom();
        int mode = View.MeasureSpec.getMode(i3);
        if (mode == Integer.MIN_VALUE) {
            i3 = View.MeasureSpec.makeMeasureSpec(Math.min(b2, View.MeasureSpec.getSize(i3)), 1073741824);
        } else if (mode == 0) {
            i3 = View.MeasureSpec.makeMeasureSpec(b2, 1073741824);
        }
        int size = View.MeasureSpec.getSize(i2);
        if (View.MeasureSpec.getMode(i2) != 0) {
            int i4 = this.s;
            if (i4 <= 0) {
                i4 = size - b(56);
            }
            this.j = i4;
        }
        super.onMeasure(i2, i3);
        if (getChildCount() == 1) {
            boolean z2 = false;
            View childAt = getChildAt(0);
            int i5 = this.l;
            if (i5 == 0 ? childAt.getMeasuredWidth() < getMeasuredWidth() : !(i5 != 1 || childAt.getMeasuredWidth() == getMeasuredWidth())) {
                z2 = true;
            }
            if (z2) {
                childAt.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), getChildMeasureSpec(i3, getPaddingTop() + getPaddingBottom(), childAt.getLayoutParams().height));
            }
        }
    }

    private void c(int i2) {
        TabView tabView = (TabView) this.q.getChildAt(i2);
        this.q.removeViewAt(i2);
        if (tabView != null) {
            tabView.a();
            this.E.a(tabView);
        }
        requestLayout();
    }

    private void d(int i2) {
        boolean z2;
        if (i2 != -1) {
            if (getWindowToken() != null && u.J(this)) {
                d dVar = this.q;
                int childCount = dVar.getChildCount();
                int i3 = 0;
                while (true) {
                    if (i3 >= childCount) {
                        z2 = false;
                        break;
                    } else if (dVar.getChildAt(i3).getWidth() <= 0) {
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
                        e();
                        this.y.setIntValues(new int[]{scrollX, a2});
                        this.y.start();
                    }
                    this.q.b(i2, 300);
                    return;
                }
            }
            setScrollPosition(i2, 0.0f, true);
        }
    }

    private void e() {
        if (this.y == null) {
            this.y = new ValueAnimator();
            this.y.setInterpolator(a.f75092b);
            this.y.setDuration(300);
            this.y.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    CustomTabLayout.this.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    public void setScrollAnimatorListener(Animator.AnimatorListener animatorListener) {
        e();
        this.y.addListener(animatorListener);
    }

    public void setSelectedTabView(int i2) {
        int childCount = this.q.getChildCount();
        if (i2 < childCount) {
            int i3 = 0;
            while (i3 < childCount) {
                this.q.getChildAt(i3).setSelected(i3 == i2);
                i3++;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void b(e eVar) {
        b(eVar, true);
    }

    /* access modifiers changed from: package-private */
    public final void b(e eVar, boolean z2) {
        int i2;
        e eVar2 = this.p;
        if (eVar2 != eVar) {
            if (eVar != null) {
                i2 = eVar.f75077d;
            } else {
                i2 = -1;
            }
            if (z2) {
                if ((eVar2 == null || eVar2.f75077d == -1) && i2 != -1) {
                    setScrollPosition(i2, 0.0f, true);
                } else {
                    d(i2);
                }
                if (i2 != -1) {
                    setSelectedTabView(i2);
                }
            }
            if (eVar2 != null) {
                f(eVar2);
            }
            this.p = eVar;
            if (eVar != null) {
                e(eVar);
            }
        } else if (eVar2 != null) {
            f();
            d(eVar.f75077d);
        }
    }

    private void e(e eVar) {
        for (int size = this.w.size() - 1; size >= 0; size--) {
            this.w.get(size).a(eVar);
        }
    }

    private void f(e eVar) {
        for (int size = this.w.size() - 1; size >= 0; size--) {
            this.w.get(size).b(eVar);
        }
    }

    private void f() {
        for (int size = this.w.size() - 1; size >= 0; size--) {
            this.w.get(size);
        }
    }

    private int a(int i2, float f2) {
        int i3 = 0;
        if (this.l != 0) {
            return 0;
        }
        View childAt = this.q.getChildAt(i2);
        int i4 = i2 + 1;
        View childAt2 = i4 < this.q.getChildCount() ? this.q.getChildAt(i4) : null;
        int width = childAt != null ? childAt.getWidth() : 0;
        if (childAt2 != null) {
            i3 = childAt2.getWidth();
        }
        int left = (childAt.getLeft() + (width / 2)) - (getWidth() / 2);
        int i5 = (int) (((float) (width + i3)) * 0.5f * f2);
        return u.j(this) == 0 ? left + i5 : left - i5;
    }

    private void g() {
        u.b(this.q, this.l == 0 ? Math.max(0, this.u - this.f75037a) : 0, 0, 0, 0);
        int i2 = this.l;
        if (i2 == 0) {
            this.q.setGravity(8388611);
        } else if (i2 == 1) {
            this.q.setGravity(1);
        }
        a(true);
    }

    /* access modifiers changed from: package-private */
    public final void a(boolean z2) {
        for (int i2 = 0; i2 < this.q.getChildCount(); i2++) {
            View childAt = this.q.getChildAt(i2);
            childAt.setMinimumWidth(getTabMinWidth());
            a((LinearLayout.LayoutParams) childAt.getLayoutParams());
            if (z2) {
                childAt.requestLayout();
            }
        }
    }

    public static final class e {

        /* renamed from: a  reason: collision with root package name */
        Drawable f75074a;

        /* renamed from: b  reason: collision with root package name */
        CharSequence f75075b;

        /* renamed from: c  reason: collision with root package name */
        CharSequence f75076c;

        /* renamed from: d  reason: collision with root package name */
        public int f75077d = -1;

        /* renamed from: e  reason: collision with root package name */
        public View f75078e;

        /* renamed from: f  reason: collision with root package name */
        CustomTabLayout f75079f;

        /* renamed from: g  reason: collision with root package name */
        public TabView f75080g;

        /* renamed from: h  reason: collision with root package name */
        private Object f75081h;

        e() {
        }

        public final e a(View view) {
            this.f75078e = view;
            c();
            return this;
        }

        public final e a(CharSequence charSequence) {
            this.f75075b = charSequence;
            c();
            return this;
        }

        public final void a() {
            CustomTabLayout customTabLayout = this.f75079f;
            if (customTabLayout != null) {
                customTabLayout.b(this);
                return;
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        public final boolean b() {
            CustomTabLayout customTabLayout = this.f75079f;
            if (customTabLayout != null) {
                return customTabLayout.getSelectedTabPosition() == this.f75077d;
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        /* access modifiers changed from: package-private */
        public final void c() {
            TabView tabView = this.f75080g;
            if (tabView != null) {
                tabView.b();
            }
        }

        /* access modifiers changed from: package-private */
        public final void d() {
            this.f75079f = null;
            this.f75080g = null;
            this.f75081h = null;
            this.f75074a = null;
            this.f75075b = null;
            this.f75076c = null;
            this.f75077d = -1;
            this.f75078e = null;
        }
    }

    public class TabView extends LinearLayout {

        /* renamed from: b  reason: collision with root package name */
        private e f75048b;

        /* renamed from: c  reason: collision with root package name */
        private TextView f75049c;

        /* renamed from: d  reason: collision with root package name */
        private ImageView f75050d;

        /* renamed from: e  reason: collision with root package name */
        private View f75051e;

        /* renamed from: f  reason: collision with root package name */
        private TextView f75052f;

        /* renamed from: g  reason: collision with root package name */
        private ImageView f75053g;

        /* renamed from: h  reason: collision with root package name */
        private int f75054h = 2;

        public TabView(Context context) {
            super(context);
            if (CustomTabLayout.this.f75045i != 0) {
                u.a((View) this, androidx.appcompat.a.a.a.b(context, CustomTabLayout.this.f75045i));
            }
            u.b(this, CustomTabLayout.this.f75037a, CustomTabLayout.this.f75038b, CustomTabLayout.this.f75039c, CustomTabLayout.this.f75040d);
            setGravity(17);
            setOrientation(1);
            setClickable(true);
            u.a((View) this, s.a(getContext()));
        }

        public final boolean performClick() {
            boolean performClick = super.performClick();
            if (this.f75048b == null) {
                return performClick;
            }
            if (!performClick) {
                playSoundEffect(0);
            }
            this.f75048b.a();
            return true;
        }

        public final void setSelected(boolean z) {
            boolean z2 = isSelected() != z;
            super.setSelected(z);
            if (z2 && z && Build.VERSION.SDK_INT < 16) {
                sendAccessibilityEvent(4);
            }
            TextView textView = this.f75049c;
            if (textView != null) {
                textView.setSelected(z);
            }
            ImageView imageView = this.f75050d;
            if (imageView != null) {
                imageView.setSelected(z);
            }
            View view = this.f75051e;
            if (view != null) {
                view.setSelected(z);
            }
        }

        public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(ActionBar.a.class.getName());
        }

        public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(ActionBar.a.class.getName());
        }

        public final void onMeasure(int i2, int i3) {
            Layout layout;
            int size = View.MeasureSpec.getSize(i2);
            int mode = View.MeasureSpec.getMode(i2);
            int tabMaxWidth = CustomTabLayout.this.getTabMaxWidth();
            if (tabMaxWidth > 0 && (mode == 0 || size > tabMaxWidth)) {
                i2 = View.MeasureSpec.makeMeasureSpec(CustomTabLayout.this.j, Integer.MIN_VALUE);
            }
            super.onMeasure(i2, i3);
            if (this.f75049c != null) {
                getResources();
                float f2 = CustomTabLayout.this.f75043g;
                int i4 = this.f75054h;
                ImageView imageView = this.f75050d;
                boolean z = true;
                if (imageView == null || imageView.getVisibility() != 0) {
                    TextView textView = this.f75049c;
                    if (textView != null && textView.getLineCount() > 1) {
                        f2 = CustomTabLayout.this.f75044h;
                    }
                } else {
                    i4 = 1;
                }
                float textSize = this.f75049c.getTextSize();
                int lineCount = this.f75049c.getLineCount();
                int a2 = i.a(this.f75049c);
                int i5 = (f2 > textSize ? 1 : (f2 == textSize ? 0 : -1));
                if (i5 != 0 || (a2 >= 0 && i4 != a2)) {
                    if (CustomTabLayout.this.l == 1 && i5 > 0 && lineCount == 1 && ((layout = this.f75049c.getLayout()) == null || layout.getLineWidth(0) * (f2 / layout.getPaint().getTextSize()) > ((float) ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight())))) {
                        z = false;
                    }
                    if (z) {
                        this.f75049c.setTextSize(0, f2);
                        this.f75049c.setMaxLines(i4);
                        super.onMeasure(i2, i3);
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final void setTab(e eVar) {
            if (eVar != this.f75048b) {
                this.f75048b = eVar;
                b();
            }
        }

        /* access modifiers changed from: package-private */
        public final void a() {
            setTab((e) null);
            setSelected(false);
        }

        /* access modifiers changed from: package-private */
        public final void b() {
            View view;
            e eVar = this.f75048b;
            if (eVar != null) {
                view = eVar.f75078e;
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
                this.f75051e = view;
                TextView textView = this.f75049c;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.f75050d;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.f75050d.setImageDrawable((Drawable) null);
                }
                this.f75052f = (TextView) view.findViewById(16908308);
                TextView textView2 = this.f75052f;
                if (textView2 != null) {
                    this.f75054h = i.a(textView2);
                }
                this.f75053g = (ImageView) view.findViewById(16908294);
            } else {
                View view2 = this.f75051e;
                if (view2 != null) {
                    removeView(view2);
                    this.f75051e = null;
                }
                this.f75052f = null;
                this.f75053g = null;
            }
            boolean z = false;
            if (this.f75051e == null) {
                if (this.f75050d == null) {
                    ImageView imageView2 = (ImageView) LayoutInflater.from(getContext()).inflate(com.google.android.material.R.layout.design_layout_tab_icon, this, false);
                    addView(imageView2, 0);
                    this.f75050d = imageView2;
                }
                if (this.f75049c == null) {
                    TextView textView3 = (TextView) LayoutInflater.from(getContext()).inflate(com.google.android.material.R.layout.design_layout_tab_text, this, false);
                    addView(textView3);
                    this.f75049c = textView3;
                    this.f75054h = i.a(this.f75049c);
                }
                i.a(this.f75049c, CustomTabLayout.this.f75041e);
                if (CustomTabLayout.this.f75042f != null) {
                    this.f75049c.setTextColor(CustomTabLayout.this.f75042f);
                }
                a(this.f75049c, this.f75050d);
            } else if (!(this.f75052f == null && this.f75053g == null)) {
                a(this.f75052f, this.f75053g);
            }
            if (eVar != null && eVar.b()) {
                z = true;
            }
            setSelected(z);
        }

        private void a(TextView textView, ImageView imageView) {
            Drawable drawable;
            CharSequence charSequence;
            CharSequence charSequence2;
            e eVar = this.f75048b;
            CharSequence charSequence3 = null;
            if (eVar != null) {
                drawable = eVar.f75074a;
            } else {
                drawable = null;
            }
            e eVar2 = this.f75048b;
            if (eVar2 != null) {
                charSequence = eVar2.f75075b;
            } else {
                charSequence = null;
            }
            e eVar3 = this.f75048b;
            if (eVar3 != null) {
                charSequence2 = eVar3.f75076c;
            } else {
                charSequence2 = null;
            }
            int i2 = 0;
            if (imageView != null) {
                if (drawable != null) {
                    imageView.setImageDrawable(drawable);
                    imageView.setVisibility(0);
                    setVisibility(0);
                } else {
                    imageView.setVisibility(8);
                    imageView.setImageDrawable((Drawable) null);
                }
                imageView.setContentDescription(charSequence2);
            }
            boolean z = !TextUtils.isEmpty(charSequence);
            if (textView != null) {
                if (z) {
                    textView.setText(charSequence);
                    textView.setVisibility(0);
                    setVisibility(0);
                } else {
                    textView.setVisibility(8);
                    textView.setText((CharSequence) null);
                }
                textView.setContentDescription(charSequence2);
            }
            if (imageView != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                if (z && imageView.getVisibility() == 0) {
                    i2 = CustomTabLayout.this.b(8);
                }
                if (i2 != marginLayoutParams.bottomMargin) {
                    marginLayoutParams.bottomMargin = i2;
                    imageView.requestLayout();
                }
            }
            if (!z) {
                charSequence3 = charSequence2;
            }
            ae.a(this, charSequence3);
        }
    }

    class d extends LinearLayout {

        /* renamed from: a  reason: collision with root package name */
        int f75058a = -1;

        /* renamed from: b  reason: collision with root package name */
        float f75059b;

        /* renamed from: d  reason: collision with root package name */
        private int f75061d;

        /* renamed from: e  reason: collision with root package name */
        private int f75062e;

        /* renamed from: f  reason: collision with root package name */
        private final Paint f75063f;

        /* renamed from: g  reason: collision with root package name */
        private int f75064g = -1;

        /* renamed from: h  reason: collision with root package name */
        private int f75065h = -1;

        /* renamed from: i  reason: collision with root package name */
        private int f75066i = -1;
        private ValueAnimator j;

        d(Context context) {
            super(context);
            setWillNotDraw(false);
            this.f75063f = new Paint();
        }

        /* access modifiers changed from: package-private */
        public final void a(int i2) {
            if (this.f75063f.getColor() != i2) {
                this.f75063f.setColor(i2);
                u.g(this);
            }
        }

        /* access modifiers changed from: package-private */
        public final void b(int i2) {
            if (this.f75061d != i2) {
                this.f75061d = i2;
                u.g(this);
            }
        }

        /* access modifiers changed from: package-private */
        public final void c(int i2) {
            if (this.f75062e != i2) {
                this.f75062e = i2;
                u.g(this);
            }
        }

        /* access modifiers changed from: package-private */
        public final void a(int i2, float f2) {
            ValueAnimator valueAnimator = this.j;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.j.cancel();
            }
            this.f75058a = i2;
            this.f75059b = f2;
            a();
        }

        public final void onRtlPropertiesChanged(int i2) {
            super.onRtlPropertiesChanged(i2);
            if (Build.VERSION.SDK_INT < 23 && this.f75064g != i2) {
                requestLayout();
                this.f75064g = i2;
            }
        }

        /* access modifiers changed from: protected */
        public final void onMeasure(int i2, int i3) {
            super.onMeasure(i2, i3);
            if (View.MeasureSpec.getMode(i2) == 1073741824) {
                boolean z = true;
                if (CustomTabLayout.this.l == 1 && CustomTabLayout.this.k == 1) {
                    int childCount = getChildCount();
                    int i4 = 0;
                    for (int i5 = 0; i5 < childCount; i5++) {
                        View childAt = getChildAt(i5);
                        if (childAt.getVisibility() == 0) {
                            i4 = Math.max(i4, childAt.getMeasuredWidth());
                        }
                    }
                    if (i4 > 0) {
                        if (i4 * childCount <= getMeasuredWidth() - (CustomTabLayout.this.b(16) * 2)) {
                            boolean z2 = false;
                            for (int i6 = 0; i6 < childCount; i6++) {
                                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getChildAt(i6).getLayoutParams();
                                if (layoutParams.width != i4 || layoutParams.weight != 0.0f) {
                                    layoutParams.width = i4;
                                    layoutParams.weight = 0.0f;
                                    z2 = true;
                                }
                            }
                            z = z2;
                        } else {
                            CustomTabLayout customTabLayout = CustomTabLayout.this;
                            customTabLayout.k = 0;
                            customTabLayout.a(false);
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
            ValueAnimator valueAnimator = this.j;
            if (valueAnimator == null || !valueAnimator.isRunning()) {
                a();
                return;
            }
            this.j.cancel();
            b(this.f75058a, Math.round((1.0f - this.j.getAnimatedFraction()) * ((float) this.j.getDuration())));
        }

        private void a() {
            int i2;
            int i3;
            View childAt = getChildAt(this.f75058a);
            if (childAt == null || childAt.getWidth() <= 0) {
                i3 = -1;
                i2 = -1;
            } else {
                int left = childAt.getLeft();
                int width = childAt.getWidth();
                int i4 = this.f75062e;
                i3 = left + ((width - i4) / 2);
                i2 = i4 + i3;
                if (this.f75059b > 0.0f && this.f75058a < getChildCount() - 1) {
                    View childAt2 = getChildAt(this.f75058a + 1);
                    float f2 = this.f75059b;
                    int left2 = childAt2.getLeft();
                    int width2 = childAt2.getWidth();
                    int i5 = this.f75062e;
                    i3 = (int) ((f2 * ((float) (left2 + ((width2 - i5) / 2)))) + ((1.0f - this.f75059b) * ((float) i3)));
                    i2 = i3 + i5;
                }
            }
            a(i3, i2);
        }

        /* access modifiers changed from: package-private */
        public final void a(int i2, int i3) {
            if (i2 != this.f75065h || i3 != this.f75066i) {
                this.f75065h = i2;
                this.f75066i = i3;
                u.g(this);
            }
        }

        /* access modifiers changed from: package-private */
        public final void b(final int i2, int i3) {
            final int i4;
            final int i5;
            ValueAnimator valueAnimator = this.j;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.j.cancel();
            }
            boolean z = u.j(this) == 1;
            View childAt = getChildAt(i2);
            if (childAt == null) {
                a();
                return;
            }
            int left = childAt.getLeft();
            int width = childAt.getWidth();
            int i6 = this.f75062e;
            final int i7 = left + ((width - i6) / 2);
            final int i8 = i7 + i6;
            if (Math.abs(i2 - this.f75058a) <= 1) {
                i5 = this.f75065h;
                i4 = this.f75066i;
            } else {
                int b2 = CustomTabLayout.this.b(24);
                i5 = (i2 >= this.f75058a ? !z : z) ? i7 - b2 : b2 + i8;
                i4 = i5;
            }
            if (i5 != i7 || i4 != i8) {
                ValueAnimator valueAnimator2 = new ValueAnimator();
                this.j = valueAnimator2;
                valueAnimator2.setInterpolator(a.f75092b);
                valueAnimator2.setDuration((long) i3);
                valueAnimator2.setFloatValues(new float[]{0.0f, 1.0f});
                valueAnimator2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float animatedFraction = valueAnimator.getAnimatedFraction();
                        d.this.a(a.a(i5, i7, animatedFraction), a.a(i4, i8, animatedFraction));
                    }
                });
                valueAnimator2.addListener(new AnimatorListenerAdapter() {
                    public final void onAnimationEnd(Animator animator) {
                        d dVar = d.this;
                        dVar.f75058a = i2;
                        dVar.f75059b = 0.0f;
                    }
                });
                valueAnimator2.start();
            }
        }

        public final void draw(Canvas canvas) {
            super.draw(canvas);
            int i2 = this.f75065h;
            if (i2 >= 0 && this.f75066i > i2) {
                canvas.drawRect((float) i2, (float) (getHeight() - this.f75061d), (float) this.f75066i, (float) getHeight(), this.f75063f);
            }
        }
    }

    private static ColorStateList a(int i2, int i3) {
        return new ColorStateList(new int[][]{SELECTED_STATE_SET, EMPTY_STATE_SET}, new int[]{i3, i2});
    }

    private int getDefaultHeight() {
        int size = this.o.size();
        boolean z2 = false;
        int i2 = 0;
        while (true) {
            if (i2 < size) {
                e eVar = this.o.get(i2);
                if (eVar != null && eVar.f75074a != null && !TextUtils.isEmpty(eVar.f75075b)) {
                    z2 = true;
                    break;
                }
                i2++;
            } else {
                break;
            }
        }
        return z2 ? 72 : 48;
    }

    private int getTabMinWidth() {
        int i2 = this.r;
        if (i2 != -1) {
            return i2;
        }
        if (this.l == 0) {
            return this.t;
        }
        return 0;
    }

    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    /* access modifiers changed from: package-private */
    public int getTabMaxWidth() {
        return this.j;
    }

    public static class f implements ViewPager.e {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<CustomTabLayout> f75082a;

        /* renamed from: b  reason: collision with root package name */
        private int f75083b;

        /* renamed from: c  reason: collision with root package name */
        private int f75084c;

        public f(CustomTabLayout customTabLayout) {
            this.f75082a = new WeakReference<>(customTabLayout);
        }

        public final void onPageScrollStateChanged(int i2) {
            this.f75083b = this.f75084c;
            this.f75084c = i2;
        }

        public final void onPageScrolled(int i2, float f2, int i3) {
            CustomTabLayout customTabLayout = (CustomTabLayout) this.f75082a.get();
            if (customTabLayout != null) {
                boolean z = false;
                boolean z2 = this.f75084c != 2 || this.f75083b == 1;
                if (!(this.f75084c == 2 && this.f75083b == 0)) {
                    z = true;
                }
                customTabLayout.a(i2, f2, z2, z);
            }
        }

        public final void onPageSelected(int i2) {
            CustomTabLayout customTabLayout = (CustomTabLayout) this.f75082a.get();
            if (customTabLayout != null && customTabLayout.getSelectedTabPosition() != i2 && i2 < customTabLayout.getTabCount()) {
                int i3 = this.f75084c;
                customTabLayout.b(customTabLayout.a(i2), i3 == 0 || (i3 == 2 && this.f75083b == 0));
            }
        }

        /* access modifiers changed from: package-private */
        public final void a() {
            this.f75084c = 0;
            this.f75083b = 0;
        }
    }

    public static class g implements b {

        /* renamed from: a  reason: collision with root package name */
        private final ViewPager f75085a;

        public final void b(e eVar) {
        }

        public g(ViewPager viewPager) {
            this.f75085a = viewPager;
        }

        public final void a(e eVar) {
            this.f75085a.setCurrentItem(eVar.f75077d);
        }
    }

    class c extends DataSetObserver {
        c() {
        }

        public final void onChanged() {
            CustomTabLayout.this.c();
        }

        public final void onInvalidated() {
            CustomTabLayout.this.c();
        }
    }

    class a implements ViewPager.d {

        /* renamed from: a  reason: collision with root package name */
        boolean f75055a;

        a() {
        }

        public final void onAdapterChanged(ViewPager viewPager, androidx.viewpager.widget.a aVar, androidx.viewpager.widget.a aVar2) {
            if (CustomTabLayout.this.m == viewPager) {
                CustomTabLayout.this.a(aVar2, this.f75055a);
            }
        }
    }

    private void a(e eVar, int i2) {
        eVar.f75077d = i2;
        this.o.add(i2, eVar);
        int size = this.o.size();
        while (true) {
            i2++;
            if (i2 < size) {
                this.o.get(i2).f75077d = i2;
            } else {
                return;
            }
        }
    }
}
