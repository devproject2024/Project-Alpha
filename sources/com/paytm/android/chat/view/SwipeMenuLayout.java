package com.paytm.android.chat.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import com.paytm.android.chat.R;

public class SwipeMenuLayout extends ViewGroup {
    private static SwipeMenuLayout m;
    private static boolean n;

    /* renamed from: a  reason: collision with root package name */
    public boolean f42527a;

    /* renamed from: b  reason: collision with root package name */
    private int f42528b;

    /* renamed from: c  reason: collision with root package name */
    private int f42529c;

    /* renamed from: d  reason: collision with root package name */
    private int f42530d;

    /* renamed from: e  reason: collision with root package name */
    private int f42531e;

    /* renamed from: f  reason: collision with root package name */
    private int f42532f;

    /* renamed from: g  reason: collision with root package name */
    private int f42533g;

    /* renamed from: h  reason: collision with root package name */
    private View f42534h;

    /* renamed from: i  reason: collision with root package name */
    private PointF f42535i;
    private boolean j;
    private PointF k;
    private boolean l;
    private VelocityTracker o;
    private boolean p;
    private boolean q;
    private boolean r;
    private boolean s;
    private long t;
    private float u;
    private float v;
    private ValueAnimator w;
    private ValueAnimator x;
    private a y;

    public interface a {
        void a();
    }

    public SwipeMenuLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public SwipeMenuLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SwipeMenuLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f42535i = new PointF();
        this.j = true;
        this.k = new PointF();
        a(context, attributeSet, i2);
    }

    public void setSwipeEnable(boolean z) {
        this.p = z;
    }

    public static SwipeMenuLayout getViewCache() {
        return m;
    }

    private void a(Context context, AttributeSet attributeSet, int i2) {
        this.f42528b = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f42529c = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
        this.p = true;
        this.q = true;
        this.s = true;
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.SwipeMenuLayout, i2, 0);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i3 = 0; i3 < indexCount; i3++) {
            int index = obtainStyledAttributes.getIndex(i3);
            if (index == R.styleable.SwipeMenuLayout_swipeEnable) {
                this.p = obtainStyledAttributes.getBoolean(index, true);
            } else if (index == R.styleable.SwipeMenuLayout_ios) {
                this.q = obtainStyledAttributes.getBoolean(index, true);
            } else if (index == R.styleable.SwipeMenuLayout_leftSwipe) {
                this.s = obtainStyledAttributes.getBoolean(index, true);
            }
        }
        obtainStyledAttributes.recycle();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        setClickable(true);
        this.f42532f = 0;
        this.f42531e = 0;
        int childCount = getChildCount();
        boolean z = View.MeasureSpec.getMode(i3) != 1073741824;
        int i4 = 0;
        boolean z2 = false;
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            childAt.setClickable(true);
            if (childAt.getVisibility() != 8) {
                measureChild(childAt, i2, i3);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                this.f42531e = Math.max(this.f42531e, childAt.getMeasuredHeight());
                if (z && marginLayoutParams.height == -1) {
                    z2 = true;
                }
                if (i5 > 0) {
                    this.f42532f += childAt.getMeasuredWidth();
                } else {
                    this.f42534h = childAt;
                    i4 = childAt.getMeasuredWidth();
                }
            } else {
                int i6 = i2;
                int i7 = i3;
            }
        }
        int i8 = i2;
        setMeasuredDimension(getPaddingLeft() + getPaddingRight() + i4, this.f42531e + getPaddingTop() + getPaddingBottom());
        this.f42533g = (this.f42532f * 4) / 10;
        if (z2) {
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
            for (int i9 = 0; i9 < childCount; i9++) {
                View childAt2 = getChildAt(i9);
                if (childAt2.getVisibility() != 8) {
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) childAt2.getLayoutParams();
                    if (marginLayoutParams2.height == -1) {
                        int i10 = marginLayoutParams2.width;
                        marginLayoutParams2.width = childAt2.getMeasuredWidth();
                        measureChildWithMargins(childAt2, i2, 0, makeMeasureSpec, 0);
                        marginLayoutParams2.width = i10;
                    }
                }
            }
        }
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int measuredWidth;
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft() + 0;
        int paddingLeft2 = getPaddingLeft() + 0;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                if (i6 == 0) {
                    childAt.layout(paddingLeft, getPaddingTop(), childAt.getMeasuredWidth() + paddingLeft, getPaddingTop() + childAt.getMeasuredHeight());
                    measuredWidth = childAt.getMeasuredWidth();
                } else if (this.s) {
                    childAt.layout(paddingLeft, getPaddingTop(), childAt.getMeasuredWidth() + paddingLeft, getPaddingTop() + childAt.getMeasuredHeight());
                    measuredWidth = childAt.getMeasuredWidth();
                } else {
                    childAt.layout(paddingLeft2 - childAt.getMeasuredWidth(), getPaddingTop(), paddingLeft2, getPaddingTop() + childAt.getMeasuredHeight());
                    paddingLeft2 -= childAt.getMeasuredWidth();
                }
                paddingLeft += measuredWidth;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0023, code lost:
        if (r1 != 3) goto L_0x018b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean dispatchTouchEvent(android.view.MotionEvent r11) {
        /*
            r10 = this;
            boolean r0 = r10.p
            if (r0 == 0) goto L_0x018b
            android.view.VelocityTracker r0 = r10.o
            if (r0 != 0) goto L_0x000e
            android.view.VelocityTracker r0 = android.view.VelocityTracker.obtain()
            r10.o = r0
        L_0x000e:
            android.view.VelocityTracker r0 = r10.o
            r0.addMovement(r11)
            android.view.VelocityTracker r0 = r10.o
            int r1 = r11.getAction()
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x0134
            if (r1 == r2) goto L_0x0094
            r4 = 2
            if (r1 == r4) goto L_0x0027
            r4 = 3
            if (r1 == r4) goto L_0x0094
            goto L_0x018b
        L_0x0027:
            boolean r0 = r10.r
            if (r0 != 0) goto L_0x018b
            android.graphics.PointF r0 = r10.f42535i
            float r0 = r0.x
            float r1 = r11.getRawX()
            float r0 = r0 - r1
            int r1 = r10.getScrollX()
            int r1 = java.lang.Math.abs(r1)
            if (r1 <= 0) goto L_0x0045
            android.view.ViewParent r1 = r10.getParent()
            r1.requestDisallowInterceptTouchEvent(r2)
        L_0x0045:
            float r1 = java.lang.Math.abs(r0)
            int r2 = r10.f42528b
            float r2 = (float) r2
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 <= 0) goto L_0x0052
            r10.j = r3
        L_0x0052:
            int r0 = (int) r0
            r10.scrollBy(r0, r3)
            boolean r0 = r10.s
            if (r0 == 0) goto L_0x006f
            int r0 = r10.getScrollX()
            if (r0 >= 0) goto L_0x0063
            r10.scrollTo(r3, r3)
        L_0x0063:
            int r0 = r10.getScrollX()
            int r1 = r10.f42532f
            if (r0 <= r1) goto L_0x0085
            r10.scrollTo(r1, r3)
            goto L_0x0085
        L_0x006f:
            int r0 = r10.getScrollX()
            int r1 = r10.f42532f
            int r2 = -r1
            if (r0 >= r2) goto L_0x007c
            int r0 = -r1
            r10.scrollTo(r0, r3)
        L_0x007c:
            int r0 = r10.getScrollX()
            if (r0 <= 0) goto L_0x0085
            r10.scrollTo(r3, r3)
        L_0x0085:
            android.graphics.PointF r0 = r10.f42535i
            float r1 = r11.getRawX()
            float r2 = r11.getRawY()
            r0.set(r1, r2)
            goto L_0x018b
        L_0x0094:
            java.util.Calendar r1 = java.util.Calendar.getInstance()
            long r4 = r1.getTimeInMillis()
            long r6 = r10.t
            long r4 = r4 - r6
            float r1 = r11.getX()
            float r6 = r11.getY()
            float r7 = r10.u
            float r1 = r1 - r7
            float r7 = r10.v
            float r6 = r6 - r7
            r7 = 100
            int r9 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r9 >= 0) goto L_0x00c3
            r4 = 1084227584(0x40a00000, float:5.0)
            int r1 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r1 >= 0) goto L_0x00c3
            int r1 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r1 >= 0) goto L_0x00c3
            com.paytm.android.chat.view.SwipeMenuLayout$a r0 = r10.y
            r0.a()
            goto L_0x0122
        L_0x00c3:
            float r1 = r11.getRawX()
            android.graphics.PointF r4 = r10.k
            float r4 = r4.x
            float r1 = r1 - r4
            float r1 = java.lang.Math.abs(r1)
            int r4 = r10.f42528b
            float r4 = (float) r4
            int r1 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r1 <= 0) goto L_0x0122
            r10.l = r2
            boolean r1 = r10.r
            if (r1 != 0) goto L_0x0122
            r1 = 1000(0x3e8, float:1.401E-42)
            int r2 = r10.f42529c
            float r2 = (float) r2
            r0.computeCurrentVelocity(r1, r2)
            int r1 = r10.f42530d
            float r0 = r0.getXVelocity(r1)
            float r1 = java.lang.Math.abs(r0)
            r2 = 1148846080(0x447a0000, float:1000.0)
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 <= 0) goto L_0x010f
            r1 = -998637568(0xffffffffc47a0000, float:-1000.0)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x0107
            boolean r0 = r10.s
            if (r0 == 0) goto L_0x0103
            r10.b()
            goto L_0x0122
        L_0x0103:
            r10.a()
            goto L_0x0122
        L_0x0107:
            boolean r0 = r10.s
            if (r0 != 0) goto L_0x011f
            r10.b()
            goto L_0x0122
        L_0x010f:
            int r0 = r10.getScrollX()
            int r0 = java.lang.Math.abs(r0)
            int r1 = r10.f42533g
            if (r0 <= r1) goto L_0x011f
            r10.b()
            goto L_0x0122
        L_0x011f:
            r10.a()
        L_0x0122:
            android.view.VelocityTracker r0 = r10.o
            if (r0 == 0) goto L_0x0131
            r0.clear()
            android.view.VelocityTracker r0 = r10.o
            r0.recycle()
            r0 = 0
            r10.o = r0
        L_0x0131:
            n = r3
            goto L_0x018b
        L_0x0134:
            java.util.Calendar r0 = java.util.Calendar.getInstance()
            long r0 = r0.getTimeInMillis()
            r10.t = r0
            float r0 = r11.getX()
            r10.u = r0
            float r0 = r11.getY()
            r10.v = r0
            r10.l = r3
            r10.j = r2
            r10.r = r3
            boolean r0 = n
            if (r0 == 0) goto L_0x0155
            return r3
        L_0x0155:
            n = r2
            android.graphics.PointF r0 = r10.f42535i
            float r1 = r11.getRawX()
            float r4 = r11.getRawY()
            r0.set(r1, r4)
            android.graphics.PointF r0 = r10.k
            float r1 = r11.getRawX()
            float r4 = r11.getRawY()
            r0.set(r1, r4)
            com.paytm.android.chat.view.SwipeMenuLayout r0 = m
            if (r0 == 0) goto L_0x0185
            if (r0 == r10) goto L_0x017e
            r0.a()
            boolean r0 = r10.q
            r10.r = r0
        L_0x017e:
            android.view.ViewParent r0 = r10.getParent()
            r0.requestDisallowInterceptTouchEvent(r2)
        L_0x0185:
            int r0 = r11.getPointerId(r3)
            r10.f42530d = r0
        L_0x018b:
            boolean r11 = super.dispatchTouchEvent(r11)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.android.chat.view.SwipeMenuLayout.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.p) {
            int action = motionEvent.getAction();
            if (action == 1) {
                if (this.s) {
                    if (getScrollX() > this.f42528b && motionEvent.getX() < ((float) (getWidth() - getScrollX()))) {
                        if (this.j) {
                            a();
                        }
                        return true;
                    }
                } else if ((-getScrollX()) > this.f42528b && motionEvent.getX() > ((float) (-getScrollX()))) {
                    if (this.j) {
                        a();
                    }
                    return true;
                }
                if (this.l) {
                    return true;
                }
            } else if (action == 2 && Math.abs(motionEvent.getRawX() - this.k.x) > ((float) this.f42528b)) {
                return true;
            }
            if (this.r) {
                return true;
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    private void b() {
        m = this;
        View view = this.f42534h;
        if (view != null) {
            view.setLongClickable(false);
        }
        c();
        int[] iArr = new int[2];
        iArr[0] = getScrollX();
        iArr[1] = this.s ? this.f42532f : -this.f42532f;
        this.w = ValueAnimator.ofInt(iArr);
        this.w.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                SwipeMenuLayout.this.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
            }
        });
        this.w.setInterpolator(new OvershootInterpolator());
        this.w.addListener(new AnimatorListenerAdapter() {
            public final void onAnimationEnd(Animator animator) {
                boolean unused = SwipeMenuLayout.this.f42527a = true;
            }
        });
        this.w.setDuration(300).start();
    }

    private void c() {
        ValueAnimator valueAnimator = this.x;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.x.cancel();
        }
        ValueAnimator valueAnimator2 = this.w;
        if (valueAnimator2 != null && valueAnimator2.isRunning()) {
            this.w.cancel();
        }
    }

    public final void a() {
        m = null;
        View view = this.f42534h;
        if (view != null) {
            view.setLongClickable(true);
        }
        c();
        this.x = ValueAnimator.ofInt(new int[]{getScrollX(), 0});
        this.x.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                SwipeMenuLayout.this.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
            }
        });
        this.x.setInterpolator(new AccelerateInterpolator());
        this.x.addListener(new AnimatorListenerAdapter() {
            public final void onAnimationEnd(Animator animator) {
                boolean unused = SwipeMenuLayout.this.f42527a = false;
            }
        });
        this.x.setDuration(300).start();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        SwipeMenuLayout swipeMenuLayout = m;
        if (this == swipeMenuLayout) {
            swipeMenuLayout.a();
            m = null;
        }
        super.onDetachedFromWindow();
    }

    public boolean performLongClick() {
        if (Math.abs(getScrollX()) > this.f42528b) {
            return false;
        }
        return super.performLongClick();
    }

    public void setClickListener(a aVar) {
        this.y = aVar;
    }
}
