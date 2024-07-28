package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.g.c;
import androidx.core.h.a.c;
import androidx.core.h.a.f;
import androidx.core.h.ab;
import androidx.core.h.q;
import androidx.core.h.u;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import com.google.android.material.internal.k;
import com.google.android.material.k.h;
import com.google.android.material.k.i;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class AppBarLayout extends LinearLayout implements CoordinatorLayout.a {

    /* renamed from: e  reason: collision with root package name */
    private static final int f35823e = R.style.Widget_Design_AppBarLayout;

    /* renamed from: a  reason: collision with root package name */
    boolean f35824a;

    /* renamed from: b  reason: collision with root package name */
    int f35825b;

    /* renamed from: c  reason: collision with root package name */
    ab f35826c;

    /* renamed from: d  reason: collision with root package name */
    boolean f35827d;

    /* renamed from: f  reason: collision with root package name */
    private int f35828f;

    /* renamed from: g  reason: collision with root package name */
    private int f35829g;

    /* renamed from: h  reason: collision with root package name */
    private int f35830h;

    /* renamed from: i  reason: collision with root package name */
    private int f35831i;
    private List<a> j;
    private boolean k;
    private boolean l;
    private boolean m;
    private int n;
    private WeakReference<View> o;
    private ValueAnimator p;
    private int[] q;
    private Drawable r;

    public interface a<T extends AppBarLayout> {
        void onOffsetChanged(T t, int i2);
    }

    public interface b extends a<AppBarLayout> {
    }

    @Deprecated
    public float getTargetElevation() {
        return 0.0f;
    }

    public AppBarLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public AppBarLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.appBarLayoutStyle);
    }

    public AppBarLayout(Context context, AttributeSet attributeSet, int i2) {
        super(com.google.android.material.theme.a.a.a(context, attributeSet, i2, f35823e), attributeSet, i2);
        this.f35829g = -1;
        this.f35830h = -1;
        this.f35831i = -1;
        this.f35825b = 0;
        Context context2 = getContext();
        setOrientation(1);
        if (Build.VERSION.SDK_INT >= 21) {
            b.a(this);
            b.a(this, attributeSet, i2, f35823e);
        }
        TypedArray a2 = k.a(context2, attributeSet, R.styleable.AppBarLayout, i2, f35823e, new int[0]);
        u.a((View) this, a2.getDrawable(R.styleable.AppBarLayout_android_background));
        if (getBackground() instanceof ColorDrawable) {
            h hVar = new h();
            hVar.g(ColorStateList.valueOf(((ColorDrawable) getBackground()).getColor()));
            hVar.a(context2);
            u.a((View) this, (Drawable) hVar);
        }
        if (a2.hasValue(R.styleable.AppBarLayout_expanded)) {
            a(a2.getBoolean(R.styleable.AppBarLayout_expanded, false), false, false);
        }
        if (Build.VERSION.SDK_INT >= 21 && a2.hasValue(R.styleable.AppBarLayout_elevation)) {
            b.a(this, (float) a2.getDimensionPixelSize(R.styleable.AppBarLayout_elevation, 0));
        }
        if (Build.VERSION.SDK_INT >= 26) {
            if (a2.hasValue(R.styleable.AppBarLayout_android_keyboardNavigationCluster)) {
                setKeyboardNavigationCluster(a2.getBoolean(R.styleable.AppBarLayout_android_keyboardNavigationCluster, false));
            }
            if (a2.hasValue(R.styleable.AppBarLayout_android_touchscreenBlocksFocus)) {
                setTouchscreenBlocksFocus(a2.getBoolean(R.styleable.AppBarLayout_android_touchscreenBlocksFocus, false));
            }
        }
        this.f35827d = a2.getBoolean(R.styleable.AppBarLayout_liftOnScroll, false);
        this.n = a2.getResourceId(R.styleable.AppBarLayout_liftOnScrollTargetViewId, -1);
        setStatusBarForeground(a2.getDrawable(R.styleable.AppBarLayout_statusBarForeground));
        a2.recycle();
        u.a((View) this, (q) new q() {
            public final ab a(View view, ab abVar) {
                AppBarLayout appBarLayout = AppBarLayout.this;
                ab abVar2 = u.A(appBarLayout) ? abVar : null;
                if (!c.a(appBarLayout.f35826c, abVar2)) {
                    appBarLayout.f35826c = abVar2;
                    appBarLayout.a();
                    appBarLayout.requestLayout();
                }
                return abVar;
            }
        });
    }

    public void setStatusBarForeground(Drawable drawable) {
        Drawable drawable2 = this.r;
        if (drawable2 != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback((Drawable.Callback) null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.r = drawable3;
            Drawable drawable4 = this.r;
            if (drawable4 != null) {
                if (drawable4.isStateful()) {
                    this.r.setState(getDrawableState());
                }
                androidx.core.graphics.drawable.a.b(this.r, u.j(this));
                this.r.setVisible(getVisibility() == 0, false);
                this.r.setCallback(this);
            }
            a();
            u.g(this);
        }
    }

    public void setStatusBarForegroundColor(int i2) {
        setStatusBarForeground(new ColorDrawable(i2));
    }

    public void setStatusBarForegroundResource(int i2) {
        setStatusBarForeground(androidx.appcompat.a.a.a.b(getContext(), i2));
    }

    public Drawable getStatusBarForeground() {
        return this.r;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (b()) {
            int save = canvas.save();
            canvas.translate(0.0f, (float) (-this.f35828f));
            this.r.draw(canvas);
            canvas.restoreToCount(save);
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.r;
        if (drawable != null && drawable.isStateful() && drawable.setState(drawableState)) {
            invalidateDrawable(drawable);
        }
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.r;
    }

    public void setVisibility(int i2) {
        super.setVisibility(i2);
        boolean z = i2 == 0;
        Drawable drawable = this.r;
        if (drawable != null) {
            drawable.setVisible(z, false);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int mode = View.MeasureSpec.getMode(i3);
        if (mode != 1073741824 && u.A(this) && f()) {
            int measuredHeight = getMeasuredHeight();
            if (mode == Integer.MIN_VALUE) {
                measuredHeight = androidx.core.c.a.a(getMeasuredHeight() + getTopInset(), 0, View.MeasureSpec.getSize(i3));
            } else if (mode == 0) {
                measuredHeight += getTopInset();
            }
            setMeasuredDimension(getMeasuredWidth(), measuredHeight);
        }
        c();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0084, code lost:
        if (r4 != false) goto L_0x0086;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onLayout(boolean r2, int r3, int r4, int r5, int r6) {
        /*
            r1 = this;
            super.onLayout(r2, r3, r4, r5, r6)
            boolean r2 = androidx.core.h.u.A(r1)
            r3 = 1
            if (r2 == 0) goto L_0x0025
            boolean r2 = r1.f()
            if (r2 == 0) goto L_0x0025
            int r2 = r1.getTopInset()
            int r4 = r1.getChildCount()
            int r4 = r4 - r3
        L_0x0019:
            if (r4 < 0) goto L_0x0025
            android.view.View r5 = r1.getChildAt(r4)
            androidx.core.h.u.f((android.view.View) r5, (int) r2)
            int r4 = r4 + -1
            goto L_0x0019
        L_0x0025:
            r1.c()
            r2 = 0
            r1.f35824a = r2
            int r4 = r1.getChildCount()
            r5 = 0
        L_0x0030:
            if (r5 >= r4) goto L_0x0046
            android.view.View r6 = r1.getChildAt(r5)
            android.view.ViewGroup$LayoutParams r6 = r6.getLayoutParams()
            com.google.android.material.appbar.AppBarLayout$LayoutParams r6 = (com.google.android.material.appbar.AppBarLayout.LayoutParams) r6
            android.view.animation.Interpolator r6 = r6.f35850b
            if (r6 == 0) goto L_0x0043
            r1.f35824a = r3
            goto L_0x0046
        L_0x0043:
            int r5 = r5 + 1
            goto L_0x0030
        L_0x0046:
            android.graphics.drawable.Drawable r4 = r1.r
            if (r4 == 0) goto L_0x0055
            int r5 = r1.getWidth()
            int r6 = r1.getTopInset()
            r4.setBounds(r2, r2, r5, r6)
        L_0x0055:
            boolean r4 = r1.k
            if (r4 != 0) goto L_0x0090
            boolean r4 = r1.f35827d
            if (r4 != 0) goto L_0x0086
            int r4 = r1.getChildCount()
            r5 = 0
        L_0x0062:
            if (r5 >= r4) goto L_0x0083
            android.view.View r6 = r1.getChildAt(r5)
            android.view.ViewGroup$LayoutParams r6 = r6.getLayoutParams()
            com.google.android.material.appbar.AppBarLayout$LayoutParams r6 = (com.google.android.material.appbar.AppBarLayout.LayoutParams) r6
            int r0 = r6.f35849a
            r0 = r0 & r3
            if (r0 != r3) goto L_0x007b
            int r6 = r6.f35849a
            r6 = r6 & 10
            if (r6 == 0) goto L_0x007b
            r6 = 1
            goto L_0x007c
        L_0x007b:
            r6 = 0
        L_0x007c:
            if (r6 == 0) goto L_0x0080
            r4 = 1
            goto L_0x0084
        L_0x0080:
            int r5 = r5 + 1
            goto L_0x0062
        L_0x0083:
            r4 = 0
        L_0x0084:
            if (r4 == 0) goto L_0x0087
        L_0x0086:
            r2 = 1
        L_0x0087:
            boolean r3 = r1.l
            if (r3 == r2) goto L_0x0090
            r1.l = r2
            r1.refreshDrawableState()
        L_0x0090:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout.onLayout(boolean, int, int, int, int):void");
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        setWillNotDraw(!b());
    }

    private boolean b() {
        return this.r != null && getTopInset() > 0;
    }

    private void c() {
        this.f35829g = -1;
        this.f35830h = -1;
        this.f35831i = -1;
    }

    public void setOrientation(int i2) {
        if (i2 == 1) {
            super.setOrientation(i2);
            return;
        }
        throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        i.a((View) this);
    }

    public CoordinatorLayout.Behavior<AppBarLayout> getBehavior() {
        return new Behavior();
    }

    public void setElevation(float f2) {
        super.setElevation(f2);
        i.a((View) this, f2);
    }

    public void setExpanded(boolean z) {
        setExpanded(z, u.J(this));
    }

    public void setExpanded(boolean z, boolean z2) {
        a(z, z2, true);
    }

    private void a(boolean z, boolean z2, boolean z3) {
        int i2 = 0;
        int i3 = (z ? 1 : 2) | (z2 ? 4 : 0);
        if (z3) {
            i2 = 8;
        }
        this.f35825b = i3 | i2;
        requestLayout();
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    private static LayoutParams d() {
        return new LayoutParams(-1, -2);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    private static LayoutParams a(ViewGroup.LayoutParams layoutParams) {
        if (Build.VERSION.SDK_INT >= 19 && (layoutParams instanceof LinearLayout.LayoutParams)) {
            return new LayoutParams((LinearLayout.LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        e();
    }

    public final int getTotalScrollRange() {
        int i2 = this.f35829g;
        if (i2 != -1) {
            return i2;
        }
        int childCount = getChildCount();
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i3 >= childCount) {
                break;
            }
            View childAt = getChildAt(i3);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i5 = layoutParams.f35849a;
            if ((i5 & 1) == 0) {
                break;
            }
            i4 += measuredHeight + layoutParams.topMargin + layoutParams.bottomMargin;
            if (i3 == 0 && u.A(childAt)) {
                i4 -= getTopInset();
            }
            if ((i5 & 2) != 0) {
                i4 -= u.r(childAt);
                break;
            }
            i3++;
        }
        int max = Math.max(0, i4);
        this.f35829g = max;
        return max;
    }

    /* access modifiers changed from: package-private */
    public int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    /* access modifiers changed from: package-private */
    public int getDownNestedPreScrollRange() {
        int i2;
        int r2;
        int i3 = this.f35830h;
        if (i3 != -1) {
            return i3;
        }
        int i4 = 0;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i5 = layoutParams.f35849a;
            if ((i5 & 5) != 5) {
                if (i4 > 0) {
                    break;
                }
            } else {
                int i6 = layoutParams.topMargin + layoutParams.bottomMargin;
                if ((i5 & 8) != 0) {
                    r2 = u.r(childAt);
                } else if ((i5 & 2) != 0) {
                    r2 = measuredHeight - u.r(childAt);
                } else {
                    i2 = i6 + measuredHeight;
                    if (childCount == 0 && u.A(childAt)) {
                        i2 = Math.min(i2, measuredHeight - getTopInset());
                    }
                    i4 += i2;
                }
                i2 = i6 + r2;
                i2 = Math.min(i2, measuredHeight - getTopInset());
                i4 += i2;
            }
        }
        int max = Math.max(0, i4);
        this.f35830h = max;
        return max;
    }

    /* access modifiers changed from: package-private */
    public int getDownNestedScrollRange() {
        int i2 = this.f35831i;
        if (i2 != -1) {
            return i2;
        }
        int childCount = getChildCount();
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i3 >= childCount) {
                break;
            }
            View childAt = getChildAt(i3);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            int i5 = layoutParams.f35849a;
            if ((i5 & 1) == 0) {
                break;
            }
            i4 += measuredHeight;
            if ((i5 & 2) != 0) {
                i4 -= u.r(childAt);
                break;
            }
            i3++;
        }
        int max = Math.max(0, i4);
        this.f35831i = max;
        return max;
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2) {
        this.f35828f = i2;
        if (!willNotDraw()) {
            u.g(this);
        }
        List<a> list = this.j;
        if (list != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                a aVar = this.j.get(i3);
                if (aVar != null) {
                    aVar.onOffsetChanged(this, i2);
                }
            }
        }
    }

    public final int getMinimumHeightForVisibleOverlappingContent() {
        int topInset = getTopInset();
        int r2 = u.r(this);
        if (r2 == 0) {
            int childCount = getChildCount();
            r2 = childCount > 0 ? u.r(getChildAt(childCount - 1)) : 0;
            if (r2 == 0) {
                return getHeight() / 3;
            }
        }
        return (r2 * 2) + topInset;
    }

    /* access modifiers changed from: protected */
    public int[] onCreateDrawableState(int i2) {
        if (this.q == null) {
            this.q = new int[4];
        }
        int[] iArr = this.q;
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + iArr.length);
        iArr[0] = this.l ? R.attr.state_liftable : -R.attr.state_liftable;
        iArr[1] = (!this.l || !this.m) ? -R.attr.state_lifted : R.attr.state_lifted;
        iArr[2] = this.l ? R.attr.state_collapsible : -R.attr.state_collapsible;
        iArr[3] = (!this.l || !this.m) ? -R.attr.state_collapsed : R.attr.state_collapsed;
        return mergeDrawableStates(onCreateDrawableState, iArr);
    }

    /* access modifiers changed from: package-private */
    public final boolean a(boolean z) {
        if (this.m == z) {
            return false;
        }
        this.m = z;
        refreshDrawableState();
        if (this.f35827d && (getBackground() instanceof h)) {
            final h hVar = (h) getBackground();
            float dimension = getResources().getDimension(R.dimen.design_appbar_elevation);
            float f2 = z ? 0.0f : dimension;
            if (!z) {
                dimension = 0.0f;
            }
            ValueAnimator valueAnimator = this.p;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            this.p = ValueAnimator.ofFloat(new float[]{f2, dimension});
            this.p.setDuration((long) getResources().getInteger(R.integer.app_bar_elevation_anim_duration));
            this.p.setInterpolator(com.google.android.material.a.a.f35800a);
            this.p.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    hVar.r(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            });
            this.p.start();
        }
        return true;
    }

    public void setLiftOnScroll(boolean z) {
        this.f35827d = z;
    }

    public void setLiftOnScrollTargetViewId(int i2) {
        this.n = i2;
        e();
    }

    public int getLiftOnScrollTargetViewId() {
        return this.n;
    }

    private void e() {
        WeakReference<View> weakReference = this.o;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.o = null;
    }

    @Deprecated
    public void setTargetElevation(float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            b.a(this, f2);
        }
    }

    /* access modifiers changed from: package-private */
    public int getPendingAction() {
        return this.f35825b;
    }

    /* access modifiers changed from: package-private */
    public final int getTopInset() {
        ab abVar = this.f35826c;
        if (abVar != null) {
            return abVar.b();
        }
        return 0;
    }

    private boolean f() {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            if (childAt.getVisibility() == 8 || u.A(childAt)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public static class LayoutParams extends LinearLayout.LayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public int f35849a = 1;

        /* renamed from: b  reason: collision with root package name */
        Interpolator f35850b;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AppBarLayout_Layout);
            this.f35849a = obtainStyledAttributes.getInt(R.styleable.AppBarLayout_Layout_layout_scrollFlags, 0);
            if (obtainStyledAttributes.hasValue(R.styleable.AppBarLayout_Layout_layout_scrollInterpolator)) {
                this.f35850b = AnimationUtils.loadInterpolator(context, obtainStyledAttributes.getResourceId(R.styleable.AppBarLayout_Layout_layout_scrollInterpolator, 0));
            }
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(int i2, int i3) {
            super(i2, i3);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(LinearLayout.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public final void a(int i2) {
            this.f35849a = i2;
        }
    }

    public static class Behavior extends BaseBehavior<AppBarLayout> {

        public static abstract class a extends BaseBehavior.a<AppBarLayout> {
        }

        public /* bridge */ /* synthetic */ int getLeftAndRightOffset() {
            return super.getLeftAndRightOffset();
        }

        public /* bridge */ /* synthetic */ int getTopAndBottomOffset() {
            return super.getTopAndBottomOffset();
        }

        public /* bridge */ /* synthetic */ boolean isHorizontalOffsetEnabled() {
            return super.isHorizontalOffsetEnabled();
        }

        public /* bridge */ /* synthetic */ boolean isVerticalOffsetEnabled() {
            return super.isVerticalOffsetEnabled();
        }

        public /* bridge */ /* synthetic */ boolean onLayoutChild(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i2) {
            return super.onLayoutChild(coordinatorLayout, appBarLayout, i2);
        }

        public /* bridge */ /* synthetic */ boolean onMeasureChild(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i2, int i3, int i4, int i5) {
            return super.onMeasureChild(coordinatorLayout, appBarLayout, i2, i3, i4, i5);
        }

        public /* bridge */ /* synthetic */ void onNestedPreScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i2, int i3, int[] iArr, int i4) {
            super.onNestedPreScroll(coordinatorLayout, appBarLayout, view, i2, i3, iArr, i4);
        }

        public /* bridge */ /* synthetic */ void onNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i2, int i3, int i4, int i5, int i6, int[] iArr) {
            super.onNestedScroll(coordinatorLayout, appBarLayout, view, i2, i3, i4, i5, i6, iArr);
        }

        public /* bridge */ /* synthetic */ void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, Parcelable parcelable) {
            super.onRestoreInstanceState(coordinatorLayout, appBarLayout, parcelable);
        }

        public /* bridge */ /* synthetic */ Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            return super.onSaveInstanceState(coordinatorLayout, appBarLayout);
        }

        public /* bridge */ /* synthetic */ boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i2, int i3) {
            return super.onStartNestedScroll(coordinatorLayout, appBarLayout, view, view2, i2, i3);
        }

        public /* bridge */ /* synthetic */ void onStopNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i2) {
            super.onStopNestedScroll(coordinatorLayout, appBarLayout, view, i2);
        }

        public /* bridge */ /* synthetic */ void setDragCallback(BaseBehavior.a aVar) {
            super.setDragCallback(aVar);
        }

        public /* bridge */ /* synthetic */ void setHorizontalOffsetEnabled(boolean z) {
            super.setHorizontalOffsetEnabled(z);
        }

        public /* bridge */ /* synthetic */ boolean setLeftAndRightOffset(int i2) {
            return super.setLeftAndRightOffset(i2);
        }

        public /* bridge */ /* synthetic */ boolean setTopAndBottomOffset(int i2) {
            return super.setTopAndBottomOffset(i2);
        }

        public /* bridge */ /* synthetic */ void setVerticalOffsetEnabled(boolean z) {
            super.setVerticalOffsetEnabled(z);
        }

        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    protected static class BaseBehavior<T extends AppBarLayout> extends HeaderBehavior<T> {
        private static final int INVALID_POSITION = -1;
        private static final int MAX_OFFSET_ANIMATION_DURATION = 600;
        private WeakReference<View> lastNestedScrollingChildRef;
        private int lastStartedType;
        private ValueAnimator offsetAnimator;
        /* access modifiers changed from: private */
        public int offsetDelta;
        private int offsetToChildIndexOnLayout = -1;
        private boolean offsetToChildIndexOnLayoutIsMinHeight;
        private float offsetToChildIndexOnLayoutPerc;
        private a onDragCallback;

        public static abstract class a<T extends AppBarLayout> {
            public abstract boolean a(T t);
        }

        private static boolean checkFlag(int i2, int i3) {
            return (i2 & i3) == i3;
        }

        public BaseBehavior() {
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, T t, View view, int i2, int i3, int[] iArr, int i4) {
            int i5;
            int i6;
            if (i3 != 0) {
                if (i3 < 0) {
                    int i7 = -t.getTotalScrollRange();
                    i6 = i7;
                    i5 = t.getDownNestedPreScrollRange() + i7;
                } else {
                    i6 = -t.getUpNestedPreScrollRange();
                    i5 = 0;
                }
                if (i6 != i5) {
                    iArr[1] = scroll(coordinatorLayout, t, i3, i6, i5);
                }
            }
            if (t.f35827d) {
                t.a(t.a(view));
            }
        }

        public void onNestedScroll(CoordinatorLayout coordinatorLayout, T t, View view, int i2, int i3, int i4, int i5, int i6, int[] iArr) {
            if (i5 < 0) {
                iArr[1] = scroll(coordinatorLayout, t, i5, -t.getDownNestedScrollRange(), 0);
            }
            if (i5 == 0) {
                updateAccessibilityActions(coordinatorLayout, t);
            }
        }

        public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, T t, View view, int i2) {
            if (this.lastStartedType == 0 || i2 == 1) {
                snapToChildIfNeeded(coordinatorLayout, t);
                if (t.f35827d) {
                    t.a(t.a(view));
                }
            }
            this.lastNestedScrollingChildRef = new WeakReference<>(view);
        }

        public void setDragCallback(a aVar) {
            this.onDragCallback = aVar;
        }

        private void animateOffsetTo(CoordinatorLayout coordinatorLayout, T t, int i2, float f2) {
            int i3;
            int abs = Math.abs(getTopBottomOffsetForScrollingSibling() - i2);
            float abs2 = Math.abs(f2);
            if (abs2 > 0.0f) {
                i3 = Math.round((((float) abs) / abs2) * 1000.0f) * 3;
            } else {
                i3 = (int) (((((float) abs) / ((float) t.getHeight())) + 1.0f) * 150.0f);
            }
            animateOffsetWithDuration(coordinatorLayout, t, i2, i3);
        }

        private void animateOffsetWithDuration(final CoordinatorLayout coordinatorLayout, final T t, int i2, int i3) {
            int topBottomOffsetForScrollingSibling = getTopBottomOffsetForScrollingSibling();
            if (topBottomOffsetForScrollingSibling == i2) {
                ValueAnimator valueAnimator = this.offsetAnimator;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    this.offsetAnimator.cancel();
                    return;
                }
                return;
            }
            ValueAnimator valueAnimator2 = this.offsetAnimator;
            if (valueAnimator2 == null) {
                this.offsetAnimator = new ValueAnimator();
                this.offsetAnimator.setInterpolator(com.google.android.material.a.a.f35804e);
                this.offsetAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        BaseBehavior.this.setHeaderTopBottomOffset(coordinatorLayout, t, ((Integer) valueAnimator.getAnimatedValue()).intValue());
                    }
                });
            } else {
                valueAnimator2.cancel();
            }
            this.offsetAnimator.setDuration((long) Math.min(i3, 600));
            this.offsetAnimator.setIntValues(new int[]{topBottomOffsetForScrollingSibling, i2});
            this.offsetAnimator.start();
        }

        private int getChildIndexOnOffset(T t, int i2) {
            int childCount = t.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = t.getChildAt(i3);
                int top = childAt.getTop();
                int bottom = childAt.getBottom();
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (checkFlag(layoutParams.f35849a, 32)) {
                    top -= layoutParams.topMargin;
                    bottom += layoutParams.bottomMargin;
                }
                int i4 = -i2;
                if (top <= i4 && bottom >= i4) {
                    return i3;
                }
            }
            return -1;
        }

        private void snapToChildIfNeeded(CoordinatorLayout coordinatorLayout, T t) {
            int topBottomOffsetForScrollingSibling = getTopBottomOffsetForScrollingSibling();
            int childIndexOnOffset = getChildIndexOnOffset(t, topBottomOffsetForScrollingSibling);
            if (childIndexOnOffset >= 0) {
                View childAt = t.getChildAt(childIndexOnOffset);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int i2 = layoutParams.f35849a;
                if ((i2 & 17) == 17) {
                    int i3 = -childAt.getTop();
                    int i4 = -childAt.getBottom();
                    if (childIndexOnOffset == t.getChildCount() - 1) {
                        i4 += t.getTopInset();
                    }
                    if (checkFlag(i2, 2)) {
                        i4 += u.r(childAt);
                    } else if (checkFlag(i2, 5)) {
                        int r = u.r(childAt) + i4;
                        if (topBottomOffsetForScrollingSibling < r) {
                            i3 = r;
                        } else {
                            i4 = r;
                        }
                    }
                    if (checkFlag(i2, 32)) {
                        i3 += layoutParams.topMargin;
                        i4 -= layoutParams.bottomMargin;
                    }
                    if (topBottomOffsetForScrollingSibling < (i4 + i3) / 2) {
                        i3 = i4;
                    }
                    animateOffsetTo(coordinatorLayout, t, androidx.core.c.a.a(i3, -t.getTotalScrollRange(), 0), 0.0f);
                }
            }
        }

        public boolean onMeasureChild(CoordinatorLayout coordinatorLayout, T t, int i2, int i3, int i4, int i5) {
            if (((CoordinatorLayout.d) t.getLayoutParams()).height != -2) {
                return super.onMeasureChild(coordinatorLayout, t, i2, i3, i4, i5);
            }
            coordinatorLayout.a((View) t, i2, i3, View.MeasureSpec.makeMeasureSpec(0, 0), i5);
            return true;
        }

        public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, T t, int i2) {
            int i3;
            boolean onLayoutChild = super.onLayoutChild(coordinatorLayout, t, i2);
            int pendingAction = t.getPendingAction();
            int i4 = this.offsetToChildIndexOnLayout;
            if (i4 >= 0 && (pendingAction & 8) == 0) {
                View childAt = t.getChildAt(i4);
                int i5 = -childAt.getBottom();
                if (this.offsetToChildIndexOnLayoutIsMinHeight) {
                    i3 = u.r(childAt) + t.getTopInset();
                } else {
                    i3 = Math.round(((float) childAt.getHeight()) * this.offsetToChildIndexOnLayoutPerc);
                }
                setHeaderTopBottomOffset(coordinatorLayout, t, i5 + i3);
            } else if (pendingAction != 0) {
                boolean z = (pendingAction & 4) != 0;
                if ((pendingAction & 2) != 0) {
                    int i6 = -t.getUpNestedPreScrollRange();
                    if (z) {
                        animateOffsetTo(coordinatorLayout, t, i6, 0.0f);
                    } else {
                        setHeaderTopBottomOffset(coordinatorLayout, t, i6);
                    }
                } else if ((pendingAction & 1) != 0) {
                    if (z) {
                        animateOffsetTo(coordinatorLayout, t, 0, 0.0f);
                    } else {
                        setHeaderTopBottomOffset(coordinatorLayout, t, 0);
                    }
                }
            }
            t.f35825b = 0;
            this.offsetToChildIndexOnLayout = -1;
            setTopAndBottomOffset(androidx.core.c.a.a(getTopAndBottomOffset(), -t.getTotalScrollRange(), 0));
            updateAppBarLayoutDrawableState(coordinatorLayout, t, getTopAndBottomOffset(), 0, true);
            t.a(getTopAndBottomOffset());
            updateAccessibilityActions(coordinatorLayout, t);
            return onLayoutChild;
        }

        private void updateAccessibilityActions(CoordinatorLayout coordinatorLayout, T t) {
            u.d((View) coordinatorLayout, c.a.m.a());
            u.d((View) coordinatorLayout, c.a.n.a());
            View findFirstScrollingChild = findFirstScrollingChild(coordinatorLayout);
            if (findFirstScrollingChild != null && t.getTotalScrollRange() != 0 && (((CoordinatorLayout.d) findFirstScrollingChild.getLayoutParams()).f2603a instanceof ScrollingViewBehavior)) {
                addAccessibilityScrollActions(coordinatorLayout, t, findFirstScrollingChild);
            }
        }

        private void addAccessibilityScrollActions(CoordinatorLayout coordinatorLayout, T t, View view) {
            if (getTopBottomOffsetForScrollingSibling() != (-t.getTotalScrollRange()) && view.canScrollVertically(1)) {
                addActionToExpand(coordinatorLayout, t, c.a.m, false);
            }
            if (getTopBottomOffsetForScrollingSibling() == 0) {
                return;
            }
            if (view.canScrollVertically(-1)) {
                final int i2 = -t.getDownNestedPreScrollRange();
                if (i2 != 0) {
                    final CoordinatorLayout coordinatorLayout2 = coordinatorLayout;
                    final T t2 = t;
                    final View view2 = view;
                    u.a((View) coordinatorLayout, c.a.n, (f) new f() {
                        public final boolean a(View view) {
                            BaseBehavior.this.onNestedPreScroll(coordinatorLayout2, t2, view2, 0, i2, new int[]{0, 0}, 1);
                            return true;
                        }
                    });
                    return;
                }
                return;
            }
            addActionToExpand(coordinatorLayout, t, c.a.n, true);
        }

        private void addActionToExpand(CoordinatorLayout coordinatorLayout, final T t, c.a aVar, final boolean z) {
            u.a((View) coordinatorLayout, aVar, (f) new f() {
                public final boolean a(View view) {
                    t.setExpanded(z);
                    return true;
                }
            });
        }

        /* access modifiers changed from: package-private */
        public boolean canDragView(T t) {
            a aVar = this.onDragCallback;
            if (aVar != null) {
                return aVar.a(t);
            }
            WeakReference<View> weakReference = this.lastNestedScrollingChildRef;
            if (weakReference == null) {
                return true;
            }
            View view = (View) weakReference.get();
            if (view == null || !view.isShown() || view.canScrollVertically(-1)) {
                return false;
            }
            return true;
        }

        /* access modifiers changed from: package-private */
        public void onFlingFinished(CoordinatorLayout coordinatorLayout, T t) {
            snapToChildIfNeeded(coordinatorLayout, t);
            if (t.f35827d) {
                t.a(t.a(findFirstScrollingChild(coordinatorLayout)));
            }
        }

        /* access modifiers changed from: package-private */
        public int getMaxDragOffset(T t) {
            return -t.getDownNestedScrollRange();
        }

        /* access modifiers changed from: package-private */
        public int getScrollRangeForDragFling(T t) {
            return t.getTotalScrollRange();
        }

        /* access modifiers changed from: package-private */
        public int setHeaderTopBottomOffset(CoordinatorLayout coordinatorLayout, T t, int i2, int i3, int i4) {
            int topBottomOffsetForScrollingSibling = getTopBottomOffsetForScrollingSibling();
            int i5 = 0;
            if (i3 == 0 || topBottomOffsetForScrollingSibling < i3 || topBottomOffsetForScrollingSibling > i4) {
                this.offsetDelta = 0;
            } else {
                int a2 = androidx.core.c.a.a(i2, i3, i4);
                if (topBottomOffsetForScrollingSibling != a2) {
                    int interpolateOffset = t.f35824a ? interpolateOffset(t, a2) : a2;
                    boolean topAndBottomOffset = setTopAndBottomOffset(interpolateOffset);
                    i5 = topBottomOffsetForScrollingSibling - a2;
                    this.offsetDelta = a2 - interpolateOffset;
                    if (!topAndBottomOffset && t.f35824a) {
                        coordinatorLayout.a((View) t);
                    }
                    t.a(getTopAndBottomOffset());
                    updateAppBarLayoutDrawableState(coordinatorLayout, t, a2, a2 < topBottomOffsetForScrollingSibling ? -1 : 1, false);
                }
            }
            updateAccessibilityActions(coordinatorLayout, t);
            return i5;
        }

        /* access modifiers changed from: package-private */
        public boolean isOffsetAnimatorRunning() {
            ValueAnimator valueAnimator = this.offsetAnimator;
            return valueAnimator != null && valueAnimator.isRunning();
        }

        private int interpolateOffset(T t, int i2) {
            int abs = Math.abs(i2);
            int childCount = t.getChildCount();
            int i3 = 0;
            int i4 = 0;
            while (true) {
                if (i4 >= childCount) {
                    break;
                }
                View childAt = t.getChildAt(i4);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                Interpolator interpolator = layoutParams.f35850b;
                if (abs < childAt.getTop() || abs > childAt.getBottom()) {
                    i4++;
                } else if (interpolator != null) {
                    int i5 = layoutParams.f35849a;
                    if ((i5 & 1) != 0) {
                        i3 = 0 + childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
                        if ((i5 & 2) != 0) {
                            i3 -= u.r(childAt);
                        }
                    }
                    if (u.A(childAt)) {
                        i3 -= t.getTopInset();
                    }
                    if (i3 > 0) {
                        float f2 = (float) i3;
                        return Integer.signum(i2) * (childAt.getTop() + Math.round(f2 * interpolator.getInterpolation(((float) (abs - childAt.getTop())) / f2)));
                    }
                }
            }
            return i2;
        }

        private void updateAppBarLayoutDrawableState(CoordinatorLayout coordinatorLayout, T t, int i2, int i3, boolean z) {
            View appBarChildOnOffset = getAppBarChildOnOffset(t, i2);
            if (appBarChildOnOffset != null) {
                int i4 = ((LayoutParams) appBarChildOnOffset.getLayoutParams()).f35849a;
                boolean z2 = false;
                if ((i4 & 1) != 0) {
                    int r = u.r(appBarChildOnOffset);
                    if (i3 <= 0 || (i4 & 12) == 0 ? !((i4 & 2) == 0 || (-i2) < (appBarChildOnOffset.getBottom() - r) - t.getTopInset()) : (-i2) >= (appBarChildOnOffset.getBottom() - r) - t.getTopInset()) {
                        z2 = true;
                    }
                }
                if (t.f35827d) {
                    z2 = t.a(findFirstScrollingChild(coordinatorLayout));
                }
                boolean a2 = t.a(z2);
                if (z || (a2 && shouldJumpElevationState(coordinatorLayout, t))) {
                    t.jumpDrawablesToCurrentState();
                }
            }
        }

        private boolean shouldJumpElevationState(CoordinatorLayout coordinatorLayout, T t) {
            List<View> c2 = coordinatorLayout.c((View) t);
            int size = c2.size();
            int i2 = 0;
            while (i2 < size) {
                CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.d) c2.get(i2).getLayoutParams()).f2603a;
                if (!(behavior instanceof ScrollingViewBehavior)) {
                    i2++;
                } else if (((ScrollingViewBehavior) behavior).f35871d != 0) {
                    return true;
                } else {
                    return false;
                }
            }
            return false;
        }

        private static View getAppBarChildOnOffset(AppBarLayout appBarLayout, int i2) {
            int abs = Math.abs(i2);
            int childCount = appBarLayout.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = appBarLayout.getChildAt(i3);
                if (abs >= childAt.getTop() && abs <= childAt.getBottom()) {
                    return childAt;
                }
            }
            return null;
        }

        private View findFirstScrollingChild(CoordinatorLayout coordinatorLayout) {
            int childCount = coordinatorLayout.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = coordinatorLayout.getChildAt(i2);
                if ((childAt instanceof androidx.core.h.i) || (childAt instanceof ListView) || (childAt instanceof ScrollView)) {
                    return childAt;
                }
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        public int getTopBottomOffsetForScrollingSibling() {
            return getTopAndBottomOffset() + this.offsetDelta;
        }

        public Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, T t) {
            Parcelable onSaveInstanceState = super.onSaveInstanceState(coordinatorLayout, t);
            int topAndBottomOffset = getTopAndBottomOffset();
            int childCount = t.getChildCount();
            boolean z = false;
            int i2 = 0;
            while (i2 < childCount) {
                View childAt = t.getChildAt(i2);
                int bottom = childAt.getBottom() + topAndBottomOffset;
                if (childAt.getTop() + topAndBottomOffset > 0 || bottom < 0) {
                    i2++;
                } else {
                    SavedState savedState = new SavedState(onSaveInstanceState);
                    savedState.f35846a = i2;
                    if (bottom == u.r(childAt) + t.getTopInset()) {
                        z = true;
                    }
                    savedState.f35848e = z;
                    savedState.f35847b = ((float) bottom) / ((float) childAt.getHeight());
                    return savedState;
                }
            }
            return onSaveInstanceState;
        }

        public void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, T t, Parcelable parcelable) {
            if (parcelable instanceof SavedState) {
                SavedState savedState = (SavedState) parcelable;
                super.onRestoreInstanceState(coordinatorLayout, t, savedState.f3245d);
                this.offsetToChildIndexOnLayout = savedState.f35846a;
                this.offsetToChildIndexOnLayoutPerc = savedState.f35847b;
                this.offsetToChildIndexOnLayoutIsMinHeight = savedState.f35848e;
                return;
            }
            super.onRestoreInstanceState(coordinatorLayout, t, parcelable);
            this.offsetToChildIndexOnLayout = -1;
        }

        protected static class SavedState extends AbsSavedState {
            public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
                public final /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                    return new SavedState(parcel, classLoader);
                }

                public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
                    return new SavedState[i2];
                }

                public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                    return new SavedState(parcel, (ClassLoader) null);
                }
            };

            /* renamed from: a  reason: collision with root package name */
            int f35846a;

            /* renamed from: b  reason: collision with root package name */
            float f35847b;

            /* renamed from: e  reason: collision with root package name */
            boolean f35848e;

            public SavedState(Parcel parcel, ClassLoader classLoader) {
                super(parcel, classLoader);
                this.f35846a = parcel.readInt();
                this.f35847b = parcel.readFloat();
                this.f35848e = parcel.readByte() != 0;
            }

            public SavedState(Parcelable parcelable) {
                super(parcelable);
            }

            public void writeToParcel(Parcel parcel, int i2) {
                super.writeToParcel(parcel, i2);
                parcel.writeInt(this.f35846a);
                parcel.writeFloat(this.f35847b);
                parcel.writeByte(this.f35848e ? (byte) 1 : 0);
            }
        }

        public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, T t, View view, View view2, int i2, int i3) {
            ValueAnimator valueAnimator;
            boolean z = (i2 & 2) != 0 && (t.f35827d || canScrollChildren(coordinatorLayout, t, view));
            if (z && (valueAnimator = this.offsetAnimator) != null) {
                valueAnimator.cancel();
            }
            this.lastNestedScrollingChildRef = null;
            this.lastStartedType = i3;
            return z;
        }

        private boolean canScrollChildren(CoordinatorLayout coordinatorLayout, T t, View view) {
            return (t.getTotalScrollRange() != 0) && coordinatorLayout.getHeight() - view.getHeight() <= t.getHeight();
        }
    }

    public final void a(b bVar) {
        if (this.j == null) {
            this.j = new ArrayList();
        }
        if (bVar != null && !this.j.contains(bVar)) {
            this.j.add(bVar);
        }
    }

    public final void b(b bVar) {
        List<a> list = this.j;
        if (list != null && bVar != null) {
            list.remove(bVar);
        }
    }

    public static class ScrollingViewBehavior extends HeaderScrollingViewBehavior {
        /* access modifiers changed from: package-private */
        public final /* synthetic */ View a(List list) {
            return b((List<View>) list);
        }

        public /* bridge */ /* synthetic */ int getLeftAndRightOffset() {
            return super.getLeftAndRightOffset();
        }

        public /* bridge */ /* synthetic */ int getTopAndBottomOffset() {
            return super.getTopAndBottomOffset();
        }

        public /* bridge */ /* synthetic */ boolean isHorizontalOffsetEnabled() {
            return super.isHorizontalOffsetEnabled();
        }

        public /* bridge */ /* synthetic */ boolean isVerticalOffsetEnabled() {
            return super.isVerticalOffsetEnabled();
        }

        public /* bridge */ /* synthetic */ boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int i2) {
            return super.onLayoutChild(coordinatorLayout, view, i2);
        }

        public /* bridge */ /* synthetic */ boolean onMeasureChild(CoordinatorLayout coordinatorLayout, View view, int i2, int i3, int i4, int i5) {
            return super.onMeasureChild(coordinatorLayout, view, i2, i3, i4, i5);
        }

        public /* bridge */ /* synthetic */ void setHorizontalOffsetEnabled(boolean z) {
            super.setHorizontalOffsetEnabled(z);
        }

        public /* bridge */ /* synthetic */ boolean setLeftAndRightOffset(int i2) {
            return super.setLeftAndRightOffset(i2);
        }

        public /* bridge */ /* synthetic */ boolean setTopAndBottomOffset(int i2) {
            return super.setTopAndBottomOffset(i2);
        }

        public /* bridge */ /* synthetic */ void setVerticalOffsetEnabled(boolean z) {
            super.setVerticalOffsetEnabled(z);
        }

        public ScrollingViewBehavior() {
        }

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ScrollingViewBehavior_Layout);
            this.f35871d = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ScrollingViewBehavior_Layout_behavior_overlapTop, 0);
            obtainStyledAttributes.recycle();
        }

        public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return view2 instanceof AppBarLayout;
        }

        public void onDependentViewRemoved(CoordinatorLayout coordinatorLayout, View view, View view2) {
            if (view2 instanceof AppBarLayout) {
                u.d((View) coordinatorLayout, c.a.m.a());
                u.d((View) coordinatorLayout, c.a.n.a());
            }
        }

        public boolean onRequestChildRectangleOnScreen(CoordinatorLayout coordinatorLayout, View view, Rect rect, boolean z) {
            AppBarLayout b2 = b(coordinatorLayout.b(view));
            if (b2 != null) {
                rect.offset(view.getLeft(), view.getTop());
                Rect rect2 = this.f35868a;
                rect2.set(0, 0, coordinatorLayout.getWidth(), coordinatorLayout.getHeight());
                if (!rect2.contains(rect)) {
                    b2.setExpanded(false, !z);
                    return true;
                }
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public final float a(View view) {
            int i2;
            if (view instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view;
                int totalScrollRange = appBarLayout.getTotalScrollRange();
                int downNestedPreScrollRange = appBarLayout.getDownNestedPreScrollRange();
                CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.d) appBarLayout.getLayoutParams()).f2603a;
                int topBottomOffsetForScrollingSibling = behavior instanceof BaseBehavior ? ((BaseBehavior) behavior).getTopBottomOffsetForScrollingSibling() : 0;
                if ((downNestedPreScrollRange == 0 || totalScrollRange + topBottomOffsetForScrollingSibling > downNestedPreScrollRange) && (i2 = totalScrollRange - downNestedPreScrollRange) != 0) {
                    return (((float) topBottomOffsetForScrollingSibling) / ((float) i2)) + 1.0f;
                }
            }
            return 0.0f;
        }

        private static AppBarLayout b(List<View> list) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view = list.get(i2);
                if (view instanceof AppBarLayout) {
                    return (AppBarLayout) view;
                }
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        public final int b(View view) {
            if (view instanceof AppBarLayout) {
                return ((AppBarLayout) view).getTotalScrollRange();
            }
            return super.b(view);
        }

        public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view, View view2) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.d) view2.getLayoutParams()).f2603a;
            if (behavior instanceof BaseBehavior) {
                u.f(view, (((view2.getBottom() - view.getTop()) + ((BaseBehavior) behavior).offsetDelta) + this.f35870c) - c(view2));
            }
            if (!(view2 instanceof AppBarLayout)) {
                return false;
            }
            AppBarLayout appBarLayout = (AppBarLayout) view2;
            if (!appBarLayout.f35827d) {
                return false;
            }
            appBarLayout.a(appBarLayout.a(view));
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean a(View view) {
        int i2;
        if (this.o == null && (i2 = this.n) != -1) {
            View findViewById = view != null ? view.findViewById(i2) : null;
            if (findViewById == null && (getParent() instanceof ViewGroup)) {
                findViewById = ((ViewGroup) getParent()).findViewById(this.n);
            }
            if (findViewById != null) {
                this.o = new WeakReference<>(findViewById);
            }
        }
        WeakReference<View> weakReference = this.o;
        View view2 = weakReference != null ? (View) weakReference.get() : null;
        if (view2 != null) {
            view = view2;
        }
        if (view != null) {
            return view.canScrollVertically(-1) || view.getScrollY() > 0;
        }
        return false;
    }
}
