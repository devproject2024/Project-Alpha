package net.one97.paytm.recharge.common.utils;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import androidx.core.d.k;
import androidx.core.d.l;
import androidx.core.h.u;
import androidx.core.h.v;
import androidx.core.widget.d;
import com.alipay.mobile.nebula.refresh.H5PullContainer;
import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CJRRechargeNoCacheViewPager extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    private static final Comparator<a> f61455a = new Comparator<a>() {
        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            return ((a) obj).f61468b - ((a) obj2).f61468b;
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private static final Interpolator f61456b = new Interpolator() {
        public final float getInterpolation(float f2) {
            float f3 = f2 - 1.0f;
            return (f3 * f3 * f3) + 1.0f;
        }
    };
    private VelocityTracker A;
    private int B;
    private int C;
    private float D;
    private float E;
    private boolean F;
    private d G;
    private d H;
    private boolean I = true;
    private b J;
    private int K = 0;

    /* renamed from: c  reason: collision with root package name */
    private final ArrayList<a> f61457c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    private androidx.viewpager.widget.a f61458d;

    /* renamed from: e  reason: collision with root package name */
    private int f61459e;

    /* renamed from: f  reason: collision with root package name */
    private int f61460f = -1;

    /* renamed from: g  reason: collision with root package name */
    private Parcelable f61461g = null;

    /* renamed from: h  reason: collision with root package name */
    private ClassLoader f61462h = null;

    /* renamed from: i  reason: collision with root package name */
    private Scroller f61463i;
    private c j;
    private int k;
    private Drawable l;
    private int m;
    private int n;
    private boolean o;
    private boolean p;
    private boolean q;
    private boolean r;
    private int s = 0;
    private boolean t;
    private boolean u;
    private int v;
    private float w;
    private float x;
    private float y;
    private int z = -1;

    public interface b {
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        Object f61467a;

        /* renamed from: b  reason: collision with root package name */
        int f61468b;

        /* renamed from: c  reason: collision with root package name */
        boolean f61469c;

        a() {
        }
    }

    public CJRRechargeNoCacheViewPager(Context context) {
        super(context);
        b();
    }

    public CJRRechargeNoCacheViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b();
    }

    private void b() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.f61463i = new Scroller(context, f61456b);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.v = v.a(viewConfiguration);
        this.B = viewConfiguration.getScaledMinimumFlingVelocity();
        this.C = viewConfiguration.getScaledMaximumFlingVelocity();
        this.G = new d(context);
        this.H = new d(context);
        this.D = context.getResources().getDisplayMetrics().density * 2500.0f;
        this.E = 0.4f;
    }

    private void setScrollState(int i2) {
        if (this.K != i2) {
            this.K = i2;
        }
    }

    public void setAdapter(androidx.viewpager.widget.a aVar) {
        androidx.viewpager.widget.a aVar2 = this.f61458d;
        if (aVar2 != null) {
            aVar2.unregisterDataSetObserver(this.j);
            this.f61458d.startUpdate((ViewGroup) this);
            for (int i2 = 0; i2 < this.f61457c.size(); i2++) {
                a aVar3 = this.f61457c.get(i2);
                this.f61458d.destroyItem((ViewGroup) this, aVar3.f61468b, aVar3.f61467a);
            }
            this.f61458d.finishUpdate((ViewGroup) this);
            this.f61457c.clear();
            removeAllViews();
            this.f61459e = 0;
            scrollTo(0, 0);
        }
        this.f61458d = aVar;
        if (this.f61458d != null) {
            if (this.j == null) {
                this.j = new c(this, (byte) 0);
            }
            this.f61458d.registerDataSetObserver(this.j);
            this.q = false;
            if (this.f61460f >= 0) {
                this.f61458d.restoreState(this.f61461g, this.f61462h);
                a(this.f61460f, false, true);
                this.f61460f = -1;
                this.f61461g = null;
                this.f61462h = null;
                return;
            }
            c();
        }
    }

    public androidx.viewpager.widget.a getAdapter() {
        return this.f61458d;
    }

    public void setCurrentItem(int i2) {
        this.q = false;
        a(i2, !this.I, false);
    }

    public void setCurrentItem(int i2, boolean z2) {
        this.q = false;
        a(i2, z2, false);
    }

    public int getCurrentItem() {
        return this.f61459e;
    }

    private void a(int i2, boolean z2, boolean z3) {
        a(i2, z2, z3, 0);
    }

    private void a(int i2, boolean z2, boolean z3, int i3) {
        androidx.viewpager.widget.a aVar = this.f61458d;
        if (aVar == null || aVar.getCount() <= 0) {
            setScrollingCacheEnabled(false);
        } else if (z3 || this.f61459e != i2 || this.f61457c.size() == 0) {
            boolean z4 = true;
            if (i2 < 0) {
                i2 = 0;
            } else if (i2 >= this.f61458d.getCount()) {
                i2 = this.f61458d.getCount() - 1;
            }
            int i4 = this.s;
            int i5 = this.f61459e;
            if (i2 > i5 + i4 || i2 < i5 - i4) {
                for (int i6 = 0; i6 < this.f61457c.size(); i6++) {
                    this.f61457c.get(i6).f61469c = true;
                }
            }
            if (this.f61459e == i2) {
                z4 = false;
            }
            this.f61459e = i2;
            c();
            int width = (getWidth() + this.k) * i2;
            if (z2) {
                a(width, i3);
                if (z4 && this.J == null) {
                    return;
                }
                return;
            }
            d();
            scrollTo(width, 0);
        } else {
            setScrollingCacheEnabled(false);
        }
    }

    public void setOnPageChangeListener(b bVar) {
        this.J = bVar;
    }

    public int getOffscreenPageLimit() {
        return this.s;
    }

    public void setOffscreenPageLimit(int i2) {
        if (i2 < 0) {
            i2 = 0;
        }
        if (i2 != this.s) {
            this.s = i2;
            c();
        }
    }

    public void setPageMargin(int i2) {
        int i3 = this.k;
        this.k = i2;
        int width = getWidth();
        a(width, width, i2, i3);
        requestLayout();
    }

    public int getPageMargin() {
        return this.k;
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.l = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public void setPageMarginDrawable(int i2) {
        setPageMarginDrawable(getContext().getResources().getDrawable(i2));
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.l;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.l;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
    }

    private void a(int i2, int i3) {
        int i4;
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int i5 = i2 - scrollX;
        int i6 = 0 - scrollY;
        if (i5 == 0 && i6 == 0) {
            d();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        this.r = true;
        setScrollState(2);
        int abs = (int) ((((float) Math.abs(i5)) / ((float) (getWidth() + this.k))) * 100.0f);
        int abs2 = Math.abs(i3);
        if (abs2 > 0) {
            float f2 = (float) abs;
            i4 = (int) (f2 + ((f2 / (((float) abs2) / this.D)) * this.E));
        } else {
            i4 = abs + 100;
        }
        this.f61463i.startScroll(scrollX, scrollY, i5, i6, Math.min(i4, H5PullContainer.DEFALUT_DURATION));
        invalidate();
    }

    private void b(int i2, int i3) {
        a aVar = new a();
        aVar.f61468b = i2;
        aVar.f61467a = this.f61458d.instantiateItem((ViewGroup) this, i2);
        if (i3 < 0) {
            this.f61457c.add(aVar);
        } else {
            this.f61457c.add(i3, aVar);
        }
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        boolean z2 = true;
        boolean z3 = this.f61457c.size() < 3 && this.f61457c.size() < this.f61458d.getCount();
        int i2 = 0;
        int i3 = -1;
        while (i2 < this.f61457c.size()) {
            a aVar = this.f61457c.get(i2);
            int itemPosition = this.f61458d.getItemPosition(aVar.f61467a);
            if (itemPosition != -1) {
                if (itemPosition == -2) {
                    this.f61457c.remove(i2);
                    i2--;
                    this.f61458d.destroyItem((ViewGroup) this, aVar.f61468b, aVar.f61467a);
                    if (this.f61459e == aVar.f61468b) {
                        i3 = Math.max(0, Math.min(this.f61459e, this.f61458d.getCount() - 1));
                    }
                } else if (aVar.f61468b != itemPosition) {
                    if (aVar.f61468b == this.f61459e) {
                        i3 = itemPosition;
                    }
                    aVar.f61468b = itemPosition;
                }
                z3 = true;
            }
            i2++;
        }
        Collections.sort(this.f61457c, f61455a);
        if (i3 >= 0) {
            a(i3, false, true);
        } else {
            z2 = z3;
        }
        if (z2) {
            c();
            requestLayout();
        }
    }

    private void c() {
        int i2;
        a aVar;
        a aVar2;
        if (this.f61458d != null && !this.q && getWindowToken() != null) {
            this.f61458d.startUpdate((ViewGroup) this);
            int i3 = this.s;
            int i4 = 0;
            int max = Math.max(0, this.f61459e - i3);
            int min = Math.min(this.f61458d.getCount() - 1, this.f61459e + i3);
            int i5 = 0;
            int i6 = -1;
            while (i5 < this.f61457c.size()) {
                a aVar3 = this.f61457c.get(i5);
                if ((aVar3.f61468b < max || aVar3.f61468b > min) && !aVar3.f61469c) {
                    this.f61457c.remove(i5);
                    i5--;
                    this.f61458d.destroyItem((ViewGroup) this, aVar3.f61468b, aVar3.f61467a);
                } else if (i6 < min && aVar3.f61468b > max) {
                    int i7 = i6 + 1;
                    if (i7 < max) {
                        i7 = max;
                    }
                    while (i7 <= min && i7 < aVar3.f61468b) {
                        b(i7, i5);
                        i7++;
                        i5++;
                    }
                }
                i6 = aVar3.f61468b;
                i5++;
            }
            if (this.f61457c.size() > 0) {
                ArrayList<a> arrayList = this.f61457c;
                i2 = arrayList.get(arrayList.size() - 1).f61468b;
            } else {
                i2 = -1;
            }
            if (i2 < min) {
                int i8 = i2 + 1;
                if (i8 > max) {
                    max = i8;
                }
                while (max <= min) {
                    b(max, -1);
                    max++;
                }
            }
            int i9 = 0;
            while (true) {
                aVar = null;
                if (i9 >= this.f61457c.size()) {
                    aVar2 = null;
                    break;
                } else if (this.f61457c.get(i9).f61468b == this.f61459e) {
                    aVar2 = this.f61457c.get(i9);
                    break;
                } else {
                    i9++;
                }
            }
            this.f61458d.setPrimaryItem((ViewGroup) this, this.f61459e, aVar2 != null ? aVar2.f61467a : null);
            this.f61458d.finishUpdate((ViewGroup) this);
            if (hasFocus()) {
                View findFocus = findFocus();
                if (findFocus != null) {
                    aVar = b(findFocus);
                }
                if (aVar == null || aVar.f61468b != this.f61459e) {
                    while (i4 < getChildCount()) {
                        View childAt = getChildAt(i4);
                        a a2 = a(childAt);
                        if (a2 == null || a2.f61468b != this.f61459e || !childAt.requestFocus(2)) {
                            i4++;
                        } else {
                            return;
                        }
                    }
                }
            }
        }
    }

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = k.a(new l<SavedState>() {
            public final /* bridge */ /* synthetic */ Object[] a(int i2) {
                return new SavedState[i2];
            }

            public final /* synthetic */ Object a(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }
        });

        /* renamed from: a  reason: collision with root package name */
        int f61464a;

        /* renamed from: b  reason: collision with root package name */
        Parcelable f61465b;

        /* renamed from: c  reason: collision with root package name */
        ClassLoader f61466c;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f61464a);
            parcel.writeParcelable(this.f61465b, i2);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.f61464a + "}";
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel);
            classLoader = classLoader == null ? getClass().getClassLoader() : classLoader;
            this.f61464a = parcel.readInt();
            this.f61465b = parcel.readParcelable(classLoader);
            this.f61466c = classLoader;
        }
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f61464a = this.f61459e;
        androidx.viewpager.widget.a aVar = this.f61458d;
        if (aVar != null) {
            savedState.f61465b = aVar.saveState();
        }
        return savedState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        androidx.viewpager.widget.a aVar = this.f61458d;
        if (aVar != null) {
            aVar.restoreState(savedState.f61465b, savedState.f61466c);
            a(savedState.f61464a, false, true);
            return;
        }
        this.f61460f = savedState.f61464a;
        this.f61461g = savedState.f61465b;
        this.f61462h = savedState.f61466c;
    }

    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (this.o) {
            addViewInLayout(view, i2, layoutParams);
            view.measure(this.m, this.n);
            return;
        }
        super.addView(view, i2, layoutParams);
    }

    private a a(View view) {
        for (int i2 = 0; i2 < this.f61457c.size(); i2++) {
            a aVar = this.f61457c.get(i2);
            if (this.f61458d.isViewFromObject(view, aVar.f61467a)) {
                return aVar;
            }
        }
        return null;
    }

    private a b(View view) {
        while (true) {
            ViewParent parent = view.getParent();
            if (parent == this) {
                return a(view);
            }
            if (parent == null || !(parent instanceof View)) {
                return null;
            }
            view = (View) parent;
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.I = true;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        setMeasuredDimension(getDefaultSize(0, i2), getDefaultSize(0, i3));
        this.m = View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824);
        this.n = View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824);
        this.o = true;
        c();
        this.o = false;
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                childAt.measure(this.m, this.n);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 != i4) {
            int i6 = this.k;
            a(i2, i4, i6, i6);
        }
    }

    private void a(int i2, int i3, int i4, int i5) {
        int i6 = i2 + i4;
        if (i3 > 0) {
            int scrollX = getScrollX();
            int i7 = i3 + i5;
            int i8 = scrollX / i7;
            int i9 = (int) ((((float) i8) + (((float) (scrollX % i7)) / ((float) i7))) * ((float) i6));
            scrollTo(i9, getScrollY());
            if (!this.f61463i.isFinished()) {
                this.f61463i.startScroll(i9, 0, this.f61459e * i6, 0, this.f61463i.getDuration() - this.f61463i.timePassed());
                return;
            }
            return;
        }
        int i10 = this.f61459e * i6;
        if (i10 != getScrollX()) {
            d();
            scrollTo(i10, getScrollY());
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        a a2;
        this.o = true;
        c();
        this.o = false;
        int childCount = getChildCount();
        int i6 = i4 - i2;
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (!(childAt.getVisibility() == 8 || (a2 = a(childAt)) == null)) {
                int paddingLeft = getPaddingLeft() + ((this.k + i6) * a2.f61468b);
                int paddingTop = getPaddingTop();
                childAt.layout(paddingLeft, paddingTop, childAt.getMeasuredWidth() + paddingLeft, childAt.getMeasuredHeight() + paddingTop);
            }
        }
        this.I = false;
    }

    public void computeScroll() {
        if (this.f61463i.isFinished() || !this.f61463i.computeScrollOffset()) {
            d();
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.f61463i.getCurrX();
        int currY = this.f61463i.getCurrY();
        if (!(scrollX == currX && scrollY == currY)) {
            scrollTo(currX, currY);
        }
        if (this.J != null) {
            getWidth();
        }
        invalidate();
    }

    private void d() {
        boolean z2 = this.r;
        if (z2) {
            setScrollingCacheEnabled(false);
            this.f61463i.abortAnimation();
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.f61463i.getCurrX();
            int currY = this.f61463i.getCurrY();
            if (!(scrollX == currX && scrollY == currY)) {
                scrollTo(currX, currY);
            }
            setScrollState(0);
        }
        this.q = false;
        this.r = false;
        boolean z3 = z2;
        for (int i2 = 0; i2 < this.f61457c.size(); i2++) {
            a aVar = this.f61457c.get(i2);
            if (aVar.f61469c) {
                aVar.f61469c = false;
                z3 = true;
            }
        }
        if (z3) {
            c();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        androidx.viewpager.widget.a aVar;
        int action = motionEvent.getAction() & PriceRangeSeekBar.INVALID_POINTER_ID;
        if (action == 3 || action == 1) {
            this.t = false;
            this.u = false;
            this.z = -1;
            return false;
        }
        if (action != 0) {
            if (this.t) {
                return true;
            }
            if (this.u) {
                return false;
            }
        }
        if (action == 0) {
            float x2 = motionEvent.getX();
            this.w = x2;
            this.x = x2;
            this.y = motionEvent.getY();
            this.z = motionEvent.getPointerId(0);
            if (this.K == 2) {
                this.t = true;
                this.u = false;
                setScrollState(1);
            } else {
                d();
                this.t = false;
                this.u = false;
            }
        } else if (action == 2) {
            int i2 = this.z;
            if (i2 != -1) {
                int findPointerIndex = motionEvent.findPointerIndex(i2);
                float x3 = motionEvent.getX(findPointerIndex);
                float f2 = x3 - this.x;
                float abs = Math.abs(f2);
                float y2 = motionEvent.getY(findPointerIndex);
                float abs2 = Math.abs(y2 - this.y);
                int scrollX = getScrollX();
                if ((f2 <= 0.0f || scrollX != 0) && f2 < 0.0f && (aVar = this.f61458d) != null) {
                    aVar.getCount();
                    getWidth();
                }
                if (a(this, false, (int) f2, (int) x3, (int) y2)) {
                    this.x = x3;
                    this.w = x3;
                    this.y = y2;
                    return false;
                } else if (abs > ((float) this.v) && abs > abs2) {
                    this.t = true;
                    setScrollState(1);
                    this.x = x3;
                    setScrollingCacheEnabled(true);
                } else if (abs2 > ((float) this.v)) {
                    this.u = true;
                }
            }
        } else if (action == 6) {
            a(motionEvent);
        }
        return this.t;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        androidx.viewpager.widget.a aVar;
        boolean a2;
        boolean a3;
        if (this.F) {
            return true;
        }
        boolean z2 = false;
        if ((motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) || (aVar = this.f61458d) == null || aVar.getCount() == 0) {
            return false;
        }
        if (this.A == null) {
            this.A = VelocityTracker.obtain();
        }
        this.A.addMovement(motionEvent);
        int action = motionEvent.getAction() & PriceRangeSeekBar.INVALID_POINTER_ID;
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    if (!this.t) {
                        int findPointerIndex = motionEvent.findPointerIndex(this.z);
                        float x2 = motionEvent.getX(findPointerIndex);
                        float abs = Math.abs(x2 - this.x);
                        float abs2 = Math.abs(motionEvent.getY(findPointerIndex) - this.y);
                        if (abs > ((float) this.v) && abs > abs2) {
                            this.t = true;
                            this.x = x2;
                            setScrollState(1);
                            setScrollingCacheEnabled(true);
                        }
                    }
                    if (this.t) {
                        float x3 = motionEvent.getX(motionEvent.findPointerIndex(this.z));
                        float f2 = this.x - x3;
                        this.x = x3;
                        float scrollX = ((float) getScrollX()) + f2;
                        int width = getWidth();
                        int i2 = this.k + width;
                        int count = this.f61458d.getCount() - 1;
                        float max = (float) Math.max(0, (this.f61459e - 1) * i2);
                        float min = (float) (Math.min(this.f61459e + 1, count) * i2);
                        if (scrollX < max) {
                            if (max == 0.0f) {
                                z2 = this.G.a((-scrollX) / ((float) width));
                            }
                            scrollX = max;
                        } else if (scrollX > min) {
                            if (min == ((float) (count * i2))) {
                                z2 = this.H.a((scrollX - min) / ((float) width));
                            }
                            scrollX = min;
                        }
                        int i3 = (int) scrollX;
                        this.x += scrollX - ((float) i3);
                        scrollTo(i3, getScrollY());
                    }
                } else if (action != 3) {
                    if (action == 5) {
                        int actionIndex = motionEvent.getActionIndex();
                        this.x = motionEvent.getX(actionIndex);
                        this.z = motionEvent.getPointerId(actionIndex);
                    } else if (action == 6) {
                        a(motionEvent);
                        this.x = motionEvent.getX(motionEvent.findPointerIndex(this.z));
                    }
                } else if (this.t) {
                    a(this.f61459e, true, true);
                    this.z = -1;
                    e();
                    a2 = this.G.a();
                    a3 = this.H.a();
                }
            } else if (this.t) {
                VelocityTracker velocityTracker = this.A;
                velocityTracker.computeCurrentVelocity(1000, (float) this.C);
                int xVelocity = (int) velocityTracker.getXVelocity(this.z);
                this.q = true;
                int scrollX2 = getScrollX() / (getWidth() + this.k);
                if (xVelocity <= 0) {
                    scrollX2++;
                }
                a(scrollX2, true, true, xVelocity);
                this.z = -1;
                e();
                a2 = this.G.a();
                a3 = this.H.a();
            }
            z2 = a2 | a3;
        } else {
            d();
            float x4 = motionEvent.getX();
            this.w = x4;
            this.x = x4;
            this.z = motionEvent.getPointerId(0);
        }
        if (z2) {
            invalidate();
        }
        return true;
    }

    public void draw(Canvas canvas) {
        androidx.viewpager.widget.a aVar;
        super.draw(canvas);
        int a2 = u.a((View) this);
        boolean z2 = false;
        int i2 = 1;
        if (a2 == 0 || (a2 == 1 && (aVar = this.f61458d) != null && aVar.getCount() > 1)) {
            if (!this.G.f3191a.isFinished()) {
                int save = canvas.save();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(270.0f);
                canvas.translate((float) ((-height) + getPaddingTop()), 0.0f);
                this.G.a(height, getWidth());
                z2 = false | this.G.a(canvas);
                canvas.restoreToCount(save);
            }
            if (!this.H.f3191a.isFinished()) {
                int save2 = canvas.save();
                int width = getWidth();
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                androidx.viewpager.widget.a aVar2 = this.f61458d;
                if (aVar2 != null) {
                    i2 = aVar2.getCount();
                }
                canvas.rotate(90.0f);
                int i3 = this.k;
                canvas.translate((float) (-getPaddingTop()), (float) (((-i2) * (width + i3)) + i3));
                this.H.a(height2, width);
                z2 |= this.H.a(canvas);
                canvas.restoreToCount(save2);
            }
        } else {
            this.G.f3191a.finish();
            this.H.f3191a.finish();
        }
        if (z2) {
            invalidate();
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.k > 0 && this.l != null) {
            int scrollX = getScrollX();
            int width = getWidth();
            int i2 = this.k;
            int i3 = scrollX % (width + i2);
            if (i3 != 0) {
                int i4 = (scrollX - i3) + width;
                this.l.setBounds(i4, 0, i2 + i4, getHeight());
                this.l.draw(canvas);
            }
        }
    }

    private void e() {
        this.t = false;
        this.u = false;
        VelocityTracker velocityTracker = this.A;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.A = null;
        }
    }

    private void setScrollingCacheEnabled(boolean z2) {
        if (this.p != z2) {
            this.p = z2;
        }
    }

    private boolean a(View view, boolean z2, int i2, int i3, int i4) {
        int i5;
        View view2 = view;
        if (view2 instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view2;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i6 = i3 + scrollX;
                if (i6 >= childAt.getLeft() && i6 < childAt.getRight() && (i5 = i4 + scrollY) >= childAt.getTop() && i5 < childAt.getBottom()) {
                    if (a(childAt, true, i2, i6 - childAt.getLeft(), i5 - childAt.getTop())) {
                        return true;
                    }
                }
            }
        }
        if (!z2 || !u.a(view, -i2)) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0048 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean dispatchKeyEvent(android.view.KeyEvent r5) {
        /*
            r4 = this;
            boolean r0 = super.dispatchKeyEvent(r5)
            r1 = 1
            if (r0 != 0) goto L_0x0049
            int r0 = r5.getAction()
            r2 = 0
            if (r0 != 0) goto L_0x0044
            int r0 = r5.getKeyCode()
            r3 = 21
            if (r0 == r3) goto L_0x003d
            r3 = 22
            if (r0 == r3) goto L_0x0036
            r3 = 61
            if (r0 == r3) goto L_0x001f
            goto L_0x0044
        L_0x001f:
            boolean r0 = r5.hasNoModifiers()
            if (r0 == 0) goto L_0x002b
            r5 = 2
            boolean r5 = r4.a((int) r5)
            goto L_0x0045
        L_0x002b:
            boolean r5 = r5.hasModifiers(r1)
            if (r5 == 0) goto L_0x0044
            boolean r5 = r4.a((int) r1)
            goto L_0x0045
        L_0x0036:
            r5 = 66
            boolean r5 = r4.a((int) r5)
            goto L_0x0045
        L_0x003d:
            r5 = 17
            boolean r5 = r4.a((int) r5)
            goto L_0x0045
        L_0x0044:
            r5 = 0
        L_0x0045:
            if (r5 == 0) goto L_0x0048
            goto L_0x0049
        L_0x0048:
            return r2
        L_0x0049:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.utils.CJRRechargeNoCacheViewPager.dispatchKeyEvent(android.view.KeyEvent):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x004c, code lost:
        if (r6 != 2) goto L_0x0057;
     */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0059  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(int r6) {
        /*
            r5 = this;
            android.view.View r0 = r5.findFocus()
            if (r0 != r5) goto L_0x0007
            r0 = 0
        L_0x0007:
            r1 = 0
            android.view.FocusFinder r2 = android.view.FocusFinder.getInstance()
            android.view.View r2 = r2.findNextFocus(r5, r0, r6)
            r3 = 66
            r4 = 17
            if (r2 == 0) goto L_0x0043
            if (r2 == r0) goto L_0x0043
            if (r6 != r4) goto L_0x0030
            if (r0 == 0) goto L_0x002b
            int r1 = r2.getLeft()
            int r0 = r0.getLeft()
            if (r1 < r0) goto L_0x002b
            boolean r1 = r5.f()
            goto L_0x0057
        L_0x002b:
            boolean r1 = r2.requestFocus()
            goto L_0x0057
        L_0x0030:
            if (r6 != r3) goto L_0x0057
            if (r0 == 0) goto L_0x003e
            int r1 = r2.getLeft()
            int r0 = r0.getLeft()
            if (r1 <= r0) goto L_0x004e
        L_0x003e:
            boolean r1 = r2.requestFocus()
            goto L_0x0057
        L_0x0043:
            if (r6 == r4) goto L_0x0053
            r0 = 1
            if (r6 != r0) goto L_0x0049
            goto L_0x0053
        L_0x0049:
            if (r6 == r3) goto L_0x004e
            r0 = 2
            if (r6 != r0) goto L_0x0057
        L_0x004e:
            boolean r1 = r5.g()
            goto L_0x0057
        L_0x0053:
            boolean r1 = r5.f()
        L_0x0057:
            if (r1 == 0) goto L_0x0060
            int r6 = android.view.SoundEffectConstants.getContantForFocusDirection(r6)
            r5.playSoundEffect(r6)
        L_0x0060:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.utils.CJRRechargeNoCacheViewPager.a(int):boolean");
    }

    private boolean f() {
        int i2 = this.f61459e;
        if (i2 <= 0) {
            return false;
        }
        setCurrentItem(i2 - 1, true);
        return true;
    }

    private boolean g() {
        androidx.viewpager.widget.a aVar = this.f61458d;
        if (aVar == null || this.f61459e >= aVar.getCount() - 1) {
            return false;
        }
        setCurrentItem(this.f61459e + 1, true);
        return true;
    }

    public void addFocusables(ArrayList<View> arrayList, int i2, int i3) {
        a a2;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i4 = 0; i4 < getChildCount(); i4++) {
                View childAt = getChildAt(i4);
                if (childAt.getVisibility() == 0 && (a2 = a(childAt)) != null && a2.f61468b == this.f61459e) {
                    childAt.addFocusables(arrayList, i2, i3);
                }
            }
        }
        if ((descendantFocusability == 262144 && size != arrayList.size()) || !isFocusable()) {
            return;
        }
        if (((i3 & 1) != 1 || !isInTouchMode() || isFocusableInTouchMode()) && arrayList != null) {
            arrayList.add(this);
        }
    }

    public void addTouchables(ArrayList<View> arrayList) {
        a a2;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (a2 = a(childAt)) != null && a2.f61468b == this.f61459e) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean onRequestFocusInDescendants(int i2, Rect rect) {
        int i3;
        int i4;
        a a2;
        int childCount = getChildCount();
        int i5 = -1;
        if ((i2 & 2) != 0) {
            i5 = childCount;
            i4 = 0;
            i3 = 1;
        } else {
            i4 = childCount - 1;
            i3 = -1;
        }
        while (i4 != i5) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() == 0 && (a2 = a(childAt)) != null && a2.f61468b == this.f61459e && childAt.requestFocus(i2, rect)) {
                return true;
            }
            i4 += i3;
        }
        return false;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        a a2;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (a2 = a(childAt)) != null && a2.f61468b == this.f61459e && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    class c extends DataSetObserver {
        private c() {
        }

        /* synthetic */ c(CJRRechargeNoCacheViewPager cJRRechargeNoCacheViewPager, byte b2) {
            this();
        }

        public final void onChanged() {
            CJRRechargeNoCacheViewPager.this.a();
        }

        public final void onInvalidated() {
            CJRRechargeNoCacheViewPager.this.a();
        }
    }

    private void a(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.z) {
            int i2 = actionIndex == 0 ? 1 : 0;
            this.x = motionEvent.getX(i2);
            this.z = motionEvent.getPointerId(i2);
            VelocityTracker velocityTracker = this.A;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }
}
