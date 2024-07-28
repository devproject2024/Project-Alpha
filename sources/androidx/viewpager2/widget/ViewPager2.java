package androidx.viewpager2.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.h.a.c;
import androidx.core.h.u;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.v;
import androidx.viewpager2.R;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;

public final class ViewPager2 extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    static boolean f4984a = true;

    /* renamed from: b  reason: collision with root package name */
    int f4985b;

    /* renamed from: c  reason: collision with root package name */
    boolean f4986c = false;

    /* renamed from: d  reason: collision with root package name */
    RecyclerView f4987d;

    /* renamed from: e  reason: collision with root package name */
    e f4988e;

    /* renamed from: f  reason: collision with root package name */
    c f4989f;

    /* renamed from: g  reason: collision with root package name */
    boolean f4990g = true;

    /* renamed from: h  reason: collision with root package name */
    a f4991h;

    /* renamed from: i  reason: collision with root package name */
    private final Rect f4992i = new Rect();
    private final Rect j = new Rect();
    private b k = new b();
    private RecyclerView.c l = new c() {
        public final void onChanged() {
            ViewPager2 viewPager2 = ViewPager2.this;
            viewPager2.f4986c = true;
            viewPager2.f4988e.f5025c = true;
        }
    };
    private LinearLayoutManager m;
    private int n = -1;
    private Parcelable o;
    private v p;
    private b q;
    private d r;
    private RecyclerView.f s = null;
    private boolean t = false;
    private int u = -1;

    public static abstract class e {
        public void a(int i2) {
        }

        public void a(int i2, float f2, int i3) {
        }

        public void b(int i2) {
        }
    }

    public interface g {
    }

    public ViewPager2(Context context) {
        super(context);
        a(context, (AttributeSet) null);
    }

    public ViewPager2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    public ViewPager2(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        this.f4991h = f4984a ? new f() : new b();
        this.f4987d = new i(context);
        this.f4987d.setId(u.a());
        this.f4987d.setDescendantFocusability(131072);
        this.m = new d(context);
        this.f4987d.setLayoutManager(this.m);
        this.f4987d.setScrollingTouchSlop(1);
        b(context, attributeSet);
        this.f4987d.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.f4987d.addOnChildAttachStateChangeListener(c());
        this.f4988e = new e(this);
        this.f4989f = new c(this, this.f4988e, this.f4987d);
        this.p = new h();
        this.p.attachToRecyclerView(this.f4987d);
        this.f4987d.addOnScrollListener(this.f4988e);
        this.q = new b();
        this.f4988e.f5023a = this.q;
        AnonymousClass2 r3 = new e() {
            public final void a(int i2) {
                if (ViewPager2.this.f4985b != i2) {
                    ViewPager2 viewPager2 = ViewPager2.this;
                    viewPager2.f4985b = i2;
                    viewPager2.f4991h.e();
                }
            }

            public final void b(int i2) {
                if (i2 == 0) {
                    ViewPager2.this.a();
                }
            }
        };
        AnonymousClass3 r4 = new e() {
            public final void a(int i2) {
                ViewPager2.this.clearFocus();
                if (ViewPager2.this.hasFocus()) {
                    ViewPager2.this.f4987d.requestFocus(2);
                }
            }
        };
        this.q.a((e) r3);
        this.q.a((e) r4);
        this.f4991h.a(this.f4987d);
        this.q.a((e) this.k);
        this.r = new d(this.m);
        this.q.a((e) this.r);
        RecyclerView recyclerView = this.f4987d;
        attachViewToParent(recyclerView, 0, recyclerView.getLayoutParams());
    }

    private RecyclerView.i c() {
        return new RecyclerView.i() {
            public final void b(View view) {
            }

            public final void a(View view) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                if (layoutParams.width != -1 || layoutParams.height != -1) {
                    throw new IllegalStateException("Pages must fill the whole ViewPager2 (use match_parent)");
                }
            }
        };
    }

    public final CharSequence getAccessibilityClassName() {
        if (this.f4991h.a()) {
            return this.f4991h.b();
        }
        return super.getAccessibilityClassName();
    }

    private void b(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ViewPager2);
        if (Build.VERSION.SDK_INT >= 29) {
            saveAttributeDataForStyleable(context, R.styleable.ViewPager2, attributeSet, obtainStyledAttributes, 0, 0);
        }
        try {
            setOrientation(obtainStyledAttributes.getInt(R.styleable.ViewPager2_android_orientation, 0));
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    /* access modifiers changed from: protected */
    public final Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f4997a = this.f4987d.getId();
        int i2 = this.n;
        if (i2 == -1) {
            i2 = this.f4985b;
        }
        savedState.f4998b = i2;
        Parcelable parcelable = this.o;
        if (parcelable != null) {
            savedState.f4999c = parcelable;
        } else {
            RecyclerView.a adapter = this.f4987d.getAdapter();
            if (adapter instanceof androidx.viewpager2.adapter.c) {
                savedState.f4999c = ((androidx.viewpager2.adapter.c) adapter).a();
            }
        }
        return savedState;
    }

    /* access modifiers changed from: protected */
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.n = savedState.f4998b;
        this.o = savedState.f4999c;
    }

    private void d() {
        RecyclerView.a adapter;
        if (this.n != -1 && (adapter = getAdapter()) != null) {
            if (this.o != null) {
                this.o = null;
            }
            this.f4985b = Math.max(0, Math.min(this.n, adapter.getItemCount() - 1));
            this.n = -1;
            this.f4987d.scrollToPosition(this.f4985b);
            this.f4991h.c();
        }
    }

    /* access modifiers changed from: protected */
    public final void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        Parcelable parcelable = sparseArray.get(getId());
        if (parcelable instanceof SavedState) {
            int i2 = ((SavedState) parcelable).f4997a;
            sparseArray.put(this.f4987d.getId(), sparseArray.get(i2));
            sparseArray.remove(i2);
        }
        super.dispatchRestoreInstanceState(sparseArray);
        d();
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return a(parcel, classLoader);
            }

            private static SavedState a(Parcel parcel, ClassLoader classLoader) {
                return Build.VERSION.SDK_INT >= 24 ? new SavedState(parcel, classLoader) : new SavedState(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
                return new SavedState[i2];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return a(parcel, (ClassLoader) null);
            }
        };

        /* renamed from: a  reason: collision with root package name */
        int f4997a;

        /* renamed from: b  reason: collision with root package name */
        int f4998b;

        /* renamed from: c  reason: collision with root package name */
        Parcelable f4999c;

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            a(parcel, classLoader);
        }

        SavedState(Parcel parcel) {
            super(parcel);
            a(parcel, (ClassLoader) null);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private void a(Parcel parcel, ClassLoader classLoader) {
            this.f4997a = parcel.readInt();
            this.f4998b = parcel.readInt();
            this.f4999c = parcel.readParcelable(classLoader);
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f4997a);
            parcel.writeInt(this.f4998b);
            parcel.writeParcelable(this.f4999c, i2);
        }
    }

    public final void setAdapter(RecyclerView.a aVar) {
        RecyclerView.a adapter = this.f4987d.getAdapter();
        this.f4991h.b((RecyclerView.a<?>) adapter);
        if (adapter != null) {
            adapter.unregisterAdapterDataObserver(this.l);
        }
        this.f4987d.setAdapter(aVar);
        this.f4985b = 0;
        d();
        this.f4991h.a((RecyclerView.a<?>) aVar);
        if (aVar != null) {
            aVar.registerAdapterDataObserver(this.l);
        }
    }

    public final RecyclerView.a getAdapter() {
        return this.f4987d.getAdapter();
    }

    public final void onViewAdded(View view) {
        throw new IllegalStateException(getClass().getSimpleName() + " does not support direct child views");
    }

    /* access modifiers changed from: protected */
    public final void onMeasure(int i2, int i3) {
        measureChild(this.f4987d, i2, i3);
        int measuredWidth = this.f4987d.getMeasuredWidth();
        int measuredHeight = this.f4987d.getMeasuredHeight();
        int measuredState = this.f4987d.getMeasuredState();
        int paddingLeft = measuredWidth + getPaddingLeft() + getPaddingRight();
        int paddingTop = measuredHeight + getPaddingTop() + getPaddingBottom();
        setMeasuredDimension(resolveSizeAndState(Math.max(paddingLeft, getSuggestedMinimumWidth()), i2, measuredState), resolveSizeAndState(Math.max(paddingTop, getSuggestedMinimumHeight()), i3, measuredState << 16));
    }

    /* access modifiers changed from: protected */
    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int measuredWidth = this.f4987d.getMeasuredWidth();
        int measuredHeight = this.f4987d.getMeasuredHeight();
        this.f4992i.left = getPaddingLeft();
        this.f4992i.right = (i4 - i2) - getPaddingRight();
        this.f4992i.top = getPaddingTop();
        this.f4992i.bottom = (i5 - i3) - getPaddingBottom();
        Gravity.apply(8388659, measuredWidth, measuredHeight, this.f4992i, this.j);
        this.f4987d.layout(this.j.left, this.j.top, this.j.right, this.j.bottom);
        if (this.f4986c) {
            a();
        }
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        v vVar = this.p;
        if (vVar != null) {
            View findSnapView = vVar.findSnapView(this.m);
            if (findSnapView != null) {
                int position = this.m.getPosition(findSnapView);
                if (position != this.f4985b && getScrollState() == 0) {
                    this.q.a(position);
                }
                this.f4986c = false;
                return;
            }
            return;
        }
        throw new IllegalStateException("Design assumption violated.");
    }

    /* access modifiers changed from: package-private */
    public final int getPageSize() {
        int height;
        int paddingBottom;
        RecyclerView recyclerView = this.f4987d;
        if (getOrientation() == 0) {
            height = recyclerView.getWidth() - recyclerView.getPaddingLeft();
            paddingBottom = recyclerView.getPaddingRight();
        } else {
            height = recyclerView.getHeight() - recyclerView.getPaddingTop();
            paddingBottom = recyclerView.getPaddingBottom();
        }
        return height - paddingBottom;
    }

    public final void setOrientation(int i2) {
        this.m.setOrientation(i2);
        this.f4991h.d();
    }

    public final int getOrientation() {
        return this.m.getOrientation();
    }

    /* access modifiers changed from: package-private */
    public final boolean b() {
        return this.m.getLayoutDirection() == 1;
    }

    public final void setCurrentItem(int i2) {
        setCurrentItem(i2, true);
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2, boolean z) {
        RecyclerView.a adapter = getAdapter();
        if (adapter == null) {
            if (this.n != -1) {
                this.n = Math.max(i2, 0);
            }
        } else if (adapter.getItemCount() > 0) {
            int min = Math.min(Math.max(i2, 0), adapter.getItemCount() - 1);
            if (min == this.f4985b && this.f4988e.a()) {
                return;
            }
            if (min != this.f4985b || !z) {
                double d2 = (double) this.f4985b;
                this.f4985b = min;
                this.f4991h.e();
                if (!this.f4988e.a()) {
                    d2 = this.f4988e.b();
                }
                this.f4988e.a(min, z);
                if (!z) {
                    this.f4987d.scrollToPosition(min);
                    return;
                }
                double d3 = (double) min;
                if (Math.abs(d3 - d2) > 3.0d) {
                    this.f4987d.scrollToPosition(d3 > d2 ? min - 3 : min + 3);
                    RecyclerView recyclerView = this.f4987d;
                    recyclerView.post(new j(min, recyclerView));
                    return;
                }
                this.f4987d.smoothScrollToPosition(min);
            }
        }
    }

    public final int getCurrentItem() {
        return this.f4985b;
    }

    public final int getScrollState() {
        return this.f4988e.f5024b;
    }

    public final void setUserInputEnabled(boolean z) {
        this.f4990g = z;
        this.f4991h.f();
    }

    public final void setOffscreenPageLimit(int i2) {
        if (i2 > 0 || i2 == -1) {
            this.u = i2;
            this.f4987d.requestLayout();
            return;
        }
        throw new IllegalArgumentException("Offscreen page limit must be OFFSCREEN_PAGE_LIMIT_DEFAULT or a number > 0");
    }

    public final int getOffscreenPageLimit() {
        return this.u;
    }

    public final boolean canScrollHorizontally(int i2) {
        return this.f4987d.canScrollHorizontally(i2);
    }

    public final boolean canScrollVertically(int i2) {
        return this.f4987d.canScrollVertically(i2);
    }

    public final void setPageTransformer(g gVar) {
        if (gVar != null) {
            if (!this.t) {
                this.s = this.f4987d.getItemAnimator();
                this.t = true;
            }
            this.f4987d.setItemAnimator((RecyclerView.f) null);
        } else if (this.t) {
            this.f4987d.setItemAnimator(this.s);
            this.s = null;
            this.t = false;
        }
        if (gVar != this.r.f5021a) {
            d dVar = this.r;
            dVar.f5021a = gVar;
            if (dVar.f5021a != null) {
                double b2 = this.f4988e.b();
                int i2 = (int) b2;
                float f2 = (float) (b2 - ((double) i2));
                this.r.a(i2, f2, Math.round(((float) getPageSize()) * f2));
            }
        }
    }

    public final void setLayoutDirection(int i2) {
        super.setLayoutDirection(i2);
        this.f4991h.g();
    }

    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        this.f4991h.a(accessibilityNodeInfo);
    }

    public final boolean performAccessibilityAction(int i2, Bundle bundle) {
        if (this.f4991h.a(i2)) {
            return this.f4991h.b(i2);
        }
        return super.performAccessibilityAction(i2, bundle);
    }

    class i extends RecyclerView {
        i(Context context) {
            super(context);
        }

        public final CharSequence getAccessibilityClassName() {
            if (ViewPager2.this.f4991h.h()) {
                return ViewPager2.this.f4991h.i();
            }
            return super.getAccessibilityClassName();
        }

        public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setFromIndex(ViewPager2.this.f4985b);
            accessibilityEvent.setToIndex(ViewPager2.this.f4985b);
            ViewPager2.this.f4991h.a(accessibilityEvent);
        }

        public final boolean onTouchEvent(MotionEvent motionEvent) {
            return ViewPager2.this.f4990g && super.onTouchEvent(motionEvent);
        }

        public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            return ViewPager2.this.f4990g && super.onInterceptTouchEvent(motionEvent);
        }
    }

    class d extends LinearLayoutManager {
        public final boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
            return false;
        }

        d(Context context) {
            super(context);
        }

        public final boolean performAccessibilityAction(RecyclerView.n nVar, RecyclerView.s sVar, int i2, Bundle bundle) {
            if (ViewPager2.this.f4991h.c(i2)) {
                return ViewPager2.this.f4991h.d(i2);
            }
            return super.performAccessibilityAction(nVar, sVar, i2, bundle);
        }

        public final void onInitializeAccessibilityNodeInfo(RecyclerView.n nVar, RecyclerView.s sVar, androidx.core.h.a.c cVar) {
            super.onInitializeAccessibilityNodeInfo(nVar, sVar, cVar);
            ViewPager2.this.f4991h.a(cVar);
        }

        public final void calculateExtraLayoutSpace(RecyclerView.s sVar, int[] iArr) {
            int offscreenPageLimit = ViewPager2.this.getOffscreenPageLimit();
            if (offscreenPageLimit == -1) {
                super.calculateExtraLayoutSpace(sVar, iArr);
                return;
            }
            int pageSize = ViewPager2.this.getPageSize() * offscreenPageLimit;
            iArr[0] = pageSize;
            iArr[1] = pageSize;
        }
    }

    class h extends v {
        h() {
        }

        public final View findSnapView(RecyclerView.LayoutManager layoutManager) {
            if (ViewPager2.this.f4989f.f5018a.f5026d) {
                return null;
            }
            return super.findSnapView(layoutManager);
        }
    }

    static class j implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final int f5012a;

        /* renamed from: b  reason: collision with root package name */
        private final RecyclerView f5013b;

        j(int i2, RecyclerView recyclerView) {
            this.f5012a = i2;
            this.f5013b = recyclerView;
        }

        public final void run() {
            this.f5013b.smoothScrollToPosition(this.f5012a);
        }
    }

    public final int getItemDecorationCount() {
        return this.f4987d.getItemDecorationCount();
    }

    abstract class a {
        /* access modifiers changed from: package-private */
        public void a(AccessibilityEvent accessibilityEvent) {
        }

        /* access modifiers changed from: package-private */
        public void a(AccessibilityNodeInfo accessibilityNodeInfo) {
        }

        /* access modifiers changed from: package-private */
        public void a(androidx.core.h.a.c cVar) {
        }

        /* access modifiers changed from: package-private */
        public void a(RecyclerView.a<?> aVar) {
        }

        /* access modifiers changed from: package-private */
        public void a(RecyclerView recyclerView) {
        }

        /* access modifiers changed from: package-private */
        public boolean a() {
            return false;
        }

        /* access modifiers changed from: package-private */
        public boolean a(int i2) {
            return false;
        }

        /* access modifiers changed from: package-private */
        public void b(RecyclerView.a<?> aVar) {
        }

        /* access modifiers changed from: package-private */
        public void c() {
        }

        /* access modifiers changed from: package-private */
        public boolean c(int i2) {
            return false;
        }

        /* access modifiers changed from: package-private */
        public void d() {
        }

        /* access modifiers changed from: package-private */
        public void e() {
        }

        /* access modifiers changed from: package-private */
        public void f() {
        }

        /* access modifiers changed from: package-private */
        public void g() {
        }

        /* access modifiers changed from: package-private */
        public boolean h() {
            return false;
        }

        private a() {
        }

        /* synthetic */ a(ViewPager2 viewPager2, byte b2) {
            this();
        }

        /* access modifiers changed from: package-private */
        public String b() {
            throw new IllegalStateException("Not implemented.");
        }

        /* access modifiers changed from: package-private */
        public boolean b(int i2) {
            throw new IllegalStateException("Not implemented.");
        }

        /* access modifiers changed from: package-private */
        public boolean d(int i2) {
            throw new IllegalStateException("Not implemented.");
        }

        /* access modifiers changed from: package-private */
        public CharSequence i() {
            throw new IllegalStateException("Not implemented.");
        }
    }

    class b extends a {
        public final boolean h() {
            return true;
        }

        public final CharSequence i() {
            return "androidx.viewpager.widget.ViewPager";
        }

        b() {
            super(ViewPager2.this, (byte) 0);
        }

        public final boolean c(int i2) {
            return (i2 == 8192 || i2 == 4096) && !ViewPager2.this.f4990g;
        }

        public final boolean d(int i2) {
            if (c(i2)) {
                return false;
            }
            throw new IllegalStateException();
        }

        public final void a(androidx.core.h.a.c cVar) {
            if (!ViewPager2.this.f4990g) {
                cVar.b(c.a.n);
                cVar.b(c.a.m);
                cVar.j(false);
            }
        }
    }

    class f extends a {

        /* renamed from: c  reason: collision with root package name */
        private final androidx.core.h.a.f f5004c = new androidx.core.h.a.f() {
            public final boolean a(View view) {
                f.this.e(((ViewPager2) view).getCurrentItem() + 1);
                return true;
            }
        };

        /* renamed from: d  reason: collision with root package name */
        private final androidx.core.h.a.f f5005d = new androidx.core.h.a.f() {
            public final boolean a(View view) {
                f.this.e(((ViewPager2) view).getCurrentItem() - 1);
                return true;
            }
        };

        /* renamed from: e  reason: collision with root package name */
        private RecyclerView.c f5006e;

        public final boolean a() {
            return true;
        }

        public final boolean a(int i2) {
            return i2 == 8192 || i2 == 4096;
        }

        public final String b() {
            return "androidx.viewpager.widget.ViewPager";
        }

        f() {
            super(ViewPager2.this, (byte) 0);
        }

        public final void a(RecyclerView recyclerView) {
            u.c((View) recyclerView, 2);
            this.f5006e = new c() {
                public final void onChanged() {
                    f.this.j();
                }
            };
            if (u.h(ViewPager2.this) == 0) {
                u.c((View) ViewPager2.this, 1);
            }
        }

        public final void c() {
            j();
        }

        public final void a(RecyclerView.a<?> aVar) {
            j();
            if (aVar != null) {
                aVar.registerAdapterDataObserver(this.f5006e);
            }
        }

        public final void b(RecyclerView.a<?> aVar) {
            if (aVar != null) {
                aVar.unregisterAdapterDataObserver(this.f5006e);
            }
        }

        public final void d() {
            j();
        }

        public final void e() {
            j();
        }

        public final void f() {
            j();
            if (Build.VERSION.SDK_INT < 21) {
                ViewPager2.this.sendAccessibilityEvent(EmiUtil.EMI_PLAN_REQUEST_CODE);
            }
        }

        public final void g() {
            j();
        }

        public final boolean b(int i2) {
            int i3;
            if (a(i2)) {
                if (i2 == 8192) {
                    i3 = ViewPager2.this.getCurrentItem() - 1;
                } else {
                    i3 = ViewPager2.this.getCurrentItem() + 1;
                }
                e(i3);
                return true;
            }
            throw new IllegalStateException();
        }

        public final void a(AccessibilityEvent accessibilityEvent) {
            accessibilityEvent.setSource(ViewPager2.this);
            accessibilityEvent.setClassName("androidx.viewpager.widget.ViewPager");
        }

        /* access modifiers changed from: package-private */
        public final void e(int i2) {
            if (ViewPager2.this.f4990g) {
                ViewPager2.this.a(i2, true);
            }
        }

        /* access modifiers changed from: package-private */
        public final void j() {
            int itemCount;
            ViewPager2 viewPager2 = ViewPager2.this;
            int i2 = 16908360;
            u.d((View) viewPager2, 16908360);
            u.d((View) viewPager2, 16908361);
            u.d((View) viewPager2, 16908358);
            u.d((View) viewPager2, 16908359);
            if (ViewPager2.this.getAdapter() != null && (itemCount = ViewPager2.this.getAdapter().getItemCount()) != 0 && ViewPager2.this.f4990g) {
                if (ViewPager2.this.getOrientation() == 0) {
                    boolean b2 = ViewPager2.this.b();
                    int i3 = b2 ? 16908360 : 16908361;
                    if (b2) {
                        i2 = 16908361;
                    }
                    if (ViewPager2.this.f4985b < itemCount - 1) {
                        u.a((View) viewPager2, new c.a(i3), this.f5004c);
                    }
                    if (ViewPager2.this.f4985b > 0) {
                        u.a((View) viewPager2, new c.a(i2), this.f5005d);
                        return;
                    }
                    return;
                }
                if (ViewPager2.this.f4985b < itemCount - 1) {
                    u.a((View) viewPager2, new c.a(16908359), this.f5004c);
                }
                if (ViewPager2.this.f4985b > 0) {
                    u.a((View) viewPager2, new c.a(16908358), this.f5005d);
                }
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:16:0x0052  */
        /* JADX WARNING: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(android.view.accessibility.AccessibilityNodeInfo r6) {
            /*
                r5 = this;
                androidx.viewpager2.widget.ViewPager2 r0 = androidx.viewpager2.widget.ViewPager2.this
                androidx.recyclerview.widget.RecyclerView$a r0 = r0.getAdapter()
                r1 = 1
                r2 = 0
                if (r0 == 0) goto L_0x002a
                androidx.viewpager2.widget.ViewPager2 r0 = androidx.viewpager2.widget.ViewPager2.this
                int r0 = r0.getOrientation()
                if (r0 != r1) goto L_0x001d
                androidx.viewpager2.widget.ViewPager2 r0 = androidx.viewpager2.widget.ViewPager2.this
                androidx.recyclerview.widget.RecyclerView$a r0 = r0.getAdapter()
                int r0 = r0.getItemCount()
                goto L_0x002b
            L_0x001d:
                androidx.viewpager2.widget.ViewPager2 r0 = androidx.viewpager2.widget.ViewPager2.this
                androidx.recyclerview.widget.RecyclerView$a r0 = r0.getAdapter()
                int r0 = r0.getItemCount()
                r3 = r0
                r0 = 0
                goto L_0x002c
            L_0x002a:
                r0 = 0
            L_0x002b:
                r3 = 0
            L_0x002c:
                androidx.core.h.a.c r4 = androidx.core.h.a.c.a((android.view.accessibility.AccessibilityNodeInfo) r6)
                androidx.core.h.a.c$b r0 = androidx.core.h.a.c.b.a(r0, r3, r2, r2)
                r4.a((java.lang.Object) r0)
                int r0 = android.os.Build.VERSION.SDK_INT
                r2 = 16
                if (r0 < r2) goto L_0x006d
                androidx.viewpager2.widget.ViewPager2 r0 = androidx.viewpager2.widget.ViewPager2.this
                androidx.recyclerview.widget.RecyclerView$a r0 = r0.getAdapter()
                if (r0 == 0) goto L_0x006d
                int r0 = r0.getItemCount()
                if (r0 == 0) goto L_0x006d
                androidx.viewpager2.widget.ViewPager2 r2 = androidx.viewpager2.widget.ViewPager2.this
                boolean r2 = r2.f4990g
                if (r2 != 0) goto L_0x0052
                goto L_0x006d
            L_0x0052:
                androidx.viewpager2.widget.ViewPager2 r2 = androidx.viewpager2.widget.ViewPager2.this
                int r2 = r2.f4985b
                if (r2 <= 0) goto L_0x005d
                r2 = 8192(0x2000, float:1.14794E-41)
                r6.addAction(r2)
            L_0x005d:
                androidx.viewpager2.widget.ViewPager2 r2 = androidx.viewpager2.widget.ViewPager2.this
                int r2 = r2.f4985b
                int r0 = r0 - r1
                if (r2 >= r0) goto L_0x0069
                r0 = 4096(0x1000, float:5.74E-42)
                r6.addAction(r0)
            L_0x0069:
                r6.setScrollable(r1)
            L_0x006d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager2.widget.ViewPager2.f.a(android.view.accessibility.AccessibilityNodeInfo):void");
        }
    }

    static abstract class c extends RecyclerView.c {
        public abstract void onChanged();

        private c() {
        }

        /* synthetic */ c(byte b2) {
            this();
        }

        public final void onItemRangeChanged(int i2, int i3) {
            onChanged();
        }

        public final void onItemRangeChanged(int i2, int i3, Object obj) {
            onChanged();
        }

        public final void onItemRangeInserted(int i2, int i3) {
            onChanged();
        }

        public final void onItemRangeRemoved(int i2, int i3) {
            onChanged();
        }

        public final void onItemRangeMoved(int i2, int i3, int i4) {
            onChanged();
        }
    }

    public final void setCurrentItem(int i2, boolean z) {
        if (!this.f4989f.f5018a.f5026d) {
            a(i2, z);
            return;
        }
        throw new IllegalStateException("Cannot change current item when ViewPager2 is fake dragging");
    }
}
