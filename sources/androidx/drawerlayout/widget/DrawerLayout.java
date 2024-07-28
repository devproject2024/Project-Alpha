package androidx.drawerlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.h.a.c;
import androidx.core.h.e;
import androidx.core.h.u;
import androidx.customview.a.c;
import androidx.customview.view.AbsSavedState;
import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;
import java.util.ArrayList;
import java.util.List;

public class DrawerLayout extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    static final int[] f3284a = {16842931};

    /* renamed from: b  reason: collision with root package name */
    static final boolean f3285b = (Build.VERSION.SDK_INT >= 19);
    private static final int[] j = {16843828};
    private static final boolean k;
    private c A;
    private float B;
    private float C;
    private Drawable D;
    private Drawable E;
    private Drawable F;
    private Object G;
    private boolean H;
    private Drawable I;
    private Drawable J;
    private Drawable K;
    private Drawable L;
    private final ArrayList<View> M;
    private Rect N;
    private Matrix O;

    /* renamed from: c  reason: collision with root package name */
    final androidx.customview.a.c f3286c;

    /* renamed from: d  reason: collision with root package name */
    final androidx.customview.a.c f3287d;

    /* renamed from: e  reason: collision with root package name */
    int f3288e;

    /* renamed from: f  reason: collision with root package name */
    boolean f3289f;

    /* renamed from: g  reason: collision with root package name */
    List<c> f3290g;

    /* renamed from: h  reason: collision with root package name */
    CharSequence f3291h;

    /* renamed from: i  reason: collision with root package name */
    CharSequence f3292i;
    private final b l;
    private float m;
    private int n;
    private int o;
    private float p;
    private Paint q;
    private final d r;
    private final d s;
    private boolean t;
    private boolean u;
    private int v;
    private int w;
    private int x;
    private int y;
    private boolean z;

    public interface c {
        void a(float f2);

        void onDrawerClosed(View view);

        void onDrawerOpened(View view);
    }

    static {
        boolean z2 = true;
        if (Build.VERSION.SDK_INT < 21) {
            z2 = false;
        }
        k = z2;
    }

    public DrawerLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public DrawerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DrawerLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.l = new b();
        this.o = -1728053248;
        this.q = new Paint();
        this.u = true;
        this.v = 3;
        this.w = 3;
        this.x = 3;
        this.y = 3;
        this.I = null;
        this.J = null;
        this.K = null;
        this.L = null;
        setDescendantFocusability(262144);
        float f2 = getResources().getDisplayMetrics().density;
        this.n = (int) ((64.0f * f2) + 0.5f);
        float f3 = 400.0f * f2;
        this.r = new d(3);
        this.s = new d(5);
        this.f3286c = androidx.customview.a.c.a((ViewGroup) this, 1.0f, (c.a) this.r);
        androidx.customview.a.c cVar = this.f3286c;
        cVar.f3238e = 1;
        cVar.f3236c = f3;
        this.r.f3306b = cVar;
        this.f3287d = androidx.customview.a.c.a((ViewGroup) this, 1.0f, (c.a) this.s);
        androidx.customview.a.c cVar2 = this.f3287d;
        cVar2.f3238e = 2;
        cVar2.f3236c = f3;
        this.s.f3306b = cVar2;
        setFocusableInTouchMode(true);
        u.c((View) this, 1);
        u.a((View) this, (androidx.core.h.a) new a());
        setMotionEventSplittingEnabled(false);
        if (u.A(this)) {
            if (Build.VERSION.SDK_INT >= 21) {
                setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() {
                    public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                        ((DrawerLayout) view).setChildInsets(windowInsets, windowInsets.getSystemWindowInsetTop() > 0);
                        return windowInsets.consumeSystemWindowInsets();
                    }
                });
                setSystemUiVisibility(1280);
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(j);
                try {
                    this.D = obtainStyledAttributes.getDrawable(0);
                } finally {
                    obtainStyledAttributes.recycle();
                }
            } else {
                this.D = null;
            }
        }
        this.m = f2 * 10.0f;
        this.M = new ArrayList<>();
    }

    public void setDrawerElevation(float f2) {
        this.m = f2;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (d(childAt)) {
                u.g(childAt, this.m);
            }
        }
    }

    public float getDrawerElevation() {
        if (k) {
            return this.m;
        }
        return 0.0f;
    }

    public void setChildInsets(Object obj, boolean z2) {
        this.G = obj;
        this.H = z2;
        setWillNotDraw(!z2 && getBackground() == null);
        requestLayout();
    }

    public void setDrawerShadow(Drawable drawable, int i2) {
        if (!k) {
            if ((i2 & 8388611) == 8388611) {
                this.I = drawable;
            } else if ((i2 & 8388613) == 8388613) {
                this.J = drawable;
            } else if ((i2 & 3) == 3) {
                this.K = drawable;
            } else if ((i2 & 5) == 5) {
                this.L = drawable;
            } else {
                return;
            }
            d();
            invalidate();
        }
    }

    public void setDrawerShadow(int i2, int i3) {
        setDrawerShadow(androidx.core.content.b.a(getContext(), i2), i3);
    }

    public void setScrimColor(int i2) {
        this.o = i2;
        invalidate();
    }

    @Deprecated
    public void setDrawerListener(c cVar) {
        List<c> list;
        c cVar2 = this.A;
        if (!(cVar2 == null || cVar2 == null || (list = this.f3290g) == null)) {
            list.remove(cVar2);
        }
        if (cVar != null) {
            a(cVar);
        }
        this.A = cVar;
    }

    public final void a(c cVar) {
        if (cVar != null) {
            if (this.f3290g == null) {
                this.f3290g = new ArrayList();
            }
            this.f3290g.add(cVar);
        }
    }

    public void setDrawerLockMode(int i2) {
        setDrawerLockMode(i2, 3);
        setDrawerLockMode(i2, 5);
    }

    public void setDrawerLockMode(int i2, int i3) {
        View b2;
        int a2 = e.a(i3, u.j(this));
        if (i3 == 3) {
            this.v = i2;
        } else if (i3 == 5) {
            this.w = i2;
        } else if (i3 == 8388611) {
            this.x = i2;
        } else if (i3 == 8388613) {
            this.y = i2;
        }
        if (i2 != 0) {
            (a2 == 3 ? this.f3286c : this.f3287d).d();
        }
        if (i2 == 1) {
            View b3 = b(a2);
            if (b3 != null) {
                e(b3);
            }
        } else if (i2 == 2 && (b2 = b(a2)) != null) {
            i(b2);
        }
    }

    public void setDrawerLockMode(int i2, View view) {
        if (d(view)) {
            setDrawerLockMode(i2, ((LayoutParams) view.getLayoutParams()).f3294a);
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer with appropriate layout_gravity");
    }

    public final int a(int i2) {
        int i3;
        int i4;
        int i5;
        int j2 = u.j(this);
        if (i2 == 3) {
            int i6 = this.v;
            if (i6 != 3) {
                return i6;
            }
            int i7 = j2 == 0 ? this.x : this.y;
            if (i7 != 3) {
                return i7;
            }
            return 0;
        } else if (i2 == 5) {
            int i8 = this.w;
            if (i8 != 3) {
                return i8;
            }
            if (j2 == 0) {
                i3 = this.y;
            } else {
                i3 = this.x;
            }
            if (i3 != 3) {
                return i3;
            }
            return 0;
        } else if (i2 == 8388611) {
            int i9 = this.x;
            if (i9 != 3) {
                return i9;
            }
            if (j2 == 0) {
                i4 = this.v;
            } else {
                i4 = this.w;
            }
            if (i4 != 3) {
                return i4;
            }
            return 0;
        } else if (i2 != 8388613) {
            return 0;
        } else {
            int i10 = this.y;
            if (i10 != 3) {
                return i10;
            }
            if (j2 == 0) {
                i5 = this.w;
            } else {
                i5 = this.v;
            }
            if (i5 != 3) {
                return i5;
            }
            return 0;
        }
    }

    public final int a(View view) {
        if (d(view)) {
            return a(((LayoutParams) view.getLayoutParams()).f3294a);
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    public void setDrawerTitle(int i2, CharSequence charSequence) {
        int a2 = e.a(i2, u.j(this));
        if (a2 == 3) {
            this.f3291h = charSequence;
        } else if (a2 == 5) {
            this.f3292i = charSequence;
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(View view, boolean z2) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if ((z2 || d(childAt)) && (!z2 || childAt != view)) {
                u.c(childAt, 4);
            } else {
                u.c(childAt, 1);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(View view, float f2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (f2 != layoutParams.f3295b) {
            layoutParams.f3295b = f2;
            List<c> list = this.f3290g;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.f3290g.get(size).a(f2);
                }
            }
        }
    }

    static float b(View view) {
        return ((LayoutParams) view.getLayoutParams()).f3295b;
    }

    /* access modifiers changed from: package-private */
    public final int c(View view) {
        return e.a(((LayoutParams) view.getLayoutParams()).f3294a, u.j(this));
    }

    /* access modifiers changed from: package-private */
    public final boolean a(View view, int i2) {
        return (c(view) & i2) == i2;
    }

    private View c() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if ((((LayoutParams) childAt.getLayoutParams()).f3297d & 1) == 1) {
                return childAt;
            }
        }
        return null;
    }

    public final View b(int i2) {
        int a2 = e.a(i2, u.j(this)) & 7;
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if ((c(childAt) & 7) == a2) {
                return childAt;
            }
        }
        return null;
    }

    private static String f(int i2) {
        if ((i2 & 3) == 3) {
            return "LEFT";
        }
        return (i2 & 5) == 5 ? "RIGHT" : Integer.toHexString(i2);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.u = true;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.u = true;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        if (!(mode == 1073741824 && mode2 == 1073741824)) {
            if (isInEditMode()) {
                if (mode != Integer.MIN_VALUE && mode == 0) {
                    size = 300;
                }
                if (mode2 != Integer.MIN_VALUE && mode2 == 0) {
                    size2 = 300;
                }
            } else {
                throw new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
            }
        }
        setMeasuredDimension(size, size2);
        int i4 = 0;
        boolean z2 = this.G != null && u.A(this);
        int j2 = u.j(this);
        int childCount = getChildCount();
        int i5 = 0;
        boolean z3 = false;
        boolean z4 = false;
        while (i5 < childCount) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (z2) {
                    int a2 = e.a(layoutParams.f3294a, j2);
                    if (u.A(childAt)) {
                        if (Build.VERSION.SDK_INT >= 21) {
                            WindowInsets windowInsets = (WindowInsets) this.G;
                            if (a2 == 3) {
                                windowInsets = windowInsets.replaceSystemWindowInsets(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), i4, windowInsets.getSystemWindowInsetBottom());
                            } else if (a2 == 5) {
                                windowInsets = windowInsets.replaceSystemWindowInsets(i4, windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom());
                            }
                            childAt.dispatchApplyWindowInsets(windowInsets);
                        }
                    } else if (Build.VERSION.SDK_INT >= 21) {
                        WindowInsets windowInsets2 = (WindowInsets) this.G;
                        if (a2 == 3) {
                            windowInsets2 = windowInsets2.replaceSystemWindowInsets(windowInsets2.getSystemWindowInsetLeft(), windowInsets2.getSystemWindowInsetTop(), i4, windowInsets2.getSystemWindowInsetBottom());
                        } else if (a2 == 5) {
                            windowInsets2 = windowInsets2.replaceSystemWindowInsets(i4, windowInsets2.getSystemWindowInsetTop(), windowInsets2.getSystemWindowInsetRight(), windowInsets2.getSystemWindowInsetBottom());
                        }
                        layoutParams.leftMargin = windowInsets2.getSystemWindowInsetLeft();
                        layoutParams.topMargin = windowInsets2.getSystemWindowInsetTop();
                        layoutParams.rightMargin = windowInsets2.getSystemWindowInsetRight();
                        layoutParams.bottomMargin = windowInsets2.getSystemWindowInsetBottom();
                    }
                }
                if (h(childAt)) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec((size - layoutParams.leftMargin) - layoutParams.rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec((size2 - layoutParams.topMargin) - layoutParams.bottomMargin, 1073741824));
                } else if (d(childAt)) {
                    if (k) {
                        float v2 = u.v(childAt);
                        float f2 = this.m;
                        if (v2 != f2) {
                            u.g(childAt, f2);
                        }
                    }
                    int c2 = c(childAt) & 7;
                    boolean z5 = c2 == 3;
                    if ((!z5 || !z3) && (z5 || !z4)) {
                        if (z5) {
                            z3 = true;
                        } else {
                            z4 = true;
                        }
                        childAt.measure(getChildMeasureSpec(i2, this.n + layoutParams.leftMargin + layoutParams.rightMargin, layoutParams.width), getChildMeasureSpec(i3, layoutParams.topMargin + layoutParams.bottomMargin, layoutParams.height));
                        i5++;
                        i4 = 0;
                    } else {
                        throw new IllegalStateException("Child drawer has absolute gravity " + f(c2) + " but this DrawerLayout already has a drawer view along that edge");
                    }
                } else {
                    throw new IllegalStateException("Child " + childAt + " at index " + i5 + " does not have a valid layout_gravity - must be Gravity.LEFT, Gravity.RIGHT or Gravity.NO_GRAVITY");
                }
            }
            int i6 = i2;
            int i7 = i3;
            i5++;
            i4 = 0;
        }
    }

    private void d() {
        if (!k) {
            this.E = e();
            this.F = f();
        }
    }

    private Drawable e() {
        int j2 = u.j(this);
        if (j2 == 0) {
            Drawable drawable = this.I;
            if (drawable != null) {
                a(drawable, j2);
                return this.I;
            }
        } else {
            Drawable drawable2 = this.J;
            if (drawable2 != null) {
                a(drawable2, j2);
                return this.J;
            }
        }
        return this.K;
    }

    private Drawable f() {
        int j2 = u.j(this);
        if (j2 == 0) {
            Drawable drawable = this.J;
            if (drawable != null) {
                a(drawable, j2);
                return this.J;
            }
        } else {
            Drawable drawable2 = this.I;
            if (drawable2 != null) {
                a(drawable2, j2);
                return this.I;
            }
        }
        return this.L;
    }

    private static boolean a(Drawable drawable, int i2) {
        if (drawable == null || !androidx.core.graphics.drawable.a.a(drawable)) {
            return false;
        }
        androidx.core.graphics.drawable.a.b(drawable, i2);
        return true;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        float f2;
        int i6;
        this.t = true;
        int i7 = i4 - i2;
        int childCount = getChildCount();
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (h(childAt)) {
                    childAt.layout(layoutParams.leftMargin, layoutParams.topMargin, layoutParams.leftMargin + childAt.getMeasuredWidth(), layoutParams.topMargin + childAt.getMeasuredHeight());
                } else {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (a(childAt, 3)) {
                        float f3 = (float) measuredWidth;
                        i6 = (-measuredWidth) + ((int) (layoutParams.f3295b * f3));
                        f2 = ((float) (measuredWidth + i6)) / f3;
                    } else {
                        float f4 = (float) measuredWidth;
                        int i9 = i7 - ((int) (layoutParams.f3295b * f4));
                        f2 = ((float) (i7 - i9)) / f4;
                        i6 = i9;
                    }
                    boolean z3 = f2 != layoutParams.f3295b;
                    int i10 = layoutParams.f3294a & 112;
                    if (i10 == 16) {
                        int i11 = i5 - i3;
                        int i12 = (i11 - measuredHeight) / 2;
                        if (i12 < layoutParams.topMargin) {
                            i12 = layoutParams.topMargin;
                        } else if (i12 + measuredHeight > i11 - layoutParams.bottomMargin) {
                            i12 = (i11 - layoutParams.bottomMargin) - measuredHeight;
                        }
                        childAt.layout(i6, i12, measuredWidth + i6, measuredHeight + i12);
                    } else if (i10 != 80) {
                        childAt.layout(i6, layoutParams.topMargin, measuredWidth + i6, layoutParams.topMargin + measuredHeight);
                    } else {
                        int i13 = i5 - i3;
                        childAt.layout(i6, (i13 - layoutParams.bottomMargin) - childAt.getMeasuredHeight(), measuredWidth + i6, i13 - layoutParams.bottomMargin);
                    }
                    if (z3) {
                        a(childAt, f2);
                    }
                    int i14 = layoutParams.f3295b > 0.0f ? 0 : 4;
                    if (childAt.getVisibility() != i14) {
                        childAt.setVisibility(i14);
                    }
                }
            }
        }
        this.t = false;
        this.u = false;
    }

    public void requestLayout() {
        if (!this.t) {
            super.requestLayout();
        }
    }

    public void computeScroll() {
        int childCount = getChildCount();
        float f2 = 0.0f;
        for (int i2 = 0; i2 < childCount; i2++) {
            f2 = Math.max(f2, ((LayoutParams) getChildAt(i2).getLayoutParams()).f3295b);
        }
        this.p = f2;
        boolean f3 = this.f3286c.f();
        boolean f4 = this.f3287d.f();
        if (f3 || f4) {
            u.g(this);
        }
    }

    public void setStatusBarBackground(Drawable drawable) {
        this.D = drawable;
        invalidate();
    }

    public Drawable getStatusBarBackgroundDrawable() {
        return this.D;
    }

    public void setStatusBarBackground(int i2) {
        this.D = i2 != 0 ? androidx.core.content.b.a(getContext(), i2) : null;
        invalidate();
    }

    public void setStatusBarBackgroundColor(int i2) {
        this.D = new ColorDrawable(i2);
        invalidate();
    }

    public void onRtlPropertiesChanged(int i2) {
        d();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0012, code lost:
        r0 = r4.G;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onDraw(android.graphics.Canvas r5) {
        /*
            r4 = this;
            super.onDraw(r5)
            boolean r0 = r4.H
            if (r0 == 0) goto L_0x002e
            android.graphics.drawable.Drawable r0 = r4.D
            if (r0 == 0) goto L_0x002e
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 21
            r2 = 0
            if (r0 < r1) goto L_0x001d
            java.lang.Object r0 = r4.G
            if (r0 == 0) goto L_0x001d
            android.view.WindowInsets r0 = (android.view.WindowInsets) r0
            int r0 = r0.getSystemWindowInsetTop()
            goto L_0x001e
        L_0x001d:
            r0 = 0
        L_0x001e:
            if (r0 <= 0) goto L_0x002e
            android.graphics.drawable.Drawable r1 = r4.D
            int r3 = r4.getWidth()
            r1.setBounds(r2, r2, r3, r0)
            android.graphics.drawable.Drawable r0 = r4.D
            r0.draw(r5)
        L_0x002e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.drawerlayout.widget.DrawerLayout.onDraw(android.graphics.Canvas):void");
    }

    /* access modifiers changed from: protected */
    public boolean drawChild(Canvas canvas, View view, long j2) {
        int i2;
        Canvas canvas2 = canvas;
        View view2 = view;
        int height = getHeight();
        boolean h2 = h(view);
        int width = getWidth();
        int save = canvas.save();
        int i3 = 0;
        if (h2) {
            int childCount = getChildCount();
            i2 = width;
            int i4 = 0;
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = getChildAt(i5);
                if (childAt != view2 && childAt.getVisibility() == 0) {
                    Drawable background = childAt.getBackground();
                    if ((background != null && background.getOpacity() == -1) && d(childAt) && childAt.getHeight() >= height) {
                        if (a(childAt, 3)) {
                            int right = childAt.getRight();
                            if (right > i4) {
                                i4 = right;
                            }
                        } else {
                            int left = childAt.getLeft();
                            if (left < i2) {
                                i2 = left;
                            }
                        }
                    }
                }
            }
            canvas2.clipRect(i4, 0, i2, getHeight());
            i3 = i4;
        } else {
            i2 = width;
        }
        boolean drawChild = super.drawChild(canvas, view, j2);
        canvas2.restoreToCount(save);
        float f2 = this.p;
        if (f2 > 0.0f && h2) {
            int i6 = this.o;
            this.q.setColor((i6 & 16777215) | (((int) (((float) ((-16777216 & i6) >>> 24)) * f2)) << 24));
            canvas.drawRect((float) i3, 0.0f, (float) i2, (float) getHeight(), this.q);
        } else if (this.E != null && a(view2, 3)) {
            int intrinsicWidth = this.E.getIntrinsicWidth();
            int right2 = view.getRight();
            float max = Math.max(0.0f, Math.min(((float) right2) / ((float) this.f3286c.f3237d), 1.0f));
            this.E.setBounds(right2, view.getTop(), intrinsicWidth + right2, view.getBottom());
            this.E.setAlpha((int) (max * 255.0f));
            this.E.draw(canvas2);
        } else if (this.F != null && a(view2, 5)) {
            int intrinsicWidth2 = this.F.getIntrinsicWidth();
            int left2 = view.getLeft();
            float max2 = Math.max(0.0f, Math.min(((float) (getWidth() - left2)) / ((float) this.f3287d.f3237d), 1.0f));
            this.F.setBounds(left2 - intrinsicWidth2, view.getTop(), left2, view.getBottom());
            this.F.setAlpha((int) (max2 * 255.0f));
            this.F.draw(canvas2);
        }
        return drawChild;
    }

    private static boolean h(View view) {
        return ((LayoutParams) view.getLayoutParams()).f3294a == 0;
    }

    static boolean d(View view) {
        int a2 = e.a(((LayoutParams) view.getLayoutParams()).f3294a, u.j(view));
        return ((a2 & 3) == 0 && (a2 & 5) == 0) ? false : true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x004d, code lost:
        r7 = r6.f3286c.b((int) r0, (int) r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001b, code lost:
        if (r0 != 3) goto L_0x0038;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            int r0 = r7.getActionMasked()
            androidx.customview.a.c r1 = r6.f3286c
            boolean r1 = r1.a((android.view.MotionEvent) r7)
            androidx.customview.a.c r2 = r6.f3287d
            boolean r2 = r2.a((android.view.MotionEvent) r7)
            r1 = r1 | r2
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L_0x003a
            if (r0 == r2) goto L_0x0031
            r7 = 2
            r4 = 3
            if (r0 == r7) goto L_0x001e
            if (r0 == r4) goto L_0x0031
            goto L_0x0038
        L_0x001e:
            androidx.customview.a.c r7 = r6.f3286c
            boolean r7 = r7.b((int) r4)
            if (r7 == 0) goto L_0x0038
            androidx.drawerlayout.widget.DrawerLayout$d r7 = r6.r
            r7.c()
            androidx.drawerlayout.widget.DrawerLayout$d r7 = r6.s
            r7.c()
            goto L_0x0038
        L_0x0031:
            r6.a((boolean) r2)
            r6.z = r3
            r6.f3289f = r3
        L_0x0038:
            r7 = 0
            goto L_0x0064
        L_0x003a:
            float r0 = r7.getX()
            float r7 = r7.getY()
            r6.B = r0
            r6.C = r7
            float r4 = r6.p
            r5 = 0
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 <= 0) goto L_0x005f
            androidx.customview.a.c r4 = r6.f3286c
            int r0 = (int) r0
            int r7 = (int) r7
            android.view.View r7 = r4.b((int) r0, (int) r7)
            if (r7 == 0) goto L_0x005f
            boolean r7 = h(r7)
            if (r7 == 0) goto L_0x005f
            r7 = 1
            goto L_0x0060
        L_0x005f:
            r7 = 0
        L_0x0060:
            r6.z = r3
            r6.f3289f = r3
        L_0x0064:
            if (r1 != 0) goto L_0x008b
            if (r7 != 0) goto L_0x008b
            int r7 = r6.getChildCount()
            r0 = 0
        L_0x006d:
            if (r0 >= r7) goto L_0x0082
            android.view.View r1 = r6.getChildAt(r0)
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            androidx.drawerlayout.widget.DrawerLayout$LayoutParams r1 = (androidx.drawerlayout.widget.DrawerLayout.LayoutParams) r1
            boolean r1 = r1.f3296c
            if (r1 == 0) goto L_0x007f
            r7 = 1
            goto L_0x0083
        L_0x007f:
            int r0 = r0 + 1
            goto L_0x006d
        L_0x0082:
            r7 = 0
        L_0x0083:
            if (r7 != 0) goto L_0x008b
            boolean r7 = r6.f3289f
            if (r7 == 0) goto L_0x008a
            goto L_0x008b
        L_0x008a:
            return r3
        L_0x008b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.drawerlayout.widget.DrawerLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        boolean z2;
        if ((motionEvent.getSource() & 2) == 0 || motionEvent.getAction() == 10 || this.p <= 0.0f) {
            return super.dispatchGenericMotionEvent(motionEvent);
        }
        int childCount = getChildCount();
        if (childCount == 0) {
            return false;
        }
        float x2 = motionEvent.getX();
        float y2 = motionEvent.getY();
        for (int i2 = childCount - 1; i2 >= 0; i2--) {
            View childAt = getChildAt(i2);
            if (this.N == null) {
                this.N = new Rect();
            }
            childAt.getHitRect(this.N);
            if (this.N.contains((int) x2, (int) y2) && !h(childAt)) {
                if (!childAt.getMatrix().isIdentity()) {
                    MotionEvent obtain = MotionEvent.obtain(motionEvent);
                    obtain.offsetLocation((float) (getScrollX() - childAt.getLeft()), (float) (getScrollY() - childAt.getTop()));
                    Matrix matrix = childAt.getMatrix();
                    if (!matrix.isIdentity()) {
                        if (this.O == null) {
                            this.O = new Matrix();
                        }
                        matrix.invert(this.O);
                        obtain.transform(this.O);
                    }
                    z2 = childAt.dispatchGenericMotionEvent(obtain);
                    obtain.recycle();
                } else {
                    float scrollX = (float) (getScrollX() - childAt.getLeft());
                    float scrollY = (float) (getScrollY() - childAt.getTop());
                    motionEvent.offsetLocation(scrollX, scrollY);
                    z2 = childAt.dispatchGenericMotionEvent(motionEvent);
                    motionEvent.offsetLocation(-scrollX, -scrollY);
                }
                if (z2) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z2;
        View c2;
        this.f3286c.b(motionEvent);
        this.f3287d.b(motionEvent);
        int action = motionEvent.getAction() & PriceRangeSeekBar.INVALID_POINTER_ID;
        if (action == 0) {
            float x2 = motionEvent.getX();
            float y2 = motionEvent.getY();
            this.B = x2;
            this.C = y2;
            this.z = false;
            this.f3289f = false;
        } else if (action == 1) {
            float x3 = motionEvent.getX();
            float y3 = motionEvent.getY();
            View b2 = this.f3286c.b((int) x3, (int) y3);
            if (b2 != null && h(b2)) {
                float f2 = x3 - this.B;
                float f3 = y3 - this.C;
                int i2 = this.f3286c.f3235b;
                if (!((f2 * f2) + (f3 * f3) >= ((float) (i2 * i2)) || (c2 = c()) == null || a(c2) == 2)) {
                    z2 = false;
                    a(z2);
                    this.z = false;
                }
            }
            z2 = true;
            a(z2);
            this.z = false;
        } else if (action == 3) {
            a(true);
            this.z = false;
            this.f3289f = false;
        }
        return true;
    }

    public void requestDisallowInterceptTouchEvent(boolean z2) {
        super.requestDisallowInterceptTouchEvent(z2);
        this.z = z2;
        if (z2) {
            a(true);
        }
    }

    public final void a(boolean z2) {
        boolean z3;
        int childCount = getChildCount();
        boolean z4 = false;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (d(childAt) && (!z2 || layoutParams.f3296c)) {
                int width = childAt.getWidth();
                if (a(childAt, 3)) {
                    z3 = this.f3286c.a(childAt, -width, childAt.getTop());
                } else {
                    z3 = this.f3287d.a(childAt, getWidth(), childAt.getTop());
                }
                z4 |= z3;
                layoutParams.f3296c = false;
            }
        }
        this.r.c();
        this.s.c();
        if (z4) {
            invalidate();
        }
    }

    private void i(View view) {
        if (d(view)) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (this.u) {
                layoutParams.f3295b = 1.0f;
                layoutParams.f3297d = 1;
                a(view, true);
            } else {
                layoutParams.f3297d |= 2;
                if (a(view, 3)) {
                    this.f3286c.a(view, 0, view.getTop());
                } else {
                    this.f3287d.a(view, getWidth() - view.getWidth(), view.getTop());
                }
            }
            invalidate();
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
    }

    public final void c(int i2) {
        View b2 = b(i2);
        if (b2 != null) {
            i(b2);
            return;
        }
        throw new IllegalArgumentException("No drawer view found with gravity " + f(i2));
    }

    public final void e(View view) {
        if (d(view)) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (this.u) {
                layoutParams.f3295b = 0.0f;
                layoutParams.f3297d = 0;
            } else {
                layoutParams.f3297d |= 4;
                if (a(view, 3)) {
                    this.f3286c.a(view, -view.getWidth(), view.getTop());
                } else {
                    this.f3287d.a(view, getWidth(), view.getTop());
                }
            }
            invalidate();
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
    }

    public final void a() {
        d(8388611);
    }

    public final void d(int i2) {
        View b2 = b(i2);
        if (b2 != null) {
            e(b2);
            return;
        }
        throw new IllegalArgumentException("No drawer view found with gravity " + f(i2));
    }

    private static boolean j(View view) {
        if (d(view)) {
            return (((LayoutParams) view.getLayoutParams()).f3297d & 1) == 1;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    public final boolean e(int i2) {
        View b2 = b(i2);
        if (b2 != null) {
            return j(b2);
        }
        return false;
    }

    public static boolean f(View view) {
        if (d(view)) {
            return ((LayoutParams) view.getLayoutParams()).f3295b > 0.0f;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public void addFocusables(ArrayList<View> arrayList, int i2, int i3) {
        if (getDescendantFocusability() != 393216) {
            int childCount = getChildCount();
            boolean z2 = false;
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                if (!d(childAt)) {
                    this.M.add(childAt);
                } else if (j(childAt)) {
                    childAt.addFocusables(arrayList, i2, i3);
                    z2 = true;
                }
            }
            if (!z2) {
                int size = this.M.size();
                for (int i5 = 0; i5 < size; i5++) {
                    View view = this.M.get(i5);
                    if (view.getVisibility() == 0) {
                        view.addFocusables(arrayList, i2, i3);
                    }
                }
            }
            this.M.clear();
        }
    }

    /* access modifiers changed from: package-private */
    public final View b() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (d(childAt) && f(childAt)) {
                return childAt;
            }
        }
        return null;
    }

    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        if (i2 != 4) {
            return super.onKeyUp(i2, keyEvent);
        }
        View b2 = b();
        if (b2 != null && a(b2) == 0) {
            a(false);
        }
        if (b2 != null) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        View b2;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.f3245d);
        if (!(savedState.f3298a == 0 || (b2 = b(savedState.f3298a)) == null)) {
            i(b2);
        }
        if (savedState.f3299b != 3) {
            setDrawerLockMode(savedState.f3299b, 3);
        }
        if (savedState.f3300e != 3) {
            setDrawerLockMode(savedState.f3300e, 5);
        }
        if (savedState.f3301f != 3) {
            setDrawerLockMode(savedState.f3301f, 8388611);
        }
        if (savedState.f3302g != 3) {
            setDrawerLockMode(savedState.f3302g, 8388613);
        }
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        int childCount = getChildCount();
        int i2 = 0;
        while (true) {
            if (i2 >= childCount) {
                break;
            }
            LayoutParams layoutParams = (LayoutParams) getChildAt(i2).getLayoutParams();
            boolean z2 = true;
            boolean z3 = layoutParams.f3297d == 1;
            if (layoutParams.f3297d != 2) {
                z2 = false;
            }
            if (z3 || z2) {
                savedState.f3298a = layoutParams.f3294a;
            } else {
                i2++;
            }
        }
        savedState.f3299b = this.v;
        savedState.f3300e = this.w;
        savedState.f3301f = this.x;
        savedState.f3302g = this.y;
        return savedState;
    }

    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i2, layoutParams);
        if (c() != null || d(view)) {
            u.c(view, 4);
        } else {
            u.c(view, 1);
        }
        if (!f3285b) {
            u.a(view, (androidx.core.h.a) this.l);
        }
    }

    static boolean g(View view) {
        return (u.h(view) == 4 || u.h(view) == 2) ? false : true;
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
        int f3298a = 0;

        /* renamed from: b  reason: collision with root package name */
        int f3299b;

        /* renamed from: e  reason: collision with root package name */
        int f3300e;

        /* renamed from: f  reason: collision with root package name */
        int f3301f;

        /* renamed from: g  reason: collision with root package name */
        int f3302g;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f3298a = parcel.readInt();
            this.f3299b = parcel.readInt();
            this.f3300e = parcel.readInt();
            this.f3301f = parcel.readInt();
            this.f3302g = parcel.readInt();
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f3298a);
            parcel.writeInt(this.f3299b);
            parcel.writeInt(this.f3300e);
            parcel.writeInt(this.f3301f);
            parcel.writeInt(this.f3302g);
        }
    }

    class d extends c.a {

        /* renamed from: a  reason: collision with root package name */
        final int f3305a;

        /* renamed from: b  reason: collision with root package name */
        androidx.customview.a.c f3306b;

        /* renamed from: d  reason: collision with root package name */
        private final Runnable f3308d = new Runnable() {
            public final void run() {
                int i2;
                View view;
                d dVar = d.this;
                int i3 = dVar.f3306b.f3237d;
                boolean z = dVar.f3305a == 3;
                if (z) {
                    view = DrawerLayout.this.b(3);
                    i2 = (view != null ? -view.getWidth() : 0) + i3;
                } else {
                    view = DrawerLayout.this.b(5);
                    i2 = DrawerLayout.this.getWidth() - i3;
                }
                if (view == null) {
                    return;
                }
                if (((z && view.getLeft() < i2) || (!z && view.getLeft() > i2)) && DrawerLayout.this.a(view) == 0) {
                    dVar.f3306b.a(view, i2, view.getTop());
                    ((LayoutParams) view.getLayoutParams()).f3296c = true;
                    DrawerLayout.this.invalidate();
                    dVar.d();
                    DrawerLayout drawerLayout = DrawerLayout.this;
                    if (!drawerLayout.f3289f) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                        int childCount = drawerLayout.getChildCount();
                        for (int i4 = 0; i4 < childCount; i4++) {
                            drawerLayout.getChildAt(i4).dispatchTouchEvent(obtain);
                        }
                        obtain.recycle();
                        drawerLayout.f3289f = true;
                    }
                }
            }
        };

        d(int i2) {
            this.f3305a = i2;
        }

        public final void c() {
            DrawerLayout.this.removeCallbacks(this.f3308d);
        }

        public final boolean b(View view, int i2) {
            return DrawerLayout.d(view) && DrawerLayout.this.a(view, this.f3305a) && DrawerLayout.this.a(view) == 0;
        }

        public final void a(int i2) {
            View rootView;
            DrawerLayout drawerLayout = DrawerLayout.this;
            View view = this.f3306b.f3239f;
            int i3 = drawerLayout.f3286c.f3234a;
            int i4 = drawerLayout.f3287d.f3234a;
            int i5 = 2;
            if (i3 == 1 || i4 == 1) {
                i5 = 1;
            } else if (!(i3 == 2 || i4 == 2)) {
                i5 = 0;
            }
            if (view != null && i2 == 0) {
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                if (layoutParams.f3295b == 0.0f) {
                    LayoutParams layoutParams2 = (LayoutParams) view.getLayoutParams();
                    if ((layoutParams2.f3297d & 1) == 1) {
                        layoutParams2.f3297d = 0;
                        if (drawerLayout.f3290g != null) {
                            for (int size = drawerLayout.f3290g.size() - 1; size >= 0; size--) {
                                drawerLayout.f3290g.get(size).onDrawerClosed(view);
                            }
                        }
                        drawerLayout.a(view, false);
                        if (drawerLayout.hasWindowFocus() && (rootView = drawerLayout.getRootView()) != null) {
                            rootView.sendAccessibilityEvent(32);
                        }
                    }
                } else if (layoutParams.f3295b == 1.0f) {
                    LayoutParams layoutParams3 = (LayoutParams) view.getLayoutParams();
                    if ((layoutParams3.f3297d & 1) == 0) {
                        layoutParams3.f3297d = 1;
                        if (drawerLayout.f3290g != null) {
                            for (int size2 = drawerLayout.f3290g.size() - 1; size2 >= 0; size2--) {
                                drawerLayout.f3290g.get(size2).onDrawerOpened(view);
                            }
                        }
                        drawerLayout.a(view, true);
                        if (drawerLayout.hasWindowFocus()) {
                            drawerLayout.sendAccessibilityEvent(32);
                        }
                    }
                }
            }
            if (i5 != drawerLayout.f3288e) {
                drawerLayout.f3288e = i5;
                if (drawerLayout.f3290g != null) {
                    for (int size3 = drawerLayout.f3290g.size() - 1; size3 >= 0; size3--) {
                        drawerLayout.f3290g.get(size3);
                    }
                }
            }
        }

        public final void a(View view, int i2, int i3, int i4, int i5) {
            float f2;
            int width = view.getWidth();
            if (DrawerLayout.this.a(view, 3)) {
                f2 = (float) (i2 + width);
            } else {
                f2 = (float) (DrawerLayout.this.getWidth() - i2);
            }
            float f3 = f2 / ((float) width);
            DrawerLayout.this.a(view, f3);
            view.setVisibility(f3 == 0.0f ? 4 : 0);
            DrawerLayout.this.invalidate();
        }

        public final void a(View view, int i2) {
            ((LayoutParams) view.getLayoutParams()).f3296c = false;
            d();
        }

        /* access modifiers changed from: package-private */
        public final void d() {
            int i2 = 3;
            if (this.f3305a == 3) {
                i2 = 5;
            }
            View b2 = DrawerLayout.this.b(i2);
            if (b2 != null) {
                DrawerLayout.this.e(b2);
            }
        }

        public final void a(View view, float f2, float f3) {
            int i2;
            float b2 = DrawerLayout.b(view);
            int width = view.getWidth();
            if (DrawerLayout.this.a(view, 3)) {
                int i3 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
                i2 = (i3 > 0 || (i3 == 0 && b2 > 0.5f)) ? 0 : -width;
            } else {
                int width2 = DrawerLayout.this.getWidth();
                if (f2 < 0.0f || (f2 == 0.0f && b2 > 0.5f)) {
                    width2 -= width;
                }
                i2 = width2;
            }
            this.f3306b.a(i2, view.getTop());
            DrawerLayout.this.invalidate();
        }

        public final void a() {
            DrawerLayout.this.postDelayed(this.f3308d, 160);
        }

        public final void a(int i2, int i3) {
            View view;
            if ((i2 & 1) == 1) {
                view = DrawerLayout.this.b(3);
            } else {
                view = DrawerLayout.this.b(5);
            }
            if (view != null && DrawerLayout.this.a(view) == 0) {
                this.f3306b.a(view, i3);
            }
        }

        public final int a(View view) {
            if (DrawerLayout.d(view)) {
                return view.getWidth();
            }
            return 0;
        }

        public final int c(View view, int i2) {
            if (DrawerLayout.this.a(view, 3)) {
                return Math.max(-view.getWidth(), Math.min(i2, 0));
            }
            int width = DrawerLayout.this.getWidth();
            return Math.max(width - view.getWidth(), Math.min(i2, width));
        }

        public final int d(View view, int i2) {
            return view.getTop();
        }
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public int f3294a = 0;

        /* renamed from: b  reason: collision with root package name */
        float f3295b;

        /* renamed from: c  reason: collision with root package name */
        boolean f3296c;

        /* renamed from: d  reason: collision with root package name */
        int f3297d;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, DrawerLayout.f3284a);
            this.f3294a = obtainStyledAttributes.getInt(0, 0);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams() {
            super(-1, -1);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
            this.f3294a = layoutParams.f3294a;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }
    }

    class a extends androidx.core.h.a {

        /* renamed from: b  reason: collision with root package name */
        private final Rect f3304b = new Rect();

        a() {
        }

        public final void onInitializeAccessibilityNodeInfo(View view, androidx.core.h.a.c cVar) {
            if (DrawerLayout.f3285b) {
                super.onInitializeAccessibilityNodeInfo(view, cVar);
            } else {
                androidx.core.h.a.c a2 = androidx.core.h.a.c.a(cVar);
                super.onInitializeAccessibilityNodeInfo(view, a2);
                cVar.b(view);
                ViewParent k = u.k(view);
                if (k instanceof View) {
                    cVar.d((View) k);
                }
                Rect rect = this.f3304b;
                a2.a(rect);
                cVar.b(rect);
                a2.c(rect);
                cVar.d(rect);
                cVar.d(a2.b());
                cVar.a(a2.f3041a.getPackageName());
                cVar.b(a2.f3041a.getClassName());
                cVar.e(a2.f3041a.getContentDescription());
                cVar.i(a2.f3041a.isEnabled());
                cVar.g(a2.f3041a.isClickable());
                cVar.b(a2.f3041a.isFocusable());
                cVar.c(a2.f3041a.isFocused());
                cVar.e(a2.c());
                cVar.f(a2.f3041a.isSelected());
                cVar.h(a2.f3041a.isLongClickable());
                cVar.a(a2.f3041a.getActions());
                a2.f3041a.recycle();
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = viewGroup.getChildAt(i2);
                    if (DrawerLayout.g(childAt)) {
                        cVar.c(childAt);
                    }
                }
            }
            cVar.b((CharSequence) DrawerLayout.class.getName());
            cVar.b(false);
            cVar.c(false);
            cVar.b(c.a.f3044a);
            cVar.b(c.a.f3045b);
        }

        public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(DrawerLayout.class.getName());
        }

        public final boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            CharSequence charSequence;
            if (accessibilityEvent.getEventType() != 32) {
                return super.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
            }
            List text = accessibilityEvent.getText();
            View b2 = DrawerLayout.this.b();
            if (b2 == null) {
                return true;
            }
            int c2 = DrawerLayout.this.c(b2);
            DrawerLayout drawerLayout = DrawerLayout.this;
            int a2 = e.a(c2, u.j(drawerLayout));
            if (a2 == 3) {
                charSequence = drawerLayout.f3291h;
            } else if (a2 == 5) {
                charSequence = drawerLayout.f3292i;
            } else {
                charSequence = null;
            }
            if (charSequence == null) {
                return true;
            }
            text.add(charSequence);
            return true;
        }

        public final boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (DrawerLayout.f3285b || DrawerLayout.g(view)) {
                return super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
            }
            return false;
        }
    }

    static final class b extends androidx.core.h.a {
        b() {
        }

        public final void onInitializeAccessibilityNodeInfo(View view, androidx.core.h.a.c cVar) {
            super.onInitializeAccessibilityNodeInfo(view, cVar);
            if (!DrawerLayout.g(view)) {
                cVar.d((View) null);
            }
        }
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            if (b() != null) {
                keyEvent.startTracking();
                return true;
            }
        }
        return super.onKeyDown(i2, keyEvent);
    }
}
