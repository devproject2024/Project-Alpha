package androidx.core.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import android.widget.ScrollView;
import androidx.core.h.a.c;
import androidx.core.h.k;
import androidx.core.h.l;
import androidx.core.h.o;
import androidx.core.h.p;
import androidx.core.h.u;
import java.util.ArrayList;

public class NestedScrollView extends FrameLayout implements k, o {
    private static final a w = new a();
    private static final int[] x = {16843130};
    private float A;
    private b B;

    /* renamed from: a  reason: collision with root package name */
    private long f3159a;

    /* renamed from: b  reason: collision with root package name */
    private final Rect f3160b;

    /* renamed from: c  reason: collision with root package name */
    private OverScroller f3161c;

    /* renamed from: d  reason: collision with root package name */
    private EdgeEffect f3162d;

    /* renamed from: e  reason: collision with root package name */
    private EdgeEffect f3163e;

    /* renamed from: f  reason: collision with root package name */
    private int f3164f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f3165g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f3166h;

    /* renamed from: i  reason: collision with root package name */
    private View f3167i;
    private boolean j;
    private VelocityTracker k;
    private boolean l;
    private boolean m;
    private int n;
    private int o;
    private int p;
    private int q;
    private final int[] r;
    private final int[] s;
    private int t;
    private int u;
    private SavedState v;
    private final p y;
    private final l z;

    public interface b {
        void onScrollChange(NestedScrollView nestedScrollView, int i2, int i3, int i4, int i5);
    }

    private static int b(int i2, int i3, int i4) {
        if (i3 >= i4 || i2 < 0) {
            return 0;
        }
        return i3 + i2 > i4 ? i4 - i3 : i2;
    }

    public final boolean a(View view, View view2, int i2, int i3) {
        return (i2 & 2) != 0;
    }

    public boolean shouldDelayChildPressedState() {
        return true;
    }

    public NestedScrollView(Context context) {
        this(context, (AttributeSet) null);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f3160b = new Rect();
        this.f3165g = true;
        this.f3166h = false;
        this.f3167i = null;
        this.j = false;
        this.m = true;
        this.q = -1;
        this.r = new int[2];
        this.s = new int[2];
        this.f3161c = new OverScroller(getContext());
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.n = viewConfiguration.getScaledTouchSlop();
        this.o = viewConfiguration.getScaledMinimumFlingVelocity();
        this.p = viewConfiguration.getScaledMaximumFlingVelocity();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, x, i2, 0);
        setFillViewport(obtainStyledAttributes.getBoolean(0, false));
        obtainStyledAttributes.recycle();
        this.y = new p();
        this.z = new l(this);
        setNestedScrollingEnabled(true);
        u.a((View) this, (androidx.core.h.a) w);
    }

    private void a(int i2, int i3, int[] iArr, int i4, int[] iArr2) {
        this.z.a(0, i2, 0, i3, iArr, i4, iArr2);
    }

    private boolean a(int i2, int i3) {
        return this.z.a(i2, i3);
    }

    public void stopNestedScroll(int i2) {
        this.z.b(i2);
    }

    private boolean d(int i2) {
        return this.z.a(i2);
    }

    private boolean a(int i2, int i3, int[] iArr, int[] iArr2, int i4) {
        return this.z.a(i2, i3, iArr, iArr2, i4);
    }

    public void setNestedScrollingEnabled(boolean z2) {
        this.z.a(z2);
    }

    public boolean isNestedScrollingEnabled() {
        return this.z.f3109a;
    }

    public boolean startNestedScroll(int i2) {
        return a(i2, 0);
    }

    public void stopNestedScroll() {
        stopNestedScroll(0);
    }

    public boolean hasNestedScrollingParent() {
        return d(0);
    }

    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        return this.z.a(i2, i3, i4, i5, iArr);
    }

    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        return a(i2, i3, iArr, iArr2, 0);
    }

    public boolean dispatchNestedFling(float f2, float f3, boolean z2) {
        return this.z.a(f2, f3, z2);
    }

    public boolean dispatchNestedPreFling(float f2, float f3) {
        return this.z.a(f2, f3);
    }

    public final void a(View view, int i2, int i3, int i4, int i5, int i6, int[] iArr) {
        a(i5, i6, iArr);
    }

    private void a(int i2, int i3, int[] iArr) {
        int scrollY = getScrollY();
        scrollBy(0, i2);
        int scrollY2 = getScrollY() - scrollY;
        if (iArr != null) {
            iArr[1] = iArr[1] + scrollY2;
        }
        this.z.a(0, scrollY2, 0, i2 - scrollY2, (int[]) null, i3, iArr);
    }

    public final void b(View view, View view2, int i2, int i3) {
        this.y.a(i2, i3);
        a(2, i3);
    }

    public final void a(View view, int i2) {
        this.y.a(i2);
        stopNestedScroll(i2);
    }

    public final void a(View view, int i2, int i3, int i4, int i5, int i6) {
        a(i5, i6, (int[]) null);
    }

    public final void a(View view, int i2, int i3, int[] iArr, int i4) {
        a(i2, i3, iArr, (int[]) null, i4);
    }

    public boolean onStartNestedScroll(View view, View view2, int i2) {
        return a(view, view2, i2, 0);
    }

    public void onNestedScrollAccepted(View view, View view2, int i2) {
        b(view, view2, i2, 0);
    }

    public void onStopNestedScroll(View view) {
        a(view, 0);
    }

    public void onNestedScroll(View view, int i2, int i3, int i4, int i5) {
        a(i5, 0, (int[]) null);
    }

    public void onNestedPreScroll(View view, int i2, int i3, int[] iArr) {
        a(view, i2, i3, iArr, 0);
    }

    public boolean onNestedFling(View view, float f2, float f3, boolean z2) {
        if (z2) {
            return false;
        }
        dispatchNestedFling(0.0f, f3, true);
        h((int) f3);
        return true;
    }

    public boolean onNestedPreFling(View view, float f2, float f3) {
        return dispatchNestedPreFling(f2, f3);
    }

    public int getNestedScrollAxes() {
        return this.y.a();
    }

    /* access modifiers changed from: protected */
    public float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int scrollY = getScrollY();
        if (scrollY < verticalFadingEdgeLength) {
            return ((float) scrollY) / ((float) verticalFadingEdgeLength);
        }
        return 1.0f;
    }

    /* access modifiers changed from: protected */
    public float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        View childAt = getChildAt(0);
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int bottom = ((childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin) - getScrollY()) - (getHeight() - getPaddingBottom());
        if (bottom < verticalFadingEdgeLength) {
            return ((float) bottom) / ((float) verticalFadingEdgeLength);
        }
        return 1.0f;
    }

    public int getMaxScrollAmount() {
        return (int) (((float) getHeight()) * 0.5f);
    }

    public void addView(View view) {
        if (getChildCount() <= 0) {
            super.addView(view);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    public void addView(View view, int i2) {
        if (getChildCount() <= 0) {
            super.addView(view, i2);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, i2, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    public void setOnScrollChangeListener(b bVar) {
        this.B = bVar;
    }

    private boolean a() {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            if (childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin > (getHeight() - getPaddingTop()) - getPaddingBottom()) {
                return true;
            }
        }
        return false;
    }

    public void setFillViewport(boolean z2) {
        if (z2 != this.l) {
            this.l = z2;
            requestLayout();
        }
    }

    public void setSmoothScrollingEnabled(boolean z2) {
        this.m = z2;
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        super.onScrollChanged(i2, i3, i4, i5);
        b bVar = this.B;
        if (bVar != null) {
            bVar.onScrollChange(this, i2, i3, i4, i5);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (this.l && View.MeasureSpec.getMode(i3) != 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int measuredHeight2 = (((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - layoutParams.topMargin) - layoutParams.bottomMargin;
            if (measuredHeight < measuredHeight2) {
                childAt.measure(getChildMeasureSpec(i2, getPaddingLeft() + getPaddingRight() + layoutParams.leftMargin + layoutParams.rightMargin, layoutParams.width), View.MeasureSpec.makeMeasureSpec(measuredHeight2, 1073741824));
            }
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || a(keyEvent);
    }

    public final boolean a(KeyEvent keyEvent) {
        this.f3160b.setEmpty();
        int i2 = 130;
        if (!a()) {
            if (isFocused() && keyEvent.getKeyCode() != 4) {
                View findFocus = findFocus();
                if (findFocus == this) {
                    findFocus = null;
                }
                View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, 130);
                if (findNextFocus == null || findNextFocus == this || !findNextFocus.requestFocus(130)) {
                    return false;
                }
                return true;
            }
            return false;
        } else if (keyEvent.getAction() != 0) {
            return false;
        } else {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode != 19) {
                if (keyCode != 20) {
                    if (keyCode != 62) {
                        return false;
                    }
                    if (keyEvent.isShiftPressed()) {
                        i2 = 33;
                    }
                    e(i2);
                    return false;
                } else if (!keyEvent.isAltPressed()) {
                    return f(130);
                } else {
                    return a(130);
                }
            } else if (!keyEvent.isAltPressed()) {
                return f(33);
            } else {
                return a(33);
            }
        }
    }

    private void b() {
        if (this.k == null) {
            this.k = VelocityTracker.obtain();
        }
    }

    private void c() {
        VelocityTracker velocityTracker = this.k;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.k = null;
        }
    }

    public void requestDisallowInterceptTouchEvent(boolean z2) {
        if (z2) {
            c();
        }
        super.requestDisallowInterceptTouchEvent(z2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00d2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r12) {
        /*
            r11 = this;
            int r0 = r12.getAction()
            r1 = 2
            r2 = 1
            if (r0 != r1) goto L_0x000d
            boolean r3 = r11.j
            if (r3 == 0) goto L_0x000d
            return r2
        L_0x000d:
            r0 = r0 & 255(0xff, float:3.57E-43)
            r3 = 0
            if (r0 == 0) goto L_0x0095
            r4 = -1
            if (r0 == r2) goto L_0x0070
            if (r0 == r1) goto L_0x0024
            r1 = 3
            if (r0 == r1) goto L_0x0070
            r1 = 6
            if (r0 == r1) goto L_0x001f
            goto L_0x00fe
        L_0x001f:
            r11.a((android.view.MotionEvent) r12)
            goto L_0x00fe
        L_0x0024:
            int r0 = r11.q
            if (r0 == r4) goto L_0x00fe
            int r5 = r12.findPointerIndex(r0)
            if (r5 != r4) goto L_0x003f
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            java.lang.String r1 = "Invalid pointerId="
            r12.<init>(r1)
            r12.append(r0)
            java.lang.String r0 = " in onInterceptTouchEvent"
            r12.append(r0)
            goto L_0x00fe
        L_0x003f:
            float r0 = r12.getY(r5)
            int r0 = (int) r0
            int r4 = r11.f3164f
            int r4 = r0 - r4
            int r4 = java.lang.Math.abs(r4)
            int r5 = r11.n
            if (r4 <= r5) goto L_0x00fe
            int r4 = r11.getNestedScrollAxes()
            r1 = r1 & r4
            if (r1 != 0) goto L_0x00fe
            r11.j = r2
            r11.f3164f = r0
            r11.b()
            android.view.VelocityTracker r0 = r11.k
            r0.addMovement(r12)
            r11.t = r3
            android.view.ViewParent r12 = r11.getParent()
            if (r12 == 0) goto L_0x00fe
            r12.requestDisallowInterceptTouchEvent(r2)
            goto L_0x00fe
        L_0x0070:
            r11.j = r3
            r11.q = r4
            r11.c()
            android.widget.OverScroller r4 = r11.f3161c
            int r5 = r11.getScrollX()
            int r6 = r11.getScrollY()
            r7 = 0
            r8 = 0
            r9 = 0
            int r10 = r11.getScrollRange()
            boolean r12 = r4.springBack(r5, r6, r7, r8, r9, r10)
            if (r12 == 0) goto L_0x0091
            androidx.core.h.u.g(r11)
        L_0x0091:
            r11.stopNestedScroll(r3)
            goto L_0x00fe
        L_0x0095:
            float r0 = r12.getY()
            int r0 = (int) r0
            float r4 = r12.getX()
            int r4 = (int) r4
            int r5 = r11.getChildCount()
            if (r5 <= 0) goto L_0x00c9
            int r5 = r11.getScrollY()
            android.view.View r6 = r11.getChildAt(r3)
            int r7 = r6.getTop()
            int r7 = r7 - r5
            if (r0 < r7) goto L_0x00c9
            int r7 = r6.getBottom()
            int r7 = r7 - r5
            if (r0 >= r7) goto L_0x00c9
            int r5 = r6.getLeft()
            if (r4 < r5) goto L_0x00c9
            int r5 = r6.getRight()
            if (r4 >= r5) goto L_0x00c9
            r4 = 1
            goto L_0x00ca
        L_0x00c9:
            r4 = 0
        L_0x00ca:
            if (r4 != 0) goto L_0x00d2
            r11.j = r3
            r11.c()
            goto L_0x00fe
        L_0x00d2:
            r11.f3164f = r0
            int r0 = r12.getPointerId(r3)
            r11.q = r0
            android.view.VelocityTracker r0 = r11.k
            if (r0 != 0) goto L_0x00e5
            android.view.VelocityTracker r0 = android.view.VelocityTracker.obtain()
            r11.k = r0
            goto L_0x00e8
        L_0x00e5:
            r0.clear()
        L_0x00e8:
            android.view.VelocityTracker r0 = r11.k
            r0.addMovement(r12)
            android.widget.OverScroller r12 = r11.f3161c
            r12.computeScrollOffset()
            android.widget.OverScroller r12 = r11.f3161c
            boolean r12 = r12.isFinished()
            r12 = r12 ^ r2
            r11.j = r12
            r11.a((int) r1, (int) r3)
        L_0x00fe:
            boolean r12 = r11.j
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        ViewParent parent;
        MotionEvent motionEvent2 = motionEvent;
        b();
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.t = 0;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.offsetLocation(0.0f, (float) this.t);
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                VelocityTracker velocityTracker = this.k;
                velocityTracker.computeCurrentVelocity(1000, (float) this.p);
                int yVelocity = (int) velocityTracker.getYVelocity(this.q);
                if (Math.abs(yVelocity) >= this.o) {
                    int i2 = -yVelocity;
                    float f2 = (float) i2;
                    if (!dispatchNestedPreFling(0.0f, f2)) {
                        dispatchNestedFling(0.0f, f2, true);
                        h(i2);
                    }
                } else if (this.f3161c.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    u.g(this);
                }
                this.q = -1;
                e();
            } else if (actionMasked == 2) {
                int findPointerIndex = motionEvent2.findPointerIndex(this.q);
                if (findPointerIndex == -1) {
                    StringBuilder sb = new StringBuilder("Invalid pointerId=");
                    sb.append(this.q);
                    sb.append(" in onTouchEvent");
                } else {
                    int y2 = (int) motionEvent2.getY(findPointerIndex);
                    int i3 = this.f3164f - y2;
                    if (!this.j && Math.abs(i3) > this.n) {
                        ViewParent parent2 = getParent();
                        if (parent2 != null) {
                            parent2.requestDisallowInterceptTouchEvent(true);
                        }
                        this.j = true;
                        i3 = i3 > 0 ? i3 - this.n : i3 + this.n;
                    }
                    int i4 = i3;
                    if (this.j) {
                        if (a(0, i4, this.s, this.r, 0)) {
                            i4 -= this.s[1];
                            this.t += this.r[1];
                        }
                        this.f3164f = y2 - this.r[1];
                        int scrollY = getScrollY();
                        int scrollRange = getScrollRange();
                        int overScrollMode = getOverScrollMode();
                        boolean z2 = overScrollMode == 0 || (overScrollMode == 1 && scrollRange > 0);
                        if (a(i4, 0, getScrollY(), scrollRange) && !d(0)) {
                            this.k.clear();
                        }
                        int scrollY2 = getScrollY() - scrollY;
                        int[] iArr = this.s;
                        iArr[1] = 0;
                        a(scrollY2, i4 - scrollY2, this.r, 0, iArr);
                        int i5 = this.f3164f;
                        int[] iArr2 = this.r;
                        this.f3164f = i5 - iArr2[1];
                        this.t += iArr2[1];
                        if (z2) {
                            int i6 = i4 - this.s[1];
                            f();
                            int i7 = scrollY + i6;
                            if (i7 < 0) {
                                d.a(this.f3162d, ((float) i6) / ((float) getHeight()), motionEvent2.getX(findPointerIndex) / ((float) getWidth()));
                                if (!this.f3163e.isFinished()) {
                                    this.f3163e.onRelease();
                                }
                            } else if (i7 > scrollRange) {
                                d.a(this.f3163e, ((float) i6) / ((float) getHeight()), 1.0f - (motionEvent2.getX(findPointerIndex) / ((float) getWidth())));
                                if (!this.f3162d.isFinished()) {
                                    this.f3162d.onRelease();
                                }
                            }
                            EdgeEffect edgeEffect = this.f3162d;
                            if (edgeEffect != null && (!edgeEffect.isFinished() || !this.f3163e.isFinished())) {
                                u.g(this);
                            }
                        }
                    }
                }
            } else if (actionMasked == 3) {
                if (this.j && getChildCount() > 0 && this.f3161c.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    u.g(this);
                }
                this.q = -1;
                e();
            } else if (actionMasked == 5) {
                int actionIndex = motionEvent.getActionIndex();
                this.f3164f = (int) motionEvent2.getY(actionIndex);
                this.q = motionEvent2.getPointerId(actionIndex);
            } else if (actionMasked == 6) {
                a(motionEvent);
                this.f3164f = (int) motionEvent2.getY(motionEvent2.findPointerIndex(this.q));
            }
        } else if (getChildCount() == 0) {
            return false;
        } else {
            boolean z3 = !this.f3161c.isFinished();
            this.j = z3;
            if (z3 && (parent = getParent()) != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            if (!this.f3161c.isFinished()) {
                d();
            }
            this.f3164f = (int) motionEvent.getY();
            this.q = motionEvent2.getPointerId(0);
            a(2, 0);
        }
        VelocityTracker velocityTracker2 = this.k;
        if (velocityTracker2 != null) {
            velocityTracker2.addMovement(obtain);
        }
        obtain.recycle();
        return true;
    }

    private void a(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.q) {
            int i2 = actionIndex == 0 ? 1 : 0;
            this.f3164f = (int) motionEvent.getY(i2);
            this.q = motionEvent.getPointerId(i2);
            VelocityTracker velocityTracker = this.k;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) != 0 && motionEvent.getAction() == 8 && !this.j) {
            float axisValue = motionEvent.getAxisValue(9);
            if (axisValue != 0.0f) {
                int scrollRange = getScrollRange();
                int scrollY = getScrollY();
                int verticalScrollFactorCompat = scrollY - ((int) (axisValue * getVerticalScrollFactorCompat()));
                if (verticalScrollFactorCompat < 0) {
                    verticalScrollFactorCompat = 0;
                } else if (verticalScrollFactorCompat > scrollRange) {
                    verticalScrollFactorCompat = scrollRange;
                }
                if (verticalScrollFactorCompat != scrollY) {
                    super.scrollTo(getScrollX(), verticalScrollFactorCompat);
                    return true;
                }
            }
        }
        return false;
    }

    private float getVerticalScrollFactorCompat() {
        if (this.A == 0.0f) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (context.getTheme().resolveAttribute(16842829, typedValue, true)) {
                this.A = typedValue.getDimension(context.getResources().getDisplayMetrics());
            } else {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
        }
        return this.A;
    }

    /* access modifiers changed from: protected */
    public void onOverScrolled(int i2, int i3, boolean z2, boolean z3) {
        super.scrollTo(i2, i3);
    }

    private boolean a(int i2, int i3, int i4, int i5) {
        boolean z2;
        boolean z3;
        getOverScrollMode();
        computeHorizontalScrollRange();
        computeHorizontalScrollExtent();
        computeVerticalScrollRange();
        computeVerticalScrollExtent();
        int i6 = i3 + 0;
        int i7 = i2 + i4;
        int i8 = i5 + 0;
        if (i6 <= 0 && i6 >= 0) {
            z2 = false;
        } else {
            i6 = 0;
            z2 = true;
        }
        if (i7 > i8) {
            z3 = true;
        } else if (i7 < 0) {
            z3 = true;
            i8 = 0;
        } else {
            i8 = i7;
            z3 = false;
        }
        if (z3 && !d(1)) {
            this.f3161c.springBack(i6, i8, 0, 0, 0, getScrollRange());
        }
        onOverScrolled(i6, i8, z2, z3);
        return z2 || z3;
    }

    /* access modifiers changed from: package-private */
    public int getScrollRange() {
        if (getChildCount() <= 0) {
            return 0;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        return Math.max(0, ((childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin) - ((getHeight() - getPaddingTop()) - getPaddingBottom()));
    }

    private View a(boolean z2, int i2, int i3) {
        ArrayList focusables = getFocusables(2);
        int size = focusables.size();
        View view = null;
        boolean z3 = false;
        for (int i4 = 0; i4 < size; i4++) {
            View view2 = (View) focusables.get(i4);
            int top = view2.getTop();
            int bottom = view2.getBottom();
            if (i2 < bottom && top < i3) {
                boolean z4 = i2 < top && bottom < i3;
                if (view == null) {
                    view = view2;
                    z3 = z4;
                } else {
                    boolean z5 = (z2 && top < view.getTop()) || (!z2 && bottom > view.getBottom());
                    if (z3) {
                        if (z4) {
                            if (!z5) {
                            }
                        }
                    } else if (z4) {
                        view = view2;
                        z3 = true;
                    } else if (!z5) {
                    }
                    view = view2;
                }
            }
        }
        return view;
    }

    private boolean e(int i2) {
        boolean z2 = i2 == 130;
        int height = getHeight();
        if (z2) {
            this.f3160b.top = getScrollY() + height;
            int childCount = getChildCount();
            if (childCount > 0) {
                View childAt = getChildAt(childCount - 1);
                int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin + getPaddingBottom();
                if (this.f3160b.top + height > bottom) {
                    this.f3160b.top = bottom - height;
                }
            }
        } else {
            this.f3160b.top = getScrollY() - height;
            if (this.f3160b.top < 0) {
                this.f3160b.top = 0;
            }
        }
        Rect rect = this.f3160b;
        rect.bottom = rect.top + height;
        return a(i2, this.f3160b.top, this.f3160b.bottom);
    }

    public final boolean a(int i2) {
        int childCount;
        boolean z2 = i2 == 130;
        int height = getHeight();
        Rect rect = this.f3160b;
        rect.top = 0;
        rect.bottom = height;
        if (z2 && (childCount = getChildCount()) > 0) {
            View childAt = getChildAt(childCount - 1);
            this.f3160b.bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin + getPaddingBottom();
            Rect rect2 = this.f3160b;
            rect2.top = rect2.bottom - height;
        }
        return a(i2, this.f3160b.top, this.f3160b.bottom);
    }

    private boolean a(int i2, int i3, int i4) {
        int height = getHeight();
        int scrollY = getScrollY();
        int i5 = height + scrollY;
        boolean z2 = false;
        boolean z3 = i2 == 33;
        View a2 = a(z3, i3, i4);
        if (a2 == null) {
            a2 = this;
        }
        if (i3 < scrollY || i4 > i5) {
            g(z3 ? i3 - scrollY : i4 - i5);
            z2 = true;
        }
        if (a2 != findFocus()) {
            a2.requestFocus(i2);
        }
        return z2;
    }

    private boolean f(int i2) {
        View findFocus = findFocus();
        if (findFocus == this) {
            findFocus = null;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i2);
        int maxScrollAmount = getMaxScrollAmount();
        if (findNextFocus == null || !a(findNextFocus, maxScrollAmount, getHeight())) {
            if (i2 == 33 && getScrollY() < maxScrollAmount) {
                maxScrollAmount = getScrollY();
            } else if (i2 == 130 && getChildCount() > 0) {
                View childAt = getChildAt(0);
                maxScrollAmount = Math.min((childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin) - ((getScrollY() + getHeight()) - getPaddingBottom()), maxScrollAmount);
            }
            if (maxScrollAmount == 0) {
                return false;
            }
            if (i2 != 130) {
                maxScrollAmount = -maxScrollAmount;
            }
            g(maxScrollAmount);
        } else {
            findNextFocus.getDrawingRect(this.f3160b);
            offsetDescendantRectToMyCoords(findNextFocus, this.f3160b);
            g(a(this.f3160b));
            findNextFocus.requestFocus(i2);
        }
        if (findFocus == null || !findFocus.isFocused() || !a(findFocus)) {
            return true;
        }
        int descendantFocusability = getDescendantFocusability();
        setDescendantFocusability(131072);
        requestFocus();
        setDescendantFocusability(descendantFocusability);
        return true;
    }

    private boolean a(View view) {
        return !a(view, 0, getHeight());
    }

    private boolean a(View view, int i2, int i3) {
        view.getDrawingRect(this.f3160b);
        offsetDescendantRectToMyCoords(view, this.f3160b);
        return this.f3160b.bottom + i2 >= getScrollY() && this.f3160b.top - i2 <= getScrollY() + i3;
    }

    private void g(int i2) {
        if (i2 == 0) {
            return;
        }
        if (this.m) {
            a(0, i2, false);
        } else {
            scrollBy(0, i2);
        }
    }

    public final void b(int i2) {
        a(0, i2, false);
    }

    public final void a(int i2, int i3, boolean z2) {
        if (getChildCount() != 0) {
            if (AnimationUtils.currentAnimationTimeMillis() - this.f3159a > 250) {
                View childAt = getChildAt(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                int scrollY = getScrollY();
                OverScroller overScroller = this.f3161c;
                int scrollX = getScrollX();
                overScroller.startScroll(scrollX, scrollY, 0, Math.max(0, Math.min(i3 + scrollY, Math.max(0, ((childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin) - ((getHeight() - getPaddingTop()) - getPaddingBottom())))) - scrollY, 250);
                a(z2);
            } else {
                if (!this.f3161c.isFinished()) {
                    d();
                }
                scrollBy(i2, i3);
            }
            this.f3159a = AnimationUtils.currentAnimationTimeMillis();
        }
    }

    public final void c(int i2) {
        a(i2, false);
    }

    public final void a(int i2, boolean z2) {
        a(0 - getScrollX(), i2 - getScrollY(), z2);
    }

    public int computeVerticalScrollRange() {
        int childCount = getChildCount();
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (childCount == 0) {
            return height;
        }
        View childAt = getChildAt(0);
        int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
        int scrollY = getScrollY();
        int max = Math.max(0, bottom - height);
        if (scrollY < 0) {
            return bottom - scrollY;
        }
        return scrollY > max ? bottom + (scrollY - max) : bottom;
    }

    public int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    public int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    public int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    public int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    public int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    /* access modifiers changed from: protected */
    public void measureChild(View view, int i2, int i3) {
        view.measure(getChildMeasureSpec(i2, getPaddingLeft() + getPaddingRight(), view.getLayoutParams().width), View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    /* access modifiers changed from: protected */
    public void measureChildWithMargins(View view, int i2, int i3, int i4, int i5) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(getChildMeasureSpec(i2, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i3, marginLayoutParams.width), View.MeasureSpec.makeMeasureSpec(marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, 0));
    }

    public void computeScroll() {
        if (!this.f3161c.isFinished()) {
            this.f3161c.computeScrollOffset();
            int currY = this.f3161c.getCurrY();
            int i2 = currY - this.u;
            this.u = currY;
            int[] iArr = this.s;
            boolean z2 = false;
            iArr[1] = 0;
            a(0, i2, iArr, (int[]) null, 1);
            int i3 = i2 - this.s[1];
            int scrollRange = getScrollRange();
            if (i3 != 0) {
                int scrollY = getScrollY();
                a(i3, getScrollX(), scrollY, scrollRange);
                int scrollY2 = getScrollY() - scrollY;
                int i4 = i3 - scrollY2;
                int[] iArr2 = this.s;
                iArr2[1] = 0;
                a(scrollY2, i4, this.r, 1, iArr2);
                i3 = i4 - this.s[1];
            }
            if (i3 != 0) {
                int overScrollMode = getOverScrollMode();
                if (overScrollMode == 0 || (overScrollMode == 1 && scrollRange > 0)) {
                    z2 = true;
                }
                if (z2) {
                    f();
                    if (i3 < 0) {
                        if (this.f3162d.isFinished()) {
                            this.f3162d.onAbsorb((int) this.f3161c.getCurrVelocity());
                        }
                    } else if (this.f3163e.isFinished()) {
                        this.f3163e.onAbsorb((int) this.f3161c.getCurrVelocity());
                    }
                }
                d();
            }
            if (!this.f3161c.isFinished()) {
                u.g(this);
            } else {
                stopNestedScroll(1);
            }
        }
    }

    private void a(boolean z2) {
        if (z2) {
            a(2, 1);
        } else {
            stopNestedScroll(1);
        }
        this.u = getScrollY();
        u.g(this);
    }

    private void d() {
        this.f3161c.abortAnimation();
        stopNestedScroll(1);
    }

    private void b(View view) {
        view.getDrawingRect(this.f3160b);
        offsetDescendantRectToMyCoords(view, this.f3160b);
        int a2 = a(this.f3160b);
        if (a2 != 0) {
            scrollBy(0, a2);
        }
    }

    private int a(Rect rect) {
        int i2;
        int i3;
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int scrollY = getScrollY();
        int i4 = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            scrollY += verticalFadingEdgeLength;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        int i5 = rect.bottom < (childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin ? i4 - verticalFadingEdgeLength : i4;
        if (rect.bottom > i5 && rect.top > scrollY) {
            if (rect.height() > height) {
                i3 = rect.top - scrollY;
            } else {
                i3 = rect.bottom - i5;
            }
            return Math.min(i3 + 0, (childAt.getBottom() + layoutParams.bottomMargin) - i4);
        } else if (rect.top >= scrollY || rect.bottom >= i5) {
            return 0;
        } else {
            if (rect.height() > height) {
                i2 = 0 - (i5 - rect.bottom);
            } else {
                i2 = 0 - (scrollY - rect.top);
            }
            return Math.max(i2, -getScrollY());
        }
    }

    public void requestChildFocus(View view, View view2) {
        if (!this.f3165g) {
            b(view2);
        } else {
            this.f3167i = view2;
        }
        super.requestChildFocus(view, view2);
    }

    /* access modifiers changed from: protected */
    public boolean onRequestFocusInDescendants(int i2, Rect rect) {
        View view;
        if (i2 == 2) {
            i2 = 130;
        } else if (i2 == 1) {
            i2 = 33;
        }
        if (rect == null) {
            view = FocusFinder.getInstance().findNextFocus(this, (View) null, i2);
        } else {
            view = FocusFinder.getInstance().findNextFocusFromRect(this, rect, i2);
        }
        if (view != null && !a(view)) {
            return view.requestFocus(i2, rect);
        }
        return false;
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z2) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        int a2 = a(rect);
        boolean z3 = a2 != 0;
        if (z3) {
            if (z2) {
                scrollBy(0, a2);
            } else {
                a(0, a2, false);
            }
        }
        return z3;
    }

    public void requestLayout() {
        this.f3165g = true;
        super.requestLayout();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        super.onLayout(z2, i2, i3, i4, i5);
        int i6 = 0;
        this.f3165g = false;
        View view = this.f3167i;
        if (view != null && a(view, (View) this)) {
            b(this.f3167i);
        }
        this.f3167i = null;
        if (!this.f3166h) {
            if (this.v != null) {
                scrollTo(getScrollX(), this.v.f3168a);
                this.v = null;
            }
            if (getChildCount() > 0) {
                View childAt = getChildAt(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                i6 = childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            }
            int paddingTop = ((i5 - i3) - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            int b2 = b(scrollY, paddingTop, i6);
            if (b2 != scrollY) {
                scrollTo(getScrollX(), b2);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        this.f3166h = true;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f3166h = false;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        View findFocus = findFocus();
        if (findFocus != null && this != findFocus && a(findFocus, 0, i5)) {
            findFocus.getDrawingRect(this.f3160b);
            offsetDescendantRectToMyCoords(findFocus, this.f3160b);
            g(a(this.f3160b));
        }
    }

    private static boolean a(View view, View view2) {
        if (view == view2) {
            return true;
        }
        ViewParent parent = view.getParent();
        if (!(parent instanceof ViewGroup) || !a((View) parent, view2)) {
            return false;
        }
        return true;
    }

    private void h(int i2) {
        if (getChildCount() > 0) {
            this.f3161c.fling(getScrollX(), getScrollY(), 0, i2, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
            a(true);
        }
    }

    private void e() {
        this.j = false;
        c();
        stopNestedScroll(0);
        EdgeEffect edgeEffect = this.f3162d;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            this.f3163e.onRelease();
        }
    }

    public void scrollTo(int i2, int i3) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int b2 = b(i2, (getWidth() - getPaddingLeft()) - getPaddingRight(), childAt.getWidth() + layoutParams.leftMargin + layoutParams.rightMargin);
            int b3 = b(i3, (getHeight() - getPaddingTop()) - getPaddingBottom(), childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin);
            if (b2 != getScrollX() || b3 != getScrollY()) {
                super.scrollTo(b2, b3);
            }
        }
    }

    private void f() {
        if (getOverScrollMode() == 2) {
            this.f3162d = null;
            this.f3163e = null;
        } else if (this.f3162d == null) {
            Context context = getContext();
            this.f3162d = new EdgeEffect(context);
            this.f3163e = new EdgeEffect(context);
        }
    }

    public void draw(Canvas canvas) {
        int i2;
        super.draw(canvas);
        if (this.f3162d != null) {
            int scrollY = getScrollY();
            int i3 = 0;
            if (!this.f3162d.isFinished()) {
                int save = canvas.save();
                int width = getWidth();
                int height = getHeight();
                int min = Math.min(0, scrollY);
                if (Build.VERSION.SDK_INT < 21 || getClipToPadding()) {
                    width -= getPaddingLeft() + getPaddingRight();
                    i2 = getPaddingLeft() + 0;
                } else {
                    i2 = 0;
                }
                if (Build.VERSION.SDK_INT >= 21 && getClipToPadding()) {
                    height -= getPaddingTop() + getPaddingBottom();
                    min += getPaddingTop();
                }
                canvas.translate((float) i2, (float) min);
                this.f3162d.setSize(width, height);
                if (this.f3162d.draw(canvas)) {
                    u.g(this);
                }
                canvas.restoreToCount(save);
            }
            if (!this.f3163e.isFinished()) {
                int save2 = canvas.save();
                int width2 = getWidth();
                int height2 = getHeight();
                int max = Math.max(getScrollRange(), scrollY) + height2;
                if (Build.VERSION.SDK_INT < 21 || getClipToPadding()) {
                    width2 -= getPaddingLeft() + getPaddingRight();
                    i3 = 0 + getPaddingLeft();
                }
                if (Build.VERSION.SDK_INT >= 21 && getClipToPadding()) {
                    height2 -= getPaddingTop() + getPaddingBottom();
                    max -= getPaddingBottom();
                }
                canvas.translate((float) (i3 - width2), (float) max);
                canvas.rotate(180.0f, (float) width2, 0.0f);
                this.f3163e.setSize(width2, height2);
                if (this.f3163e.draw(canvas)) {
                    u.g(this);
                }
                canvas.restoreToCount(save2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.v = savedState;
        requestLayout();
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f3168a = getScrollY();
        return savedState;
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
                return new SavedState[i2];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }
        };

        /* renamed from: a  reason: collision with root package name */
        public int f3168a;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        SavedState(Parcel parcel) {
            super(parcel);
            this.f3168a = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f3168a);
        }

        public String toString() {
            return "HorizontalScrollView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " scrollPosition=" + this.f3168a + "}";
        }
    }

    static class a extends androidx.core.h.a {
        a() {
        }

        public final boolean performAccessibilityAction(View view, int i2, Bundle bundle) {
            if (super.performAccessibilityAction(view, i2, bundle)) {
                return true;
            }
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            if (!nestedScrollView.isEnabled()) {
                return false;
            }
            if (i2 != 4096) {
                if (i2 == 8192 || i2 == 16908344) {
                    int max = Math.max(nestedScrollView.getScrollY() - ((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), 0);
                    if (max == nestedScrollView.getScrollY()) {
                        return false;
                    }
                    nestedScrollView.a(max, true);
                    return true;
                } else if (i2 != 16908346) {
                    return false;
                }
            }
            int min = Math.min(nestedScrollView.getScrollY() + ((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), nestedScrollView.getScrollRange());
            if (min == nestedScrollView.getScrollY()) {
                return false;
            }
            nestedScrollView.a(min, true);
            return true;
        }

        public final void onInitializeAccessibilityNodeInfo(View view, c cVar) {
            int scrollRange;
            super.onInitializeAccessibilityNodeInfo(view, cVar);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            cVar.b((CharSequence) ScrollView.class.getName());
            if (nestedScrollView.isEnabled() && (scrollRange = nestedScrollView.getScrollRange()) > 0) {
                cVar.j(true);
                if (nestedScrollView.getScrollY() > 0) {
                    cVar.a(c.a.n);
                    cVar.a(c.a.y);
                }
                if (nestedScrollView.getScrollY() < scrollRange) {
                    cVar.a(c.a.m);
                    cVar.a(c.a.A);
                }
            }
        }

        public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            accessibilityEvent.setClassName(ScrollView.class.getName());
            accessibilityEvent.setScrollable(nestedScrollView.getScrollRange() > 0);
            accessibilityEvent.setScrollX(nestedScrollView.getScrollX());
            accessibilityEvent.setScrollY(nestedScrollView.getScrollY());
            int scrollX = nestedScrollView.getScrollX();
            if (Build.VERSION.SDK_INT >= 15) {
                accessibilityEvent.setMaxScrollX(scrollX);
            }
            int scrollRange = nestedScrollView.getScrollRange();
            if (Build.VERSION.SDK_INT >= 15) {
                accessibilityEvent.setMaxScrollY(scrollRange);
            }
        }
    }
}
